package gomoku.regles;

public interface Constantes {
	/** constante qui va définir la taille de la grille */
	final static int SIZE = 19;

	/** hauteur du plateau */
	final static int HP = SIZE*50;
	
	/** largeur du plateau */
	final static int LP = SIZE*50;
    
    /** constante pour symboliser le joueur1 */
    final static int JOUEUR1 = 1;
    
    /** constante pour symboliser le joueur2 */
    final static int JOUEUR2 = -1;
	
	/** constante pour symboliser le joueur humain */
	final static int HUMAN = 0;
	
	/** constante pour symboliser le joueur ordinateur */
	final static int COMPUTER = 1;
	
    /** constante pour symboliser une case sans pions */
    final static String CASE_INACTIVE = ".";
    
}
