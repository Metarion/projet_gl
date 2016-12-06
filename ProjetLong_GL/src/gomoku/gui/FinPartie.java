package gomoku.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class FinPartie extends JFrame 
{
	public FinPartie(GomokuGui window, String text)
	{
		super("Fin de partie");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(300,100));
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		JLabel lb_text = new JLabel(text, SwingConstants.CENTER);
		lb_text.setSize(new Dimension(this.getWidth(), 30));
		
		JButton bt_rejouer = new JButton("Rejouer");
		bt_rejouer.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				FinPartie.this.dispose();
			}

		});
		JButton bt_retourMenuPrincipale = new JButton("Retour au menu");
		bt_retourMenuPrincipale.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				window.closeWindow();
				FinPartie.this.dispose();
			}

		});

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4,4,4,4);
        JPanel p_bt = new JPanel();
        p_bt.setLayout(new GridBagLayout());
        p_bt.add(bt_rejouer, gbc);
        p_bt.add(bt_retourMenuPrincipale, gbc);
        contentPane.add(p_bt, BorderLayout.CENTER);
        contentPane.add(lb_text, BorderLayout.NORTH);
		this.setContentPane(contentPane);
		this.setVisible(true);
	}
}
