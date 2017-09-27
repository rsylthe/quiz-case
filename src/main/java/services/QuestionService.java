package services;

import beans.Question;

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
@Path("/question/")
public class QuestionService {
    private static final Map<Integer, Question> questions = new HashMap<>();
    private static int nextId = 0;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Question> getQuestions() {
        return questions.values();
    }

    @Path("/{questionId}/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Question getQuestion(@PathParam("questionId") int id) {
        if (questions.get(id) != null) {
            return questions.get(id);
        } else {
            throw new NotFoundException("404");
        }
    }

    @PUT
    @Path("/{questionId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateQuestion(Question question) {
        if (questions.get(question.getId()) != null) {
            questions.put(question.getId(), question);
        } else {
            throw new NotFoundException("404, question not found");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public static void postQuestion(Question question) {
        question.setId(nextId++);
        questions.putIfAbsent(question.getId(), question);
    }

    @DELETE
    @Path("/{questionId}/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteQuestion(Question question) {
        questions.remove(question.getId());
    }
}
