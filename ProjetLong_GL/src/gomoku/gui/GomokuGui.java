package gomoku.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import gomoku.jeu.TraitementJoueur;
import gomoku.regles.Constantes;

public class GomokuGui extends JFrame implements WindowListener {
	private Menu menu;

	private JLabel lb_jeton_j1;
	private JLabel lb_jeton_j2;
	private JLabel lb_tour_joueur;

	public GomokuGui(int hia, Menu menu) {
		super("Gomoku");

		this.menu = menu;
		this.addWindowListener(this);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		lb_jeton_j1 = new JLabel("Joueur 1 : " + TraitementJoueur.JETON_J1 + " jeton(s) restant");
		if (hia == Constantes.HUMAN) {
			lb_jeton_j2 = new JLabel("Joueur 2 : " + TraitementJoueur.JETON_J2 + " jeton(s) restant");
		} else {
			lb_jeton_j2 = new JLabel("Ordinateur : " + TraitementJoueur.JETON_J2 + " jeton(s) restant");
		}

		lb_tour_joueur = new JLabel("Tour : joueur 1");
		lb_tour_joueur.setHorizontalAlignment(JLabel.CENTER);
		JPanel p_info = new JPanel();
		p_info.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		p_info.setPreferredSize(new Dimension(this.getContentPane().getWidth(), 25));
		p_info.setLayout(new BorderLayout());
		p_info.add(lb_jeton_j1, BorderLayout.WEST);
		p_info.add(lb_jeton_j2, BorderLayout.EAST);
		p_info.add(lb_tour_joueur, BorderLayout.CENTER);
		p_info.setBackground(Color.orange);

		this.getContentPane().add(p_info, BorderLayout.NORTH);
	}

	public Cellule[][] initialiserPlateau(int size) {
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

		Cellule[][] tableau_cellule = new Cellule[size][size];
		for (int i = 0; i < size; i++)
			for (int ii = 0; ii < size; ii++) {
				gc.gridx = ii;
				gc.gridy = i;
				int cord[] = { ii, i };
				tableau_cellule[ii][i] = new Cellule(this, cord);
				ap.add(tableau_cellule[ii][i], gc);
			}

		this.getContentPane().add(ap, BorderLayout.CENTER);

		this.pack();

		this.setLocationRelativeTo(null);

		return tableau_cellule;
	}

	public void updateValueLabel() {
		lb_jeton_j1.setText("Joueur 1 : " + TraitementJoueur.JETON_J1 + " jeton(s) restant");
		lb_jeton_j2.setText("Joueur 2 : " + TraitementJoueur.JETON_J2 + " jeton(s) restant");

		lb_tour_joueur.setText("Tour : joueur " + TraitementJoueur.JOUEUR_ACTUEL);

		this.validate();
	}

	public void closeWindow() {
		this.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		menu.setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
