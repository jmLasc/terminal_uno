import java.util.*;

public class Hand extends CardHolder
{
    public Hand(){}

    public void add(Card c){
        cards.add(c);
    } 

    public Card get(int i){ // gets without removal
        Card ret = null;
        Iterator<Card> iterate = cards.iterator();

        for (int j = 0; j <= i; j++){
            ret = iterate.next();
        }

        return ret;
    }

    public Card play(int i){ // actually removes
        Card ret = null;
        Iterator<Card> iterate = cards.iterator();

        for (int j = 0; j <= i; j++){
            ret = iterate.next();
        }

        iterate.remove();
        return ret;
    }

    public void shuffle(){
        // Deque cannot be shuffled with collections, so change to list and replace deque with shuffled list
        List<Card> list = new ArrayList<>(cards);
        Collections.shuffle(list);
        Collections.shuffle(list);
        
        cards.clear();
        cards.addAll(list);
    }
}