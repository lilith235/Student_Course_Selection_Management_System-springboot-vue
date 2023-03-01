package com.rainng.coursesystem.model.vo.response;

import lombok.Data;

@Data
public class ParameterErrorVO {
    private String fieldName;
    private String message;

    public ParameterErrorVO() {

    }

    public ParameterErrorVO(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
