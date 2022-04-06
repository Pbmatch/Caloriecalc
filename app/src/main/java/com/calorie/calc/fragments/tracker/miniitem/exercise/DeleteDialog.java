package com.calorie.calc.fragments.tracker.miniitem.exercise;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DeleteDialog extends DialogFragment {

    public DeleteDialog( DialogInterface.OnClickListener onClickListener) {

        this.onClickListener = onClickListener;
    }

    DialogInterface.OnClickListener onClickListener;
    @NonNull
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Удалить активность Ходьба?";

        String button1String = "Отмена";
        String button2String = "Удалить";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);  // заголовок

        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setNegativeButton(button2String, onClickListener
        );
        builder.setCancelable(true);

        return builder.create();
    }

}