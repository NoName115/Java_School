package solitaire.pile.server;

import solitaire.card.Card_Server;
import solitaire.card.ListOfCards;

import java.util.ArrayList;

public class DiscardPile_Server extends Pile_Server
{
    public DiscardPile_Server()
    {
        super();
    }

    @Override
    public boolean insertCard(ArrayList<Card_Server> inputList)
    {
        if (inputList == null || inputList.isEmpty() || inputList.size() > 1)
        {
            return false;
        }

        if (!checkCorrectCard(inputList))
        {
            return false;
        }

        for (Card_Server c : inputList)
        {
            this.cardList.add(c);
        }

        return true;
    }

    @Override
    public void returnListOfCardsToPile(ArrayList<Card_Server> inputList, boolean action)
    {
        if (inputList != null)
        {
            for (Card_Server c : inputList)
            {
                this.cardList.add(c);
            }
        }
    }

    private boolean checkCorrectCard(ArrayList<Card_Server> inputList)
    {
        // Kontrola spravneho typu kariet
        if (!this.cardList.isEmpty())
        {
            Card_Server tempCard = inputList.get(inputList.size() - 1);

            // Rovnaka farba karty
            if (!this.cardList.get(0).typeEqual(tempCard))
            {
                return false;
            }

            // Hodnota karty o 1 vyssia
            if (tempCard.getValue() - this.cardList.get(this.cardList.size() - 1).getValue() != 1)
            {
                return false;
            }
        }
        // Prva karta musi byt Eso(A)
        else
        {
            if (inputList.get(inputList.size() - 1).getValue() != 1)
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Metoda vrati null ak sa karta neda pridat do balicku,
     * alebo kartu z vrchu balicka ak sa da
     */
    public boolean canAddCard(Card_Server inputCard)
    {
        ListOfCards inputList = new ListOfCards(null, inputCard, 0);

        if (checkCorrectCard(inputList))
        {
            return true;
        }

        return false;
    }

    /*
     * Kontroluje ci solitaire.pile obsahuje vsetky potrebne karty
     * pre ukoncenie hry
     * Staci skontrolovat pocet kariet
     */
    public boolean containAllCards()
    {
        return (this.cardList.size() == 13) ? true : false;
    }
}