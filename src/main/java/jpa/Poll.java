package jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Poll {
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	private String description;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<TimeWindow> time_windows;

	@ManyToMany
	private List<Participant> participants;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<TimeWindow> getTime_windows() {
		return time_windows;
	}
	public void setTime_windows(List<TimeWindow> time_windows) {
		this.time_windows = time_windows;
	}
	public List<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
}
