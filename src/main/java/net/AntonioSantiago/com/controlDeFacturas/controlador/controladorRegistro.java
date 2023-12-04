package net.AntonioSantiago.com.controlDeFacturas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



public class controladorRegistro {

	
	@Controller
	public class RegistroControlador {

		@Value("${cashcraft.ruta.imagenes}")
		private String ruta;
		
		@Autowired
	    private UsuarioServicio usuarioServicio;
		
		@Autowired
		private UsuarioServicio servicio;
		
		@GetMapping("/login")
		public String iniciarSesion() {
			return "login";
		}
		
		@GetMapping("/")
		public String verPaginaDeInicio(Model modelo) {
			modelo.addAttribute("usuarios", servicio.listarUsuarios());
			return "index";
		}
		
		@GetMapping("/clientes")
		public String tblUsuarios(Model modelo) {
			modelo.addAttribute("usuarios", servicio.listarUsuarios());
			return "/usuarios/tblClientes";
		}
		
		@GetMapping("/administradores")
		public String tblAdministradores(Model modelo) {
			modelo.addAttribute("usuarios", servicio.listarUsuarios());
			return "/admins/tblAdmins";
		}
		
		@GetMapping("/view/{id}")
		public String verDetalle(@PathVariable("id") int idUsuario, Model model) {
			Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
			System.out.println("usuario: " + usuario);
			model.addAttribute("usuario", usuario);
			return "/usuarios/detalleCliente";
		}
		
		@GetMapping("/ver/{id}")
		public String verDetAdmin(@PathVariable("id") int idUsuario, Model model) {
			Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
			System.out.println("usuario: " + usuario);
			model.addAttribute("usuario", usuario);
			return "/admins/detalleAdmin";
		}
		
		@GetMapping("/delete/{id}")
		public String eliminar(@PathVariable("id") Long idUsuario,RedirectAttributes attributes) {
			System.out.println("Borrando Cliente con id: "+idUsuario);
			usuarioServicio.eliminar(idUsuario);
			attributes.addFlashAttribute("msg","El cliente ha sido eliminado satisfactoriamente");
			return "redirect:/clientes";
		}
		
		@GetMapping("/editar/{id}")
		public String editarCliente(@PathVariable("id") int idUsuario, Model model) {
		    Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
		    model.addAttribute("usuario", usuario);
		    return "/usuarios/EditarCliente"; // Vista específica para la edición
		}
		
		@PostMapping("/save")
		public String guardar(Usuario usuario,BindingResult result,RedirectAttributes attributes) {
			
			
			usuarioServicio.guardarUser(usuario);
			attributes.addFlashAttribute("msg","Se ha editado correctamente.");
			
			System.out.println(" Usuario: "+usuario);
			
			
			return "redirect:/clientes";
			
		}
		
		
}
