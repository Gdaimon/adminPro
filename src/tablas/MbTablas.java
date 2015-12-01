package tablas;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;

import indicador.ActualizarIndicador;
import tablas.modelo.DatosActividades;

@Named ( value = "mbTablas" )
@SessionScoped
public class MbTablas implements Serializable {

	ArrayList < DatosActividades >	ListaGeneral	= null;
	ArrayList < DatosActividades >	ListaPrincipal	= null;
	ArrayList < DatosActividades >	ListaDetalle	= null;
	ArrayList < DatosActividades >	ListaSecundaria	= null;
	DatosActividades				seleccion		= new DatosActividades ( );
	DatosActividades				seleccionPpal	= new DatosActividades ( );
	DatosActividades				seleccionSecond	= new DatosActividades ( );
	ActualizarIndicador				actInd;

	public DatosActividades getSeleccionSecond ( )
	{
		return seleccionSecond;
	}

	public void setSeleccionSecond ( DatosActividades seleccionSecond )
	{
		this.seleccionSecond = seleccionSecond;
	}

	DataTable	tablaGeneral	= new DataTable ( );
	Integer		noFila;

	public MbTablas ( )
	{

	}

	public ArrayList < DatosActividades > getListaGeneral ( )
	{
		if ( ListaGeneral == null )
		{
			ListaGeneral = new ArrayList < > ( );
			for ( int i = 0; i < 10; i++ )
			{
				DatosActividades datAct = new DatosActividades ( );
				datAct.setIdAct ( i + 1 );
				datAct.setIdPpal ( ( int ) ( Math.random ( ) * 10 + 1 ) );
				datAct.setTipoActividad ( "Principal" );
				datAct.setNivel ( ( int ) ( Math.random ( ) * 10 + 1 ) );
				datAct.setNombreActividad ( "Principal" );
				datAct.setValorEsperado ( 100.00 );
				datAct.setValorAlcanzado ( ( Double ) ( Math.random ( ) * 99 + 1 ) );
				ListaGeneral.add ( datAct );
			}
		}

		return ListaGeneral;
	}

	// Metodo Seleccion Seleccion Tarea Principal
	public String verTareaPrincipal ( Integer in )
	{
		int noFila = in;
		String redireccion = null;
		ListaPrincipal = new ArrayList < > ( );
		ListaPrincipal.add ( ListaGeneral.get ( noFila ) );
		System.out.println ( ListaGeneral.get ( noFila ) );
		redireccion = "principal?faces-redirect=true";
		return redireccion;

	}

	public void setListaGeneral ( ArrayList < DatosActividades > ListaGeneral )
	{
		this.ListaGeneral = ListaGeneral;
	}

	public DatosActividades getSeleccion ( )
	{
		return seleccion;
	}

	public void setSeleccion ( DatosActividades seleccion )
	{
		this.seleccion = seleccion;
	}

	public ArrayList < DatosActividades > getListaPrincipal ( )
	{
		return ListaPrincipal;
	}

	public void setListaPrincipal ( ArrayList < DatosActividades > listaPrincipal )
	{
		ListaPrincipal = listaPrincipal;
	}

	public ArrayList < DatosActividades > getListaDetalle ( )
	{
		if ( ListaDetalle == null )
		{
			ListaDetalle = new ArrayList < > ( );
			for ( int i = 0; i < 10; i++ )
			{
				DatosActividades datAct = new DatosActividades ( );
				datAct.setIdAct ( i + 1 );
				datAct.setIdPpal ( ( int ) ( Math.random ( ) * 10 + 1 ) );
				datAct.setTipoActividad ( "Principal" );
				datAct.setNivel ( ( int ) ( Math.random ( ) * 10 + 1 ) );
				datAct.setNombreActividad ( "Principal" );
				datAct.setValorEsperado ( 1.00 );
				datAct.setValorAlcanzado ( ( Double ) ( Math.random ( ) * 0.9 + 0.1 ) );
				ListaDetalle.add ( datAct );
			}
		}

		return ListaDetalle;
	}

	public void setListaDetalle ( ArrayList < DatosActividades > listaDetalle )
	{
		ListaDetalle = listaDetalle;
	}

	public ArrayList < DatosActividades > getListaSecundaria ( )
	{
		if ( ListaSecundaria == null )
		{
			ListaSecundaria = new ArrayList < > ( );
			for ( int i = 0; i < 10; i++ )
			{
				DatosActividades datAct = new DatosActividades ( );
				datAct.setIdAct ( i + 1 );
				datAct.setIdPpal ( ( int ) ( Math.random ( ) * 10 + 1 ) );
				datAct.setTipoActividad ( "Principal" );
				datAct.setNivel ( ( int ) ( Math.random ( ) * 10 + 1 ) );
				datAct.setNombreActividad ( "Principal" );
				datAct.setValorEsperado ( 100.00 );
				datAct.setValorAlcanzado ( ( Double ) ( Math.random ( ) * 99 + 1 ) );
				ListaSecundaria.add ( datAct );
			}
		}
		return ListaSecundaria;
	}

	public void setListaSecundaria ( ArrayList < DatosActividades > listaSecundaria )
	{
		ListaSecundaria = listaSecundaria;
	}

	public Integer getNoFila ( )
	{
		return noFila;
	}

	public void setNoFila ( Integer noFila )
	{
		this.noFila = noFila;
	}

	public String editarActPpal ( Integer in )
	{
		noFila = in;
		String redireccion = null;
		seleccionPpal.setIdAct ( ListaPrincipal.get ( in ).getIdAct ( ) );
		seleccionPpal.setIdPpal ( ListaPrincipal.get ( in ).getIdPpal ( ) );
		seleccionPpal.setNivel ( ListaPrincipal.get ( in ).getNivel ( ) );
		seleccionPpal.setNombreActividad ( ListaPrincipal.get ( in ).getNombreActividad ( ) );
		seleccionPpal.setTipoActividad ( ListaPrincipal.get ( in ).getTipoActividad ( ) );
		seleccionPpal.setValorAlcanzado ( ListaPrincipal.get ( in ).getValorAlcanzado ( ) );
		seleccionPpal.setValorEsperado ( ListaPrincipal.get ( in ).getValorEsperado ( ) );
		redireccion = "editarActPpal?faces-redirect=true";
		return redireccion;

	}

	public String editarActSecundaria ( Integer in )
	{
		noFila = in;
		String redireccion = null;
		seleccionSecond.setIdAct ( ListaSecundaria.get ( in ).getIdAct ( ) );
		seleccionSecond.setIdPpal ( ListaSecundaria.get ( in ).getIdPpal ( ) );
		seleccionSecond.setNivel ( ListaSecundaria.get ( in ).getNivel ( ) );
		seleccionSecond.setNombreActividad ( ListaSecundaria.get ( in ).getNombreActividad ( ) );
		seleccionSecond.setTipoActividad ( ListaSecundaria.get ( in ).getTipoActividad ( ) );
		seleccionSecond.setValorAlcanzado ( ListaSecundaria.get ( in ).getValorAlcanzado ( ) );
		seleccionSecond.setValorEsperado ( ListaSecundaria.get ( in ).getValorEsperado ( ) );
		redireccion = "editarActSecond?faces-redirect=true";
		return redireccion;

	}

	public String guardarCambiosActPpal ( )
	{

		String redireccion = null;
		ListaPrincipal.remove ( 0 );

		ListaPrincipal.add ( seleccionPpal );

		redireccion = "principal?faces-redirect=true";
		return redireccion;

	}

	public String guardarCambiosActSecond ( )
	{

		String redireccion = null;

		for ( int i = 0; i < ListaSecundaria.size ( ); i++ )
		{
			if ( ( ListaSecundaria.get ( i ).getIdPpal ( ) == seleccionSecond.getIdPpal ( ) )
					&& ( ListaSecundaria.get ( i ).getIdAct ( ) == seleccionSecond.getIdAct ( ) ) )
			{
				ListaSecundaria.set ( i, seleccionSecond );
				break;
			}
		}
		actInd = new ActualizarIndicador ( );
		// actInd.actInd ( seleccionSecond, ListaSecundaria );
		redireccion = "principal?faces-redirect=true";
		return redireccion;

	}

	public DatosActividades getSeleccionPpal ( )
	{
		return seleccionPpal;
	}

	public void setSeleccionPpal ( DatosActividades seleccionPpal )
	{
		this.seleccionPpal = seleccionPpal;
	}

}
