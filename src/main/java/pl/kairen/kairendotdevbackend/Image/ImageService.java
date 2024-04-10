package pl.kairen.kairendotdevbackend.Image;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.kairen.kairendotdevbackend.Gallery.Gallery;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final int imageDimension = 1280;
    private final int thumbnailDimension = 400;

    ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    private final Path STORAGE = Paths.get("storage","gallery");

    public List<Image> saveNewImages(List<MultipartFile> imageList, Gallery gallery) {

        List<Image> images = new ArrayList<>();
        Path galleryPath = Paths.get(STORAGE.toString(),gallery.getUrl());
        Path galleryImagesPath = Paths.get(galleryPath.toString(), "images");
        Path galleryThumbnailsPath = Paths.get(galleryPath.toString(), "thumbnails");
        List<BufferedImage> scaledImages = scaleImages(imageList, imageDimension);
        List<BufferedImage> thumbnails = scaleImages(imageList, thumbnailDimension);

        for (int i = 0; i < imageList.size(); i++) {
            Image newImage = new Image();
            newImage.setName(imageList.get(i).getOriginalFilename());
            newImage.setImage_path(Paths.get(galleryImagesPath.toString(),imageList.get(i).getOriginalFilename()).toString());
            newImage.setThumbnail_path(Paths.get(galleryThumbnailsPath.toString(),imageList.get(i).getOriginalFilename()).toString());
            newImage.setGallery(gallery);
            imageRepository.save(newImage);
            try {
                Path saveImagePath = Paths.get(System.getProperty("user.dir"),newImage.getImage_path());
                Path saveThumbnailPath = Paths.get(System.getProperty("user.dir"),newImage.getThumbnail_path());
                System.out.println(ImageIO.write(scaledImages.get(i),"jpg", new File(newImage.getImage_path())));
                ImageIO.write(thumbnails.get(i),"jpg", new File(newImage.getThumbnail_path()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            images.add(newImage);
        }
        return images;
    }

    public List<BufferedImage> scaleImages(List<MultipartFile> imageList, int longerDimension) {
        List<BufferedImage> scaledImages = new ArrayList<>();
        for (MultipartFile sourceImage : imageList) {
            try {
                BufferedImage image = ImageIO.read(sourceImage.getInputStream());
                java.awt.Image resizedImage;
                int shorterDimension = calculateOtherDimension(image, longerDimension);

                if (image.getHeight() > image.getWidth()) {
                    resizedImage = image.getScaledInstance(shorterDimension, longerDimension, java.awt.Image.SCALE_SMOOTH);
                }
                else {
                    resizedImage = image.getScaledInstance(longerDimension, shorterDimension, java.awt.Image.SCALE_SMOOTH);
                }
                BufferedImage bufferedImage = new BufferedImage(resizedImage.getWidth(null),resizedImage.getHeight(null),BufferedImage.TYPE_INT_RGB);
                bufferedImage.getGraphics().drawImage(resizedImage,0,0,null);
                scaledImages.add(bufferedImage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return scaledImages;
    }

    private int calculateOtherDimension(BufferedImage image, int longerDimension) {
        int width = image.getWidth();
        int height = image.getHeight();
        if (width > height) {
            int divisor = width/longerDimension;
            return height/divisor;
        }
        else {
            int divisor = height/longerDimension;
            return width/divisor;
        }
    }
}
