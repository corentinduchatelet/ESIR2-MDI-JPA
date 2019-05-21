package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.DAOPoll;
import entities.Poll;

@Path("/doodle/polls")
@Produces(MediaType.APPLICATION_JSON)
public class PollService {
	private DAOPoll daoPoll = new DAOPoll();
	@POST
	public Poll createPoll(Poll poll) {
		daoPoll.persist(poll);
		return poll;
	}
	
	@GET
	public List<Poll> getAllPolls() {
		return daoPoll.getAll();
	}
	
	
}


