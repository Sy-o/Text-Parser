package command;

import entity.Text;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 9:53:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
    public void execute(Text text);
}
