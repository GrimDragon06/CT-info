package uk.playdrop.cherrytree_idletextrpg;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.AggregateSource;
import com.google.firebase.firestore.AggregateQuerySnapshot;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.firebase.database.DataSnapshot;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Iterator;
import android.widget.RelativeLayout;
import java.util.Objects;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Query$Direction;
import android.widget.LinearLayout;
import android.view.View$OnClickListener;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import android.widget.EditText;
import java.util.Map;
import com.google.firebase.database.DatabaseReference;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.HashMap;
import java.util.Random;

public class DevTools
{
    MainActivity activity;
    
    public DevTools(final MainActivity activity) {
        this.activity = activity;
    }
    
    private String GenerateId() {
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".length())));
        }
        return sb.toString();
    }
    
    private String GetRotation() {
        final String currentGodsRotation = this.activity.databaseManager.currentGodsRotation;
        currentGodsRotation.hashCode();
        final int hashCode = currentGodsRotation.hashCode();
        String s = "Amaran,Opulina";
        int n = -1;
        switch (hashCode) {
            case 1476328258: {
                if (!currentGodsRotation.equals((Object)"Amaran,Opulina")) {
                    break;
                }
                n = 2;
                break;
            }
            case 1091902416: {
                if (!currentGodsRotation.equals((Object)"Cognium,Kynosian")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1296357280: {
                if (!currentGodsRotation.equals((Object)"Aurial,Noctyra")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            case 2: {
                s = "Aurial,Noctyra";
                break;
            }
            case 1: {
                s = "Copina,Feroxi";
                break;
            }
            case 0: {
                s = "Cognium,Kynosian";
                break;
            }
        }
        return s;
    }
    
    private boolean RequestedItemAllowed(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 658894417: {
                if (!s.equals((Object)"Gold Coin")) {
                    break;
                }
                n = 3;
                break;
            }
            case 444298052: {
                if (!s.equals((Object)"Killcoins")) {
                    break;
                }
                n = 2;
                break;
            }
            case 71018769: {
                if (!s.equals((Object)"Soul Gems")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1144442577: {
                if (!s.equals((Object)"Silver Coins")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return this.activity.allItems.contains((Object)s);
            }
            case 0:
            case 1:
            case 2:
            case 3: {
                return true;
            }
        }
    }
    
    private boolean RewardItemAllowed(final String s) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 658894417: {
                if (!s.equals((Object)"Gold Coin")) {
                    break;
                }
                n = 2;
                break;
            }
            case 71018769: {
                if (!s.equals((Object)"Soul Gems")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1326946875: {
                if (!s.equals((Object)"Challenge Coins")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                return this.activity.allItems.contains((Object)s);
            }
            case 0:
            case 1:
            case 2: {
                return true;
            }
        }
    }
    
    private void SendIt(final String s, final String s2) {
        final HashMap value = new HashMap();
        ((Map)value).put((Object)"title", (Object)s);
        ((Map)value).put((Object)"message", (Object)s2);
        final DatabaseReference push = this.activity.databaseManager.firebaseDatabase.getReference("adminmessages").push();
        push.setValue((Object)value);
        push.get().addOnSuccessListener((OnSuccessListener)new DevTools$$ExternalSyntheticLambda11(this)).addOnFailureListener((OnFailureListener)new DevTools$$ExternalSyntheticLambda22(this));
    }
    
    private void SetCommunityVault(final String s, final String s2, final String s3, final String s4) {
        final String generateId = this.GenerateId();
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"id", (Object)generateId);
        final Boolean value = false;
        ((Map)hashMap).put((Object)"available", (Object)value);
        ((Map)hashMap).put((Object)"complete", (Object)value);
        ((Map)hashMap).put((Object)"requiredAmount", (Object)Long.parseLong(s2));
        ((Map)hashMap).put((Object)"rewardAmount", (Object)Long.parseLong(s4));
        ((Map)hashMap).put((Object)"requiredItem", (Object)s);
        ((Map)hashMap).put((Object)"reward", (Object)s3);
        ((Map)hashMap).put((Object)"totalDonations", (Object)0);
        this.activity.databaseManager.db.collection("donations").document("ei3Ld9yTI90JxKV3PArE").update((Map)hashMap).addOnSuccessListener((OnSuccessListener)new DevTools$$ExternalSyntheticLambda20(this)).addOnFailureListener((OnFailureListener)new DevTools$$ExternalSyntheticLambda21(this));
    }
    
    private void SetGods(final String s) {
        this.activity.databaseManager.db.collection("weeklygods").document("RBMWjsMuSWs0FWGDmMY1").update("gods", (Object)s, new Object[0]).addOnSuccessListener((OnSuccessListener)new DevTools$$ExternalSyntheticLambda27(this)).addOnFailureListener((OnFailureListener)new DevTools$$ExternalSyntheticLambda28(this));
    }
    
    public void BanUser() {
        this.activity.LoadItemSelect("Ban a User");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Player Name");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131099658);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Ban User");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView, activity2.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda50(this, editText));
    }
    
    public void CheckData() {
        this.activity.LoadItemSelect("Check Data");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Username");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131099658);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Check User Data");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView, activity2.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, -2);
        layoutParams3.topMargin = this.activity.GetResource(2131099658);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        linearLayout.setOrientation(1);
        this.activity.itemSelect_wrap.addView((View)linearLayout);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda14(this, editText, linearLayout));
    }
    
    public void CheckFriendCoins() {
        this.activity.LoadItemSelect("Check Friend Coins");
        this.activity.itemSelect_wrap.removeAllViews();
        this.activity.databaseManager.db.collection("userinfo").orderBy("friendCoins", Query$Direction.DESCENDING).limit(10L).get().addOnSuccessListener((OnSuccessListener)new OnSuccessListener<QuerySnapshot>(this) {
            final DevTools this$0;
            
            public void onSuccess(final QuerySnapshot querySnapshot) {
                final Iterator iterator = querySnapshot.iterator();
                while (iterator.hasNext()) {
                    this.this$0.activity.runOnUiThread((Runnable)new DevTools$6$$ExternalSyntheticLambda0(this, (QueryDocumentSnapshot)iterator.next()));
                }
            }
        });
    }
    
    public void CheckReferrals() {
        this.activity.LoadItemSelect("Check Referrals");
        this.activity.itemSelect_wrap.removeAllViews();
        this.activity.databaseManager.db.collection("userinfo").orderBy("referralPoints", Query$Direction.DESCENDING).limit(10L).get().addOnSuccessListener((OnSuccessListener)new OnSuccessListener<QuerySnapshot>(this) {
            final DevTools this$0;
            
            public void onSuccess(final QuerySnapshot querySnapshot) {
                final Iterator iterator = querySnapshot.iterator();
                while (iterator.hasNext()) {
                    this.this$0.activity.runOnUiThread((Runnable)new DevTools$5$$ExternalSyntheticLambda0(this, (QueryDocumentSnapshot)iterator.next()));
                }
            }
        });
    }
    
    public void ClearTrades() {
        this.activity.LoadItemSelect("Clear Up Trades");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099658);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131099658);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Clear Trades");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView, activity2.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda48(this, editText));
    }
    
    public void CreateOfferCode() {
        this.activity.LoadItemSelect("Create offer code");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Code Name");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131100202);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Reward");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final EditText editText3 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131100202);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        editText3.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        editText3.setBackground(this.activity.GetImage(2131165476));
        editText3.setText((CharSequence)"");
        editText3.setHint((CharSequence)"Amount");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize((TextView)editText3, activity3.GetResource(2131099658));
        editText3.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText3);
        final EditText editText4 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams4 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams4.topMargin = this.activity.GetResource(2131100202);
        layoutParams4.leftMargin = this.activity.GetResource(2131099769);
        layoutParams4.rightMargin = this.activity.GetResource(2131099769);
        editText4.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        editText4.setBackground(this.activity.GetImage(2131165476));
        editText4.setText((CharSequence)"");
        editText4.setHint((CharSequence)"One Time Use");
        final MainActivity activity4 = this.activity;
        activity4.SetTextSize((TextView)editText4, activity4.GetResource(2131099658));
        editText4.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText4);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams5 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams5.topMargin = this.activity.GetResource(2131099658);
        layoutParams5.leftMargin = this.activity.GetResource(2131099769);
        layoutParams5.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams5);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Create Code");
        final MainActivity activity5 = this.activity;
        activity5.SetTextSize(textView, activity5.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda51(this, editText, editText2, editText3, editText4));
    }
    
    public void CreatePremiumCode() {
        this.activity.LoadItemSelect("Create a Premium Code");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Enter offer code");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131099658);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Create Premium Code");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView, activity2.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda3(this, editText));
    }
    
    public void GetTopDonors() {
        this.activity.LoadItemSelect("Top Donors");
        this.activity.itemSelect_wrap.removeAllViews();
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute((Runnable)new DevTools$$ExternalSyntheticLambda52(this));
        singleThreadExecutor.shutdown();
    }
    
    public void GiveReferrals() {
        this.activity.LoadItemSelect("Create offer code");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Username");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131100202);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Points");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131099658);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Give Points");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize(textView, activity3.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda25(this, editText, editText2));
    }
    
    public void SendFriendCoins() {
        this.activity.LoadItemSelect("Send Friendship Coins");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Player Name");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131100202);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Amount");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131099658);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Send Coins");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize(textView, activity3.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda40(this, editText, editText2));
    }
    
    public void SendFriendGifts() {
        this.activity.LoadItemSelect("Send Friendship Gifts");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Player Name");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131100202);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Amount");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131099658);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Send Gifts");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize(textView, activity3.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda44(this, editText, editText2));
    }
    
    public void SendItem() {
        this.activity.LoadItemSelect("Send an Item");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Player Name");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131100202);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Item");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final EditText editText3 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131100202);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        editText3.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        editText3.setBackground(this.activity.GetImage(2131165476));
        editText3.setText((CharSequence)"");
        editText3.setHint((CharSequence)"Amount");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize((TextView)editText3, activity3.GetResource(2131099658));
        editText3.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText3);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams4 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams4.topMargin = this.activity.GetResource(2131099658);
        layoutParams4.leftMargin = this.activity.GetResource(2131099769);
        layoutParams4.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Send Item");
        final MainActivity activity4 = this.activity;
        activity4.SetTextSize(textView, activity4.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda1(this, editText, editText2, editText3));
    }
    
    public void SendMessage() {
        this.activity.LoadItemSelect("Create offer code");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Title");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131099769);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Message");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131099658);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Send Message");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize(textView, activity3.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda46(this, editText, editText2));
    }
    
    public void UnbanUser() {
        this.activity.LoadItemSelect("Unban a User");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099769);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Player Name");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131099658);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Unban");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView, activity2.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda45(this, editText));
    }
    
    public void UpdateCommunityVault() {
        this.activity.LoadItemSelect("Update Community Vault");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131100202);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Requested Item");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131100202);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Request Amount");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final EditText editText3 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131100202);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        editText3.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        editText3.setBackground(this.activity.GetImage(2131165476));
        editText3.setText((CharSequence)"");
        editText3.setHint((CharSequence)"Reward");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize((TextView)editText3, activity3.GetResource(2131099658));
        editText3.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText3);
        final EditText editText4 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams4 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams4.topMargin = this.activity.GetResource(2131100202);
        layoutParams4.leftMargin = this.activity.GetResource(2131099769);
        layoutParams4.rightMargin = this.activity.GetResource(2131099769);
        editText4.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        editText4.setBackground(this.activity.GetImage(2131165476));
        editText4.setText((CharSequence)"");
        editText4.setHint((CharSequence)"Reward Amount");
        final MainActivity activity4 = this.activity;
        activity4.SetTextSize((TextView)editText4, activity4.GetResource(2131099658));
        editText4.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText4);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams5 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams5.topMargin = this.activity.GetResource(2131099658);
        layoutParams5.leftMargin = this.activity.GetResource(2131099769);
        layoutParams5.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams5);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Update Community Donations");
        final MainActivity activity5 = this.activity;
        activity5.SetTextSize(textView, activity5.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda47(this, editText, editText2, editText3, editText4));
    }
    
    public void UpdateGods() {
        this.activity.LoadItemSelect("Update Weekly Gods");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        linearLayout$LayoutParams.topMargin = this.activity.GetResource(2131099769);
        linearLayout$LayoutParams.leftMargin = this.activity.GetResource(2131099769);
        linearLayout$LayoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)linearLayout$LayoutParams);
        editText.setText((CharSequence)("Current Gods: " + this.activity.databaseManager.currentGodsRotation));
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        this.activity.itemSelect_wrap.addView((View)editText);
        final String getRotation = this.GetRotation();
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams linearLayout$LayoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        linearLayout$LayoutParams2.topMargin = this.activity.GetResource(2131099658);
        linearLayout$LayoutParams2.leftMargin = this.activity.GetResource(2131099769);
        linearLayout$LayoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)linearLayout$LayoutParams);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)getRotation);
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131099658);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Update Weekly Gods");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize(textView, activity3.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda10(this, editText2));
    }
    
    public void UpdateVault() {
        this.activity.LoadItemSelect("Update Vault Code");
        this.activity.itemSelect_wrap.removeAllViews();
        final EditText editText = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams.topMargin = this.activity.GetResource(2131100202);
        layoutParams.leftMargin = this.activity.GetResource(2131099769);
        layoutParams.rightMargin = this.activity.GetResource(2131099769);
        editText.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        editText.setBackground(this.activity.GetImage(2131165476));
        editText.setText((CharSequence)"");
        editText.setHint((CharSequence)"Reward");
        final MainActivity activity = this.activity;
        activity.SetTextSize((TextView)editText, activity.GetResource(2131099658));
        editText.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText);
        final EditText editText2 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.topMargin = this.activity.GetResource(2131100202);
        layoutParams2.leftMargin = this.activity.GetResource(2131099769);
        layoutParams2.rightMargin = this.activity.GetResource(2131099769);
        editText2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        editText2.setBackground(this.activity.GetImage(2131165476));
        editText2.setText((CharSequence)"");
        editText2.setHint((CharSequence)"Amount");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize((TextView)editText2, activity2.GetResource(2131099658));
        editText2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText2);
        final EditText editText3 = new EditText((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams3.topMargin = this.activity.GetResource(2131100202);
        layoutParams3.leftMargin = this.activity.GetResource(2131099769);
        layoutParams3.rightMargin = this.activity.GetResource(2131099769);
        editText3.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        editText3.setBackground(this.activity.GetImage(2131165476));
        editText3.setText((CharSequence)"");
        editText3.setHint((CharSequence)"Code Length");
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize((TextView)editText3, activity3.GetResource(2131099658));
        editText3.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        this.activity.itemSelect_wrap.addView((View)editText3);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams4 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams4.topMargin = this.activity.GetResource(2131099658);
        layoutParams4.leftMargin = this.activity.GetResource(2131099769);
        layoutParams4.rightMargin = this.activity.GetResource(2131099769);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        textView.setGravity(17);
        textView.setBackground(this.activity.GetImage(2131165476));
        textView.setText((CharSequence)"Create Code");
        final MainActivity activity4 = this.activity;
        activity4.SetTextSize(textView, activity4.GetResource(2131099680));
        this.activity.itemSelect_wrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new DevTools$$ExternalSyntheticLambda43(this, editText, editText2, editText3));
    }
}
