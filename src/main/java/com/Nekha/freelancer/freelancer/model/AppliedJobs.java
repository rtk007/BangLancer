package com.Nekha.freelancer.freelancer.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "applied_jobs")
public class AppliedJobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private String jobTitle;
    private int jobId;
    private String location;
    private String salary;
    private String postedTime;
    private int jobOwnerId;
    private int userId;
    private boolean accepted;
}
