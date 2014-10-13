package kata.rugby;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class EquipeTest {

	private Equipe cabcl;
	private Equipe ubb;

	@Before
	public void avantChaqueTest() {
		cabcl = new Equipe("Brive");
		ubb = new Equipe("Bordeaux");
	}

	@Test
	public void peutMarquerUnEssaiLeTransformerEtMarquerUnePenalitePour10points() {
		cabcl.marqueUnEssai();
		cabcl.transformeUnEssai();
		cabcl.transformeUnePenalite();

		assertThat(cabcl.score()).isEqualTo(10);
	}

	@Test
	public void peutGagnerContreBordeaux() {
		joueUnePartie();

		assertThat(cabcl.score()).isEqualTo(15);
		assertThat(ubb.score()).isEqualTo(8);
		assertThat(cabcl.vainqueur()).as("CABCL gagne").isTrue();
		assertThat(ubb.vainqueur()).as("UBB battu").isFalse();
	}

	public void joueUnePartie() {
		cabcl.rencontre(ubb);
		cabcl.marqueUnEssai();
		cabcl.transformeUnePenalite();
		cabcl.marqueUnEssai();
		cabcl.transformeUnEssai();
		ubb.transformeUnePenalite();
		ubb.marqueUnEssai();
	}

	@Test
	public void uneVictoireDonne4PointsEnChampionnat() {
		joueUnePartie();

		assertThat(cabcl.pointAuClassement()).isEqualTo(4);
		assertThat(ubb.pointAuClassement()).isEqualTo(0);
	}

	@Test
	public void uneDefaiteAvecMoinsDeCinqPointDEcartDonneUnBonusAuPerdantPourLeClassmeent() {
		joueUnePartie();
		ubb.marqueUnEssai();

		assertThat(ubb.pointAuClassement()).isEqualTo(1);
	}

	@Test
	public void uneVictoireAvecAuMoins3EssaisDeDifferencesDonneUnBonusAuVainqueur() {
		joueUnePartie();
		cabcl.marqueUnEssai();
		cabcl.marqueUnEssai();

		assertThat(cabcl.pointAuClassement()).isEqualTo(5);
	}

}
