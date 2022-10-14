package blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChain {
	private List<Block> blockchain = new ArrayList<>();
	public int prefix = 4;
	public String prefixString = new String(new char[prefix]).replace('\0', '0');

	public BlockChain() {
		Block b = new Block("Soy el Bloque génesis", "", 0);
		blockchain.add(b);
	}

	public void NuevoBloque(String data) {
		Block newBlock = new Block(data, // Datos
				blockchain.get(blockchain.size() - 1).getHash(), // Valor resumen del bloque previo
				new Date().getTime()); // Marca de tiempo en ms

		// Hacer primero sin minar
		// newBlock.mineBlock(prefix);
		blockchain.add(newBlock);
	}

	// Comprobación que la blockchain es válida
	public void Comprobar() {
		boolean flag = true;
		for (int i = 0; i < blockchain.size(); i++) {
			String previousHash = i == 0 ? "0" : blockchain.get(i - 1).getHash();
			flag = blockchain.get(i).getHash().equals(blockchain.get(i).calculateBlockHash())
					&& previousHash.equals(blockchain.get(i).getPreviousHash());
			// && blockchain.get(i).getHash().substring(0, prefix).equals(prefixString);
			if (!flag)
				break;
		}
	}

}
