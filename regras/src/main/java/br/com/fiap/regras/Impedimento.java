package br.com.fiap.regras;

public class Impedimento {

	public boolean estaImpedido(double posicaoAtaque, double posicaoDefesa) {
		if (posicaoAtaque > posicaoDefesa) {
			return true;
		} else {
			return false;
		}
	}
}
