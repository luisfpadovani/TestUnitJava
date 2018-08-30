package br.com.fiap.test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Before;
import org.junit.Test;
import br.com.fiap.Financeiro; 
import junit.framework.Assert;

public class FinanceiroTest extends Assert {

	Financeiro calculoFinanceiro;

	@Before
	public void setUp() throws Exception { 
		calculoFinanceiro = new Financeiro();
	}
	
   
	@Test
	public void testCalcularCPMF_x_1000() { 
		Double cpmf = calculoFinanceiro.calcularCPMF(1000.00);
		assertEquals(cpmf, new Double(3.8));
	}

	@Test
	public void testCalcularIRRF_x_1000() { 
		Double irf = calculoFinanceiro.calcularIRRF(1000.00);
		assertEquals(irf, new Double(270));
	}
	 
	@Test
	public void testCalcularCPMF_x_0() { 
		Double cpmf = calculoFinanceiro.calcularCPMF(0.00);
		assertEquals(cpmf, new Double(0));
	}

	@Test
	public void testCalcularIRRF_x_0() { 
		Double irf = calculoFinanceiro.calcularIRRF(0.00);
		assertEquals(irf, new Double(0));
	}
	
	@Test
	public void testCalcularIRRF_x__lista() { 
		ArrayList<Double> resultado = new ArrayList<Double>();
		ArrayList<Double> contas = new ArrayList<Double>();
		Double resultadoFinal = 0.0;
		Double contasFinal = 0.0;
		
		resultado.add(3.8); 
		resultado.add(0.0);
		contas.add(calculoFinanceiro.calcularCPMF(1000.00));
		contas.add(calculoFinanceiro.calcularCPMF(0.00));


		for(Double item : resultado) {
			resultadoFinal +=item;
		}
		for(Double item : contas) {
			contasFinal +=item;
		} 
		assertEquals(resultado.size(), contas.size());
		assertEquals(resultadoFinal, contasFinal); 
	} 
	
	@Test
	public void testCalcularCPMF_x__lista() { 
		ArrayList<Double> resultado = new ArrayList<Double>();
		ArrayList<Double> contas = new ArrayList<Double>();
		Double resultadoFinal = 0.0;
		Double contasFinal = 0.0;
		
		resultado.add(new Double(270)); 
		resultado.add(0.0);
		contas.add(calculoFinanceiro.calcularIRRF(1000.00));
		contas.add(calculoFinanceiro.calcularIRRF(0.00));
		for(Double item : resultado) {
			resultadoFinal +=item;
		}
		for(Double item : contas) {
			contasFinal +=item;
		} 
		assertEquals(resultado.size(), contas.size());
		assertEquals(resultadoFinal, contasFinal); 
	} 

	@Test
	public void testeCalcularCPMF_valor_negativo() {
		Double cpmf = calculoFinanceiro.calcularCPMF(-50.00);
		assertEquals(cpmf, new Double(-0.19));
	}
	
	@Test
	public void testeCalcularIRRF_valor_negativo() {
		Double cpmf = calculoFinanceiro.calcularIRRF(-50.00);
		assertEquals(cpmf, new Double(-13.5));
	}

	@Test(expected=NullPointerException.class)
	public void testeCalcularCPMF_null() {
		Double valorEntrada = null;
		Double cpmf = calculoFinanceiro.calcularCPMF(valorEntrada); 
	}
	
	@Test(expected=NullPointerException.class)
	public void testeCalcularIRRF_null() {
		Double valorEntrada = null;
		Double cpmf = calculoFinanceiro.calcularCPMF(valorEntrada); 
	}


}
