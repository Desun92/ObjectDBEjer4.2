package es.iestetuan.acv.objectDBEjer42.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.iestetuan.acv.dao.jpa.ColorJPA;
import es.iestetuan.acv.dao.jpa.LineaJPA;
import es.iestetuan.acv.dao.vo.Color;
import es.iestetuan.acv.dao.vo.Linea;
import es.iestetuan.acv.procesamiento.ColorDTO;
import es.iestetuan.acv.procesamiento.LineaDTO;

@RestController
public class LineaRestController {
	
	@GetMapping(path="/rest/lineas", produces = {"application/json"})
	public List<LineaDTO> consultarLineas(){
		
		LineaJPA operacionLinea = new LineaJPA();
		List<Linea> listaLineas = operacionLinea.consultarLista();
		List<LineaDTO> listaLineasDTO = new ArrayList<LineaDTO>();
		
		for(Linea linea : listaLineas) {
			LineaDTO lineaDTO = new LineaDTO();
			BeanUtils.copyProperties(linea, lineaDTO);
			
			ColorDTO colorDTO = new ColorDTO();
			BeanUtils.copyProperties(linea.getColor(), colorDTO);
			
			lineaDTO.setColorDTO(colorDTO);
			listaLineasDTO.add(lineaDTO);
		}
		return listaLineasDTO;
	}
	
	@GetMapping(path="/rest/linea/{codigoLinea}", produces={"application/json"})
	public Linea getColor(@PathVariable int codigoLinea) {
		
		LineaJPA operacionLinea = new LineaJPA();
		Linea linea = operacionLinea.consultarPorID(codigoLinea, Linea.class);
		return linea;
	}

}
