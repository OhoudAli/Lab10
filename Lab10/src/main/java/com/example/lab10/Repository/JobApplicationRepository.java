package com.example.lab10.Repository;


import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
}
