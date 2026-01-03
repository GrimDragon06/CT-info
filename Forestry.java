package uk.playdrop.cherrytree_idletextrpg;

import android.widget.ProgressBar;
import java.util.Locale;
import android.view.ViewStub;
import java.util.Collections;
import java.util.Iterator;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.view.ViewGroup;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;

public class Forestry
{
    MainActivity activity;
    LinearLayout firemakingList;
    TextView firemakingMakeXButton;
    LinearLayout firemakingScreen;
    RelativeLayout firemakingSkillProgress;
    List<TextView> firemakingViews;
    List<Long> forestBurnExp;
    List<Long> forestExp;
    List<Integer> forestLevels;
    List<String> forestLogs;
    List<Float> forestNestChance;
    List<Long> forestSpeed;
    List<String> forestTrees;
    long lastBurnTime;
    List<String> lumberjackOutfit;
    int outfitPieces;
    List<String> rustyHatchetLootTable;
    List<TextView> startButtons;
    
    public Forestry(final MainActivity activity) {
        final Integer value = 1;
        this.forestTrees = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Christmas Village", "Evergreen Tree", "Oak Tree", "Pine Tree", "Maple Tree", "Birch Tree", "Spruce Tree", "Fir Tree", "Ash Tree", "Willow Tree", "Eucalyptus Tree", "Elder Tree", "Redwood Tree", "Cedar Tree", "Cherry Blossom Tree", "Mahogany Tree", "Chestnut Tree", "Magnolia Tree", "Ginkgo Tree", "Sandalwood Tree" }));
        this.forestLogs = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "No Log", "Evergreen Log", "Oak Log", "Pine Log", "Maple Log", "Birch Log", "Spruce Log", "Fir Log", "Ash Log", "Willow Log", "Eucalyptus Log", "Elder Log", "Redwood Log", "Cedar Log", "Cherry Blossom Log", "Mahogany Log", "Chestnut Log", "Magnolia Log", "Ginkgo Log", "Sandalwood Log" }));
        this.forestLevels = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value, 12, 25, 35, 42, 50, 62, 69, 76, 85, 91, 96, 102, 110, 115, 121, 125, 129, 138 }));
        final Long value2 = 2000L;
        this.forestExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 30L, 15L, 25L, 40L, 60L, 75L, 100L, 150L, 225L, 350L, 500L, 650L, 1000L, 1400L, value2, 3000L, 4500L, 6000L, 8500L, 12000L }));
        this.forestBurnExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 0L, 14L, 23L, 36L, 55L, 68L, 91L, 136L, 205L, 318L, 455L, 591L, 909L, 1273L, 1818L, 2727L, 4091L, 5455L, 7727L, 10909L }));
        this.forestSpeed = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 20000L, value2, 2500L, 3000L, 3500L, 4000L, 5000L, 5500L, 6000L, 6500L, 7000L, 8000L, 10000L, 12000L, 15000L, 18000L, 22000L, 26000L, 30000L, 60000L }));
        this.forestNestChance = (List<Float>)new ArrayList((Collection)Arrays.asList((Object[])new Float[] { 1.0f, 0.3f, 0.45f, 0.6f, 0.75f, 0.9f, 1.05f, 1.2f, 1.35f, 1.5f, 1.65f, 1.8f, 1.95f, 2.1f, 2.25f, 2.4f, 2.55f, 2.7f, 2.85f, 25.0f }));
        this.startButtons = (List<TextView>)new ArrayList();
        this.firemakingViews = (List<TextView>)new ArrayList();
        this.lastBurnTime = 0L;
        this.rustyHatchetLootTable = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Gold Coin", "Coin Purse", "Stone Tablet", "Book of Aroon", "Ring Fragments", "Dragon Skull", "Dragon Leather", "Elven Crystal", "Pirates Hat", "Tooth Necklace" }));
        this.lumberjackOutfit = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Lumberjack Boots", "Lumberjack Gloves", "Lumberjack Top", "Lumberjack Hat", "Lumberjack Legs" }));
        this.outfitPieces = 0;
        this.activity = activity;
    }
    
    private void CheckRingFrags() {
        int i = 0;
        int n = 0;
        while (i < (int)this.activity.makeXAmounts.get(this.activity.burnX)) {
            int n2 = n;
            if (this.activity.GetRandom(1, 75000) <= 1) {
                n2 = n + 1;
            }
            ++i;
            n = n2;
        }
        if (n > 0) {
            final MainActivity activity = this.activity;
            final long n3 = n;
            activity.GiveItem("Ring Fragments", n3, false);
            this.activity.LargePopup(2131166150, "Congratulations", "While burning logs, your pet finds " + this.activity.FormatExp(n3) + "x Ring Fragments!");
        }
    }
    
    private boolean CheckUnlocks() {
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= this.forestLogs.size()) {
                break;
            }
            if ((int)this.forestLevels.get(n) == this.activity.GetSkillLevel("Firemaking")) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    private void GenerateFiremaking() {
        this.firemakingMakeXButton.setOnClickListener((View$OnClickListener)new Forestry$$ExternalSyntheticLambda3(this));
        this.firemakingList.removeAllViews();
        this.firemakingViews.clear();
        for (int i = 0; i < this.forestLogs.size(); ++i) {
            if (i != 0) {
                final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this.activity, 2131492912, (ViewGroup)null);
                this.firemakingList.addView((View)relativeLayout);
                Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.forestLogs.get(i)))).into((ImageView)relativeLayout.getChildAt(0));
                ((TextView)relativeLayout.getChildAt(1)).setText((CharSequence)this.forestLogs.get(i));
                final LinearLayout linearLayout = (LinearLayout)relativeLayout.findViewById(2131296487);
                this.activity.HideView(linearLayout.getChildAt(1));
                this.activity.HideView(linearLayout.getChildAt(2));
                this.activity.HideView(linearLayout.getChildAt(3));
                this.activity.HideView(linearLayout.getChildAt(4));
                this.SetTextView((TextView)linearLayout.getChildAt(0), (String)this.forestLogs.get(i));
                this.firemakingViews.add((Object)linearLayout.getChildAt(0));
                final TextView textView = (TextView)relativeLayout.getChildAt(3);
                if (this.activity.GetSkillLevel("Firemaking") >= (int)this.forestLevels.get(i)) {
                    textView.setText((CharSequence)"Burn");
                }
                else {
                    textView.setAlpha(0.5f);
                    textView.setText((CharSequence)("Level " + this.forestLevels.get(i)));
                }
                textView.setOnClickListener((View$OnClickListener)new Forestry$$ExternalSyntheticLambda4(this, i, linearLayout));
                if (this.activity.GetSkillLevel("Firemaking") < (int)this.forestLevels.get(i)) {
                    break;
                }
                if (((String)this.forestTrees.get(i)).equals((Object)"Christmas Village")) {
                    relativeLayout.setVisibility(8);
                }
            }
        }
    }
    
    private int LumberjackOutfitPieces() {
        final Iterator iterator = this.activity.combatManager.equippedItems.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (this.lumberjackOutfit.contains((Object)iterator.next())) {
                ++n;
            }
        }
        return n;
    }
    
    private void SetTextView(final TextView textView, String string) {
        long longValue;
        if (this.activity.inventoryItems.contains((Object)string)) {
            longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)string));
        }
        else {
            longValue = 0L;
        }
        final MainActivity activity = this.activity;
        final MainActivity activity2 = this.activity;
        string = activity.getString(2131820615, new Object[] { longValue, activity2.FormatExp((long)(int)activity2.makeXAmounts.get(this.activity.burnX)), string });
        if (!textView.getText().toString().equals((Object)string)) {
            textView.setText((CharSequence)string);
        }
        if (longValue >= (int)this.activity.makeXAmounts.get(this.activity.burnX)) {
            textView.setTextColor(this.activity.GetColour(2131034925));
        }
        else {
            textView.setTextColor(this.activity.GetColour(2131034904));
        }
    }
    
    private void UpdateViews() {
        int i = 0;
        while (i < this.firemakingViews.size()) {
            final TextView textView = (TextView)this.firemakingViews.get(i);
            final List<String> forestLogs = this.forestLogs;
            ++i;
            this.SetTextView(textView, (String)forestLogs.get(i));
        }
    }
    
    public float GetChopSpeed(final String s) {
        final float n = (float)(long)this.forestSpeed.get(this.forestTrees.indexOf((Object)s));
        final boolean equals = s.equals((Object)"Sandalwood Tree");
        final long n2 = 1000L;
        float n3 = n;
        long n4 = n2;
        if (!equals) {
            n3 = n;
            n4 = n2;
            if (!s.equals((Object)"Christmas Village")) {
                this.outfitPieces = this.LumberjackOutfitPieces();
                float n5 = 0.0f;
                Label_0145: {
                    if (!this.activity.combatManager.equippedItems.contains((Object)"Hatchet of the Gods") && !this.activity.combatManager.equippedItems.contains((Object)"Hatchet of Copina")) {
                        n5 = n;
                        if (!this.activity.combatManager.equippedItems.contains((Object)"Hatchet of Copina (E)")) {
                            break Label_0145;
                        }
                    }
                    n5 = n * 0.75f;
                }
                final float n6 = n3 = n5 - this.activity.databaseManager.GetWishLevel("Lumberjack", "Beginner") * 100;
                n4 = n2;
                if (this.activity.combatManager.equippedItems.contains((Object)"Sprinkles")) {
                    n3 = n6 - n6 / 5.0f;
                    n4 = 900L;
                }
            }
        }
        return Math.max(n3, (float)n4);
    }
    
    public void GetChopping(final String s) {
        ArrayList list;
        if (s.equals((Object)"Christmas Village")) {
            list = new ArrayList((Collection)this.forestLogs);
            ((List)list).remove(0);
            ((List)list).remove(((List)list).size() - 1);
            this.activity.LogIt("Chopping: " + s + " Possible Logs are: " + (Object)list);
        }
        else {
            list = new ArrayList((Collection)Collections.singletonList((Object)this.forestLogs.get(this.forestTrees.indexOf((Object)s))));
        }
        final float getChopSpeed = this.GetChopSpeed(s);
        long longValue = (long)this.forestExp.get(this.forestTrees.indexOf((Object)s));
        if (s.equals((Object)"Christmas Village")) {
            longValue *= this.activity.GetSkillLevel("Forestry");
        }
        final MainActivity activity = this.activity;
        activity.StartSkilling("Forestry", (long)getChopSpeed, (List)list, true, s, longValue, activity.forestrySkillProgress);
    }
    
    public void OpenFiremaking() {
        if (this.firemakingScreen == null) {
            final LinearLayout firemakingScreen = (LinearLayout)((ViewStub)this.activity.findViewById(2131296635)).inflate();
            this.firemakingScreen = firemakingScreen;
            this.firemakingList = (LinearLayout)firemakingScreen.findViewById(2131296631);
            this.firemakingMakeXButton = (TextView)this.firemakingScreen.findViewById(2131296632);
            this.firemakingSkillProgress = (RelativeLayout)this.firemakingScreen.findViewById(2131296634);
        }
        this.activity.findViewById(2131297035).setOnClickListener((View$OnClickListener)new Forestry$$ExternalSyntheticLambda0(this));
        this.activity.EnableLayout((ViewGroup)this.firemakingScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.firemakingScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.activity.ExpBar("Firemaking", this.firemakingSkillProgress);
        this.firemakingMakeXButton.setText((CharSequence)("Burn " + this.activity.makeXAmounts.get(this.activity.burnX)));
        this.GenerateFiremaking();
    }
    
    public void OpenForest() {
        if (this.activity.forestScreen == null) {
            final MainActivity activity = this.activity;
            activity.forestScreen = (LinearLayout)((ViewStub)activity.findViewById(2131296658)).inflate();
            final MainActivity activity2 = this.activity;
            activity2.forestScreen = (LinearLayout)activity2.findViewById(2131296657);
            final MainActivity activity3 = this.activity;
            activity3.forestryWrap = (LinearLayout)activity3.findViewById(2131296660);
            final MainActivity activity4 = this.activity;
            activity4.forestrySkillProgress = (RelativeLayout)activity4.findViewById(2131296659);
        }
        final MainActivity activity5 = this.activity;
        activity5.HideView(activity5.currentView);
        final MainActivity activity6 = this.activity;
        activity6.currentView = (View)activity6.forestScreen;
        final MainActivity activity7 = this.activity;
        activity7.ShowView(activity7.currentView);
        this.activity.EnableScreen();
        this.activity.forestScreen.getChildAt(1).setOnClickListener((View$OnClickListener)new Forestry$$ExternalSyntheticLambda1(this));
        this.startButtons.clear();
        final MainActivity activity8 = this.activity;
        activity8.ExpBar("Forestry", activity8.forestrySkillProgress);
        for (int i = 0; i < this.forestTrees.size(); ++i) {
            final RelativeLayout relativeLayout = (RelativeLayout)this.activity.forestryWrap.getChildAt(i);
            if (this.activity.GetSkillLevel("Forestry") < (int)this.forestLevels.get(i)) {
                relativeLayout.setAlpha(0.3f);
            }
            else {
                relativeLayout.setAlpha(1.0f);
            }
            final float floatValue = (float)this.forestNestChance.get(i);
            float n = 0.0f;
            Label_0351: {
                if (!this.activity.combatManager.equippedItems.contains((Object)"Rabbits Foot")) {
                    n = floatValue;
                    if (!this.activity.combatManager.equippedItems.contains((Object)"Ring of Forestry")) {
                        break Label_0351;
                    }
                }
                n = floatValue * 2.0f;
            }
            final float getChopSpeed = this.GetChopSpeed((String)this.forestTrees.get(i));
            if (((String)this.forestTrees.get(i)).equals((Object)"Christmas Village")) {
                ((ImageView)relativeLayout.getChildAt(0)).setImageDrawable(this.activity.GetImage(2131165696));
            }
            else {
                final ImageView imageView = (ImageView)relativeLayout.getChildAt(0);
                final MainActivity activity9 = this.activity;
                imageView.setImageDrawable(activity9.GetImage((int)activity9.allItemsIcons.get(this.activity.allItems.indexOf(this.forestLogs.get(i)))));
            }
            ((TextView)relativeLayout.getChildAt(1)).setText((CharSequence)this.forestTrees.get(i));
            final LinearLayout linearLayout = (LinearLayout)relativeLayout.findViewById(2131296655);
            ((TextView)linearLayout.getChildAt(0)).setText((CharSequence)("Level " + this.forestLevels.get(i)));
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)("Chop Speed: " + String.format(Locale.UK, "%.2f", new Object[] { getChopSpeed / 1000.0f }) + " seconds"));
            ((TextView)linearLayout.getChildAt(2)).setText((CharSequence)("Nest Chance: " + n + "%"));
            final TextView textView = (TextView)relativeLayout.getChildAt(3);
            this.startButtons.add((Object)textView);
            if (this.activity.trainingSkill.equals((Object)"Forestry")) {
                if (this.activity.trainingMethod.equals(this.forestTrees.get(i))) {
                    textView.setText((CharSequence)"Stop");
                    textView.setBackground(this.activity.GetImage(2131166453));
                }
                else {
                    textView.setText((CharSequence)"Chop");
                    textView.setBackground(this.activity.GetImage(2131166451));
                }
            }
            else {
                textView.setText((CharSequence)"Chop");
                textView.setBackground(this.activity.GetImage(2131166451));
            }
            textView.setOnClickListener((View$OnClickListener)new Forestry$$ExternalSyntheticLambda2(this, i, textView));
        }
    }
}
