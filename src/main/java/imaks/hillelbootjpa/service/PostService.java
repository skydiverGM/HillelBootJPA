package imaks.hillelbootjpa.service;

import imaks.hillelbootjpa.entity.postgres.Post;
import imaks.hillelbootjpa.repository.mysql.UserRepository;
import imaks.hillelbootjpa.repository.postgres.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long create(Post post) {
        return postRepository.save(post).getId();
    }

    public List<Post> findAllByUserId(Long userId) {
        return postRepository.findAllByUserId(userId);
    }
}
