/*This class will have the following instance variables:
String name – the name of the movie
ArrayList<Actor> actors – an ArrayList of the actors in the movie. 
double rating – a freshness rating from rotten tomatoes (www.rottentomatoes.com)
Add getters and setters for these instance variables.


Make sure to create a constructor that initializes your variables appropriately.*/
import java.util.*;

public class Movie {
	private String name;
	private ArrayList<Actor> actors;
	private double rating;

	public Movie(String name,ArrayList<Actor> actors,double rating) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.actors = actors;
		this.rating = rating;

	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Actor> getActors() {
		return this.actors;
	}
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	public double getRating() {
		return this.rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

}
