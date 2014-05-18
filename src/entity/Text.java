package entity;

import java.util.*;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 8:52:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Text {
    private Collection<TextPart> textParts = new TreeSet<TextPart>(new ComparatorOfSentences());

    public Text(Collection<TextPart> textParts) {
        this.textParts = textParts;
    }

    public void printText() {
        for (TextPart part : textParts) {
            System.out.print(part);
        }
        System.out.println();
    }

    public Collection<TextPart> getTextParts() {
        return textParts;
    }

    public void setTextParts(Collection<TextPart> textParts) {
        this.textParts = textParts;
    }
}
