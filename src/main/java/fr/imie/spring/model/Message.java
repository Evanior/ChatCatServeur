package fr.imie.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Quentin on 31/03/2017.
 */
@Entity
@Table(name="message")
public class Message {
	@Id
	@GeneratedValue(generator="keygen")
	@GenericGenerator(strategy="increment", name = "keygen")
    private long id;
	
    private String pseudo;
    
    @Column(name="date_msg")
    private String date;
    
    private String message;

    Message(){//JPA ONLY
    }
    public Message(String pseudo, String date, String message) {
        this.pseudo = pseudo;
        this.date = date;
        this.message = message;
    }
    public Message(long id, String pseudo, String date, String message) {
        this.pseudo = pseudo;
        this.date = date;
        this.message = message;
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
	public void setMessage(String message) {
		this.message = message;
	}
}
