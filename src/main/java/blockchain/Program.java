package blockchain;

public class Program {

	// Numero aleatorio entre 5 y 15, que va a ser la cantidad de bloques
	public static int cantidad = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);

	// Inserción de un nuevo bloque en la blockchain
	public static void main(String[] argumentos) {
		// Declaramos Blockchain
		BlockChain MyBlockChain = new BlockChain();
		System.out.println("Comienza el programa");
		
		while(true) {
			System.out.println("¿Que desea hacer?");
			System.out.println("Pulse el numero correspondiente a la opcion.");
			System.out.println("");
			System.out.println("- Insertar un nuevo bloque en la blockchain");
			System.out.println("- Mostrar la información de cada uno de los bloques de la blockchain");
			System.out.println("- Fin del programa");
			System.out.println("");
			
			
			break;
		}

		for (int i = 1; i <= cantidad; i++) {
			MyBlockChain.NuevoBloque("Bloque " + i);
			System.out.println("Bloque insertado: " + MyBlockChain.getBlockchain().get(i).getData());
		}

		System.out.println("Fin del programa");
	}
}
