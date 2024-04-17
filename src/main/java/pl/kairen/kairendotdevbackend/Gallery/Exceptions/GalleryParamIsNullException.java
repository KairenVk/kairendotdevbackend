package pl.kairen.kairendotdevbackend.Gallery.Exceptions;

public class GalleryParamIsNullException extends RuntimeException {
    public GalleryParamIsNullException(String param) {
        super("Gallery " + param + " cannot be empty");
    }
}
