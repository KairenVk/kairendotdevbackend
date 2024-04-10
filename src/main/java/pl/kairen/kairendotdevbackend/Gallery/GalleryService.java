package pl.kairen.kairendotdevbackend.Gallery;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.kairen.kairendotdevbackend.Image.ImageService;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class GalleryService {

    private final Path STORAGE = Paths.get("storage","gallery");
    private final GalleryRepository galleryRepository;
    private final ImageService imageService;

    @PostConstruct
    public void init() {
            new File(STORAGE.toString()).mkdirs();
    }

    GalleryService(GalleryRepository galleryRepository, ImageService imageService) {
        this.galleryRepository = galleryRepository;
        this.imageService = imageService;
    }
    public Gallery createNewGallery(GalleryDTO requestBody) {
        Gallery newGallery = new Gallery();
        newGallery.setName(requestBody.getName());
        newGallery.setUrl(requestBody.getUrl());
        newGallery.setPath(Paths.get(STORAGE.toString(),requestBody.getUrl()).toString());
        newGallery = galleryRepository.save(newGallery);

        new File(newGallery.getPath()).mkdir();
        new File(newGallery.getPath()+File.separator+"images").mkdirs();
        new File(newGallery.getPath()+File.separator+"thumbnails").mkdirs();
        imageService.saveNewImages(requestBody.getImageList(),newGallery);
        return newGallery;
    }
}
