import java.io.*;
import java.util.*;

public class RunMeForGame
{
    private static Deck deck = new Deck(); 
    private static Pile pile = new Pile();

    private static void createDeck()
    {
        CardMaker numFactory = new NumberCardMaker();
        CardMaker speFactory = new SpecialCardMaker();

        // Input format of (color, type, value)
        for (int i = 1; i <= 4; i++){ // For each color...
            Color c = switch (i) { // Get Color
                case 1 -> Color.RED;
                case 2 -> Color.BLUE;
                case 3 -> Color.GREEN;
                case 4 -> Color.YELLOW;
                default -> Color.RED;
            };

            for (int j = 1; j <= 9; j++){ // For each number value...
                for (int k = 1; k <= 2; k++){ // Make 2 copies of each number
                    deck.add(numFactory.makeCard(c, Type.NUMBER, j));
                }
            }

            // Make 2 copies of each special card
            for (int j = 1; j <= 2; j++){
                deck.add(speFactory.makeCard(c, Type.SKIP, -1));
                deck.add(speFactory.makeCard(c, Type.REVERSE, -1));
                deck.add(speFactory.makeCard(c, Type.DRAW2, -1));
            }
        }
        deck.shuffle();
        pile.add(deck.drawCard());
    }


    public static void main(String [] args) throws InterruptedException
    {
        // Introduction
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello!");
        Thread.sleep(1200);
        System.out.println("Today, you'll be playing a Java version of Uno!");
        Thread.sleep(1200);
        System.out.println("This game of Uno is not 100% faithful to the real game.");
        Thread.sleep(1200);
        System.out.println("Most of the rules are as you expect!");
        System.out.println("You'll be playing against 3 bots, each with their own playstyle.\n");
        Thread.sleep(1200);
        System.out.println("Let's get your name.");
        System.out.print("Enter your name: ");
        String name = scan.nextLine(); 
        
        //// Make game objects
        // Deck
        createDeck(); 

        // Players 
        Player alice = new Player(new AliceStrategy(), "Alice"); // bot
        Player bobby = new Player(new BobbyStrategy(), "Bobby"); // bot
        Player carol = new Player(new CarolStrategy(), "Carol"); // bot
        Player input = new Player(new PlayerStrategy(), name); // human player

        DoublyLinkedTurns<Player> turnOrder = new DoublyLinkedTurns<>();
        turnOrder.add(input);
        turnOrder.add(alice);
        turnOrder.add(bobby);
        turnOrder.add(carol);
        
        // Players' Hands
        for (int i = 0; i < 7; i++){
            alice.drawCard(deck);
            bobby.drawCard(deck);
            carol.drawCard(deck);
            input.drawCard(deck);
        }

        // Start of game loop
        System.out.println("\nThe game is starting with:");
        System.out.println(pile.topCard() + "\n");
        Thread.sleep(600);

        // Game Loop
        IteratorTurns<Player> iter = turnOrder.iterator();
        while (iter.hasNext()){
            // Refill deck if needed
            if (deck.isEmpty()){
                System.out.println("Deck empty, shuffling pile into deck...");
                Card temp = pile.drawCard();
                while (!pile.isEmpty()){
                    deck.add(pile.drawCard());
                }
                deck.shuffle();
                pile.add(temp);
            }

            // Assess top of the pile
            Card top = pile.topCard();
            Player current = iter.next();

            if (top.getType() == Type.REVERSE){
                iter.reverse();
                // couldn't find a good way to do this --
                // when reverse is played, the person who played it gets an extra turn
                // I was able to reverse the order, but this was the way I did the extra turn aspect
                current = iter.next();
                current = iter.next();
                current = iter.next();

                System.out.println("\nTurn order flipped!");
                System.out.println("Extra play for " + current.toString() + "! ");
            } else if (top.getType() == Type.DRAW2){
                current.drawCard(deck, pile);
                current.drawCard(deck, pile);
            } else if (top.getType() == Type.SKIP){
                System.out.println(current.toString() + " was skipped over.\n");
                current = iter.next();
            }

            // Player turn
            current.playTurn(pile.topCard(), deck, pile);
            Thread.sleep(400);
        }
    }
}


