package com.te.udemy.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String description;
	
	private String level;
	
	private String language;
	
	private double price; 
	
	private String thumbnail;
	
	@ManyToOne
	@JoinColumn(name ="instructor_id")	
	private User instructor;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Section> sections;
	
	@OneToMany(mappedBy = "course")
	private List<Review> Reviews;

}
