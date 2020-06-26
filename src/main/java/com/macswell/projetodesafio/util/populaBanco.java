package com.macswell.projetodesafio.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macswell.projetodesafio.model.Empresa;
import com.macswell.projetodesafio.repository.EmpresaRepository;

//Classe criada apenas para popular o banco durante os testes;
@Component
public class populaBanco {

	@Autowired
	EmpresaRepository repo;
	
	@PostConstruct //Comentar essa linha após a primeira execução
	public void save(){
		
		List<Empresa> empresaList = new ArrayList<Empresa>();
		
		Empresa empresa1 = new Empresa();
		empresa1.setCnpj("15.148.367/0001-24");
		empresa1.setNome("Pet Shop MeuPet");
		empresa1.setRazao("Raçoes ltda.");
		empresa1.setTipo("Matriz");
		empresa1.setEmail("empresa1@gmail.com");
		empresa1.setContato("(61) 3451-6465");
		empresa1.setLogradouro("SQN 112");
		empresa1.setBairro("Asa Norte");
		empresa1.setCidade("Brasília");
		empresa1.setEstado("Distrito Federal");
		empresa1.setComplemento(null);
		empresa1.setCep("75100-024");
		
		Empresa empresa2 = new Empresa();
		empresa2.setCnpj("32.168.867/0001-47");
		empresa2.setNome("Fashion Mal");
		empresa2.setRazao("Luiza Roupas ltda.");
		empresa2.setTipo("Matriz");
		empresa2.setEmail("empresa2@gmail.com");
		empresa2.setContato("(61) 3353-7373");
		empresa2.setLogradouro("Ae - Entre a Rua 9 e 11 Sul");
		empresa2.setBairro("Arniqueiras");
		empresa2.setCidade("Águas Claras");
		empresa2.setEstado("Distrito Federal");
		empresa2.setComplemento(null);
		empresa2.setCep("71936-250");
		
		Empresa empresa3 = new Empresa();
		empresa3.setCnpj("23.009.617/0001-73");
		empresa3.setNome("Mercado Luz");
		empresa3.setRazao("Produtos e mantimentos ltda.");
		empresa3.setTipo("Matriz");
		empresa3.setEmail("empresa3@gmail.com");
		empresa3.setContato("(61) 3451-1245");
		empresa3.setLogradouro("SQS 202");
		empresa3.setBairro("Asa Sul");
		empresa3.setCidade("Brasília");
		empresa3.setEstado("Distrito Federal");
		empresa3.setComplemento(null);
		empresa3.setCep("75100-245");
		
		empresaList.add(empresa1);
		empresaList.add(empresa2);
		empresaList.add(empresa3);
		
		for(Empresa empresa:empresaList) {
			repo.save(empresa);
		}
	}
}
