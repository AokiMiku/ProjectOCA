package enemies;

import java.util.ArrayList;

import models.SchachFigur;
import models.SchachTeam;
import views.SchachButton;

public interface IEnemy
{
	SchachTeam getTeam();
	SchachButton waehleStartFeld(SchachButton[][] spielfeld, ArrayList<SchachFigur> mussBewegen);
	SchachButton waehleZielFeld(SchachButton[][] spielfeld, boolean[][] gueltigeZuege);
}