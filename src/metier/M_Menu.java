package metier;

public class M_Menu {
	
	private int idMenu; // type : int
    private float prixMenu; // type : float
    private String nomMenu; // type : String

    public M_Menu(int idMenu, float prixMenu, String nomMenu) {
        this.idMenu = idMenu;
        this.prixMenu = prixMenu;
        this.nomMenu = nomMenu;
    }

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public float getPrixMenu() {
		return prixMenu;
	}

	public void setPrixMenu(float prixMenu) {
		this.prixMenu = prixMenu;
	}

	public String getNomMenu() {
		return nomMenu;
	}

	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}
    
    
}
