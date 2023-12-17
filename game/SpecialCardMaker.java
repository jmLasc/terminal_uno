public class SpecialCardMaker implements CardMaker
{
    public Card makeCard(Color c, Type t, int v){
        return new SpecialCard(c, t, v);
    }
}