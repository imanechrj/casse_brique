import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.EventListener;

public class CasseBrique extends Canvas implements KeyListener {
    public static final int LARGEUR = 500;
    public static final int HAUTEUR =600;

    protected ArrayList<Balle> listeBalle = new ArrayList<>();
    protected Barre barre = new Barre();
    protected ArrayList<Brique> listeBrique = new ArrayList<>();



    public CasseBrique(){

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0,0, LARGEUR, HAUTEUR);

        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR, HAUTEUR);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        JPanel panneau = (JPanel) fenetre.getContentPane();
        panneau.add(this);




        this.createBufferStrategy(2);
        fenetre.setVisible(true);

        //monBouton.addActionListener(e -> System.out.println("coucou"));

        demarrer();

    }

    public void demarrer(){


           Balle balle = new Balle(400, 300, Color.BLUE,30);


        for(int i=0; i<CasseBrique.LARGEUR;i+=50 ){
            for (int j = 0; j<220; j+=22){
                listeBrique.add(new Brique(i,j));
            }
        }

        while(true){

            try{
                ArrayList<Brique> listeTemp = new ArrayList<>();
                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

                dessin.setColor(Color.white);
                dessin.fillRect(0,0, LARGEUR, HAUTEUR);


                barre.dessiner(dessin);


                    balle.dessiner(dessin);
                    balle.deplacement();

                    if(barre.collision(balle)){
                        balle.setVitesseVerticale(-balle.getVitesseVerticale());
                    }


                for (Brique brique : listeBrique){
                    brique.dessiner(dessin);
                    if(brique.collision(balle)){
                        listeTemp.add(brique);
                        balle.setVitesseVerticale(-balle.getVitesseVerticale());
                    }
                }

                for(Brique brique : listeTemp){
                    listeBrique.remove(brique);
                }



                dessin.dispose();
                this.getBufferStrategy().show();

                Thread.sleep(1000/60);
            }catch(InterruptedException e){
                System.out.println("processus arreté");
            }
        }
    }

    public static void main(String[] args) {

        new CasseBrique();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==37){
          barre.deplacerDroite();
        }
        if(e.getKeyCode()==39){
            barre.deplacerGauche();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
