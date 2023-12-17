import java.util.*; 

public class PlayerStrategy implements GameStrategy
{
    public Card findBestCard(Hand myHand, Card top){
        Card ret = null;

        // Print Selection
        System.out.println("The cards you have are:");
        for (int i = 0; i < myHand.size(); i++){
            Card temp = myHand.get(i);
            System.out.println(String.valueOf(i) + ": " + temp.toString());
        }

        // Check to see if they can even play a card
        int good = 0;
        for (int i = 0; i < myHand.size(); i++){
            Card temp = myHand.get(i);
            if (!temp.isPlayableOnStack(top)){
                good++;
            }
        }

        if (good == myHand.size()){
            System.out.println("You cannot play any cards this turn!");
            return ret;
        }

        System.out.println("It's your turn to go.");
        boolean done = false;
        while (!done){   
            System.out.println("Top Card:" + top.toString());
            // Get user input
            System.out.println("\nSelect the index of the card you want to play.");
            Scanner scan = new Scanner(System.in);  
            String input = scan.nextLine();
            int index = Integer.parseInt(input);

            // Check if valid
            Card temp = myHand.get(index);
            if (temp.isPlayableOnStack(top)){
                return myHand.play(index);
            } else {
                System.out.println("Invalid card!");
                System.out.println("Please try again");
                System.out.println("The cards you have are:");
                for (int i = 0; i < myHand.size(); i++){
                    Card ttemp = myHand.get(i);
                    System.out.println(String.valueOf(i) + ": " + ttemp.toString());
                }
                continue;
            }
        }

        return ret;
    }
}