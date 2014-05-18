package Parser;

import entity.Text;
import entity.TextPart;
import entity.sentence.Sentence;
import entity.sentence.SentencePart;
import entity.ComparatorOfSentences;
import entity.sentence.Punctuation;
import entity.sentence.Code;
import entity.sentence.Word;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 10:52:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Parser {

    private Parser() {}

    public static Collection<TextPart> parseText(File f) throws IOException {
        return parseText(readFile(f.getAbsolutePath(), Charset.forName("UTF-8")));
    }

    public static Collection<TextPart> parseText(String text) {

        Collection<TextPart> textParts = new TreeSet<TextPart>(new ComparatorOfSentences());


        Pattern pattern = Pattern.compile("([^.!?]+[.!?])");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String match = matcher.group();
            Sentence sentence = new Sentence(matcher.start(), parseSentence(match));
            textParts.add(sentence);
        }

        return textParts;
    }

    public static Collection<SentencePart> parseSentence(String sentence) {

        sentence = sentence.replaceAll("\r", "\n");

        Collection<SentencePart> parts = new TreeSet<SentencePart>();

        Pattern codePattern = Pattern.compile("(\\{[^}]+})");
        Matcher codeMatcher = codePattern.matcher(sentence);
        while (codeMatcher.find()) {
            if (codeMatcher.group(1) != null) {
                Code code = new Code(codeMatcher.start(1), codeMatcher.group(1));
                parts.add(code);
            }
        }

        Pattern wordPattern = Pattern.compile("(\\w+)|(\\W+)");
        Matcher wordMatcher = wordPattern.matcher(sentence);
        while (wordMatcher.find()) {
            if (wordMatcher.group(1) != null) {
                Word word = new Word(wordMatcher.start(1), wordMatcher.group(1));
                parts.add(word);
            }
            if (wordMatcher.group(2) != null) {
                Punctuation punctuation = new Punctuation(wordMatcher.start(2), wordMatcher.group(2));
                parts.add(punctuation);
            }
        }

        return parts;
    }


    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
