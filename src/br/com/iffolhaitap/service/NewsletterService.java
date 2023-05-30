package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.NewsletterDao;
import br.com.iffolhaitap.model.Newsletter;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequestScoped
public class NewsletterService {
	@ManyToOne
	@Inject
	private NewsletterDao newsletterDao;
	@ManyToOne
	@Inject private LogService logService;

	public void adiciona(Newsletter newsletter) throws Exception {

		if (newsletterDao.existeNewsletterPorEmail(newsletter.getEmail())) {

			throw new Exception("J� existe um newsletter cadastrado com esse email");
		}
		newsletterDao.adiciona(newsletter);
		logService.criarLog("NEWSLETTER-ADICIONAR", newsletter.toString());

	}

	public void atualizar(Newsletter newsletter, String emailAnterior) throws Exception {

		if (newsletterDao.existeNewsletterPorEmail(newsletter.getEmail()) && !newsletter.getEmail().equals(emailAnterior)) {

			throw new Exception("J� existe um newsletter cadastrado com esse email");
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
