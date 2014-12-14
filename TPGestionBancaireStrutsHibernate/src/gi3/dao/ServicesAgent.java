package gi3.dao;

import java.util.List;

import org.hibernate.Session;

import bean.AgentBancaire;

import util.HibernateUtil;

public class ServicesAgent {

	public void addAgentBanciare(AgentBancaire ab){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(ab);
		session.getTransaction().commit();
	}

	public AgentBancaire getAgent(Long id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AgentBancaire cb = (AgentBancaire) session.load(AgentBancaire.class, id);
		return cb;
	}

	public List<AgentBancaire> getAllAgents(){
		//creating session object
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<AgentBancaire> result = (List<AgentBancaire>) session.createQuery("from AgentBancaire").list();
		session.getTransaction().commit();
		return result;
	}

	public boolean delete (Long id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AgentBancaire ab = (AgentBancaire) session.load(AgentBancaire.class, id);
		if (ab == null) throw new RuntimeException("Compte introuvable");
		session.delete(ab);
		session.getTransaction().commit();
		return true;
	}

	public void update (AgentBancaire ab){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();	
		session.update(ab);
		session.getTransaction().commit();
	}
}
