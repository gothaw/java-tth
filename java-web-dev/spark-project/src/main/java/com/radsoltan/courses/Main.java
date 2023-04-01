package com.radsoltan.courses;

import com.radsoltan.courses.model.CourseIdea;
import com.radsoltan.courses.model.CourseIdeaDAO;
import com.radsoltan.courses.model.NotFoundException;
import com.radsoltan.courses.model.SimpleCourseIdeaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    private static final String FLASH_MESSAGE_KEY = "flash_message";

    public static void main(String[] args) {
        staticFileLocation("/public");
        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        before(((request, response) -> {
            String username = request.cookie("username");

            if (username != null) {
                request.attribute("username", username);
            }
        }));

        before("/ideas", ((request, response) -> {
            if (request.attribute("username") == null) {
                setFlashMessage(request, "Please sign in first.");
                response.redirect("/");
                halt();
            }
        }));

        get("/", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", request.attribute("username"));
            model.put("flashMessage", captureFlashMessage(request));

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (request, response) -> {
            String username = request.queryParams("username");
            response.cookie("username", username);
            response.redirect("/");

            return null;
        });

        post("/ideas", (request, response) -> {
            String title = request.queryParams("title");
            CourseIdea courseIdea = new CourseIdea(title, request.attribute("username"));
            dao.add(courseIdea);
            response.redirect("/ideas");
            return null;
        });

        get("/ideas", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("ideas", dao.findAll());
            model.put("flashMessage", captureFlashMessage(request));

            return new ModelAndView(model, "ideas.hbs");
        }, new HandlebarsTemplateEngine());

        post("/ideas/:slug/vote", (request, response) -> {
            CourseIdea courseIdea = dao.findBySlug(request.params("slug"));
            boolean added = courseIdea.addVoter(request.attribute("username"));
            if (added) {
                setFlashMessage(request, "Thanks for you vote!");
            } else {
                setFlashMessage(request, "You already voted.");
            }
            response.redirect("/ideas");
            return null;
        });

        get("/ideas/:slug", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            CourseIdea courseIdea = dao.findBySlug(request.params("slug"));
            model.put("idea", courseIdea);

            return new ModelAndView(model, "idea.hbs");
        }, new HandlebarsTemplateEngine());

        exception(NotFoundException.class, (exception, request, response) -> {
           response.status(404);
           HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine(); // Building custom model and view
           String html = engine.render(new ModelAndView(null, "not-found.hbs"));
           response.body(html);
        });
    }

    private static void setFlashMessage(Request request, String message) {
        request.session().attribute(FLASH_MESSAGE_KEY, message);
    }

    private static String getFlashMessage(Request request) {
        if (request.session(false) == null) {
            return null;
        }
        if (!request.session().attributes().contains(FLASH_MESSAGE_KEY)) {
            return null;
        }
        return (String) request.session().attribute(FLASH_MESSAGE_KEY);
    }

    private static String captureFlashMessage(Request request) {
        String message = getFlashMessage(request);
        if (message != null) {
            request.session().removeAttribute(FLASH_MESSAGE_KEY);
        }
        return message;
    }
}