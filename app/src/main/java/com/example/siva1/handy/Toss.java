package com.example.siva1.handy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Toss extends AppCompatActivity implements View.OnClickListener,Runnable {

    Button one, two, three, four, five, six, playagain,quit;
    EditText ooe, tossrun;
    String tossstr;
    Socket socket;
    PrintWriter printwriter;
    public SingleTon s;
    InputStreamReader isr;
    BufferedReader br;
    BufferedReader in;
    int serverruns;
    TextView status, needed,clientrun;
    Activity act;
    int flag;
    int run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        serverruns = 0;
        flag = 0;
        run=0;
        one = (Button) findViewById(R.id.bt_one);
        two = (Button) findViewById(R.id.bt_two);
        three = (Button) findViewById(R.id.bt_three);
        four = (Button) findViewById(R.id.bt_four);
        five = (Button) findViewById(R.id.bt_five);
        six = (Button) findViewById(R.id.bt_six);
        tossrun = (EditText) findViewById(R.id.et_tossrun);
        status = (TextView) findViewById(R.id.tv_status);
        needed = (TextView) findViewById(R.id.tv_needed);
        clientrun= (TextView) findViewById(R.id.tv_crun);
        playagain= (Button) findViewById(R.id.bt_playagain);
        quit= (Button) findViewById(R.id.bt_quit);
        playagain.setVisibility(View.INVISIBLE);
        quit.setVisibility(View.INVISIBLE);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                s.sendData("1");
                startActivity(intent);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.sendData("0");
                finish();
            }
        });
        status.setText("Server Batting");
        act = this;
        try {
            //isr= new InputStreamReader(s.socket.getInputStream());
            in = new BufferedReader(new InputStreamReader(s.socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t = new Thread(this);
        t.start();
        // br= new BufferedReader(isr); //get the client message
        //tosss= (Button) findViewById(R.id.bt_tosssnd);
        //ooe= (EditText) findViewById(R.id.et_tossdec);
        //tossrun= (EditText) findViewById(R.id.et_tossrun);
        one.setOnClickListener(Toss.this);
        two.setOnClickListener(Toss.this);
        three.setOnClickListener(Toss.this);
        four.setOnClickListener(Toss.this);
        five.setOnClickListener(Toss.this);
        six.setOnClickListener(Toss.this);

        s = SingleTon.getInstance();


    }

    @Override

    public void onClick(View v) {
/*if(flag==1){
    Thread t=new Thread(this);
    t.start();
}*/
        switch (v.getId()) {
            case R.id.bt_one:
                tossrun.setText("1");
                if (flag == 0) {
                    s.sendData("1");

                }
                if (flag == 1) {
                    s.sendData("1");

                    serverruns = serverruns - 1;
                    needed.setText("Need " + serverruns + " runs");
                    run=run+1;
                    clientrun.setText("Score "+run);

                }
                break;
            case R.id.bt_two:
                tossrun.setText("2");
                if (flag == 0) {
                    s.sendData("2");

                }
                if (flag == 1) {
                    s.sendData("2");
                    run=run+2;
                    clientrun.setText("Score " + run);
                    serverruns = serverruns - 2;
                    needed.setText("Need " + serverruns + " runs");
                }
                break;
            case R.id.bt_three:
                tossrun.setText("3");
                if (flag == 0) {
                    s.sendData("3");

                }
                if (flag == 1) {
                    s.sendData("3");
                    run=run+3;
                    clientrun.setText("Score " + run);
                    serverruns = serverruns - 3;
                    needed.setText("Need " + serverruns + " runs");
                }
                break;
            case R.id.bt_four:
                tossrun.setText("4");
                if (flag == 0) {
                    s.sendData("4");

                }
                if (flag == 1) {
                    s.sendData("4");
                    run=run+4;
                    clientrun.setText("Score " + run);
                    serverruns = serverruns - 4;
                    needed.setText("Need " + serverruns + " runs");
                }
                break;
            case R.id.bt_five:
                tossrun.setText("5");
                if (flag == 0) {
                    s.sendData("5");
                }
                if (flag == 1) {
                    s.sendData("5");
                    run=run+5;
                    clientrun.setText("Score "+run);
                    serverruns = serverruns - 5;
                    needed.setText("Need " + serverruns + " runs");
                }
                break;
            case R.id.bt_six:
                tossrun.setText("6");
                if (flag == 0) {
                    s.sendData("6");
                }
                if (flag == 1) {
                    s.sendData("6");
                    run=run+6;
                    clientrun.setText("Score "+run);
                    serverruns = serverruns - 6;
                    needed.setText("Need " + serverruns + " runs");
                }
                break;

        }
    }

    @Override
    public void run() {
        String recd = null;
        try {
            recd=in.readLine().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //while(true){
        if (flag == 0 && (recd.charAt(0)!='R')) {
            System.out.println("Getting the final score");

            serverruns = Integer.parseInt(recd);
            System.out.println(serverruns);
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    flag = 1;
                    status.setText("Server Out. Total score is " + serverruns);
                    serverruns = serverruns + 1;
                    needed.setText("Need " + serverruns + " runs");
                }
            });
            Thread t=new Thread(this);
            t.start();
        }else{
            final String finalRecd = recd;
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int size= finalRecd.length();
                    String stat= finalRecd.substring(1,size);
                    status.setText(stat);
                    needed.setText("");
                    clientrun.setText("");
                    flag=0;
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    playagain.setVisibility(View.VISIBLE);
                    quit.setVisibility(View.VISIBLE);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            });
        }
        /*if(flag==1){
            try {
                final String result=br.readLine();
                act.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      status.setText(result);
                        needed.setText("");
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}