import java.util.*;

public abstract class CardHolder
{
    protected Deque<Card> cards = new LinkedList<>();

    public int size(){
        return cards.size();
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public void add(Card c) throws InapplicableOperationException{ 
        throw new InapplicableOperationException("add error!");
    }

    public Card topCard() throws InapplicableOperationException{
        throw new InapplicableOperationException("topCard error!");
    } 

    public Card drawCard() throws InapplicableOperationException{
        throw new InapplicableOperationException("drawCard error!");
    }
}