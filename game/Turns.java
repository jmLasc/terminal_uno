public interface Turns<T>
{
	void add (T item);
	int size();
	IteratorTurns<T> iterator();
}
