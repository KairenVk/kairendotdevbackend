package pl.kairen.kairendotdevbackend.Gallery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GalleryRepository extends JpaRepository<Gallery, String> {
    Optional<Gallery> findByUrl(String url);
    void deleteByUrl(String url);
}