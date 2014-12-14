package gi3.struts2;

import gi3.dao.ServicesComptes;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;
import bean.Client;
import bean.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionComptes extends ActionSupport{

	private int cin;
	public List<CompteBancaire> listComptes;

	private String name;
	private double sold;
	private Long rib;
	
	ServicesComptes service = new ServicesComptes();

	public String getList(){
		lists(getIdByCIN());
		return SUCCESS;
	}

	public String addCompte(){
		try{
			Long id = getIdByCIN();
			service.addCompte(new CompteBancaire(getName(), getSold(), id));
			lists(id);
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;
		}
	}
	
	public String delCompte(){
		service.delete(rib);
		lists(getIdByCIN());
		return SUCCESS;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
	}

	public Long getIdByCIN(){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		String sql = "SELECT * FROM client WHERE CIN = :cin ;";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Client.class);
		query.setParameter("cin", getCin());
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

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}
}