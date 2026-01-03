package uk.playdrop.cherrytree_idletextrpg;

import android.text.style.ForegroundColorSpan;
import android.text.SpannableString;
import java.util.Collections;
import android.widget.ProgressBar;
import android.os.CountDownTimer;
import android.view.ViewStub;
import android.view.ContextThemeWrapper;
import android.widget.RelativeLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import android.view.ViewGroup$LayoutParams;
import android.view.View$OnClickListener;
import com.squareup.picasso.Picasso;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import java.util.List;

public class CombatManager
{
    String activeMaster;
    String activeMonster;
    MainActivity activity;
    List<List<String>> allGodDropAmounts;
    List<List<Long>> allGodDropRates;
    List<List<String>> allGodDrops;
    List<String> allGods;
    List<String> archeryArmour;
    List<Long> archeryArmourCrit;
    List<Long> archeryArmourDamage;
    long archeryArmourDamageBonus;
    List<Long> archeryArrowDamage;
    List<String> archeryArrows;
    List<Long> archeryBowAccuracy;
    List<Long> archeryBowDamage;
    List<Long> archeryBowSpeed;
    List<String> archeryBows;
    boolean balloonBow;
    int baseInstaKill;
    List<String> battleAreas;
    List<String> battleAreasDifficulty;
    List<Long> bowCritChance;
    boolean bowOfFriendship;
    boolean canSpawnCog;
    boolean candleArrows;
    String currentSlayerMaster;
    int damageCap;
    long doubleLootChance;
    int dragonRiderBuff;
    boolean dragonhideSet;
    boolean eggArrows;
    boolean eggSword;
    boolean eggstravagantBow;
    List<String> enemyArea;
    List<Integer> enemyAttack;
    List<String> enemyAttackSpeed;
    List<Integer> enemyDefence;
    List<String> enemyDrops;
    List<Integer> enemyHealth;
    List<Integer> enemyIcons;
    List<String> enemyNames;
    List<Long> enemySlayerExp;
    List<Integer> enemySlayerLevel;
    List<Integer> enemyStrength;
    List<String> enemyWeakness;
    List<List<String>> equipmentPresets;
    String equippedArrows;
    List<String> equippedItems;
    List<String> equippedItemsTypes;
    List<ImageView> equippedItemsViews;
    boolean farmourSet;
    int friendsDamageBoost;
    boolean fullFeroxiEnhanced;
    int ghostlyMiss;
    boolean godsRealm;
    boolean hollybranchBow;
    boolean inImmortalRealm;
    int krampusPieces;
    List<String> krampusSet;
    List<String> meleeAttackStyles;
    boolean mistletoeArrows;
    LinearLayout mySlayerCaskets;
    long mySpeed;
    boolean mysticSet;
    int rageKillsRemaining;
    boolean rageMode;
    long respawnTime;
    int shadowBlockChance;
    List<List<Long>> shadowDropAmounts;
    List<List<Float>> shadowDropRates;
    List<List<String>> shadowDrops;
    List<String> shadowGear;
    int shadowHealChance;
    float shadowKillChance;
    List<String> shadowMonsters;
    boolean shadowRealm;
    int shieldHealChance;
    boolean shieldOfFriendship;
    long skullShieldActivation;
    TextView slay_activeMaster;
    TextView slay_activeTask;
    TextView slay_cancelGold;
    TextView slay_cancelKc;
    TextView slay_darkthread;
    TextView slay_newTask;
    TextView slay_soulgems;
    TextView slay_soulthread;
    int slayerAmount;
    List<Long> slayerCasketAmounts;
    List<String> slayerCasketLoot;
    List<Float> slayerCasketOdds;
    LinearLayout slayerCasketReward;
    SlayerInfo slayerInfo;
    List<String> slayerMasters;
    List<Long> slayerMastersKillCoins;
    List<Integer> slayerMastersLevelUnlock;
    List<Integer> slayerMastersMaxTask;
    List<Integer> slayerMastersMinTask;
    List<String> slayerMastersTasks;
    ScrollView slayerScreen;
    LinearLayout slayerShop;
    List<Long> slayerShopCost;
    List<String> slayerShopCurrency;
    List<String> slayerShopDesc;
    LinearLayout slayerShopGems;
    List<String> slayerShopItems;
    String slayerTask;
    int soulReaperDamageBuff;
    boolean soulReaperEquipped;
    boolean swordOfFriendship;
    long totalMonsterKills;
    TextView totalMonsterKillsCmb;
    boolean trainingGrounds;
    boolean trollPet;
    String weakness;
    List<String> weeklyGods;
    
    public CombatManager(final MainActivity activity) {
        this.equippedItems = (List<String>)new ArrayList();
        this.equippedItemsTypes = (List<String>)new ArrayList();
        this.equippedItemsViews = (List<ImageView>)new ArrayList();
        final Integer value = 1;
        final Integer value2 = 5;
        final Integer value3 = 10;
        final Integer value4 = 15;
        final Integer value5 = 20;
        this.enemyNames = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Chicken", "Crow", "Rat", "Sheep", "Goat", "Pig", "Ox", "Young Goblin", "Goblin Grump", "Goblin Guard", "Goblin Chief", "Jin", "Red Ghoul", "Grey Wolf", "Cyclops", "Cave Demon", "Banshee", "Cave Beast", "Giant Cave Spider", "Wild Dog", "Crocodile", "Lion", "Brown Bear", "Skeletal Bear", "Baby Red Dragon", "Baby Blue Dragon", "Undead Dragon", "Ancient Dragon", "Green Dragon", "Water Dragon", "King Dragon", "Dragon Queen", "Elite Chicken", "Elite Crow", "Elite Rat", "Elite Sheep", "Elite Goat", "Elite Pig", "Elite Ox", "Training Dummy", "Ghost", "Phoenix", "Nightmare", "Orc Captain", "Cobra", "Skeletal Hound", "Necromancer", "Fluffy", "Blue Devil", "Ancient Tribal Leader", "Dummy Queen", "Scarab Queen", "Spider Queen", "Undead Dragon Queen", "Bone King", "Skeletal King", "Living Armour King", "Orc King", "Elven Fairy", "Elven Warrior", "Elven Archer", "Elven Mage", "Elven King", "Elven Queen", "Amaran", "Aurial", "Cognium", "Copina", "Feroxi", "Kynosian", "Noctyra", "Opulina", "Practice Dummy", "Spider Clone", "Dragon Queen Clone", "Tribal Leader Clone", "Orc King Clone", "Elven Queen Clone", "Zombie", "Shadow Creature", "Shadow Dragon" }));
        this.enemyIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165396, 2131165401, 2131165437, 2131165442, 2131165417, 2131165436, 2131165434, 2131165418, 2131165419, 2131165420, 2131165421, 2131165424, 2131165438, 2131165423, 2131165402, 2131165395, 2131165390, 2131165394, 2131165416, 2131165451, 2131165400, 2131165426, 2131165393, 2131165443, 2131165389, 2131165388, 2131165448, 2131165385, 2131165422, 2131165450, 2131165403, 2131165404, 2131165396, 2131165401, 2131165437, 2131165442, 2131165417, 2131165436, 2131165434, 2131165447, 2131165415, 2131165435, 2131165429, 2131165432, 2131165397, 2131165444, 2131165428, 2131165414, 2131165391, 2131165386, 2131165406, 2131165439, 2131165446, 2131165449, 2131165392, 2131165445, 2131165427, 2131165433, 2131165408, 2131165412, 2131165407, 2131165410, 2131165409, 2131165411, 2131165384, 2131165387, 2131165398, 2131165399, 2131165413, 2131165425, 2131165430, 2131165431, 2131165405, 2131165416, 2131165404, 2131165386, 2131165433, 2131165411, 2131165452, 2131165440, 2131165441 }));
        this.enemyHealth = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value3, value5, 30, 50, 75, 100, 150, 35, 75, 135, 225, 375, 600, 90, 150, 300, 450, 675, 1000, 180, 360, 570, 750, 1200, 800, 1000, 1600, 2800, 4000, 5200, 8000, 15000, 10000, 15000, 20000, 25000, 30000, 50000, 75000, 35, 75, 250, 400, 600, 750, 1500, 2500, 5000, 8000, 12000, 50000, 75000, 100000, 150000, 200000, 250000, 300000, 400000, 100000, 150000, 300000, 400000, 600000, 750000, 7000000, 4000000, 6000000, 5000000, 6500000, 5000000, 6000000, 4500000, value, 6000000, 7000000, 8000000, 9000000, 10000000, 12000000, 15000000, 20000000 }));
        this.enemyAttack = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value2, value2, value3, value3, value4, 25, value3, value4, 25, 45, 70, 80, 35, 60, 75, 75, 80, 90, 50, 65, 70, 80, 95, 120, 150, 180, 250, 300, 350, 400, 800, 300, 500, 400, 600, 750, 900, 1200, value3, 30, 50, 60, 70, 80, 140, 200, 250, 350, 600, 2000, 2400, 3000, 3750, 5000, 7500, 10000, 15000, 8000, 9000, 12000, 15000, 24000, 30000, 70000, 60000, 80000, 60000, 90000, 80000, 100000, 70000, value, 120000, 150000, 180000, 230000, 260000, 300000, 350000, 400000 }));
        this.enemyStrength = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, 4, value3, value4, 25, value4, 30, value4, value4, value5, 60, 65, 90, 50, 75, 65, 80, 80, 95, 65, 70, 75, 90, 120, 120, 150, 220, 280, 350, 350, 450, 750, 300, 400, 450, 600, 750, 900, 1200, value3, 25, 60, 70, 80, 90, 160, 250, 300, 500, 800, 800, 1400, 2000, 2400, 3600, 4800, 6000, 7200, 6000, 8000, 10000, 15000, 25000, 40000, 300000, 225000, 450000, 225000, 562500, 525000, 562500, 262500, value, 600000, 800000, 1000000, 1200000, 1400000, 1800000, 2000000, 2500000 }));
        this.enemyDefence = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value2, 8, value4, value4, 25, 40, value2, value3, 35, 50, 70, 85, 40, 70, 60, 70, 80, 85, 55, 50, 60, 85, 100, 120, 130, 140, 300, 240, 300, 450, 2000, 200, 300, 200, 400, 600, 750, 1000, value3, value5, 50, 75, 75, 85, 120, 200, 350, 400, 850, 850, 1000, 1500, 1700, 2500, 3800, 5000, 8500, 10000, 12000, 14000, 16000, 18000, 25000, 67500, 36000, 54000, 40500, 63000, 36000, 67500, 45000, value, 300000, 360000, 450000, 540000, 630000, 750000, 900000, 1200000 }));
        this.enemyAttackSpeed = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Slow", "Medium", "Medium", "Slow", "Slow", "Medium", "Slow", "Medium", "Medium", "Medium", "Fast", "Very Fast", "Very Fast", "Fast", "Slow", "Medium", "Fast", "Fast", "Very Fast", "Fast", "Slow", "Fast", "Slow", "Slow", "Medium", "Medium", "Fast", "Fast", "Fast", "Very Fast", "Very Fast", "Very Fast", "Fast", "Fast", "Fast", "Fast", "Very Fast", "Very Fast", "Very Fast", "Slow", "Medium", "Fast", "Fast", "Fast", "Very Fast", "Fast", "Fast", "Very Fast", "Fast", "Very Fast", "Very Fast", "Very Fast", "Very Fast", "Insane", "Very Fast", "Very Fast", "Very Fast", "Insane", "Fast", "Fast", "Very Fast", "Very Fast", "Insane", "Insane", "Very Fast", "Fast", "Insane", "Fast", "Very Fast", "Insane", "Insane", "Fast", "Slow", "Insane", "Insane", "Insane", "Insane", "Shadows", "Shadows", "Shadows", "Shadows" }));
        this.enemySlayerExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 11L, 12L, 13L, 15L, 16L, 18L, 22L, 13L, 16L, 21L, 29L, 39L, 53L, 21L, 28L, 35L, 44L, 56L, 74L, 28L, 37L, 49L, 60L, 86L, 68L, 82L, 117L, 192L, 255L, 320L, 475L, 938L, 550L, 820L, 1063L, 1340L, 1615L, 2638L, 3930L, 13L, 18L, 31L, 40L, 51L, 60L, 106L, 168L, 305L, 473L, 723L, 2693L, 4000L, 5335L, 7903L, 10565L, 13315L, 16060L, 21545L, 6210L, 8960L, 16810L, 22310L, 33360L, 42260L, 371885L, 216060L, 329210L, 266285L, 360785L, 282060L, 336510L, 243885L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L }));
        this.enemyWeakness = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Melee", "Archery", "Melee", "Melee", "Melee", "Melee", "Melee", "Archery", "Melee", "Melee", "Archery", "Melee", "Archery", "Melee", "Archery", "Melee", "Archery", "Melee", "Archery", "Melee", "Archery", "Melee", "Melee", "Melee", "Archery", "Archery", "Archery", "Archery", "Archery", "Archery", "Archery", "Archery", "Melee", "Archery", "Melee", "Melee", "Melee", "Melee", "Melee", "Melee", "Melee", "Archery", "Archery", "Melee", "Melee", "Melee", "Melee", "Archery", "Archery", "Melee", "Melee", "Archery", "Archery", "Archery", "Melee", "Melee", "Melee", "Archery", "Archery", "Archery", "Melee", "Archery", "Melee", "Melee", "None", "None", "None", "None", "None", "None", "None", "None", "None", "Immune Melee", "Immune Archery", "Immune Melee", "Immune Archery", "Immune Melee", "Immune Archery", "Immune Melee", "Immune Archery" }));
        this.enemySlayerLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value3, value5, 30, 45, 60, 65, 75, 85, 90, 95, 99, value, value, value, value, value, value, value, value, value, value, value, value, value, value, 130, 130, 130, 130, 130, 130, 130, 130, value, 130, 130, 130, 130, 130, 130, 130, 130 }));
        this.enemyDrops = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Bones,1,1,Always/Feathers,1,3,Always/Egg,1,1,Uncommon/Drumstick,1,1,Rare/Thread,1,1,Common/Birds Nest,1,1,Uncommon/Common Key,1,1,Rare/Chicken Knife,1,1,Secret Rare", "Bones,1,1,Always/Feathers,3,6,Always/Evergreen Arrow Shafts,5,10,Uncommon/Egg,1,1,Uncommon/Thread,1,3,Common/Coins,2,10,Uncommon/Birds Nest,1,2,Uncommon/Common Chest,1,1,Rare/Raw Shrimp,1,1,Uncommon", "Bones,1,1,Always/Coins,1,5,Uncommon/Stone Arrowheads,5,10,Uncommon/Common Chest,1,1,Rare/Thread,2,5,Common/Raw Shrimp,1,1,Uncommon/Emerald,1,1,Super Rare", "Bones,1,1,Always/Coins,5,10,Uncommon/Wool,1,1,Common/Akomeric,1,1,Rare/Common Chest,1,1,Rare/Thread,2,6,Common/Raw Snail,1,1,Uncommon/Raw Shrimp,1,1,Common", "Bones,1,1,Always/Milk,1,1,Uncommon/Oak Arrow Shafts,15,30,Rare/Coins,5,10,Uncommon/Common Chest,1,1,Rare/Thread,5,10,Common/Raw Carp,1,1,Uncommon", "Bones,1,1,Always/Bacon,1,1,Common/Coins,10,20,Uncommon/Common Chest,1,1,Rare/Raw Minnows,1,1,Uncommon/Emerald,1,1,Super Rare", "Bones,1,1,Always/Milk,1,1,Common/Coins,20,40,Common/Hide,1,1,Common/Common Chest,1,1,Uncommon/Thread,10,15,Common/Raw Perch,1,1,Uncommon", "Bones,1,1,Always/Coins,5,10,Common/Evergreen Bow,1,1,Rare/Akomeric,1,1,Uncommon/Bloodroot,1,1,Rare/Hyssop,1,1,Rare/Red Chest,1,1,Super Rare/Oak,1,3,Common", "Bones,1,1,Always/Coins,5,10,Common/Copper Arrowheads,5,10,Rare/Akomeric,1,1,Uncommon/Bloodroot,1,1,Rare/Hyssop,1,1,Rare/Hide,1,1,Common/Red Chest,1,1,Super Rare", "Bones,1,1,Always/Coins,10,15,Common/Oak Bow,1,1,Rare/Red Chest,1,1,Rare/Wood,1,1,Common/Iron Ore,1,1,Common/Bloodroot,1,1,Common/Akomeric,1,1,Common", "Bones,1,1,Always/Coins,20,30,Common/Red Chest,1,1,Rare/Goblin Cleaver,1,1,Legendary/Bloodroot,1,1,Common/Akomeric,1,1,Common/Hyssop,1,1,Common/Ancient Rod,1,1,Secret Rare", "Bones,1,1,Always/Coins,50,100,Uncommon/Maple Bow,1,1,Rare/Red Chest,1,1,Uncommon/Raw Crab,1,1,Rare/Raw Lobster,1,1,Rare/Empty Vial,5,10,Common/Oak,3,5,Common/Cauldron,1,1,Secret Rare", "Bones,1,1,Always/Coins,60,100,Uncommon/Red Chest,1,1,Uncommon/Raw Crab,1,1,Uncommon/Raw Lobster,1,1,Rare/Emerald,1,1,Super Rare", "Bones,1,1,Always/Akomeric,1,1,Always/Hide,1,5,Uncommon/Leather,1,2,Rare/Iron Ore,1,1,Uncommon/Emerald,1,1,Super Rare", "Bones,1,1,Always/Akomeric,1,1,Always/Maple Log,1,1,Uncommon/Bloodroot,1,1,Uncommon/Stone,1,3,Uncommon/Wood,2,5,Uncommon/Rope,1,3,Rare/Mithril Boots,1,1,Super Rare/Mithril Ore,1,5,Rare", "Bones,1,1,Always/Empty Vial,1,3,Common/Fir Bow,1,1,Rare/Nails,1,5,Uncommon/Bloodroot,1,1,Uncommon/Fishing Potion,1,1,Rare/Honey,1,1,Uncommon", "Bones,1,1,Always/Empty Vial,1,3,Common/Strength Potion,1,1,Uncommon/Mithril Top,1,1,Super Rare/Mithril Greaves,1,1,Super Rare/Mithril Boots,1,1,Super Rare/Safflower,1,1,Rare", "Bones,1,1,Always/Tooth Necklace,1,1,Rare/Empty Vial,1,3,Common/Hyssop,1,1,Common/Safflower,1,1,Uncommon/Hide,1,10,Uncommon/Raw Catfish,1,5,Rare/Large Fishing Net,1,1,Super Rare/Fishing Net,3,5,Rare", "Bones,1,1,Always/Stone Tablet,1,1,Legendary/Hide,5,10,Uncommon/Thread,10,20,Uncommon/Leather,1,5,Rare/Rope,5,10,Super Rare/Wolfmint,1,1,Super Rare/Vissinel,1,1,Super Rare/Coins,200,500,Rare", "Bones,1,1,Always/Nefrit Chest,1,1,Super Rare/Nefrit Key,1,1,Super Rare/Iron Ore,1,5,Uncommon/Wood,1,3,Common/Emerald,1,1,Super Rare", "Bones,1,1,Always/Nefrit Chest,1,1,Super Rare/Nefrit Key,1,1,Super Rare/Cog,1,1,Common/Thread,5,10,Common/Hide,1,5,Uncommon/Fishing Net,1,3,Rare", "Bones,1,1,Always/Ram Skull,1,1,Super Rare/Fir Log,1,1,Uncommon/Nefrit Chest,1,1,Super Rare/Nefrit Key,1,1,Super Rare/Thread,5,10,Common/Yarn,1,5,Uncommon/Emerald,1,1,Rare", "Bones,1,1,Always/Ram Skull,1,1,Super Rare/Honey,1,1,Common/Nefrit Chest,1,1,Rare/Nefrit Key,1,1,Rare/Coins,200,500,Rare/Pot of Gold,1,1,Rare/Thread,10,20,Uncommon/Yarn,5,10,Common", "Bones,1,1,Always/Gold Ring,1,1,Legendary/Rhodium Ore,1,1,Super Rare/Nefrit Chest,1,1,Uncommon/Nefrit Key,1,1,Uncommon/Coins,500,1000,Rare/Thread,20,50,Rare/Oak,5,10,Common", "Dragon Bones,1,1,Always/Dragon Leather,1,1,Rare/Dragon Skull,1,1,Legendary/Crystal Chest,1,1,Super Rare/Dragon Ore,1,1,Super Rare/Dragon Scimitar,1,1,Super Rare/Coins,500,1000,Rare/Luck Potion,1,1,Uncommon", "Dragon Bones,1,1,Always/Dragon Leather,1,1,Rare/Dragon Skull,1,1,Legendary/Crystal Key,1,1,Super Rare/Dragon Ore,1,1,Super Rare/Dragon Scimitar,1,1,Super Rare/Coins,500,1000,Rare/Luck Potion,1,1,Uncommon", "Dragon Bones,1,1,Always/Dragon Leather,1,1,Uncommon/Dragon Skull,1,1,Legendary/Crystal Chest,1,1,Super Rare/Dragon Ore,1,2,Super Rare/Dragon Scimitar,1,1,Super Rare/Coins,500,1000,Rare/Luck Potion,1,1,Uncommon", "Dragon Bones,1,1,Always/Dragon Arrowheads,15,25,Rare/Dragon Leather,1,1,Uncommon/Dragon Skull,1,1,Legendary/Golden Necklace,1,1,Legendary/Crystal Key,1,1,Super Rare/Dragon Ore,1,2,Super Rare/Dragon Scimitar,1,1,Super Rare/Coins,1000,2500,Rare", "Dragon Bones,1,1,Always/Dragon Leather,1,2,Uncommon/Dragon Skull,1,1,Legendary/Dragon Tail,1,1,Legendary/Golden Necklace,1,1,Legendary/Crystal Chest,1,1,Rare/Dragon Ore,1,2,Super Rare/Dragon Wing Battleaxe,1,1,Legendary/Dragon Scimitar,1,1,Super Rare/Coins,1000,2500,Rare", "Dragon Bones,1,1,Always/Dragon Leather,1,2,Common/Dragon Skull,1,1,Legendary/Dragon Tail,1,1,Legendary/Golden Scarab,1,1,Legendary/Crystal Key,1,1,Rare/Dragon Ore,1,1,Rare/Trident of the Seas,1,1,Legendary/Dragon Wing Battleaxe,1,1,Super Rare/Dragon Scimitar,1,1,Super Rare/Coins,2500,5000,Rare", "Big Dragon Bones,1,1,Always/Dragon Leather,2,5,Common/Dragon Skull,1,1,Legendary/Dragon Tail,1,1,Legendary/Golden Scarab,1,1,Legendary/Crystal Key,1,1,Rare/Dragon Ore,1,2,Rare/Dragon Wing Battleaxe,1,1,Super Rare/Dragon Scimitar,1,1,Rare/Coins,5000,10000,Rare/Kings Chest,1,1,Mythical/Kings Key,1,1,Mythical", "Big Dragon Bones,1,2,Always/Dragon Leather,5,10,Common/Dragon Skull,1,1,Super Rare/Dragon Tail,1,1,Super Rare/Golden Scarab,1,1,Super Rare/Queens Chest,1,1,Mythical/Queens Key,1,1,Mythical/Dragon Ore,2,5,Rare/Dragon Scimitar,1,1,Rare/Coins,5000,10000,Rare", "Bones,5,5,Always/Coins,1000,2500,Always/Cedar Log,1,1,Rare/Feathers,10,30,Always/Egg,5,10,Uncommon/Chicken Knife,1,1,Legendary/Farm Chest,1,1,Legendary/Farmour Fragment,1,1,Legendary", "Bones,5,5,Always/Coins,1500,2500,Always/Feathers,5,10,Always/Egg,1,3,Uncommon/Thread,5,10,Common/Birds Nest,2,5,Uncommon/Farm Key,1,1,Legendary/Dagger Fragment,1,1,Mythical", "Bones,5,5,Always/Coins,2000,3000,Always/Platinum Ore,1,1,Rare/Emerald,1,3,Rare/Farm Chest,1,1,Super Rare/Farmour Fragment,1,2,Legendary", "Bones,5,5,Always/Coins,2500,3000,Always/Wool,2,5,Common/Farm Key,1,1,Super Rare/Dagger Fragment,1,3,Mythical", "Bones,5,5,Always/Coins,3000,4000,Always/Cedar Bow,1,1,Super Rare/Milk,2,5,Uncommon/Farm Chest,1,1,Rare/Farmour Fragment,1,3,Legendary", "Bones,5,5,Always/Coins,3500,4500,Always/Bacon,2,5,Common/Farm Key,1,1,Rare/Dagger Fragment,2,5,Mythical", "Bones,5,5,Always/Coins,4000,5000,Always/Hide,2,5,Common/Ginkgo Bow,1,1,Legendary/Ginkgo Log,1,1,Uncommon/Farm Chest,1,2,Rare/Farm Key,1,2,Rare/Farmour Fragment,2,5,Legendary/Dagger Fragment,1,1,Legendary", "Wood,1,1,Always/Hide,1,1,Uncommon/Redwood Log,1,1,Super Rare/Thread,1,3,Common/Common Key,1,1,Rare/Oak,1,3,Uncommon/Iron Ore,1,3,Uncommon", "Akomeric,1,1,Common/Mushroom,1,1,Common/Stone,1,5,Common/Common Key,1,1,Rare/Common Chest,1,1,Rare", "Bones,1,1,Always/Bloodroot,1,1,Common/Red Chest,1,1,Rare/Red Key,1,1,Rare/Thread,10,20,Common/Yarn,1,5,Common/Ruby,1,1,Rare/Gold Ore,1,1,Legendary/Sextant,1,1,Super Rare/Mystery Egg,1,1,Secret Rare", "Hyssop,1,1,Common/Red Key,1,1,Rare/Red Chest,1,1,Rare/Book of Aroon,1,1,Legendary/Thread,25,50,Rare/Hide,10,25,Uncommon/Iron Ore,1,3,Common", "Bones,1,1,Always/Thread,10,25,Common/Sage Leaf,1,5,Common/Wood,10,20,Uncommon/Mithril Ore,5,10,Rare/Iron Ore,10,25,Rare/Barbarian Boots,1,1,Legendary/Barbarian Gloves,1,1,Legendary/Barbarian Top,1,1,Legendary/Barbarian Helm,1,1,Legendary/Barbarian Greaves,1,1,Legendary/Barbarian Cape,1,1,Legendary", "Bones,1,1,Always/Safflower,1,1,Common/Sunburst Flower,1,1,Super Rare/Spiked Chest,1,1,Rare/Spiked Key,1,1,Rare/Hide,10,25,Uncommon/Mithril Ore,1,5,Rare/Iron Ore,10,25,Common/Yarn,5,10,Rare/Emerald,1,1,Rare", "Bones,1,1,Always/Sage Leaf,1,1,Common/Redwood Bow,1,1,Super Rare/Mithril Ore,5,10,Uncommon/Rope,5,10,Uncommon/Cog,1,1,Rare/Iron Ore,5,10,Common/Blue Silk,15,20,Super Rare", "Bones,1,5,Always/Thread,10,15,Common/Vissinel,1,1,Common/Wood,10,20,Uncommon/Mithril Ore,5,10,Rare/Iron Ore,10,20,Rare/Necromancer Boots,1,1,Legendary/Necromancer Gloves,1,1,Legendary/Necromancer Top,1,1,Legendary/Necromancer Helm,1,1,Legendary/Necromancer Greaves,1,1,Legendary/Necromancer Cape,1,1,Legendary", "Bones,1,1,Always/Wolfmint,1,1,Common/Ember Fern,1,1,Super Rare/Chestnut Log,1,1,Rare/Crystal Chest,1,2,Super Rare/Thread,25,50,Uncommon/Rope,10,15,Rare/Yarn,5,10,Rare/Gold Ring,1,1,Legendary/Iron Ore,10,20,Common", "Bones,1,1,Always/Vissinel,1,1,Always/Crystal Key,1,1,Rare/Chestnut Bow,1,1,Super Rare/Stone Tablet,1,1,Legendary/Gold Ring,1,1,Legendary/Thread,50,100,Uncommon/Rope,15,20,Rare/Blue Thread,1,1,Common", "Bones,5,5,Always/Vissinel,3,5,Always/Crystal Chest,1,3,Rare/Ancient Dagger,1,1,Mythical/Blue Thread,3,5,Common/Blue Silk,1,3,Uncommon/Coin Purse,1,1,Super Rare/Golden Necklace,1,1,Super Rare/Wine,3,5,Rare", "Coins,100,200,Always/Queens Chest,1,1,Super Rare/Wood,10,20,Always/Hide,10,20,Uncommon/Thread,10,30,Common/Queens Armour Fragment,1,1,Legendary", "Coins,150,250,Always/Queens Key,1,1,Super Rare/Golden Necklace,1,1,Super Rare/Wine,3,5,Rare/Queens Armour Fragment,1,2,Legendary/Golden Scarab,1,1,Super Rare", "Coins,250,500,Always/Queens Chest,1,1,Rare/Golden Necklace,1,1,Super Rare/Wine,3,5,Rare/Wolfmint,1,1,Common/Ember Fern,1,1,Rare/Thread,50,100,Uncommon/Gold Ring,1,1,Legendary/Queens Armour Fragment,1,3,Legendary", "Coins,500,750,Always/Queens Key,1,1,Rare/Big Dragon Bones,2,3,Always/Dragon Leather,2,5,Common/Dragon Skull,1,1,Legendary/Dragon Tail,1,1,Legendary/Golden Scarab,1,1,Legendary/Queens Weapon Fragment,1,1,Legendary", "Sunburst Flower,1,1,Always/Coins,750,1000,Always/Kings Chest,1,1,Super Rare/Kings Armour Fragment,1,1,Legendary", "Sunburst Flower,1,1,Always/Coins,1000,1500,Always/Kings Key,1,1,Super Rare/Kings Armour Fragment,1,2,Legendary", "Ember Fern,1,1,Always/Coins,2000,3000,Always/Kings Chest,1,1,Rare/Kings Armour Fragment,1,3,Legendary", "Ember Fern,1,1,Always/Coins,3000,5000,Always/Kings Key,1,1,Rare/Kings Weapon Fragment,1,1,Legendary", "Coins,8000,10000,Always/Elven Chest,1,1,Super Rare/Blue Silk,5,10,Common/Compass,1,1,Rare/Treasure Map,1,1,Rare/Extreme Power Potion,1,1,Rare/Safflower,1,3,Uncommon/Dragon Tail,1,3,Legendary", "Coins,10000,15000,Always/Elven Key,1,1,Super Rare/Compass,1,3,Rare/Sunburst Flower,1,3,Uncommon/Dragon Skull,1,3,Legendary/Raw Ray,1,1,Common/Pirates Hat,1,1,Super Rare", "Coins,15000,20000,Always/Elven Chest,1,2,Rare/Elven Arrows,1,1,Super Rare/Sunburst Flower,3,5,Uncommon/Crab,3,5,Common/Dragon Plate,15,20,Super Rare/Raw Shark,1,1,Common/Golden Scarab,1,3,Super Rare", "Coins,20000,25000,Always/Elven Key,1,2,Rare/Sunburst Flower,5,10,Uncommon/Dragon Leather,15,20,Super Rare/Raw Octopus,1,1,Common/Dragon Ore,1,3,Super Rare/Dragon Platter,1,1,Rare", "Coins,30000,50000,Always/Elven Chest,1,2,Uncommon/Ember Fern,3,5,Uncommon/Dragon Tail,5,10,Legendary/Dragon Ore,3,5,Super Rare/Golden Scarab,3,5,Super Rare/Dragon Platter,3,5,Rare", "Coins,50000,100000,Always/Elven Key,1,2,Uncommon/Ember Fern,15,20,Uncommon/Dragon Skull,5,10,Legendary/Queens Weapon Fragment,1,1,Super Rare/Queens Armour Fragment,1,1,Super Rare/Dragon Platter,5,10,Uncommon", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Wood,1,1,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always", "Gold Coin,5,10,Always" }));
        this.enemyArea = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Farm", "Farm", "Farm", "Farm", "Farm", "Farm", "Farm", "Abandoned Village", "Abandoned Village", "Abandoned Village", "Abandoned Village", "Abandoned Village", "Abandoned Village", "Caves", "Caves", "Caves", "Caves", "Caves", "Caves", "Great Plains", "Great Plains", "Great Plains", "Great Plains", "Great Plains", "Dragon Island", "Dragon Island", "Dragon Island", "Dragon Island", "Dragon Island", "Dragon Island", "Dragon Island", "Dragon Island", "Elite Farm", "Elite Farm", "Elite Farm", "Elite Farm", "Elite Farm", "Elite Farm", "Elite Farm", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Slayer Dungeon", "Realm of the Kings", "Realm of the Kings", "Realm of the Kings", "Realm of the Kings", "Realm of the Kings", "Realm of the Kings", "Realm of the Kings", "Realm of the Kings", "Immortal Realm", "Immortal Realm", "Immortal Realm", "Immortal Realm", "Immortal Realm", "Immortal Realm", "Kingdom of the Gods", "Kingdom of the Gods", "Kingdom of the Gods", "Kingdom of the Gods", "Kingdom of the Gods", "Kingdom of the Gods", "Kingdom of the Gods", "Kingdom of the Gods", "Training Grounds", "Shadow Realm", "Shadow Realm", "Shadow Realm", "Shadow Realm", "Shadow Realm", "Shadow Realm", "Shadow Realm", "Shadow Realm" }));
        this.battleAreas = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Training Grounds", "Farm", "Abandoned Village", "Caves", "Great Plains", "Dragon Island", "Elite Farm", "Slayer Dungeon", "Realm of the Kings", "Immortal Realm", "Kingdom of the Gods", "Shadow Realm" }));
        this.battleAreasDifficulty = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Just for damage practice", "Easy", "Easy - Medium", "Medium - Hard", "Hard - Very Hard", "Very Hard - Extreme", "Very Hard - Extreme", "Easy - Extreme", "Extreme - Insanity", "Insanity", "Insanity (Changes Weekly, requires 130 Slayer)", "Ultimate Challenge (Requires 130 Slayer)" }));
        this.slayerTask = "";
        this.currentSlayerMaster = "";
        this.slayerAmount = 0;
        this.slayerMasters = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Blade", "Tracer", "Crux", "Tide", "Quill", "Lumen", "Vain", "Feroxi", "Adamet", "Sylthenia", "Illunaris" }));
        this.slayerMastersTasks = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Chicken/Crow/Rat/Young Goblin", "Young Goblin/Sheep/Goblin Grump/Goat/Ghost/Pig", "Ghost/Goblin Guard/Grey Wolf/Ox/Wild Dog/Cyclops/Goblin Chief/Phoenix/Cave Demon", "Wild Dog/Cyclops/Goblin Chief/Cave Demon/Crocodile/Jin/Nightmare/Banshee/Lion/Red Ghoul/Cave Beast", "Lion/Orc Captain/Red Ghoul/Cave Beast/Brown Bear/Cobra/Baby Red Dragon/Giant Cave Spider/Baby Blue Dragon/Skeletal Bear/Undead Dragon", "Baby Blue Dragon/Skeletal Bear/Skeletal Hound/Undead Dragon/Necromancer/Ancient Dragon/Green Dragon/Water Dragon/King Dragon/Elite Chicken", "Fluffy/Blue Devil/King Dragon/Elite Chicken/Ancient Tribal Leader/Elite Crow/Dragon Queen/Elite Rat/Elite Sheep/Elite Goat/Elite Pig/Dummy Queen", "Elite Pig/Dummy Queen/Elite Ox/Scarab Queen/Spider Queen/Elven Fairy/Undead Dragon Queen/Elven Warrior/Bone King", "Elven Warrior/Bone King/Skeletal King/Living Armour King/Elven Archer/Orc King/Elven Mage/Elven King/Elven Queen", "Gods", "Spider Clone/Dragon Queen Clone/Tribal Leader Clone/Orc King Clone/Elven Queen Clone/Zombie" }));
        final Long value6 = 1L;
        this.slayerMastersKillCoins = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value6, 3L, 6L, 10L, 18L, 32L, 54L, 75L, 125L, 175L, 300L }));
        this.slayerMastersLevelUnlock = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value5, 35, 50, 70, 85, 95, 105, 115, 130, 140 }));
        this.slayerMastersMinTask = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value2, value3, value5, 25, 40, 60, 90, 100, 120, 90, 50 }));
        this.slayerMastersMaxTask = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value3, value5, 30, 40, 60, 90, 120, 150, 200, 200, 80 }));
        this.archeryBows = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Evergreen Bow", "Oak Bow", "Maple Bow", "Fir Bow", "Redwood Bow", "Cedar Bow", "Chestnut Bow", "Ginkgo Bow", "Queens Bow", "Kings Bow", "Elven Bow", "Bow of Kynosian", "Bow of Kynosian (E)", "Bow of Kynosian (E2)", "Bow of Kynosian (E3)", "Bow of Kynosian (E4)", "Bow of Kynosian (E5)", "Bow of Eggcellence", "Eggstravagant Bow", "Bow of Friendship", "Balloon Bow", "Bow of the Shadows", "Hollybranch Bow" }));
        this.archeryBowSpeed = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 2800L, 2650L, 2500L, 2350L, 2200L, 2050L, 1900L, 1750L, 1600L, 1450L, 1300L, 1000L, 1000L, 1000L, 800L, 800L, 800L, 1200L, 900L, 1300L, 1300L, 700L, 1400L }));
        this.archeryBowDamage = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 0L, 0L, 0L, 0L, 10L, 25L, 50L, 100L, 750L, 1250L, 2500L, 4000L, 5000L, 5500L, 6000L, 6500L, 7000L, 2000L, 3000L, 3000L, 2000L, 10000L, 1750L }));
        this.archeryBowAccuracy = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 30L, 35L, 40L, 45L, 50L, 55L, 60L, 65L, 70L, 75L, 80L, 90L, 95L, 95L, 95L, 95L, 100L, 75L, 80L, 90L, 70L, 100L, 78L }));
        this.archeryArrows = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Stone Arrows", "Copper Arrows", "Iron Arrows", "Mithril Arrows", "Dragon Arrows", "Platinum Arrows", "Rhodium Arrows", "Iridium Arrows", "Queens Arrows", "Kings Arrows", "Elven Arrows", "Kynosian Arrows", "Egg Arrows", "Candle Arrows", "Darkstar Arrows", "Shadow Arrows", "Mistletoe Arrows" }));
        this.archeryArrowDamage = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 4L, 10L, 20L, 50L, 100L, 240L, 500L, 1250L, 2500L, 3000L, 5000L, 8000L, 5000L, 3000L, 7500L, 12000L, 4000L }));
        final Long value7 = 5L;
        this.bowCritChance = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 0L, 0L, 0L, 0L, 0L, 0L, 0L, 2L, value7, 10L, 20L, 40L, 40L, 40L, 40L, 40L, 40L, 30L, 35L, 25L, 25L, 50L, 25L }));
        this.equippedArrows = "";
        this.archeryArmour = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Kynosian Boots", "Kynosian Gloves", "Kynosian Hat", "Kynosian Legs", "Kynosian Top", "Dragonhide Boots", "Dragonhide Gloves", "Dragonhide Helm", "Dragonhide Legs", "Dragonhide Top", "Kynosian Boots (E)", "Kynosian Gloves (E)", "Kynosian Hat (E)", "Kynosian Legs (E)", "Kynosian Top (E)", "Shadow Boots", "Shadow Gloves", "Shadow Hood", "Shadow Greaves", "Shadow Cloak" }));
        this.archeryArmourDamage = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 350L, 350L, 500L, 650L, 800L, 50L, 50L, 75L, 100L, 125L, 350L, 350L, 500L, 650L, 800L, 600L, 600L, 800L, 1000L, 1200L }));
        this.archeryArmourCrit = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 2L, 3L, value7, 10L, 15L, value6, value6, 2L, 3L, value7, 3L, 4L, 6L, 15L, 20L, value7, 6L, 8L, 20L, 25L }));
        this.activeMaster = "";
        this.slayerShopItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Small Exp Scroll", "Gold Coin", "Apprentice Sword", "Apprentice Boots", "Apprentice Gloves", "Apprentice Helm", "Apprentice Legs", "Apprentice Top", "Soul Thread", "Dark Thread", "Fragment of Secrets 1", "Enhancement Ticket", "Soul Reaper Fragment", "Slayer Casket", "Slayer Casket" }));
        this.slayerShopDesc = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Grants a small amount of experience to any skill", "Premium Currency", "Tier 1 Slayer Weapon", "Tier 1 Slayer Armour", "Tier 1 Slayer Armour", "Tier 1 Slayer Armour", "Tier 1 Slayer Armour", "Tier 1 Slayer Armour", "A rare piece of thread used for Crafting powerful armour", "A special thread used to upgrade Slayer Weapons.", "I can use this to craft something", "Used to enhance items making them more powerful", "Used to craft Soul Reaper Gear", "Grants 20 Slayer Caskets", "Grants 20 Slayer Caskets" }));
        this.slayerShopCurrency = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Killcoins", "Killcoins", "Killcoins", "Killcoins", "Killcoins", "Killcoins", "Killcoins", "Killcoins", "Soul Gems", "Killcoins", "Soul Gems", "Soul Gems", "Soul Gems", "Killcoins", "Soul Gems" }));
        this.slayerShopCost = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 10L, 75L, 10L, 10L, 15L, 20L, 30L, 35L, 3L, 30L, 1500L, 80L, 2500L, 50000L, 75L }));
        this.meleeAttackStyles = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Attack", "Strength", "Defence" }));
        this.weeklyGods = (List<String>)new ArrayList();
        this.allGods = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Amaran", "Aurial", "Cognium", "Copina", "Feroxi", "Kynosian", "Noctyra", "Opulina" }));
        this.allGodDrops = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "Shield of Amaran", "Ring of Life", "Necklace of Defence", "Necklace of Health", "Queens Armour Fragment", "Kings Armour Fragment", "Invincibility Potion", "Rock Skin Potion", "Dragon Platter", "Iridium Ore" }), Arrays.asList((Object[])new String[] { "Scythe of Aurial", "Scythe of Demeter", "Restoration Fragment 2", "Magic Watering Can", "Pumpkin Seed", "Farm Chest", "Farm Key", "Wine", "Eggplant", "Fruit Salad", "Lemon" }), Arrays.asList((Object[])new String[] { "Cognium Ring", "Ring of Speed", "Ring Fragments", "Sextant", "Steel Bar", "Cog", "Iron Ore" }), Arrays.asList((Object[])new String[] { "Stethoscope of Copina", "Rod of Copina", "Rabbits Foot", "Eagles Nest", "Book of Aroon", "Stone Tablet", "Ginkgo Log", "Shark", "Marlin", "Chestnut Log", "Large Fishing Net", "Rhodium Ore" }), Arrays.asList((Object[])new String[] { "Shield of Feroxi", "Gloves of Feroxi", "Berserker Ring", "Extreme Power Stone", "Necklace of Strength", "Kings Weapon Fragment", "Queens Weapon Fragment", "Ultimate Power Potion", "Super Power Stone", "Tooth Necklace", "Super Power Potion", "Power Potion" }), Arrays.asList((Object[])new String[] { "Kynosian Top", "Kynosian Gloves", "Kynosian Boots", "Kynosian Arrows", "Elven Bow", "Elven Arrows", "Kings Bow", "Kings Arrows", "Queens Bow", "Queens Arrows", "Ginkgo Headless Arrows", "Ginkgo Arrow Shafts" }), Arrays.asList((Object[])new String[] { "Sword of Cognium", "Death Princess Rune", "Ancient Elven Book", "Ring of Death", "Book of Death", "Soul Gem", "Liquid Death Potion", "Dragon Skull", "Insta Kill Potion", "Big Dragon Bones", "Dragon Bones", "Bones" }), Arrays.asList((Object[])new String[] { "Opulinas Robe Bottoms", "Gold Coin", "Gold Coin", "Golden Touch Potion", "Gold Coin", "Golden Scarab", "Pot of Gold", "Treasure Map", "Gold Coin", "Gold Bar", "Gold Feather", "Gold Ore" }) }));
        this.allGodDropAmounts = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,1", "4,5", "2,3", "1,3", "2,5", "15,25", "10,20" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,1", "5,10", "2,3", "2,3", "15,20", "10,15", "15,20", "15,20" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,2", "3,5", "15,20", "5,10", "20,30" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "2,3", "4,5", "4,5", "20,25", "40,50", "50,60", "25,40", "5,10", "15,25" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,2", "1,1", "2,3", "3,4", "2,5", "2,5", "3,5", "5,10", "10,15" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "2,5", "1,1", "5,10", "1,1", "15,20", "1,1", "20,30", "25,40", "40,60" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "5,10", "5,10", "10,15", "15,20", "20,25", "30,40" }), Arrays.asList((Object[])new String[] { "1,1", "100,100", "25,25", "2,5", "15,15", "5,10", "5,10", "5,10", "5,5", "15,20", "25,30", "30,40" }) }));
        this.allGodDropRates = (List<List<Long>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Long[] { value6, 4L, 14L, 24L, 144L, 384L, 984L, 2984L, 7984L, 17984L }), Arrays.asList((Object[])new Long[] { value6, 3L, value7, 13L, 38L, 188L, 338L, 1338L, 4338L, 10338L, 20338L }), Arrays.asList((Object[])new Long[] { value6, 4L, 19L, 519L, 3019L, 8019L, 18019L }), Arrays.asList((Object[])new Long[] { value6, 2L, 6L, 106L, 256L, 406L, 906L, 1706L, 4206L, 8206L, 14206L, 24206L }), Arrays.asList((Object[])new Long[] { value6, 2L, value7, 11L, 17L, 67L, 187L, 937L, 1937L, 3937L, 8937L, 18937L }), Arrays.asList((Object[])new Long[] { value6, 2L, 3L, 9L, 24L, 54L, 204L, 454L, 954L, 1704L, 9204L, 19204L }), Arrays.asList((Object[])new Long[] { value6, 3L, 6L, 11L, 16L, 22L, 522L, 1272L, 2772L, 5772L, 10772L, 20772L }), Arrays.asList((Object[])new Long[] { value6, 3L, 7L, 15L, 31L, 111L, 411L, 1011L, 2011L, 4511L, 9511L, 17511L }) }));
        this.shadowMonsters = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Spider Clone", "Dragon Queen Clone", "Tribal Leader Clone", "Orc King Clone", "Elven Queen Clone", "Zombie", "Shadow Creature", "Shadow Dragon" }));
        this.shadowDrops = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "Eternal Berserker Ring", "Ring of Speed", "Ring of Life", "Ring of Death", "Ring Fragments", "Gold Coin", "Elven Grace Potion", "Queens Key", "Queens Chest", "Power Stone", "Dragon Platter", "Gold Ring" }), Arrays.asList((Object[])new String[] { "Necklace of Amaran", "Divine Protection Potion", "Gold Coin", "Elven Grace Potion", "Ultimate Power Potion", "Golden Scarab", "Dragon Tail", "Queens Key", "Queens Chest", "Power Stone", "Dragon Platter" }), Arrays.asList((Object[])new String[] { "Pumpkin Seed Scroll", "Treasure Casket", "Darkstar Ore", "Super Power Stone", "Divine Protection Potion", "Gold Coin", "Elven Grace Potion", "Kings Chest", "Kings Key", "Elven Crystal", "Blueprints", "Dragon Platter" }), Arrays.asList((Object[])new String[] { "Scythe of Noctyra", "Enhancement Ticket", "Treasure Casket", "Sandalwood Log", "Super Power Stone", "Gold Coin", "Elven Key", "Elven Chest", "Golden Scarab", "Blueprints", "Ultimate Power Potion", "Dragon Platter" }), Arrays.asList((Object[])new String[] { "Soul Reaper Fragment", "Treasure Casket", "Gold Coin", "Soul Reaper Potion", "Elven Chest", "Elven Key", "Darkstar Ore", "Golden Scarab", "Rabbits Foot", "Extreme Power Stone", "Blueprints", "Pumpkin Pie" }), Arrays.asList((Object[])new String[] { "Shadow Staff Base", "Shadow Lantern Base", "Divine Protection Scroll", "Soul Reaper Fragment", "Shadow Arrowheads", "Shadow Weapon Fragment", "Gold Coin", "Summer Cocktail", "Stone Tablet", "Sandalwood Log", "Darkstar Ore", "Pumpkin Pie" }), Arrays.asList((Object[])new String[] { "Shadow Staff Handle", "Shadow Lantern Handle", "Challenge Coin", "Soul Reaper Fragment", "Treasure Casket", "Shadow Arrowheads", "Shadow Armour Fragment", "Gold Coin", "Soul Reaper Potion", "Summer Cocktail", "Darkstar Ore", "Sandalwood Log", "Stone Tablet", "Pumpkin Pie" }), Arrays.asList((Object[])new String[] { "Shadow Staff Tip", "Shadow Lantern Gem", "Scythe of Noctyra", "Dragon Tail Feather", "Shadow Arrowheads", "Shadow Weapon Fragment", "Shadow Armour Fragment", "Divine Protection Potion", "Gold Coin", "Summer Cocktail", "Slayer Casket", "Sandalwood Log", "Darkstar Ore", "Pumpkin Pie" }) }));
        this.shadowDropAmounts = (List<List<Long>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Long[] { value6, value6, value6, value6, 6L, 100L, value6, 2L, 2L, value6, 2L, value6 }), Arrays.asList((Object[])new Long[] { value6, value6, 250L, 2L, 3L, 2L, 10L, 2L, 2L, 3L, value7 }), Arrays.asList((Object[])new Long[] { value6, value7, value6, value6, 3L, 500L, value6, value7, value7, 4L, value6, 10L }), Arrays.asList((Object[])new Long[] { value6, 2L, 10L, value6, 2L, 750L, value7, value7, value7, 3L, value7, 15L }), Arrays.asList((Object[])new Long[] { value6, 20L, 1000L, value7, 15L, 15L, value6, 10L, value7, value6, value7, 2L }), Arrays.asList((Object[])new Long[] { value6, value6, value6, value6, 10L, value6, 2500L, value6, 10L, value6, value6, 3L }), Arrays.asList((Object[])new Long[] { value6, value6, value7, 2L, 20L, 15L, value6, 5000L, 10L, 2L, value6, value6, 20L, 6L }), Arrays.asList((Object[])new Long[] { value6, value6, value6, value6, 25L, 2L, 2L, value7, 10000L, value7, value7, 3L, 3L, 8L }) }));
        this.shadowDropRates = (List<List<Float>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Float[] { 0.01f, 0.26f, 0.76f, 1.51f, 2.51f, 5.51f, 10.51f, 28.51f, 48.51f, 73.51f, 113.51f, 163.51f }), Arrays.asList((Object[])new Float[] { 0.01f, 0.51f, 1.51f, 5.51f, 15.51f, 30.51f, 50.51f, 76.51f, 104.51f, 139.51f, 181.51f }), Arrays.asList((Object[])new Float[] { 0.01f, 0.11f, 0.36f, 0.86f, 1.86f, 6.86f, 16.86f, 32.86f, 50.86f, 75.86f, 107.86f, 147.86f }), Arrays.asList((Object[])new Float[] { 0.01f, 0.11f, 0.36f, 0.86f, 1.86f, 6.86f, 16.86f, 28.86f, 46.86f, 71.86f, 103.86f, 143.86f }), Arrays.asList((Object[])new Float[] { 0.01f, 0.07f, 0.37f, 0.97f, 1.97f, 3.17f, 5.17f, 8.67f, 13.67f, 20.67f, 30.67f, 45.67f }), Arrays.asList((Object[])new Float[] { 0.003f, 0.009f, 0.034f, 0.134f, 0.434f, 1.184f, 6.184f, 16.184f, 31.184f, 51.184f, 75.184f, 105.184f }), Arrays.asList((Object[])new Float[] { 0.003f, 0.011f, 0.111f, 0.261f, 0.561f, 1.061f, 1.811f, 4.811f, 12.811f, 22.811f, 35.811f, 53.811f, 77.811f, 107.811f }), Arrays.asList((Object[])new Float[] { 0.004f, 0.011f, 0.041f, 0.101f, 0.601f, 1.351f, 2.351f, 6.351f, 13.351f, 25.351f, 43.351f, 64.351f, 91.351f, 123.351f }) }));
        this.damageCap = 600000;
        this.skullShieldActivation = 0L;
        this.equipmentPresets = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { null, null }));
        this.baseInstaKill = 0;
        this.canSpawnCog = false;
        this.inImmortalRealm = false;
        this.weakness = "";
        this.rageMode = false;
        this.fullFeroxiEnhanced = false;
        this.rageKillsRemaining = 0;
        this.godsRealm = false;
        this.trainingGrounds = false;
        this.soulReaperEquipped = false;
        this.soulReaperDamageBuff = 0;
        this.dragonRiderBuff = 0;
        this.ghostlyMiss = 0;
        this.archeryArmourDamageBonus = 0L;
        this.totalMonsterKills = 0L;
        this.doubleLootChance = 0L;
        this.eggArrows = false;
        this.eggSword = false;
        this.eggstravagantBow = false;
        this.balloonBow = false;
        this.candleArrows = false;
        this.bowOfFriendship = false;
        this.shieldOfFriendship = false;
        this.swordOfFriendship = false;
        this.trollPet = false;
        this.shadowRealm = false;
        this.shadowHealChance = 0;
        this.shadowKillChance = 0.0f;
        this.shadowBlockChance = 0;
        this.friendsDamageBoost = 0;
        this.shieldHealChance = 0;
        this.farmourSet = false;
        this.dragonhideSet = false;
        this.mysticSet = false;
        this.slayerCasketLoot = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Ring of Souls", "Divine Protection Scroll", "Shield of Amaran", "Soul Reaper Fragment", "Enhancement Ticket", "Casket of Treasure", "Egg Arrows", "Soul Gem", "Casket of Treasure", "Kynosian Arrows", "Gold Coin", "Pumpkin Seed", "Soul Reaper Potion", "Divine Protection Potion", "Kings Arrows", "Queens Arrows", "Iridium Arrows", "Liquid Death Potion", "Elven Chest", "Elven Key", "Big Dragon Bones", "Stone" }));
        this.slayerCasketAmounts = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value6, value6, value6, value6, 3L, 20L, 20L, 10L, 10L, 15L, 75000L, value7, value7, value7, 10L, 15L, 20L, value7, value7, value7, 50L, 100L }));
        this.slayerCasketOdds = (List<Float>)new ArrayList((Collection)Arrays.asList((Object[])new Float[] { 0.01f, 0.03f, 0.07f, 0.17f, 0.57f, 1.17f, 1.97f, 2.97f, 4.47f, 6.27f, 8.47f, 12.47f, 20.47f, 32.47f, 50.47f, 72.47f, 98.47f, 130.47f, 170.47f, 215.47f, 270.47f, 335.47f }));
        this.shadowGear = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Shadow Boots", "Shadow Gloves", "Shadow Hood", "Shadow Greaves", "Shadow Cloak" }));
        this.krampusSet = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Krampus Horns", "Krampus Jacket", "Krampus Legs" }));
        this.krampusPieces = 0;
        this.mistletoeArrows = false;
        this.hollybranchBow = false;
        this.activity = activity;
    }
    
    private void AddEnemy(final int n, final LinearLayout linearLayout) {
        final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this.activity, 2131492937, (ViewGroup)null);
        final int getResource = this.activity.GetResource(2131100046);
        int n2 = -1;
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, getResource);
        linearLayout$LayoutParams.leftMargin = this.activity.GetResource(2131099758);
        linearLayout$LayoutParams.rightMargin = this.activity.GetResource(2131099758);
        Picasso.get().load((int)this.enemyIcons.get(n)).into((ImageView)relativeLayout.getChildAt(0));
        final String s = (String)this.enemyWeakness.get(n);
        s.hashCode();
        switch (s.hashCode()) {
            case 916547894: {
                if (!s.equals((Object)"Archery")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case 439518103: {
                if (!s.equals((Object)"Immune Melee")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case 74227028: {
                if (!s.equals((Object)"Melee")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -226047303: {
                if (!s.equals((Object)"Immune Archery")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        switch (n2) {
            default: {
                Picasso.get().load(2131166497).into((ImageView)relativeLayout.getChildAt(4));
                break;
            }
            case 3: {
                Picasso.get().load(2131166482).into((ImageView)relativeLayout.getChildAt(4));
                break;
            }
            case 2: {
                Picasso.get().load(2131165522).into((ImageView)relativeLayout.getChildAt(4));
                break;
            }
            case 1: {
                Picasso.get().load(2131166468).into((ImageView)relativeLayout.getChildAt(4));
                break;
            }
            case 0: {
                Picasso.get().load(2131165521).into((ImageView)relativeLayout.getChildAt(4));
                break;
            }
        }
        final LinearLayout linearLayout2 = (LinearLayout)relativeLayout.getChildAt(1);
        ((TextView)linearLayout2.getChildAt(0)).setText((CharSequence)this.enemyNames.get(n));
        final TextView textView = (TextView)linearLayout2.getChildAt(1);
        final MainActivity activity = this.activity;
        textView.setText((CharSequence)activity.getString(2131820620, new Object[] { activity.FormatExp((long)activity.GetCombatLevel((int)this.enemyAttack.get(n), (int)this.enemyStrength.get(n), (int)this.enemyDefence.get(n), (int)this.enemyHealth.get(n))) }));
        ((TextView)linearLayout2.getChildAt(0)).setTextColor(this.activity.white);
        relativeLayout.getChildAt(3).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda4(this, n));
        relativeLayout.getChildAt(2).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda5(this, n));
        linearLayout.addView((View)relativeLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
    }
    
    private long ArmourCritChance() {
        final Iterator iterator = this.equippedItems.iterator();
        long n = 0L;
        while (iterator.hasNext()) {
            final String s = (String)iterator.next();
            if (this.archeryArmour.contains((Object)s)) {
                n += this.ArmourCrit(s);
            }
        }
        return n;
    }
    
    private long BowCritChance() {
        return (long)this.bowCritChance.get(this.archeryBows.indexOf((Object)this.BowEquipped()));
    }
    
    private void BuySlayerItem(final String s, final String s2, final long n) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n2 = -1;
        switch (hashCode) {
            case 1721869536: {
                if (!s.equals((Object)"Enhancement Ticket")) {
                    break;
                }
                n2 = 5;
                break;
            }
            case 1253687303: {
                if (!s.equals((Object)"Slayer Casket")) {
                    break;
                }
                n2 = 4;
                break;
            }
            case 658894417: {
                if (!s.equals((Object)"Gold Coin")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case -95351593: {
                if (!s.equals((Object)"Soul Thread")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case -819624483: {
                if (!s.equals((Object)"Casket of Treasure")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -1070077452: {
                if (!s.equals((Object)"Dark Thread")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        switch (n2) {
            default: {
                if (this.activity.InventoryNotFull(s)) {
                    this.activity.GiveItem(s, 1L, true);
                    break;
                }
                this.activity.QuickPopup("Inventory Full");
                return;
            }
            case 5: {
                final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                ++blessings.tickets;
                this.activity.QuickPopup("+1 Enhancement Ticket");
                break;
            }
            case 4: {
                final SlayerInfo slayerInfo = this.slayerInfo;
                slayerInfo.slayerCaskets += 20L;
                this.activity.QuickPopup("You bought Slayer Caskets");
                ((TextView)this.mySlayerCaskets.getChildAt(2)).setText((CharSequence)this.activity.FormatExp(this.slayerInfo.getSlayerCaskets()));
                break;
            }
            case 3: {
                final MainActivity activity = this.activity;
                ++activity.totalGems;
                this.activity.QuickPopup("+1 Gold Coin");
                break;
            }
            case 2: {
                final SlayerInfo slayerInfo2 = this.slayerInfo;
                ++slayerInfo2.soulThread;
                this.activity.QuickPopup("+1 Soul Thread");
                break;
            }
            case 1: {
                final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                ++myTreasureHunts.caskets;
                this.activity.QuickPopup("+1 Treasure Casket");
                break;
            }
            case 0: {
                final SlayerInfo slayerInfo3 = this.slayerInfo;
                ++slayerInfo3.darkThread;
                this.activity.QuickPopup("+1 Dark Thread");
                break;
            }
        }
        if (s2.equals((Object)"Killcoins")) {
            final SlayerInfo slayerInfo4 = this.slayerInfo;
            slayerInfo4.killcoins -= n;
        }
        else {
            final SlayerInfo slayerInfo5 = this.slayerInfo;
            slayerInfo5.soulGems -= n;
        }
        this.UpdateSlayer();
        this.activity.UpdateCash();
    }
    
    private void CheckBoosts(final String s) {
        if (this.activity.GetCombatLevel((int)this.enemyAttack.get(this.enemyNames.indexOf((Object)s)), (int)this.enemyStrength.get(this.enemyNames.indexOf((Object)s)), (int)this.enemyDefence.get(this.enemyNames.indexOf((Object)s)), (int)this.enemyHealth.get(this.enemyNames.indexOf((Object)s))) >= 150000) {
            if (this.activity.treasureHunts.BoostActive("I feel Blessed") && this.activity.GetRandom(1, 333) <= 1) {
                final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                ++blessings.tickets;
                this.activity.LargePopup(2131165610, "Congratulations", "While killing enemies you find an Enhancement Ticket!");
            }
            if (this.activity.treasureHunts.BoostActive("Soul Hunter") && this.activity.GetRandom(1, 100) <= 1) {
                final SlayerInfo slayerInfo = this.slayerInfo;
                ++slayerInfo.soulGems;
                this.activity.LargePopup(2131166237, "Congratulations", "While killing enemies you find a Soul Gem!");
            }
            if (this.activity.treasureHunts.BoostActive("Raining Fragments") && this.activity.GetRandom(1, 100) <= 2) {
                this.activity.GiveItem("Ring Fragments", 1L, false);
                this.activity.LargePopup(2131166150, "Congratulations", "While killing enemies you find a Ring Fragment!");
            }
        }
    }
    
    private void CheckSpecials(final String s) {
        if (s.equals((Object)"Chicken")) {
            final MainActivity activity = this.activity;
            ++activity.totalChickenKills;
            if (this.activity.totalChickenKills == 25000L) {
                this.activity.GiveTitle("the Chicken Slayer");
            }
        }
        if (s.equals((Object)"Pig")) {
            this.CheckSecret("Mystic Hat", 2131166028, 10000);
        }
        if (s.equals((Object)"Ghost")) {
            this.CheckSecret("Super Power Stone", 2131166289, 5000);
            if (this.equippedItems.contains((Object)"Evergreen Bow") && (this.equippedItems.contains((Object)"Kynosian Arrows") || this.equippedItems.contains((Object)"Shadow Arrows")) && this.activity.GetRandom(1, 25000) <= 1 && !this.activity.myPets.contains((Object)"Ace the Ghost")) {
                this.activity.myPets.add((Object)"Ace the Ghost");
                this.activity.GiveAvatar("Ace the Ghost");
            }
        }
        if (s.equals((Object)"Orc King")) {
            this.CheckSecret("Ring of Speed", 2131166161, 15000);
        }
        if (s.equals((Object)"Living Armour King")) {
            this.CheckSecret("Blessed Sacrifice", 2131165599, 75000);
        }
        if (s.equals((Object)"Elite Pig")) {
            this.CheckSecret("Ring of Life", 2131166156, 20000);
        }
        if (s.equals((Object)"Elven Mage") && this.activity.equippedFood.equals((Object)"Cheese") && this.equippedItems.contains((Object)"Thieving Gloves") && this.equippedItems.contains((Object)"Drakes Ring") && this.equippedItems.contains((Object)"Defence Cape")) {
            this.CheckSecret("Energy Overload Scroll", 2131165795, 150000);
        }
        if (s.equals((Object)"Sheep") && this.activity.GetRandom(1, 500000) == 1) {
            if (this.activity.Ultimaxed()) {
                if (this.activity.trainingSkill.equals((Object)"Forestry") && this.activity.trainingMethod.equals((Object)"Ginkgo Tree")) {
                    this.activity.LargePopup(2131166030, "Congratulations!", "You found a Mystic Staff!");
                    this.activity.GiveItem("Mystic Staff", 1L, false);
                }
                else {
                    this.activity.LargePopup(2131165979, "Congratulations!", "You found a Massive Exp Scroll!");
                    this.activity.GiveItem("Massive Exp Scroll", 1L, false);
                }
            }
            else {
                this.activity.LargePopup(2131165948, "Congratulations!", "You found a Large Exp Scroll!");
                this.activity.GiveItem("Large Exp Scroll", 1L, false);
            }
        }
        if (s.equals((Object)"Ancient Tribal Leader")) {
            final MainActivity activity2 = this.activity;
            ++activity2.totalTribalKills;
            if (this.activity.totalTribalKills == 100000L) {
                this.activity.GiveTitle("the New Leader");
            }
        }
        if (s.equals((Object)"Elite Chicken") && this.FullLeather()) {
            this.CheckSecret("Magic Watering Can", 2131165970, 250000);
        }
        if (s.equals((Object)"Water Dragon")) {
            this.CheckSecret("Restoration Fragment 1", 2131166142, 30000);
        }
        if (s.equals((Object)"Elven Archer")) {
            this.CheckSecret("Book of Death", 2131165628, 30000);
        }
        if (s.equals((Object)"Elven King")) {
            this.CheckSecret("Book of Necromancy", 2131165629, 300000);
        }
        if (s.equals((Object)"Elven Queen")) {
            this.CheckSecret("Ancient Elven Book", 2131165532, 100000);
            if (this.slayerInfo.getSlayerTask().equals((Object)s)) {
                this.CheckSecret("Ring of Souls", 2131166160, 250000);
            }
        }
        if (s.equals((Object)"Orc King Clone") && this.equippedItems.contains((Object)"Ring of Secrets")) {
            this.CheckSecret("Fragment of the Gods II", 2131165852, 120000);
        }
        if (this.activity.treasureHunts.BoostActive("More Old Rod") && this.activity.GetRandom(1, 100) <= 20) {
            if (this.activity.GetRandom(1, 3000) <= 2) {
                final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                ++myTreasureHunts.caskets;
                this.activity.LargePopup(2131165669, "Old Rod Luck!", "Your active boost helps you find a Treasure Casket!");
            }
            else {
                final String s2 = (String)this.activity.fishing.oldFishingRodLootTable.get(this.activity.randomGenerator.nextInt(this.activity.fishing.oldFishingRodLootTable.size()));
                if (s2.equals((Object)"Gold Coin")) {
                    final MainActivity activity3 = this.activity;
                    ++activity3.totalGems;
                    this.activity.UpdateCash();
                }
                else {
                    this.activity.GiveItem(s2, 1L, false);
                }
                this.activity.QuickPopup("Your Old Rod Boost manages to find a " + s2 + "!");
            }
        }
    }
    
    private void CheckTreasureScroll(int getWishLevel) {
        float n2;
        final float n = n2 = getWishLevel * 1.0E-4f + 0.01f;
        if (this.activity.databaseManager.GetWishLevel("Treasure Hunter", "Beginner") >= 1) {
            n2 = n + n / 100.0f * this.activity.databaseManager.GetWishLevel("Treasure Hunter", "Beginner");
        }
        float n3 = n2;
        if (this.activity.baseTower.baseTowerLevel >= 72) {
            n3 = n2 + n2 / 5.0f;
        }
        if (this.RandomFloat(0.0f, 2800.0f) <= Math.min(n3, 18.0f)) {
            getWishLevel = this.activity.databaseManager.GetWishLevel("No more Scrolls", "Endgame");
            if (getWishLevel > 0) {
                if (this.activity.GetRandom(1, 50) <= getWishLevel) {
                    this.activity.accountStats.addScrollCompleted(1);
                    final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                    ++myTreasureHunts.caskets;
                    this.activity.LargePopup(2131166315, "Congratulations!", "You found a Treasure Scroll which your wish completed for you!");
                }
                else {
                    final TreasureHunts$MyTreasureHunts myTreasureHunts2 = this.activity.treasureHunts.myTreasureHunts;
                    ++myTreasureHunts2.scrolls;
                    this.activity.LargePopup(2131166315, "Congratulations!", "While killing enemies, you find a Treasure Scroll!");
                }
            }
            else {
                final TreasureHunts$MyTreasureHunts myTreasureHunts3 = this.activity.treasureHunts.myTreasureHunts;
                ++myTreasureHunts3.scrolls;
                this.activity.LargePopup(2131166315, "Congratulations!", "While killing enemies, you find a Treasure Scroll!");
            }
        }
    }
    
    private void ClearCasketLoot() {
        this.slayerCasketReward.getChildAt(0).setAlpha(0.0f);
        this.slayerCasketReward.getChildAt(1).setAlpha(0.0f);
        this.slayerCasketReward.getChildAt(2).setAlpha(0.0f);
    }
    
    private void CollectLootItem(final int n) {
        final String s = (String)this.activity.currentLoot.get(n);
        s.hashCode();
        final int hashCode = s.hashCode();
        int n2 = -1;
        switch (hashCode) {
            case 1803406242: {
                if (!s.equals((Object)"Soul Gem")) {
                    break;
                }
                n2 = 6;
                break;
            }
            case 1721869536: {
                if (!s.equals((Object)"Enhancement Ticket")) {
                    break;
                }
                n2 = 5;
                break;
            }
            case 1253687303: {
                if (!s.equals((Object)"Slayer Casket")) {
                    break;
                }
                n2 = 4;
                break;
            }
            case 658894417: {
                if (!s.equals((Object)"Gold Coin")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case 65287138: {
                if (!s.equals((Object)"Coins")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case -458446738: {
                if (!s.equals((Object)"Challenge Coin")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -1274418954: {
                if (!s.equals((Object)"Treasure Casket")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        switch (n2) {
            default: {
                if (this.activity.farming.farmingSeeds.contains(this.activity.currentLoot.get(n))) {
                    final MainActivity activity = this.activity;
                    activity.GiveSeed((String)activity.currentLoot.get(n), (long)this.activity.currentLootAmounts.get(n));
                }
                else {
                    final MainActivity activity2 = this.activity;
                    if (activity2.InventoryNotFull((String)activity2.currentLoot.get(n))) {
                        final MainActivity activity3 = this.activity;
                        activity3.GiveItem((String)activity3.currentLoot.get(n), (long)this.activity.currentLootAmounts.get(n), true);
                    }
                    else if (this.activity.baseTower.myTreestones.contains((Object)"Treestone of Space")) {
                        final MainActivity activity4 = this.activity;
                        if (activity4.StashNotFull((String)activity4.currentLoot.get(n))) {
                            final MainActivity activity5 = this.activity;
                            activity5.GiveItemStash((String)activity5.currentLoot.get(n), (long)this.activity.currentLootAmounts.get(n), true);
                        }
                    }
                }
                if (((String)this.activity.currentLoot.get(n)).equals((Object)this.activity.equippedFood) && this.activity.currentLoot.contains((Object)this.activity.equippedFood)) {
                    long longValue;
                    if (this.activity.inventoryItems.contains((Object)this.activity.equippedFood)) {
                        longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)this.activity.equippedFood));
                    }
                    else {
                        longValue = 0L;
                    }
                    final TextView eatFood = this.activity.eatFood;
                    final MainActivity activity6 = this.activity;
                    eatFood.setText((CharSequence)activity6.getString(2131820619, new Object[] { activity6.equippedFood, longValue }));
                    this.activity.UpdateBottomNav();
                    break;
                }
                break;
            }
            case 6: {
                final SlayerInfo slayerInfo = this.slayerInfo;
                slayerInfo.soulGems += (long)this.activity.currentLootAmounts.get(n);
                break;
            }
            case 5: {
                final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                blessings.tickets += (long)this.activity.currentLootAmounts.get(n);
                break;
            }
            case 4: {
                final SlayerInfo slayerInfo2 = this.slayerInfo;
                slayerInfo2.slayerCaskets += (long)this.activity.currentLootAmounts.get(n);
                break;
            }
            case 3: {
                final MainActivity activity7 = this.activity;
                activity7.totalGems += (long)this.activity.currentLootAmounts.get(n);
                this.activity.UpdateCash();
                break;
            }
            case 2: {
                final MainActivity activity8 = this.activity;
                activity8.totalCoins += (long)this.activity.currentLootAmounts.get(n);
                this.activity.UpdateCash();
                break;
            }
            case 1: {
                final Dailies dailies = this.activity.dailies;
                dailies.challengeCoins += (int)(long)this.activity.currentLootAmounts.get(n);
                break;
            }
            case 0: {
                final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                myTreasureHunts.caskets += (int)(long)this.activity.currentLootAmounts.get(n);
                break;
            }
        }
        this.activity.lootList.removeViewAt(n);
        this.activity.currentLoot.remove(n);
        this.activity.currentLootAmounts.remove(n);
    }
    
    private void CombatCalculations(String s) {
        this.mySpeed = this.GetAttackSpeed();
        this.respawnTime = this.GetRespawnTime();
        this.ghostlyMiss = this.GhostlyMissChance();
        this.soulReaperDamageBuff = this.SoulReaperDamageBuff();
        this.soulReaperEquipped = this.SoulReaperEquipped();
        this.dragonRiderBuff = this.DragonRiderBuff(s);
        this.krampusPieces = this.GetKrampusPieces();
        this.eggSword = this.equippedItems.contains((Object)"Sword of Eggcellence");
        this.eggstravagantBow = this.equippedItems.contains((Object)"Eggstravagant Bow");
        this.swordOfFriendship = this.equippedItems.contains((Object)"Sword of Friendship");
        this.shieldOfFriendship = this.equippedItems.contains((Object)"Shield of Friendship");
        this.bowOfFriendship = this.equippedItems.contains((Object)"Bow of Friendship");
        this.balloonBow = this.equippedItems.contains((Object)"Balloon Bow");
        this.candleArrows = this.equippedItems.contains((Object)"Candle Arrows");
        this.trollPet = this.equippedItems.contains((Object)"Adam the Troll");
        this.hollybranchBow = this.equippedItems.contains((Object)"Hollybranch Bow");
        this.mistletoeArrows = this.equippedItems.contains((Object)"Mistletoe Arrows");
        Label_0262: {
            if (!this.bowOfFriendship) {
                if (!this.swordOfFriendship) {
                    break Label_0262;
                }
            }
            try {
                this.friendsDamageBoost = Math.min(this.activity.friends.GetMutualFriends(), 20) * 5;
            }
            catch (final NullPointerException ex) {
                this.friendsDamageBoost = 0;
            }
        }
        if (this.shieldOfFriendship) {
            try {
                this.shieldHealChance = Math.min(this.activity.friends.GetMutualFriends(), 20);
            }
            catch (final NullPointerException ex2) {
                this.shieldHealChance = 0;
            }
        }
        this.inImmortalRealm = ((String)this.enemyArea.get(this.enemyNames.indexOf((Object)s))).equals((Object)"Immortal Realm");
        this.godsRealm = this.allGods.contains((Object)s);
        this.trainingGrounds = ((String)this.enemyArea.get(this.enemyNames.indexOf((Object)s))).equals((Object)"Training Grounds");
        this.shadowRealm = ((String)this.enemyArea.get(this.enemyNames.indexOf((Object)s))).equals((Object)"Shadow Realm");
        this.shadowKillChance = 0.0f;
        this.shadowHealChance = 0;
        this.baseInstaKill = 0;
        if (!this.allGods.contains((Object)s)) {
            if (this.equippedItems.contains((Object)"Staff of the Shadows") || this.equippedItems.contains((Object)"Bow of the Shadows")) {
                this.baseInstaKill += 35;
            }
            if (!this.inImmortalRealm) {
                this.baseInstaKill = this.activity.instakillchance;
                if (this.equippedItems.contains((Object)"Ring of Death") || this.equippedItems.contains((Object)"Eternal Ring") || this.equippedItems.contains((Object)"Eternal Berserker Ring") || this.equippedItems.contains((Object)"Ring of Secrets")) {
                    this.baseInstaKill += 10;
                }
                if (this.equippedItems.contains((Object)"Sword of Feroxi (E)")) {
                    this.baseInstaKill += 10;
                }
                if (this.equippedItems.contains((Object)"Mystic Staff")) {
                    this.baseInstaKill += 25;
                }
                if (this.equippedItems.contains((Object)"Mystic Staff (E)")) {
                    this.baseInstaKill += 35;
                }
                if (this.equippedItems.contains((Object)"Sword of Cognium")) {
                    this.baseInstaKill += 15;
                }
            }
            if (this.equippedItems.contains((Object)"Scythe of Noctyra") || this.equippedItems.contains((Object)"Scythe of Noctyra (E)") || this.equippedItems.contains((Object)"Scythe of Noctyra (E2)") || this.equippedItems.contains((Object)"Scythe of Noctyra (E3)")) {
                this.baseInstaKill += 20;
            }
            if (this.equippedItems.contains((Object)"Spade")) {
                this.baseInstaKill += 2;
            }
            if (this.equippedItems.contains((Object)"Staff of Skulls")) {
                this.baseInstaKill += 5;
            }
            if (this.trollPet) {
                this.baseInstaKill += 5;
            }
            if (this.soulReaperEquipped) {
                this.baseInstaKill += this.SoulReaperInstaKill();
            }
        }
        else {
            if (this.equippedItems.contains((Object)"Staff of the Shadows") || this.equippedItems.contains((Object)"Bow of the Shadows")) {
                this.baseInstaKill += 15;
            }
            if (this.equippedItems.contains((Object)"Scythe of Noctyra")) {
                this.baseInstaKill += 3;
            }
            if (this.equippedItems.contains((Object)"Scythe of Noctyra (E)") || this.equippedItems.contains((Object)"Scythe of Noctyra (E2)") || this.equippedItems.contains((Object)"Scythe of Noctyra (E3)")) {
                this.baseInstaKill += 7;
            }
            if (this.trollPet) {
                this.baseInstaKill += 5;
            }
        }
        this.baseInstaKill = Math.min(this.baseInstaKill, 50);
        this.canSpawnCog = (this.equippedItems.contains((Object)"Sword of Cognium") && !this.trainingGrounds);
        this.farmourSet = (this.equippedItems.contains((Object)"Farmour Gloves") && this.equippedItems.contains((Object)"Farmour Boots") && this.equippedItems.contains((Object)"Farmour Helm") && this.equippedItems.contains((Object)"Farmour Legs") && this.equippedItems.contains((Object)"Farmour Top"));
        this.dragonhideSet = (this.equippedItems.contains((Object)"Dragonhide Gloves") && this.equippedItems.contains((Object)"Dragonhide Boots") && this.equippedItems.contains((Object)"Dragonhide Helm") && this.equippedItems.contains((Object)"Dragonhide Legs") && this.equippedItems.contains((Object)"Dragonhide Top"));
        this.mysticSet = (this.equippedItems.contains((Object)"Mystic Gloves") && this.equippedItems.contains((Object)"Mystic Boots") && this.equippedItems.contains((Object)"Mystic Hat") && this.equippedItems.contains((Object)"Mystic Bottoms") && this.equippedItems.contains((Object)"Mystic Robe"));
        this.weakness = (String)this.enemyWeakness.get(this.enemyNames.indexOf((Object)s));
        if (this.shadowRealm) {
            this.damageCap = 200000;
            if (this.equippedItems.contains((Object)"Scythe of Noctyra (E)") || this.equippedItems.contains((Object)"Scythe of Noctyra (E2)") || this.equippedItems.contains((Object)"Scythe of Noctyra (E3)")) {
                this.damageCap += 100000;
            }
            if (this.equippedItems.contains((Object)"Scythe of Noctyra")) {
                this.damageCap += 50000;
            }
            if (this.equippedItems.contains((Object)"Shadow Lantern")) {
                this.damageCap += 100000;
            }
            if (this.equippedItems.contains((Object)"Staff of the Shadows")) {
                this.damageCap += 200000;
            }
            if (this.equippedItems.contains((Object)"Bow of the Shadows")) {
                this.damageCap += 200000;
            }
            s.hashCode();
            final int hashCode = s.hashCode();
            int n = -1;
            switch (hashCode) {
                case 1535009599: {
                    if (!s.equals((Object)"Shadow Creature")) {
                        break;
                    }
                    n = 7;
                    break;
                }
                case 1439488570: {
                    if (!s.equals((Object)"Dragon Queen Clone")) {
                        break;
                    }
                    n = 6;
                    break;
                }
                case 329688575: {
                    if (!s.equals((Object)"Elven Queen Clone")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 126498036: {
                    if (!s.equals((Object)"Orc King Clone")) {
                        break;
                    }
                    n = 4;
                    break;
                }
                case -157596397: {
                    if (!s.equals((Object)"Shadow Dragon")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case -522660796: {
                    if (!s.equals((Object)"Tribal Leader Clone")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case -1612488122: {
                    if (!s.equals((Object)"Zombie")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -2074301342: {
                    if (!s.equals((Object)"Spider Clone")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    this.shadowKillChance = 0.0f;
                    this.shadowHealChance = 0;
                    this.shadowBlockChance = 0;
                    break;
                }
                case 7: {
                    this.shadowKillChance = 4.0f;
                    this.shadowHealChance = 12;
                    this.shadowBlockChance = 12;
                    break;
                }
                case 6: {
                    this.shadowKillChance = 1.2f;
                    this.shadowHealChance = 3;
                    this.shadowBlockChance = 3;
                    break;
                }
                case 5: {
                    this.shadowKillChance = 2.5f;
                    this.shadowHealChance = 7;
                    this.shadowBlockChance = 7;
                    break;
                }
                case 4: {
                    this.shadowKillChance = 2.0f;
                    this.shadowHealChance = 5;
                    this.shadowBlockChance = 5;
                    break;
                }
                case 3: {
                    this.shadowKillChance = 7.0f;
                    this.shadowHealChance = 15;
                    this.shadowBlockChance = 15;
                    break;
                }
                case 2: {
                    this.shadowKillChance = 1.5f;
                    this.shadowHealChance = 4;
                    this.shadowBlockChance = 4;
                    break;
                }
                case 1: {
                    this.shadowKillChance = 3.0f;
                    this.shadowHealChance = 10;
                    this.shadowBlockChance = 10;
                    break;
                }
                case 0: {
                    this.shadowKillChance = 1.0f;
                    this.shadowHealChance = 2;
                    this.shadowBlockChance = 2;
                    break;
                }
            }
        }
        else {
            if (this.trollPet) {
                this.damageCap = 300000;
            }
            else {
                this.damageCap = 600000;
            }
            if (this.activity.baseTower.baseTowerLevel >= 62) {
                this.damageCap += 200000;
            }
            if (this.activity.baseTower.baseTowerLevel >= 70) {
                this.damageCap += 200000;
            }
            if (this.equippedItems.contains((Object)"Teddy Bear")) {
                this.damageCap += 200000;
            }
            if (this.equippedItems.contains((Object)"Golden Sunglasses")) {
                this.damageCap += 250000;
            }
            if (this.eggstravagantBow) {
                this.damageCap += 400000;
            }
        }
        this.rageMode = false;
        this.fullFeroxiEnhanced = (this.equippedItems.contains((Object)"Sword of Feroxi (E)") && this.equippedItems.contains((Object)"Shield of Feroxi (E)") && this.equippedItems.contains((Object)"Boots of Feroxi (E)") && this.equippedItems.contains((Object)"Gloves of Feroxi (E)") && this.equippedItems.contains((Object)"Helm of Feroxi (E)") && this.equippedItems.contains((Object)"Plate of Feroxi (E)") && this.equippedItems.contains((Object)"Greaves of Feroxi (E)"));
        this.archeryArmourDamageBonus = 0L;
        final Iterator iterator = this.equippedItems.iterator();
        while (iterator.hasNext()) {
            s = (String)iterator.next();
            if (this.archeryArmour.contains((Object)s)) {
                this.archeryArmourDamageBonus += this.ArmourDamage(s);
            }
        }
    }
    
    private boolean DoubleLoot() {
        final MainActivity activity = this.activity;
        boolean b = true;
        if (activity.GetRandom(1, 100) > this.doubleLootChance) {
            b = false;
        }
        return b;
    }
    
    private void EnterRageMode() {
        this.rageMode = true;
        this.rageKillsRemaining = 10;
        this.activity.QuickPopup("You feel the rage of Feroxi take over you!");
    }
    
    private boolean FullLeather() {
        return this.equippedItems.contains((Object)"Leather Top") && this.equippedItems.contains((Object)"Leather Helm") && this.equippedItems.contains((Object)"Leather Greaves") && this.equippedItems.contains((Object)"Leather Gloves") && this.equippedItems.contains((Object)"Leather Boots");
    }
    
    private void GenerateSlayerShop(final String s) {
        for (int i = 0; i < this.slayerShopItems.size(); ++i) {
            if (((String)this.slayerShopCurrency.get(i)).equals((Object)s)) {
                final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.activity, 2131493059, (ViewGroup)null);
                final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
                linearLayout$LayoutParams.bottomMargin = this.activity.GetResource(2131099980);
                if (((String)this.slayerShopCurrency.get(i)).equals((Object)"Killcoins")) {
                    this.slayerShop.addView((View)constraintLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                }
                else {
                    this.slayerShopGems.addView((View)constraintLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                }
                Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.slayerShopItems.get(i)))).into((ImageView)constraintLayout.getChildAt(0));
                final TextView textView = (TextView)constraintLayout.getChildAt(3);
                ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)this.slayerShopItems.get(i));
                ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)this.slayerShopDesc.get(i));
                textView.setText((CharSequence)this.activity.FormatExp((long)this.slayerShopCost.get(i)));
                textView.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda8(this, i));
                constraintLayout.getChildAt(0).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda9(this, i));
            }
        }
    }
    
    private long GetAttackSpeed() {
        long bowSpeed = 0L;
        Label_0104: {
            long n;
            int n2;
            if (this.activity.currentAttackStyle.equals((Object)"Archery")) {
                if (!this.BowEquipped().isEmpty()) {
                    bowSpeed = this.BowSpeed();
                    break Label_0104;
                }
                this.activity.currentAttackStyle = "Attack";
                this.activity.combatManager.SetCombatStyle();
                n = this.activity.myAttackSpeed;
                n2 = this.activity.GetSkillLevel("Attack");
            }
            else {
                n = this.activity.myAttackSpeed;
                n2 = this.activity.GetSkillLevel("Attack");
            }
            bowSpeed = n - n2 * 5L;
        }
        long n3 = 0L;
        Label_0234: {
            if (!this.equippedItems.contains((Object)"Ring of Speed") && !this.equippedItems.contains((Object)"Eternal Ring") && !this.equippedItems.contains((Object)"Berserker Ring") && !this.equippedItems.contains((Object)"Eternal Berserker Ring") && !this.equippedItems.contains((Object)"Ring of Secrets") && !this.equippedItems.contains((Object)"Cognium Ring") && !this.equippedItems.contains((Object)"Ring of Souls")) {
                n3 = bowSpeed;
                if (!this.equippedItems.contains((Object)"Ring of Souls (E)")) {
                    break Label_0234;
                }
            }
            n3 = bowSpeed / 2L;
        }
        long n4 = n3;
        if (this.activity.baseTower.baseTowerLevel >= 60) {
            n4 = n3 - n3 / 5L;
        }
        long n5 = n4;
        if (!this.activity.currentAttackStyle.equals((Object)"Archery")) {
            long n6 = n4;
            if (this.equippedItems.contains((Object)"Larry")) {
                n6 = n4 - 100L;
            }
            final int getWishLevel = this.activity.databaseManager.GetWishLevel("Speed Please", "Endgame");
            n5 = n6;
            if (getWishLevel > 0) {
                n5 = n6 - n6 / 100L * getWishLevel;
            }
        }
        return n5;
    }
    
    private int GetKrampusPieces() {
        final Iterator iterator = this.krampusSet.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (this.equippedItems.contains((Object)iterator.next())) {
                ++n;
            }
        }
        return n;
    }
    
    private long GetRespawnTime() {
        long n;
        if (this.activity.premiumUpgradesPurchased.get(this.activity.premiumUpgrades.indexOf((Object)"Fast Combat"))) {
            n = 900L;
        }
        else {
            n = 1800L;
        }
        long n2 = 0L;
        Label_0085: {
            if (!this.equippedItems.contains((Object)"Cognium Ring")) {
                n2 = n;
                if (!this.equippedItems.contains((Object)"Ring of Secrets")) {
                    break Label_0085;
                }
            }
            n2 = n / 2L;
        }
        long n3 = n2;
        if (this.equippedItems.contains((Object)"Wings of Cognium")) {
            n3 = n2 / 2L;
        }
        long n4 = n3;
        if (this.activity.baseTower.baseTowerLevel >= 66) {
            n4 = n3 - n3 / 5L;
        }
        return Math.max(n4, 100L);
    }
    
    private int GhostlyMissChance() {
        int i = 0;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Ghostly Top", "Ghostly Cloak", "Ghostly Legs", "Ghostly Hood" }));
        int n = 0;
        while (i < ((List)list).size()) {
            int n2 = n;
            if (this.equippedItems.contains(((List)list).get(i))) {
                n2 = n + 3;
            }
            ++i;
            n = n2;
        }
        return n;
    }
    
    private void GodDrops(String s) {
        final List list = (List)this.allGodDrops.get(this.allGods.indexOf((Object)s));
        final List list2 = (List)this.allGodDropAmounts.get(this.allGods.indexOf((Object)s));
        this.activity.LoadItemSelect("Loot from " + s + " (Rarity Order)");
        this.activity.itemSelect_wrap.removeAllViews();
        for (int i = 0; i < list.size(); ++i) {
            final String[] split = ((String)list2.get(i)).split("\\s*,\\s*");
            final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
            relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
            relativeLayout.setPadding(this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236));
            final ImageView imageView = new ImageView((Context)this.activity);
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.activity.GetResource(2131099769), this.activity.GetResource(2131099769));
            layoutParams.addRule(15);
            imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            imageView.setAdjustViewBounds(true);
            Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(list.get(i)))).into(imageView);
            relativeLayout.addView((View)imageView);
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
            final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -1);
            layoutParams2.addRule(15);
            layoutParams2.setMargins(this.activity.GetResource(2131099880), 0, 0, 0);
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            textView.setGravity(16);
            if (split[0].equals((Object)split[1])) {
                s = this.activity.FormatExp(Long.parseLong(split[0]));
            }
            else {
                s = this.activity.FormatExp(Long.parseLong(split[0])) + " - " + this.activity.FormatExp(Long.parseLong(split[1]));
            }
            textView.setText((CharSequence)(s + "x " + (String)list.get(i)));
            textView.setTextColor(this.activity.white);
            final MainActivity activity = this.activity;
            activity.SetTextSize(textView, activity.GetResource(2131099658));
            relativeLayout.addView((View)textView);
            this.activity.itemSelect_wrap.addView((View)relativeLayout);
            final MainActivity activity2 = this.activity;
            activity2.AddBorder((ViewGroup)activity2.itemSelect_wrap);
        }
    }
    
    private void KillPlayer() {
        final MainActivity activity = this.activity;
        ++activity.totalDeaths;
        this.activity.currentHealth = 0;
        this.activity.myHealthBar.setProgress(this.activity.currentHealth);
        final TextView myHealth = this.activity.myHealth;
        final MainActivity activity2 = this.activity;
        myHealth.setText((CharSequence)activity2.getString(2131820639, new Object[] { activity2.currentHealth, this.activity.maxHealth }));
        this.activity.UpdateBottomNav();
        this.activity.myAttackTimer.cancel();
        this.activity.enemyAttackTimer.cancel();
        this.activity.attackSpeedBar.setProgress(0);
        this.activity.inCombat = false;
        this.activity.GoHome();
        if (this.activity.baseTower.baseTowerLevel >= 35) {
            this.CollectLoot();
            this.activity.QuickPopup("You died, but managed to grab your loot just in time.");
        }
        else {
            this.activity.QuickPopup("You died and lost all your loot");
            this.activity.currentLoot.clear();
            this.activity.currentLootAmounts.clear();
        }
    }
    
    private void OpenSlayerCasket() {
        final List<Float> slayerCasketOdds = this.slayerCasketOdds;
        final float randomFloat = this.RandomFloat(0.0f, (float)slayerCasketOdds.get(slayerCasketOdds.size() - 1));
        this.activity.LogIt("Roll is: " + randomFloat);
        int n = 0;
        int n2;
        while (true) {
            final int size = this.slayerCasketLoot.size();
            n2 = -1;
            if (n >= size) {
                n = -1;
                break;
            }
            if (randomFloat < (float)this.slayerCasketOdds.get(n)) {
                this.activity.LogIt("Reward is: " + n);
                break;
            }
            ++n;
        }
        int n3 = n;
        if (n < 0) {
            n3 = this.slayerCasketLoot.size() - 1;
        }
        final String s = (String)this.slayerCasketLoot.get(n3);
        s.hashCode();
        int n4 = 0;
        switch (s.hashCode()) {
            default: {
                n4 = n2;
                break;
            }
            case 1803406242: {
                if (!s.equals((Object)"Soul Gem")) {
                    n4 = n2;
                    break;
                }
                n4 = 4;
                break;
            }
            case 1721869536: {
                if (!s.equals((Object)"Enhancement Ticket")) {
                    n4 = n2;
                    break;
                }
                n4 = 3;
                break;
            }
            case 812281961: {
                if (!s.equals((Object)"Pumpkin Seed")) {
                    n4 = n2;
                    break;
                }
                n4 = 2;
                break;
            }
            case 658894417: {
                if (!s.equals((Object)"Gold Coin")) {
                    n4 = n2;
                    break;
                }
                n4 = 1;
                break;
            }
            case -819624483: {
                if (!s.equals((Object)"Casket of Treasure")) {
                    n4 = n2;
                    break;
                }
                n4 = 0;
                break;
            }
        }
        int intValue = 0;
        switch (n4) {
            default: {
                intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.slayerCasketLoot.get(n3)));
                this.activity.GiveItem((String)this.slayerCasketLoot.get(n3), (long)this.slayerCasketAmounts.get(n3), false);
                break;
            }
            case 4: {
                final SlayerInfo slayerInfo = this.slayerInfo;
                slayerInfo.soulGems += (long)this.slayerCasketAmounts.get(n3);
                this.slay_soulgems.setText((CharSequence)this.activity.FormatExp(this.slayerInfo.getSoulGems()));
                intValue = 2131166237;
                break;
            }
            case 3: {
                final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                blessings.tickets += (long)this.slayerCasketAmounts.get(n3);
                intValue = 2131165610;
                break;
            }
            case 2: {
                this.activity.GiveSeed("Pumpkin Seed", (long)this.slayerCasketAmounts.get(n3));
                intValue = 2131166089;
                break;
            }
            case 1: {
                final MainActivity activity = this.activity;
                activity.totalGems += (long)this.slayerCasketAmounts.get(n3);
                this.activity.UpdateCash();
                intValue = 2131165871;
                break;
            }
            case 0: {
                final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                myTreasureHunts.caskets += (int)(long)this.slayerCasketAmounts.get(n3);
                intValue = 2131165669;
                break;
            }
        }
        if (n3 <= 5) {
            this.activity.LargePopup(intValue, "Congratulations", "You opened the Slayer Casket and found " + this.activity.FormatExp((long)this.slayerCasketAmounts.get(n3)) + "x " + (String)this.slayerCasketLoot.get(n3) + "!");
        }
        ((ImageView)this.slayerCasketReward.getChildAt(0)).setImageDrawable(this.activity.GetImage(intValue));
        ((TextView)this.slayerCasketReward.getChildAt(1)).setText((CharSequence)this.slayerCasketLoot.get(n3));
        ((TextView)this.slayerCasketReward.getChildAt(2)).setText((CharSequence)this.activity.FormatExp((long)this.slayerCasketAmounts.get(n3)));
        if (this.slayerCasketReward.getChildAt(0).getAlpha() < 1.0f) {
            this.slayerCasketReward.getChildAt(0).setAlpha(1.0f);
        }
        if (this.slayerCasketReward.getChildAt(1).getAlpha() < 1.0f) {
            this.slayerCasketReward.getChildAt(1).setAlpha(1.0f);
        }
        if (this.slayerCasketReward.getChildAt(2).getAlpha() < 1.0f) {
            this.slayerCasketReward.getChildAt(2).setAlpha(1.0f);
        }
    }
    
    private void OutOfArrows() {
        this.activity.myAttackTimer.cancel();
        this.activity.enemyAttackTimer.cancel();
        this.activity.attackSpeedBar.setProgress(0);
        this.CollectLoot();
        this.activity.inCombat = false;
        this.OpenDungeons();
        final List<String> equippedItems = this.equippedItems;
        equippedItems.set(equippedItems.indexOf((Object)this.equippedArrows), (Object)null);
        this.equippedArrows = "";
        this.activity.QuickPopup("You ran out of arrows, so you collected your loot ran away from the enemy.");
    }
    
    private void PickSlayerTask() {
        final int index = this.slayerMasters.indexOf((Object)this.activeMaster);
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])((String)this.slayerMastersTasks.get(index)).split("\\s*/\\s*")));
        final int pickTaskAmount = this.PickTaskAmount((int)this.slayerMastersMinTask.get(index), (int)this.slayerMastersMaxTask.get(index));
        this.slayerInfo.slayerMaster = this.activeMaster;
        this.slayerInfo.slayerTask = (String)((List)list).get(this.activity.randomGenerator.nextInt(((List)list).size()));
        this.slayerInfo.slayerAmount = pickTaskAmount;
        this.slayerInfo.startingAmount = pickTaskAmount;
        this.UpdateSlayer();
        this.activity.LargePopup(2131166479, "New Task", "Your new Slayer task is to kill " + this.slayerInfo.getSlayerAmount() + "x " + this.slayerInfo.getSlayerTask());
    }
    
    private long PotionCritChance() {
        if (this.activity.alchemy.activePotions.contains((Object)"Archery Potion")) {
            return 1L;
        }
        if (this.activity.alchemy.activePotions.contains((Object)"Super Archery Potion")) {
            return 2L;
        }
        if (this.activity.alchemy.activePotions.contains((Object)"Extreme Archery Potion")) {
            return 3L;
        }
        if (this.activity.alchemy.activePotions.contains((Object)"Ultimate Archery Potion")) {
            return 5L;
        }
        return 0L;
    }
    
    private boolean PrimalEquipped() {
        boolean b = false;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Primal Top", "Primal Gloves", "Primal Boots", "Primal Legs", "Primal Helm" }));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm" }));
        final ArrayList list3 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Soul Reaper Top (E)", "Soul Reaper Gloves (E)", "Soul Reaper Boots (E)", "Soul Reaper Legs (E)", "Soul Reaper Helm (E)" }));
        for (int i = 0; i < ((List)list).size(); ++i) {
            if (!this.equippedItems.contains(((List)list).get(i)) && !this.equippedItems.contains(((List)list2).get(i)) && !this.equippedItems.contains(((List)list3).get(i))) {
                return b;
            }
        }
        b = true;
        return b;
    }
    
    private void SelectGodDrop(String s) {
        final List list = (List)this.allGodDrops.get(this.allGods.indexOf((Object)s));
        final List list2 = (List)this.allGodDropAmounts.get(this.allGods.indexOf((Object)s));
        final List list3 = (List)this.allGodDropRates.get(this.allGods.indexOf((Object)s));
        final int getRandom = this.activity.GetRandom(1, Math.toIntExact((long)list3.get(list3.size() - 1)));
        for (int i = 0; i < list.size(); ++i) {
            if (getRandom <= (long)list3.get(i)) {
                s = (String)list.get(i);
                final String[] split = ((String)list2.get(i)).split("\\s*,\\s*");
                int n;
                if (Integer.parseInt(split[0]) == Integer.parseInt(split[1])) {
                    n = Integer.parseInt(split[0]);
                }
                else {
                    n = this.activity.GetRandom(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                }
                int n2 = n;
                if (this.totalMonsterKills >= 100000L) {
                    n2 = n;
                    if (this.DoubleLoot()) {
                        n2 = n * 2;
                    }
                }
                this.UpdateLoot(s, n2);
                break;
            }
        }
    }
    
    private void SelectShadowDrop(final String s) {
        final List list = (List)this.shadowDrops.get(this.shadowMonsters.indexOf((Object)s));
        final List list2 = (List)this.shadowDropAmounts.get(this.shadowMonsters.indexOf((Object)s));
        final List list3 = (List)this.shadowDropRates.get(this.shadowMonsters.indexOf((Object)s));
        final float randomFloat = this.RandomFloat(0.0f, (float)list3.get(list3.size() - 1));
        for (int i = 0; i < list.size(); ++i) {
            if (randomFloat <= (float)list3.get(i)) {
                this.UpdateLoot((String)list.get(i), (long)list2.get(i));
                break;
            }
        }
    }
    
    private void SetTask(final String slayerTask) {
        this.slayerInfo.slayerMaster = this.activeMaster;
        this.slayerInfo.slayerTask = slayerTask;
        final int pickTaskAmount = this.PickTaskAmount((int)this.slayerMastersMinTask.get(this.slayerMasters.indexOf((Object)this.activeMaster)), (int)this.slayerMastersMaxTask.get(this.slayerMasters.indexOf((Object)this.activeMaster)));
        this.slayerInfo.slayerAmount = pickTaskAmount;
        this.slayerInfo.startingAmount = pickTaskAmount;
        this.UpdateSlayer();
        this.activity.LargePopup(2131166479, "New Task", "Your new Slayer task is to kill " + this.slayerInfo.getSlayerAmount() + "x " + this.slayerInfo.getSlayerTask());
    }
    
    private void ShadowDrops(final String s) {
        final List list = (List)this.shadowDrops.get(this.shadowMonsters.indexOf((Object)s));
        final List list2 = (List)this.shadowDropAmounts.get(this.shadowMonsters.indexOf((Object)s));
        this.activity.LoadItemSelect("Loot from " + s + " (Rarity Order)");
        this.activity.itemSelect_wrap.removeAllViews();
        for (int i = 0; i < list.size(); ++i) {
            final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
            relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
            relativeLayout.setPadding(this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236));
            final ImageView imageView = new ImageView((Context)this.activity);
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.activity.GetResource(2131099769), this.activity.GetResource(2131099769));
            layoutParams.addRule(15);
            imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            int n = 1;
            imageView.setAdjustViewBounds(true);
            final String s2 = (String)list.get(i);
            s2.hashCode();
            Label_0373: {
                switch (s2.hashCode()) {
                    case 1721869536: {
                        if (!s2.equals((Object)"Enhancement Ticket")) {
                            break;
                        }
                        n = 3;
                        break Label_0373;
                    }
                    case 1253687303: {
                        if (!s2.equals((Object)"Slayer Casket")) {
                            break;
                        }
                        n = 2;
                        break Label_0373;
                    }
                    case -458446738: {
                        if (!s2.equals((Object)"Challenge Coin")) {
                            break;
                        }
                        break Label_0373;
                    }
                    case -1274418954: {
                        if (!s2.equals((Object)"Treasure Casket")) {
                            break;
                        }
                        n = 0;
                        break Label_0373;
                    }
                }
                n = -1;
            }
            int intValue = 0;
            switch (n) {
                default: {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(list.get(i)));
                    break;
                }
                case 3: {
                    intValue = 2131165610;
                    break;
                }
                case 2: {
                    intValue = 2131166225;
                    break;
                }
                case 1: {
                    intValue = 2131165354;
                    break;
                }
                case 0: {
                    intValue = 2131165669;
                    break;
                }
            }
            Picasso.get().load(intValue).into(imageView);
            relativeLayout.addView((View)imageView);
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
            final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -1);
            layoutParams2.addRule(15);
            layoutParams2.setMargins(this.activity.GetResource(2131099880), 0, 0, 0);
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            textView.setGravity(16);
            textView.setText((CharSequence)(this.activity.FormatExp((long)list2.get(i)) + "x " + (String)list.get(i)));
            textView.setTextColor(this.activity.white);
            final MainActivity activity = this.activity;
            activity.SetTextSize(textView, activity.GetResource(2131099658));
            relativeLayout.addView((View)textView);
            this.activity.itemSelect_wrap.addView((View)relativeLayout);
            final MainActivity activity2 = this.activity;
            activity2.AddBorder((ViewGroup)activity2.itemSelect_wrap);
        }
    }
    
    private int SoulReaperInstaKill() {
        int i = 0;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Soul Reaper Sword", "Soul Reaper Top (E)", "Soul Reaper Gloves (E)", "Soul Reaper Boots (E)", "Soul Reaper Legs (E)", "Soul Reaper Helm (E)", "Soul Reaper Sword (E)" }));
        int n = 0;
        while (i < ((List)list).size()) {
            int n2 = n;
            if (this.equippedItems.contains(((List)list).get(i))) {
                if (((String)((List)list).get(i)).contains((CharSequence)"(E)")) {
                    n2 = n + 7;
                }
                else {
                    n2 = n + 5;
                }
            }
            ++i;
            n = n2;
        }
        return n;
    }
    
    private void UpdateMonsterKills() {
        this.totalMonsterKillsCmb.setText((CharSequence)("Total Kills: " + this.activity.FormatExp(this.totalMonsterKills)));
    }
    
    private void UpdateSlayer() {
        this.slay_darkthread.setText((CharSequence)this.activity.FormatExp(this.slayerInfo.getDarkThread()));
        this.slay_soulgems.setText((CharSequence)this.activity.FormatExp(this.slayerInfo.getSoulGems()));
        this.slay_soulthread.setText((CharSequence)this.activity.FormatExp(this.slayerInfo.getSoulThread()));
        long n;
        long n2;
        if (this.slayerInfo.getSlayerTask().isEmpty()) {
            this.slay_activeTask.setText((CharSequence)"No Active Task");
            this.slay_cancelKc.setText((CharSequence)"N/A");
            this.slay_cancelGold.setText((CharSequence)"N/A");
            n = 0L;
            n2 = 0L;
        }
        else {
            if (this.slayerInfo.getSlayerMaster().equals((Object)"Illunaris")) {
                n = 5000L;
                n2 = 50000L;
            }
            else {
                n = (long)this.slayerMastersKillCoins.get(this.slayerMasters.indexOf((Object)this.slayerInfo.getSlayerMaster())) * 5L;
                n2 = (long)this.slayerMastersKillCoins.get(this.slayerMasters.indexOf((Object)this.slayerInfo.getSlayerMaster())) * 2L;
            }
            this.slay_activeTask.setText((CharSequence)(this.slayerInfo.getSlayerTask() + " (" + this.activity.FormatExp((long)this.slayerInfo.getSlayerAmount()) + " left)"));
            this.slay_cancelKc.setText((CharSequence)("Cancel Task (" + this.activity.FormatExp(n) + " Killcoins)"));
            this.slay_cancelGold.setText((CharSequence)("Cancel Task (" + this.activity.FormatExp(n2) + " Gold)"));
        }
        if (this.activeMaster.isEmpty()) {
            this.slay_activeMaster.setText((CharSequence)"Select a Slayer Master");
        }
        else {
            this.slay_activeMaster.setText((CharSequence)this.activeMaster);
        }
        this.slay_activeMaster.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda16(this));
        this.slay_newTask.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda17(this));
        this.slay_cancelKc.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda18(this, n));
        this.slay_cancelGold.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda19(this, n2));
        this.slay_activeTask.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda20(this));
    }
    
    private long getEnemySpeed(int n) {
        final String s = (String)this.enemyAttackSpeed.get(n);
        s.hashCode();
        final int hashCode = s.hashCode();
        n = -1;
        switch (hashCode) {
            case 699990278: {
                if (!s.equals((Object)"Very Fast")) {
                    break;
                }
                n = 5;
                break;
            }
            case 2580001: {
                if (!s.equals((Object)"Slow")) {
                    break;
                }
                n = 4;
                break;
            }
            case 2182268: {
                if (!s.equals((Object)"Fast")) {
                    break;
                }
                n = 3;
                break;
            }
            case -576502989: {
                if (!s.equals((Object)"Shadows")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1994163307: {
                if (!s.equals((Object)"Medium")) {
                    break;
                }
                n = 1;
                break;
            }
            case -2099929270: {
                if (!s.equals((Object)"Insane")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        long n2 = 0L;
        switch (n) {
            default: {
                n2 = 0L;
                break;
            }
            case 5: {
                n2 = 1500L;
                break;
            }
            case 4: {
                n2 = 3000L;
                break;
            }
            case 3: {
                n2 = 2000L;
                break;
            }
            case 2: {
                n2 = 400L;
                break;
            }
            case 1: {
                n2 = 2500L;
                break;
            }
            case 0: {
                n2 = 1000L;
                break;
            }
        }
        long n3 = n2;
        if (this.equippedItems.contains((Object)"Krampus Horns")) {
            n3 = n2 + n2 / 4L;
        }
        long n4 = n3;
        if (this.equippedItems.contains((Object)"Sunglasses")) {
            n4 = n3 + n3 / 2L;
        }
        long n5 = n4;
        if (this.equippedItems.contains((Object)"Pink Sunglasses")) {
            n5 = n4 + n4 / 10L * 6L;
        }
        long n6 = n5;
        if (this.equippedItems.contains((Object)"Golden Sunglasses")) {
            n6 = n5 + n5 / 10L * 7L;
        }
        return n6;
    }
    
    public long ArmourCrit(final String s) {
        if (this.archeryArmour.contains((Object)s)) {
            return (long)this.archeryArmourCrit.get(this.archeryArmour.indexOf((Object)s));
        }
        return 0L;
    }
    
    public long ArmourDamage(final String s) {
        if (this.archeryArmour.contains((Object)s)) {
            return (long)this.archeryArmourDamage.get(this.archeryArmour.indexOf((Object)s));
        }
        return 0L;
    }
    
    public long ArrowDamage() {
        for (final String s : this.archeryArrows) {
            if (this.equippedItems.contains((Object)s)) {
                return (long)this.archeryArrowDamage.get(this.archeryArrows.indexOf((Object)s));
            }
        }
        return 0L;
    }
    
    public long ArrowsEquipped() {
        for (final String s : this.archeryArrows) {
            if (this.equippedItems.contains((Object)s)) {
                if (this.activity.inventoryItems.contains((Object)s)) {
                    return (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)s));
                }
                break;
            }
        }
        return 0L;
    }
    
    public long BowAccuracy() {
        return (long)this.archeryBowAccuracy.get(this.archeryBows.indexOf((Object)this.BowEquipped()));
    }
    
    public long BowDamage() {
        return (long)this.archeryBowDamage.get(this.archeryBows.indexOf((Object)this.BowEquipped()));
    }
    
    public String BowEquipped() {
        for (final String s : this.archeryBows) {
            if (this.equippedItems.contains((Object)s)) {
                return s;
            }
        }
        return "";
    }
    
    public long BowSpeed() {
        return (long)this.archeryBowSpeed.get(this.archeryBows.indexOf((Object)this.BowEquipped()));
    }
    
    public void CheckSecret(final String s, final int n, int n2) {
        int n3 = n2;
        try {
            if (this.activity.databaseManager.GetWishLevel("Secrets", "Beginner") >= 1) {
                n3 = n2 - n2 / 100 * this.activity.databaseManager.GetWishLevel("Secrets", "Beginner");
            }
        }
        catch (final Exception ex) {
            this.activity.LogIt("Wishes Exception");
            n3 = n2;
        }
        n2 = n3;
        if (this.activity.baseTower.baseTowerLevel >= 65) {
            n2 = n3 - n3 / 20;
        }
        int n4 = n2;
        if (this.equippedItems.contains((Object)"Ring of Secrets")) {
            n4 = n2 - n2 / 10;
        }
        n2 = n4;
        if (this.activity.treasureHunts.BoostActive("Secret Hunter")) {
            n2 = n4 - n4 / 10;
        }
        int n5 = n2;
        if (this.equippedItems.contains((Object)"Cassie the Casket")) {
            n5 = n2 - n2 / 20;
        }
        n2 = n5;
        if (this.equippedItems.contains((Object)"Marshmallow the Bunny")) {
            n2 = n5 - n5 / 10;
        }
        int n6 = n2;
        if (this.activity.alchemy.activePotions.contains((Object)"Luck Potion")) {
            n6 = n2 - n2 / 100;
        }
        n2 = n6;
        if (this.activity.alchemy.activePotions.contains((Object)"Extreme Luck Potion")) {
            n2 = n6 - n6 / 50;
        }
        if (this.activity.GetRandom(1, Math.max(n2, 500)) <= 2) {
            this.activity.GiveItem(s, 1L, false);
            this.activity.LargePopup(n, "Congratulations!", "You manage to find the secret rare: " + s + "!");
        }
    }
    
    public void CollectLoot() {
        for (int i = 0; i < this.activity.currentLoot.size(); ++i) {
            final String s = (String)this.activity.currentLoot.get(i);
            s.hashCode();
            final int hashCode = s.hashCode();
            int n = -1;
            switch (hashCode) {
                case 1803406242: {
                    if (!s.equals((Object)"Soul Gem")) {
                        break;
                    }
                    n = 6;
                    break;
                }
                case 1721869536: {
                    if (!s.equals((Object)"Enhancement Ticket")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 1253687303: {
                    if (!s.equals((Object)"Slayer Casket")) {
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
                case 65287138: {
                    if (!s.equals((Object)"Coins")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case -458446738: {
                    if (!s.equals((Object)"Challenge Coin")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -1274418954: {
                    if (!s.equals((Object)"Treasure Casket")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    if (this.activity.farming.farmingSeeds.contains(this.activity.currentLoot.get(i))) {
                        final MainActivity activity = this.activity;
                        activity.GiveSeed((String)activity.currentLoot.get(i), (long)this.activity.currentLootAmounts.get(i));
                    }
                    else {
                        final MainActivity activity2 = this.activity;
                        if (activity2.InventoryNotFull((String)activity2.currentLoot.get(i))) {
                            final MainActivity activity3 = this.activity;
                            activity3.GiveItem((String)activity3.currentLoot.get(i), (long)this.activity.currentLootAmounts.get(i), false);
                        }
                        else if (this.activity.baseTower.myTreestones.contains((Object)"Treestone of Space")) {
                            final MainActivity activity4 = this.activity;
                            if (activity4.StashNotFull((String)activity4.currentLoot.get(i))) {
                                final MainActivity activity5 = this.activity;
                                activity5.GiveItemStash((String)activity5.currentLoot.get(i), (long)this.activity.currentLootAmounts.get(i), true);
                            }
                        }
                    }
                    if (((String)this.activity.currentLoot.get(i)).equals((Object)this.activity.equippedFood) && this.activity.currentLoot.contains((Object)this.activity.equippedFood)) {
                        long longValue;
                        if (this.activity.inventoryItems.contains((Object)this.activity.equippedFood)) {
                            longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)this.activity.equippedFood));
                        }
                        else {
                            longValue = 0L;
                        }
                        final TextView eatFood = this.activity.eatFood;
                        final MainActivity activity6 = this.activity;
                        eatFood.setText((CharSequence)activity6.getString(2131820619, new Object[] { activity6.equippedFood, longValue }));
                        this.activity.UpdateBottomNav();
                        break;
                    }
                    break;
                }
                case 6: {
                    final SlayerInfo slayerInfo = this.slayerInfo;
                    slayerInfo.soulGems += (long)this.activity.currentLootAmounts.get(i);
                    break;
                }
                case 5: {
                    final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                    blessings.tickets += (long)this.activity.currentLootAmounts.get(i);
                    break;
                }
                case 4: {
                    final SlayerInfo slayerInfo2 = this.slayerInfo;
                    slayerInfo2.slayerCaskets += (long)this.activity.currentLootAmounts.get(i);
                    break;
                }
                case 3: {
                    final MainActivity activity7 = this.activity;
                    activity7.totalGems += (long)this.activity.currentLootAmounts.get(i);
                    this.activity.UpdateCash();
                    break;
                }
                case 2: {
                    final MainActivity activity8 = this.activity;
                    activity8.totalCoins += (long)this.activity.currentLootAmounts.get(i);
                    this.activity.UpdateCash();
                    break;
                }
                case 1: {
                    final Dailies dailies = this.activity.dailies;
                    dailies.challengeCoins += (int)(long)this.activity.currentLootAmounts.get(i);
                    break;
                }
                case 0: {
                    final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                    myTreasureHunts.caskets += (int)(long)this.activity.currentLootAmounts.get(i);
                    break;
                }
            }
            if (i == this.activity.currentLoot.size() - 1) {
                this.activity.lootList.removeAllViews();
                this.activity.currentLoot.clear();
                this.activity.currentLootAmounts.clear();
            }
        }
    }
    
    public void CompleteSlayerTask() {
        this.activity.QuickPopup("Slayer Task Complete");
        this.activity.dailies.UpdateDailies("Slayer", "Slayer", 1);
        this.activity.secretPathway.CheckPathway("Slayer", this.slayerInfo.getSlayerMaster());
        if (this.slayerInfo.getSlayerMaster().equals((Object)"Lumen")) {
            this.CheckSecret("Mystic Dagger", 2131166026, 5000);
        }
        if (this.slayerInfo.getSlayerMaster().equals((Object)"Vain")) {
            this.CheckSecret("Extreme Power Stone", 2131165815, 2500);
        }
        if ((this.slayerInfo.getSlayerMaster().equals((Object)"Adamet") || this.slayerInfo.getSlayerMaster().equals((Object)"Sylthenia") || this.slayerInfo.getSlayerMaster().equals((Object)"Illunaris")) && this.PrimalEquipped()) {
            int n;
            if (this.activity.alchemy.activePotions.contains((Object)"Soul Reaper Potion")) {
                n = 60000;
            }
            else {
                n = 75000;
            }
            if (this.activity.GetRandom(1, n) <= 1) {
                final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Soul Reaper Sword" }));
                final String s = (String)((List)list).get(this.activity.randomGenerator.nextInt(((List)list).size()));
                if (this.activity.InventoryNotFull(s)) {
                    this.activity.GiveItem(s, 1L, false);
                    final MainActivity activity = this.activity;
                    activity.LargePopup((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s)), "Congratulations", "You managed to find a piece of the Soul Reaper Outfit!");
                }
                else {
                    final MainActivity activity2 = this.activity;
                    activity2.LargePopup((int)activity2.allItemsIcons.get(this.activity.allItems.indexOf((Object)s)), "Unlucky", "You managed to find a Soul Reaper piece, but your Inventory was full!");
                }
            }
            if (this.activity.GetRandom(1, 15) <= 1) {
                final SlayerInfo slayerInfo = this.slayerInfo;
                ++slayerInfo.slayerCaskets;
                this.activity.LargePopup(2131166225, "Congratulations", "After completing your task you were awarded a Slayer Casket!");
            }
        }
        if (this.activity.GetRandom(1, 100000) <= 2) {
            this.activity.GiveTitle("the Slayer Master");
        }
        int intValue;
        final int n2 = intValue = (int)this.slayerMastersLevelUnlock.get(this.slayerMasters.indexOf((Object)this.slayerInfo.getSlayerMaster()));
        if (this.slayerInfo.getSlayerMaster().equals((Object)"Sylthenia")) {
            intValue = n2 * 2;
        }
        int n3 = intValue;
        if (this.slayerInfo.getSlayerMaster().equals((Object)"Illunaris")) {
            n3 = intValue * 3;
        }
        int n4 = n3;
        if (this.activity.baseTower.baseTowerLevel >= 56) {
            n4 = n3 + n3 / 5;
        }
        int n5 = n4;
        if (this.activity.alchemy.activePotions.contains((Object)"Soul Reaper Potion")) {
            n5 = n4 + n4 / 5;
        }
        if (this.activity.GetRandom(1, 5000) <= n5 && !this.equippedItems.contains((Object)"Adam the Troll")) {
            long n6;
            if (this.equippedItems.contains((Object)"Carrie")) {
                n6 = 2L;
            }
            else {
                n6 = 1L;
            }
            long n7 = n6;
            if (this.equippedItems.contains((Object)"Saul the Soul")) {
                n7 = n6 + 3L;
            }
            long n8 = 0L;
            Label_0752: {
                if (this.equippedItems.contains((Object)"Ring of Souls")) {
                    n8 = n7 * 2L;
                }
                else {
                    if (!this.equippedItems.contains((Object)"Ring of Souls (E)")) {
                        n8 = n7;
                        if (!this.equippedItems.contains((Object)"Ring of Secrets")) {
                            break Label_0752;
                        }
                    }
                    n8 = n7 * 4L;
                }
            }
            long n9 = n8;
            if (this.activity.baseTower.baseTowerLevel >= 68) {
                n9 = n8;
                if (this.activity.GetRandom(1, 100) <= 20) {
                    n9 = n8 * 2L;
                }
            }
            this.activity.LargePopup(2131166237, "Congratulations!", "After completing the Slayer task, you were awarded " + n9 + "x Soul Gem!");
            final SlayerInfo slayerInfo2 = this.slayerInfo;
            slayerInfo2.soulGems += n9;
            if (!this.activity.myPets.contains((Object)"Saul the Soul") && this.activity.GetRandom(1, 250000) <= 1) {
                this.activity.myPets.add((Object)"Saul the Soul");
                this.activity.LargePopup(2131166237, "Congratulations!", "After completing the Slayer task, you found Saul the Soul pet!");
            }
            final int getWishLevel = this.activity.databaseManager.GetWishLevel("Soul Reaper", "Endgame");
            if (getWishLevel > 0 && this.activity.GetRandom(1, 1000) <= getWishLevel) {
                this.activity.GiveItem("Soul Reaper Fragment", 1L, false);
                this.activity.LargePopup(2131166239, "Congratulations!", "After completing the Slayer task, your wish finds a Soul Reaper Fragment!");
            }
        }
        long longValue;
        if (!this.equippedItems.contains((Object)"Slayer Cape") && !this.equippedItems.contains((Object)"Max Cape") && !this.equippedItems.contains((Object)"Mini Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") && !this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
            longValue = (long)this.slayerMastersKillCoins.get(this.slayerMasters.indexOf((Object)this.slayerInfo.getSlayerMaster()));
        }
        else {
            longValue = (long)this.slayerMastersKillCoins.get(this.slayerMasters.indexOf((Object)this.slayerInfo.getSlayerMaster())) * 2L;
        }
        final long n10 = (long)(longValue / 100.0f * (this.activity.databaseManager.GetWishLevel("Killcoins", "Beginner") * 5L));
        final SlayerInfo slayerInfo3 = this.slayerInfo;
        slayerInfo3.killcoins += longValue + n10;
        this.activity.UpdateCash();
        final MainActivity activity3 = this.activity;
        ++activity3.slayerTasksCompleted;
        if (!this.slayerInfo.slayerMaster.equals((Object)"Illunaris") && (this.equippedItems.contains((Object)"Ring of Souls") || this.equippedItems.contains((Object)"Ring of Souls (E)") || this.equippedItems.contains((Object)"Ring of Secrets"))) {
            this.activity.QuickPopup("Your Ring of Souls restarts your Slayer task.");
            if (this.slayerInfo.getStartingAmount() > 0) {
                final SlayerInfo slayerInfo4 = this.slayerInfo;
                slayerInfo4.slayerAmount = slayerInfo4.getStartingAmount();
            }
            else {
                this.slayerInfo.slayerAmount = 100;
            }
        }
        else {
            final MainActivity activity4 = this.activity;
            activity4.HideView((View)activity4.combatSlayerProgress);
            this.slayerInfo.slayerTask = "";
            this.slayerInfo.slayerAmount = 0;
            this.slayerInfo.slayerMaster = "";
        }
    }
    
    public int DragonRiderBuff(String s) {
        final boolean contains = s.contains((CharSequence)"Dragon");
        int n = 0;
        int i = 0;
        if (contains) {
            n = 0;
            while (i < 5) {
                s = (new String[] { "Dragon Rider Boots", "Dragon Rider Gloves", "Dragon Rider Greaves", "Dragon Rider Helm", "Dragon Rider Top" })[i];
                int n2 = n;
                if (this.equippedItems.contains((Object)s)) {
                    n2 = n + 10;
                }
                ++i;
                n = n2;
            }
        }
        return n;
    }
    
    public void FightScreen(final String s) {
        if (!this.BowEquipped().isEmpty() && this.ArrowsEquipped() == 0L) {
            this.activity.QuickPopup("You need to equip Arrows in order to fight with a bow.");
            return;
        }
        this.activeMonster = s;
        if (this.totalMonsterKillsCmb == null) {
            this.totalMonsterKillsCmb = (TextView)this.activity.findViewById(2131297263);
        }
        final long longValue = (long)this.activity.accountStats.getAllMonsterKills().get(this.enemyNames.indexOf((Object)s));
        this.totalMonsterKills = longValue;
        this.doubleLootChance = Math.min(longValue / 100000L * 20L, 100L);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.combatScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.EnableScreen();
        this.activity.totalKills = 0;
        if (!this.slayerInfo.getSlayerTask().isEmpty()) {
            if (this.slayerInfo.getSlayerTask().equals((Object)s)) {
                final MainActivity activity4 = this.activity;
                activity4.ShowView((View)activity4.combatSlayerProgress);
                this.activity.combatSlayerProgress.setText((CharSequence)("Slayer Kills Left: " + this.slayerInfo.getSlayerAmount()));
            }
            else if (this.slayerInfo.getSlayerTask().equals((Object)"Gods") && this.allGods.contains((Object)s)) {
                final MainActivity activity5 = this.activity;
                activity5.ShowView((View)activity5.combatSlayerProgress);
                this.activity.combatSlayerProgress.setText((CharSequence)("Slayer Kills Left: " + this.slayerInfo.getSlayerAmount()));
            }
            else {
                final MainActivity activity6 = this.activity;
                activity6.HideView((View)activity6.combatSlayerProgress);
            }
        }
        else {
            final MainActivity activity7 = this.activity;
            activity7.HideView((View)activity7.combatSlayerProgress);
        }
        this.UpdateSkillProgress();
        this.SetCombatStyle();
        this.CombatCalculations(s);
        this.eggArrows = false;
        this.activity.enemyHealthBar.setProgress((int)this.enemyHealth.get(this.enemyNames.indexOf((Object)s)));
        this.activity.enemyHealthBar.setMax((int)this.enemyHealth.get(this.enemyNames.indexOf((Object)s)));
        this.activity.currentLoot.clear();
        this.activity.currentLootAmounts.clear();
        this.activity.inCombat = true;
        this.activity.lootList.removeAllViews();
        if (!this.activity.equippedFood.isEmpty()) {
            long longValue2;
            if (this.activity.inventoryItems.contains((Object)this.activity.equippedFood)) {
                longValue2 = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)this.activity.equippedFood));
            }
            else {
                longValue2 = 0L;
            }
            final TextView eatFood = this.activity.eatFood;
            final MainActivity activity8 = this.activity;
            eatFood.setText((CharSequence)activity8.getString(2131820619, new Object[] { activity8.equippedFood, longValue2 }));
            this.activity.eatFood.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda0(this));
        }
        else {
            this.activity.eatFood.setText((CharSequence)"No food equipped");
        }
        if (this.ArrowsEquipped() > 0L) {
            this.activity.currentArrows.setText((CharSequence)("Arrows: " + this.activity.FormatCoins(this.ArrowsEquipped())));
            this.equippedArrows = this.FindArrows();
        }
        else {
            this.equippedArrows = "";
            this.activity.currentArrows.setText((CharSequence)"No Arrows");
        }
        if (!this.BowEquipped().isEmpty()) {
            this.activity.currentAttackStyle = "Archery";
            this.activity.combatManager.SetCombatStyle();
            this.activity.combatManager.UpdateSkillProgress();
        }
        if (!this.BowEquipped().isEmpty() && this.ArrowsEquipped() > 0L) {
            this.activity.currentAttackStyle = "Archery";
            this.activity.combatManager.SetCombatStyle();
            this.activity.combatManager.UpdateSkillProgress();
            this.eggArrows = this.equippedItems.contains((Object)"Egg Arrows");
        }
        if (this.BowEquipped().isEmpty() && this.activity.currentAttackStyle.equals((Object)"Archery")) {
            this.activity.currentAttackStyle = "Attack";
            this.activity.combatManager.SetCombatStyle();
            this.activity.combatManager.UpdateSkillProgress();
        }
        if (!this.BowEquipped().isEmpty() && this.ArrowsEquipped() <= 0L && this.activity.currentAttackStyle.equals((Object)"Archery")) {
            this.activity.currentAttackStyle = "Attack";
            this.activity.combatManager.SetCombatStyle();
            this.activity.combatManager.UpdateSkillProgress();
        }
        final String[] split = ((String)this.enemyDrops.get(this.enemyNames.indexOf((Object)s))).split("\\s*/\\s*");
        this.activity.drops.clear();
        this.activity.dropMin.clear();
        this.activity.dropMax.clear();
        this.activity.dropRarity.clear();
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] split2 = split[i].split("\\s*,\\s*");
            this.activity.drops.add((Object)split2[0]);
            this.activity.dropMin.add((Object)Integer.valueOf(split2[1]));
            this.activity.dropMax.add((Object)Integer.valueOf(split2[2]));
            this.activity.dropRarity.add((Object)split2[3]);
        }
        final int index = this.enemyNames.indexOf((Object)s);
        final int getCombatLevel = this.activity.GetCombatLevel((int)this.enemyAttack.get(index), (int)this.enemyStrength.get(index), (int)this.enemyDefence.get(index), (int)this.enemyHealth.get(index));
        Picasso.get().load((int)this.enemyIcons.get(index)).into(this.activity.enemyImage);
        this.activity.enemyNameTv.setText((CharSequence)s);
        final TextView enemyCombatLevelTv = this.activity.enemyCombatLevelTv;
        final MainActivity activity9 = this.activity;
        enemyCombatLevelTv.setText((CharSequence)activity9.getString(2131820620, new Object[] { activity9.FormatExp((long)getCombatLevel) }));
        this.ResetCombat(s);
        this.activity.combatButtons.getChildAt(0).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda11(this));
        this.activity.combatButtons.getChildAt(1).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda14(this));
    }
    
    public String FindArrows() {
        for (final String s : this.archeryArrows) {
            if (this.equippedItems.contains((Object)s)) {
                if (this.activity.inventoryItems.contains((Object)s)) {
                    return s;
                }
                break;
            }
        }
        return "";
    }
    
    public void GenerateDungeon(final String s, final LinearLayout linearLayout) {
        final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099758)));
        relativeLayout.setBackgroundColor(this.activity.GetColour(2131034148));
        linearLayout.addView((View)relativeLayout);
        for (int i = 0; i < this.enemyArea.size(); ++i) {
            if (((String)this.enemyArea.get(i)).equals((Object)s)) {
                if (s.equals((Object)"Kingdom of the Gods")) {
                    if (this.weeklyGods.contains(this.enemyNames.get(i))) {
                        this.AddEnemy(i, linearLayout);
                    }
                }
                else {
                    this.AddEnemy(i, linearLayout);
                }
            }
        }
    }
    
    public void GenerateDungeons() {
        for (int i = 0; i < this.battleAreas.size(); ++i) {
            final LinearLayout linearLayout = (LinearLayout)this.activity.dungeonWrap.getChildAt(i);
            final LinearLayout linearLayout2 = (LinearLayout)linearLayout.getChildAt(0);
            final LinearLayout linearLayout3 = (LinearLayout)linearLayout.getChildAt(1);
            ((TextView)linearLayout2.getChildAt(0)).setText((CharSequence)this.battleAreas.get(i));
            ((TextView)linearLayout2.getChildAt(1)).setText((CharSequence)this.battleAreasDifficulty.get(i));
            if (linearLayout3.getVisibility() == 0) {
                linearLayout3.setVisibility(8);
            }
            linearLayout2.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda15(this, linearLayout3, i));
        }
    }
    
    public void MonsterDrops(int i) {
        this.activity.LoadItemSelect("Loot from " + (String)this.enemyNames.get(i));
        this.activity.itemSelect_wrap.removeAllViews();
        final String[] split = ((String)this.enemyDrops.get(i)).split("\\s*/\\s*");
        int length;
        String[] split2;
        RelativeLayout relativeLayout;
        ImageView imageView;
        RelativeLayout$LayoutParams layoutParams;
        LinearLayout linearLayout;
        RelativeLayout$LayoutParams layoutParams2;
        TextView textView;
        LinearLayout$LayoutParams layoutParams3;
        String s;
        MainActivity activity;
        TextView textView2;
        MainActivity activity2;
        MainActivity activity3;
        for (length = split.length, i = 0; i < length; ++i) {
            split2 = split[i].split("\\s*,\\s*");
            if (!split2[3].equals((Object)"Secret Rare")) {
                relativeLayout = new RelativeLayout((Context)this.activity);
                relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
                relativeLayout.setPadding(this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658));
                imageView = new ImageView((Context)this.activity);
                layoutParams = new RelativeLayout$LayoutParams(this.activity.GetResource(2131099813), this.activity.GetResource(2131099813));
                layoutParams.addRule(15);
                imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                imageView.setAdjustViewBounds(true);
                try {
                    Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)split2[0]))).into(imageView);
                }
                catch (final IndexOutOfBoundsException ex) {
                    Picasso.get().load(2131166220).into(imageView);
                }
                relativeLayout.addView((View)imageView);
                linearLayout = new LinearLayout((Context)this.activity);
                layoutParams2 = new RelativeLayout$LayoutParams(-1, -1);
                layoutParams2.setMargins(this.activity.GetResource(2131099935), 0, 0, 0);
                layoutParams2.addRule(15);
                linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                linearLayout.setGravity(16);
                linearLayout.setOrientation(1);
                textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886367));
                layoutParams3 = new LinearLayout$LayoutParams(-2, -2);
                layoutParams3.setMargins(0, 0, 0, this.activity.GetResource(2131099869));
                textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
                if (split2[1].equals((Object)split2[2])) {
                    s = this.activity.FormatExp(Long.parseLong(split2[1]));
                }
                else {
                    s = this.activity.FormatExp(Long.parseLong(split2[1])) + " - " + this.activity.FormatExp(Long.parseLong(split2[2]));
                }
                textView.setText((CharSequence)(s + "x " + split2[0]));
                textView.setTextColor(this.activity.white);
                activity = this.activity;
                activity.SetTextSize(textView, activity.GetResource(2131099669));
                linearLayout.addView((View)textView);
                textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                textView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
                textView2.setText((CharSequence)split2[3]);
                textView2.setTextColor(this.activity.faded);
                activity2 = this.activity;
                activity2.SetTextSize(textView2, activity2.GetResource(2131100247));
                linearLayout.addView((View)textView2);
                relativeLayout.addView((View)linearLayout);
                this.activity.itemSelect_wrap.addView((View)relativeLayout);
                activity3 = this.activity;
                activity3.AddBorder((ViewGroup)activity3.itemSelect_wrap);
            }
        }
    }
    
    public void OpenDungeons() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.dungeonsScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        final MainActivity activity4 = this.activity;
        activity4.EnableLayout((ViewGroup)activity4.dungeonsScreen);
        this.GenerateDungeons();
    }
    
    public void OpenSlayer() {
        if (this.slayerScreen == null) {
            this.slayerScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297151)).inflate();
            this.slayerScreen = (ScrollView)this.activity.findViewById(2131297147);
            this.slay_activeTask = (TextView)this.activity.findViewById(2131297138);
            this.slay_activeMaster = (TextView)this.activity.findViewById(2131297137);
            this.slay_newTask = (TextView)this.activity.findViewById(2131297142);
            this.slay_cancelKc = (TextView)this.activity.findViewById(2131297140);
            this.slay_cancelGold = (TextView)this.activity.findViewById(2131297139);
            this.slayerShop = (LinearLayout)this.activity.findViewById(2131297148);
            this.slay_darkthread = (TextView)this.activity.findViewById(2131297141);
            this.slay_soulgems = (TextView)this.activity.findViewById(2131297143);
            this.slay_soulthread = (TextView)this.activity.findViewById(2131297144);
            this.slayerShopGems = (LinearLayout)this.activity.findViewById(2131297149);
            this.mySlayerCaskets = (LinearLayout)this.activity.findViewById(2131296899);
            this.slayerCasketReward = (LinearLayout)this.activity.findViewById(2131297146);
        }
        this.activity.ExpBar("Slayer", (RelativeLayout)this.slayerScreen.findViewById(2131297150));
        this.activity.EnableLayout((ViewGroup)this.slayerScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.slayerScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.UpdateSlayer();
        this.slayerScreen.findViewById(2131297316).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda21(this));
        this.slayerScreen.findViewById(2131297319).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda1(this));
        this.ClearCasketLoot();
        ((TextView)this.mySlayerCaskets.getChildAt(2)).setText((CharSequence)this.activity.FormatExp(this.slayerInfo.getSlayerCaskets()));
        this.slayerScreen.findViewById(2131297145).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda2(this));
        this.slayerScreen.findViewById(2131296938).setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda3(this));
    }
    
    public int PickTaskAmount(int n, int getRandom) {
        getRandom = this.activity.GetRandom(n, getRandom);
        this.activity.LogIt("Base amount is: " + getRandom);
        n = getRandom;
        if (this.activity.baseTower.baseTowerLevel >= 69) {
            n = (int)(getRandom / 10.0f * 8.0f);
        }
        return Math.max(n, 5);
    }
    
    public float RandomFloat(final float n, final float n2) {
        return this.activity.randomGenerator.nextFloat() * (n2 - n) + n;
    }
    
    public void ResetCombat(final String s) {
        final MainActivity activity = this.activity;
        activity.ShowView((View)activity.searchingEnemy);
        if (this.activity.myAttackTimer != null) {
            this.activity.myAttackTimer.cancel();
        }
        if (this.activity.enemyAttackTimer != null) {
            this.activity.enemyAttackTimer.cancel();
        }
        final int index = this.enemyNames.indexOf((Object)s);
        this.UpdateMonsterKills();
        this.activity.enemyCurrentHealth = (int)this.enemyHealth.get(index);
        this.activity.enemyMaxHealth = (int)this.enemyHealth.get(index);
        final int getCombatLevel = this.activity.GetCombatLevel((int)this.enemyAttack.get(index), (int)this.enemyStrength.get(index), (int)this.enemyDefence.get(index), (int)this.enemyHealth.get(index));
        final long enemySpeed = this.getEnemySpeed(index);
        final TextView enemyHealthTv = this.activity.enemyHealthTv;
        final MainActivity activity2 = this.activity;
        enemyHealthTv.setText((CharSequence)activity2.getString(2131820622, new Object[] { activity2.enemyCurrentHealth, this.activity.enemyMaxHealth }));
        this.activity.enemyHealthBar.setProgress(this.activity.enemyMaxHealth);
        this.activity.enemyHealthBar.setMax(this.activity.enemyMaxHealth);
        this.activity.attackSpeedBar.setProgress(0);
        this.activity.attackSpeedBar.setMax((int)this.mySpeed);
        this.activity.enemyAttackSpeedBar.setProgress(0);
        this.activity.enemyAttackSpeedBar.setMax((int)enemySpeed);
        final TextView myHealth = this.activity.myHealth;
        final MainActivity activity3 = this.activity;
        myHealth.setText((CharSequence)activity3.getString(2131820639, new Object[] { activity3.currentHealth, this.activity.maxHealth }));
        this.activity.myHealthBar.setProgress(this.activity.currentHealth);
        this.activity.myHealthBar.setMax(this.activity.maxHealth);
        this.activity.myAttackTimer = new CountDownTimer(this, this.mySpeed, 10L, index, s, getCombatLevel) {
            final CombatManager this$0;
            final int val$enemyCombatLevel;
            final int val$index;
            final String val$monster;
            
            public void onFinish() {
                int calculateDamage;
                if (this.this$0.activity.currentAttackStyle.equals((Object)"Archery")) {
                    final int archeryDamage = this.this$0.activity.ArcheryDamage(this.this$0.activity.GetSkillLevel("Archery"), this.this$0.BowDamage(), this.this$0.ArrowDamage(), this.this$0.BowAccuracy(), (int)this.this$0.enemyDefence.get(this.val$index));
                    final long n = this.this$0.BowCritChance() + this.this$0.ArmourCritChance() + this.this$0.PotionCritChance();
                    calculateDamage = archeryDamage;
                    if (n > 0L && (calculateDamage = archeryDamage) > 0) {
                        calculateDamage = archeryDamage;
                        if (this.this$0.activity.GetRandom(1, 100) <= n) {
                            calculateDamage = archeryDamage + archeryDamage / 4;
                        }
                    }
                }
                else {
                    calculateDamage = this.this$0.activity.CalculateDamage(this.this$0.activity.GetSkillLevel("Attack") + this.this$0.activity.attackBonus, this.this$0.activity.GetSkillLevel("Strength") + this.this$0.activity.strengthBonus, (int)this.this$0.enemyDefence.get(this.val$index), "Enemy");
                }
                final int baseInstaKill = this.this$0.baseInstaKill;
                int n4;
                if (!this.this$0.shadowRealm) {
                    int n2;
                    if (!this.this$0.allGods.contains((Object)this.val$monster)) {
                        n2 = baseInstaKill;
                        if (!this.this$0.inImmortalRealm) {
                            n2 = baseInstaKill;
                            if (this.this$0.activity.treasureHunts.BoostActive("Death to all")) {
                                n2 = baseInstaKill + 3;
                            }
                        }
                    }
                    else {
                        n2 = baseInstaKill;
                        if (this.this$0.activity.treasureHunts.BoostActive("Curse of Noctyra")) {
                            n2 = baseInstaKill + 5;
                        }
                    }
                    int n3 = n2;
                    if (this.this$0.rageMode) {
                        n3 = n2;
                        if (this.this$0.rageKillsRemaining > 0) {
                            final CombatManager this$0 = this.this$0;
                            --this$0.rageKillsRemaining;
                            if (this.this$0.rageKillsRemaining == 0) {
                                this.this$0.rageMode = false;
                                this.this$0.activity.QuickPopup("You feel the rage of Feroxi leave you.");
                            }
                            n3 = 100;
                        }
                    }
                    n4 = n3;
                    if (this.this$0.activity.alchemy.activePotions.contains((Object)"Summer Cocktail")) {
                        n4 = n3;
                        if (!this.this$0.trollPet) {
                            n4 = 100;
                        }
                    }
                }
                else if (!this.this$0.equippedItems.contains((Object)"Staff of the Shadows") && !this.this$0.equippedItems.contains((Object)"Bow of the Shadows")) {
                    n4 = 0;
                }
                else {
                    n4 = 2;
                }
                boolean b;
                if (n4 > 0 && this.this$0.activity.GetRandom(1, 100) <= n4) {
                    final int enemyCurrentHealth = this.this$0.activity.enemyCurrentHealth;
                    this.this$0.activity.QuickPopup("You manage to instantly kill the enemy.");
                    if ((this.this$0.equippedItems.contains((Object)"Scythe of Noctyra") || this.this$0.equippedItems.contains((Object)"Scythe of Noctyra (E)") || this.this$0.equippedItems.contains((Object)"Scythe of Noctyra (E2)") || this.this$0.equippedItems.contains((Object)"Scythe of Noctyra (E3)")) && this.this$0.activity.GetRandom(1, 1500) <= 2) {
                        int n5;
                        if (this.this$0.equippedItems.contains((Object)"Scythe of Noctyra (E)")) {
                            n5 = 2;
                        }
                        else {
                            n5 = 1;
                        }
                        final SlayerInfo slayerInfo = this.this$0.slayerInfo;
                        slayerInfo.soulGems += n5;
                        this.this$0.activity.LargePopup(2131166237, "Soul Collector", "Upon killing the enemy your Scythe collects the enemies soul awarding " + n5 + "x Soul Gem.");
                    }
                    b = true;
                    calculateDamage = enemyCurrentHealth;
                }
                else {
                    b = false;
                }
                int n6 = calculateDamage;
                boolean b2 = false;
                int n7 = 0;
                Label_0851: {
                    if (this.this$0.shadowRealm) {
                        Label_0817: {
                            if (!this.this$0.weakness.equals((Object)"Immune Archery") || !this.this$0.activity.currentAttackStyle.equals((Object)"Archery")) {
                                n6 = calculateDamage;
                                if (!this.this$0.weakness.equals((Object)"Immune Melee")) {
                                    break Label_0817;
                                }
                                n6 = calculateDamage;
                                if (!this.this$0.meleeAttackStyles.contains((Object)this.this$0.activity.currentAttackStyle)) {
                                    break Label_0817;
                                }
                            }
                            n6 = 0;
                        }
                        if (this.this$0.activity.GetRandom(1, 100) <= this.this$0.shadowBlockChance) {
                            b2 = true;
                            n7 = 0;
                            break Label_0851;
                        }
                    }
                    b2 = false;
                    n7 = n6;
                }
                if (n7 <= 0) {
                    if (b2) {
                        this.this$0.activity.battleUpdates.setText((CharSequence)("The " + this.val$monster + " dodged your attack!"));
                    }
                    else {
                        this.this$0.activity.battleUpdates.setText((CharSequence)"You missed");
                    }
                }
                else {
                    if (this.this$0.canSpawnCog && this.this$0.activity.GetRandom(1, 100) <= 2) {
                        this.this$0.activity.GiveItem("Cog", 1L, false);
                        this.this$0.activity.QuickPopup("Your Sword summons the power of Cognium and spawns a Cog!");
                        if (!this.this$0.equippedItems.contains((Object)"Cognium Ring") && !this.this$0.equippedItems.contains((Object)"Ring of Secrets")) {
                            if (this.this$0.activity.GetRandom(1, 250000) <= 2) {
                                this.this$0.activity.GiveTitle("of Cognium");
                            }
                        }
                        else if (this.this$0.activity.GetRandom(1, 200000) <= 2) {
                            this.this$0.activity.GiveTitle("of Cognium");
                        }
                    }
                    if (!this.this$0.shadowRealm && this.this$0.fullFeroxiEnhanced && !this.this$0.rageMode && this.this$0.activity.GetRandom(1, 100) <= 2) {
                        this.this$0.EnterRageMode();
                    }
                    int n8 = n7;
                    if (this.this$0.inImmortalRealm) {
                        int n9 = 0;
                        Label_1186: {
                            if (!this.this$0.equippedItems.contains((Object)"Mystic Staff")) {
                                n9 = n7;
                                if (!this.this$0.equippedItems.contains((Object)"Mystic Staff (E)")) {
                                    break Label_1186;
                                }
                            }
                            n9 = n7 + n7 / 2;
                        }
                        n8 = n9;
                        if (this.this$0.equippedItems.contains((Object)"Dark Elven Sword")) {
                            n8 = n9 + n9 / 4;
                        }
                    }
                    int n10 = n8;
                    if (this.this$0.equippedItems.contains((Object)"Sword of Feroxi")) {
                        n10 = n8 + n8 / 10;
                    }
                    int n11 = n10;
                    if (this.this$0.mysticSet) {
                        n11 = n10 + n10 / 5;
                    }
                    int n12 = n11;
                    if (this.this$0.equippedItems.contains((Object)"Sword of Feroxi (E)")) {
                        n12 = n11 + n11 / 4;
                    }
                    int n13 = 0;
                    Label_1363: {
                        int n14;
                        if (this.this$0.weakness.equals((Object)"Melee")) {
                            n13 = n12;
                            if (!this.this$0.meleeAttackStyles.contains((Object)this.this$0.activity.currentAttackStyle)) {
                                break Label_1363;
                            }
                            n14 = n12 / 10;
                        }
                        else {
                            n13 = n12;
                            if (!this.this$0.activity.currentAttackStyle.equals((Object)"Archery")) {
                                break Label_1363;
                            }
                            n14 = n12 / 10;
                        }
                        n13 = n12 + n14;
                    }
                    final long n15 = Math.min(n13, this.this$0.damageCap);
                    int n16 = n13;
                    if (this.this$0.equippedItems.contains((Object)"Blessed Sacrifice")) {
                        n16 = n13 + this.this$0.activity.maxHealth / 2;
                    }
                    int n17 = 0;
                    Label_1463: {
                        if (!this.this$0.equippedItems.contains((Object)"Blessed Eternal Sacrifice")) {
                            n17 = n16;
                            if (!this.this$0.equippedItems.contains((Object)"Necklace of the Gods")) {
                                break Label_1463;
                            }
                        }
                        n17 = n16 + this.this$0.activity.maxHealth;
                    }
                    int n18 = n17;
                    if (this.this$0.equippedItems.contains((Object)"Staff of Skulls")) {
                        n18 = n17 + n17 / 5;
                    }
                    int n19 = n18;
                    if (this.this$0.activity.alchemy.activePotions.contains((Object)"Divine Protection Potion")) {
                        n19 = n18;
                        if (this.this$0.activity.GetRandom(1, 100) <= 25) {
                            n19 = n18 * 2;
                        }
                    }
                    int n20 = n19;
                    if (this.this$0.equippedItems.contains((Object)"Necklace of the Gods")) {
                        n20 = n19;
                        if (this.this$0.activity.GetRandom(1, 100) <= 25) {
                            n20 = n19 * 2;
                        }
                    }
                    int n21 = n20;
                    if (this.this$0.activity.treasureHunts.BoostActive("I got the Power")) {
                        n21 = n20 + n20 / 100 * 15;
                    }
                    int n22 = n21;
                    if (this.this$0.activity.treasureHunts.BoostActive("New Power")) {
                        n22 = n21 + n21 / 20;
                    }
                    int n23 = 0;
                    Label_1926: {
                        int n24;
                        if (!this.this$0.activity.currentAttackStyle.equals((Object)"Archery")) {
                            n23 = n22;
                            if (!this.this$0.equippedItems.contains((Object)"Leo")) {
                                break Label_1926;
                            }
                            n24 = n22 / 10;
                        }
                        else {
                            int n25 = n22;
                            if (this.this$0.equippedItems.contains((Object)"Timmy")) {
                                n25 = n22 + n22 / 10;
                            }
                            int n26 = n25;
                            if (this.this$0.eggArrows) {
                                n26 = n25;
                                if (this.this$0.activity.GetRandom(1, 100) <= 5) {
                                    n26 = n25 * 2;
                                    this.this$0.activity.QuickPopup("Your arrow egg-splodes dealing double damage!");
                                }
                            }
                            int n27 = n26;
                            if (this.this$0.eggstravagantBow) {
                                n27 = n26 * 2;
                            }
                            int n28 = n27;
                            if (this.this$0.balloonBow) {
                                n28 = n27;
                                if (this.this$0.activity.GetRandom(1, 100) <= 5) {
                                    n28 = n27 * 2;
                                    this.this$0.activity.QuickPopup("Your Balloon Bow doubles your damage!");
                                }
                            }
                            n22 = n28;
                            if (this.this$0.candleArrows) {
                                n22 = n28;
                                if (this.this$0.activity.GetRandom(1, 100) <= 2) {
                                    n22 = n28 * 2;
                                    this.this$0.activity.QuickPopup("Your arrow explodes and doubles your damage!");
                                }
                            }
                            n23 = n22;
                            if (!this.this$0.equippedItems.contains((Object)"Quiver of Kynosian")) {
                                break Label_1926;
                            }
                            n23 = n22;
                            if (!this.this$0.equippedItems.contains((Object)"Kynosian Arrows")) {
                                break Label_1926;
                            }
                            n24 = n22 / 5;
                        }
                        n23 = n22 + n24;
                    }
                    int n29 = 0;
                    Label_1975: {
                        if (!this.this$0.bowOfFriendship) {
                            n29 = n23;
                            if (!this.this$0.swordOfFriendship) {
                                break Label_1975;
                            }
                        }
                        n29 = n23;
                        if (this.this$0.friendsDamageBoost > 0) {
                            n29 = n23 + n23 / 100 * this.this$0.friendsDamageBoost;
                        }
                    }
                    if (this.this$0.shieldOfFriendship && this.this$0.shieldHealChance > 0 && this.this$0.activity.GetRandom(1, 100) <= this.this$0.shieldHealChance) {
                        final int n30 = n29 / 4;
                        if (n30 > 0) {
                            final MainActivity activity = this.this$0.activity;
                            activity.currentHealth += n30;
                            if (this.this$0.activity.currentHealth > this.this$0.activity.maxHealth) {
                                this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                            }
                            this.this$0.activity.myHealthBar.setProgress(this.this$0.activity.currentHealth);
                            this.this$0.activity.myHealth.setText((CharSequence)this.this$0.activity.getString(2131820639, new Object[] { this.this$0.activity.currentHealth, this.this$0.activity.maxHealth }));
                            this.this$0.activity.UpdateBottomNav();
                            this.this$0.activity.QuickPopup("You are healed " + this.this$0.activity.FormatExp((long)n30) + " by the power of Friendship!");
                        }
                    }
                    int n31 = n29;
                    if (this.this$0.equippedItems.contains((Object)"Teddy Bear")) {
                        n31 = n29;
                        if (this.this$0.activity.GetRandom(1, 100) <= 5) {
                            n31 = n29 * 2;
                        }
                    }
                    int n35 = 0;
                    Label_2692: {
                        int n34 = 0;
                        int n36;
                        if (!this.this$0.activity.currentAttackStyle.equals((Object)"Archery")) {
                            int n32 = 0;
                            Label_2354: {
                                if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Strength Potion")) {
                                    n32 = n31;
                                    if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Power Potion")) {
                                        break Label_2354;
                                    }
                                }
                                n32 = n31 + Math.max(n31 / 100, 2);
                            }
                            int n33 = 0;
                            Label_2415: {
                                if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Super Strength Potion")) {
                                    n33 = n32;
                                    if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Super Power Potion")) {
                                        break Label_2415;
                                    }
                                }
                                n33 = n32 + Math.max(n32 / 50, 2);
                            }
                            Label_2478: {
                                if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Extreme Strength Potion")) {
                                    n34 = n33;
                                    if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Extreme Power Potion")) {
                                        break Label_2478;
                                    }
                                }
                                n34 = n33 + Math.max(n33 / 100 * 3, 2);
                            }
                            if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Ultimate Strength Potion")) {
                                n35 = n34;
                                if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Ultimate Power Potion")) {
                                    break Label_2692;
                                }
                            }
                            n36 = Math.max(n34 / 20, 2);
                        }
                        else {
                            int n37 = n31;
                            if (this.this$0.activity.alchemy.activePotions.contains((Object)"Archery Potion")) {
                                n37 = n31 + Math.max(n31 / 100, 2);
                            }
                            int n38 = n37;
                            if (this.this$0.activity.alchemy.activePotions.contains((Object)"Super Archery Potion")) {
                                n38 = n37 + Math.max(n37 / 50, 2);
                            }
                            n34 = n38;
                            if (this.this$0.activity.alchemy.activePotions.contains((Object)"Extreme Archery Potion")) {
                                n34 = n38 + Math.max(n38 / 100 * 3, 2);
                            }
                            n35 = n34;
                            if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Ultimate Archery Potion")) {
                                break Label_2692;
                            }
                            n36 = Math.max(n34 / 20, 2);
                        }
                        n35 = n34 + n36;
                    }
                    int min = n35;
                    if (!b) {
                        min = Math.min(n35, this.this$0.damageCap);
                    }
                    if (this.this$0.equippedItems.contains((Object)"Spider Necklace")) {
                        if (this.this$0.activity.GetRandom(1, 100) <= 5) {
                            int n39;
                            if (this.this$0.shadowRealm) {
                                n39 = this.this$0.activity.enemyMaxHealth / 100;
                            }
                            else {
                                n39 = this.this$0.activity.enemyMaxHealth / 10;
                            }
                            min += n39;
                            this.this$0.activity.QuickPopup("Your Spider Necklace bites the enemy dealing " + this.this$0.activity.FormatExp((long)n39) + " extra damage!");
                        }
                    }
                    if (!this.this$0.godsRealm && !this.this$0.trainingGrounds) {
                        if (this.this$0.equippedItems.contains((Object)"Ring of Life") || this.this$0.equippedItems.contains((Object)"Eternal Ring") || this.this$0.equippedItems.contains((Object)"Eternal Berserker Ring") || this.this$0.equippedItems.contains((Object)"Ring of Secrets")) {
                            final long n40 = n15 / 5L;
                            final MainActivity activity2 = this.this$0.activity;
                            activity2.currentHealth += (int)n40;
                            if (this.this$0.activity.currentHealth > this.this$0.activity.maxHealth) {
                                this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                            }
                            this.this$0.activity.myHealthBar.setProgress(this.this$0.activity.currentHealth);
                            this.this$0.activity.myHealth.setText((CharSequence)this.this$0.activity.getString(2131820639, new Object[] { this.this$0.activity.currentHealth, this.this$0.activity.maxHealth }));
                            this.this$0.activity.UpdateBottomNav();
                        }
                        if (this.this$0.equippedItems.contains((Object)"Necklace of Restoration") || this.this$0.equippedItems.contains((Object)"Necklace of Restoration (E)") || this.this$0.equippedItems.contains((Object)"Necklace of the Gods")) {
                            long n41;
                            long n42;
                            if (!this.this$0.inImmortalRealm && !this.this$0.shadowRealm) {
                                if (!this.this$0.equippedItems.contains((Object)"Necklace of Restoration (E)") && !this.this$0.equippedItems.contains((Object)"Necklace of the Gods")) {
                                    n41 = n15 / 10L;
                                    n42 = 4L;
                                }
                                else {
                                    n41 = n15 / 10L;
                                    n42 = 5L;
                                }
                            }
                            else {
                                n41 = n15 / 10L;
                                n42 = 2L;
                            }
                            final MainActivity activity3 = this.this$0.activity;
                            activity3.currentHealth += (int)(n41 * n42);
                            if (this.this$0.activity.currentHealth > this.this$0.activity.maxHealth) {
                                this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                            }
                            this.this$0.activity.myHealthBar.setProgress(this.this$0.activity.currentHealth);
                            this.this$0.activity.myHealth.setText((CharSequence)this.this$0.activity.getString(2131820639, new Object[] { this.this$0.activity.currentHealth, this.this$0.activity.maxHealth }));
                            this.this$0.activity.UpdateBottomNav();
                        }
                    }
                    long n43 = n15;
                    if (n15 > this.this$0.activity.enemyCurrentHealth) {
                        n43 = this.this$0.activity.enemyCurrentHealth;
                    }
                    if (!this.this$0.trainingGrounds) {
                        final MainActivity activity4 = this.this$0.activity;
                        activity4.enemyCurrentHealth -= min;
                        this.this$0.activity.enemyHealthBar.setProgress(this.this$0.activity.enemyCurrentHealth);
                        this.this$0.activity.enemyHealthTv.setText((CharSequence)this.this$0.activity.getString(2131820622, new Object[] { this.this$0.activity.enemyCurrentHealth, this.this$0.activity.enemyMaxHealth }));
                        this.this$0.activity.battleUpdates.setText((CharSequence)this.this$0.activity.getString(2131820616, new Object[] { min }));
                        this.this$0.activity.GiveExp(this.this$0.activity.currentAttackStyle, this.this$0.activity.combatExp * n43, (ProgressBar)null);
                        this.this$0.activity.GiveExp("Health", n43 * this.this$0.activity.healthExp, (ProgressBar)null);
                        this.this$0.UpdateSkillProgress();
                    }
                    else {
                        this.this$0.activity.battleUpdates.setText((CharSequence)this.this$0.activity.getString(2131820616, new Object[] { min }));
                    }
                    this.this$0.activity.event.CheckFlowers();
                    if (this.this$0.activity.enemyCurrentHealth > 0 && this.this$0.eggSword && !this.this$0.shadowRealm && this.this$0.activity.GetRandom(1, 100) <= 2) {
                        this.this$0.activity.QuickPopup("You sword bunny hops in time instantly granting loot from the enemy!");
                        if (this.this$0.allGods.contains((Object)this.val$monster)) {
                            this.this$0.SelectGodDrop(this.val$monster);
                        }
                        else {
                            this.this$0.SelectDrop();
                        }
                    }
                }
                if (this.this$0.activity.enemyCurrentHealth <= 0) {
                    if (this.this$0.shadowRealm) {
                        if (!this.this$0.activity.myTitles.contains((Object)"of the Shadows") && this.this$0.activity.GetRandom(1, 250000) <= 1) {
                            this.this$0.activity.GiveTitle("of the Shadows");
                        }
                        this.this$0.SelectShadowDrop(this.val$monster);
                    }
                    else if (this.this$0.allGods.contains((Object)this.val$monster)) {
                        this.this$0.SelectGodDrop(this.val$monster);
                    }
                    else {
                        this.this$0.SelectDrop();
                    }
                    this.this$0.CheckBoosts(this.val$monster);
                    if ((this.this$0.slayerInfo.getSlayerTask().equals((Object)this.val$monster) || (this.this$0.slayerInfo.getSlayerTask().equals((Object)"Gods") && this.this$0.allGods.contains((Object)this.val$monster))) && this.this$0.slayerInfo.getSlayerAmount() >= 0) {
                        final SlayerInfo slayerInfo2 = this.this$0.slayerInfo;
                        --slayerInfo2.slayerAmount;
                        this.this$0.activity.combatSlayerProgress.setText((CharSequence)("Slayer Kills Left: " + this.this$0.slayerInfo.getSlayerAmount()));
                        this.this$0.activity.GiveExp("Slayer", (long)this.this$0.enemySlayerExp.get(this.this$0.enemyNames.indexOf((Object)this.val$monster)), (ProgressBar)null);
                        if (this.this$0.activity.alchemy.activePotions.contains((Object)"Soul Reaper Potion") && !this.this$0.equippedItems.contains((Object)"Adam the Troll") && this.this$0.activity.GetRandom(1, 300) <= 1) {
                            final SlayerInfo slayerInfo3 = this.this$0.slayerInfo;
                            ++slayerInfo3.soulGems;
                            this.this$0.activity.LargePopup(2131166237, "Congratulations", "Your Potion manages to capture the enemies soul granting a Soul Gem.");
                        }
                        if (this.this$0.slayerInfo.getSlayerAmount() <= 0) {
                            this.this$0.CompleteSlayerTask();
                        }
                    }
                    if (!this.this$0.trollPet) {
                        this.this$0.CheckTreasureScroll(this.val$enemyCombatLevel);
                    }
                    this.this$0.activity.secretPathway.CheckPathway("Combat", this.val$monster);
                    this.this$0.activity.treasureHunts.CheckTreasureHunts("Combat", this.val$monster);
                    this.this$0.ResetCombat(this.val$monster);
                    if (!this.this$0.trollPet) {
                        final CombatManager this$2 = this.this$0;
                        ++this$2.totalMonsterKills;
                        this.this$0.activity.accountStats.addKill(this.this$0.enemyNames.indexOf((Object)this.val$monster));
                    }
                    if (this.this$0.activity.avatarNames.contains((Object)this.val$monster)) {
                        if (!this.this$0.shadowRealm) {
                            if ((long)this.this$0.activity.accountStats.getAllMonsterKills().get(this.this$0.enemyNames.indexOf((Object)this.val$monster)) >= 100000L) {
                                this.this$0.activity.GiveAvatar(this.val$monster);
                            }
                        }
                        else if (this.this$0.activity.GetRandom(1, 50000) <= 1) {
                            this.this$0.activity.GiveAvatar(this.val$monster);
                        }
                    }
                    this.this$0.activity.dailies.UpdateDailies("Combat", this.val$monster, 1);
                    if (!this.this$0.trollPet) {
                        this.this$0.CheckSpecials(this.val$monster);
                    }
                    this.this$0.activity.itemManager.CheckOnlineSecrets("Combat", this.val$monster);
                    final String currentAttackStyle = this.this$0.activity.currentAttackStyle;
                    currentAttackStyle.hashCode();
                    int n44 = 0;
                    Label_4713: {
                        switch (currentAttackStyle.hashCode()) {
                            case 1971575400: {
                                if (!currentAttackStyle.equals((Object)"Attack")) {
                                    break;
                                }
                                n44 = 2;
                                break Label_4713;
                            }
                            case 1855960161: {
                                if (!currentAttackStyle.equals((Object)"Strength")) {
                                    break;
                                }
                                n44 = 1;
                                break Label_4713;
                            }
                            case -1085397968: {
                                if (!currentAttackStyle.equals((Object)"Defence")) {
                                    break;
                                }
                                n44 = 0;
                                break Label_4713;
                            }
                        }
                        n44 = -1;
                    }
                    switch (n44) {
                        case 2: {
                            this.this$0.CheckSecret("Necklace of Attack", 2131166034, 20000);
                            break;
                        }
                        case 1: {
                            this.this$0.CheckSecret("Necklace of Strength", 2131166038, 20000);
                            break;
                        }
                        case 0: {
                            this.this$0.CheckSecret("Necklace of Defence", 2131166035, 20000);
                            break;
                        }
                    }
                }
                else {
                    this.this$0.activity.attackSpeedBar.setProgress((int)this.this$0.mySpeed);
                    this.this$0.activity.myAttackTimer.start();
                }
                if (this.this$0.activity.currentAttackStyle.equals((Object)"Archery") && !this.this$0.trainingGrounds) {
                    try {
                        int n45;
                        if (this.this$0.eggstravagantBow) {
                            n45 = 2;
                        }
                        else {
                            n45 = 1;
                        }
                        int n46;
                        if (this.this$0.equippedItems.contains((Object)"Quiver of Kynosian")) {
                            n46 = 45;
                        }
                        else {
                            n46 = 5;
                        }
                        int n47 = n46;
                        if (this.this$0.dragonhideSet) {
                            n47 = n46 + 15;
                        }
                        if (this.this$0.activity.GetRandom(1, 100) <= 100 - n47) {
                            this.this$0.activity.RemoveItem(this.this$0.equippedArrows, n45);
                        }
                        if (this.this$0.activity.inventoryItems.contains((Object)this.this$0.equippedArrows)) {
                            this.this$0.activity.currentArrows.setText((CharSequence)("Arrows: " + this.this$0.activity.FormatCoins(this.this$0.ArrowsEquipped())));
                        }
                        else {
                            this.this$0.OutOfArrows();
                        }
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        this.this$0.OutOfArrows();
                    }
                }
            }
            
            public void onTick(final long n) {
                this.this$0.activity.attackSpeedBar.setProgress((int)(this.this$0.mySpeed - n));
            }
        };
        this.activity.enemyAttackTimer = new CountDownTimer(this, enemySpeed, 10L, enemySpeed, index, s) {
            final CombatManager this$0;
            final long val$enemySpeed;
            final int val$index;
            final String val$monster;
            
            public void onFinish() {
                int calculateDamage;
                int n = calculateDamage = this.this$0.activity.CalculateDamage((int)this.this$0.enemyAttack.get(this.val$index), (int)this.this$0.enemyStrength.get(this.val$index), this.this$0.activity.GetSkillLevel("Defence") + this.this$0.activity.defenceBonus, "Player");
                if (!this.this$0.inImmortalRealm) {
                    calculateDamage = n;
                    if (!this.this$0.godsRealm) {
                        calculateDamage = n;
                        if (!this.this$0.shadowRealm) {
                            if (this.this$0.activity.alchemy.activePotions.contains((Object)"Invincibility Potion")) {
                                n = 0;
                            }
                            calculateDamage = n;
                            if (this.this$0.activity.alchemy.activePotions.contains((Object)"Rock Skin Potion") && (calculateDamage = n) > 0) {
                                calculateDamage = n / 2;
                            }
                        }
                    }
                }
                int n2 = calculateDamage;
                if (this.this$0.activity.alchemy.activePotions.contains((Object)"Elven Grace Potion") && (n2 = calculateDamage) > 0) {
                    n2 = calculateDamage;
                    if (this.this$0.activity.GetRandom(1, 100) <= 25) {
                        n2 = calculateDamage / 4;
                    }
                }
                int n3 = n2;
                if (this.this$0.activity.alchemy.activePotions.contains((Object)"Divine Protection Potion") && (n3 = n2) > 0) {
                    n3 = n2;
                    if (this.this$0.activity.GetRandom(1, 100) <= 25) {
                        n3 = 0;
                    }
                }
                int n4 = n3;
                if (this.this$0.activity.currentAttackStyle.equals((Object)"Archery")) {
                    n4 = n3;
                    if (this.this$0.mistletoeArrows && (n4 = n3) > 0) {
                        int n5;
                        if (this.this$0.hollybranchBow) {
                            n5 = n3 / 5;
                        }
                        else {
                            n5 = n3 / 10;
                        }
                        n4 = n3 - n5;
                    }
                }
                int n6 = 0;
                Label_0448: {
                    if (!this.this$0.equippedItems.contains((Object)"Necklace of Amaran") && !this.this$0.equippedItems.contains((Object)"Necklace of Amaran (E)") && !this.this$0.equippedItems.contains((Object)"Necklace of Amaran (E2)")) {
                        n6 = n4;
                        if (!this.this$0.equippedItems.contains((Object)"Necklace of Amaran (E3)")) {
                            break Label_0448;
                        }
                    }
                    if ((n6 = n4) > 0) {
                        n6 = n4;
                        if (this.this$0.activity.GetRandom(1, 100) <= 5) {
                            n6 = n4 / 10;
                        }
                    }
                }
                int n7;
                if ((n7 = n6) > 0) {
                    int n8 = 0;
                    Label_0512: {
                        if (!this.this$0.equippedItems.contains((Object)"Mystic Staff")) {
                            n8 = n6;
                            if (!this.this$0.equippedItems.contains((Object)"Mystic Staff (E)")) {
                                break Label_0512;
                            }
                        }
                        n8 = n6;
                        if (this.this$0.activity.GetRandom(1, 100) <= 25) {
                            n8 = 0;
                        }
                    }
                    int n9 = n8;
                    if (this.this$0.equippedItems.contains((Object)"Elven Sword")) {
                        n9 = n8;
                        if (this.this$0.activity.GetRandom(1, 100) <= 30) {
                            final MainActivity activity = this.this$0.activity;
                            activity.currentHealth += n8 / 4;
                            this.this$0.activity.enemyDamageUpdates.setText((CharSequence)"The elven power heals you for some of the damamge you received.");
                            if (this.this$0.activity.currentHealth >= this.this$0.activity.maxHealth) {
                                this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                            }
                            n9 = 0;
                        }
                    }
                    int n10 = n9;
                    if (this.this$0.equippedItems.contains((Object)"Ring of Sun")) {
                        n10 = n9;
                        if (this.this$0.activity.GetRandom(1, 100) <= 5) {
                            n10 = 0;
                        }
                    }
                    int n11 = n10;
                    if (this.this$0.equippedItems.contains((Object)"Beach Parasol")) {
                        n11 = n10;
                        if (this.this$0.activity.GetRandom(1, 100) <= 15) {
                            this.this$0.activity.QuickPopup("You're Parasol blocks all incoming damage!");
                            n11 = 0;
                        }
                    }
                    int n12 = n11;
                    if (this.this$0.equippedItems.contains((Object)"Ace the Ghost")) {
                        n12 = n11;
                        if (this.this$0.activity.GetRandom(1, 100) <= 15) {
                            this.this$0.activity.QuickPopup("Ace blocks all incoming damage!");
                            n12 = 0;
                        }
                    }
                    int n13 = n12;
                    if (this.this$0.activity.baseTower.baseTowerLevel >= 48) {
                        n13 = n12;
                        if (!this.this$0.trainingGrounds) {
                            n13 = n12;
                            if (this.this$0.activity.GetRandom(1, 100) <= 10) {
                                this.this$0.activity.QuickPopup("You manage to reflect the damage back at the " + this.val$monster);
                                final MainActivity activity2 = this.this$0.activity;
                                activity2.enemyCurrentHealth -= n12;
                                this.this$0.activity.enemyHealthBar.setProgress(this.this$0.activity.enemyCurrentHealth);
                                this.this$0.activity.enemyHealthTv.setText((CharSequence)this.this$0.activity.getString(2131820622, new Object[] { this.this$0.activity.enemyCurrentHealth, this.this$0.activity.enemyMaxHealth }));
                                this.this$0.activity.battleUpdates.setText((CharSequence)("You reflected " + n12 + " damage"));
                                n13 = 0;
                            }
                        }
                    }
                    n7 = n13;
                    if (this.this$0.ghostlyMiss > 0) {
                        n7 = n13;
                        if (this.this$0.activity.GetRandom(1, 100) <= this.this$0.ghostlyMiss) {
                            this.this$0.activity.QuickPopup("Your Ghostly outfit reduces the enemies damage to 0");
                            n7 = 0;
                        }
                    }
                }
                int n14 = n7;
                if (this.this$0.godsRealm) {
                    n14 = n7;
                    if (this.this$0.activity.baseTower.baseTowerLevel >= 64 && (n14 = n7) > 0) {
                        n14 = n7 - n7 / 100 * 15;
                    }
                }
                int n15 = n14;
                if (this.this$0.trainingGrounds) {
                    n15 = 0;
                }
                int n16 = n15;
                if (this.this$0.equippedItems.contains((Object)"Taylor")) {
                    n16 = n15 - n15 / 10;
                }
                int n17 = n16;
                if (this.this$0.equippedItems.contains((Object)"Teddy Bear")) {
                    n17 = n16;
                    if (this.this$0.activity.GetRandom(1, 100) <= 15) {
                        n17 = 0;
                    }
                }
                int n18 = n17;
                if (this.this$0.krampusPieces > 0) {
                    n18 = n17;
                    if (this.this$0.activity.GetRandom(1, 100) <= this.this$0.krampusPieces * 3) {
                        this.this$0.activity.QuickPopup("Krampus protects you from the incoming damage!");
                        n18 = 0;
                    }
                }
                int n19 = 0;
                Label_1486: {
                    if ((n19 = n18) > 0) {
                        int n20 = 0;
                        Label_1301: {
                            if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Defence Potion")) {
                                n20 = n18;
                                if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Power Potion")) {
                                    break Label_1301;
                                }
                            }
                            n20 = n18 - Math.max(n18 / 100, 2);
                        }
                        int n21 = 0;
                        Label_1362: {
                            if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Super Defence Potion")) {
                                n21 = n20;
                                if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Super Power Potion")) {
                                    break Label_1362;
                                }
                            }
                            n21 = n20 - Math.max(n20 / 50, 2);
                        }
                        int n22 = 0;
                        Label_1425: {
                            if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Extreme Defence Potion")) {
                                n22 = n21;
                                if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Extreme Power Potion")) {
                                    break Label_1425;
                                }
                            }
                            n22 = n21 - Math.max(n21 / 100 * 3, 2);
                        }
                        if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Ultimate Defence Potion")) {
                            n19 = n22;
                            if (!this.this$0.activity.alchemy.activePotions.contains((Object)"Ultimate Power Potion")) {
                                break Label_1486;
                            }
                        }
                        n19 = n22 - Math.max(n22 / 20, 2);
                    }
                }
                if (n19 <= 0) {
                    this.this$0.activity.enemyDamageUpdates.setText((CharSequence)this.this$0.activity.getString(2131820623, new Object[] { this.val$monster }));
                }
                else {
                    int currentHealth = n19;
                    if (this.this$0.shadowRealm) {
                        currentHealth = n19;
                        if (this.this$0.shadowKillChance > 0.0f) {
                            currentHealth = n19;
                            if (this.this$0.RandomFloat(0.0f, 750.0f) <= this.this$0.shadowKillChance) {
                                String s;
                                int n23;
                                if (this.this$0.equippedItems.contains((Object)"Teddy Bear")) {
                                    s = "The cuteness of the Teddy Bear saves your life!";
                                    n23 = 10;
                                }
                                else {
                                    s = "You manage to avoid an insta kill!";
                                    n23 = 0;
                                }
                                int n24 = n23;
                                if (this.this$0.krampusPieces > 0) {
                                    n24 = n23 + this.this$0.krampusPieces * 2;
                                }
                                if (n24 > 0 && this.this$0.activity.GetRandom(1, 100) <= n24) {
                                    this.this$0.activity.LargePopup(2131165483, "Life Saved", s);
                                    currentHealth = n19;
                                }
                                else {
                                    currentHealth = this.this$0.activity.currentHealth;
                                    this.this$0.activity.LargePopup(2131166505, "Insta Kill", "The " + this.val$monster + " deals a fatal blow, killing you instantly!");
                                }
                            }
                        }
                    }
                    if (this.this$0.activity.baseTower.baseTowerLevel >= 20 && !this.this$0.shadowRealm) {
                        if (this.this$0.activity.GetRandom(1, 100) <= 10) {
                            final MainActivity activity3 = this.this$0.activity;
                            activity3.currentHealth += currentHealth;
                            this.this$0.activity.enemyDamageUpdates.setText((CharSequence)(this.val$monster + " dealt " + currentHealth + " damage which you healed"));
                            if (this.this$0.activity.currentHealth >= this.this$0.activity.maxHealth) {
                                this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                            }
                        }
                        else {
                            this.this$0.activity.enemyDamageUpdates.setText((CharSequence)this.this$0.activity.getString(2131820621, new Object[] { this.val$monster, currentHealth }));
                            final MainActivity activity4 = this.this$0.activity;
                            activity4.currentHealth -= currentHealth;
                        }
                    }
                    else {
                        this.this$0.activity.enemyDamageUpdates.setText((CharSequence)this.this$0.activity.getString(2131820621, new Object[] { this.val$monster, currentHealth }));
                        final MainActivity activity5 = this.this$0.activity;
                        activity5.currentHealth -= currentHealth;
                    }
                    this.this$0.activity.myHealthBar.setProgress(this.this$0.activity.currentHealth);
                    this.this$0.activity.myHealth.setText((CharSequence)this.this$0.activity.getString(2131820639, new Object[] { this.this$0.activity.currentHealth, this.this$0.activity.maxHealth }));
                    this.this$0.activity.UpdateBottomNav();
                    if (this.this$0.shadowRealm && this.this$0.shadowHealChance > 0 && this.this$0.activity.GetRandom(1, 100) <= this.this$0.shadowHealChance) {
                        if (this.this$0.equippedItems.contains((Object)"Necklace of the Gods") && this.this$0.activity.GetRandom(1, 100) <= 5) {
                            this.this$0.activity.QuickPopup("Your necklace prevents the enemy from healing!");
                        }
                        else {
                            final int getRandom = this.this$0.activity.GetRandom(this.this$0.activity.enemyMaxHealth / 15, this.this$0.activity.enemyMaxHealth / 9);
                            final MainActivity activity6 = this.this$0.activity;
                            activity6.enemyCurrentHealth += getRandom;
                            if (this.this$0.activity.enemyCurrentHealth >= this.this$0.activity.enemyMaxHealth) {
                                this.this$0.activity.enemyCurrentHealth = this.this$0.activity.enemyMaxHealth;
                            }
                            this.this$0.activity.enemyHealthBar.setProgress(this.this$0.activity.enemyCurrentHealth);
                            this.this$0.activity.enemyHealthTv.setText((CharSequence)this.this$0.activity.getString(2131820622, new Object[] { this.this$0.activity.enemyCurrentHealth, this.this$0.activity.enemyMaxHealth }));
                            this.this$0.activity.enemyDamageUpdates.setText((CharSequence)(this.val$monster + " healed " + this.this$0.activity.FormatExp((long)getRandom) + "!"));
                        }
                    }
                }
                if (this.this$0.activity.currentHealth <= 0) {
                    if (this.this$0.equippedItems.contains((Object)"Necklace of the Gods") && this.this$0.activity.GetRandom(1, 100) <= 20) {
                        this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                        this.this$0.activity.QuickPopup("At the moment of death, the Gods revive you back to full health.");
                        if (this.this$0.activity.currentHealth > this.this$0.activity.maxHealth) {
                            this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                        }
                        this.this$0.activity.myHealth.setText((CharSequence)this.this$0.activity.getString(2131820639, new Object[] { this.this$0.activity.currentHealth, this.this$0.activity.maxHealth }));
                        this.this$0.activity.myHealthBar.setProgress(this.this$0.activity.currentHealth);
                        this.this$0.activity.myHealthBar.setMax(this.this$0.activity.maxHealth);
                        this.this$0.activity.UpdateBottomNav();
                        this.this$0.activity.enemyAttackSpeedBar.setProgress(0);
                        this.this$0.activity.enemyAttackTimer.start();
                    }
                    else if (!this.this$0.equippedItems.contains((Object)"Skull Shield") && !this.this$0.equippedItems.contains((Object)"Shadow Lantern")) {
                        this.this$0.KillPlayer();
                    }
                    else if (System.currentTimeMillis() - this.this$0.skullShieldActivation > 120000L) {
                        this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                        this.this$0.skullShieldActivation = System.currentTimeMillis();
                        this.this$0.activity.QuickPopup("At the moment of death, your shield revives you back to full health.");
                        if (this.this$0.activity.currentHealth > this.this$0.activity.maxHealth) {
                            this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                        }
                        this.this$0.activity.myHealth.setText((CharSequence)this.this$0.activity.getString(2131820639, new Object[] { this.this$0.activity.currentHealth, this.this$0.activity.maxHealth }));
                        this.this$0.activity.myHealthBar.setProgress(this.this$0.activity.currentHealth);
                        this.this$0.activity.myHealthBar.setMax(this.this$0.activity.maxHealth);
                        this.this$0.activity.UpdateBottomNav();
                        this.this$0.activity.enemyAttackSpeedBar.setProgress(0);
                        this.this$0.activity.enemyAttackTimer.start();
                    }
                    else {
                        this.this$0.KillPlayer();
                    }
                }
                else {
                    if (this.this$0.activity.autoEat && !this.this$0.activity.equippedFood.isEmpty() && this.this$0.activity.inventoryItems.contains((Object)this.this$0.activity.equippedFood) && this.this$0.activity.currentHealth <= this.this$0.activity.maxHealth / 2) {
                        int n25 = (int)this.this$0.activity.foodItemHealing.get(this.this$0.activity.foodItems.indexOf((Object)this.this$0.activity.equippedFood));
                        if (this.this$0.activity.equippedFood.equals((Object)"Dragon Platter")) {
                            n25 = this.this$0.activity.maxHealth / 3;
                        }
                        if (this.this$0.activity.equippedFood.equals((Object)"Pumpkin Pie")) {
                            n25 = this.this$0.activity.maxHealth;
                        }
                        int n26 = n25;
                        if (this.this$0.activity.members) {
                            n26 = n25 + n25 / 5;
                        }
                        final MainActivity activity7 = this.this$0.activity;
                        activity7.currentHealth += n26;
                        this.this$0.activity.RemoveItem(this.this$0.activity.equippedFood, 1);
                        long longValue;
                        if (this.this$0.activity.inventoryItems.contains((Object)this.this$0.activity.equippedFood)) {
                            longValue = (long)this.this$0.activity.inventoryAmounts.get(this.this$0.activity.inventoryItems.indexOf((Object)this.this$0.activity.equippedFood));
                        }
                        else {
                            longValue = 0L;
                        }
                        if (this.this$0.activity.currentHealth > this.this$0.activity.maxHealth) {
                            this.this$0.activity.currentHealth = this.this$0.activity.maxHealth;
                        }
                        this.this$0.activity.eatFood.setText((CharSequence)this.this$0.activity.getString(2131820619, new Object[] { this.this$0.activity.equippedFood, longValue }));
                        this.this$0.activity.myHealth.setText((CharSequence)this.this$0.activity.getString(2131820639, new Object[] { this.this$0.activity.currentHealth, this.this$0.activity.maxHealth }));
                        this.this$0.activity.myHealthBar.setProgress(this.this$0.activity.currentHealth);
                        this.this$0.activity.myHealthBar.setMax(this.this$0.activity.maxHealth);
                        this.this$0.activity.UpdateBottomNav();
                    }
                    this.this$0.activity.enemyAttackSpeedBar.setProgress(0);
                    this.this$0.activity.enemyAttackTimer.start();
                }
            }
            
            public void onTick(final long n) {
                this.this$0.activity.enemyAttackSpeedBar.setProgress((int)(this.val$enemySpeed - n));
            }
        };
        this.activity.mainHandler.postDelayed((Runnable)new CombatManager$$ExternalSyntheticLambda12(this), this.respawnTime);
    }
    
    public void SelectDrop() {
        final float randomFloat = this.activity.RandomFloat();
        final float secretChance = this.activity.secretChance;
        final float secretChanceBoost = this.activity.secretChanceBoost;
        String s = "Mythical";
        Label_0570: {
            Label_0565: {
                Label_0557: {
                    Label_0516: {
                        Label_0449: {
                            Label_0364: {
                                if (randomFloat > secretChance + secretChanceBoost) {
                                    if (randomFloat <= this.activity.mythicalChance + this.activity.mythicalChanceBoost) {
                                        if (this.activity.dropRarity.contains((Object)"Mythical")) {
                                            break Label_0570;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Legendary")) {
                                            break Label_0364;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Super Rare")) {
                                            break Label_0449;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Rare")) {
                                            break Label_0516;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Uncommon")) {
                                            break Label_0557;
                                        }
                                    }
                                    else if (randomFloat <= this.activity.legendaryChance + this.activity.legendaryChanceBoost) {
                                        if (this.activity.dropRarity.contains((Object)"Legendary")) {
                                            break Label_0364;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Super Rare")) {
                                            break Label_0449;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Rare")) {
                                            break Label_0516;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Uncommon")) {
                                            break Label_0557;
                                        }
                                    }
                                    else if (randomFloat <= this.activity.superRareChance + this.activity.superRareChanceBoost) {
                                        if (this.activity.dropRarity.contains((Object)"Super Rare")) {
                                            break Label_0449;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Rare")) {
                                            break Label_0516;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Uncommon")) {
                                            break Label_0557;
                                        }
                                    }
                                    else if (randomFloat <= this.activity.rareChance + this.activity.rareChanceBoost) {
                                        if (this.activity.dropRarity.contains((Object)"Rare")) {
                                            break Label_0516;
                                        }
                                        if (this.activity.dropRarity.contains((Object)"Uncommon")) {
                                            break Label_0557;
                                        }
                                    }
                                    else if (randomFloat <= this.activity.uncommonChance) {
                                        if (this.activity.dropRarity.contains((Object)"Uncommon")) {
                                            break Label_0557;
                                        }
                                    }
                                    break Label_0565;
                                }
                                if (this.activity.dropRarity.contains((Object)"Secret Rare")) {
                                    s = "Secret Rare";
                                    break Label_0570;
                                }
                                if (this.activity.dropRarity.contains((Object)"Mythical")) {
                                    break Label_0570;
                                }
                                if (!this.activity.dropRarity.contains((Object)"Legendary")) {
                                    if (this.activity.dropRarity.contains((Object)"Super Rare")) {
                                        break Label_0449;
                                    }
                                    if (this.activity.dropRarity.contains((Object)"Rare")) {
                                        break Label_0516;
                                    }
                                    if (!this.activity.dropRarity.contains((Object)"Uncommon")) {
                                        break Label_0565;
                                    }
                                    break Label_0557;
                                }
                            }
                            s = "Legendary";
                            break Label_0570;
                        }
                        s = "Super Rare";
                        break Label_0570;
                    }
                    s = "Rare";
                    break Label_0570;
                }
                s = "Uncommon";
                break Label_0570;
            }
            s = "Common";
        }
        for (int i = 0; i < this.activity.drops.size(); ++i) {
            if (((String)this.activity.dropRarity.get(i)).equals((Object)"Always")) {
                int n;
                if (((Integer)this.activity.dropMin.get(i)).equals(this.activity.dropMax.get(i))) {
                    n = (int)this.activity.dropMax.get(i);
                }
                else {
                    final MainActivity activity = this.activity;
                    n = activity.GetRandom((int)activity.dropMin.get(i), (int)this.activity.dropMax.get(i));
                }
                long n3;
                final long n2 = n3 = n;
                if (this.activity.premiumUpgradesPurchased.get(this.activity.premiumUpgrades.indexOf((Object)"Double Drops"))) {
                    n3 = n2;
                    if (this.activity.GetRandom(1, 100) <= 25) {
                        n3 = n2 * 2L;
                    }
                }
                long n4 = n3;
                if (this.activity.databaseManager.eventType.equals((Object)"Double Drops")) {
                    n4 = n3 * 2L;
                }
                long n5 = n4;
                Label_0904: {
                    if (this.farmourSet) {
                        final String s2 = (String)this.enemyArea.get(this.enemyNames.indexOf((Object)this.activeMonster));
                        if (!s2.equals((Object)"Farm")) {
                            n5 = n4;
                            if (!s2.equals((Object)"Elite Farm")) {
                                break Label_0904;
                            }
                        }
                        n5 = n4 * 2L;
                    }
                }
                long n6 = n5;
                if (this.activity.eventDoubleDrops) {
                    n6 = n5 * 2L;
                }
                long n7 = n6;
                if (this.activity.treasureHunts.BoostActive("Loot Hunter")) {
                    n7 = n6 * 3L;
                }
                long n8 = n7;
                if (this.activity.treasureHunts.BoostActive("More Drops")) {
                    n8 = n7;
                    if (this.activity.GetRandom(1, 100) <= 20) {
                        n8 = n7 * 2L;
                    }
                }
                long n9 = n8;
                if (this.doubleLootChance > 0L) {
                    n9 = n8;
                    if (this.DoubleLoot()) {
                        n9 = n8 * 2L;
                    }
                }
                this.UpdateLoot((String)this.activity.drops.get(i), n9);
            }
        }
        final ArrayList list = new ArrayList((Collection)this.activity.drops);
        Collections.shuffle((List)list);
        for (int j = 0; j < ((List)list).size(); ++j) {
            final int index = this.activity.drops.indexOf(((List)list).get(j));
            if (((String)this.activity.dropRarity.get(index)).equals((Object)s)) {
                int n10;
                if (((Integer)this.activity.dropMin.get(index)).equals(this.activity.dropMax.get(index))) {
                    n10 = (int)this.activity.dropMax.get(index);
                }
                else {
                    final MainActivity activity2 = this.activity;
                    n10 = activity2.GetRandom((int)activity2.dropMin.get(index), (int)this.activity.dropMax.get(index));
                }
                int n11 = n10;
                if (this.activity.premiumUpgradesPurchased.get(this.activity.premiumUpgrades.indexOf((Object)"Double Drops"))) {
                    n11 = n10;
                    if (this.activity.GetRandom(1, 100) <= 25) {
                        n11 = n10 * 2;
                    }
                }
                int n12 = n11;
                Label_1394: {
                    if (this.farmourSet) {
                        final String s3 = (String)this.enemyArea.get(this.enemyNames.indexOf((Object)this.activeMonster));
                        if (!s3.equals((Object)"Farm")) {
                            n12 = n11;
                            if (!s3.equals((Object)"Elite Farm")) {
                                break Label_1394;
                            }
                        }
                        n12 = n11 * 2;
                    }
                }
                int n13 = n12;
                if (this.activity.baseTower.myTreestones.contains((Object)"Treestone of Reality")) {
                    n13 = n12;
                    if (this.activity.GetRandom(1, 100) <= 25) {
                        n13 = n12 * 2;
                    }
                }
                int n14 = n13;
                if (this.activity.databaseManager.eventType.equals((Object)"Double Drops")) {
                    n14 = n13 * 2;
                }
                int n15 = n14;
                if (this.activity.eventDoubleDrops) {
                    n15 = n14 * 2;
                }
                int n16 = n15;
                if (this.activity.treasureHunts.BoostActive("Loot Hunter")) {
                    n16 = n15 * 3;
                }
                int n17 = n16;
                if (this.activity.treasureHunts.BoostActive("More Drops")) {
                    n17 = n16;
                    if (this.activity.GetRandom(1, 100) <= 20) {
                        n17 = n16 * 2;
                    }
                }
                int n18 = n17;
                if (this.totalMonsterKills >= 100000L) {
                    n18 = n17;
                    if (this.DoubleLoot()) {
                        n18 = n17 * 2;
                    }
                }
                this.UpdateLoot((String)((List)list).get(j), n18);
                break;
            }
        }
    }
    
    public void SetCombatStyle() {
        final String currentAttackStyle = this.activity.currentAttackStyle;
        currentAttackStyle.hashCode();
        final int hashCode = currentAttackStyle.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1971575400: {
                if (!currentAttackStyle.equals((Object)"Attack")) {
                    break;
                }
                n = 3;
                break;
            }
            case 1855960161: {
                if (!currentAttackStyle.equals((Object)"Strength")) {
                    break;
                }
                n = 2;
                break;
            }
            case 916547894: {
                if (!currentAttackStyle.equals((Object)"Archery")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1085397968: {
                if (!currentAttackStyle.equals((Object)"Defence")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            case 3: {
                this.activity.styleAttack.setAlpha(1.0f);
                this.activity.styleStrength.setAlpha(0.2f);
                this.activity.styleDefence.setAlpha(0.2f);
                this.activity.styleArchery.setAlpha(0.2f);
                break;
            }
            case 2: {
                this.activity.styleAttack.setAlpha(0.2f);
                this.activity.styleStrength.setAlpha(1.0f);
                this.activity.styleDefence.setAlpha(0.2f);
                this.activity.styleArchery.setAlpha(0.2f);
                break;
            }
            case 1: {
                this.activity.styleAttack.setAlpha(0.2f);
                this.activity.styleStrength.setAlpha(0.2f);
                this.activity.styleDefence.setAlpha(0.2f);
                this.activity.styleArchery.setAlpha(1.0f);
                break;
            }
            case 0: {
                this.activity.styleAttack.setAlpha(0.2f);
                this.activity.styleStrength.setAlpha(0.2f);
                this.activity.styleDefence.setAlpha(1.0f);
                this.activity.styleArchery.setAlpha(0.2f);
                break;
            }
        }
        this.mySpeed = this.GetAttackSpeed();
        this.respawnTime = this.GetRespawnTime();
    }
    
    public int SoulReaperDamageBuff() {
        int i = 0;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Soul Reaper Sword", "Soul Reaper Top (E)", "Soul Reaper Gloves (E)", "Soul Reaper Boots (E)", "Soul Reaper Legs (E)", "Soul Reaper Helm (E)", "Soul Reaper Sword (E)" }));
        int n = 0;
        while (i < ((List)list).size()) {
            int n2 = n;
            if (this.equippedItems.contains(((List)list).get(i))) {
                if (((String)((List)list).get(i)).contains((CharSequence)"(E)")) {
                    n2 = n + 20;
                }
                else {
                    n2 = n + 10;
                }
            }
            ++i;
            n = n2;
        }
        return n;
    }
    
    public boolean SoulReaperEquipped() {
        final boolean b = false;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Soul Reaper Sword", "Soul Reaper Top (E)", "Soul Reaper Gloves (E)", "Soul Reaper Boots (E)", "Soul Reaper Legs (E)", "Soul Reaper Helm (E)", "Soul Reaper Sword (E)" }));
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= ((List)list).size()) {
                break;
            }
            if (this.equippedItems.contains(((List)list).get(n))) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    public void UpdateLoot(final String s, final long n) {
        if (s.equals((Object)"Ancient Dagger")) {
            this.activity.GiveTitle("the Ancient");
        }
        final boolean contains = this.activity.currentLoot.contains((Object)s);
        int n2 = 1;
        if (contains) {
            this.activity.currentLootAmounts.set(this.activity.currentLoot.indexOf((Object)s), (Object)((long)this.activity.currentLootAmounts.get(this.activity.currentLoot.indexOf((Object)s)) + n));
            final TextView textView = (TextView)((LinearLayout)this.activity.lootList.getChildAt(this.activity.currentLoot.indexOf((Object)s))).getChildAt(1);
            final MainActivity activity = this.activity;
            textView.setText((CharSequence)activity.getString(2131820618, new Object[] { s, activity.currentLootAmounts.get(this.activity.currentLoot.indexOf((Object)s)) }));
        }
        else {
            this.activity.currentLoot.add((Object)s);
            this.activity.currentLootAmounts.add((Object)n);
            final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
            linearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
            linearLayout.setBackground(this.activity.GetImage(2131165348));
            linearLayout.setPadding(this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            final ImageView imageView = new ImageView((Context)this.activity);
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(this.activity.GetResource(2131099746), this.activity.GetResource(2131099746));
            layoutParams.setMargins(0, 0, this.activity.GetResource(2131099658), 0);
            imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            imageView.setAdjustViewBounds(true);
            s.hashCode();
            Label_0529: {
                switch (s.hashCode()) {
                    case 1721869536: {
                        if (!s.equals((Object)"Enhancement Ticket")) {
                            break;
                        }
                        n2 = 3;
                        break Label_0529;
                    }
                    case 1253687303: {
                        if (!s.equals((Object)"Slayer Casket")) {
                            break;
                        }
                        n2 = 2;
                        break Label_0529;
                    }
                    case -458446738: {
                        if (!s.equals((Object)"Challenge Coin")) {
                            break;
                        }
                        break Label_0529;
                    }
                    case -1274418954: {
                        if (!s.equals((Object)"Treasure Casket")) {
                            break;
                        }
                        n2 = 0;
                        break Label_0529;
                    }
                }
                n2 = -1;
            }
            int intValue = 0;
            switch (n2) {
                default: {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s));
                    break;
                }
                case 3: {
                    intValue = 2131165610;
                    break;
                }
                case 2: {
                    intValue = 2131166225;
                    break;
                }
                case 1: {
                    intValue = 2131165354;
                    break;
                }
                case 0: {
                    intValue = 2131165669;
                    break;
                }
            }
            imageView.setImageDrawable(this.activity.GetImage(intValue));
            linearLayout.addView((View)imageView);
            final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            textView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
            textView2.setTextColor(this.activity.GetColour(2131034924));
            final MainActivity activity2 = this.activity;
            activity2.SetTextSize(textView2, activity2.GetResource(2131100247));
            textView2.setText((CharSequence)this.activity.getString(2131820618, new Object[] { s, n }));
            linearLayout.addView((View)textView2);
            this.activity.lootList.addView((View)linearLayout);
            linearLayout.setOnClickListener((View$OnClickListener)new CombatManager$$ExternalSyntheticLambda10(this, s));
        }
    }
    
    public void UpdateSkillProgress() {
        final MainActivity activity = this.activity;
        activity.ExpBar(activity.currentAttackStyle, this.activity.combatSkillProgress);
    }
    
    public static class SlayerInfo
    {
        long darkThread;
        long killcoins;
        int slayerAmount;
        long slayerCaskets;
        String slayerMaster;
        String slayerTask;
        long soulGems;
        long soulThread;
        int startingAmount;
        
        public SlayerInfo(final long killcoins, final long soulGems, final String slayerTask, final String slayerMaster, final int slayerAmount, final long soulThread, final int startingAmount, final long darkThread, final long slayerCaskets) {
            this.killcoins = killcoins;
            this.soulGems = soulGems;
            this.slayerTask = slayerTask;
            this.slayerMaster = slayerMaster;
            this.slayerAmount = slayerAmount;
            this.soulThread = soulThread;
            this.startingAmount = startingAmount;
            this.darkThread = darkThread;
            this.slayerCaskets = slayerCaskets;
        }
        
        public long getDarkThread() {
            return this.darkThread;
        }
        
        public long getKillcoins() {
            return this.killcoins;
        }
        
        public int getSlayerAmount() {
            return this.slayerAmount;
        }
        
        public long getSlayerCaskets() {
            return this.slayerCaskets;
        }
        
        public String getSlayerMaster() {
            return this.slayerMaster;
        }
        
        public String getSlayerTask() {
            return this.slayerTask;
        }
        
        public long getSoulGems() {
            return this.soulGems;
        }
        
        public long getSoulThread() {
            return this.soulThread;
        }
        
        public int getStartingAmount() {
            return this.startingAmount;
        }
    }
}
