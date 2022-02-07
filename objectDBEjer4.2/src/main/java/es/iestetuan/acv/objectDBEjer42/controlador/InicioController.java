package es.iestetuan.acv.objectDBEjer42.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	
	@RequestMapping("/")
	public String iniciarConPlantilla(){
		return "inicio";
	}

}
