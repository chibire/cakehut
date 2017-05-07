package com.chibire.terence.cakehut.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chibire.terence.cakehut.MainActivity;
import com.chibire.terence.cakehut.R;

/**
 * Created by root on 4/14/17.
 */

public class FeedbackFragment extends Fragment implements View.OnClickListener{

    String str_subject, str_content;
    EditText edt_subject, edt_content;

    Button feedback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x = inflater.inflate(R.layout.fragment_feedback, container, false);
        ((MainActivity) getActivity()).mToolbar.setTitle("Feedback");

        feedback = (Button) x.findViewById(R.id.feedback);
        edt_subject = (EditText) x.findViewById(R.id.subject);
        edt_content = (EditText) x.findViewById(R.id.content);

        feedback.setOnClickListener(this);

        return x;
    }

    @Override
    public void onClick(View v) {
        str_subject = edt_subject.getText().toString();
        str_content = edt_content.getText().toString();

        if (str_subject.length() == 0 & str_content.length() == 0) {
            Toast.makeText(getActivity(),
                    "Please enter your Subject and Message",
                    Toast.LENGTH_LONG).show();
        } else if (str_subject.length() == 0) {
            Toast.makeText(getActivity(),
                    "Please enter your Subject", Toast.LENGTH_LONG).show();
        } else if (str_content.length() == 0) {
            Toast.makeText(getActivity(),
                    "Please enter your Message", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Feedback sent successful, Thanks.", Toast.LENGTH_LONG).show();
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
                    .setTitle("Feedback");
        }
    }
}