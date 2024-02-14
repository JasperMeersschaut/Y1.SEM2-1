package domein;


import java.security.PrivilegedActionException;
import java.time.LocalDate;
import java.util.Objects;

public class Film {
    private int sterren;
    private String naam;
    private int jaar;
    public static final int HUIDIG_JAAR = LocalDate.now().getYear();
    public static final int MIN_STERREN = 0;
    public static final int MAX_STERREN = 5;
    public static final int MIN_JAAR = 1900;

    public Film(String naam, int sterren, int jaar) {
     setNaam(naam);
     setSterren(sterren);
     setJaar(jaar);
    }

    public int getSterren() {
        return sterren;
    }

    private void setSterren(int sterren) {
        if (sterren<MIN_STERREN||sterren>MAX_STERREN){
            throw new IllegalArgumentException(String.format("Aantal sterren ligt in het interval [%d,%d]",MIN_STERREN,MAX_STERREN));
        }
        this.sterren = sterren;
    }

    public String getNaam() {
        return naam;
    }

    private void setNaam(String naam) {
        if (naam ==null ||naam.isBlank()){
            throw new IllegalArgumentException(String.format("Je naam moet goed zijn"));
        }
        this.naam = naam;
    }

    public int getJaar() {
        return jaar;
    }

    private void setJaar(int jaar) {
        if (jaar < MIN_JAAR||jaar > HUIDIG_JAAR){
            throw new IllegalArgumentException(String.format("jaar moet in het interval [%d,%d] liggen",MIN_JAAR, HUIDIG_JAAR));
        }
        this.jaar = jaar;
    }
    @Override
    public int hashCode() {
        return Objects.hash(naam, jaar);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return jaar == film.jaar && Objects.equals(naam, film.naam);
    }

    @Override
    public String toString() {
     return String.format("%s %s - %d - %d",getClass().getSimpleName(), naam, sterren,jaar);
    }
}


