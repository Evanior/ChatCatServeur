package fr.imie.spring.dao;

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
		String query = "select * from message where date_msg = :date order by id asc";
		Query q = em.createNativeQuery(query);
		q.setParameter("date", date);
		return q.getResultList();
	}
	
	public Message getMessageById(long id){
		String query = "select * from message where id = :id";
		Query q = em.createNativeQuery(query);
		q.setParameter("id", id);
		return (Message) q.getResultList().stream().findFirst().orElse(null);
	}
	
	@Transactional
	public void createNewMessage(Message m){
		em.persist(m);
	}
	
	@Transactional
	public void deleteMessage(Message m){
		em.remove(m);
	}
	
}
