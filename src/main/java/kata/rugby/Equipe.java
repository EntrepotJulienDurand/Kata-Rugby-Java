package kata.rugby;

public class Equipe {
	private static final int AUCUN_POINT = 0;
	private static final int POINT_VICTOIRE = 4;
	private static final int BONUS = 1;
	private int score;
	private Equipe adversaire;
	private int nombreEssaisMarques;

	public Equipe(String nomEquipe) {
	}

	public void marqueUnEssai() {
		score += 5;
		nombreEssaisMarques++;
	}

	public void transformeUnEssai() {
		score += 2;
	}

	public int score() {
		return score;
	}

	public void transformeUnePenalite() {
		score += 3;
	}

	public void rencontre(Equipe equipe) {
		adversaire = equipe;
		equipe.adversaire = this;
	}

	public boolean vainqueur() {
		return this.score > adversaire.score;
	}

	public int pointAuClassement() {
		int pointAuClassement = AUCUN_POINT;
		pointAuClassement += pointsVictoire();
		pointAuClassement += bonusOffensif();
		pointAuClassement += bonusDefensif();
		return pointAuClassement;

	}

	private int bonusDefensif() {
		return pointDeBonusPour(defaiteDeMoinsDe5Points());
	}

	private int bonusOffensif() {
		return pointDeBonusPour(troisEssaisDePlus());
	}

	private int pointDeBonusPour(boolean possibiliteBonus) {
		if (possibiliteBonus) {
			return BONUS;
		}
		return AUCUN_POINT;
	}

	private int pointsVictoire() {
		if (vainqueur()) {
			return POINT_VICTOIRE;
		}
		return AUCUN_POINT;
	}

	public boolean defaiteDeMoinsDe5Points() {
		return !vainqueur() && moinsDe5Points();
	}

	public boolean troisEssaisDePlus() {
		return (this.nombreEssaisMarques - adversaire.nombreEssaisMarques) >= 3;
	}

	private boolean moinsDe5Points() {
		return Math.abs(this.score - adversaire.score) <= 5;
	}
}
