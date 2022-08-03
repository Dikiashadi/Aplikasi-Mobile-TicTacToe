package com.diki.projectakhir1901010198;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class CreativeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView player1skor, player2skor, status;
    private Button [] buttons = new Button[9];
    private Button reset;

    private int player1scorecount, player2scorecount, rountcount;
    boolean activeplayer;

    //p1 => 0
    //p2 => 1
    //empty => 2
    int [] gamestate = {2,2,2,2,2,2,2,2,2};

    int [][] menang = {
            {0,1,2}, {3,4,5}, {6,7,8}, //baris
            {0,3,6}, {1,4,7}, {2,5,8}, //kolom
            {0,4,8}, {2,4,6}, {2,5,8} //silang
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creative);

        player1skor = (TextView) findViewById(R.id.player1skor);
        player2skor = (TextView) findViewById(R.id.player2skor);
        status = (TextView) findViewById(R.id.status);
        reset = (Button) findViewById(R.id.reset);

        for(int i=0; i <buttons.length; i++) {
            String buttonID = "btn_" +i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
        }
        rountcount = 0;
        player1scorecount =0;
        player2scorecount =0;
        activeplayer = true;

    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        String buttonID = v.getResources().getResourceEntryName(v.getId()); //btn_2
        int gamestatepointer = Integer.parseInt(buttonID.substring(buttonID.length()-1, buttonID.length()));

        if(activeplayer) {
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.parseColor("#FFC34A"));
            gamestate[gamestatepointer] = 0;
        }else {
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.parseColor("#70FFEA"));
            gamestate[gamestatepointer] = 1;

        }
        rountcount++;

        if(checkwinner()){
            if(activeplayer) {
                player1scorecount++;
                updateplayerscore();
                Toast.makeText(this, "Player 1 Menang!", Toast.LENGTH_SHORT).show();
            }else {
                player2scorecount++;
                updateplayerscore();
                Toast.makeText(this, "Player 2 Menang!", Toast.LENGTH_SHORT).show();
            }
            mainlagi();

        }else if(rountcount ==9){
            mainlagi();
            Toast.makeText(this, "IMBANG!", Toast.LENGTH_SHORT).show();

        }else {
            activeplayer = !activeplayer;
        }

        if(player1scorecount > player2scorecount){
            status.setText("PLayer 1 Menang!");
        }else if(player2scorecount > player1scorecount) {
            status.setText("PLayer 2 Menang!");
        }else{
            status.setText("");

        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainlagi();
                player1scorecount = 0;
                player2scorecount =0;
                status.setText("");
                updateplayerscore();
            }
        });

    }
    public boolean checkwinner(){
        boolean winnerresult = false;

        for(int [] win : menang){
            if(gamestate[win[0]] == gamestate[win[1]] &&
                    gamestate[win[1]] == gamestate[win[2]] &&
                        gamestate[win[0]] !=2){
                winnerresult = true;
            }
        }
        return winnerresult;
    }

    public void updateplayerscore(){
        player1skor.setText(Integer.toString(player1scorecount));
        player2skor.setText(Integer.toString(player2scorecount));
    }

    public  void mainlagi(){
        rountcount = 0;
        activeplayer = true;

        for(int i = 0; i < buttons.length; i++){
            gamestate[i] = 2;
            buttons[i].setText("");
        }
    }
}