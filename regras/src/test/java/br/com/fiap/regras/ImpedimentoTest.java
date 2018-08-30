package br.com.fiap.regras;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ImpedimentoTest {

	@Test
	public void testImpedidoFalse() {
		Impedimento impedimento = new Impedimento();
		boolean impedido = impedimento.estaImpedido(105.10, 105.0);
		assertTrue(impedido);
	}
	
	@Test
	public void testImpedidoTrue() {
		Impedimento impedimento = new Impedimento();
		boolean impedido = impedimento.estaImpedido(105.0, 105.10);
		assertTrue(!impedido);
	}

}
