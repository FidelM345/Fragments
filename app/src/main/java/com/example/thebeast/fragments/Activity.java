package com.example.thebeast.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity extends AppCompatActivity implements Fragment_Activity.OnFragmentInteractionListener {
    Button click;
    EditText editText;
    Fragment_Activity fragment_activity;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);


        click=findViewById(R.id.id_click);
        editText=findViewById(R.id.id_text);



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text=editText.getText().toString();

                fragment_activity=Fragment_Activity.newInstance(text);//sends text from the main activity to the fragment

                replaceFragment(fragment_activity);//calls the fragment to be displayed when button is clicked
            }
        });


    }




    private  void replaceFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment,"BLANK_FRAGMENT");
        fragmentTransaction.addToBackStack(null);//ensures only fragment closes when back button is pressed
        fragmentTransaction.commit();

}

    @Override
    public void onFragmentInteraction(String senToMain) {

        editText.setText(senToMain);
        onBackPressed();//so that our fragment becomes automatically closed
    }
}
