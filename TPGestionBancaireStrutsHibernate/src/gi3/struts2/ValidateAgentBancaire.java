package gi3.struts2;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import util.HibernateUtil;

import bean.AgentBancaire;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class ValidateAgentBancaire extends ActionSupport{

	public String execute() {

		Session session =  HibernateUtil.getSessionFactory().openSession();

		try {
			String sql = "SELECT * FROM agentbancaire WHERE login = :agent_login AND password = :agent_pass ;";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AgentBancaire.class);
			query.setParameter("agent_login", getLogin());
			query.setParameter("agent_pass", getPassword());
			List<AgentBancaire> results = query.list();
			if (results.size() > 0) {
				//setAgentBancaire(results.get(0));
				AgentBancaire ab = results.get(0);
				if (ab.getIsAdmin() == false){
					return SUCCESS;
				}
				else{
					return LOGIN;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	private String login;
	private String password;
	private AgentBancaire agentBancaire;

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

	public void setAgentBancaire(AgentBancaire agentBancaire) {
		this.agentBancaire = agentBancaire;
	}

	public void validate() {
		if (getLogin().length() == 0) {
			addFieldError("login", "The login is required");
		}
		else if (!validateEntry(getLogin())) {
			addFieldError("login", "The Login is not valid");
		}

		if (getPassword().length() == 0) {
			addFieldError("password", "The password is required");
		}
	}

	private boolean validateEntry(final String str) {
		Pattern pattern = Pattern.compile("^[A-Za-z ]+$");;
		Matcher matcher = pattern.matcher((str.trim()).toLowerCase());
		return (matcher.matches() && (str.length() != 0));
	}
}
