package com.learning.datastructure;

public class GraphNode {
	String city;
	boolean visited;
	int edge;
	
	GraphNode(){
		
	}
	
	GraphNode(String city){
		this.city = city;
		this.edge = 0;
		this.visited = false;
	}
	
	GraphNode(String city, int edge){
		this.city = city;
		this.edge = edge;
		this.visited = false;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + edge;
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (edge != other.edge)
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}
	
	
}
