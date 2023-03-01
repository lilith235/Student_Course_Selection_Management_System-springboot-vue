package com.rainng.coursesystem.model.vo.response.table;

import lombok.Data;


@Data
public class MajorItemVO {
    private Integer id;
    private String name;
    private String departmentName;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
    
    
}
