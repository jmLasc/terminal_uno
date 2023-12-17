public class NumberCard extends Card
{
    public NumberCard(Color c, Type t, int v){
        super(c, t, v);
    }

    public boolean isPlayableOnStack(Card c){
        if (this.getColor() == c.getColor()){
            return true;
        }
        if (this.getValue() == c.getValue()){
            return true;
        }
        return false;
    }
}