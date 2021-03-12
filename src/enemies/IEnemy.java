package enemies;

import models.SchachTeam;
import views.SchachButton;

public interface IEnemy
{
	SchachTeam getTeam();
	SchachButton waehleStartFeld(SchachButton[][] spielfeld);
	SchachButton waehleZielFeld(SchachButton[][] spielfeld, boolean[][] gueltigeZuege);
}