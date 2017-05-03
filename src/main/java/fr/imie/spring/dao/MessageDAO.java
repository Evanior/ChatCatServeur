package fr.imie.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
}
