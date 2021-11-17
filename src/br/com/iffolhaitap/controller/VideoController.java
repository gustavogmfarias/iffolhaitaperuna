package br.com.iffolhaitap.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.VideoDao;
import br.com.iffolhaitap.model.Video;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.VideoService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class VideoController {

	@Inject
	private Result result;
	@Inject
	private VideoDao videoDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;
	@Inject
	private VideoService videoService;

	@Privado
	@Get("/adm/videos")
	public void lista(String busca, Integer paginaAtual) {
		Paginacao<Video> paginacao = videoDao.lista(busca, paginaAtual);
		result.include("paginacao", paginacao);
		result.include("busca", busca);

	}

	@Privado
	@Get("/adm/videos/novo")
	public void novo() {

	}

	@Privado
	@Post("/adm/videos")
	public void adiciona(@Valid Video video, UploadedFile imagemVideo) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			videoService.adiciona(video, imagemVideo);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("message", "Video adicionado com sucesso");

		result.redirectTo(this).lista("",1);

	}

	@Privado
	@Get("/adm/videos/{video.id}/editar")
	public void editar(Video video) {
		result.include("video", videoDao.get(video.getId()));
	}

	@Privado
	@Post("/adm/videos/editar")
	public void atualizar(@Valid Video video, UploadedFile imagemVideo) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			videoService.atualizar(video, imagemVideo);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("",1);


		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(video);
		}

		result.include("mensagem", "Video atualizado com sucesso");

		result.redirectTo(this).lista("",1);

	}

	@Privado
	@Get("/adm/videos/{video.id}/apagar")
	public void remove(Video video) {

		try {

			HibernateUtil.beginTransaction();
			videoService.remove(video);
			HibernateUtil.commit();
			result.include("mensagem", "Video removido com sucesso");
			result.redirectTo(this).lista("",1);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).lista("",1);
		}

	}


}
