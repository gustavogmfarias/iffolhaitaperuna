package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.TagDao;
import br.com.iffolhaitap.model.Artigo;
import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.model.Tag;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequestScoped
public class TagService {

	@ManyToOne
	@Inject TagDao tagDao;

	public Noticia criarTags(Noticia noticia, String tagsEmTexto) {


		if (tagsEmTexto == null || tagsEmTexto.isEmpty()) {

			return noticia;
		}

		String[] arrayDeTags = tagsEmTexto.split(",");

		for (String tagStr : arrayDeTags) {

			if (tagStr == null || tagStr.trim().isEmpty()) {
				continue;
			}

			Tag tag = new Tag();
			tag.setNome(tagStr);
			if (tagDao.existeTagPorNome(tagStr)) {
				tag = tagDao.procuraPorNome(tagStr);
			} else {
				tag.montarUrl();

				tag = tagDao.merge(tag);
			}
			noticia.getTags().add(tag);

		}

		return noticia;

	}

	public Artigo criarTags(Artigo artigo, String tagsEmTexto) {
		if (tagsEmTexto == null || tagsEmTexto.isEmpty()) {

			return artigo;
		}

		String[] arrayDeTags = tagsEmTexto.split(",");

		for (String tagStr : arrayDeTags) {

			if (tagStr == null || tagStr.trim().isEmpty()) {
				continue;
			}

			Tag tag = new Tag();
			tag.setNome(tagStr);
			if (tagDao.existeTagPorNome(tagStr)) {
				tag = tagDao.procuraPorNome(tagStr);
			} else {
				tag = tagDao.merge(tag);
			}
			artigo.getTags().add(tag);

		}

		return artigo;
	}

}
