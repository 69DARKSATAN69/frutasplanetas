package frutasplanetas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lector lector = new Lector();
		ArrayList<Fruta> frutas = new ArrayList<>();
		ArrayList<Planeta> planetas = new ArrayList<>();
		ArrayList todo = new ArrayList<>();
		ArrayList<String> todo2 = new ArrayList<>();
		int counterPlanetas = 0;
		int counterFrutas = 1;
		System.out.println("Leyendo fruta");
		ArrayList<String> lineas = lector.leer("C:\\programacion\\frutasplanetas\\frutas.txt");
		if (lineas.size() > 1) {
			System.out.println("Lista de fruta creada.");
		} else {
			System.out.println("Error al crear lista de fruta.");
		}

		System.out.println("Creando lista de fruta");
		for (String s : lineas) {
			Fruta fruta = new Fruta(s);
			frutas.add(fruta);
		}
		if (frutas.size() == lineas.size()) {
			System.out.println("Lista creada con exito.");
		} else {
			System.out.println("Error probable, la lista son " + frutas.size() + " en vez de " + lineas.size());
		}
		ArrayList<String> lineas2 = lector.leer("C:\\programacion\\frutasplanetas\\planetas.txt");
		if (lineas2.size() > 1) {
			System.out.println("Lista de planetas creada.");
		} else {
			System.out.println("Error al crear lista de planetas.");
		}

		System.out.println("Creando lista de planetas");
		for (String s : lineas2) {
			Planeta planeta = new Planeta(s);
			planetas.add(planeta);
		}
		if (planetas.size() == lineas2.size()) {
			System.out.println("Lista creada con exito.");
		} else {
			System.out.println("Error probable, la lista son " + planetas.size() + " en vez de " + lineas2.size());
		}

		todo.add(0, frutas.get(0));
		for (int i = 1; i < frutas.size() + planetas.size(); i++) {
			if (todo.get(i - 1) instanceof Fruta && counterPlanetas < planetas.size()) {
				todo.add(i, planetas.get(counterPlanetas));
				counterPlanetas++;

			} else if (todo.get(i - 1) instanceof Planeta || counterPlanetas >= planetas.size()) {
				todo.add(i, frutas.get(counterFrutas));
				counterFrutas++;

			}
		}

		try {
			PrintWriter pw = new PrintWriter((new BufferedWriter(new FileWriter("listadetodo.txt"))));
			for (int i = 0; i < todo.size(); i++) {
				pw.write(todo.get(i).toString());
				pw.write("\n");
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(Planeta p : planetas) {
			todo2.add(p.toString());
		}
		for(Fruta f : frutas) {
			todo2.add(f.toString());
		}
		
		todo2.sort(new ComparatorStrings());
		try {
			PrintWriter pw = new PrintWriter((new BufferedWriter(new FileWriter("listadetodo2.txt"))));
			for (int i = 0; i < todo2.size(); i++) {
				pw.write(todo2.get(i).toString());
				pw.write("\n");
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
