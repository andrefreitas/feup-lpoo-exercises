import java.util.ArrayList;
import java.util.Date;


public class Recurso {
	protected String name;
	protected ArrayList<Compromisso> compromissos;
	public Date horalivre;
	Recurso(String n){
		name=n;
		compromissos=new ArrayList<Compromisso>();
	}
	public String getNome() {
		return name;
	}
	public void addCompromisso(Compromisso c1){
		compromissos.add(c1);
	}
	public ArrayList<Compromisso> getCompromissos() {
		return compromissos;
	}
	public void setHoraLivre(Date hl){
		horalivre=hl;
	}
}
