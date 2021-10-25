package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.model.Curso;

@RequestScoped
public class CursoService {
	@Inject
	private CursoDao cursoDao;

	public void adiciona(Curso curso) throws Exception {

		if (cursoDao.existeCursoPorNome(curso.getNome())) {

			throw new Exception("Já existe um curso cadastrado com esse nome");
		}
		cursoDao.adiciona(curso);

	}

	public void atualizar(Curso curso, String nomeAnterior) throws Exception {

		if (cursoDao.existeCursoPorNome(curso.getNome()) && !curso.getNome().equals(nomeAnterior)) {

			throw new Exception("Já existe um curso cadastrado com esse nome");
		}

		cursoDao.atualizar(curso);

	}

}
