package kata.rugby;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MatchTest {

	private Equipe cabcl;
	private Equipe ubb;

	@Before
	public void avantChaqueTest() {
		cabcl = new Equipe("Brive");
		ubb = new Equipe("Bordeaux");
	}

	@Test
	public void lEquipeQuiJoueADomcilePeutGagner() {
		Match match = Match.quiOppose(cabcl).contre(ubb);
		cabcl.marqueUnEssai().transformé();

		Equipe vainqueur = match.vainqueur();

		assertThat(vainqueur).isEqualTo(cabcl);
	}

	@Test
	public void lEquipeQuiJoueALExterieurPeutGagner() {
		Match match = Match.quiOppose(cabcl).contre(ubb);
		ubb.marqueUnEssai().transformé();

		Equipe vainqueur = match.vainqueur();

		assertThat(vainqueur).isEqualTo(ubb);
	}

	@Test
	public void leVainqueurGagneQuatrePointsAuClassementGeneral() {
		Match match = Match.quiOppose(cabcl).contre(ubb);
		cabcl.marqueUnePenalite();
		cabcl.marqueUnEssai();

		assertThat(match.vainqueur().pointAuClassement()).isEqualTo(4);
	}
}
