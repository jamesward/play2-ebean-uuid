package controllers;

import models.Bar;
import play.*;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;
import java.util.UUID;

public class Application extends Controller {

    public static Result index() {
        return redirect(routes.Application.getBars());
    }

    public static Result addBar() {
        Bar bar = form(Bar.class).bindFromRequest().get();
        bar.save();
        return redirect(routes.Application.index());
    }

    public static Result getBars() {
        List<Bar> bars = new Bar.Finder(String.class, Bar.class).all();
        return ok(barList.render(bars));
    }
    
    public static Result getBar(UUID id) {
        Bar bar = new Bar.Finder<String, Bar>(String.class, Bar.class).byId(id.toString());
        return ok(barDetail.render(bar));
    }

}