package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.TurmaDao;
import br.com.iffolhaitap.model.Turma;

@RequestScoped
public class TurmaService {

	@Inject
	private TurmaDao turmaDao;

	public void adiciona(Turma turma) throws Exception {

		if (turmaDao.existeTurmaPorNome(turma.getNome())) {
			throw new Exception("Já existe uma turma cadastrada com esse nome");
		}

		turmaDao.adiciona(turma);

	}

	public void atualizar(Turma turma, String nomeAnterior) throws Exception {

		if (turmaDao.existeTurmaPorNome(turma.getNome()) && !turma.getNome().equals(nomeAnterior)) {

			throw new Exception("Já existe uma turma cadastrada com esse nome");

		}

		turmaDao.atualizar(turma);

	}

}
