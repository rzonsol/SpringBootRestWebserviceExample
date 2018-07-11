package pl.rzonsol.springboot.rest.webservice.example.services;

import org.springframework.stereotype.Service;
import pl.rzonsol.springboot.rest.webservice.example.entity.Post;
import pl.rzonsol.springboot.rest.webservice.example.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private static List<Post> posts = new ArrayList<>();
    private int counter = 10;

    static {
        for (int i = 0; i < 10; i++) {
            posts.add(
                    Post.builder()
                            .user(new User(i, "Name " + 1, new Date()))
                            .id(i)
                            .message("message " + i)
                            .build()
            );
        }
    }

    public List<Post> findUserPosts(Integer userId) {
        if (userId == null || userId.compareTo(0) < 0)
            return new ArrayList<>();
        return posts.stream()
                .filter(u -> userId.equals(
                        Optional.ofNullable(u.getUser())
                                .map(User::getId)
                                .orElse(-1)))
                .collect(Collectors.toList());
    }

    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findOne(Integer userId, Integer postId) {
        if (postId == null || userId == null)
            return Optional.empty();

        return posts.stream()
                .filter(i -> postId.equals(i.getId()))
                .filter(u-> Optional.of(u.getUser()).map(User::getId).map(i->i.equals(userId)).orElse(false))
                .findAny();
    }

    public Post save(Post post) {
        Optional.ofNullable(post).ifPresent(this::savePost);
        return post;
    }

    private void savePost(Post post) {
        post.setId(++counter);
        posts.add(post);
    }
}
