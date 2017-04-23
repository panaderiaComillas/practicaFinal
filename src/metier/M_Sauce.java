package metier;

public class M_Sauce {
	
	private int idSauce; // type : int
    private String nomSauce; // type : String

    M_Sauce(int idSauce, String nomSauce) {
        this.idSauce = idSauce;
        this.nomSauce = nomSauce;
    }

	public int getIdSauce() {
		return idSauce;
	}

	public void setIdSauce(int idSauce) {
		this.idSauce = idSauce;
	}

	public String getNomSauce() {
		return nomSauce;
	}

	public void setNomSauce(String nomSauce) {
		this.nomSauce = nomSauce;
	}
    
}
