package gi3.struts2;

import java.util.List;

import gi3.dao.ServicesAgent;
import bean.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ConfirmUpdateAgent extends ActionSupport{

	private Long id;
	private String new_login;
	private String new_password;
	private String confirm_new_password;
	private String new_name;
	private String new_surname;
	
	public List<AgentBancaire> listAgents;

	public String execute(){
		ServicesAgent service = new ServicesAgent();
		if (getNew_password().equals(getConfirm_new_password())){
		AgentBancaire ab = new AgentBancaire(getNew_login(), getNew_password(), getNew_name(), getNew_surname(), false);
		ab.setId(getId());
		service.update(ab);
		listAgents = service.getAllAgents();
		return SUCCESS;
		}
		else{
			return ERROR;
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

	public String getConfirm_new_password() {
		return confirm_new_password;
	}

	public void setConfirm_new_password(String confirm_new_password) {
		this.confirm_new_password = confirm_new_password;
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
