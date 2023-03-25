
public class Convive {
	private String nom;
	private String prenom;
	private Civilite civilite;
	
	public Convive(String nom, String prenom, Civilite civilite) throws IllegalArgumentException {
		if (nom.equals(null)||prenom.equals(null)) {
			throw new IllegalArgumentException("Valeurs nulles");
		}
		this.nom=nom;
		this.prenom=prenom;
		this.civilite=civilite;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public Civilite getCivilite() {
		return this.civilite;
	}
	
	public String description() {
		return "("+this.getCivilite()+") "+this.getPrenom()+" "+this.getNom();
	}
}
