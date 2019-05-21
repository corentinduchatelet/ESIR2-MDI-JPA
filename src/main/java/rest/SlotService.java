package rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.DAOSlot;
import entities.Slot;

@Path("/doodle/slots")
@Produces(MediaType.APPLICATION_JSON)
public class SlotService {
	private DAOSlot daoSlot = new DAOSlot();
	@POST
	public Slot createParticipant(Slot slot) {
		daoSlot.persist(slot);
		return slot;
	}
	
}
