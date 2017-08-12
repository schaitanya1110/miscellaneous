import java.util.ArrayList;

/*
 * This class will have the following instance variables:
String name – the full name of the actor or actress.
ArrayList<Movie> movies – an Arraylist that has movies that this actor has acted in.
Add getters and setters for these instance variables.
Make sure to create a constructor that initializes your variables appropriately.
 */
public class Actor {
	private String name; // name of the actor
	private ArrayList<Movie> movies; // List of Movies this actor has acted in

	Actor(String name, Movie movies){
		this.name = name;
		this.movies = new ArrayList<Movie>();
		

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
 

}
