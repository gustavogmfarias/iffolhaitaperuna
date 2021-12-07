package br.com.iffolhaitap.controller;
import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.iffolhaitap.dao.TagDao;
import br.com.iffolhaitap.model.Tag;
import br.com.iffolhaitap.util.FormatterString;

@Controller
public class TagController {

	@Inject
	private Result result;
	@Inject
	private TagDao tagDao;
	@Inject
	FormatterString format = new FormatterString();

	@Get("/tags/{tag.url}")
	public void showTag(Tag tag) {
		tag = tagDao.procuraPorUrl(tag);
		result.include("tag", tag);
	}
}
