
public class Pendular extends Comboio {

	Pendular(String nome) {
		super(nome);
	}
	@Override
	public ServicoABordo getServicoABordo() {
		servico= new ServicoSemEnjoos();
		return servico;
	}
}
