package metier;

public class M_Assaisonner {
	
	private int idProduit; // type : int
    private int idSauce; // type : int
    
    public M_Assaisonner(int idProduit, int idSauce) {
        this.idProduit = idProduit;
        this.idSauce = idSauce;
    }
    
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdSauce() {
		return idSauce;
	}
	public void setIdSauce(int idSauce) {
		this.idSauce = idSauce;
	}     
}
