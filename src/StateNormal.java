public class StateNormal implements State{

    @Override
    public void move(Pacman pacman, Direction direction) {
        pacman.step(direction);
    }

    @Override
    public State.PacmanState getState() {
        return PacmanState.NORMAL;
    }
    
}
