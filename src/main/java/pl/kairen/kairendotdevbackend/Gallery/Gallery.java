package pl.kairen.kairendotdevbackend.Gallery;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import pl.kairen.kairendotdevbackend.Image.Image;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gallery")
public class Gallery {
    @Id
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true, name = "url")
    private String url;

    @Column(name = "path")
    private String path;

    @OneToMany(mappedBy = "gallery", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonManagedReference("gallery")
    private List<Image> images = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

}