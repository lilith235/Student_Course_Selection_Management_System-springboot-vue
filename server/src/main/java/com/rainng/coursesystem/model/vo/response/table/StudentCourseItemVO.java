package com.rainng.coursesystem.model.vo.response.table;

import lombok.Data;


@Data
public class StudentCourseItemVO {
    private Integer id;
    private String courseName;
    private String studentName;
    private String className;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getDailyScore() {
		return dailyScore;
	}
	public void setDailyScore(Integer dailyScore) {
		this.dailyScore = dailyScore;
	}
	public Integer getExamScore() {
		return examScore;
	}
	public void setExamScore(Integer examScore) {
		this.examScore = examScore;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
    
    
}
