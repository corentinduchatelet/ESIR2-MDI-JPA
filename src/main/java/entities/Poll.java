package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Poll {
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	private String description;
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE},
			   mappedBy="poll",
			   orphanRemoval=true)
	private List<Slot> time_windows;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE},
			   mappedBy="poll",
			   orphanRemoval=true)
	private List<Participant> participants;
	
	public Long getId() {
		return id;
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
	
	public List<Slot> getTime_windows() {
		return time_windows;
	}
	public void setTime_windows(List<Slot> time_windows) {
		this.time_windows = time_windows;
	}
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
}
