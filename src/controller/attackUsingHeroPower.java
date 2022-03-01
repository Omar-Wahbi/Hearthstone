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

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.Mage;
import model.heroes.Priest;

public class attackUsingHeroPower extends JFrame implements ActionListener
{
	private JPanel att3;
	private JTextArea chooseTarget3;
	private JButton ok3;
	private static Hero curr10;
	private static controller con4;
	private static JPanel twoooo;
	private static JPanel threeeee;
	private static JPanel end5;
	
	public attackUsingHeroPower()
	{
		super();
		this.setBounds(620,300, 250, 150);
		this.setVisible(true);
		att3 = new JPanel();
		att3.setVisible(true);
		att3.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		att3.setLayout(new FlowLayout());
		this.add(att3,BorderLayout.NORTH);
		chooseTarget3 = new JTextArea();
		chooseTarget3.setPreferredSize(new Dimension(230,50));
		chooseTarget3.setText("    Choose your Target");
		chooseTarget3.setFont(new Font("Arial", Font.PLAIN, 20));
		chooseTarget3.setEditable(false);
		att3.add(chooseTarget3,BorderLayout.NORTH);
		ok3 = new JButton();
		ok3.setVisible(true);
		ok3.setPreferredSize(new Dimension(230,50));
		ok3.setLayout(new FlowLayout());
		ok3.setText("OK");
		ok3.setFont(new Font("Arial", Font.PLAIN, 20));
		ok3.addActionListener(this);
		att3.add(ok3,BorderLayout.CENTER);
		controller.setattack3(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton selectedButton5 = (JButton) e.getSource();
		if(selectedButton5.getText().equals("OK"))
		{
			this.setVisible(false);
		}
	}
	
	public static void goPower(Minion minion)
	{
		if(curr10 instanceof Mage)
		{
			Mage v = (Mage) curr10;
			try 
			{
				twoooo.setVisible(false);
				threeeee.setVisible(false);
				end5.setVisible(false);
				v.useHeroPower(minion);
			} 
			catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException | FullHandException| FullFieldException | CloneNotSupportedException e) 
			{
				new messages("\n   " + e.getMessage());
				if(e instanceof FullHandException)
				{
					new burntCard(((FullHandException) e).getBurned());
				}
			}
			con4.createField();
		}
		else if(curr10 instanceof Priest)
		{
			Priest v = (Priest) curr10;
			try 
			{
				twoooo.setVisible(false);
				threeeee.setVisible(false);
				end5.setVisible(false);
				v.useHeroPower(minion);
			} 
			catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException | FullHandException| FullFieldException | CloneNotSupportedException e) 
			{
				new messages("\n   " + e.getMessage());
				if(e instanceof FullHandException)
				{
					new burntCard(((FullHandException) e).getBurned());
				}
			}
			con4.createField();
		}
	}
	
	public static void goPower(Hero targeting)
	{
		if(curr10 instanceof Mage)
		{
			Mage v = (Mage) curr10;
			try 
			{
				twoooo.setVisible(false);
				threeeee.setVisible(false);
				end5.setVisible(false);
				v.useHeroPower(targeting);
			} 
			catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException | FullHandException| FullFieldException | CloneNotSupportedException e) 
			{
				new messages("\n   " + e.getMessage());
				if(e instanceof FullHandException)
				{
					new burntCard(((FullHandException) e).getBurned());
				}
			}
			con4.createField();
		}
		
		else if(curr10 instanceof Priest)
		{
			Priest v = (Priest) curr10;
			try 
			{
				twoooo.setVisible(false);
				threeeee.setVisible(false);
				end5.setVisible(false);
				v.useHeroPower(targeting);
			} 
			catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException | FullHandException| FullFieldException | CloneNotSupportedException e) 
			{
				new messages("\n   " + e.getMessage());
				if(e instanceof FullHandException)
				{
					new burntCard(((FullHandException) e).getBurned());
				}
			}
			con4.createField();
		}
	}
	
	public void setCurr10(Hero currentHero) 
	{
		curr10 = currentHero;
	}
	
	public void setthreeeee(JPanel three) 
	{
		threeeee = three;
	}
	
	public void setend5(JPanel endTurnButton) 
	{
		end5 = endTurnButton;
	}
	public void setCon4(controller controller) 
	{
		con4 = controller;
	}

	public void settwoooo(JPanel two) 
	{
		twoooo = two;
	}
}
