package gomoku.regles;

public class Constantes 
{
	/** constante qui va définir la taille de la grille */
	public final static int SIZE = 19;

	/** hauteur du plateau */
	public final static int HP = SIZE*40;
	
	/** largeur du plateau */
	public final static int LP = SIZE*40;
	
	/** constante pour symboliser le joueur humain */
    public final static int HUMAN = 0;
	
	/** constante pour symboliser le joueur ordinateur */
    public final static int COMPUTER = 1;
	
    /** constante pour symboliser une case sans pions */
    public final static String CASE_INACTIVE = ".";
    
    /** Permet de préciser si les jeton doivent ếtre obligatoirement placé à coté d'un autre jeton */
    public static boolean aCote = true;
    
}
