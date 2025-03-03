package imaks.hillelbootjpa.controller;

import imaks.hillelbootjpa.entity.postgres.Post;
import imaks.hillelbootjpa.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Post post) {
        Long id = postService.create(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).body(id);
    }
}
