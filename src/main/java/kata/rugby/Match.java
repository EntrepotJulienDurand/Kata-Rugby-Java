package kata.rugby;

public class Match {

	private Equipe domicile;
	private Equipe exterieur;

	private Match(Equipe domicile, Equipe exterieur) {
		this.domicile = domicile;
		this.exterieur = exterieur;
	}

	public Equipe vainqueur() {
		Equipe vainqueur = domicile;
		if (exterieur.score() > domicile.score()) {
			vainqueur = exterieur;
		}
		return vainqueur;
	}

	public static MatchEnConstruction quiOppose(Equipe domicile) {
		return new MatchEnConstruction(domicile);
	}

	public static class MatchEnConstruction {
		private Equipe domicile;

		public MatchEnConstruction(Equipe domicile) {
			this.domicile = domicile;
		}

		public Match contre(Equipe exterieur) {
			return new Match(this.domicile, exterieur);
		}
	}

}
