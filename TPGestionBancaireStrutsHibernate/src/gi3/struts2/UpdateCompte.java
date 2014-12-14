package gi3.struts2;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;
import gi3.dao.ServicesComptes;
import bean.Client;
import bean.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateCompte extends ActionSupport{

	private Long rib;
	private double solde;
	private int cin;
	private String name;

	private double montant;
	public List<CompteBancaire> listComptes;

	ServicesComptes service = new ServicesComptes();
	
	public String depot(){
		return SUCCESS;
	}
	
	public String retrait(){
		return SUCCESS;
	}

	public String depotMontant(){
		Long id = getIdByCIN();
		CompteBancaire cb = new CompteBancaire();
		cb.setRib(rib);
		cb.setNomClient(name);
		cb.setSolde(solde + montant);
		cb.setIdClient(id);
		service.update(cb);
		lists(id);
		return SUCCESS;
	}

	public String retraitMontant(){
		if ((double) (solde - montant) >= 0){
			Long id = getIdByCIN();
			CompteBancaire cb = new CompteBancaire();
			cb.setRib(rib);
			cb.setNomClient(name);
			cb.setSolde((double) (solde - montant));
			cb.setIdClient(id);
			service.update(cb);
			lists(id);
			return SUCCESS;
		}
		else
			return ERROR;
	}

	public Long getRib() {
		return rib;
	}
	public void setRib(Long rib) {
		this.rib = rib;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getIdByCIN(){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT * FROM client WHERE CIN = :cin ;";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Client.class);
		query.setParameter("cin", cin);
		List<Client> results = query.list();
		Client c = results.get(0);
		return c.getIdClient();
	}
	
	public void lists(Long id){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT * FROM comptebancaire WHERE id_client = :id ;";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(CompteBancaire.class);
		query.setParameter("id", id);
		listComptes = query.list();
	}
}
