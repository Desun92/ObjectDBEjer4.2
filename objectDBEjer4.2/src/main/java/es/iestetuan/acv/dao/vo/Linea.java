package es.iestetuan.acv.dao.vo;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="T_LINEA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Linea {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_linea")
	private int codigoLinea;
	
	@Column(name="nombre_corto")
	private String nombreCorto;
	
	@Column(name="nombre_largo")
	private String nombreLargo;
	
	@OneToOne
	@JoinColumn(name="cod_color", foreignKey = @ForeignKey(name="fk_color"))
	private Color color;
	
	@Column(name="kilometros")
	private float kilometros;
	
	@Column(name="url")
	private String url;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="imagen")
	private byte[] imagen;
	
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
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
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Linea [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", color=" + color + ", kilometros=" + kilometros + "]";
	}
	
}
