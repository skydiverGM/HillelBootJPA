package imaks.hillelbootjpa.service;

import imaks.hillelbootjpa.entity.mysql.User;
import imaks.hillelbootjpa.exception.UserNotFoundException;
import imaks.hillelbootjpa.repository.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public Long create(User user) {
        return userRepository.save(user).getId();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found", HttpStatus.NOT_FOUND));
    }
}
