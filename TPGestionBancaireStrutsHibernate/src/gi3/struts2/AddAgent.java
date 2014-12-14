package gi3.struts2;

import java.util.List;

import gi3.dao.ServicesAgent;
import bean.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddAgent extends ActionSupport{
	
	private String login;
	private String password;
	private String name;
	private String surname;
	
	public List<AgentBancaire> listAgents;

	public String execute(){
		ServicesAgent service = new ServicesAgent();
		try{
			service.addAgentBanciare(new AgentBancaire(getLogin(), getPassword(), getName(), getSurname(), false));
			listAgents = service.getAllAgents();
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	/*public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}*/
}
