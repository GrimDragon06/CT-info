package uk.playdrop.cherrytree_idletextrpg;

import android.animation.ValueAnimator;
import java.util.Locale;
import java.util.Iterator;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.os.Handler;
import android.widget.RelativeLayout$LayoutParams;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import java.util.Random;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.util.Log;
import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import android.animation.TimeInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.widget.ScrollView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.animation.ObjectAnimator;
import android.widget.LinearLayout;
import java.util.List;

public class Thieving
{
    List<String> activeCombination;
    Safe activeSafe;
    MainActivity activity;
    List<String> allLoot;
    List<Long> allLootAmounts;
    LinearLayout allSafes;
    ObjectAnimator arrowAnimation;
    TextView autoCrack;
    boolean autoSafecracking;
    TextView backToSafes;
    TextView breakLock;
    int currentLock;
    long dailySafesAllowed;
    long dailySafesCracked;
    TextView locksCracked;
    List<String> presentSackSpecials;
    RelativeLayout safeArrow;
    TextView safeCrackedMessage;
    LinearLayout safeLocks;
    List<List<String>> safeLoot;
    List<List<Long>> safeLootAmounts;
    List<List<Long>> safeLootOdds;
    int safeLootRolls;
    RelativeLayout safeMinigame;
    ScrollView safeScreen;
    RelativeLayout safeSkillProgress;
    TextView safeTitle;
    RelativeLayout safeUnlockSection;
    List<Long> safe_exp;
    List<Integer> safe_level;
    List<Integer> safe_locks;
    List<String> safe_name;
    LinearLayout safe_rewards;
    List<Long> safe_speed;
    List<Integer> safe_width;
    ScrollView safecrackingScreen;
    List<Safe> safes;
    int screenWidth;
    List<TextView> startButtons;
    List<Long> thievingCoins;
    List<Integer> thievingDamage;
    List<Long> thievingExp;
    List<List<String>> thievingLoot;
    List<List<Long>> thievingLootAmounts;
    List<List<Float>> thievingLootOdds;
    List<String> thievingNpc;
    List<String> thievingOutfit;
    LinearLayout thievingScreen;
    RelativeLayout thievingSkillProgress;
    List<Long> thievingSpeed;
    List<Integer> thievingSuccess;
    List<Integer> thievingUnlockLevel;
    LinearLayout thievingWrap;
    ValueAnimator$AnimatorUpdateListener updateListener;
    
    public Thieving(final MainActivity activity) {
        final Integer value = 1;
        final Integer value2 = 3;
        final Integer value3 = 4;
        final Integer value4 = 5;
        final Integer value5 = 6;
        final Integer value6 = 7;
        this.thievingNpc = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Farmer", "Bard", "Fisher", "Chef", "Alchemist", "Blacksmith", "Taskmaster", "Lumberjack", "Elven Trader", "Traveller" }));
        final Integer value7 = 12;
        this.thievingSuccess = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 30, 28, 26, 24, 22, 20, 18, 16, 14, value7 }));
        this.thievingUnlockLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, 15, 28, 37, 49, 61, 74, 83, 91, 99 }));
        final Long value8 = 10L;
        final Long value9 = 25L;
        this.thievingExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value8, value9, 50L, 75L, 100L, 120L, 160L, 250L, 400L, 550L }));
        this.thievingDamage = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value2, value4, value6, 9, value7, 15, 20, 30, 40 }));
        this.thievingCoins = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value8, value9, 45L, 70L, 90L, 130L, 185L, 240L, 350L, 750L }));
        this.thievingSpeed = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 2000L, 3000L, 4000L, 5000L, 6000L, 7000L, 8000L, 9000L, 10000L, 12000L }));
        this.thievingLoot = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "Pumpkin Seed", "Magnolia Seed", "Eggplant Seed", "Blueberry Seed", "Cherry Blossom Seed", "Lemon Seed", "Orange Seed", "Strawberry Seed", "Apple Seed", "Tomato Seed" }), Arrays.asList((Object[])new String[] { "Golden Scarab", "Stone Tablet", "Attack Potion", "Defence Potion", "Strength Potion", "Birds Nest", "Wool", "Feathers", "Thread" }), Arrays.asList((Object[])new String[] { "Fishing Potion", "Fish Hook", "Anchor", "Large Fishing Net", "Fishing Net", "Raw Perch", "Raw Minnows", "Raw Carp", "Raw Snail", "Raw Shrimp" }), Arrays.asList((Object[])new String[] { "Cauldron", "Pumpkin Pie", "Dragon Platter", "Mushroom Soup", "Burnt Lobster", "Burnt Snail", "Burnt Shrimp", "Bag of Flour", "Milk", "Mushroom" }), Arrays.asList((Object[])new String[] { "Wolfmint", "Sage Leaf", "Pearl", "Ember Fern", "Empty Vial", "Safflower", "Hyssop", "Bloodroot", "Sunburst Flower", "Akomeric" }), Arrays.asList((Object[])new String[] { "Darkstar Bar", "Iridium Ore", "Rhodium Ore", "Dragon Ore", "Mithril Ore", "Gold Bar", "Iron", "Copper Ore", "Nails", "Iron Ore" }), Arrays.asList((Object[])new String[] { "Stone Tablet", "Gold Coin", "Dragon Tail", "Dragon Skull", "Ram Skull", "Eagles Nest", "Ember Fern", "Wine", "Cog", "Yarn" }), Arrays.asList((Object[])new String[] { "Rabbits Foot", "Sandalwood Log", "Eagles Nest", "Ginkgo Seed", "Magnolia Seed", "Chestnut Seed", "Ginkgo Log", "Chestnut Log", "Cedar Log", "Redwood Log" }), Arrays.asList((Object[])new String[] { "Restoration Fragment 2", "Ancient Elven Book", "Dragon Skull", "Dragon Tail", "Treasure Map", "Elven Arrows", "Elven Chest", "Elven Key", "Ember Fern", "Dragon Platter" }), Arrays.asList((Object[])new String[] { "Elven Crystal", "Stone Tablet", "Dragon Scimitar", "Blueprints", "Compass", "Ember Fern", "Eggplant", "Lemon", "Orange", "Empty Vial" }) }));
        final Long value10 = 1L;
        final List list = Arrays.asList((Object[])new Long[] { value10, value10, value10, value10, value10, value10, value10, value10, value10, value10 });
        final List list2 = Arrays.asList((Object[])new Long[] { value10, value10, value10, value10, value10, value10, value10, value10, value10 });
        final List list3 = Arrays.asList((Object[])new Long[] { value10, value10, value10, value10, value10, value10, value10, value10, value10, value10 });
        final Long value11 = 5L;
        final List list4 = Arrays.asList((Object[])new Long[] { value10, value10, value10, value10, value11, value11, value11, value10, value10, value10 });
        final Long value12 = 3L;
        this.thievingLootAmounts = (List<List<Long>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { list, list2, list3, list4, Arrays.asList((Object[])new Long[] { value10, value10, value10, value12, value11, value10, value10, value10, value10, value10 }), Arrays.asList((Object[])new Long[] { value10, value10, value10, value10, value10, value10, value10, value10, value10, value10 }), Arrays.asList((Object[])new Long[] { value12, 100L, value10, value10, value10, value10, value12, value10, value12, value12 }), Arrays.asList((Object[])new Long[] { value10, value10, value10, value10, value10, value10, value10, value10, value10, value10 }), Arrays.asList((Object[])new Long[] { value10, value10, value10, value10, value10, value10, value10, value10, value10, value10 }), Arrays.asList((Object[])new Long[] { value10, value11, value10, value10, value10, value11, value8, value11, value11, value10 }) }));
        final Float value13 = 0.03f;
        final Float value14 = 0.09f;
        this.thievingLootOdds = (List<List<Float>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Float[] { value13, value14, 0.24f, 0.49f, 1.49f, 4.49f, 9.49f, 16.49f, 28.49f, 43.49f }), Arrays.asList((Object[])new Float[] { value13, value14, 0.24f, 0.49f, 1.49f, 4.49f, 9.49f, 16.49f, 28.49f }), Arrays.asList((Object[])new Float[] { value13, value14, 0.24f, 0.49f, 1.49f, 4.49f, 9.49f, 16.49f, 28.49f, 43.49f }), Arrays.asList((Object[])new Float[] { value13, value14, 0.24f, 0.49f, 1.49f, 4.49f, 9.49f, 16.49f, 28.49f, 43.49f }), Arrays.asList((Object[])new Float[] { value13, value14, 0.24f, 0.49f, 1.49f, 4.49f, 9.49f, 16.49f, 28.49f, 43.49f }), Arrays.asList((Object[])new Float[] { 0.01f, 0.07f, 0.22f, 0.47f, 1.97f, 5.97f, 11.97f, 20.97f, 35.97f, 55.97f }), Arrays.asList((Object[])new Float[] { value13, value14, 0.24f, 0.49f, 1.49f, 4.49f, 9.49f, 16.49f, 28.49f, 43.49f }), Arrays.asList((Object[])new Float[] { 0.01f, value13, 0.18f, 0.43f, 1.43f, 4.43f, 9.43f, 16.43f, 28.43f, 43.43f }), Arrays.asList((Object[])new Float[] { 0.01f, 0.05f, 0.15f, 0.55f, 3.55f, 8.55f, 17.55f, 32.55f, 52.55f, 82.55f }), Arrays.asList((Object[])new Float[] { value13, value14, 0.24f, 0.49f, 1.49f, 4.49f, 9.49f, 16.49f, 28.49f, 43.49f }) }));
        this.startButtons = (List<TextView>)new ArrayList();
        this.safe_name = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Dryadalis", "Cragnum", "Hydrelos", "Silvanium", "Spelithos", "Auranium", "Polisoros", "Empyreon" }));
        this.safe_level = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, 20, 40, 65, 80, 99, 110, 130 }));
        this.safe_locks = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value2, value3, value3, value4, value4, value5, value5, value6 }));
        this.safe_speed = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 2000L, 2000L, 1800L, 1800L, 1600L, 1600L, 1400L, 1200L }));
        this.safe_width = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 18, 18, 16, 16, 14, 14, value7, 11 }));
        this.safe_exp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 20L, 75L, 300L, 800L, 1600L, 4000L, 7500L, 15000L }));
        this.safeLoot = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "Gold Coin", "Old Fishing Rod", "Gold Coin", "Coin Purse", "Blue Silk", "Lemon", "Red Onion", "Super Energy Potion", "Coins", "Wood", "Thread" }), Arrays.asList((Object[])new String[] { "Gold Coin", "Dragon Leather", "Fish Hook", "Anchor", "Mithril Bar", "Gold Coin", "Extreme Attack Potion", "Extreme Energy Potion", "Coin Purse", "Blue Silk", "Coins" }), Arrays.asList((Object[])new String[] { "Gold Coin", "Rod of Anuket", "Golden Necklace", "Bestiary", "Gold Coin", "Blue Crab", "Fish Soup", "Large Fishing Net", "Extreme Energy Potion", "Coins", "Coin Purse", "Hide" }), Arrays.asList((Object[])new String[] { "Gold Coin", "Dragon Rider Greaves", "Liquid Death Potion", "Gold Coin", "Rock Skin Potion", "Bone Stew", "Sunburst Flower", "Ember Fern", "Coin Purse", "Blue Silk", "Coins" }), Arrays.asList((Object[])new String[] { "Gold Coin", "Golden Touch Potion", "Pumpkin", "Gold Coin", "Golden Necklace", "Dragon Skull", "Dragon Tail", "Liquid Death Potion", "Extreme Power Potion", "Sunburst Flower", "Coins", "Mushroom Soup" }), Arrays.asList((Object[])new String[] { "Thieving Gloves", "Gold Coin", "Scythe of Demeter", "Ring Fragments", "Golden Touch Potion", "Mystery Egg", "Gold Coin", "Golden Necklace", "Dragon Skull", "Dragon Tail", "Extreme Energy Potion", "Coins" }), Arrays.asList((Object[])new String[] { "Gold Coin", "Ring Fragments", "Mystic Robe", "Mystic Bottoms", "Necromancer Top", "Necromancer Greaves", "Magic Watering Can", "Gold Coin", "Extreme Power Stone", "Coins", "Crystal Key", "Crystal Chest" }), Arrays.asList((Object[])new String[] { "Gold Coin", "Ring Fragments", "Soul Gem", "Casket of Treasure", "Soul Reaper Potion", "Mystic Robe", "Mystic Bottoms", "Ring of Speed", "Ring of Life", "Ring of Death", "Stone Tablet", "Elven Chest", "Elven Key", "Liquid Death Potion", "Extreme Luck Potion", "Extreme Energy Potion" }) }));
        final Long value15 = 2L;
        this.safeLootAmounts = (List<List<Long>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Long[] { 40L, value10, value15, value15, value11, value11, value11, value15, 2000L, value11, 20L }), Arrays.asList((Object[])new Long[] { 60L, value10, value10, value10, value11, 4L, value15, value15, value11, 15L, 5000L }), Arrays.asList((Object[])new Long[] { 100L, value10, value10, value10, 8L, value8, value11, value8, value15, 15000L, value8, value8 }), Arrays.asList((Object[])new Long[] { 200L, value11, value11, 15L, value8, value8, 20L, 20L, value9, 50L, 25000L }), Arrays.asList((Object[])new Long[] { 500L, value15, value15, value9, value9, value11, value11, value8, value8, 50L, 100000L, 50L }), Arrays.asList((Object[])new Long[] { value10, 1000L, value10, value15, value11, value10, 40L, value9, value11, value11, value8, 200000L }), Arrays.asList((Object[])new Long[] { 2000L, value11, value10, value10, value10, value10, value10, 60L, value10, 500000L, value8, value8 }), Arrays.asList((Object[])new Long[] { 5000L, value8, value10, value11, value10, value10, value10, value10, value10, value10, value11, value10, value10, value15, value15, 15L }) }));
        this.safeLootOdds = (List<List<Long>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Long[] { value10, value12, 13L, 33L, 63L, 103L, 153L, 203L, 303L, 423L, 573L }), Arrays.asList((Object[])new Long[] { value10, 6L, 16L, 26L, 46L, 71L, 111L, 151L, 211L, 311L, 461L }), Arrays.asList((Object[])new Long[] { value10, value12, 8L, 18L, 33L, 53L, 83L, 133L, 193L, 283L, 383L, 533L }), Arrays.asList((Object[])new Long[] { value10, 6L, 16L, 31L, 56L, 96L, 156L, 216L, 296L, 396L, 516L }), Arrays.asList((Object[])new Long[] { value10, 6L, 13L, value9, 40L, 70L, 100L, 140L, 200L, 300L, 450L, 650L }), Arrays.asList((Object[])new Long[] { value10, value12, value11, 9L, 19L, 34L, 54L, 79L, 279L, 479L, 829L, 1429L }), Arrays.asList((Object[])new Long[] { value10, value12, 6L, value8, 15L, 21L, 28L, 68L, 168L, 518L, 1268L, 2018L }), Arrays.asList((Object[])new Long[] { value10, value12, 9L, 16L, 24L, 33L, 43L, 55L, 69L, 85L, 185L, 635L, 1085L, 1685L, 2335L, 3235L }) }));
        this.safes = (List<Safe>)new ArrayList();
        this.currentLock = 0;
        this.screenWidth = 0;
        this.activeCombination = (List<String>)new ArrayList();
        this.safeLootRolls = 2;
        this.allLoot = (List<String>)new ArrayList();
        this.allLootAmounts = (List<Long>)new ArrayList();
        this.autoSafecracking = false;
        this.dailySafesCracked = 0L;
        this.dailySafesAllowed = 3000L;
        this.thievingOutfit = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Thief Boots", "Thief Gloves", "Thief Top", "Thief Hood", "Thief Legs" }));
        this.presentSackSpecials = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Special Currency", "Enhancement Ticket", "Gold Coin", "Slayer Casket" }));
        this.activity = activity;
        this.CreateSafes();
    }
    
    private void BreakLock() {
        this.arrowAnimation.cancel();
        if (this.safeArrow.getX() >= this.safeUnlockSection.getX() && this.safeArrow.getX() <= this.safeUnlockSection.getX() + this.safeUnlockSection.getWidth()) {
            final int currentLock = this.currentLock;
            if (currentLock >= 1) {
                if (currentLock >= this.activeSafe.getLocks()) {
                    this.activity.GiveExp("Thieving", this.activeSafe.getExp() * 2L, null);
                }
                else {
                    this.activity.GiveExp("Thieving", this.activeSafe.getExp(), null);
                }
            }
            this.activity.ExpBar("Thieving", this.safeSkillProgress);
            if (this.activity.combatManager.equippedItems.contains((Object)"Magnet of Copina")) {
                final int locks = this.activeSafe.getLocks();
                final int currentLock2 = this.currentLock;
                if (locks - currentLock2 >= 2) {
                    if (this.activity.GetRandom(1, 100) <= 10) {
                        this.currentLock += 2;
                        this.activity.QuickPopup("Your Magnet of Copina manages to crack 2 locks instead of 1!");
                    }
                    else {
                        ++this.currentLock;
                    }
                }
                else {
                    this.currentLock = currentLock2 + 1;
                }
            }
            else {
                ++this.currentLock;
            }
            this.UpdateLocks();
            if (this.currentLock >= this.activeSafe.getLocks()) {
                this.SafeCracked();
            }
            else if (this.currentLock > 1) {
                final int getWishLevel = this.activity.databaseManager.GetWishLevel("Master Thief", "Endgame");
                if (getWishLevel > 0) {
                    if (this.activity.GetRandom(1, 100) <= getWishLevel) {
                        this.activity.QuickPopup("You Master Thief wish completes the safe for you!");
                        this.SafeCracked();
                    }
                    else {
                        this.ResetBox();
                    }
                }
                else {
                    this.ResetBox();
                }
            }
            else {
                this.ResetBox();
            }
        }
        else {
            this.ResetSafe();
        }
    }
    
    private void CheckMittens() {
        if (!this.activity.holidayEventAvailable) {
            return;
        }
        if (this.activity.GetRandom(1, 4000) > this.activeSafe.getLocks()) {
            return;
        }
        final TreasureHunts.EventPresent eventPresent = this.activity.treasureHunts.eventPresent;
        ++eventPresent.specialCurrency;
        final MainActivity activity = this.activity;
        activity.LargePopup(activity.event.specialCurrencyIcon, "Congratulations", "Your Santas Mittens find a " + this.activity.event.specialCurrency + "!");
    }
    
    private void ClearRewards() {
        this.safeCrackedMessage.setText((CharSequence)"Crack all the locks to receive your reward");
        for (int i = 0; i < this.safe_rewards.getChildCount(); ++i) {
            this.activity.HideView(this.safe_rewards.getChildAt(i));
        }
    }
    
    private void CreateAnimation() {
        long speed;
        final long n = speed = this.activeSafe.getSpeed();
        if (this.activity.combatManager.equippedItems.contains((Object)"Lockpick of Copina")) {
            speed = n + n / 10L;
        }
        (this.arrowAnimation = ObjectAnimator.ofFloat((Object)this.safeArrow, "translationX", new float[] { 0.0f, (float)(this.screenWidth - this.activity.GetResource(2131099669)) })).setDuration(speed);
        this.arrowAnimation.setRepeatMode(2);
        this.arrowAnimation.setRepeatCount(-1);
        this.arrowAnimation.setInterpolator((TimeInterpolator)new LinearInterpolator());
        this.arrowAnimation.addListener((Animator$AnimatorListener)new Animator$AnimatorListener(this) {
            final Thieving this$0;
            
            public void onAnimationCancel(final Animator animator) {
            }
            
            public void onAnimationEnd(final Animator animator) {
            }
            
            public void onAnimationRepeat(final Animator animator) {
                if (!this.this$0.safeScreen.isShown()) {
                    animator.cancel();
                    Log.e("Thieving", "Cancelling animation as screen is not visible");
                }
            }
            
            public void onAnimationStart(final Animator animator) {
            }
        });
    }
    
    private void CreateLocks() {
        this.safeLocks.removeAllViews();
        for (int i = 0; i < this.activeSafe.getLocks(); ++i) {
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(0, -1, 1.0f);
            if (i > 0) {
                layoutParams.leftMargin = this.activity.GetResource(2131100202);
            }
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            textView.setText((CharSequence)"?");
            textView.setTextColor(this.activity.GetColour(2131034225));
            textView.setBackground(this.activity.GetImage(2131166455));
            textView.setGravity(17);
            final MainActivity activity = this.activity;
            activity.SetTextSize(textView, activity.GetResource(2131099680));
            this.safeLocks.addView((View)textView);
        }
        this.ResetSafe();
    }
    
    private void CreateSafes() {
        if (this.safes.isEmpty()) {
            for (int i = 0; i < this.safe_name.size(); ++i) {
                this.safes.add((Object)new Safe((String)this.safe_name.get(i), (int)this.safe_level.get(i), (int)this.safe_locks.get(i), (int)this.safe_width.get(i), (long)this.safe_exp.get(i), (long)this.safe_speed.get(i), (List<String>)this.safeLoot.get(i), (List<Long>)this.safeLootAmounts.get(i), (List<Long>)this.safeLootOdds.get(i)));
            }
        }
    }
    
    private void GenerateCombination() {
        this.activeCombination.clear();
        for (int i = 0; i < this.activeSafe.getLocks(); ++i) {
            this.activeCombination.add((Object)(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" })[new Random().nextInt(10)]);
        }
    }
    
    private String GetLootOdds(final int n, final List<Float> list) {
        final float floatValue = (float)list.get(list.size() - 1);
        final StringBuilder sb = new StringBuilder("1 / ");
        if (n == 0) {
            return sb.append(Math.round(floatValue / (float)list.get(n))).toString();
        }
        return sb.append(Math.round(floatValue / ((float)list.get(n) - (float)list.get(n - 1)))).toString();
    }
    
    private void GiveRewards() {
        for (int i = 0; i < this.allLoot.size(); ++i) {
            final String s = (String)this.allLoot.get(i);
            s.hashCode();
            final int hashCode = s.hashCode();
            int n = -1;
            switch (hashCode) {
                case 1803406242: {
                    if (!s.equals((Object)"Soul Gem")) {
                        break;
                    }
                    n = 3;
                    break;
                }
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
                case -819624483: {
                    if (!s.equals((Object)"Casket of Treasure")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    this.activity.GiveItem((String)this.allLoot.get(i), (long)this.allLootAmounts.get(i), false);
                    break;
                }
                case 3: {
                    final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                    slayerInfo.soulGems += (long)this.allLootAmounts.get(i);
                    break;
                }
                case 2: {
                    final MainActivity activity = this.activity;
                    activity.totalGems += (long)this.allLootAmounts.get(i);
                    this.activity.UpdateCash();
                    break;
                }
                case 1: {
                    final MainActivity activity2 = this.activity;
                    activity2.totalCoins += (long)this.allLootAmounts.get(i);
                    this.activity.UpdateCash();
                    break;
                }
                case 0: {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                    myTreasureHunts.caskets += (int)(long)this.allLootAmounts.get(i);
                    break;
                }
            }
        }
    }
    
    private void LoadSafe() {
        if (this.safeScreen == null) {
            this.safeScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297055)).inflate();
            final ScrollView safeScreen = (ScrollView)this.activity.findViewById(2131297053);
            this.safeScreen = safeScreen;
            this.safeLocks = (LinearLayout)safeScreen.findViewById(2131297051);
            this.safeTitle = (TextView)this.safeScreen.findViewById(2131297056);
            this.breakLock = (TextView)this.safeScreen.findViewById(2131296409);
            this.safeMinigame = (RelativeLayout)this.safeScreen.findViewById(2131297052);
            this.locksCracked = (TextView)this.safeScreen.findViewById(2131296792);
            this.safe_rewards = (LinearLayout)this.safeScreen.findViewById(2131297057);
            this.safeCrackedMessage = (TextView)this.safeScreen.findViewById(2131297050);
            this.safeSkillProgress = (RelativeLayout)this.safeScreen.findViewById(2131297054);
            this.backToSafes = (TextView)this.safeScreen.findViewById(2131296368);
            this.autoCrack = (TextView)this.safeScreen.findViewById(2131296358);
            this.safeUnlockSection = (RelativeLayout)this.safeMinigame.getChildAt(0);
            this.safeArrow = (RelativeLayout)this.safeMinigame.getChildAt(1);
        }
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.safeScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.activity.EnableLayout((ViewGroup)this.safeScreen);
        this.activity.ExpBar("Thieving", this.safeSkillProgress);
        this.safeTitle.setText((CharSequence)("Safe of " + this.activeSafe.getName()));
        if (this.WearingOutfit()) {
            final Safe activeSafe = this.activeSafe;
            --activeSafe.locks;
        }
        this.breakLock.setText((CharSequence)"Break Lock");
        this.ClearRewards();
        this.backToSafes.setOnClickListener((View$OnClickListener)new Thieving$$ExternalSyntheticLambda4(this));
        this.safeScreen.post((Runnable)new Thieving$$ExternalSyntheticLambda5(this));
    }
    
    private void PickLoot() {
        this.allLoot.clear();
        this.allLootAmounts.clear();
        int n;
        if (this.activity.combatManager.equippedItems.contains((Object)"Martin")) {
            n = 25;
        }
        else {
            n = 15;
        }
        if (this.activity.GetRandom(1, 100) <= n) {
            this.safeLootRolls = 2;
        }
        else {
            this.safeLootRolls = 1;
        }
        for (int i = 0; i < this.safeLootRolls; ++i) {
            this.PickSafeReward();
        }
        if (this.activity.combatManager.equippedItems.contains((Object)"Golden Thieving Gloves") && this.activity.GetRandom(1, 100) <= this.activeSafe.getLocks() * 2) {
            final int getRandom = this.activity.GetRandom(1, 10000);
            long n2;
            if (getRandom <= 1) {
                n2 = 1000000L;
            }
            else if (getRandom <= 10) {
                n2 = 100000L;
            }
            else if (getRandom <= 100) {
                n2 = 10000L;
            }
            else {
                n2 = 1000L;
            }
            final MainActivity activity = this.activity;
            activity.totalGems += n2;
            this.activity.UpdateCash();
            if (n2 >= 100000L) {
                this.activity.LargePopup(2131165871, "Congratulations", "Your Golden Gloves find " + this.activity.FormatExp(n2) + " Gold Coins!");
            }
            else {
                this.activity.QuickPopup("Your Golden Gloves find " + this.activity.FormatExp(n2) + " Gold Coins!");
            }
        }
        if (this.activity.combatManager.equippedItems.contains((Object)"Santas Mittens")) {
            this.CheckMittens();
        }
        this.UpdateRewards();
    }
    
    private void PickSafeReward() {
        int n;
        if (this.activity.treasureHunts.BoostActive("Master Cracker")) {
            n = this.activity.GetRandom(1, Math.toIntExact((long)this.activeSafe.getLootOdds().get(this.activeSafe.getLootOdds().size() - 3)));
        }
        else {
            n = this.activity.GetRandom(1, Math.toIntExact((long)this.activeSafe.getLootOdds().get(this.activeSafe.getLootOdds().size() - 1)));
        }
        int i = 0;
        while (i < this.activeSafe.getLoot().size()) {
            if (n <= (long)this.activeSafe.getLootOdds().get(i)) {
                final String s = (String)this.activeSafe.getLoot().get(i);
                if (this.allLoot.contains((Object)s)) {
                    final int index = this.allLoot.indexOf((Object)s);
                    final List<Long> allLootAmounts = this.allLootAmounts;
                    allLootAmounts.set(index, (Object)((long)allLootAmounts.get(index) + (long)this.activeSafe.getLootAmounts().get(i)));
                    break;
                }
                this.allLoot.add((Object)s);
                this.allLootAmounts.add((Object)this.activeSafe.getLootAmounts().get(i));
                break;
            }
            else {
                ++i;
            }
        }
    }
    
    private void ResetBox() {
        int width = this.activeSafe.getWidth();
        if (this.activity.combatManager.equippedItems.contains((Object)"Stethoscope of Copina")) {
            width += 5;
        }
        int n2;
        final int n = n2 = this.screenWidth / 100 * width;
        if (this.activity.treasureHunts.BoostActive("Big Box")) {
            n2 = n + n / 5;
        }
        this.safeUnlockSection.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(n2, -1));
        this.safeUnlockSection.setX((float)this.activity.GetRandom(0, this.screenWidth - n2));
        if (this.currentLock < this.activeSafe.getLocks()) {
            this.SetArrow();
        }
        else {
            this.arrowAnimation.cancel();
        }
    }
    
    private void ResetSafe() {
        this.currentLock = 0;
        this.GenerateCombination();
        this.UpdateLocks();
        this.ResetBox();
    }
    
    private void SafeCracked() {
        this.PickLoot();
        this.GiveRewards();
        ++this.dailySafesCracked;
        this.activity.itemManager.CheckOnlineSecrets("Thieving", this.activeSafe.getName());
        this.activity.secretPathway.CheckPathway("Thieving", this.activeSafe.getName());
        if (this.activity.GetRandom(1, 12000) <= this.activeSafe.getLevel()) {
            final TreasureHunts.MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
            ++myTreasureHunts.scrolls;
            this.activity.LargePopup(2131166315, "Congratulations", "While cracking safes you found a Treasure Scroll!");
        }
        final MainActivity.Statistic accountStats = this.activity.accountStats;
        ++accountStats.safesCracked;
        if (this.activeSafe.getName().equals((Object)"Empyreon")) {
            final MainActivity.Statistic accountStats2 = this.activity.accountStats;
            ++accountStats2.empyreonSafesCracked;
        }
        this.safeCrackedMessage.setText((CharSequence)"Congratulations, you cracked the safe!");
        this.breakLock.setText((CharSequence)"Generate New Safe");
        if (this.autoSafecracking) {
            new Handler().postDelayed((Runnable)new Thieving$$ExternalSyntheticLambda10(this), 1000L);
        }
        else {
            this.breakLock.setOnClickListener((View$OnClickListener)new Thieving$$ExternalSyntheticLambda1(this));
        }
    }
    
    private void SetArrow() {
        this.safeArrow.setX((float)this.activity.GetResource(2131099758));
        this.arrowAnimation.start();
        this.breakLock.setOnClickListener((View$OnClickListener)new Thieving$$ExternalSyntheticLambda3(this));
    }
    
    private void UpdateLocks() {
        this.locksCracked.setText((CharSequence)("Locks Cracked: " + this.currentLock + " / " + this.activeSafe.getLocks()));
        for (int i = 0; i < this.safeLocks.getChildCount(); ++i) {
            if (this.currentLock > i) {
                ((TextView)this.safeLocks.getChildAt(i)).setText((CharSequence)this.activeCombination.get(i));
            }
            else {
                ((TextView)this.safeLocks.getChildAt(i)).setText((CharSequence)"?");
            }
        }
    }
    
    private void UpdateRewards() {
        for (int i = 0; i < this.allLoot.size(); ++i) {
            final LinearLayout linearLayout = (LinearLayout)this.safe_rewards.getChildAt(i);
            linearLayout.setVisibility(0);
            Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.allLoot.get(i)))).into((ImageView)linearLayout.getChildAt(0));
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)this.allLoot.get(i));
            ((TextView)linearLayout.getChildAt(2)).setText((CharSequence)("x" + this.activity.FormatExp((long)this.allLootAmounts.get(i))));
        }
    }
    
    private void UpdateSafecracking() {
        for (int i = 0; i < this.safes.size(); ++i) {
            final Safe safe = (Safe)this.safes.get(i);
            final LinearLayout linearLayout = (LinearLayout)this.allSafes.getChildAt(i);
            final LinearLayout linearLayout2 = (LinearLayout)linearLayout.getChildAt(0);
            final LinearLayout linearLayout3 = (LinearLayout)linearLayout.getChildAt(1);
            final LinearLayout linearLayout4 = (LinearLayout)linearLayout.getChildAt(2);
            ((TextView)linearLayout2.getChildAt(0)).setText((CharSequence)safe.getName());
            ((TextView)linearLayout2.getChildAt(1)).setText((CharSequence)("Level " + safe.getLevel()));
            ((TextView)linearLayout3.getChildAt(0)).setText((CharSequence)("Total Locks: " + safe.getLocks()));
            ((TextView)linearLayout3.getChildAt(1)).setText((CharSequence)("Exp/lock: " + this.activity.FormatExp(safe.getExp())));
            linearLayout4.getChildAt(0).setOnClickListener((View$OnClickListener)new Thieving$$ExternalSyntheticLambda6(this, safe));
            linearLayout4.getChildAt(1).setOnClickListener((View$OnClickListener)new Thieving$$ExternalSyntheticLambda7(this, safe));
        }
    }
    
    private void ViewLoot(final Safe safe) {
        this.activity.LoadItemSelect("Safe of " + safe.getName() + " Loot");
        this.activity.itemSelect_wrap.removeAllViews();
        for (int i = 0; i < safe.getLoot().size(); ++i) {
            final String s = (String)safe.getLoot().get(i);
            s.hashCode();
            int intValue;
            if (!s.equals((Object)"Casket of Treasure")) {
                if (!s.equals((Object)"Soul Gem")) {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(safe.getLoot().get(i)));
                }
                else {
                    intValue = 2131166237;
                }
            }
            else {
                intValue = 2131165669;
            }
            this.activity.itemSelect_wrap.addView((View)this.activity.AddItemSelectItem(intValue, (String)safe.getLoot().get(i) + " x" + this.activity.FormatExp((long)safe.getLootAmounts().get(i))));
        }
    }
    
    private boolean WearingOutfit() {
        final Iterator iterator = this.thievingOutfit.iterator();
        while (iterator.hasNext()) {
            if (!this.activity.combatManager.equippedItems.contains((Object)iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public void CheckSack(final long n) {
        if (n < 800L) {
            return;
        }
        if (!this.activity.combatManager.equippedItems.contains((Object)"Sack of Presents")) {
            return;
        }
        final MainActivity activity = this.activity;
        int n2 = 1;
        if (activity.GetRandom(1, 1500) > n / 1000L) {
            return;
        }
        String specialCurrency = (String)this.presentSackSpecials.get(this.activity.randomGenerator.nextInt(this.presentSackSpecials.size()));
        String s;
        if (specialCurrency.equals((Object)"Special Currency") && !this.activity.holidayEventAvailable) {
            s = "Gold Coin";
        }
        else {
            s = specialCurrency;
        }
        s.hashCode();
        final int hashCode = s.hashCode();
        int n3 = -1;
        switch (hashCode) {
            case 1721869536: {
                if (!s.equals((Object)"Enhancement Ticket")) {
                    break;
                }
                n3 = 2;
                break;
            }
            case 1253687303: {
                if (!s.equals((Object)"Slayer Casket")) {
                    break;
                }
                n3 = 1;
                break;
            }
            case 464123864: {
                if (!s.equals((Object)"Special Currency")) {
                    break;
                }
                n3 = 0;
                break;
            }
        }
        int specialCurrencyIcon = 0;
        switch (n3) {
            default: {
                final MainActivity activity2 = this.activity;
                activity2.totalGems += 10000L;
                n2 = 10000;
                specialCurrencyIcon = 2131165871;
                break;
            }
            case 2: {
                final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                ++blessings.tickets;
                specialCurrencyIcon = 2131165610;
                break;
            }
            case 1: {
                final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                slayerInfo.slayerCaskets += 10L;
                n2 = 10;
                specialCurrencyIcon = 2131166225;
                break;
            }
            case 0: {
                specialCurrency = this.activity.event.specialCurrency;
                final TreasureHunts.EventPresent eventPresent = this.activity.treasureHunts.eventPresent;
                ++eventPresent.specialCurrency;
                specialCurrencyIcon = this.activity.event.specialCurrencyIcon;
                break;
            }
        }
        this.activity.LargePopup(specialCurrencyIcon, "Extra Loot!", "While pickpocketing, your Present Sack helps you grab " + this.activity.FormatExp(n2) + "x " + specialCurrency + " as well!");
    }
    
    public long GetSpeed(final int n) {
        long longValue;
        final long n2 = longValue = (long)this.thievingSpeed.get(n);
        if (this.activity.combatManager.equippedItems.contains((Object)"Thieving Gloves")) {
            longValue = n2 - n2 / 5L;
        }
        long n3 = 0L;
        Label_0130: {
            if (!this.activity.combatManager.equippedItems.contains((Object)"Thieving Gloves (E)") && !this.activity.combatManager.equippedItems.contains((Object)"Golden Thieving Gloves") && !this.WearingOutfit()) {
                n3 = longValue;
                if (!this.activity.combatManager.equippedItems.contains((Object)"Santas Mittens")) {
                    break Label_0130;
                }
            }
            n3 = longValue / 2L;
        }
        long n4;
        if (this.activity.combatManager.equippedItems.contains((Object)"Sprinkles")) {
            n3 -= n3 / 5L;
            n4 = 900L;
        }
        else {
            n4 = 1000L;
        }
        return Math.max(n3, n4);
    }
    
    public int GetSuccessChance(int n) {
        final int intValue = (int)this.thievingSuccess.get(n);
        if (!this.activity.combatManager.equippedItems.contains((Object)"Thieving Gloves") && !this.activity.combatManager.equippedItems.contains((Object)"Thieving Gloves (E)") && !this.activity.databaseManager.weeklySkill.equals((Object)"Thieving")) {
            final int intValue2 = (int)this.thievingUnlockLevel.get(n);
            final int getSkillLevel = this.activity.GetSkillLevel("Thieving");
            n = intValue;
            if (getSkillLevel > intValue2) {
                n = intValue + (getSkillLevel - intValue2);
            }
            n += this.activity.databaseManager.GetWishLevel("Thief", "Beginner");
        }
        else {
            n = 100;
        }
        return Math.min(n, 100);
    }
    
    public void GoThieving(final int n) {
        this.activity.StartSkilling("Thieving", this.GetSpeed(n), (List<String>)this.thievingLoot.get(n), true, (String)this.thievingNpc.get(n), (long)this.thievingExp.get(n), this.thievingSkillProgress);
    }
    
    public int IdleDropAmount(final String s, final String s2) {
        final int index = this.thievingNpc.indexOf((Object)s2);
        int intExact = Math.toIntExact((long)((List)this.thievingLootAmounts.get(index)).get(((List)this.thievingLoot.get(index)).indexOf((Object)s)));
        if (this.WearingOutfit()) {
            intExact *= 2;
        }
        return intExact;
    }
    
    public String IdleThievingDrop(String s) {
        final int index = this.thievingNpc.indexOf((Object)s);
        final float randomFloat = this.activity.combatManager.RandomFloat(0.0f, (float)((List)this.thievingLootOdds.get(index)).get(((List)this.thievingLootOdds.get(index)).size() - 1));
        while (true) {
            for (int i = 0; i < ((List)this.thievingLootOdds.get(index)).size(); ++i) {
                if (randomFloat <= (float)((List)this.thievingLootOdds.get(index)).get(i)) {
                    s = (String)((List)this.thievingLoot.get(index)).get(i);
                    String s2 = s;
                    if (s.isEmpty()) {
                        s2 = (String)((List)this.thievingLoot.get(index)).get(((List)this.thievingLoot.get(index)).size() - 1);
                    }
                    return s2;
                }
            }
            s = "";
            continue;
        }
    }
    
    public void OpenSafecracking() {
        if (this.activity.databaseManager.weeklySkill.equals((Object)"Thieving")) {
            this.dailySafesAllowed = 5000L;
        }
        if (this.safecrackingScreen == null) {
            this.safecrackingScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297059)).inflate();
            final ScrollView safecrackingScreen = (ScrollView)this.activity.findViewById(2131297058);
            this.safecrackingScreen = safecrackingScreen;
            this.allSafes = (LinearLayout)safecrackingScreen.findViewById(2131296341);
        }
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.safecrackingScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.activity.EnableLayout((ViewGroup)this.safecrackingScreen);
        this.UpdateSafecracking();
    }
    
    public void OpenThieving() {
        if (this.thievingScreen == null) {
            final LinearLayout thievingScreen = (LinearLayout)((ViewStub)this.activity.findViewById(2131297245)).inflate();
            this.thievingScreen = thievingScreen;
            this.thievingWrap = (LinearLayout)thievingScreen.findViewById(2131297246);
            this.thievingSkillProgress = (RelativeLayout)this.thievingScreen.findViewById(2131297244);
        }
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.thievingScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.activity.EnableScreen();
        this.startButtons.clear();
        this.activity.ExpBar("Thieving", this.thievingSkillProgress);
        for (int i = 0; i < this.thievingNpc.size(); ++i) {
            final LinearLayout linearLayout = (LinearLayout)this.thievingWrap.getChildAt(i);
            ((TextView)linearLayout.getChildAt(0)).setText((CharSequence)this.thievingNpc.get(i));
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)("Level " + this.thievingUnlockLevel.get(i)));
            ((TextView)linearLayout.getChildAt(3)).setText((CharSequence)("Success Chance: " + this.GetSuccessChance(i) + "%"));
            ((TextView)linearLayout.getChildAt(4)).setText((CharSequence)("Pickpocketing Speed: " + String.format(Locale.UK, "%.1f", new Object[] { this.GetSpeed(i) / 1000.0f }) + " seconds"));
            ((TextView)linearLayout.getChildAt(5)).setText((CharSequence)("Catch Damage: " + this.thievingDamage.get(i) + "%"));
            ((TextView)linearLayout.getChildAt(6)).setText((CharSequence)("Experience: " + this.thievingExp.get(i) + " exp"));
            final TextView textView = (TextView)((LinearLayout)linearLayout.getChildAt(7)).getChildAt(0);
            final TextView textView2 = (TextView)((LinearLayout)linearLayout.getChildAt(7)).getChildAt(1);
            this.startButtons.add((Object)textView2);
            if (this.activity.trainingMethod.equals(this.thievingNpc.get(i))) {
                textView2.setText((CharSequence)"Stop Thieving");
                textView2.setBackground(this.activity.GetImage(2131166453));
            }
            else {
                textView2.setText((CharSequence)"Start Thieving");
                textView2.setBackground(this.activity.GetImage(2131166451));
            }
            if (this.activity.GetSkillLevel("Thieving") < (int)this.thievingUnlockLevel.get(i)) {
                linearLayout.getChildAt(2).setVisibility(8);
                linearLayout.getChildAt(3).setVisibility(8);
                linearLayout.getChildAt(4).setVisibility(8);
                linearLayout.getChildAt(5).setVisibility(8);
                linearLayout.getChildAt(6).setVisibility(8);
                linearLayout.getChildAt(7).setVisibility(8);
            }
            else {
                linearLayout.getChildAt(2).setVisibility(0);
                linearLayout.getChildAt(3).setVisibility(0);
                linearLayout.getChildAt(4).setVisibility(0);
                linearLayout.getChildAt(5).setVisibility(0);
                linearLayout.getChildAt(6).setVisibility(0);
                linearLayout.getChildAt(7).setVisibility(0);
            }
            textView.setOnClickListener((View$OnClickListener)new Thieving$$ExternalSyntheticLambda8(this, i));
            textView2.setOnClickListener((View$OnClickListener)new Thieving$$ExternalSyntheticLambda9(this, textView2, i));
        }
    }
    
    public void PickThievingLoot(String s) {
        final int index = this.thievingNpc.indexOf((Object)s);
        if (index < 0) {
            return;
        }
        final float randomFloat = this.activity.combatManager.RandomFloat(0.0f, (float)((List)this.thievingLootOdds.get(index)).get(((List)this.thievingLootOdds.get(index)).size() - 1));
        while (true) {
            for (int i = 0; i < ((List)this.thievingLootOdds.get(index)).size(); ++i) {
                if (randomFloat <= (float)((List)this.thievingLootOdds.get(index)).get(i)) {
                    s = (String)((List)this.thievingLoot.get(index)).get(i);
                    final long longValue = (long)((List)this.thievingLootAmounts.get(index)).get(i);
                    long n = 0L;
                    Label_0265: {
                        if (!s.isEmpty()) {
                            n = longValue;
                            if (longValue != 0L) {
                                break Label_0265;
                            }
                        }
                        s = (String)((List)this.thievingLoot.get(index)).get(((List)this.thievingLoot.get(index)).size() - 1);
                        n = 1L;
                    }
                    long n2 = n;
                    if (this.WearingOutfit()) {
                        n2 = n * 2L;
                    }
                    long n3 = n2;
                    if (this.activity.combatManager.equippedItems.contains((Object)"Sack of Presents")) {
                        n3 = n2;
                        if (this.activity.GetRandom(1, 25) <= 1) {
                            n3 = n2 * 2L;
                        }
                    }
                    if (s.equals((Object)"Gold Coin")) {
                        final MainActivity activity = this.activity;
                        activity.totalGems += n3;
                        this.activity.QuickPopup("+" + this.activity.FormatCoins(n3) + " Gold");
                        this.activity.UpdateCash();
                    }
                    else {
                        this.activity.GiveItem(s, n3, true);
                    }
                    return;
                }
            }
            s = "";
            final long longValue = 0L;
            continue;
        }
    }
    
    public void ThievingLoot(final int n) {
        this.activity.LoadItemSelect("Loot from " + (String)this.thievingNpc.get(n));
        this.activity.itemSelect_wrap.removeAllViews();
        final List list = (List)this.thievingLoot.get(n);
        for (int i = 0; i < list.size(); ++i) {
            this.activity.LogIt((String)this.thievingNpc.get(n) + ": " + (String)list.get(i));
            final String s = (String)list.get(i);
            s.hashCode();
            int intValue;
            if (!s.equals((Object)"Gold Coin")) {
                intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(list.get(i)));
            }
            else {
                intValue = 2131165871;
            }
            this.activity.itemSelect_wrap.addView((View)this.activity.AddDescriptiveItemSelectItem(intValue, (String)list.get(i) + " x" + ((List)this.thievingLootAmounts.get(n)).get(i), this.GetLootOdds(i, (List<Float>)this.thievingLootOdds.get(n))));
        }
    }
    
    public static class Safe
    {
        long exp;
        int level;
        int locks;
        List<String> loot;
        List<Long> lootAmounts;
        List<Long> lootOdds;
        String name;
        long speed;
        int width;
        
        public Safe(final String name, final int level, final int locks, final int width, final long exp, final long speed, final List<String> loot, final List<Long> lootAmounts, final List<Long> lootOdds) {
            this.name = name;
            this.level = level;
            this.locks = locks;
            this.width = width;
            this.exp = exp;
            this.speed = speed;
            this.loot = loot;
            this.lootAmounts = lootAmounts;
            this.lootOdds = lootOdds;
        }
        
        public long getExp() {
            return this.exp;
        }
        
        public int getLevel() {
            return this.level;
        }
        
        public int getLocks() {
            return this.locks;
        }
        
        public List<String> getLoot() {
            return this.loot;
        }
        
        public List<Long> getLootAmounts() {
            return this.lootAmounts;
        }
        
        public List<Long> getLootOdds() {
            return this.lootOdds;
        }
        
        public String getName() {
            return this.name;
        }
        
        public long getSpeed() {
            return this.speed;
        }
        
        public int getWidth() {
            return this.width;
        }
    }
}
