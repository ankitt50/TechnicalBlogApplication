package technicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalblog.Services.PostService;
import technicalblog.model.Post;
import technicalblog.model.PostCreated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postservice;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        List<Post> posts= postservice.getAllPosts();
//        ArrayList<Post> posts = new ArrayList<Post>();
//        posts.add(post);
        model.addAttribute("posts", posts);
        return "users/posts";
    }

    @RequestMapping("/createpost")
    public String createPost() {
        return "CreatePost";
    }

    @RequestMapping(value="/createpost", method=RequestMethod.POST)
    public String submitPost(Post newPost) {
        newPost.setDate(new Date());
        postservice.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
        newPost.setDate(new Date());
        postservice.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model) {
        Post post = postservice.getPost(postId);
        model.addAttribute("post",post);
        return "posts/edit";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.DELETE)
    public String deletePost(@RequestParam(name="postId") Integer postId) {
        postservice.deletePost(postId);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.PUT)
    public String editPostReceived(@RequestParam(name="postId") Integer postId, Post editedPost) {
        editedPost.setDate(new Date());
        editedPost.setId(postId);
        postservice.editPost(editedPost);
        return "redirect:/posts";
    }

}
