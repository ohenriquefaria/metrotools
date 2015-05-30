package com.application.controller.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.application.domain.Usuario;
import com.avaje.ebean.Ebean;


@ManagedBean(name="usuarioMB")
@ViewScoped
public class UsuarioListMB {

	private Usuario bean;
	private List<Usuario> usuarios;
	private Long idToDelete;
	
	public UsuarioListMB() {
		System.out.println("UsuarioListMB()");
		this.usuarios = getUsuarioList();
	}
	
	
	public String save() {
		Ebean.save(getBean());
		return "welcome.xhtml";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String add() {
		return "add.xhtml";
	}

	public String edit() {
		return "update.xhtml";
	}

	public void remove() {
		Ebean.delete(Usuario.class, idToDelete);
		FacesUtil.addSuccessMessage("Usuario deleted.");
		setUsuarios(getUsuarioList());
	}
	

	public Usuario getBean() {
		return bean;
	}


	public void setBean(Usuario bean) {
		this.bean = bean;
	}


	public Long getIdToDelete() {
		return idToDelete;
	}


	public void setIdToDelete(Long idToDelete) {
		this.idToDelete = idToDelete;
	}
	
	private List<Usuario> getUsuarioList(){
		return Ebean.find(Usuario.class).findList();
	}
	
}
