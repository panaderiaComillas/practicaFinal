package metier;

public class M_TypeRetrait {
	
	private int idTypeRetrait; // type : int
    private String nomTypeRetrait; // ADMINISTRATEUR, UTILISATEUR

    M_TypeRetrait (int idTypeRetrait, String nomTypeRetrait) {
        this.idTypeRetrait = idTypeRetrait;
        this.nomTypeRetrait = nomTypeRetrait;
    }

	public int getIdTypeRetrait() {
		return idTypeRetrait;
	}

	public void setIdTypeRetrait(int idTypeRetrait) {
		this.idTypeRetrait = idTypeRetrait;
	}

	public String getNomTypeRetrait() {
		return nomTypeRetrait;
	}

	public void setNomTypeRetrait(String nomTypeRetrait) {
		this.nomTypeRetrait = nomTypeRetrait;
	}
    
}
