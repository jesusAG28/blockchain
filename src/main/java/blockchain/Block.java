package blockchain;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class Block {

	private String hash; // Valor resumen del bloque actual
	private String previousHash; // Valor resumen del bloque previo
	private String data; // any information having value, like a contract
	private long timeStamp; // Marca de tiempo
	private int nonce; // "number only used once". Es usado para la PoW.

	public Block(String data, String previousHash, long timeStamp) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = timeStamp;
		this.hash = calculateBlockHash();
	}

	public String getHash() {
		return this.hash;
	}

	public int getOnce() {
		return this.nonce;
	}

	public String getPreviousHash() {
		return this.previousHash;
	}

	public String calculateBlockHash() {
		// Se concatena la información del bloque para calcular el resumen
		String dataToHash = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data;

		MessageDigest digest = null;

		byte[] bytes = null;

		try {
			digest = MessageDigest.getInstance("SHA-256");
			bytes = digest.digest(dataToHash.getBytes(Charset.forName("UTF-8")));
		} catch (Exception ex) {
		}

		StringBuffer buffer = new StringBuffer();
		for (byte b : bytes) {
			buffer.append(String.format("%02x", b));
		}

		return buffer.toString();
	}

}
