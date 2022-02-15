package by.projectCinema.repositories;

import by.projectCinema.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    boolean findByUsernameAndPassword(String name, String password);

    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("select (count(u) > 0) from User u where u.username = ?1")
    boolean existsByUsername(String name);

    @Query("select (count(u) > 0) from User u where u.username = ?1 and u.password = ?2")
    boolean existsByUsernameAndPassword(String name, String password);
}
