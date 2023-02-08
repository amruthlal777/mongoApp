package com.codepk.joblisting.repo;

import java.util.List;

import com.codepk.joblisting.model.Post;

public interface SearchRepository {

	List<Post> findByText(String keyword);
}
