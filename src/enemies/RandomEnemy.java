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
	public SchachButton waehleStartFeld(SchachButton[][] spielfeld)
	{
		ArrayList<SchachButton> gueltigeFelder = new ArrayList<>();
		for (int i = 0; i < spielfeld.length; i++)
		{
			for (int j = 0; j < spielfeld[i].length; j++)
			{
				if (spielfeld[i][j].getFigurAufFeld() == null || ((SchachFigur) spielfeld[i][j].getFigurAufFeld()).getTeam() != this.team)
				{
					continue;
				}
				
				gueltigeFelder.add(spielfeld[i][j]);
			}
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
		
		return gueltigeFelder.get(RandomGenerator.getRandomNumber(1, gueltigeFelder.size() - 1));
	}

	public RandomEnemy(SchachTeam team)
	{
		this.team = team;
	}
}