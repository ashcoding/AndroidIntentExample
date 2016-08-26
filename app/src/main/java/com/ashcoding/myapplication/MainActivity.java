package com.ashcoding.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();

                // todo: Please replace this testing!!!
                // Set the package name aka Application ID of the Titanium App.
                String packageName = "sg.appcelerator";

                // todo: Please replace this for testing!!!
                // Set the Activity name. This is usually packageName + Application name + "Activity"
                // You can also find this in the generated manifest when an Android app is created.
                String activityName = packageName + "." + "Titaniumsdk6v8Activity";

                sendIntent.setClassName(packageName, activityName);
                sendIntent.addFlags((Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send. Please Receive It!");
                sendIntent.setType("text/plain");

                // Verify it resolves
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(sendIntent, 0);
                boolean isIntentSafe = activities.size() > 0;
                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(sendIntent);
                }
            }
        });
    }
}
