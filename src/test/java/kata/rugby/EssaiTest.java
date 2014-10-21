package kata.rugby;

import org.junit.Test;

public class EssaiTest {

	@Test(expected = IllegalStateException.class)
	public void nePeutPasEtreTransforméPlusDUneFois() {
		Essai essai = new Essai(new Equipe("unEquipe"));
		essai.transformé();

		essai.transformé();
	}
}
