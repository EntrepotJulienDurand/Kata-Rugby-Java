package kata.rugby;

public class Equipe {

	protected int score;
	private String nom;

	public Equipe(String nom) {
		this.nom = nom;
	}

	public Essai marqueUnEssai() {
		score += 5;
		return new Essai(this);
	}

	public void marqueUnePenalite() {
		score += 3;
	}

	public int score() {
		return score;
	}

	@Override
	public String toString() {
		return nom;
	}

	public int pointAuClassement() {
		return 4;
	}

}
