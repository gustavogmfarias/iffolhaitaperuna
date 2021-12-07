package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.NewsletterDao;
import br.com.iffolhaitap.model.Newsletter;

@RequestScoped
public class NewsletterService {
	@Inject
	private NewsletterDao newsletterDao;
	@Inject private LogService logService;

	public void adiciona(Newsletter newsletter) throws Exception {

		if (newsletterDao.existeNewsletterPorEmail(newsletter.getEmail())) {

			throw new Exception("Já existe um newsletter cadastrado com esse email");
		}
		newsletterDao.adiciona(newsletter);
		logService.criarLog("NEWSLETTER-ADICIONAR", newsletter.toString());

	}

	public void atualizar(Newsletter newsletter, String emailAnterior) throws Exception {

		if (newsletterDao.existeNewsletterPorEmail(newsletter.getEmail()) && !newsletter.getEmail().equals(emailAnterior)) {

			throw new Exception("Já existe um newsletter cadastrado com esse email");
		}

		newsletterDao.atualizar(newsletter);
		logService.criarLog("NEWSLETTER-ATUALIZAR", newsletter.toString());

	}

	public void remove(Newsletter newsletter) {

		newsletter = newsletterDao.get(newsletter.getId());
		newsletterDao.remove(newsletter);
		logService.criarLog("NEWSLETTER-REMOVER", newsletter.toString());



	}
}
