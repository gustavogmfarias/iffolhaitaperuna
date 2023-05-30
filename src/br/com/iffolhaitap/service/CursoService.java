package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.model.Curso;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequestScoped
public class CursoService {
	@ManyToOne
	@Inject
	private CursoDao cursoDao;
	@ManyToOne
	@Inject private LogService logService;

	public void adiciona(Curso curso) throws Exception {

		if (cursoDao.existeCursoPorNome(curso.getNome())) {

			throw new Exception("J� existe um curso cadastrado com esse nome");
		}
		cursoDao.adiciona(curso);
		logService.criarLog("CURSO-ADICIONAR", curso.toString());

	}

	public void atualizar(Curso curso, String nomeAnterior) throws Exception {

		if (cursoDao.existeCursoPorNome(curso.getNome()) && !curso.getNome().equals(nomeAnterior)) {

			throw new Exception("J� existe um curso cadastrado com esse nome");
		}

		cursoDao.atualizar(curso);
		logService.criarLog("CURSO-ATUALIZAR", curso.toString());

	}

	public void remove(Curso curso) {
		
		curso = cursoDao.get(curso.getId());
		cursoDao.remove(curso);
		logService.criarLog("CURSO-REMOVER", curso.toString());


		
	}
}
