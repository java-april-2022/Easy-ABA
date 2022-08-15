package com.aba.easy.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="scores")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int correct;

//	private int incorrect;
//	
//	private int prompted;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    public Student getStudents() {
		return students;
	}
	public void setStudents(Student students) {
		this.students = students;
	}
	public Activity getActivities() {
		return activities;
	}
	public void setActivities(Activity activities) {
		this.activities = activities;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student students;
    
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="activity_id")
    private Activity activities;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCorrect() {
		return correct;
	}
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
//	public Integer getIncorrect() {
//		return incorrect;
//	}
//	public void setIncorrect(Integer incorrect) {
//		this.incorrect = incorrect;
//	}
//	public Integer getPrompted() {
//		return prompted;
//	}
//	public void setPrompted(Integer prompted) {
//		this.prompted = prompted;
//	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Score() {

	}
    
    
}
