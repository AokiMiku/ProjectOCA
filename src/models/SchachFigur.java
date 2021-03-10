package models;

public class SchachFigur
{
	public static SchachFigur weissKoenig = new SchachFigur(SchachTeam.WEISS, FigurArt.KOENIG);
	public static SchachFigur weissDame = new SchachFigur(SchachTeam.WEISS, FigurArt.DAME);
	public static SchachFigur weissTurm = new SchachFigur(SchachTeam.WEISS, FigurArt.TURM);
	public static SchachFigur weissLaeufer = new SchachFigur(SchachTeam.WEISS, FigurArt.LAEUFER);
	public static SchachFigur weissSpringer = new SchachFigur(SchachTeam.WEISS, FigurArt.SPRINGER);
	public static SchachFigur weissBauer = new SchachFigur(SchachTeam.WEISS, FigurArt.BAUER);

	public static SchachFigur schwarzDame = new SchachFigur(SchachTeam.SCHWARZ, FigurArt.DAME);
	public static SchachFigur schwarzKoenig = new SchachFigur(SchachTeam.SCHWARZ, FigurArt.KOENIG);
	public static SchachFigur schwarzTurm = new SchachFigur(SchachTeam.SCHWARZ, FigurArt.TURM);
	public static SchachFigur schwarzLaeufer = new SchachFigur(SchachTeam.SCHWARZ, FigurArt.LAEUFER);
	public static SchachFigur schwarzSpringer = new SchachFigur(SchachTeam.SCHWARZ, FigurArt.SPRINGER);
	public static SchachFigur schwarzBauer = new SchachFigur(SchachTeam.SCHWARZ, FigurArt.BAUER);

	public static SchachFigur[] getFiguren(SchachTeam team)
	{
		SchachFigur[] figuren = null;
		switch (team)
		{
		case WEISS:
			figuren = new SchachFigur[] { new SchachFigur(weissBauer), new SchachFigur(weissBauer),
					new SchachFigur(weissBauer), new SchachFigur(weissBauer), new SchachFigur(weissBauer),
					new SchachFigur(weissBauer), new SchachFigur(weissBauer), new SchachFigur(weissBauer),
					new SchachFigur(weissTurm), new SchachFigur(weissTurm), new SchachFigur(weissSpringer),
					new SchachFigur(weissSpringer), new SchachFigur(weissLaeufer), new SchachFigur(weissLaeufer),
					new SchachFigur(weissKoenig), new SchachFigur(weissDame) };
			break;
		case SCHWARZ:
			figuren = new SchachFigur[] { new SchachFigur(schwarzBauer), new SchachFigur(schwarzBauer),
					new SchachFigur(schwarzBauer), new SchachFigur(schwarzBauer), new SchachFigur(schwarzBauer),
					new SchachFigur(schwarzBauer), new SchachFigur(schwarzBauer), new SchachFigur(schwarzBauer),
					new SchachFigur(schwarzTurm), new SchachFigur(schwarzTurm), new SchachFigur(schwarzSpringer),
					new SchachFigur(schwarzSpringer), new SchachFigur(schwarzLaeufer), new SchachFigur(schwarzLaeufer),
					new SchachFigur(schwarzKoenig), new SchachFigur(schwarzDame) };
			break;
		default:
			break;
		}

		return figuren;
	}

	private SchachTeam team;
	private FigurArt art;
	private String unicodeChar;
	private String bezeichnung;
	private boolean geschlagen;

	public SchachTeam getTeam()
	{
		return team;
	}
	public FigurArt getArt()
	{
		return this.art;
	}
	public String getUnicodeChar()
	{
		return unicodeChar;
	}
	public String getBezeichnung()
	{
		return this.bezeichnung;
	}
	public boolean getGeschlagen()
	{
		return geschlagen;
	}

	public SchachFigur(SchachTeam team, FigurArt art)
	{
		this.team = team;
		this.art = art;
		this.geschlagen = false;
		
		this.bezeichnung = "";
		switch (team)
		{
			case SCHWARZ:
				this.bezeichnung = "Schwarze";
				switch (art)
				{
					case BAUER:
						this.unicodeChar = "\u265F";
						this.bezeichnung += "r Bauer";
						break;
					case TURM:
						this.unicodeChar = "\u265C";
						this.bezeichnung += "r Turm";
						break;
					case SPRINGER:
						this.unicodeChar = "\u265E";
						this.bezeichnung += "r Springer";
						break;
					case LAEUFER:
						this.unicodeChar = "\u265D";
						this.bezeichnung += "r Läufer";
						break;
					case DAME:
						this.unicodeChar = "\u265B";
						this.bezeichnung += " Dame";
						break;
					case KOENIG:
						this.unicodeChar = "\u265A";
						this.bezeichnung += "r König";
						break;
					
					default:
						break;
				}
				
				break;
			case WEISS:
				this.bezeichnung = "Weiße";
				switch (art)
				{
				case BAUER:
					this.unicodeChar = "\u2659";
					this.bezeichnung += "r Bauer";
					break;
				case TURM:
					this.unicodeChar = "\u2656";
					this.bezeichnung += "r Turm";
					break;
				case SPRINGER:
					this.unicodeChar = "\u2658";
					this.bezeichnung += "r Springer";
					break;
				case LAEUFER:
					this.unicodeChar = "\u2657";
					this.bezeichnung += "r Läufer";
					break;
				case DAME:
					this.unicodeChar = "\u2655";
					this.bezeichnung += " Dame";
					break;
				case KOENIG:
					this.unicodeChar = "\u2654";
					this.bezeichnung += "r König";
					break;
					
				default:
					break;
				}
				
				break;
			default:
				break;
		}
		
//		System.out.println(this.bezeichnung + " erstellt.");
	}

	public SchachFigur(SchachFigur copyOf)
	{
		this(copyOf.team, copyOf.art);
	}
	
	public void schlageFigur()
	{
		this.geschlagen = true;
	}
	
	@Override
	public String toString()
	{
		return this.unicodeChar;
	}
}