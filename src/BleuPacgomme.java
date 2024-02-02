public class BleuPacgomme implements Pacgomme{
    
    private final Position pos;
    private int point;

    public BleuPacgomme(Position p){
        this.pos = p;
        this.point = 100;
    }

	@Override
	public void action(Pacman pacman) {
        pacman.addPoint(this.point);
    }

	@Override
	public Pacgomme.PacgommeType getType() {
		return PacgommeType.BLEU;
	}

	@Override
	public Position getPosition() {
		return this.pos;
	}
}
