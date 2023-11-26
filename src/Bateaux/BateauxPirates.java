package Bateaux;

public class BateauxPirates extends Bateau {
    public BateauxPirates(int positionX, int positionY, double vitesse) {
        super(positionX, positionY, vitesse);
        this.capaciteMaxInventaire = 50;

    }

    // Ajoutez des méthodes spécifiques aux bateaux pirates ici
}