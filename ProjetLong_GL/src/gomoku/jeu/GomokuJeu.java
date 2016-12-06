package gomoku.jeu;

import gomoku.gui.Cellule;
import gomoku.gui.FinPartie;
import gomoku.gui.GomokuGui;
import gomoku.gui.Menu;
import gomoku.regles.Constantes;

public class GomokuJeu {
	private static Cellule[][] tableau_cellule;
	public static int nbTour = 0;

	public GomokuJeu() {
	}

	public GomokuJeu(int hia, Menu menu) {
		GomokuGui window = new GomokuGui(hia, menu);
		nbTour = 0;
		tableau_cellule = window.initialiserPlateau(Constantes.SIZE);
		window.setVisible(true);
	}

	private boolean verificationPlacement(Cellule c) {
		if (c.isChecked())
			return false;
		else {
			if (nbTour == 0)
				return true;
			else {
				for (int i = -1; i < 2; i++) {
					for (int ii = -1; ii < 2; ii++) {
						int testX = c.getCordX() - i;
						int testY = c.getCordY() - ii;

						if (testX >= 0 && testX < Constantes.SIZE && testY >= 0 && testY < Constantes.SIZE) // Si
																											// la
																											// cellules
																											// a
																											// tester
																											// existe
							if (tableau_cellule[testX][testY].isChecked())
								return true;
					}
				}
				return false;
			}
		}
	}

	public void joueurJoue(Cellule c, GomokuGui window) {
		if (verificationPlacement(c)) {
			nbTour++;
			if (TraitementJoueur.JOUEUR_ACTUEL == TraitementJoueur.JOUEUR1) {
				if (TraitementJoueur.JETON_J1 != 0)
					TraitementJoueur.JETON_J1--;
				c.setCheckBy(TraitementJoueur.JOUEUR1); // Joueur 1
			} else {
				if (TraitementJoueur.JETON_J2 != 0)
					TraitementJoueur.JETON_J2--;
				c.setCheckBy(TraitementJoueur.JOUEUR2); // Joueur 2
			}

			c.setCheck();

			c.repaint();

			if (aGagner(c)) {
				new FinPartie(window, "Le joueur " + TraitementJoueur.JOUEUR_ACTUEL + " a gagné");
			} else {
				TraitementJoueur.JOUEUR_ACTUEL = (TraitementJoueur.JOUEUR_ACTUEL == TraitementJoueur.JOUEUR1
						? TraitementJoueur.JOUEUR2 : TraitementJoueur.JOUEUR1);
			}
		}
	}

	private boolean aGagner(Cellule c) {
		if (testVertical(c) || testHorizontal(c) || testDiagonalGauche(c) || testDiagonalDroite(c))
			return true;

		return false;
	}

	private boolean testVertical(Cellule c) {
		int cpt_bon = 1;
		int x = 1;
		int y = 1;
		boolean continu = true;

		// test haut
		while (continu) {
			if (c.getCordY() - y >= 0) {
				if (tableau_cellule[c.getCordX()][c.getCordY() - y].isChecked()
						&& tableau_cellule[c.getCordX()][c.getCordY() - y].checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			y++;
		}

		y = 1;
		continu = true;

		// test bas
		while (continu) {
			if (c.getCordY() < Constantes.SIZE) {
				if (tableau_cellule[c.getCordX()][c.getCordY() + y].isChecked()
						&& tableau_cellule[c.getCordX()][c.getCordY() + y].checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			y++;
		}

		if (cpt_bon == 5)
			return true;

		return false;
	}

	private boolean testHorizontal(Cellule c) {
		int cpt_bon = 1;
		int x = 1;
		int y = 1;
		boolean continu = true;

		// test gauche
		while (continu) {
			if (c.getCordX() - x >= 0) {
				if (tableau_cellule[c.getCordX() - x][c.getCordY()].isChecked()
						&& tableau_cellule[c.getCordX() - x][c.getCordY()].checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			x++;
		}

		continu = true;
		x = 1;

		// test droite
		while (continu) {
			if (c.getCordX() + x < Constantes.SIZE) {
				if (tableau_cellule[c.getCordX() + x][c.getCordY()].isChecked()
						&& tableau_cellule[c.getCordX() + x][c.getCordY()].checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			x++;
		}

		if (cpt_bon == 5)
			return true;

		return false;
	}

	private boolean testDiagonalGauche(Cellule c) {
		int cpt_bon = 1;
		int x = 1;
		int y = 1;
		boolean continu = true;

		// test \
		while (continu) {
			if (c.getCordX() - x >= 0 && c.getCordY() - y >= 0) {
				if (tableau_cellule[c.getCordX() - x][c.getCordY() - y].isChecked()
						&& tableau_cellule[c.getCordX() - x][c.getCordY() - y]
								.checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			x++;
			y++;
		}

		continu = true;
		x = 1;
		y = 1;

		while (continu) {
			if (c.getCordX() + x < Constantes.SIZE && c.getCordY() + y < Constantes.SIZE) {
				if (tableau_cellule[c.getCordX() + x][c.getCordY() + y].isChecked()
						&& tableau_cellule[c.getCordX() + x][c.getCordY() + y]
								.checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			x++;
			y++;
		}

		if (cpt_bon == 5)
			return true;

		return false;
	}

	private boolean testDiagonalDroite(Cellule c) {
		int cpt_bon = 1;
		int x = 1;
		int y = 1;
		boolean continu = true;

		// test /
		while (continu) {
			if (c.getCordX() + x < Constantes.SIZE && c.getCordY() - y >= 0) {
				if (tableau_cellule[c.getCordX() + x][c.getCordY() - y].isChecked()
						&& tableau_cellule[c.getCordX() + x][c.getCordY() - y]
								.checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			x++;
			y++;
		}

		continu = true;
		x = 1;
		y = 1;

		while (continu) {
			if (c.getCordX() - x >= 0 && c.getCordY() + y < Constantes.SIZE) {
				if (tableau_cellule[c.getCordX() - x][c.getCordY() + y].isChecked()
						&& tableau_cellule[c.getCordX() - x][c.getCordY() + y]
								.checkBy() == TraitementJoueur.JOUEUR_ACTUEL)
					cpt_bon++;
				else
					continu = false;
			} else
				continu = false;

			x++;
			y++;
		}

		if (cpt_bon == 5)
			return true;

		return false;
	}
}