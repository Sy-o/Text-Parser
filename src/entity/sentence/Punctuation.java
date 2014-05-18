package entity.sentence;

/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 9:18:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Punctuation extends SentencePart {
    private String punctuation;

    public Punctuation(int position, String punctuation) {
        super.setPosition(position);
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return punctuation;
    }
}
