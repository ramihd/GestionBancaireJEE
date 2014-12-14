package gi3.struts2;

import java.util.List;

import gi3.dao.ServicesClients;
import bean.Client;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddClient extends ActionSupport{

	private String name;
	private String surname;
	private int cin;
	private String adresse;
	private String numTel;
	
	public List<Client> listClients;

	public String execute(){
		ServicesClients service = new ServicesClients();
		try{
			service.addClient(new Client(getName(), getSurname(), getCin(), getAdresse(), getNumTel()));
			listClients = service.getAllClients();
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;
		}
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

	@Override
	public void validate() {
		if (getCin() == 0)
			addFieldError("cin", "The cin is required");
	}
}
