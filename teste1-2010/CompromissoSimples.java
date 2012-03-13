import java.util.Date;


public class CompromissoSimples extends Compromisso  {

	 CompromissoSimples(Recurso[] recursos, Date d1, Date d2) throws ColisaoException {
		super(recursos,d1,d2);
		for(int i=0; i<recursos.length;i++){
			if(recursos[i].horalivre!=null && d1.before(recursos[i].horalivre)) throw new ColisaoException();
			recursos[i].setHoraLivre(d2);
		}
	}

}