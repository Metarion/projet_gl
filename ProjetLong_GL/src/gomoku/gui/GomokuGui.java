package gomoku.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gomoku.jeu.TraitementJoueur;
import gomoku.regles.Constantes;

public class GomokuGui extends JFrame 
{	
	private JLabel lb_jeton_j1;
	private JLabel lb_jeton_j2;
	private JLabel lb_tour_joueur;
	private int hia;

	public GomokuGui(int hia)
	{	
		super("Gomoku");
		this.hia=hia;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());	
		lb_jeton_j1 = new JLabel("Joueur 1 : " + TraitementJoueur.JETON_J1 + " jeton(s) restant");
		if(hia == Constantes.HUMAN){
			lb_jeton_j2 = new JLabel("Joueur 2 : " + TraitementJoueur.JETON_J2 + " jeton(s) restant");
		} else {
			lb_jeton_j2 = new JLabel("Ordinateur : " + TraitementJoueur.JETON_J2 + " jeton(s) restant");
		}

		lb_tour_joueur = new JLabel("Tour : joueur " + (TraitementJoueur.JOUEUR_ACTUEL == TraitementJoueur.JOUEUR1 ? TraitementJoueur.JOUEUR1 : TraitementJoueur.JOUEUR2));
		lb_tour_joueur.setHorizontalAlignment(JLabel.CENTER);
		JPanel p_info = new JPanel();
		p_info.setPreferredSize(new Dimension(this.getContentPane().getWidth(), 25));
		p_info.setLayout(new BorderLayout());
		p_info.add(lb_jeton_j1, BorderLayout.WEST);
		p_info.add(lb_jeton_j2, BorderLayout.EAST);
		p_info.add(lb_tour_joueur, BorderLayout.CENTER);
		
		this.getContentPane().add(p_info, BorderLayout.NORTH);
	}
	
	public Cellule[][] initialiserPlateau(int size)
	{
		ArrierePlan ap = new ArrierePlan();
		//ap.setPreferredSize(new Dimension(size * 40, size*40));
		ap.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;

		gc.insets = new Insets(2, 2, 2, 2);

		gc.ipady = gc.anchor = GridBagConstraints.CENTER;

		gc.weightx = 1;

		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;

		Cellule[][] tableau_cellule = new Cellule[size][size];
		for(int i = 0; i < size; i++)
			for(int ii = 0; ii < size; ii++)
			{
				gc.gridx = ii;
				gc.gridy = i;
				int cord [] = {ii,i};
				tableau_cellule[ii][i] = new Cellule(this, cord);
				ap.add(tableau_cellule[ii][i], gc);
			}
		
		this.getContentPane().add(ap, BorderLayout.CENTER);
		
		this.pack();
		
		return tableau_cellule;
	}
	
	public void updateValueLabel(int joueur)
	{
		if(joueur == TraitementJoueur.JOUEUR1){
			lb_jeton_j1.setText("Joueur 1 : " + TraitementJoueur.JETON_J1 + " jeton(s) restant");
		}else{
			if(this.hia==Constantes.HUMAN){
				lb_jeton_j2.setText("Joueur 2 : " + TraitementJoueur.JETON_J2 + " jeton(s) restant");
			} else {
				lb_jeton_j2.setText("Ordinateur : " + TraitementJoueur.JETON_J2 + " jeton(s) restant");
			}
		}
		lb_tour_joueur.setText("Tour : joueur " + (TraitementJoueur.JOUEUR_ACTUEL == TraitementJoueur.JOUEUR1 ? TraitementJoueur.JOUEUR2 : TraitementJoueur.JOUEUR1));
	}
	
	public int getHia(){
		return this.hia;
	}
}
