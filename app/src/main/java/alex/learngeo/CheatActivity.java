package alex.learngeo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends Activity {
    public static final String EXTRA_ANSWER_IS_TRUE = "com.alex.android.first.answe.is.true";
    public static final String EXTRA_ANSWER_IS_SHOW = "com.alex.android.first.answe.is.show";
    private boolean mAswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;


    private void setAnswerShowResult(boolean isanswerShown) {
        Intent date = new Intent();
        date.putExtra(EXTRA_ANSWER_IS_SHOW, isanswerShown);
        setResult(RESULT_OK, date);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mShowAnswer = (Button) findViewById(R.id.showAnserButton);
        setAnswerShowResult(false);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAswerIsTrue) {

                    mAnswerTextView.setText(R.string.ture);
                } else {
                    mAnswerTextView.setText(R.string.flse);
                }
                setAnswerShowResult(true);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(CheatActivity.this, "this is add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.del_item:
                Toast.makeText(CheatActivity.this, "This is del", Toast.LENGTH_SHORT).show();
                break;
            default:
        }

        return true;
    }


}
