package views;

import javax.swing.JButton;

public class SchachButton extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6399607304184809536L;
	
	private char column;
	private int row;
	private Object figurAufFeld;
	
	public char getColumn() 
	{
		return column;
	}
	
	public void setColumn(char column) 
	{
		this.column = column;
	}
	
	public int getRow() 
	{
		return row;
	}
	
	public void setRow(int row) 
	{
		this.row = row;
	}
	
	public Object getFigurAufFeld()
	{
		return this.figurAufFeld;
	}
	
	public void setFigurAufFeld(Object figurAufFeld)
	{
		this.figurAufFeld = figurAufFeld; 
		if (figurAufFeld != null)
		{
			this.setText(figurAufFeld.toString());
		}
		else
		{
			this.setText("");
		}
	}
	
	public String getPosition()
	{
		return this.getColumn() + "" + this.getRow();
	}
	
	public SchachButton(char column, int row)
	{
		this.setColumn(column);
		this.setRow(row);
	}
	
	@Override
	public String toString() 
	{
		if (this.figurAufFeld != null)
		{
			return this.getPosition() + " " + this.figurAufFeld.toString();
		}
		else
		{
			return this.getPosition();
		}
	}
}