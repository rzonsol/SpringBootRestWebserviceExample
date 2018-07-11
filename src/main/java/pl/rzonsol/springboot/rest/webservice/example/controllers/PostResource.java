package pl.rzonsol.springboot.rest.webservice.example.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.rzonsol.springboot.rest.webservice.example.entity.Post;
import pl.rzonsol.springboot.rest.webservice.example.exception.PostNotFoundException;
import pl.rzonsol.springboot.rest.webservice.example.services.PostService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostResource {

    private final PostService postService;

    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable Integer id) {
        List<Post> posts = postService.findUserPosts(id);
        if (CollectionUtils.isEmpty(posts)) {
            throw new PostNotFoundException("There is no post for user with id: " + id);
        }
        return posts;
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post getPostDetail(@PathVariable(name = "id") Integer userId, @PathVariable Integer postId) {
        return postService.findOne(userId, postId)
                .orElseThrow(() -> new PostNotFoundException("There is no post for usererId: " + userId + " and postId: " + postId));
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity addPost(@RequestBody Post post) {
        Optional.ofNullable(post).ifPresent(postService::save);

        URI locations = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(locations).build();
    }
}
