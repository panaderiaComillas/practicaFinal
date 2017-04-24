package metier;

public class M_Ingredient {
	
	private int idIngredient; // type : int
    private String nomIngredient; // type : String

    public M_Ingredient(int idIngredient, String nomIngredient) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
    }

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getNomIngredient() {
		return nomIngredient;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}
    
    
}
