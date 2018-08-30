package br.com.fiap;


public class Financeiro {

	public double calcularCPMF(double valor) {
		return valor * 0.0038;
	}

	public double calcularIRRF(double valor) {
		return valor * 0.27;
	}
}
