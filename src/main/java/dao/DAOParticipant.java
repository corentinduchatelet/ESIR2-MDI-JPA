package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Participant;
import entities.Poll;
import utils.EntityManagerHelper;

public class DAOParticipant {
	public Participant getById(Long id) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		Participant participant = (Participant) manager.find(Participant.class, id);
        return participant;
	}
	public List<Participant> getParticipants(Poll poll){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		TypedQuery<Participant> query = manager.createQuery("SELECT p FROM Participant p WHERE p.poll = :pollId", Participant.class);
		return query.setParameter("pollId", poll.getId()).getResultList();
	} 
}
