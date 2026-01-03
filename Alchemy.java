package uk.playdrop.cherrytree_idletextrpg;

import android.os.CountDownTimer;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import android.view.ContextThemeWrapper;
import java.util.function.Function;
import java.util.Comparator;
import android.os.Bundle;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class Alchemy
{
    Potion activePotion;
    List<TextView> activePotionViews;
    List<String> activePotions;
    List<Long> activePotionsTimers;
    MainActivity activity;
    LinearLayout alchemyOverview;
    int cocktailCap;
    int cocktailsDrank;
    int drinkXEnergy;
    int[] energyPotionXAmounts;
    long lastBrewTime;
    List<String> noMultiples;
    List<Long> potionItemExp;
    List<Integer> potionItemLevel;
    List<String> potionItems;
    List<String> potionMaterials;
    List<String> potionMaterialsAmounts;
    List<Long> potionTimer;
    List<String> potionType;
    List<Potion> potions;
    
    public Alchemy(final MainActivity activity) {
        this.activePotions = (List<String>)new ArrayList();
        this.activePotionsTimers = (List<Long>)new ArrayList();
        this.activePotionViews = (List<TextView>)new ArrayList();
        final Integer value = 40;
        final Integer value2 = 45;
        this.potionItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Attack Potion", "Defence Potion", "Strength Potion", "Fishing Potion", "Forestry Potion", "Energy Potion", "Archery Potion", "Super Attack Potion", "Super Fishing Potion", "Explorers Potion", "Super Defence Potion", "Super Forestry Potion", "Power Potion", "Super Energy Potion", "Poison Potion", "Super Strength Potion", "Luck Potion", "Super Explorers Potion", "Extreme Energy Potion", "Super Archery Potion", "Lightning Potion", "Super Power Potion", "Extreme Fishing Potion", "Extreme Attack Potion", "Extreme Defence Potion", "Extreme Forestry Potion", "Mining Potion", "Extreme Strength Potion", "Thunderstorm Potion", "Extreme Explorers Potion", "Thieving Potion", "Ultimate Attack Potion", "Cyclone Potion", "Extreme Power Potion", "Ultimate Fishing Potion", "Insta Kill Potion", "Ultimate Defence Potion", "Avalanche Potion", "Extreme Archery Potion", "Ultimate Forestry Potion", "Rock Skin Potion", "Ultimate Explorers Potion", "Extreme Luck Potion", "Liquid Death Potion", "Cherry Bomb Potion", "Ultimate Strength Potion", "Elven Grace Potion", "Ultimate Power Potion", "Golden Touch Potion", "Invincibility Potion", "Summer Cocktail", "Divine Protection Potion", "Ultimate Archery Potion", "Soul Reaper Potion" }));
        this.potionMaterials = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Empty Vial,Akomeric,Birds Nest", "Empty Vial,Akomeric,Bones", "Empty Vial,Akomeric,Mushroom", "Empty Vial,Bloodroot,Fish Hook", "Empty Vial,Evergreen Log,Oak Log,Birds Nest", "Empty Vial,Bloodroot,Orange", "Empty Vial,Maple Bow,Copper Arrows,Iron Arrows", "Hyssop,Attack Potion,Pearl", "Hyssop,Fishing Potion,Jawbone", "Empty Vial,Energy Potion,Treasure Map", "Safflower,Defence Potion,Blue Feather", "Maple Log,Birch Log,Forestry Potion", "Attack Potion,Strength Potion,Defence Potion", "Safflower,Energy Potion,Compass,Lemon", "Empty Vial,Wolfmint,Dragon Ore", "Safflower,Strength Potion,Mushroom", "Empty Vial,Sage Leaf,Emerald", "Explorers Potion,Luck Potion,Coins", "Sage Leaf,Super Energy Potion,Treasure Map,Eggplant", "Archery Potion,Redwood Bow,Dragon Arrows,Platinum Arrows", "Empty Vial,Sunburst Flower,Golden Scarab", "Super Attack Potion,Super Strength Potion,Super Defence Potion,Wolfmint", "Super Fishing Potion,Raw Pufferfish,Message in a Bottle", "Wolfmint,Super Attack Potion,Marlin", "Wolfmint,Super Defence Potion,Ray", "Fir Log,Ash Log,Willow Log,Super Forestry Potion", "Empty Vial,Wolfmint,Ruby", "Wolfmint,Super Strength Potion,Shark", "Empty Vial,Ember Fern,Tooth Necklace", "Super Explorers Potion,Extreme Energy Potion,Stone Tablet,Gold Coin", "Empty Vial,Vissinel,Blue Silk", "Super Attack Potion,Extreme Attack Potion,Squid", "Empty Vial,Ember Fern,Dragon Scimitar", "Extreme Attack Potion,Extreme Strength Potion,Extreme Defence Potion,Sunburst Flower", "Extreme Fishing Potion,Raw Shark,Pirates Hat", "Empty Vial,Sunburst Flower,Blueprints,Coins", "Super Defence Potion,Extreme Defence Potion,Fish Wedge", "Elven Crystal,Book of Aroon,Ember Fern,Coins", "Super Archery Potion,Queens Bow,Rhodium Arrows,Iridium Arrows", "Elder Log,Redwood Log,Cedar Log,Extreme Forestry Potion", "Empty Vial,Sunburst Flower,Dragon Ore,Dragon Leather,Coins", "Extreme Explorers Potion,Extreme Energy Potion,Treasure Map,Gold Coin", "Sunburst Flower,Luck Potion", "Sunburst Flower,Insta Kill Potion,Stone Tablet,Coins", "Avalanche Potion,Cyclone Potion,Liquid Death Potion,Cherries,Gold Coin", "Super Strength Potion,Extreme Strength Potion,Thunderstorm Potion", "Elven Crystal,Stone Tablet,Ember Fern,Coins", "Ultimate Attack Potion,Ultimate Strength Potion,Ultimate Defence Potion,Dragon Skull", "Empty Vial,Pirates Hat,Treasure Map,Ember Fern,Coins", "Rock Skin Potion,Ember Fern,Stone Tablet", "Liquid Death Potion,Wine,Orange,Lemon,Gold Coin", "Gold Coin,Elven Armour Fragment,Kings Armour Fragment,Ember Fern", "Extreme Archery Potion,Elven Bow,Queens Arrows,Kings Arrows", "Liquid Death Potion,Gold Coin,Dark Thread,Stone Tablet" }));
        this.potionItemLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 1, 5, 10, 18, 20, 32, 35, 38, value, value, value2, value2, 48, 52, 55, 57, 65, 65, 70, 70, 70, 73, 75, 76, 80, 80, 82, 85, 87, 90, 94, 95, 95, 96, 98, 99, 103, 103, 104, 105, 106, 108, 109, 109, 113, 117, 123, 125, 127, 129, 130, 132, 134, 135 }));
        final Long value3 = 30000L;
        this.potionItemExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 18L, 30L, 45L, 90L, 100L, 160L, 180L, 200L, 240L, 240L, 300L, 300L, 325L, 350L, 360L, 380L, 450L, 450L, 500L, 550L, 550L, 540L, 600L, 625L, 700L, 700L, 850L, 1000L, 1250L, 1600L, 1800L, 1900L, 1950L, 2000L, 2250L, 2500L, 2900L, 2900L, 3100L, 3250L, 3500L, 3700L, 4000L, 4000L, 5000L, 6000L, 7000L, 7500L, 8000L, 10000L, 12000L, 25000L, value3, 50000L }));
        this.potionMaterialsAmounts = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "1,1,1", "1,1,5", "1,1,5", "1,1,1", "1,20,20,10", "1,1,5", "1,1,25,25", "1,1,5", "1,1,5", "1,10,5", "1,1,10", "25,25,5", "1,1,1", "1,1,1,10", "1,1,2", "1,1,3", "1,1,1", "1,5,25000", "1,1,1,10", "1,1,40,40", "1,1,2", "1,1,1,1", "1,10,10", "1,1,5", "1,1,5", "40,40,40,10", "1,1,4", "1,1,5", "1,1,1", "1,10,5,750", "1,1,2", "5,1,25", "1,1,1", "1,1,1,1", "1,25,20", "1,1,1,10000", "5,1,25", "1,1,3,75000", "1,1,50,50", "75,75,75,10", "1,1,5,5,5000", "1,25,25,1500", "3,3", "2,2,2,30000", "10,10,10,250,1000", "5,1,5", "1,5,3,50000", "1,1,1,5", "1,1,1,1,25000", "1,2,5", "25,25,250,250,10000", "1500,1,1,5", "1,1,50,50", "25,7500,50,50" }));
        this.potionType = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Attack", "Defence", "Strength", "Fishing", "Forestry", "null", "Archery", "Attack", "Fishing", "Explorers", "Defence", "Forestry", "Power", "null", "Damage", "Strength", "Luck", "Explorers", "null", "Archery", "Damage", "Power", "Fishing", "Attack", "Defence", "Forestry", "Mining", "Strength", "Damage", "Explorers", "Thieving", "Attack", "Damage", "Power", "Fishing", "null", "Defence", "Damage", "Archery", "Forestry", "null", "Explorers", "Luck", "null", "Damage", "Strength", "null", "Power", "null", "null", "Instant Kill", "Damage", "Archery", "null" }));
        final Long value4 = 60000L;
        this.potionTimer = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value4, value4, value4, value4, value4, 0L, value4, value4, value4, value3, value4, value4, value4, 0L, value3, value4, value4, value3, 0L, value4, value3, value4, value4, value4, value4, value4, value4, value4, value3, value3, value4, value4, value3, value4, value4, value4, value4, value3, value4, value4, value4, value3, value4, value4, 45000L, value4, value4, value4, value4, value4, 10000L, value4, value4, 20000L }));
        this.potions = (List<Potion>)new ArrayList();
        this.activePotion = null;
        this.noMultiples = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Golden Touch Potion", "Invincibility Potion", "Avalanche Potion", "Divine Protection Potion", "Soul Reaper Potion", "Summer Cocktail", "Cherry Bomb Potion" }));
        this.lastBrewTime = 0L;
        this.drinkXEnergy = 0;
        this.energyPotionXAmounts = new int[] { 1, 10, 100, 1000, 10000, 50000, 100000 };
        this.cocktailCap = 300;
        this.cocktailsDrank = 0;
        this.activity = activity;
    }
    
    private void UseEnergyPotion(final String s, final long n) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n2 = -1;
        switch (hashCode) {
            case 1272251799: {
                if (!s.equals((Object)"Extreme Energy Potion")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case 408906278: {
                if (!s.equals((Object)"Super Energy Potion")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case 187249195: {
                if (!s.equals((Object)"Energy Potion")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        long n3 = 5L;
        switch (n2) {
            case 2: {
                if (this.activity.baseTower.baseTowerLevel >= 67) {
                    n3 = 150L;
                    break;
                }
                n3 = 75L;
                break;
            }
            case 1: {
                if (this.activity.baseTower.baseTowerLevel >= 67) {
                    n3 = 50L;
                    break;
                }
                n3 = 25L;
                break;
            }
            case 0: {
                if (this.activity.baseTower.baseTowerLevel >= 67) {
                    n3 = 10L;
                    break;
                }
                break;
            }
        }
        final MainActivity activity = this.activity;
        activity.currentStamina += (int)(n3 * n);
        if (this.activity.discovery.discoveryArea != null && this.activity.discovery.discoveryArea.isShown()) {
            this.activity.discovery.UpdateEnergy();
        }
        if (this.activity.discovery.singleMazeScreen != null && this.activity.discovery.singleMazeScreen.isShown()) {
            final TextView currentEnergy = this.activity.discovery.currentEnergy;
            final StringBuilder sb = new StringBuilder("Current Energy: ");
            final MainActivity activity2 = this.activity;
            currentEnergy.setText((CharSequence)sb.append(activity2.FormatExp((long)activity2.currentStamina)).toString());
        }
    }
    
    public boolean AlreadyActive(final Potion potion) {
        boolean contains;
        final boolean b = contains = this.activePotions.contains((Object)potion.GetItem());
        if (!b) {
            contains = b;
            if (!this.activePotions.isEmpty()) {
                int n = 0;
                while (true) {
                    contains = b;
                    if (n >= this.activePotions.size()) {
                        return contains;
                    }
                    if (((String)this.potionType.get(this.potionItems.indexOf(this.activePotions.get(n)))).equals((Object)potion.GetType()) && !potion.GetType().equals((Object)"null")) {
                        break;
                    }
                    if ((potion.GetType().equals((Object)"Attack") || potion.GetType().equals((Object)"Strength") || potion.GetType().equals((Object)"Defence")) && ((String)this.potionType.get(this.potionItems.indexOf(this.activePotions.get(n)))).equals((Object)"Power")) {
                        break;
                    }
                    if (potion.GetType().equals((Object)"Power")) {
                        if (((String)this.potionType.get(this.potionItems.indexOf(this.activePotions.get(n)))).equals((Object)"Attack") || ((String)this.potionType.get(this.potionItems.indexOf(this.activePotions.get(n)))).equals((Object)"Strength")) {
                            break;
                        }
                        if (((String)this.potionType.get(this.potionItems.indexOf(this.activePotions.get(n)))).equals((Object)"Defence")) {
                            break;
                        }
                    }
                    if (potion.GetItem().equals((Object)"Insta Kill Potion") && ((String)this.activePotions.get(n)).equals((Object)"Liquid Death Potion")) {
                        break;
                    }
                    if (potion.GetItem().equals((Object)"Liquid Death Potion") && ((String)this.activePotions.get(n)).equals((Object)"Insta Kill Potion")) {
                        break;
                    }
                    ++n;
                }
                contains = true;
            }
        }
        return contains;
    }
    
    public boolean CheckPotionItems() {
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])this.activePotion.GetMats().split("\\s*,\\s*")));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])this.activePotion.GetAmounts().split("\\s*,\\s*")));
        final boolean b = false;
        int n = 0;
        boolean b2 = false;
    Label_0521:
        while (true) {
            final int size = ((List)list).size();
            int n2 = 1;
            if (n >= size) {
                b2 = true;
                break;
            }
            final String s = (String)((List)list).get(n);
            s.hashCode();
            Label_0182: {
                switch (s.hashCode()) {
                    case 658894417: {
                        if (!s.equals((Object)"Gold Coin")) {
                            break;
                        }
                        n2 = 2;
                        break Label_0182;
                    }
                    case 65287138: {
                        if (!s.equals((Object)"Coins")) {
                            break;
                        }
                        break Label_0182;
                    }
                    case -1070077452: {
                        if (!s.equals((Object)"Dark Thread")) {
                            break;
                        }
                        n2 = 0;
                        break Label_0182;
                    }
                }
                n2 = -1;
            }
            switch (n2) {
                default: {
                    b2 = b;
                    if (!this.activity.inventoryItems.contains(((List)list).get(n))) {
                        break Label_0521;
                    }
                    if ((long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list).get(n))) < Integer.parseInt((String)((List)list2).get(n)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX)) {
                        b2 = b;
                        break Label_0521;
                    }
                    break;
                }
                case 2: {
                    if (this.activity.totalGems < Integer.parseInt((String)((List)list2).get(n)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX)) {
                        b2 = b;
                        break Label_0521;
                    }
                    break;
                }
                case 1: {
                    if (this.activity.totalCoins < Integer.parseInt((String)((List)list2).get(n)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX)) {
                        b2 = b;
                        break Label_0521;
                    }
                    break;
                }
                case 0: {
                    if (this.activity.combatManager.slayerInfo.getDarkThread() < Integer.parseInt((String)((List)list2).get(n)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX)) {
                        b2 = b;
                        break Label_0521;
                    }
                    break;
                }
            }
            ++n;
        }
        return b2;
    }
    
    public void CreatePotion() {
        if (this.CheckPotionItems()) {
            if (this.activity.InventoryNotFull(this.activePotion.GetItem())) {
                final long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lastBrewTime < 10L) {
                    this.activity.QuickPopup("You are clicking too fast, slow down.");
                }
                else {
                    this.lastBrewTime = currentTimeMillis;
                    final int intValue = (int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX);
                    final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])this.activePotion.GetMats().split("\\s*,\\s*")));
                    final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])this.activePotion.GetAmounts().split("\\s*,\\s*")));
                    int n2;
                    int n = n2 = intValue;
                    int n3;
                    int n4;
                    for (int i = 0; i < intValue; ++i, n = n3, n2 = n4) {
                        n3 = n;
                        if (!this.noMultiples.contains((Object)this.activePotion.GetItem())) {
                            n3 = n;
                            if (this.activity.GetRandom(1, 100) <= this.activity.doublePotions) {
                                n3 = n + 1;
                            }
                        }
                        n4 = n2;
                        if (this.activity.GetRandom(1, 100) < this.activity.resourceSave) {
                            n4 = n2 - 1;
                        }
                    }
                    int n5 = n;
                    if (!this.noMultiples.contains((Object)this.activePotion.GetItem())) {
                        int n6 = 0;
                        Label_0393: {
                            if (!this.activity.combatManager.equippedItems.contains((Object)"Alchemy Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Mini Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape")) {
                                n6 = n;
                                if (!this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                                    break Label_0393;
                                }
                            }
                            n6 = n * 2;
                        }
                        int n7 = n6;
                        if (this.activity.baseTower.baseTowerLevel >= 3) {
                            n7 = n6 * 2;
                        }
                        n5 = n7;
                        if (this.activity.combatManager.equippedItems.contains((Object)"Casper")) {
                            n5 = n7;
                            if (this.activity.GetRandom(1, 100) <= 10) {
                                n5 = n7 * 2;
                            }
                        }
                    }
                    for (int j = 0; j < ((List)list).size(); ++j) {
                        final String s = (String)((List)list).get(j);
                        s.hashCode();
                        final int hashCode = s.hashCode();
                        int n8 = -1;
                        switch (hashCode) {
                            case 658894417: {
                                if (!s.equals((Object)"Gold Coin")) {
                                    break;
                                }
                                n8 = 2;
                                break;
                            }
                            case 65287138: {
                                if (!s.equals((Object)"Coins")) {
                                    break;
                                }
                                n8 = 1;
                                break;
                            }
                            case -1070077452: {
                                if (!s.equals((Object)"Dark Thread")) {
                                    break;
                                }
                                n8 = 0;
                                break;
                            }
                        }
                        switch (n8) {
                            default: {
                                this.activity.RemoveItem((String)((List)list).get(j), Integer.parseInt((String)((List)list2).get(j)) * n2);
                                break;
                            }
                            case 2: {
                                final MainActivity activity = this.activity;
                                activity.totalGems -= Integer.parseInt((String)((List)list2).get(j)) * (long)n2;
                                break;
                            }
                            case 1: {
                                final MainActivity activity2 = this.activity;
                                activity2.totalCoins -= Integer.parseInt((String)((List)list2).get(j)) * (long)n2;
                                break;
                            }
                            case 0: {
                                final CombatManager.SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                                slayerInfo.darkThread -= Integer.parseInt((String)((List)list2).get(j)) * (long)n2;
                                break;
                            }
                        }
                    }
                    final MainActivity activity3 = this.activity;
                    final String getItem = this.activePotion.GetItem();
                    final long n9 = n5;
                    activity3.GiveItem(getItem, n9, true);
                    this.activity.treasureHunts.CheckTreasureHunts("Alchemy", this.activePotion.GetItem());
                    this.activity.secretPathway.CheckPathway("Alchemy", this.activePotion.GetItem());
                    this.activity.dailies.UpdateDailies("Alchemy", this.activePotion.GetItem(), n5);
                    final MainActivity activity4 = this.activity;
                    activity4.potionsMade += n9;
                    this.activity.GiveExp("Alchemy", this.activePotion.GetExp() * n9, (ProgressBar)null);
                    if (this.activePotion.GetItem().equals((Object)"Soul Reaper Potion") || this.activePotion.GetItem().equals((Object)"Divine Protection Potion")) {
                        this.LogPotion(this.activePotion.GetItem(), n5);
                    }
                    final MainActivity activity5 = this.activity;
                    activity5.ExpBar("Alchemy", activity5.alchemySkillProgress);
                    this.UpdatePotion();
                    this.activity.UpdateCash();
                    if (this.activePotion.GetItem().equals((Object)"Super Defence Potion")) {
                        this.activity.combatManager.CheckSecret("Cauldron", 2131165671, 7000);
                    }
                    if (this.activePotion.GetItem().equals((Object)"Power Potion")) {
                        this.activity.combatManager.CheckSecret("Power Stone", 2131166081, 1000);
                    }
                    if (this.activePotion.GetItem().equals((Object)"Thieving Potion")) {
                        this.activity.combatManager.CheckSecret("Mystic Gloves", 2131166027, 15000);
                    }
                }
            }
            else {
                this.activity.QuickPopup("Inventory full");
            }
        }
        else {
            this.activity.QuickPopup("You don't have the required ingredients.");
        }
    }
    
    public void GeneratePotion() {
        final int index = this.activity.allItems.indexOf((Object)this.activePotion.GetItem());
        final ImageView imageView = (ImageView)this.alchemyOverview.getChildAt(0);
        final MainActivity activity = this.activity;
        imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(index)));
        ((TextView)this.alchemyOverview.getChildAt(1)).setText((CharSequence)this.activePotion.GetItem());
        ((TextView)this.alchemyOverview.getChildAt(2)).setText((CharSequence)("Level " + this.activePotion.GetLevel()));
        String string;
        final String s = string = (String)this.activity.allItemsDescriptions.get(index);
        if (this.noMultiples.contains((Object)this.activePotion.GetItem())) {
            string = s + "\nNote: This potion is unaffected by any resource saving or multiplying bonuses.";
        }
        ((TextView)this.alchemyOverview.getChildAt(3)).setText((CharSequence)string);
        ((TextView)this.alchemyOverview.getChildAt(5)).setText((CharSequence)("Exp: " + this.activity.FormatExp(this.activePotion.GetExp())));
        this.alchemyOverview.getChildAt(6).setOnClickListener((View$OnClickListener)new Alchemy$$ExternalSyntheticLambda0(this));
        this.UpdatePotion();
    }
    
    public void LogPotion(final String s, final int n) {
        final Bundle bundle = new Bundle();
        bundle.putLong("amount", (long)n);
        this.activity.firebaseAnalytics.logEvent(s, bundle);
    }
    
    public void OpenApothocary() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.apothocaryScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        final MainActivity activity4 = this.activity;
        activity4.ExpBar("Alchemy", activity4.alchemySkillProgress);
        this.activity.EnableScreen();
        this.alchemyOverview = (LinearLayout)this.activity.alchemyList.findViewById(2131296335);
        if (this.potions.isEmpty()) {
            this.Setup();
        }
        if (this.activePotion == null) {
            this.activePotion = (Potion)this.potions.get(0);
        }
        this.activity.alchemySpinner.setText((CharSequence)(this.activePotion.GetItem() + " (Level " + this.activePotion.GetLevel() + ")"));
        this.activity.alchemyMakeXButton.setText((CharSequence)("Brew " + this.activity.makeXAmounts.get(this.activity.alchemyMakeX)));
        this.activity.alchemyMakeXButton.setOnClickListener((View$OnClickListener)new Alchemy$$ExternalSyntheticLambda5(this));
        this.GeneratePotion();
    }
    
    public int PotionDamage(final Potion potion) {
        final String getItem = potion.GetItem();
        getItem.hashCode();
        final int hashCode = getItem.hashCode();
        final int n = 0;
        int n2 = -1;
        switch (hashCode) {
            case 1809597804: {
                if (!getItem.equals((Object)"Cyclone Potion")) {
                    break;
                }
                n2 = 6;
                break;
            }
            case -314263575: {
                if (!getItem.equals((Object)"Lightning Potion")) {
                    break;
                }
                n2 = 5;
                break;
            }
            case -535105302: {
                if (!getItem.equals((Object)"Cherry Bomb Potion")) {
                    break;
                }
                n2 = 4;
                break;
            }
            case -750244978: {
                if (!getItem.equals((Object)"Thunderstorm Potion")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case -976296533: {
                if (!getItem.equals((Object)"Poison Potion")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case -1514597280: {
                if (!getItem.equals((Object)"Avalanche Potion")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -1795291991: {
                if (!getItem.equals((Object)"Divine Protection Potion")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        int n3 = 100;
        int n5;
        final int n4 = n5 = 50000;
        int max = 0;
        switch (n2) {
            default: {
                n5 = n4;
                max = n;
                break;
            }
            case 6: {
                max = 200;
                n5 = n4;
                break;
            }
            case 5: {
                max = 50;
                n5 = n4;
                break;
            }
            case 4: {
                if (this.activity.combatManager.shadowRealm) {
                    n3 = Math.max(this.activity.enemyMaxHealth / 100, 2);
                }
                else {
                    n3 = Math.max(this.activity.enemyMaxHealth / 20, 2);
                }
                n5 = 60000;
            }
            case 3: {
                max = n3;
                break;
            }
            case 2: {
                max = 25;
                n5 = n4;
                break;
            }
            case 1: {
                max = 2000;
                n5 = n4;
                break;
            }
            case 0: {
                max = Math.max(this.activity.enemyMaxHealth / 100, 2);
                n5 = n4;
                break;
            }
        }
        return Math.min(max, n5);
    }
    
    public void SetPotion(final Potion potion, final String s) {
        final boolean equals = s.equals((Object)"Use");
        final int n = 1;
        if (equals) {
            int n2;
            if (this.activity.baseTower.baseTowerLevel >= 63 && this.activity.GetRandom(1, 100) <= 25) {
                n2 = 0;
            }
            else {
                n2 = 1;
            }
            String s2 = null;
            Label_0113: {
                if (n2 != 0) {
                    final List<String> equippedItems = this.activity.combatManager.equippedItems;
                    s2 = "Pumpkin Cauldron";
                    if (equippedItems.contains((Object)"Pumpkin Cauldron") && this.activity.GetRandom(1, 100) <= 10) {
                        n2 = 0;
                        break Label_0113;
                    }
                }
                s2 = "Base Camp";
            }
            if (n2 != 0) {
                this.activity.RemoveItem(potion.GetItem(), 1);
            }
            else {
                this.activity.QuickPopup("Your " + s2 + " saves your Potion!");
            }
            this.activity.UpdateBottomNav();
            if (this.activity.inventoryScreen.isShown()) {
                this.activity.itemManager.UpdateInventory();
            }
        }
        final String getItem = potion.GetItem();
        getItem.hashCode();
        int n3 = 0;
        Label_0403: {
            switch (getItem.hashCode()) {
                case 1436746416: {
                    if (!getItem.equals((Object)"Insta Kill Potion")) {
                        break;
                    }
                    n3 = 6;
                    break Label_0403;
                }
                case 1272251799: {
                    if (!getItem.equals((Object)"Extreme Energy Potion")) {
                        break;
                    }
                    n3 = 5;
                    break Label_0403;
                }
                case 778749251: {
                    if (!getItem.equals((Object)"Liquid Death Potion")) {
                        break;
                    }
                    n3 = 4;
                    break Label_0403;
                }
                case 408906278: {
                    if (!getItem.equals((Object)"Super Energy Potion")) {
                        break;
                    }
                    n3 = 3;
                    break Label_0403;
                }
                case 187249195: {
                    if (!getItem.equals((Object)"Energy Potion")) {
                        break;
                    }
                    n3 = 2;
                    break Label_0403;
                }
                case 147443534: {
                    n3 = n;
                    if (!getItem.equals((Object)"Extreme Luck Potion")) {
                        break;
                    }
                    break Label_0403;
                }
                case -962064158: {
                    if (!getItem.equals((Object)"Luck Potion")) {
                        break;
                    }
                    n3 = 0;
                    break Label_0403;
                }
            }
            n3 = -1;
        }
        switch (n3) {
            case 6: {
                if (s.equals((Object)"Use")) {
                    this.activity.instakillchance = 5;
                    break;
                }
                this.activity.instakillchance = 0;
                break;
            }
            case 4: {
                if (s.equals((Object)"Use")) {
                    this.activity.instakillchance = 10;
                    break;
                }
                this.activity.instakillchance = 0;
                break;
            }
            case 2:
            case 3:
            case 5: {
                this.UseEnergyPotion(potion.GetItem(), 1L);
                break;
            }
            case 1: {
                if (s.equals((Object)"Use")) {
                    final MainActivity activity = this.activity;
                    activity.rareChanceBoost += this.activity.rareChance * 2.0f;
                    final MainActivity activity2 = this.activity;
                    activity2.superRareChanceBoost += this.activity.superRareChance * 2.0f;
                    final MainActivity activity3 = this.activity;
                    activity3.legendaryChanceBoost += this.activity.legendaryChance * 2.0f;
                    final MainActivity activity4 = this.activity;
                    activity4.mythicalChanceBoost += this.activity.mythicalChance * 2.0f;
                    final MainActivity activity5 = this.activity;
                    activity5.secretChanceBoost += this.activity.secretChance * 2.0f;
                    break;
                }
                this.activity.rareChanceBoost = 0.0f;
                this.activity.superRareChanceBoost = 0.0f;
                this.activity.legendaryChanceBoost = 0.0f;
                this.activity.mythicalChanceBoost = 0.0f;
                this.activity.secretChanceBoost = 0.0f;
                break;
            }
            case 0: {
                if (s.equals((Object)"Use")) {
                    final MainActivity activity6 = this.activity;
                    activity6.rareChanceBoost += this.activity.rareChance;
                    final MainActivity activity7 = this.activity;
                    activity7.superRareChanceBoost += this.activity.superRareChance;
                    final MainActivity activity8 = this.activity;
                    activity8.legendaryChanceBoost += this.activity.legendaryChance;
                    final MainActivity activity9 = this.activity;
                    activity9.mythicalChanceBoost += this.activity.mythicalChance;
                    final MainActivity activity10 = this.activity;
                    activity10.secretChanceBoost += this.activity.secretChance;
                    break;
                }
                this.activity.rareChanceBoost = 0.0f;
                this.activity.superRareChanceBoost = 0.0f;
                this.activity.legendaryChanceBoost = 0.0f;
                this.activity.mythicalChanceBoost = 0.0f;
                this.activity.secretChanceBoost = 0.0f;
                break;
            }
        }
    }
    
    public void Setup() {
        for (int i = 0; i < this.potionItems.size(); ++i) {
            this.potions.add((Object)new Potion((int)this.potionItemLevel.get(i), (String)this.potionItems.get(i), (String)this.potionMaterials.get(i), (long)this.potionItemExp.get(i), (String)this.potionMaterialsAmounts.get(i), (String)this.potionType.get(i), (long)this.potionTimer.get(i)));
        }
        this.potions.sort(Comparator.comparing((Function)new Alchemy$$ExternalSyntheticLambda4()));
    }
    
    public void UpdatePotion() {
        final TextView textView = (TextView)this.alchemyOverview.getChildAt(4);
        final StringBuilder sb = new StringBuilder();
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])this.activePotion.GetMats().split("\\s*,\\s*")));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])this.activePotion.GetAmounts().split("\\s*,\\s*")));
        for (int i = 0; i < ((List)list).size(); ++i) {
            if (i > 0) {
                sb.append("\n");
            }
            final String s = (String)((List)list).get(i);
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
                case 65287138: {
                    if (!s.equals((Object)"Coins")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -1070077452: {
                    if (!s.equals((Object)"Dark Thread")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    long longValue;
                    if (this.activity.inventoryItems.contains(((List)list).get(i))) {
                        longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list).get(i)));
                    }
                    else {
                        longValue = 0L;
                    }
                    sb.append(this.activity.getString(2131820615, new Object[] { longValue, this.activity.FormatExp(Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX)), ((List)list).get(i) }));
                    break;
                }
                case 2: {
                    final MainActivity activity = this.activity;
                    sb.append(activity.FormatCoins(activity.totalGems)).append(" / ").append(this.activity.FormatCoins(Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX))).append(" ").append((String)((List)list).get(i));
                    break;
                }
                case 1: {
                    final MainActivity activity2 = this.activity;
                    sb.append(activity2.FormatCoins(activity2.totalCoins)).append(" / ").append(this.activity.FormatCoins(Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX))).append(" ").append((String)((List)list).get(i));
                    break;
                }
                case 0: {
                    final MainActivity activity3 = this.activity;
                    sb.append(activity3.FormatCoins(activity3.combatManager.slayerInfo.getDarkThread())).append(" / ").append(this.activity.FormatCoins(Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.alchemyMakeX))).append(" ").append((String)((List)list).get(i));
                    break;
                }
            }
        }
        textView.setText((CharSequence)sb.toString());
        if (this.activity.GetSkillLevel("Alchemy") >= this.activePotion.GetLevel()) {
            ((TextView)this.alchemyOverview.getChildAt(6)).setText((CharSequence)("Brew " + this.activity.makeXAmounts.get(this.activity.alchemyMakeX)));
            this.alchemyOverview.getChildAt(6).setAlpha(1.0f);
        }
        else {
            this.alchemyOverview.getChildAt(6).setAlpha(0.5f);
            ((TextView)this.alchemyOverview.getChildAt(6)).setText((CharSequence)"Locked");
        }
    }
    
    public void UpdatePotionSelect(final List<Potion> list) {
        this.activity.itemSelect_wrap.removeAllViews();
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
        textView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880)));
        if (this.activity.potionRenewal) {
            textView.setText((CharSequence)"Tap to disable auto potion renewal");
        }
        else {
            textView.setText((CharSequence)"Tap to enable auto potion renewal");
        }
        textView.setTextColor(this.activity.GetColour(2131034924));
        textView.setBackground(this.activity.GetImage(2131165348));
        final MainActivity activity = this.activity;
        activity.SetTextSize(textView, activity.GetResource(2131099658));
        textView.setGravity(17);
        this.activity.itemSelect_wrap.addView((View)textView);
        if (this.activity.itemManager.isScrollUnlocked("Energy Overload")) {
            final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            textView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880)));
            textView2.setText((CharSequence)("Drink " + this.activity.FormatExp((long)this.energyPotionXAmounts[this.drinkXEnergy]) + "x Energy Potion"));
            textView2.setTextColor(this.activity.GetColour(2131034924));
            textView2.setBackground(this.activity.GetImage(2131165348));
            final MainActivity activity2 = this.activity;
            activity2.SetTextSize(textView2, activity2.GetResource(2131099658));
            textView2.setGravity(17);
            this.activity.itemSelect_wrap.addView((View)textView2);
            textView2.setOnClickListener((View$OnClickListener)new Alchemy$$ExternalSyntheticLambda1(this, textView2));
        }
        textView.setOnClickListener((View$OnClickListener)new Alchemy$$ExternalSyntheticLambda2(this, textView));
        for (int i = 0; i < list.size(); ++i) {
            if (this.activity.inventoryItems.contains((Object)((Potion)list.get(i)).GetItem()) || this.activePotions.contains((Object)((Potion)list.get(i)).GetItem())) {
                final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
                relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
                relativeLayout.setPadding(this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658));
                final ImageView imageView = new ImageView((Context)this.activity);
                final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.activity.GetResource(2131099824), this.activity.GetResource(2131099824));
                layoutParams.addRule(15);
                imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                imageView.setAdjustViewBounds(true);
                Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)((Potion)list.get(i)).GetItem()))).into(imageView);
                relativeLayout.addView((View)imageView);
                final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
                final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -1);
                layoutParams2.setMargins(this.activity.GetResource(2131099935), 0, this.activity.GetResource(2131100204), 0);
                layoutParams2.addRule(15);
                linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                linearLayout.setGravity(16);
                linearLayout.setOrientation(1);
                final TextView textView3 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-2, -2);
                layoutParams3.setMargins(0, 0, 0, this.activity.GetResource(2131099980));
                textView3.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
                long longValue;
                if (this.activity.inventoryItems.contains((Object)((Potion)list.get(i)).GetItem())) {
                    longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)((Potion)list.get(i)).GetItem()));
                }
                else {
                    longValue = 0L;
                }
                textView3.setText((CharSequence)this.activity.getString(2131820614, new Object[] { ((Potion)list.get(i)).GetItem(), longValue }));
                textView3.setTextColor(this.activity.white);
                final MainActivity activity3 = this.activity;
                activity3.SetTextSize(textView3, activity3.GetResource(2131099658));
                linearLayout.addView((View)textView3);
                final TextView textView4 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                textView4.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
                textView4.setLineSpacing(0.0f, 1.2f);
                String string;
                final String s = string = (String)this.activity.allItemsDescriptions.get(this.activity.allItems.indexOf((Object)((Potion)list.get(i)).GetItem()));
                if (((Potion)list.get(i)).GetItem().equals((Object)"Summer Cocktail")) {
                    string = s + " (" + (this.cocktailCap + this.activity.databaseManager.GetWishLevel("Cocktail Craze", "Endgame") * 20 - this.cocktailsDrank) + " left today)";
                }
                textView4.setText((CharSequence)string);
                textView4.setTextColor(this.activity.faded);
                final MainActivity activity4 = this.activity;
                activity4.SetTextSize(textView4, activity4.GetResource(2131100247));
                linearLayout.addView((View)textView4);
                relativeLayout.addView((View)linearLayout);
                if (this.activePotions.contains((Object)((Potion)list.get(i)).GetItem())) {
                    final TextView textView5 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                    final RelativeLayout$LayoutParams layoutParams4 = new RelativeLayout$LayoutParams(this.activity.GetResource(2131100102), -2);
                    layoutParams4.addRule(21);
                    layoutParams4.addRule(15);
                    textView5.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
                    textView5.setText((CharSequence)String.valueOf((long)this.activePotionsTimers.get(this.activePotions.indexOf((Object)((Potion)list.get(i)).GetItem())) / 1000L));
                    textView5.setGravity(17);
                    textView5.setBackground(this.activity.GetImage(2131165334));
                    final MainActivity activity5 = this.activity;
                    activity5.SetTextSize(textView5, activity5.GetResource(2131099658));
                    textView5.setPadding(0, this.activity.GetResource(2131100202), 0, this.activity.GetResource(2131100202));
                    textView5.setTextColor(this.activity.GetColour(2131034925));
                    relativeLayout.addView((View)textView5);
                    textView5.setEnabled(false);
                    this.activePotionViews.set(this.activePotions.indexOf((Object)((Potion)list.get(i)).GetItem()), (Object)textView5);
                }
                else {
                    final TextView textView6 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                    final RelativeLayout$LayoutParams layoutParams5 = new RelativeLayout$LayoutParams(this.activity.GetResource(2131100102), -2);
                    layoutParams5.addRule(21);
                    layoutParams5.addRule(15);
                    textView6.setLayoutParams((ViewGroup$LayoutParams)layoutParams5);
                    textView6.setText((CharSequence)"Drink");
                    textView6.setGravity(17);
                    textView6.setBackground(this.activity.GetImage(2131165334));
                    final MainActivity activity6 = this.activity;
                    activity6.SetTextSize(textView6, activity6.GetResource(2131099658));
                    textView6.setPadding(0, this.activity.GetResource(2131100202), 0, this.activity.GetResource(2131100202));
                    textView6.setTextColor(this.activity.GetColour(2131034925));
                    relativeLayout.addView((View)textView6);
                    textView6.setOnClickListener((View$OnClickListener)new Alchemy$$ExternalSyntheticLambda3(this, list, i, textView6));
                }
                this.activity.itemSelect_wrap.addView((View)relativeLayout);
                final MainActivity activity7 = this.activity;
                activity7.AddBorder((ViewGroup)activity7.itemSelect_wrap);
            }
        }
        if (this.activity.itemSelect_wrap.getChildCount() == 1) {
            final TextView textView7 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final LinearLayout$LayoutParams layoutParams6 = new LinearLayout$LayoutParams(-1, -2);
            layoutParams6.setMargins(this.activity.GetResource(2131099658), this.activity.GetResource(2131099769), this.activity.GetResource(2131099658), 0);
            textView7.setLayoutParams((ViewGroup$LayoutParams)layoutParams6);
            textView7.setText((CharSequence)"You don't currently have any potions in your inventory");
            textView7.setTextColor(this.activity.faded);
            textView7.setGravity(17);
            textView7.setLineSpacing(0.0f, 1.2f);
            final MainActivity activity8 = this.activity;
            activity8.SetTextSize(textView7, activity8.GetResource(2131099680));
            this.activity.itemSelect_wrap.addView((View)textView7);
        }
    }
    
    public void UsePotion(final Potion potion, final TextView textView) {
        long getTimer;
        final long n = getTimer = potion.GetTimer();
        if (!potion.GetItem().equals((Object)"Summer Cocktail")) {
            long n2 = n;
            if (this.activity.baseTower.myTreestones.contains((Object)"Treestone of Time")) {
                n2 = n * 2L;
            }
            getTimer = n2;
            if (this.activity.baseTower.baseTowerLevel >= 49) {
                getTimer = n2 * 2L;
            }
        }
        if (!this.AlreadyActive(potion)) {
            this.SetPotion(potion, "Use");
            if (potion.GetItem().equals((Object)"Summer Cocktail")) {
                ++this.cocktailsDrank;
            }
            if (getTimer > 0L) {
                this.activePotions.add((Object)potion.GetItem());
                this.activePotionsTimers.add((Object)getTimer);
                this.activePotionViews.add((Object)textView);
                new CountDownTimer(this, getTimer, 1000L, potion, textView) {
                    final Alchemy this$0;
                    final Potion val$potion;
                    final TextView val$tv;
                    
                    public void onFinish() {
                        this.this$0.SetPotion(this.val$potion, "Remove");
                        this.this$0.activePotionsTimers.remove(this.this$0.activePotions.indexOf((Object)this.val$potion.GetItem()));
                        this.this$0.activePotionViews.remove(this.this$0.activePotions.indexOf((Object)this.val$potion.GetItem()));
                        this.this$0.activePotions.remove((Object)this.val$potion.GetItem());
                        if (this.this$0.activity.potionRenewal && !this.val$potion.GetItem().equals((Object)"Summer Cocktail")) {
                            if (!this.this$0.activity.combatManager.equippedItems.contains((Object)"Cauldron") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Ring of Renewal") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Blessed Eternal Sacrifice") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Pumpkin Cauldron") && !this.this$0.activity.combatManager.equippedItems.contains((Object)"Necklace of the Gods")) {
                                this.this$0.activity.potionRenewal = false;
                            }
                            else if (this.this$0.activity.inventoryItems.contains((Object)this.val$potion.GetItem())) {
                                this.this$0.UsePotion(this.val$potion, this.val$tv);
                                this.this$0.activity.QuickPopup("You drink another dose of your " + this.val$potion.GetItem());
                            }
                            else {
                                this.this$0.activity.potionRenewal = false;
                                this.this$0.activity.QuickPopup("You have run out of " + this.val$potion.GetItem() + "s");
                            }
                        }
                        else {
                            this.this$0.activity.QuickPopup("Your " + this.val$potion.GetItem() + " has worn off");
                        }
                    }
                    
                    public void onTick(final long n) {
                        this.this$0.activePotionsTimers.set(this.this$0.activePotions.indexOf((Object)this.val$potion.GetItem()), (Object)((long)this.this$0.activePotionsTimers.get(this.this$0.activePotions.indexOf((Object)this.val$potion.GetItem())) - 1000L));
                        if (this.this$0.activePotionViews.get(this.this$0.activePotions.indexOf((Object)this.val$potion.GetItem())) != null) {
                            ((TextView)this.this$0.activePotionViews.get(this.this$0.activePotions.indexOf((Object)this.val$potion.GetItem()))).setText((CharSequence)String.valueOf(n / 1000L));
                        }
                        if (this.val$potion.GetType().equals((Object)"Damage") && this.this$0.activity.inCombat && this.this$0.activity.searchingEnemy.getVisibility() == 8 && this.this$0.activity.enemyCurrentHealth > 0) {
                            final int potionDamage = this.this$0.PotionDamage(this.val$potion);
                            if (this.this$0.activity.enemyCurrentHealth > potionDamage) {
                                final MainActivity activity = this.this$0.activity;
                                activity.enemyCurrentHealth -= potionDamage;
                                this.this$0.activity.enemyHealthBar.setProgress(this.this$0.activity.enemyCurrentHealth);
                                this.this$0.activity.enemyHealthTv.setText((CharSequence)this.this$0.activity.getString(2131820622, new Object[] { this.this$0.activity.enemyCurrentHealth, this.this$0.activity.enemyMaxHealth }));
                                this.this$0.activity.battleUpdates.setText((CharSequence)this.this$0.activity.getString(2131820616, new Object[] { potionDamage }));
                            }
                        }
                    }
                }.start();
            }
        }
        else {
            this.activity.QuickPopup("You already have an active potion of this type");
        }
    }
    
    public static class Potion
    {
        long exp;
        String item;
        int levelRequirement;
        String materials;
        String materialsAmounts;
        long timer;
        String type;
        
        public Potion(final int levelRequirement, final String item, final String materials, final long exp, final String materialsAmounts, final String type, final long timer) {
            this.levelRequirement = levelRequirement;
            this.exp = exp;
            this.materials = materials;
            this.item = item;
            this.materialsAmounts = materialsAmounts;
            this.type = type;
            this.timer = timer;
        }
        
        public String GetAmounts() {
            return this.materialsAmounts;
        }
        
        public long GetExp() {
            return this.exp;
        }
        
        public String GetItem() {
            return this.item;
        }
        
        public long GetLevel() {
            return this.levelRequirement;
        }
        
        public String GetMats() {
            return this.materials;
        }
        
        public long GetTimer() {
            return this.timer;
        }
        
        public String GetType() {
            return this.type;
        }
    }
}
