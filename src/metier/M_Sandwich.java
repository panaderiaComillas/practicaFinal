package metier;

public class M_Sandwich extends M_Produit{
	
	private boolean temperaturePain; // type : booléen

	M_Sandwich (int idProduit, String nomProduit, boolean temperaturePain) {
    	super(idProduit, nomProduit);
        this.temperaturePain = temperaturePain;        
    }

	public boolean isTemperaturePain() {
		return temperaturePain;
	}

	public void setTemperaturePain(boolean temperaturePain) {
		this.temperaturePain = temperaturePain;
	}
	
}
