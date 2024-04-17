package pl.kairen.kairendotdevbackend.Gallery;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GalleryModelAssembler implements RepresentationModelAssembler<Gallery, EntityModel<Gallery>> {

    @Override
    public EntityModel<Gallery> toModel(Gallery gallery) {
        return EntityModel.of(gallery,
                linkTo(methodOn(GalleryController.class).getGallery(gallery.getUrl())).withSelfRel(),
                linkTo(methodOn(GalleryController.class).all()).withRel("galleries"));
    }
}
