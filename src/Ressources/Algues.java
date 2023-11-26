package Ressources;

import Bateaux.Bateau;

public class Algues implements Ressource {
    private final int valeur = 1;
    private final int espaceInventaire = 1;
    private final long tempsDisparition = 30000; // 60 000 milliseconds (1 minute)

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
        // Implémentation de l'interaction avec les algues
    }
}