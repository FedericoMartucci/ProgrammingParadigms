package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class GrupoFormas implements Forma {
    private List<Forma> formas = new ArrayList<>();

    public void agregarFigura(Forma forma) {
    	formas.add(forma);
    }
    
	@Override
	public double getArea() {
		double areaTotal = 0;
		for(Forma forma : formas) {
			areaTotal += forma.getArea();
		}
		return areaTotal;
	}

}
