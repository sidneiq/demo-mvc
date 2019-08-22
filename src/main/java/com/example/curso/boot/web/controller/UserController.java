package com.example.curso.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.curso.boot.domain.User;
import com.example.curso.boot.service.em.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

// @Repository	
//	public interface PersonRepository extends JpaRepository<Person, Long> { }
//	public interface PersonService {}
//	@Service
//  public class PersonServiceImpl implements PersonService {	

	
	@Autowired
	private UserService userService;

	@GetMapping("/cadastrar")
	public String cadastrar(User user) {
		return "user/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("users", userService.buscarTodos());
		return "user/lista"; 
	}
	
	@PostMapping("/salvar")
	@Secured({ "ROLE_ADMIN" })
	public String salvar(@Valid User user, BindingResult result,  RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "user/cadastro";
		}
		
		userService.salvar(user);
		attr.addFlashAttribute("success", "user inserido com sucesso.");
		return "redirect:/users/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		
		 //User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		model.addAttribute("user", userService.buscarPorId(id));
		return "user/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid User user, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "user/cadastro";
		}
		
		userService.editar(user);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
//		if (userService.cargoTemFuncionarios(id)) {
//			attr.addFlashAttribute("fail", "Cargo não excluido. Tem funcionário(s) vinculado(s).");
//		} else {
//			userService.excluir(id);
//			attr.addFlashAttribute("success", "User excluido com sucesso.");
//		}
		return "redirect:/users/listar";
	}
	
//	   @PostMapping("/salvarRole")
//	    public String salvar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
//	        if (result.hasErrors()) {
//	            return "/playlist/add";
//	        }
//	 
//	        playlistService.salvar(playlist);
//	        attr.addFlashAttribute("mensagem", "Playlist criada com sucesso.");
//	        return "redirect:/playlists/listar";
//	    }
	 
	   
}
