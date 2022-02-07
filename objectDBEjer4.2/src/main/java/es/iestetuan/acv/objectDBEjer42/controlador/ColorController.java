package es.iestetuan.acv.objectDBEjer42.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.iestetuan.acv.dao.jpa.ColorJPA;
import es.iestetuan.acv.dao.vo.Color;
import es.iestetuan.acv.procesamiento.ColorDTO;

@Controller
public class ColorController {
	
	@GetMapping("/colores")
	public String listarColores(Model model) {
		
		ColorJPA operacionColor = new ColorJPA();
		List<Color> listaColores = operacionColor.consultarLista();
		List<ColorDTO> listaColoresDTO = new ArrayList<ColorDTO>();
		
		for(Color color : listaColores) {
			ColorDTO colorDTO = new ColorDTO();
			BeanUtils.copyProperties(color, colorDTO);
			listaColoresDTO.add(colorDTO);
		}
		model.addAttribute("colores", listaColoresDTO);
		return "color/lista";
	}

}
