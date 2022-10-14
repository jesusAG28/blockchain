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
		getBlockchain().add(b);
	}

	public void NuevoBloque(String data) {
		Block newBlock = new Block(data, // Datos
				getBlockchain().get(getBlockchain().size() - 1).getHash(), // Valor resumen del bloque previo
				new Date().getTime()); // Marca de tiempo en ms

		// Hacer primero sin minar
		// newBlock.mineBlock(prefix);
		newBlock.mineBlock(4);
		getBlockchain().add(newBlock);
	}

	// Comprobación que la blockchain es válida
	public void Comprobar() {
		boolean flag = true;
		for (int i = 0; i < getBlockchain().size(); i++) {
			String previousHash = i == 0 ? "0" : getBlockchain().get(i - 1).getHash();
			flag = getBlockchain().get(i).getHash().equals(getBlockchain().get(i).calculateBlockHash())
					&& previousHash.equals(getBlockchain().get(i).getPreviousHash());
			// && blockchain.get(i).getHash().substring(0, prefix).equals(prefixString);
			if (!flag)
				break;
		}
	}

	public List<Block> getBlockchain() {
		return blockchain;
	}

}
