import java.util.Random;

public class Ghost {

    private Position position_courante;     // position du fantome
    private Direction direction;            // direction de deplacement du fantome
    
    /**
     * constructeur de fantôme
     */
    public Ghost(){
        this.position_courante = new Position(17, 9);
        this.direction = Direction.UP;
    }

    /**
     * coordonnée x de la position du fantôme
     */
    public int getX() {
        return this.position_courante.getX();
    }

    /**
     * coordonnée y de la position du fantôme
     */
    public int getY() {
        return this.position_courante.getY();
    }

    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction d){
        this.direction = d;
    }
    public void setPos_x(int x){
        this.position_courante = new Position(x, this.getY());
    }
    public void setPos_y(int y){
        this.position_courante = new Position(this.getX(), y);
    }

    public void changeDirection(){

        Direction[] directions = Direction.values();
        int randomIndex = new Random().nextInt(directions.length);
        this.setDirection( directions[randomIndex]);

    }
    public void setInitialPosition(){
        this.position_courante = new Position(17, 9);
    }

    public Position getPosition(){
        return this.position_courante;
    }

    public void action(Pacman pacman){
        switch (pacman.getState().getState()) {
            case NORMAL:
                pacman.setInitialPosition();
                pacman.decLife();
                break;
        
            case SUPER:
                this.setInitialPosition();
                break;
            default:
                break;
        }
    }
}

