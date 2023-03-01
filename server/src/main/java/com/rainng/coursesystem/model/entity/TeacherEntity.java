package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@TableName("teacher")
@Data
public class TeacherEntity {

	public static final String ID = "teacher_id";
    public static final String DEPARTMENT_ID = "teacher_department_id";
    public static final String NUMBER = "teacher_number";
    public static final String NAME = "teacher_name";
    public static final String PASSWORD = "teacher_password";
	public static final String EMAIL = "teacher_email";
	public static final String BIRTHDAY = "teacher_birthday";
	public static final String SEX = "teacher_sex";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择所专业")
    @TableField(DEPARTMENT_ID)
    private Integer departmentId;

    @Length(min = 12, max = 12, message = "工号长度必须为12位")
    @TableField(NUMBER)
    private String number;

    @NotBlank(message = "教师姓名不能为空")
    @TableField(NAME)
    private String name;

	@Length(min = 8, max = 12, message = "密码必须为8到12位的数字、字母或特殊符号的混合形式")
	@NotNull
    @TableField(PASSWORD)
    private String password;

	@Email(message = "邮箱格式不正确")
	//pdateStrategy = FieldStrategy.IGNORED表示该字段可以为空
	@TableField(value = EMAIL, updateStrategy = FieldStrategy.IGNORED)
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@TableField(value = BIRTHDAY, updateStrategy = FieldStrategy.IGNORED)
	private Date birthday;

	@Range(min = 0, max = 1)
	@TableField(SEX)
	private Integer sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
