package br.com.iffolhaitap.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.iffolhaitap.annotation.Privado;

@Controller
public class IndexController {
	
	@Privado
	@Get("/adm")
	public void inicio() {
		
		
		
	}
	
}
