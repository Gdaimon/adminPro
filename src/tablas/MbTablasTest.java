package tablas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MbTablasTest {

	private MbTablas mbTabla;

	public MbTablasTest ( )

	{
		mbTabla = new MbTablas ( );
	}

	@Test
	public void verTareaPrincipalTest ( )
	{
		assertEquals ( "principal?faces-redirect=true", mbTabla.verTareaPrincipal ( 1 ) );

	}

}
