package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.TurmaDao;
import br.com.iffolhaitap.model.Turma;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequestScoped
public class TurmaService {

	@ManyToOne
	@Inject
	private TurmaDao turmaDao;
	
	@ManyToOne
	@Inject private LogService logService;

	public void adiciona(Turma turma) throws Exception {

		if (turmaDao.existeTurmaPorNome(turma.getNome())) {
			throw new Exception("J� existe uma turma cadastrada com esse nome");
		}

		turmaDao.adiciona(turma);
		logService.criarLog("TURMA-ADICIONAR", turma.toString());


	}

	public void atualizar(Turma turma, String nomeAnterior) throws Exception {

		if (turmaDao.existeTurmaPorNome(turma.getNome()) && !turma.getNome().equals(nomeAnterior)) {

			throw new Exception("J� existe uma turma cadastrada com esse nome");

		}

		turmaDao.atualizar(turma);
		logService.criarLog("TURMA-ATUALIZAR", turma.toString());

	}

	public void remove(Turma turma) {
		turmaDao.remove(turma);
		logService.criarLog("TURMA-REMOVER", turma.toString());		
	}

}
