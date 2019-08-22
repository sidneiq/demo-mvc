package com.example.curso.boot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.curso.boot.domain.Departamento;
import com.example.curso.boot.service.em.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Departamento> list =  service.buscarTodos();
		model.addAttribute("departamentos", list);
		model.addAttribute("totalPagina", list.size());
		return "departamento/lista"; 
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "/departamento/cadastro";
		}
		//	public String salvar(Departamento departamento, RedirectAttributes attr, ModelMap model, BindingResult result) {
		//		if (result.hasErrors()) {
		//			return "/departamento/cadastro";
		//		}
		//
		//		if(departamento.getNome() == null || departamento.getNome().trim().equals("")) {
		//			model.addAttribute("fail", "Nome é obrigatório.");
		//			return "/departamento/cadastro";
		//		}

		service.salvar(departamento);
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.buscarPorId(id));
		return "departamento/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Departamento departamento,  BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "departamento/cadastro";
		}
		
		service.editar(departamento);
		attr.addFlashAttribute("success", "Departamento editado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

		if (service.depertamentoTemCargos(id)) {
			model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculado(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Departamento excluído com sucesso.");
		}

		return listar(model);
	}

}

