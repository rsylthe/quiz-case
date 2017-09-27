package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 20.09.2017.
 *
 * @author Roy Åne Sylthe
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Quiz {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "startTime")
    private Date startTime;
    @XmlElement(name = "questions")
    private List<Question> questions = new ArrayList<>();
//    @XmlElement(name = "players")
//    private List<Player> players = new ArrayList<>();

    /* Getters */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    /* Setters */
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
