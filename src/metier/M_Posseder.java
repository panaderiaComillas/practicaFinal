package metier;

public class M_Posseder {
	
	private int idMenu; // type : int
    private int idProduit; // type : int

    public M_Posseder(int idMenu, int idProduit) {
        this.idMenu = idMenu;
        this.idProduit = idProduit;
    }

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
    
}
