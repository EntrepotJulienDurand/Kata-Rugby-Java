package kata.rugby;

import org.junit.Test;

public class EssaiTest {

	@Test(expected = IllegalStateException.class)
	public void nePeutPasEtreTransform�PlusDUneFois() {
		Essai essai = new Essai(new Equipe("unEquipe"));
		essai.transform�();

		essai.transform�();
	}
}
