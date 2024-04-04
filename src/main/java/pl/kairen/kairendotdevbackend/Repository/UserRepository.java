package pl.kairen.kairendotdevbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kairen.kairendotdevbackend.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}