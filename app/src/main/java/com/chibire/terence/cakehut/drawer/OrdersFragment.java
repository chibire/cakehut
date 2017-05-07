package com.chibire.terence.cakehut.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.chibire.terence.cakehut.MainActivity;
import com.chibire.terence.cakehut.R;

import java.util.ArrayList;
import java.util.Collections;



/**
 * Created by root on 4/14/17.
 */

public class OrdersFragment extends Fragment implements View.OnClickListener{

    String str_name, str_email, str_address, str_number, str_dod,str_item, str_add;
    EditText edt_name, edt_email, edt_address, edt_number, edt_dod, edt_add;
    Spinner edt_item;

    Button send;
    public static String[] items = new String[]{"Apple Cake", "Beef Burger", "Beef Sandwich", "Blackforest Cake", "Blue Berry Cake", "Caesar Salad", "Cheese Cake", "Cheese Sandwich", "Chicken Burger", "Chicken Salad", "Choccocino Cake", "Chocolate Cake", "Chocolate Fudge Cake", "Club Sandwich", "Coffee", "Egg Burger", "Fresh Juice", "Fruit Cake", "Fruit Salad", "Garden Salad", "Madeira Cake", "Milk Shakes", "Passion Cake","Red Velvet Cake", "Sacher Torte Cake", "Sandwich Salad", "Smoothie","Strawberry Cake", "Tea", "Tiramisu Cake", "Vanilla Cake", "Vegetable Burger", "Vegetable Sandwich", "Whiteforest Cake"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x = inflater.inflate(R.layout.fragment_order, container, false);
        ((MainActivity) getActivity()).mToolbar.setTitle("Order");

        send = (Button) x.findViewById(R.id.send);
        edt_name = (EditText) x.findViewById(R.id.txtName);
        edt_email = (EditText) x.findViewById(R.id.txtEmail);
        edt_address = (EditText) x.findViewById(R.id.address);
        edt_number = (EditText) x.findViewById(R.id.number);
        edt_dod = (EditText) x.findViewById(R.id.dod);
        edt_add = (EditText) x.findViewById(R.id.add);

        // Spinner element
        edt_item = (Spinner) x.findViewById(R.id.spinner);

        // Spinner click listener
        //edt_item.setOnItemSelectedListener(getActivity());

        loadSpinnerData();
        send.setOnClickListener(this);

        return x;
    }

    private void loadSpinnerData() {
        ///Spinner start
        ArrayList<String> item = new ArrayList<String>();
            for( int i=0; i< items.length; i++ ){
            if( items.length > 0 && !item.contains(items) ){
                item.add( items[i] );
            }
        }
            Collections.sort(item);

        //this is for custom spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, item);

        // Drop down layout style - list view with radio button for default provided by android
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //this for a custom spinner
            dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // attaching data adapter to spinner
        edt_item.setAdapter(dataAdapter);
}

    @Override
    public void onClick(View v) {
        str_name = edt_name.getText().toString();
        str_email = edt_email.getText().toString();

        if (str_name.length() == 0 & str_email.length() == 0) {
            Toast.makeText(getActivity(),
                    "Please enter your Subject and Message",
                    Toast.LENGTH_LONG).show();
        } else if (str_name.length() == 0) {
            Toast.makeText(getActivity(),
                    "Please enter your Subject", Toast.LENGTH_LONG).show();
        } else if (str_email.length() == 0) {
            Toast.makeText(getActivity(),
                    "Please enter your Message", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Order sent successful, Thanks.", Toast.LENGTH_LONG).show();
            Intent feedback = new Intent(getActivity(), MainActivity.class);
            startActivity(feedback);
        }
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            // Set title
            getActivity().getActionBar()
                    .setTitle("Order");
        }
    }
}