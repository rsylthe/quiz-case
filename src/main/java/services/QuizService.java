package services;

import beans.Question;
import beans.Quiz;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 20.09.2017.
 *
 * @author Roy Åne Sylthe
 * @version 0.1.0
 */
@Path("/quiz/")
public class QuizService {
    private static final Map<Integer, Quiz> quizzes = new HashMap<>();
    private static int nextId = 0;

    /**
     * {GET} all quizzes on the server.
     * @return  Collection of quizzes.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }

    /**
     * {GET} a specific quiz identified by its {id}.
     * @param id    ID specific to a single quiz.
     * @return      The specified quiz if it exists, 404 NotFoundException otherwise.
     */
    @Path("/{quizId}/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Quiz getQuiz(@PathParam("quizId") int id) {
        if (quizzes.get(id) != null) {
            return quizzes.get(id);
        } else {
            throw new NotFoundException("404, quiz not found");
        }
    }

    @PUT
    @Path("/{quizId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateQuiz(Quiz quiz) {
        if (quizzes.get(quiz.getId()) != null) {
            quizzes.put(quiz.getId(), quiz);
        } else {
            throw new NotFoundException("404, quiz not found");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postQuiz(Quiz quiz) {
        quiz.setId(nextId++);
        for (Question question : quiz.getQuestions()) {
            QuestionService.postQuestion(question);
        }
        quizzes.putIfAbsent(quiz.getId(), quiz);
    }

    @DELETE
    @Path("/{quizId}/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteQuiz(Quiz quiz) {
        quizzes.remove(quiz.getId());
    }
}
