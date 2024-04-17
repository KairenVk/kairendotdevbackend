package pl.kairen.kairendotdevbackend.Image.Exceptions;

public class EmptyImageListException extends RuntimeException {
    public EmptyImageListException() {
        super("imageList param cannot be empty. Remove imageList or add compatible files.");
    }
}
