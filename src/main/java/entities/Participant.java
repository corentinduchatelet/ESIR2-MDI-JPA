package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Participant {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String first_name;
	private String mail;
	@OneToMany
	private List<Slot> selectedSlots;
	@ManyToOne
	private Poll poll;
	
	
	public Long getId() {
		return id;
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
	public List<Slot> getSelectedSlots() {
		return selectedSlots;
	}
	public void setSelectedSlots(List<Slot> selectedSlots) {
		this.selectedSlots = selectedSlots;
	}
	public Poll getPoll() {
		return poll;
	}
	public void setPoll(Poll poll) {
		this.poll = poll;
	}
	
}
