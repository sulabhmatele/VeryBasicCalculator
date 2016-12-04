package com.laksystems.sulabhmatele.simplecal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    private final String OPERATOR_PLUS = "plus";
    private final String OPERATOR_MINUS = "minus";
    private final String OPERATOR_MULTIPLY = "multiply";
    private final String OPERATOR_DIVISION = "division";

    Button mBtn0 = null;
    Button mBtn1 = null;
    Button mBtn2 = null;
    Button mBtn3 = null;
    Button mBtn4 = null;
    Button mBtn5 = null;
    Button mBtn6 = null;
    Button mBtn7 = null;
    Button mBtn8 = null;
    Button mBtn9 = null;
    Button mBtnClr = null;
    Button mBtnPlus = null;
    Button mBtnMinus = null;
    Button mBtnDiv = null;
    Button mBtnMul = null;
    Button mBtnEql = null;
    TextView mTxtViewEq = null;
    TextView mTxtViewResult = null;

    private String mOperator = null;
    private String mDisplayOperator = null;
    private int mFirstOperand = 0;
    private String mFirstOperandString = null;
    private Boolean mResultObtained = false;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn0 = (Button) findViewById(R.id.btn0);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn5 = (Button) findViewById(R.id.btn5);
        mBtn6 = (Button) findViewById(R.id.btn6);
        mBtn7 = (Button) findViewById(R.id.btn7);
        mBtn8 = (Button) findViewById(R.id.btn8);
        mBtn9 = (Button) findViewById(R.id.btn9);
        mBtnClr = (Button) findViewById(R.id.btnClr);
        mBtnPlus = (Button) findViewById(R.id.btnPlus);
        mBtnMinus = (Button) findViewById(R.id.btnMinus);
        mBtnDiv = (Button) findViewById(R.id.btnDiv);
        mBtnMul = (Button) findViewById(R.id.btnMul);
        mBtnEql = (Button) findViewById(R.id.btnEql);
        mTxtViewEq = (TextView) findViewById(R.id.textViewEq);
        mTxtViewResult = (TextView) findViewById(R.id.textViewResult);

        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "0");
                insertNumberToTextBox(mTxtViewEq, "0");
            }
        });

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "1");
                insertNumberToTextBox(mTxtViewEq, "1");
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "2");
                insertNumberToTextBox(mTxtViewEq, "2");
            }
        });

        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "3");
                insertNumberToTextBox(mTxtViewEq, "3");
            }
        });

        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "4");
                insertNumberToTextBox(mTxtViewEq, "4");
            }
        });

        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "5");
                insertNumberToTextBox(mTxtViewEq, "5");
            }
        });

        mBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "6");
                insertNumberToTextBox(mTxtViewEq, "6");
            }
        });

        mBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "7");
                insertNumberToTextBox(mTxtViewEq, "7");
            }
        });

        mBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "8");
                insertNumberToTextBox(mTxtViewEq, "8");
            }
        });

        mBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNumberToTextBox(mTxtViewResult, "9");
                insertNumberToTextBox(mTxtViewEq, "9");
            }
        });


        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplayOperator = " + ";
                mOperator = OPERATOR_PLUS;
                createFirstOperand();
                insertOperatorToTextView();
            }
        });

        mBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOperator = OPERATOR_MINUS;
                createFirstOperand();
                insertOperatorToTextView();
            }
        });

        mBtnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplayOperator = " x ";
                mOperator = OPERATOR_MULTIPLY;
                createFirstOperand();
                insertOperatorToTextView();
            }
        });

        mBtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDisplayOperator = " / ";
                mOperator = OPERATOR_DIVISION;
                createFirstOperand();
                insertOperatorToTextView();
            }
        });

        mBtnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((mFirstOperand != 0) && (mOperator != null)) {
                    int secondOperand = Integer.valueOf(mTxtViewResult.getText().toString());
                    int result = 0;
                    if (mOperator == OPERATOR_PLUS) {
                        result = mFirstOperand + secondOperand;
                    } else if (mOperator == OPERATOR_MINUS) {
                        result = mFirstOperand - secondOperand;

                    } else if (mOperator == OPERATOR_MULTIPLY) {
                        result = mFirstOperand * secondOperand;

                    } else if (mOperator == OPERATOR_DIVISION) {
                        result = mFirstOperand / secondOperand;
                    }
                    mTxtViewEq.setText("");
                    mTxtViewResult.setText(String.valueOf(result));
                    mResultObtained = true;
                }
            }
        });

        mBtnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtViewResult.setText(null);
                mTxtViewEq.setText(null);
                mOperator = null;
                mDisplayOperator = null;
                mFirstOperand = 0;
                mFirstOperandString = null;
                mResultObtained = false;
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void createFirstOperand()
    {
        if(mTxtViewResult.getText().toString() != "") {
            mFirstOperandString = mTxtViewResult.getText().toString();
            mFirstOperand = Integer.valueOf(mTxtViewResult.getText().toString());
            mTxtViewResult.setText("");
        }
    }

    private void insertOperatorToTextView()
    {
        mTxtViewEq.setText("");
        mTxtViewEq.setText(String.format("%s%s", mFirstOperandString, mDisplayOperator));
    }

    private void insertNumberToTextBox(TextView txtView, String str) {
        if(mResultObtained)
        {
            mTxtViewResult.setText(null);
            mTxtViewEq.setText(null);
            mOperator = null;
            mDisplayOperator = null;
            mFirstOperand = 0;
            mFirstOperandString = null;
            mResultObtained = false;
        }
        String oldStr = txtView.getText().toString();
        txtView.setText(String.format("%s%s", oldStr, str));
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
