package com.rainng.coursesystem.model.vo.response;

import lombok.Data;

@Data
public class IdNameVO {
    private Integer id;
    private String name;

    public IdNameVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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
