package fr.imie.spring.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.imie.spring.model.Message;

@Repository
public class MessageDAO {
	
	@PersistenceContext
	private EntityManager em;

	public List<Message> getAllMessage(){
		String query = "from Message";
		Query q = em.createQuery(query);
		return q.getResultList();
	}
	
	public List<Message> getAllMessageByPseudo(String pseudo){
		String query = "select * from message where pseudo = :pseudo";
		Query q = em.createNativeQuery(query);
		q.setParameter("pseudo", pseudo);
		return q.getResultList();
	}
	
	public List<Message> getAllMessageByDate(String date){
		String query = "select * from message where date_msg = :date";
		Query q = em.createNativeQuery(query);
		q.setParameter("date", date);
		return q.getResultList();
	}
	
	public Message getMessageById(long id){
		String query = "from Message where id = :id";
		Query q = em.createQuery(query);
		q.setParameter("id", id);
		/*List<Object[]> list = q.getResultList();
		Message m = null;
		for(Object[] o : list){
			BigInteger idGet = (BigInteger)  o[0];
			String date_msg = (String)  o[1];
			String pseudo = (String)  o[2];
			String message = (String)  o[3];
			m = new Message(id,pseudo,date_msg,message);
		}*/
		return (Message) q.getResultList().stream().findFirst().orElse(null);
	}
	
	@Transactional
	public void createNewMessage(Message m){
		em.persist(m);
	}
	
	@Transactional
	public void deleteMessage(Message m){
		em.remove(em.contains(m) ? m : em.merge(m));
	}

	@Transactional
	public void updateMessage(Message m) {
		em.persist(em.merge(m));
	}
	
}
