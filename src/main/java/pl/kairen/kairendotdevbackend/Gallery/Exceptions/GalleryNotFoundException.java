package pl.kairen.kairendotdevbackend.Gallery.Exceptions;

public class GalleryNotFoundException extends RuntimeException {
    public GalleryNotFoundException(String url) {
        super("Could not find gallery with given url: " + url);
    }
}
