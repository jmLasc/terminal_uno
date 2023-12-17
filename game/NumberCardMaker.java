public class NumberCardMaker implements CardMaker
{
    public Card makeCard(Color c, Type t, int v){
        return new NumberCard(c, t, v);
    }
}