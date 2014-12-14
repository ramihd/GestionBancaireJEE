package gi3.struts2;

import gi3.dao.ServicesClients;
import gi3.dao.ServicesComptes;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;
import bean.Client;
import bean.CompteBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DelClient extends ActionSupport{

	private int cin;
	public List<Client> listClients;
	
	public ServicesClients serviceClients = new ServicesClients();

	@Override
	public String execute() throws Exception {
		try{
			delComptesClient();
			listClients = serviceClients.getAllClients();
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	@Override
	public void validate() {
		if (getCin() == 0) {
			addFieldError("cin", "The identifier of the customer cannot be empty");
		}
	}

	public void delComptesClient(){
		Session session =  HibernateUtil.getSessionFactory().openSession();
		
		String sql = "SELECT * FROM client WHERE CIN = :cin ;";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Client.class);
		query.setParameter("cin", cin);
		List<Client> results = query.list();
		Client c = results.get(0);

		String sql2 = "SELECT * FROM comptebancaire WHERE id_client = :id ;";
		SQLQuery query2 = session.createSQLQuery(sql2);
		query2.addEntity(CompteBancaire.class);
		query2.setParameter("id", c.getIdClient());
		List<CompteBancaire> listComptes = query2.list();
		for (CompteBancaire compte:listComptes){
			ServicesComptes service = new ServicesComptes();
			service.delete(compte.getRib());
		}
		
		serviceClients.delete(c.getIdClient());
	}
}
