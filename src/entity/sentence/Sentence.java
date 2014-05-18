package entity.sentence;

import entity.TextPart;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 9:10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sentence extends TextPart {
    private Collection<SentencePart> sentenceParts;

    public Sentence(int position, Collection<SentencePart> sentenceParts) {
        super.setPosition(position);
        this.sentenceParts = sentenceParts;
    }

    public Collection<SentencePart> getSentenceParts() {
        return sentenceParts;
    }

    public void setPartsOfSentence(Collection<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (SentencePart part : sentenceParts) {
            if (!(part instanceof Code)) {
                sentence.append(part);
            }
        }
        return sentence.toString();
    }
}
