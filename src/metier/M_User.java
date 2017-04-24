package metier;

public class M_User {
	
	private int idUser; //type : int
    private String nomUser; //type : String
    private String prenomUser; //type : String
    private String email; //type : String
    private String tel; //type : String
    private String login; //type : String
    private String mdp; //type : String encodé en sha1
    private M_Role role; //objet role

    public M_User(int idUser) {
		this.idUser = idUser;
	}

	public M_User (int idUser, String nomUser, String prenomUser, String email, String tel, String login, String mdp, M_Role role) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.email = email;
        this.tel = tel;
        this.login = login;
        this.mdp = mdp;
        this.role = role;
    }

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public M_Role getRole() {
		return role;
	}

	public void setRole(M_Role role) {
		this.role = role;
	}
    
}
