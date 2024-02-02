public class OrangePacgomme implements Pacgomme{

    private final Position pos;
	private int point;

    public OrangePacgomme(Position p){
        this.pos = p;
		this.point = 500;
    }
	@Override
	public void action(Pacman pacman) {
		StateSuperPacman temp = new StateSuperPacman();
		temp.setTimer(System.currentTimeMillis());
		pacman.changeState(temp);
		pacman.addPoint(this.point);
	}

	@Override
	public Pacgomme.PacgommeType getType() {
		return PacgommeType.ORANGE;
	}

	@Override
	public Position getPosition() {
		return this.pos;
	}
}
