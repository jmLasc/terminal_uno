import java.util.*; 
public interface GameStrategy
{
    Card findBestCard(Hand hand, Card top);
}