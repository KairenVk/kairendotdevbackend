package pl.kairen.kairendotdevbackend.Gallery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.kairen.kairendotdevbackend.Gallery.Exceptions.GalleryParamIsNullException;
import pl.kairen.kairendotdevbackend.Gallery.Exceptions.GalleryNotFoundException;

@ControllerAdvice
public class GalleryExceptionAdvice {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String galleryNotFoundHandler(GalleryNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String nameIsNullHandler(GalleryParamIsNullException ex) {return ex.getMessage(); }
}
