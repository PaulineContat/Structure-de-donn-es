import java.util.Map;
import java.util.TreeMap;

public class Table {

	private int nbPlaces;
	private int nbPlacesDispo;
	private Convive[] emplacements;
	
	public Table(int nbPlaces) {
		this.nbPlaces=nbPlaces;
		this.nbPlacesDispo=this.nbPlaces;
	}
	
	public int getNbConvives() {
		int nbConvives=0;
		for (int i=0;i<this.emplacements.length;i++) {
			if (!this.emplacements[i].equals(null)) {
				nbConvives+=1;
			}
		}
		return nbConvives;
	}
	
	public void mettreATable(Convive convive, int numPlace) throws MettreATableException {
		if(!this.emplacements[numPlace].equals(null)) {
			throw new MettreATableException("Il ne peut y avoir plus d'un convive à la même place");
		} else {
			if(convive.equals(null)) {
				throw new MettreATableException("Le convive n'existe pas");
			} else {
				if (numPlace>=this.emplacements.length||numPlace<0) {
					throw new MettreATableException("L'emplacement n'est pas valide");
				} else {
					if (this.nbPlacesDispo==0) {
						throw new MettreATableException("Il n'y a plus de pllaces disponibles");
					}
				}
			}
		}
		this.emplacements[numPlace]= convive;
		this.nbPlacesDispo-=1;
	}
	
	public int positionATable(Convive convive) {
		
		for (int i=0; i<this.nbPlaces;i++) {
			if(this.emplacements[i]==convive) {
				return i;
			}
		}
		return -1;
	}
	
	public String planDeTable() {
		for (int i=0;i<this.emplacements.length;i++) {
			if(!this.emplacements[i].equals(null)) {
				return "NUMERO_PLACE :" + i + " "+this.emplacements[i].description()+"\n";
			} else {
				return "NUMERO_PLACE :" + i + " Vide\n";
			}
		}
		return null;
	}
	
	public Convive[] listeAlphaDesConvives() {
		TreeMap<String, Convive> convives = new TreeMap<>();
		Convive[] lesConvives;
		for (int i=0;i<this.emplacements.length;i++) {
				convives.put(this.emplacements[i].getNom()+this.emplacements[i].getPrenom(), this.emplacements[i]);
		}
		for(int j=0;j<this.emplacements.length;j++) {
			lesConvives[j]=convives[0];
		}
	}
	
}
