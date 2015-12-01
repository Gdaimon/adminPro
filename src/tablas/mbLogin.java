package tablas;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Data;
import tablas.modelo.Usuario;

@Named ( value = "mbLogin" )
@SessionScoped
public @Data class mbLogin implements Serializable {
	private Usuario		usuario;
	private mBUsuario	mb;

}
