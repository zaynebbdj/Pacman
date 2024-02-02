
public class Pacman {
    private Position currentPosition;
    private int point;
    //Color color;
    private int life;
    //int time_effect = 9;
    private State state;
    private Direction direction;
    private int gainLife;

    public Pacman(){
        this.life = 3;
        this.point = 0;
        this.currentPosition = new Position(17, 18);
        this.state = new StateNormal();
        this.direction = Direction.UP;
        this.gainLife = 0;
    }

    boolean isAlive(){
        return this.life > 0;
    }

    public int getX(){
        return this.currentPosition.getX();
    }

    public int getY() {
        return this.currentPosition.getY();
    }

    public int getPoint(){
        return this.point;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void setPoint(int point){
        this.point = point;
    }

    public void addPoint(int p) {
        this.point = this.point + p;
        this.gainLife = this.gainLife + p;
        if(this.gainLife >= 5000){
            this.life = this.life + 1;
            this.gainLife = 0;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void incLife() {
        this.life = this.life + 1;
    }
    public void decLife(){
        this.life = this.life - 1;
    }

    public int getLife() {
        return this.life;
    }
    /* public Color getColor(){
        return this.color;
    } */

    public State getState(){
        return this.state;
    }

    public void changeState(State state){
        this.state = state;
    }

    public void setInitialPosition(){
        this.currentPosition = new Position(17, 18);
    }
    
    public void step(Direction direction){
        this.currentPosition = this.currentPosition.move(direction);
    }

    public Position getPosition(){
        return this.currentPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }
}
