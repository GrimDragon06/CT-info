package uk.playdrop.cherrytree_idletextrpg;

import android.widget.LinearLayout$LayoutParams;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import java.util.Objects;
import com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails;
import com.android.billingclient.api.ProductDetails;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.squareup.picasso.RequestCreator;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.view.View;
import java.util.Random;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.RelativeLayout;
import android.os.CountDownTimer;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout;
import java.util.List;

public class TreasureHunts
{
    ActiveBoost activeBoost;
    MainActivity activity;
    List<String> allBoosts;
    LinearLayout b_active;
    TextView b_possiblesEndgame;
    TextView b_possiblesLow;
    List<String> boostDescriptions;
    List<Long> boostDurations;
    List<Integer> boostIcons;
    List<String> boostLevels;
    ScrollView boostScreen;
    CountDownTimer boostTimer;
    long casketMitigation;
    LinearLayout casketPurchase1;
    LinearLayout casketPurchase2;
    LinearLayout casketPurchase3;
    TextView doubleCaskets;
    long endgameCost;
    EventPresent eventPresent;
    List<String> godItems;
    List<String> godItemsDescription;
    long lastGodItem;
    long lastPetCheck;
    long lowCost;
    MyTreasureHunts myTreasureHunts;
    RelativeLayout new_beginnerBoost;
    RelativeLayout new_endgameBoost;
    int rewardIconSize;
    TextView th_activeClue;
    TextView th_caskets;
    TextView th_convertScrolls;
    TextView th_discardScroll;
    TextView th_openCasket;
    TextView th_openScroll;
    LinearLayout th_rewards;
    TextView th_scrolls;
    List<String> treasureClues;
    List<String> treasureHuntRewardAmounts;
    List<Float> treasureHuntRewardChances;
    List<String> treasureHuntRewards;
    ScrollView treasureHuntScreen;
    List<String> treasureMethods;
    List<String> treasureSkills;
    
    public TreasureHunts(final MainActivity activity) {
        this.treasureClues = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "I am found in the darkness and have many eyes", "I am the Queen of a newly discovered realm", "I'm smart so I wish people would acknowledge that", "I come in many types, King is my most well known", "I am the King of the greatly feared creatures, fire is my breath", "I shall rise from the ashes and become reborn", "I lead an ancient forgotten tribe", "A peaceful place filled with birds chirping, the beating heart of the earth", "Do we really know more about space?", "How on earth did a trolley get in there?", "You may need to wrap up warm for this one", "Seriously though, who comes up with these names?", "I am found in all kinds of plants and animals across the earth and used as a defence mechanism", "Do these even work? Well, only one way to find out", "Karen, activate insta kill!", "I think we have a slight problem, that my friend is what we call a lot of snow!", "Contains information about things, well, technically this one doesn't, but usually they do", "Think of the amount of Fish I can catch with this beast!", "I aint eating that, looks like it's still on fire!", "On a diet? Nope, but this makes for some good healing", "How did I even catch this?", "Is this even edible?", "If I get caught, he better not give me a job to do", "I feel harsh pickpocketing him, but I need money too you know!", "How on earth does this not make me rich behind my wildest dreams", "It's not real, I mean, if it was it would be cool though right?", "I wonder if that's where the name comes from?", "I'm gonna take this night, and make it\u2026", "As strong as they come, very reliable", "I must be aware of all the needles", "I could make some syrup, well, not on this game, but maybe one day?", "Evergreen Tree, often red in colour", "This tree is a living fossil and has fan shaped leaves", "A bustling waterway amidst stone and steel, where the flow never sleeps.", "I prefer nice dreams", "Despite the name, I would not recommend giving this guy a cuddle.", "A great place to find a Ferris Wheel, or an Arcade. Omg Donuts and Slush!", "A hidden paradise among trees, where the waters reflect the canopy above.", "Named after a place near where I grew up. Quite a few things are actually.", "Some people say I'm your best friend. Others just see money.", "Not very comfortable to lie on", "Fair enough, I'm partially colourblind, so yes, I got this one a little off.", "I'm sorry, but I'm on Team Egg", "Can't beat a good old Bacon Butty!", "He can help me practice my bow skills, or just show off with his.", "For Cognium!", "Wood!", "Don't touch the but!", "I gotta go, we got cows", "Did I get this one right? It is blue, right?", "Don't hit me on the head", "Give a man a fish, feed him for a day. Teach a man to fish, feed him for a lifetime.", "Poor Cow", "Yeah no thanks, I don't like the dark.", "Wana bet?", "Wouldn't these be like, really heavy?", "Up in the clouds. I'm the king of the World!", "Can't touch this", "Now I know how Midas felt" }));
        this.treasureMethods = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Giant Cave Spider", "Elven Queen", "Dummy Queen", "Cobra", "King Dragon", "Phoenix", "Ancient Tribal Leader", "Woodland Lake", "Open Ocean", "Small Pond", "Frozen Wasteland", "Mount Kwaya", "Poison Potion", "Luck Potion", "Liquid Death Potion", "Avalanche Potion", "Bestiary", "Large Fishing Net", "Dragon Platter", "Fruit Salad", "Octopus", "Bone Stew", "Taskmaster", "Bard", "Gold Ore", "Dragon Ore", "Cherry Blossom Tree", "Evergreen Tree", "Oak Tree", "Pine Tree", "Maple Tree", "Cedar Tree", "Ginkgo Tree", "City River", "Nightmare", "Fluffy", "Beach Pier", "The Grove", "Livingstone Island", "Diamond", "Lion", "Green Dragon", "Chicken", "Pig", "Elven Archer", "Crocodile", "Training Dummy", "Clownfish", "Cyclone Potion", "Baby Blue Dragon", "Nails", "Fishing Net", "Leather", "Cave", "Lake Wana", "Iron Boots", "Rocky Peaks", "Invincibility Potion", "Golden Touch Potion" }));
        this.treasureSkills = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Combat", "Combat", "Combat", "Combat", "Combat", "Combat", "Combat", "Fishing", "Fishing", "Fishing", "Discovery", "Discovery", "Alchemy", "Alchemy", "Alchemy", "Alchemy", "Crafting", "Crafting", "Cooking", "Cooking", "Cooking", "Cooking", "Thieving", "Thieving", "Mining", "Mining", "Forestry", "Forestry", "Forestry", "Forestry", "Forestry", "Forestry", "Forestry", "Fishing", "Combat", "Combat", "Fishing", "Fishing", "Fishing", "Mining", "Combat", "Combat", "Combat", "Combat", "Combat", "Combat", "Combat", "Cooking", "Alchemy", "Combat", "Crafting", "Crafting", "Crafting", "Fishing", "Discovery", "Crafting", "Discovery", "Alchemy", "Alchemy" }));
        this.treasureHuntRewards = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Scythe of Noctyra", "Wings of Cognium", "Cognium Ring", "Bow of Kynosian", "Divine Protection Scroll", "Death Princess Rune", "Sword of Cognium", "Crown of Opulina", "Opulinas Robe Top", "Opulinas Robe Bottoms", "Kynosian Top", "Kynosian Legs", "Kynosian Hat", "Kynosian Gloves", "Kynosian Boots", "Scythe of Aurial", "Necklace of Amaran", "Shield of Amaran", "Plate of Feroxi", "Greaves of Feroxi", "Helm of Feroxi", "Gloves of Feroxi", "Boots of Feroxi", "Lockpick of Copina", "Stethoscope of Copina", "Sword of Feroxi", "Shield of Feroxi", "Knife of Copina", "Rod of Copina", "Pickaxe of Copina", "Hatchet of Copina", "Quiver of Kynosian", "Golden Ticket", "Eternal Ring", "Mystic Staff", "Ancient Elven Book", "Massive Exp Scroll", "Necklace of Restoration", "Chefs Hat", "Pickaxe of the Gods", "Gold Coin", "Ring of Death", "Ring of Life", "Ring of Speed", "Elven Sword", "Gold Coin", "Elven Plate", "Elven Greaves", "Elven Helm", "Elven Gloves", "Elven Boots", "Avalanche Potion", "Kings Sword", "Kings Gloves", "Kings Boots", "Kings Helm", "Kings Greaves", "Kings Top", "Gold Coin", "Elven Grace Potion", "Invincibility Potion", "Book of Aroon", "Stone Tablet", "Gold Coin", "Elven Crystal", "Queens Sword", "Coins", "Golden Touch Potion", "Queens Gloves", "Queens Boots", "Queens Helm", "Queens Greaves", "Queens Top", "Ember Fern", "Dagger of Demeter", "Pot of Gold", "Farmour Gloves", "Farmour Boots", "Farmour Helm", "Farmour Legs", "Farmour Top", "Ginkgo Arrow Shafts", "Sunburst Flower", "Liquid Death Potion", "Extreme Luck Potion", "Kynosian Arrows", "Elven Weapon Fragment", "Elven Arrows", "Dragon Platter", "Kings Arrows", "Vissinel", "Queens Arrows", "Blue Silk", "Kings Weapon Fragment", "Gold Bar", "Chestnut Arrow Shafts", "Iridium Arrows", "Rhodium Arrows", "Wolfmint", "Cog", "Sage Leaf", "Cedar Arrow Shafts", "Platinum Arrows", "Redwood Arrow Shafts", "Safflower", "Dragon Arrows", "Hyssop", "Stone Arrows", "Bloodroot", "Wood", "Feathers", "Thread", "Akomeric", "Iron Ore", "Stone" }));
        this.treasureHuntRewardAmounts = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "100000,250000", "1,1", "1,1", "1,1", "1,1", "10000,10000", "1,1", "1,1", "1,1", "1,1", "1,1", "15,20", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "5000,5000", "5,10", "10,15", "40,75", "40,75", "2000,2000", "25,50", "1,1", "10000000,100000000", "10,20", "1,1", "1,1", "1,1", "1,1", "1,1", "10,20", "1,1", "100,150", "1,1", "1,1", "1,1", "1,1", "1,1", "40,75", "15,30", "20,35", "30,40", "20,40", "5,10", "25,60", "100,200", "30,65", "15,40", "40,75", "100,250", "10,20", "100,250", "50,75", "50,100", "75,100", "15,50", "30,75", "20,60", "75,100", "100,140", "100,140", "25,65", "120,150", "30,70", "200,400", "35,75", "200,500", "200,500", "200,500", "80,120", "200,500", "200,500" }));
        this.treasureHuntRewardChances = (List<Float>)new ArrayList((Collection)Arrays.asList((Object[])new Float[] { 0.01f, 0.04f, 0.09f, 0.19f, 0.31f, 0.46f, 0.64f, 0.84f, 1.06f, 1.31f, 1.58f, 1.87f, 2.18f, 2.51f, 2.86f, 3.26f, 3.71f, 4.21f, 4.76f, 5.32f, 5.89f, 6.47f, 7.06f, 7.68f, 8.38f, 9.13f, 9.93f, 10.78f, 11.65f, 12.54f, 13.45f, 14.45f, 16.95f, 30.95f, 48.45f, 72.95f, 99.2f, 127.2f, 162.2f, 205.95f, 258.45f, 324.95f, 394.95f, 473.7f, 569.95f, 674.95f, 779.95f, 888.45f, 1000.45f, 1115.95f, 1234.95f, 1357.45f, 1486.95f, 1618.2f, 1751.2f, 1885.95f, 2022.45f, 2160.7f, 2300.7f, 2449.45f, 2601.7f, 2759.2f, 2920.2f, 3086.45f, 3252.7f, 3427.7f, 3646.45f, 3908.95f, 4188.95f, 4477.7f, 4775.2f, 5081.45f, 5396.45f, 5781.45f, 6218.95f, 6700.2f, 7225.2f, 7767.7f, 8327.7f, 8905.2f, 9500.2f, 10200.2f, 10987.7f, 11862.7f, 12825.2f, 13875.2f, 15187.7f, 16587.7f, 18162.7f, 19912.7f, 21837.7f, 24025.2f, 26475.2f, 29100.2f, 31900.2f, 34962.7f, 38112.7f, 41350.2f, 44850.2f, 48787.7f, 53162.7f, 57975.2f, 63225.2f, 68825.2f, 74950.2f, 81512.7f, 88512.7f, 96387.7f, 105137.7f, 114325.2f, 124475.2f, 135325.2f, 146700.2f, 159825.2f, 173825.2f }));
        this.godItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Sword of Feroxi", "Bow of Kynosian", "Hatchet of Copina", "Pickaxe of Copina", "Rod of Copina", "Opulinas Robe Top", "Opulinas Robe Bottoms", "Shield of Feroxi", "Quiver of Kynosian", "Scythe of Aurial", "Shield of Amaran", "Boots of Feroxi", "Gloves of Feroxi", "Plate of Feroxi", "Helm of Feroxi", "Greaves of Feroxi", "Knife of Copina", "Kynosian Boots", "Kynosian Gloves", "Kynosian Top", "Kynosian Hat", "Kynosian Legs", "Sword of Cognium", "Death Princess Rune", "Cognium Ring", "Necklace of Amaran", "Divine Protection Scroll", "Scythe of Noctyra", "Crown of Opulina", "Lockpick of Copina", "Stethoscope of Copina", "Wings of Cognium" }));
        this.godItemsDescription = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "A powerful sword which increases damage dealt by 10%", "An extremely powerful Bow that has a high crit chance and high attack speed", "25% Increased Forestry speed. 4x Logs, seed chance, and Eagles Nest Chance. Zero fail chance.", "4x all ores mined. Zero fail chance.", "4x all fish caught. Also provides the benefit of the Rod of Anuket automatically deploying nets", "When wearing the bottoms and the top and using Golden Touch Potions, you get 15 gold instead of 1", "When wearing the bottoms and the top and using Golden Touch Potions, you get 15 gold instead of 1", "Wearing the full enhanced Feroxi set gives a chance to enter Rage Mode, instantly killing the next 10 enemies", "Grants a 60% chance to save arrows when using Archery", "Doubles all crops harvested. Automatically replants seeds and harvests them. Reduces farming time by 95%", "A powerful shield that grants an insanely high health bonus", "Wearing the full enhanced Feroxi set gives a chance to enter Rage Mode, instantly killing the next 10 enemies", "Wearing the full enhanced Feroxi set gives a chance to enter Rage Mode, instantly killing the next 10 enemies", "Wearing the full enhanced Feroxi set gives a chance to enter Rage Mode, instantly killing the next 10 enemies", "Wearing the full enhanced Feroxi set gives a chance to enter Rage Mode, instantly killing the next 10 enemies", "Wearing the full enhanced Feroxi set gives a chance to enter Rage Mode, instantly killing the next 10 enemies", "Doubles all Fletched items", "A powerful piece of Archery gear, giving a high damage bonus and critical hit boost", "A powerful piece of Archery gear, giving a high damage bonus and critical hit boost", "A powerful piece of Archery gear, giving a high damage bonus and critical hit boost", "A powerful piece of Archery gear, giving a high damage bonus and critical hit boost", "A powerful piece of Archery gear, giving a high damage bonus and critical hit boost", "15% Insta Kill chance (Excludes the Immortal Realm and Kingdom of the Gods)", "Grants an 80% chance to double damage dealt, 20% chance to reduce damage dealt by 70%", "Doubles attack speed and reduces enemy spawn speed by 50%", "Grants a 25% chance to reduce incoming damage by 90%", "Unlocks the ability to brew Divine Protection Potions", "15% Insta kill chance (Excluding Gods), 1% insta kill chance against Gods. Chance to spawn Soul Gems", "When worn with the top and bottoms, Gold Coins from potions increase to 30", "Slows down the safecracking dot by 10%", "Increases the size of the safe area in safecracking by 5%", "Lowers enemy respawn by 50%, stacks with the Ring" }));
        this.lastGodItem = 0L;
        this.casketMitigation = 6500L;
        this.endgameCost = 50000L;
        this.lowCost = 1000L;
        this.allBoosts = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Curse of Noctyra", "I feel Blessed", "Secret Hunter", "Soul Hunter", "Master Cracker", "Big Box", "I got the Power", "I never miss", "Raining Fragments", "Commercial Fisher", "Loot Hunter", "New Fisher", "New Chopper", "New Miner", "Death to all", "New Power", "More Old Rod", "More Drops" }));
        final Long value = 600000L;
        this.boostDurations = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value, value, value, value, 900000L, 900000L, value, value, value, value, value, value, value, value, value, value, 300000L, value }));
        this.boostDescriptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Grants a 5% Insta Kill chance in the Kingdom of the Gods", "Grants a 0.3% chance when killing enemies above Level 150,000 to find an Enhancement Ticket", "Increases the drop rate of all Secret Rares by 10%", "Grants a 1% chance when killing enemies above Level 150,000 to find a Soul Gem", "Removes the 2 most common items from the Safecracking loot table (The bottom 2)", "Increases the size of the safe box in Safecracking by 20%", "Grants a global 15% damage buff (Applied after everything else)", "Grants 100% Accuracy, you never miss!", "Grants a 2% chance when killing enemies above Level 150,000 to find a Ring Fragment", "Multiplies all Fishing catches by 5", "Triples all enemy drops (Excluding Kingdom of the Gods)", "Grants a 10% chance to double any fish caught", "Grants a 10% chance to double any logs you chop", "Grants a 10% chance to double any ores you mine", "Grants a 3% chance to instantly kill any enemy (doesn't work in the Immortal Realm or the Kingdom of the Gods)", "Grants a global 5% damage buff (Applied after everything else)", "Grants a 20% chance to access the Old Fishing Rod loot table while killing enemies", "Grants a 25% chance to get double drops from enemies (Excludes Kingdom of the Gods)" }));
        this.boostLevels = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Endgame", "Endgame", "Endgame", "Endgame", "Endgame", "Endgame", "Endgame", "Endgame", "Endgame", "Endgame", "Endgame", "Beginner", "Beginner", "Beginner", "Beginner", "Beginner", "Beginner", "Beginner" }));
        this.boostIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131166191, 2131165507, 2131166159, 2131166237, 2131166460, 2131166460, 2131166480, 2131166468, 2131166150, 2131165949, 2131165813, 2131166475, 2131166476, 2131166478, 2131165905, 2131166086, 2131166057, 2131165964 }));
        this.rewardIconSize = 0;
        this.lastPetCheck = 0L;
        this.activity = activity;
        this.activeBoost = new ActiveBoost("", false, 0L, this.boostTimer);
    }
    
    private void CompleteClue() {
        final MyTreasureHunts myTreasureHunts = this.myTreasureHunts;
        ++myTreasureHunts.caskets;
        final int getWishLevel = this.activity.databaseManager.GetWishLevel("Scroll Solver", "Endgame");
        if (getWishLevel > 0) {
            if (this.activity.GetRandom(1, 100) <= getWishLevel) {
                this.activity.accountStats.addScrollCompleted(2);
                this.activity.QuickPopup("Your Scroll Solver wish counts the Scroll as 2!");
            }
            else {
                this.activity.accountStats.addScrollCompleted(1);
            }
        }
        else {
            this.activity.accountStats.addScrollCompleted(1);
        }
        this.activity.LargePopup(2131165669, "Reward Casket Found!", "You completed your treasure hunt and found a reward casket!");
        this.ClearActive();
    }
    
    private CountDownTimer CreateBoostTimer(final int n, final long n2) {
        return new CountDownTimer(this, n2, 1000L) {
            final TreasureHunts this$0;
            
            public void onFinish() {
                this.this$0.activeBoost.active = false;
                this.this$0.activity.LargePopup(2131165507, "Boost Ended", "Your active boost from the Gods has now ended.");
                if (this.this$0.activity.currentView == this.this$0.boostScreen) {
                    ((TextView)this.this$0.b_active.getChildAt(6)).setText((CharSequence)"This boost has ended.");
                }
            }
            
            public void onTick(long seconds) {
                this.this$0.activeBoost.timeRemaining = seconds;
                if (this.this$0.activity.currentView == this.this$0.boostScreen) {
                    final long hours = TimeUnit.MILLISECONDS.toHours(seconds);
                    final long minutes = TimeUnit.MILLISECONDS.toMinutes(seconds);
                    seconds = TimeUnit.MILLISECONDS.toSeconds(seconds);
                    ((TextView)this.this$0.b_active.getChildAt(6)).setText((CharSequence)String.format(Locale.UK, "%02d:%02d:%02d", new Object[] { hours, minutes % 60L, seconds % 60L }));
                }
            }
        };
    }
    
    private String GetMinutes(final long n) {
        return String.valueOf(n / 60000L);
    }
    
    private void HideRewardViews() {
        for (int i = 0; i < this.th_rewards.getChildCount(); ++i) {
            this.activity.HideView(this.th_rewards.getChildAt(i));
        }
    }
    
    private void OpenCasket() {
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final int getRandom = this.activity.GetRandom(2, 3);
        this.activity.LogIt("Total Rewards: " + getRandom);
        for (int i = 0; i < getRandom; ++i) {
            this.PickReward((List<String>)list, (List<Long>)list2);
        }
        this.activity.itemManager.CheckOnlineSecrets("Caskets", "Caskets");
        this.activity.combatManager.CheckSecret("Barbecue Skythe", 2131165559, 40000);
        if (this.activity.totalGameTicks - this.lastPetCheck >= 10L) {
            this.lastPetCheck = this.activity.totalGameTicks;
            if (!this.activity.myPets.contains((Object)"Cassie the Casket") && this.activity.GetRandom(1, 100000) <= 1) {
                this.activity.myPets.add((Object)"Cassie the Casket");
                this.activity.LargePopup(2131165669, "Congratulations!", "While opening Caskets you found Cassie the Casket Pet!");
            }
        }
        this.UpdateRewards((List<String>)list, (List<Long>)list2);
    }
    
    private void OpenScroll() {
        if (!this.myTreasureHunts.haveActiveScroll()) {
            this.PickTreasureHunt();
            this.UpdateScreen();
        }
        else {
            this.activity.QuickPopup("You already have an active Treasure Hunt.");
        }
    }
    
    private void PickReward(final List<String> list, final List<Long> list2) {
        final List<Float> treasureHuntRewardChances = this.treasureHuntRewardChances;
        float n = this.GetRandomFloat((float)treasureHuntRewardChances.get(treasureHuntRewardChances.size() - 1));
        if (this.activity.baseTower.baseTowerLevel >= 71) {
            final List<Float> treasureHuntRewardChances2 = this.treasureHuntRewardChances;
            n = this.GetRandomFloat((float)treasureHuntRewardChances2.get(treasureHuntRewardChances2.size() - 2));
        }
        if (this.activity.accountStats.getCasketsOpened() - this.lastGodItem >= this.casketMitigation) {
            n = this.GetRandomFloat((float)this.treasureHuntRewardChances.get(31));
            this.lastGodItem = this.activity.accountStats.getCasketsOpened();
        }
        int i = 0;
        while (i < this.treasureHuntRewards.size()) {
            if (n < (float)this.treasureHuntRewardChances.get(i)) {
                final String s = (String)this.treasureHuntRewards.get(i);
                final String[] split = ((String)this.treasureHuntRewardAmounts.get(i)).split("\\s*,\\s*");
                long long1;
                if (split[0].equals((Object)split[1])) {
                    long1 = Long.parseLong(split[1]);
                }
                else {
                    long1 = this.activity.GetRandom(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                }
                if (list.contains((Object)s)) {
                    list2.set(list.indexOf((Object)s), (Object)((long)list2.get(list.indexOf((Object)s)) + long1));
                    break;
                }
                list.add((Object)s);
                list2.add((Object)long1);
                break;
            }
            else {
                ++i;
            }
        }
    }
    
    private void PickTreasureHunt() {
        this.myTreasureHunts.activeScroll = true;
        final int nextInt = new Random().nextInt(this.treasureClues.size());
        this.myTreasureHunts.activeScrollMethod = (String)this.treasureMethods.get(nextInt);
        this.myTreasureHunts.activeScrollClue = (String)this.treasureClues.get(nextInt);
        this.myTreasureHunts.activeScrollSkill = (String)this.treasureSkills.get(nextInt);
        this.UpdateScreen();
    }
    
    private void SetActiveBoost(final int n) {
        this.activeBoost.active = false;
        if (this.activeBoost.timer != null) {
            this.activeBoost.timer.cancel();
        }
        this.activeBoost.boost = (String)this.allBoosts.get(n);
        this.activeBoost.active = true;
        final long longValue = (long)this.boostDurations.get(n);
        final int getWishLevel = this.activity.databaseManager.GetWishLevel("Boosty McBoost", "Endgame");
        long n2 = longValue;
        if (getWishLevel > 0) {
            n2 = longValue + getWishLevel * 30000L;
        }
        final CountDownTimer createBoostTimer = this.CreateBoostTimer(n, n2);
        this.boostTimer = createBoostTimer;
        (this.activeBoost.timer = createBoostTimer).start();
        this.UpdateBoosts();
    }
    
    private void UpdateBoosts() {
        if (this.activeBoost.isActive()) {
            this.activity.ShowView((View)this.b_active);
            final int index = this.allBoosts.indexOf((Object)this.activeBoost.getBoost());
            final long longValue = (long)this.boostDurations.get(index);
            final int getWishLevel = this.activity.databaseManager.GetWishLevel("Boosty McBoost", "Endgame");
            long n = longValue;
            if (getWishLevel > 0) {
                n = longValue + getWishLevel * 30000L;
            }
            long n2;
            if (((String)this.boostLevels.get(index)).equals((Object)"Endgame")) {
                n2 = this.endgameCost;
            }
            else {
                n2 = this.lowCost;
            }
            Picasso.get().load((int)this.boostIcons.get(this.allBoosts.indexOf((Object)this.activeBoost.getBoost()))).into((ImageView)this.b_active.getChildAt(0));
            ((TextView)this.b_active.getChildAt(2)).setText((CharSequence)this.activeBoost.getBoost());
            ((TextView)this.b_active.getChildAt(4)).setText((CharSequence)this.boostDescriptions.get(index));
            ((TextView)this.b_active.getChildAt(7)).setText((CharSequence)("+" + n / 60000L + " Minutes for " + this.activity.FormatExp(n2) + " Gold"));
            this.b_active.getChildAt(7).setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda0(this, n2, index, n));
        }
        else {
            this.activity.HideView((View)this.b_active);
        }
    }
    
    private void UpdateRewards(final List<String> list, final List<Long> list2) {
        for (int i = 0; i < this.th_rewards.getChildCount(); ++i) {
            if (i >= list.size()) {
                this.th_rewards.getChildAt(i).setVisibility(8);
            }
        }
        for (int j = 0; j < list.size(); ++j) {
            final String s = (String)list.get(j);
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
                case 224325123: {
                    if (!s.equals((Object)"Golden Ticket")) {
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
            final int n2 = 2131165478;
            switch (n) {
                default: {
                    this.activity.GiveItem((String)list.get(j), (long)list2.get(j), false);
                    if (this.godItems.contains(list.get(j))) {
                        final MainActivity activity = this.activity;
                        activity.LargePopup((int)activity.allItemsIcons.get(this.activity.allItems.indexOf(list.get(j))), "Congratulations!", "You opened a Casket and found " + (String)list.get(j));
                        this.activity.accountStats.addGodItemFound(1);
                        this.lastGodItem = this.activity.accountStats.getCasketsOpened();
                        break;
                    }
                    break;
                }
                case 3: {
                    final MainActivity activity2 = this.activity;
                    activity2.totalGems += (long)list2.get(j);
                    break;
                }
                case 2: {
                    final SecretPathway.MyPath myPath = this.activity.secretPathway.myPath;
                    myPath.goldenTickets += (long)list2.get(j);
                    this.activity.LargePopup(2131165478, "Golden Ticket", "While opening caskets, you find a Golden Ticket!");
                    break;
                }
                case 1: {
                    final MainActivity activity3 = this.activity;
                    activity3.totalCoins += (long)list2.get(j);
                    break;
                }
                case 0: {
                    final MyTreasureHunts myTreasureHunts = this.myTreasureHunts;
                    myTreasureHunts.caskets += (int)(long)list2.get(j);
                    break;
                }
            }
            final LinearLayout linearLayout = (LinearLayout)this.th_rewards.getChildAt(j);
            this.activity.ShowView((View)linearLayout);
            int intValue;
            if (((String)list.get(j)).equals((Object)"Golden Ticket")) {
                intValue = n2;
            }
            else {
                try {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(list.get(j)));
                }
                catch (final IndexOutOfBoundsException ex) {
                    intValue = 2131166220;
                }
            }
            if (this.rewardIconSize == 0) {
                this.rewardIconSize = linearLayout.getChildAt(0).getWidth();
                Picasso.get().load(intValue).into((ImageView)linearLayout.getChildAt(0));
            }
            else {
                final RequestCreator load = Picasso.get().load(intValue);
                final int rewardIconSize = this.rewardIconSize;
                load.resize(rewardIconSize, rewardIconSize).into((ImageView)linearLayout.getChildAt(0));
            }
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)list.get(j));
            ((TextView)linearLayout.getChildAt(2)).setText((CharSequence)("x" + this.activity.FormatExp((long)list2.get(j))));
        }
        this.activity.UpdateCash();
    }
    
    private void ViewSpecialLoot() {
        this.activity.LoadItemSelect("Possible Special Loot");
        this.activity.itemSelect_wrap.removeAllViews();
        for (int i = 0; i < this.godItems.size(); ++i) {
            final MainActivity activity = this.activity;
            this.activity.itemSelect_wrap.addView((View)activity.AddDescriptiveItemSelectItem((int)activity.allItemsIcons.get(this.activity.allItems.indexOf(this.godItems.get(i))), (String)this.godItems.get(i), (String)this.godItemsDescription.get(i)));
        }
    }
    
    public boolean BoostActive(final String s) {
        final boolean equals = this.activeBoost.getBoost().equals((Object)s);
        boolean b = false;
        if (equals) {
            b = (this.activeBoost.isActive() || b);
        }
        return b;
    }
    
    public void CheckTreasureHunts(final String s, final String s2) {
        final MyTreasureHunts myTreasureHunts = this.myTreasureHunts;
        if (myTreasureHunts != null && myTreasureHunts.haveActiveScroll() && this.myTreasureHunts.getActiveScrollSkill().equals((Object)s) && this.myTreasureHunts.activeScrollMethod.equals((Object)s2) && this.activity.GetRandom(1, 100) <= 10) {
            this.CompleteClue();
        }
    }
    
    public void ClearActive() {
        this.myTreasureHunts.activeScroll = false;
        this.myTreasureHunts.activeScrollMethod = "";
        this.myTreasureHunts.activeScrollClue = "";
        this.myTreasureHunts.activeScrollSkill = "";
    }
    
    public float GetRandomFloat(final float n) {
        return this.activity.randomGenerator.nextFloat() * n;
    }
    
    public void New() {
        this.myTreasureHunts = new MyTreasureHunts(0, 0, false, "", "", "");
    }
    
    public void NewPresent() {
        this.eventPresent = new EventPresent(0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0, 0L, 0, 0L, "");
    }
    
    public void OpenBoosts() {
        if (this.boostScreen == null) {
            final ScrollView boostScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131296400)).inflate();
            this.boostScreen = boostScreen;
            this.b_active = (LinearLayout)boostScreen.findViewById(2131296363);
            this.b_possiblesEndgame = (TextView)this.boostScreen.findViewById(2131296364);
            this.b_possiblesLow = (TextView)this.boostScreen.findViewById(2131296365);
            this.new_beginnerBoost = (RelativeLayout)this.boostScreen.findViewById(2131296915);
            this.new_endgameBoost = (RelativeLayout)this.boostScreen.findViewById(2131296916);
        }
        this.activity.EnableLayout((ViewGroup)this.boostScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.boostScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.UpdateBoosts();
        ((TextView)((LinearLayout)this.new_beginnerBoost.getChildAt(0)).getChildAt(1)).setText((CharSequence)this.activity.FormatExp(this.lowCost));
        ((TextView)((LinearLayout)this.new_endgameBoost.getChildAt(0)).getChildAt(1)).setText((CharSequence)this.activity.FormatExp(this.endgameCost));
        this.b_possiblesEndgame.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda6(this));
        this.b_possiblesLow.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda7(this));
        this.new_endgameBoost.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda8(this));
        this.new_beginnerBoost.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda9(this));
    }
    
    public void OpenTreasureHunts() {
        if (this.treasureHuntScreen == null) {
            final ScrollView treasureHuntScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297280)).inflate();
            this.treasureHuntScreen = treasureHuntScreen;
            this.th_activeClue = (TextView)treasureHuntScreen.findViewById(2131297234);
            this.th_scrolls = (TextView)this.treasureHuntScreen.findViewById(2131297241);
            this.th_caskets = (TextView)this.treasureHuntScreen.findViewById(2131297235);
            this.th_openScroll = (TextView)this.treasureHuntScreen.findViewById(2131297239);
            this.th_discardScroll = (TextView)this.treasureHuntScreen.findViewById(2131297237);
            this.th_openCasket = (TextView)this.treasureHuntScreen.findViewById(2131297238);
            this.th_rewards = (LinearLayout)this.treasureHuntScreen.findViewById(2131297240);
            this.casketPurchase1 = (LinearLayout)this.treasureHuntScreen.findViewById(2131296422);
            this.casketPurchase2 = (LinearLayout)this.treasureHuntScreen.findViewById(2131296423);
            this.casketPurchase3 = (LinearLayout)this.treasureHuntScreen.findViewById(2131296424);
            this.th_convertScrolls = (TextView)this.treasureHuntScreen.findViewById(2131297236);
            this.doubleCaskets = (TextView)this.treasureHuntScreen.findViewById(2131296565);
        }
        this.activity.EnableLayout((ViewGroup)this.treasureHuntScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.treasureHuntScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        if (this.activity.billingInitialized && !this.activity.inAppProducts.isEmpty() && this.activity.skuNames.contains((Object)"event_pack1") && this.activity.skuNames.contains((Object)"event_pack2") && this.activity.skuNames.contains((Object)"event_pack3")) {
            final Integer[] array = { 100, 350, 1000 };
            final ProductDetails productDetails = (ProductDetails)this.activity.inAppProducts.get(this.activity.skuNames.indexOf((Object)"event_pack1"));
            final ProductDetails productDetails2 = (ProductDetails)this.activity.inAppProducts.get(this.activity.skuNames.indexOf((Object)"event_pack2"));
            final ProductDetails productDetails3 = (ProductDetails)this.activity.inAppProducts.get(this.activity.skuNames.indexOf((Object)"event_pack3"));
            if (this.activity.accountType.equals((Object)"Ironman")) {
                ((TextView)this.casketPurchase1.getChildAt(3)).setText((CharSequence)"N/A");
                ((TextView)this.casketPurchase2.getChildAt(3)).setText((CharSequence)"N/A");
                ((TextView)this.casketPurchase3.getChildAt(3)).setText((CharSequence)"N/A");
            }
            else {
                ((TextView)this.casketPurchase1.getChildAt(3)).setText((CharSequence)((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)productDetails.getOneTimePurchaseOfferDetails())).getFormattedPrice());
                ((TextView)this.casketPurchase2.getChildAt(3)).setText((CharSequence)((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)productDetails2.getOneTimePurchaseOfferDetails())).getFormattedPrice());
                ((TextView)this.casketPurchase3.getChildAt(3)).setText((CharSequence)((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)productDetails3.getOneTimePurchaseOfferDetails())).getFormattedPrice());
            }
            ((TextView)this.casketPurchase1.getChildAt(1)).setText((CharSequence)("x" + (Object)array[0]));
            ((TextView)this.casketPurchase2.getChildAt(1)).setText((CharSequence)("x" + (Object)array[1]));
            ((TextView)this.casketPurchase3.getChildAt(1)).setText((CharSequence)("x" + (Object)array[2]));
            this.casketPurchase1.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda12(this, productDetails));
            this.casketPurchase2.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda13(this, productDetails2));
            this.casketPurchase3.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda14(this, productDetails3));
        }
        else {
            ((TextView)this.casketPurchase1.getChildAt(3)).setText((CharSequence)"Error");
            ((TextView)this.casketPurchase2.getChildAt(3)).setText((CharSequence)"Error");
            ((TextView)this.casketPurchase3.getChildAt(3)).setText((CharSequence)"Error");
        }
        if (this.activity.databaseManager.doubleCasketsAvailable) {
            this.activity.ShowView((View)this.doubleCaskets);
        }
        else {
            this.activity.HideView((View)this.doubleCaskets);
        }
        this.UpdateScreen();
        this.th_openScroll.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda1(this));
        this.th_discardScroll.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda2(this));
        this.th_openCasket.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda3(this));
        if (this.activity.baseTower.baseTowerLevel >= 74) {
            this.th_convertScrolls.setText((CharSequence)"Convert 2 Scrolls to 1 Casket");
        }
        else {
            this.th_convertScrolls.setText((CharSequence)"Convert 3 Scrolls to 1 Casket");
        }
        this.th_convertScrolls.setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda4(this));
        this.activity.findViewById(2131297242).setOnClickListener((View$OnClickListener)new TreasureHunts$$ExternalSyntheticLambda5(this));
    }
    
    public void SimLoot(final long n) {
        this.activity.LogIt("Opening: " + n + " Caskets");
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        int n2 = 0;
        while (true) {
            final long n3 = n2;
            if (n3 >= n) {
                break;
            }
            final int getRandom = this.activity.GetRandom(2, 3);
            if (n2 > 0 && n3 % (n / 100L) == 0L) {
                this.activity.LogIt("Opened: " + n2);
            }
            for (int i = 0; i < getRandom; ++i) {
                this.PickReward((List<String>)list, (List<Long>)list2);
            }
            if (n3 == n - 1L) {
                for (int j = 0; j < ((List)list).size(); ++j) {
                    if (this.godItems.contains(((List)list).get(j))) {
                        this.activity.LogIt("Loot from " + n + ", " + (String)((List)list).get(j) + " " + ((List)list2).get(j));
                    }
                }
            }
            ++n2;
        }
    }
    
    public void UpdateScreen() {
        if (this.myTreasureHunts.haveActiveScroll()) {
            if (!this.th_activeClue.getText().equals(this.myTreasureHunts.getActiveScrollClue())) {
                this.th_activeClue.setText((CharSequence)this.myTreasureHunts.getActiveScrollClue());
            }
        }
        else if (!this.th_activeClue.getText().equals("No Active Treasure Hunt. Open a Scroll to start a Treasure Hunt!")) {
            this.th_activeClue.setText((CharSequence)"No Active Treasure Hunt. Open a Scroll to start a Treasure Hunt!");
        }
        final String formatExp = this.activity.FormatExp(this.myTreasureHunts.getScrolls());
        if (!this.th_scrolls.getText().equals(formatExp)) {
            this.th_scrolls.setText((CharSequence)formatExp);
        }
        final String formatExp2 = this.activity.FormatExp(this.myTreasureHunts.getCaskets());
        if (!this.th_caskets.getText().equals(formatExp2)) {
            this.th_caskets.setText((CharSequence)formatExp2);
        }
        if (this.th_rewards.getChildAt(0).getVisibility() == 0) {
            this.HideRewardViews();
        }
    }
    
    public static class ActiveBoost
    {
        boolean active;
        String boost;
        long timeRemaining;
        CountDownTimer timer;
        
        public ActiveBoost(final String boost, final boolean active, final long timeRemaining, final CountDownTimer timer) {
            this.boost = boost;
            this.active = active;
            this.timeRemaining = timeRemaining;
            this.timer = timer;
        }
        
        public String getBoost() {
            return this.boost;
        }
        
        public long getTimeRemaining() {
            return this.timeRemaining;
        }
        
        public CountDownTimer getTimer() {
            return this.timer;
        }
        
        public boolean isActive() {
            return this.active;
        }
    }
    
    public static class EventPresent
    {
        String activeEvent;
        int birthdayPresents;
        int blueTreatBags;
        int chocolateBoxes;
        int christmasCrackers;
        int communityEggsFound;
        int easterEggs;
        int goldenCrackers;
        int goldenEggs;
        int goldenEggsOpened;
        long opened;
        int presents;
        long presentsOpened;
        int redTreatBags;
        int specialCurrency;
        long specialCurrencyOpened;
        int treatBags;
        int yellowTreatBags;
        long yellowtreatBagsOpened;
        
        public EventPresent(final int presents, final long opened, final int treatBags, final int christmasCrackers, final int goldenCrackers, final int chocolateBoxes, final int easterEggs, final int goldenEggs, final int communityEggsFound, final int goldenEggsOpened, final int blueTreatBags, final int yellowTreatBags, final int redTreatBags, final long yellowtreatBagsOpened, final int birthdayPresents, final long presentsOpened, final int specialCurrency, final long specialCurrencyOpened, final String activeEvent) {
            this.presents = presents;
            this.opened = opened;
            this.treatBags = treatBags;
            this.christmasCrackers = christmasCrackers;
            this.goldenCrackers = goldenCrackers;
            this.chocolateBoxes = chocolateBoxes;
            this.easterEggs = easterEggs;
            this.goldenEggs = goldenEggs;
            this.communityEggsFound = communityEggsFound;
            this.goldenEggsOpened = goldenEggsOpened;
            this.blueTreatBags = blueTreatBags;
            this.yellowTreatBags = yellowTreatBags;
            this.redTreatBags = redTreatBags;
            this.yellowtreatBagsOpened = yellowtreatBagsOpened;
            this.birthdayPresents = birthdayPresents;
            this.presentsOpened = presentsOpened;
            this.specialCurrency = specialCurrency;
            this.specialCurrencyOpened = specialCurrencyOpened;
            this.activeEvent = activeEvent;
        }
        
        public String getActiveEvent() {
            return this.activeEvent;
        }
        
        public int getBirthdayPresents() {
            return this.birthdayPresents;
        }
        
        public int getBlueTreatBags() {
            return this.blueTreatBags;
        }
        
        public int getChocolateBoxes() {
            return this.chocolateBoxes;
        }
        
        public int getChristmasCrackers() {
            return this.christmasCrackers;
        }
        
        public int getCommunityEggsFound() {
            return this.communityEggsFound;
        }
        
        public int getEasterEggs() {
            return this.easterEggs;
        }
        
        public int getGoldenCrackers() {
            return this.goldenCrackers;
        }
        
        public int getGoldenEggs() {
            return this.goldenEggs;
        }
        
        public int getGoldenEggsOpened() {
            return this.goldenEggsOpened;
        }
        
        public long getOpened() {
            return this.opened;
        }
        
        public long getPresentsOpened() {
            return this.presentsOpened;
        }
        
        public int getRedTreatBags() {
            return this.redTreatBags;
        }
        
        public int getSpecialCurrency() {
            return this.specialCurrency;
        }
        
        public long getSpecialCurrencyOpened() {
            return this.specialCurrencyOpened;
        }
        
        public int getYellowTreatBags() {
            return this.yellowTreatBags;
        }
        
        public long getYellowtreatBagsOpened() {
            return this.yellowtreatBagsOpened;
        }
    }
    
    public static class MyTreasureHunts
    {
        boolean activeScroll;
        String activeScrollClue;
        String activeScrollMethod;
        String activeScrollSkill;
        int caskets;
        int scrolls;
        
        public MyTreasureHunts(final int scrolls, final int caskets, final boolean activeScroll, final String activeScrollClue, final String activeScrollMethod, final String activeScrollSkill) {
            this.scrolls = scrolls;
            this.caskets = caskets;
            this.activeScroll = activeScroll;
            this.activeScrollClue = activeScrollClue;
            this.activeScrollMethod = activeScrollMethod;
            this.activeScrollSkill = activeScrollSkill;
        }
        
        public String getActiveScrollClue() {
            return this.activeScrollClue;
        }
        
        public String getActiveScrollMethod() {
            return this.activeScrollMethod;
        }
        
        public String getActiveScrollSkill() {
            return this.activeScrollSkill;
        }
        
        public int getCaskets() {
            return this.caskets;
        }
        
        public int getScrolls() {
            return this.scrolls;
        }
        
        public boolean haveActiveScroll() {
            return this.activeScroll;
        }
    }
}
