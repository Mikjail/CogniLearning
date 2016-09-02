package edu.curso.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Usuario;
import edu.curso.java.bo.UsuarioForm;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
		
		@Autowired
		UsuarioService usuarioService;
		
		@RequestMapping(value="/listar")
		public String listar(Model model){
			List<Usuario> usuarios = usuarioService.recuperarUsuarios();
			model.addAttribute("usuarios", usuarios);
			return null;
		}
	
		@RequestMapping(value="/verusuario", method = RequestMethod.GET)
		public String verUsuario(@RequestParam("id") Long id,Model model){
			Usuario usuario = usuarioService.recuperarUsuarioPorID(id);
			model.addAttribute("usuario", usuario);
			return null;
		}
		
		@RequestMapping(value = "/nuevousuario")
		public String nuevoUsuario(Model model) {
			model.addAttribute("usuarioForm", new UsuarioForm());
			return "/usuarios/form";
		}

		@RequestMapping(value = "/guardarusuario", method = RequestMethod.POST)
		public String guardarUsuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm, Model model) {
			Usuario usuario = null;
			Long idActual = usuarioForm.getId();
			
			if(idActual != null) {
			usuario = usuarioService.recuperarUsuarioPorID(idActual);
			usuario.setNombreCompleto(usuarioForm.getNombreCompleto());
			usuario.setUsuario(usuarioForm.getUsuario());
			usuario.setPassword(usuarioForm.getPassword());
			usuario.setActivo(usuarioForm.isActivo());
			usuarioService.actualizarUsuario(usuario);
			}
			else{
			usuario = new Usuario();
			usuario.setNombreCompleto(usuarioForm.getNombreCompleto());
			usuario.setUsuario(usuarioForm.getUsuario());
			usuario.setPassword(usuarioForm.getPassword());
			usuario.setActivo(usuarioForm.isActivo());
			idActual = usuarioService.crearNuevoUsuario(usuario);
			}

			return "redirect:/usuarios/verusuario.html?id=" + idActual;
		}

		@RequestMapping(value="/editarusuario")
		public String editarUsuario(@RequestParam long id, Model model){
			Usuario usuario =  usuarioService.recuperarUsuarioPorID(id);
			UsuarioForm usuarioForm = new UsuarioForm();
			usuarioForm.setId(usuario.getId());
			usuarioForm.setNombreCompleto(usuario.getNombreCompleto());
			usuarioForm.setPassword(usuario.getPassword());
			usuarioForm.setUsuario(usuario.getUsuario());
			model.addAttribute("usuarioForm", usuarioForm);
			
			return "/usuarios/form";
		}
		
		@RequestMapping(value = "/borrarusuario")
		public String borrarUsuario(@RequestParam Long id, Model model) {
			usuarioService.borrarUsuario(id);
			return "redirect:/usuarios/listar.html";
		}
}
