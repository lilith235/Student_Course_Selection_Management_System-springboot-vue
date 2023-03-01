package com.rainng.coursesystem.model.vo.response;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class TeacherGradeVO {
    @NotNull
    private Integer studentCourseId;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    private Integer dailyScore;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    private Integer examScore;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    private Integer score;

	public Integer getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(Integer studentCourseId) {
		this.studentCourseId = studentCourseId;
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
