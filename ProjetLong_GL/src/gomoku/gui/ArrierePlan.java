package gomoku.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import gomoku.regles.Constantes;

public class ArrierePlan extends JPanel
{
	int lCel;
	int hCel;
	
	ArrierePlan()
	{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(Constantes.HP, Constantes.LP));
		this.setBackground(Color.orange);
		hCel = (Constantes.HP) / Constantes.SIZE;
		lCel = (Constantes.LP) / Constantes.SIZE;
	}
	
	@Override 
	public void paintComponent(Graphics g) 
	{ 
		super.paintComponent(g);
		
		((Graphics2D)g).setStroke(new BasicStroke(2));
		
		int x0 = lCel / 2;
		int y0 = hCel /2 ;			
		
		// Barre gauche
		g.drawLine(x0, y0, x0, (Constantes.SIZE - 1) *  hCel + y0);
		// Barre droite
		g.drawLine((Constantes.SIZE) * lCel - x0, y0, (Constantes.SIZE) * lCel - x0, (Constantes.SIZE - 1) *  hCel + y0);
		// Barre haute
		g.drawLine(x0, y0, (Constantes.SIZE) * lCel - x0, y0);
		// Barre basse
		g.drawLine(x0, (Constantes.SIZE - 1) *  hCel + y0, (Constantes.SIZE) * lCel - x0, (Constantes.SIZE - 1) *  hCel + y0);
		
		// Ligne horizontal
		for(int i = 1; i <= Constantes.SIZE - 2; i++)
			g.drawLine(x0, y0 + i * hCel, (Constantes.SIZE) * lCel - x0, y0 + i * hCel);
		
		// Ligne vertical
		for(int i = 1; i <= Constantes.SIZE - 2; i++)
			g.drawLine(x0 + i * lCel, y0, x0 + i * lCel, (Constantes.SIZE - 1) *  hCel + y0);
    }
}
