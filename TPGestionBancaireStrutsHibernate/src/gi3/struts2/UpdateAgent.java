package gi3.struts2;

import gi3.dao.ServicesAgent;

import bean.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateAgent extends ActionSupport{

	private Long id;
	private String new_login;
	private String new_password;
	private String new_name;
	private String new_surname;

	public String execute(){
		ServicesAgent serviceAgent = new ServicesAgent();
		try{
			AgentBancaire ab = serviceAgent.getAgent(id);
			setId(id);
			setNew_login(ab.getLogin());
			setNew_name(ab.getNom());
			setNew_surname(ab.getPrenom());
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;
		}
	}

	public void validate(){
		if (getId() == null) {
			addFieldError("id", "The identifier is required");
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNew_login() {
		return new_login;
	}

	public void setNew_login(String new_login) {
		this.new_login = new_login;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public String getNew_name() {
		return new_name;
	}

	public void setNew_name(String new_name) {
		this.new_name = new_name;
	}

	public String getNew_surname() {
		return new_surname;
	}

	public void setNew_surname(String new_surname) {
		this.new_surname = new_surname;
	}
}
