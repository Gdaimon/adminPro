package tablas;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Data;
import tablas.modelo.Usuario;

@Named ( value = "mbUser" )
@SessionScoped
public @Data class mBUsuario implements Serializable {

	Usuario					usuario;
	Usuario					usuarioTemp	= new Usuario ( );
	ArrayList < Usuario >	lstUsuario;

	public mBUsuario ( )
	{
		usuario = new Usuario ( );
		// cargarUsuarios ( );
	}

	private void cargarUsuarios ( )
	{
		lstUsuario = new ArrayList < > ( );
		usuarioTemp.setUsuario ( "pedro" );
		usuarioTemp.setPass ( "1234" );
		lstUsuario.add ( usuarioTemp );
		usuarioTemp = new Usuario ( );
		usuarioTemp.setUsuario ( "diego" );
		usuarioTemp.setPass ( "0987" );
		lstUsuario.add ( usuarioTemp );
		usuarioTemp = new Usuario ( );
		usuarioTemp.setUsuario ( "carlos" );
		usuarioTemp.setPass ( "5678" );
		lstUsuario.add ( usuarioTemp );
		// iniciarSesion ( lstUsuario, usuario );

	}

	public void registrarUsuario ( )
	{
		cargarUsuarios ( );
		lstUsuario.add ( usuario );
		FacesContext.getCurrentInstance ( ).addMessage ( null,
				new FacesMessage ( FacesMessage.SEVERITY_INFO, "Aviso", "Se Creo el Usuario Correctamente" ) );
	}

	public String iniciarSesion ( )
	{
		cargarUsuarios ( );
		String redireccion = null;
		for ( int i = 0; i < lstUsuario.size ( ); i++ )
		{
			Usuario user = lstUsuario.get ( i );
			if ( ( user.getUsuario ( ).equals ( usuario.getUsuario ( ) ) ) && ( user.getPass ( ).equals ( usuario.getPass ( ) ) ) )
			{
				redireccion = "index?faces-redirect=true";
				break;
			}
			else
			{
				FacesContext.getCurrentInstance ( ).addMessage ( null,
						new FacesMessage ( FacesMessage.SEVERITY_INFO, "Aviso", "Credenciales Incorrectas" ) );
				redireccion = "";
			}

		}
		return redireccion;

	}
}
