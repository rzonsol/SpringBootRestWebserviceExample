package pl.rzonsol.springboot.rest.webservice.example.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.rzonsol.springboot.rest.webservice.example.entity.Post;
import pl.rzonsol.springboot.rest.webservice.example.services.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostResource {

    private final PostService postService;

    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable Integer id){
        List<Post> posts = postService.findUserPosts(id);
        if (CollectionUtils.isEmpty(posts)){
            //Todo throw exception
        }
        return posts;
    }

    /* todo
     - created a post for a user
     - get post detail
     - created exception
     */
}
