package gi3.struts2;

import gi3.dao.ServicesAgent;

import java.util.List;

import bean.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ListAgents extends ActionSupport{
	
	public List<AgentBancaire> listAgents;

	public String execute(){
		ServicesAgent servicesAgents = new ServicesAgent();
		listAgents = servicesAgents.getAllAgents();
		return SUCCESS;
	}

}
