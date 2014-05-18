package entity.sentence;

/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: May 18, 2014
 * Time: 9:06:37 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class SentencePart implements Comparable<SentencePart>{
     private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int compareTo(SentencePart o) {
        return this.position - o.position;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
