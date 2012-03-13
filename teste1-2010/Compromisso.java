import java.util.ArrayList;
import java.util.Date;


public class Compromisso {
	protected Recurso recursos[];
	protected Date d1;
	protected Date d2;
	Compromisso(Recurso[] recursos, Date d1, Date d2){
		this.d1=d1;
		this.d2=d2;
		this.recursos=recursos;
		for(int i=0; i<recursos.length;i++){
			recursos[i].addCompromisso(this);
		}
			
	}
	public Date getInicio() {
		return d1;
		
	}
	public Date getFim() {
		return d2;
	}
	public ArrayList<Recurso> getRecursos() {
		ArrayList<Recurso> temp= new ArrayList<Recurso>();
		for(int i=0; i<recursos.length;i++)
			temp.add(recursos[i]);
		return temp;
	}

}
