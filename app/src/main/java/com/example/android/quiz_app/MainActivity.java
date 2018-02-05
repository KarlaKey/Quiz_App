package com.example.android.quiz_app;


        import android.content.Intent;

        import android.support.v7.app.AppCompatActivity;

        import android.os.Bundle;

        import android.view.View;

        import android.widget.CheckBox;

        import android.widget.EditText;

        import android.widget.RadioButton;

        import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    static int totalPoints;

    RadioButton questionOneAnswerThree;

    RadioButton questionTwoAnswerOne;

    RadioButton questionThreeAnswerTrue;

    RadioButton questionFourAnswerTrue;

    EditText questionFiveEditText;

    CheckBox questionSixAnswerOne;

    CheckBox questionSixAnswerFour;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        questionOneAnswerThree = findViewById(R.id.questionOneAnswerThree_radio);

        questionTwoAnswerOne = findViewById(R.id.questionTwoAnswerOne_radio);

        questionThreeAnswerTrue = findViewById(R.id.questionThreeAnswerTrue_radio);

        questionFourAnswerTrue = findViewById(R.id.questionFourAnswerTrue_radio);

        questionFiveEditText = findViewById(R.id.questionFive_editText);

        questionSixAnswerOne = findViewById(R.id.questionSixAnswerOne_checkbox);

        questionSixAnswerFour = findViewById(R.id.questionSixAnswerFour_checkbox);


    }

    //** * This method is called when the GET YOUR SCORE button is clicked*/

    public void submitAnswers(View v) {

        EditText nameField = findViewById(R.id.name_edit_text);

        String name = nameField.getText().toString();

        // show toast message when user press Get the score but didn't edit their name

        if (name.equalsIgnoreCase("")) {

            Toast.makeText(this, "Please write your name at the top", Toast.LENGTH_SHORT).show();

            return;
        }

        if(questionOneAnswerThree.isChecked()) {

            totalPoints += 1;

        }

        if(questionTwoAnswerOne.isChecked()) {

            totalPoints += 1;

        }

        if(questionThreeAnswerTrue.isChecked()) {

            totalPoints += 1;

        }

        if(questionFourAnswerTrue.isChecked()) {

            totalPoints += 1;

        }

        String questionFiveString = questionFiveEditText.getText().toString();

        if(questionFiveString.equals("Sweden")) {

            totalPoints += 1;

        }

        if((questionSixAnswerOne.isChecked()) && (questionSixAnswerFour.isChecked())) {

            totalPoints += 1;


        }

        //** * This method create results message*/


        String messageZero = name + getResources().getString(R.string.toast0);

        String lessPoints = name + getResources().getString(R.string.toast1);

        String messageLess = String.format(lessPoints, totalPoints);

        String mediumPoints = name + getResources().getString(R.string.toast2);

        String messageMedium = String.format(mediumPoints, totalPoints);

        String highPoints = name + getResources().getString(R.string.toast3);

        String messageHigh = String.format(highPoints, totalPoints);



        if(totalPoints == 0) {

            Toast.makeText(this, messageZero, Toast.LENGTH_LONG).show();

        } else if(totalPoints == 1 || totalPoints == 2) {

            Toast.makeText(this, messageLess, Toast.LENGTH_LONG).show();

        } else if(totalPoints == 3 || totalPoints == 4) {

            Toast.makeText(this, messageMedium, Toast.LENGTH_LONG).show();

        } else if(totalPoints == 5 || totalPoints == 6) {

            Toast.makeText(this, messageHigh, Toast.LENGTH_LONG).show();

        }


    }

    //** * This method is called when the TRY AGAIN button is clicked. */

    public void resetAnswers(View v) {

        totalPoints = 0;

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

//** * This method is called when the SHARE button is clicked. */

    public void shareResults(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,getString(R.string.shareMessageFriends) );
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.share_message)));


    }}

