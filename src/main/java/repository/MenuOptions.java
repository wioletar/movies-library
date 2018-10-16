package repository;

import model.Actor;
import model.Movie;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuOptions {

    public static void genreSearch(List<Movie> movies) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Podaj rodzaj filmu:");
        String genre = scanner.next();
        for (Movie e : movies) {
            if (e.getGenre().compareTo(genre) == 0)
                System.out.println(e.getTitle());
        }
    }

    public static void actorSearch(List<Movie> movies) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Podaj nazwisko aktora");
        String name = scanner.next();
        for (Movie e : movies) {
            for (Actor a : e.getListOfActors()) {
                if (a.getLastName().compareTo(name) == 0)
                    System.out.println(e.getTitle());
            }
        }
    }

    public static void dateSearch(List<Movie> movies) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj zakres daty od(DD.MM.YYYY):");
        String dateFromString = scanner.next();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date dateFrom = format.parse(dateFromString);

        System.out.println("Podaj zakres daty do(DD.MM.YYYY");
        String dateToString = scanner.next();
        Date dateTo = format.parse(dateToString);

        for (Movie e : movies) {
            if (e.getDateOfProduction().before(dateTo) && e.getDateOfProduction().after(dateFrom))
                System.out.println(e.getTitle());
        }
    }

    public static void moviesPrint(List<Movie> movies) {
        for (Movie e : movies) {
            System.out.println("FILM: "+e.getTitle()+".\n"+"REŻYSER: "+e.getDirector()+".\n"+"DATA: "+e.getDateOfProduction()+".\n"+"GATUNEK: "+e.getGenre()+".\n"+"Aktorzy: "+e.getListOfActors());
        }
    }

}
