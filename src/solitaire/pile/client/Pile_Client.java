package solitaire.pile.client;

import java.awt.Graphics;

import java.util.ArrayList;

import solitaire.card.*;
import solitaire.PlayGround;


/**
 * Trieda z ktorej dedia vsetky ostatne xxxPile
 */
public abstract class Pile_Client
{
	protected int xPosition;
	protected int yPosition;
	protected int width;
	protected int height;
	protected PlayGround pg;
	protected ArrayList<Card> cardList;

	public Pile_Client(int xPos, int yPos, int width, int height, PlayGround pg)
	{
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.width = width;
		this.height = height;
		this.pg = pg;
		this.cardList = new ArrayList<Card>();
	}

	abstract public void render(Graphics g);

	/**
	 * Prida kartu na koniec balicku
	 * a vola setDefaultPosition pre danu kartu
	 */
	public void addCard(Card inputCard)
	{
		this.cardList.add(inputCard);
		inputCard.setDefaultPosition(this.xPosition, this.yPosition);
	}

	/**
	 * Kontroluje ci sa myska nachadza v Pile-e
	 * NEPREPISUJE SA
	 */
	public boolean isInPile(int ix, int iy)
	{
		if (this.xPosition <= ix && this.xPosition + this.width >= ix)
		{
			if (this.yPosition <= iy && this.yPosition + this.height >= iy)
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * Funkcia pre nastavenie noveho rozlisenia okna hry pri zmene pocte hier
	 */
	public void setNewResolution(int xPos, int yPos, int width, int height)
	{
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.width = width;
		this.height = height;

		this.setNewDefaultPosition();
	}

	/**
	 * Nastavi nove defaultPosition pre zoznamy kariet v Pile-e
	 */
	public void setNewDefaultPosition()
	{
		for (Card c : this.cardList)
		{
			c.setDefaultPosition(this.xPosition, this.yPosition);
		}
	}

	/**
	 * Urobit akciu pri kliknuti na Pile
	 * Ak je potrebne vrati object ListOfCards
	 */
	public ListOfCards selectPile(int ix, int iy) { return null; }
}