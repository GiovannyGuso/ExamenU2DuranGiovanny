package grafo.aydacencia;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GrafoAdcia grafo = new GrafoAdcia(20);

		while (true) {
			System.out.println("///////////////////////////////////////////////////////////////////////////");
			System.out.println("Menu");
			System.out.println("1. Agregar nuevo vértice");
			System.out.println("2. Agregar nuevo arco");
			System.out.println("3. Verificar si dos vértices son adyacentes");
			System.out.println("4. Realizar DFS");
			System.out.println("5. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer
			switch (opcion) {
			case 1:
				System.out.print("\n");
				System.out.print("Digite la cantidad de vértices que desea agregar: ");
				int numVerticesAgregar = scanner.nextInt();
				while (numVerticesAgregar >20 || numVerticesAgregar < 1) {
					System.out.print("No puede ingresar cantidad de vertices mayor a 20 y menos a 1");
					System.out.print("*****************************************************************");
					System.out.print("Digite nuevamente la cantidad de vertices");
					numVerticesAgregar = scanner.nextInt();
				}
				scanner.nextLine(); // Limpiar el buffer
				for (int i = 0; i < numVerticesAgregar; i++) {
					if (grafo.numVerts >= GrafoAdcia.maxVerts) {
						System.out.println("Se ha alcanzado el límite máximo de vértices (20).");
						break;
					}
					System.out.print("Ingrese el nombre del vértice " + (i + 1) + ": ");
					String nombreVertice = scanner.nextLine();

					if (nombreVertice.isEmpty()) {
						System.out.println("El nombre del vértice no puede estar vacío.");
						continue;
					}
					if (grafo.numVertice(nombreVertice) >= 0) {
						System.out.println("El vértice ya existe en el grafo.");
						continue;
					}
					grafo.nuevoVertice(nombreVertice);
					System.out.println("Vértice agregado.");
				}
				break;
			case 2:
				System.out.print("\n");
				System.out.print("Ingrese el nombre del vértice origen: ");
				String origen = scanner.nextLine();
				System.out.print("Ingrese el nombre del vértice destino: ");
				String destino = scanner.nextLine();
				grafo.nuevoArco(origen, destino);
				System.out.println("Arco agregado.");
				break;
			case 3:
				System.out.print("\n");
				System.out.print("Ingrese el nombre del vértice 1: ");
				String vertice1 = scanner.nextLine();
				System.out.print("Ingrese el nombre del vértice 2: ");
				String vertice2 = scanner.nextLine();
				boolean adyacentes = grafo.sonAdyacentes(vertice1, vertice2);
				if (adyacentes) {
					System.out.println("Los vértices son adyacentes.");
				} else {
					System.out.println("Los vértices no son adyacentes.");
				}
				break;
			case 4:
				System.out.print("\n");
				System.out.print("Ingrese el vértice de inicio para DFS: ");
				int inicioDFS = scanner.nextInt();
				grafo.DFS(inicioDFS);
				break;
			case 5:
				System.out.print("\n");
				System.out.println("Saliendo del programa...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opción inválida.");
				break;
			}
		}
	}
}
