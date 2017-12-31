package com.heavenhr.exercise.data.model;

import lombok.ToString;

import javax.persistence.*;


@ToString(exclude = {"id"})
@Entity
@Table(name = "application", uniqueConstraints = { @UniqueConstraint(columnNames = { "candidateEmail", "applicationId"  } )})
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "applicationId", nullable = false)
    private Offer offer;

    @Column(name = "candidateEmail")
    private String candidateEmail;

    @Column(name = "resumeText")
    private String resumeText;

    @Column(name = "applicationStatus")
    private ApplicationStatus applicationStatus;

    public Application() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
