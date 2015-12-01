package tablas.modelo;

import lombok.Data;

public @Data class DatosActividades {
	private Integer	IdAct;
	private Integer	IdPpal;
	private String	TipoActividad;
	private Integer	Nivel;
	private String	NombreActividad;
	private Double	ValorEsperado;
	private Double	ValorAlcanzado;

}
