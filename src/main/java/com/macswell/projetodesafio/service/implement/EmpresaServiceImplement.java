package com.macswell.projetodesafio.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macswell.projetodesafio.model.Empresa;
import com.macswell.projetodesafio.repository.EmpresaRepository;
import com.macswell.projetodesafio.service.EmpresaService;

@Service
public class EmpresaServiceImplement implements EmpresaService{

	@Autowired
	EmpresaRepository repo;
	
	public List<Empresa> findAll() {
		return repo.findAll();
	}

	public Empresa findById(Long id) {
		return repo.findById(id).get();
	}

	public Empresa save(Empresa empresa) {
		return repo.saveAndFlush(empresa);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Empresa> findEmpresa(String cnpj, String nome) {
		return repo.findEmpresa(cnpj, nome);
	}

}
