package pl.kairen.kairendotdevbackend.Gallery;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kairen.kairendotdevbackend.Gallery.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, String> {
}