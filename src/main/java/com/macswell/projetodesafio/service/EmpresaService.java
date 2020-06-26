package com.macswell.projetodesafio.service;

import java.util.List;

import com.macswell.projetodesafio.model.Empresa;

public interface EmpresaService {
	public List<Empresa> findAll();
	public Empresa findById(Long id);
	public Empresa save(Empresa empresa);
	public void delete(Long id);
	public List<Empresa> findEmpresa(String cnpj, String nome);
}
