public interface Pacgomme {
    
    public static enum PacgommeType { ORANGE, BLEU, VIOLET, VERT};
    public void action(Pacman pacman);
    public PacgommeType getType();
    public Position getPosition();
}
