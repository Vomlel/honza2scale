package net.toscalecz.test.repositories;

import net.toscalecz.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This is for repository. Extends JpaRepository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
