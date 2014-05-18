package command;

import entity.Text;
import entity.TextPart;
import entity.sentence.Sentence;
import entity.sentence.SentencePart;
import entity.sentence.Word;

import java.util.*;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 9:54:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SortByCountOfWords implements Command {
    public void execute(Text text) {
        List<TextPart> parts = new ArrayList<TextPart>(text.getTextParts());
        Collections.sort(parts, new Comparator<TextPart>() {
            public int compare(TextPart o1, TextPart o2) {
                Collection<SentencePart> partOfFirstSentence = ((Sentence)o1).getSentenceParts();
                Collection<SentencePart> partOfSecondSentence = ((Sentence)o2).getSentenceParts();

                int wordInFirstSentence = 0;
                for (SentencePart part : partOfFirstSentence) {
                    if (part instanceof Word) {
                        wordInFirstSentence++;
                    }
                }

                int wordInSecondSentence = 0;
                for (SentencePart part : partOfSecondSentence) {
                    if (part instanceof Word) {
                        wordInSecondSentence++;
                    }
                }

                return wordInFirstSentence - wordInSecondSentence;
            }
        });


        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ SORT BY COUNT OF WORDS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        int i = 0;
        for (TextPart part : parts) {
            System.out.println(++i + ". " + part);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   SORT END   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
}
