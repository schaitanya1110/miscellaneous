import java.util.*;
import java.io.*;

public class MovieDatabase {
	ArrayList<Movie> movieList; //– an ArrayList of movies
	ArrayList<Actor> actorList;// – an ArrayList of actors

	public MovieDatabase() {
		this.movieList =  new ArrayList<Movie>();
		this.actorList =  new ArrayList<Actor>();
	}

	/*
	 * This method takes in the name of a movie that is not currently in the database along with a list of actors for that movie. 
		If the movie is already in the database, your code ignores this request  
		If the movie is a new movie, a movie object is created and added to the movieList. 
		If any of the actors happen to be new, they will be added to the actorList.
	 */
	void addMovie(String name, String[] actors) {
		for (Movie movie1 : movieList) {
			if (name.equals(movie1.getName())) {
				/*		ArrayList<Actor> movieactors = new ArrayList<Actor>();
				movieactors = movie1.getActors(); //get already known actors for a movie.

			for (String string : actors) {
				for (Actor actor : movieactors) {
					actor.getName();
				}
			}*/

				return;
			}

			else { 				
				//add movie to movie list
				Movie movie2 = new Movie(name,null,0.0);
				movieList.add(movie2);
			}
			for (String string : actors) {
				if(!actorList.contains(string));{
					actorList.add(new Actor(string,null));
				}
			}

		}}    

	void addRating(String name, double rating) {
		//	Add a rating for this movie. Assume that 
		//  the name argument will definitely be a name that is currently in the database.
		for (Movie movie : movieList) {
			if(movie.getName().equals(name)) {
				movie.setRating(rating);
			}
		}

	}
	void updateRating(String name, double newRating)
	{//	Overwrite the current rating of a movie with this new rating. 
		//Again, assume that the name argument will definitely be a name that is currently in the database.
		for (Movie movie : movieList) {
			if(movie.getName().equals(name)) {
				movie.setRating(newRating);
			}
		}

	}

	String getBestActor() {
		//	Returns the name of the actor that has the best average rating for their movies.
		//	In the case of a tie, return any one of the best actors.
		double highestavgrating = 0.0;
		double totrating = 0.0;
		String bestactor = null;

		for (Actor actor : actorList) {
			ArrayList<Movie> actmovies = actor.getMovies();
			for (Movie movie : actmovies) {
				totrating += movie.getRating();
			}
			if (totrating/actmovies.size() > highestavgrating) {
				highestavgrating = totrating/actmovies.size();
				bestactor = actor.getName();
			}
		}
		return bestactor;


	}
	String getBestMovie() {
		//	Returns the name of the movie with the highest rating.
		//	In the case of a tie, return any one of the best movies.
		double	highestrating = 0.0;
		String bestmovie = null;
		for (Movie movie : movieList) {
			if (movie.getRating() > highestrating) {
				highestrating = movie.getRating();
				bestmovie = movie.getName();
			}
		}
		return bestmovie;


	}


	public ArrayList<String> getMovieList() {
		ArrayList<String> movienames = new ArrayList<String>();
		for (Movie movie : movieList) {
			String name = movie.getName();
			movienames.add(name);
		}
		return movienames;
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}


	public static void main(String[] args) {
		MovieDatabase MD1 =  new MovieDatabase();
		try {
			Scanner scnr = new Scanner(new File("movies.txt")).useDelimiter(",");
			ArrayList<String> word = new ArrayList<String>();
			while(scnr.hasNextLine()) {
				String text = scnr.nextLine();
				//System.out.println(text);

				Scanner scnr1 = new Scanner(text).useDelimiter(",");
				while (scnr1.hasNext()) {
					word.add(scnr1.next());
					//System.out.println(word);

				}
				scnr1.close();
				//Take movies from Word and add to MD.
				for (String string : word) {
					if(string.equals(word.get(0))) {
						continue;
					}else {
						String[] Actor = new String[1];
						Actor[0] = word.get(0);
						MD1.addMovie(string,Actor);

					}
				}
				word.clear();

			}      
			scnr.close();
			//System.out.println(MD1.getMovieList());
			//System.out.println());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//Add ratings for the movies from ratings.txt
		try {
			Scanner scnr = new Scanner(new File("ratings.txt"));
			while (scnr.hasNextLine()) {
				String text = scnr.nextLine();
				//System.out.println(text);
			//	System.out.println(text.split("[\\d]"));
				for (String retval: text.split("[\\d]")) {
					System.out.println(retval);
					
				}			 	

			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



}
