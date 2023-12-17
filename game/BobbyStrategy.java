import java.util.*; 

public class BobbyStrategy implements GameStrategy
{
    public Card findBestCard(Hand myHand, Card top){
        Card ret = null;

        // Bob = play number cards first, then specials if needed
        // iterate for number
        for (int i = 0; i < myHand.size(); i++){
            Card temp = myHand.get(i);
            if (temp.getType() != Type.NUMBER){
                continue;
            } else if (temp.isPlayableOnStack(top)){
                return myHand.play(i);
            }
            
        }

        // if this runs, then that means that no
        // number card was found. look for any card instead
        for (int i = 0; i < myHand.size(); i++){
            Card temp = myHand.get(i);
            if (temp.isPlayableOnStack(top)){
                return myHand.play(i);
            }
            
        }

        myHand.shuffle();
        return ret;
    }
}