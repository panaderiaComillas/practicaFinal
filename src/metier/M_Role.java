package metier;

public class M_Role {
	
	private int idRole; // type : int
    private  String nomRole; // ADMINISTRATEUR, UTILISATEUR

    public M_Role(int idRole, String nomRole) {
        this.idRole = idRole;
        this.nomRole = nomRole;
    }

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
}
