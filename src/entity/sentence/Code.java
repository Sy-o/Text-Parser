package entity.sentence;

/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 9:09:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Code extends SentencePart {
    private String code;

    public Code(int position, String code) {
        super.setPosition(position);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String word) {
        this.code = word;
    }

    @Override
    public String toString() {
        return code;
    }
}
