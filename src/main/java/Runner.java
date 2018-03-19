import antlr.DocBookCodeGenerator;
import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("All American Action Films Inc");
        DBHelper.saveOrUpdate(studio1);

        Director director1 = new Director("John Carpenter");
        DBHelper.saveOrUpdate(director1);
        Director director2 = new Director("Edmund Burke");
        DBHelper.saveOrUpdate(director2);

        Actor actor1 = new Actor("Nick Nicholson");
        DBHelper.saveOrUpdate(actor1);
        Actor actor2 = new Actor("Jarvis Arbuckle");
        DBHelper.saveOrUpdate(actor2);
        Actor actor3 = new Actor("Spingle Gambolls");
        DBHelper.saveOrUpdate(actor3);


        Film film1 = new Film("I Married My Gun", 2018, 5000000,"Mumblecore", studio1, director1);
        DBHelper.saveOrUpdate(film1);

        Film film2 = new Film("Dancing with Databases", 1976, 1000000, "Farce", studio1, director2);
        DBHelper.saveOrUpdate(film2);


        //        then test delete things,
//        then add extensions
//        add actors to films, then do budget change

//        test FIND

        Film foundFilm = DBHelper.find(Film.class, film1.getId());
        Actor foundActor = DBHelper.find(Actor.class, actor1.getId());
        Director foundDirector = DBHelper.find(Director.class, director1.getId());
        Studio foundStudio = DBHelper.find(Studio.class, studio1.getId());

//        test UPDATE

        foundStudio.setName("AAAF inc");
        DBHelper.saveOrUpdate(foundStudio);

        List<Film> allFilms = DBHelper.getAll(Film.class);
        List<Actor> allActors = DBHelper.getAll(Actor.class);
        List<Director> allDirectors = DBHelper.getAll(Director.class);
        List<Studio> allStudios = DBHelper.getAll(Studio.class);

//        test GET FILMS BY DIRECTOR
        List<Film> filmsByDirector1 = DBHelper.getFilmsByDirector(director1);

//        test GET FILMS BY FIELD
//          problem thrown up by Actors
        List<Film> filmsByFieldDirector = DBHelper.getFilmsByField("director", director1);
        List<Film> filmsByFieldStudio = DBHelper.getFilmsByField("studio", studio1);

//        test ADD ACTOR TO FILM
        DBHelper.addActorToFilm(foundActor, foundFilm);
        foundFilm = DBHelper.find(Film.class, film1.getId());
        foundActor = DBHelper.find(Actor.class, actor1.getId());




//        test DELETE
//          have to delete Films first before you can delete Director, Studio or Actors
//        how to get round this

//        DBHelper.delete(foundActor);
//        DBHelper.delete(foundFilm);
//        DBHelper.delete(foundDirector);
//        DBHelper.delete(foundStudio);

//        test GET ACTORS FILMS
        DBHelper.addActorToFilm(actor1, film2);
        int countFarce = DBHelper.countActorFilmsByGenre(actor1, "Farce");

        List<Film> filmsOfGenre = DBHelper.getFilmsByGenre("Farce");

        List<Film> filmsWithActor = DBHelper.getFilmsByActor(actor1);

    }
}
