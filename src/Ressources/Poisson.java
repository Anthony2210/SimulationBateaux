package Ressources;

import Bateaux.Bateau;

public class Poisson implements Ressource {
    private final int valeur = 50;
    private final int espaceInventaire = 10;
    private final long tempsDisparition = 60000; // 60 000 milliseconds (1 minute)

    @Override
    public int getValeur() {
        return valeur;
    }

    @Override
    public int getEspaceInventaire() {
        return espaceInventaire;
    }

    @Override
    public long getTempsDisparition() {
        return tempsDisparition;
    }

    @Override
    public void interagir(Bateau bateau) {
        // Logique spécifique pour interagir avec un bateau pêcheur
        System.out.println("Le bateau pêcheur attrape un poisson !");
    }
}