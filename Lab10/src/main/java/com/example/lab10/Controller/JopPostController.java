package com.example.lab10.Controller;


import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-post")
@RequiredArgsConstructor
public class JopPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getAllJobPost(){

        return ResponseEntity.status(200).body(jobPostService.getAllJobPost());

    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("new job post added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id, @Valid @RequestBody JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdated = jobPostService.updateJobPost(id, jobPost);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("job post updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("api not found"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoffee(@PathVariable Integer id){

        jobPostService.deleteJobPost(id);
        return ResponseEntity.status(200).body(new ApiResponse("job post deleted successfully"));
    }

}
