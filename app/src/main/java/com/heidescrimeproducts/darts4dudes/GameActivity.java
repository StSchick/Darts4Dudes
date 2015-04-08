package com.heidescrimeproducts.darts4dudes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class GameActivity extends ActionBarActivity {


    ListView lvPlayer1;
    ListView lvPlayer2;
    ShotAdapter<String> shotAdapter1;
    ShotAdapter<String> shotAdapter2;
    ArrayList<String> shots1;
    ArrayList<String> shots2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initialize views
        initText();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initText() {


        //Initialize List for each player
        lvPlayer1 = (ListView) findViewById(R.id.listView_player1);
        lvPlayer2 = (ListView) findViewById(R.id.listView_player2);

        shots1 = new ArrayList<>();
        shots2 = new ArrayList<>();

        this.shotAdapter1 = new ShotAdapter<String>(this, shots1);
        this.shotAdapter2 = new ShotAdapter<String>(this, shots2);

        this.lvPlayer1.setAdapter(shotAdapter1);
        this.lvPlayer2.setAdapter(shotAdapter2);


        //Toggle first Radiobutton to avoid "no radio button active"
        RadioButton rbSingle = (RadioButton) findViewById(R.id.radioButton_virtual_keyboard_single);
        rbSingle.toggle();

        //Get reference to keyboard textviews
        final TextView[] tv = new TextView[21];
        tv[0] = (TextView) findViewById(R.id.textView_virtual_keyboard_0);
        tv[1] = (TextView) findViewById(R.id.textView_virtual_keyboard_1);
        tv[2] = (TextView) findViewById(R.id.textView_virtual_keyboard_2);
        tv[3] = (TextView) findViewById(R.id.textView_virtual_keyboard_3);
        tv[4] = (TextView) findViewById(R.id.textView_virtual_keyboard_4);
        tv[5] = (TextView) findViewById(R.id.textView_virtual_keyboard_5);
        tv[6] = (TextView) findViewById(R.id.textView_virtual_keyboard_6);
        tv[7] = (TextView) findViewById(R.id.textView_virtual_keyboard_7);
        tv[8] = (TextView) findViewById(R.id.textView_virtual_keyboard_8);
        tv[9] = (TextView) findViewById(R.id.textView_virtual_keyboard_9);
        tv[10] = (TextView) findViewById(R.id.textView_virtual_keyboard_10);
        tv[11] = (TextView) findViewById(R.id.textView_virtual_keyboard_11);
        tv[12] = (TextView) findViewById(R.id.textView_virtual_keyboard_12);
        tv[13] = (TextView) findViewById(R.id.textView_virtual_keyboard_13);
        tv[14] = (TextView) findViewById(R.id.textView_virtual_keyboard_14);
        tv[15] = (TextView) findViewById(R.id.textView_virtual_keyboard_15);
        tv[16] = (TextView) findViewById(R.id.textView_virtual_keyboard_16);
        tv[17] = (TextView) findViewById(R.id.textView_virtual_keyboard_17);
        tv[18] = (TextView) findViewById(R.id.textView_virtual_keyboard_18);
        tv[19] = (TextView) findViewById(R.id.textView_virtual_keyboard_19);
        tv[20] = (TextView) findViewById(R.id.textView_virtual_keyboard_20);

        //Get reference to edittext
        final EditText editText = (EditText) findViewById(R.id.editText_virtual_keyboard);

        //Define onclick-methods for each "button"
        for (int i = 0; i < tv.length; i++) {
            tv[i].setOnClickListener(new MyOnClickListener(i) {
                @Override
                public void onClick(View v) {
                    Log.i("MYLOGGER", "Pressed Button[" + i + "]");
                    //Get radiobutton reference
                    RadioButton rbSingle = (RadioButton) findViewById(R.id.radioButton_virtual_keyboard_single);
                    RadioButton rbDouble = (RadioButton) findViewById(R.id.radioButton_virtual_keyboard_double);
                    RadioButton rbTriple = (RadioButton) findViewById(R.id.radioButton_virtual_keyboard_triple);

                    //Use stringbuilder to build new string and append old text
                    StringBuilder stringBuilder = new StringBuilder();
                    String oldtext = editText.getText().toString();
                    stringBuilder.append(oldtext);


                    if (rbSingle.isChecked()) {
                        stringBuilder.append("S");
                    }
                    if (rbDouble.isChecked()) {
                        stringBuilder.append("D");
                    }
                    if (rbTriple.isChecked()) {
                        stringBuilder.append("T");
                    }
                    stringBuilder.append(i);

                    //Check if there are already 2 "," in the string
                    String tempString = stringBuilder.toString();

                    //Count ","
                    int count = 0;
                    while(tempString.contains(",")) {
                        tempString = tempString.replaceFirst(",", "");
                        count++;
                    }

                    //If there are already 2 throws -> do not append a "," after the third one
                    if(count < 2) {
                        stringBuilder.append(",");
                    }

                    //Build and set string
                    String newString = stringBuilder.toString();
                    editText.setText(newString);
                }
            });
        }
    }

    public void addShot(View view){
        final EditText editText = (EditText) findViewById(R.id.editText_virtual_keyboard);
        String shot = editText.getText().toString();
        Log.i("MYLOGGER", shot);

        shots1.add(shot);
        shotAdapter1.notifyDataSetChanged();
    }
}
