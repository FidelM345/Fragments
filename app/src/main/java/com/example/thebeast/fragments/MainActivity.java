package com.example.thebeast.fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

BlankFragment blankFragment;
FragmentTwo fragmentTwo;
Button one,two;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        blankFragment=new BlankFragment();
        fragmentTwo=new FragmentTwo();
        replaceFragment(blankFragment);//loading the home fragment in main activity


        one=findViewById(R.id.fragment_one);
        two=findViewById(R.id.fragment_two);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
    }



    private  void replaceFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.fragment_one:
                replaceFragment(blankFragment);
                break;

            case R.id.fragment_two:
                replaceFragment(fragmentTwo);
                break;

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id ==R.id.id_activity) {
            Intent intent=new Intent(this,Activity.class);
            startActivity(intent);

        }

        return true;
    }
}
