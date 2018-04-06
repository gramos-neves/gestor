package com.br.gestor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.gestor.dao.RamalDao;
import com.br.gestor.model.Ramal;

@RestController
@RequestMapping("/api/ramal")
public class RamalController {

	@Autowired
	private RamalDao dao;
	
	@RequestMapping(method= {RequestMethod.GET},produces={"application/json"})
	public Iterable<Ramal> Lista(){
	   return dao.findAll();	 
	}
	
	@RequestMapping(method= {RequestMethod.POST},produces={"application/json"})
	public Ramal Salvar(@RequestBody Ramal ramal) {
		return dao.save(ramal); 
	}
	
	
}
