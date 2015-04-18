package Manos;
import java.util.Collections;
import java.util.List;

public class Manos {

	List<Mano> manos;

	public List<Mano> getManos() {
		return manos;
	}

	public Manos(List<Mano> manos) {
		this.manos = manos;
	}

	public void setManos(List<Mano> manos) {
		this.manos = manos;
	}

	public void encontrarGanador() {
		for (Mano m : manos) {
			m.clasificar();
		}
		Collections.sort(manos, new ComparadorMano());
	}
}
