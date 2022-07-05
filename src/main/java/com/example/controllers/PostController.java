package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.ErrorClazz;
import com.example.entities.Post;
import com.example.services.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PostController {
	public PostController() {
		System.out.println("PostController instantiated");
	}
	@Autowired
	PostService postService;
	
@GetMapping("/posts")

public List<Post> getAllPosts(){
	return postService.getAllPosts();
	
}
@GetMapping("/viewpost/{id}")
public Optional<Post> viewPost(@PathVariable int id) {
	System.out.println("THE VALUE OF ID IS " + id);
	return postService.getPostById(id);
}
@RequestMapping("/message")
//http://localhost:8080/message
public String message() {
	return "Hello World!";
}

@DeleteMapping("/deletepost/{id}")
public ResponseEntity<?> deletePost(@PathVariable int  id){
	try {
	 List<Post> posts=postService.deletePostById(id);
	 return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	 }catch(Exception e) {
		ErrorClazz error=new ErrorClazz(500,e.getMessage());
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	 }
}

@PostMapping("/savepost")
public List<Post> savePost(@RequestBody Post post){
	return postService.savePost(post);
	
}
}
