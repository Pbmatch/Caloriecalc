package com.calorie.calc.fragments.tracker;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.MainActivity;
import com.calorie.calc.R;
import com.calorie.calc.data.NoteItem;
import com.calorie.calc.utils.BackPressable;

import java.text.SimpleDateFormat;
import java.util.Date;


public class NoteFragment extends Fragment implements BackPressable {

    TextView textViewToolbarTitle;
    TextView textViewToolbarText;
    ImageView imageviewToolbarBack;
    TextView clearNote;
    Button button;
    EditText editText;
    NoteItem item;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        item= MainActivity.getUser().getNoteItem().getValue();
        textViewToolbarText=view.findViewById(R.id.toolbarTextViewText);
        textViewToolbarTitle=  view.findViewById(R.id.toolbarTextViewTitle);
        imageviewToolbarBack=view.findViewById(R.id.toolbarImageViewBack);
        clearNote=view.findViewById(R.id.textViewText);
        button=view.findViewById(R.id.button);
        editText=view.findViewById(R.id.editText);
        textViewToolbarTitle.setText(R.string.note_title);
        SimpleDateFormat fmtOut = new SimpleDateFormat("dd.MMMM.yyyy");
        textViewToolbarText.setText( fmtOut.format(item.getDate()));
        editText.setText(item.getText());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             item.setText(editText.getText().toString());
             item.setDate(new Date());
              MainActivity.getUser().getNoteItem().setValue(item);
                getActivity().onBackPressed();
            }
        });
        clearNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        imageviewToolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE   ) {

                    button.callOnClick();
                    handled = true;
                }
                return handled;
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}