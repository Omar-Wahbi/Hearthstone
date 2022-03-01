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

import exceptions.CannotAttackException;
import exceptions.InvalidTargetException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class attackUsingMinion extends JFrame implements ActionListener
{
	private JPanel att;
	private JPanel att2;
	private static Hero curr7;
	private static Hero opp2;
	private static Minion curr8;
	private static Minion curr9;
	private JTextArea chooseTarget2;
	private JButton ok2;
	private static controller con3;
	private static JPanel twooo;
	private static JPanel threeee;
	private static JPanel end4;
	public attackUsingMinion()
	{
		super();
		this.setBounds(620,300, 250, 150);
		this.setVisible(true);
		att = new JPanel();
		att.setVisible(true);
		att.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		att.setLayout(new FlowLayout());
		this.add(att,BorderLayout.CENTER);
		JButton cass = new JButton();
		cass.setFont(new Font("Arial", Font.PLAIN, 15));
		cass.addActionListener(this);
		cass.setText("Attack");
		cass.setPreferredSize(new Dimension(100,100));
		att.add(cass);
		JButton cancel2 = new JButton();
		cancel2.setFont(new Font("Arial", Font.PLAIN, 15));
		cancel2.addActionListener(this);
		cancel2.setText("Cancel");
		cancel2.setPreferredSize(new Dimension(100,100));
		att.add(cancel2);
		this.revalidate();
		this.repaint();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton selectedButton4 = (JButton) e.getSource();
		
		if(selectedButton4.getText().equals("OK"))
		{
			this.setVisible(false);
		}
		
		else if(selectedButton4.getText().equals("Cancel"))
		{
			this.setVisible(false);
			twooo.setVisible(false);
			threeee.setVisible(false);
			end4.setVisible(false);
			con3.createField();
		}
		
		else
		{
			goAttack();
		}
	}
	
	public void goAttack() 
	{
		att.setVisible(false);
		att2 = new JPanel();
		att2.setVisible(true);
		att2.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		att2.setLayout(new FlowLayout());
		this.add(att2,BorderLayout.NORTH);
		chooseTarget2 = new JTextArea();
		chooseTarget2.setPreferredSize(new Dimension(230,50));
		chooseTarget2.setText("    Choose your Target");
		chooseTarget2.setFont(new Font("Arial", Font.PLAIN, 20));
		chooseTarget2.setEditable(false);
		att2.add(chooseTarget2,BorderLayout.NORTH);
		ok2 = new JButton();
		ok2.setVisible(true);
		ok2.setPreferredSize(new Dimension(230,50));
		ok2.setLayout(new FlowLayout());
		ok2.setText("OK");
		ok2.setFont(new Font("Arial", Font.PLAIN, 20));
		ok2.addActionListener(this);
		att2.add(ok2,BorderLayout.CENTER);
		controller.setattack2(true);
	}

	public void setend4(JPanel endTurnButton) 
	{
		end4 = endTurnButton;
	}
	public void setCon3(controller controller) 
	{
		con3 = controller;
	}

	public void settwooo(JPanel two) 
	{
		twooo = two;
	}

	public void setthreeee(JPanel three) 
	{
		threeee = three;
	}

	public void setCurr7(Hero currentHero) 
	{
		curr7 = currentHero;
	}

	public static void setopp2(Hero opponent) 
	{
		opp2 = opponent;
	}

	public void setCurr8(Minion minion) 
	{
		curr8 = minion;
	}
	
	public static void setCurr9(Minion minion) 
	{
		curr9 = minion;
	}

	public static void attMinion() 
	{
		try 
		{
			twooo.setVisible(false);
			threeee.setVisible(false);
			end4.setVisible(false);
			curr7.attackWithMinion(curr8, curr9);
			curr8 = null;
			curr9 = null;
		} 
		catch (CannotAttackException | NotYourTurnException | TauntBypassException | InvalidTargetException| NotSummonedException e) 
		{
			new messages("\n" + e.getMessage());
		}
		con3.createField();
	}
	
	public static void attMinion2() 
	{
		try 
		{
			twooo.setVisible(false);
			threeee.setVisible(false);
			end4.setVisible(false);
			curr7.attackWithMinion(curr8, opp2);
			curr8 = null;
			opp2 = null;
		} 
		catch (CannotAttackException | NotYourTurnException | TauntBypassException | NotSummonedException| InvalidTargetException e) 
		{
			new messages("\n" + e.getMessage());
		}			
		con3.createField();
	}
}
