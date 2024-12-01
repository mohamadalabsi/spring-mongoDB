package org.me.learning.springmongodb.repo;

import org.me.learning.springmongodb.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> searchByText(String text);

}
