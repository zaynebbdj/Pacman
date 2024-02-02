public class StateSuperPacman implements State{

    private long timer = 0;

    public StateSuperPacman(){
        
    }
    
    @Override
    public void move(Pacman pacman, Direction direction) {
        if(System.currentTimeMillis() >= timer + 10000 && timer != 0) {
            pacman.changeState(new StateNormal());
            timer = 0;
        }
        pacman.step(direction);
    }

    @Override
    public PacmanState getState() {
        return PacmanState.SUPER;
    }

    public void setTimer(long debut){
        this.timer = debut;
    }
    
}
