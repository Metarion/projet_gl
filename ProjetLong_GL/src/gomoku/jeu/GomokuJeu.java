package gomoku.jeu;

import gomoku.gui.Cellule;
import gomoku.gui.GomokuGui;
import gomoku.regles.Constantes;

public class GomokuJeu 
{
	/*public static void main(String[] args)
	{
		new GomokuJeu();
	}*/
	
	private static Cellule[][] tableau_cellule;
	public static int nbTour = 0;
	
	public GomokuJeu(int hia)
	{
		GomokuGui window = new GomokuGui(hia);
		tableau_cellule = window.initialiserPlateau(Constantes.SIZE);
		window.setVisible(true);
	}
	
	public static boolean verificationPlacement(Cellule c)
	{		
		if(c.isChecked())
			return false;
		else
		{
			if(nbTour == 0)
				return true;
			else
			{
				boolean ok = false;
				for(int i = -1; i < 2; i++)
				{
					for(int ii = -1; ii < 2; ii++)
					{
						int testX = c.getCordX() - i;
						int testY = c.getCordY() - ii;
						
						if(testX >= 0 && testX < Constantes.SIZE && testY >=0 && testY < Constantes.SIZE) // Si la cellules a tester existe
						{
							if(tableau_cellule[testX][testY].isChecked())
								ok = true;
						}
					}
				}
				
				return ok;
			}
		}
	}
}