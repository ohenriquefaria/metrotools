package com.application.controller.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.application.domain.Usuario;
import com.avaje.ebean.Ebean;

@ManagedBean(name="editUsuarioMB")
@RequestScoped
public class EditUsuarioMB implements Serializable{
	
	private static final long serialVersionUID = -634836716902391555L;
	private Usuario bean;
	
	public EditUsuarioMB() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
		System.out.println("fetching usuario id " + id);
		setBean(Ebean.find(Usuario.class, Long.valueOf(id)));
	}

	public Usuario getBean() {
		return bean;
	}

	public void setBean(Usuario bean) {
		this.bean = bean;
	}
	
	public String save() {
		System.out.println("Saving " + bean);
		Ebean.update(bean);
		FacesUtil.addSuccessMessage("Usuario edited");
		return "list.xhtml";
	}
	
}
