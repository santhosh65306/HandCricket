package com.example.siva1.handy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText textip;
    EditText textport;
    public static Socket socket;
    DataOutputStream dataOutputStream;
    Button one,two,three,four,five,six,playagain,quit;
    public static PrintWriter printwriter;
    public SingleTon s;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //final EditText textOut=(EditText)findViewById(R.id.et_text);
        textip = (EditText) findViewById(R.id.et_ip);
        Button setIp = (Button) findViewById(R.id.bt_setip);
        one= (Button) findViewById(R.id.bt_run1);
        two= (Button) findViewById(R.id.bt_run2);
        three= (Button) findViewById(R.id.bt_run3);
        four= (Button) findViewById(R.id.bt_run4);
        five= (Button) findViewById(R.id.bt_run5);
        six= (Button) findViewById(R.id.bt_run6);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Toss.class);

                startActivity(a);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        })
        //two.setOnClickListener(MainActivity.this);
        three.setOnClickListener(MainActivity.this);
        four.setOnClickListener(MainActivity.this);
        five.setOnClickListener(MainActivity.this);
        six.setOnClickListener(MainActivity.this);
        //Button sendText= (Button) findViewById(R.id.bt_send);
        textport = (EditText) findViewById(R.id.et_port);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip = textip.getText().toString();
                int port = Integer.parseInt(textport.getText().toString());
                try {
                    System.out.println("seti clicked");
                    //socket = new Socket(ip, port);
                    s=SingleTon.getInstance(ip,port);
                    System.out.println("socket created");
                    System.out.println("streams created");
                } catch (IOException e) {

                }

            }
        });
        /*sendText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    printwriter.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_run1:
                System.out.println("1clicked");
                try {
                    printwriter = new PrintWriter(socket.getOutputStream(), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("1wrote");
                printwriter.println("1");
                printwriter.flush();
                //printwriter.close();

                break;
            case R.id.bt_run2:
                System.out.println("2clicked");
                try {
                    printwriter = new PrintWriter(socket.getOutputStream(), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("2wrote");
                printwriter.println("2");
                printwriter.flush();
                //printwriter.close();

                break;
            case R.id.bt_run3:
                System.out.println("3clicked");
                System.out.println("3wrote");
                printwriter.println("3");
                printwriter.flush();
                //printwriter.close();

                break;
            case R.id.bt_run4:
                System.out.println("4clicked");
                try {
                    printwriter = new PrintWriter(socket.getOutputStream(),true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printwriter.println("4");
                System.out.println("4wrote");
                printwriter.flush();
                //printwriter.close();

                break;
            case R.id.bt_run5:
                System.out.println("5clicked");
                try {
                    printwriter = new PrintWriter(socket.getOutputStream(),true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printwriter.println("5");
                System.out.println("5wrote");
                printwriter.flush();
                //printwriter.close();

                break;
            case R.id.bt_run6:
                System.out.println("6clicked");
                try {
                    printwriter = new PrintWriter(socket.getOutputStream(),true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printwriter.println("6");
                System.out.println("6wrote");
                printwriter.flush();
                //printwriter.close();
                break;
            default:
                try {
                    printwriter = new PrintWriter(socket.getOutputStream(),true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printwriter.println("kabimkumam");
                printwriter.flush();
                //printwriter.close();
                break;
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.siva1.handy/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.siva1.handy/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
