import java.awt.*;

public class Rond  extends Sprite{
    protected int diametre;
    protected int vitesseHorizontale;
    protected int vitesseVerticale;


    public Rond(int x, int y, Color couleur, int diametre) {
        super(x, y, couleur);

        this.diametre = diametre;
        this.vitesseHorizontale = (int)(Math.random() * 5 )+ 2;
        this.vitesseVerticale = (int)(Math.random() * 5 )+ 2;
    }

    public void deplacement(){
        x += vitesseHorizontale;
        y += vitesseVerticale;

        if(x >= CasseBrique.LARGEUR-diametre || x <= 0){
            vitesseHorizontale = -vitesseHorizontale;
        }

        if (y >= CasseBrique.HAUTEUR-40 || y <= 0){
            vitesseVerticale = -vitesseVerticale;
        }

    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);
    }

}
