import java.util.*;

public class Deck extends CardHolder
{
    public Deck(){}

    public void add(Card c){
        cards.push(c);
    } 

    public Card drawCard(){
        return cards.pop();
    }

    public void shuffle(){
        // Deque cannot be shuffled with collections, so change to list and replace deque with shuffled list
        List<Card> list = new ArrayList<>(cards);
        Collections.shuffle(list); // shuffle twice, feels better in my opinion
        Collections.shuffle(list);
        
        cards.clear();
        cards.addAll(list);
    }
}