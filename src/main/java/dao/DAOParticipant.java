package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Participant;
import entities.Poll;
import utils.EntityManagerHelper;

public class DAOParticipant {
	private EntityManager manager;
	private EntityTransaction tx;
	public Participant getById(Long id) {
		manager = EntityManagerHelper.getEntityManager();
		Participant participant = (Participant) manager.find(Participant.class, id);
        return participant;
	}
	public List<Participant> getParticipants(Poll poll){
		manager = EntityManagerHelper.getEntityManager();
		TypedQuery<Participant> query = manager.createQuery("SELECT p FROM Participant p WHERE p.poll = :pollId", Participant.class);
		return query.setParameter("pollId", poll.getId()).getResultList();
	} 
}
