

public class Deck {

    final static int DECK_SIZE = 52;
    private Card[] cards;
    private Card[] cards1;
    private Card[] cards2;
    private Card[] cards3;
    private Card[] cards4;
    private Card[] cards5;
    private Card[] cards6;
    private int N = 0;
    public int SIZE = 0;
    private int deckMultiplier;

    public Deck(int decksAmount)
    {
        deckMultiplier = decksAmount;
        switch (deckMultiplier)
        {
            case 1:
                cards = new Card[DECK_SIZE];
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 13; j++)
                    {
                        cards[N] = new Card(N, j, i + "" + j);
                        N++;
                    }
                }
                break;
            case 2:
                cards1 = new Card[DECK_SIZE];
                cards2 = new Card[DECK_SIZE];
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 13; j++)
                    {
                        cards1[N] = new Card(N, j, i + "" + j + ".png");
                        cards2[N] = new Card(N, j, i + "" + j + ".png");
                        N++;
                    }
                }
                cards = new Card[cards1.length+cards2.length];
                System.arraycopy(cards1, 0, cards, 0,  DECK_SIZE);
                System.arraycopy(cards2, 0, cards, DECK_SIZE, DECK_SIZE);
                SIZE = cards.length;
                break;
            case 3:
                cards1 = new Card[DECK_SIZE];
                cards2 = new Card[DECK_SIZE];
                cards3 = new Card[DECK_SIZE];
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 13; j++)
                    {
                        cards1[N] = new Card(N, j, i + "" + j + ".png");
                        cards2[N] = new Card(N, j, i + "" + j + ".png");
                        cards3[N] = new Card(N, j, i + "" + j + ".png");
                        N++;
                    }
                }
                cards = new Card[DECK_SIZE*3];
                System.arraycopy(cards1, 0, cards, 0,  DECK_SIZE);
                System.arraycopy(cards2, 0, cards, DECK_SIZE, DECK_SIZE);
                System.arraycopy(cards3, 0, cards, DECK_SIZE*2, DECK_SIZE);
                SIZE = cards.length;
                break;
            case 4:
                cards1 = new Card[DECK_SIZE];
                cards2 = new Card[DECK_SIZE];
                cards3 = new Card[DECK_SIZE];
                cards4 = new Card[DECK_SIZE];
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 13; j++)
                    {
                        cards1[N] = new Card(N, j, i + "" + j + ".png");
                        cards2[N] = new Card(N, j, i + "" + j + ".png");
                        cards3[N] = new Card(N, j, i + "" + j + ".png");
                        cards4[N] = new Card(N, j, i + "" + j + ".png");
                        N++;
                    }
                }
                cards = new Card[cards1.length+cards2.length+cards3.length+cards4.length];
                System.arraycopy(cards1, 0, cards, 0,  DECK_SIZE);
                System.arraycopy(cards2, 0, cards, DECK_SIZE, DECK_SIZE);
                System.arraycopy(cards3, 0, cards, DECK_SIZE*2, DECK_SIZE);
                System.arraycopy(cards4, 0, cards, DECK_SIZE*3, DECK_SIZE);
                SIZE = cards.length;
                break;
            case 5:
                cards1 = new Card[DECK_SIZE];
                cards2 = new Card[DECK_SIZE];
                cards3 = new Card[DECK_SIZE];
                cards4 = new Card[DECK_SIZE];
                cards5 = new Card[DECK_SIZE];
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 13; j++)
                    {
                        cards1[N] = new Card(N, j, i + "" + j + ".png");
                        cards2[N] = new Card(N, j, i + "" + j + ".png");
                        cards3[N] = new Card(N, j, i + "" + j + ".png");
                        cards4[N] = new Card(N, j, i + "" + j + ".png");
                        cards5[N] = new Card(N, j, i + "" + j + ".png");
                        N++;
                    }
                }
                cards = new Card[cards1.length+cards2.length+cards3.length+cards4.length+cards5.length];
                System.arraycopy(cards1, 0, cards, 0,  DECK_SIZE);
                System.arraycopy(cards2, 0, cards, DECK_SIZE, DECK_SIZE);
                System.arraycopy(cards3, 0, cards, DECK_SIZE*2, DECK_SIZE);
                System.arraycopy(cards4, 0, cards, DECK_SIZE*3, DECK_SIZE);
                System.arraycopy(cards5, 0, cards, DECK_SIZE*4, DECK_SIZE);
                SIZE = cards.length;
                break;
            case 6:
                cards1 = new Card[DECK_SIZE];
                cards2 = new Card[DECK_SIZE];
                cards3 = new Card[DECK_SIZE];
                cards4 = new Card[DECK_SIZE];
                cards5 = new Card[DECK_SIZE];
                cards6 = new Card[DECK_SIZE];
                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j < 13; j++)
                    {
                        cards1[N] = new Card(N, j, i + "" + j + ".png");
                        cards2[N] = new Card(N, j, i + "" + j + ".png");
                        cards3[N] = new Card(N, j, i + "" + j + ".png");
                        cards4[N] = new Card(N, j, i + "" + j + ".png");
                        cards5[N] = new Card(N, j, i + "" + j + ".png");
                        cards6[N] = new Card(N, j, i + "" + j + ".png");
                        N++;
                    }
                }
                cards = new Card[cards1.length+cards2.length+cards3.length+cards4.length+cards5.length+cards6.length];
                System.arraycopy(cards1, 0, cards, 0,  DECK_SIZE);
                System.arraycopy(cards2, 0, cards, DECK_SIZE, DECK_SIZE);
                System.arraycopy(cards3, 0, cards, DECK_SIZE*2, DECK_SIZE);
                System.arraycopy(cards4, 0, cards, DECK_SIZE*3, DECK_SIZE);
                System.arraycopy(cards5, 0, cards, DECK_SIZE*4, DECK_SIZE);
                System.arraycopy(cards5, 0, cards, DECK_SIZE*5, DECK_SIZE);
                SIZE = cards.length;
                break;
        }
    }

    public Card dealFrom()
    {
        return cards[--SIZE];
    }

    public boolean isEmpty()
    {
        return (SIZE == 0);
    }

    public int size()
    {
        return SIZE;
    }

    public void shuffle()
    {
        for (int i = 0; i < SIZE; i++)
        {
            int r = (int) (Math.random() * i);
            Card swap = cards[i];
            cards[i] = cards[r];
            cards[r] = swap;
        }
    }
}
