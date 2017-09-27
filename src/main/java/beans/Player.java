package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created on 20.09.2017.
 *
 * @author Roy Åne Sylthe
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "score")
    private int score;

    /* Getters */
    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    /* Setters */

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }
}
