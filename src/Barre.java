import java.awt.*;

public class Barre extends Rectangle{

    protected int vitesse =20;

    public Barre() {

        super(
                0,
                CasseBrique.HAUTEUR - 100,
                Color.BLUE,
                200,
                20
        );

        this.x = CasseBrique.LARGEUR /2 -this.largeur /2;

    }
    public void deplacerDroite(){
        if (x>0){
            x -= vitesse;
        }

    }

    public void deplacerGauche(){
        if ( x<CasseBrique.LARGEUR - largeur){
            x+=vitesse;
        }
    }

}
