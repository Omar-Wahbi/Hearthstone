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

import exceptions.FullFieldException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class summon extends JFrame implements ActionListener
{ 
	private JPanel sum;
	private Hero curr;
	private Minion curr2;
	private controller con;
	private JPanel two2;
	private JPanel three3;
	private JPanel end2;
	
	public summon()
	{
		super();
		this.setBounds(620,300, 250, 150);
		this.setVisible(true);
		sum = new JPanel();
		sum.setVisible(true);
		sum.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		sum.setLayout(new FlowLayout());
		this.add(sum,BorderLayout.CENTER);
		JButton summ = new JButton();
		summ.setFont(new Font("Arial", Font.PLAIN, 15));
		summ.addActionListener(this);
		summ.setText("Summon");
		summ.setPreferredSize(new Dimension(100,100));
		sum.add(summ);
		JButton cancel = new JButton();
		cancel.setFont(new Font("Arial", Font.PLAIN, 15));
		cancel.addActionListener(this);
		cancel.setText("Cancel");
		cancel.setPreferredSize(new Dimension(100,100));
		sum.add(cancel);
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton selectedButton2 = (JButton) e.getSource();
		if(selectedButton2.getText().equals("Cancel"))
		{
			this.setVisible(false);
		}
		else
		{
			try 
			{
				two2.setVisible(false);
				three3.setVisible(false);
				end2.setVisible(false);
				putMinion();
			} 
			catch (NotYourTurnException | NotEnoughManaException | FullFieldException e1) 
			{
				new messages("\n        " + e1.getMessage());
			}
			con.createField();
			this.setVisible(false);
		}
		
	}
	
	public void setCurr(Hero currentHero) 
	{
		this.curr = currentHero;
	}
	
	public void putMinion() throws NotYourTurnException, NotEnoughManaException, FullFieldException
	{
		curr.playMinion(curr2);
	}

	public void setCurr2(Minion curr2)
	{
		this.curr2 = curr2;
	}

	public void setCon(controller controller) {
		this.con = controller;
	}

	public void setthree(JPanel three) 
	{
		this.three3 = three;
	}

	public void settwo(JPanel two) 
	{
		this.two2 = two;
	}

	public void setend(JPanel endTurnButton) 
	{
		end2 = endTurnButton;
	}
}
