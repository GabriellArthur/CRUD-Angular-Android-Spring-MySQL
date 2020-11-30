package com.example.exemplo1;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface PessoaRepositorio extends Repository<Pessoa, Integer>{
	List<Pessoa>findAll();
	Pessoa findById(int id);
	Pessoa save(Pessoa p);
	void delete(Pessoa p);
}
