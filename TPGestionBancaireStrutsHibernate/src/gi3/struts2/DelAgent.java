package gi3.struts2;

import java.util.List;

import gi3.dao.ServicesAgent;
import bean.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DelAgent extends ActionSupport {

	private Long idAgent;
	
	public List<AgentBancaire> listAgents;

	public String execute(){
		ServicesAgent service = new ServicesAgent();
		try{
			service.delete(getIdAgent());
			listAgents = service.getAllAgents();
			return SUCCESS;
		}
		catch(Exception e){
			return ERROR;
		}
	}
	public Long getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Long idAgent) {
		this.idAgent = idAgent;
	}

	public void validate() {
		if (getIdAgent() == null) {
			addFieldError("idAgent", "The identifier of the agent cannot be empty");
		}
	}
}
