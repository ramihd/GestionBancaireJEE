package gi3.struts2;

import gi3.dao.ServicesClients;

import java.util.List;

import bean.Client;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ListClients extends ActionSupport{
	
	public List<Client> listClients;

	public String execute(){
		ServicesClients service = new ServicesClients();
		listClients = service.getAllClients();
		return SUCCESS;
	}

}
