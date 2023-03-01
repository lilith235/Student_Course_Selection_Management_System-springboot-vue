package com.rainng.coursesystem.model.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BoolOptionVO {
    @NotNull
    public Boolean option;

	public Boolean getOption() {
		return option;
	}

	public void setOption(Boolean option) {
		this.option = option;
	}
    
}
