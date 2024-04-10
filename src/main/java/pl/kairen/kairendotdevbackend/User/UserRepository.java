package pl.kairen.kairendotdevbackend.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<credentials, Integer> {
}