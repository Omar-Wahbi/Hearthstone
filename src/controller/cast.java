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

import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.FieldSpell;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.KillCommand;
import model.cards.spells.LeechingSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Pyroblast;
import model.cards.spells.Spell;
import model.heroes.Hero;

public class cast extends JFrame implements ActionListener
{
	private JPanel cas;
	private JPanel cas2;
	private static Hero curr3;
	private Hero opp;
	private static Spell curr4;
	private static Minion curr5;
	private static Hero curr6;
	private static controller con2;
	private static JPanel twoo;
	private static JPanel threee;
	private static JPanel end3;
	private JTextArea chooseTarget;
	private JButton ok;
	
	public cast()
	{
		super();
		this.setBounds(620,300, 250, 150);
		this.setVisible(true);
		cas = new JPanel();
		cas.setVisible(true);
		cas.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		cas.setLayout(new FlowLayout());
		this.add(cas,BorderLayout.CENTER);
		JButton cass = new JButton();
		cass.setFont(new Font("Arial", Font.PLAIN, 15));
		cass.addActionListener(this);
		cass.setText("Cast");
		cass.setPreferredSize(new Dimension(100,100));
		cas.add(cass);
		JButton cancel2 = new JButton();
		cancel2.setFont(new Font("Arial", Font.PLAIN, 15));
		cancel2.addActionListener(this);
		cancel2.setText("Cancel");
		cancel2.setPreferredSize(new Dimension(100,100));
		cas.add(cancel2);
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton selectedButton3 = (JButton) e.getSource();
		if(selectedButton3.getText().equals("OK"))
		{
			this.setVisible(false);
		}
		else if(selectedButton3.getText().equals("Cancel"))
		{
			this.setVisible(false);
			twoo.setVisible(false);
			threee.setVisible(false);
			end3.setVisible(false);
			con2.createField();
		}
		else 
		{
			if(curr4 instanceof AOESpell)
			{
				try 
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((AOESpell)curr4,opp.getField());
				} 
				catch (NotYourTurnException | NotEnoughManaException e1) 
				{
					new messages("\n        " + e1.getMessage());
				}
				con2.createField();
				this.setVisible(false);
			}
			else if(curr4 instanceof FieldSpell)
			{
				try 
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((FieldSpell)curr4);
				} 
				catch (NotYourTurnException | NotEnoughManaException e1) 
				{
					new messages("\n        " + e1.getMessage());
				}
				con2.createField();
				this.setVisible(false);
			}
			
			else if(curr4 instanceof HeroTargetSpell)
			{
				castSpelll();
			}
			
			else if(curr4 instanceof LeechingSpell)
			{
				castSpelll();
			}
			
			else if(curr4 instanceof MinionTargetSpell)
			{
				castSpelll();
			}
		}
	}

	public void castSpelll() 
	{
		cas.setVisible(false);
		cas2 = new JPanel();
		cas2.setVisible(true);
		cas2.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		cas2.setLayout(new FlowLayout());
		this.add(cas2,BorderLayout.NORTH);
		chooseTarget = new JTextArea();
		chooseTarget.setPreferredSize(new Dimension(230,50));
		chooseTarget.setText("    Choose your Target");
		chooseTarget.setFont(new Font("Arial", Font.PLAIN, 20));
		chooseTarget.setEditable(false);
		cas2.add(chooseTarget,BorderLayout.NORTH);
		ok = new JButton();
		ok.setVisible(true);
		ok.setPreferredSize(new Dimension(230,50));
		ok.setLayout(new FlowLayout());
		ok.setText("OK");
		ok.setFont(new Font("Arial", Font.PLAIN, 20));
		ok.addActionListener(this);
		cas2.add(ok,BorderLayout.CENTER);
		controller.setattack(true);
	}
	
	public static void performSpelll()
	{
		if(curr4 instanceof Pyroblast)
		{
			if(curr6!=null)
			{
				try
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((HeroTargetSpell)curr4, curr6);
					curr5 = null;
					curr6 = null;
				} 
				catch (NotYourTurnException | NotEnoughManaException e) 
				{
					new messages("\n        " + e.getMessage());
				}
				con2.createField();
			}
			else if(curr5!=null)
			{
				try 
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((MinionTargetSpell)curr4, curr5);
					curr5 = null;
					curr6 = null;
				} 
				catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e) 
				{
					new messages("\n        " + e.getMessage());
				}
				con2.createField();
			}
		}
		
		else if(curr4 instanceof KillCommand)
		{
			if(curr6!=null)
			{
				try
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((HeroTargetSpell)curr4, curr6);
					curr5 = null;
					curr6 = null;
				} 
				catch (NotYourTurnException | NotEnoughManaException e) 
				{
					new messages("\n        " + e.getMessage());
				}
				con2.createField();
			}
			else if(curr5!=null)
			{
				try 
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((MinionTargetSpell)curr4, curr5);
					curr5 = null;
					curr6 = null;
				} 
				catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e) 
				{
					new messages("\n        " + e.getMessage());
				}
				con2.createField();
			}
		}
		
		else if(curr4 instanceof HeroTargetSpell)
		{
			
			try 
			{
				if(curr6!=null)
				{
				twoo.setVisible(false);
				threee.setVisible(false);
				end3.setVisible(false);
				curr3.castSpell((HeroTargetSpell)curr4, curr6);
				curr5 = null;
				curr6 = null;
				}
				else
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					new messages("\n                    Invalid Action");
				}
			} 
			
			catch (NotYourTurnException | NotEnoughManaException e) 
			{
				new messages("\n        " + e.getMessage());
			}
			con2.createField();
		}
		
		else if(curr4 instanceof LeechingSpell)
		{
			
			try
			{
				if(curr5!=null)
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((LeechingSpell)curr4, curr5);
					curr5 = null;
					curr6 = null;
				}
				else
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					new messages("\n                    Invalid Action");
				}
			} 
			catch (NotYourTurnException | NotEnoughManaException e) 
			{
				new messages("\n        " + e.getMessage());
			}
			con2.createField();
		}
		
		else if(curr4 instanceof MinionTargetSpell)
		{
			try 
			{
				if(curr5!=null)
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					curr3.castSpell((MinionTargetSpell)curr4, curr5);
					curr5 = null;
					curr6 = null;
				}
				else
				{
					twoo.setVisible(false);
					threee.setVisible(false);
					end3.setVisible(false);
					new messages("\n                    Invalid Action");
				}
			} 
			catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e) 
			{
				new messages("\n        " + e.getMessage());
			}
			con2.createField();
		}
	}
	

	public void setCurr3(Hero currentHero) 
	{
		curr3 = currentHero;
	}

	public void setopp(Hero opponent) 
	{
		opp = opponent;
	}

	public void setCurr4(Spell spell) 
	{
		curr4 = spell;
	}

	public void setCon2(controller controller) 
	{
		con2 = controller;
	}

	public void settwoo(JPanel two) 
	{
		twoo = two;
	}

	public void setthreee(JPanel three) 
	{
		threee = three;
	}

	public void setend2(JPanel endTurnButton) 
	{
		end3 = endTurnButton;
	}

	public static void setMinioncard(Minion minion) 
	{
		curr5 = minion;
	}

	public static void setHeroCard(Hero currentHero) 
	{
		curr6 = currentHero;
	}
	
	

}
