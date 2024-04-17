package pl.kairen.kairendotdevbackend.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kairen.kairendotdevbackend.Image.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}