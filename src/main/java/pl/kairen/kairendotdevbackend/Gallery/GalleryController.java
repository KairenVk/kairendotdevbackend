package pl.kairen.kairendotdevbackend.Gallery;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@RestController
public class GalleryController {

    private final GalleryRepository repository;
    private final GalleryService service;

    GalleryController(GalleryRepository repository, GalleryService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/galleries")
    List<Gallery> all() {
        return repository.findAll();
    }

    @PostMapping("/newGallery")
    Gallery newGallery(@RequestPart List<MultipartFile> imageList, @RequestParam String name, @RequestParam String url) {
        GalleryDTO galleryDTO = new GalleryDTO(imageList,name,url);
        return service.createNewGallery(galleryDTO);
    }
}
