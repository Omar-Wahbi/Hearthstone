package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.Spell;

public class burntCard extends JFrame implements ActionListener
{
	private JPanel bur;
	private JButton ok4;
	private JTextArea burn;
	public burntCard(Card b)
	{
		super();
		this.setBounds(920,300, 150, 180);
		this.setVisible(true);
		bur = new JPanel();
		bur.setVisible(true);
		bur.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		bur.setLayout(new FlowLayout());
		this.add(bur,BorderLayout.NORTH);
		if(b instanceof Minion)
		{
			Minion min = (Minion)b;
			burn = new JTextArea();
			burn.setFont(new Font("Arial", Font.BOLD, 8));
			burn.setText("                   Burnt Card\n" + b.getName() + "\nMana Cost = " + b.getManaCost() + "\nRarity = " + b.getRarity() + "\nAttack = " + min.getAttack() + "\nCurrent HP = " + min.getCurrentHP() + "\nTaunt = " + min.isTaunt() + "\nDivine = " + min.isDivine() + "\nCharge = " + !min.isSleeping());
			burn.setPreferredSize(new Dimension(140,90));
			burn.setEditable(false);
			bur.add(burn,BorderLayout.NORTH);
		}
		
		else if(b instanceof Spell)
		{
			burn = new JTextArea();
			burn.setFont(new Font("Arial", Font.BOLD, 8));
			burn.setText("                   Burnt Card\n" + b.getName() + "\nMana Cost = " + b.getManaCost() + "\nRarity = " + b.getRarity());
			burn.setPreferredSize(new Dimension(140,90));
			burn.setEditable(false);
			bur.add(burn,BorderLayout.NORTH);
		}
		ok4 = new JButton();
		ok4.setVisible(true);
		ok4.setPreferredSize(new Dimension(140,40));
		ok4.setLayout(new FlowLayout());
		ok4.setText("OK");
		ok4.setFont(new Font("Arial", Font.PLAIN, 20));
		ok4.addActionListener(this);
		bur.add(ok4,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton selectedButton4 = (JButton) e.getSource();
		
		if(selectedButton4.getText().equals("OK"))
		{
			this.setVisible(false);
		}
	}
}
