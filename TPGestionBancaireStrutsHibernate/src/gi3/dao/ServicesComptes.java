package gi3.dao;

import java.util.List;

import org.hibernate.Session;

import bean.CompteBancaire;

import util.HibernateUtil;

public class ServicesComptes {

	public void addCompte(CompteBancaire cb){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(cb);
		session.getTransaction().commit();
	}

	public CompteBancaire getCompte(Long rib){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CompteBancaire cb = (CompteBancaire) session.load(CompteBancaire.class, rib);
		return cb;
	}

	public List<CompteBancaire> getAllComptes(){

		//creating session object
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<CompteBancaire> result = (List<CompteBancaire>) session.createQuery("from CompteBancaire").list();
		session.getTransaction().commit();
		return result;
	}

	public boolean delete (Long rib){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CompteBancaire cb = (CompteBancaire) session.load(CompteBancaire.class, rib);
		if (cb == null) throw new RuntimeException("Compte introuvable");
		session.delete(cb);
		session.getTransaction().commit();
		return true;
	}

	public void update (CompteBancaire cb){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(cb);
		session.getTransaction().commit();
	}
}
