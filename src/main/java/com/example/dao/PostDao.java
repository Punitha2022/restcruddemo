package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Post;
@Repository
public interface PostDao extends JpaRepository<Post, Integer> {

}
