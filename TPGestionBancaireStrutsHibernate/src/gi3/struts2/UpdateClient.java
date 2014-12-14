package gi3.struts2;

import gi3.dao.ServicesClients;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;
import bean.Client;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateClient extends ActionSupport{

	private String name;
	private String surname;
	private int cin;
	private String adresse;
	private String numTel;
	
	@Override
	public String execute() throws Exception {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		try {
			String sql = "SELECT * FROM client WHERE cin = :cin ;";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Client.class);
			query.setParameter("cin", getCin());
			List<Client> results = query.list();
			if (results.size() > 0) {
				Client c = results.get(0);
                setCin(getCin());
				setName(c.getNom());
				setSurname(c.getPrenom());
				setAdresse(c.getAdresse());
				setNumTel(c.getNumTel());
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	public void validate(){
		if (getCin() == 0) {
			addFieldError("cin", "The identifier is required");
		}
	}
}
