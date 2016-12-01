package gomoku.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame {
	public Menu() {
		this.setTitle("Menu Principal");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// On définit le layout à utiliser sur le content pane
		this.setLayout(new BorderLayout());
		// On ajoute le bouton au content pane de la JFrame
		JLabel lab = new JLabel("Le Jeu de Gomoku !", SwingConstants.CENTER);
		this.getContentPane().add(lab, BorderLayout.NORTH);
		JButton boutJJ = new JButton("Joueur VS Joueur");
		boutJJ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Menu.this.setVisible(false);
				new GomokuMain();
			}
		});
		JButton boutJIA = new JButton("Joueur VS Ia");
		JPanel pan = new JPanel(new GridLayout(2, 1));
		pan.add(boutJJ);
		pan.add(boutJIA);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		this.setVisible(true);
	}

/*	public void actionPerformed(ActionEvent arg0) {

		  if(arg0.getSource() == bout)

		}
	*/
	public static void main(String[] args) {
		Menu m = new Menu();
	}
}