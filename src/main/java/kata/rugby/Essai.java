package kata.rugby;

public class Essai {

	private Equipe equipe;
	private Etat etat;

	public Essai(Equipe equipe) {
		this.equipe = equipe;
		etat = Etat.NON_TRANSFORME;
	}

	public void transformé() {
		equipe.score += 2;
		etat.transformé(this);
	}

	private enum Etat {
		TRANSFORME {
			@Override
			public void transformé(Essai essai) {
				throw new IllegalStateException();
			}
		},
		NON_TRANSFORME {
			@Override
			public void transformé(Essai essai) {
				essai.etat = TRANSFORME;
			}
		};

		public abstract void transformé(Essai essai);
	}

}
