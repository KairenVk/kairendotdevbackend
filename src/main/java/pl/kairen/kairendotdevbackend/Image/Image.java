package pl.kairen.kairendotdevbackend.Image;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import pl.kairen.kairendotdevbackend.Gallery.Gallery;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String image_path;

    @Column(unique = true)
    private String thumbnail_path;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "gallery_name", nullable = false)
    @JsonBackReference("gallery")
    private Gallery gallery;

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getThumbnail_path() {
        return thumbnail_path;
    }

    public void setThumbnail_path(String thumbnail_path) {
        this.thumbnail_path = thumbnail_path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}