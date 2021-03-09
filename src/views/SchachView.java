package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.SchachController;

public class SchachView extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5334413959560661613L;

	private SchachButton fieldA1;
	private SchachButton fieldA2;
	private SchachButton fieldA3;
	private SchachButton fieldA4;
	private SchachButton fieldA5;
	private SchachButton fieldA6;
	private SchachButton fieldA7;
	private SchachButton fieldA8;
	private SchachButton fieldB1;
	private SchachButton fieldB2;
	private SchachButton fieldB3;
	private SchachButton fieldB4;
	private SchachButton fieldB5;
	private SchachButton fieldB6;
	private SchachButton fieldB7;
	private SchachButton fieldB8;
	private SchachButton fieldC1;
	private SchachButton fieldC2;
	private SchachButton fieldC3;
	private SchachButton fieldC4;
	private SchachButton fieldC5;
	private SchachButton fieldC6;
	private SchachButton fieldC7;
	private SchachButton fieldC8;
	private SchachButton fieldD1;
	private SchachButton fieldD2;
	private SchachButton fieldD3;
	private SchachButton fieldD4;
	private SchachButton fieldD5;
	private SchachButton fieldD6;
	private SchachButton fieldD7;
	private SchachButton fieldD8;
	private SchachButton fieldE1;
	private SchachButton fieldE2;
	private SchachButton fieldE3;
	private SchachButton fieldE4;
	private SchachButton fieldE5;
	private SchachButton fieldE6;
	private SchachButton fieldE7;
	private SchachButton fieldE8;
	private SchachButton fieldF1;
	private SchachButton fieldF2;
	private SchachButton fieldF3;
	private SchachButton fieldF4;
	private SchachButton fieldF5;
	private SchachButton fieldF6;
	private SchachButton fieldF7;
	private SchachButton fieldF8;
	private SchachButton fieldG1;
	private SchachButton fieldG2;
	private SchachButton fieldG3;
	private SchachButton fieldG4;
	private SchachButton fieldG5;
	private SchachButton fieldG6;
	private SchachButton fieldG7;
	private SchachButton fieldG8;
	private SchachButton fieldH1;
	private SchachButton fieldH2;
	private SchachButton fieldH3;
	private SchachButton fieldH4;
	private SchachButton fieldH5;
	private SchachButton fieldH6;
	private SchachButton fieldH7;
	private SchachButton fieldH8;

	public SchachButton getFieldA1()
	{
		return fieldA1;
	}
	public SchachButton getFieldA2()
	{
		return fieldA2;
	}
	public SchachButton getFieldA3()
	{
		return fieldA3;
	}
	public SchachButton getFieldA4()
	{
		return fieldA4;
	}
	public SchachButton getFieldA5()
	{
		return fieldA5;
	}
	public SchachButton getFieldA6()
	{
		return fieldA6;
	}
	public SchachButton getFieldA7()
	{
		return fieldA7;
	}
	public SchachButton getFieldA8()
	{
		return fieldA8;
	}
	public SchachButton getFieldB1()
	{
		return fieldB1;
	}
	public SchachButton getFieldB2()
	{
		return fieldB2;
	}
	public SchachButton getFieldB3()
	{
		return fieldB3;
	}
	public SchachButton getFieldB4()
	{
		return fieldB4;
	}
	public SchachButton getFieldB5()
	{
		return fieldB5;
	}
	public SchachButton getFieldB6()
	{
		return fieldB6;
	}
	public SchachButton getFieldB7()
	{
		return fieldB7;
	}
	public SchachButton getFieldB8()
	{
		return fieldB8;
	}
	public SchachButton getFieldC1()
	{
		return fieldC1;
	}
	public SchachButton getFieldC2()
	{
		return fieldC2;
	}
	public SchachButton getFieldC3()
	{
		return fieldC3;
	}
	public SchachButton getFieldC4()
	{
		return fieldC4;
	}
	public SchachButton getFieldC5()
	{
		return fieldC5;
	}
	public SchachButton getFieldC6()
	{
		return fieldC6;
	}
	public SchachButton getFieldC7()
	{
		return fieldC7;
	}
	public SchachButton getFieldC8()
	{
		return fieldC8;
	}
	public SchachButton getFieldD1()
	{
		return fieldD1;
	}
	public SchachButton getFieldD2()
	{
		return fieldD2;
	}
	public SchachButton getFieldD3()
	{
		return fieldD3;
	}
	public SchachButton getFieldD4()
	{
		return fieldD4;
	}
	public SchachButton getFieldD5()
	{
		return fieldD5;
	}
	public SchachButton getFieldD6()
	{
		return fieldD6;
	}
	public SchachButton getFieldD7()
	{
		return fieldD7;
	}
	public SchachButton getFieldD8()
	{
		return fieldD8;
	}
	public SchachButton getFieldE1()
	{
		return fieldE1;
	}
	public SchachButton getFieldE2()
	{
		return fieldE2;
	}
	public SchachButton getFieldE3()
	{
		return fieldE3;
	}
	public SchachButton getFieldE4()
	{
		return fieldE4;
	}
	public SchachButton getFieldE5()
	{
		return fieldE5;
	}
	public SchachButton getFieldE6()
	{
		return fieldE6;
	}
	public SchachButton getFieldE7()
	{
		return fieldE7;
	}
	public SchachButton getFieldE8()
	{
		return fieldE8;
	}
	public SchachButton getFieldF1()
	{
		return fieldF1;
	}
	public SchachButton getFieldF2()
	{
		return fieldF2;
	}
	public SchachButton getFieldF3()
	{
		return fieldF3;
	}
	public SchachButton getFieldF4()
	{
		return fieldF4;
	}
	public SchachButton getFieldF5()
	{
		return fieldF5;
	}
	public SchachButton getFieldF6()
	{
		return fieldF6;
	}
	public SchachButton getFieldF7()
	{
		return fieldF7;
	}
	public SchachButton getFieldF8()
	{
		return fieldF8;
	}
	public SchachButton getFieldG1()
	{
		return fieldG1;
	}
	public SchachButton getFieldG2()
	{
		return fieldG2;
	}
	public SchachButton getFieldG3()
	{
		return fieldG3;
	}
	public SchachButton getFieldG4()
	{
		return fieldG4;
	}
	public SchachButton getFieldG5()
	{
		return fieldG5;
	}
	public SchachButton getFieldG6()
	{
		return fieldG6;
	}
	public SchachButton getFieldG7()
	{
		return fieldG7;
	}
	public SchachButton getFieldG8()
	{
		return fieldG8;
	}
	public SchachButton getFieldH1()
	{
		return fieldH1;
	}
	public SchachButton getFieldH2()
	{
		return fieldH2;
	}
	public SchachButton getFieldH3()
	{
		return fieldH3;
	}
	public SchachButton getFieldH4()
	{
		return fieldH4;
	}
	public SchachButton getFieldH5()
	{
		return fieldH5;
	}
	public SchachButton getFieldH6()
	{
		return fieldH6;
	}
	public SchachButton getFieldH7()
	{
		return fieldH7;
	}
	public SchachButton getFieldH8()
	{
		return fieldH8;
	}
	
	public ArrayList<SchachButton> getFields()
	{
		return this.fields;
	}

	private SchachController controller;
	private ArrayList<SchachButton> fields;
	private JButton[][] spielBrett;
	private JPanel pnlBoard;
	private JPanel pnlGame;

	private Color black;
	private Color white;
	private Font fontForButtons; 

	public SchachView()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.initComponents();
		this.addComponents();
		this.styleComponents();
		this.setVisible(true);
	}

	private void initComponents()
	{
		this.pnlBoard = new JPanel(new GridLayout(8, 8, 2, 2));
		this.pnlGame = new JPanel();
		
		this.fontForButtons = new Font("DejaVu Sans", Font.BOLD, 48);

		this.fieldA1 = new SchachButton('a', 1);
		this.fieldA2 = new SchachButton('a', 2);
		this.fieldA3 = new SchachButton('a', 3);
		this.fieldA4 = new SchachButton('a', 4);
		this.fieldA5 = new SchachButton('a', 5);
		this.fieldA6 = new SchachButton('a', 6);
		this.fieldA7 = new SchachButton('a', 7);
		this.fieldA8 = new SchachButton('a', 8);
		this.fieldB1 = new SchachButton('b', 1);
		this.fieldB2 = new SchachButton('b', 2);
		this.fieldB3 = new SchachButton('b', 3);
		this.fieldB4 = new SchachButton('b', 4);
		this.fieldB5 = new SchachButton('b', 5);
		this.fieldB6 = new SchachButton('b', 6);
		this.fieldB7 = new SchachButton('b', 7);
		this.fieldB8 = new SchachButton('b', 8);
		this.fieldC1 = new SchachButton('c', 1);
		this.fieldC2 = new SchachButton('c', 2);
		this.fieldC3 = new SchachButton('c', 3);
		this.fieldC4 = new SchachButton('c', 4);
		this.fieldC5 = new SchachButton('c', 5);
		this.fieldC6 = new SchachButton('c', 6);
		this.fieldC7 = new SchachButton('c', 7);
		this.fieldC8 = new SchachButton('c', 8);
		this.fieldD1 = new SchachButton('d', 1);
		this.fieldD2 = new SchachButton('d', 2);
		this.fieldD3 = new SchachButton('d', 3);
		this.fieldD4 = new SchachButton('d', 4);
		this.fieldD5 = new SchachButton('d', 5);
		this.fieldD6 = new SchachButton('d', 6);
		this.fieldD7 = new SchachButton('d', 7);
		this.fieldD8 = new SchachButton('d', 8);
		this.fieldE1 = new SchachButton('e', 1);
		this.fieldE2 = new SchachButton('e', 2);
		this.fieldE3 = new SchachButton('e', 3);
		this.fieldE4 = new SchachButton('e', 4);
		this.fieldE5 = new SchachButton('e', 5);
		this.fieldE6 = new SchachButton('e', 6);
		this.fieldE7 = new SchachButton('e', 7);
		this.fieldE8 = new SchachButton('e', 8);
		this.fieldF1 = new SchachButton('f', 1);
		this.fieldF2 = new SchachButton('f', 2);
		this.fieldF3 = new SchachButton('f', 3);
		this.fieldF4 = new SchachButton('f', 4);
		this.fieldF5 = new SchachButton('f', 5);
		this.fieldF6 = new SchachButton('f', 6);
		this.fieldF7 = new SchachButton('f', 7);
		this.fieldF8 = new SchachButton('f', 8);
		this.fieldG1 = new SchachButton('g', 1);
		this.fieldG2 = new SchachButton('g', 2);
		this.fieldG3 = new SchachButton('g', 3);
		this.fieldG4 = new SchachButton('g', 4);
		this.fieldG5 = new SchachButton('g', 5);
		this.fieldG6 = new SchachButton('g', 6);
		this.fieldG7 = new SchachButton('g', 7);
		this.fieldG8 = new SchachButton('g', 8);
		this.fieldH1 = new SchachButton('h', 1);
		this.fieldH2 = new SchachButton('h', 2);
		this.fieldH3 = new SchachButton('h', 3);
		this.fieldH4 = new SchachButton('h', 4);
		this.fieldH5 = new SchachButton('h', 5);
		this.fieldH6 = new SchachButton('h', 6);
		this.fieldH7 = new SchachButton('h', 7);
		this.fieldH8 = new SchachButton('h', 8);

		this.fields = new ArrayList<SchachButton>();
		this.controller = new SchachController(this);
		
		this.fields.add(fieldA1);
		this.fields.add(fieldA2);
		this.fields.add(fieldA3);
		this.fields.add(fieldA4);
		this.fields.add(fieldA5);
		this.fields.add(fieldA6);
		this.fields.add(fieldA7);
		this.fields.add(fieldA8);

		this.fields.add(fieldB1);
		this.fields.add(fieldB2);
		this.fields.add(fieldB3);
		this.fields.add(fieldB4);
		this.fields.add(fieldB5);
		this.fields.add(fieldB6);
		this.fields.add(fieldB7);
		this.fields.add(fieldB8);

		this.fields.add(fieldC1);
		this.fields.add(fieldC2);
		this.fields.add(fieldC3);
		this.fields.add(fieldC4);
		this.fields.add(fieldC5);
		this.fields.add(fieldC6);
		this.fields.add(fieldC7);
		this.fields.add(fieldC8);

		this.fields.add(fieldD1);
		this.fields.add(fieldD2);
		this.fields.add(fieldD3);
		this.fields.add(fieldD4);
		this.fields.add(fieldD5);
		this.fields.add(fieldD6);
		this.fields.add(fieldD7);
		this.fields.add(fieldD8);

		this.fields.add(fieldE1);
		this.fields.add(fieldE2);
		this.fields.add(fieldE3);
		this.fields.add(fieldE4);
		this.fields.add(fieldE5);
		this.fields.add(fieldE6);
		this.fields.add(fieldE7);
		this.fields.add(fieldE8);

		this.fields.add(fieldF1);
		this.fields.add(fieldF2);
		this.fields.add(fieldF3);
		this.fields.add(fieldF4);
		this.fields.add(fieldF5);
		this.fields.add(fieldF6);
		this.fields.add(fieldF7);
		this.fields.add(fieldF8);

		this.fields.add(fieldG1);
		this.fields.add(fieldG2);
		this.fields.add(fieldG3);
		this.fields.add(fieldG4);
		this.fields.add(fieldG5);
		this.fields.add(fieldG6);
		this.fields.add(fieldG7);
		this.fields.add(fieldG8);

		this.fields.add(fieldH1);
		this.fields.add(fieldH2);
		this.fields.add(fieldH3);
		this.fields.add(fieldH4);
		this.fields.add(fieldH5);
		this.fields.add(fieldH6);
		this.fields.add(fieldH7);
		this.fields.add(fieldH8);

		for (int i = 0; i < this.fields.size(); i++)
		{
			this.fields.get(i).addActionListener(this.controller);
			this.fields.get(i).setFont(this.fontForButtons);
		}

		this.spielBrett = new JButton[8][8];
		int idx = 0;
		for (int i = 0; i < this.spielBrett.length; i++)
		{
			for (int j = 0; j < this.spielBrett[i].length; j++)
			{
				this.spielBrett[i][j] = this.fields.get(idx++);
			}
		}

		this.black = new Color(108, 80, 80);
		this.white = new Color(200, 200, 200);
	}

	private void addComponents()
	{
		for (JButton jButton : this.fields)
		{
			this.pnlBoard.add(jButton);
		}
		this.pnlGame.add(this.pnlBoard);

		this.setContentPane(this.pnlGame);
	}

	private void styleComponents()
	{
		for (JButton jButton : this.fields)
		{
			jButton.setPreferredSize(new Dimension(80, 80));
			jButton.setBorder(null);
			jButton.setFocusable(false);
		}

		for (int i = 0; i < this.spielBrett.length; i++) // rows
		{
			for (int j = 0; j < this.spielBrett[i].length; j++) // columns
			{
				if (i % 2 == 0)
				{
					if (j % 2 == 0)
					{
						this.spielBrett[i][j].setBackground(this.black);
					} 
					else
					{
						this.spielBrett[i][j].setBackground(this.white);
					}
				} 
				else
				{
					if (j % 2 == 1)
					{
						this.spielBrett[i][j].setBackground(this.black);
					} 
					else
					{
						this.spielBrett[i][j].setBackground(this.white);
					}
				}
			}
		}
	}
}