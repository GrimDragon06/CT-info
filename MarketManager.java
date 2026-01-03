package uk.playdrop.cherrytree_idletextrpg;

import java.util.Iterator;
import java.util.Random;
import java.util.HashSet;
import java.util.Objects;
import com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails;
import android.view.ViewStub;
import android.util.Log;
import java.util.Collections;
import com.android.billingclient.api.ProductDetails;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.ImageView;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import android.view.ContextThemeWrapper;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.RelativeLayout;
import java.util.List;

public class MarketManager
{
    List<String> activeItems;
    MainActivity activity;
    List<String> allSpecials;
    List<Integer> allSpecialsAmounts;
    List<Long> allSpecialsCosts;
    int buyX;
    Integer[] buyXAmounts;
    String category;
    int extremeCost;
    int godsChestCost;
    List<String> godsChestItems;
    RelativeLayout goldPurchase2;
    RelativeLayout goldPurchase3;
    RelativeLayout goldPurchase4;
    RelativeLayout goldPurchase5;
    RelativeLayout goldPurchase6;
    List<Integer> goldPurchaseIcons;
    ScrollView goldStoreScreen;
    RelativeLayout lootChest2;
    RelativeLayout lootChest3;
    List<Integer> lootChest3Amounts;
    List<String> lootChest3Items;
    List<Integer> potionChestAmounts;
    List<String> potionChestItems;
    int potionCost;
    TextView refreshStore;
    String silverCategory;
    LinearLayout silverMarketScreen;
    TextView silverStoreBuyX;
    TextView silverStoreCatSelect;
    List<String> silverStoreCategories;
    List<Long> silverStoreCosts;
    List<String> silverStoreItems;
    LinearLayout silverStoreList;
    List<Integer> specialChestAmounts;
    List<String> specialChestLoot;
    List<String> specialItems;
    RelativeLayout specialOffer1;
    RelativeLayout specialOffer2;
    RelativeLayout specialOffer3;
    RelativeLayout specialOffer4;
    
    public MarketManager(final MainActivity activity) {
        this.category = "";
        this.specialItems = (List<String>)new ArrayList();
        final Integer value = 1;
        final Integer value2 = 2;
        final Integer value3 = 5;
        final Integer value4 = 10;
        final Integer value5 = 15;
        final Integer value6 = 20;
        this.allSpecials = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Blue Silk", "Dragon Leather", "Dragon Plate", "Mithril Bar", "Super Energy Potion", "Extreme Energy Potion", "Small Exp Scroll", "Kings Armour Fragment", "Queens Armour Fragment", "Massive Exp Scroll", "Farmour Fragment", "Dagger Fragment", "Kings Weapon Fragment", "Queens Weapon Fragment", "Eggplant", "Dragon Skull", "Dragon Tail", "Ember Fern", "Crab Soup", "Coin Purse", "Crystal Key", "Farm Key", "Golden Scarab", "Mystic Dagger", "Cauldron" }));
        this.allSpecialsAmounts = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 250, 75, 75, 250, value5, value4, value, value, value2, value, value2, value, value, value, 150, 50, 50, 250, 500, 500, 50, 50, 100, value, value }));
        this.allSpecialsCosts = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 200L, 200L, 250L, 100L, 150L, 150L, 150L, 250L, 250L, 250000L, 200L, 200L, 400L, 320L, 300L, 400L, 400L, 300L, 400L, 1000L, 100L, 240L, 900L, 5000L, 20000L }));
        this.potionChestItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Liquid Death Potion", "Rock Skin Potion", "Ultimate Power Potion", "Invincibility Potion", "Golden Touch Potion", "Cyclone Potion", "Extreme Luck Potion", "Insta Kill Potion", "Elven Grace Potion", "Avalanche Potion" }));
        this.potionChestAmounts = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value4, value5, value4, value4, value3, value6, value4, value6, value5, value3 }));
        this.godsChestItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Sword of Feroxi", "Hatchet of Copina", "Pickaxe of Copina", "Rod of Copina", "Shield of Feroxi", "Quiver of Kynosian", "Shield of Amaran", "Boots of Feroxi", "Gloves of Feroxi", "Plate of Feroxi", "Helm of Feroxi", "Greaves of Feroxi", "Knife of Copina", "Sword of Cognium", "Death Princess Rune", "Divine Protection Scroll" }));
        this.lootChest3Items = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Coins", "Ancient Dagger", "Invincibility Potion", "Dragon Platter", "Ring Fragments", "Kings Armour Fragment", "Queens Armour Fragment", "Chicken Knife", "Trident of the Seas", "Wood" }));
        this.specialChestLoot = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Pumpkin", "Candy Cane", "Bunny Ears" }));
        this.lootChest3Amounts = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 100000000, value, 250, 1000, 4, value4, value5, value, value, 2500 }));
        this.specialChestAmounts = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value, value }));
        this.goldPurchaseIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131166461, 2131166462, 2131166463, 2131166464, 2131166465 }));
        this.godsChestCost = 5000000;
        this.extremeCost = 1500;
        this.potionCost = 500;
        this.silverStoreItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Akomeric", "Bloodroot", "Hyssop", "Safflower", "Sage Leaf", "Wolfmint", "Evergreen Log", "Pine Log", "Birch Log", "Fir Log", "Willow Log", "Elder Log", "Copper Ore", "Iron Ore", "Silver Ore", "Gold Ore", "Mithril Ore", "Tomato", "Apple", "Strawberry", "Red Onion", "Orange", "Lemon", "Cherries", "Stone Tablet", "Ring Fragments", "Book of Aroon", "Treasure Map", "Elven Crystal", "Magnolia Seed", "Elven Weapon Fragment", "Elven Armour Fragment" }));
        this.silverStoreCategories = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Herbs", "Herbs", "Herbs", "Herbs", "Herbs", "Herbs", "Logs", "Logs", "Logs", "Logs", "Logs", "Logs", "Ores", "Ores", "Ores", "Ores", "Ores", "Crops", "Crops", "Crops", "Crops", "Crops", "Crops", "Crops", "Specials", "Specials", "Specials", "Specials", "Specials", "Specials", "Specials", "Specials" }));
        this.silverStoreCosts = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 25000L, 75000L, 150000L, 250000L, 600000L, 1500000L, 25000L, 75000L, 150000L, 250000L, 600000L, 1500000L, 25000L, 75000L, 150000L, 250000L, 600000L, 25000L, 75000L, 150000L, 250000L, 600000L, 1500000L, 3500000L, 25000000L, 600000000L, 20000000L, 15000000L, 35000000L, 750000L, 150000000L, 125000000L }));
        this.buyXAmounts = new Integer[] { value, value4, 50, 100, 500, 1000 };
        this.buyX = 0;
        this.silverCategory = "Herbs";
        this.activeItems = (List<String>)new ArrayList();
        this.activity = activity;
    }
    
    private void GenerateMarket(final String s) {
        this.activity.marketList.removeAllViews();
        this.activity.seedBuyPrices.clear();
        this.activity.seedBuyBaseValues.clear();
        final boolean equals = s.equals((Object)"Seeds");
        int n = 17;
        int n2 = 2131099658;
        if (equals) {
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886371));
            textView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099880)));
            textView.setBackground(this.activity.GetImage(2131165346));
            final StringBuilder sb = new StringBuilder("Buy ");
            final MainActivity activity = this.activity;
            textView.setText((CharSequence)sb.append(activity.FormatExp((int)activity.makeXAmounts.get(this.activity.seedBuy))).append(" Seeds").toString());
            textView.setTextColor(this.activity.GetColour(2131034924));
            final MainActivity activity2 = this.activity;
            activity2.SetTextSize(textView, activity2.GetResource(2131099658));
            textView.setGravity(17);
            this.activity.marketList.addView((View)textView);
            textView.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda11(this, textView));
        }
        int n3 = 0;
        int n18;
        for (int i = 0; i < this.activity.market_itemsAvailable.size(); i = n18) {
            int n11;
            int n15;
            int n16;
            if (((String)this.activity.market_itemCategory.get(i)).equals((Object)s)) {
                final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
                relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
                relativeLayout.setBackground(this.activity.GetImage(2131165348));
                relativeLayout.setPadding(this.activity.GetResource(n2), this.activity.GetResource(n2), this.activity.GetResource(n2), this.activity.GetResource(n2));
                if (!s.equals((Object)"Spend your Gold")) {
                    final ImageView imageView = new ImageView((Context)this.activity);
                    final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.activity.GetResource(2131099824), this.activity.GetResource(2131099824));
                    layoutParams.addRule(15);
                    imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                    Picasso.get().load((int)this.activity.market_itemIcon.get(i)).into(imageView);
                    relativeLayout.addView((View)imageView);
                    if (s.equals((Object)"Slayer") || s.equals((Object)"Skillcapes")) {
                        imageView.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda12(this, i));
                    }
                }
                final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
                final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, -1);
                if (s.equals((Object)"Spend your Gold")) {
                    layoutParams2.setMargins(n3, n3, this.activity.GetResource(2131100220), n3);
                }
                else {
                    layoutParams2.setMargins(this.activity.GetResource(2131099935), n3, this.activity.GetResource(2131100220), n3);
                }
                linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                linearLayout.setGravity(16);
                linearLayout.setOrientation(1);
                final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-2, -2);
                layoutParams3.setMargins(n3, n3, n3, this.activity.GetResource(2131099869));
                textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
                textView2.setText((CharSequence)this.activity.market_itemsAvailable.get(i));
                final MainActivity activity3 = this.activity;
                activity3.SetTextSize(textView2, activity3.GetResource(2131099669));
                textView2.setTextColor(this.activity.GetColour(2131034924));
                linearLayout.addView((View)textView2);
                final TextView textView3 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886406));
                textView3.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
                textView3.setText((CharSequence)this.activity.market_itemDescription.get(i));
                final MainActivity activity4 = this.activity;
                activity4.SetTextSize(textView3, activity4.GetResource(2131100247));
                textView3.setTextColor(this.activity.GetColour(2131034225));
                textView3.setLineSpacing(0.0f, 1.2f);
                linearLayout.addView((View)textView3);
                relativeLayout.addView((View)linearLayout);
                s.hashCode();
                final boolean equals2 = s.equals((Object)"Skill Upgrades");
                long n4 = 0L;
                Label_0925: {
                    if (!equals2) {
                        if (!s.equals((Object)"Inventory")) {
                            n4 = (long)this.activity.market_itemSellPrice.get(i);
                        }
                        else if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Inventory Size")) {
                            n4 = this.GetInventoryUpgradeCost(this.activity);
                        }
                        else if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Stash Size")) {
                            n4 = this.GetStashCost(this.activity);
                        }
                    }
                    else {
                        final String s2 = (String)this.activity.market_itemsAvailable.get(i);
                        s2.hashCode();
                        int n5 = 0;
                        Label_1212: {
                            switch (s2.hashCode()) {
                                case 2086605565: {
                                    if (!s2.equals((Object)"Energy Saver")) {
                                        break;
                                    }
                                    n5 = 5;
                                    break Label_1212;
                                }
                                case 1841435622: {
                                    if (!s2.equals((Object)"Discovery Fail Chance")) {
                                        break;
                                    }
                                    n5 = 4;
                                    break Label_1212;
                                }
                                case 1788891085: {
                                    if (!s2.equals((Object)"Fishing Rod Upgrade")) {
                                        break;
                                    }
                                    n5 = 3;
                                    break Label_1212;
                                }
                                case -367008759: {
                                    if (!s2.equals((Object)"Pickaxe Upgrade")) {
                                        break;
                                    }
                                    n5 = 2;
                                    break Label_1212;
                                }
                                case -1056217751: {
                                    if (!s2.equals((Object)"Crop Rows")) {
                                        break;
                                    }
                                    n5 = 1;
                                    break Label_1212;
                                }
                                case -1120027725: {
                                    if (!s2.equals((Object)"Explore Items")) {
                                        break;
                                    }
                                    n5 = 0;
                                    break Label_1212;
                                }
                            }
                            n5 = -1;
                        }
                        long n6 = 0L;
                        long n7 = 0L;
                        switch (n5) {
                            default: {
                                break Label_0925;
                            }
                            case 5: {
                                n6 = this.activity.staminaSaveChance;
                                n7 = 6000L;
                                break;
                            }
                            case 4: {
                                n4 = this.GetDiscoveryFailCost(this.activity);
                                break Label_0925;
                            }
                            case 3: {
                                n4 = this.GetSkillItemUpgradeCost(this.activity.fishingRodLevel);
                                break Label_0925;
                            }
                            case 2: {
                                n4 = this.GetSkillItemUpgradeCost(this.activity.pickaxeLevel);
                                break Label_0925;
                            }
                            case 1: {
                                if (this.activity.farming.planters < 40) {
                                    n4 = this.GetPlanterCost(this.activity);
                                }
                                break Label_0925;
                            }
                            case 0: {
                                n6 = this.activity.exploreItems;
                                n7 = 50000L;
                                break;
                            }
                        }
                        n4 = n7 * n6;
                    }
                }
                long n8 = n4;
                if (!s.equals((Object)"Slayer")) {
                    n8 = n4;
                    if (!s.equals((Object)"Spend your Gold")) {
                        final float n9 = (float)n4;
                        n8 = (long)(n9 - n9 / 100.0f * this.activity.marketDiscount);
                    }
                }
                final LinearLayout linearLayout2 = new LinearLayout((Context)this.activity);
                final RelativeLayout$LayoutParams layoutParams4 = new RelativeLayout$LayoutParams(this.activity.GetResource(2131100204), -2);
                layoutParams4.addRule(21);
                layoutParams4.addRule(15);
                linearLayout2.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(17);
                linearLayout2.setBackground(this.activity.GetImage(2131165334));
                linearLayout2.setPadding(0, this.activity.GetResource(2131100202), 0, this.activity.GetResource(2131100202));
                final ImageView imageView2 = new ImageView((Context)this.activity);
                imageView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(this.activity.GetResource(2131099680), this.activity.GetResource(2131099680)));
                imageView2.setAdjustViewBounds(true);
                if (s.equals((Object)"Slayer")) {
                    imageView2.setImageDrawable(this.activity.GetImage(2131165924));
                }
                else if (s.equals((Object)"Spend your Gold")) {
                    imageView2.setImageDrawable(this.activity.GetImage(2131165871));
                }
                else {
                    imageView2.setImageDrawable(this.activity.GetImage(2131166220));
                }
                linearLayout2.addView((View)imageView2);
                final TextView textView4 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                final RelativeLayout$LayoutParams layoutParams5 = new RelativeLayout$LayoutParams(-2, -2);
                layoutParams5.addRule(21);
                layoutParams5.addRule(15);
                textView4.setLayoutParams((ViewGroup$LayoutParams)layoutParams5);
                if (s.equals((Object)"Seeds")) {
                    final MainActivity activity5 = this.activity;
                    textView4.setText((CharSequence)activity5.FormatCoins((int)activity5.makeXAmounts.get(this.activity.seedBuy) * n8));
                    textView4.setTag((Object)String.valueOf(n8 * (int)this.activity.makeXAmounts.get(this.activity.seedBuy)));
                }
                else {
                    textView4.setText((CharSequence)this.activity.FormatCoins(n8));
                    textView4.setTag((Object)String.valueOf(n8));
                }
                final int n10 = 17;
                textView4.setGravity(17);
                final MainActivity activity6 = this.activity;
                n11 = 2131099658;
                activity6.SetTextSize(textView4, activity6.GetResource(2131099658));
                textView4.setPadding(this.activity.GetResource(2131100091), 0, 0, 0);
                textView4.setTextColor(this.activity.GetColour(2131034925));
                linearLayout2.addView((View)textView4);
                if (s.equals((Object)"Seeds")) {
                    this.activity.seedBuyPrices.add((Object)textView4);
                    this.activity.seedBuyBaseValues.add((Object)this.activity.market_itemSellPrice.get(i));
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Crop Rows") && this.activity.farming.planters >= 40) {
                    textView4.setText((CharSequence)"Max");
                    linearLayout2.setAlpha(0.2f);
                    linearLayout2.setEnabled(false);
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Explore Items") && this.activity.exploreItems >= 3) {
                    textView4.setText((CharSequence)"Max");
                    linearLayout2.setAlpha(0.2f);
                    linearLayout2.setEnabled(false);
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Energy Saver") && this.activity.staminaSaveChance >= 50) {
                    textView4.setText((CharSequence)"Max");
                    linearLayout2.setAlpha(0.2f);
                    linearLayout2.setEnabled(false);
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Inventory Size")) {
                    int n14;
                    if (this.activity.members) {
                        int n12;
                        if (this.activity.baseTower.baseTowerLevel >= 33) {
                            n12 = 260;
                        }
                        else {
                            n12 = 240;
                        }
                        int n13 = n12;
                        if (this.activity.baseTower.baseTowerLevel >= 40) {
                            n13 = n12 + 20;
                        }
                        n14 = n13;
                        if (this.activity.baseTower.baseTowerLevel >= 47) {
                            n14 = n13 + 20;
                        }
                    }
                    else {
                        n14 = 120;
                    }
                    if (this.activity.maxInventory >= n14) {
                        textView4.setText((CharSequence)"Max");
                        linearLayout2.setAlpha(0.2f);
                        linearLayout2.setEnabled(false);
                    }
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Stash Size") && this.activity.baseTower.maxStash >= 150) {
                    textView4.setText((CharSequence)"Max");
                    linearLayout2.setAlpha(0.2f);
                    linearLayout2.setEnabled(false);
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Fishing Rod Upgrade") && this.activity.fishingRodLevel >= 15) {
                    textView4.setText((CharSequence)"Max");
                    linearLayout2.setAlpha(0.2f);
                    linearLayout2.setEnabled(false);
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Auto Eat") && this.activity.autoEat) {
                    linearLayout2.setAlpha(0.2f);
                    linearLayout2.setEnabled(false);
                }
                if (s.equals((Object)"Spend your Gold") && (boolean)this.activity.premiumUpgradesPurchased.get(this.activity.premiumUpgrades.indexOf(this.activity.market_itemsAvailable.get(i)))) {
                    linearLayout2.setAlpha(0.1f);
                    linearLayout2.setEnabled(false);
                }
                if (((String)this.activity.market_itemsAvailable.get(i)).equals((Object)"Discovery Fail Chance") && this.activity.discovery.discoveryFailChance <= 10) {
                    textView4.setText((CharSequence)"Max");
                    linearLayout2.setAlpha(0.2f);
                    linearLayout2.setEnabled(false);
                }
                n15 = 0;
                relativeLayout.addView((View)linearLayout2);
                this.activity.marketList.addView((View)relativeLayout);
                linearLayout2.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda13(this, i, textView4, s, linearLayout2));
                n16 = n10;
            }
            else {
                final int n17 = n;
                n11 = n2;
                n15 = n3;
                n16 = n17;
            }
            n18 = i + 1;
            final int n19 = n11;
            final int n20 = n15;
            n = n16;
            n2 = n19;
            n3 = n20;
        }
    }
    
    private void GenerateSilverStore() {
        this.activeItems.clear();
        this.silverStoreList.removeAllViews();
        for (int i = 0; i < this.silverStoreItems.size(); ++i) {
            if (((String)this.silverStoreCategories.get(i)).equals((Object)this.silverCategory)) {
                this.activeItems.add((Object)this.silverStoreItems.get(i));
                final RelativeLayout relativeLayout = (RelativeLayout)ViewGroup.inflate((Context)this.activity, 2131492942, (ViewGroup)null);
                final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
                linearLayout$LayoutParams.topMargin = this.activity.GetResource(2131100202);
                this.silverStoreList.addView((View)relativeLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.silverStoreItems.get(i)))).into((ImageView)relativeLayout.getChildAt(0));
                ((TextView)relativeLayout.getChildAt(1)).setText((CharSequence)this.silverStoreItems.get(i));
                ((TextView)relativeLayout.getChildAt(2)).setText((CharSequence)this.activity.FormatCoins((long)this.silverStoreCosts.get(i) * this.buyXAmounts[this.buyX]));
                relativeLayout.getChildAt(2).setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda14(this, i));
            }
        }
    }
    
    private void LootChestItem(final String s, final int n, final String s2) {
        this.activity.DisableScreen();
        this.activity.LoadChestScreen();
        final LinearLayout chestLootScreen = this.activity.chestLootScreen;
        int n2 = 2;
        final LinearLayout linearLayout = (LinearLayout)chestLootScreen.getChildAt(2);
        linearLayout.removeAllViews();
        this.activity.chestLootScreen.getChildAt(3).setAlpha(0.0f);
        s2.hashCode();
        Label_0208: {
            switch (s2.hashCode()) {
                case 359367820: {
                    if (!s2.equals((Object)"Extreme")) {
                        break;
                    }
                    n2 = 4;
                    break Label_0208;
                }
                case 81831820: {
                    if (!s2.equals((Object)"Ultra")) {
                        break;
                    }
                    n2 = 3;
                    break Label_0208;
                }
                case -232531857: {
                    if (!s2.equals((Object)"Starter")) {
                        break;
                    }
                    break Label_0208;
                }
                case -1679249128: {
                    if (!s2.equals((Object)"Gods Chest")) {
                        break;
                    }
                    n2 = 1;
                    break Label_0208;
                }
                case -1898564173: {
                    if (!s2.equals((Object)"Potion")) {
                        break;
                    }
                    n2 = 0;
                    break Label_0208;
                }
            }
            n2 = -1;
        }
        switch (n2) {
            case 4: {
                ((ImageView)this.activity.chestLootScreen.getChildAt(0)).setImageDrawable(this.activity.GetImage(2131165509));
                break;
            }
            case 2: {
                ((ImageView)this.activity.chestLootScreen.getChildAt(0)).setImageDrawable(this.activity.GetImage(2131165519));
                break;
            }
            case 1:
            case 3: {
                ((ImageView)this.activity.chestLootScreen.getChildAt(0)).setImageDrawable(this.activity.GetImage(2131165517));
                break;
            }
            case 0: {
                ((ImageView)this.activity.chestLootScreen.getChildAt(0)).setImageDrawable(this.activity.GetImage(2131165516));
                break;
            }
        }
        ((TextView)this.activity.chestLootScreen.getChildAt(1)).setText((CharSequence)("You opened a " + s2 + " chest and received..."));
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
        textView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        textView.setTextColor(this.activity.GetColour(2131034892));
        final MainActivity activity = this.activity;
        activity.SetTextSize(textView, activity.GetResource(2131099669));
        textView.setText((CharSequence)(" " + this.activity.FormatExp(n) + "x " + s));
        textView.setGravity(17);
        linearLayout.addView((View)textView);
        this.activity.mainHandler.postDelayed((Runnable)new MarketManager$$ExternalSyntheticLambda8(this), 1500L);
    }
    
    private void UpdateSpecials() {
        this.GenerateSpecials();
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new RelativeLayout[] { this.specialOffer1, this.specialOffer2, this.specialOffer3, this.specialOffer4 }));
        for (int i = 0; i < ((List)list).size(); ++i) {
            ((TextView)((RelativeLayout)((List)list).get(i)).getChildAt(1)).setText((CharSequence)(this.activity.FormatExp((int)this.allSpecialsAmounts.get(this.allSpecials.indexOf(this.specialItems.get(i)))) + "x " + (String)this.specialItems.get(i)));
            final ImageView imageView = (ImageView)((RelativeLayout)((List)list).get(i)).getChildAt(0);
            final MainActivity activity = this.activity;
            imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf(this.specialItems.get(i)))));
            ((TextView)((LinearLayout)((RelativeLayout)((List)list).get(i)).getChildAt(2)).getChildAt(1)).setText((CharSequence)this.activity.FormatExp((long)this.allSpecialsCosts.get(this.allSpecials.indexOf(this.specialItems.get(i)))));
        }
    }
    
    private void UpdateStorePrices() {
        for (int i = 0; i < this.activeItems.size(); ++i) {
            ((TextView)((RelativeLayout)this.silverStoreList.getChildAt(i)).getChildAt(2)).setText((CharSequence)this.activity.FormatCoins((long)this.silverStoreCosts.get(this.silverStoreItems.indexOf(this.activeItems.get(i))) * this.buyXAmounts[this.buyX]));
        }
    }
    
    public void BuyItem(int i, final TextView textView, String s, final LinearLayout linearLayout, final MainActivity mainActivity) {
        Label_2569: {
            if (!textView.getText().toString().equals((Object)"Max")) {
                final long long1 = Long.parseLong(textView.getTag().toString());
                s.hashCode();
                final int hashCode = s.hashCode();
                final int n = 0;
                int n2 = 0;
                Label_0140: {
                    switch (hashCode) {
                        case 509058027: {
                            if (!s.equals((Object)"Spend your Gold")) {
                                break;
                            }
                            n2 = 2;
                            break Label_0140;
                        }
                        case -690832273: {
                            if (!s.equals((Object)"Skillcapes")) {
                                break;
                            }
                            n2 = 1;
                            break Label_0140;
                        }
                        case -1815998242: {
                            if (!s.equals((Object)"Slayer")) {
                                break;
                            }
                            n2 = 0;
                            break Label_0140;
                        }
                    }
                    n2 = -1;
                }
                switch (n2) {
                    default: {
                        if (mainActivity.totalCoins < long1) {
                            mainActivity.QuickPopup("Not enough coins");
                            break;
                        }
                        mainActivity.totalCoins -= long1;
                        mainActivity.UpdateCash();
                        if (s.equals((Object)"Seeds")) {
                            mainActivity.GiveSeed((String)mainActivity.market_itemsAvailable.get(i), (int)mainActivity.makeXAmounts.get(mainActivity.seedBuy));
                            mainActivity.QuickPopup(mainActivity.getString(2131820643, new Object[] { mainActivity.makeXAmounts.get(mainActivity.seedBuy), mainActivity.market_itemsAvailable.get(i) }));
                            break;
                        }
                        s = (String)mainActivity.market_itemsAvailable.get(i);
                        s.hashCode();
                        Label_0575: {
                            switch (s.hashCode()) {
                                case 2086605565: {
                                    if (!s.equals((Object)"Energy Saver")) {
                                        break;
                                    }
                                    i = 8;
                                    break Label_0575;
                                }
                                case 1841435622: {
                                    if (!s.equals((Object)"Discovery Fail Chance")) {
                                        break;
                                    }
                                    i = 7;
                                    break Label_0575;
                                }
                                case 1788891085: {
                                    if (!s.equals((Object)"Fishing Rod Upgrade")) {
                                        break;
                                    }
                                    i = 6;
                                    break Label_0575;
                                }
                                case 1501785447: {
                                    if (!s.equals((Object)"Auto Eat")) {
                                        break;
                                    }
                                    i = 5;
                                    break Label_0575;
                                }
                                case 905108748: {
                                    if (!s.equals((Object)"Stash Size")) {
                                        break;
                                    }
                                    i = 4;
                                    break Label_0575;
                                }
                                case -367008759: {
                                    if (!s.equals((Object)"Pickaxe Upgrade")) {
                                        break;
                                    }
                                    i = 3;
                                    break Label_0575;
                                }
                                case -1056217751: {
                                    if (!s.equals((Object)"Crop Rows")) {
                                        break;
                                    }
                                    i = 2;
                                    break Label_0575;
                                }
                                case -1094291323: {
                                    if (!s.equals((Object)"Inventory Size")) {
                                        break;
                                    }
                                    i = 1;
                                    break Label_0575;
                                }
                                case -1120027725: {
                                    if (!s.equals((Object)"Explore Items")) {
                                        break;
                                    }
                                    i = 0;
                                    break Label_0575;
                                }
                            }
                            i = -1;
                        }
                        switch (i) {
                            default: {
                                break Label_2569;
                            }
                            case 8: {
                                ++mainActivity.staminaSaveChance;
                                if (mainActivity.staminaSaveChance >= 50) {
                                    linearLayout.setAlpha(0.2f);
                                    textView.setText((CharSequence)"Max");
                                    linearLayout.setEnabled(false);
                                    break Label_2569;
                                }
                                textView.setText((CharSequence)mainActivity.FormatCoins(mainActivity.staminaSaveChance * 6000L - mainActivity.staminaSaveChance * 6000L / 100L * mainActivity.marketDiscount));
                                textView.setTag((Object)String.valueOf(mainActivity.staminaSaveChance * 6000L - mainActivity.staminaSaveChance * 6000L / 100L * mainActivity.marketDiscount));
                                break Label_2569;
                            }
                            case 7: {
                                final Discovery discovery = mainActivity.discovery;
                                --discovery.discoveryFailChance;
                                if (mainActivity.discovery.discoveryFailChance <= 10) {
                                    linearLayout.setAlpha(0.2f);
                                    textView.setText((CharSequence)"Max");
                                    linearLayout.setEnabled(false);
                                    break Label_2569;
                                }
                                textView.setText((CharSequence)mainActivity.FormatCoins(this.GetDiscoveryFailCost(mainActivity) - this.GetDiscoveryFailCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                textView.setTag((Object)String.valueOf(this.GetDiscoveryFailCost(mainActivity) - this.GetDiscoveryFailCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                break Label_2569;
                            }
                            case 6: {
                                ++mainActivity.fishingRodLevel;
                                if (mainActivity.fishingRodLevel >= 15) {
                                    linearLayout.setAlpha(0.2f);
                                    textView.setText((CharSequence)"Max");
                                    linearLayout.setEnabled(false);
                                    break Label_2569;
                                }
                                textView.setText((CharSequence)mainActivity.FormatCoins(this.GetSkillItemUpgradeCost(mainActivity.fishingRodLevel) - this.GetSkillItemUpgradeCost(mainActivity.fishingRodLevel) / 100L * mainActivity.marketDiscount));
                                textView.setTag((Object)String.valueOf(this.GetSkillItemUpgradeCost(mainActivity.fishingRodLevel) - this.GetSkillItemUpgradeCost(mainActivity.fishingRodLevel) / 100L * mainActivity.marketDiscount));
                                break Label_2569;
                            }
                            case 5: {
                                mainActivity.autoEat = true;
                                linearLayout.setAlpha(0.2f);
                                textView.setText((CharSequence)"Max");
                                linearLayout.setEnabled(false);
                                break Label_2569;
                            }
                            case 4: {
                                final BaseTower baseTower = mainActivity.baseTower;
                                baseTower.maxStash += mainActivity.inventoryUpgradeAmount;
                                if (mainActivity.baseTower.maxStash >= 150) {
                                    linearLayout.setAlpha(0.2f);
                                    textView.setText((CharSequence)"Max");
                                    linearLayout.setEnabled(false);
                                    break Label_2569;
                                }
                                textView.setText((CharSequence)mainActivity.FormatCoins(this.GetStashCost(mainActivity) - this.GetStashCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                textView.setTag((Object)String.valueOf(this.GetStashCost(mainActivity) - this.GetStashCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                break Label_2569;
                            }
                            case 3: {
                                ++mainActivity.pickaxeLevel;
                                textView.setText((CharSequence)mainActivity.FormatCoins(this.GetSkillItemUpgradeCost(mainActivity.pickaxeLevel) - this.GetSkillItemUpgradeCost(mainActivity.pickaxeLevel) / 100L * mainActivity.marketDiscount));
                                textView.setTag((Object)String.valueOf(this.GetSkillItemUpgradeCost(mainActivity.pickaxeLevel) - this.GetSkillItemUpgradeCost(mainActivity.pickaxeLevel) / 100L * mainActivity.marketDiscount));
                                break Label_2569;
                            }
                            case 2: {
                                final Farming farming = mainActivity.farming;
                                farming.planters += mainActivity.farming.planterIncrease;
                                if (mainActivity.farming.planters >= 40) {
                                    linearLayout.setAlpha(0.2f);
                                    textView.setText((CharSequence)"Max");
                                    linearLayout.setEnabled(false);
                                    i = n;
                                }
                                else {
                                    textView.setText((CharSequence)mainActivity.FormatCoins(this.GetPlanterCost(mainActivity) - this.GetPlanterCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                    textView.setTag((Object)String.valueOf(this.GetPlanterCost(mainActivity) - this.GetPlanterCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                    i = n;
                                }
                                while (i < mainActivity.farming.planterIncrease) {
                                    mainActivity.farming.farmCrop.add((Object)null);
                                    mainActivity.farming.farmCropTimer.add((Object)null);
                                    mainActivity.farming.farmCropProgress.add((Object)null);
                                    mainActivity.farming.farmCropTimeRemaining.add((Object)null);
                                    ++i;
                                }
                                break Label_2569;
                            }
                            case 1: {
                                mainActivity.maxInventory += mainActivity.inventoryUpgradeAmount;
                                mainActivity.itemManager.generateInventory = true;
                                int n4;
                                if (mainActivity.members) {
                                    int n3;
                                    if (mainActivity.baseTower.baseTowerLevel >= 33) {
                                        n3 = 260;
                                    }
                                    else {
                                        n3 = 240;
                                    }
                                    i = n3;
                                    if (mainActivity.baseTower.baseTowerLevel >= 40) {
                                        i = n3 + 20;
                                    }
                                    n4 = i;
                                    if (mainActivity.baseTower.baseTowerLevel >= 47) {
                                        n4 = i + 20;
                                    }
                                }
                                else {
                                    n4 = 120;
                                }
                                if (mainActivity.maxInventory >= n4) {
                                    linearLayout.setAlpha(0.2f);
                                    textView.setText((CharSequence)"Max");
                                    linearLayout.setEnabled(false);
                                    break Label_2569;
                                }
                                textView.setText((CharSequence)mainActivity.FormatCoins(this.GetInventoryUpgradeCost(mainActivity) - this.GetInventoryUpgradeCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                textView.setTag((Object)String.valueOf(this.GetInventoryUpgradeCost(mainActivity) - this.GetInventoryUpgradeCost(mainActivity) / 100L * mainActivity.marketDiscount));
                                break Label_2569;
                            }
                            case 0: {
                                ++mainActivity.exploreItems;
                                if (mainActivity.exploreItems >= 3) {
                                    linearLayout.setAlpha(0.2f);
                                    textView.setText((CharSequence)"Max");
                                    linearLayout.setEnabled(false);
                                    break Label_2569;
                                }
                                textView.setText((CharSequence)mainActivity.FormatCoins(mainActivity.exploreItems * 50000L - mainActivity.exploreItems * 50000L / 100L * mainActivity.marketDiscount));
                                textView.setTag((Object)String.valueOf(mainActivity.exploreItems * 50000 - mainActivity.exploreItems * 50000 / 100 * mainActivity.marketDiscount));
                                break Label_2569;
                            }
                        }
                        break;
                    }
                    case 2: {
                        if (mainActivity.totalGems < long1) {
                            mainActivity.QuickPopup("Not enough gold");
                            break;
                        }
                        if (mainActivity.premiumUpgradesPurchased.get(mainActivity.premiumUpgrades.indexOf(mainActivity.market_itemsAvailable.get(i)))) {
                            break;
                        }
                        mainActivity.totalGems -= long1;
                        mainActivity.UpdateCash();
                        mainActivity.premiumUpgradesPurchased.set(mainActivity.premiumUpgrades.indexOf(mainActivity.market_itemsAvailable.get(i)), (Object)true);
                        linearLayout.setAlpha(0.1f);
                        linearLayout.setEnabled(false);
                        switch (mainActivity.premiumUpgrades.indexOf(mainActivity.market_itemsAvailable.get(i))) {
                            default: {
                                break Label_2569;
                            }
                            case 17: {
                                mainActivity.farmingTimer += 30;
                                break Label_2569;
                            }
                            case 16: {
                                mainActivity.farmingTimer += 15;
                                break Label_2569;
                            }
                            case 15: {
                                mainActivity.farmingTimer += 5;
                                break Label_2569;
                            }
                            case 14: {
                                mainActivity.resourceSave += 15;
                                break Label_2569;
                            }
                            case 13: {
                                mainActivity.resourceSave += 10;
                                break Label_2569;
                            }
                            case 12: {
                                mainActivity.resourceSave += 5;
                                break Label_2569;
                            }
                            case 11: {
                                mainActivity.doublePotions += 15;
                                break Label_2569;
                            }
                            case 10: {
                                mainActivity.doublePotions += 8;
                                break Label_2569;
                            }
                            case 9: {
                                mainActivity.doublePotions += 2;
                                break Label_2569;
                            }
                            case 8: {
                                mainActivity.doubleFish += 15;
                                break Label_2569;
                            }
                            case 7: {
                                mainActivity.doubleFish += 8;
                                break Label_2569;
                            }
                            case 6: {
                                mainActivity.doubleFish += 2;
                                break Label_2569;
                            }
                            case 5: {
                                ++mainActivity.expMultiplier;
                                break Label_2569;
                            }
                            case 4: {
                                mainActivity.marketDiscount += 20;
                                break Label_2569;
                            }
                            case 3: {
                                mainActivity.marketDiscount += 15;
                                break Label_2569;
                            }
                            case 2: {
                                mainActivity.marketDiscount += 10;
                                break Label_2569;
                            }
                            case 1: {
                                mainActivity.marketDiscount += 5;
                                break Label_2569;
                            }
                            case 0: {
                                mainActivity.marketDiscount += 2;
                                break Label_2569;
                            }
                        }
                        break;
                    }
                    case 1: {
                        if (mainActivity.totalCoins < long1) {
                            mainActivity.QuickPopup("Not enough coins");
                            break;
                        }
                        if (mainActivity.InventoryNotFull((String)mainActivity.market_itemsAvailable.get(i))) {
                            mainActivity.totalCoins -= long1;
                            mainActivity.UpdateCash();
                            mainActivity.GiveItem((String)mainActivity.market_itemsAvailable.get(i), 1L, true);
                            break;
                        }
                        mainActivity.QuickPopup("Inventory Full");
                        break;
                    }
                    case 0: {
                        if (mainActivity.combatManager.slayerInfo.getKillcoins() < long1) {
                            mainActivity.QuickPopup("Not enough killcoins");
                            break;
                        }
                        if (mainActivity.InventoryNotFull((String)mainActivity.market_itemsAvailable.get(i))) {
                            final CombatManager$SlayerInfo slayerInfo = mainActivity.combatManager.slayerInfo;
                            slayerInfo.killcoins -= long1;
                            if (((String)mainActivity.market_itemsAvailable.get(i)).equals((Object)"Gold Coin")) {
                                ++mainActivity.totalGems;
                            }
                            else {
                                mainActivity.GiveItem((String)mainActivity.market_itemsAvailable.get(i), 1L, true);
                            }
                            mainActivity.UpdateCash();
                            break;
                        }
                        mainActivity.QuickPopup("Inventory Full");
                        break;
                    }
                }
            }
        }
    }
    
    public boolean CheckCompletionist() {
        return this.activity.Ultimaxed();
    }
    
    public boolean CheckNoLife() {
        final boolean checkCompletionist = this.CheckCompletionist();
        boolean b2;
        final boolean b = b2 = false;
        if (checkCompletionist) {
            b2 = b;
            if (this.CheckUltraComp()) {
                b2 = b;
                if (this.activity.baseTower.baseTowerLevel >= 75) {
                    if (this.activity.accountStats.getItemsCrafted() < 50000000L) {
                        b2 = b;
                    }
                    else if (this.activity.accountStats.getEnergyUsed() < 25000000L) {
                        b2 = b;
                    }
                    else if (this.activity.accountStats.getScrollsCompleted() < 10000L) {
                        b2 = b;
                    }
                    else if (this.activity.accountStats.getEmpyreonSafesCracked() < 10000L) {
                        b2 = b;
                    }
                    else {
                        for (int n = 0; n < this.activity.accountStats.getAllMonsterKills().size() && !((String)this.activity.combatManager.enemyArea.get(n)).equals((Object)"Shadow Realm"); ++n) {
                            if (!((String)this.activity.combatManager.enemyNames.get(n)).equals((Object)"Practice Dummy")) {
                                if (!this.activity.combatManager.allGods.contains(this.activity.combatManager.enemyNames.get(n))) {
                                    if ((long)this.activity.accountStats.getAllMonsterKills().get(n) < 100000L) {
                                        b2 = b;
                                        return b2;
                                    }
                                }
                                else if ((long)this.activity.accountStats.getAllMonsterKills().get(n) < 10000L) {
                                    b2 = b;
                                    return b2;
                                }
                            }
                        }
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    public boolean CheckUltraComp() {
        return this.CheckCompletionist() && this.activity.myPets.size() >= this.activity.skillingPets.size() && this.activity.AllQuestsComplete() && this.activity.baseTower.baseTowerLevel >= 50;
    }
    
    public void GenerateSpecials() {
        this.specialItems.clear();
        final ArrayList list = new ArrayList((Collection)this.allSpecials);
        Collections.shuffle((List)list);
        for (int i = 0; i < 4; ++i) {
            this.specialItems.add((Object)((List)list).get(0));
            ((List)list).remove(0);
        }
        Log.e("Skipped", "Generated Specials");
    }
    
    public long GetDiscoveryFailCost(final MainActivity mainActivity) {
        int i = mainActivity.discovery.discoveryFailChance;
        long n = 5000L;
        while (i < 25) {
            n *= (long)1.5f;
            ++i;
        }
        return n;
    }
    
    public long GetInventoryUpgradeCost(final MainActivity mainActivity) {
        long n = 2000L;
        for (int i = 0; i < (mainActivity.maxInventory - 10) / 5; ++i) {
            n *= (long)1.4f;
        }
        return Math.min(n, 10000000000L);
    }
    
    public long GetPlanterCost(final MainActivity mainActivity) {
        return (new Long[] { 10000L, 50000L, 100000L, 250000L, 500000L, 1000000L })[(mainActivity.farming.planters - 10) / mainActivity.farming.planterIncrease];
    }
    
    public long GetSkillItemUpgradeCost(final int n) {
        long n2 = 5000L;
        for (int i = 0; i < n; ++i) {
            n2 *= (long)1.65f;
        }
        return (long)(Math.ceil((double)Math.abs(n2 / 100L)) * 100.0);
    }
    
    public long GetStashCost(final MainActivity mainActivity) {
        long n = 10000L;
        for (int i = 0; i < (mainActivity.baseTower.maxStash - 25) / 5; ++i) {
            n *= (long)1.4f;
        }
        return n;
    }
    
    public void OpenGoldStore(final MainActivity mainActivity) {
        if (this.goldStoreScreen == null) {
            final ScrollView goldStoreScreen = (ScrollView)((ViewStub)mainActivity.findViewById(2131296707)).inflate();
            this.goldStoreScreen = goldStoreScreen;
            this.refreshStore = (TextView)goldStoreScreen.findViewById(2131297031);
            this.specialOffer1 = (RelativeLayout)this.goldStoreScreen.findViewById(2131297163);
            this.specialOffer2 = (RelativeLayout)this.goldStoreScreen.findViewById(2131297164);
            this.specialOffer3 = (RelativeLayout)this.goldStoreScreen.findViewById(2131297165);
            this.specialOffer4 = (RelativeLayout)this.goldStoreScreen.findViewById(2131297166);
            this.goldPurchase2 = (RelativeLayout)this.goldStoreScreen.findViewById(2131296701);
            this.goldPurchase3 = (RelativeLayout)this.goldStoreScreen.findViewById(2131296702);
            this.goldPurchase4 = (RelativeLayout)this.goldStoreScreen.findViewById(2131296703);
            this.goldPurchase5 = (RelativeLayout)this.goldStoreScreen.findViewById(2131296704);
            this.goldPurchase6 = (RelativeLayout)this.goldStoreScreen.findViewById(2131296705);
            this.lootChest2 = (RelativeLayout)this.goldStoreScreen.findViewById(2131296797);
            this.lootChest3 = (RelativeLayout)this.goldStoreScreen.findViewById(2131296798);
        }
        mainActivity.EnableLayout((ViewGroup)this.goldStoreScreen);
        mainActivity.HideView(mainActivity.currentView);
        mainActivity.ShowView(mainActivity.currentView = (View)this.goldStoreScreen);
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new RelativeLayout[] { this.goldPurchase2, this.goldPurchase3, this.goldPurchase4, this.goldPurchase5, this.goldPurchase6 }));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])new RelativeLayout[] { this.specialOffer1, this.specialOffer2, this.specialOffer3, this.specialOffer4 }));
        for (int i = 0; i < ((List)list).size(); ++i) {
            ((ImageView)((RelativeLayout)((List)list).get(i)).getChildAt(0)).setImageDrawable(mainActivity.GetImage((int)this.goldPurchaseIcons.get(i)));
            ((TextView)((RelativeLayout)((List)list).get(i)).getChildAt(1)).setText((CharSequence)(mainActivity.FormatExp((long)mainActivity.goldPurchaseAmounts.get(i)) + " Gold"));
            if (mainActivity.billingInitialized) {
                try {
                    ((TextView)((RelativeLayout)((List)list).get(i)).getChildAt(2)).setText((CharSequence)((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)((ProductDetails)mainActivity.inAppProducts.get(mainActivity.skuNames.indexOf(mainActivity.goldPurchaseSkus.get(i)))).getOneTimePurchaseOfferDetails())).getFormattedPrice());
                }
                catch (final IndexOutOfBoundsException ex) {
                    ((TextView)((RelativeLayout)((List)list).get(i)).getChildAt(2)).setText((CharSequence)"Error");
                }
            }
            else {
                ((TextView)((RelativeLayout)((List)list).get(i)).getChildAt(2)).setText((CharSequence)"Error");
            }
            ((RelativeLayout)((List)list).get(i)).setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda17(mainActivity, i));
        }
        if (this.specialItems.isEmpty()) {
            this.GenerateSpecials();
        }
        for (int j = 0; j < ((List)list2).size(); ++j) {
            ((TextView)((RelativeLayout)((List)list2).get(j)).getChildAt(1)).setText((CharSequence)(mainActivity.FormatExp((int)this.allSpecialsAmounts.get(this.allSpecials.indexOf(this.specialItems.get(j)))) + "x " + (String)this.specialItems.get(j)));
            ((ImageView)((RelativeLayout)((List)list2).get(j)).getChildAt(0)).setImageDrawable(mainActivity.GetImage((int)mainActivity.allItemsIcons.get(mainActivity.allItems.indexOf(this.specialItems.get(j)))));
            final LinearLayout linearLayout = (LinearLayout)((RelativeLayout)((List)list2).get(j)).getChildAt(2);
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)mainActivity.FormatExp((long)this.allSpecialsCosts.get(this.allSpecials.indexOf(this.specialItems.get(j)))));
            ((RelativeLayout)((List)list2).get(j)).getChildAt(0).setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda18(this, mainActivity, j));
            linearLayout.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda1(this, mainActivity, j));
        }
        this.refreshStore.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda2(this, mainActivity));
        ((ImageView)this.lootChest2.getChildAt(0)).setImageDrawable(mainActivity.GetImage(2131165509));
        ((ImageView)this.lootChest3.getChildAt(0)).setImageDrawable(mainActivity.GetImage(2131165516));
        ((TextView)this.lootChest2.getChildAt(1)).setText((CharSequence)"Extreme Chest");
        ((TextView)this.lootChest3.getChildAt(1)).setText((CharSequence)"Potion Chest");
        ((TextView)((LinearLayout)this.lootChest2.getChildAt(2)).getChildAt(1)).setText((CharSequence)mainActivity.FormatExp(this.extremeCost));
        ((TextView)((LinearLayout)this.lootChest3.getChildAt(2)).getChildAt(1)).setText((CharSequence)mainActivity.FormatExp(this.potionCost));
        this.lootChest2.getChildAt(2).setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda3(this, mainActivity));
        this.lootChest3.getChildAt(2).setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda4(this, mainActivity));
        this.lootChest2.getChildAt(0).setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda5(this, mainActivity));
        this.lootChest3.getChildAt(0).setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda6(this, mainActivity));
    }
    
    public void OpenMarket() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.marketScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Spend your Gold", "Inventory", "Seeds", "Skill Upgrades", "Combat", "Skillcapes" }));
        if (this.category.isEmpty()) {
            this.category = (String)((List)list).get(1);
        }
        this.activity.marketCategorySelect.setText((CharSequence)("Select Category: " + this.category));
        this.activity.marketCategorySelect.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda7(this, (List)list));
        this.GenerateMarket(this.category);
    }
    
    public void OpenSilverStore() {
        if (this.silverMarketScreen == null) {
            final LinearLayout silverMarketScreen = (LinearLayout)((ViewStub)this.activity.findViewById(2131297117)).inflate();
            this.silverMarketScreen = silverMarketScreen;
            this.silverStoreList = (LinearLayout)silverMarketScreen.findViewById(2131297120);
            this.silverStoreBuyX = (TextView)this.silverMarketScreen.findViewById(2131297118);
            this.silverStoreCatSelect = (TextView)this.silverMarketScreen.findViewById(2131297119);
        }
        this.activity.EnableLayout((ViewGroup)this.silverMarketScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.silverMarketScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.silverStoreBuyX.setText((CharSequence)("Buy x" + this.activity.FormatExp(this.buyXAmounts[this.buyX])));
        this.silverStoreBuyX.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda0(this));
        final ArrayList list = new ArrayList((Collection)new HashSet((Collection)this.silverStoreCategories));
        if (this.silverCategory.isEmpty()) {
            this.silverCategory = (String)((List)list).get(0);
        }
        this.silverStoreCatSelect.setText((CharSequence)("Select Category: " + this.silverCategory));
        this.silverStoreCatSelect.setOnClickListener((View$OnClickListener)new MarketManager$$ExternalSyntheticLambda10(this, (List)list));
        this.GenerateSilverStore();
    }
}
