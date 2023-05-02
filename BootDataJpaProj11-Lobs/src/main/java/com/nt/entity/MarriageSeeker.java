package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MarriageSeeker implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=20)
	@NonNull
	private String name;
	
	@Column(length=20)
	@NonNull
	private String addrs;
	
	@NonNull
	@Lob
	private byte[] photo;
	
	@Lob
	@NonNull
	private char[] biodata;
	
	@NonNull
	private LocalDateTime dob;
	
	@NonNull
	private boolean indian;
}
