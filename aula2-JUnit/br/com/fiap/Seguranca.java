package br.com.fiap;

import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Seguranca {

	public String recuperarIniciaisNome(String nomeCompleto) {
		String iniciais = "";
		StringTokenizer stringTokenizer = new StringTokenizer(nomeCompleto, " ");
		while (stringTokenizer.hasMoreTokens()) {
			iniciais += stringTokenizer.nextToken().substring(0, 1)
					.toUpperCase();
		}
		return iniciais;
	}

	private static byte[] crypto(boolean dir, byte[] password, byte[] text)
			throws Exception {
		DESKeySpec keySpec = new DESKeySpec(password);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(dir ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, factory
				.generateSecret(keySpec));
		return cipher.doFinal(text);
	}

	public byte[] criptografar(String password, String text)
			throws Exception {
		return crypto(true, password.getBytes(), text.getBytes());
	}

	public String descriptografar(String password, byte[] text)
			throws Exception {
		return new String(crypto(false, password.getBytes(), text));
	}

}
