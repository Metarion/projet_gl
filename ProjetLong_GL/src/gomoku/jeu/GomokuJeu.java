package gomoku.jeu;

import gomoku.gui.Cellule;
import gomoku.gui.GomokuGui;
import gomoku.regles.Constantes;

public class GomokuJeu 
{
	public static void main(String[] args)
	{
		new GomokuJeu();
	}
	
	private static Cellule[][] tableau_cellule;
	
	public GomokuJeu()
	{
		GomokuGui window = new GomokuGui();
		tableau_cellule = window.initialiserPlateau(Constantes.SIZE);
		window.setVisible(true);
	}
	
	public static boolean verificationPlacement(Cellule c)
	{		
		if(c.isChecked())
			return false;
		else
		{
			for(int i = -1; i < 2; i++)
			{
				//for
			}
		}
		
		return true;
	}
}