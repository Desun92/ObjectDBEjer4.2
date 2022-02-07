package es.iestetuan.acv.procesamiento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LineaDTO {
	
	@JacksonXmlProperty(localName = "codigoLinea")
	private int codigoLinea;
	
	@JacksonXmlProperty(localName = "nombreCorto")
	private String nombreCorto;
	
	@JacksonXmlProperty(localName = "nombreLargo")
	private String nombreLargo;
	
	@JacksonXmlProperty(localName = "color")
	private ColorDTO colorDTO;
	
	@JacksonXmlProperty(localName = "kilometros")
	private float kilometros;
	
	@JacksonXmlProperty(localName = "urlImagen")
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
	public float getKilometros() {
		return kilometros;
	}
	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String urlImagen) {
		this.url = urlImagen;
	}
}
