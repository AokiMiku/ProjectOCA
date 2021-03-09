package models;

import java.util.Arrays;

public class SchachSpieler
{
	SchachTeam team;
	SchachFigur[] figuren;
	
	public SchachSpieler(SchachTeam team)
	{
		this.team = team;
		this.figuren = SchachFigur.getFiguren(team);
	}
	
	public SchachFigur[] getFiguren(FigurArt art)
	{
		return Arrays.stream(this.figuren).filter(f -> f.getArt().equals(art)).toArray(SchachFigur[]::new);
	}
}