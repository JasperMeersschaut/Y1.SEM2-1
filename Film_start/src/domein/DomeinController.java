package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {

	private final FilmRepository filmRepo;
	
	
	public DomeinController() {
		filmRepo = new FilmRepository();
	}


	public List<String> geefAlleFilms() {
		List<Film>films= filmRepo.getFilms();
		List<String> filmAlsStrings = new ArrayList<>();

		for (Film film : films){
			filmAlsStrings.add(film.toString()) ;
		}
		return  filmAlsStrings;
	}
	
	public void voegFilmToe(String naam, int jaar, int sterren) {
		filmRepo.voegFilmToe(new Film(naam, sterren , jaar));
	}
	
	public int geefAantalFilms() {
		return filmRepo.geefAantalFilms();
	}
}
