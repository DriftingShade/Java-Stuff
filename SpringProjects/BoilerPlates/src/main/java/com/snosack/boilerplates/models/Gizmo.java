package com.snosack.boilerplates.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="gizmos")
public class Gizmo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
//	Change columns to table columns!  Adjust validations accordingly.
	
	@NotNull
	@Size(min=3, max=60, message="column1 must be between 1 and 60 characters.")
	private String column1;
	
	@NotNull
	@Size(min=3, max=60, message="column2 must be between 1 and 60 characters.")
	private String column2;
	
	@NotNull
	@Size(min=3, max=60, message="column3 must be between 1 and 60 characters.")
	private String column3;
	
	@NotNull
	@Size(min=3, max=60, message="column4 must be between 1 and 60 characters.")
	private String column4;
	
	@NotNull
	@Size(min=3, max=60, message="column5 must be between 1 and 60 characters.")
	private String column5;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Gizmo() {}
	
//	Adjust Getters and Setters as necessary!

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn3() {
		return column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public String getColumn4() {
		return column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

	public String getColumn5() {
		return column5;
	}

	public void setColumn5(String column5) {
		this.column5 = column5;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
