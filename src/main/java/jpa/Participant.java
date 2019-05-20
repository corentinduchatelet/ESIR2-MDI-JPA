package jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Participant {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String first_name;
	private String mail;
	@ManyToMany
	private List<Poll> polls;
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<Poll> getPolls() {
		return polls;
	}
	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}
	
}
