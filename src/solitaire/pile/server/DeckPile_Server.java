package solitaire.pile.server;

import java.awt.*;
import java.util.Random;

import solitaire.card.*;


/**
 * Trieda pre vygenerovanie celeho balicka kariet
 */
public class DeckPile_Server extends Pile_Server
{
	private static final int NUMBER_OF_CARDS = 13;

	public static enum Type
	{
		CLUBS, DIAMONDS, HEARTS, SPADES;

		public Color toColor()
		{
			switch(this)
			{
				case DIAMONDS:
				case HEARTS:
					return Color.RED;
				case CLUBS:
				case SPADES:
					return Color.BLACK;
				default:
					return Color.WHITE;
			}
		}

		public String toString()
		{
			switch(this)
			{
				case DIAMONDS:
					return "D";
				case HEARTS:
					return "H";
				case CLUBS:
					return "C";
				case SPADES:
					return "S";
				default:
					return "Error";
			}
		}

		public boolean equalColor(DeckPile_Server.Type iColor)
		{
			if (this == iColor)
			{
				return true;
			}

			if ((this == CLUBS && iColor == SPADES) || (this == SPADES && iColor == CLUBS))
			{
				return true;
			}

			if ((this == DIAMONDS && iColor == HEARTS) || (this == HEARTS && iColor == DIAMONDS))
			{
				return true;
			}

			return false;
		}
	}

	/**
	 * Generuje balicek 52 kariet
	 */
	public DeckPile_Server()
	{
		super();

		for (DeckPile_Server.Type t : DeckPile_Server.Type.values())
		{
			for (int j = 0; j < NUMBER_OF_CARDS; ++j)
			{
				this.cardList.add(new Card_Server(j + 1, t));
			}
		}
	}

	public void addCard(Card inputCard) {}

	/**
	 * Vrati nahodnu kartu z balicka
	 * Vrati null ak je balicek prazny
	 */
	public Card_Server popCard()
	{
		if (this.cardList.isEmpty())
		{
			return null;
		}

		Random ran = new Random();
		int randomIndex = ran.nextInt(this.cardList.size());
		Card_Server returnCard = this.cardList.get(randomIndex);
		this.cardList.remove(randomIndex);

		return returnCard;
	}
}