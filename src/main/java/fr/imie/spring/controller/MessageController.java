package fr.imie.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.imie.spring.model.Message;
import fr.imie.spring.service.MessageService;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Quentin on 31/03/2017.
 */
@RestController
public class MessageController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    Collection<Message> readMessages() {
        return this.messageService.findAllMessage();
    }

    @RequestMapping(value = "/message",method=POST)
    public Message message(@RequestParam(value="pseudo", defaultValue="default") String pseudo,
                           @RequestParam(value="date", defaultValue="00h00") String date,
                           @RequestParam(value="message", defaultValue="Message par défaut") String message) {
        return new Message(pseudo,
                date,
                message);
    }

   @RequestMapping(value = "/message",method=GET )
   public Collection<Message> message() {
        return readMessages();
   }

}