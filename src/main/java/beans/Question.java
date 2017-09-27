package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created on 20.09.2017.
 *
 * @author Roy Åne Sylthe
 * @version 0.1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "timeLimit")
    private int timeLimit;
    @XmlElement(name = "questionText")
    private String questionText;
    @XmlElement(name = "answerChoices")
    private List<String> answerChoices;
    @XmlElement(name = "correctAnswer")
    private int correctAnswer;

    /* Getters */
    public int getId() {
        return id;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    /* Setters */
    public void setId(int id) {
        this.id = id;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setAnswerChoices(List<String> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
