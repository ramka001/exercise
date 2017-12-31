package com.heavenhr.exercise.data.model;


import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@ToString(exclude = {"id"})
@Entity
@Table(name="offer", uniqueConstraints={@UniqueConstraint(columnNames={"jobTitle"})})
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="jobTitle")
    private String jobTitle;

    @Column(name="startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name="numberOfApplications")
    private Integer numberOfApplications;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private Map<String,Application> applications;

    public Offer() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(Integer numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }

    public Map<String,Application> getApplications() {
        return applications;
    }

    public void setApplications(Map<String,Application> applications) {
        this.applications = applications;
    }
}