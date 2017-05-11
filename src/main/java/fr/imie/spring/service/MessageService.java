package fr.imie.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public Message createMessage(String pseudo, String date, String msg) throws ParseException, Exception{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Message m = new Message(pseudo, date, msg);
		if(msg.equals("")){
			throw new Exception();
		}
		if(format.parse(date).getTime() > 10000){
			messageDAO.createNewMessage(m);		
		}
		return m;
	}
	
	public void deleteMessage(long id){
		Message m = getMessageById(id);
		messageDAO.deleteMessage(m);
	}

	public Message updateMessageById(long id, String message) {
		Message m = getMessageById(id);
		m.setMessage(message);
		messageDAO.updateMessage(m);
		return m;
	}

}
