package metier;

public class M_Contenir {
	
	private int idIngredient; // type : int
    private int idProduit; // type : int

    M_Contenir(int idIngredient, int idProduit) {
        this.idIngredient = idIngredient;
        this.idProduit = idProduit;
    }

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
    
    
}
