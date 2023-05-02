package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="CALLER_TUNE_INFO")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class CallerTuneInfo{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tuneId;
	
	@Column(length=20)
	@NonNull
	private String tuneName;
	
	@Column(length=20)
	@NonNull
	private String movieName;
	
	@Version
	@Column(name="UPDATE_COUNT")
	private Integer updatedCount;
	
	@Column(name="SERVICE_OPTED_ON")
	@CreationTimestamp
	private LocalDateTime serviceOptedOn;
	
	@Column(name="LASTLY_UPDATED_ON")
	@UpdateTimestamp
	private LocalDateTime lastlyUpdatedOn;
}
