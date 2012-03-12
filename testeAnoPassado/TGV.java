
public class TGV extends Comboio {

	TGV(String nome) {
		super(nome);
	}
	public String toString(){
		String lug="lugar";
		String carr="carruagem";
		String pass="passageiro";
		if(getNumLugares()>1 | getNumLugares()==0 ) lug="lugares";
		if(getNumCarruagens()>1 | getNumCarruagens()==0) carr="carruagens";
		if(getNumPassageiros()>1 | getNumPassageiros()==0) pass="passageiros";
		String info="TGV "+ nome +", "+ getNumCarruagens()+ " "+carr+", " + getNumLugares() + " "+lug+", " + getNumPassageiros() + " "+pass;
		return info;
		
	}
	@Override
	public ServicoABordo getServicoABordo() {
		servico= new ServicoPrioritario();
		return servico;
	}

}
