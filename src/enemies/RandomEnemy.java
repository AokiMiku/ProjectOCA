package enemies;

import java.util.ArrayList;

import models.SchachFigur;
import models.SchachTeam;
import random.RandomGenerator;
import views.SchachButton;

public class RandomEnemy implements IEnemy
{
	private SchachTeam team;
	
	@Override
	public SchachTeam getTeam()
	{
		return this.team;
	}

	@Override
	public SchachButton waehleStartFeld(SchachButton[][] spielfeld, ArrayList<SchachFigur> mussBewegen)
	{
		ArrayList<SchachButton> gueltigeFelder = new ArrayList<>();
		for (int i = 0; i < spielfeld.length; i++)
		{
			for (int j = 0; j < spielfeld[i].length; j++)
			{
				SchachFigur sf = ((SchachFigur) spielfeld[i][j].getFigurAufFeld());
				if (sf == null || sf.getTeam() != this.team || (mussBewegen != null && mussBewegen.size() > 0 && !mussBewegen.contains(sf)))
				{
					continue;
				}
				
				gueltigeFelder.add(spielfeld[i][j]);
			}
		}
		
		if (gueltigeFelder.size() == 0)
		{
			return null;
		}
		
		return gueltigeFelder.get(RandomGenerator.getRandomNumber(0, gueltigeFelder.size() - 1));
	}

	@Override
	public SchachButton waehleZielFeld(SchachButton[][] spielfeld, boolean[][] gueltigeZuege)
	{
		ArrayList<SchachButton> gueltigeFelder = new ArrayList<>();
		for (int i = 0; i < gueltigeZuege.length; i++)
		{
			for (int j = 0; j < gueltigeZuege[i].length; j++)
			{
				if (!gueltigeZuege[i][j])
				{
					continue;
				}
				
				gueltigeFelder.add(spielfeld[i][j]);
			}
		}
		
		return gueltigeFelder.get(RandomGenerator.getRandomNumber(0, gueltigeFelder.size() - 1));
	}

	public RandomEnemy(SchachTeam team)
	{
		this.team = team;
	}
}