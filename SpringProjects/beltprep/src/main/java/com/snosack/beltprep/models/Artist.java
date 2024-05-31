package com.snosack.beltprep.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="artists")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Artist name is required")
	@Size(min=3, max=45, message="Artist name must be between 3 and 45 characters.")
	private String name;
	
	@NotNull
	@Min(value = 0, message="Cannot have negative number of albums.")
	@Max(value = 100, message="Must be less than 100 albums.")
	private int numOfAlbums;
	
	@NotBlank(message="Genre is required")
	@Size(min=3, max=45, message="Genre must be between 3 and 45 characters.")
	private String genre;
	
	
	private Boolean stillTouring;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Artist() {}

	public Artist(
			@NotBlank(message = "Artist name is required") @Size(min = 3, max = 45, message = "Artist name must be between 3 and 45 characters.") String name,
			@NotEmpty(message = "Number of albums is required") @Min(value = 0, message = "Cannot have negative number of albums.") @Max(value = 100, message = "Must be less than 100 albums.") int numOfAlbums,
			@NotBlank(message = "Genre is required") @Size(min = 3, max = 45, message = "Genre must be between 3 and 45 characters.") String genre,
			Boolean stillTouring, User user) {
		this.name = name;
		this.numOfAlbums = numOfAlbums;
		this.genre = genre;
		this.stillTouring = stillTouring;
		this.user = user;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfAlbums() {
		return numOfAlbums;
	}

	public void setNumOfAlbums(int numOfAlbums) {
		this.numOfAlbums = numOfAlbums;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getStillTouring() {
		return stillTouring;
	}

	public void setStillTouring(Boolean stillTouring) {
		this.stillTouring = stillTouring;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
