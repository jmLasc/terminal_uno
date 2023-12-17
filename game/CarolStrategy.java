import java.util.*; 

public class CarolStrategy implements GameStrategy
{
    public Card findBestCard(Hand myHand, Card top){
        Card ret = null;

        // Carol = play special first, then play number if unable
        // iterate for special
        for (int i = 0; i < myHand.size(); i++){
            Card temp = myHand.get(i);
            if (temp.getType() == Type.NUMBER){
                continue;
            } else if (temp.isPlayableOnStack(top)){
                return myHand.play(i);
            }
            
        }

        // if this runs, then that means that no
        // special card was found. look for number card
        for (int i = 0; i < myHand.size(); i++){
            Card temp = myHand.get(i);
            if (temp.isPlayableOnStack(top)){
                return myHand.play(i);
            }
            
        }

        myHand.shuffle();
        // fail case
        return ret;
    }
}