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
		String dataToHash = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + getData();

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

	/*
	 * Minar un bloque significa resolver un problema complejo Por ejemplo: Calcular
	 * el un hash que contenga 4 '0's seguidos al comienzo.
	 * 
	 */
	public String mineBlock(int prefix) {
		String prefixString = new String(new char[prefix]).replace('\0', '0');
		while (!hash.substring(0, prefix).equals(prefixString)) {
			nonce = nonce + 1;
			hash = calculateBlockHash();
		}
		return hash;
	}

	public String getData() {
		return data;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

}
