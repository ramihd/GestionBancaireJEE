package gi3.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;
import bean.AgentBancaire;
import bean.Client;

public class ServicesClients {
	
	public void addClient(Client c){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}

	public Client getClient(Long idClient){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Client c = (Client) session.load(Client.class, idClient);
		return c;
	}

	public List<Client> getAllClients(){

		//creating session object
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Client> result = (List<Client>) session.createQuery("from Client").list();
		session.getTransaction().commit();
		return result;
	}
	
	public boolean delete (Long idClient){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Client c = (Client) session.load(Client.class, idClient);
		if (c == null) throw new RuntimeException("Client introuvable");
		session.delete(c);
		session.getTransaction().commit();
		return true;
	}

	public void update (Client c){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
	}
}
