package utils;

@SuppressWarnings("serial")
public class PaginaNoEncontradaException extends Exception {

	private static String descripcion = "No se encuentra en la página esperada: ";

	public PaginaNoEncontradaException(String mensaje) {
		super(descripcion + mensaje);
	}

	public String getDescripcion() {
		return descripcion;
	}
}
