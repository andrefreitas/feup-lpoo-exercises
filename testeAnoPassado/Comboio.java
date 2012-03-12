import java.util.ArrayList;


public class Comboio {
	protected String nome;
	protected ArrayList<Carruagem> carruagens;
	ServicoABordo servico;
	Comboio(String nome){
		this.nome =nome;
		carruagens=new ArrayList(); 
	}
	public String getNome(){
		return nome;
	}
	public int getNumLugares() {
		int soma=0;
		for (int i=0; i<carruagens.size(); i++){
			soma=soma+  carruagens.get(i).getCapacidade();
		}
		return soma;
	}
	public int getNumCarruagens() {
		return carruagens.size();
	}
	public void addCarruagem(Carruagem a1) {
		carruagens.add(a1);
		
	}
	public Carruagem getCarruagemByOrder(int i) {
		return carruagens.get(i);
	}
	public void removeAllCarruagens(int i) {
		for (int j=0; j<carruagens.size(); j++){
			if (carruagens.get(j).getNumLugares()==i){
				carruagens.remove(j);
				j--;
			}
			
		}
		
	}
	public int getNumPassageiros() {
		int soma=0;
		for (int i=0; i<carruagens.size(); i++){
			soma=soma+carruagens.get(i).getNumPassageiros();
		}
		return soma;
	}
	public int getLugaresLivres() {
		int soma=0;
		for (int i=0; i<carruagens.size(); i++){
			soma=soma+carruagens.get(i).getNumLugares();
		}
		return soma;
	}
	public void addPassageiros(int i) throws PassengerCapacityExceeded {
		boolean success=false;
		for (int j=0; j<carruagens.size(); j++){
			int aux;
			if(carruagens.get(j).getNumLugares()<i) {
				aux=i-carruagens.get(j).getNumLugares();
				i=i-aux;
			}
			else {
				carruagens.get(j).addPassageiros(i);
				success=true;
				break;
			}
				carruagens.get(j).addPassageiros(aux);
		}
		if(success==false) throw new PassengerCapacityExceeded();
		
	}
	public void removePassageiros(int i) {
		for (int j=0; j<carruagens.size(); j++){
			if(carruagens.get(j).getNumPassageiros()<i){
				i=i-carruagens.get(j).getNumPassageiros();
				carruagens.get(j).removePassageiros();
			}
			else carruagens.get(j).removePassageiros(i);
		}
		
	}
	public void removePassageiros() {
		for (int j=0; j<carruagens.size(); j++)
			carruagens.get(j).removePassageiros();
		
	}
	@Override
	public String toString(){
		String lug="lugar";
		String carr="carruagem";
		String pass="passageiro";
		if(getNumLugares()>1 | getNumLugares()==0 ) lug="lugares";
		if(getNumCarruagens()>1 | getNumCarruagens()==0) carr="carruagens";
		if(getNumPassageiros()>1 | getNumPassageiros()==0) pass="passageiros";
		String info="Comboio "+ nome +", "+ getNumCarruagens()+ " "+carr+", " + getNumLugares() + " "+lug+", " + getNumPassageiros() + " "+pass;
		return info;
		
	}
	@Override
	public boolean equals(Object b){
		if(getNumCarruagens()==0 & ((Comboio)b).getNumCarruagens()==0) return true;
		if(((Comboio)b).getNumCarruagens()!=getNumCarruagens()) return false;
		for (int i=0; i<carruagens.size();i++){
			if(carruagens.get(i).getCapacidade()!=((Comboio)b).carruagens.get(i).getCapacidade()) return false;
		}
		return true;
	}
	public ServicoABordo getServicoABordo() {
		servico= new ServicoRegular();
		return servico;
	}
	public String getDescricaoServico() {
		
		return servico.getDescricaoServico();
	}
	public void setServicoABordo(ServicoPrioritario servicoPrioritario) {
		servico=servicoPrioritario;
		
	}
}
