package gomoku.jeu;

public class TraitementJoueur 
{
    /** Constante pour symboliser le nombre de jeton du joueur1 */
    public static int JETON_J1 = 60;
    
    /** Constante pour symboliser le nombre de jeton du joueur2 */
    public static int JETON_J2 = 60;
    
	/** constante pour symboliser le joueur2 */
    public static int JOUEUR_ACTUEL = 1;
    
    /** constante pour symboliser le joueur1 */
    public final static int JOUEUR1 = 1;
    
    /** constante pour symboliser le joueur2 */
    public final static int JOUEUR2 = 2;
    
    public static void resetValue()
    {
    	JOUEUR_ACTUEL = JOUEUR1;
    	JETON_J1 = JETON_J2 = 60;
    }
	
}
