package es.iestetuan.acv.dao.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="T_COLOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JacksonXmlRootElement(localName="color")
@JsonRootName(value="color")
public class Color {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_color")
	//@JacksonXmlProperty(isAttribute=true, localName="cod_color")
	private int codigoColor;
	
	@Column(name="cod_hexadecimal")
	//@JacksonXmlProperty(localName="cod_hexadecimal")
	private String codigoHexadecimal;
	
	@Column(name="nombre")
	//@JacksonXmlProperty(localName="nombre")
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
	@Override
	public String toString() {
		return "Color [codigoColor=" + codigoColor + ", codigoHexadecimal=" + codigoHexadecimal + ", nombre=" + nombre
				+ "]";
	}
	
}
