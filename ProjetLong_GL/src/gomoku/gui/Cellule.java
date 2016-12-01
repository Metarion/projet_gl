package gomoku.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gomoku.regles.Constantes;

class Cellule extends JPanel implements MouseListener
{
	/** Par qu'elle joueur la cellule a était check */ 
	private int checkBy;
	/** Si la cellule a déjà était séléctionné par un joueur */
	private boolean isChecked = false;
	
	Cellule()
	{
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
			if(checkBy == Constantes.JOUEUR1)
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
		//System.out.println(((GridBagLayout)((JPanel)MainWindow.this.getContentPane().getComponent(0)).getLayout()).getConstraints(this).gridx);
		//System.out.println(((GridBagLayout)((JPanel)MainWindow.this.getContentPane().getComponent(0)).getLayout()).getConstraints(this).gridy);
		
		if(!isChecked)
		{
			if(Constantes.JOUEUR_ACTUEL == Constantes.JOUEUR1)
				checkBy = Constantes.JOUEUR1; // Joueur 1
			else
				checkBy = Constantes.JOUEUR2; // Joueur 2
			
			Constantes.JOUEUR_ACTUEL = (Constantes.JOUEUR_ACTUEL == Constantes.JOUEUR1 ? Constantes.JOUEUR2 : Constantes.JOUEUR1);
			isChecked = true;
			this.repaint();
		}
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
