package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import views.*;

public class SchachController implements ActionListener
{
	private SchachView view;
	private ISchachModel model;

	public SchachController(SchachView view)
	{
		this.view = view;
		this.newGame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println(e.getSource());
	}
	
	private void newGame()
	{
		for (SchachButton feld : this.view.getFields())
		{
			feld.setText("");
		}
		this.model = new SchachModel();
		
		SchachFigur[] sf = this.model.getSpielerSchwarz().getFiguren(FigurArt.TURM);
		this.view.getFieldA1().setFigurAufFeld(sf[0]);
		this.view.getFieldA8().setFigurAufFeld(sf[1]);

		sf = this.model.getSpielerSchwarz().getFiguren(FigurArt.SPRINGER);
		this.view.getFieldA2().setFigurAufFeld(sf[0]);
		this.view.getFieldA7().setFigurAufFeld(sf[1]);
		
		sf = this.model.getSpielerSchwarz().getFiguren(FigurArt.LAEUFER);
		this.view.getFieldA3().setFigurAufFeld(sf[0]);
		this.view.getFieldA6().setFigurAufFeld(sf[1]);
		
		sf = this.model.getSpielerSchwarz().getFiguren(FigurArt.DAME);
		this.view.getFieldA5().setFigurAufFeld(sf[0]);
		
		sf = this.model.getSpielerSchwarz().getFiguren(FigurArt.KOENIG);
		this.view.getFieldA4().setFigurAufFeld(sf[0]);
		
		sf = this.model.getSpielerSchwarz().getFiguren(FigurArt.BAUER);
		this.view.getFieldB1().setFigurAufFeld(sf[0]);
		this.view.getFieldB2().setFigurAufFeld(sf[1]);
		this.view.getFieldB3().setFigurAufFeld(sf[2]);
		this.view.getFieldB4().setFigurAufFeld(sf[3]);
		this.view.getFieldB5().setFigurAufFeld(sf[4]);
		this.view.getFieldB6().setFigurAufFeld(sf[5]);
		this.view.getFieldB7().setFigurAufFeld(sf[6]);
		this.view.getFieldB8().setFigurAufFeld(sf[7]);
		
		sf = this.model.getSpielerWeiss().getFiguren(FigurArt.TURM);
		this.view.getFieldH1().setFigurAufFeld(sf[0]);
		this.view.getFieldH8().setFigurAufFeld(sf[1]);
		
		sf = this.model.getSpielerWeiss().getFiguren(FigurArt.SPRINGER);
		this.view.getFieldH2().setFigurAufFeld(sf[0]);
		this.view.getFieldH7().setFigurAufFeld(sf[1]);
		
		sf = this.model.getSpielerWeiss().getFiguren(FigurArt.LAEUFER);
		this.view.getFieldH3().setFigurAufFeld(sf[0]);
		this.view.getFieldH6().setFigurAufFeld(sf[1]);
		
		sf = this.model.getSpielerWeiss().getFiguren(FigurArt.DAME);
		this.view.getFieldH5().setFigurAufFeld(sf[0]);
		
		sf = this.model.getSpielerWeiss().getFiguren(FigurArt.KOENIG);
		this.view.getFieldH5().setFigurAufFeld(sf[0]);
		
		sf = this.model.getSpielerWeiss().getFiguren(FigurArt.BAUER);
		this.view.getFieldG1().setFigurAufFeld(sf[0]);
		this.view.getFieldG2().setFigurAufFeld(sf[1]);
		this.view.getFieldG3().setFigurAufFeld(sf[2]);
		this.view.getFieldG4().setFigurAufFeld(sf[3]);
		this.view.getFieldG5().setFigurAufFeld(sf[4]);
		this.view.getFieldG6().setFigurAufFeld(sf[5]);
		this.view.getFieldG7().setFigurAufFeld(sf[6]);
		this.view.getFieldG8().setFigurAufFeld(sf[7]);
	}
	
	
}