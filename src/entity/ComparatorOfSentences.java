package entity;

import java.util.Comparator;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 9:00:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComparatorOfSentences implements Comparator<TextPart> {
    public int compare(TextPart o1, TextPart o2) {
        return o1.getPosition() - o2.getPosition();
    }
}
