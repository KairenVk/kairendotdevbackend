package pl.kairen.kairendotdevbackend.Gallery;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class GalleryDTO {
    public GalleryDTO(List<MultipartFile> imageList, String name, String url) {
        this.imageList = imageList;
        this.name = name;
        this.url = url;
    }

    private List<MultipartFile> imageList;
    private String name;
    private String url;

    public List<MultipartFile> getImageList() {
        return imageList;
    }

    public void setImageList(List<MultipartFile> imageList) {
        this.imageList = imageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
