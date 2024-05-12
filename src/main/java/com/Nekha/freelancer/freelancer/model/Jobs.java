package com.Nekha.freelancer.freelancer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String jobType;
    private String location;
    private String salaryRange;
    private String jobDesc;
    private String skills;
    private String education;
    private String postedDate;
    private int vacancy;
    private String jobNature;
    private String applicationDate;
    private String companyName;
    private String companyDesc;
    private String web;
    private String email;

    @Column(name = "user_id")
    private int user_id;

    // Constructors, getters, and setters

    public Jobs() {
    }

    public Jobs(Long id, String title, String jobType, String location, String salaryRange, String jobDesc, String skills, String education, String postedDate, int vacancy, String jobNature, String applicationDate, String companyName, String companyDesc, String web, String email, int userId) {
        this.id = id;
        this.title = title;
        this.jobType = jobType;
        this.location = location;
        this.salaryRange = salaryRange;
        this.jobDesc = jobDesc;
        this.skills = skills;
        this.education = education;
        this.postedDate = postedDate;
        this.vacancy = vacancy;
        this.jobNature = jobNature;
        this.applicationDate = applicationDate;
        this.companyName = companyName;
        this.companyDesc = companyDesc;
        this.web = web;
        this.email = email;
        this.user_id = userId;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }
}
