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

import lombok.Data;

@Data
@Entity
@Table(name="board")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Board {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String seq;
	private String title;
	private String content;
	
	private String regby;
	@CreationTimestamp
	private @Column(name = "regdate", insertable=false, updatable=false) Timestamp regdate;
	
	private String uptby;
	@UpdateTimestamp
	private @Column(name = "uptdate") Timestamp uptdate;
}
