package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private UndirectedGraph<Country,DefaultEdge> grafo;
	private BordersDAO dao;
	private List<Country> country;

	public Model() {
		grafo=new SimpleGraph<Country,DefaultEdge>(DefaultEdge.class);
		dao=new BordersDAO();
		country=new ArrayList<Country>();
		country=dao.loadAllCountries();
		
	}
	
	public void creaGrafo(int anno){
		
		Graphs.addAllVertices(grafo,country);
		
		List<Border> confini=new ArrayList<Border>();
		
		int a=1816;
		while(a<=anno){
			confini.addAll(dao.getCountryPairs(a));
			a++;
		}
		
		for (Border b:confini){
			if (!grafo.containsEdge(getCountry(b.getCc1()),getCountry(b.getCc2())))
					grafo.addEdge(getCountry(b.getCc1()),getCountry(b.getCc2()));
		}
		
	}
	
	public List<String> stampa(){
		
		List<String> st=new ArrayList<String>();
		
		for(Country c:grafo.vertexSet()){
			st.add(c.getName()+" "+grafo.degreeOf(c));
		}
		
		return st;
	}
	
	public Country getCountry(int cc){
		for (Country c:country){
			if (c.getCcode()==cc)
				return c;
		}
		return null;
	}
	
	public int numeroComponentiConnessi(){
		
//		BreadthFirstIterator<Country,DefaultEdge> bfi= new BreadthFirstIterator<>(grafo);
		
		int contatore=1;
		
//		while(bfi.hasNext()){
//			contatore++;
//		}
		
		return contatore;
	}
	
}
