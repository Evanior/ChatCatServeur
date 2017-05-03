package init;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.imie.spring.model.Message;

public class CreateDatabase {

	public static void main(String[] args) throws HibernateException {
		
		Session session = HibernateUtil.getSession();

	    Transaction tx = session.beginTransaction();
	    
	    Message m = new Message("Tim","03/05/2017","Bonjour le monde");
	    session.save(m);
	
	    tx.commit();
	    session.close();
	    System.out.println("database créé");
	}
    
}
