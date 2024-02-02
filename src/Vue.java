import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Vue extends JComponent implements Runnable{
    private Partie partie;

    private final static int LENGTH = 20; //taille des cases du labyrinthe

    public Vue(Partie partie){
        super();
        setOpaque(true);
        setSize(713, 500);
        this.partie = partie;
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 38){ //UP
                    if(partie.update(Direction.valueOf("UP"))){
                        repaint();
                    }
                }
                if(e.getKeyCode() == 37){ //LEFT
                    if(partie.update(Direction.valueOf("LEFT"))){
                        repaint();
                    }
                }
                if(e.getKeyCode() == 39){ //RIGTH
                    if(partie.update(Direction.valueOf("RIGHT"))){
                        repaint();
                    }
                }
                if(e.getKeyCode() == 40){ //DOWN
                    if(partie.update(Direction.valueOf("DOWN"))){
                        repaint();
                    }
                }
            }

                @Override
            public void keyTyped(KeyEvent e) {}
                @Override
            public void keyReleased(KeyEvent e) {}
        });
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.partie.isOver() == true){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,713,500);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("name", Font.BOLD, 50));
            g.drawString("PARTIE TERMINÉE", 20, 250);
        } else{
            g.setColor(Color.BLACK);
            g.fillRect(0,0,713,400);
            drawLabyrinth(g);
            drawInfo(g);
            drawPacgomme(g);
            drawGhost(g);
            drawPacman(g);
        }
    }
    
    public void drawLabyrinth(Graphics g){
        for(int y = 0 ; y < 21; y++){
            for (int x = 0; x < 35; x++){
                if(this.partie.getBoard()[y][x].isWall()){
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x*LENGTH,y*LENGTH,LENGTH,LENGTH);
                }
            }
        }
    }
    
    public void drawPacman(Graphics g){
        Color pacColor ;
        switch(this.partie.getPacman().getState().getState()){
            case SUPER:
                pacColor = new Color(255, 128, 0);
                break;
            case INVISBLE:
                pacColor = new Color(253, 108, 158);
                break;
            default:
                pacColor = new Color(200,200,0);
            break;
        }
        g.setColor(pacColor);
        int x = this.partie.getPacman().getX();
        int y = this.partie.getPacman().getY();
        g.fillOval( x * LENGTH,y * LENGTH, 15, 15);
    }
    
    public void drawPacgomme(Graphics g){
        Color PacgommeColor;
        for(Pacgomme p: this.partie.getPacgommes()){
            switch(p.getType()){
                case ORANGE:
                    PacgommeColor = new Color(255, 128, 0);
                    break;
                case BLEU:
                    PacgommeColor = new Color(0,0,255);
                    break;
                case VIOLET:
                    PacgommeColor = new Color(102,0,255);
                    break;
                case VERT:
                    PacgommeColor = new Color(0,255,0);
                    break;
                default:
                    PacgommeColor = new Color(200,150,0);
                break;
            }
            g.setColor(PacgommeColor);
            int x = p.getPosition().getX();
            int y = p.getPosition().getY();
            g.fillOval( x * LENGTH + 3,y * LENGTH + 3, 10, 10);
        }
    }
    
    public void drawGhost(Graphics g){
        int x, y;
        Color ghostColor;
        for (int i= 0; i < 4; i++){
            if( this.partie.getPacman().getState().getState().name().equals("SUPER")){
                ghostColor = new Color(0, 0, 255);
            }else{
                switch(i){
                    case 0:
                        ghostColor = new Color(255,51,187);
                    break;
                    case 1:
                        ghostColor = new Color(0,255,255);
                        break;
                    case 2:
                        ghostColor = new Color(200,0,0);
                        break;
                    default:
                        ghostColor = new Color(200,150,0);
                    break;
                }
            }
            
            g.setColor(ghostColor);
            x = this.partie.getGhosts()[i].getX();
            y = this.partie.getGhosts()[i].getY();
            g.fillOval( x * LENGTH,y * LENGTH, 15, 15);
        }
    }
    
    public void drawInfo(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 415, 700, 50);
        g.setColor(Color.RED);
        g.setFont(new Font("name", Font.BOLD, 10));
        g.drawString("vie : "+ this.partie.getPacman().getLife(), LENGTH, 444);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("name", Font.BOLD, 10));
        g.drawString("point : "+ this.partie.getPacman().getPoint(), LENGTH + 50, 444);
    }

    @Override
    public void run() {
        while (!this.partie.isOver()) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {}
            this.partie.move(this.partie.getPacman().getDirection());
            repaint();
            if(this.partie.getPacman().getState().getState() == State.PacmanState.SUPER){
                try {
                    Thread.sleep(250);
                } catch (Exception e) {}
                this.partie.moveGhost();
                this.partie.move(this.partie.getPacman().getDirection());
                repaint();
            }
            else{
                this.partie.moveGhost();
            }
            repaint();
        }
    }
}
