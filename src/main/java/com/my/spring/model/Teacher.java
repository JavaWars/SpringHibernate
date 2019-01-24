package com.my.spring.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private int id;

	private String firstName;

	private String secondName;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Teacher_Subject", 
				joinColumns = { @JoinColumn(name = "teacher_id") }, 
				inverseJoinColumns = {@JoinColumn(name = "subject_id") })
	private Set<Subject> teacherSubjeect;

	public Teacher() {
	}

	public Teacher(String firstName, String secondName, Set<Subject> teacherSubjeect) {

		this.firstName = firstName;
		this.secondName = secondName;
		this.teacherSubjeect = teacherSubjeect;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Set<Subject> getTeacherSubjeect() {
		return teacherSubjeect;
	}

	public void setTeacherSubjeect(Set<Subject> teacherSubjeect) {
		this.teacherSubjeect = teacherSubjeect;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", teacherSubjeect="
				+ teacherSubjeect + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + ((teacherSubjeect == null) ? 0 : teacherSubjeect.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		if (teacherSubjeect == null) {
			if (other.teacherSubjeect != null)
				return false;
		} else if (!teacherSubjeect.equals(other.teacherSubjeect))
			return false;
		return true;
	}

}