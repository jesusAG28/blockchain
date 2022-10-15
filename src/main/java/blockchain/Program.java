package blockchain;

import java.util.Scanner;

public class Program {

	public static boolean goOn = true;

	static int selection;
	static Long tInicio, tFin, tTotal, segundos;
	static String enter;
	static Scanner input = new Scanner(System.in);

	// Declaramos Blockchain
	static BlockChain MyBlockChain = new BlockChain();

	public static void readKey() {
		selection = input.nextInt();
		switch (selection) {
		case 1:
			// Insertar un nuevo bloque en la blockchain
			System.out.println("------------------------------");
			System.out.println("Escribe la informacion del bloque: ");
			input.nextLine();
			String data = input.nextLine();
			System.out.println("");
			System.out.println("Generando bloque");
			tInicio = System.currentTimeMillis(); // Calculamos el tiempo quue tarda en encontrar un hash correcto
			MyBlockChain.NuevoBloque(data);
			tFin = System.currentTimeMillis();
			tTotal = tFin - tInicio;
			segundos = (long) (tTotal/1000.0);
			System.out.println("Bloque generado correctamente en " + tTotal + " ms, " + segundos + " s");
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("Pulsa enter para continuar");
			input.nextLine();
			// enter = input.nextLine();
			break;
		case 2:
			// Mostrar la información de cada uno de los bloques de la blockchain
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("Informacion de todos los bloques de la cadena: ");
			for (int i = 0; i < MyBlockChain.getBlockchain().size(); i++) {
				System.out.println("Bloque " + i);
				System.out.println(" - data         => " + MyBlockChain.getBlockchain().get(i).getData());
				System.out.println(" - nonce        => " + MyBlockChain.getBlockchain().get(i).getOnce());
				System.out.println(" - hash         => " + MyBlockChain.getBlockchain().get(i).getHash());
				System.out.println(" - previousHash => " + MyBlockChain.getBlockchain().get(i).getPreviousHash());
				System.out.println(" - timeStamp => " + MyBlockChain.getBlockchain().get(i).getTimeStamp());
			}
			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("Pulsa enter para continuar");
			input.nextLine();
			enter = input.nextLine();
			break;
		case 3:
			// Finalizar programa
			goOn = false;
			break;
		default:
			// Consituna el programa a la espera de in input valido
		}
	}

	public static void showMenu() {
		System.out.println("¿Que desea hacer? Pulse el numero correspondiente a la opcion y enter.");
		System.out.println("");
		System.out.println("1 Insertar un nuevo bloque en la blockchain");
		System.out.println("2 Mostrar la información de cada uno de los bloques");
		System.out.println("3 Finalizar programa");
		System.out.println("");
	}

	// Inserción de un nuevo bloque en la blockchain
	public static void main(String[] argumentos) {

		while (goOn) {
			showMenu();
			readKey();
		}

		System.out.println("");
		System.out.println("Hasta luego!");
		System.out.println("");
	}
}
