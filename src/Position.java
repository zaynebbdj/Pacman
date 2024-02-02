public class Position{
    private int x;
    private int y;
    private boolean isWall;

    public Position(int x, int y, boolean b){
        this.x = x;
        this.y = y;
        this.isWall = b;
    }
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.isWall = false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    
    public Position move(Direction direction) {
        int temp_x = x;
        int temp_y = y;
        switch (direction) {
            case RIGHT -> temp_x++;
            case LEFT -> temp_x--;
            case UP -> temp_y--;
            case DOWN -> temp_y++;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
        
        return new Position(temp_x, temp_y);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Position p = (Position) obj;
            return (this.x == p.x) && (y == p.y);
        }
        else return false;
    }

    boolean isWall(){
        return this.isWall;
    }
}
