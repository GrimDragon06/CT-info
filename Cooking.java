package uk.playdrop.cherrytree_idletextrpg;

import android.view.View;
import android.widget.ImageView;
import android.view.View$OnClickListener;
import android.util.Log;
import android.widget.TextView;
import android.widget.ProgressBar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.LinearLayout;
import java.util.List;

public class Cooking
{
    CookingItem activeCookingItem;
    MainActivity activity;
    List<CookingItem> cookingItems;
    LinearLayout cookingOverview;
    List<Integer> cooking_burnChance;
    List<String> cooking_burnt;
    List<String> cooking_cooked;
    List<Long> cooking_exp;
    List<Integer> cooking_level;
    List<Integer> cooking_noBurnLevel;
    List<String> cooking_raw;
    long lastCookTime;
    int maxCookX;
    
    public Cooking(final MainActivity activity) {
        final Integer value = 0;
        this.cooking_raw = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Raw Shrimp", "Raw Snail", "Raw Carp", "Raw Minnows", "Milk", "Raw Perch", "Raw Crab", "Raw Lobster", "Raw Clownfish", "Raw Catfish", "Raw Jellyfish", "Raw Pufferfish", "Raw Marlin", "Raw Ray", "Raw Shark", "Raw Squid", "Raw Octopus", "Clownfish,Crab", "Ray,Perch", "Marlin,Pufferfish,Shrimp", "Bones,Milk,Bag of Flour", "Mushroom,Milk,Wine", "Grapes,Orange,Red Onion,Apple", "Crab,Milk,Wine", "Egg,Cherries,Bag of Flour", "Big Dragon Bones,Dragon Tail,Milk,Bag of Flour", "Pumpkin,Egg,Bag of Flour,Milk" }));
        this.cooking_cooked = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Shrimp", "Snail", "Carp", "Minnows", "Cheese", "Perch", "Crab", "Lobster", "Clownfish", "Catfish", "Jellyfish", "Pufferfish", "Marlin", "Ray", "Shark", "Squid", "Octopus", "Fish Wedge", "Fish Steak", "Fish Soup", "Bone Stew", "Mushroom Soup", "Fruit Salad", "Crab Soup", "Cherry Pie", "Dragon Platter", "Pumpkin Pie" }));
        this.cooking_burnt = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Burnt Shrimp", "Burnt Snail", "Burnt Carp", "Burnt Minnows", "Burnt Cheese", "Burnt Perch", "Burnt Crab", "Burnt Lobster", "Burnt Clownfish", "Burnt Catfish", "Burnt Jellyfish", "Burnt Pufferfish", "Burnt Marlin", "Burnt Ray", "Burnt Shark", "Burnt Squid", "Burnt Octopus", "Burnt Fish Wedge", "Burnt Fish Steak", "Burnt Fish Soup", "Burnt Bone Stew", "Burnt Mushroom Soup", "Burnt Fruit Salad", "Burnt Crab Soup", "Burnt Cherry Pie", "Burnt Dragon Platter", "Burnt Pumpkin Pie" }));
        this.cooking_level = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 1, 5, 10, 20, 25, 30, 40, 46, 50, 58, 65, 70, 75, 82, 86, 90, 95, 102, 105, 109, 114, 118, 120, 123, 126, 129, 130 }));
        this.cooking_exp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 5L, 10L, 15L, 30L, 40L, 60L, 80L, 100L, 130L, 170L, 220L, 280L, 320L, 400L, 500L, 700L, 900L, 1100L, 1250L, 1400L, 2000L, 2500L, 2800L, 3600L, 4100L, 4800L, 6000L }));
        this.cooking_burnChance = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 85, 90 }));
        this.cooking_noBurnLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 14, 18, 24, 36, 42, 46, 58, 64, 70, 78, 86, 92, 98, 106, 110, 114, 120, 128, value, value, value, value, value, value, value, value, value }));
        this.cookingItems = (List<CookingItem>)new ArrayList();
        this.activeCookingItem = null;
        this.lastCookTime = 0L;
        this.activity = activity;
    }
    
    private void CookItem() {
        if (this.activity.GetSkillLevel("Cooking") >= this.activeCookingItem.GetLevel()) {
            if (this.GotIngredients()) {
                for (final String s : this.activeCookingItem.GetRaw().split("\\s*,\\s*")) {
                    int intValue;
                    final int n = intValue = (int)this.activity.makeXAmounts.get(this.activity.kitchenMakeX);
                    if (this.activity.combatManager.equippedItems.contains((Object)"Chefs Hat") && (intValue = n) > 1) {
                        intValue = n - n / 4;
                    }
                    this.activity.RemoveItem(s, intValue);
                }
                boolean b = this.activeCookingItem.GetNoBurn() <= 0 || this.activity.GetSkillLevel("Cooking") < this.activeCookingItem.GetNoBurn();
                if (this.activity.combatManager.equippedItems.contains((Object)"Cooking Cape") || this.activity.combatManager.equippedItems.contains((Object)"Max Cape") || this.activity.combatManager.equippedItems.contains((Object)"Mini Max Cape") || this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") || this.activity.combatManager.equippedItems.contains((Object)"Chefs Hat") || this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") || this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                    b = false;
                }
                int getBurntAmount;
                int intValue2;
                if (b) {
                    getBurntAmount = this.GetBurntAmount((int)this.activity.makeXAmounts.get(this.activity.kitchenMakeX), this.activeCookingItem.GetBurnChance());
                    intValue2 = (int)this.activity.makeXAmounts.get(this.activity.kitchenMakeX) - getBurntAmount;
                }
                else {
                    intValue2 = (int)this.activity.makeXAmounts.get(this.activity.kitchenMakeX);
                    getBurntAmount = 0;
                }
                if (intValue2 > 0) {
                    int n2;
                    if (this.activity.combatManager.equippedItems.contains((Object)"Chefs Hat")) {
                        n2 = intValue2 * 2;
                    }
                    else {
                        n2 = intValue2;
                    }
                    int n3 = n2;
                    if (this.activity.combatManager.equippedItems.contains((Object)"Apron of Banshen")) {
                        n3 = n2 * 2;
                    }
                    int n4 = n3;
                    if (this.activity.baseTower.baseTowerLevel >= 58) {
                        n4 = n3;
                        if (this.activity.GetRandom(1, 100) <= 20) {
                            n4 = n3 * 2;
                        }
                    }
                    int n5 = n4;
                    if (this.activity.combatManager.equippedItems.contains((Object)"Benny")) {
                        n5 = n4;
                        if (this.activity.GetRandom(1, 100) <= 10) {
                            n5 = n4 * 2;
                        }
                    }
                    this.activity.GiveItem(this.activeCookingItem.GetCooked(), (long)n5, true);
                    this.activity.treasureHunts.CheckTreasureHunts("Cooking", this.activeCookingItem.GetCooked());
                    if (getBurntAmount > 0) {
                        this.activity.GiveItem(this.activeCookingItem.GetBurnt(), (long)getBurntAmount, false);
                    }
                }
                else {
                    this.activity.GiveItem(this.activeCookingItem.GetBurnt(), (long)getBurntAmount, true);
                }
                final MainActivity activity = this.activity;
                final long getExp = this.activeCookingItem.GetExp();
                final long n6 = intValue2;
                activity.GiveExp("Cooking", getExp * n6, (ProgressBar)null);
                final MainActivity activity2 = this.activity;
                activity2.ExpBar("Cooking", activity2.kitchenSkillProgress);
                this.UpdateCookingItem();
                this.activity.dailies.UpdateDailies("Cooking", this.activeCookingItem.GetCooked(), intValue2);
                final MainActivity activity3 = this.activity;
                activity3.fishCooked += n6;
                final MainActivity activity4 = this.activity;
                activity4.fishBurnt += getBurntAmount;
                this.activity.itemManager.CheckOnlineSecrets("Cooking", this.activeCookingItem.GetCooked());
                this.activity.secretPathway.CheckPathway("Cooking", this.activeCookingItem.GetCooked());
                if (this.activeCookingItem.GetCooked().equals((Object)"Fish Wedge")) {
                    this.activity.combatManager.CheckSecret("Mystic Bottoms", 2131166025, 20000);
                }
                if (this.activeCookingItem.GetCooked().equals((Object)"Dragon Platter")) {
                    this.activity.combatManager.CheckSecret("Ring of Death", 2131166152, 20000);
                }
            }
            else {
                this.activity.QuickPopup("You don't have the ingredients for this recipe.");
            }
        }
    }
    
    private boolean GotIngredients() {
        final String[] split = this.activeCookingItem.GetRaw().split("\\s*,\\s*");
        final int length = split.length;
        final boolean b = false;
        int i = 0;
        while (i < length) {
            final String s = split[i];
            boolean b2 = b;
            if (this.activity.inventoryItems.contains((Object)s)) {
                if ((long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)s)) >= (int)this.activity.makeXAmounts.get(this.activity.kitchenMakeX)) {
                    ++i;
                    continue;
                }
                b2 = b;
            }
            return b2;
        }
        return true;
    }
    
    private void UpdateCookingItem() {
        final TextView textView = (TextView)this.cookingOverview.getChildAt(3);
        final StringBuilder text = new StringBuilder();
        final String[] split = this.activeCookingItem.GetRaw().split("\\s*,\\s*");
        for (int i = 0; i < split.length; ++i) {
            long longValue;
            if (this.activity.inventoryItems.contains((Object)split[i])) {
                longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)split[i]));
            }
            else {
                longValue = 0L;
            }
            if (i > 0) {
                text.append("\n");
            }
            final MainActivity activity = this.activity;
            final MainActivity activity2 = this.activity;
            text.append(activity.getString(2131820615, new Object[] { longValue, activity2.FormatExp((long)(int)activity2.makeXAmounts.get(this.activity.kitchenMakeX)), split[i] }));
        }
        textView.setText((CharSequence)text);
        if (this.activity.GetSkillLevel("Cooking") >= this.activeCookingItem.GetLevel()) {
            final TextView textView2 = (TextView)this.cookingOverview.getChildAt(7);
            final StringBuilder sb = new StringBuilder("Cook ");
            final MainActivity activity3 = this.activity;
            textView2.setText((CharSequence)sb.append(activity3.FormatExp((long)(int)activity3.makeXAmounts.get(this.activity.kitchenMakeX))).toString());
            this.cookingOverview.getChildAt(7).setAlpha(1.0f);
        }
        else {
            this.cookingOverview.getChildAt(7).setAlpha(0.5f);
            ((TextView)this.cookingOverview.getChildAt(7)).setText((CharSequence)"Locked");
        }
    }
    
    public int GetBurntAmount(final int n, final int n2) {
        final double n3 = n2 / 100.0;
        final double n4 = n * n3;
        return Math.max(0, Math.min((int)Math.round(n4 + this.activity.randomGenerator.nextGaussian() * Math.sqrt((1.0 - n3) * n4)), n));
    }
    
    public void OpenKitchen() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.kitchenScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.EnableScreen();
        this.cookingOverview = (LinearLayout)this.activity.kitchenList.findViewById(2131296480);
        Log.e("Skipped: ", "Active Cooking item: " + (Object)this.activeCookingItem);
        if (this.activeCookingItem == null) {
            try {
                this.activeCookingItem = (CookingItem)this.cookingItems.get(0);
            }
            catch (final IndexOutOfBoundsException ex) {
                if (this.cookingItems.isEmpty()) {
                    this.Setup();
                }
                this.activeCookingItem = (CookingItem)this.cookingItems.get(0);
            }
        }
        this.activity.kitchenSpinner.setText((CharSequence)(this.activeCookingItem.GetCooked() + " (Level " + this.activeCookingItem.GetLevel() + ")"));
        final MainActivity activity4 = this.activity;
        activity4.ExpBar("Cooking", activity4.kitchenSkillProgress);
        if (this.activity.combatManager.equippedItems.contains((Object)"Oven Gloves")) {
            this.maxCookX = (int)this.activity.makeXAmounts.get(this.activity.makeXAmounts.size() - 1);
        }
        else {
            this.maxCookX = 100;
        }
        if ((int)this.activity.makeXAmounts.get(this.activity.kitchenMakeX) >= this.maxCookX) {
            this.activity.kitchenMakeX = 0;
        }
        final TextView kitchenMakeXButton = this.activity.kitchenMakeXButton;
        final StringBuilder sb = new StringBuilder("Cook ");
        final MainActivity activity5 = this.activity;
        kitchenMakeXButton.setText((CharSequence)sb.append(activity5.FormatExp((long)(int)activity5.makeXAmounts.get(this.activity.kitchenMakeX))).toString());
        this.activity.kitchenMakeXButton.setOnClickListener((View$OnClickListener)new Cooking$$ExternalSyntheticLambda1(this));
        this.SetCookingItem();
    }
    
    void SetCookingItem() {
        boolean b = this.activeCookingItem.GetNoBurn() <= 0 || this.activity.GetSkillLevel("Cooking") < this.activeCookingItem.GetNoBurn();
        if (this.activity.combatManager.equippedItems.contains((Object)"Cooking Cape") || this.activity.combatManager.equippedItems.contains((Object)"Max Cape") || this.activity.combatManager.equippedItems.contains((Object)"Mini Max Cape") || this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") || this.activity.combatManager.equippedItems.contains((Object)"Chefs Hat") || this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") || this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
            b = false;
        }
        int getBurnChance;
        if (!b) {
            getBurnChance = 0;
        }
        else {
            getBurnChance = this.activeCookingItem.GetBurnChance();
        }
        final ImageView imageView = (ImageView)this.cookingOverview.getChildAt(0);
        final MainActivity activity = this.activity;
        imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)this.activeCookingItem.GetCooked()))));
        ((TextView)this.cookingOverview.getChildAt(1)).setText((CharSequence)this.activeCookingItem.GetCooked());
        ((TextView)this.cookingOverview.getChildAt(2)).setText((CharSequence)("Level " + this.activeCookingItem.GetLevel()));
        ((TextView)this.cookingOverview.getChildAt(4)).setText((CharSequence)("Exp: " + this.activity.FormatExp(this.activeCookingItem.GetExp())));
        ((TextView)this.cookingOverview.getChildAt(5)).setText((CharSequence)("Burn Chance: " + getBurnChance + "%"));
        final MainActivity activity2 = this.activity;
        String formatExp = activity2.FormatExp((long)(int)activity2.allItemsHealingAmount.get(this.activity.allItems.indexOf((Object)this.activeCookingItem.GetCooked())));
        if (this.activeCookingItem.GetCooked().equals((Object)"Dragon Platter")) {
            formatExp = "50% of Max Health";
        }
        if (this.activeCookingItem.GetCooked().equals((Object)"Pumpkin Pie")) {
            formatExp = "100% of Max Health";
        }
        ((TextView)this.cookingOverview.getChildAt(6)).setText((CharSequence)("Healing Value: " + formatExp));
        final TextView textView = (TextView)this.cookingOverview.getChildAt(7);
        final StringBuilder sb = new StringBuilder("Cook ");
        final MainActivity activity3 = this.activity;
        textView.setText((CharSequence)sb.append(activity3.FormatExp((long)(int)activity3.makeXAmounts.get(this.activity.kitchenMakeX))).toString());
        this.cookingOverview.getChildAt(7).setOnClickListener((View$OnClickListener)new Cooking$$ExternalSyntheticLambda0(this));
        this.UpdateCookingItem();
    }
    
    public void Setup() {
        for (int i = 0; i < this.cooking_raw.size(); ++i) {
            this.cookingItems.add((Object)new CookingItem((String)this.cooking_raw.get(i), (String)this.cooking_cooked.get(i), (String)this.cooking_burnt.get(i), (int)this.cooking_level.get(i), (int)this.cooking_burnChance.get(i), (int)this.cooking_noBurnLevel.get(i), (long)this.cooking_exp.get(i)));
        }
    }
    
    public static class CookingItem
    {
        int burnChance;
        String burnt;
        String cooked;
        long exp;
        int level;
        int noBurn;
        String raw;
        
        public CookingItem(final String raw, final String cooked, final String burnt, final int level, final int burnChance, final int noBurn, final long exp) {
            this.raw = raw;
            this.cooked = cooked;
            this.burnt = burnt;
            this.level = level;
            this.burnChance = burnChance;
            this.noBurn = noBurn;
            this.exp = exp;
        }
        
        public int GetBurnChance() {
            return this.burnChance;
        }
        
        public String GetBurnt() {
            return this.burnt;
        }
        
        public String GetCooked() {
            return this.cooked;
        }
        
        public long GetExp() {
            return this.exp;
        }
        
        public int GetLevel() {
            return this.level;
        }
        
        public int GetNoBurn() {
            return this.noBurn;
        }
        
        public String GetRaw() {
            return this.raw;
        }
    }
}
