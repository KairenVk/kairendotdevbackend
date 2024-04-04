package pl.kairen.kairendotdevbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kairen.kairendotdevbackend.Entity.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, String> {
}