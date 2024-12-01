package org.me.learning.springmongodb.repo;

import org.me.learning.springmongodb.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepo extends MongoRepository<Post, String> {
}
