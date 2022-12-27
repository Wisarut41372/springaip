package nvc.it.nvcjobmarketspapi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.nvcjobmarketspapi.model.Applicant;
import nvc.it.nvcjobmarketspapi.model.Post;
import nvc.it.nvcjobmarketspapi.service.PostService;

@RestController
@RequestMapping("/jobpost")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<Object> getAllPost() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", postService.getPosts());
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable String id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", postService.findById(id));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Object> getPostByTitle(@PathVariable String title) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", postService.findByPostTitle(title));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addProduct(@RequestBody Post post) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Post Complete");
        map.put("data", postService.addPost(post));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Post post) {
        Post currentPost = postService.findById(id).get();
        if (post.getTitle() != null)
            currentPost.setTitle(post.getTitle());
        if (post.getDescription() != null)
            currentPost.setDescription(post.getDescription());
        if (post.getDepartment() != null)
            currentPost.setDepartment(post.getDepartment());
        if (post.getPosition() != null)
            currentPost.setPosition(post.getPosition());
        if (post.getSalaryMin() != null)
            currentPost.setSalaryMin(post.getSalaryMin());
        if (post.getSalaryMax() != null)
            currentPost.setSalaryMax(post.getSalaryMax());
        if (post.getAgeMin() != null)
            currentPost.setAgeMin(post.getAgeMin());
        if (post.getAgeMax() != null)
            currentPost.setAgeMax(post.getAgeMax());
        if (post.getStartDate() != null)
            currentPost.setStartDate(post.getStartDate());
        if (post.getEndDate() != null)
            currentPost.setEndDate(post.getEndDate());

        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "OK");
        map.put("data", postService.updateProduct(id, currentPost));
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    @PatchMapping("/applicant/add/{id}")
    public ResponseEntity<Object> addApplicant(@PathVariable String id,@RequestBody Applicant applicant){
        HashMap<String,Object> map = new HashMap<>();
        map.put("msg", "Add Review OK");
        map.put("data",postService.addApplicant(id,applicant));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable String id){
        HashMap<String,Object> map = new HashMap<>();
        if(!postService.deleteProduct(id)){
            map.put("msg", "Error on delete post id: " + id);
            return new ResponseEntity<Object>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            map.put("msg", "Delete post id: " + id + " successfully.");
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        
    }

}
