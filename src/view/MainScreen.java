package view;
import javax.swing.*;

public class MainScreen extends JFrame
{
	
	public MainScreen()
	{
		super();
		this.setBounds(100,30, 1300, 790);
		this.setVisible(true);
		this.setTitle("HearthStone");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.revalidate();
		this.repaint();
	}

	

}
