package metier;

import java.util.Date;

public class M_Commande {
	
	private int idCommande; // type : int
    private Date dateHeure; //type : datetime
    private Date heureRetrait; //type : date
    
//    private Timestamp dateHeure; //type : datetime
//    private Time heureRetrait; //type : date
    
    private int idUser; //type : int
    private M_TypeRetrait typeRetrait; //objet TypeRetrait
    private String etatCommande; //// type : varchar
    
    public M_Commande(int idCommande, Date dateHeure, Date heureRetrait, int idUser, M_TypeRetrait typeRetrait, String etatCommande) {
        this.idCommande = idCommande;
        this.dateHeure = dateHeure;
        this.heureRetrait = heureRetrait;
        this.idUser = idUser;
        this.typeRetrait = typeRetrait;
        this.etatCommande = etatCommande;
    }

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Date getHeureRetrait() {
		return heureRetrait;
	}

	public void setHeureRetrait(Date heureRetrait) {
		this.heureRetrait = heureRetrait;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public M_TypeRetrait getTypeRetrait() {
		return typeRetrait;
	}

	public void setTypeRetrait(M_TypeRetrait typeRetrait) {
		this.typeRetrait = typeRetrait;
	}

	public String getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(String etatCommande) {
		this.etatCommande = etatCommande;
	}
    
}
