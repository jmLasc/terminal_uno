import java.util.*; 

public class AliceStrategy implements GameStrategy
{
    public Card findBestCard(Hand myHand, Card top){
        Card ret = null;

        // Alice = play the oldest cards first
        for (int i = 0; i < myHand.size(); i++){
            Card temp = myHand.get(i);
            if (temp.isPlayableOnStack(top)){
                return myHand.play(i);
            }
        }
        
        // fail case, no card found
        return ret;
    }
}