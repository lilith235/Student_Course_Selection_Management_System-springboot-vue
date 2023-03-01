package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@TableName("department")
@Data
public class DepartmentEntity {
    public static final String ID = "department_id";
    public static final String NAME = "department_name";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "系名不能为空")
    @TableField(NAME)
    private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
    
}
