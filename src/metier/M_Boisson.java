package metier;

public class M_Boisson extends M_Produit{
	
	private float volume; // type : float

    public M_Boisson(int idProduit, String nomProduit, float volume) {        
    	super(idProduit, nomProduit);
        this.volume = volume;        
    }

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}
}
