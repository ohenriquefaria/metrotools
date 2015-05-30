package com.application.controller.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.application.domain.Usuario;
import com.avaje.ebean.Ebean;

@ManagedBean(name="addUsuarioMB")
@RequestScoped
public class AddUsuarioMB {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String save() {
		Ebean.save(usuario);
		FacesUtil.addSuccessMessage("New usuario added.");
		return "list.xhtml";
	}
}

