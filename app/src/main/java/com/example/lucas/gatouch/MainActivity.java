package com.example.lucas.gatouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button[][] btn= new Button[3][3];
    int[][] btnInt=new int[3][3];
    boolean turn=true;//Set turn to Player 1
    RadioButton Rpvp,Rpve;
    Boolean mode=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn[0][0]=(Button)findViewById(R.id.btn11);
        btn[1][1]=(Button)findViewById(R.id.btn21);
        btn[2][2]=(Button)findViewById(R.id.btn31);
        btn[0][0]=(Button)findViewById(R.id.btn12);
        btn[1][1]=(Button)findViewById(R.id.btn22);
        btn[2][2]=(Button)findViewById(R.id.btn32);
        btn[0][0]=(Button)findViewById(R.id.btn13);
        btn[1][1]=(Button)findViewById(R.id.btn23);
        btn[2][2]=(Button)findViewById(R.id.btn33);
        Rpve=(RadioButton)findViewById(R.id.pve);
        Rpvp=(RadioButton)findViewById(R.id.pvp);
    }
    public void option(View view){
        if (Rpvp.isChecked())
            mode=true;
        else
            mode=false;
        reset();
    }
    public void reset(){
        for(int i=0;i<3;i++){
            for(int e=0;e<3;e++){
                btn[i][e].setText(" ");
                btn[i][e].setEnabled(true);
                btnInt[i][e]=0;
            }
        }
    }
    public void mark(View view){
        switch (view.getId()){
            case R.id.btn11:{
                play(1,1);
                break;
            }
            case R.id.btn21:{
                play(2,1);
                break;
            }
            case R.id.btn31:{
                play(3,1);
                break;
            }
            case R.id.btn12:{
                play(1,2);
                break;
            }
            case R.id.btn22:{
                play(2,2);
                break;
            }
            case R.id.btn32:{
                play(3,2);
                break;
            }
            case R.id.btn13:{
                play(1,3);
                break;
            }
            case R.id.btn23:{
                play(2,3);
                break;
            }
            case R.id.btn33:{
                play(3,3);
                break;
            }
        }

    }

    public void play(int x, int y) {

    }

}
