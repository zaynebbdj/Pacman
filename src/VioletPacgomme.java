public class VioletPacgomme implements Pacgomme {
    
    private final Position pos;
    private int point;

    public VioletPacgomme(Position p){
        this.pos = p;
        this.point = 300;
    }

	@Override
	public void action(Pacman pacman) {
		StateInvisible temp = new StateInvisible();
		temp.setTimer(System.currentTimeMillis());
		pacman.changeState(temp);
        pacman.addPoint(this.point);
	}

	@Override
	public Pacgomme.PacgommeType getType() {
		return PacgommeType.VIOLET;
	}

	@Override
	public Position getPosition() {
		return this.pos;
	}
}
