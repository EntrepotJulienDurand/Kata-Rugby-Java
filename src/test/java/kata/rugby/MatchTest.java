package kata.rugby;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class MatchTest {

	@Test
	public void doitDefinirUnHashCode() {
		Match match = new Match(Equipe.CABCL, Equipe.UBB);
		Match autreMatch = new Match(Equipe.CABCL, Equipe.UBB);

		assertThat(match.hashCode()).isEqualTo(autreMatch.hashCode());
	}
}
