package main;
import java.io.*;

import poll.*;
import poll.observers.*;
import ui.Interviewer;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");
		
		// Detectar los puntos de mejora en el diseño. Rediseñarlo usando uno o
		// más patrones. A partir de este punto no debería tener que modificarse
		// la clase Poll para realizar el resto de las modificaciones.		
		
		poll.addObserver(new PieChart());
		BarChart barChart = new BarChart();
		poll.addObserver(barChart);
		poll.addObserver(new ResultSaver());
		
		// Apartado 1
		// ----------
		// Hacer una nueva versión del programa que al recibir un voto también
		// se dibuje una línea de estado. Una línea de estado es una línea de
		// texto que indica el estado actual de la votación (nº de síes = <x>,
		// nº de noes = <y>).
		poll.addObserver(new StatusBar());
		
		// Apartado 2
		// ----------
		// Hacer una nueva versión del programa que no dibuje el gráfico de
		// barras.
		poll.removeObserver(barChart);
		
		// Apartado 3
		// ----------
		// Hacer otra versión del programa que, en vez de dibujarlo con cada
		// voto, el gráfico circular sólo se dibuje a partir del tercer voto
		// (y a partir de ahí se dibuje con cada voto).
		poll.addObserver(new MinimumVotesObserver(3, new BarChart()));
		
		// Apartado 4
		// ----------
		// Hacer otra versión del programa en la que vuelva a estar el gráfico
		// de barras, pero ahora solo se dibujará cada tres votos (con el primero,
		// cuarto, séptimo, etcétera).		
		poll.addObserver(new FrequencyObserver(3, new BarChart()));

		// Apartado 5
		// ----------
		// Hacer una última versión del programa en la que la línea de estado
		// comience a imprimirse a partir del cuarto voto y a partir de ahí se
		// imprima cada dos (se imprimirá en el cuarto, sexto, octavo, etcétera).
		poll.addObserver(new MinimumVotesObserver(4, new FrequencyObserver(2, new StatusBar())));
		

		//-- Inicio del cuestionario
		
		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}

