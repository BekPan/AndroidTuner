package com.bekiarispanagiotis.androidtuner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<String[]> permissionResultLauncher;
    private boolean isMicrophonePermissionGranted = false;
    private boolean isBackPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
            if (result.get(Manifest.permission.RECORD_AUDIO) != null) {
                isMicrophonePermissionGranted = Boolean.TRUE.equals(result.get(Manifest.permission.RECORD_AUDIO));
            }
        });
        requestMicrophonePermission();

        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050,1024,0);

        @SuppressLint("SetTextI18n") PitchDetectionHandler pdh = (result, e) -> {
            final float pitchInHz = result.getPitch();
            runOnUiThread(() -> {
                TextView pitch = findViewById(R.id.pitchText);
                TextView note = findViewById(R.id.noteText);
                pitch.setText("" + pitchInHz);
                if(pitchInHz >= 65.41 && pitchInHz < 69.3) {
                    //C2
                    note.setText("C2");
                }
                else if(pitchInHz >= 69.3 && pitchInHz < 73.42) {
                    //C2#
                    note.setText("C2#");
                }
                else if(pitchInHz >= 73.42 && pitchInHz < 77.78) {
                    //D2
                    note.setText("D2");
                }
                else if(pitchInHz >= 77.78 && pitchInHz < 82.41) {
                    //D2#
                    note.setText("D2#");
                }
                else if(pitchInHz >= 82.41 && pitchInHz < 87.31) {
                    //E2
                    note.setText("E2");
                }
                else if(pitchInHz >= 87.31 && pitchInHz < 92.5) {
                    //F2
                    note.setText("F2");
                }
                else if(pitchInHz >= 92.5 && pitchInHz < 98) {
                    //F2#
                    note.setText("F2#");
                }
                else if(pitchInHz >= 98 && pitchInHz < 103.83) {
                    //G2
                    note.setText("G2");
                }
                else if(pitchInHz >= 103.83 && pitchInHz < 110) {
                    //G2#
                    note.setText("G2#");
                }
                else if(pitchInHz >= 110 && pitchInHz < 116.54) {
                    //A2
                    note.setText("A2");
                }
                else if(pitchInHz >= 116.54 && pitchInHz < 123.47) {
                    //A2#
                    note.setText("A2#");
                }
                else if(pitchInHz >= 123.47 && pitchInHz < 130.81) {
                    //B2
                    note.setText("B2");
                }
                else if(pitchInHz >= 130.81 && pitchInHz < 138.59) {
                    //C3
                    note.setText("C3");
                }
                else if(pitchInHz >= 138.59 && pitchInHz < 146.83) {
                    //C3#
                    note.setText("C3#");
                }
                else if(pitchInHz >= 146.83 && pitchInHz < 155.56) {
                    //D3
                    note.setText("D3");
                }
                else if(pitchInHz >= 155.56 && pitchInHz < 164.81) {
                    //D3#
                    note.setText("D3#");
                }
                else if(pitchInHz >= 164.81 && pitchInHz < 174.61) {
                    //E3
                    note.setText("E3");
                }
                else if(pitchInHz >= 174.61 && pitchInHz < 185) {
                    //F3
                    note.setText("F3");
                }
                else if(pitchInHz >= 185 && pitchInHz < 196) {
                    //F3#
                    note.setText("F3#");
                }
                else if(pitchInHz >= 196 && pitchInHz < 207.65) {
                    //G3
                    note.setText("G3");
                }
                else if(pitchInHz >= 207.65 && pitchInHz < 220) {
                    //G3#
                    note.setText("G3#");
                }
                else if(pitchInHz >= 220 && pitchInHz < 233.08) {
                    //A3
                    note.setText("A3");
                }
                else if(pitchInHz >= 233.08 && pitchInHz < 246.94) {
                    //A3#
                    note.setText("A3#");
                }
                else if(pitchInHz >= 246.94 && pitchInHz < 261.63) {
                    //B3
                    note.setText("B3");
                }
                else if(pitchInHz >= 261.63 && pitchInHz < 277.18) {
                    //C4
                    note.setText("C4");
                }
                else if(pitchInHz >= 277.18 && pitchInHz < 293.66) {
                    //C4#
                    note.setText("C4#");
                }
                else if(pitchInHz >= 293.66 && pitchInHz < 311.13) {
                    //D4
                    note.setText("D4");
                }
                else if(pitchInHz >= 311.13 && pitchInHz < 329.63) {
                    //D4#
                    note.setText("D4#");
                }
                else if(pitchInHz >= 329.63 && pitchInHz < 349.23) {
                    //E4
                    note.setText("E4");
                }
                else if(pitchInHz >= 349.23 && pitchInHz < 369.99) {
                    //F4
                    note.setText("F4");
                }
                else if(pitchInHz >= 369.99 && pitchInHz < 392) {
                    //F4#
                    note.setText("F4#");
                }
                else if(pitchInHz >= 392 && pitchInHz < 415.3) {
                    //G4
                    note.setText("G4");
                }
                else if(pitchInHz >= 415.3 && pitchInHz < 440) {
                    //G4#
                    note.setText("G4#");
                }
                else if(pitchInHz >= 440 && pitchInHz < 466.16) {
                    //A4
                    note.setText("A4");
                }
                else if(pitchInHz >= 466.16 && pitchInHz < 493.88) {
                    //A4#
                    note.setText("A4#");
                }
                else if(pitchInHz >= 493.88 && pitchInHz < 523.25) {
                    //B4
                    note.setText("B4");
                }
                else if(pitchInHz >= 523.25 && pitchInHz < 554.37) {
                    //C5
                    note.setText("C5");
                }
                else if(pitchInHz >= 554.37 && pitchInHz < 587.33) {
                    //C5#
                    note.setText("C5#");
                }
                else if(pitchInHz >= 587.33 && pitchInHz < 622.25) {
                    //D5
                    note.setText("D5");
                }
                else if(pitchInHz >= 622.25 && pitchInHz < 659.25) {
                    //D5#
                    note.setText("D5#");
                }
                else if(pitchInHz >= 659.25 && pitchInHz < 698.46) {
                    //E5
                    note.setText("E5");
                }
                else if(pitchInHz >= 698.46 && pitchInHz < 739.99) {
                    //F5
                    note.setText("F5");
                }
                else if(pitchInHz >= 739.99 && pitchInHz < 783.99) {
                    //F5#
                    note.setText("F5#");
                }
                else if(pitchInHz >= 783.99 && pitchInHz < 830.61) {
                    //G5
                    note.setText("G5");
                }
                else if(pitchInHz >= 830.61 && pitchInHz < 880) {
                    //G5#
                    note.setText("G5#");
                }
                else if(pitchInHz >= 880 && pitchInHz < 932.33) {
                    //A5
                    note.setText("A5");
                }
                else if(pitchInHz >= 932.33 && pitchInHz < 987.77) {
                    //A5#
                    note.setText("A5#");
                }
                else if(pitchInHz >= 987.77 && pitchInHz < 1046.5) {
                    //B5
                    note.setText("B5");
                }
                else if(pitchInHz >= 1046.5 && pitchInHz < 1108.73) {
                    //C6
                    note.setText("C6");
                }
            });
        };
        AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(p);
        new Thread(dispatcher,"Audio Dispatcher").start();
    }

    private void requestMicrophonePermission () {

        isMicrophonePermissionGranted = ContextCompat.checkSelfPermission(
                this, Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED;

        List<String> permissionRequest = new ArrayList<>();
        if (!isMicrophonePermissionGranted) {
            permissionRequest.add(Manifest.permission.RECORD_AUDIO);
        }

        if (!permissionRequest.isEmpty()){
            permissionResultLauncher.launch(permissionRequest.toArray(new String[0]));
        }
    }

    public void onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed();
            return;
        }
        Toast.makeText(this,"Tap again to exit", Toast.LENGTH_SHORT).show();
        isBackPressedOnce = true;

        new Handler().postDelayed(() -> isBackPressedOnce = false, 2000);
    }
}