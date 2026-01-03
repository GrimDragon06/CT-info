package uk.playdrop.cherrytree_idletextrpg;

import android.view.ContextThemeWrapper;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout$LayoutParams;
import com.squareup.picasso.Picasso;
import java.util.Iterator;
import android.text.style.ForegroundColorSpan;
import android.text.SpannableString;
import android.widget.ProgressBar;
import android.view.View;
import android.content.res.Resources$NotFoundException;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.GridLayout;
import android.widget.TextView;
import java.util.List;

public class Discovery
{
    Maze activeMaze;
    MainActivity activity;
    List<String> allLoot;
    List<Long> allLootAmounts;
    List<Maze> allMazes;
    TextView backToMazes;
    TextView centreInfo;
    TextView centreTitle;
    TextView currentEnergy;
    List<String> currentPath;
    int currentStep;
    int currentZone;
    GridLayout directions;
    TextView discoverAllButton;
    ConstraintLayout discoveryArea;
    int discoveryFailChance;
    RelativeLayout discoveryGrid;
    LinearLayout discoveryGridLayout;
    RelativeLayout discoverySkillProgress;
    int drakesDiscoveries;
    List<String> explorationArea;
    List<Long> explorationEnergy;
    List<Long> explorationExperience;
    List<Integer> explorationLevel;
    List<List<String>> explorationLoot;
    List<List<Long>> explorationLootAmount;
    List<List<Long>> explorationLootChance;
    List<Integer> explorationSteps;
    boolean generatedGrid;
    int gridSize;
    List<RelativeLayout> gridTiles;
    long lastGridClick;
    long lastInstaClick;
    long lastMazeClick;
    List<String> lootTable;
    int maxMazes;
    LinearLayout mazeCentre;
    ImageView mazeEnemy;
    LinearLayout mazePath;
    LinearLayout mazeRewards;
    TextView mazeRewardsMessage;
    ScrollView mazeScreen;
    TextView mazeTitle;
    LinearLayout mazeWrap;
    int mazesComplete;
    List<Long> metalDetectorDropAmounts;
    List<Float> metalDetectorDropOdds;
    List<String> metalDetectorDropTable;
    List<String> navigationArea;
    List<Long> navigationAreaExp;
    List<String> navigationAreaItems;
    List<Integer> navigationAreaLevel;
    TextView newExploration;
    TextView pathsComplete;
    List<List<Integer>> possibleEnemyDamage;
    List<Integer> possibleFailHealthLoss;
    List<String> possibleFailMessages;
    List<String> possibleSuccessMessages;
    List<List<String>> possibleWildEnemies;
    Random random;
    TextView returnDiscovery;
    ScrollView singleMazeScreen;
    List<String> steps;
    int tileSize;
    
    public Discovery(final MainActivity activity) {
        this.discoveryFailChance = 25;
        final Integer value = 10;
        final Integer value2 = 0;
        final Integer value3 = 4;
        final Integer value4 = 5;
        final Integer value5 = 6;
        final Integer value6 = 8;
        this.navigationArea = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Forest Oasis", "Lake Wana", "Island Oasis", "Rocky Peaks", "Mount Desmond", "Frozen Wasteland", "Mystery Island", "Mount Kwaya", "The Other Side", "Wasteland Volcano" }));
        this.navigationAreaItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Akomeric,Birds Nest,Mushroom,Hide,Sandstone,Candle,Thread,Bag of Flour", "Akomeric,Wood,Hide,Stone,Molten Glass,Blue Thread,Nails", "Bloodroot,Wood,Iron Ore,Stone,Sandstone,Gold Feather,Mushroom,Pirates Hat,Mystery Egg", "Bloodroot,Iron Ore,Molten Glass,Rope,Oak,Nails,Bag of Flour", "Hyssop,Mithril Ore,Bag of Pearls,Bananas,Candle,Thread,Blue Buttons", "Safflower,Carving Knife,Pearl,Message in a Bottle,Steak,Yarn", "Bones,Akomeric,Bloodroot,Hyssop,Safflower,Sage Leaf,Wolfmint,Vissinel,Steak,Large Fishing Net,Crystal Chest", "Sage Leaf,Ram Skull,Oak,Compass,Blue Feather,Gold Feather,Jawbone,Fish Hook,Fishing Net", "Wolfmint,Sunburst Flower,Treasure Map,Oak,Mithril Ore,Steel Bar,Empty Vial,Thread,Hide,Fishing Net", "Vissinel,Ember Fern,Mithril Ore,Blueprints,Waterskin,Rope,Fishing Net,Dragon Ore,Crystal Key" }));
        this.navigationAreaLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 1, value, 20, 30, 45, 60, 65, 75, 90, 99 }));
        final Long value7 = 10L;
        final Long value8 = 25L;
        this.navigationAreaExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value7, value8, 50L, 75L, 120L, 250L, 1000L, 500L, 1000L, 1800L }));
        this.gridSize = 5;
        this.tileSize = 0;
        this.generatedGrid = false;
        this.gridTiles = (List<RelativeLayout>)new ArrayList();
        this.lootTable = (List<String>)new ArrayList();
        this.currentZone = 0;
        this.lastGridClick = 0L;
        this.lastInstaClick = 0L;
        this.drakesDiscoveries = 25;
        this.explorationArea = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Dryadalis", "Cragnum", "Hydrelos", "Silvanium", "Spelithos", "Auranium", "Polisoros", "Empyreon" }));
        this.explorationLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 40, 55, 70, 90, 99, 105, 115, 130 }));
        final Integer value9 = 12;
        this.explorationSteps = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value3, value4, value5, 7, value6, 9, value, value9 }));
        this.explorationExperience = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 100L, 250L, 500L, 1000L, 2100L, 4500L, 7500L, 15000L }));
        final Long value10 = 5L;
        final Long value11 = 20L;
        this.explorationEnergy = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value10, value7, value11, 40L, 60L, 80L, 120L, 160L }));
        final List list = Arrays.asList((Object[])new String[] { "Challenger Boots", "Gold Coin", "Rod of Anuket", "Ancient Rod", "Chicken Knife", "Killcoins", "Gold Coin", "Energy Potion", "Orange", "Stone Arrows", "Wool" });
        final List list2 = Arrays.asList((Object[])new String[] { "Challenger Gloves", "Gold Coin", "Cauldron", "Drakes Diary", "Killcoins", "Gold Coin", "Red Chest", "Red Key", "Super Energy Potion", "Luck Potion", "Coin Purse" });
        final List list3 = Arrays.asList((Object[])new String[] { "Challenger Hat", "Gold Coin", "Mystic Hat", "Super Power Stone", "Killcoins", "Gold Coin", "Nefrit Chest", "Nefrit Key", "Super Energy Potion", "Cedar Log", "Cog", "Blueberry" });
        final List list4 = Arrays.asList((Object[])new String[] { "Challenger Legs", "Gold Coin", "Extreme Power Stone", "Coins", "Killcoins", "Gold Coin", "Crystal Chest", "Crystal Key", "Liquid Death Potion", "Super Energy Potion", "Rock Skin Potion", "Lightning Potion", "Grapes" });
        final List list5 = Arrays.asList((Object[])new String[] { "Challenger Top", "Gold Coin", "Book of Death", "Magic Watering Can", "Ring of Death", "Gold Coin", "Soul Gem", "Eagles Nest", "Farm Chest", "Farm Key", "Platinum Ore", "Redwood Log" });
        final List list6 = Arrays.asList((Object[])new String[] { "Opulinas Robe Bottoms", "Gold Coin", "Book of Necromancy", "Scythe of Demeter", "Ring of Speed", "Gold Coin", "Queens Chest", "Queens Key", "Golden Touch Potion", "Invincibility Potion", "Extreme Power Potion", "Cherry Blossom Log", "Mahogany Log" });
        final List list7 = Arrays.asList((Object[])new String[] { "Opulinas Robe Top", "Mystic Staff", "Blessed Sacrifice", "Gold Coin", "Ring Fragments", "Ring of Life", "Barbarian Top", "Divine Protection Potion", "Soul Reaper Potion", "Kings Chest", "Kings Key", "Book of Aroon", "Chestnut Log", "Rhodium Ore" });
        final Integer value12 = 15;
        this.explorationLoot = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { list, list2, list3, list4, list5, list6, list7, Arrays.asList((Object[])new String[] { "Crown of Opulina", "Eternal Ring", "Necklace of Restoration", "Enhancement Ticket", "Chefs Hat", "Gold Coin", "Kynosian Arrows", "Ring Fragments", "Casket of Treasure", "Soul Gem", "Pumpkin", "Elven Armour Fragment", "Elven Weapon Fragment", "Elven Chest", "Elven Key", "Iridium Ore", "Ginkgo Log", "Elven Crystal", "Milk" }) }));
        final Long value13 = 1L;
        this.explorationLootAmount = (List<List<Long>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Long[] { value13, 100L, value13, value13, value13, value10, value7, 2L, value11, 15L, value10 }), Arrays.asList((Object[])new Long[] { value13, 250L, value13, value13, value7, value8, value10, value10, 2L, value7, value7 }), Arrays.asList((Object[])new Long[] { value13, 500L, value13, value13, value8, 50L, value7, value7, value10, value11, value7, value7 }), Arrays.asList((Object[])new Long[] { value13, 1000L, value13, 1000000L, 50L, 100L, value7, value7, value7, value7, value7, value7, value7 }), Arrays.asList((Object[])new Long[] { value13, 2500L, value13, value13, value13, 250L, value13, value7, value7, value7, value11, value11 }), Arrays.asList((Object[])new Long[] { value13, 5000L, value13, value13, value13, 500L, value7, value7, value7, value8, value8, value8, value8 }), Arrays.asList((Object[])new Long[] { value13, value13, value13, 10000L, value7, value13, value13, value10, value10, value11, value11, value10, value8, value8 }), Arrays.asList((Object[])new Long[] { value13, value13, value13, 2L, value13, 20000L, value11, 30L, value7, value10, 15L, value10, value10, 40L, 40L, 50L, 50L, value7, 50L }) }));
        this.explorationLootChance = (List<List<Long>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Long[] { value13, 3L, 6L, 11L, 19L, 34L, 59L, 99L, 174L, 324L, 524L }), Arrays.asList((Object[])new Long[] { value13, 3L, 6L, 11L, 21L, 41L, 91L, 141L, 231L, 381L, 581L }), Arrays.asList((Object[])new Long[] { value13, 3L, 6L, 11L, 21L, 46L, 86L, 126L, 186L, 261L, 411L, 611L }), Arrays.asList((Object[])new Long[] { value13, 3L, 6L, 11L, 19L, 31L, 66L, 101L, 161L, 241L, 391L, 591L, 831L }), Arrays.asList((Object[])new Long[] { value13, 3L, 6L, 11L, 19L, 31L, 46L, 96L, 186L, 276L, 476L, 716L }), Arrays.asList((Object[])new Long[] { value13, 3L, 6L, value7, 18L, 30L, 105L, 180L, 280L, 420L, 620L, 870L, 1220L }), Arrays.asList((Object[])new Long[] { value13, 3L, 6L, value7, 15L, 23L, 33L, 45L, 65L, 185L, 305L, 505L, 765L, 1115L }), Arrays.asList((Object[])new Long[] { value13, 3L, 6L, value7, 15L, 21L, 28L, 36L, 48L, 63L, 113L, 233L, 353L, 503L, 683L, 903L, 1153L, 1453L, 1803L }) }));
        this.possibleFailMessages = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "You hit a dead end. Time to backtrack!", "A mysterious force pushes you back. Try another path.", "Thorns block your way, damaging you for 10% of your max health and forcing you to turn around.", "A thick fog engulfs you, making it impossible to continue.", "You step into a pitfall, dealing 20% of your health as damage! Thankfully, you climb out, but must go back.", "The path ahead is crumbling. There\u2019s no way forward.", "Strange whispers echo in your ears. Something tells you to turn back.", "A hidden trap activates, sending you tumbling to where you started. You take damage for 5% of your max health", "The walls shift, closing off your path. You need a new route.", "A ghostly figure blocks your way, shaking its head. Wrong choice.", "A gust of wind howls through the corridor, forcing you to retreat.", "You wade into deep water, but it\u2019s impassable. You must turn back.", "A swarm of bats screeches at you, preventing you from moving forward and damaging you for 25% of your max health.", "A chilling presence makes you uneasy. Something tells you to leave.", "The ground beneath you trembles. It\u2019s too dangerous to continue this way.", "Your instincts scream at you\u2014this isn\u2019t the right way.", "You feel like you've been here before\u2026 You're going in circles!", "A heavy door slams shut ahead. There\u2019s no way to open it.", "Vines creep toward you, blocking the path. You need to turn around.", "A strange mist warps your vision. You can\u2019t tell what\u2019s ahead. Best to retreat.", "While travelling you wander across a wild %1$s, which attacks you and deals %2$d%% of your max health as damage!" }));
        this.possibleFailHealthLoss = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value2, value2, value, value2, 20, value2, value2, value4, value2, value2, value2, value2, 25, value2, value2, value2, value2, value2, value2, value2, value2 }));
        this.possibleSuccessMessages = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "You feel a gentle breeze guiding you forward. This must be the right way!", "The path ahead is clear and inviting. You move forward with confidence.", "You hear distant echoes of footsteps\u2014others must have passed this way.", "A warm light flickers ahead, reassuring you that you\u2019re on the right track.", "The air feels lighter, and your instincts tell you this is the way forward.", "You spot faint markings on the walls\u2014signs that this path is well-traveled.", "Your footsteps sound steady, and an unknown force urges you onward.", "The path slopes gently downward, leading you deeper into the unknown.", "You notice fresh footprints in the dust\u2014someone else made it this way.", "A carved symbol on a stone matches the clues you\u2019ve found. You proceed!", "A gust of fresh air brushes against you, filling you with determination.", "The flickering torchlight ahead reassures you\u2014this path feels safe.", "You hear the soft trickling of water nearby. Progress is within reach!", "A faint glow shimmers in the distance. This must be the right direction.", "You step carefully and feel the ground firm beneath your feet. No traps here!", "Your instincts are sharp\u2014every step forward feels like the right choice.", "You hear the faint sound of music, as if welcoming you forward.", "The air smells fresh, free of decay or danger. You press on with confidence.", "A familiar landmark reassures you\u2014you\u2019ve chosen correctly.", "Your heart pounds with excitement. You can sense you're getting closer!" }));
        this.possibleWildEnemies = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "Chicken", "Crow", "Rat" }), Arrays.asList((Object[])new String[] { "Young Goblin", "Sheep", "Goblin Grump" }), Arrays.asList((Object[])new String[] { "Wolf", "Ox", "Cyclops", "Goblin Chief" }), Arrays.asList((Object[])new String[] { "Cave Beast", "Brown Bear", "Giant Cave Spider" }), Arrays.asList((Object[])new String[] { "Skeletal Bear", "Undead Dragon", "Necromancer" }), Arrays.asList((Object[])new String[] { "Ancient Dragon", "Green Dragon", "Water Dragon", "King Dragon" }), Arrays.asList((Object[])new String[] { "Scarab Queen", "Bone King", "Skeletal King", "Orc King" }), Arrays.asList((Object[])new String[] { "Elven Mage", "Elven King", "Elven Queen" }) }));
        this.possibleEnemyDamage = (List<List<Integer>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Integer[] { 2, 3, value3 }), Arrays.asList((Object[])new Integer[] { value4, value5, value6 }), Arrays.asList((Object[])new Integer[] { value6, value, value9, value12 }), Arrays.asList((Object[])new Integer[] { value12, 18, 20 }), Arrays.asList((Object[])new Integer[] { 22, 25, 28 }), Arrays.asList((Object[])new Integer[] { 30, 32, 35, 38 }), Arrays.asList((Object[])new Integer[] { 40, 45, 50, 60 }), Arrays.asList((Object[])new Integer[] { 70, 75, 80 }) }));
        this.allMazes = (List<Maze>)new ArrayList();
        this.currentPath = (List<String>)new ArrayList();
        this.currentStep = 0;
        this.steps = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "North", "East", "South", "West" }));
        this.metalDetectorDropTable = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Soul Reaper Fragment", "Gold Coin", "Soul Gem", "Elven Chest", "Elven Key", "Casket of Treasure", "Slayer Casket", "Kings Chest", "Kings Key", "Dragon Plate", "Iridium Ore", "Rhodium Ore", "Platinum Ore", "Gold Coin", "Iron Ore" }));
        this.metalDetectorDropAmounts = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value13, 100000L, value13, value7, value7, value7, 4L, value11, value11, value7, value10, value7, 15L, 100L, value8 }));
        this.metalDetectorDropOdds = (List<Float>)new ArrayList((Collection)Arrays.asList((Object[])new Float[] { 0.1f, 0.4f, 1.0f, 2.2f, 3.4f, 4.9f, 6.7f, 9.2f, 11.7f, 19.7f, 31.7f, 47.7f, 67.7f, 97.7f, 147.7f }));
        this.allLoot = (List<String>)new ArrayList();
        this.allLootAmounts = (List<Long>)new ArrayList();
        this.random = new Random();
        this.mazesComplete = 0;
        this.maxMazes = 30;
        this.lastMazeClick = 0L;
        this.activity = activity;
    }
    
    private void AddImage(final RelativeLayout relativeLayout, final String s) {
        final ImageView imageView = new ImageView((Context)this.activity);
        final int tileSize = this.tileSize;
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(tileSize / 2, tileSize / 2);
        layoutParams.addRule(13);
        imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        if (s != null) {
            final MainActivity activity = this.activity;
            imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s))));
        }
        else {
            try {
                imageView.setImageDrawable(this.activity.GetImage(2131165382));
            }
            catch (final Resources$NotFoundException ex) {
                Log.e("Error: ", "Resources not found");
            }
            imageView.setAlpha(0.4f);
        }
        imageView.setAdjustViewBounds(true);
        relativeLayout.addView((View)imageView);
        if (this.GridFull()) {
            this.ClearGrid();
        }
    }
    
    private void CheckDirection(String string) {
        if (this.mazeEnemy.getAlpha() > 0.0f) {
            this.mazeEnemy.setAlpha(0.0f);
        }
        if (this.currentStep < this.activeMaze.getSteps()) {
            if (this.activity.currentStamina >= this.activeMaze.getEnergy()) {
                final MainActivity activity = this.activity;
                activity.currentStamina -= (int)this.activeMaze.getEnergy();
                if (((String)this.currentPath.get(this.currentStep)).equals((Object)string)) {
                    if (this.currentStep >= 1) {
                        this.activity.GiveExp("Discovery", this.activeMaze.getExp(), (ProgressBar)null);
                    }
                    if (this.activity.combatManager.equippedItems.contains((Object)"Diary of May")) {
                        ((TextView)this.mazePath.getChildAt(this.currentStep)).setText((CharSequence)string.substring(0, 1));
                    }
                    ++this.currentStep;
                    this.UpdateMaze();
                    if (this.currentStep == this.activeMaze.getSteps()) {
                        this.PickLoot();
                        this.activity.secretPathway.CheckPathway("Discovery", this.activeMaze.getName());
                        if (this.activeMaze.getName().equals((Object)"Auranium") && this.activity.combatManager.equippedItems.contains((Object)"Ring of Secrets") && this.activity.InventoryNotFull("Fragment of the Gods I") && this.activity.GetRandom(1, 75000) <= 1) {
                            this.activity.GiveItem("Fragment of the Gods I", 1L, false);
                            this.activity.LargePopup(2131165851, "Congratulations!", "While exploring you found a Fragment of the Gods!");
                        }
                        if (this.activeMaze.getName().equals((Object)"Polisoros") && this.activity.combatManager.equippedItems.contains((Object)"Stethoscope of Copina") && this.activity.combatManager.equippedItems.contains((Object)"Lockpick of Copina")) {
                            this.activity.combatManager.CheckSecret("Diary of May", 2131165741, 30000);
                        }
                        this.activity.ShowView((View)this.newExploration);
                        this.UpdateCentreTitle("Congratulations!");
                        this.UpdateCentreInfo(new SpannableString((CharSequence)"You have completed the path and found the treasure at the end!"));
                    }
                    else {
                        this.UpdateCentreTitle("Good Choice!");
                        int getWishLevel;
                        final int n = getWishLevel = this.activity.databaseManager.GetWishLevel("Navigator", "Endgame");
                        if (this.activity.alchemy.activePotions.contains((Object)"Explorers Potion")) {
                            getWishLevel = n + 5;
                        }
                        int n2 = getWishLevel;
                        if (this.activity.alchemy.activePotions.contains((Object)"Super Explorers Potion")) {
                            n2 = getWishLevel + 10;
                        }
                        int n3 = n2;
                        if (this.activity.alchemy.activePotions.contains((Object)"Extreme Explorers Potion")) {
                            n3 = n2 + 15;
                        }
                        int n4 = n3;
                        if (this.activity.alchemy.activePotions.contains((Object)"Ultimate Explorers Potion")) {
                            n4 = n3 + 20;
                        }
                        if (n4 > 0) {
                            if (this.activity.GetRandom(1, 100) <= n4) {
                                string = "I think we should go " + (String)this.currentPath.get(this.currentStep) + " next.";
                                final StringBuilder sb = new StringBuilder();
                                final List<String> possibleSuccessMessages = this.possibleSuccessMessages;
                                final String string2 = sb.append((String)possibleSuccessMessages.get(this.random.nextInt(possibleSuccessMessages.size()))).append(". I think we should go ").append((String)this.currentPath.get(this.currentStep)).append(" next.").toString();
                                final SpannableString spannableString = new SpannableString((CharSequence)string2);
                                final int index = string2.indexOf(string);
                                spannableString.setSpan((Object)new ForegroundColorSpan(this.activity.GetColour(2131034892)), index, string.length() + index, 33);
                                this.UpdateCentreInfo(spannableString);
                            }
                            else {
                                final List<String> possibleSuccessMessages2 = this.possibleSuccessMessages;
                                this.UpdateCentreInfo(new SpannableString((CharSequence)possibleSuccessMessages2.get(this.random.nextInt(possibleSuccessMessages2.size()))));
                            }
                        }
                        else {
                            final List<String> possibleSuccessMessages3 = this.possibleSuccessMessages;
                            this.UpdateCentreInfo(new SpannableString((CharSequence)possibleSuccessMessages3.get(this.random.nextInt(possibleSuccessMessages3.size()))));
                        }
                    }
                }
                else {
                    this.FailedStep();
                }
            }
            else {
                this.activity.QuickPopup("You don't have enough energy to continue!");
            }
        }
        else {
            this.UpdateCentreTitle("Already Completed");
            this.UpdateCentreInfo(new SpannableString((CharSequence)"You have already completed this path, hit the button below to generate another!"));
        }
    }
    
    private void CheckSize(final int n, final int n2) {
        final int tileSize = this.tileSize;
        final int gridSize = this.gridSize;
        if (tileSize * gridSize > n) {
            this.activity.LogIt("Checking height");
            --this.tileSize;
            this.CheckSize(n, n2);
        }
        else if (gridSize * tileSize > n2) {
            this.tileSize = tileSize - 1;
            this.CheckSize(n, n2);
        }
        else {
            Log.e("Discovery Grid", "Perfect, tile size is: " + this.tileSize);
            this.GenerateGrid();
        }
    }
    
    private void ClearGrid() {
        final Iterator iterator = this.gridTiles.iterator();
        while (iterator.hasNext()) {
            ((RelativeLayout)iterator.next()).removeAllViews();
        }
    }
    
    private void ClearRewards() {
        this.mazeRewardsMessage.setText((CharSequence)"Complete the Path to find the Treasure");
        for (int i = 0; i < this.mazeRewards.getChildCount(); ++i) {
            this.activity.HideView(this.mazeRewards.getChildAt(i));
        }
    }
    
    private void DiscoverAll() {
        if (!this.activity.combatManager.equippedItems.contains((Object)"Drakes Compass") && !this.activity.combatManager.equippedItems.contains((Object)"Drakes Ring") && !this.activity.combatManager.equippedItems.contains((Object)"Metal Detector") && !this.activity.combatManager.equippedItems.contains((Object)"Pumpkin Lantern")) {
            this.activity.QuickPopup("You must have Drakes Compass/Ring or Metal Detector equipped to use instant Discovery.");
        }
        else if (this.generatedGrid) {
            if (this.activity.currentStamina >= this.drakesDiscoveries) {
                if (this.activity.GetRandom(1, 100) > 10) {
                    int i = 0;
                    int n = 0;
                    while (i < this.drakesDiscoveries) {
                        int n2;
                        if (!this.activity.combatManager.equippedItems.contains((Object)"Discovery Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Mini Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") && !this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                            n2 = 1;
                        }
                        else {
                            n2 = 3;
                        }
                        int n3 = n2;
                        if (this.activity.baseTower.baseTowerLevel >= 2) {
                            n3 = n2 + 1;
                        }
                        int n4 = n3;
                        if (this.activity.combatManager.equippedItems.contains((Object)"Oscar")) {
                            n4 = n3 + 1;
                        }
                        int n5 = n4;
                        if (this.activity.combatManager.equippedItems.contains((Object)"Metal Detector")) {
                            n5 = n4 * 2;
                        }
                        int n6 = n;
                        if (this.activity.GetRandom(1, 100) > this.activity.staminaSaveChance) {
                            n6 = n + 1;
                        }
                        final String pickDrop = this.activity.PickDrop((List)this.lootTable);
                        if (pickDrop.equals((Object)"Gold Coin")) {
                            final MainActivity activity = this.activity;
                            ++activity.totalGems;
                            this.activity.UpdateCash();
                        }
                        else {
                            this.activity.GiveItem(pickDrop, (long)n5, false);
                        }
                        ++i;
                        n = n6;
                    }
                    this.activity.GiveExp("Discovery", (long)this.navigationAreaExp.get(this.currentZone) * this.drakesDiscoveries, (ProgressBar)null);
                    this.activity.ExpBar("Discovery", this.discoverySkillProgress);
                    this.activity.secretPathway.CheckPathway("Discovery", (String)this.navigationArea.get(this.currentZone));
                    final MainActivity activity2 = this.activity;
                    activity2.currentStamina -= n;
                    this.activity.accountStats.addEnergyUsed(n);
                    this.activity.dailies.UpdateDailies("Discovery", "Energy", n);
                    this.UpdateEnergy();
                    this.activity.QuickPopup("Successful Expedition");
                    this.activity.treasureHunts.CheckTreasureHunts("Discovery", (String)this.navigationArea.get(this.currentZone));
                }
                else {
                    this.activity.QuickPopup("Discovery Expedition Failed");
                    final MainActivity activity3 = this.activity;
                    activity3.currentStamina -= this.activity.GetRandom(5, 15);
                    this.UpdateEnergy();
                }
            }
            else {
                this.activity.QuickPopup("You need " + this.drakesDiscoveries + " energy to do this.");
            }
        }
    }
    
    private void DiscoveryLoot(int i) {
        this.activity.LoadItemSelect("Loot from " + (String)this.navigationArea.get(i));
        this.activity.itemSelect_wrap.removeAllViews();
        final String[] split = ((String)this.navigationAreaItems.get(i)).split("\\s*,\\s*");
        int length;
        String s;
        MainActivity activity;
        for (length = split.length, i = 0; i < length; ++i) {
            s = split[i];
            activity = this.activity;
            this.activity.itemSelect_wrap.addView((View)activity.AddItemSelectItem((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s)), s));
        }
    }
    
    private void FailedStep() {
        this.UpdateCentreTitle("Wrong Path!");
        final int nextInt = this.random.nextInt(this.possibleFailMessages.size());
        String format;
        int n;
        if (nextInt == this.possibleFailMessages.size() - 1) {
            final int nextInt2 = this.random.nextInt(this.activeMaze.getEnemies().size());
            format = String.format((String)this.possibleFailMessages.get(nextInt), new Object[] { this.activeMaze.getEnemies().get(nextInt2), this.activeMaze.getEnemyDamage().get(nextInt2) });
            n = (int)(this.activity.maxHealth / 100.0f * (int)this.activeMaze.getEnemyDamage().get(nextInt2));
            this.mazeEnemy.setAlpha(0.3f);
            try {
                Picasso.get().load((int)this.activity.combatManager.enemyIcons.get(this.activity.combatManager.enemyNames.indexOf(this.activeMaze.getEnemies().get(nextInt2)))).into(this.mazeEnemy);
            }
            catch (final IndexOutOfBoundsException ex) {
                this.mazeEnemy.setAlpha(0.0f);
            }
        }
        else {
            format = (String)this.possibleFailMessages.get(nextInt);
            if ((int)this.possibleFailHealthLoss.get(nextInt) > 0) {
                n = (int)(this.activity.maxHealth / 100.0f * (int)this.possibleFailHealthLoss.get(nextInt));
            }
            else {
                n = 0;
            }
        }
        this.UpdateCentreInfo(new SpannableString((CharSequence)format));
        if (n > 0) {
            final MainActivity activity = this.activity;
            activity.currentHealth -= n;
            if (this.activity.currentHealth <= 0) {
                this.activity.currentHealth = 0;
            }
            this.activity.UpdateBottomNav();
            if (this.activity.currentHealth <= 0) {
                this.activity.QuickPopup("Unfortunately, you died inside the maze!");
                this.OpenMazeExploration();
            }
            else {
                this.currentStep = 0;
                this.UpdateMaze();
            }
        }
        else {
            this.currentStep = 0;
            this.UpdateMaze();
        }
    }
    
    private void GenerateGrid() {
        this.gridTiles.clear();
        int n = 0;
        while (true) {
            final int gridSize = this.gridSize;
            if (n >= gridSize * gridSize) {
                break;
            }
            if (n % gridSize == 0) {
                final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
                linearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum((float)this.gridSize);
                this.discoveryGridLayout.addView((View)linearLayout);
            }
            final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
            final int tileSize = this.tileSize;
            relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(tileSize, tileSize));
            if (n % 2 == 0) {
                relativeLayout.setBackgroundColor(this.activity.GetColour(2131034224));
            }
            this.gridTiles.add((Object)relativeLayout);
            final LinearLayout discoveryGridLayout = this.discoveryGridLayout;
            ((LinearLayout)discoveryGridLayout.getChildAt(discoveryGridLayout.getChildCount() - 1)).addView((View)relativeLayout);
            ++n;
        }
        this.generatedGrid = true;
        this.SetGridListeners();
    }
    
    private void GenerateSteps() {
        this.currentPath.clear();
        for (int i = 0; i < this.activeMaze.getSteps(); ++i) {
            final List<String> currentPath = this.currentPath;
            final List<String> steps = this.steps;
            currentPath.add((Object)steps.get(this.random.nextInt(steps.size())));
        }
    }
    
    private float GetRandomFloat(final float n) {
        return this.random.nextFloat() * n;
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
                    n = 5;
                    break;
                }
                case 1721869536: {
                    if (!s.equals((Object)"Enhancement Ticket")) {
                        break;
                    }
                    n = 4;
                    break;
                }
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
                case 5: {
                    final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                    slayerInfo.soulGems += (long)this.allLootAmounts.get(i);
                    break;
                }
                case 4: {
                    final ItemManager.Blessings blessings = this.activity.itemManager.blessings;
                    blessings.tickets += (long)this.allLootAmounts.get(i);
                    break;
                }
                case 3: {
                    final MainActivity activity = this.activity;
                    activity.totalGems += (long)this.allLootAmounts.get(i);
                    this.activity.UpdateCash();
                    break;
                }
                case 2: {
                    final CombatManager$SlayerInfo slayerInfo2 = this.activity.combatManager.slayerInfo;
                    slayerInfo2.killcoins += (long)this.allLootAmounts.get(i);
                    break;
                }
                case 1: {
                    final MainActivity activity2 = this.activity;
                    activity2.totalCoins += (long)this.allLootAmounts.get(i);
                    this.activity.UpdateCash();
                    break;
                }
                case 0: {
                    final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                    myTreasureHunts.caskets += (int)(long)this.allLootAmounts.get(i);
                    break;
                }
            }
        }
    }
    
    private boolean GridFull() {
        final Iterator iterator = this.gridTiles.iterator();
        while (iterator.hasNext()) {
            if (((RelativeLayout)iterator.next()).getChildCount() == 0) {
                return false;
            }
        }
        return true;
    }
    
    private void LoadMaze() {
        final ScrollView singleMazeScreen = this.singleMazeScreen;
        int i = 0;
        if (singleMazeScreen == null) {
            this.singleMazeScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297123)).inflate();
            final ScrollView singleMazeScreen2 = (ScrollView)this.activity.findViewById(2131297122);
            this.singleMazeScreen = singleMazeScreen2;
            this.mazeTitle = (TextView)singleMazeScreen2.findViewById(2131296839);
            this.backToMazes = (TextView)this.singleMazeScreen.findViewById(2131296367);
            this.pathsComplete = (TextView)this.singleMazeScreen.findViewById(2131296974);
            this.currentEnergy = (TextView)this.singleMazeScreen.findViewById(2131296503);
            this.directions = (GridLayout)this.singleMazeScreen.findViewById(2131296544);
            this.mazeCentre = (LinearLayout)this.singleMazeScreen.findViewById(2131296832);
            this.mazeRewards = (LinearLayout)this.singleMazeScreen.findViewById(2131296835);
            this.mazeRewardsMessage = (TextView)this.singleMazeScreen.findViewById(2131296836);
            this.mazeEnemy = (ImageView)this.singleMazeScreen.findViewById(2131296833);
            this.newExploration = (TextView)this.singleMazeScreen.findViewById(2131296913);
            this.mazePath = (LinearLayout)this.singleMazeScreen.findViewById(2131296834);
            this.centreTitle = (TextView)this.mazeCentre.getChildAt(0);
            this.centreInfo = (TextView)this.mazeCentre.getChildAt(1);
        }
        this.SetLog();
        this.mazeEnemy.setAlpha(0.0f);
        this.activity.HideView((View)this.newExploration);
        this.activity.EnableLayout((ViewGroup)this.singleMazeScreen);
        this.mazesComplete = 0;
        this.ClearRewards();
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.singleMazeScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.mazeTitle.setText((CharSequence)this.activeMaze.getName());
        this.UpdateCentreTitle("Welcome to " + this.activeMaze.getName());
        this.UpdateCentreInfo(new SpannableString((CharSequence)"Which direction should you go?"));
        this.UpdateMaze();
        this.backToMazes.setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda10(this));
        this.newExploration.setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda11(this));
        while (i < this.directions.getChildCount()) {
            this.directions.getChildAt(i).setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda12(this, i));
            ++i;
        }
    }
    
    private void PickLoot() {
        this.allLoot.clear();
        this.allLootAmounts.clear();
        for (int i = 0; i < 3; ++i) {
            this.PickReward();
        }
        this.UpdateRewards();
        this.GiveRewards();
        if (this.activity.combatManager.equippedItems.contains((Object)"Golden Compass") && this.activity.GetRandom(1, 100) <= this.activeMaze.getSteps() * 2) {
            final int getRandom = this.activity.GetRandom(1, 10000);
            long n;
            if (getRandom <= 1) {
                n = 1000000L;
            }
            else if (getRandom <= 10) {
                n = 100000L;
            }
            else if (getRandom <= 100) {
                n = 10000L;
            }
            else {
                n = 1000L;
            }
            final MainActivity activity = this.activity;
            activity.totalGems += n;
            this.activity.UpdateCash();
            if (n >= 100000L) {
                this.activity.LargePopup(2131165871, "Congratulations", "Your Compass finds " + this.activity.FormatExp(n) + " Gold Coins!");
            }
            else {
                this.activity.QuickPopup("Your Golden Compass finds " + this.activity.FormatExp(n) + " Gold Coins!");
            }
        }
        if (this.activity.holidayEventAvailable && this.activity.combatManager.equippedItems.contains((Object)"Christmas Socks") && this.activity.GetRandom(1, this.SockRate(this.activeMaze.getExp())) <= 1) {
            final TreasureHunts$EventPresent eventPresent = this.activity.treasureHunts.eventPresent;
            ++eventPresent.specialCurrency;
            final MainActivity activity2 = this.activity;
            activity2.LargePopup(activity2.event.specialCurrencyIcon, "Congratulations", "Your Christmas Socks manage to find a  " + this.activity.event.specialCurrency + " !");
        }
    }
    
    private void PickReward() {
        int n;
        if (this.activity.combatManager.equippedItems.contains((Object)"Metal Detector")) {
            n = this.activity.GetRandom(1, Math.toIntExact((long)this.activeMaze.getLootOdds().get(this.activeMaze.getLootOdds().size() - 2)));
        }
        else {
            n = this.activity.GetRandom(1, Math.toIntExact((long)this.activeMaze.getLootOdds().get(this.activeMaze.getLootOdds().size() - 1)));
        }
        int i = 0;
        while (i < this.activeMaze.getLoot().size()) {
            if (n <= (long)this.activeMaze.getLootOdds().get(i)) {
                final String s = (String)this.activeMaze.getLoot().get(i);
                long longValue;
                final long n2 = longValue = (long)this.activeMaze.getLootAmounts().get(i);
                if (this.activity.combatManager.equippedItems.contains((Object)"Golden Compass")) {
                    longValue = n2;
                    if (this.activity.GetRandom(1, 100) <= 20) {
                        longValue = n2 * 2L;
                    }
                }
                if (this.allLoot.contains((Object)s)) {
                    final int index = this.allLoot.indexOf((Object)s);
                    final List<Long> allLootAmounts = this.allLootAmounts;
                    allLootAmounts.set(index, (Object)((long)allLootAmounts.get(index) + longValue));
                    break;
                }
                this.allLoot.add((Object)s);
                this.allLootAmounts.add((Object)longValue);
                break;
            }
            else {
                ++i;
            }
        }
    }
    
    private void RestartMaze() {
        this.ClearRewards();
        this.currentPath.clear();
        int i = 0;
        this.currentStep = 0;
        this.GenerateSteps();
        while (i < this.mazePath.getChildCount()) {
            ((TextView)this.mazePath.getChildAt(i)).setText((CharSequence)"?");
            ++i;
        }
        this.activity.HideView((View)this.newExploration);
        this.UpdateCentreTitle("Welcome to " + this.activeMaze.getName());
        this.UpdateCentreInfo(new SpannableString((CharSequence)"Which direction should you go?"));
        this.UpdateMaze();
    }
    
    private void SearchGrid(final RelativeLayout relativeLayout) {
        final boolean contains = this.activity.combatManager.equippedItems.contains((Object)"Discovery Cape");
        final boolean b = true;
        int n;
        if (!contains && !this.activity.combatManager.equippedItems.contains((Object)"Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Mini Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") && !this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
            n = 1;
        }
        else {
            n = 3;
        }
        int n2 = n;
        if (this.activity.baseTower.baseTowerLevel >= 2) {
            n2 = n + 1;
        }
        int n3 = n2;
        if (this.activity.combatManager.equippedItems.contains((Object)"Oscar")) {
            n3 = n2 + 1;
        }
        if (this.activity.GetRandom(1, 100) > this.activity.staminaSaveChance) {
            final MainActivity activity = this.activity;
            --activity.currentStamina;
            this.activity.dailies.UpdateDailies("Discovery", "Energy", 1);
            this.activity.accountStats.addEnergyUsed(1);
        }
        int n4;
        String s;
        if (this.activity.GetRandom(1, 100) > this.activity.discovery.discoveryFailChance) {
            final String pickDrop = this.activity.PickDrop((List)this.lootTable);
            if (pickDrop.equals((Object)"Gold Coin")) {
                final MainActivity activity2 = this.activity;
                ++activity2.totalGems;
                this.activity.UpdateCash();
            }
            else {
                this.activity.GiveItem(pickDrop, (long)n3, false);
            }
            if (((String)this.navigationArea.get(this.currentZone)).equals((Object)"Mount Desmond")) {
                this.activity.combatManager.CheckSecret("Restoration Fragment 3", 2131166144, 30000);
            }
            n4 = (b ? 1 : 0);
            s = pickDrop;
            if (((String)this.navigationArea.get(this.currentZone)).equals((Object)"Wasteland Volcano")) {
                this.activity.combatManager.CheckSecret("Flame Gloves", 2131165844, 250000);
                n4 = (b ? 1 : 0);
                s = pickDrop;
            }
        }
        else {
            n4 = 0;
            s = null;
        }
        if (this.discoveryArea.isShown()) {
            this.activity.discovery.UpdateEnergy();
        }
        if (this.activity.currentStamina <= 0) {
            this.activity.QuickPopup("You have no energy.");
        }
        if (n4 != 0) {
            this.activity.GiveExp("Discovery", (long)this.navigationAreaExp.get(this.currentZone), (ProgressBar)null);
            this.activity.ExpBar("Discovery", this.discoverySkillProgress);
            this.activity.treasureHunts.CheckTreasureHunts("Discovery", (String)this.navigationArea.get(this.currentZone));
            this.activity.secretPathway.CheckPathway("Discovery", (String)this.navigationArea.get(this.currentZone));
            this.AddImage(relativeLayout, s);
        }
        else {
            this.AddImage(relativeLayout, null);
        }
    }
    
    private void SetGridListeners() {
        for (final RelativeLayout relativeLayout : this.gridTiles) {
            relativeLayout.setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda0(this, relativeLayout));
        }
    }
    
    private void SetLog() {
        this.mazePath.removeAllViews();
        for (int i = 0; i < this.currentPath.size(); ++i) {
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
            this.mazePath.addView((View)textView);
        }
    }
    
    private int SockRate(final long n) {
        return (int)(50000 / (n / 15));
    }
    
    private void StartExploring(final int currentZone) {
        if (this.discoveryArea == null) {
            final ConstraintLayout discoveryArea = (ConstraintLayout)((ViewStub)this.activity.findViewById(2131296555)).inflate();
            this.discoveryArea = discoveryArea;
            this.discoverySkillProgress = (RelativeLayout)discoveryArea.findViewById(2131296558);
            this.discoveryGrid = (RelativeLayout)this.discoveryArea.findViewById(2131296556);
            this.returnDiscovery = (TextView)this.discoveryArea.findViewById(2131297034);
            this.discoverAllButton = (TextView)this.discoveryArea.findViewById(2131296553);
        }
        this.activity.EnableLayout((ViewGroup)this.discoveryArea);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.discoveryArea;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.UpdateEnergy();
        this.returnDiscovery.setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda5(this));
        final ArrayList lootTable = new ArrayList((Collection)Arrays.asList((Object[])((String)this.navigationAreaItems.get(currentZone)).split("\\s*,\\s*")));
        this.currentZone = currentZone;
        ((TextView)this.discoveryArea.getChildAt(1)).setText((CharSequence)this.navigationArea.get(this.currentZone));
        this.lootTable = (List<String>)lootTable;
        this.activity.ExpBar("Discovery", this.discoverySkillProgress);
        if (!this.generatedGrid) {
            this.discoveryGridLayout = (LinearLayout)this.discoveryGrid.getChildAt(0);
            this.discoveryGrid.post((Runnable)new Discovery$$ExternalSyntheticLambda6(this));
        }
        else {
            this.ClearGrid();
            this.SetGridListeners();
        }
        this.discoverAllButton.setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda7(this));
    }
    
    private void StartMaze() {
        this.currentPath.clear();
        this.currentStep = 0;
        this.GenerateSteps();
        this.LoadMaze();
    }
    
    private void UpdateCentreInfo(final SpannableString text) {
        this.centreInfo.setText((CharSequence)text);
    }
    
    private void UpdateCentreTitle(final String text) {
        this.centreTitle.setText((CharSequence)text);
    }
    
    private void UpdateMaze() {
        final String string = "Paths Complete: " + this.currentStep + " / " + this.activeMaze.getSteps();
        if (!this.pathsComplete.getText().toString().equals((Object)string)) {
            this.pathsComplete.setText((CharSequence)string);
        }
        final StringBuilder sb = new StringBuilder("Current Energy: ");
        final MainActivity activity = this.activity;
        final String string2 = sb.append(activity.FormatExp((long)activity.currentStamina)).toString();
        if (!this.currentEnergy.getText().toString().equals((Object)string2)) {
            this.currentEnergy.setText((CharSequence)string2);
        }
    }
    
    private void UpdateMazeScreen() {
        for (int i = 0; i < this.allMazes.size(); ++i) {
            final LinearLayout linearLayout = (LinearLayout)this.mazeWrap.getChildAt(i);
            final LinearLayout linearLayout2 = (LinearLayout)linearLayout.getChildAt(0);
            final LinearLayout linearLayout3 = (LinearLayout)linearLayout.getChildAt(1);
            final LinearLayout linearLayout4 = (LinearLayout)linearLayout.getChildAt(2);
            ((TextView)linearLayout2.getChildAt(0)).setText((CharSequence)((Maze)this.allMazes.get(i)).getName());
            ((TextView)linearLayout2.getChildAt(1)).setText((CharSequence)("Level " + ((Maze)this.allMazes.get(i)).getLevel()));
            ((TextView)linearLayout3.getChildAt(0)).setText((CharSequence)("Total Paths: " + ((Maze)this.allMazes.get(i)).getSteps()));
            ((TextView)linearLayout3.getChildAt(1)).setText((CharSequence)("Experience: " + this.activity.FormatExp(((Maze)this.allMazes.get(i)).getExp())));
            ((TextView)linearLayout3.getChildAt(2)).setText((CharSequence)("Energy/Step: " + this.activity.FormatExp(((Maze)this.allMazes.get(i)).getEnergy())));
            linearLayout4.getChildAt(0).setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda8(this, i));
            linearLayout4.getChildAt(1).setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda9(this, i));
        }
    }
    
    private void UpdateRewards() {
        for (int i = 0; i < this.allLoot.size(); ++i) {
            final LinearLayout linearLayout = (LinearLayout)this.mazeRewards.getChildAt(i);
            linearLayout.setVisibility(0);
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
                case 1721869536: {
                    if (!s.equals((Object)"Enhancement Ticket")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case 444298052: {
                    if (!s.equals((Object)"Killcoins")) {
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
            int intValue = 0;
            switch (n) {
                default: {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.allLoot.get(i)));
                    break;
                }
                case 3: {
                    intValue = 2131166237;
                    break;
                }
                case 2: {
                    intValue = 2131165610;
                    break;
                }
                case 1: {
                    intValue = 2131165924;
                    break;
                }
                case 0: {
                    intValue = 2131165669;
                    break;
                }
            }
            Picasso.get().load(intValue).into((ImageView)linearLayout.getChildAt(0));
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)this.allLoot.get(i));
            ((TextView)linearLayout.getChildAt(2)).setText((CharSequence)("x" + this.activity.FormatExp((long)this.allLootAmounts.get(i))));
        }
    }
    
    private void ViewLoot(final Maze maze) {
        this.activity.LoadItemSelect(maze.getName() + " Loot");
        this.activity.itemSelect_wrap.removeAllViews();
        int size;
        if (this.activity.combatManager.equippedItems.contains((Object)"Metal Detector")) {
            size = maze.getLoot().size() - 1;
        }
        else {
            size = maze.getLoot().size();
        }
        for (int i = 0; i < size; ++i) {
            final String s = (String)maze.getLoot().get(i);
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
                case 1721869536: {
                    if (!s.equals((Object)"Enhancement Ticket")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case 444298052: {
                    if (!s.equals((Object)"Killcoins")) {
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
            int intValue = 0;
            switch (n) {
                default: {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(maze.getLoot().get(i)));
                    break;
                }
                case 3: {
                    intValue = 2131166237;
                    break;
                }
                case 2: {
                    intValue = 2131165610;
                    break;
                }
                case 1: {
                    intValue = 2131165924;
                    break;
                }
                case 0: {
                    intValue = 2131165669;
                    break;
                }
            }
            this.activity.itemSelect_wrap.addView((View)this.activity.AddItemSelectItem(intValue, (String)maze.getLoot().get(i) + " x" + this.activity.FormatExp((long)maze.getLootAmounts().get(i))));
        }
    }
    
    public void GenerateMazes() {
        for (int i = 0; i < this.explorationArea.size(); ++i) {
            this.allMazes.add((Object)new Maze((String)this.explorationArea.get(i), (int)this.explorationLevel.get(i), (int)this.explorationSteps.get(i), (long)this.explorationExperience.get(i), (long)this.explorationEnergy.get(i), (List<String>)this.explorationLoot.get(i), (List<Long>)this.explorationLootAmount.get(i), (List<Long>)this.explorationLootChance.get(i), (List<String>)this.possibleWildEnemies.get(i), (List<Integer>)this.possibleEnemyDamage.get(i)));
        }
    }
    
    public void MetalDetectorLoot() {
        final List<Float> metalDetectorDropOdds = this.metalDetectorDropOdds;
        final float getRandomFloat = this.GetRandomFloat((float)metalDetectorDropOdds.get(metalDetectorDropOdds.size() - 1));
        for (int i = 0; i < this.metalDetectorDropTable.size(); ++i) {
            if (getRandomFloat <= (float)this.metalDetectorDropOdds.get(i)) {
                final String s = (String)this.metalDetectorDropTable.get(i);
                final long longValue = (long)this.metalDetectorDropAmounts.get(i);
                if (i == 0) {
                    this.activity.runOnUiThread((Runnable)new Discovery$$ExternalSyntheticLambda13(this));
                }
                this.activity.runOnUiThread((Runnable)new Discovery$$ExternalSyntheticLambda1(this, s, longValue));
                break;
            }
        }
    }
    
    public void OpenExplore() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.discoveryScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.EnableScreen();
        this.activity.findViewById(2131296595).setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda2(this));
        for (int i = 0; i < this.activity.discoveryWrap.getChildCount(); ++i) {
            final ConstraintLayout constraintLayout = (ConstraintLayout)this.activity.discoveryWrap.getChildAt(i);
            ((TextView)constraintLayout.getChildAt(0)).setText((CharSequence)this.navigationArea.get(i));
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)("Level " + this.navigationAreaLevel.get(i)));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)("Successful Discovery Exp " + this.activity.FormatExp((long)this.navigationAreaExp.get(i))));
            final TextView textView = (TextView)constraintLayout.getChildAt(3);
            final TextView textView2 = (TextView)constraintLayout.getChildAt(4);
            textView2.setText((CharSequence)"Start Exploring");
            if (this.activity.GetSkillLevel("Discovery") < (int)this.navigationAreaLevel.get(i)) {
                constraintLayout.getChildAt(2).setVisibility(8);
                constraintLayout.getChildAt(3).setVisibility(8);
                constraintLayout.getChildAt(4).setVisibility(8);
            }
            else {
                constraintLayout.getChildAt(2).setVisibility(0);
                constraintLayout.getChildAt(3).setVisibility(0);
                constraintLayout.getChildAt(4).setVisibility(0);
            }
            if (((String)this.navigationArea.get(i)).equals((Object)"Mystery Island") && !this.activity.inventoryItems.contains((Object)"Mystery Egg") && !this.activity.baseTower.stashItems.contains((Object)"Mystery Egg")) {
                constraintLayout.setVisibility(8);
            }
            else {
                constraintLayout.setVisibility(0);
            }
            textView2.setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda3(this, i));
            textView.setOnClickListener((View$OnClickListener)new Discovery$$ExternalSyntheticLambda4(this, i));
        }
    }
    
    public void OpenMazeExploration() {
        if (this.mazeScreen == null) {
            this.mazeScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131296838)).inflate();
            final ScrollView mazeScreen = (ScrollView)this.activity.findViewById(2131296837);
            this.mazeScreen = mazeScreen;
            this.mazeWrap = (LinearLayout)mazeScreen.findViewById(2131296840);
        }
        this.activity.EnableLayout((ViewGroup)this.mazeScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.mazeScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.UpdateMazeScreen();
    }
    
    public void UpdateEnergy() {
        ((TextView)this.discoveryArea.getChildAt(2)).setText((CharSequence)("Current Energy: " + this.activity.currentStamina + " / " + this.activity.maxStamina));
        ((TextView)this.discoveryArea.getChildAt(3)).setText((CharSequence)("Energy Save: " + this.activity.staminaSaveChance + "% | Fail Chance: " + this.discoveryFailChance + "%"));
    }
    
    public static class Maze
    {
        List<String> enemies;
        List<Integer> enemyDamage;
        long energy;
        long exp;
        int level;
        List<String> loot;
        List<Long> lootAmounts;
        List<Long> lootOdds;
        String name;
        int steps;
        
        public Maze(final String name, final int level, final int steps, final long exp, final long energy, final List<String> loot, final List<Long> lootAmounts, final List<Long> lootOdds, final List<String> enemies, final List<Integer> enemyDamage) {
            this.name = name;
            this.level = level;
            this.steps = steps;
            this.exp = exp;
            this.energy = energy;
            this.loot = loot;
            this.lootAmounts = lootAmounts;
            this.lootOdds = lootOdds;
            this.enemies = enemies;
            this.enemyDamage = enemyDamage;
        }
        
        public List<String> getEnemies() {
            return this.enemies;
        }
        
        public List<Integer> getEnemyDamage() {
            return this.enemyDamage;
        }
        
        public long getEnergy() {
            return this.energy;
        }
        
        public long getExp() {
            return this.exp;
        }
        
        public int getLevel() {
            return this.level;
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
        
        public int getSteps() {
            return this.steps;
        }
    }
}
