package com.rainng.coursesystem.model.bo;

import lombok.Data;

@Data
public class SdnuNewsBO {
    private String title;
    private String url;
    private String date;

    public SdnuNewsBO(String title, String date, String url) {
        this.title = title;
        this.date = date;
        this.url = url;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
