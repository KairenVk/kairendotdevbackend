package pl.kairen.kairendotdevbackend.Gallery;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.kairen.kairendotdevbackend.Gallery.Exceptions.GalleryParamIsNullException;
import pl.kairen.kairendotdevbackend.Gallery.Exceptions.GalleryNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GalleryController {

    private final GalleryRepository repository;
    private final GalleryService service;

    private final GalleryModelAssembler assembler;

    GalleryController(GalleryRepository repository, GalleryService service, GalleryModelAssembler assembler) {
        this.repository = repository;
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/galleries")
    CollectionModel<EntityModel<Gallery>> all() {
        List<EntityModel<Gallery>> galleries = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(galleries, linkTo(methodOn(GalleryController.class).all()).withSelfRel());
    }

    @GetMapping("/gallery/{url}")
    EntityModel<Gallery> getGallery(@PathVariable String url) {
        Gallery gallery = repository.findByUrl(url).orElseThrow(() -> new GalleryNotFoundException(url));
        return assembler.toModel(gallery);
    }

    @PostMapping("/newGallery")
    EntityModel<Gallery> newGallery(@RequestPart (required = false) List<MultipartFile> imageList, @RequestParam String name, @RequestParam String url) {
        if (name.isBlank()) {
            throw new GalleryParamIsNullException("name");
        } else if (url.isBlank()) {
            throw new GalleryParamIsNullException("url");
        }

        GalleryDTO galleryDTO = new GalleryDTO(imageList,name,url);
        Gallery newGallery = service.createNewGallery(galleryDTO);
        return assembler.toModel(newGallery);
    }

    @DeleteMapping("/gallery/{url}")
    void deleteGallery(@PathVariable String url) {
        service.deleteGallery(url);
    }
}
