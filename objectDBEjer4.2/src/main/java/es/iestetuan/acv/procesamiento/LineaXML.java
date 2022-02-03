package es.iestetuan.acv.procesamiento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class LineaXML {
	
	@JacksonXmlProperty(isAttribute=true, localName="cod_linea")
	private int codigoLinea;
	
	@JacksonXmlProperty(localName="nombre_corto")
	private String nombreCorto;
	
	@JacksonXmlProperty(localName="nombre_largo")
	private String nombreLargo;
	
	@JacksonXmlProperty(localName="cod_color")
	private int color;
	
	@JacksonXmlProperty(localName="kilometros")
	private float kilometros;
	
	@JacksonXmlProperty(localName="url_img_tmp")
	private String url;

	public int getCodigoLinea() {
		return codigoLinea;
	}

	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public float getKilometros() {
		return kilometros;
	}

	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LineaXML [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", color=" + color + ", kilometros=" + kilometros + ", url=" + url + "]";
	}

}
