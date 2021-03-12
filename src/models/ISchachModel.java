package models;

public interface ISchachModel 
{
	SchachSpieler getSpielerWeiss();
	SchachSpieler getSpielerSchwarz();
	
	void schlageFigur(SchachFigur meine, SchachFigur gegner);
	void neuesSpiel();
}