package jpa;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			Participant patrick = new Participant();
			patrick.setFirst_name("patrick");
			Poll poll = new Poll();
			List<Participant> list = new LinkedList<Participant>();
			list.add(patrick);
			poll.setParticipants(list);
			TimeWindow creneau=new TimeWindow();
			creneau.setBegin(new Date());
			List<TimeWindow> list_time = new LinkedList<TimeWindow>();
			list_time.add(creneau);
			poll.setTime_windows(list_time);
			//creneau.setPoll(poll);
			
			manager.persist(poll);
			manager.persist(patrick);

			
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
