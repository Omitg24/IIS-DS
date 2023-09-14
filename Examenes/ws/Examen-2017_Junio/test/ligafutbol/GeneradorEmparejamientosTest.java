package ligafutbol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ligafutbol.validators.CheckAll;
import ligafutbol.validators.SameAge;
import ligafutbol.validators.SameGender;

public class GeneradorEmparejamientosTest {
	private GeneradorEmparejamientos generador;
	private Equipo callealteros, racingTenderina, ramonPelayo, realUria,
			maragatos, sportingLeon;
	private List<Equipo> equipos;

	@Before
	public void setUp() {
		generador = new GeneradorEmparejamientos(new CheckAll(new SameGender(), new SameAge()));
		equipos = new ArrayList<Equipo>();

		callealteros = new Equipo("Callealteros", "Cantabria", true, 10);
		racingTenderina = new Equipo("Racing de Tenderina", "Asturias", false,
				11);
		ramonPelayo = new Equipo("Colegio Ramón Pelayo", "Cantabria", false,
				10);
		realUria = new Equipo("Real Uría", "Asturias", true, 10);
		maragatos = new Equipo("Los Maragatos", "León", true, 10);
		sportingLeon = new Equipo("Sporting de León", "León", false, 11);

		equipos.add(callealteros);
		equipos.add(racingTenderina);
		equipos.add(ramonPelayo);
		equipos.add(realUria);
		equipos.add(maragatos);
		equipos.add(sportingLeon);
	}

	@Test
	public void testEmpareja() {
		Map<Equipo, List<Equipo>> emparejamientos = generador.empareja(equipos);
		// Racing de Tenderina
		List<Equipo> contrincantesRacingTenderina = emparejamientos
				.get(racingTenderina);
		assertEquals(1, contrincantesRacingTenderina.size());
		assertTrue(contrincantesRacingTenderina.contains(sportingLeon));
		// Maragatos
		List<Equipo> contrincantesMaragatos = emparejamientos.get(maragatos);
		assertEquals(2, contrincantesMaragatos.size());
		assertTrue(contrincantesMaragatos.contains(callealteros));
		assertTrue(contrincantesMaragatos.contains(realUria));
		// Sporting de León
		List<Equipo> contrincantesSportingLeon = emparejamientos
				.get(sportingLeon);
		assertEquals(1, contrincantesSportingLeon.size());
		assertTrue(contrincantesSportingLeon.contains(racingTenderina));
		// Real Uría
		List<Equipo> contrincantesRealUria = emparejamientos.get(realUria);
		assertEquals(2, contrincantesRealUria.size());
		assertTrue(contrincantesRealUria.contains(callealteros));
		assertTrue(contrincantesRealUria.contains(maragatos));
		// Callealteros
		List<Equipo> contrincantesCallealteros = emparejamientos
				.get(callealteros);
		assertEquals(2, contrincantesCallealteros.size());
		assertTrue(contrincantesCallealteros.contains(realUria));
		assertTrue(contrincantesCallealteros.contains(maragatos));
		// Colegio Ramón Pelayo
		List<Equipo> contrincantesRamonPelayo = emparejamientos
				.get(ramonPelayo);
		assertEquals(0, contrincantesRamonPelayo.size());
	}
}
