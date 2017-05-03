package fr.imie.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.spring.dao.MessageDAO;
import fr.imie.spring.model.Message;

@Service
public class MessageService {
	
	@Autowired
	MessageDAO messageDAO;

	public Collection<Message> findAllMessage() {
		return messageDAO.getAllMessage();
	}
	
	public Collection<Message> getAllMessageByPseudo(String pseudo) {
		return messageDAO.getAllMessageByPseudo(pseudo);
	}
	
	public Collection<Message> getAllMessageByDate(String date) {
		return messageDAO.getAllMessageByDate(date);
	}

	public Message getMessageById(long id) {
		return messageDAO.getMessageById(id);
	}
	
	public Message createMessage(String pseudo, String date, String msg){
		//TODO verification
		Message m = new Message(pseudo, date, msg);
		messageDAO.createNewMessage(m);
		return m;
	}

}
