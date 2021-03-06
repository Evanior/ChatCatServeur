package fr.imie.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.imie.spring.model.Message;
import fr.imie.spring.service.MessageService;

import java.text.ParseException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by Quentin on 31/03/2017.
 */
@RestController
public class MessageController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/message",method=RequestMethod.POST)
    public Message message(@RequestParam(value="pseudo", defaultValue="default") String pseudo,
                           @RequestParam(value="date", defaultValue="01/01/1970 00:00") String date,
                           @RequestParam(value="message", defaultValue="") String message) {
    	Message m;
    	try {
    		m = messageService.createMessage(pseudo, date, message);
    	}catch(ParseException e){
    		m = new Message("Error date", "01/01/1970 00:00", "Mauvais format -_-'");
    	}catch(Exception e){
    		m = new Message("Error message", "01/01/1970 00:00", "Message vide -_-'");
    	}
    	return m;
    }
    
    @RequestMapping(value = "/message/{id}",method=RequestMethod.DELETE)
    public Message messageDelete(@PathVariable(value="id") long id) {
    	messageService.deleteMessage(id);
    	return new Message("Serveur", "01/01/1970 00:00", "Message n°"+id+" supprimer");
    }

    @RequestMapping(value = "/message/{id}",method=RequestMethod.GET )
    public Message messageById(@PathVariable("id") long id ) {
    	return messageService.getMessageById(id);
    }
    
    @RequestMapping(value = "/message/{id}",method=RequestMethod.PUT )
    public Message updateMessageById(@PathVariable("id") long id,
			   						 @RequestParam(value="message", defaultValue="") String message) {
    	return messageService.updateMessageById(id, message);
    }
    
   @RequestMapping(value = "/message",method=RequestMethod.GET )
   public Collection<Message> message() {
        return messageService.findAllMessage();
   }
   
   @RequestMapping(value = "/message/pseudo/{pseudo}",method=RequestMethod.GET )
   public Collection<Message> messageByPseudo(@PathVariable("pseudo") String pseudo) {
        return messageService.getAllMessageByPseudo(pseudo);
   }
   

}
