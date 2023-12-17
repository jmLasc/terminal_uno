public class SpecialCard extends Card
{
    public SpecialCard(Color c, Type t, int v){
        super(c, t, v);
    }

    public boolean isPlayableOnStack(Card c){
        if (this.getColor() == c.getColor()){
            return true;
        }
        if ((this.getType() == c.getType())){
            return true;
        }
        return false;
    }
}