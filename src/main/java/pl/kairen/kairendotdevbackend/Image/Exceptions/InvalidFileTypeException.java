package pl.kairen.kairendotdevbackend.Image.Exceptions;

public class InvalidFileTypeException extends RuntimeException {
    public InvalidFileTypeException() {
        super ("Invalid file type uploaded. Only image files are accepted.");
    }
}
