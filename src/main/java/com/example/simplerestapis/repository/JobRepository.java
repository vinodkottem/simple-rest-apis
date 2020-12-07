package com.example.simplerestapis.repository;

import com.example.simplerestapis.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("SELECT p.STATUS FROM Job p WHERE p.UUID = :uid")
    public String findByUUID(@Param("uid")String uuid);

    @Query("SELECT p FROM Job p WHERE p.UUID = :uid")
    public Job findAllByUUID(@Param("uid")String uuid);

    @Query("SELECT p FROM Job p WHERE p.STATUS = :status")
    public List<Job> findByStatus(@Param("status")String status);

    @Transactional
    @Modifying
    @Query("UPDATE Job p SET p.STATUS = :status, p.RESULT= :result WHERE p.id = :id")
    public void updateStatus(@Param("id") Long id, @Param("status") String status, String result);

}
