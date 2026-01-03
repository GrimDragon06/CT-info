package uk.playdrop.cherrytree_idletextrpg;

import java.util.function.Function;
import java.util.Comparator;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.RelativeLayout;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.os.CountDownTimer;
import android.widget.TextView;
import java.util.List;

public class Farming
{
    MainActivity activity;
    boolean autoPlant;
    List<String> farmCrop;
    List<TextView> farmCropProgress;
    List<Long> farmCropTimeRemaining;
    List<CountDownTimer> farmCropTimer;
    List<String> farmingSeeds;
    List<Long> farmingSeedsExp;
    List<Integer> farmingSeedsLevels;
    List<String> farmingSeedsReward;
    List<Long> farmingSeedsTimers;
    long lastScytheCheck;
    int planterIncrease;
    int planters;
    List<String> seedBag;
    List<Long> seedBagAmounts;
    List<Seed> seeds;
    
    public Farming(final MainActivity activity) {
        this.seedBag = (List<String>)new ArrayList();
        this.seedBagAmounts = (List<Long>)new ArrayList();
        this.farmingSeeds = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Tomato Seed", "Apple Seed", "Strawberry Seed", "Red Onion Seed", "Orange Seed", "Lemon Seed", "Cherries Seed", "Blueberry Seed", "Eggplant Seed", "Grapes Seed", "Evergreen Seed", "Oak Seed", "Pine Seed", "Maple Seed", "Birch Seed", "Spruce Seed", "Fir Seed", "Ash Seed", "Willow Seed", "Eucalyptus Seed", "Elder Seed", "Redwood Seed", "Cedar Seed", "Cherry Blossom Seed", "Mahogany Seed", "Chestnut Seed", "Magnolia Seed", "Ginkgo Seed", "Pumpkin Seed" }));
        this.farmingSeedsLevels = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 5, 15, 25, 35, 42, 52, 63, 69, 76, 85, 91, 96, 102, 110, 115, 121, 125, 129, 128 }));
        this.farmingSeedsTimers = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 300000L, 900000L, 1800000L, 3600000L, 7200000L, 10800000L, 14400000L, 18000000L, 36000000L, 86400000L, 1800000L, 3600000L, 7200000L, 14400000L, 21600000L, 28800000L, 36000000L, 43200000L, 50400000L, 57600000L, 64800000L, 72000000L, 79200000L, 86400000L, 93600000L, 100800000L, 108000000L, 115200000L, 172800000L }));
        this.farmingSeedsExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 15L, 60L, 125L, 280L, 600L, 950L, 1400L, 2500L, 6000L, 15000L, 120L, 300L, 800L, 1800L, 3000L, 5000L, 8000L, 12000L, 15000L, 18000L, 22000L, 28000L, 35000L, 40000L, 50000L, 60000L, 70000L, 85000L, 150000L }));
        this.farmingSeedsReward = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Tomato", "Apple", "Strawberry", "Red Onion", "Orange", "Lemon", "Cherries", "Blueberry", "Eggplant", "Grapes", "Evergreen Log", "Oak Log", "Pine Log", "Maple Log", "Birch Log", "Spruce Log", "Fir Log", "Ash Log", "Willow Log", "Eucalyptus Log", "Elder Log", "Redwood Log", "Cedar Log", "Cherry Blossom Log", "Mahogany Log", "Chestnut Log", "Magnolia Log", "Ginkgo Log", "Pumpkin" }));
        this.planters = 10;
        this.planterIncrease = 5;
        this.farmCrop = (List<String>)new ArrayList();
        this.farmCropTimer = (List<CountDownTimer>)new ArrayList();
        this.farmCropTimeRemaining = (List<Long>)new ArrayList();
        this.farmCropProgress = (List<TextView>)new ArrayList();
        this.seeds = (List<Seed>)new ArrayList();
        this.autoPlant = false;
        this.lastScytheCheck = 0L;
        this.activity = activity;
    }
    
    private int GetSeedIndex(final String s) {
        final int n = 0;
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n;
            if (n2 >= this.seeds.size()) {
                break;
            }
            if (((Seed)this.seeds.get(n2)).GetSeed().equals((Object)s)) {
                n3 = n2;
                break;
            }
            ++n2;
        }
        return n3;
    }
    
    private void PlantAllSeeds(final TextView textView) {
        for (int i = 0; i < this.activity.farmingSpots.size(); ++i) {
            if (this.farmCrop.get(i) == null) {
                if (!this.seedBag.contains((Object)this.activity.selectedCrop)) {
                    this.activity.QuickPopup("You ran out of seeds");
                    break;
                }
                if ((long)this.seedBagAmounts.get(this.seedBag.indexOf((Object)this.activity.selectedCrop)) <= 0L) {
                    this.activity.QuickPopup("You ran out of seeds");
                    break;
                }
                this.PlantCrop(this.activity.selectedCrop, i, (RelativeLayout)this.activity.farmingSpots.get(i), textView);
                final MainActivity activity = this.activity;
                activity.RemoveSeed(activity.selectedCrop, textView);
            }
        }
    }
    
    public void AddPlantButton(final RelativeLayout relativeLayout, final TextView textView, final int n) {
        final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
        textView2.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        textView2.setText((CharSequence)"Plant");
        textView2.setGravity(17);
        textView2.setTextColor(this.activity.white);
        final MainActivity activity = this.activity;
        activity.SetTextSize(textView2, activity.GetResource(2131100247));
        relativeLayout.addView((View)textView2);
        textView2.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda2(this, n, relativeLayout, textView));
    }
    
    public void CropSelect(final TextView textView) {
        this.activity.LoadItemSelect("Select a Seed");
        for (int i = 0; i < this.seedBag.size(); ++i) {
            final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
            relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099991)));
            relativeLayout.setBackground(this.activity.GetImage(2131165348));
            relativeLayout.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
            final ImageView imageView = new ImageView((Context)this.activity);
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.activity.GetResource(2131099769), this.activity.GetResource(2131099769));
            layoutParams.addRule(15);
            imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            final MainActivity activity = this.activity;
            imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf(this.seedBag.get(i)))));
            imageView.setAdjustViewBounds(true);
            relativeLayout.addView((View)imageView);
            final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -1);
            layoutParams2.leftMargin = this.activity.GetResource(2131099935);
            textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            textView2.setGravity(16);
            textView2.setText((CharSequence)this.activity.getString(2131820632, new Object[] { this.seedBag.get(i), this.activity.FormatExp((long)this.seedBagAmounts.get(i)), this.GrowthString(this.GetGrowthTime((String)this.seedBag.get(i))) }));
            final MainActivity activity2 = this.activity;
            activity2.SetTextSize(textView2, activity2.GetResource(2131099669));
            textView2.setTextColor(this.activity.GetColour(2131034225));
            relativeLayout.addView((View)textView2);
            this.activity.itemSelect_wrap.addView((View)relativeLayout);
            relativeLayout.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda6(this, i, textView));
        }
    }
    
    public void FarmingButtons(final TextView textView, final RelativeLayout relativeLayout) {
        final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880)));
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(3.0f);
        linearLayout.setGravity(17);
        final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        textView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -1, 0.9f));
        textView2.setText((CharSequence)"Plant All");
        textView2.setBackground(this.activity.GetImage(2131165348));
        final MainActivity activity = this.activity;
        activity.SetTextSize(textView2, activity.GetResource(2131099658));
        textView2.setTextColor(this.activity.GetColour(2131034924));
        textView2.setGravity(17);
        linearLayout.addView((View)textView2);
        final TextView textView3 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        textView3.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -1, 0.9f));
        textView3.setText((CharSequence)"Harvest All");
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView3, activity2.GetResource(2131099658));
        textView3.setBackground(this.activity.GetImage(2131165350));
        textView3.setTextColor(this.activity.GetColour(2131034924));
        textView3.setGravity(17);
        linearLayout.addView((View)textView3);
        final TextView textView4 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        textView4.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -1, 1.2f));
        if (this.autoPlant) {
            textView4.setText((CharSequence)"Auto Farming: On");
        }
        else {
            textView4.setText((CharSequence)"Auto Farming: Off");
        }
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize(textView4, activity3.GetResource(2131099658));
        textView4.setBackground(this.activity.GetImage(2131165350));
        textView4.setTextColor(this.activity.GetColour(2131034924));
        textView4.setGravity(17);
        linearLayout.addView((View)textView4);
        this.activity.genWrap.addView((View)linearLayout);
        textView2.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda3(this, textView));
        textView3.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda4(this, textView, relativeLayout));
        textView4.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda5(this, textView4));
    }
    
    public long GetGrowthTime(final String s) {
        final long longValue = (long)this.farmingSeedsTimers.get(this.farmingSeeds.indexOf((Object)s));
        Log.e("Farming Timer: ", "" + s + " time is " + longValue);
        final long n = longValue - longValue / 100L * this.activity.farmingTimer;
        long n2;
        if (!this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E)") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E2)") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E3)") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E4)")) {
            if (!this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E5)") && !this.activity.combatManager.equippedItems.contains((Object)"Golden Scythe")) {
                if (!this.activity.combatManager.equippedItems.contains((Object)"Scythe of Demeter")) {
                    n2 = n;
                    if (!this.activity.combatManager.equippedItems.contains((Object)"Ring of Demeter")) {
                        return n2;
                    }
                }
                n2 = Math.max(n / 100L * 20L, 30000L);
            }
            else {
                n2 = Math.max(n / 100L * 2L, 30000L);
            }
        }
        else {
            n2 = Math.max(n / 100L * 5L, 30000L);
        }
        return n2;
    }
    
    public String GrowthString(long n) {
        final long hours = TimeUnit.MILLISECONDS.toHours(n);
        final long n2 = TimeUnit.MILLISECONDS.toMinutes(n) % 60L;
        n = TimeUnit.MILLISECONDS.toSeconds(n) % 60L;
        final String format = String.format(Locale.UK, "%d", new Object[] { hours });
        final String format2 = String.format(Locale.UK, "%d", new Object[] { n2 });
        final String format3 = String.format(Locale.UK, "%d", new Object[] { n });
        final StringBuilder sb = new StringBuilder();
        if (hours > 0L) {
            sb.append(format).append(" Hours");
            if (n2 > 0L) {
                sb.append(" and ").append(format2).append(" Minutes");
            }
        }
        else if (n2 > 0L) {
            sb.append(format2).append(" Minutes");
            if (n > 0L) {
                sb.append(" and ").append(format3).append(" Seconds");
            }
        }
        else {
            sb.append(format3).append(" Seconds");
        }
        return sb.toString();
    }
    
    public void HarvestCrop(final RelativeLayout relativeLayout, final int n, final TextView textView) {
        if (this.activity.combatManager.equippedItems.contains((Object)"Golden Scythe")) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastScytheCheck > 30000L) {
                this.activity.GoldenTools("Golden Scythe");
                this.lastScytheCheck = currentTimeMillis;
            }
        }
        final int getSeedIndex = this.GetSeedIndex((String)this.farmCrop.get(n));
        if (this.activity.InventoryNotFull((String)this.farmingSeedsReward.get(this.farmingSeeds.indexOf(this.farmCrop.get(n))))) {
            if (this.activity.GetRandom(1, Math.max(360000 - (getSeedIndex + 1) * 15000, 100000)) <= 2) {
                this.activity.GiveItem("Scythe of Demeter", 1L, false);
                this.activity.LevelPopup(2131166190, "While Farming you find the Scythe of Demeter!");
            }
            long longValue;
            final long n2 = longValue = (long)this.farmingSeedsExp.get(this.farmingSeeds.indexOf(this.farmCrop.get(n)));
            if (this.activity.baseTower.baseTowerLevel >= 13) {
                longValue = n2 + n2 / 4L;
            }
            this.activity.GiveExp("Farming", longValue, (ProgressBar)null);
            int n3;
            if (((String)this.farmingSeedsReward.get(this.farmingSeeds.indexOf(this.farmCrop.get(n)))).contains((CharSequence)"Log")) {
                n3 = 5;
            }
            else {
                n3 = 1;
            }
            int n4 = n3;
            if (this.activity.combatManager.equippedItems.contains((Object)"Pinky")) {
                n4 = n3;
                if (this.activity.GetRandom(1, 100) <= 20) {
                    n4 = n3 * 2;
                }
            }
            int n5 = 0;
            Label_0401: {
                if (!this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial")) {
                    n5 = n4;
                    if (!this.activity.combatManager.equippedItems.contains((Object)"Golden Scythe")) {
                        break Label_0401;
                    }
                }
                n5 = n4 * 2;
            }
            int n6 = n5;
            if (this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E)")) {
                n6 = n5 * 4;
            }
            int n7 = n6;
            if (this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E2)")) {
                n7 = n6 * 5;
            }
            int n8 = n7;
            if (this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E3)")) {
                n8 = n7 * 6;
            }
            int n9 = n8;
            if (this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E4)")) {
                n9 = n8 * 7;
            }
            int n10 = n9;
            if (this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E5)")) {
                n10 = n9 * 10;
            }
            if (((String)this.farmingSeedsReward.get(this.farmingSeeds.indexOf(this.farmCrop.get(n)))).equals((Object)"Cherries")) {
                this.activity.combatManager.CheckSecret("Restoration Fragment 2", 2131166143, 25000);
            }
            if (((String)this.farmingSeedsReward.get(this.farmingSeeds.indexOf(this.farmCrop.get(n)))).equals((Object)"Elder Log")) {
                this.activity.combatManager.CheckSecret("Thieving Gloves", 2131166307, 150000);
            }
            this.activity.secretPathway.CheckPathway("Farming", (String)this.farmCrop.get(n));
            int n11 = n10;
            if (this.activity.premiumUpgradesPurchased.get(this.activity.premiumUpgrades.indexOf((Object)"Double Farming"))) {
                n11 = n10;
                if (this.activity.GetRandom(1, 100) <= 25) {
                    n11 = n10 * 2;
                }
            }
            int n12 = 0;
            Label_0906: {
                if (!this.activity.combatManager.equippedItems.contains((Object)"Farming Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Mini Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape")) {
                    n12 = n11;
                    if (!this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                        break Label_0906;
                    }
                }
                n12 = n11 * 2;
            }
            int n13 = n12;
            if (this.activity.baseTower.baseTowerLevel >= 8) {
                n13 = n12 * 2;
            }
            this.activity.itemManager.CheckOnlineSecrets("Farming", (String)this.farmCrop.get(n));
            this.activity.GiveItem((String)this.farmingSeedsReward.get(this.farmingSeeds.indexOf(this.farmCrop.get(n))), (long)n13, true);
            this.farmCropTimer.set(n, (Object)null);
            this.farmCropTimeRemaining.set(n, (Object)null);
            this.farmCrop.set(n, (Object)null);
            this.farmCropProgress.set(n, (Object)null);
            relativeLayout.removeAllViews();
            this.AddPlantButton(relativeLayout, textView, n);
            final MainActivity activity = this.activity;
            ++activity.cropsFarmed;
            if (this.autoPlant) {
                if (!this.activity.combatManager.equippedItems.contains((Object)"Magic Watering Can") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E)") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E2)") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E3)") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E4)") && !this.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E5)") && !this.activity.combatManager.equippedItems.contains((Object)"Golden Scythe")) {
                    this.autoPlant = false;
                }
                else if (!this.activity.selectedCrop.isEmpty()) {
                    if (this.seedBag.contains((Object)this.activity.selectedCrop) && (long)this.seedBagAmounts.get(this.seedBag.indexOf((Object)this.activity.selectedCrop)) > 0L) {
                        this.PlantCrop(this.activity.selectedCrop, n, relativeLayout, textView);
                        final MainActivity activity2 = this.activity;
                        activity2.RemoveSeed(activity2.selectedCrop, textView);
                    }
                }
                else {
                    this.autoPlant = false;
                }
            }
        }
        else {
            this.activity.QuickPopup("Inventory full");
        }
    }
    
    public void OpenFarm() {
        this.activity.LoadGenerations((String)null, (String)null);
        this.activity.farmingSpots.clear();
        final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this.activity, 2131493056, (ViewGroup)null);
        this.activity.genWrap.addView((View)relativeLayout);
        final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)relativeLayout.getLayoutParams();
        layoutParams.topMargin = this.activity.GetResource(2131100248);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.activity.ExpBar("Farming", relativeLayout);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        textView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099935)));
        if (this.activity.selectedCrop.isEmpty()) {
            textView.setText((CharSequence)"Click here to select a seed to plant");
        }
        else if (this.seedBag.contains((Object)this.activity.selectedCrop)) {
            final MainActivity activity = this.activity;
            textView.setText((CharSequence)activity.getString(2131820760, new Object[] { activity.selectedCrop, this.seedBagAmounts.get(this.seedBag.indexOf((Object)this.activity.selectedCrop)) }));
        }
        else {
            this.activity.selectedCrop = "";
            textView.setText((CharSequence)"Click here to select a seed to plant");
        }
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView, activity2.GetResource(2131099658));
        textView.setTextColor(this.activity.GetColour(2131034888));
        textView.setBackground(this.activity.GetImage(2131165346));
        textView.setGravity(17);
        this.activity.genWrap.addView((View)textView);
        textView.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda8(this, textView));
        this.FarmingButtons(textView, relativeLayout);
        final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
        textView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        textView2.setText((CharSequence)"You can buy more seeds from the Market Trader.\nThe Market Trader can also increase the amount of planting spaces you have.");
        textView2.setTextColor(this.activity.GetColour(2131034225));
        textView2.setGravity(17);
        textView2.setLineSpacing(0.0f, 1.3f);
        final MainActivity activity3 = this.activity;
        activity3.SetTextSize(textView2, activity3.GetResource(2131099658));
        textView2.setBackground(this.activity.GetImage(2131165348));
        textView2.setPadding(this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658));
        this.activity.genWrap.addView((View)textView2);
        final TextView textView3 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880));
        layoutParams2.setMargins(0, 0, 0, this.activity.GetResource(2131099658));
        textView3.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView3.setText((CharSequence)"Cancel All Crops");
        textView3.setBackground(this.activity.GetImage(2131165348));
        final MainActivity activity4 = this.activity;
        activity4.SetTextSize(textView3, activity4.GetResource(2131099658));
        textView3.setTextColor(this.activity.GetColour(2131034891));
        textView3.setGravity(17);
        this.activity.genWrap.addView((View)textView3);
        textView3.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda9(this, textView));
        final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, -2);
        layoutParams3.setMargins(0, -this.activity.GetResource(2131099658), 0, -this.activity.GetResource(2131099658));
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        boolean adjustViewBounds = true;
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658));
        this.activity.genWrap.addView((View)linearLayout);
        for (int i = 0; i < this.planters; ++i) {
            if (i % this.planterIncrease == 0) {
                final LinearLayout linearLayout2 = new LinearLayout((Context)this.activity);
                final LinearLayout$LayoutParams layoutParams4 = new LinearLayout$LayoutParams(-1, -2);
                if (i > 0) {
                    layoutParams4.setMargins(this.activity.GetResource(2131099658), this.activity.GetResource(2131100202), this.activity.GetResource(2131099658), 0);
                }
                else {
                    layoutParams4.setMargins(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
                }
                linearLayout2.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
                linearLayout2.setOrientation(0);
                linearLayout2.setWeightSum((float)this.planterIncrease);
                linearLayout2.setClipChildren(false);
                linearLayout2.setClipToPadding(false);
                linearLayout.addView((View)linearLayout2);
            }
            final RelativeLayout relativeLayout2 = new RelativeLayout((Context)this.activity);
            final LinearLayout$LayoutParams layoutParams5 = new LinearLayout$LayoutParams(0, -2, 1.0f);
            if (i % this.planterIncrease != 0) {
                layoutParams5.setMargins(this.activity.GetResource(2131100202), 0, 0, 0);
            }
            relativeLayout2.setLayoutParams((ViewGroup$LayoutParams)layoutParams5);
            relativeLayout2.setClipToPadding(false);
            relativeLayout2.setClipChildren(false);
            relativeLayout2.setBackground(this.activity.GetImage(2131165336));
            if (this.farmCrop.get(i) != null) {
                final ImageView imageView = new ImageView((Context)this.activity);
                imageView.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
                imageView.setAdjustViewBounds(adjustViewBounds);
                final MainActivity activity5 = this.activity;
                imageView.setImageDrawable(activity5.GetImage((int)activity5.allItemsIcons.get(this.activity.allItems.indexOf(this.farmCrop.get(i)))));
                imageView.setPadding(this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658));
                relativeLayout2.addView((View)imageView);
                final TextView textView4 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
                final RelativeLayout$LayoutParams layoutParams6 = new RelativeLayout$LayoutParams(-1, -2);
                layoutParams6.setMargins(this.activity.GetResource(2131099980), 0, this.activity.GetResource(2131099980), this.activity.GetResource(2131100091));
                layoutParams6.addRule(12);
                textView4.setLayoutParams((ViewGroup$LayoutParams)layoutParams6);
                textView4.setTextColor(this.activity.white);
                textView4.setGravity(17);
                final MainActivity activity6 = this.activity;
                activity6.SetTextSize(textView4, activity6.GetResource(2131100247));
                if ((long)this.farmCropTimeRemaining.get(i) > 0L) {
                    textView4.setText((CharSequence)this.activity.GetTime((long)this.farmCropTimeRemaining.get(i)));
                }
                else {
                    textView4.setText((CharSequence)"Ready");
                }
                relativeLayout2.addView((View)textView4);
                this.farmCropProgress.set(i, (Object)textView4);
                adjustViewBounds = true;
                imageView.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda10(this, i, relativeLayout2, textView, relativeLayout));
            }
            else {
                this.AddPlantButton(relativeLayout2, textView, i);
            }
            ((LinearLayout)linearLayout.getChildAt(linearLayout.getChildCount() - 1)).addView((View)relativeLayout2);
            this.activity.farmingSpots.add((Object)relativeLayout2);
            relativeLayout2.post((Runnable)new Farming$$ExternalSyntheticLambda1(this, relativeLayout2, i));
        }
    }
    
    public void PlantCrop(final String s, final int n, final RelativeLayout relativeLayout, final TextView textView) {
        final long getGrowthTime = this.GetGrowthTime(s);
        relativeLayout.removeViewAt(0);
        this.farmCrop.set(n, (Object)s);
        this.farmCropTimeRemaining.set(n, (Object)(getGrowthTime / 1000L));
        final ImageView imageView = new ImageView((Context)this.activity);
        imageView.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, -1));
        imageView.setAdjustViewBounds(true);
        final MainActivity activity = this.activity;
        imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s))));
        imageView.setPadding(this.activity.GetResource(2131099680), this.activity.GetResource(2131099680), this.activity.GetResource(2131099680), this.activity.GetResource(2131099680));
        relativeLayout.addView((View)imageView);
        imageView.setOnClickListener((View$OnClickListener)new Farming$$ExternalSyntheticLambda7(this, n, relativeLayout, textView));
        final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams.setMargins(this.activity.GetResource(2131099980), 0, this.activity.GetResource(2131099980), this.activity.GetResource(2131099869));
        layoutParams.addRule(12);
        textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        textView2.setTextColor(this.activity.white);
        textView2.setGravity(17);
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView2, activity2.GetResource(2131100247));
        relativeLayout.addView((View)textView2);
        this.farmCropProgress.set(n, (Object)textView2);
        final CountDownTimer countDownTimer = new CountDownTimer(this, getGrowthTime, 1000L, n, relativeLayout, textView) {
            final Farming this$0;
            final TextView val$cropSelect;
            final int val$index;
            final RelativeLayout val$planterSpot;
            
            public void onFinish() {
                this.this$0.farmCropTimeRemaining.set(this.val$index, (Object)0L);
                if (this.this$0.autoPlant) {
                    if (!this.this$0.activity.combatManager.equippedItems.contains((Object)"Magic Watering Can") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E2)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E3)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E4)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Scythe of Aurial (E5)") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Golden Scythe")) {
                        this.this$0.autoPlant = false;
                        if (this.this$0.farmCropProgress.get(this.val$index) != null && ((TextView)this.this$0.farmCropProgress.get(this.val$index)).isShown()) {
                            ((TextView)this.this$0.farmCropProgress.get(this.val$index)).setText((CharSequence)"Ready");
                        }
                    }
                    else {
                        this.this$0.HarvestCrop(this.val$planterSpot, this.val$index, this.val$cropSelect);
                    }
                }
                else if (this.this$0.farmCropProgress.get(this.val$index) != null && ((TextView)this.this$0.farmCropProgress.get(this.val$index)).isShown()) {
                    ((TextView)this.this$0.farmCropProgress.get(this.val$index)).setText((CharSequence)"Ready");
                }
            }
            
            public void onTick(final long n) {
                try {
                    this.this$0.farmCropTimeRemaining.set(this.val$index, (Object)n);
                    if (this.this$0.farmCropProgress.get(this.val$index) != null && ((TextView)this.this$0.farmCropProgress.get(this.val$index)).isShown()) {
                        ((TextView)this.this$0.farmCropProgress.get(this.val$index)).setText((CharSequence)this.this$0.activity.GetTime(n));
                    }
                }
                catch (final IndexOutOfBoundsException ex) {
                    this.this$0.activity.LogIt("Index out of bounds: " + (Object)ex);
                }
            }
        };
        countDownTimer.start();
        this.farmCropTimer.set(n, (Object)countDownTimer);
    }
    
    public void Setup() {
        for (int i = 0; i < this.farmingSeeds.size(); ++i) {
            this.seeds.add((Object)new Seed((int)this.farmingSeedsLevels.get(i), (String)this.farmingSeeds.get(i), (String)this.farmingSeedsReward.get(i), (long)this.farmingSeedsTimers.get(i), (long)this.farmingSeedsExp.get(i)));
        }
        this.seeds.sort(Comparator.comparing((Function)new Farming$$ExternalSyntheticLambda0()));
    }
    
    public void SortSeedBag() {
        while (this.seedBagAmounts.contains((Object)0L)) {
            final int index = this.seedBagAmounts.indexOf((Object)0L);
            this.seedBag.remove(index);
            this.seedBagAmounts.remove(index);
        }
    }
    
    public static class Seed
    {
        long exp;
        long growthTime;
        int levelRequirement;
        String loot;
        String seed;
        
        public Seed(final int levelRequirement, final String seed, final String loot, final long growthTime, final long exp) {
            this.levelRequirement = levelRequirement;
            this.exp = exp;
            this.growthTime = growthTime;
            this.seed = seed;
            this.loot = loot;
        }
        
        public int GetLevel() {
            return this.levelRequirement;
        }
        
        public String GetSeed() {
            return this.seed;
        }
    }
}
