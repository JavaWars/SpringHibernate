package com.my.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private int id;

	private String name;

	private String description;

	private int hoursCountPerSemestr;

	@ManyToMany(mappedBy = "teacherSubjeect")
	private Set<Teacher> lessons=new HashSet<Teacher>();
	
	public Subject() {
	}

	public Subject(String name, String description, int hoursCountPerSemestr) {
		this.name = name;
		this.description = description;
		this.hoursCountPerSemestr = hoursCountPerSemestr;
	}

	@ManyToMany(mappedBy = "teacherSubjeect", cascade = CascadeType.ALL)
	Set<Teacher> teacherSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHoursCountPerSemestr() {
		return hoursCountPerSemestr;
	}

	public void setHoursCountPerSemestr(int hoursCountPerSemestr) {
		this.hoursCountPerSemestr = hoursCountPerSemestr;
	}

	public Set<Teacher> getTeacherSet() {
		return teacherSet;
	}

	public void setTeacherSet(Set<Teacher> teacherSet) {
		this.teacherSet = teacherSet;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + ", hoursCountPerSemestr="
				+ hoursCountPerSemestr + ", teacherSet=" + teacherSet + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + hoursCountPerSemestr;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teacherSet == null) ? 0 : teacherSet.hashCode());
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
		Subject other = (Subject) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (hoursCountPerSemestr != other.hoursCountPerSemestr)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teacherSet == null) {
			if (other.teacherSet != null)
				return false;
		} else if (!teacherSet.equals(other.teacherSet))
			return false;
		return true;
	}

}