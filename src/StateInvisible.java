public class StateInvisible implements State{

    private long timer = 0;

    public StateInvisible(){}
    
    @Override
    public void move(Pacman pacman, Direction direction) {
        if(System.currentTimeMillis() >= timer + 10000 && timer != 0) {
            pacman.changeState(new StateNormal());
            timer = 0;
        }
        pacman.step(direction);
    }

    @Override
    public State.PacmanState getState() {
        return PacmanState.INVISBLE;
    }

    public void setTimer(long debut){
        this.timer = debut;
    }
    
}
