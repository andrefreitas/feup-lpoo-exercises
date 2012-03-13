
public class Carruagem {
	protected int capacidade;
	protected int lugares;
	Carruagem(int n){
		lugares=n;
		capacidade=n;
	}
	public int getNumLugares() {
		return lugares;
	}
	public int getNumPassageiros(){
		return capacidade-lugares;
	}
	public void addPassageiros(int i){
		lugares=lugares-i;
	}
	
	public void removePassageiros(int n){
		lugares=lugares+n;
	}
	public void removePassageiros(){
		lugares=capacidade;
	}
	public int getCapacidade(){
		return capacidade;
	}
}
