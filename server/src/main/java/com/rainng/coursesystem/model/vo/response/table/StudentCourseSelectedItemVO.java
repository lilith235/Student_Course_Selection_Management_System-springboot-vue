package com.rainng.coursesystem.model.vo.response.table;

import lombok.Data;


@Data
public class StudentCourseSelectedItemVO {
    private Integer studentCourseId;
    private String courseName;
    private String teacherName;
    private Integer credit;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
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
