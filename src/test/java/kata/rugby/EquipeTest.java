package kata.rugby;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class EquipeTest {

	private Equipe cabcl;

	@Before
	public void avantChaqueTest() {
		cabcl = new Equipe("Brive");
	}

	@Test
	public void uneEquipePeutMarquerUnEssai() {
		cabcl.marqueUnEssai();

		assertThat(cabcl.score()).isEqualTo(5);
	}

	@Test
	public void peutMarquerPlusieursEssais() {
		cabcl.marqueUnEssai();
		cabcl.marqueUnEssai();

		assertThat(cabcl.score()).isEqualTo(10);
	}

	@Test
	public void peutTransformerUnEssai() {
		Essai essai = cabcl.marqueUnEssai();

		essai.transformé();

		assertThat(cabcl.score()).isEqualTo(7);
	}

	@Test
	public void peutMarquerUnePenalite() {
		cabcl.marqueUnePenalite();

		assertThat(cabcl.score()).isEqualTo(3);
	}
}
