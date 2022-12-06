package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int actply = 1;
    int [] gamestate = {3, 3, 3, 3, 3, 3, 3, 3, 3};

    int [][] winstate = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},
                        {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
                        {1, 5, 9}, {3, 5, 7}};
    boolean activegame = true;
    public void gameemp(View view)
    {
        activegame = true;
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i] = 3;
        }

        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);

        TextView txt = findViewById(R.id.statusview);
        txt.setText(R.string.ply1);
    }

    public void ptap(View view) {
        ImageView img = (ImageView) view;
        int tag1 = Integer.parseInt(img.getTag().toString());
        TextView  txt = findViewById(R.id.statusview);
        if(!activegame)
        {
            gameemp(view);
            return;
        }
        if(gamestate[tag1-1] == 3 && activegame)
        {
            img.setTranslationY(-1000f);
            gamestate[tag1-1] = actply;
            if(actply == 1)
            {
                img.setImageResource(R.drawable.o);
                actply = 2;
                txt.setText(getString(R.string.ply2));
            }
            else
            {
                img.setImageResource(R.drawable.x);
                actply = 1;
                txt.setText(getString(R.string.ply1));
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] win: winstate ){
            if((gamestate[win[0]-1] == gamestate[win[1]-1]) && (gamestate[win[1]-1] == gamestate[win[2]-1]) && (gamestate[win[2]-1] != 3))
            {
                if(gamestate[win[0]-1] == 1)
                {
                    txt.setText(getString(R.string.win1));
                }
                else
                {
                    txt.setText(getString(R.string.win2));
                }
                activegame = false;
                return;
            }
        }
        boolean ab = true;
        for(int i=0;i<gamestate.length;i++)
        {
            if(gamestate[i]==3)
            {
                ab = false;
                break;
            }
        }
        if(ab)
        {
            String s4 = "Match Draw";
            txt.setText(s4);
            activegame = false;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}