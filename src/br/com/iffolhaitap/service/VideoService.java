package br.com.iffolhaitap.service;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.iffolhaitap.dao.VideoDao;
import br.com.iffolhaitap.model.Video;

@RequestScoped
public class VideoService {

	@Inject VideoDao videoDao;
	@Inject LogService logService;

	public void adiciona(Video video, UploadedFile imagemVideo) throws Exception {

		if (imagemVideo != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-video",
					imagemVideo.getFileName());
			imagemVideo.writeTo(fotoSalva);
			video.setImagem(imagemVideo.getFileName());
		}

		if (videoDao.existeVideoPorLink(video.getLink())) {

			throw new Exception("Já existe video cadastrado com esse link");

		}



		videoDao.adiciona(video);
		logService.criarLog("VIDEO-ADICIONAR", video.toString());

	}

	public void atualizar(Video video, UploadedFile imagemVideo) throws Exception {

		if (imagemVideo != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-video",
					imagemVideo.getFileName());
			imagemVideo.writeTo(fotoSalva);
			video.setImagem(imagemVideo.getFileName());
		}

		if (videoDao.existeVideoPorLink(video.getLink()) && !video.getLink().equals(video.getNovoLink())) {

			throw new Exception("Já existe video cadastrado com esse link");

		}

		videoDao.atualizar(video);
		logService.criarLog("VIDEO-ATUALIZAR", video.toString());

	}

	public void remove(Video video) {

		video = videoDao.get(video.getId());
		videoDao.remove(video);
		logService.criarLog("VIDEO-REMOVER", video.toString());



	}


}
