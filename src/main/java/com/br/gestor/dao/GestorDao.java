package com.br.gestor.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.gestor.model.Gestor;

public interface GestorDao extends CrudRepository<Gestor, Integer> {

	@Query("SELECT g, r.descricao FROM Gestor g inner join Ramal r on g.ramal = r.id_ramal")
	List<Gestor> listar();

	@Query("select g from Gestor g where g.data_inicio >=?1")
	List<Gestor> Listar(Date data);

}
