package com.stamp.cms.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Column(name = "uid") Long uid;
	private @Column(name = "uname") String uname;
	private @Column(name = "password") String password;
	
	@CreationTimestamp
	private @Column(name = "regdate", insertable=false, updatable=false) Timestamp regdate;
	
	@UpdateTimestamp
	private @Column(name = "uptdate") Timestamp uptdate;
}
