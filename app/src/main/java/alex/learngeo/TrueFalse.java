package alex.learngeo;

/**
 * Created by ALEX on 2016/4/15 0015.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTruefalse;

    public  TrueFalse(int question, boolean truefalse) {
        mQuestion = question;
        mTruefalse = truefalse;
    }

    public boolean isTruefalse() {
        return mTruefalse;
    }

    public void setTruefalse(boolean truefalse) {
        mTruefalse = truefalse;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }
}
