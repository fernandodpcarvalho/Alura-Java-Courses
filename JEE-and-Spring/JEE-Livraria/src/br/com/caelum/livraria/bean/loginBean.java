package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.util.RedirectView;

//@ManagedBean
@Named
@ViewScoped
public class loginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDao dao;
	
	@Inject
	FacesContext context;
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public RedirectView efetuarLogin(){
		System.out.println("Fazendo login do usu�rio"+this.usuario.getEmail());
		
		//boolean existe = new UsuarioDao().existe(this.usuario);
		boolean existe = dao.existe(this.usuario);
		//obt�m a sess�o HTTP (COntext)
		//FacesContext context = FacesContext.getCurrentInstance();
		
		if(existe) {
			//Armazena a informa��o como um mapa chave-valor (usuario)
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);

			return new RedirectView("livro");
			//return "livro?faces-redirect-true";
		} 
		
		//O retorno com redirect for�a uma nova requisi��o, o context � apagado e perde a mensagem cadastrada.
		//Para resolver isso, o getFash faz com que o context continue v�lido por mais uma requisi��o.
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuario ou sennha inv�lidos"));
		return new RedirectView("login");
		//return "login?faces-redirect=true";
	}
	
	public String deslogar(){
		//FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");		
		return "login?faces-redirect=true";
	}
}
