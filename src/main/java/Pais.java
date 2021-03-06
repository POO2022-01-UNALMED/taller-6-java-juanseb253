package vehiculos;
import java.util.ArrayList;
import java.util.Collections;
public class Pais {
	private String nombre;
	
	public Pais(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static Pais paisMasVendedor() {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		ArrayList<Integer> cantporPais = new ArrayList<Integer>();
		for (int i=0;i<Vehiculo.lista.size();i++) {
			Pais a=Vehiculo.lista.get(i).getFabricante().getPais();
			if (!paises.contains(a)) {
				paises.add(a);
				int vi=0;
				for (int t=0;t<Vehiculo.lista.size();t++) { 
					Pais c=Vehiculo.lista.get(t).getFabricante().getPais();
					if(c.equals(a)) {
						vi++;
					}
				}
				cantporPais.add(vi);
			}
		}
		Integer maximo = Collections.max(cantporPais);
		for (int g=0;g<cantporPais.size();g++) {
			if(cantporPais.get(g)==maximo) {
				return paises.get(g);
			}
		}
		return null;
	}
}
