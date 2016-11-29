package gomoku.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gomoku.regles.*;

public class MainWindow extends JFrame 
{

	public static void main(String[] args) 
	{
		new MainWindow();
	}

	MainWindow()
	{	
		this.setSize(new Dimension(700, 700));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setContentPane(new ArrierePlan());	
		this.setVisible(true);
		
		JPanel p2 = new JPanel();
		p2.setOpaque(false);
		p2.setSize(new Dimension(700,700));
		p2.setLayout(new GridBagLayout());
		p2.setBackground(new Color(0,0,0,0));
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;

		gc.insets = new Insets(2, 2, 2, 2);

		gc.ipady = gc.anchor = GridBagConstraints.CENTER;

		gc.weightx = 3;

		gc.weighty = 3;

		gc.gridx = 0;
		gc.gridy = 0;
		int k = 1;
		for(int i = 0; i < 19; i++)
		{
			for(int ii = 0; ii < 19; ii++)
			{
				gc.gridx = ii;
				gc.gridy = i;
				p2.add(new Cellule(), gc);
			}
			
		}		
		
		this.add(p2, BorderLayout.CENTER);
		this.validate();
	}
	
	class ArrierePlan extends JPanel
	{
		ArrierePlan()
		{
			this.setLayout(new BorderLayout());
			this.setSize(new Dimension(MainWindow.this.getWidth(),MainWindow.this.getHeight()));
		}
		
		@Override 
		public void paintComponent(Graphics g) 
		{ 
			super.paintComponent(g);
			
			((Graphics2D)g).setStroke(new BasicStroke(2));
			
			// Bord du plateau
			g.drawLine(19 + 2, 19, 19 + 2, this.getHeight() - 19);
			g.drawLine(19 + 2, 19, this.getWidth() - 19 - 2, 19);
			g.drawLine(19 + 2, this.getHeight() - 19, this.getWidth() - 19 - 2, this.getHeight() - 19);
			g.drawLine(this.getWidth() - 19 - 2, 19, this.getWidth() - 19 - 2, this.getHeight()- 19);
			
			int taille_celluleH = this.getHeight() / 19;
			int positionH = taille_celluleH + 19;
			
			int taille_celluleL = this.getWidth() / 19;
			int positionL = taille_celluleH + 19;
			
			for(int i = 0; i < Constantes.SIZE - 2; i++)
			{
				g.drawLine(19 + 5, (i == 0 ? positionH : taille_celluleH * i + positionH + 1 ), this.getWidth() - 19 - 5, (i == 0 ? positionH : taille_celluleH * i + positionH + 1));
			}
			
			for(int i = 0; i < Constantes.SIZE - 2; i++)
			{
				g.drawLine((i == 0 ? positionL + 8: taille_celluleL * i + positionL + 8),19, (i == 0 ? positionL + 8 : taille_celluleL * i + positionL + 8), this.getHeight() - 19);
			}
	    }
	}
	
	static class Cellule extends JPanel implements MouseListener
	{
		private static int tour = 0;
		
		Cellule()
		{
			this.setBackground(new Color(0,0,0,0));
			this.addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			//System.out.println(((GridBagLayout)((JPanel)MainWindow.this.getContentPane().getComponent(0)).getLayout()).getConstraints(this).gridx);
			//System.out.println(((GridBagLayout)((JPanel)MainWindow.this.getContentPane().getComponent(0)).getLayout()).getConstraints(this).gridy);
			
			Graphics g = this.getGraphics();
			if(tour == 1)
				g.setColor(Color.red);
			else
				g.setColor(Color.green);
			g.fillOval(0, 0, this.getWidth(), this.getHeight());
			tour = (tour == 0 ? 1 : 0);
			
			
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
}
