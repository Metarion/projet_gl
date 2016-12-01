package gomoku.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import gomoku.regles.*;

public class GomokuMain extends JFrame 
{
	// Basculer tour_joueur (Cellule) dans régles
	/*public static void main(String[] args) 
	{
		new GomokuMain();
	}*/

	GomokuMain()
	{	
		super("Gomoku");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());	
		this.setVisible(true);
		
		ArrierePlan ap = new ArrierePlan();
		ap.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;

		gc.insets = new Insets(2, 2, 2, 2);

		gc.ipady = gc.anchor = GridBagConstraints.CENTER;

		gc.weightx = 1;

		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;

		for(int i = 0; i < Constantes.SIZE; i++)
			for(int ii = 0; ii < Constantes.SIZE; ii++)
			{
				gc.gridx = ii;
				gc.gridy = i;
				ap.add(new Cellule(), gc);
			}		
		
		this.getContentPane().add(ap, BorderLayout.CENTER);
		this.pack();
		this.validate();
	}
}
