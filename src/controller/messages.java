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

public class messages extends JFrame implements ActionListener
{
	private JPanel mess;
	private JTextArea chooseTarget4;
	private JButton ok4;
	
	public messages(String exc)
	{
		super();
		this.setBounds(620,300, 270, 150);
		this.setVisible(true);
		mess = new JPanel();
		mess.setVisible(true);
		mess.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		mess.setLayout(new FlowLayout());
		this.add(mess,BorderLayout.NORTH);
		chooseTarget4 = new JTextArea();
		chooseTarget4.setPreferredSize(new Dimension(250,50));
		chooseTarget4.setText(exc);
		chooseTarget4.setFont(new Font("Arial", Font.PLAIN, 14));
		chooseTarget4.setEditable(false);
		mess.add(chooseTarget4,BorderLayout.NORTH);
		ok4 = new JButton();
		ok4.setVisible(true);
		ok4.setPreferredSize(new Dimension(250,50));
		ok4.setLayout(new FlowLayout());
		ok4.setText("OK");
		ok4.setFont(new Font("Arial", Font.PLAIN, 20));
		ok4.addActionListener(this);
		mess.add(ok4,BorderLayout.CENTER);
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
}
