package voll.med.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import voll.med.api.domain.users.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserDetails findByLogin(String login);
}