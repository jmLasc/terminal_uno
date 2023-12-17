import java.util.*;

public class Pile extends CardHolder
{
    public Pile(){}

    public void add(Card c){
        cards.offer(c);
    } 

    public Card drawCard(){
        return cards.pollLast();
    }

    public Card topCard(){
        return cards.peekLast();
    }
}