package com.codepk.joblisting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codepk.joblisting.model.Post;
import com.codepk.joblisting.repo.PostRepository;
import com.codepk.joblisting.repo.SearchRepository;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
public class JobController {

	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	@Hidden
	@GetMapping("/")
	public void redirect(HttpServletResponse httpServletResponse) throws IOException
	{
		 httpServletResponse.sendRedirect("/swagger-ui/index.html");
	}
	
	@GetMapping("/allPosts")
	public List<Post> getAllPosts()
	{
		return repo.findAll(); 
	}
	
	@GetMapping("/posts/{keyword}")
	public List<Post> search(@PathVariable String keyword)
	{
		return srepo.findByText(keyword); 
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post)
	{
		System.out.println(post);
		return repo.save(post);
	}
}
