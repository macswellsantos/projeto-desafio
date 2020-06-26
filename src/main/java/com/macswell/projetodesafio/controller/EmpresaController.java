package com.macswell.projetodesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.macswell.projetodesafio.model.Empresa;
import com.macswell.projetodesafio.repository.EmpresaRepository;
import com.macswell.projetodesafio.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	EmpresaService service;
	
	EmpresaRepository repo;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/empresas", method = RequestMethod.GET)
	public ModelAndView getEmpresa(){
		ModelAndView mv = new ModelAndView("empresas");
		List<Empresa> listaEmpresas = service.findAll();
		mv.addObject("empresas", listaEmpresas);
		int n = listaEmpresas.size();
		mv.addObject("paginas", n);
		return mv;
	}
	
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public ModelAndView getCadastro(Empresa empresa) {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("empresa",empresa);
		return mv;
	}
	
	@RequestMapping(value = "/cadastro/{id}", method = RequestMethod.GET)
	public ModelAndView buscaEmpresa(@PathVariable Long id){
		return getCadastro(service.findById(id));
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvaEmpresa(Empresa empresa){
		service.save(empresa);
		return getEmpresa();
	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public ModelAndView excluiEmpresa(@PathVariable Long id){
		service.delete(id);
		return getEmpresa();
	}
	
	@RequestMapping(value = "/pesquisarEmpresa", method = RequestMethod.POST)
	public ModelAndView buscaEmpresa(@RequestParam String cnpj,@RequestParam String nome){
		ModelAndView mv = new ModelAndView("empresas");
		List<Empresa> listaEmpresas = service.findEmpresa(cnpj, nome);
		mv.addObject("empresas", listaEmpresas);
		int n = listaEmpresas.size();
		mv.addObject("paginas", n);
		return mv;
	}
	
		
}
