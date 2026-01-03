package uk.playdrop.cherrytree_idletextrpg;

import android.os.Bundle;
import android.view.View$OnClickListener;
import android.view.View;
import android.content.IntentSender$SendIntentException;
import android.app.Activity;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.InstallState;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import android.content.Context;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import android.widget.ScrollView;
import android.content.Intent;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.appupdate.AppUpdateManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity
{
    TextView acceptUpdates;
    AppUpdateManager appUpdateManager;
    InstallStateUpdatedListener installStateUpdatedListener;
    TextView loadingPleaseWait;
    String log;
    Intent startGame;
    TextView updateLog;
    int updateRequestCode;
    ScrollView updatesv;
    TextView wel_version;
    
    public Welcome() {
        this.updateRequestCode = 1354;
        this.log = "Update Log\n- Since it's officially Christmas week, I want to start off this update log by saying Merry Christmas to everybody! Sending love from my family to yours wherever you may be in the world!\n- We have now entered week 5 of the Christmas Event, which means all Cracker loot has now been changed up with some past event specials available to get your hands on, including the most wanted item on this years Christmas List, the Metal Detector!\n- Inside Golden Crackers there is also a brand new hidden event special that is tradable!\n- A Huge Potion Rework has arrived! With changes to previous potions and 16 brand new potions to brew up, including Archery, Forestry, Exploration and more! Head over to the Alchemy page to find out more!\n- To align with the potion rework, Alchemy is the newest skill to be expanded to a level cap of 140!\n- The Potions Forever questline has been extended and has 11 new requests added!\n- Attack Potions now increases hit chance by a % amount, instead of give a stat boost.\n- Strength Potions now increases damage by a % amount, instead of give a stat boost.\n- Defence Potions now reduce incoming damage by a % amount, instead of give a stat boost.\n- Fishing Potions now grant a chance at extra fish instead of give more experience.\n- All Health Potions have been removed, because of this the Potion quests that request Health Potions, now request Forestry Potions instead.\n- Further increased the drop rate of Golden Crackers.\n- You can now see which of your mutual friends have sent you a daily coin.\n- The Mining outfit now works properly as it should.\n- Fixed an issue with Firemaking when burning logs the UI got all riddled.\n- Replaced the Health Potions in Base Camp with Forestry Potions.\n- The usual small bug fixes here and there.";
    }
    
    public void CheckForUpdates() {
        this.appUpdateManager = AppUpdateManagerFactory.create((Context)this);
        final Welcome$$ExternalSyntheticLambda4 installStateUpdatedListener = new Welcome$$ExternalSyntheticLambda4(this);
        this.installStateUpdatedListener = (InstallStateUpdatedListener)installStateUpdatedListener;
        this.appUpdateManager.registerListener((InstallStateUpdatedListener)installStateUpdatedListener);
        this.appUpdateManager.getAppUpdateInfo().addOnSuccessListener((OnSuccessListener)new Welcome$$ExternalSyntheticLambda5(this)).addOnFailureListener((OnFailureListener)new Welcome$$ExternalSyntheticLambda6(this));
    }
    
    void LoadGame() {
        new Handler(Looper.getMainLooper()).postDelayed((Runnable)new Welcome$$ExternalSyntheticLambda2(this), 1200L);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492894);
        this.startGame = new Intent((Context)this, (Class)MainActivity.class);
        this.wel_version = (TextView)this.findViewById(2131297333);
        this.updateLog = (TextView)this.findViewById(2131297305);
        this.acceptUpdates = (TextView)this.findViewById(2131296272);
        this.loadingPleaseWait = (TextView)this.findViewById(2131296791);
        (this.updatesv = (ScrollView)this.findViewById(2131297307)).setVisibility(8);
        this.acceptUpdates.setVisibility(8);
        this.loadingPleaseWait.setText((CharSequence)"Checking for updates...");
        this.loadingPleaseWait.setVisibility(0);
        this.wel_version.setText((CharSequence)this.getString(2131820645));
        this.updateLog.setText((CharSequence)this.log);
        this.updateLog.postDelayed((Runnable)new Welcome$$ExternalSyntheticLambda3(this), 500L);
    }
    
    protected void onDestroy() {
        final AppUpdateManager appUpdateManager = this.appUpdateManager;
        if (appUpdateManager != null) {
            final InstallStateUpdatedListener installStateUpdatedListener = this.installStateUpdatedListener;
            if (installStateUpdatedListener != null) {
                appUpdateManager.unregisterListener(installStateUpdatedListener);
            }
        }
        super.onDestroy();
    }
}
