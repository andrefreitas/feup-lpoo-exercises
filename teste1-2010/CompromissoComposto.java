import java.util.Date;
import java.util.List;


public class CompromissoComposto extends Compromisso {
	//TODO: to fix this
	CompromissoComposto(Recurso[] recursos, List<Intervalo<Date>> tempos) throws ColisaoException {
		super(recursos, tempos.get(0).getInicio(), tempos.get(tempos.size()-1).getFim());
		for(int i=0; i<recursos.length;i++){
			if(recursos[i].horalivre!=null )
				if (tempos.get(0).getInicio().before(recursos[i].horalivre))
					if (tempos.get(0).getFim().after(recursos[i].horalivre))
						throw new ColisaoException();
			recursos[i].setHoraLivre(d2);
		}
		
	}

}
