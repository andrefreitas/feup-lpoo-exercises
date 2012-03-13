
public class RecursoFisico extends Recurso{
	protected Pessoa pessoa;
	RecursoFisico(String nome, Pessoa p){
		super(nome);
		pessoa=p;
	}
	public String getNome() {
		return name;
	}
	public Pessoa getResponsavel() {
		return pessoa;
	}
}
