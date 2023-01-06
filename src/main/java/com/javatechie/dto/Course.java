package com.javatechie.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Course {

	private int courseId;
	private String name;
	private String trainerName;
	private String duration; // Duration can be in days or month value
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private Date startDate;
	private String courseType; // Live or Recording
	private double fees;
	private boolean isCertificateAvailable;
	private String description;

	// Default Constructor
	public Course() {

	}

	// Parameterized Constructor
	public Course(int courseId, String name, String trainerName, String duration, Date startDate, String courseType,
			double fees, boolean isCertificateAvailable, String description) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.trainerName = trainerName;
		this.duration = duration;
		this.startDate = startDate;
		this.courseType = courseType;
		this.fees = fees;
		this.isCertificateAvailable = isCertificateAvailable;
		this.description = description;
	}

	// Getters & Setters
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public boolean isCertificateAvailable() {
		return isCertificateAvailable;
	}

	public void setCertificateAvailable(boolean isCertificateAvailable) {
		this.isCertificateAvailable = isCertificateAvailable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
