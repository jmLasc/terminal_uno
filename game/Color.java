import java.awt.*;

public enum Color
{
    RED("RED", 0),
    BLUE("BLU", 1),
    GREEN("GRN", 2),
    YELLOW("YEL", 3);

    private final String name;
    private final int index;

    public static final String R = "\u001B[31m";
    public static final String B = "\u001B[36m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

    
    Color(String n, int i){
        name = n;
        index = i;
    }

    public String toString(){
        String ret = "";

        switch (index){ // Get Color
            case 0:
                ret += R + name + RESET;
                break;
            case 1:
                ret += B + name + RESET;
                break;
            case 2:
                ret += G + name + RESET;
                break;
            case 3:
                ret += Y + name + RESET;
                break;
        }

        return ret;
    }
}