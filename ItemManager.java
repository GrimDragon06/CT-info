package uk.playdrop.cherrytree_idletextrpg;

import android.widget.ProgressBar;
import java.util.Objects;
import java.util.Collections;
import java.util.function.Function;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout$LayoutParams;
import java.util.Iterator;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.view.View$OnClickListener;
import android.view.inputmethod.InputMethodManager;
import java.util.Random;
import android.widget.SeekBar;
import android.widget.EditText;
import android.view.View;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Color;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.graphics.ColorFilter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ItemManager
{
    static final boolean $assertionsDisabled = false;
    MainActivity activity;
    List<String> allChests;
    List<List<String>> allChestsAmounts;
    List<String> allChestsKeys;
    List<List<String>> allChestsLoot;
    List<List<Float>> allChestsOdds;
    List<Enhancement> allEnhancements;
    List<SecretRare> allSecretRares;
    TextView bl_blessings;
    LinearLayout bl_chosenItem;
    TextView bl_enhance;
    TextView bl_select;
    TextView bl_tickets;
    TextView bl_tierselect;
    List<String> blessedItems;
    List<String> blessedItemsDescription;
    List<String> blessedItemsRequirement;
    List<Long> blessedItemsTickets;
    Blessings blessings;
    ScrollView blessingsScreen;
    EnhancementTier chosenItem;
    List<EnhancementTier> enhancementTiers;
    boolean generateInventory;
    int inventImageSize;
    int inventItemSize;
    List<RelativeLayout> inventoryViews;
    Item item;
    int maxChestOpens;
    TextView organise;
    int rowSize;
    List<String> secretRareSkills;
    Enhancement selectedEnhancement;
    int selectedItem;
    ColorFilter shadowFilter;
    List<String> shadowItems;
    List<String> skillScrolls_items;
    List<String> skillScrolls_recipes;
    List<String> skillScrolls_skills;
    List<Boolean> skillScrolls_unlocked;
    SkillingScrolls skillingScrolls;
    boolean sortMode;
    List<Long> tempInventoryAmounts;
    List<Boolean> tempInventoryItemLocked;
    List<String> tempInventoryItems;
    
    public ItemManager(final MainActivity activity) {
        this.inventoryViews = (List<RelativeLayout>)new ArrayList();
        this.rowSize = 5;
        this.generateInventory = true;
        final Boolean value = false;
        this.inventItemSize = 0;
        this.inventImageSize = 0;
        this.tempInventoryItems = (List<String>)new ArrayList();
        this.tempInventoryAmounts = (List<Long>)new ArrayList();
        this.tempInventoryItemLocked = (List<Boolean>)new ArrayList();
        this.allChests = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Common Chest", "Red Chest", "Spiked Chest", "Nefrit Chest", "Crystal Chest", "Queens Chest", "Kings Chest", "Farm Chest", "Eagles Nest", "Elven Chest", "Easter Egg", "Christmas Stocking" }));
        this.allChestsKeys = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Common Key", "Red Key", "Spiked Key", "Nefrit Key", "Crystal Key", "Queens Key", "Kings Key", "Farm Key", "", "Elven Key", "", "" }));
        this.allChestsLoot = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "Coins", "Mini Exp Scroll", "Iron Sword", "Leather Helm", "Leather Boots", "Leather Greaves", "Leather Top", "Leather Gloves", "Fishing Net", "Coins", "Empty Vial", "Iron Ore", "Hide", "Wood", "Thread" }), Arrays.asList((Object[])new String[] { "Coins", "Small Exp Scroll", "Steel Knives", "Steel Sword", "Iron Battleaxe", "Iron Gloves", "Iron Boots", "Iron Helm", "Iron Greaves", "Iron Top", "Akomeric", "Mushroom", "Sandstone", "Coins", "Fishing Net", "Iron Ore", "Thread", "Hide", "Wood" }), Arrays.asList((Object[])new String[] { "Coins", "Medium Exp Scroll", "Mithril Sword", "Mithril Axe", "Steel Gloves", "Steel Boots", "Steel Helm", "Steel Greaves", "Steel Top", "Coins", "Emerald", "Sage Leaf", "Blue Buttons", "Large Fishing Net", "Safflower", "Blue Thread", "Hyssop", "Bloodroot", "Sandstone" }), Arrays.asList((Object[])new String[] { "Trident of the Seas", "Gold Coin", "Goblin Cleaver", "Chicken Knife", "Coins", "Large Exp Scroll", "Mithril Gloves", "Mithril Boots", "Mithril Helm", "Mithril Top", "Mithril Greaves", "Coins", "Blueberry", "Orange", "Emerald", "Wolfmint", "Vissinel", "Sage Leaf", "Sandstone", "Egg" }), Arrays.asList((Object[])new String[] { "Ancient Dagger", "Massive Exp Scroll", "Dragon Wing Battleaxe", "Trident of the Seas", "Coins", "Chicken Knife", "Dragon Scimitar", "Large Exp Scroll", "Gold Coin", "Dragon Tail", "Dragon Skull", "Blueprints", "Dragon Rider Gloves", "Dragon Rider Boots", "Dragon Rider Helm", "Dragon Rider Greaves", "Dragon Rider Top", "Ember Fern", "Sunburst Flower", "Eggplant", "Wine", "Dragon Ore", "Dragon Leather", "Coins", "Egg", "Milk" }), Arrays.asList((Object[])new String[] { "Super Power Stone", "Gold Coin", "Queens Weapon Fragment", "Queens Armour Fragment", "Wine", "Power Stone", "Dragon Plate", "Dragon Leather", "Large Fishing Net", "Liquid Death Potion", "Invincibility Potion", "Dragon Ore", "Blue Silk", "Wood" }), Arrays.asList((Object[])new String[] { "Scythe of Demeter", "Extreme Power Stone", "Mystic Dagger", "Dragon Skull", "Super Power Stone", "Gold Coin", "Kings Weapon Fragment", "Kings Armour Fragment", "Wine", "Power Stone", "Dragon Plate", "Dragon Leather", "Dragon Ore", "Liquid Death Potion", "Invincibility Potion", "Dragon Tail", "Blue Silk", "Wood" }), Arrays.asList((Object[])new String[] { "Scythe of Demeter", "Coins", "Chicken Knife", "Gold Coin", "Rock Skin Potion", "Dragon Tail", "Coins", "Dragon Skull", "Treasure Map", "Pirates Hat", "Dagger Fragment", "Farmour Fragment", "Ember Fern", "Sunburst Flower", "Rope", "Wood", "Thread" }), Arrays.asList((Object[])new String[] { "Scythe of Demeter", "Hatchet of the Gods", "Rabbits Foot", "Ginkgo Seed", "Magnolia Seed", "Chestnut Seed", "Mahogany Seed", "Cherry Blossom Seed", "Cedar Seed", "Redwood Seed", "Elder Seed", "Eucalyptus Seed", "Willow Seed", "Ash Seed", "Fir Seed", "Spruce Seed", "Birch Seed", "Maple Seed", "Pine Seed", "Oak Seed", "Evergreen Seed" }), Arrays.asList((Object[])new String[] { "Soul Reaper Fragment", "Illuminant Gem", "Pickaxe of the Gods", "Hatchet of the Gods", "Kynosian Arrows", "Soul Gem", "Elven Arrows", "Casket of Treasure", "Kings Arrows", "Elven Crystal", "Queens Arrows", "Gold Coin", "Elven Grace Potion", "Golden Scarab", "Elven Armour Fragment", "Elven Weapon Fragment", "Dragon Platter", "Dragon Ore", "Dragon Skull", "Dragon Tail", "Dragon Leather", "Ember Fern", "Sunburst Flower", "Vissinel" }), Arrays.asList((Object[])new String[] { "Soul Reaper Fragment", "Golden Egg", "Ring Fragments", "Hatchet of the Gods", "Pumpkin Seed", "Kynosian Arrows", "Soul Gem", "Elven Arrows", "Kings Arrows", "Elven Crystal", "Queens Arrows", "Gold Coin", "Elven Grace Potion", "Golden Scarab", "Elven Armour Fragment", "Elven Weapon Fragment", "Dragon Platter", "Dragon Ore", "Dragon Skull", "Dragon Tail", "Dragon Leather", "Ember Fern", "Sunburst Flower", "Vissinel" }), Arrays.asList((Object[])new String[] { "Soul Reaper Fragment", "Special Currency", "Ring Fragments", "Hot Chocolate", "Pumpkin Seed", "Kynosian Arrows", "Soul Gem", "Elven Arrows", "Kings Arrows", "Elven Crystal", "Queens Arrows", "Gold Coin", "Elven Grace Potion", "Golden Scarab", "Elven Armour Fragment", "Elven Weapon Fragment", "Dragon Platter", "Dragon Ore", "Dragon Skull", "Dragon Tail", "Dragon Leather", "Ember Fern", "Sunburst Flower", "Vissinel" }) }));
        this.allChestsAmounts = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "10000,10000", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,2", "100,200", "5,10", "2,5", "5,10", "5,10", "5,10" }), Arrays.asList((Object[])new String[] { "25000,25000", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "2,5", "2,5", "15,20", "250,500", "1,2", "5,10", "15,20", "15,20", "15,20" }), Arrays.asList((Object[])new String[] { "50000,50000", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "500,1000", "2,5", "2,5", "5,10", "1,2", "5,10", "5,10", "6,12", "7,13", "25,30" }), Arrays.asList((Object[])new String[] { "1,1", "1,2", "1,1", "1,1", "250000,250000", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1000,2000", "5,10", "10,15", "5,10", "2,5", "3,6", "5,10", "45,60", "10,15" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,1", "1000000,1000000", "1,1", "1,1", "1,1", "1,2", "1,1", "1,1", "1,2", "1,1", "1,1", "1,1", "1,1", "1,1", "2,3", "3,5", "10,15", "9,12", "10,15", "10,15", "2500,5000", "25,40", "25,40" }), Arrays.asList((Object[])new String[] { "1,1", "1,2", "1,1", "1,2", "5,10", "1,1", "10,20", "25,50", "5,10", "2,4", "2,4", "25,50", "40,75", "50,100" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,3", "1,1", "1,2", "1,1", "1,2", "10,25", "1,1", "20,40", "40,75", "40,75", "3,6", "3,6", "1,3", "40,75", "50,75" }), Arrays.asList((Object[])new String[] { "1,1", "10000000,10000000", "1,1", "1,1", "1,3", "1,1", "5000,10000", "1,1", "1,1", "1,1", "1,1", "1,2", "1,3", "3,5", "10,25", "25,50", "25,50" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "3,3", "3,3", "3,3", "3,3", "3,3", "3,3", "5,5", "5,5", "5,5", "5,5", "5,5", "5,5", "10,10", "10,10", "10,10", "10,10", "10,10", "10,10" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "1,1", "1,1", "2,5", "1,1", "5,10", "1,3", "10,15", "5,10", "20,25", "25,50", "1,3", "10,15", "2,5", "2,5", "5,10", "5,10", "5,10", "5,10", "5,10", "2,5", "5,10", "10,15" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "5,10", "1,1", "10,15", "5,10", "1,1", "5,10", "10,15", "5,10", "20,25", "25,50", "1,3", "10,15", "2,5", "2,5", "5,10", "5,10", "5,10", "5,10", "5,10", "2,5", "5,10", "10,15" }), Arrays.asList((Object[])new String[] { "1,1", "1,1", "5,10", "1,2", "5,10", "5,10", "1,1", "5,10", "10,15", "5,10", "20,25", "25,50", "1,3", "10,15", "2,5", "2,5", "5,10", "5,10", "5,10", "5,10", "5,10", "2,5", "5,10", "10,15" }) }));
        this.allChestsOdds = (List<List<Float>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new Float[] { 2.0f, 12.0f, 32.0f, 62.0f, 92.0f, 122.0f, 152.0f, 182.0f, 232.0f, 307.0f, 432.0f, 582.0f, 782.0f, 1082.0f, 1482.0f }), Arrays.asList((Object[])new Float[] { 2.0f, 12.0f, 42.0f, 72.0f, 122.0f, 172.0f, 222.0f, 272.0f, 322.0f, 372.0f, 472.0f, 572.0f, 722.0f, 922.0f, 1172.0f, 1422.0f, 1722.0f, 2072.0f, 2572.0f }), Arrays.asList((Object[])new Float[] { 2.0f, 12.0f, 42.0f, 72.0f, 132.0f, 192.0f, 252.0f, 312.0f, 372.0f, 472.0f, 622.0f, 822.0f, 1072.0f, 1372.0f, 1722.0f, 2122.0f, 2622.0f, 3222.0f, 4122.0f }), Arrays.asList((Object[])new Float[] { 2.0f, 4.0f, 7.0f, 11.0f, 17.0f, 32.0f, 92.0f, 152.0f, 212.0f, 272.0f, 332.0f, 432.0f, 632.0f, 882.0f, 1182.0f, 1582.0f, 2032.0f, 2632.0f, 3382.0f, 4582.0f }), Arrays.asList((Object[])new Float[] { 2.0f, 4.0f, 9.0f, 16.0f, 24.0f, 33.0f, 43.0f, 55.0f, 71.0f, 111.0f, 151.0f, 211.0f, 271.0f, 331.0f, 391.0f, 451.0f, 511.0f, 711.0f, 1011.0f, 1411.0f, 1911.0f, 2661.0f, 3411.0f, 4411.0f, 6411.0f, 8911.0f }), Arrays.asList((Object[])new Float[] { 50.0f, 250.0f, 650.0f, 1150.0f, 2150.0f, 3150.0f, 4150.0f, 5150.0f, 6350.0f, 8850.0f, 11350.0f, 13850.0f, 17850.0f, 25850.0f }), Arrays.asList((Object[])new Float[] { 1.0f, 6.0f, 31.0f, 106.0f, 306.0f, 506.0f, 756.0f, 1056.0f, 1856.0f, 2656.0f, 3456.0f, 4256.0f, 5256.0f, 6256.0f, 7256.0f, 8756.0f, 11756.0f, 19756.0f }), Arrays.asList((Object[])new Float[] { 2.0f, 5.0f, 30.0f, 60.0f, 410.0f, 810.0f, 1310.0f, 1810.0f, 2310.0f, 2810.0f, 3410.0f, 4010.0f, 5210.0f, 6710.0f, 10210.0f, 14210.0f, 19210.0f }), Arrays.asList((Object[])new Float[] { 1.0f, 4.0f, 9.0f, 109.0f, 309.0f, 609.0f, 1009.0f, 1509.0f, 2109.0f, 2809.0f, 3809.0f, 5309.0f, 7309.0f, 9809.0f, 12809.0f, 22809.0f, 33809.0f, 45809.0f, 58809.0f, 72809.0f, 87809.0f }), Arrays.asList((Object[])new Float[] { 0.015f, 0.12f, 0.32f, 0.57f, 4.57f, 9.57f, 15.57f, 22.57f, 32.57f, 44.57f, 59.57f, 77.57f, 97.57f, 122.57f, 222.57f, 322.57f, 472.57f, 672.57f, 922.57f, 1172.57f, 1522.57f, 2022.57f, 2622.57f, 3422.57f }), Arrays.asList((Object[])new Float[] { 0.04f, 0.14f, 0.54f, 1.04f, 1.79f, 5.79f, 10.79f, 16.79f, 26.79f, 38.79f, 53.79f, 71.79f, 91.79f, 116.79f, 191.79f, 291.79f, 411.79f, 561.79f, 761.79f, 1011.79f, 1311.79f, 1711.79f, 2211.79f, 2861.79f }), Arrays.asList((Object[])new Float[] { 0.02f, 0.05f, 0.2f, 0.45f, 0.95f, 1.95f, 3.95f, 6.95f, 11.95f, 18.95f, 27.95f, 39.95f, 53.95f, 69.95f, 87.95f, 107.95f, 131.95f, 159.95f, 194.95f, 234.95f, 276.95f, 321.95f, 371.95f, 426.95f }) }));
        this.sortMode = false;
        this.selectedItem = -1;
        this.skillScrolls_recipes = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Pumpkin Pie Recipe Scroll", "Divine Protection Scroll", "Energy Overload Scroll", "Pumpkin Seed Scroll", "Summer Cocktail Recipe" }));
        this.skillScrolls_skills = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Cooking", "Alchemy", "Alchemy", "Farming", "Alchemy" }));
        this.skillScrolls_items = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Pumpkin Pie", "Divine Protection Potion", "Energy Overload", "Pumpkin Seed", "Summer Cocktail" }));
        this.skillScrolls_unlocked = (List<Boolean>)new ArrayList((Collection)Arrays.asList((Object[])new Boolean[] { value, value, value, value, value }));
        this.blessedItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Scythe of Aurial (E)", "Mystic Staff (E)", "Necklace of Restoration (E)", "Thieving Gloves (E)", "Ring of Souls (E)", "Bow of Kynosian (E)", "Sword of Feroxi (E)", "Mystic Dagger (E)", "Old Fishing Rod (E)", "Knife of Copina (E)", "Kynosian Boots (E)", "Kynosian Gloves (E)", "Kynosian Hat (E)", "Kynosian Legs (E)", "Kynosian Top (E)", "Scythe of Noctyra (E)", "Pickaxe of Copina (E)", "Hatchet of Copina (E)", "Rod of Copina (E)", "Rod of Copina (E2)", "Rod of Copina (E3)", "Rod of Copina (E4)", "Rod of Copina (E5)", "Rod of Copina (E6)", "Bow of Kynosian (E2)", "Bow of Kynosian (E3)", "Bow of Kynosian (E4)", "Bow of Kynosian (E5)", "Scythe of Aurial (E2)", "Scythe of Aurial (E3)", "Scythe of Aurial (E4)", "Scythe of Aurial (E5)", "Boots of Feroxi (E)", "Gloves of Feroxi (E)", "Plate of Feroxi (E)", "Helm of Feroxi (E)", "Greaves of Feroxi (E)", "Shield of Feroxi (E)", "Soul Reaper Top (E)", "Soul Reaper Gloves (E)", "Soul Reaper Boots (E)", "Soul Reaper Legs (E)", "Soul Reaper Helm (E)", "Death Princess Rune (E)", "Necklace of Amaran (E)", "Necklace of Amaran (E2)", "Necklace of Amaran (E3)", "Scythe of Noctyra (E2)", "Scythe of Noctyra (E3)" }));
        this.blessedItemsTickets = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 25L, 30L, 20L, 5L, 35L, 35L, 20L, 2L, 5L, 25L, 20L, 20L, 20L, 40L, 40L, 50L, 25L, 25L, 25L, 75L, 100L, 125L, 150L, 200L, 150L, 250L, 400L, 750L, 75L, 150L, 250L, 400L, 250L, 250L, 400L, 300L, 300L, 400L, 600L, 300L, 300L, 500L, 400L, 100L, 250L, 500L, 750L, 1000L, 1500L }));
        this.blessedItemsRequirement = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Scythe of Aurial", "Mystic Staff", "Necklace of Restoration", "Thieving Gloves", "Ring of Souls", "Bow of Kynosian", "Sword of Feroxi", "Mystic Dagger", "Old Fishing Rod", "Knife of Copina", "Kynosian Boots", "Kynosian Gloves", "Kynosian Hat", "Kynosian Legs", "Kynosian Top", "Scythe of Noctyra", "Pickaxe of Copina", "Hatchet of Copina", "Rod of Copina", "Rod of Copina (E)", "Rod of Copina (E2)", "Rod of Copina (E3)", "Rod of Copina (E4)", "Rod of Copina (E5)", "Bow of Kynosian (E)", "Bow of Kynosian (E2)", "Bow of Kynosian (E3)", "Bow of Kynosian (E4)", "Scythe of Aurial (E)", "Scythe of Aurial (E2)", "Scythe of Aurial (E3)", "Scythe of Aurial (E4)", "Boots of Feroxi", "Gloves of Feroxi", "Plate of Feroxi", "Helm of Feroxi", "Greaves of Feroxi", "Shield of Feroxi", "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Death Princess Rune", "Necklace of Amaran", "Necklace of Amaran (E)", "Necklace of Amaran (E2)", "Scythe of Noctyra (E)", "Scythe of Noctyra (E2)" }));
        this.blessedItemsDescription = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Increases the crop harvest multiplier to x4", "Increases the Insta Kill chance from 25% to 35%", "Increases healing from 40% to 50%", "Lowers Thieving time to 1s. Gives a 1% chance to find Gold Coins while Thieving", "Increased Soul Gems from x2 to x4", "Increases damage bonus to 5,000 and base Accuracy to 95%.", "Gives the Sword a 10% Insta Kill chance (Doesn't work in the Immortal Realm or the Kingdom of the Gods). Also increases the damage buff from 10% to 25%", "Increases the Strength bonus from 500 to 650", "Increases the chance of finding items from 15% to 20%", "Increases the Fletching item multiplier to x2", "Increases the Critical Bonus from 2% to 3%", "Increases the Critical Bonus from 3% to 4%", "Increases the Critical Bonus from 5% to 6%", "Increases the Critical Bonus from 10% to 15%", "Increases the Critical Bonus from 15% to 20%", "Increases the Insta Kill bonus in the Kingdom of the Gods from 2% to 5%. Also increases Soul Gems found while using the Scythe from 1 to 2", "Increases the Mining multiplier from x4 to x5", "Increases the Forestry multiplier from x4 to x5 for logs, nest chance and seed chance.", "Increases the Fishing multiplier from x4 to x5", "Increases the Fishing multiplier from x5 to x6", "Increases the Fishing multiplier from x6 to x7", "Increases the Fishing multiplier from x7 to x8", "Increases the Fishing multiplier from x8 to x9", "Increases the Fishing multiplier from x9 to x10", "Increases damage bonus to 5,500", "Increases damage bonus to 6,000 and increases attack speed by 20%", "Increases damage bonus to 6,500", "Increases damage bonus to 7,000 and sets the accuracy to 100%", "Increases the crop harvest multiplier to x5", "Increases the crop harvest multiplier to x6", "Increases the crop harvest multiplier to x7", "Increases the crop harvest multiplier to x10 and the crop reduction timer to 98%", "When the full enhanced set is equipped (Sword,Shield,Boots,Gloves,Helm,Top,Legs) there is a 2% chance per attack to enter Rage Mode, instantly killing the next 10 enemies", "When the full enhanced set is equipped (Sword,Shield,Boots,Gloves,Helm,Top,Legs) there is a 2% chance per attack to enter Rage Mode, instantly killing the next 10 enemies", "When the full enhanced set is equipped (Sword,Shield,Boots,Gloves,Helm,Top,Legs) there is a 2% chance per attack to enter Rage Mode, instantly killing the next 10 enemies", "When the full enhanced set is equipped (Sword,Shield,Boots,Gloves,Helm,Top,Legs) there is a 2% chance per attack to enter Rage Mode, instantly killing the next 10 enemies", "When the full enhanced set is equipped (Sword,Shield,Boots,Gloves,Helm,Top,Legs) there is a 2% chance per attack to enter Rage Mode, instantly killing the next 10 enemies", "When the full enhanced set is equipped (Sword,Shield,Boots,Gloves,Helm,Top,Legs) there is a 2% chance per attack to enter Rage Mode, instantly killing the next 10 enemies", "Increases the damage buff from 10% to 20% and the insta kill chance from 5% to 7%", "Increases the damage buff from 10% to 20% and the insta kill chance from 5% to 7%", "Increases the damage buff from 10% to 20% and the insta kill chance from 5% to 7%", "Increases the damage buff from 10% to 20% and the insta kill chance from 5% to 7%", "Increases the damage buff from 10% to 20% and the insta kill chance from 5% to 7%", "The negative effect reduces damage by 50% instead of 70% and increases the chance to deal double damage to 85%", "Increases the health bonus to 40,000", "Increases the health bonus to 45,000", "Increases the health bonus to 50,000 and the defence bonus to 7,000", "Increases the Health Bonus to 20,000 and Defence to 7,500", "Grants a 100% Accuracy chance, you will never miss!" }));
        this.shadowItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Kynosian Shadow Bow" }));
        this.chosenItem = null;
        this.allSecretRares = (List<SecretRare>)new ArrayList();
        this.secretRareSkills = (List<String>)new ArrayList();
        this.allEnhancements = (List<Enhancement>)new ArrayList();
        this.enhancementTiers = (List<EnhancementTier>)new ArrayList();
        this.selectedEnhancement = null;
        this.maxChestOpens = 5000;
        this.activity = activity;
        this.CreateEnhancements();
        this.shadowFilter = (ColorFilter)new PorterDuffColorFilter(Color.argb(120, 0, 0, 0), PorterDuff$Mode.SRC_ATOP);
    }
    
    private void AddItem(final String s, final int n) {
        if (this.activity.farming.farmingSeeds.contains((Object)s)) {
            if (this.activity.farming.seedBag.contains((Object)s)) {
                final int index = this.activity.farming.seedBag.indexOf((Object)s);
                this.activity.farming.seedBagAmounts.set(index, (Object)((long)this.activity.farming.seedBagAmounts.get(index) + n));
            }
            else {
                this.activity.farming.seedBag.add((Object)s);
                this.activity.farming.seedBagAmounts.add((Object)(long)n);
            }
        }
        else if (this.activity.inventoryItems.contains((Object)s)) {
            final int index2 = this.activity.inventoryItems.indexOf((Object)s);
            this.activity.inventoryAmounts.set(index2, (Object)((long)this.activity.inventoryAmounts.get(index2) + n));
        }
        else if (this.activity.inventoryItems.size() < this.activity.maxInventory) {
            this.activity.inventoryItems.add((Object)s);
            this.activity.inventoryAmounts.add((Object)(long)n);
            this.activity.inventoryItemLocked.add((Object)false);
        }
    }
    
    private void AddItemInfoWrap(final String text, final String text2, final int n, final LinearLayout linearLayout) {
        final LinearLayout linearLayout2 = new LinearLayout((Context)this.activity);
        linearLayout2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099857)));
        linearLayout2.setBackground(this.activity.GetImage(n));
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
        textView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
        textView.setText((CharSequence)text);
        textView.setTextColor(this.activity.GetColour(2131034924));
        final MainActivity activity = this.activity;
        activity.SetTextSize(textView, activity.GetResource(2131100247));
        linearLayout2.addView((View)textView);
        final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
        textView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        textView2.setText((CharSequence)text2);
        textView2.setTextColor(this.activity.GetColour(2131034225));
        textView2.setGravity(8388629);
        final MainActivity activity2 = this.activity;
        activity2.SetTextSize(textView2, activity2.GetResource(2131100247));
        linearLayout2.addView((View)textView2);
        linearLayout.addView((View)linearLayout2);
    }
    
    private void CheckSkillingScroll(final String s, final EditText editText, final int n, final SeekBar seekBar, final LinearLayout linearLayout) {
        if (this.skillingScrolls.getScrolls().contains((Object)s)) {
            final int index = this.skillingScrolls.getScrolls().indexOf((Object)s);
            if (this.skillingScrolls.unlocked.get(index)) {
                this.activity.QuickPopup("You have already unlocked this skilling scroll");
            }
            else {
                this.skillingScrolls.unlocked.set(index, (Object)true);
                final MainActivity activity = this.activity;
                activity.LargePopup((int)activity.skillsIcons.get(this.activity.skills.indexOf(this.skillingScrolls.getSkills().get(index))), "Congratulations", "You have unlocked a new ability: " + (String)this.skillingScrolls.getMethod().get(index) + "!");
                this.activity.RemoveItem(s, 1);
                try {
                    if (((String)this.activity.inventoryItems.get(n)).equals((Object)s)) {
                        final TextView textView = (TextView)((LinearLayout)linearLayout.getChildAt(0)).getChildAt(1);
                        final MainActivity activity2 = this.activity;
                        textView.setText((CharSequence)activity2.FormatExp((long)activity2.inventoryAmounts.get(n)));
                        seekBar.setProgress(0);
                        editText.setText((CharSequence)"");
                        seekBar.setMax(Math.toIntExact((long)this.activity.inventoryAmounts.get(n)));
                    }
                    else {
                        this.CloseItemPopup();
                    }
                    this.UpdateInventory();
                }
                catch (final IndexOutOfBoundsException ex) {
                    this.CloseItemPopup();
                    this.UpdateInventory();
                }
            }
        }
        else {
            this.activity.LogIt("Error: " + (Object)this.skillingScrolls.getScrolls());
        }
    }
    
    private boolean CorrectEquipment(final SecretRare secretRare) {
        boolean b = false;
        for (int n = 0; n < secretRare.getEquipmentNeeded().size() && !((String)secretRare.getEquipmentNeeded().get(n)).isEmpty(); ++n) {
            if (!this.activity.combatManager.equippedItems.contains(secretRare.getEquipmentNeeded().get(n))) {
                return b;
            }
        }
        b = true;
        return b;
    }
    
    private void EnhanceItem() {
        long tickets;
        final long n = tickets = this.selectedEnhancement.getTickets();
        if (this.activity.baseTower.baseTowerLevel >= 57) {
            tickets = n - n / 5L;
        }
        long n2 = tickets;
        if (tickets >= 20L) {
            n2 = tickets;
            if (this.activity.combatManager.equippedItems.contains((Object)"Tiki the Ticket")) {
                n2 = tickets - tickets / 20L;
            }
        }
        if (this.blessings.getTickets() >= n2) {
            if (this.activity.inventoryItems.contains((Object)this.selectedEnhancement.getRequirement())) {
                final int index = this.activity.inventoryItems.indexOf((Object)this.selectedEnhancement.getRequirement());
                if ((long)this.activity.inventoryAmounts.get(index) >= 1L) {
                    if ((long)this.activity.inventoryAmounts.get(index) == 1L && this.activity.combatManager.equippedItems.contains((Object)this.selectedEnhancement.getRequirement())) {
                        this.activity.QuickPopup("You must unequip this item first before you can enhance it");
                    }
                    else if (this.activity.inventoryItems.size() <= this.activity.maxInventory - 1) {
                        final Blessings blessings = this.blessings;
                        blessings.tickets -= n2;
                        final Blessings blessings2 = this.blessings;
                        ++blessings2.blessingsMade;
                        this.activity.RemoveItem(this.selectedEnhancement.getRequirement(), 1);
                        this.activity.GiveItem(this.selectedEnhancement.getItem(), 1L, false);
                        this.activity.LargePopup(2131165507, "Enhancement Complete", "Congratulations, you received 1x " + this.selectedEnhancement.getItem() + "!");
                        this.chosenItem = null;
                        this.UpdateBlessings();
                    }
                    else {
                        this.activity.QuickPopup("You need at least 1 free Inventory space.");
                    }
                }
                else {
                    this.activity.QuickPopup("You don't have the required item in your inventory.");
                }
            }
            else {
                this.activity.QuickPopup("You don't have the required item in your inventory.");
            }
        }
        else {
            this.activity.QuickPopup("You don't have enough Enhancement Tickets");
        }
    }
    
    private EnhancementTier FindTier(final String s) {
        for (int i = 0; i < this.enhancementTiers.size(); ++i) {
            if (((EnhancementTier)this.enhancementTiers.get(i)).getBaseItem().equals((Object)s)) {
                return (EnhancementTier)this.enhancementTiers.get(i);
            }
        }
        return null;
    }
    
    private float GetRandomFloat(final float n) {
        return new Random().nextFloat() * n;
    }
    
    private void HideKeyboard(final EditText editText) {
        ((InputMethodManager)this.activity.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
    
    private void UpdateBlessings() {
        this.bl_tickets.setText((CharSequence)this.activity.FormatExp(this.blessings.getTickets()));
        this.bl_blessings.setText((CharSequence)this.activity.FormatExp(this.blessings.getBlessingsMade()));
        final EnhancementTier chosenItem = this.chosenItem;
        if (chosenItem != null && this.selectedEnhancement != null) {
            this.bl_select.setText((CharSequence)chosenItem.getBaseItem());
            this.activity.ShowView((View)this.bl_chosenItem);
            this.activity.ShowView((View)this.bl_enhance);
            this.activity.ShowView((View)this.bl_tierselect);
            this.bl_tierselect.setText((CharSequence)("Enhancement Level " + (this.chosenItem.getItemTiers().indexOf((Object)this.selectedEnhancement) + 1)));
            this.bl_tierselect.setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda21(this));
            ((TextView)this.bl_chosenItem.getChildAt(0)).setText((CharSequence)this.selectedEnhancement.getItem());
            Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)this.selectedEnhancement.getItem()))).into((ImageView)this.bl_chosenItem.getChildAt(1));
            ((TextView)this.bl_chosenItem.getChildAt(3)).setText((CharSequence)("1x " + this.selectedEnhancement.getRequirement()));
            long tickets;
            final long n = tickets = this.selectedEnhancement.getTickets();
            if (this.activity.baseTower.baseTowerLevel >= 57) {
                tickets = n - n / 5L;
            }
            long n2 = tickets;
            if (tickets >= 20L) {
                n2 = tickets;
                if (this.activity.combatManager.equippedItems.contains((Object)"Tiki the Ticket")) {
                    n2 = tickets - tickets / 20L;
                }
            }
            ((TextView)this.bl_chosenItem.getChildAt(5)).setText((CharSequence)this.activity.FormatExp(n2));
            ((TextView)this.bl_chosenItem.getChildAt(7)).setText((CharSequence)this.selectedEnhancement.getDescription());
        }
        else {
            this.activity.HideView((View)this.bl_chosenItem);
            this.activity.HideView((View)this.bl_enhance);
            this.bl_select.setText((CharSequence)"Select an item to Enhance");
            this.activity.HideView((View)this.bl_tierselect);
        }
    }
    
    public void CheckOnlineSecrets(final String s, final String s2) {
        if (this.activity.databaseManager.hiddenSecrets_skill.contains((Object)s)) {
            for (final SecretRare secretRare : this.allSecretRares) {
                if (secretRare.getSkill().equals((Object)s) && secretRare.getMethod().equals((Object)s2)) {
                    if (this.CorrectEquipment(secretRare)) {
                        this.activity.combatManager.CheckSecret(secretRare.getName(), (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)secretRare.getName())), secretRare.getDropRate());
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    public void CheckSkillingScrolls() {
        this.activity.LogIt("Checking scrolls");
        for (int i = 0; i < this.skillScrolls_recipes.size(); ++i) {
            if (!this.skillingScrolls.getScrolls().contains(this.skillScrolls_recipes.get(i))) {
                this.activity.LogIt("Adding: " + (String)this.skillScrolls_recipes.get(i));
                this.skillingScrolls.scrolls.add((Object)this.skillScrolls_recipes.get(i));
                this.skillingScrolls.skills.add((Object)this.skillScrolls_skills.get(i));
                this.skillingScrolls.method.add((Object)this.skillScrolls_items.get(i));
                this.skillingScrolls.unlocked.add((Object)false);
            }
        }
    }
    
    public void CloseItemPopup() {
        this.activity.funimator.Start("SlideOutRight", 250L, new Funimator.AnimationData((View)this.activity.itemPopup, 0, true, 1, 0));
        this.activity.mainHandler.postDelayed((Runnable)new ItemManager$$ExternalSyntheticLambda24(this), 260L);
    }
    
    public void CreateEnhancements() {
        for (int i = 0; i < this.blessedItems.size(); ++i) {
            this.allEnhancements.add((Object)new Enhancement((String)this.blessedItems.get(i), (String)this.blessedItemsRequirement.get(i), (String)this.blessedItemsDescription.get(i), (long)this.blessedItemsTickets.get(i)));
        }
        this.CreateTiers();
    }
    
    public List<Item> CreateItemList() {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < this.activity.inventoryItems.size(); ++i) {
            ((List)list).add((Object)new Item((String)this.activity.inventoryItems.get(i), (long)this.activity.inventoryAmounts.get(i), (boolean)this.activity.inventoryItemLocked.get(i), i));
        }
        return (List<Item>)list;
    }
    
    public void CreateSkillingScrolls() {
        this.skillingScrolls = new SkillingScrolls(this.skillScrolls_skills, this.skillScrolls_recipes, this.skillScrolls_items, this.skillScrolls_unlocked);
    }
    
    public void CreateTiers() {
        for (int i = 0; i < this.allEnhancements.size(); ++i) {
            final Enhancement enhancement = (Enhancement)this.allEnhancements.get(i);
            if (enhancement.getItem().contains((CharSequence)"(E)")) {
                final EnhancementTier enhancementTier = new EnhancementTier(enhancement.getRequirement(), (List<Enhancement>)new ArrayList());
                enhancementTier.itemTiers.add((Object)enhancement);
                this.enhancementTiers.add((Object)enhancementTier);
            }
            else {
                String s;
                if (enhancement.getRequirement().contains((CharSequence)"(E)")) {
                    s = enhancement.getRequirement().substring(0, enhancement.getRequirement().length() - 4);
                }
                else {
                    s = enhancement.getRequirement().substring(0, enhancement.getRequirement().length() - 5);
                }
                final EnhancementTier findTier = this.FindTier(s);
                if (findTier != null) {
                    findTier.itemTiers.add((Object)enhancement);
                }
            }
        }
    }
    
    public void EquipItem(final int n, final String s, final int n2, final TextView textView) {
        if (this.activity.combatManager.equippedItems.get(n) != null && ((String)this.activity.combatManager.equippedItems.get(n)).equals((Object)s)) {
            final MainActivity activity = this.activity;
            activity.attackBonus -= (int)this.activity.allItemsAttackBonus.get(n2);
            final MainActivity activity2 = this.activity;
            activity2.strengthBonus -= (int)this.activity.allItemsStrengthBonus.get(n2);
            final MainActivity activity3 = this.activity;
            activity3.defenceBonus -= (int)this.activity.allItemsDefenceBonus.get(n2);
            final MainActivity activity4 = this.activity;
            activity4.healthBonus -= (int)this.activity.allItemsHealthBonus.get(n2);
            this.activity.combatManager.equippedItems.set(n, (Object)null);
        }
        else {
            if (this.activity.combatManager.equippedItems.get(n) != null) {
                final String s2 = (String)this.activity.combatManager.equippedItems.get(n);
                final MainActivity activity5 = this.activity;
                activity5.attackBonus -= (int)this.activity.allItemsAttackBonus.get(this.activity.allItems.indexOf((Object)s2));
                final MainActivity activity6 = this.activity;
                activity6.strengthBonus -= (int)this.activity.allItemsStrengthBonus.get(this.activity.allItems.indexOf((Object)s2));
                final MainActivity activity7 = this.activity;
                activity7.defenceBonus -= (int)this.activity.allItemsDefenceBonus.get(this.activity.allItems.indexOf((Object)s2));
                final MainActivity activity8 = this.activity;
                activity8.healthBonus -= (int)this.activity.allItemsHealthBonus.get(this.activity.allItems.indexOf((Object)s2));
            }
            this.activity.combatManager.equippedItems.set(n, (Object)s);
            final MainActivity activity9 = this.activity;
            activity9.attackBonus += (int)this.activity.allItemsAttackBonus.get(n2);
            final MainActivity activity10 = this.activity;
            activity10.strengthBonus += (int)this.activity.allItemsStrengthBonus.get(n2);
            final MainActivity activity11 = this.activity;
            activity11.defenceBonus += (int)this.activity.allItemsDefenceBonus.get(n2);
            final MainActivity activity12 = this.activity;
            activity12.healthBonus += (int)this.activity.allItemsHealthBonus.get(n2);
        }
        this.activity.UpdateMaxHealth();
        if (textView != null) {
            if (this.activity.combatManager.equippedItems.get(n) != null && ((String)this.activity.combatManager.equippedItems.get(n)).equals((Object)s)) {
                textView.setText((CharSequence)"Unequip");
            }
            else {
                textView.setText((CharSequence)"Equip");
            }
        }
    }
    
    public void GenerateInventory() {
        this.activity.inventoryWrap.removeAllViews();
        this.activity.inventoryWrap.setColumnCount(this.rowSize);
        this.inventoryViews.clear();
        this.generateInventory = false;
        for (int i = 0; i < this.activity.maxInventory; ++i) {
            final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
            final int inventItemSize = this.inventItemSize;
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(inventItemSize, inventItemSize);
            if (i % this.rowSize != 0) {
                layoutParams.leftMargin = this.activity.GetResource(2131100202);
            }
            if (i >= this.rowSize) {
                layoutParams.topMargin = this.activity.GetResource(2131100202);
            }
            relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            relativeLayout.setClipToPadding(false);
            relativeLayout.setClipChildren(false);
            relativeLayout.setBackground(this.activity.GetImage(2131165525));
            if (this.activity.inventoryItems.size() > i) {
                if ((long)this.activity.inventoryAmounts.get(i) >= 2000000000L) {
                    this.activity.inventoryAmounts.set(i, (Object)2000000000L);
                }
                final ImageView imageView = new ImageView((Context)this.activity);
                final int inventImageSize = this.inventImageSize;
                final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(inventImageSize, inventImageSize);
                layoutParams2.addRule(13);
                imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                imageView.setAdjustViewBounds(true);
                int intValue;
                try {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.activity.inventoryItems.get(i)));
                }
                catch (final IndexOutOfBoundsException ex) {
                    intValue = 0;
                }
                imageView.setTag((Object)intValue);
                Picasso.get().load(intValue).into(imageView);
                relativeLayout.addView((View)imageView);
                final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886371));
                final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(-2, -2);
                layoutParams3.addRule(12);
                layoutParams3.addRule(21);
                layoutParams3.setMargins(0, 0, this.activity.GetResource(2131100091), this.activity.GetResource(2131100091));
                textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
                final MainActivity activity = this.activity;
                activity.SetTextSize(textView, activity.GetResource(2131100247));
                textView.setTextColor(this.activity.GetColour(2131034924));
                final MainActivity activity2 = this.activity;
                textView.setText((CharSequence)activity2.FormatCoins((long)activity2.inventoryAmounts.get(i)));
                relativeLayout.addView((View)textView);
            }
            this.activity.inventoryWrap.addView((View)relativeLayout);
            this.inventoryViews.add((Object)relativeLayout);
            relativeLayout.setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda25(this, relativeLayout, i));
        }
    }
    
    public void ItemInfo(final String p0, final boolean p1, final boolean p2, final boolean p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //     4: astore          12
        //     6: aload           12
        //     8: aload           12
        //    10: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemPopup:Landroid/widget/RelativeLayout;
        //    13: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //    16: aload_0        
        //    17: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //    20: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.DisableScreen:()V
        //    23: aload_0        
        //    24: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //    27: astore          12
        //    29: aload           12
        //    31: aload           12
        //    33: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemPopup:Landroid/widget/RelativeLayout;
        //    36: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.DisableLayout:(Landroid/view/ViewGroup;)V
        //    39: aload_0        
        //    40: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //    43: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItems:Ljava/util/List;
        //    46: aload_1        
        //    47: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //    52: istore          7
        //    54: aload_0        
        //    55: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //    58: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryItems:Ljava/util/List;
        //    61: aload_1        
        //    62: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //    67: istore          6
        //    69: aload_0        
        //    70: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //    73: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemPopup:Landroid/widget/RelativeLayout;
        //    76: iconst_2       
        //    77: invokevirtual   android/widget/RelativeLayout.getChildAt:(I)Landroid/view/View;
        //    80: checkcast       Landroid/widget/ImageView;
        //    83: astore          16
        //    85: aload_0        
        //    86: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //    89: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //    92: iconst_0       
        //    93: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //    96: checkcast       Landroid/widget/TextView;
        //    99: astore          23
        //   101: aload_0        
        //   102: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   105: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   108: iconst_1       
        //   109: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   112: checkcast       Landroid/widget/ImageView;
        //   115: astore          13
        //   117: aload_0        
        //   118: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   121: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   124: iconst_2       
        //   125: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   128: checkcast       Landroid/widget/TextView;
        //   131: astore          12
        //   133: aload_0        
        //   134: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   137: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   140: iconst_3       
        //   141: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   144: checkcast       Landroid/widget/LinearLayout;
        //   147: astore          17
        //   149: aload_0        
        //   150: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   153: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   156: iconst_4       
        //   157: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   160: checkcast       Landroid/widget/EditText;
        //   163: astore          20
        //   165: aload_0        
        //   166: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   169: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   172: iconst_5       
        //   173: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   176: checkcast       Landroid/widget/SeekBar;
        //   179: astore          19
        //   181: aload_0        
        //   182: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   185: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   188: bipush          6
        //   190: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   193: checkcast       Landroid/widget/LinearLayout;
        //   196: astore          15
        //   198: aload_0        
        //   199: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   202: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   205: bipush          7
        //   207: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   210: checkcast       Landroid/widget/TextView;
        //   213: astore          21
        //   215: aload_0        
        //   216: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   219: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   222: bipush          8
        //   224: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   227: checkcast       Landroid/widget/TextView;
        //   230: astore          14
        //   232: aload_0        
        //   233: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   236: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   239: bipush          9
        //   241: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   244: checkcast       Landroid/widget/TextView;
        //   247: astore          22
        //   249: aload_0        
        //   250: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   253: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemInfoWrap:Landroid/widget/LinearLayout;
        //   256: bipush          10
        //   258: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //   261: checkcast       Landroid/widget/TextView;
        //   264: astore          18
        //   266: aload_0        
        //   267: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   270: aload           14
        //   272: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   275: aload_0        
        //   276: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   279: aload           18
        //   281: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   284: aload_0        
        //   285: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   288: aload           22
        //   290: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   293: iload_2        
        //   294: ifne            342
        //   297: aload_0        
        //   298: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   301: aload           21
        //   303: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   306: aload_0        
        //   307: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   310: aload           15
        //   312: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   315: aload_0        
        //   316: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   319: aload           19
        //   321: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   324: aload_0        
        //   325: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   328: aload           20
        //   330: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   333: aload           16
        //   335: fconst_0       
        //   336: invokevirtual   android/widget/ImageView.setAlpha:(F)V
        //   339: goto            708
        //   342: aload_0        
        //   343: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   346: aload           21
        //   348: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   351: aload_0        
        //   352: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   355: aload           15
        //   357: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   360: aload_0        
        //   361: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   364: aload           19
        //   366: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   369: aload_0        
        //   370: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   373: aload           20
        //   375: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   378: aload_0        
        //   379: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   382: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryItemLocked:Ljava/util/List;
        //   385: iload           6
        //   387: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   392: checkcast       Ljava/lang/Boolean;
        //   395: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   398: ifeq            410
        //   401: aload           16
        //   403: fconst_1       
        //   404: invokevirtual   android/widget/ImageView.setAlpha:(F)V
        //   407: goto            431
        //   410: aload           16
        //   412: ldc_w           0.2
        //   415: invokevirtual   android/widget/ImageView.setAlpha:(F)V
        //   418: goto            431
        //   421: astore          24
        //   423: aload           16
        //   425: ldc_w           0.2
        //   428: invokevirtual   android/widget/ImageView.setAlpha:(F)V
        //   431: aload           16
        //   433: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda27;
        //   436: dup            
        //   437: aload_0        
        //   438: iload           6
        //   440: aload           16
        //   442: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda27.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;ILandroid/widget/ImageView;)V
        //   445: invokevirtual   android/widget/ImageView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //   448: aload_0        
        //   449: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.allChests:Ljava/util/List;
        //   452: aload_1        
        //   453: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   458: ifeq            339
        //   461: aload_0        
        //   462: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   465: aload           14
        //   467: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   470: aload_0        
        //   471: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   474: aload           22
        //   476: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   479: aload           22
        //   481: ldc_w           "Open Max"
        //   484: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   487: aload_0        
        //   488: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.maxChestOpens:I
        //   491: i2l            
        //   492: aload_0        
        //   493: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   496: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryAmounts:Ljava/util/List;
        //   499: iload           6
        //   501: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   506: checkcast       Ljava/lang/Long;
        //   509: invokevirtual   java/lang/Long.longValue:()J
        //   512: invokestatic    java/lang/Math.min:(JJ)J
        //   515: l2i            
        //   516: istore          5
        //   518: aload_0        
        //   519: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.allChestsKeys:Ljava/util/List;
        //   522: aload_0        
        //   523: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.allChests:Ljava/util/List;
        //   526: aload_1        
        //   527: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //   532: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   537: checkcast       Ljava/lang/String;
        //   540: astore          16
        //   542: aload           16
        //   544: invokevirtual   java/lang/String.isEmpty:()Z
        //   547: ifne            663
        //   550: aload_0        
        //   551: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   554: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryItems:Ljava/util/List;
        //   557: aload           16
        //   559: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   564: ifeq            652
        //   567: aload_0        
        //   568: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   571: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryItems:Ljava/util/List;
        //   574: aload           16
        //   576: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //   581: istore          8
        //   583: aload_0        
        //   584: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   587: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryAmounts:Ljava/util/List;
        //   590: iload           8
        //   592: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   597: checkcast       Ljava/lang/Long;
        //   600: invokevirtual   java/lang/Long.longValue:()J
        //   603: iload           5
        //   605: i2l            
        //   606: invokestatic    java/lang/Math.min:(JJ)J
        //   609: l2i            
        //   610: istore          5
        //   612: aload           22
        //   614: new             Ljava/lang/StringBuilder;
        //   617: dup            
        //   618: ldc_w           "Open Max ("
        //   621: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   624: aload_0        
        //   625: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   628: iload           5
        //   630: i2l            
        //   631: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //   634: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   637: ldc_w           ")"
        //   640: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   643: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   646: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   649: goto            700
        //   652: aload           22
        //   654: ldc_w           "No Keys!"
        //   657: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   660: goto            700
        //   663: aload           22
        //   665: new             Ljava/lang/StringBuilder;
        //   668: dup            
        //   669: ldc_w           "Open Max ("
        //   672: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   675: aload_0        
        //   676: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   679: iload           5
        //   681: i2l            
        //   682: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //   685: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   688: ldc_w           ")"
        //   691: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   694: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   697: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   700: aload           14
        //   702: ldc_w           "Open"
        //   705: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   708: aload           15
        //   710: astore          16
        //   712: aload_0        
        //   713: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   716: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.baseTower:Luk/playdrop/cherrytree_idletextrpg/BaseTower;
        //   719: getfield        uk/playdrop/cherrytree_idletextrpg/BaseTower.baseTowerLevel:I
        //   722: iconst_5       
        //   723: if_icmplt       772
        //   726: iload           4
        //   728: ifeq            751
        //   731: aload_0        
        //   732: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   735: aload           18
        //   737: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   740: aload           18
        //   742: ldc_w           "Withdraw from Stash"
        //   745: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   748: goto            772
        //   751: iload_2        
        //   752: ifeq            772
        //   755: aload_0        
        //   756: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   759: aload           18
        //   761: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   764: aload           18
        //   766: ldc_w           "Send to Stash"
        //   769: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   772: aload           17
        //   774: invokevirtual   android/widget/LinearLayout.removeAllViews:()V
        //   777: aload           23
        //   779: aload_1        
        //   780: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   783: aload_0        
        //   784: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   787: astore          23
        //   789: aload           13
        //   791: aload           23
        //   793: aload           23
        //   795: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsIcons:Ljava/util/List;
        //   798: iload           7
        //   800: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   805: checkcast       Ljava/lang/Integer;
        //   808: invokevirtual   java/lang/Integer.intValue:()I
        //   811: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.GetImage:(I)Landroid/graphics/drawable/Drawable;
        //   814: invokevirtual   android/widget/ImageView.setImageDrawable:(Landroid/graphics/drawable/Drawable;)V
        //   817: aload_0        
        //   818: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   821: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsDescriptions:Ljava/util/List;
        //   824: iload           7
        //   826: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   831: checkcast       Ljava/lang/String;
        //   834: ldc_w           "null"
        //   837: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   840: ifne            877
        //   843: aload_0        
        //   844: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   847: aload           12
        //   849: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //   852: aload           12
        //   854: aload_0        
        //   855: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   858: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsDescriptions:Ljava/util/List;
        //   861: iload           7
        //   863: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   868: checkcast       Ljava/lang/CharSequence;
        //   871: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //   874: goto            886
        //   877: aload_0        
        //   878: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   881: aload           12
        //   883: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.HideView:(Landroid/view/View;)V
        //   886: aload_0        
        //   887: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   890: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.funimator:Luk/playdrop/cherrytree_idletextrpg/Funimator;
        //   893: ldc_w           "SlideInRight"
        //   896: ldc2_w          250
        //   899: new             Luk/playdrop/cherrytree_idletextrpg/Funimator$AnimationData;
        //   902: dup            
        //   903: aload_0        
        //   904: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   907: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.itemPopup:Landroid/widget/RelativeLayout;
        //   910: iconst_0       
        //   911: iconst_0       
        //   912: iconst_0       
        //   913: iconst_1       
        //   914: invokespecial   uk/playdrop/cherrytree_idletextrpg/Funimator$AnimationData.<init>:(Landroid/view/View;IZII)V
        //   917: invokevirtual   uk/playdrop/cherrytree_idletextrpg/Funimator.Start:(Ljava/lang/String;JLuk/playdrop/cherrytree_idletextrpg/Funimator$AnimationData;)V
        //   920: aload_0        
        //   921: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   924: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.mainHandler:Landroid/os/Handler;
        //   927: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda1;
        //   930: dup            
        //   931: aload_0        
        //   932: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda1.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;)V
        //   935: ldc2_w          250
        //   938: invokevirtual   android/os/Handler.postDelayed:(Ljava/lang/Runnable;J)Z
        //   941: pop            
        //   942: aload           19
        //   944: iconst_0       
        //   945: invokevirtual   android/widget/SeekBar.setProgress:(I)V
        //   948: aload           20
        //   950: ldc             ""
        //   952: invokevirtual   android/widget/EditText.setText:(Ljava/lang/CharSequence;)V
        //   955: aload_0        
        //   956: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   959: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryItems:Ljava/util/List;
        //   962: aload_1        
        //   963: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   968: ifeq            1002
        //   971: aload           19
        //   973: aload_0        
        //   974: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //   977: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryAmounts:Ljava/util/List;
        //   980: iload           6
        //   982: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   987: checkcast       Ljava/lang/Long;
        //   990: invokevirtual   java/lang/Long.longValue:()J
        //   993: invokestatic    java/lang/Math.toIntExact:(J)I
        //   996: invokevirtual   android/widget/SeekBar.setMax:(I)V
        //   999: goto            1008
        //  1002: aload           19
        //  1004: iconst_0       
        //  1005: invokevirtual   android/widget/SeekBar.setMax:(I)V
        //  1008: aload           20
        //  1010: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$1;
        //  1013: dup            
        //  1014: aload_0        
        //  1015: aload           20
        //  1017: aload           19
        //  1019: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$1.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;Landroid/widget/SeekBar;)V
        //  1022: invokevirtual   android/widget/EditText.addTextChangedListener:(Landroid/text/TextWatcher;)V
        //  1025: aload           19
        //  1027: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$2;
        //  1030: dup            
        //  1031: aload_0        
        //  1032: aload           21
        //  1034: aload           20
        //  1036: aload_1        
        //  1037: aload           14
        //  1039: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$2.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/TextView;Landroid/widget/EditText;Ljava/lang/String;Landroid/widget/TextView;)V
        //  1042: invokevirtual   android/widget/SeekBar.setOnSeekBarChangeListener:(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V
        //  1045: aload_0        
        //  1046: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1049: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryItems:Ljava/util/List;
        //  1052: aload_1        
        //  1053: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  1058: istore          9
        //  1060: ldc_w           "0"
        //  1063: astore          13
        //  1065: iload           9
        //  1067: ifeq            1115
        //  1070: aload_0        
        //  1071: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1074: astore          12
        //  1076: aload           12
        //  1078: aload           12
        //  1080: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryAmounts:Ljava/util/List;
        //  1083: aload_0        
        //  1084: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1087: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.inventoryItems:Ljava/util/List;
        //  1090: aload_1        
        //  1091: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  1096: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1101: checkcast       Ljava/lang/Long;
        //  1104: invokevirtual   java/lang/Long.longValue:()J
        //  1107: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1110: astore          12
        //  1112: goto            1120
        //  1115: ldc_w           "0"
        //  1118: astore          12
        //  1120: aload_0        
        //  1121: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1124: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.baseTower:Luk/playdrop/cherrytree_idletextrpg/BaseTower;
        //  1127: getfield        uk/playdrop/cherrytree_idletextrpg/BaseTower.stashItems:Ljava/util/List;
        //  1130: aload_1        
        //  1131: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  1136: ifeq            1187
        //  1139: aload_0        
        //  1140: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1143: astore          13
        //  1145: aload           13
        //  1147: aload           13
        //  1149: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.baseTower:Luk/playdrop/cherrytree_idletextrpg/BaseTower;
        //  1152: getfield        uk/playdrop/cherrytree_idletextrpg/BaseTower.stashAmounts:Ljava/util/List;
        //  1155: aload_0        
        //  1156: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1159: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.baseTower:Luk/playdrop/cherrytree_idletextrpg/BaseTower;
        //  1162: getfield        uk/playdrop/cherrytree_idletextrpg/BaseTower.stashItems:Ljava/util/List;
        //  1165: aload_1        
        //  1166: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  1171: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1176: checkcast       Ljava/lang/Long;
        //  1179: invokevirtual   java/lang/Long.longValue:()J
        //  1182: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1185: astore          13
        //  1187: iconst_4       
        //  1188: anewarray       Ljava/lang/String;
        //  1191: astore          23
        //  1193: aload           23
        //  1195: iconst_0       
        //  1196: ldc_w           "Inventory"
        //  1199: aastore        
        //  1200: aload           23
        //  1202: iconst_1       
        //  1203: ldc_w           "In Stash"
        //  1206: aastore        
        //  1207: aload           23
        //  1209: iconst_2       
        //  1210: ldc_w           "Item Value"
        //  1213: aastore        
        //  1214: aload           23
        //  1216: iconst_3       
        //  1217: ldc_w           "Rarity"
        //  1220: aastore        
        //  1221: aload_0        
        //  1222: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1225: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsValues:Ljava/util/List;
        //  1228: iload           7
        //  1230: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1235: checkcast       Ljava/lang/Long;
        //  1238: invokevirtual   java/lang/Long.longValue:()J
        //  1241: lstore          10
        //  1243: lload           10
        //  1245: lload           10
        //  1247: ldc2_w          100
        //  1250: ldiv           
        //  1251: aload_0        
        //  1252: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1255: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.databaseManager:Luk/playdrop/cherrytree_idletextrpg/DatabaseManager;
        //  1258: ldc_w           "Trader"
        //  1261: ldc_w           "Beginner"
        //  1264: invokevirtual   uk/playdrop/cherrytree_idletextrpg/DatabaseManager.GetWishLevel:(Ljava/lang/String;Ljava/lang/String;)I
        //  1267: i2l            
        //  1268: lmul           
        //  1269: ladd           
        //  1270: lstore          10
        //  1272: iconst_4       
        //  1273: anewarray       Ljava/lang/String;
        //  1276: astore          24
        //  1278: aload           24
        //  1280: iconst_0       
        //  1281: aload           12
        //  1283: aastore        
        //  1284: aload           24
        //  1286: iconst_1       
        //  1287: aload           13
        //  1289: aastore        
        //  1290: aload           24
        //  1292: iconst_2       
        //  1293: aload_0        
        //  1294: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1297: lload           10
        //  1299: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1302: aastore        
        //  1303: aload           24
        //  1305: iconst_3       
        //  1306: aload_0        
        //  1307: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1310: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsRarity:Ljava/util/List;
        //  1313: iload           7
        //  1315: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1320: checkcast       Ljava/lang/String;
        //  1323: aastore        
        //  1324: iconst_0       
        //  1325: istore          5
        //  1327: iload           5
        //  1329: iconst_4       
        //  1330: if_icmpge       1385
        //  1333: iload           5
        //  1335: ifle            1360
        //  1338: aload_0        
        //  1339: aload           23
        //  1341: iload           5
        //  1343: aaload         
        //  1344: aload           24
        //  1346: iload           5
        //  1348: aaload         
        //  1349: ldc_w           2131165348
        //  1352: aload           17
        //  1354: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager.AddItemInfoWrap:(Ljava/lang/String;Ljava/lang/String;ILandroid/widget/LinearLayout;)V
        //  1357: goto            1379
        //  1360: aload_0        
        //  1361: aload           23
        //  1363: iload           5
        //  1365: aaload         
        //  1366: aload           24
        //  1368: iload           5
        //  1370: aaload         
        //  1371: ldc_w           2131165346
        //  1374: aload           17
        //  1376: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager.AddItemInfoWrap:(Ljava/lang/String;Ljava/lang/String;ILandroid/widget/LinearLayout;)V
        //  1379: iinc            5, 1
        //  1382: goto            1327
        //  1385: aload_0        
        //  1386: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1389: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.farming:Luk/playdrop/cherrytree_idletextrpg/Farming;
        //  1392: getfield        uk/playdrop/cherrytree_idletextrpg/Farming.farmingSeeds:Ljava/util/List;
        //  1395: aload_1        
        //  1396: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  1401: ifeq            1481
        //  1404: aload_0        
        //  1405: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1408: astore          12
        //  1410: aload_0        
        //  1411: ldc_w           "Growth Time"
        //  1414: aload           12
        //  1416: ldc_w           2131820638
        //  1419: iconst_1       
        //  1420: anewarray       Ljava/lang/Object;
        //  1423: dup            
        //  1424: iconst_0       
        //  1425: aload           12
        //  1427: aload           12
        //  1429: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.farming:Luk/playdrop/cherrytree_idletextrpg/Farming;
        //  1432: getfield        uk/playdrop/cherrytree_idletextrpg/Farming.farmingSeedsTimers:Ljava/util/List;
        //  1435: aload_0        
        //  1436: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1439: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.farming:Luk/playdrop/cherrytree_idletextrpg/Farming;
        //  1442: getfield        uk/playdrop/cherrytree_idletextrpg/Farming.farmingSeeds:Ljava/util/List;
        //  1445: aload_1        
        //  1446: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  1451: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1456: checkcast       Ljava/lang/Long;
        //  1459: invokevirtual   java/lang/Long.longValue:()J
        //  1462: ldc2_w          60000
        //  1465: ldiv           
        //  1466: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1469: aastore        
        //  1470: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.getString:(I[Ljava/lang/Object;)Ljava/lang/String;
        //  1473: ldc_w           2131165348
        //  1476: aload           17
        //  1478: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager.AddItemInfoWrap:(Ljava/lang/String;Ljava/lang/String;ILandroid/widget/LinearLayout;)V
        //  1481: aload_0        
        //  1482: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1485: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsTypes:Ljava/util/List;
        //  1488: iload           7
        //  1490: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1495: checkcast       Ljava/lang/String;
        //  1498: ldc_w           "Equipment"
        //  1501: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //  1504: ifeq            2876
        //  1507: aload_0        
        //  1508: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1511: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1514: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryBows:Ljava/util/List;
        //  1517: aload_1        
        //  1518: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  1523: ifeq            1816
        //  1526: aload_0        
        //  1527: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1530: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1533: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryBows:Ljava/util/List;
        //  1536: aload_1        
        //  1537: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  1542: istore          5
        //  1544: new             Ljava/util/ArrayList;
        //  1547: dup            
        //  1548: iconst_4       
        //  1549: anewarray       Ljava/lang/String;
        //  1552: dup            
        //  1553: iconst_0       
        //  1554: ldc_w           "Speed"
        //  1557: aastore        
        //  1558: dup            
        //  1559: iconst_1       
        //  1560: ldc_w           "Accuracy"
        //  1563: aastore        
        //  1564: dup            
        //  1565: iconst_2       
        //  1566: ldc_w           "Damage Bonus"
        //  1569: aastore        
        //  1570: dup            
        //  1571: iconst_3       
        //  1572: ldc_w           "Critical Chance"
        //  1575: aastore        
        //  1576: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  1579: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  1582: astore          12
        //  1584: new             Ljava/lang/StringBuilder;
        //  1587: dup            
        //  1588: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1591: aload_0        
        //  1592: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1595: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1598: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryBowSpeed:Ljava/util/List;
        //  1601: iload           5
        //  1603: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1608: checkcast       Ljava/lang/Long;
        //  1611: invokevirtual   java/lang/Long.longValue:()J
        //  1614: l2f            
        //  1615: ldc_w           1000.0
        //  1618: fdiv           
        //  1619: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
        //  1622: ldc_w           "s"
        //  1625: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1628: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1631: astore          13
        //  1633: new             Ljava/lang/StringBuilder;
        //  1636: dup            
        //  1637: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1640: astore          24
        //  1642: aload_0        
        //  1643: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1646: astore          23
        //  1648: aload           24
        //  1650: aload           23
        //  1652: aload           23
        //  1654: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1657: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryBowAccuracy:Ljava/util/List;
        //  1660: iload           5
        //  1662: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1667: checkcast       Ljava/lang/Long;
        //  1670: invokevirtual   java/lang/Long.longValue:()J
        //  1673: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1676: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1679: ldc_w           "%"
        //  1682: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1685: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1688: astore          23
        //  1690: aload_0        
        //  1691: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1694: astore          24
        //  1696: aload           24
        //  1698: aload           24
        //  1700: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1703: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryBowDamage:Ljava/util/List;
        //  1706: iload           5
        //  1708: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1713: checkcast       Ljava/lang/Long;
        //  1716: invokevirtual   java/lang/Long.longValue:()J
        //  1719: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1722: astore          26
        //  1724: new             Ljava/lang/StringBuilder;
        //  1727: dup            
        //  1728: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1731: astore          24
        //  1733: aload_0        
        //  1734: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1737: astore          25
        //  1739: new             Ljava/util/ArrayList;
        //  1742: dup            
        //  1743: iconst_4       
        //  1744: anewarray       Ljava/lang/String;
        //  1747: dup            
        //  1748: iconst_0       
        //  1749: aload           13
        //  1751: aastore        
        //  1752: dup            
        //  1753: iconst_1       
        //  1754: aload           23
        //  1756: aastore        
        //  1757: dup            
        //  1758: iconst_2       
        //  1759: aload           26
        //  1761: aastore        
        //  1762: dup            
        //  1763: iconst_3       
        //  1764: aload           24
        //  1766: aload           25
        //  1768: aload           25
        //  1770: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1773: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.bowCritChance:Ljava/util/List;
        //  1776: iload           5
        //  1778: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1783: checkcast       Ljava/lang/Long;
        //  1786: invokevirtual   java/lang/Long.longValue:()J
        //  1789: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1792: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1795: ldc_w           "%"
        //  1798: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1801: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1804: aastore        
        //  1805: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  1808: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  1811: astore          13
        //  1813: goto            2667
        //  1816: aload_0        
        //  1817: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1820: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1823: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryArrows:Ljava/util/List;
        //  1826: aload_1        
        //  1827: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  1832: ifeq            1929
        //  1835: aload_0        
        //  1836: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1839: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1842: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryArrows:Ljava/util/List;
        //  1845: aload_1        
        //  1846: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  1851: istore          5
        //  1853: new             Ljava/util/ArrayList;
        //  1856: dup            
        //  1857: iconst_1       
        //  1858: anewarray       Ljava/lang/String;
        //  1861: dup            
        //  1862: iconst_0       
        //  1863: ldc_w           "Archery Damage"
        //  1866: aastore        
        //  1867: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  1870: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  1873: astore          12
        //  1875: aload_0        
        //  1876: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1879: astore          13
        //  1881: new             Ljava/util/ArrayList;
        //  1884: dup            
        //  1885: iconst_1       
        //  1886: anewarray       Ljava/lang/String;
        //  1889: dup            
        //  1890: iconst_0       
        //  1891: aload           13
        //  1893: aload           13
        //  1895: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1898: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryArrowDamage:Ljava/util/List;
        //  1901: iload           5
        //  1903: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1908: checkcast       Ljava/lang/Long;
        //  1911: invokevirtual   java/lang/Long.longValue:()J
        //  1914: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  1917: aastore        
        //  1918: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  1921: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  1924: astore          13
        //  1926: goto            2667
        //  1929: aload_0        
        //  1930: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  1933: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  1936: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.shadowGear:Ljava/util/List;
        //  1939: aload_1        
        //  1940: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  1945: ifeq            2242
        //  1948: new             Ljava/util/ArrayList;
        //  1951: dup            
        //  1952: bipush          6
        //  1954: anewarray       Ljava/lang/String;
        //  1957: dup            
        //  1958: iconst_0       
        //  1959: ldc_w           "Attack Bonus"
        //  1962: aastore        
        //  1963: dup            
        //  1964: iconst_1       
        //  1965: ldc_w           "Strength Bonus"
        //  1968: aastore        
        //  1969: dup            
        //  1970: iconst_2       
        //  1971: ldc_w           "Defence Bonus"
        //  1974: aastore        
        //  1975: dup            
        //  1976: iconst_3       
        //  1977: ldc_w           "Health Bonus"
        //  1980: aastore        
        //  1981: dup            
        //  1982: iconst_4       
        //  1983: ldc_w           "Archery Damage"
        //  1986: aastore        
        //  1987: dup            
        //  1988: iconst_5       
        //  1989: ldc_w           "Archery Crit"
        //  1992: aastore        
        //  1993: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  1996: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  1999: astore          12
        //  2001: aload_0        
        //  2002: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2005: astore          13
        //  2007: aload           13
        //  2009: aload           13
        //  2011: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsAttackBonus:Ljava/util/List;
        //  2014: iload           7
        //  2016: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2021: checkcast       Ljava/lang/Integer;
        //  2024: invokevirtual   java/lang/Integer.intValue:()I
        //  2027: i2l            
        //  2028: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2031: astore          13
        //  2033: aload_0        
        //  2034: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2037: astore          23
        //  2039: aload           23
        //  2041: aload           23
        //  2043: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsStrengthBonus:Ljava/util/List;
        //  2046: iload           7
        //  2048: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2053: checkcast       Ljava/lang/Integer;
        //  2056: invokevirtual   java/lang/Integer.intValue:()I
        //  2059: i2l            
        //  2060: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2063: astore          23
        //  2065: aload_0        
        //  2066: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2069: astore          24
        //  2071: aload           24
        //  2073: aload           24
        //  2075: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsDefenceBonus:Ljava/util/List;
        //  2078: iload           7
        //  2080: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2085: checkcast       Ljava/lang/Integer;
        //  2088: invokevirtual   java/lang/Integer.intValue:()I
        //  2091: i2l            
        //  2092: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2095: astore          24
        //  2097: aload_0        
        //  2098: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2101: astore          25
        //  2103: aload           25
        //  2105: aload           25
        //  2107: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsHealthBonus:Ljava/util/List;
        //  2110: iload           7
        //  2112: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2117: checkcast       Ljava/lang/Integer;
        //  2120: invokevirtual   java/lang/Integer.intValue:()I
        //  2123: i2l            
        //  2124: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2127: astore          25
        //  2129: aload_0        
        //  2130: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2133: astore          26
        //  2135: aload           26
        //  2137: aload           26
        //  2139: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2142: aload_1        
        //  2143: invokevirtual   uk/playdrop/cherrytree_idletextrpg/CombatManager.ArmourDamage:(Ljava/lang/String;)J
        //  2146: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2149: astore          27
        //  2151: new             Ljava/lang/StringBuilder;
        //  2154: dup            
        //  2155: invokespecial   java/lang/StringBuilder.<init>:()V
        //  2158: astore          28
        //  2160: aload_0        
        //  2161: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2164: astore          26
        //  2166: new             Ljava/util/ArrayList;
        //  2169: dup            
        //  2170: bipush          6
        //  2172: anewarray       Ljava/lang/String;
        //  2175: dup            
        //  2176: iconst_0       
        //  2177: aload           13
        //  2179: aastore        
        //  2180: dup            
        //  2181: iconst_1       
        //  2182: aload           23
        //  2184: aastore        
        //  2185: dup            
        //  2186: iconst_2       
        //  2187: aload           24
        //  2189: aastore        
        //  2190: dup            
        //  2191: iconst_3       
        //  2192: aload           25
        //  2194: aastore        
        //  2195: dup            
        //  2196: iconst_4       
        //  2197: aload           27
        //  2199: aastore        
        //  2200: dup            
        //  2201: iconst_5       
        //  2202: aload           28
        //  2204: aload           26
        //  2206: aload           26
        //  2208: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2211: aload_1        
        //  2212: invokevirtual   uk/playdrop/cherrytree_idletextrpg/CombatManager.ArmourCrit:(Ljava/lang/String;)J
        //  2215: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2218: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2221: ldc_w           "%"
        //  2224: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2227: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  2230: aastore        
        //  2231: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  2234: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  2237: astore          13
        //  2239: goto            1813
        //  2242: aload_0        
        //  2243: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2246: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2249: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.archeryArmour:Ljava/util/List;
        //  2252: aload_1        
        //  2253: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  2258: ifeq            2467
        //  2261: new             Ljava/util/ArrayList;
        //  2264: dup            
        //  2265: iconst_4       
        //  2266: anewarray       Ljava/lang/String;
        //  2269: dup            
        //  2270: iconst_0       
        //  2271: ldc_w           "Defence Bonus"
        //  2274: aastore        
        //  2275: dup            
        //  2276: iconst_1       
        //  2277: ldc_w           "Health Bonus"
        //  2280: aastore        
        //  2281: dup            
        //  2282: iconst_2       
        //  2283: ldc_w           "Archery Damage"
        //  2286: aastore        
        //  2287: dup            
        //  2288: iconst_3       
        //  2289: ldc_w           "Archery Crit"
        //  2292: aastore        
        //  2293: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  2296: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  2299: astore          12
        //  2301: aload_0        
        //  2302: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2305: astore          13
        //  2307: aload           13
        //  2309: aload           13
        //  2311: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsDefenceBonus:Ljava/util/List;
        //  2314: iload           7
        //  2316: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2321: checkcast       Ljava/lang/Integer;
        //  2324: invokevirtual   java/lang/Integer.intValue:()I
        //  2327: i2l            
        //  2328: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2331: astore          13
        //  2333: aload_0        
        //  2334: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2337: astore          23
        //  2339: aload           23
        //  2341: aload           23
        //  2343: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsHealthBonus:Ljava/util/List;
        //  2346: iload           7
        //  2348: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2353: checkcast       Ljava/lang/Integer;
        //  2356: invokevirtual   java/lang/Integer.intValue:()I
        //  2359: i2l            
        //  2360: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2363: astore          23
        //  2365: aload_0        
        //  2366: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2369: astore          24
        //  2371: aload           24
        //  2373: aload           24
        //  2375: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2378: aload_1        
        //  2379: invokevirtual   uk/playdrop/cherrytree_idletextrpg/CombatManager.ArmourDamage:(Ljava/lang/String;)J
        //  2382: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2385: astore          24
        //  2387: new             Ljava/lang/StringBuilder;
        //  2390: dup            
        //  2391: invokespecial   java/lang/StringBuilder.<init>:()V
        //  2394: astore          26
        //  2396: aload_0        
        //  2397: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2400: astore          25
        //  2402: new             Ljava/util/ArrayList;
        //  2405: dup            
        //  2406: iconst_4       
        //  2407: anewarray       Ljava/lang/String;
        //  2410: dup            
        //  2411: iconst_0       
        //  2412: aload           13
        //  2414: aastore        
        //  2415: dup            
        //  2416: iconst_1       
        //  2417: aload           23
        //  2419: aastore        
        //  2420: dup            
        //  2421: iconst_2       
        //  2422: aload           24
        //  2424: aastore        
        //  2425: dup            
        //  2426: iconst_3       
        //  2427: aload           26
        //  2429: aload           25
        //  2431: aload           25
        //  2433: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2436: aload_1        
        //  2437: invokevirtual   uk/playdrop/cherrytree_idletextrpg/CombatManager.ArmourCrit:(Ljava/lang/String;)J
        //  2440: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2443: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2446: ldc_w           "%"
        //  2449: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  2452: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  2455: aastore        
        //  2456: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  2459: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  2462: astore          13
        //  2464: goto            2667
        //  2467: new             Ljava/util/ArrayList;
        //  2470: dup            
        //  2471: iconst_4       
        //  2472: anewarray       Ljava/lang/String;
        //  2475: dup            
        //  2476: iconst_0       
        //  2477: ldc_w           "Attack Bonus"
        //  2480: aastore        
        //  2481: dup            
        //  2482: iconst_1       
        //  2483: ldc_w           "Strength Bonus"
        //  2486: aastore        
        //  2487: dup            
        //  2488: iconst_2       
        //  2489: ldc_w           "Defence Bonus"
        //  2492: aastore        
        //  2493: dup            
        //  2494: iconst_3       
        //  2495: ldc_w           "Health Bonus"
        //  2498: aastore        
        //  2499: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  2502: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  2505: astore          12
        //  2507: aload_0        
        //  2508: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2511: astore          13
        //  2513: aload           13
        //  2515: aload           13
        //  2517: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsAttackBonus:Ljava/util/List;
        //  2520: iload           7
        //  2522: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2527: checkcast       Ljava/lang/Integer;
        //  2530: invokevirtual   java/lang/Integer.intValue:()I
        //  2533: i2l            
        //  2534: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2537: astore          13
        //  2539: aload_0        
        //  2540: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2543: astore          23
        //  2545: aload           23
        //  2547: aload           23
        //  2549: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsStrengthBonus:Ljava/util/List;
        //  2552: iload           7
        //  2554: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2559: checkcast       Ljava/lang/Integer;
        //  2562: invokevirtual   java/lang/Integer.intValue:()I
        //  2565: i2l            
        //  2566: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2569: astore          23
        //  2571: aload_0        
        //  2572: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2575: astore          24
        //  2577: aload           24
        //  2579: aload           24
        //  2581: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsDefenceBonus:Ljava/util/List;
        //  2584: iload           7
        //  2586: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2591: checkcast       Ljava/lang/Integer;
        //  2594: invokevirtual   java/lang/Integer.intValue:()I
        //  2597: i2l            
        //  2598: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2601: astore          25
        //  2603: aload_0        
        //  2604: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2607: astore          24
        //  2609: new             Ljava/util/ArrayList;
        //  2612: dup            
        //  2613: iconst_4       
        //  2614: anewarray       Ljava/lang/String;
        //  2617: dup            
        //  2618: iconst_0       
        //  2619: aload           13
        //  2621: aastore        
        //  2622: dup            
        //  2623: iconst_1       
        //  2624: aload           23
        //  2626: aastore        
        //  2627: dup            
        //  2628: iconst_2       
        //  2629: aload           25
        //  2631: aastore        
        //  2632: dup            
        //  2633: iconst_3       
        //  2634: aload           24
        //  2636: aload           24
        //  2638: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsHealthBonus:Ljava/util/List;
        //  2641: iload           7
        //  2643: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2648: checkcast       Ljava/lang/Integer;
        //  2651: invokevirtual   java/lang/Integer.intValue:()I
        //  2654: i2l            
        //  2655: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2658: aastore        
        //  2659: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //  2662: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //  2665: astore          13
        //  2667: iconst_0       
        //  2668: istore          5
        //  2670: iload           5
        //  2672: aload           12
        //  2674: invokeinterface java/util/List.size:()I
        //  2679: if_icmpge       2721
        //  2682: aload_0        
        //  2683: aload           12
        //  2685: iload           5
        //  2687: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2692: checkcast       Ljava/lang/String;
        //  2695: aload           13
        //  2697: iload           5
        //  2699: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2704: checkcast       Ljava/lang/String;
        //  2707: ldc_w           2131165348
        //  2710: aload           17
        //  2712: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager.AddItemInfoWrap:(Ljava/lang/String;Ljava/lang/String;ILandroid/widget/LinearLayout;)V
        //  2715: iinc            5, 1
        //  2718: goto            2670
        //  2721: iload_3        
        //  2722: ifeq            2873
        //  2725: aload_0        
        //  2726: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2729: astore          12
        //  2731: aload           12
        //  2733: aload           14
        //  2735: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  2738: aload_0        
        //  2739: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2742: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsTypes:Ljava/util/List;
        //  2745: iload           7
        //  2747: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2752: checkcast       Ljava/lang/String;
        //  2755: ldc_w           "\\s*-\\s*"
        //  2758: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //  2761: iconst_1       
        //  2762: aaload         
        //  2763: astore          12
        //  2765: aload_0        
        //  2766: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2769: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2772: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.equippedItemsTypes:Ljava/util/List;
        //  2775: aload           12
        //  2777: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  2782: istore          5
        //  2784: aload_0        
        //  2785: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2788: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2791: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.equippedItems:Ljava/util/List;
        //  2794: iload           5
        //  2796: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2801: ifnull          2842
        //  2804: aload_0        
        //  2805: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2808: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.combatManager:Luk/playdrop/cherrytree_idletextrpg/CombatManager;
        //  2811: getfield        uk/playdrop/cherrytree_idletextrpg/CombatManager.equippedItems:Ljava/util/List;
        //  2814: iload           5
        //  2816: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2821: checkcast       Ljava/lang/String;
        //  2824: aload_1        
        //  2825: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2828: ifeq            2842
        //  2831: aload           14
        //  2833: ldc_w           "Unequip"
        //  2836: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //  2839: goto            2850
        //  2842: aload           14
        //  2844: ldc_w           "Equip"
        //  2847: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //  2850: aload           14
        //  2852: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda2;
        //  2855: dup            
        //  2856: aload_0        
        //  2857: aload_1        
        //  2858: iload           5
        //  2860: iload           7
        //  2862: aload           14
        //  2864: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda2.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Ljava/lang/String;IILandroid/widget/TextView;)V
        //  2867: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  2870: goto            2876
        //  2873: goto            2876
        //  2876: iload_3        
        //  2877: ifeq            3427
        //  2880: aload_0        
        //  2881: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2884: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.foodItems:Ljava/util/List;
        //  2887: aload_1        
        //  2888: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  2893: ifeq            3044
        //  2896: aload_0        
        //  2897: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2900: aload           14
        //  2902: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  2905: aload_0        
        //  2906: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2909: astore          12
        //  2911: aload           12
        //  2913: aload           12
        //  2915: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.foodItemHealing:Ljava/util/List;
        //  2918: aload_0        
        //  2919: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2922: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.foodItems:Ljava/util/List;
        //  2925: aload_1        
        //  2926: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  2931: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  2936: checkcast       Ljava/lang/Integer;
        //  2939: invokevirtual   java/lang/Integer.intValue:()I
        //  2942: i2l            
        //  2943: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2946: astore          12
        //  2948: aload_1        
        //  2949: ldc_w           "Dragon Platter"
        //  2952: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  2955: ifeq            2979
        //  2958: aload_0        
        //  2959: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2962: astore          12
        //  2964: aload           12
        //  2966: aload           12
        //  2968: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.maxHealth:I
        //  2971: iconst_2       
        //  2972: idiv           
        //  2973: i2l            
        //  2974: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  2977: astore          12
        //  2979: aload_0        
        //  2980: ldc_w           "Heal Amount"
        //  2983: aload           12
        //  2985: ldc_w           2131165348
        //  2988: aload           17
        //  2990: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager.AddItemInfoWrap:(Ljava/lang/String;Ljava/lang/String;ILandroid/widget/LinearLayout;)V
        //  2993: aload_0        
        //  2994: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  2997: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.equippedFood:Ljava/lang/String;
        //  3000: aload_1        
        //  3001: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3004: ifeq            3018
        //  3007: aload           14
        //  3009: ldc_w           "Unequip"
        //  3012: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //  3015: goto            3026
        //  3018: aload           14
        //  3020: ldc_w           "Equip"
        //  3023: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //  3026: aload           14
        //  3028: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda3;
        //  3031: dup            
        //  3032: aload_0        
        //  3033: aload           20
        //  3035: aload_1        
        //  3036: aload           14
        //  3038: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda3.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;Ljava/lang/String;Landroid/widget/TextView;)V
        //  3041: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3044: aload_0        
        //  3045: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3048: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsTypes:Ljava/util/List;
        //  3051: iload           7
        //  3053: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3058: checkcast       Ljava/lang/String;
        //  3061: ldc_w           "Weapon"
        //  3064: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3067: ifeq            3248
        //  3070: aload_0        
        //  3071: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3074: aload           14
        //  3076: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  3079: aload_0        
        //  3080: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3083: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsAttackBonus:Ljava/util/List;
        //  3086: iload           7
        //  3088: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3093: checkcast       Ljava/lang/Integer;
        //  3096: astore          24
        //  3098: aload_0        
        //  3099: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3102: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsStrengthBonus:Ljava/util/List;
        //  3105: iload           7
        //  3107: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3112: checkcast       Ljava/lang/Integer;
        //  3115: astore          12
        //  3117: aload_0        
        //  3118: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3121: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsDefenceBonus:Ljava/util/List;
        //  3124: iload           7
        //  3126: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3131: checkcast       Ljava/lang/Integer;
        //  3134: astore          13
        //  3136: aload_0        
        //  3137: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3140: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsHealthBonus:Ljava/util/List;
        //  3143: iload           7
        //  3145: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3150: checkcast       Ljava/lang/Integer;
        //  3153: astore          23
        //  3155: iconst_0       
        //  3156: istore          5
        //  3158: iload           5
        //  3160: iconst_4       
        //  3161: if_icmpge       3248
        //  3164: aload_0        
        //  3165: iconst_4       
        //  3166: anewarray       Ljava/lang/String;
        //  3169: dup            
        //  3170: iconst_0       
        //  3171: ldc_w           "Attack Bonus"
        //  3174: aastore        
        //  3175: dup            
        //  3176: iconst_1       
        //  3177: ldc_w           "Strength Bonus"
        //  3180: aastore        
        //  3181: dup            
        //  3182: iconst_2       
        //  3183: ldc_w           "Defence Bonus"
        //  3186: aastore        
        //  3187: dup            
        //  3188: iconst_3       
        //  3189: ldc_w           "Health Bonus"
        //  3192: aastore        
        //  3193: iload           5
        //  3195: aaload         
        //  3196: aload_0        
        //  3197: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3200: iconst_4       
        //  3201: anewarray       Ljava/lang/Integer;
        //  3204: dup            
        //  3205: iconst_0       
        //  3206: aload           24
        //  3208: aastore        
        //  3209: dup            
        //  3210: iconst_1       
        //  3211: aload           12
        //  3213: aastore        
        //  3214: dup            
        //  3215: iconst_2       
        //  3216: aload           13
        //  3218: aastore        
        //  3219: dup            
        //  3220: iconst_3       
        //  3221: aload           23
        //  3223: aastore        
        //  3224: iload           5
        //  3226: aaload         
        //  3227: invokevirtual   java/lang/Integer.intValue:()I
        //  3230: i2l            
        //  3231: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.FormatExp:(J)Ljava/lang/String;
        //  3234: ldc_w           2131165348
        //  3237: aload           17
        //  3239: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager.AddItemInfoWrap:(Ljava/lang/String;Ljava/lang/String;ILandroid/widget/LinearLayout;)V
        //  3242: iinc            5, 1
        //  3245: goto            3158
        //  3248: aload_0        
        //  3249: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.allChests:Ljava/util/List;
        //  3252: aload_1        
        //  3253: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //  3258: ifeq            3300
        //  3261: aload           14
        //  3263: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda4;
        //  3266: dup            
        //  3267: aload_0        
        //  3268: aload           19
        //  3270: aload_1        
        //  3271: aload           20
        //  3273: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda4.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/SeekBar;Ljava/lang/String;Landroid/widget/EditText;)V
        //  3276: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3279: aload           22
        //  3281: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda5;
        //  3284: dup            
        //  3285: aload_0        
        //  3286: iload           6
        //  3288: aload_1        
        //  3289: aload           20
        //  3291: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda5.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;ILjava/lang/String;Landroid/widget/EditText;)V
        //  3294: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3297: goto            3300
        //  3300: aload_0        
        //  3301: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3304: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsTypes:Ljava/util/List;
        //  3307: iload           7
        //  3309: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3314: checkcast       Ljava/lang/String;
        //  3317: ldc_w           "Exp Scroll"
        //  3320: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3323: ifeq            3359
        //  3326: aload_0        
        //  3327: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3330: aload           14
        //  3332: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  3335: aload           14
        //  3337: ldc_w           "Read Scroll"
        //  3340: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //  3343: aload           14
        //  3345: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda6;
        //  3348: dup            
        //  3349: aload_0        
        //  3350: aload_1        
        //  3351: aload           20
        //  3353: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda6.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Ljava/lang/String;Landroid/widget/EditText;)V
        //  3356: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3359: aload_0        
        //  3360: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3363: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.allItemsTypes:Ljava/util/List;
        //  3366: iload           7
        //  3368: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3373: checkcast       Ljava/lang/String;
        //  3376: ldc_w           "Skilling Scroll"
        //  3379: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //  3382: ifeq            3427
        //  3385: aload_0        
        //  3386: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3389: aload           14
        //  3391: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  3394: aload           14
        //  3396: ldc_w           "Read Scroll"
        //  3399: invokevirtual   android/widget/TextView.setText:(Ljava/lang/CharSequence;)V
        //  3402: aload           14
        //  3404: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda7;
        //  3407: dup            
        //  3408: aload_0        
        //  3409: aload_1        
        //  3410: aload           20
        //  3412: iload           6
        //  3414: aload           19
        //  3416: aload           17
        //  3418: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda7.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Ljava/lang/String;Landroid/widget/EditText;ILandroid/widget/SeekBar;Landroid/widget/LinearLayout;)V
        //  3421: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3424: goto            3427
        //  3427: iload_2        
        //  3428: ifeq            3506
        //  3431: aload           16
        //  3433: iconst_0       
        //  3434: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //  3437: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda8;
        //  3440: dup            
        //  3441: aload_0        
        //  3442: aload           20
        //  3444: aload           19
        //  3446: aload           21
        //  3448: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda8.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;Landroid/widget/SeekBar;Landroid/widget/TextView;)V
        //  3451: invokevirtual   android/view/View.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3454: aload           16
        //  3456: iconst_1       
        //  3457: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //  3460: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda9;
        //  3463: dup            
        //  3464: aload_0        
        //  3465: aload           20
        //  3467: aload           19
        //  3469: aload           21
        //  3471: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda9.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;Landroid/widget/SeekBar;Landroid/widget/TextView;)V
        //  3474: invokevirtual   android/view/View.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3477: aload           21
        //  3479: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda28;
        //  3482: dup            
        //  3483: aload_0        
        //  3484: aload           20
        //  3486: iload           6
        //  3488: aload           19
        //  3490: aload_1        
        //  3491: lload           10
        //  3493: aload           17
        //  3495: aload           21
        //  3497: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda28.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;ILandroid/widget/SeekBar;Ljava/lang/String;JLandroid/widget/LinearLayout;Landroid/widget/TextView;)V
        //  3500: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3503: goto            3506
        //  3506: iload           4
        //  3508: ifeq            3664
        //  3511: aload_0        
        //  3512: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3515: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.baseTower:Luk/playdrop/cherrytree_idletextrpg/BaseTower;
        //  3518: getfield        uk/playdrop/cherrytree_idletextrpg/BaseTower.baseTowerLevel:I
        //  3521: iconst_5       
        //  3522: if_icmplt       3690
        //  3525: aload_0        
        //  3526: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3529: aload           19
        //  3531: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  3534: aload_0        
        //  3535: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3538: aload           20
        //  3540: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  3543: aload_0        
        //  3544: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3547: aload           15
        //  3549: invokevirtual   uk/playdrop/cherrytree_idletextrpg/MainActivity.ShowView:(Landroid/view/View;)V
        //  3552: aload           19
        //  3554: aload_0        
        //  3555: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3558: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.baseTower:Luk/playdrop/cherrytree_idletextrpg/BaseTower;
        //  3561: getfield        uk/playdrop/cherrytree_idletextrpg/BaseTower.stashAmounts:Ljava/util/List;
        //  3564: aload_0        
        //  3565: getfield        uk/playdrop/cherrytree_idletextrpg/ItemManager.activity:Luk/playdrop/cherrytree_idletextrpg/MainActivity;
        //  3568: getfield        uk/playdrop/cherrytree_idletextrpg/MainActivity.baseTower:Luk/playdrop/cherrytree_idletextrpg/BaseTower;
        //  3571: getfield        uk/playdrop/cherrytree_idletextrpg/BaseTower.stashItems:Ljava/util/List;
        //  3574: aload_1        
        //  3575: invokeinterface java/util/List.indexOf:(Ljava/lang/Object;)I
        //  3580: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  3585: checkcast       Ljava/lang/Long;
        //  3588: invokevirtual   java/lang/Long.longValue:()J
        //  3591: invokestatic    java/lang/Math.toIntExact:(J)I
        //  3594: invokevirtual   android/widget/SeekBar.setMax:(I)V
        //  3597: aload           15
        //  3599: iconst_0       
        //  3600: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //  3603: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda29;
        //  3606: dup            
        //  3607: aload_0        
        //  3608: aload           20
        //  3610: aload           19
        //  3612: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda29.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;Landroid/widget/SeekBar;)V
        //  3615: invokevirtual   android/view/View.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3618: aload           15
        //  3620: iconst_1       
        //  3621: invokevirtual   android/widget/LinearLayout.getChildAt:(I)Landroid/view/View;
        //  3624: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda30;
        //  3627: dup            
        //  3628: aload_0        
        //  3629: aload           20
        //  3631: aload           19
        //  3633: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda30.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;Landroid/widget/SeekBar;)V
        //  3636: invokevirtual   android/view/View.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3639: aload           18
        //  3641: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda31;
        //  3644: dup            
        //  3645: aload_0        
        //  3646: aload           19
        //  3648: aload_1        
        //  3649: aload           20
        //  3651: aload           18
        //  3653: aload           17
        //  3655: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda31.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/SeekBar;Ljava/lang/String;Landroid/widget/EditText;Landroid/widget/TextView;Landroid/widget/LinearLayout;)V
        //  3658: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3661: goto            3690
        //  3664: iload_2        
        //  3665: ifeq            3690
        //  3668: aload           18
        //  3670: new             Luk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda32;
        //  3673: dup            
        //  3674: aload_0        
        //  3675: aload           20
        //  3677: aload_1        
        //  3678: aload           19
        //  3680: aload           18
        //  3682: iload           6
        //  3684: invokespecial   uk/playdrop/cherrytree_idletextrpg/ItemManager$$ExternalSyntheticLambda32.<init>:(Luk/playdrop/cherrytree_idletextrpg/ItemManager;Landroid/widget/EditText;Ljava/lang/String;Landroid/widget/SeekBar;Landroid/widget/TextView;I)V
        //  3687: invokevirtual   android/widget/TextView.setOnClickListener:(Landroid/view/View$OnClickListener;)V
        //  3690: return         
        //  3691: astore          24
        //  3693: goto            423
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                 
        //  -----  -----  -----  -----  -------------------------------------
        //  378    407    421    423    Ljava/lang/IndexOutOfBoundsException;
        //  410    418    3691   3696   Ljava/lang/IndexOutOfBoundsException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0410:
        //     at w5.m.a(SourceFile:20)
        //     at w5.f.o(SourceFile:122)
        //     at w5.f.r(SourceFile:571)
        //     at w5.f.q(SourceFile:3)
        //     at a6.j.j(SourceFile:32)
        //     at a6.j.i(SourceFile:28)
        //     at a6.i.n(SourceFile:7)
        //     at a6.i.m(SourceFile:174)
        //     at a6.i.c(SourceFile:67)
        //     at a6.i.r(SourceFile:328)
        //     at a6.i.s(SourceFile:17)
        //     at a6.i.q(SourceFile:29)
        //     at a6.i.b(SourceFile:33)
        //     at y5.d.e(SourceFile:6)
        //     at y5.d.b(SourceFile:1)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(SourceFile:306)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(SourceFile:131)
        //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(SourceFile:3)
        //     at com.thesourceofcode.jadec.workers.DecompilerWorker.d(SourceFile:53)
        //     at com.thesourceofcode.jadec.workers.DecompilerWorker.b(SourceFile:1)
        //     at e7.a.run(SourceFile:1)
        //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1154)
        //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:652)
        //     at java.lang.Thread.run(Thread.java:1563)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void OpenBlessings() {
        if (this.blessingsScreen == null) {
            this.blessingsScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131296397)).inflate();
            final ScrollView blessingsScreen = (ScrollView)this.activity.findViewById(2131296396);
            this.blessingsScreen = blessingsScreen;
            this.bl_tickets = (TextView)blessingsScreen.findViewById(2131296394);
            this.bl_blessings = (TextView)this.blessingsScreen.findViewById(2131296390);
            this.bl_select = (TextView)this.blessingsScreen.findViewById(2131296393);
            this.bl_enhance = (TextView)this.blessingsScreen.findViewById(2131296392);
            this.bl_chosenItem = (LinearLayout)this.blessingsScreen.findViewById(2131296391);
            this.bl_tierselect = (TextView)this.blessingsScreen.findViewById(2131296395);
        }
        this.activity.EnableLayout((ViewGroup)this.blessingsScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.blessingsScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.chosenItem = null;
        this.selectedEnhancement = null;
        this.bl_enhance.setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda13(this));
        this.bl_select.setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda14(this));
        this.UpdateBlessings();
    }
    
    public void OpenChest(final String s, final int n) {
        this.activity.LoadChestScreen();
        ((LinearLayout)this.activity.chestLootScreen.getChildAt(2)).removeAllViews();
        this.activity.chestLootScreen.getChildAt(3).setAlpha(0.0f);
        final ImageView imageView = (ImageView)this.activity.chestLootScreen.getChildAt(0);
        final MainActivity activity = this.activity;
        imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s))));
        ((TextView)this.activity.chestLootScreen.getChildAt(1)).setText((CharSequence)("You opened " + this.activity.FormatExp((long)n) + " " + s + "s and received..."));
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute((Runnable)new ItemManager$$ExternalSyntheticLambda19(this, s, n));
        singleThreadExecutor.shutdown();
    }
    
    public void OpenInventory() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.inventoryScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        final MainActivity activity4 = this.activity;
        activity4.ShowView(activity4.findViewById(2131296964));
        final TextView organise = (TextView)this.activity.findViewById(2131296957);
        this.organise = organise;
        this.sortMode = false;
        this.selectedItem = -1;
        organise.setText((CharSequence)"Sort Mode Off");
        if (!this.inventoryViews.isEmpty()) {
            for (final RelativeLayout relativeLayout : this.inventoryViews) {
                if (relativeLayout.getAlpha() < 1.0f) {
                    relativeLayout.setAlpha(1.0f);
                }
            }
        }
        this.organise.setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda0(this));
        this.activity.findViewById(2131296359).setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda11(this));
        this.activity.findViewById(2131296750).setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda22(this));
        this.activity.currentView.post((Runnable)new ItemManager$$ExternalSyntheticLambda26(this));
    }
    
    public void RevertBackToLists(final List<Item> list) {
        this.tempInventoryItems.clear();
        this.tempInventoryAmounts.clear();
        this.tempInventoryItemLocked.clear();
        this.tempInventoryItems.addAll((Collection)this.activity.inventoryItems);
        this.tempInventoryAmounts.addAll((Collection)this.activity.inventoryAmounts);
        this.tempInventoryItemLocked.addAll((Collection)this.activity.inventoryItemLocked);
        this.activity.inventoryItems.clear();
        this.activity.inventoryAmounts.clear();
        this.activity.inventoryItemLocked.clear();
        for (int i = 0; i < list.size(); ++i) {
            final Item item = (Item)list.get(i);
            this.activity.inventoryItems.add((Object)item.getName());
            this.activity.inventoryAmounts.add((Object)item.getAmount());
            this.activity.inventoryItemLocked.add((Object)item.isLocked());
        }
    }
    
    public void ShowChestLoot(final List<String> list, final List<Integer> list2) {
        final LinearLayout linearLayout = (LinearLayout)this.activity.chestLootScreen.getChildAt(2);
        for (int i = 0; i < list.size(); ++i) {
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = this.activity.GetResource(2131099869);
            }
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            if (!((String)list.get(i)).equals((Object)"Soul Reaper Fragment") && !((String)list.get(i)).equals((Object)"Golden Egg") && !((String)list.get(i)).equals((Object)"Special Currency")) {
                textView.setTextColor(this.activity.GetColour(2131034225));
            }
            else {
                textView.setTextColor(this.activity.GetColour(2131034892));
            }
            final MainActivity activity = this.activity;
            activity.SetTextSize(textView, activity.GetResource(2131099658));
            if (((String)list.get(i)).equals((Object)"Special Currency")) {
                textView.setText((CharSequence)(" " + this.activity.FormatExp((long)(int)list2.get(i)) + "x " + this.activity.event.specialCurrency));
            }
            else {
                textView.setText((CharSequence)(" " + this.activity.FormatExp((long)(int)list2.get(i)) + "x " + (String)list.get(i)));
            }
            textView.setGravity(17);
            linearLayout.addView((View)textView);
        }
        this.activity.mainHandler.postDelayed((Runnable)new ItemManager$$ExternalSyntheticLambda15(this), 1500L);
    }
    
    public void SortInventory(final String s) {
        this.RevertBackToLists(this.SortItems(s));
    }
    
    public List<Item> SortItems(final String s) {
        final List<Item> createItemList = this.CreateItemList();
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1854127182: {
                if (!s.equals((Object)"Amount (Low-High)")) {
                    break;
                }
                n = 2;
                break;
            }
            case 87950: {
                if (!s.equals((Object)"Z-A")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1024744928: {
                if (!s.equals((Object)"Amount (High-Low)")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                createItemList.sort(Comparator.comparing((Function)new BaseTower$$ExternalSyntheticLambda1()));
                break;
            }
            case 2: {
                createItemList.sort(Comparator.comparing((Function)new BaseTower$$ExternalSyntheticLambda2()));
                break;
            }
            case 1: {
                createItemList.sort(Comparator.comparing((Function)new BaseTower$$ExternalSyntheticLambda1()));
                Collections.reverse((List)createItemList);
                break;
            }
            case 0: {
                createItemList.sort(Comparator.comparing((Function)new BaseTower$$ExternalSyntheticLambda2()));
                Collections.reverse((List)createItemList);
                break;
            }
        }
        return createItemList;
    }
    
    public void UpdateInventory() {
        for (int i = 0; i < this.inventoryViews.size(); ++i) {
            if (this.activity.inventoryItems.size() > i) {
                if ((long)this.activity.inventoryAmounts.get(i) >= 2000000000L) {
                    this.activity.inventoryAmounts.set(i, (Object)2000000000L);
                }
                final MainActivity activity = this.activity;
                final String formatCoins = activity.FormatCoins((long)activity.inventoryAmounts.get(i));
                if (((RelativeLayout)this.inventoryViews.get(i)).getChildCount() == 0) {
                    final ImageView imageView = new ImageView((Context)this.activity);
                    final int inventImageSize = this.inventImageSize;
                    final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(inventImageSize, inventImageSize);
                    layoutParams.addRule(13);
                    imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                    imageView.setAdjustViewBounds(true);
                    final int intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.activity.inventoryItems.get(i)));
                    imageView.setTag((Object)intValue);
                    Picasso.get().load(intValue).into(imageView);
                    ((RelativeLayout)this.inventoryViews.get(i)).addView((View)imageView);
                    final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886371));
                    final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-2, -2);
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(21);
                    layoutParams2.setMargins(0, 0, this.activity.GetResource(2131100091), this.activity.GetResource(2131100091));
                    textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                    final MainActivity activity2 = this.activity;
                    activity2.SetTextSize(textView, activity2.GetResource(2131100247));
                    textView.setTextColor(this.activity.GetColour(2131034924));
                    textView.setText((CharSequence)formatCoins);
                    ((RelativeLayout)this.inventoryViews.get(i)).addView((View)textView);
                }
                else {
                    final ImageView imageView2 = (ImageView)((RelativeLayout)this.inventoryViews.get(i)).getChildAt(0);
                    final TextView textView2 = (TextView)((RelativeLayout)this.inventoryViews.get(i)).getChildAt(1);
                    final int intValue2 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.activity.inventoryItems.get(i)));
                    if ((int)imageView2.getTag() != intValue2) {
                        imageView2.setTag((Object)intValue2);
                        Picasso.get().load(intValue2).into(imageView2);
                    }
                    if (!textView2.getText().toString().equals((Object)formatCoins)) {
                        textView2.setText((CharSequence)formatCoins);
                    }
                }
            }
            else {
                ((RelativeLayout)this.inventoryViews.get(i)).removeAllViews();
            }
        }
    }
    
    public void UpdateItem(final String s) {
        if (!this.activity.inventoryItems.contains((Object)s)) {
            return;
        }
        try {
            final int index = this.activity.inventoryItems.indexOf((Object)s);
            if (index < 0) {
                return;
            }
            final List<RelativeLayout> inventoryViews = this.inventoryViews;
            if (inventoryViews != null && index < inventoryViews.size()) {
                if (this.inventoryViews.get(index) != null) {
                    final TextView textView = (TextView)((RelativeLayout)this.inventoryViews.get(index)).getChildAt(1);
                    if (textView != null) {
                        final MainActivity activity = this.activity;
                        textView.setText((CharSequence)activity.FormatCoins((long)activity.inventoryAmounts.get(index)));
                    }
                }
            }
        }
        catch (final NullPointerException ex) {}
    }
    
    public void UseExpScroll(final String s) {
        s.hashCode();
        int n = 0;
        Label_0149: {
            switch (s.hashCode()) {
                case 1862586185: {
                    if (!s.equals((Object)"Small Exp Scroll")) {
                        break;
                    }
                    n = 4;
                    break Label_0149;
                }
                case 789479573: {
                    if (!s.equals((Object)"Large Exp Scroll")) {
                        break;
                    }
                    n = 3;
                    break Label_0149;
                }
                case -433323591: {
                    if (!s.equals((Object)"Mini Exp Scroll")) {
                        break;
                    }
                    n = 2;
                    break Label_0149;
                }
                case -555573285: {
                    if (!s.equals((Object)"Medium Exp Scroll")) {
                        break;
                    }
                    n = 1;
                    break Label_0149;
                }
                case -1764478260: {
                    if (!s.equals((Object)"Massive Exp Scroll")) {
                        break;
                    }
                    n = 0;
                    break Label_0149;
                }
            }
            n = -1;
        }
        long n2 = 0L;
        switch (n) {
            default: {
                n2 = 0L;
                break;
            }
            case 4: {
                n2 = (long)this.activity.scrollExps.get(1);
                break;
            }
            case 3: {
                n2 = (long)this.activity.scrollExps.get(3);
                break;
            }
            case 2: {
                n2 = (long)this.activity.scrollExps.get(0);
                break;
            }
            case 1: {
                n2 = (long)this.activity.scrollExps.get(2);
                break;
            }
            case 0: {
                n2 = 100000L;
                break;
            }
        }
        this.activity.LoadItemSelect("Use your " + s);
        for (int i = 0; i < this.activity.skills.size(); ++i) {
            if (!(boolean)this.activity.membersSkill.get(i) || this.activity.members) {
                final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                textView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099991)));
                textView.setGravity(16);
                final StringBuilder append = new StringBuilder().append((String)this.activity.skills.get(i)).append(" (Level ");
                final MainActivity activity = this.activity;
                final StringBuilder append2 = append.append(activity.GetSkillLevel((String)activity.skills.get(i))).append(") (+");
                final MainActivity activity2 = this.activity;
                textView.setText((CharSequence)append2.append(activity2.FormatExp(activity2.GetSkillLevel((String)activity2.skills.get(i)) * n2)).append(" exp)").toString());
                final MainActivity activity3 = this.activity;
                activity3.SetTextSize(textView, activity3.GetResource(2131099669));
                textView.setTextColor(this.activity.GetColour(2131034225));
                textView.setPadding(this.activity.GetResource(2131099658), 0, this.activity.GetResource(2131099658), 0);
                this.activity.itemSelect_wrap.addView((View)textView);
                final MainActivity activity4 = this.activity;
                textView.setOnClickListener((View$OnClickListener)new ItemManager$$ExternalSyntheticLambda23(this, i, Math.min(activity4.GetSkillLevel((String)activity4.skills.get(i)), 99) * n2, s));
                final MainActivity activity5 = this.activity;
                activity5.AddBorder((ViewGroup)activity5.itemSelect_wrap);
            }
        }
    }
    
    public boolean isScrollUnlocked(final String s) {
        return (boolean)this.skillingScrolls.getUnlocked().get(this.skillingScrolls.getMethod().indexOf((Object)s));
    }
    
    public boolean isSkillingScroll(final String s) {
        return this.skillingScrolls.getMethod().contains((Object)s);
    }
    
    public static class Blessings
    {
        long blessingsMade;
        long tickets;
        
        public Blessings(final long tickets, final long blessingsMade) {
            this.tickets = tickets;
            this.blessingsMade = blessingsMade;
        }
        
        public long getBlessingsMade() {
            return this.blessingsMade;
        }
        
        public long getTickets() {
            return this.tickets;
        }
    }
    
    public static class Enhancement
    {
        String description;
        String item;
        String requirement;
        long tickets;
        
        public Enhancement(final String item, final String requirement, final String description, final long tickets) {
            this.item = item;
            this.requirement = requirement;
            this.description = description;
            this.tickets = tickets;
        }
        
        public String getDescription() {
            return this.description;
        }
        
        public String getItem() {
            return this.item;
        }
        
        public String getRequirement() {
            return this.requirement;
        }
        
        public long getTickets() {
            return this.tickets;
        }
    }
    
    public static class EnhancementTier
    {
        String baseItem;
        List<Enhancement> itemTiers;
        
        public EnhancementTier(final String baseItem, final List<Enhancement> itemTiers) {
            this.baseItem = baseItem;
            this.itemTiers = itemTiers;
        }
        
        public String getBaseItem() {
            return this.baseItem;
        }
        
        public List<Enhancement> getItemTiers() {
            return this.itemTiers;
        }
    }
    
    public static class Item
    {
        long amount;
        int inventoryId;
        boolean locked;
        String name;
        
        public Item(final String name, final long amount, final boolean locked, final int inventoryId) {
            this.name = name;
            this.amount = amount;
            this.locked = locked;
            this.inventoryId = inventoryId;
        }
        
        public long getAmount() {
            return this.amount;
        }
        
        public int getInventoryId() {
            return this.inventoryId;
        }
        
        public String getName() {
            return this.name;
        }
        
        public boolean isLocked() {
            return this.locked;
        }
    }
    
    public static class SecretRare
    {
        int droprate;
        List<String> equipmentNeeded;
        String method;
        String name;
        String skill;
        
        public SecretRare(final String name, final int droprate, final String method, final String skill, final List<String> equipmentNeeded) {
            this.name = name;
            this.method = method;
            this.droprate = droprate;
            this.skill = skill;
            this.equipmentNeeded = equipmentNeeded;
        }
        
        public int getDropRate() {
            return this.droprate;
        }
        
        public List<String> getEquipmentNeeded() {
            return this.equipmentNeeded;
        }
        
        public String getMethod() {
            return this.method;
        }
        
        public String getName() {
            return this.name;
        }
        
        public String getSkill() {
            return this.skill;
        }
    }
    
    public static class SkillingScrolls
    {
        List<String> method;
        List<String> scrolls;
        List<String> skills;
        List<Boolean> unlocked;
        
        public SkillingScrolls(final List<String> skills, final List<String> scrolls, final List<String> method, final List<Boolean> unlocked) {
            this.method = method;
            this.scrolls = scrolls;
            this.skills = skills;
            this.unlocked = unlocked;
        }
        
        public List<String> getMethod() {
            return this.method;
        }
        
        public List<String> getScrolls() {
            return this.scrolls;
        }
        
        public List<String> getSkills() {
            return this.skills;
        }
        
        public List<Boolean> getUnlocked() {
            return this.unlocked;
        }
    }
}
