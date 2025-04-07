package com.example.lab10.Controller;


import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JobApplicationService;
import com.example.lab10.Service.JobPostService;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-application")
@RequiredArgsConstructor
public class JobApplicationController {


    private final JobApplicationService jobApplicationService;
    private final JobPostService jobPostService;
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllJobApplication(){

        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplication());
    }

//    @PostMapping("/add")
//    public ResponseEntity ApplyForJob(@Valid @RequestBody JobApplication jobApplication, Errors errors){
//        if(errors.hasErrors()){
//            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
//        }
//        jobApplicationService.addJobApplication(jobApplication);
//        return ResponseEntity.status(200).body(new ApiResponse("job application added successfully"));
//    }
//
//
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity WithdrawJobApplication(@PathVariable Integer id){
//
//        jobApplicationService.deleteJobApplication(id);
//        return ResponseEntity.status(200).body(new ApiResponse("deleted successfully"));
//    }


    @PostMapping("/apply")
    public ResponseEntity applyForJob(@RequestBody JobApplication jobApplication, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isApplied = jobApplicationService.applyForJob(jobApplication);
        if (isApplied) {
            return ResponseEntity.status(200).body(new ApiResponse("apply successfully"));
        } else {
            return ResponseEntity.status(400).body("User or JobPost not found.");
        }
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity withdrawJobApplication(@RequestBody JobApplication jobApplication ,Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isWithdrawn = jobApplicationService.withdrawJob(jobApplication);
        if (isWithdrawn) {
            return ResponseEntity.status(200).body(new ApiResponse("Job application withdrawn successfully."));
        } else {
            return ResponseEntity.status(400).body("Job application not found.");
        }
    }
}
