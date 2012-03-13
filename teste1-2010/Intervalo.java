import java.util.Date;


public class Intervalo<T> {
	public Intervalo(T d1, T d2) {
		if (((Date) d1).after(((Date)d2)))
			throw new IllegalArgumentException();
		a=d1;
		b=d2;
	}
	protected T a;
	protected T b;
	public T getInicio() {
		return a;
	}
	public T getFim() {
		return b;
	}
	public boolean overlaps(Intervalo<Date> d23) {
		return ( ( ((Date) getFim()).after(d23.getInicio()) && ((Date) getFim()).before(d23.getFim()) )
				|| ( ((Date) d23.getFim()).after((Date) getInicio())) && ((Date) d23.getInicio()).after((Date) getFim())) ;		

	}
}
