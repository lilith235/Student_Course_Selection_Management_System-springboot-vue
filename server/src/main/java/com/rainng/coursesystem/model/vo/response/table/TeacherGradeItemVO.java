package com.rainng.coursesystem.model.vo.response.table;

import lombok.Data;


@Data
public class TeacherGradeItemVO {
    private Integer studentCourseId;
    private String courseName;
    private String studentName;
    private Integer dailyScore;
    private Integer examScore;
    private Integer score;
	public Integer getStudentCourseId() {
		return studentCourseId;
	}
	public void setStudentCourseId(Integer studentCourseId) {
		this.studentCourseId = studentCourseId;
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
