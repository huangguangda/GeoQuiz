package cn.edu.gdmec.android.geoquiz;
//学习android应用的基本组成，activity，界面布局（layout）以及显式intent
//android用户界面设计，xml
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question ( R.string.question_oceans, true ),
            new Question ( R.string.question_mideast, false ),
            new Question ( R.string.question_africa, false ),
            new Question ( R.string.question_americas, true ),
            new Question ( R.string.question_asia, true ),
    };

    private int mCurrentIndex = 0;
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId ();
        mQuestionTextView.setText ( question );
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue ();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText ( this, messageResId, Toast.LENGTH_SHORT ).show ();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        Log.d (TAG, "onCreate(Bundle) called");
        setContentView ( R.layout.activity_quiz );


        mQuestionTextView = (TextView ) findViewById ( R.id.question_text_view );
//        int question = mQuestionBank[mCurrentIndex].getTextResId ();
//        mQuestionTextView.setText ( question );


        mTrueButton = (Button) findViewById ( R.id.true_button );
        mTrueButton.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View v){
//                Toast.makeText ( QuizActivity.this,
//                        R.string.incorrect_toast,
//                        Toast.LENGTH_SHORT).show ();
                checkAnswer ( true );

            }
        } );
        mFalseButton = (Button) findViewById ( R.id.false_button );
        mFalseButton.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View v){
//                Toast.makeText ( QuizActivity.this,
//                        R.string.correct_toast,
//                        Toast.LENGTH_SHORT).show ();
                checkAnswer ( false );
            }
        } );
        mNextButton = (Button) findViewById ( R.id.next_button );
        mNextButton.setOnClickListener ( new View.OnClickListener (){
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getTextResId ();
//                mQuestionTextView.setText ( question );
                updateQuestion();
            }
        } );
        updateQuestion();
    }

    @Override
    public void onStart(){
        super.onStart ();
        Log.d ( TAG, "onStart() called" );
    }
    @Override
    public void onPause(){
        super.onPause ();
        Log.d ( TAG, "onPause() called" );
    }
    @Override
    public void onResume(){
        super.onResume ();
        Log.d ( TAG, "onResume() called" );
    }
    @Override
    public void onStop(){
        super.onStop ();
        Log.d ( TAG, "onStop() called" );
    }
    @Override
    public void onDestroy(){
        super.onDestroy ();
        Log.d ( TAG, "onDestroy() called" );
    }

}
