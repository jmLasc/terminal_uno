public abstract class Card
{
    private Color color;
    private Type type;
    private int value = -1;
    
    public Card(Color c, Type t, int v){
        color = c;
        type = t;
        value = v;
    }

    public Color getColor(){ // Only need getters since card properties are static
        return color;
    }

    public Type getType(){
        return type;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        if (type == Type.NUMBER){
            return color + " " + value;
        } else {
            return color + " " + type;
        }
    }

    abstract boolean isPlayableOnStack(Card c);
}