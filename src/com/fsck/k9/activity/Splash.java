package com.fsck.k9.activity;

import android.app.Activity;
import android.os.Bundle;

import com.fsck.k9.R;
import com.fsck.k9.activity.setup.WelcomeMessage;

public class Splash extends Activity {
    @Override
    public void onBackPressed(){

    }
    final private static int TIME_FOR_SPLASH = 3500;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.splash);
        findViewById(R.id.splash).animate().alpha(1).setDuration(TIME_FOR_SPLASH).withEndAction(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (this) {
                            try {
                                wait(TIME_FOR_SPLASH);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        WelcomeMessage.showWelcomeMessage(Splash.this);
                        //startActivity(intent);
                        finish();
                    }
                }
        ).start();
    }
}
