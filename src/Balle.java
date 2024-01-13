import java.awt.*;


public class Balle extends Rond{


    public Balle(int x, int y, Color couleur, int diametre) {

        super(x, y, couleur, diametre);

        this.x= CasseBrique.LARGEUR/2;
        this.y=CasseBrique.HAUTEUR/3;
        this.couleur = Color.BLUE;
        
    }

    public  int getCentreX(){
        return x  + diametre/2;
    }

    public  int getCentreY(){
        return y  + diametre/2;
    }

//    public Balle(int x, int y, int diametre) {
//        super(x, y, Color.RED);
//
//       // this.x = x;
//        // this.y = y;
//        this.diametre = diametre;
//        this.vitesseHorizontale = 5;
//        this.vitesseVerticale = 4;
//        //this.couleur = Color.RED;
//    }


    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public int getVitesseHorizontale() {
        return vitesseHorizontale;
    }

    public void setVitesseHorizontale(int vitesseHorizontale) {
        this.vitesseHorizontale = vitesseHorizontale;
    }

    public int getVitesseVerticale() {
        return vitesseVerticale;
    }

    public void setVitesseVerticale(int vitesseVerticale) {
        this.vitesseVerticale = vitesseVerticale;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
