package br.com.iffolhaitap.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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

@Entity
@Controller
public class VideoController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private VideoDao videoDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private VideoService videoService;

	@Privado
	@Get("/adm/videos")
	public void lista(String busca, Integer paginaAtual, Boolean ehDestaque) {
		Paginacao<Video> paginacao = videoDao.lista(busca, paginaAtual, ehDestaque);
		result.include("paginacao", paginacao);
		result.include("busca", busca);
		result.include("ehDestaque", ehDestaque);

	}

	@Privado
	@Get("/adm/videos/novo")
	public void novo() {

	}

	@Privado
	@Post("/adm/videos")
	public void adiciona(@Valid Video video, UploadedFile imagemVideo) throws IOException {
		validator.onErrorRedirectTo(this).novo();
		if(imagemVideo== null) {
			validator.add(new SimpleMessage("error", "Por favor, insira uma imagem"));
			validator.onErrorRedirectTo(this).novo();
		}

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

		result.redirectTo(this).lista("",1,null);

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
			validator.onErrorRedirectTo(this).lista("",1,null);


		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(video);
		}

		result.include("mensagem", "Video atualizado com sucesso");

		result.redirectTo(this).lista("",1,null);

	}

	@Privado
	@Get("/adm/videos/{video.id}/apagar")
	public void remove(Video video) {

		try {

			HibernateUtil.beginTransaction();
			videoService.remove(video);
			HibernateUtil.commit();
			result.include("mensagem", "Video removido com sucesso");
			result.redirectTo(this).lista("",1,null);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("",1,null);
		}

	}


}
