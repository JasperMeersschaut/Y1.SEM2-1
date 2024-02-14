package testen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Film;

import static org.junit.jupiter.api.Assertions.*;

public class FilmTest {
    private static final int HUIDIG_JAAR = 2024;
    private static final int MIN_STERREN = 0;
    private static final int MAX_STERREN = 5;
    private static final int MIN_JAAR = 1900;

    @Test
    void maakFlim_alleParametersOK_creatieFilm() {
        // arrange, act
        Film film = new Film("test", 4, 2005);

        // assert
        assertEquals("test", film.getNaam());
        assertEquals(4, film.getSterren());
        assertEquals(2005, film.getJaar());

    }

    // testen op sterren
    @ParameterizedTest
    @ValueSource(ints = {3, MIN_STERREN, MAX_STERREN})
    void maakFilm_sterrenOK_maaktFilm(int sterren) {
        // arrange, act
        Film film = new Film("test", sterren, 2005);
        // assert
        assertEquals("test", film.getNaam());
        assertEquals(sterren, film.getSterren());
        assertEquals(2005, film.getJaar());
    }

    @ParameterizedTest
    @ValueSource(ints = {60, -20, 6, -1})
    void maakFilm_sterrenNOK_gooitException(int sterren) {
        // arrange, act, assert
        assertThrows(IllegalArgumentException.class,
                () -> new Film("test", sterren, 2005));


    }


    //testen op jaar
    @ParameterizedTest
    @ValueSource(ints = {2000, MIN_JAAR, HUIDIG_JAAR})
    void maakFIlm_jaarOk_maaktFilm(int jaar) {
        Film film = new Film("test", 4, jaar);
    //Arrange ,Act en Assert
        assertEquals("test", film.getNaam());
        assertEquals(4, film.getSterren());
        assertEquals(jaar, film.getJaar());
    }

    @ParameterizedTest
    @ValueSource(ints = {1899, 2025, 3000, 1700})
    void maakFilm_jaarNOK_gooitException(int jaar) {

        // arrange, act, assert
        assertThrows(IllegalArgumentException.class, () -> new Film("test", 4, jaar));
    }


    //neg test op naam
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"    ", "\t", "\n"})
    void maakFilm_naamNOk_maaktFilm(String naam) {
        assertThrows(IllegalArgumentException.class, () -> new Film(naam, 4, 2000));
    }

    //testen op equals
    @Test
    void equals_naamJaarGelijk_filmsGelijk() {
    //Arange
        Film film1 = new Film("test", MAX_STERREN, HUIDIG_JAAR);
        Film film2 = new Film("test", 2, HUIDIG_JAAR);

        assertTrue(film1.equals(film2));
    }

    @Test
    void equals_naamJaarNietGelijk_filmsGelijk() {
        Film film1 = new Film("test", MAX_STERREN, HUIDIG_JAAR);
        Film film2 = new Film("test", 2, HUIDIG_JAAR - 1);

        assertFalse(film1.equals(film2));
    }

}