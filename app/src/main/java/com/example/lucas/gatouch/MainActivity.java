package com.example.lucas.gatouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button[][] btn= new Button[3][3];
    TextView winLbl,turnLbl;
    int[][] btnInt=new int[3][3];
    boolean turn=true;//Set turn to Player 1
    RadioButton Rpvp,Rpve;
    boolean modePvE=true;//Set mode to PvE
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
        winLbl=(TextView)findViewById(R.id.winLbl);
        turnLbl=(TextView)findViewById(R.id.turnLbl);
    }
    public void option(View view){
        if (Rpve.isChecked())
            modePvE=true;
        else
            modePvE=false;
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
        turn=true;
        winLbl.setText("");
        turnLbl.setText("1");
    }
    public void mark(View view){
        switch (view.getId()){
            case R.id.btn11:{
                play(0,0);
                break;
            }
            case R.id.btn21:{
                play(1,0);
                break;
            }
            case R.id.btn31:{
                play(2,0);
                break;
            }
            case R.id.btn12:{
                play(0,1);
                break;
            }
            case R.id.btn22:{
                play(1,1);
                break;
            }
            case R.id.btn32:{
                play(2,1);
                break;
            }
            case R.id.btn13:{
                play(0,2);
                break;
            }
            case R.id.btn23:{
                play(1,2);
                break;
            }
            case R.id.btn33:{
                play(2,2);
                break;
            }
        }
        if (modePvE)
            movePvE();

    }

    public void play(int x, int y) {
        btn[x][y].setEnabled(false);
        if(turn){
            btn[x][y].setText("O");
            btnInt[x][y]=1;}
        else{
            btn[x][y].setText("X");
            btnInt[x][y]=2;}
        if(checkWin()){
            if(turn)
                winLbl.setText("Gana Jugador 1");
            else
                winLbl.setText("Gana Jugador 2");
            for(int i=0;i<3;i++){
                for(int e=0;e<3;e++){
                    btn[i][e].setEnabled(false);
                }
            }
        }
        if(turn){
            turn=false;
            turnLbl.setText("2");}
        else{
            turn=true;
            turnLbl.setText("1");}

    }

    private boolean checkWin() {
        if(
          ((btnInt[0][0]==1||btnInt[0][0]==2)
                  &&
          ((btnInt[0][0]==btnInt[0][1]&&btnInt[0][1]==btnInt[0][2])||
          (btnInt[0][0]==btnInt[1][0]&&btnInt[1][0]==btnInt[2][0])||
          (btnInt[0][0]==btnInt[1][1]&&btnInt[1][1]==btnInt[2][2])))
                  ||
          ((btnInt[1][1]==1||btnInt[1][1]==2)
                  &&
          ((btnInt[1][1]==btnInt[1][0]&&btnInt[1][1]==btnInt[1][2])||
          (btnInt[1][1]==btnInt[0][1]&&btnInt[1][1]==btnInt[2][1])||
          (btnInt[1][1]==btnInt[0][2]&&btnInt[1][1]==btnInt[2][0])))
                  ||
          ((btnInt[2][2]==1||btnInt[2][2]==2)
                  &&
          ((btnInt[2][2]==btnInt[2][1]&&btnInt[2][1]==btnInt[2][0])||
          (btnInt[2][2]==btnInt[0][2]&&btnInt[0][2]==btnInt[1][2]))))
            return true;
        return false;
    }

    public void movePvE(){

    }
}
