package gomoku.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gomoku.jeu.GomokuJeu;
import gomoku.jeu.TraitementJoueur;
import gomoku.regles.Constantes;

@SuppressWarnings("serial")
public class Menu extends JFrame {
	public Menu() {
		this.setTitle("Menu Principal");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// On définit le layout à utiliser sur le content pane
		this.setLayout(new BorderLayout());
		// On ajoute le bouton au content pane de la JFrame
		JLabel lab = new JLabel("Le Jeu de Gomoku !", SwingConstants.CENTER);
		this.getContentPane().add(lab, BorderLayout.NORTH);
		JButton boutJJ = new JButton("Joueur VS Joueur");
		boutJJ.setPreferredSize(new Dimension(200, 40));
		boutJJ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Constantes.TYPE_ADVERSAIRE = Constantes.HUMAN;
				GomokuJeu jeu = new GomokuJeu();
				jeu.lancerJeu();
				Menu.this.dispose();
			}
		});
		
		JButton boutJIA = new JButton("Joueur VS Ia");
		boutJIA.setPreferredSize(new Dimension(200, 40));
		boutJIA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Constantes.TYPE_ADVERSAIRE = Constantes.COMPUTER;
				GomokuJeu jeu = new GomokuJeu();
				jeu.lancerJeu();
				Menu.this.dispose();
			}
		});
		
		JButton boutMorpion = new JButton("Morpion");
		boutMorpion.setPreferredSize(new Dimension(200, 40));
		boutMorpion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Menu.this.setVisible(false);
			//	TraitementJoueur.resetValue();
			//	GomokuJeu jeu = new GomokuJeu(0, Menu.this);
			//	Menu.this.setVisible(false);
			}
		});
		
		JButton boutPuissance4 = new JButton("Puissance 4");
		boutPuissance4.setPreferredSize(new Dimension(200, 40));
		boutPuissance4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Menu.this.setVisible(false);
			//	TraitementJoueur.resetValue();
			//	GomokuJeu jeu = new GomokuJeu(0, Menu.this);
			//	Menu.this.setVisible(false);
			}
		});
		
		JButton boutParam = new JButton("Paramètres");
		boutParam.setPreferredSize(new Dimension(200, 40));
		boutParam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Menu.this.setVisible(false);
			//	TraitementJoueur.resetValue();
			//	GomokuJeu jeu = new GomokuJeu(0, Menu.this);
			//	Menu.this.setVisible(false);
			}
		});
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		JPanel pan = new JPanel(new GridBagLayout());
		this.getContentPane().setBackground(new Color(255,189,79));
		pan.setBackground(new Color(255,189,79));
		gbc.gridx=0;
		gbc.gridy=0;
		pan.add(boutJJ, gbc);
		gbc.gridy++;
		pan.add(boutJIA, gbc);
		gbc.gridy++;
		pan.add(boutMorpion, gbc);
		gbc.gridy++;
		pan.add(boutPuissance4, gbc);
		gbc.gridy++;
		pan.add(boutParam, gbc);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Menu();
	}
}
