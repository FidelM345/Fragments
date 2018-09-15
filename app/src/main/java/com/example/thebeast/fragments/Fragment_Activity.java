package com.example.thebeast.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Activity.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Activity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Activity extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    EditText editText;
    Button button,btn_frag;



    private String mParam1;

    FragmentTwo fragmentTwo;


    private OnFragmentInteractionListener mListener;

    public Fragment_Activity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of fragment Fragment_Activity.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Activity newInstance(String param1) {
        Fragment_Activity fragment = new Fragment_Activity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_activity, container, false);

        editText=view.findViewById(R.id.frag_text);
        button =view.findViewById(R.id.frag_btn);
        btn_frag =view.findViewById(R.id.frag_next);
        editText.setText(mParam1);
        editText.requestFocus();//the edit text will be automatically focused when we open our fragment


        fragmentTwo=new FragmentTwo();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sendToMain=editText.getText().toString();

                sendBack(sendToMain);




            }
        });


        btn_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragment(fragmentTwo);


            }
        });

        return view;
    }




    private  void replaceFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();//getActivity method must be called first becoz its a fragment and not an activity
        fragmentTransaction.replace(R.id.main_container,fragment,"BLANK_FRAGMENT");
        fragmentTransaction.addToBackStack(null);//ensures only fragment closes when back button is pressed
        fragmentTransaction.commit();

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void sendBack(String sendToMain) {
        if (mListener != null) {
            //if the main activity is not null then do the following
            mListener.onFragmentInteraction(sendToMain);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String sendToMain);//the method will be implemented on the main activity
    }
}
