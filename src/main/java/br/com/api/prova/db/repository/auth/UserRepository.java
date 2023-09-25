package br.com.api.prova.db.repository.auth;


import br.com.api.prova.record.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
