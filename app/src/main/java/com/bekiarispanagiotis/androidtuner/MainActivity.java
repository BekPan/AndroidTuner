package com.bekiarispanagiotis.androidtuner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<String[]> permissionResultLauncher;
    private boolean isMicrophonePermissionGranted = false;
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
}