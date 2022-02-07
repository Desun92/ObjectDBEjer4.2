package es.iestetuan.acv.objectDBEjer42.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.iestetuan.acv.dao.jpa.LineaJPA;
import es.iestetuan.acv.dao.vo.Linea;
import es.iestetuan.acv.procesamiento.ColorDTO;
import es.iestetuan.acv.procesamiento.LineaDTO;

@Controller
public class LineaController {
	
	@GetMapping("/lineas")
	public String listarColores(Model model) {
		
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
		
		model.addAttribute("lineasDTO", listaLineasDTO);
		return "linea/lista";
	}
	
}
