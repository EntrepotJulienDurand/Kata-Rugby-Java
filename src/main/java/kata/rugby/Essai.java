package kata.rugby;

public class Essai {

	private Equipe equipe;
	private Etat etat;

	public Essai(Equipe equipe) {
		this.equipe = equipe;
		etat = Etat.NON_TRANSFORME;
	}

	public void transform�() {
		equipe.score += 2;
		etat.transform�(this);
	}

	private enum Etat {
		TRANSFORME {
			@Override
			public void transform�(Essai essai) {
				throw new IllegalStateException();
			}
		},
		NON_TRANSFORME {
			@Override
			public void transform�(Essai essai) {
				essai.etat = TRANSFORME;
			}
		};

		public abstract void transform�(Essai essai);
	}

}
