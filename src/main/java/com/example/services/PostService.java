package com.example.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PostDao;
import com.example.entities.Post;
@Service
@Transactional
public class PostService {
	@Autowired
	PostDao postDao;
public List<Post> getAllPosts(){
	return postDao.findAll();
}
public Optional<Post> getPostById(int id) {
	// TODO Auto-generated method stub
	return postDao.findById(id);
}
public List<Post> deletePostById(int id){
	postDao.deleteById(id);
	return postDao.findAll();
}

public List<Post> savePost(Post p){
	postDao.save(p);
	return postDao.findAll();
}
}
