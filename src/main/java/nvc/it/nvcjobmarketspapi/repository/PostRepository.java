package nvc.it.nvcjobmarketspapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import nvc.it.nvcjobmarketspapi.model.Post;

public interface PostRepository extends MongoRepository<Post,String> {
    public List<Post> findByTitleContaining(String title);
}
