package command;

import entity.Text;
import entity.sentence.Sentence;
import entity.sentence.Word;
import entity.TextPart;
import entity.sentence.SentencePart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 10:46:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindUniqWord implements Command {
    public void execute(Text text) {
        List<Sentence> sentences = extractSentences(text);

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~ FIND UNIQUE WORD FOR ALL TEXT IN 1'ST SENTENCE ~~~~~~~~~~~~~~~~~~~~");
        Iterator<Sentence> iterator = sentences.iterator();
        List<Word> potencialWords = extractWord(iterator.next());
        while (iterator.hasNext()) {
            List<Word> deletedWord = extractWord(iterator.next());
            potencialWords.removeAll(deletedWord);
        }
        for (Word word : potencialWords) {
            System.out.println(word);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   END OF SEARCH   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private List<Sentence> extractSentences(Text text) {
        List<TextPart> partOfTexts = new ArrayList<TextPart>(text.getTextParts());
        List<Sentence> sentences = new ArrayList<Sentence>();
        for (TextPart part : partOfTexts) {
            if (part instanceof Sentence) {
                sentences.add((Sentence)part);
            }
        }
        return sentences;
    }

    private List<Word> extractWord(Sentence sentence) {
        List<SentencePart> partOfSentences = new ArrayList<SentencePart>(sentence.getSentenceParts());
        List<Word> words = new ArrayList<Word>();
        for (SentencePart part : partOfSentences) {
            if (part instanceof Word) {
                words.add((Word)part);
            }
        }
        return words;
    }
}
