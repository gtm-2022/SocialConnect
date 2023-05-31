package com.example.demo.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.user.User;

@Controller
public class PostController {
    @Autowired
    PostService ps;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return ps.getAllPost();
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable("id") String id){
        return ps.getPost(id);
    }

    @GetMapping("/posts/user/{id}")
    public String getPostByUser(@PathVariable("id") String id, Model model){
        model.addAttribute("posts", ps.getPostByUser(id));
        model.addAttribute("post", new Post());
        return "postbyuser";
    }

    @GetMapping("/posts/postdate/{postdate}")
    public List<Post> getPostByPostdate(@PathVariable("postdate") String postdate){
        return ps.getPostByPostdate(postdate);
    }

    @PostMapping("/posts")
    public String addPost(@ModelAttribute("post") Post post, @RequestParam("userid") String userid){
        User user = new User();
        user.setId(userid);
        post.setUser(user);
        ps.addPost(post);
        return "redirect:/posts/user/"+userid;
    }

    @PutMapping("/posts/update/{id}")
    public String updatePost(@PathVariable("id") String id, @RequestBody Post post){
        ps.updatePost(id, post);
        return "post updated successfully";
    }

    @RequestMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable("id") String id){
        String uId = ps.getPost(id).getUser().getId();
        ps.deletePost(id);
        return "redirect:/posts/user/"+uId;
    }
}