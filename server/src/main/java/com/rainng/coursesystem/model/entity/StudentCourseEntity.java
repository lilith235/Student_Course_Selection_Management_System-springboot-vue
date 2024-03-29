package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


@TableName("student_course")
@Data
public class StudentCourseEntity {
    public static final String ID = "sc_id";
    public static final String STUDENT_ID = "sc_student_id";
    public static final String COURSE_ID = "sc_course_id";
    public static final String DAILY_SCORE = "sc_daily_score";
    public static final String EXAM_SCORE = "sc_exam_score";
    public static final String SCORE = "sc_score";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择学生")
    @TableField(STUDENT_ID)
    private Integer studentId;

    @NotNull(message = "必须选择课程")
    @TableField(COURSE_ID)
    private Integer courseId;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    @TableField(value = DAILY_SCORE, updateStrategy = FieldStrategy.IGNORED)
    private Integer dailyScore;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    @TableField(value = EXAM_SCORE, updateStrategy = FieldStrategy.IGNORED)
    private Integer examScore;

    @Range(min = 0, max = 100, message = "分数必须在0-100之间")
    @TableField(value = SCORE, updateStrategy = FieldStrategy.IGNORED)
    private Integer score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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


	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return score;
	}

    
}
