package uk.playdrop.cherrytree_idletextrpg;

import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import java.util.Collections;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.TextView;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import java.util.List;

public class Mining
{
    MainActivity activity;
    List<Long> miningLocationsBaseSpeed;
    List<Long> miningLocationsExp;
    List<Integer> miningLocationsLevel;
    List<Integer> miningLocationsSuccess;
    List<String> miningOutfit;
    List<String> miningRocks;
    LinearLayout miningScreen;
    RelativeLayout miningSkillProgress;
    GridLayout miningWrap;
    int outfitPieces;
    List<String> rustyPickaxeLootTable;
    List<TextView> startButtons;
    
    public Mining(final MainActivity activity) {
        final Integer value = 1;
        final Integer value2 = 15;
        this.miningRocks = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Christmas Village", "Stone", "Copper Ore", "Iron Ore", "Silver Ore", "Gold Ore", "Sapphire", "Mithril Ore", "Emerald", "Ruby", "Diamond", "Dragon Ore", "Platinum Ore", "Rhodium Ore", "Iridium Ore", "Darkstar Ore" }));
        final Integer value3 = 75;
        final Integer value4 = 65;
        final Integer value5 = 60;
        final Integer value6 = 30;
        final Integer value7 = 25;
        this.miningLocationsSuccess = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 100, 80, value3, 70, value4, value5, 55, 50, 40, value6, value7, 20, value2, 12, 10, value7 }));
        this.miningLocationsLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value, value2, 20, value6, 45, value5, value4, value3, 85, 93, 99, 105, 115, 125, 138 }));
        this.miningLocationsBaseSpeed = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 20000L, 2000L, 2500L, 3000L, 3500L, 4000L, 5000L, 6000L, 8000L, 10000L, 15000L, 20000L, 30000L, 45000L, 60000L, 60000L }));
        this.miningLocationsExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 25L, 15L, 25L, 40L, 60L, 100L, 150L, 200L, 300L, 450L, 800L, 1500L, 3000L, 5000L, 10000L, 15000L }));
        this.startButtons = (List<TextView>)new ArrayList();
        this.rustyPickaxeLootTable = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Gold Coin", "Coin Purse", "Stone Tablet", "Book of Aroon", "Ring Fragments", "Elven Arrows", "Kings Arrows", "Ember Fern", "Treasure Map" }));
        this.miningOutfit = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Miners Boots", "Miners Gloves", "Miners Top", "Miners Hat", "Miners Legs" }));
        this.outfitPieces = 0;
        this.activity = activity;
    }
    
    private int MinersOutfitPieces() {
        final Iterator iterator = this.miningOutfit.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (this.activity.combatManager.equippedItems.contains((Object)iterator.next())) {
                ++n;
            }
        }
        return n;
    }
    
    public float GetMiningSpeed(final String s) {
        final float n = (float)(long)this.miningLocationsBaseSpeed.get(this.miningRocks.indexOf((Object)s));
        final boolean equals = s.equals((Object)"Darkstar Ore");
        final long n2 = 1000L;
        float max = n;
        long n3 = n2;
        if (!equals) {
            max = n;
            n3 = n2;
            if (!s.equals((Object)"Christmas Village")) {
                final float n4 = max = Math.max(n - this.activity.databaseManager.GetWishLevel("Miner", "Beginner") * 100, 1000.0f);
                n3 = n2;
                if (this.activity.combatManager.equippedItems.contains((Object)"Sprinkles")) {
                    max = n4 - n4 / 5.0f;
                    n3 = 900L;
                }
            }
        }
        return Math.max(max, (float)n3);
    }
    
    public int GetSuccessChance(final int n) {
        int intValue = (int)this.miningLocationsSuccess.get(n);
        if (this.activity.GetSkillLevel("Mining") >= (int)this.miningLocationsLevel.get(n)) {
            intValue += this.activity.GetSkillLevel("Mining") - (int)this.miningLocationsLevel.get(n);
        }
        if (this.activity.combatManager.equippedItems.contains((Object)"Pickaxe of the Gods") || this.activity.combatManager.equippedItems.contains((Object)"Pickaxe of Copina") || this.activity.combatManager.equippedItems.contains((Object)"Pickaxe of Copina (E)")) {
            intValue = 100;
        }
        return Math.min(intValue, 100);
    }
    
    public void GoMining(final String s) {
        this.outfitPieces = this.MinersOutfitPieces();
        Object singletonList;
        if (!s.equals((Object)"Christmas Village")) {
            singletonList = Collections.singletonList((Object)s);
        }
        else {
            singletonList = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Stone", "Copper Ore", "Iron Ore", "Silver Ore", "Gold Ore", "Sapphire", "Mithril Ore", "Emerald", "Ruby", "Diamond", "Dragon Ore", "Platinum Ore", "Rhodium Ore", "Iridium Ore" }));
        }
        final float getMiningSpeed = this.GetMiningSpeed(s);
        long longValue = (long)this.miningLocationsExp.get(this.miningRocks.indexOf((Object)s));
        if (s.equals((Object)"Christmas Village")) {
            longValue *= this.activity.GetSkillLevel("Mining");
        }
        this.activity.StartSkilling("Mining", (long)getMiningSpeed, (List<String>)singletonList, true, s, longValue, this.miningSkillProgress);
    }
    
    public void OpenMining() {
        if (this.miningScreen == null) {
            final LinearLayout miningScreen = (LinearLayout)((ViewStub)this.activity.findViewById(2131296854)).inflate();
            this.miningScreen = miningScreen;
            this.miningWrap = (GridLayout)miningScreen.findViewById(2131296855);
            this.miningSkillProgress = (RelativeLayout)this.miningScreen.findViewById(2131296853);
        }
        this.activity.EnableLayout((ViewGroup)this.miningScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.miningScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.startButtons.clear();
        this.activity.ExpBar("Mining", this.miningSkillProgress);
        for (int i = 0; i < this.miningRocks.size(); ++i) {
            final LinearLayout linearLayout = (LinearLayout)this.miningWrap.getChildAt(i);
            if (this.activity.GetSkillLevel("Mining") < (int)this.miningLocationsLevel.get(i)) {
                linearLayout.setAlpha(0.3f);
            }
            else {
                linearLayout.setAlpha(1.0f);
            }
            final float getMiningSpeed = this.GetMiningSpeed((String)this.miningRocks.get(i));
            ((TextView)linearLayout.getChildAt(0)).setText((CharSequence)this.miningRocks.get(i));
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)("Level " + this.miningLocationsLevel.get(i)));
            ((TextView)linearLayout.getChildAt(3)).setText((CharSequence)("Speed: " + getMiningSpeed / 1000.0f + " seconds"));
            ((TextView)linearLayout.getChildAt(4)).setText((CharSequence)("Success: " + this.GetSuccessChance(i) + "%"));
            ((TextView)linearLayout.getChildAt(5)).setText((CharSequence)("Experience: " + this.miningLocationsExp.get(i) + " exp"));
            final TextView textView = (TextView)linearLayout.getChildAt(6);
            this.startButtons.add((Object)textView);
            if (this.activity.trainingSkill.equals((Object)"Mining") && this.activity.trainingMethod.equals(this.miningRocks.get(i))) {
                textView.setText((CharSequence)"Stop Mining");
                textView.setBackground(this.activity.GetImage(2131166453));
            }
            else {
                textView.setText((CharSequence)"Start Mining");
                textView.setBackground(this.activity.GetImage(2131166451));
            }
            textView.setOnClickListener((View$OnClickListener)new Mining$$ExternalSyntheticLambda0(this, i, textView));
        }
    }
}
