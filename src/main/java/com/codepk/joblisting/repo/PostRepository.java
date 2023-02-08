package com.codepk.joblisting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codepk.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
