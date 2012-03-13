

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;



public class TestAgendaJUnit3 extends TestCase {

	String nome1 = "Dr. José Silva";
	String nome2 = "Sra. Maria Raquel";
	String nome3 = "Sala A201";
	String nome4 = "Projector Epson EB-95 - 01";
	
	Recurso p1 = new Pessoa(nome1);
	Pessoa p2 = new Pessoa(nome2);	
	RecursoFisico s3 = new Sala(nome3, p2);
	RecursoFisico e4 = new Equipamento(nome4, p2);

	Date d1 = new Date(2010, 4, 15, 10, 30);
	Date d2  = new Date(2010, 4, 15, 11, 30);
	Date d3  = new Date(2010, 4, 15, 12, 30);
	Date d4  = new Date(2010, 4, 15, 13, 30);
	

	public void testCriarPessoa() {		
		assertEquals(nome1, p1.getNome());
	}

	
	public void testCriarSala() {		
		assertEquals(nome3, s3.getNome());
		assertEquals(p2, s3.getResponsavel());
	}
	
	
	public void testCriarEquipamento() {
		assertEquals(nome4, e4.getNome());
		assertEquals(p2, e4.getResponsavel());
	}
	
	/*
	 * Teste de compromisso envolvendo v�rios recursos,
	 * mas um intervalo de tempo simples.
	 */
	
	public void testCriarCompromissoSimples() throws ColisaoException {
		Recurso[] recursos = {p1, s3, e4};
		
		Compromisso c1 = new CompromissoSimples(recursos, d1, d2);
		
		assertEquals(d1, c1.getInicio());
		assertEquals(d2, c1.getFim());	

		for (Recurso r : recursos) {
			assertTrue(c1.getRecursos().contains(r));
			assertTrue(r.getCompromissos().contains(c1));
		}
	}
	
	
	public void testIntervaloTempo() {
		Intervalo<Date> d12 = new Intervalo<Date>(d1, d2);
		assertEquals(d1, d12.getInicio());
		assertEquals(d2, d12.getFim());
	}
	
	
	public void testIntervalosTempoSobrepostos() {
		Intervalo<Date> d12 = new Intervalo<Date>(d1, d2);
		Intervalo<Date> d23 = new Intervalo<Date>(d2, d3);
		Intervalo<Date> d13 = new Intervalo<Date>(d1, d3);
		assertFalse(d12.overlaps(d23));
		assertTrue(d12.overlaps(d13));
	}
	
	public void testIntervaloTempoInvalido() {
		try {
			new Intervalo<Date>(d2, d1);
			fail("Devia ter lan�ado IllegalArgumentException");
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	

	public void testColisaoCompromissosSimples() throws ColisaoException {
		Recurso[] rr1 = {p1, s3, e4};		
		Recurso[] rr2 = {s3};		
		Compromisso c1 = new CompromissoSimples(rr1, d1, d2);
		
		// Este deve dar colis�o e lan�ar excep��o
		try {
			Compromisso c2 = new CompromissoSimples(rr2, d1, d3);	
			fail("Devia ter lan�ado excep��o");
		}
		catch (ColisaoException e) {			
		}

		// Este n�o deve dar colis�o 
		Compromisso c2 = new CompromissoSimples(rr1, d2, d3);		

	} 
	
	/*
	 * Teste de compromisso envolvendo v�rios recursos,
	 * e v�rios intervalos de tempo.
	 */

	public void testCriarCompromissoComposto() throws ColisaoException {
		Recurso[] recursos = {p1, e4, s3};
		Intervalo<Date> d12 = new Intervalo<Date>(d1, d2);
		Intervalo<Date> d34 = new Intervalo<Date>(d3, d4);
		List<Intervalo<Date>> tempos = new ArrayList<Intervalo<Date>>();
		tempos.add(d12);
		tempos.add(d34);

		Compromisso c1 = new CompromissoComposto(recursos, tempos);
		
		assertEquals(d1, c1.getInicio());
		assertEquals(d4, c1.getFim());	

		for (Recurso r : recursos) {
			assertTrue(c1.getRecursos().contains(r));
			assertTrue(r.getCompromissos().contains(c1));
		}
	}

	/*
	public void testColisaoComplexa() throws ColisaoException {
		Recurso[] recursos1 = {p1, e4, s3};
		Recurso[] recursos2 = {p2, s3};
		Recurso[] recursos3 = {p2};
		Intervalo<Date> d12 = new Intervalo<Date>(d1, d2);
		Intervalo<Date> d34 = new Intervalo<Date>(d3, d4);
		List<Intervalo<Date>> tempos = new ArrayList<Intervalo<Date>>();
		tempos.add(d12);
		tempos.add(d34);
		Compromisso c1 = new CompromissoComposto(recursos1, tempos);	
		
		// Este compromisso deve dar colis�o e lan�ar excep��o
		try {
			Compromisso c2 = new CompromissoSimples(recursos2, d1, d2);
			fail("Devia ter lan�ado excep��o");
		}
		catch (ColisaoException e) {
		}
		
		// Estes n�o devem dar colis�o
		Compromisso c3 = new CompromissoSimples(recursos1, d2, d3);		
		Compromisso c4 = new CompromissoSimples(recursos3, d1, d2);		
	} */
}
