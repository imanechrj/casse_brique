import java.awt.*;

public class Brique extends Rectangle{


    public Brique(int x, int y) {
        super(
                x,
                y,
                new Color((float)Math.random(),(float)Math.random(),(float)Math.random()),
                48,
                20
        );
    }

    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillRect(x, y, this.largeur, this.hauteur);
    }
}
