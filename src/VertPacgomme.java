public class VertPacgomme implements Pacgomme {

    private final Position pos;
    private int point;

    public VertPacgomme(Position p){
        this.pos = p;
        this.point = 1000;
    }

	@Override
	public void action(Pacman pacman) {
        pacman.addPoint(this.point);
	}

	@Override
	public Pacgomme.PacgommeType getType() {
		return PacgommeType.VERT;
	}

	@Override
	public Position getPosition() {
		return this.pos;
	}
}
