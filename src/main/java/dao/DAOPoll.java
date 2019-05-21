package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Participant;
import entities.Poll;
import utils.EntityManagerHelper;

public class DAOPoll {
	//CREATE
	public void persist(Poll entity) {
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        manager.persist(entity);
        EntityManagerHelper.commit();
    }
    
	//READ
	public Poll getById(Long id) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		Poll poll = (Poll) manager.find(Poll.class, id);
        return poll;
	}
	public List<Poll> getAll(){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		return manager.createQuery("SELECT p FROM Poll p", Poll.class).getResultList();
	} 
	public List<Poll> getByName(String name){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		return manager.createQuery("SELECT p FROM Poll p WHERE p.name = :name", Poll.class).setParameter("name", name).getResultList();
	}
	
	//UPDATE
	public void update(Poll entity) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        manager.merge(entity);
        EntityManagerHelper.commit();
    }
	
	//DELETE
	public void delete(Poll entity) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        manager.remove(entity);
        EntityManagerHelper.commit();
    }
	//It will reset the DB (cascade)
	public void deleteAll() {
		EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        for (Poll entity : getAll())
        	manager.remove(entity);
        EntityManagerHelper.commit();
    }
	
}
