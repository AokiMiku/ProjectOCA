package models;

public class SchachModel implements ISchachModel
{
	SchachSpieler spielerWeiss;
	SchachSpieler spielerSchwarz;

	@Override
	public SchachSpieler getSpielerWeiss()
	{
		return this.spielerWeiss;
	}

	@Override
	public SchachSpieler getSpielerSchwarz()
	{
		return this.spielerSchwarz;
	}

	@Override
	public void schlageFigur(SchachFigur meine, SchachFigur gegner)
	{
		gegner.schlageFigur();
	}

	public SchachModel()
	{
		this.neuesSpiel();
	}

	@Override
	public void neuesSpiel()
	{
		this.spielerWeiss = new SchachSpieler(SchachTeam.WEISS);
		this.spielerSchwarz = new SchachSpieler(SchachTeam.SCHWARZ);
	}
}
