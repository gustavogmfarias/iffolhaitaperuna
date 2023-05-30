package br.com.iffolhaitap.service;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.iffolhaitap.dao.VideoDao;
import br.com.iffolhaitap.model.Video;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequestScoped
public class VideoService {

	@ManyToOne
	@Inject VideoDao videoDao;
	@ManyToOne
	@Inject LogService logService;

	public void adiciona(Video video, UploadedFile imagemVideo) throws Exception {

		if (imagemVideo != null) {
			File fotoSalva = new File("D:\\VScode\\iffolha\\iffolhaitaperuna\\WebContent\\img\\imagens-video",
					imagemVideo.getFileName());
			imagemVideo.writeTo(fotoSalva);
			video.setImagem(imagemVideo.getFileName());
		}

		if (videoDao.existeVideoPorLink(video.getLink())) {

			throw new Exception("J� existe video cadastrado com esse link");

		}



		videoDao.adiciona(video);
		logService.criarLog("VIDEO-ADICIONAR", video.toString());

	}

	public void atualizar(Video video, UploadedFile imagemVideo) throws Exception {

		if (imagemVideo != null) {
			File fotoSalva = new File("D:\\VScode\\iffolha\\iffolhaitaperuna\\WebContent\\img\\imagens-video",
					imagemVideo.getFileName());
			imagemVideo.writeTo(fotoSalva);
			video.setImagem(imagemVideo.getFileName());
		}

		if (videoDao.existeVideoPorLink(video.getLink()) && !video.getLink().equals(video.getNovoLink())) {

			throw new Exception("J� existe video cadastrado com esse link");

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
