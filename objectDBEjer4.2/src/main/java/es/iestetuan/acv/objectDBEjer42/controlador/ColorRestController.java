package es.iestetuan.acv.objectDBEjer42.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iestetuan.acv.dao.jpa.ColorJPA;
import es.iestetuan.acv.dao.vo.Color;
import es.iestetuan.acv.procesamiento.ColorDTO;

@RestController
public class ColorRestController {
	
	@GetMapping(path="/rest/colores", produces={"application/json"})
	public List<ColorDTO> getListaColores(){
		
		ColorJPA operacionColor = new ColorJPA();
		List<Color> listaColores = operacionColor.consultarLista();
		List<ColorDTO> listaColoresDTO = new ArrayList<ColorDTO>();
		
		for(Color color : listaColores) {
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setCodigoColor(color.getCodigoColor());
			colorDTO.setCodigoHexadecimal(color.getCodigoHexadecimal());
			colorDTO.setNombre(color.getNombre());
			listaColoresDTO.add(colorDTO);
		}
		
		return listaColoresDTO;
	}

}
