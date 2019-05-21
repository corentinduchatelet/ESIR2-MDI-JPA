package rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.DAOParticipant;
import entities.Participant;

@Path("/doodle/participant")
@Produces(MediaType.APPLICATION_JSON)
public class ParticipantService {
	private DAOParticipant daoParticipant = new DAOParticipant();
	@POST
	public Participant createParticipant(Participant participant) {
		daoParticipant.persist(participant);
		return participant;
	}
}
