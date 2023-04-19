package com.bekiarispanagiotis.androidtuner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class InfoDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Information")
                .setMessage("Bekiaris Panagiotis Android Tuner. \nUsing TarsosDSP library." +
                        "\nThis project was part of my thesis at former Computer Science & Engineering T.E.I. of Larisa." +
                        "\nDigital Systems University of Thessaly \nAll Rights Reserved")
                .setPositiveButton("ok", (dialogInterface, i) -> {

                });
        return builder.create();
    }
}
