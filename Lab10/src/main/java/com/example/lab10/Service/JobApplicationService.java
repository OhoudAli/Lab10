package com.example.lab10.Service;


import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;

    public List<JobApplication> getAllJobApplication(){
        return jobApplicationRepository.findAll();
    }

//    public void addJobApplication(JobApplication jobApplication){
//        jobApplicationRepository.save(jobApplication);
//    }


    public Boolean applyForJob(JobApplication jobApplication){
        User user = userRepository.getById(jobApplication.getUserId());
        JobPost jobPost = jobPostRepository.getById(jobApplication.getJobPostId());
        if(user == null){
            return false;
        }
        if(jobPost == null){
            return false;
        }

//        JobApplication jobApplication1 = new JobApplication();
        jobApplication.setJobPostId(jobPost.getId());
        jobApplication.setUserId(user.getId());
        jobApplicationRepository.save(jobApplication);
        return true;


    }

    public Boolean withdrawJob(JobApplication jobApplication){
        User user = userRepository.getById(jobApplication.getUserId());
        JobPost jobPost = jobPostRepository.getById(jobApplication.getJobPostId());
        if (user == null){
            return false;
        }
        if(jobPost == null){
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }
}
