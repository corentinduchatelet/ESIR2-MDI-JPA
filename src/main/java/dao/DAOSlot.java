package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Participant;
import entities.Poll;
import entities.Slot;
import utils.EntityManagerHelper;

public class DAOSlot {
	public Slot getById(Long id) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		Slot slot = (Slot) manager.find(Slot.class, id);
        return slot;
	}
	public List<Slot> getAvailableSlots(Poll poll){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		TypedQuery<Slot> query = manager.createQuery("SELECT s FROM Slot s WHERE s.poll = :pollId", Slot.class);
		return query.setParameter("pollId", poll.getId()).getResultList();
	} 
	public List<Slot> getSelectedSlots(Participant participant){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		TypedQuery<Slot> query = manager.createQuery("SELECT s FROM Slot s WHERE s in :selectedSLot", Slot.class);
		return query.setParameter("selectedSLot", participant.getSelectedSlots()).getResultList();
	}
}
