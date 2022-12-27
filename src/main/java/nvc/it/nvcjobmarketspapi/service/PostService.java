package nvc.it.nvcjobmarketspapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nvc.it.nvcjobmarketspapi.model.Applicant;
import nvc.it.nvcjobmarketspapi.model.Post;
import nvc.it.nvcjobmarketspapi.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> findById(String id){
        return postRepository.findById(id);
    }

    public List<Post> findByPostTitle(String title){
        return postRepository.findByTitleContaining(title);
    }
    
    public Post addPost(Post post){
        return postRepository.save(post);
    }

    public Optional<Post> updateProduct(String id,Post post){
        Post currentPost = postRepository.findById(id).get();
        currentPost.setTitle(post.getTitle());
        currentPost.setDescription(post.getDescription());
        currentPost.setDepartment(post.getDepartment());
        currentPost.setPosition(post.getPosition());
        currentPost.setSalaryMin(post.getSalaryMin());
        currentPost.setSalaryMax(post.getSalaryMax());
        currentPost.setAgeMin(post.getAgeMin());
        currentPost.setAgeMax(post.getAgeMax());
        currentPost.setStartDate(post.getStartDate());
        currentPost.setEndDate(post.getEndDate());
        return Optional.of(postRepository.save(currentPost));
    }

    public Optional<Post> addApplicant(String id, Applicant applicant){
        Post currentPost = postRepository.findById(id).get();
        List<Applicant> applicants = currentPost.getApplicants();
        applicants.add(applicant);
        currentPost.setApplicants(applicants);
        return Optional.of(postRepository.save(currentPost));
    }

    public boolean deleteProduct(String id){
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
