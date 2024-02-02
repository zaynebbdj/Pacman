public interface State {

   enum PacmanState{NORMAL, INVISBLE, SUPER}
   void move(Pacman pacman, Direction direction);
   PacmanState getState();
}
