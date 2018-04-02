package com.br.gestor.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gestor.dao.GestorDao;
import com.br.gestor.model.Gestor;
import com.br.gestor.tarefas.*;


@RestController
public class GestorController {

	
	@Autowired
	private GestorDao dao;

	@RequestMapping("/")
	public String Home() {
         return "Iniciar";
	}

	@RequestMapping("/start")
	public String Iniciar() {
		Runnable tarefa = new Tarefas(dao);
		Thread thread = new Thread(tarefa);
		thread.start();
		return "Iniciar";
	}
	
	@RequestMapping("/lista")
	public List<Gestor> lista(){
		return dao.listar();
	}

	

}
