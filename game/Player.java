import java.util.*;

public class Player
{
    private Hand hand = new Hand();
    private String name;
    private GameStrategy gs;

    public Player(GameStrategy playerType, String n){
        name = n;
        gs = playerType;
    }

    public String toString(){
        return name;
    }

    // For initial 7 draw
    public void drawCard(Deck deck){
        hand.add(deck.drawCard());
    }

    // For other drawing, more verbose (during game loop)
    public void drawCard(Deck deck, Pile pile){
        hand.add(deck.drawCard());
        System.out.println(name + " drew a card.");
    }

    public void playTurn(Card topPile, Deck deck, Pile pile){
        Card toPlay = gs.findBestCard(hand, topPile);

        if (toPlay != null){
            System.out.println(name + " is playing: " + toPlay + "");
            pile.add(toPlay);
        } else {
            System.out.println(name + " was unable to play a card.");
            drawCard(deck, pile);
        }
        checkPlayer();
        System.out.print("\n");
    }

    public void checkPlayer(){
        if (hand.size() == 1){
            System.out.println(name + " has one card left in hand!!");
        }
        else if (hand.size() == 0){
            System.out.println(name + " has won the game!");
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
}