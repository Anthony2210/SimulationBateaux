package Ressources;

import Bateaux.Bateau;

public interface Ressource {
    int getValeur();
    int getEspaceInventaire();
    long getTempsDisparition();
    void interagir(Bateau bateau);
}