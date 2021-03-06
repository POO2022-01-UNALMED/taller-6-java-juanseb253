package vehiculos;
import java.util.ArrayList;
import java.util.Collections;
public class Fabricante {
	private String nombre;
	private Pais pais;
	
	public Fabricante(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static Fabricante fabricaMayorVentas() {
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		ArrayList<Integer> cantporfab = new ArrayList<Integer>();
		for (int l=0;l<Vehiculo.lista.size();l++) {
			Fabricante f=Vehiculo.lista.get(l).getFabricante();
			if (!fabricantes.contains(f)) {
				fabricantes.add(f);
				int ci=0;
				for (int t=0;t<Vehiculo.lista.size();t++) { 
					Fabricante d=Vehiculo.lista.get(t).getFabricante();
					if(d.equals(f)) {
						ci++;
					}
				}
				cantporfab.add(ci);
			}
		}
		Integer maximo = Collections.max(cantporfab);
		for (int j=0;j<cantporfab.size();j++) {
			if(cantporfab.get(j)==maximo) {
				return fabricantes.get(j);
			}
		}
		return null;
		
	}
}
