package pl.kairen.kairendotdevbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kairen.kairendotdevbackend.Entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}