package edu.curso.java.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.ProyectoForm;
import edu.curso.java.bo.Usuario;
import edu.curso.java.services.ProyectoService;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping("/proyectos")
public class ProyectosController {

	private static final Logger log = Logger.getLogger(ProyectosController.class);
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		log.info("Listando los proyectos");
		
		return null;
	}
	
	@RequestMapping(value = "/nuevoproyecto", method = RequestMethod.GET)
	public String nuevoProyecto(Model model){
		log.info("Creano un nuevo proyecto");
		model.addAttribute("proyectoForm",new ProyectoForm());
		model.addAttribute("usuarios", usuarioService.recuperarUsuarios());
		return "/proyectos/form";
	}

	@RequestMapping(value= "/listar")
	public String verProyectos(Model model){
		List<Proyecto> proyectos = proyectoService.listarProyectos();
		model.addAttribute("proyectos", proyectos);	
		return null;
	}
	
	@RequestMapping(value="/verproyecto")
	public String verProyecto(@RequestParam("id") Long id,Model model){
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		model.addAttribute("proyecto",proyecto);
		return null;
	}

	@RequestMapping(value = "/guardarproyecto", method= RequestMethod.POST)
	public String guardarProyecto(@ModelAttribute("proyectoForm") ProyectoForm proyectoForm, Model model){
		Proyecto proyecto  = null;
		Long idActual = proyectoForm.getId();
		Long idUsuarioPrincipal = proyectoForm.getIdUsuarioPrincipal();
		Long[] idUsuarios = proyectoForm.getIdUsuarios();
				
		
		
		if(idActual != null){
			proyecto = proyectoService.recuperarProyectoPorId(idActual);
			proyecto.setNombre(proyectoForm.getNombre());
			proyecto.setDescripcion(proyectoForm.getDescripcion());
			proyectoService.actualizarProyecto(proyecto, idUsuarioPrincipal, idUsuarios);
		}
		else{
			proyecto = new Proyecto();
			proyecto.setNombre(proyectoForm.getNombre());
			proyecto.setDescripcion(proyectoForm.getDescripcion());
			proyecto.setActivo(proyectoForm.isActivo());
			idActual = proyectoService.guardarProyecto(proyecto, idUsuarioPrincipal, idUsuarios);
		}
		
		return "redirect:/proyectos/verproyecto.html?id=" + idActual;
	}
	
	@RequestMapping(value = "/buscarPorNombreProyecto")
	public String buscarporNombre(@ModelAttribute("nombre") String nombre,Model model){
		List<Usuario> usuariosEncontrados = proyectoService.buscarPorNombre(nombre);
		model.addAttribute("usuarioBuscado", usuariosEncontrados);
		return null;
	}
}
