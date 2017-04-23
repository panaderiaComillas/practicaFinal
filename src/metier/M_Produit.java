package metier;

public class M_Produit {
	
	private int idProduit; // type : int
    private String nomProduit; // type : String

    M_Produit(int idProduit, String nomProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
    }

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
    
}
