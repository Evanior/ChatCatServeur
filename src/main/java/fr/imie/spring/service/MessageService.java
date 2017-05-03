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

}
