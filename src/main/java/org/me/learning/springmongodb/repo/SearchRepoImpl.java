package org.me.learning.springmongodb.repo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.me.learning.springmongodb.model.Post;
import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Component
public class SearchRepoImpl implements SearchRepo {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> searchByText(String text) {
        final List<Post> posts = new ArrayList<Post>();


        MongoDatabase database = client.getDatabase("moabsi");
        MongoCollection<Document> collection = database.getCollection("jobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                         new Document("text",
                         new Document("query", text)
                         .append("path", Arrays.asList("techs", "profile", "desc")))),
                         new Document("$sort",
                         new Document("exp", 1L)),
                         new Document("$limit", 4L)));



        result.forEach(document -> posts.add(converter.read(Post.class, document)));
        return posts;
    }
}
