package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import exceptions.IllegalFigureStateException;
import models.*;
import views.*;

public class SchachController extends WindowAdapter implements ActionListener
{
	private SchachView view;
	private ISchachModel model;

	private SchachTeam spielerAmZug;
	private SchachFigur[][] figurenAufSpielbrett;
	private int anzahlGueltigeSpielzuege = 0;
	private Color highlightColor = new Color(128, 255, 187);
	private GameState status = GameState.WAEHLEFIGUR;
	private SchachButton aktuellesFeld;
	private boolean isGameOver = false;
	private boolean isSchach = false;

	public SchachController(SchachView view)
	{
		this.view = view;
		this.model = new SchachModel();
		this.spielerAmZug = SchachTeam.WEISS;
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		super.windowOpened(e);
		this.newGame();
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.getSource());
		if (this.view.getFields().contains(e.getSource()))
		{
			if (this.isGameOver)
			{
				return;
			}
			
			if (this.status == GameState.WAEHLEFIGUR)
			{
				SchachFigur figur = (SchachFigur) ((SchachButton) e.getSource()).getFigurAufFeld();
				if (figur == null)
				{
					return;
				}

				if (figur.getTeam() != this.spielerAmZug)
				{
					System.out.println("Es koennen nur eigene Figuren bewegt werden!");
					return;
				}

				this.getFigurenAufSpielbrett();
				boolean[][] spielzuege = this.getGueltigeSpielzuege(figur);

				if (this.anzahlGueltigeSpielzuege > 1)
				{
					System.out.println((this.anzahlGueltigeSpielzuege - 1) + " gueltige Zuege.");
					for (int i = 0; i < spielzuege.length; i++)
					{
						for (int j = 0; j < spielzuege[i].length; j++)
						{
							if (spielzuege[i][j] && this.view.getSpielBrett()[i][j] != e.getSource())
							{
								this.view.getSpielBrett()[i][j].setBackground(this.highlightColor);
							}
						}
					}
					this.aktuellesFeld = (SchachButton) e.getSource();
					this.status = GameState.BEWEGEFIGUR;
				}
			}
			else if (this.status == GameState.BEWEGEFIGUR)
			{
				SchachButton feld = (SchachButton) e.getSource();
				if (feld == this.aktuellesFeld)
				{
					this.status = GameState.WAEHLEFIGUR;
					this.view.buildChessBoard();
				}
				if (feld.getBackground() == this.highlightColor)
				{
					if (feld.getFigurAufFeld() != null)
					{
						if (((SchachFigur) feld.getFigurAufFeld()).getTeam() != this.spielerAmZug)
						{
							((SchachFigur) feld.getFigurAufFeld()).schlageFigur();
						}
					}

					feld.setFigurAufFeld(this.aktuellesFeld.getFigurAufFeld());
					this.aktuellesFeld.setFigurAufFeld(null);

					this.status = GameState.WAEHLEFIGUR;
					this.view.buildChessBoard();
					this.beendeZug();
				}
			}
		}
	}

	private void beendeZug()
	{
		if (this.spielerAmZug == SchachTeam.SCHWARZ)
		{
			this.spielerAmZug = SchachTeam.WEISS;
		}
		else if (this.spielerAmZug == SchachTeam.WEISS)
		{
			this.spielerAmZug = SchachTeam.SCHWARZ;
		}
		this.view.getLblGameText().setText(this.spielerAmZug.toString() + " ist am Zug.");
		
		if (this.checkGameOver())
		{
			this.view.getLblGameText().setText(this.spielerAmZug.toString() + " ist schachmatt.");
			this.isGameOver = true;
		}
	}
	
	private boolean checkGameOver()
	{
		this.getFigurenAufSpielbrett();
		
		SchachFigur koenig = null;
		int posKoenigRow = -1;
		int posKoenigCol = -1;
		for (int i = 0; i < this.figurenAufSpielbrett.length; i++)
		{
			for (int j = 0; j < this.figurenAufSpielbrett[i].length; j++)
			{
				SchachFigur schachFigur = this.figurenAufSpielbrett[i][j];
				if (schachFigur == null || schachFigur.getTeam() != this.spielerAmZug || schachFigur.getArt() != FigurArt.KOENIG)
				{
					continue;
				}
				
				koenig = schachFigur;
				posKoenigRow = i;
				posKoenigCol = j;
			}
		}
		
//		System.out.println("*");
		for (int i = 0; i < this.figurenAufSpielbrett.length; i++)
		{
			for (int j = 0; j < this.figurenAufSpielbrett[i].length; j++)
			{
				SchachFigur schachFigur = this.figurenAufSpielbrett[i][j];
				if (schachFigur == null || schachFigur.getTeam() == this.spielerAmZug)
				{
					continue;
				}
//				System.out.println(schachFigur.getBezeichnung());
				
				boolean[][] spielzuege = this.getGueltigeSpielzuege(schachFigur);
//				System.out.println(schachFigur.getBezeichnung() + " " + spielZuege[posKoenigRow][posKoenigCol]);
				if (spielzuege[posKoenigRow][posKoenigCol])
				{
					this.isSchach = true;
					this.view.getLblGameText().setText(koenig.getBezeichnung() + " steht im Schach!");
				}
			}
		}
		
		boolean isSchachmatt = false;
		if (this.isSchach)
		{
			boolean[][] spielzuegeKoenig = this.getGueltigeSpielzuege(koenig);
			for (int koenigRow = 0; koenigRow < spielzuegeKoenig.length; koenigRow++)
			{
				for (int koenigCol = 0; koenigCol < spielzuegeKoenig[koenigRow].length; koenigCol++)
				{
					if (!spielzuegeKoenig[koenigRow][koenigCol])
					{
						continue;
					}
					
					for (int i = 0; i < this.figurenAufSpielbrett.length; i++)
					{
						for (int j = 0; j < this.figurenAufSpielbrett[i].length; j++)
						{
							SchachFigur schachFigur = this.figurenAufSpielbrett[i][j];
							if (schachFigur == null || schachFigur.getTeam() == this.spielerAmZug)
							{
								continue;
							}
							
							boolean[][] spielzuege = this.getGueltigeSpielzuege(schachFigur);
							if (spielzuege[koenigRow][koenigCol])
							{
								isSchachmatt = true;
								this.view.getLblGameText().setText(koenig.getTeam() + " ist schachmatt!");
							}
						}
					}
				}
			}
		}
		
		return isSchachmatt;
	}

	private void newGame()
	{
		for (SchachButton feld : this.view.getFields())
		{
			feld.setText("");
		}
		this.model.newGame();

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
		this.view.getFieldH4().setFigurAufFeld(sf[0]);

		sf = this.model.getSpielerWeiss().getFiguren(FigurArt.BAUER);
		this.view.getFieldG1().setFigurAufFeld(sf[0]);
		this.view.getFieldG2().setFigurAufFeld(sf[1]);
		this.view.getFieldG3().setFigurAufFeld(sf[2]);
		this.view.getFieldG4().setFigurAufFeld(sf[3]);
		this.view.getFieldG5().setFigurAufFeld(sf[4]);
		this.view.getFieldG6().setFigurAufFeld(sf[5]);
		this.view.getFieldG7().setFigurAufFeld(sf[6]);
		this.view.getFieldG8().setFigurAufFeld(sf[7]);

		this.view.getLblGameText().setText("Weiss beginnt.");
		this.isGameOver = false;
	}

	private void getFigurenAufSpielbrett()
	{
		this.figurenAufSpielbrett = new SchachFigur[8][8];
		for (int i = 0; i < this.view.getSpielBrett().length; i++)
		{
			for (int j = 0; j < this.view.getSpielBrett()[i].length; j++)
			{
				Object figur = this.view.getSpielBrett()[i][j].getFigurAufFeld();
				if (figur != null && figur instanceof SchachFigur)
				{
					this.figurenAufSpielbrett[i][j] = (SchachFigur) this.view.getSpielBrett()[i][j].getFigurAufFeld();
				}
			}
			System.out.println(Arrays.toString(this.figurenAufSpielbrett[i]));
		}
	}

	private boolean[][] getGueltigeSpielzuege(SchachFigur figurAmZug)
	{
		int posFigurRow = -1;
		int posFigurCol = -1;

		for (int row = 0; row < this.figurenAufSpielbrett.length; row++)
		{
			for (int col = 0; col < this.figurenAufSpielbrett[row].length; col++)
			{
				if (this.figurenAufSpielbrett[row][col] == figurAmZug)
				{
					posFigurRow = row;
					posFigurCol = col;
				}
			}
		}

		if (posFigurRow == -1 || posFigurCol == -1)
		{
			throw new IllegalFigureStateException(
					String.format("%s befindet sich nicht auf dem Spielfeld.", figurAmZug));
		}

		ArrayList<Integer> idxRowsGueltig = new ArrayList<>();
		idxRowsGueltig.add(posFigurRow);
		ArrayList<Integer> idxColsGueltig = new ArrayList<>();
		idxColsGueltig.add(posFigurCol);

		switch (figurAmZug.getArt())
		{
			case BAUER:
			{
				if (figurAmZug.getTeam() == SchachTeam.WEISS)
				{
					if (posFigurRow == 0)
					{
						break;
					}

					if (this.figurenAufSpielbrett[posFigurRow - 1][posFigurCol] == null)
					{
						idxRowsGueltig.add(posFigurRow - 1);
						idxColsGueltig.add(posFigurCol);
					}

					if (posFigurRow == 6 && this.figurenAufSpielbrett[4][posFigurCol] == null)
					{
						idxRowsGueltig.add(posFigurRow - 2);
						idxColsGueltig.add(posFigurCol);
					}

					if (posFigurCol > 0 && this.figurenAufSpielbrett[posFigurRow - 1][posFigurCol - 1] != null
							&& this.figurenAufSpielbrett[posFigurRow - 1][posFigurCol - 1].getTeam() != figurAmZug
									.getTeam())
					{
						idxRowsGueltig.add(posFigurRow - 1);
						idxColsGueltig.add(posFigurCol - 1);
					}

					if (posFigurCol < 7 && this.figurenAufSpielbrett[posFigurRow - 1][posFigurCol + 1] != null
							&& this.figurenAufSpielbrett[posFigurRow - 1][posFigurCol + 1].getTeam() != figurAmZug
									.getTeam())
					{
						idxRowsGueltig.add(posFigurRow - 1);
						idxColsGueltig.add(posFigurCol + 1);
					}
				}
				else if (figurAmZug.getTeam() == SchachTeam.SCHWARZ)
				{
					if (posFigurRow == 7)
					{
						break;
					}

					if (this.figurenAufSpielbrett[posFigurRow + 1][posFigurCol] == null)
					{
						idxRowsGueltig.add(posFigurRow + 1);
						idxColsGueltig.add(posFigurCol);
					}

					if (posFigurRow == 1 && this.figurenAufSpielbrett[3][posFigurCol] == null)
					{
						idxRowsGueltig.add(posFigurRow + 2);
						idxColsGueltig.add(posFigurCol);
					}

					if (posFigurCol > 0 && this.figurenAufSpielbrett[posFigurRow + 1][posFigurCol - 1] != null
							&& this.figurenAufSpielbrett[posFigurRow + 1][posFigurCol - 1].getTeam() != figurAmZug
									.getTeam())
					{
						idxRowsGueltig.add(posFigurRow + 1);
						idxColsGueltig.add(posFigurCol - 1);
					}

					if (posFigurCol < 7 && this.figurenAufSpielbrett[posFigurRow + 1][posFigurCol + 1] != null
							&& this.figurenAufSpielbrett[posFigurRow + 1][posFigurCol + 1].getTeam() != figurAmZug
									.getTeam())
					{
						idxRowsGueltig.add(posFigurRow + 1);
						idxColsGueltig.add(posFigurCol + 1);
					}
				}
				break;
			}
			case SPRINGER:
			{
				Integer[] rows = { posFigurRow - 2, posFigurRow - 2, posFigurRow + 2, posFigurRow + 2, posFigurRow - 1, posFigurRow + 1, posFigurRow - 1, posFigurRow + 1 };
				Integer[] cols = { posFigurCol - 1, posFigurCol + 1, posFigurCol - 1, posFigurCol + 1, posFigurCol - 2, posFigurCol - 2, posFigurCol + 2, posFigurCol + 2 };
				
				for (int i = 0; i < rows.length; i++)
				{
					if (rows[i] >= 0 && rows[i] <= 7 && cols[i] >= 0 && cols[i] <= 7 && (this.figurenAufSpielbrett[rows[i]][cols[i]] == null
							|| this.figurenAufSpielbrett[rows[i]][cols[i]].getTeam() != figurAmZug.getTeam()))
					{
						idxRowsGueltig.add(rows[i]);
						idxColsGueltig.add(cols[i]);
					}
				}

				break;
			}
			case TURM:
			{
				ArrayList<Integer>[] rowsUndCols = this.getHorizontalUndVertikalBewegung(posFigurRow, posFigurCol,
						figurAmZug);
				idxRowsGueltig.addAll(rowsUndCols[0]);
				idxColsGueltig.addAll(rowsUndCols[1]);
				break;
			}
			case LAEUFER:
			{
				ArrayList<Integer>[] rowsUndCols = this.getDiagonaleBewegung(posFigurRow, posFigurCol, figurAmZug);
				idxRowsGueltig.addAll(rowsUndCols[0]);
				idxColsGueltig.addAll(rowsUndCols[1]);
				break;
			}
			case DAME:
			{
				ArrayList<Integer>[] rowsUndCols = this.getHorizontalUndVertikalBewegung(posFigurRow, posFigurCol,
						figurAmZug);
				idxRowsGueltig.addAll(rowsUndCols[0]);
				idxColsGueltig.addAll(rowsUndCols[1]);

				rowsUndCols = this.getDiagonaleBewegung(posFigurRow, posFigurCol, figurAmZug);
				idxRowsGueltig.addAll(rowsUndCols[0]);
				idxColsGueltig.addAll(rowsUndCols[1]);
				break;
			}
			case KOENIG:
			{
				Integer[] rows = { posFigurRow - 1, posFigurRow - 1, posFigurRow - 1, posFigurRow    , posFigurRow + 1, posFigurRow + 1, posFigurRow + 1, posFigurRow     };
				Integer[] cols = { posFigurCol - 1, posFigurCol    , posFigurCol + 1, posFigurCol + 1, posFigurCol + 1, posFigurCol    , posFigurCol - 1, posFigurCol - 1 };
				
				for (int i = 0; i < rows.length; i++)
				{
					if (rows[i] >= 0 && rows[i] <= 7 && cols[i] >= 0 && cols[i] <= 7 && (this.figurenAufSpielbrett[rows[i]][cols[i]] == null
							|| this.figurenAufSpielbrett[rows[i]][cols[i]].getTeam() != figurAmZug.getTeam()))
					{
						idxRowsGueltig.add(rows[i]);
						idxColsGueltig.add(cols[i]);
					}
				}
				
				break;
			}
			default:
				break;
		}

		// duerfte niemals passieren; falls doch zum testen erst nur auf Konsole
		// anzeigen
		if (idxRowsGueltig.size() != idxColsGueltig.size())
		{
			System.out.println("idxRowsGueltig.size() != idxColsGueltig.size()");
			return null;
		}

		this.anzahlGueltigeSpielzuege = 0;
		boolean[][] gueltigeSpielzuege = new boolean[8][8];

		for (int i = 0; i < idxRowsGueltig.size(); i++)
		{
			if ((idxRowsGueltig.get(i) >= 0 && idxRowsGueltig.get(i) <= 7)
					&& (idxColsGueltig.get(i) >= 0 && idxColsGueltig.get(i) <= 7))
			{
				this.anzahlGueltigeSpielzuege++;
				gueltigeSpielzuege[idxRowsGueltig.get(i)][idxColsGueltig.get(i)] = true;
			}
		}
		
//		if (figurAmZug.getArt() == FigurArt.LAEUFER)
//		{
//			System.out.println("**********************************");
//			System.out.println(figurAmZug.getBezeichnung());
//			System.out.println(Arrays.toString(gueltigeSpielzuege[0]));
//			System.out.println(Arrays.toString(gueltigeSpielzuege[1]));
//			System.out.println(Arrays.toString(gueltigeSpielzuege[2]));
//			System.out.println(Arrays.toString(gueltigeSpielzuege[3]));
//			System.out.println(Arrays.toString(gueltigeSpielzuege[4]));
//			System.out.println(Arrays.toString(gueltigeSpielzuege[5]));
//			System.out.println(Arrays.toString(gueltigeSpielzuege[6]));
//			System.out.println(Arrays.toString(gueltigeSpielzuege[7]));
//		}
		return gueltigeSpielzuege;
	}

	private ArrayList<Integer>[] getHorizontalUndVertikalBewegung(int rowStart, int colStart, SchachFigur figurAmZug)
	{
		@SuppressWarnings ("unchecked")
		ArrayList<Integer>[] horizontalUndVertikal = new ArrayList[2];
		horizontalUndVertikal[0] = new ArrayList<Integer>();
		horizontalUndVertikal[1] = new ArrayList<Integer>();

		int row = rowStart;
		int col = colStart;
		while (--row >= 0
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			horizontalUndVertikal[0].add(row);
			horizontalUndVertikal[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}
		row = rowStart;
		col = colStart;
		while (++row <= 7
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			horizontalUndVertikal[0].add(row);
			horizontalUndVertikal[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}
		row = rowStart;
		col = colStart;
		while (--col >= 0
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			horizontalUndVertikal[0].add(row);
			horizontalUndVertikal[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}
		row = rowStart;
		col = colStart;
		while (++col <= 7
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			horizontalUndVertikal[0].add(row);
			horizontalUndVertikal[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}

		return horizontalUndVertikal;
	}

	private ArrayList<Integer>[] getDiagonaleBewegung(int rowStart, int colStart, SchachFigur figurAmZug)
	{
		@SuppressWarnings ("unchecked")
		ArrayList<Integer>[] diagonaleBewegung = new ArrayList[2];
		diagonaleBewegung[0] = new ArrayList<Integer>();
		diagonaleBewegung[1] = new ArrayList<Integer>();

		int row = rowStart;
		int col = colStart;
		while (--row >= 0 && --col >= 0
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			diagonaleBewegung[0].add(row);
			diagonaleBewegung[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}

		row = rowStart;
		col = colStart;
		while (--row >= 0 && ++col <= 7
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			diagonaleBewegung[0].add(row);
			diagonaleBewegung[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}

		row = rowStart;
		col = colStart;
		while (++row <= 7 && ++col <= 7
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			diagonaleBewegung[0].add(row);
			diagonaleBewegung[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}

		row = rowStart;
		col = colStart;
		while (++row <= 7 && --col >= 0
				&& (this.figurenAufSpielbrett[row][col] == null || this.figurenAufSpielbrett[row][col] == figurAmZug
						|| this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam()))
		{
			diagonaleBewegung[0].add(row);
			diagonaleBewegung[1].add(col);
			if (this.figurenAufSpielbrett[row][col] != null
					&& this.figurenAufSpielbrett[row][col].getTeam() != figurAmZug.getTeam())
			{
				break;
			}
		}

		return diagonaleBewegung;
	}
}