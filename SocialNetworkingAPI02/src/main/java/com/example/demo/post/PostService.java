package com.example.demo.post;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPost(){
        return (List<Post>) postRepository.findAll();
    }

    public Post getPost(String id){
        return postRepository.findById(id).get();
    }

    public Optional<Post> getPostByUser(String id){
        return postRepository.findById(id);
    }
    public List<Post> getPostByPostdate(String postdate){
        return postRepository.getPostByPostdate(postdate);
    }
    public void addPost(Post post){
        postRepository.save(post);
    }


    public void deletePost(String id){
        postRepository.delete(postRepository.getReferenceById(id));
    }

	public void updatePost(String id, Post post) {
		// TODO Auto-generated method stub
		
	}
}
