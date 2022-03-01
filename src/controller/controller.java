package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import engine.GameListener;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.minions.Minion;
import model.cards.spells.Spell;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;
import view.MainScreen;

public class controller implements ActionListener, GameListener{
	private Game model;
	private MainScreen view;
	private JPanel one;
	private JTextArea text;
	private ArrayList<JButton> buttons;
	private Hero temp1;
	private Hero temp2;
	private Boolean playerOneChose;
	private JPanel two;
	private JPanel BottomTwo;
	private JPanel CenterTwo;
	private JPanel TopTwo;
	private JPanel three;
	private JPanel BottomThree;
	private JPanel CenterThree;
	private JPanel TopThree;
	private JButton end;
	private JPanel endTurnButton;
	private JPanel endGame;
	private ArrayList<JButton> buttons1;
	private ArrayList<JButton> buttons2;
	private ArrayList<JButton> buttons3;
	private ArrayList<JButton> buttons4;
	private JButton handCards1;
	private static Boolean attack;
	private static Boolean attack2;
	private static Boolean attack3;
	
	public controller()
	{
		view = new MainScreen();
		one = new JPanel();
		one.setPreferredSize(new Dimension(view.getWidth(),view.getHeight()));
		one.setLayout(new FlowLayout());
		buttons = new ArrayList<JButton>();
		text = new JTextArea();
		playerOneChose = false;
		two = new JPanel();
		three = new JPanel();
		endGame = new JPanel();
		attack = false;
		attack2 = false;
		attack3 = false;
		chooseHero();	
		view.revalidate();
		view.repaint();
	}
	public void chooseHero() 
	{
		endGame.setVisible(false);
		one = new JPanel();
		one.setVisible(true);
		playerOneChose = false;
		text.setPreferredSize(new Dimension(250,250));
		text.setText("\n\n\n\n\n\n\n                                                                                                             Player 1");
		text.setFont(new Font("Arial", Font.PLAIN, 20));
		text.setEditable(false);
		view.add(text,BorderLayout.NORTH);
		view.add(one,BorderLayout.CENTER);
		JButton hun = new JButton();
		hun.setName("Hunter");
		hun.setFont(new Font("Arial", Font.PLAIN, 20));
		hun.addActionListener(this);
		buttons.add(hun);
		hun.setText("Hunter");
		hun.setPreferredSize(new Dimension(200,290));
		one.add(hun);
		JButton war = new JButton();
		war.setName("Warlock");
		war.setFont(new Font("Arial", Font.PLAIN, 20));
		war.addActionListener(this);
		buttons.add(war);
		war.setText("Warlock");
		war.setPreferredSize(new Dimension(200,290));
		one.add(war);
		JButton pri = new JButton();
		pri.setName("Priest");
		pri.setFont(new Font("Arial", Font.PLAIN, 20));
		pri.addActionListener(this);
		buttons.add(pri);
		pri.setText("Priest");
		pri.setPreferredSize(new Dimension(200,290));
		one.add(pri);
		JButton pal = new JButton();
		pal.setName("Paladin");
		pal.setFont(new Font("Arial", Font.PLAIN, 20));
		pal.addActionListener(this);
		buttons.add(pal);
		pal.setText("Paladin");
		pal.setPreferredSize(new Dimension(200,290));
		one.add(pal);
		JButton mag = new JButton();
		mag.setName("Mage");
		mag.setFont(new Font("Arial", Font.PLAIN, 20));
		mag.addActionListener(this);
		buttons.add(mag);
		mag.setText("Mage");
		mag.setPreferredSize(new Dimension(200,290));
		one.add(mag);
	}
	
	public void onGameOver() 
	{
		two.setVisible(false);
		three.setVisible(false);
		endTurnButton.setVisible(false);
		endGame = new JPanel();
		endGame.setVisible(true);
		text.setVisible(true);
		view.add(text,BorderLayout.NORTH);
		if(temp1.getCurrentHP()<=0)
		{
			text.setText("\n\n\n\n\n\n\n                                                                                                        Player 2 won");
		}
		else if(temp2.getCurrentHP()<=0)
		{
			text.setText("\n\n\n\n\n\n\n                                                                                                        Player 1 won");
		}
		endGame.setPreferredSize(new Dimension(view.getWidth(),view.getHeight()));
		endGame.setLayout(new FlowLayout());
		view.add(endGame,BorderLayout.CENTER);
		JButton startNewGame = new JButton();
		startNewGame.setName("Start");
		startNewGame.setFont(new Font("Arial", Font.PLAIN, 15));
		startNewGame.addActionListener(this);
		startNewGame.setText("Start a New Game");
		startNewGame.setPreferredSize(new Dimension(170,170));
		endGame.add(startNewGame);
		JButton exit = new JButton();
		exit.setName("Exit");
		exit.setFont(new Font("Arial", Font.PLAIN, 15));
		exit.addActionListener(this);
		exit.setText("Exit");
		exit.setPreferredSize(new Dimension(170,170));
		endGame.add(exit);
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton selectedButton = (JButton) e.getSource();
		
		if(attack3 == true)
		{
			if(selectedButton.getName().equals("End Turn"))
			{
				new messages("Please choose a Target");
				attack2 = false;
				attack = false;
			}
			
			else if(selectedButton.getName().equals("HeroPower"))
			{
				new messages("Cannot do that. Choose another \ntarget.");
				attack2 = false;
				attack = false;
			}
			
			else if(selectedButton.getName().equals("playerHand"))
			{
				new messages("You can not use Hero Power \n on your Hand. Choose another \ntarget.");
				attack2 = false;
				attack = false;
			}
			
			else if(selectedButton.getName().equals("playerHand2"))
			{
				new messages("You can not use Hero Power \non your Opponent's Hand. \nChoose another target.");
				attack2 = false;
				attack = false;
			}
			
			else if(selectedButton.getName().equals("playerField"))
			{
				int index7 = buttons2.indexOf(selectedButton);
				attackUsingHeroPower.goPower((Minion)model.getCurrentHero().getField().get(index7));
			}
			
			else if(selectedButton.getName().equals("playerField2"))
			{
				int index8 = buttons4.indexOf(selectedButton);
				attackUsingHeroPower.goPower((Minion)model.getOpponent().getField().get(index8));
			}
			
			else if(selectedButton.getName().equals("HeroName"))
			{
				attackUsingHeroPower.goPower(model.getCurrentHero());
			}
			
			else if(selectedButton.getName().equals("HeroName2"))
			{
				attackUsingHeroPower.goPower(model.getOpponent());
			}
		}
		
		else if(attack2 == true)
		{
			if(selectedButton.getName().equals("End Turn"))
			{
				new messages("Please choose a Target");
				attack = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("HeroPower"))
			{
				new messages("Cannot do that. Choose another \ntarget.");
				attack = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("playerHand"))
			{
				new messages("Cannot attack on your Hand. \nPlease choose another Target.");
				attack = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("playerHand2"))
			{
				new messages("You can not attack a minion that your \nOpponent has not summoned yet.");
				attack = false;
				attack2 = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("playerField"))
			{
				int index5 = buttons2.indexOf(selectedButton);
				attackUsingMinion.setCurr9((Minion)model.getCurrentHero().getField().get(index5));
				attackUsingMinion.attMinion();
			}
			
			else if(selectedButton.getName().equals("playerField2"))
			{
				int index6 = buttons4.indexOf(selectedButton);
				attackUsingMinion.setCurr9((Minion)model.getOpponent().getField().get(index6));
				attackUsingMinion.attMinion();
			}
			
			else if(selectedButton.getName().equals("HeroName"))
			{
				attackUsingMinion.setopp2(model.getCurrentHero());
				attackUsingMinion.attMinion2();
			}
			
			else if(selectedButton.getName().equals("HeroName2"))
			{
				attackUsingMinion.setopp2(model.getOpponent());
				attackUsingMinion.attMinion2();
			}
		}
		
		else if(attack == true)
		{
			if(selectedButton.getName().equals("End Turn"))
			{
				new messages("Please choose a Target");
				attack2 = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("HeroPower"))
			{
				new messages("Cannot do that. Choose another \ntarget.");
				attack2 = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("playerHand"))
			{
				new messages("You cannot cast a spell on a your Hand. \nChoose another target.");
				attack2 = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("playerHand2"))
			{
				new messages("You cannot cast a spell on your \nOpponent's Hand. Choose another \ntarget.");
				attack2 = false;
				attack3 = false;
			}
			
			else if(selectedButton.getName().equals("HeroName"))
			{
				cast.setHeroCard((Hero)model.getCurrentHero());
				cast.performSpelll();
			}
			
			else if(selectedButton.getName().equals("HeroName2"))
			{
				cast.setHeroCard((Hero)model.getOpponent());
				cast.performSpelll();
			}
			
			else if(selectedButton.getName().equals("playerField"))
			{
				int index2 = buttons2.indexOf(selectedButton);
				cast.setMinioncard((Minion)model.getCurrentHero().getField().get(index2));
				cast.performSpelll();
			}
			
			else if(selectedButton.getName().equals("playerField2"))
			{
				int index2 = buttons4.indexOf(selectedButton);
				cast.setMinioncard((Minion)model.getOpponent().getField().get(index2));
				cast.performSpelll();
			}
			
		}
		
		else if(selectedButton.getName().equals("HeroPower"))
		{
			if(model.getCurrentHero() instanceof Hunter)
			{
				try 
				{
					two.setVisible(false);
					three.setVisible(false);
					endTurnButton.setVisible(false);
					model.getCurrentHero().useHeroPower();
				} 
				catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException| FullHandException | FullFieldException | CloneNotSupportedException e1)
				{
					new messages(e1.getMessage());
					if(e1 instanceof FullHandException)
					{
						new burntCard(((FullHandException) e1).getBurned());
					}
				}
				createField();
			}
			
			else if(model.getCurrentHero() instanceof Mage)
			{
				attackUsingHeroPower card4 = new attackUsingHeroPower();
				card4.setCurr10(model.getCurrentHero());
				card4.setCon4(this);
				card4.settwoooo(two);
				card4.setthreeeee(three);
				card4.setend5(endTurnButton);
			}
			
			else if(model.getCurrentHero() instanceof Paladin)
			{
				try 
				{
					two.setVisible(false);
					three.setVisible(false);
					endTurnButton.setVisible(false);
					model.getCurrentHero().useHeroPower();
				} 
				catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException| FullHandException | FullFieldException | CloneNotSupportedException e1)
				{
					new messages(e1.getMessage());
					if(e1 instanceof FullHandException)
					{
						new burntCard(((FullHandException) e1).getBurned());
					}
				}
				createField();
			}
			
			else if(model.getCurrentHero() instanceof Priest)
			{
				attackUsingHeroPower card4 = new attackUsingHeroPower();
				card4.setCurr10(model.getCurrentHero());
				card4.setCon4(this);
				card4.settwoooo(two);
				card4.setthreeeee(three);
				card4.setend5(endTurnButton);
			}
			
			else if(model.getCurrentHero() instanceof Warlock)
			{
				try 
				{
					two.setVisible(false);
					three.setVisible(false);
					endTurnButton.setVisible(false);
					model.getCurrentHero().useHeroPower();
				} 
				catch (NotEnoughManaException | HeroPowerAlreadyUsedException | NotYourTurnException| FullHandException | FullFieldException | CloneNotSupportedException e1) 
				{
					new messages(e1.getMessage());
					if(e1 instanceof FullHandException)
					{
						new burntCard(((FullHandException) e1).getBurned());
					}
				}
				createField();
			}
		}
		
		else if(selectedButton.getName().equals("playerHand2"))
		{
			new messages("You can not do any action in your \nOpponent's turn");
			attack = false;
			attack2 = false;
			attack3 = false;
		}
		
		else if(selectedButton.getName().equals("HeroName"))
		{
			
		}
		
		else if(selectedButton.getName().equals("HeroName2"))
		{
			
		}
		
		else if(selectedButton.getName().equals("playerField"))
		{
			int index3 = buttons2.indexOf(selectedButton);
			attackUsingMinion card3 = new attackUsingMinion();
			card3.setCurr7(model.getCurrentHero());
			card3.setCurr8((Minion)model.getCurrentHero().getField().get(index3));
			card3.setCon3(this);
			card3.settwooo(two);
			card3.setthreeee(three);
			card3.setend4(endTurnButton);
		}
		
		else if(selectedButton.getName().equals("playerField2"))
		{
			new messages("You can not do any action in your \nOpponent's turn");
			attack = false;
			attack2 = false;
			attack3 = false;
		}
		
		else if(selectedButton.getName().equals("playerHand"))
		{
			int index1 = buttons1.indexOf(selectedButton);
			if(model.getCurrentHero().getHand().get(index1) instanceof Minion)
			{
				summon card = new summon();
				card.setCurr(model.getCurrentHero());
				card.setCurr2((Minion)model.getCurrentHero().getHand().get(index1));
				card.setCon(this);
				card.settwo(two);
				card.setthree(three);
				card.setend(endTurnButton);
			}
			else if(model.getCurrentHero().getHand().get(index1) instanceof Spell)
			{
				cast card2 = new cast();
				card2.setCurr3(model.getCurrentHero());
				card2.setopp(model.getOpponent());
				card2.setCurr4((Spell)model.getCurrentHero().getHand().get(index1));
				card2.setCon2(this);
				card2.settwoo(two);
				card2.setthreee(three);
				card2.setend2(endTurnButton);
			}
		}
		
		else if(selectedButton.getText().equals("Start a New Game"))
		{
			chooseHero();
		}
		
		else if(selectedButton.getText().equals("Exit"))
		{
			view.setVisible(false);
			System.exit(0);
		}
		else if(selectedButton.getText().equals("END TURN"))
		{
			try 
			{
				two.setVisible(false);
				three.setVisible(false);
				endTurnButton.setVisible(false);
				model.endTurn();
				createField();
			} 
			catch (FullHandException | CloneNotSupportedException e1) 
			{
				new messages(e1.getMessage());
				if(e1 instanceof FullHandException)
				{
					new burntCard(((FullHandException) e1).getBurned());
				}
				createField();
			}
		}
		
		else 
		{
			if(playerOneChose==false)
			{
			int index = buttons.indexOf(selectedButton);
			try 
			{
				temp1 = CreateHeroSelected(index);
				text.setText("\n\n\n\n\n\n\n                                                                                                             Player 2");
			} 
			catch (FullHandException | IOException | CloneNotSupportedException e1) 
			{
				e1.printStackTrace();
				if(e1 instanceof FullHandException)
				{
					new burntCard(((FullHandException) e1).getBurned());
				}
			}				
			}
			else
			{
				int index = buttons.indexOf(selectedButton);
				try 
				{
					temp2 = CreateHeroSelected(index);
					createGame(temp1,temp2);
				} 
				catch (FullHandException | IOException | CloneNotSupportedException e1) 
				{
					e1.printStackTrace();
					if(e1 instanceof FullHandException)
					{
						new burntCard(((FullHandException) e1).getBurned());
					}
				}
			}
		}
		
	}
	
	public Hero CreateHeroSelected(int index) throws IOException, CloneNotSupportedException, FullHandException 
	{
			if(buttons.get(index).getText().equals("Hunter"))
			{
				Hunter hunter = new Hunter();
				playerOneChose = true;
				return hunter;
			}
			else if(buttons.get(index).getText().equals("Warlock"))
			{
				Warlock warlock = new Warlock();
				playerOneChose = true;
				return warlock;
			}
			else if(buttons.get(index).getText().equals("Priest"))
			{
				Priest priest = new Priest();
				playerOneChose = true;
				return priest;
			}
			else if(buttons.get(index).getText().equals("Paladin"))
			{
				Paladin paladin = new Paladin();
				playerOneChose = true;
				return paladin;
			}
			else
			{
				Mage mage = new Mage();
				playerOneChose = true;
				return mage;
			}
	}
	
	public void createGame(Hero temp1,Hero temp2) throws FullHandException, CloneNotSupportedException
	{
		one.setVisible(false);
		text.setVisible(false);
		model = new Game(temp1,temp2);
		model.setListener(this);
		createField();
	}
	
	public void createField()
	{
		attack3 = false;
		attack2 = false;
		attack = false;
		
		if(temp1.getCurrentHP()<=0)
		{
			two.setVisible(false);
			three.setVisible(false);
			endTurnButton.setVisible(false);
		}
		else if(temp2.getCurrentHP()<=0)
		{
			two.setVisible(false);
			three.setVisible(false);
			endTurnButton.setVisible(false);
		}
		else
		{
		two = new JPanel();
		two.setLayout(new BorderLayout());
		two.setPreferredSize(new Dimension(100,360));
		view.add(two,BorderLayout.SOUTH);
//BOTTOM
		BottomTwo = new JPanel();
		BottomTwo.setLayout(new FlowLayout());
		BottomTwo.setPreferredSize(new Dimension(100,70));
		JTextArea deck1 = new JTextArea();
		deck1.setPreferredSize(new Dimension(200,60));
		deck1.setText("\nDECK = "+model.getCurrentHero().getDeck().size());
		deck1.setFont(new Font("Arial", Font.PLAIN, 16));
		deck1.setEditable(false);
		BottomTwo.add(deck1);
		JButton useHeroPowerButton = new JButton();
		useHeroPowerButton.setName("HeroPower");
		useHeroPowerButton.addActionListener(this);
		useHeroPowerButton.setText("Use Hero Power");
		useHeroPowerButton.setFont(new Font("Arial", Font.PLAIN, 17));
		useHeroPowerButton.setPreferredSize(new Dimension(200,60));
		BottomTwo.add(useHeroPowerButton);
		JButton player1 = new JButton();
		player1.setName("HeroName");
		player1.addActionListener(this);
		player1.setText(model.getCurrentHero().getName());
		player1.setFont(new Font("Arial", Font.PLAIN, 17));
		player1.setPreferredSize(new Dimension(200,60));
		BottomTwo.add(player1);
		JTextArea currentHP1 = new JTextArea();
		currentHP1.setPreferredSize(new Dimension(90,60));
		currentHP1.setText("\nCurrent HP ="+ model.getCurrentHero().getCurrentHP());
		currentHP1.setFont(new Font("Arial", Font.PLAIN, 13));
		currentHP1.setEditable(false);
		BottomTwo.add(currentHP1);
		JTextArea currentMana1 = new JTextArea();
		currentMana1.setPreferredSize(new Dimension(160,60));
		currentMana1.setText("\nCurrent Mana Crystals = "+ model.getCurrentHero().getCurrentManaCrystals());
		currentMana1.setFont(new Font("Arial", Font.PLAIN, 13));
		currentMana1.setEditable(false);
		BottomTwo.add(currentMana1);
		JTextArea totalmMana1 = new JTextArea();
		totalmMana1.setPreferredSize(new Dimension(145,60));
		totalmMana1.setText("\nTotal Mana Crystals = "+ model.getCurrentHero().getTotalManaCrystals());
		totalmMana1.setFont(new Font("Arial", Font.PLAIN, 13));
		totalmMana1.setEditable(false);
		BottomTwo.add(totalmMana1);
		
		two.add(BottomTwo,BorderLayout.SOUTH);
//CENTER
		CenterTwo = new JPanel();
		CenterTwo.setLayout(new FlowLayout());
		CenterTwo.setPreferredSize(new Dimension(100,145));
		buttons1 = new ArrayList<JButton>();
		for(int i = 0;i<model.getCurrentHero().getHand().size();i++)
		{
			if(model.getCurrentHero().getHand().get(i) instanceof Spell)
			{
				handCards1 = new JButton();
				handCards1.setName("playerHand");
				handCards1.setFont(new Font("Arial", Font.BOLD, 8));
				handCards1.setText("<html>" + model.getCurrentHero().getHand().get(i).getName() + "<br />" + "Mana Cost = " + model.getCurrentHero().getHand().get(i).getManaCost() + "<br />" + "Rarity = " + model.getCurrentHero().getHand().get(i).getRarity() + "</html>");
				handCards1.setPreferredSize(new Dimension(120,140));
				handCards1.addActionListener(this);
				buttons1.add(handCards1);
				CenterTwo.add(handCards1);
			}
			else
			{
				handCards1 = new JButton();
				handCards1.setName("playerHand");
				handCards1.setFont(new Font("Arial", Font.BOLD, 8));
				Minion c = (Minion)model.getCurrentHero().getHand().get(i);
				handCards1.setText("<html>" + model.getCurrentHero().getHand().get(i).getName() + "<br />" + "Mana Cost = " + model.getCurrentHero().getHand().get(i).getManaCost() + "<br />" + "Rarity = " + model.getCurrentHero().getHand().get(i).getRarity() + "<br />" + "Attack = " + c.getAttack() + "<br />" + "Current HP = " + c.getCurrentHP() + "<br />" + "Taunt = " + c.isTaunt() + "<br />" + "Divine = " + c.isDivine() + "<br />" + "Charge = " + !c.isSleeping() +"</html>");
				handCards1.setPreferredSize(new Dimension(120,140));
				handCards1.addActionListener(this);
				buttons1.add(handCards1);
				CenterTwo.add(handCards1);
			}
		}
		two.add(CenterTwo,BorderLayout.CENTER);
//TOP
		TopTwo = new JPanel();
		TopTwo.setLayout(new FlowLayout());
		TopTwo.setPreferredSize(new Dimension(100,145));
		buttons2 = new ArrayList<JButton>();
		for(int i =0;i<model.getCurrentHero().getField().size();i++)
		{
			if(model.getCurrentHero().getField().get(i) instanceof Minion)
			{
				JButton fieldCards1 = new JButton();
				fieldCards1.setFont(new Font("Arial", Font.BOLD, 8));
				fieldCards1.setName("playerField");
				fieldCards1.addActionListener(this);
				Minion c = (Minion)model.getCurrentHero().getField().get(i);
				fieldCards1.setText("<html>" + model.getCurrentHero().getField().get(i).getName() + "<br />" + "Mana Cost = " + model.getCurrentHero().getField().get(i).getManaCost() + "<br />" + "Rarity = " + model.getCurrentHero().getField().get(i).getRarity() + "<br />" + "Attack = " + c.getAttack() + "<br />" + "Current HP = " + c.getCurrentHP() + "<br />" + "Taunt = " + c.isTaunt() + "<br />" + "Divine = " + c.isDivine() + "<br />" + "Charge = " + !c.isSleeping() +"</html>");
				fieldCards1.setPreferredSize(new Dimension(120,140));
				buttons2.add(fieldCards1);
				TopTwo.add(fieldCards1);
			}
			else
			{
				JButton fieldCards1 = new JButton();
				fieldCards1.setFont(new Font("Arial", Font.BOLD, 8));
				fieldCards1.setName("playerField");
				fieldCards1.addActionListener(this);
				fieldCards1.setText("<html>" + model.getCurrentHero().getField().get(i).getName() + "<br />" + "Mana Cost = " + model.getCurrentHero().getField().get(i).getManaCost() + "<br />" + "Rarity = " + model.getCurrentHero().getField().get(i).getRarity() +"</html>");
				fieldCards1.setPreferredSize(new Dimension(120,140));
				buttons2.add(fieldCards1);
				TopTwo.add(fieldCards1);
			}
		}
		two.add(TopTwo,BorderLayout.NORTH);
		
		three = new JPanel();
		three.setLayout(new BorderLayout());
		three.setPreferredSize(new Dimension(100,360));
		view.add(three,BorderLayout.NORTH);
//TOP
		TopThree = new JPanel();
		TopThree.setLayout(new FlowLayout());
		TopThree.setPreferredSize(new Dimension(100,60));
		JTextArea deck2 = new JTextArea();
		deck2.setPreferredSize(new Dimension(400,55));
		deck2.setText("\nDECK = "+model.getOpponent().getDeck().size());
		deck2.setFont(new Font("Arial", Font.PLAIN, 16));
		deck2.setEditable(false);
		TopThree.add(deck2);
		JButton player2 = new JButton();
		player2.setText(model.getOpponent().getName());
		player2.setName("HeroName2");
		player2.addActionListener(this);
		player2.setFont(new Font("Arial", Font.PLAIN, 17));
		player2.setPreferredSize(new Dimension(200,55));
		TopThree.add(player2);
		JTextArea currentHP2 = new JTextArea();
		currentHP2.setPreferredSize(new Dimension(90,55));
		currentHP2.setText("\nCurrent HP ="+ model.getOpponent().getCurrentHP());
		currentHP2.setFont(new Font("Arial", Font.PLAIN, 13));
		currentHP2.setEditable(false);
		TopThree.add(currentHP2);
		JTextArea currentMana2 = new JTextArea();
		currentMana2.setPreferredSize(new Dimension(160,55));
		currentMana2.setText("\nCurrent Mana Crystals = "+ model.getOpponent().getCurrentManaCrystals());
		currentMana2.setFont(new Font("Arial", Font.PLAIN, 13));
		currentMana2.setEditable(false);
		TopThree.add(currentMana2);
		JTextArea totalmMana2 = new JTextArea();
		totalmMana2.setPreferredSize(new Dimension(145,55));
		totalmMana2.setText("\nTotal Mana Crystals = "+ model.getOpponent().getTotalManaCrystals());
		totalmMana2.setFont(new Font("Arial", Font.PLAIN, 13));
		totalmMana2.setEditable(false);
		TopThree.add(totalmMana2);
		three.add(TopThree,BorderLayout.NORTH);
//CENTER
		CenterThree = new JPanel();
		CenterThree.setLayout(new FlowLayout());
		CenterThree.setPreferredSize(new Dimension(100,145));
		buttons3 = new ArrayList<JButton>();
		for(int i = 0;i<model.getOpponent().getHand().size();i++)
		{
			JButton handCards2 = new JButton();
			handCards2.setText("CARD");
			handCards2.setName("playerHand2");
			handCards2.addActionListener(this);
			handCards2.setFont(new Font("Arial", Font.PLAIN, 16));
			handCards2.setPreferredSize(new Dimension(120,140));
			buttons3.add(handCards2);
			CenterThree.add(handCards2);
		}
		three.add(CenterThree,BorderLayout.CENTER);
//BOTTOM
		BottomThree = new JPanel();
		BottomThree.setLayout(new FlowLayout());
		BottomThree.setPreferredSize(new Dimension(100,155));
		buttons4 = new ArrayList<JButton>();
		for(int i =0;i<model.getOpponent().getField().size();i++)
		{
			if(model.getOpponent().getField().get(i) instanceof Minion)
			{
				JButton fieldCards2 = new JButton();
				fieldCards2.setFont(new Font("Arial", Font.BOLD, 8));
				fieldCards2.setName("playerField2");
				fieldCards2.addActionListener(this);
				Minion c = (Minion)model.getOpponent().getField().get(i);
				fieldCards2.setText("<html>" + model.getOpponent().getField().get(i).getName() + "<br />" + "Mana Cost = " + model.getOpponent().getField().get(i).getManaCost() + "<br />" + "Rarity = " + model.getOpponent().getField().get(i).getRarity() + "<br />" + "Attack = " + c.getAttack() + "<br />" + "Current HP = " + c.getCurrentHP() + "<br />" + "Taunt = " + c.isTaunt() + "<br />" + "Divine = " + c.isDivine() + "<br />" + "Charge = " + !c.isSleeping() +"</html>");
				fieldCards2.setPreferredSize(new Dimension(120,140));
				buttons4.add(fieldCards2);
				BottomThree.add(fieldCards2);
			}
			else
			{
				JButton fieldCards2 = new JButton();
				fieldCards2.setFont(new Font("Arial", Font.BOLD, 8));
				fieldCards2.setName("playerField2");
				fieldCards2.addActionListener(this);
				fieldCards2.setText("<html>" + model.getOpponent().getField().get(i).getName() + "<br />" + "Mana Cost = " + model.getOpponent().getField().get(i).getManaCost() + "<br />" + "Rarity = " + model.getOpponent().getField().get(i).getRarity() + "</html>");
				fieldCards2.setPreferredSize(new Dimension(120,140));
				buttons4.add(fieldCards2);
				BottomThree.add(fieldCards2);
			}
		}
		three.add(BottomThree,BorderLayout.SOUTH);
		
		endTurnButton = new JPanel();
		endTurnButton.setLayout(new BorderLayout());
		endTurnButton.setPreferredSize(new Dimension(100,10));
		end = new JButton();
		end.setName("End Turn");
		end.setFont(new Font("Arial", Font.BOLD, 12));
		end.addActionListener(this);
		end.setText("END TURN");
		end.setPreferredSize(new Dimension(70,100));
		endTurnButton.add(end);
		view.add(endTurnButton,BorderLayout.EAST);
		}
	}
	
	public static void main(String[]args)
	{
		new controller();
	}
	public static void setattack(boolean b) 
	{
		attack = b;
	}
	public static void setattack2(boolean b) 
	{
		attack2 = b;
	}
	public static void setattack3(boolean b) 
	{
		attack3 = b;
	}

}
