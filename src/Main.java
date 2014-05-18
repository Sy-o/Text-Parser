import entity.Text;
import command.FindUniqWord;
import command.SortByCountOfWords;
import command.Command;
import Parser.Parser;

import java.io.File;
import java.io.IOException;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 11:04:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {

        File f = new File("test.txt");

        try {
            Text text = new Text(Parser.parseText(f));
            text.printText();

            Command second = new SortByCountOfWords();
            second.execute(text);

            Command third = new FindUniqWord();
            third.execute(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
