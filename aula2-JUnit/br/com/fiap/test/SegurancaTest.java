package br.com.fiap.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fiap.Seguranca;


public class SegurancaTest extends Assert {

	Seguranca seguranca;

	@Before
	public void setUp() throws Exception {
		System.out.println("SegurancaTest.setUp");
		seguranca = new Seguranca();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("SegurancaTest.tearDown");
	}

	
	@Test
	public void recuperarIniciaisNome() {
		String iniciais = seguranca.recuperarIniciaisNome("Albert da Costa");
		assertEquals(iniciais, "ADC");
	}
	
	@Test
	public void criptografar() throws Exception{
		String nome = new String(seguranca.criptografar("chave457", "Fiap"));
		assertNotNull(nome);
	}
	
	@Test
	public void descriptografar() throws Exception{
		byte[] nome = seguranca.criptografar("chave457", "Fiap");
		String nome1 = seguranca.descriptografar("chave457", nome);
		assertEquals(nome1, "Fiap");
	}
}
