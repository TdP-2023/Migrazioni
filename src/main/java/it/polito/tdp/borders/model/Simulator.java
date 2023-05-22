package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class Simulator {
	
	// Stato del sistema e output
	private Map<Country, Integer> stanziali ;
	

	// Parametri della simulazione
	private Graph<Country, DefaultEdge> graph ;
	private int nPersone = 1000 ;
	private Country partenza ;
	
	// Output
	private int nPassi ;
	
	// Coda degli eventi
	private PriorityQueue<Event> queue ;
	
	
	public Simulator(Graph<Country, DefaultEdge> graph, Country partenza) {
		this.graph = graph ;
		this.partenza = partenza ;
		
		this.nPassi = 0 ;
		
		this.stanziali = new HashMap<Country, Integer>() ;
		for(Country c: this.graph.vertexSet()) {
			this.stanziali.put(c, 0) ;
		}
		
		this.queue = new PriorityQueue<>() ;
	}
	
	public void initialize() {
		this.queue.add(new Event( 0, this.partenza, this.nPersone ));
	}
	
	public void run() {
		while(!this.queue.isEmpty()) {
			Event e = this.queue.poll() ;
			System.out.println(e);
			int time = e.getTime() ;
			Country destinazione = e.getDestinazione() ;
			int dimensione = e.getDimensione() ;
			
			
			// dimensione / 2 si dividono negli stati adiacenti
			// generando eventi INGRESSO con la quota di persone

			// i rimanenti diventano stanziali nello stato 'destinazione'

		}
	}

	public Map<Country, Integer> getStanziali() {
		return stanziali;
	}


}
