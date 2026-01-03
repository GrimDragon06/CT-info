package uk.playdrop.cherrytree_idletextrpg;

import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View$OnClickListener;
import android.widget.LinearLayout;
import android.os.CountDownTimer;
import android.view.View;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.TextView;
import java.util.List;

public class Fishing
{
    MainActivity activity;
    List<String> fishingLocations;
    List<Long> fishingLocationsBaseSpeed;
    List<Long> fishingLocationsExp;
    List<String> fishingLocationsFish;
    List<Integer> fishingLocationsLevel;
    boolean fishingNetActive;
    long fishingNetTime;
    List<String> fishingOutfit;
    long largeFishingNetTime;
    List<String> oldFishingRodLootTable;
    int outfitPieces;
    List<Boolean> premiumLocation;
    List<TextView> startButtons;
    
    public Fishing(final MainActivity activity) {
        final Boolean value = false;
        final Integer value2 = 1;
        this.fishingLocations = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Christmas Village", "Small Pond", "City River", "Woodland Lake", "Cave", "Beach Pier", "Mystery Island", "Open Ocean", "Livingstone Island", "The Grove", "Mystic Lake" }));
        this.fishingLocationsFish = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Raw Carp,Raw Shrimp,Raw Perch,Raw Crab,Raw Lobster,Raw Clownfish,Raw Catfish,Raw Jellyfish,Raw Squid,Raw Ray", "Raw Carp,Raw Snail,Raw Shrimp,Fish Hook,Common Chest", "Raw Perch,Raw Minnows,Raw Carp,Old Boot,Shell,Fish Hook,Common Key,Ancient Rod", "Raw Perch,Raw Carp,Raw Minnows,Old Boot,Carving Knife,Shell,Bag of Pearls,Common Chest,Common Key", "Raw Crab,Blue Shrimp,Raw Perch,Raw Lobster,Shell,Tentacle,Skeleton Fish,Jawbone,Red Chest", "Raw Clownfish,Raw Catfish,Raw Jellyfish,Amonyte,Pearl,Blue Crab,Anchor,Red Key", "Raw Catfish,Raw Jellyfish,Raw Pufferfish,Raw Marlin,Raw Ray,Raw Shark,Raw Squid, Raw Octopus,Fish Hook,Jawbone,Large Fishing Net,Crystal Chest,Spiked Chest,Nefrit Chest", "Raw Pufferfish,Raw Marlin,Raw Ray,Amonyte,Message in a Bottle,Treasure Map,Wine,Spiked Chest,Spiked Key", "Raw Shark,Raw Squid,Raw Ray,Amonyte,Message in a Bottle,Treasure Map,Nefrit Chest,Nefrit Key", "Raw Marlin,Raw Ray,Raw Shark,Raw Squid,Raw Octopus", "Raw Octopus,Raw Squid,Raw Shark,Raw Ray,Treasure Map,Tentacle,Pirates Hat,Sea Scorpion,Crystal Chest,Crystal Key" }));
        final Long value3 = 15L;
        this.fishingLocationsExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value3, 5L, 10L, value3, 30L, 60L, 90L, 100L, 150L, 200L, 300L }));
        this.fishingLocationsLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value2, value2, 20, 30, 40, 50, 60, 70, 85, 90, 95 }));
        final Long value4 = 5000L;
        final Long value5 = 7500L;
        this.fishingLocationsBaseSpeed = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 20000L, 3000L, 3500L, 4000L, 4500L, value4, value5, 6000L, value5, value4, 10000L }));
        this.premiumLocation = (List<Boolean>)new ArrayList((Collection)Arrays.asList((Object[])new Boolean[] { value, value, value, value, value, value, value, value, value, true, value }));
        this.startButtons = (List<TextView>)new ArrayList();
        this.fishingNetTime = 60000L;
        this.largeFishingNetTime = 300000L;
        this.fishingNetActive = false;
        this.oldFishingRodLootTable = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Gold Coin", "Wood", "Barrel", "Coin Purse", "Blue Silk", "Diary", "Notebook", "Anchor", "Fish Hook", "Bestiary", "Stone Tablet", "Book of Aroon" }));
        this.fishingOutfit = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Fishing Boots", "Fishing Gloves", "Fishing Hat", "Fishing Top", "Fishing Waders" }));
        this.outfitPieces = 0;
        this.activity = activity;
    }
    
    private int FishingOutfitPieces() {
        final Iterator iterator = this.activity.combatManager.equippedItems.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (this.fishingOutfit.contains((Object)iterator.next())) {
                ++n;
            }
        }
        return n;
    }
    
    private long GetFishingSpeed(final String s) {
        long n = (long)this.fishingLocationsBaseSpeed.get(this.fishingLocations.indexOf((Object)s)) - this.activity.fishingRodLevel * 200L - this.activity.databaseManager.GetWishLevel("Fisher", "Beginner") * 100L;
        long n2;
        if (this.activity.combatManager.equippedItems.contains((Object)"Sprinkles")) {
            n -= n / 5L;
            n2 = 900L;
        }
        else {
            n2 = 1000L;
        }
        return Math.max(n, n2);
    }
    
    private void ResetButtons() {
        for (final TextView textView : this.startButtons) {
            textView.setText((CharSequence)"Start");
            textView.setBackground(this.activity.GetImage(2131166451));
        }
    }
    
    private void ShowPossibleFish(int i) {
        this.activity.LoadItemSelect("Loot from " + (String)this.fishingLocations.get(i));
        this.activity.itemSelect_wrap.removeAllViews();
        final String[] split = ((String)this.fishingLocationsFish.get(i)).split("\\s*,\\s*");
        int length;
        String s;
        MainActivity activity;
        for (length = split.length, i = 0; i < length; ++i) {
            s = split[i];
            activity = this.activity;
            this.activity.itemSelect_wrap.addView((View)activity.AddItemSelectItem((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s)), s));
        }
    }
    
    void ActivateNet(final String s) {
        this.activity.QuickPopup("You cast out your Fishing Net");
        this.fishingNetActive = true;
        long n;
        if (s.equals((Object)"Fishing Net")) {
            n = this.fishingNetTime;
        }
        else {
            n = this.largeFishingNetTime;
        }
        new CountDownTimer(this, n, 1000L, s) {
            final Fishing this$0;
            final String val$net;
            
            public void onFinish() {
                this.this$0.fishingNetActive = false;
                if (!this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Anuket") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Ring of Anuket") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Copina") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Copina (E)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Copina (E2)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Copina (E3)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Copina (E4)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Copina (E5)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Rod of Copina (E6)")) {
                    this.this$0.activity.QuickPopup("Your Fishing Net bonus has ended.");
                }
                else if (this.this$0.activity.inventoryItems.contains((Object)this.val$net)) {
                    this.this$0.activity.RemoveItem(this.val$net, 1);
                    this.this$0.ActivateNet(this.val$net);
                }
                else {
                    this.this$0.activity.QuickPopup("You have run out of Fishing Nets.");
                }
            }
            
            public void onTick(final long n) {
            }
        }.start();
    }
    
    public void GoFishing(final String s) {
        this.outfitPieces = this.FishingOutfitPieces();
        float max;
        if (s.equals((Object)"Christmas Village")) {
            max = (float)(long)this.fishingLocationsBaseSpeed.get(this.fishingLocations.indexOf((Object)s));
        }
        else {
            max = Math.max(this.GetFishingSpeed(s) - (float)(this.activity.databaseManager.GetWishLevel("Fisher", "Beginner") * 100), 1000.0f);
        }
        long longValue = (long)this.fishingLocationsExp.get(this.fishingLocations.indexOf((Object)s));
        if (s.equals((Object)"Christmas Village")) {
            longValue *= this.activity.GetSkillLevel("Fishing");
        }
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])((String)this.fishingLocationsFish.get(this.fishingLocations.indexOf((Object)s))).split("\\s*,\\s*")));
        final MainActivity activity = this.activity;
        activity.StartSkilling("Fishing", (long)max, (List)list, true, s, longValue, activity.fishingSkillProgress);
    }
    
    public void OpenFishing() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.fishingScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.EnableScreen();
        this.startButtons.clear();
        final MainActivity activity4 = this.activity;
        activity4.ExpBar("Fishing", activity4.fishingSkillProgress);
        ((LinearLayout)this.activity.fishingScreen.getChildAt(1)).getChildAt(0).setOnClickListener((View$OnClickListener)new Fishing$$ExternalSyntheticLambda0(this));
        ((LinearLayout)this.activity.fishingScreen.getChildAt(1)).getChildAt(1).setOnClickListener((View$OnClickListener)new Fishing$$ExternalSyntheticLambda1(this));
        for (int i = 0; i < this.fishingLocations.size(); ++i) {
            final ConstraintLayout constraintLayout = (ConstraintLayout)this.activity.fishingWrap.getChildAt(i);
            if (this.activity.GetSkillLevel("Fishing") < (int)this.fishingLocationsLevel.get(i)) {
                constraintLayout.setAlpha(0.2f);
            }
            else if ((boolean)this.premiumLocation.get(i) && !this.activity.members) {
                constraintLayout.setAlpha(0.2f);
            }
            else {
                constraintLayout.setAlpha(1.0f);
            }
            long n;
            if (((String)this.fishingLocations.get(i)).equals((Object)"Christmas Village")) {
                n = (long)this.fishingLocationsBaseSpeed.get(i);
            }
            else {
                n = this.GetFishingSpeed((String)this.fishingLocations.get(i));
            }
            final float n2 = (float)n;
            ((TextView)constraintLayout.getChildAt(0)).setText((CharSequence)this.fishingLocations.get(i));
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)("Level " + this.fishingLocationsLevel.get(i)));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)("Speed: " + n2 / 1000.0f + " seconds"));
            ((TextView)constraintLayout.getChildAt(3)).setText((CharSequence)("Experience: " + this.fishingLocationsExp.get(i) + " exp"));
            final TextView textView = (TextView)constraintLayout.getChildAt(4);
            final TextView textView2 = (TextView)constraintLayout.getChildAt(5);
            this.startButtons.add((Object)textView2);
            if (this.activity.trainingSkill.equals((Object)"Fishing") && this.activity.trainingMethod.equals(this.fishingLocations.get(i))) {
                textView2.setText((CharSequence)"Stop");
                textView2.setBackground(this.activity.GetImage(2131166453));
            }
            else {
                textView2.setText((CharSequence)"Start");
                textView2.setBackground(this.activity.GetImage(2131166451));
            }
            textView.setOnClickListener((View$OnClickListener)new Fishing$$ExternalSyntheticLambda2(this, i));
            textView2.setOnClickListener((View$OnClickListener)new Fishing$$ExternalSyntheticLambda3(this, i, textView2));
        }
    }
}
