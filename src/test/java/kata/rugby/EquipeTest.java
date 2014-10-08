package kata.rugby;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class EquipeTest {

	@Test
	public void peutJouerContreUneAutreEquipe() {
		Rencontre match = Equipe.CABCL.joueContre(Equipe.UBB);

		Equipe.CABCL.marqueUnEssai();
		Equipe.CABCL.transformeUnEssai();
		Equipe.UBB.marqueUnEssai();

		assertThat(match).isNotNull();
		assertThat(Equipe.CABCL.matchContre(Equipe.UBB)).isNotNull();
		assertThat(Equipe.UBB.matchContre(Equipe.CABCL)).isNotNull();
		assertThat(Equipe.CABCL.score()).isEqualTo(7);
		assertThat(Equipe.UBB.score()).isEqualTo(5);
		assertThat(match.vainqueur()).isEqualTo(Equipe.CABCL);
	}
}
