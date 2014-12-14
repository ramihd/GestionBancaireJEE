package bean;

public class CompteBancaire {
	
	private Long rib;
	private String nomClient;
	private double solde;
	private Long idClient;
	
	public CompteBancaire() {
		super();
	}

	public CompteBancaire(String nomClient, double solde, Long idClient) {
		super();
		this.nomClient = nomClient;
		this.solde = solde;
		this.idClient = idClient;
	}

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
}
