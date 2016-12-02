package gomoku.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import gomoku.jeu.GomokuJeu;
import gomoku.jeu.TraitementJoueur;
import gomoku.regles.Constantes;

public class Cellule extends JPanel implements MouseListener
{
	/** Par qu'elle joueur la cellule a était check */ 
	private int checkBy;
	/** Si la cellule a déjà était séléctionné par un joueur */
	private boolean isChecked = false;
	
	private int cord [];
	
	private GomokuGui window;
	
	Cellule(GomokuGui window, int[] cord)
	{
		this.window = window;
		this.cord = cord;
		// Permet d'avoir un fond transparent afin de pouvoir voir la plateau à travers les cellules
		this.setBackground(new Color(0,0,0,0));
				
		this.addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	
		
		if(isChecked)
		{
			if(checkBy == TraitementJoueur.JOUEUR1)
			{
				g.setColor(Color.black);
				g.fillOval(0, 0, this.getWidth(), this.getHeight());
			}
			else
			{
				g.setColor(Color.white);
				g.fillOval(0, 0, this.getWidth(), this.getHeight());
			}			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{		
			GomokuJeu.verificationPlacement(this);
			if(TraitementJoueur.JOUEUR_ACTUEL == TraitementJoueur.JOUEUR1)
			{
				if(TraitementJoueur.JETON_J1 != 0)
					TraitementJoueur.JETON_J1--;
				checkBy = TraitementJoueur.JOUEUR1; // Joueur 1
			}
			else
			{
				if(TraitementJoueur.JETON_J2 != 0)
					TraitementJoueur.JETON_J2--;
				checkBy = TraitementJoueur.JOUEUR2; // Joueur 2
			}
			
			window.updateValueLabel(TraitementJoueur.JOUEUR_ACTUEL);
			
			TraitementJoueur.JOUEUR_ACTUEL = (TraitementJoueur.JOUEUR_ACTUEL == TraitementJoueur.JOUEUR1 ? TraitementJoueur.JOUEUR2 : TraitementJoueur.JOUEUR1);
			isChecked = true;
			this.repaint();
	}
	
	public boolean isChecked()
	{
		return isChecked;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
