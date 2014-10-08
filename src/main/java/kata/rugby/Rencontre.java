package kata.rugby;

import java.util.HashMap;
import java.util.Map;

public class Rencontre {

	private static Map<Match, Rencontre> matchs = new HashMap<Match, Rencontre>();
	private Match matchEnCours;

	public Rencontre(Equipe domicile, Equipe exterieur) {
		Rencontre rencontre = new Rencontre();
		matchEnCours = new Match(domicile, exterieur);
		matchs.put(matchEnCours, rencontre);
		matchs.put(new Match(exterieur, domicile), rencontre);
	}

	private Rencontre() {
	}

	public Equipe vainqueur() {
		return matchEnCours.vainqueur();
	}

	public static Rencontre match(Equipe domicile, Equipe exterieur) {
		return matchs.get(new Match(domicile, exterieur));
	}
}
