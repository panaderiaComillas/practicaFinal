package metier;

public class M_Comporter {
	
	private int idMenu; // type : int
    private int idCommande; // type : int

    M_Comporter(int idMenu, int idCommande) {
        this.idMenu = idMenu;
        this.idCommande = idCommande;
    }

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
    
    
}
