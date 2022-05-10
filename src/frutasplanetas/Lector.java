package frutasplanetas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lector {

	private String linea;
	
	public ArrayList<String> leer(String direccion) {
		BufferedReader br = null;
		ArrayList<String> lista = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(direccion));
			linea = br.readLine();
			while(linea!=null) {
				lista.add(linea);
				linea = br.readLine();
			}
			
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
		
	}
	
	
	
	
	
}
