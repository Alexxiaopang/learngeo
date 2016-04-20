package alex.learngeo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class firstActivity extends Activity {


    private Button mButtontrue;
    private Button mButtonfalse;
    private TextView mTextView;
    private Button next;
    private Button last;
    private Button mCheckButton;
    private static final String Tab = "New Activity";
    private static final String key_current = "idex";
    int current = 0;
    private boolean mIsCheater;
    //  int lcurrent = 0;
    private TrueFalse[] mTruefalseinfo = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, true),

    };


    private void updatenext() {
        int questioninfo = mTruefalseinfo[current].getQuestion();
        mTextView.setText(questioninfo);
        // String string =getString(questioninfo).toString() ;
        Log.e("udatenext", "LOG_" + getString(questioninfo).toString());
    }


    private void usertruefalse(boolean useranswer) {
        boolean mtrueorflase = mTruefalseinfo[current].isTruefalse();
        int mcrrent = 0;
        if (mIsCheater) {
            mcrrent = R.string.judgment;
        } else {
            if (useranswer == mtrueorflase) {
                mcrrent = R.string.question_true;
                Log.e("user", "default_true is " + mtrueorflase);
            } else {
                mcrrent = R.string.question_false;

                Log.e("user", "default_true is " + mtrueorflase);
            }
        }
        Toast.makeText(firstActivity.this, mcrrent, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Tab, "is onCreate called");
        setContentView(R.layout.activity_first);
        mButtontrue = (Button) findViewById(R.id.btntrue);
        mButtonfalse = (Button) findViewById(R.id.btnfalse);
        mTextView = (TextView) findViewById(R.id.show);
        next = (Button) findViewById(R.id.nest);
        final int questioninfo = mTruefalseinfo[current].getQuestion();
        mTextView.setText(questioninfo);
        last = (Button) findViewById(R.id.last);
        mCheckButton = (Button) findViewById(R.id.Cheat);
        mButtontrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(firstActivity.this, R.string.question, Toast.LENGTH_SHORT).show();
                usertruefalse(true);
                Log.e("select", "is select true");
            }
        });

        mButtonfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(firstActivity.this, R.string.question, Toast.LENGTH_SHORT).show();
                usertruefalse(false);
                Log.e("select", "is select false");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = (current + 1) % mTruefalseinfo.length;
                //  int questioninfo = mTruefalseinfo[current].getQuestion();
                //  mTextView.setText(questioninfo);
                updatenext();
                Log.e("next", "current is " + current);
            }
        });
        mIsCheater = false;
        updatenext();
        Log.e("Defualt", "Defualtcurrent is " + current);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = (current + 1) % mTruefalseinfo.length;
                //     int questioninfo =mTruefalseinfo[current].getQuestion();
                //   mTextView.setText(questioninfo);
                updatenext();

            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current - 1 == -1) {
                    current = 5;
                    Log.e("last", "-1 current is " + current);
                } else {
                    current = current - 1;
                }
                ;
                int questioninfo = mTruefalseinfo[current].getQuestion();
                mTextView.setText(questioninfo);
                Log.e("last", "Lcurrent is " + current);
            }
        });
        if (savedInstanceState != null) {
            current = savedInstanceState.getInt(key_current, 0);
        }
        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //START Activity
                Intent intent = new Intent(firstActivity.this, CheatActivity.class);
                Boolean answerIsTrue = mTruefalseinfo[current].isTruefalse();
                intent.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answerIsTrue);
                //  startActivity(intent);
                startActivityForResult(intent, 0);
            }
        });
    }


    @Override
    public void onStart() {

        super.onStart();
        Log.d(Tab, "is onstart called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Tab, "is onpause called");
    }

    @Override

    public void onResume() {

        super.onResume();
        Log.d(Tab, "is onresume called");
    }

    @Override
    public void onStop() {


        super.onStop();
        Log.d(Tab, "is onstop called");
    }

    @Override
    public void onDestroy() {


        super.onDestroy();
        Log.d(Tab, "is onDestroy called");
    }

    @Override
    public void onRestart() {


        super.onRestart();
        Log.d(Tab, "is onRestart called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(key_current, current);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent date) {
        if (date == null) {
            return;
        }
        mIsCheater = date.getBooleanExtra(CheatActivity.EXTRA_ANSWER_IS_SHOW, false);
    }
}
