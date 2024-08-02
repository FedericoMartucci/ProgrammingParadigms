package objetos.ejercicio01;

public class Nota {
	
	private int valor;
	
    /**
     * pre : valorInicial está comprendido entre 0 y 10.
     * post: inicializa la Nota con el valor indicado.
     */
    public Nota(int valorInicial) {
    	this.valor = valorInicial;
    }
    
    /**
     * post: devuelve el valor numérico de la Nota,
     *       comprendido entre 0 y 10.
     */
    public int obtenerValor() {
    	return this.valor;
    }
    
    /**
     * post: indica si la Nota permite o no la aprobación.
     */
    public boolean aprobado() {
    	return this.valor >= 4;
    }
    
    /**
     * post: indica si la Nota implica desaprobación.
     */
    public boolean desaprobado() {
    	return this.valor < 4;
    }
    
    /**
    * pre : nuevoValor está comprendido entre 0 y 10.
    * post: modifica el valor numérico de la Nota, cambiándolo
    * por nuevoValor, siempre y cuando nuevoValor sea superior al
    * valor numérico actual de la Nota.
    */
    public void recuperar(int nuevoValor) {
    	if(this.valor < nuevoValor)
    		this.valor = nuevoValor;
    }
}
