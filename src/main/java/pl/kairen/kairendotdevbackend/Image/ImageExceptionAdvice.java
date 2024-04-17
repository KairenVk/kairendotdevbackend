package pl.kairen.kairendotdevbackend.Image;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.kairen.kairendotdevbackend.Image.Exceptions.EmptyImageListException;
import pl.kairen.kairendotdevbackend.Image.Exceptions.InvalidFileTypeException;

@ControllerAdvice
public class ImageExceptionAdvice {
    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidFileTypeHandler(InvalidFileTypeException ex) { return ex.getMessage(); }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emptyImageListHandler(EmptyImageListException ex) { return ex.getMessage(); }
}
