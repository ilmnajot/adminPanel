package uz.ilmnajot.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmnajot.adminpanel.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
