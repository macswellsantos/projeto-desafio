package com.macswell.projetodesafio.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.macswell.projetodesafio.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>  {
	
	@Query("select e from Empresa e where e.cnpj = ?1 or e.nome like %?2% ")
	List<Empresa> findEmpresa(String cnpj, String nome);
}
