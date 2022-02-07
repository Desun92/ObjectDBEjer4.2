package es.iestetuan.acv.procesamiento;

public class ColorDTO {
	
	private int codigoColor;
	private String codigoHexadecimal;
	private String nombre;
	
	public int getCodigoColor() {
		return codigoColor;
	}
	public void setCodigoColor(int codigoColor) {
		this.codigoColor = codigoColor;
	}
	public String getCodigoHexadecimal() {
		return codigoHexadecimal;
	}
	public void setCodigoHexadecimal(String codigoHexadecimal) {
		this.codigoHexadecimal = codigoHexadecimal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String toString() {
		return "ColorDTO [codigoColor=" + codigoColor + ", codigoHexadecimal=" + codigoHexadecimal + ", nombre="
				+ nombre + "]";
	}
}
