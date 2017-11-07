package utils;

@SuppressWarnings("serial")
public class ElementoNoEncontradoException extends Exception{
	
	private String descripcion;
	
	public ElementoNoEncontradoException(String mensaje) {
		super(mensaje);
		this.descripcion="No se pudo encontrar el elemento: ";
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
