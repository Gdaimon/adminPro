package indicador;

import java.util.ArrayList;

import tablas.MbTablas;
import tablas.modelo.DatosActividades;

public class ActualizarIndicador {
	MbTablas			mbTab;
	DatosActividades	seleccion;
	DatosActividades	seleccionTemp;

	public void actInd ( DatosActividades sel, ArrayList < DatosActividades > listaSecundaria )
	{
		double acumulador = 0.00;
		int noRegistros = 0;
		seleccion = new DatosActividades ( );
		ArrayList < DatosActividades > ListSec = null;
		ListSec = listaSecundaria;
		seleccion = sel;
		for ( int i = 0; i < ListSec.size ( ); i++ )
		{
			if ( seleccion.getIdPpal ( ) == ListSec.get ( i ).getIdPpal ( ) )
			{
				acumulador = acumulador + ListSec.get ( i ).getIdPpal ( );
				noRegistros++;
			}
		}
		acumulador = ( ( acumulador ) / noRegistros );

		for ( int i = 0; i < mbTab.getListaGeneral ( ).size ( ); i++ )
		{
			if ( mbTab.getListaGeneral ( ).get ( i ).getIdPpal ( ) == sel.getIdPpal ( ) )
			{
				seleccionTemp = new DatosActividades ( );
				seleccionTemp = mbTab.getListaGeneral ( ).get ( i );
				seleccionTemp.setValorAlcanzado ( acumulador );
				mbTab.getListaGeneral ( ).set ( i, seleccionTemp );
			}
		}
	}
}
