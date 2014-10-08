package kata.rugby;

public class Match {

	private Equipe domicile;
	private Equipe exterieur;

	public Match(Equipe domicile, Equipe exterieur) {
		this.domicile = domicile;
		this.exterieur = exterieur;
	}

	@Override
	public int hashCode() {
		return domicile.hashCode() + exterieur.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Match other = Match.class.cast(obj);
		return this.domicile.equals(other.domicile) && this.exterieur.equals(other.exterieur);
	}

	public Equipe vainqueur() {
		Equipe vainqueur = domicile;
		if (domicile.score() < exterieur.score()) {
			vainqueur = exterieur;
		}
		return vainqueur;
	}

}
