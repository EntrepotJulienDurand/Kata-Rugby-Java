package kata.rugby;

import static kata.rugby.Rencontre.match;

public class Equipe {
	public static Equipe CABCL = new Equipe("Brive");
	public static Equipe UBB = new Equipe("Bordeaux");
	private String nom;
	private int score;

	private Equipe(String nom) {
		this.nom = nom;
	}

	public Rencontre joueContre(Equipe adversaire) {
		return new Rencontre(this, adversaire);
	}

	public void marqueUnEssai() {
		score += 5;
	}

	public void transformeUnEssai() {
		score += 2;
	}

	public Rencontre matchContre(Equipe uneEquipe) {
		return match(this, uneEquipe);
	}

	@Override
	public int hashCode() {
		return nom.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Equipe other = Equipe.class.cast(obj);
		return this.nom.equals(other.nom);
	}

	public int score() {
		return score;
	}

}
