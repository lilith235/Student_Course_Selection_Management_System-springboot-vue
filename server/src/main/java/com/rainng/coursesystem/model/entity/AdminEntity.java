package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rainng.coursesystem.config.themis.annotation.Admin;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@TableName("admin")
@Data
public class AdminEntity {
    public static final String ID = "admin_id";
    public static final String USERNAME = "admin_username";
    public static final String PASSWORD = "admin_password";
    public static final String PRIVILEGE = "admin_privilege";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @TableField(USERNAME)
    private String username;

    @NotNull
    @TableField(PASSWORD)
    private String password;

    @NotNull
    @Range(min = Admin.NO, max = Admin.ALL)
    @TableField(PRIVILEGE)
    private Integer privilege;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}

    
    
}
