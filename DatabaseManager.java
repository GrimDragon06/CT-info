package uk.playdrop.cherrytree_idletextrpg;

import android.os.Handler;
import android.os.Looper;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.content.Intent;
import com.google.firebase.firestore.FirebaseFirestoreException$Code;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import android.text.SpannableString;
import com.google.firebase.firestore.QuerySnapshot;
import com.android.billingclient.api.Purchase;
import android.net.Network;
import android.net.ConnectivityManager$NetworkCallback;
import android.net.ConnectivityManager;
import android.view.ViewStub;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.database.ServerValue;
import java.text.SimpleDateFormat;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import java.util.Locale;
import android.os.CountDownTimer;
import com.google.firebase.database.Query;
import java.util.function.Predicate;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;
import java.util.Map;
import java.util.HashMap;
import com.google.firebase.firestore.DocumentSnapshot;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import android.widget.ImageView;
import java.util.Iterator;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import com.google.firebase.auth.PlayGamesAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.database.DatabaseError;
import android.view.View;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Objects;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.database.DatabaseReference;
import java.util.Date;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.EditText;
import com.google.firebase.firestore.FirebaseFirestore;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.auth.AuthCredential;
import java.util.List;

public class DatabaseManager
{
    String activeDisplayName;
    MainActivity activity;
    List<Trade> allTrades;
    AuthCredential authCredential;
    boolean banned;
    List<String> bannedUsers;
    List<String> bigWishDescriptions;
    List<Integer> bigWishIcons;
    List<Integer> bigWishMaxLevels;
    List<String> bigWishNames;
    List<String> bigWishRarities;
    boolean canTrade;
    TextView chancesRemaining;
    TextView changeWell;
    List<String> checkedUsers;
    boolean claimedDonationBin;
    TextView codeResult;
    boolean collecting;
    List<Wish> commonBigWishes;
    List<Wish> commonWishes;
    CommunityVault communityVault;
    ScrollView communityVaultScreen;
    boolean connected;
    Currencies currencies;
    String currentGodsRotation;
    LinearLayout currentGuessNumbers;
    RelativeLayout currentRequest;
    LinearLayout currentReward;
    FirebaseFirestore db;
    EditText donationAmount;
    TextView donationNotice;
    boolean doubleCasketsAvailable;
    List<Wish> epicBigWishes;
    List<Wish> epicWishes;
    String eventType;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser firebaseUser;
    boolean freePremiumAvailable;
    TextView getMoreChances;
    List<String> hiddenSecrets;
    List<Integer> hiddenSecrets_dropRate;
    List<List<String>> hiddenSecrets_equipment;
    List<String> hiddenSecrets_method;
    List<String> hiddenSecrets_skill;
    LinearLayout increaseNumbers;
    long lastDonation;
    long lastRefresh;
    int latestVersion;
    List<Wish> legendaryBigWishes;
    List<Wish> legendaryWishes;
    List<String> limitedItems;
    List<Long> limitedItems_limit;
    LinearLayout lowerNumbers;
    int maxDailyTrades;
    long maxDonation;
    RelativeLayout milestoneReward;
    List<String> mods;
    List<Wish> myBigWishes;
    TextView myDonations;
    List<Wish> myWishes;
    List<OfferCode> offerCodes;
    TextView openButton;
    List<Wish> rareBigWishes;
    List<Wish> rareWishes;
    Referrals referrals;
    TextView refreshProgress;
    List<String> rewardCurrencies;
    String sendItem;
    List<Trade> sentTrades;
    TextView serverConnecting;
    Date serverDate;
    long serverTime;
    long totalDonations;
    long tradeCooldown;
    DatabaseReference tradeRef;
    ScrollView tradeScreen;
    long tradeTimeout;
    int tradesSent;
    LinearLayout ts_activeGifts;
    LinearLayout ts_activeTrades;
    TextView ts_adminSend;
    TextView ts_itemSend;
    EditText ts_itemSendAmount;
    EditText ts_playername;
    TextView ts_reloadtrades;
    TextView ts_sendFriend;
    TextView ts_sendrequest;
    LinearLayout ts_sentItems;
    TextView ts_setMax;
    TextView ts_tradeLimit;
    TextView ts_username;
    List<String> untradableItems;
    int vaultChances;
    VaultCode vaultCode;
    List<String> vaultCodesChecked;
    List<String> vaultCodesClaimed;
    String vaultDocId;
    TextView vaultDonate;
    ScrollView vaultScreen;
    int versionCode;
    String weeklySkill;
    List<String> wishDescriptions;
    List<Integer> wishIcons;
    List<Integer> wishMaxLevels;
    List<String> wishNames;
    List<String> wishRarities;
    ConstraintLayout wishScreen;
    List<String> wishViewNames;
    List<LinearLayout> wishViews;
    LinearLayout wishes_common;
    LinearLayout wishes_epic;
    LinearLayout wishes_legendary;
    LinearLayout wishes_new;
    LinearLayout wishes_rare;
    
    public DatabaseManager(final MainActivity activity) {
        this.eventType = "";
        this.db = null;
        this.offerCodes = (List<OfferCode>)new ArrayList();
        this.vaultCode = null;
        final Integer value = 10;
        this.vaultChances = 10;
        this.vaultDocId = "";
        this.vaultCodesClaimed = (List<String>)new ArrayList();
        this.rewardCurrencies = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Challenge Coins", "Coins", "Gold Coin", "Killcoins", "Event Currency" }));
        this.wishNames = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Attack", "Strength", "Defence", "Global Exp", "Golden Touch", "Secrets", "Trader", "Miner", "Fisher", "Lumberjack", "Thief", "Silver Fish", "Silver Trees", "Idle Please", "Killcoins", "Pet Hunter", "Archery Damage", "Treasure Hunter", "Fletcher" }));
        this.wishDescriptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Boosts Attack Stat by 15 per level", "Boosts Strength Stat by 15 per level", "Boosts Defence Stat by 15 per level", "Gives a global exp bonus of 0.5% per level", "Increases Rate of Golden Touch Potions by 0.25% per level", "Increases chance of finding Secret Rares by 1% per level", "Increases sell value of all items by 1% per level", "Speeds up Mining by 0.1s per level (Minimum 1s)", "Speeds up Fishing by 0.1s per level (Minimum 1s)", "Speeds up Forestry by 0.1s per level (Minimum 1s)", "Increases Thieving success by 1% per level (Max of 100%)", "Gives a 5% chance to find 100 Silver per level while Fishing", "Gives a 5% chance to find 100 Silver per level while Chopping Trees", "Increases max offline timer by 15 minutes per level", "Increases the killcoins from Slayer Tasks by 5% per level", "Increases the chance to find pets by 20% per level", "Gives an Archery damage bonus of 2 per level", "Increases the chance to find Treasure Scrolls by 1% per level", "Grants a 1% chance per level of Fletching double items" }));
        this.wishIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131166468, 2131166480, 2131166471, 2131166321, 2131165884, 2131166150, 2131166220, 2131166478, 2131166475, 2131166476, 2131166481, 2131166114, 2131166340, 2131165766, 2131165924, 2131166446, 2131166482, 2131166315, 2131165938 }));
        final Integer value2 = 50;
        this.wishMaxLevels = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 150, 150, 150, 500, value2, 40, 100, value2, value2, value2, value2, value2, value2, 100, value2, 20, 250, 40, value2 }));
        this.wishRarities = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Common", "Common", "Common", "Rare", "Legendary", "Legendary", "Common", "Rare", "Rare", "Rare", "Rare", "Epic", "Epic", "Legendary", "Epic", "Legendary", "Common", "Legendary", "Epic" }));
        this.myWishes = (List<Wish>)new ArrayList();
        this.wishViewNames = (List<String>)new ArrayList();
        this.wishViews = (List<LinearLayout>)new ArrayList();
        this.commonWishes = (List<Wish>)new ArrayList();
        this.rareWishes = (List<Wish>)new ArrayList();
        this.epicWishes = (List<Wish>)new ArrayList();
        this.legendaryWishes = (List<Wish>)new ArrayList();
        this.bigWishNames = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Archery", "Melee", "Ticket Rain", "Golden Rain", "Event Mayhem", "Scroll Solver", "Soul Reaper", "Path Hunter", "Cocktail Craze", "Golden Ticket", "Navigator", "Master Thief", "Speed Please", "No more Scrolls", "Boosty McBoost" }));
        this.bigWishDescriptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Boosts Archery Damage by 1% per level", "Boosts Melee Damage by 1% per level", "Grants a 0.1% chance per level to find an Enhancement Ticket every minute while skilling", "Grants a 2% chance per level to find between 100 and 1m Gold every 40 seconds while skilling", "Awards Event Currency (5 per level) every 20 seconds during Events", "Grants a 1% chance per level for each Treasure Scroll solved to count as 2", "Grants a 0.1% chance per level when finding Soul Gems to also find a Soul Reaper Fragment", "Increases the chance to find Secret Pathway levels by 2% per level", "Increases the daily cap of Summer Cocktails by 20 per level", "Grants a 1% chance per level to find a Golden Ticket when levelling the Secret Pathway (Doesn't work when skipping levels)", "1% chance per level to reveal the next direction during Exploration", "1% chance per level to completely crack a safe upon breaking a lock (Doesn't work on the first lock)", "Increases attack speed by 1% per level when using Melee", "Grants a 2% chance per level to automatically complete Treasure Scrolls when found (counts towards no-life)", "Increases the duration of boosts by 30 seconds per level" }));
        this.bigWishIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131166482, 2131166480, 2131165610, 2131165871, 2131165563, 2131166315, 2131166239, 2131165520, 2131166274, 2131165478, 2131166472, 2131166481, 2131166468, 2131166048, 2131165766 }));
        this.bigWishMaxLevels = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 25, value2, 20, value2, 30, value2, 25, 25, value, value, 20, value, 40, 20, 30 }));
        this.bigWishRarities = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Common", "Common", "Legendary", "Epic", "Rare", "Common", "Legendary", "Legendary", "Epic", "Rare", "Rare", "Epic", "Common", "Legendary", "Rare" }));
        this.myBigWishes = (List<Wish>)new ArrayList();
        this.commonBigWishes = (List<Wish>)new ArrayList();
        this.rareBigWishes = (List<Wish>)new ArrayList();
        this.epicBigWishes = (List<Wish>)new ArrayList();
        this.legendaryBigWishes = (List<Wish>)new ArrayList();
        this.allTrades = (List<Trade>)new ArrayList();
        this.sentTrades = (List<Trade>)new ArrayList();
        this.canTrade = true;
        this.tradeTimeout = 20000L;
        this.tradeCooldown = 0L;
        this.checkedUsers = (List<String>)new ArrayList();
        this.connected = true;
        this.collecting = false;
        this.maxDailyTrades = 50;
        this.tradesSent = 0;
        this.bannedUsers = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "QuestYur", "QuestYor", "AbyssalRin", "gvt55", "gvt7", "gvt1ssc", "EvenTent75", "ZeMPik", "zekani", "RefinedInspiration81", "Rin4Lord", "gvt3ssc", "RamblingRaven45207", "LimitTaeyeon", "ModernistBacking73", "WreckingSting75", "Valaryian666" }));
        this.untradableItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Golden Touch Potion", "Mini Exp Scroll", "Small Exp Scroll", "Medium Exp Scroll", "Large Exp Scroll", "Massive Exp Scroll", "Attack Cape", "Strength Cape", "Defence Cape", "Health Cape", "Slayer Cape", "Fishing Cape", "Discovery Cape", "Alchemy Cape", "Farming Cape", "Crafting Cape", "Cooking Cape", "Thieving Cape", "Mining Cape", "Max Cape", "Mini Max Cape", "Completion Cape", "Supporters Crown", "Crown of the Invested", "Eternal Berserker Ring", "Ultra Comp Cape", "No Life Cape", "Apprentice Gloves", "Apprentice Boots", "Apprentice Legs", "Apprentice Helm", "Master Top", "Master Gloves", "Master Boots", "Master Legs", "Master Helm", "Primal Top", "Primal Gloves", "Primal Boots", "Primal Legs", "Primal Helm", "Soul Thread", "Soul Gem", "Blessed Eternal Sacrifice", "Divine Protection Potion", "Pumpkin Pie", "Black Partyhat", "Blue Partyhat", "Cog Partyhat", "Pink Partyhat", "Red Partyhat", "White Partyhat", "Yellow Partyhat", "Wooden Partyhat", "Enhancement Ticket", "Apprentice Sword", "Master Sword", "Primal Sword", "Scythe of Noctyra", "Dark Thread", "Christmas Cracker", "Dark Elven Helm", "Dark Elven Gloves", "Dark Elven Boots", "Dark Elven Greaves", "Dark Elven Plate", "Dark Elven Sword", "Snowflake Partyhat", "Soul Reaper Potion", "Ring of Secrets", "Fragment of Secrets 1", "Fragment of Secrets 2", "Fragment of Secrets 3", "Fragment of Secrets 4", "Soul Reaper Fragment", "Yellow Roses", "White Roses", "Red Roses", "Pink Roses", "Sword of Friendship", "Shield of Friendship", "Bow of Friendship", "Golden Ticket", "Summer Cocktail", "Golden Hatchet", "Golden Fishing Rod", "Birthday Crown", "Balloon Bow", "Candle Arrows", "Golden Pickaxe", "Dragon Tail Feather", "Shadow Bowstring", "Shadow Staff Tip", "Shadow Staff Base", "Shadow Staff Handle", "Shadow Lantern Handle", "Shadow Lantern Gem", "Shadow Lantern Base", "Staff of the Shadows", "Shadow Cloak", "Shadow Greaves", "Shadow Hood", "Shadow Gloves", "Shadow Boots", "Unstrung Shadow Bow", "Bow of the Shadows", "Shadow Arrowheads", "Shadow Lantern", "Darkstar Bar", "Darkstar Arrowheads", "Sandalwood Arrow Shafts", "Headless Sandalwood Arrows", "Shadow Arrows", "Darkstar Arrows", "Golden Compass", "Loyalty Crown I", "Fragment of the Gods I", "Fragment of the Gods II", "Fragment of the Gods III", "Fragment of the Gods IV", "Necklace of the Gods", "Golden Scythe", "Black Roses", "Golden Thieving Gloves", "Golden Halo", "Hot Chocolate", "Fairy Light Whip", "Santa Disguise", "Pink Christmas Jumper", "Green Christmas Jumper", "Blue Christmas Jumper", "Krampus Horns", "Krampus Jacket", "Krampus Legs", "Snowflake Top", "Snowflake Legs", "Christmas Socks", "Sack of Presents", "Hollybranch Bow", "Mistletoe Arrows", "Santas Mittens", "Wreath Necklace", "Christmas Pantaloons", "Sweet Potato", "Sweet Potato Pie", "Cherry Bomb Potion" }));
        this.limitedItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Eternal Ring", "Sword of Feroxi", "Bow of Kynosian", "Hatchet of Copina", "Pickaxe of Copina", "Rod of Copina", "Opulinas Robe Top", "Opulinas Robe Bottoms", "Shield of Feroxi", "Quiver of Kynosian", "Scythe of Aurial", "Shield of Amaran", "Boots of Feroxi", "Gloves of Feroxi", "Plate of Feroxi", "Helm of Feroxi", "Greaves of Feroxi", "Knife of Copina", "Kynosian Boots", "Kynosian Gloves", "Kynosian Top", "Kynosian Hat", "Kynosian Legs", "Sword of Cognium", "Death Princess Rune", "Cognium Ring", "Mystic Staff", "Ancient Elven Book", "Necklace of Restoration", "Chefs Hat", "Pickaxe of the Gods", "Ring of Death", "Ring of Life", "Ring of Speed", "Elven Crystal", "Kynosian Arrows", "Elven Weapon Fragment", "Elven Arrows", "Elven Armour Fragment", "Blessed Sacrifice", "Blessed Eternal Sacrifice", "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Black Partyhat", "Blue Partyhat", "Cog Partyhat", "Pink Partyhat", "Red Partyhat", "White Partyhat", "Yellow Partyhat", "Berserker Ring", "Illuminant Gem", "Wooden Partyhat", "Ring Fragments", "Necklace of Amaran", "Ghostly Cloak", "Ghostly Top", "Ghostly Legs", "Ghostly Hood", "Staff of Skulls", "Pumpkin Pie Recipe Scroll", "Skull Shield", "Divine Protection Potion", "Divine Protection Scroll", "Gold Coin", "Pumpkin Pie", "Enhancement Ticket", "Old Fishing Rod", "Energy Overload Scroll", "Christmas Cracker", "Golden Cracker", "Blue Santa Hat", "Snowflake Partyhat", "Candy Cane Scythe", "Crown of Opulina", "Lockpick of Copina", "Stethoscope of Copina", "Ring of Souls", "Scythe of Noctyra", "Fragment of Secrets 2", "Fragment of Secrets 3", "Fragment of Secrets 4", "Soul Reaper Sword", "Box of Chocolates", "Teddy Bear", "Wings of Cognium", "Yellow Roses", "White Roses", "Red Roses", "Pink Roses", "Barbecue Skythe", "Apron of Banshen", "Rusty Pickaxe", "Rusty Hatchet", "Magnet of Copina", "Fishing Boots", "Fishing Gloves", "Fishing Hat", "Fishing Top", "Fishing Waders", "Lumberjack Boots", "Lumberjack Gloves", "Lumberjack Top", "Lumberjack Hat", "Lumberjack Legs", "Miners Boots", "Miners Gloves", "Miners Top", "Miners Hat", "Miners Legs", "Thief Boots", "Thief Gloves", "Thief Top", "Thief Hood", "Thief Legs", "Easter Egg", "Eggstravagant Bow", "Easter Bonnet", "Pumpkin Seed Scroll", "Bow of Eggcellence", "Sword of Eggcellence", "Egg Arrows", "Golden Egg", "Sword of Friendship", "Shield of Friendship", "Bow of Friendship", "Summer Cocktail Recipe", "Golden Sunglasses", "Metal Detector", "Oven Gloves", "Pink Sunglasses", "Beach Parasol", "Birthday Present", "Birthday Crown", "Party Balloons", "Balloon Bow", "Candle Arrows", "Golden Pickaxe", "Clown Mask", "Clown Top", "Clown Leggings", "Sandalwood Log", "Darkstar Ore", "Darkstar Bar", "Shadow Arrowheads", "Darkstar Arrowheads", "Darkstar Arrows", "Shadow Arrows", "Shadow Weapon Fragment", "Shadow Armour Fragment", "Sandalwood Arrow Shafts", "Headless Sandalwood Arrows", "Christmas Stocking", "Diary of May", "Pumpkin Lantern", "Pumpkin Cauldron", "Spider Necklace", "Rainbow Santa Hat" }));
        final Long value3 = 1L;
        final Long value4 = 1000L;
        this.limitedItems_limit = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, 5L, 5L, 5L, 5L, 50L, 50L, 50L, 25000L, 5000L, 10000L, 25000L, 10000L, 20L, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, 5L, 5L, value3, value4, value3, value3, value3, value3, value3, value3, 5L, value3, value3, value3, 25000000L, value3, 10L, 100L, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, 10L, value3, value3, value3, value3, value3, value3, value3, value3, 5L, 5L, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, 250L, value3, value3, value3, value3, value3, value4, 50L, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value3, value4, value3, value3, value3, value3, value4, value4, value4, value4, value4, value4, value4, 100L, 100L, value4, value4, 500L, value3, value3, value3, value3, value3 }));
        this.banned = false;
        this.freePremiumAvailable = false;
        this.doubleCasketsAvailable = false;
        this.hiddenSecrets = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Fragment of Secrets 2", "Fragment of Secrets 3", "Fragment of Secrets 4", "Rod of Copina", "Pickaxe of Copina", "Hatchet of Copina", "Apron of Banshen" }));
        this.hiddenSecrets_equipment = (List<List<String>>)new ArrayList((Collection)Arrays.asList((Object[])new List[] { Arrays.asList((Object[])new String[] { "" }), Arrays.asList((Object[])new String[] { "Drakes Compass" }), Arrays.asList((Object[])new String[] { "Flame Gloves" }), Arrays.asList((Object[])new String[] { "Old Fishing Rod" }), Arrays.asList((Object[])new String[] { "Pickaxe of the Gods" }), Arrays.asList((Object[])new String[] { "Hatchet of the Gods" }), Arrays.asList((Object[])new String[] { "" }) }));
        this.hiddenSecrets_skill = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Caskets", "Thieving", "Farming", "Fishing", "Mining", "Forestry", "Cooking" }));
        this.hiddenSecrets_method = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Caskets", "Empyreon", "Magnolia Seed", "City River", "Silver Ore", "Spruce Tree", "Fish Steak" }));
        this.hiddenSecrets_dropRate = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 25000, 20000, 100000, 1200000, 1200000, 1200000, 450000 }));
        this.latestVersion = 467;
        this.versionCode = 467;
        this.totalDonations = 0L;
        this.maxDonation = 0L;
        this.currentGodsRotation = "";
        this.claimedDonationBin = false;
        this.lastRefresh = 0L;
        this.lastDonation = 0L;
        this.vaultCodesChecked = (List<String>)new ArrayList();
        this.weeklySkill = "";
        this.activeDisplayName = "";
        this.sendItem = "";
        this.serverTime = 0L;
        this.mods = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "banshen", "FoxesGoAhhh", "PlaydropUK", "Ace12444", "sunshiinejay" }));
        this.activity = activity;
        this.CreateSecrets();
    }
    
    private void AddCheckedUser(final String s) {
        if (!this.checkedUsers.contains((Object)s)) {
            this.checkedUsers.add((Object)s);
        }
    }
    
    private String AddSuffix(final String s) {
        final int int1 = Integer.parseInt(s);
        Label_0073: {
            if (int1 != 1) {
                Label_0066: {
                    if (int1 != 2) {
                        if (int1 != 3) {
                            if (int1 == 31) {
                                break Label_0073;
                            }
                            switch (int1) {
                                default: {
                                    final String s2 = "th";
                                    return s + "" + s2;
                                }
                                case 23: {
                                    break;
                                }
                                case 22: {
                                    break Label_0066;
                                }
                                case 21: {
                                    break Label_0073;
                                }
                            }
                        }
                        final String s2 = "rd";
                        return s + "" + s2;
                    }
                }
                final String s2 = "nd";
                return s + "" + s2;
            }
        }
        final String s2 = "st";
        return s + "" + s2;
    }
    
    private void AddTradeCounter() {
        ++this.tradesSent;
        this.ts_tradeLimit.setText((CharSequence)("You have " + (this.maxDailyTrades - this.tradesSent) + " trades remaining today"));
        final DatabaseReference child = this.firebaseDatabase.getReference("tradelimits").child((String)Objects.requireNonNull((Object)this.firebaseUser.getDisplayName()));
        child.get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda44(this, child)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda55(this));
    }
    
    private boolean AllowedTrade() {
        final FirebaseUser firebaseUser = this.firebaseUser;
        boolean b = false;
        if (firebaseUser == null) {
            return false;
        }
        if (firebaseUser.getDisplayName() == null) {
            return false;
        }
        if (this.serverDate == null) {
            return false;
        }
        if (this.firebaseUser.getMetadata() == null) {
            return false;
        }
        if (TimeUnit.MILLISECONDS.toDays(this.serverDate.getTime() - new Date(this.firebaseUser.getMetadata().getCreationTimestamp()).getTime()) >= 2L) {
            b = true;
        }
        return b;
    }
    
    private boolean CanSend(final String s, final Long n) {
        final boolean contains = this.untradableItems.contains((Object)s);
        boolean b2;
        final boolean b = b2 = false;
        if (!contains) {
            if (s.contains((CharSequence)"(E)")) {
                b2 = b;
            }
            else {
                if (this.limitedItems.contains((Object)s)) {
                    final int index = this.limitedItems.indexOf((Object)s);
                    if (n > (long)this.limitedItems_limit.get(index)) {
                        this.activity.LargePopup(2131166497, "Error", "You can only send a max of " + this.activity.FormatExp((long)this.limitedItems_limit.get(index)) + " of this item per trade.");
                        b2 = b;
                        return b2;
                    }
                }
                b2 = true;
            }
        }
        return b2;
    }
    
    private void CheckBan() {
        final FirebaseUser firebaseUser = this.firebaseUser;
        if (firebaseUser == null) {
            return;
        }
        if (firebaseUser.getDisplayName() == null) {
            return;
        }
        if (!this.activity.gpSignedIn) {
            return;
        }
        if (this.activity.playGamesUser == null) {
            return;
        }
        if (this.activity.playerId == null) {
            return;
        }
        if (this.activity.playerId.isEmpty()) {
            return;
        }
        final String displayName = this.firebaseUser.getDisplayName();
        this.db.collection("bannedusers").document(displayName).get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda100(this, displayName));
    }
    
    private void CheckDailyEvent(final String s) {
        this.firebaseDatabase.getReference().child("dailybunnygifts").child(s).get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda42(this));
    }
    
    private void CheckDailyGifts() {
        if (this.serverDate == null) {
            return;
        }
        if (!this.activity.avatarNames.contains((Object)"Santa")) {
            return;
        }
        final Calendar instance = Calendar.getInstance();
        instance.setTime(this.serverDate);
        final int value = instance.get(5);
        final int value2 = instance.get(2);
        if (value == 25 && value2 == 11 && !this.activity.myProfileAvatars.contains((Object)this.activity.avatarNames.indexOf((Object)"Santa"))) {
            this.activity.runOnUiThread((Runnable)new DatabaseManager$$ExternalSyntheticLambda80(this));
        }
    }
    
    private void CheckIncomingTrade(final DataSnapshot dataSnapshot) {
        final Trade trade = new Trade(dataSnapshot.getKey(), (String)dataSnapshot.child("sender").getValue((Class)String.class), (String)dataSnapshot.child("recipient").getValue((Class)String.class), (String)dataSnapshot.child("item").getValue((Class)String.class), (String)dataSnapshot.child("amount").getValue((Class)String.class), (String)dataSnapshot.child("date").getValue((Class)String.class));
        if (Long.parseLong(trade.getItemAmount()) == 0L) {
            this.DestroyTrade(trade);
            return;
        }
        if (!this.untradableItems.contains((Object)trade.getItem())) {
            if (this.limitedItems.contains((Object)trade.getItem())) {
                if (Long.parseLong(trade.getItemAmount()) <= (long)this.limitedItems_limit.get(this.limitedItems.indexOf((Object)trade.getItem()))) {
                    this.ReceivedTrade(trade);
                }
                else if (this.mods.contains((Object)trade.getSender().trim())) {
                    this.ReceivedTrade(trade);
                }
                else {
                    this.DestroyTrade(trade);
                }
            }
            else {
                this.ReceivedTrade(trade);
            }
        }
        else if (this.mods.contains((Object)trade.getSender().trim())) {
            this.ReceivedTrade(trade);
        }
        else {
            this.DestroyTrade(trade);
        }
    }
    
    private void CheckTradeExists(final Trade trade, final ConstraintLayout constraintLayout, final LinearLayout linearLayout) {
        this.tradeRef.child(trade.getId()).addListenerForSingleValueEvent((ValueEventListener)new ValueEventListener(this, trade, constraintLayout, linearLayout) {
            final DatabaseManager this$0;
            final LinearLayout val$parent;
            final ConstraintLayout val$rel;
            final Trade val$trade;
            
            public void onCancelled(final DatabaseError databaseError) {
                this.this$0.activity.runOnUiThread((Runnable)new DatabaseManager$8$$ExternalSyntheticLambda1(this));
            }
            
            public void onDataChange(final DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    this.this$0.CollectTrade(this.val$trade, this.val$rel);
                }
                else {
                    this.this$0.activity.runOnUiThread((Runnable)new DatabaseManager$8$$ExternalSyntheticLambda0(this, this.val$trade, this.val$parent, this.val$rel));
                }
            }
        });
    }
    
    private void ClaimRewards() {
        if (this.firebaseUser.getDisplayName() != null) {
            this.db.collection("donors").document(this.firebaseUser.getDisplayName()).update("claimed", (Object)true, new Object[0]).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda96(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda97(this));
        }
        else {
            this.activity.runOnUiThread((Runnable)new DatabaseManager$$ExternalSyntheticLambda98(this));
        }
    }
    
    private void CollectSpecialTrade(final Trade trade, final ConstraintLayout constraintLayout) {
        final String[] split = trade.getItem().split("\\s*#\\s*");
        int n = 0;
        final String s = split[0];
        s.hashCode();
        Label_0148: {
            switch (s.hashCode()) {
                case 1972874617: {
                    if (!s.equals((Object)"Avatar")) {
                        break;
                    }
                    n = 3;
                    break Label_0148;
                }
                case 80818744: {
                    if (!s.equals((Object)"Title")) {
                        break;
                    }
                    n = 2;
                    break Label_0148;
                }
                case 72499381: {
                    if (!s.equals((Object)"Kills")) {
                        break;
                    }
                    n = 1;
                    break Label_0148;
                }
                case 80127: {
                    if (!s.equals((Object)"Pet")) {
                        break;
                    }
                    break Label_0148;
                }
            }
            n = -1;
        }
        switch (n) {
            case 3: {
                if (this.activity.avatarNames.contains((Object)split[1])) {
                    this.activity.GiveAvatar(split[1]);
                    break;
                }
                break;
            }
            case 2: {
                if (!this.activity.myTitles.contains((Object)split[1])) {
                    this.activity.myTitles.add((Object)split[1]);
                    this.activity.LargePopup(2131165520, "Congratulations", "You unlocked the title: " + split[1] + "!");
                    break;
                }
                break;
            }
            case 1: {
                final String s2 = split[1];
                final int index = this.activity.combatManager.enemyNames.indexOf((Object)s2);
                this.activity.accountStats.getAllMonsterKills().set(index, (Object)((long)this.activity.accountStats.getAllMonsterKills().get(index) + Long.parseLong(trade.getItemAmount())));
                this.activity.LargePopup(2131166505, "Congratulations", "You received " + this.activity.FormatExp(Long.parseLong(trade.getItemAmount())) + "x " + s2 + " Kills!");
                break;
            }
            case 0: {
                if (!this.activity.myPets.contains((Object)split[1])) {
                    this.activity.myPets.add((Object)split[1]);
                    this.activity.LargePopup(2131166488, "Congratulations", "You received the Pet: " + split[1]);
                    break;
                }
                break;
            }
        }
        this.RemoveTrade(trade.getId());
        this.ts_activeTrades.removeView((View)constraintLayout);
    }
    
    private void CollectTrade(final Trade trade, final ConstraintLayout constraintLayout) {
        this.tradeRef.child(trade.getId()).removeValue().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda11(this, trade, constraintLayout)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda22(this));
    }
    
    private void CompleteDonation(final long n) {
        final DocumentReference document = this.db.collection("donations").document("ei3Ld9yTI90JxKV3PArE");
        document.get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda140(this, document, n)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda141(this));
    }
    
    private void CompleteSignIn() {
        if (this.authCredential == null) {
            this.authCredential = PlayGamesAuthProvider.getCredential(this.activity.userAuth);
        }
        this.firebaseAuth.signInWithCredential(this.authCredential).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda133(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda134(this));
    }
    
    private void CrackVault() {
        final StringBuilder sb = new StringBuilder();
        final ArrayList list = new ArrayList();
        final int n = 0;
        for (int i = 0; i < this.currentGuessNumbers.getChildCount(); ++i) {
            sb.append(((TextView)this.currentGuessNumbers.getChildAt(i)).getText().toString());
            ((List)list).add((Object)((TextView)this.currentGuessNumbers.getChildAt(i)).getText().toString());
        }
        final String string = sb.toString();
        if (this.vaultCodesChecked.contains((Object)string)) {
            this.activity.QuickPopup("You have already checked this code");
        }
        else {
            this.vaultCodesChecked.add((Object)string);
            if (this.vaultCode.getCode().equals((Object)string)) {
                if (!this.rewardCurrencies.contains((Object)this.vaultCode.getReward())) {
                    if (this.activity.InventoryNotFull(this.vaultCode.getReward())) {
                        this.vaultCodesClaimed.add((Object)this.vaultCode.getCode());
                        this.openButton.setAlpha(0.4f);
                        this.openButton.setText((CharSequence)"Cracked");
                        this.codeResult.setText((CharSequence)"Congratulations you cracked the vault!");
                        this.VaultReward();
                    }
                    else {
                        this.codeResult.setText((CharSequence)"The code is correct, but your inventory is full, clear some space, then return!");
                    }
                }
                else {
                    this.vaultCodesClaimed.add((Object)this.vaultCode.getCode());
                    this.openButton.setAlpha(0.4f);
                    this.openButton.setText((CharSequence)"Cracked");
                    this.codeResult.setText((CharSequence)"Congratulations you cracked the vault!");
                    this.VaultReward();
                }
            }
            else {
                --this.vaultChances;
                this.chancesRemaining.setText((CharSequence)("Chances Remaining: " + this.vaultChances));
                final ArrayList list2 = new ArrayList();
                for (int j = n; j < ((List)list).size(); ++j) {
                    if (this.vaultCode.getCode().contains((CharSequence)((List)list).get(j)) && !((List)list2).contains(((List)list).get(j))) {
                        ((List)list2).add((Object)((List)list).get(j));
                    }
                }
                if (((List)list2).size() == 1) {
                    this.activity.QuickPopup(((List)list2).size() + " of the numbers is in the sequence.");
                }
                else {
                    this.activity.QuickPopup(((List)list2).size() + " of the numbers are in the sequence.");
                }
            }
        }
    }
    
    private String CreateCode(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(s); ++i) {
            sb.append((new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" })[new Random().nextInt(10)]);
        }
        return sb.toString();
    }
    
    private void CreateSecrets() {
        for (int i = 0; i < this.hiddenSecrets.size(); ++i) {
            this.activity.itemManager.allSecretRares.add((Object)new ItemManager.SecretRare((String)this.hiddenSecrets.get(i), (int)this.hiddenSecrets_dropRate.get(i), (String)this.hiddenSecrets_method.get(i), (String)this.hiddenSecrets_skill.get(i), (List<String>)this.hiddenSecrets_equipment.get(i)));
        }
    }
    
    private void DestroyTrade(final Trade trade) {
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute((Runnable)new DatabaseManager$$ExternalSyntheticLambda18(this, trade));
        singleThreadExecutor.shutdown();
    }
    
    private void DonateVault(final String s) {
        final long long1 = Long.parseLong(s);
        if (this.totalDonations + long1 > this.maxDonation) {
            this.activity.QuickPopup("This donation will take you above the max donation allowed.");
        }
        else if (long1 > 0L && long1 < 2000000000L) {
            if (this.GotItem(long1)) {
                this.lastDonation = System.currentTimeMillis();
                this.ShowConnecting();
                final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
                singleThreadExecutor.execute((Runnable)new DatabaseManager$$ExternalSyntheticLambda10(this, long1));
                singleThreadExecutor.shutdown();
            }
            else {
                this.activity.QuickPopup("You don't have enough of the required item to donate!");
            }
        }
        else {
            this.activity.QuickPopup("Please enter a valid amount to donate between 0 and 2b.");
        }
    }
    
    private Wish FindWish(final String s, final String s2) {
        final ArrayList list = new ArrayList();
        final boolean equals = s2.equals((Object)"Beginner");
        int n = 3;
        final Wish wish = null;
        Wish wish2 = null;
        if (equals) {
            s.hashCode();
            Label_0149: {
                switch (s.hashCode()) {
                    case 2024019467: {
                        if (!s.equals((Object)"Common")) {
                            break;
                        }
                        break Label_0149;
                    }
                    case 2539714: {
                        if (!s.equals((Object)"Rare")) {
                            break;
                        }
                        n = 2;
                        break Label_0149;
                    }
                    case 2166565: {
                        if (!s.equals((Object)"Epic")) {
                            break;
                        }
                        n = 1;
                        break Label_0149;
                    }
                    case -77594853: {
                        if (!s.equals((Object)"Legendary")) {
                            break;
                        }
                        n = 0;
                        break Label_0149;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    wish2 = wish;
                    break;
                }
                case 3: {
                    ((List)list).addAll((Collection)this.commonWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator.next();
                    } while (wish2.getLevel() >= (int)this.wishMaxLevels.get(this.wishNames.indexOf((Object)wish2.getName())));
                    break;
                }
                case 2: {
                    ((List)list).addAll((Collection)this.rareWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator2 = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator2.next();
                    } while (wish2.getLevel() >= (int)this.wishMaxLevels.get(this.wishNames.indexOf((Object)wish2.getName())));
                    break;
                }
                case 1: {
                    ((List)list).addAll((Collection)this.epicWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator3 = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator3.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator3.next();
                    } while (wish2.getLevel() >= (int)this.wishMaxLevels.get(this.wishNames.indexOf((Object)wish2.getName())));
                    break;
                }
                case 0: {
                    ((List)list).addAll((Collection)this.legendaryWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator4 = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator4.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator4.next();
                    } while (wish2.getLevel() >= (int)this.wishMaxLevels.get(this.wishNames.indexOf((Object)wish2.getName())));
                    break;
                }
            }
        }
        else {
            s.hashCode();
            Label_0653: {
                switch (s.hashCode()) {
                    case 2024019467: {
                        if (!s.equals((Object)"Common")) {
                            break;
                        }
                        break Label_0653;
                    }
                    case 2539714: {
                        if (!s.equals((Object)"Rare")) {
                            break;
                        }
                        n = 2;
                        break Label_0653;
                    }
                    case 2166565: {
                        if (!s.equals((Object)"Epic")) {
                            break;
                        }
                        n = 1;
                        break Label_0653;
                    }
                    case -77594853: {
                        if (!s.equals((Object)"Legendary")) {
                            break;
                        }
                        n = 0;
                        break Label_0653;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    wish2 = wish;
                    break;
                }
                case 3: {
                    ((List)list).addAll((Collection)this.commonBigWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator5 = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator5.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator5.next();
                    } while (wish2.getLevel() >= (int)this.bigWishMaxLevels.get(this.bigWishNames.indexOf((Object)wish2.getName())));
                    break;
                }
                case 2: {
                    ((List)list).addAll((Collection)this.rareBigWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator6 = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator6.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator6.next();
                    } while (wish2.getLevel() >= (int)this.bigWishMaxLevels.get(this.bigWishNames.indexOf((Object)wish2.getName())));
                    break;
                }
                case 1: {
                    ((List)list).addAll((Collection)this.epicBigWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator7 = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator7.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator7.next();
                    } while (wish2.getLevel() >= (int)this.bigWishMaxLevels.get(this.bigWishNames.indexOf((Object)wish2.getName())));
                    break;
                }
                case 0: {
                    ((List)list).addAll((Collection)this.legendaryBigWishes);
                    Collections.shuffle((List)list);
                    final Iterator iterator8 = ((List)list).iterator();
                    do {
                        wish2 = wish;
                        if (!iterator8.hasNext()) {
                            break;
                        }
                        wish2 = (Wish)iterator8.next();
                    } while (wish2.getLevel() >= (int)this.bigWishMaxLevels.get(this.bigWishNames.indexOf((Object)wish2.getName())));
                    break;
                }
            }
        }
        return wish2;
    }
    
    private void GenerateViews() {
        for (int i = 0; i < this.vaultCode.getCode().length(); ++i) {
            final ImageView imageView = new ImageView((Context)this.activity);
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(0, -2, 1.0f);
            if (i > 0) {
                layoutParams.leftMargin = this.activity.GetResource(2131099869);
            }
            imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            imageView.setImageDrawable(this.activity.GetImage(2131165515));
            imageView.setScaleY(-1.0f);
            imageView.setAlpha(0.3f);
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202));
            this.increaseNumbers.addView((View)imageView);
            final ImageView imageView2 = new ImageView((Context)this.activity);
            final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(0, -2, 1.0f);
            if (i > 0) {
                layoutParams2.leftMargin = this.activity.GetResource(2131099869);
            }
            imageView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            imageView2.setImageDrawable(this.activity.GetImage(2131165515));
            imageView2.setAlpha(0.3f);
            imageView2.setAdjustViewBounds(true);
            imageView2.setPadding(this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202));
            this.lowerNumbers.addView((View)imageView2);
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(0, -1, 1.0f);
            if (i > 0) {
                layoutParams3.leftMargin = this.activity.GetResource(2131099869);
            }
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
            final MainActivity activity = this.activity;
            activity.SetTextSize(textView, activity.GetResource(2131099680));
            textView.setText((CharSequence)"0");
            textView.setGravity(17);
            textView.setTextColor(this.activity.GetColour(2131034924));
            this.currentGuessNumbers.addView((View)textView);
        }
    }
    
    private void GetCommunityVault() {
        this.db.collection("donations").document("ei3Ld9yTI90JxKV3PArE").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda119(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda120(this));
        this.db.collection("donors").document((String)Objects.requireNonNull((Object)this.firebaseUser.getDisplayName())).get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda121(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda122(this));
    }
    
    private List<String> GetStringList(final Object o) {
        final ArrayList list = new ArrayList();
        if (o instanceof List) {
            for (final Object next : (List)o) {
                if (next instanceof String) {
                    ((List)list).add((Object)next);
                }
            }
        }
        return (List<String>)list;
    }
    
    private void GetTradesSent(final String s) {
        if (this.activity.baseTower.baseTowerLevel >= 54) {
            this.maxDailyTrades = 75;
        }
        else {
            this.maxDailyTrades = 50;
        }
        this.firebaseDatabase.getReference().child("tradelimits").child(s).get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda14(this));
    }
    
    private void GetUserCurrencies(final String s) {
        this.db.collection("userinfo").document(s).get().addOnSuccessListener((OnSuccessListener)new OnSuccessListener<DocumentSnapshot>(this, s) {
            final DatabaseManager this$0;
            final String val$username;
            
            public void onSuccess(final DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    final boolean contains = documentSnapshot.contains("bossCoins");
                    final int n = 1;
                    long longValue;
                    int n2;
                    if (contains) {
                        longValue = (long)Objects.requireNonNull((Object)documentSnapshot.getLong("bossCoins"));
                        n2 = 0;
                    }
                    else {
                        n2 = 1;
                        longValue = 0L;
                    }
                    long longValue2;
                    if (documentSnapshot.contains("friendCoins")) {
                        longValue2 = (long)Objects.requireNonNull((Object)documentSnapshot.getLong("friendCoins"));
                    }
                    else {
                        n2 = 1;
                        longValue2 = 0L;
                    }
                    long longValue3;
                    if (documentSnapshot.contains("friendGifts")) {
                        longValue3 = (long)Objects.requireNonNull((Object)documentSnapshot.getLong("friendGifts"));
                    }
                    else {
                        n2 = 1;
                        longValue3 = 0L;
                    }
                    long longValue4;
                    if (documentSnapshot.contains("snowballs")) {
                        longValue4 = (long)Objects.requireNonNull((Object)documentSnapshot.getLong("snowballs"));
                    }
                    else {
                        n2 = 1;
                        longValue4 = 0L;
                    }
                    long longValue5;
                    if (documentSnapshot.contains("eventTokens")) {
                        longValue5 = (long)Objects.requireNonNull((Object)documentSnapshot.getLong("eventTokens"));
                    }
                    else {
                        n2 = 1;
                        longValue5 = 0L;
                    }
                    if (!documentSnapshot.contains("playid")) {
                        n2 = 1;
                    }
                    long longValue6;
                    if (documentSnapshot.contains("referralPoints")) {
                        longValue6 = (long)Objects.requireNonNull((Object)documentSnapshot.getLong("referralPoints"));
                    }
                    else {
                        longValue6 = 0L;
                        n2 = n;
                    }
                    if (documentSnapshot.contains("type")) {
                        final String s = (String)DatabaseManager$$ExternalSyntheticBackport0.m((Object)documentSnapshot.getString("type"), (Object)"Standard");
                        if (s.equals((Object)"Admin") || s.equals((Object)"Mod")) {
                            this.this$0.activity.UpdateDev(s);
                        }
                    }
                    this.this$0.currencies = new Currencies(longValue, longValue6, longValue2, longValue3, longValue4, longValue5);
                    if (n2 != 0) {
                        final HashMap hashMap = new HashMap();
                        ((Map)hashMap).put((Object)"bossCoins", (Object)this.this$0.currencies.getBossCoins());
                        ((Map)hashMap).put((Object)"referralPoints", (Object)this.this$0.currencies.getReferralPoints());
                        ((Map)hashMap).put((Object)"friendCoins", (Object)this.this$0.currencies.getFriendCoins());
                        ((Map)hashMap).put((Object)"friendGifts", (Object)this.this$0.currencies.getFriendGifts());
                        ((Map)hashMap).put((Object)"snowballs", (Object)this.this$0.currencies.getSnowballs());
                        ((Map)hashMap).put((Object)"eventTokens", (Object)this.this$0.currencies.getEventTokens());
                        if (this.this$0.activity.playerId != null && !this.this$0.activity.playerId.isEmpty()) {
                            ((Map)hashMap).put((Object)"playid", (Object)this.this$0.activity.playerId);
                        }
                        this.this$0.db.collection("userinfo").document(this.val$username).update((Map)hashMap).addOnSuccessListener((OnSuccessListener)new DatabaseManager$4$$ExternalSyntheticLambda0(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$4$$ExternalSyntheticLambda1(this));
                    }
                }
                else {
                    this.this$0.LogIt("Failed to get currencies");
                    this.this$0.currencies = new Currencies(0L, 0L, 0L, 0L, 0L, 0L);
                }
            }
        }).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda110(this));
    }
    
    private boolean GotItem(final long n) {
        final String requiredItem = this.communityVault.getRequiredItem();
        requiredItem.hashCode();
        final int hashCode = requiredItem.hashCode();
        boolean b = true;
        final boolean b2 = true;
        final boolean b3 = true;
        final boolean b4 = true;
        final boolean b5 = true;
        int n2 = -1;
        switch (hashCode) {
            case 658894417: {
                if (!requiredItem.equals((Object)"Gold Coin")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case 444298052: {
                if (!requiredItem.equals((Object)"Killcoins")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case 71018769: {
                if (!requiredItem.equals((Object)"Soul Gems")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -1144442577: {
                if (!requiredItem.equals((Object)"Silver Coins")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        switch (n2) {
            default: {
                return this.activity.inventoryItems.contains((Object)this.communityVault.getRequiredItem()) && (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)this.communityVault.getRequiredItem())) >= n && b5;
            }
            case 3: {
                if (this.activity.totalGems < n) {
                    b = false;
                }
                return b;
            }
            case 2: {
                return this.activity.combatManager.slayerInfo.getKillcoins() >= n && b2;
            }
            case 1: {
                return this.activity.combatManager.slayerInfo.getSoulGems() >= n && b3;
            }
            case 0: {
                return this.activity.totalCoins >= n && b4;
            }
        }
    }
    
    private boolean InventorySpace(final String s) {
        final boolean equals = s.equals((Object)"Gold Coin");
        boolean b2;
        final boolean b = b2 = true;
        if (!equals) {
            b2 = b;
            if (!s.equals((Object)"Birthday Present")) {
                if (s.equals((Object)"Special Currency")) {
                    b2 = b;
                }
                else if (this.activity.inventoryItems.contains((Object)s)) {
                    b2 = b;
                }
                else {
                    b2 = (this.activity.inventoryItems.size() < this.activity.maxInventory && b);
                }
            }
        }
        return b2;
    }
    
    private void LogDonation(final long n) {
        if (this.firebaseUser.getDisplayName() != null) {
            final DocumentReference document = this.db.collection("donors").document(this.firebaseUser.getDisplayName());
            document.update("totalDonations", (Object)FieldValue.increment(n), new Object[0]).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda2(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda3(this, n, document));
        }
        else {
            this.activity.runOnUiThread((Runnable)new DatabaseManager$$ExternalSyntheticLambda150(this));
        }
    }
    
    private void LogFriendsData(final String s) {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"title", (Object)this.activity.activeTitle);
        ((Map)hashMap).put((Object)"avatar", this.activity.myProfileAvatars.get(this.activity.activeAvatar));
        ((Map)hashMap).put((Object)"activity", (Object)FieldValue.serverTimestamp());
        for (int i = 0; i < this.activity.combatManager.allGods.size(); ++i) {
            ((Map)hashMap).put((Object)this.activity.combatManager.allGods.get(i), this.activity.accountStats.getAllMonsterKills().get(this.activity.combatManager.enemyNames.indexOf(this.activity.combatManager.allGods.get(i))));
        }
        this.db.collection("userinfo").document(s).update((Map)hashMap).addOnSuccessListener((OnSuccessListener)new OnSuccessListener<Void>(this, s) {
            final DatabaseManager this$0;
            final String val$username;
            
            public void onSuccess(final Void void1) {
                this.this$0.db.collection("userinfo").document(this.val$username).get().addOnSuccessListener((OnSuccessListener)new OnSuccessListener<DocumentSnapshot>(this) {
                    final DatabaseManager$7 this$1;
                    
                    public void onSuccess(final DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.contains("activity")) {
                            final Timestamp timestamp = documentSnapshot.getTimestamp("activity");
                            if (timestamp != null) {
                                this.this$1.this$0.serverDate = timestamp.toDate();
                                this.this$1.this$0.CheckDailyGifts();
                            }
                        }
                    }
                });
            }
        }).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda91(this));
    }
    
    private Wish PickWish(final String s) {
        ArrayList list;
        if (s.equals((Object)"Beginner")) {
            list = new ArrayList((Collection)this.myWishes);
        }
        else {
            list = new ArrayList((Collection)this.myBigWishes);
        }
        Collections.shuffle((List)list);
        final int getRandom = this.activity.GetRandom(1, 100);
        int i = 0;
        String[] array;
        if (getRandom <= 5) {
            array = new String[] { "Legendary", "Epic", "Rare", "Common" };
        }
        else if (getRandom <= 20) {
            array = new String[] { "Epic", "Rare", "Common", "Legendary" };
        }
        else if (getRandom <= 50) {
            array = new String[] { "Rare", "Common", "Epic", "Legendary" };
        }
        else {
            array = new String[] { "Common", "Rare", "Epic", "Legendary" };
        }
        final int length = array.length;
        Wish findWish = null;
        while (i < length) {
            findWish = this.FindWish(array[i], s);
            if (findWish != null) {
                break;
            }
            ++i;
        }
        return findWish;
    }
    
    private void ReceivedTrade(final Trade trade) {
        final String item = trade.getItem();
        item.hashCode();
        final int hashCode = item.hashCode();
        int n = -1;
        switch (hashCode) {
            case -456161768: {
                if (!item.equals((Object)"Birthday Present")) {
                    break;
                }
                n = 2;
                break;
            }
            case -631155548: {
                if (!item.equals((Object)"Golden Present")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1405765706: {
                if (!item.equals((Object)"Friendship Gift")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                this.activity.LargePopup(2131166491, "Item Received", trade.getSender() + " has sent you something. Go check it out!");
                break;
            }
            case 1:
            case 2: {
                this.activity.LargePopup(2131165572, "Present Received!", trade.getSender() + " has sent you a Birthday Present!");
                break;
            }
            case 0: {
                this.activity.LargePopup(2131165856, "Gift of Friendship!", "You have been sent a Gift of Friendship!");
                break;
            }
        }
        if (trade.getItem().equals((Object)"Birthday Present") && Long.parseLong(trade.getItemAmount()) == 1L && this.activity.GetRandom(1, 1000) <= 2) {
            trade.item = "Golden Present";
        }
        this.allTrades.add((Object)trade);
    }
    
    private void RefreshProgress() {
        this.db.collection("donations").document("ei3Ld9yTI90JxKV3PArE").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda76(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda77(this));
    }
    
    private void RemoveDonationItem(final long n) {
        final String requiredItem = this.communityVault.getRequiredItem();
        requiredItem.hashCode();
        final int hashCode = requiredItem.hashCode();
        int n2 = -1;
        switch (hashCode) {
            case 658894417: {
                if (!requiredItem.equals((Object)"Gold Coin")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case 444298052: {
                if (!requiredItem.equals((Object)"Killcoins")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case 71018769: {
                if (!requiredItem.equals((Object)"Soul Gems")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -1144442577: {
                if (!requiredItem.equals((Object)"Silver Coins")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        switch (n2) {
            default: {
                this.activity.RemoveItem(this.communityVault.getRequiredItem(), (int)n);
                break;
            }
            case 3: {
                final MainActivity activity = this.activity;
                activity.totalGems -= n;
                this.activity.UpdateCash();
                break;
            }
            case 2: {
                final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                slayerInfo.killcoins -= n;
                break;
            }
            case 1: {
                final CombatManager$SlayerInfo slayerInfo2 = this.activity.combatManager.slayerInfo;
                slayerInfo2.soulGems -= n;
                break;
            }
            case 0: {
                final MainActivity activity2 = this.activity;
                activity2.totalCoins -= n;
                this.activity.UpdateCash();
                break;
            }
        }
        this.activity.QuickPopup("Thank you, your donation has been received!");
        final CommunityVault communityVault = this.communityVault;
        communityVault.totalDonations += n;
        this.UpdateCommunityVault();
    }
    
    private void RemoveTrade(final String s) {
        for (final Trade trade : this.allTrades) {
            if (trade.getId().equals((Object)s)) {
                this.allTrades.remove((Object)trade);
                break;
            }
        }
    }
    
    private void RemoveUntradableItems(final List<ItemManager.Item> list) {
        list.removeIf((Predicate)new DatabaseManager$$ExternalSyntheticLambda126(this));
    }
    
    private void ResetNumbers() {
        for (int i = 0; i < this.currentGuessNumbers.getChildCount(); ++i) {
            ((TextView)this.currentGuessNumbers.getChildAt(i)).setText((CharSequence)"0");
            ((TextView)this.currentGuessNumbers.getChildAt(i)).setTextColor(this.activity.GetColour(2131034924));
        }
    }
    
    private void RewardOutfitPiece(final String s, final String s2) {
        if (this.activity.InventoryNotFull(s)) {
            this.activity.runOnUiThread((Runnable)new DatabaseManager$$ExternalSyntheticLambda61(this, s, s2));
        }
    }
    
    private void SendItem(final String s) {
        final String[] split = this.ts_itemSendAmount.getText().toString().split("\\s*\\s*");
        int n = 0;
        if (!split[0].equals((Object)"0")) {
            if (this.CanSend(s, Long.parseLong(this.ts_itemSendAmount.getText().toString()))) {
                s.hashCode();
                Label_0179: {
                    switch (s.hashCode()) {
                        case 2064007691: {
                            if (!s.equals((Object)"Box of Chocolates")) {
                                break;
                            }
                            n = 3;
                            break Label_0179;
                        }
                        case 963625070: {
                            if (!s.equals((Object)"Golden Egg")) {
                                break;
                            }
                            n = 2;
                            break Label_0179;
                        }
                        case 658894417: {
                            if (!s.equals((Object)"Gold Coin")) {
                                break;
                            }
                            n = 1;
                            break Label_0179;
                        }
                        case -456161768: {
                            if (!s.equals((Object)"Birthday Present")) {
                                break;
                            }
                            break Label_0179;
                        }
                    }
                    n = -1;
                }
                switch (n) {
                    default: {
                        if (!this.activity.inventoryItems.contains((Object)s)) {
                            this.activity.QuickPopup("You don't have any of this item to send.");
                            break;
                        }
                        final int index = this.activity.inventoryItems.indexOf((Object)s);
                        if ((long)this.activity.inventoryAmounts.get(index) < Long.parseLong(this.ts_itemSendAmount.getText().toString())) {
                            this.activity.QuickPopup("You don't have enough of this item to send.");
                            break;
                        }
                        if (this.activity.combatManager.equippedItems.contains((Object)s) && (long)this.activity.inventoryAmounts.get(index) == 1L) {
                            this.activity.QuickPopup("You must unequip this item first.");
                            break;
                        }
                        this.SendTradeRequest(this.ts_playername.getText().toString(), s, this.ts_itemSendAmount.getText().toString());
                        this.ts_itemSendAmount.setText((CharSequence)"");
                        break;
                    }
                    case 3: {
                        if (this.activity.treasureHunts.eventPresent.getChocolateBoxes() >= Long.parseLong(this.ts_itemSendAmount.getText().toString())) {
                            this.SendTradeRequest(this.ts_playername.getText().toString(), s, this.ts_itemSendAmount.getText().toString());
                            this.ts_itemSendAmount.setText((CharSequence)"");
                            break;
                        }
                        this.activity.QuickPopup("You don't have enough Chocolate Boxes.");
                        break;
                    }
                    case 2: {
                        if (this.activity.treasureHunts.eventPresent.getGoldenEggs() >= Long.parseLong(this.ts_itemSendAmount.getText().toString())) {
                            this.SendTradeRequest(this.ts_playername.getText().toString(), s, this.ts_itemSendAmount.getText().toString());
                            this.ts_itemSendAmount.setText((CharSequence)"");
                            break;
                        }
                        this.activity.QuickPopup("You don't have enough Golden Eggs.");
                        break;
                    }
                    case 1: {
                        if (this.activity.totalGems >= Long.parseLong(this.ts_itemSendAmount.getText().toString())) {
                            this.SendTradeRequest(this.ts_playername.getText().toString(), s, this.ts_itemSendAmount.getText().toString());
                            this.ts_itemSendAmount.setText((CharSequence)"");
                            break;
                        }
                        this.activity.QuickPopup("You don't have enough gold.");
                        break;
                    }
                    case 0: {
                        if (this.activity.treasureHunts.eventPresent.getBirthdayPresents() >= Long.parseLong(this.ts_itemSendAmount.getText().toString())) {
                            this.SendTradeRequest(this.ts_playername.getText().toString(), s, this.ts_itemSendAmount.getText().toString());
                            this.ts_itemSendAmount.setText((CharSequence)"");
                            break;
                        }
                        this.activity.QuickPopup("You don't have enough presents.");
                        break;
                    }
                }
            }
        }
        else {
            this.activity.QuickPopup("You must enter a valid item amount");
        }
    }
    
    private void SendTradeRequest(final String s, final String s2, final String s3) {
        if (this.connected) {
            this.ShowConnecting();
            final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
            singleThreadExecutor.execute((Runnable)new DatabaseManager$$ExternalSyntheticLambda41(this, s, s2, s3));
            singleThreadExecutor.shutdown();
        }
        else {
            this.activity.QuickPopup("No internet connection");
        }
    }
    
    private void SetupListener(final Query query) {
        query.addValueEventListener((ValueEventListener)new ValueEventListener(this) {
            final DatabaseManager this$0;
            
            public void onCancelled(final DatabaseError databaseError) {
                this.this$0.activity.LogIt("Event listener cancelled: ");
            }
            
            public void onDataChange(DataSnapshot dataSnapshot) {
                final Iterator iterator = dataSnapshot.getChildren().iterator();
                while (iterator.hasNext()) {
                    dataSnapshot = (DataSnapshot)iterator.next();
                    if (this.this$0.FindTrade(dataSnapshot.getKey()) == null && !this.this$0.banned) {
                        this.this$0.CheckIncomingTrade(dataSnapshot);
                    }
                }
            }
        });
    }
    
    private void TradeTimeout() {
        this.canTrade = false;
        new CountDownTimer(this, this.tradeTimeout, 1000L) {
            final DatabaseManager this$0;
            
            public void onFinish() {
                this.this$0.canTrade = true;
            }
            
            public void onTick(final long tradeCooldown) {
                this.this$0.tradeCooldown = tradeCooldown;
            }
        }.start();
    }
    
    private void UnlockWish(final String s) {
        final Wish pickWish = this.PickWish(s);
        ++pickWish.level;
        if (s.equals((Object)"Beginner")) {
            this.activity.LargePopup((int)this.wishIcons.get(this.wishNames.indexOf((Object)pickWish.getName())), "Wish Granted", pickWish.getName() + " wish is now level " + pickWish.getLevel());
        }
        else {
            this.activity.LargePopup((int)this.bigWishIcons.get(this.bigWishNames.indexOf((Object)pickWish.getName())), "Wish Granted", pickWish.getName() + " wish is now level " + pickWish.getLevel());
        }
        if (!this.wishViewNames.isEmpty() && !this.wishViews.isEmpty()) {
            try {
                ((TextView)((LinearLayout)this.wishViews.get(this.wishViewNames.indexOf((Object)pickWish.getName()))).getChildAt(1)).setText((CharSequence)("Level " + this.GetWishLevel(pickWish.getName(), s)));
            }
            catch (final IndexOutOfBoundsException ex) {
                this.UpdateWishes(s);
            }
        }
    }
    
    private void UpdateCommunityVault() {
        final RelativeLayout currentRequest = this.currentRequest;
        int n = 3;
        ((TextView)currentRequest.getChildAt(3)).setText((CharSequence)("Total Donations: " + this.activity.FormatExp(this.communityVault.getTotalDonations())));
        ((TextView)this.currentRequest.getChildAt(4)).setText((CharSequence)("Request Progress: " + String.format(Locale.UK, "%.2f", new Object[] { this.communityVault.getTotalDonations() / (float)this.communityVault.getRequiredAmount() * 100.0f }) + "%"));
        if (this.communityVault.getTotalDonations() >= this.communityVault.getRequiredAmount()) {
            this.milestoneReward.getChildAt(2).setAlpha(1.0f);
        }
        else {
            this.milestoneReward.getChildAt(2).setAlpha(0.0f);
        }
        this.myDonations.setText((CharSequence)(this.activity.FormatExp(this.totalDonations) + " / " + this.activity.FormatExp(this.maxDonation)));
        if (this.communityVault.isCompleted()) {
            this.activity.HideView((View)this.donationAmount);
            if (this.communityVault.getTotalDonations() >= this.communityVault.getRequiredAmount()) {
                if (this.claimedDonationBin) {
                    this.vaultDonate.setAlpha(0.2f);
                }
                else {
                    this.vaultDonate.setAlpha(1.0f);
                }
                this.vaultDonate.setText((CharSequence)"Collect Reward");
                this.donationNotice.setText((CharSequence)"This Vault is now closed! You can collect the reward using the button below!");
            }
            else {
                this.vaultDonate.setAlpha(0.2f);
                this.vaultDonate.setText((CharSequence)"Request not completed");
                this.donationNotice.setText((CharSequence)"This Vault is now closed! Unfortunately the request was not completed, so nobody gets a reward!");
            }
        }
        else if (this.totalDonations >= this.maxDonation) {
            this.vaultDonate.setAlpha(0.2f);
            this.activity.HideView((View)this.donationAmount);
            this.donationNotice.setText((CharSequence)"Thank you for your donation to the vault. Once the vault is complete, if the request is met, you will be able to collect your reward!");
            this.vaultDonate.setText((CharSequence)"Already Donated");
        }
        else {
            this.vaultDonate.setAlpha(1.0f);
            this.activity.ShowView((View)this.donationAmount);
            this.donationNotice.setText((CharSequence)"Please note: You must donate any amount in order to collect the reward at the end.");
            this.vaultDonate.setText((CharSequence)"Donate");
        }
        final String requiredItem = this.communityVault.getRequiredItem();
        requiredItem.hashCode();
        Label_0567: {
            switch (requiredItem.hashCode()) {
                case 658894417: {
                    if (!requiredItem.equals((Object)"Gold Coin")) {
                        break;
                    }
                    break Label_0567;
                }
                case 444298052: {
                    if (!requiredItem.equals((Object)"Killcoins")) {
                        break;
                    }
                    n = 2;
                    break Label_0567;
                }
                case 71018769: {
                    if (!requiredItem.equals((Object)"Soul Gems")) {
                        break;
                    }
                    n = 1;
                    break Label_0567;
                }
                case -1144442577: {
                    if (!requiredItem.equals((Object)"Silver Coins")) {
                        break;
                    }
                    n = 0;
                    break Label_0567;
                }
            }
            n = -1;
        }
        String s = null;
        switch (n) {
            default: {
                if (this.activity.inventoryItems.contains((Object)this.communityVault.getRequiredItem())) {
                    final MainActivity activity = this.activity;
                    s = activity.FormatExp((long)activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)this.communityVault.getRequiredItem())));
                    break;
                }
                s = "0";
                break;
            }
            case 3: {
                final MainActivity activity2 = this.activity;
                s = activity2.FormatExp(activity2.totalGems);
                break;
            }
            case 2: {
                final MainActivity activity3 = this.activity;
                s = activity3.FormatExp(activity3.combatManager.slayerInfo.getKillcoins());
                break;
            }
            case 1: {
                final MainActivity activity4 = this.activity;
                s = activity4.FormatExp(activity4.combatManager.slayerInfo.getSoulGems());
                break;
            }
            case 0: {
                final MainActivity activity5 = this.activity;
                s = activity5.FormatExp(activity5.totalCoins);
                break;
            }
        }
        this.donationAmount.setHint((CharSequence)("You currently have: " + s));
    }
    
    private void UpdatePlayerTrades() {
        this.ts_activeTrades.removeAllViews();
        this.ts_activeGifts.removeAllViews();
        for (int i = 0; i < this.allTrades.size(); ++i) {
            final Trade trade = (Trade)this.allTrades.get(i);
            final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.activity, 2131493067, (ViewGroup)null);
            int n = -1;
            final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
            linearLayout$LayoutParams.bottomMargin = this.activity.GetResource(2131100202);
            final String item = trade.getItem();
            item.hashCode();
            switch (item.hashCode()) {
                case 1361763894: {
                    if (!item.equals((Object)"Yellow Treat Bag")) {
                        break;
                    }
                    n = 11;
                    break;
                }
                case 963625070: {
                    if (!item.equals((Object)"Golden Egg")) {
                        break;
                    }
                    n = 10;
                    break;
                }
                case 880990999: {
                    if (!item.equals((Object)"Event Currency")) {
                        break;
                    }
                    n = 9;
                    break;
                }
                case 658894417: {
                    if (!item.equals((Object)"Gold Coin")) {
                        break;
                    }
                    n = 8;
                    break;
                }
                case 464123864: {
                    if (!item.equals((Object)"Special Currency")) {
                        break;
                    }
                    n = 7;
                    break;
                }
                case 444298052: {
                    if (!item.equals((Object)"Killcoins")) {
                        break;
                    }
                    n = 6;
                    break;
                }
                case 429263516: {
                    if (!item.equals((Object)"Blue Treat Bag")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 224325123: {
                    if (!item.equals((Object)"Golden Ticket")) {
                        break;
                    }
                    n = 4;
                    break;
                }
                case -456161768: {
                    if (!item.equals((Object)"Birthday Present")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case -631155548: {
                    if (!item.equals((Object)"Golden Present")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case -1326946875: {
                    if (!item.equals((Object)"Challenge Coins")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -1793434157: {
                    if (!item.equals((Object)"Red Treat Bag")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            int n2 = 0;
            switch (n) {
                default: {
                    try {
                        n2 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)trade.getItem()));
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        n2 = 2131166220;
                    }
                    break;
                }
                case 11: {
                    n2 = 2131166355;
                    break;
                }
                case 10: {
                    n2 = 2131165510;
                    break;
                }
                case 9: {
                    n2 = (int)this.activity.eventIcons.get(this.activity.eventCurrecies.indexOf((Object)this.activity.currentHolidayCurrency));
                    break;
                }
                case 8: {
                    n2 = 2131165871;
                    break;
                }
                case 7: {
                    n2 = this.activity.event.specialCurrencyIcon;
                    break;
                }
                case 6: {
                    n2 = 2131165924;
                    break;
                }
                case 5: {
                    n2 = 2131165623;
                    break;
                }
                case 4: {
                    n2 = 2131165478;
                    break;
                }
                case 3: {
                    n2 = 2131165572;
                    break;
                }
                case 2: {
                    n2 = 2131165879;
                    break;
                }
                case 1: {
                    n2 = 2131165354;
                    break;
                }
                case 0: {
                    n2 = 2131166136;
                    break;
                }
            }
            ((ImageView)constraintLayout.getChildAt(0)).setImageDrawable(this.activity.GetImage(n2));
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)("Received from " + trade.getSender()));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)(this.activity.FormatExp(Long.parseLong(trade.getItemAmount())) + "x " + trade.getItem()));
            ((TextView)constraintLayout.getChildAt(3)).setText((CharSequence)"Collect");
            constraintLayout.getChildAt(3).setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda47(this, trade, constraintLayout));
            if (trade.getItem().equals((Object)"Friendship Gift")) {
                this.ts_activeGifts.addView((View)constraintLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
            }
            else {
                this.ts_activeTrades.addView((View)constraintLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
            }
        }
    }
    
    private void UpdateSentTrades() {
        this.ts_sentItems.removeAllViews();
        for (int i = 0; i < this.sentTrades.size(); ++i) {
            final Trade trade = (Trade)this.sentTrades.get(i);
            final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.activity, 2131493067, (ViewGroup)null);
            int n = -1;
            final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
            linearLayout$LayoutParams.bottomMargin = this.activity.GetResource(2131100202);
            final String item = trade.getItem();
            item.hashCode();
            switch (item.hashCode()) {
                case 963625070: {
                    if (!item.equals((Object)"Golden Egg")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case 658894417: {
                    if (!item.equals((Object)"Gold Coin")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case 224325123: {
                    if (!item.equals((Object)"Golden Ticket")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -456161768: {
                    if (!item.equals((Object)"Birthday Present")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            Drawable imageDrawable = null;
            switch (n) {
                default: {
                    try {
                        final MainActivity activity = this.activity;
                        imageDrawable = activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)trade.getItem())));
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        imageDrawable = this.activity.GetImage(2131166497);
                    }
                    break;
                }
                case 3: {
                    imageDrawable = this.activity.GetImage(2131165510);
                    break;
                }
                case 2: {
                    imageDrawable = this.activity.GetImage(2131165871);
                    break;
                }
                case 1: {
                    imageDrawable = this.activity.GetImage(2131165478);
                    break;
                }
                case 0: {
                    imageDrawable = this.activity.GetImage(2131165572);
                    break;
                }
            }
            ((ImageView)constraintLayout.getChildAt(0)).setImageDrawable(imageDrawable);
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)("Sent to " + trade.getRecipient()));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)(this.activity.FormatExp(Long.parseLong(trade.getItemAmount())) + "x " + trade.getItem()));
            ((TextView)constraintLayout.getChildAt(3)).setText((CharSequence)trade.getDate());
            this.ts_sentItems.addView((View)constraintLayout, 0, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        }
    }
    
    private void UpdateWishes(final String s) {
        this.wishViewNames.clear();
        this.wishViews.clear();
        this.wishes_common.removeAllViews();
        this.wishes_rare.removeAllViews();
        this.wishes_epic.removeAllViews();
        this.wishes_legendary.removeAllViews();
        if (s.equals((Object)"Beginner")) {
            for (int i = 0; i < this.myWishes.size(); ++i) {
                final LinearLayout linearLayout = (LinearLayout)View.inflate((Context)this.activity, 2131493073, (ViewGroup)null);
                final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(0, -2, 1.0f);
                final String s2 = (String)this.wishRarities.get(this.wishNames.indexOf((Object)((Wish)this.myWishes.get(i)).getName()));
                s2.hashCode();
                int n = 0;
                Label_0270: {
                    switch (s2.hashCode()) {
                        case 2024019467: {
                            if (!s2.equals((Object)"Common")) {
                                break;
                            }
                            n = 3;
                            break Label_0270;
                        }
                        case 2539714: {
                            if (!s2.equals((Object)"Rare")) {
                                break;
                            }
                            n = 2;
                            break Label_0270;
                        }
                        case 2166565: {
                            if (!s2.equals((Object)"Epic")) {
                                break;
                            }
                            n = 1;
                            break Label_0270;
                        }
                        case -77594853: {
                            if (!s2.equals((Object)"Legendary")) {
                                break;
                            }
                            n = 0;
                            break Label_0270;
                        }
                    }
                    n = -1;
                }
                switch (n) {
                    case 3: {
                        this.wishes_common.addView((View)linearLayout);
                        if (this.wishes_common.getChildCount() > 0) {
                            layoutParams.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                    case 2: {
                        this.wishes_rare.addView((View)linearLayout);
                        if (this.wishes_rare.getChildCount() > 0) {
                            layoutParams.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                    case 1: {
                        this.wishes_epic.addView((View)linearLayout);
                        if (this.wishes_epic.getChildCount() > 0) {
                            layoutParams.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                    case 0: {
                        this.wishes_legendary.addView((View)linearLayout);
                        if (this.wishes_legendary.getChildCount() > 0) {
                            layoutParams.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                }
                linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                ((ImageView)linearLayout.getChildAt(0)).setImageDrawable(this.activity.GetImage((int)this.wishIcons.get(this.wishNames.indexOf((Object)((Wish)this.myWishes.get(i)).getName()))));
                if (((Wish)this.myWishes.get(i)).getLevel() > 0) {
                    ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)("Level " + ((Wish)this.myWishes.get(i)).getLevel()));
                }
                else {
                    ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)"Locked");
                }
                linearLayout.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda87(this, i));
                this.wishViews.add((Object)linearLayout);
                this.wishViewNames.add((Object)((Wish)this.myWishes.get(i)).getName());
            }
            ((TextView)this.wishes_new.getChildAt(1)).setText((CharSequence)this.activity.FormatExp(this.getWishCost(s)));
        }
        else {
            for (int j = 0; j < this.myBigWishes.size(); ++j) {
                final LinearLayout linearLayout2 = (LinearLayout)View.inflate((Context)this.activity, 2131493073, (ViewGroup)null);
                final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(0, -2, 1.0f);
                final String s3 = (String)this.bigWishRarities.get(this.bigWishNames.indexOf((Object)((Wish)this.myBigWishes.get(j)).getName()));
                s3.hashCode();
                int n2 = 0;
                Label_0898: {
                    switch (s3.hashCode()) {
                        case 2024019467: {
                            if (!s3.equals((Object)"Common")) {
                                break;
                            }
                            n2 = 3;
                            break Label_0898;
                        }
                        case 2539714: {
                            if (!s3.equals((Object)"Rare")) {
                                break;
                            }
                            n2 = 2;
                            break Label_0898;
                        }
                        case 2166565: {
                            if (!s3.equals((Object)"Epic")) {
                                break;
                            }
                            n2 = 1;
                            break Label_0898;
                        }
                        case -77594853: {
                            if (!s3.equals((Object)"Legendary")) {
                                break;
                            }
                            n2 = 0;
                            break Label_0898;
                        }
                    }
                    n2 = -1;
                }
                switch (n2) {
                    case 3: {
                        this.wishes_common.addView((View)linearLayout2);
                        if (this.wishes_common.getChildCount() > 0) {
                            layoutParams2.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                    case 2: {
                        this.wishes_rare.addView((View)linearLayout2);
                        if (this.wishes_rare.getChildCount() > 0) {
                            layoutParams2.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                    case 1: {
                        this.wishes_epic.addView((View)linearLayout2);
                        if (this.wishes_epic.getChildCount() > 0) {
                            layoutParams2.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                    case 0: {
                        this.wishes_legendary.addView((View)linearLayout2);
                        if (this.wishes_legendary.getChildCount() > 0) {
                            layoutParams2.leftMargin = this.activity.GetResource(2131099658);
                            break;
                        }
                        break;
                    }
                }
                linearLayout2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                ((ImageView)linearLayout2.getChildAt(0)).setImageDrawable(this.activity.GetImage((int)this.bigWishIcons.get(this.bigWishNames.indexOf((Object)((Wish)this.myBigWishes.get(j)).getName()))));
                if (((Wish)this.myBigWishes.get(j)).getLevel() > 0) {
                    ((TextView)linearLayout2.getChildAt(1)).setText((CharSequence)("Level " + ((Wish)this.myBigWishes.get(j)).getLevel()));
                }
                else {
                    ((TextView)linearLayout2.getChildAt(1)).setText((CharSequence)"Locked");
                }
                linearLayout2.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda88(this, j));
                this.wishViews.add((Object)linearLayout2);
                this.wishViewNames.add((Object)((Wish)this.myBigWishes.get(j)).getName());
            }
            ((TextView)this.wishes_new.getChildAt(1)).setText((CharSequence)this.activity.FormatExp(this.getWishCost(s)));
        }
    }
    
    private void UserBanned(final String text) {
        this.activity.DisableScreen();
        final LinearLayout linearLayout = (LinearLayout)this.activity.inflater.inflate(2131492896, (ViewGroup)this.activity.mainView, false);
        this.activity.mainView.addView((View)linearLayout);
        ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)text);
        this.banned = true;
    }
    
    private void VaultListeners() {
        final int n = 0;
        int n2 = 0;
        int i;
        while (true) {
            i = n;
            if (n2 >= this.lowerNumbers.getChildCount()) {
                break;
            }
            this.lowerNumbers.getChildAt(n2).setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda73(this, n2));
            ++n2;
        }
        while (i < this.increaseNumbers.getChildCount()) {
            this.increaseNumbers.getChildAt(i).setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda84(this, i));
            ++i;
        }
        this.getMoreChances.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda95(this));
        this.openButton.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda106(this));
        this.vaultScreen.findViewById(2131296765).setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda117(this));
    }
    
    private void VaultReward() {
        final String reward = this.vaultCode.getReward();
        reward.hashCode();
        final int hashCode = reward.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1803406242: {
                if (!reward.equals((Object)"Soul Gem")) {
                    break;
                }
                n = 11;
                break;
            }
            case 1361763894: {
                if (!reward.equals((Object)"Yellow Treat Bag")) {
                    break;
                }
                n = 10;
                break;
            }
            case 880990999: {
                if (!reward.equals((Object)"Event Currency")) {
                    break;
                }
                n = 9;
                break;
            }
            case 712033232: {
                if (!reward.equals((Object)"Golden Cracker")) {
                    break;
                }
                n = 8;
                break;
            }
            case 658894417: {
                if (!reward.equals((Object)"Gold Coin")) {
                    break;
                }
                n = 7;
                break;
            }
            case 444298052: {
                if (!reward.equals((Object)"Killcoins")) {
                    break;
                }
                n = 6;
                break;
            }
            case 429263516: {
                if (!reward.equals((Object)"Blue Treat Bag")) {
                    break;
                }
                n = 5;
                break;
            }
            case 224325123: {
                if (!reward.equals((Object)"Golden Ticket")) {
                    break;
                }
                n = 4;
                break;
            }
            case 65287138: {
                if (!reward.equals((Object)"Coins")) {
                    break;
                }
                n = 3;
                break;
            }
            case -819624483: {
                if (!reward.equals((Object)"Casket of Treasure")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1326946875: {
                if (!reward.equals((Object)"Challenge Coins")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1793434157: {
                if (!reward.equals((Object)"Red Treat Bag")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        int n2 = 0;
        switch (n) {
            default: {
                this.activity.GiveItem(this.vaultCode.getReward(), this.vaultCode.getRewardAmount(), false);
                try {
                    n2 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)this.vaultCode.getReward()));
                }
                catch (final IndexOutOfBoundsException ex) {
                    n2 = 2131166497;
                }
                break;
            }
            case 11: {
                final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                slayerInfo.soulGems += this.vaultCode.getRewardAmount();
                n2 = 2131166237;
                break;
            }
            case 10: {
                final TreasureHunts$EventPresent eventPresent = this.activity.treasureHunts.eventPresent;
                eventPresent.yellowTreatBags += (int)this.vaultCode.getRewardAmount();
                n2 = 2131166355;
                break;
            }
            case 9: {
                final MainActivity activity = this.activity;
                activity.holidayCurrency += this.vaultCode.getRewardAmount();
                this.activity.UpdateBottomNav();
                n2 = (int)this.activity.eventIcons.get(this.activity.eventCurrecies.indexOf((Object)this.activity.currentHolidayCurrency));
                break;
            }
            case 8: {
                final TreasureHunts$EventPresent eventPresent2 = this.activity.treasureHunts.eventPresent;
                eventPresent2.goldenCrackers += (int)this.vaultCode.getRewardAmount();
                n2 = 2131165873;
                break;
            }
            case 7: {
                final MainActivity activity2 = this.activity;
                activity2.totalGems += this.vaultCode.getRewardAmount();
                this.activity.UpdateCash();
                n2 = 2131165871;
                break;
            }
            case 6: {
                final CombatManager$SlayerInfo slayerInfo2 = this.activity.combatManager.slayerInfo;
                slayerInfo2.killcoins += this.vaultCode.getRewardAmount();
                this.activity.UpdateCash();
                n2 = 2131165924;
                break;
            }
            case 5: {
                final TreasureHunts$EventPresent eventPresent3 = this.activity.treasureHunts.eventPresent;
                eventPresent3.blueTreatBags += (int)this.vaultCode.getRewardAmount();
                n2 = 2131165623;
                break;
            }
            case 4: {
                final SecretPathway$MyPath myPath = this.activity.secretPathway.myPath;
                myPath.goldenTickets += (int)this.vaultCode.getRewardAmount();
                n2 = 2131165478;
                break;
            }
            case 3: {
                final MainActivity activity3 = this.activity;
                activity3.totalCoins += this.vaultCode.getRewardAmount();
                this.activity.UpdateCash();
                n2 = 2131166220;
                break;
            }
            case 2: {
                final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                myTreasureHunts.caskets += (int)this.vaultCode.getRewardAmount();
                n2 = 2131165669;
                break;
            }
            case 1: {
                final Dailies dailies = this.activity.dailies;
                dailies.challengeCoins += (int)this.vaultCode.getRewardAmount();
                n2 = 2131165354;
                break;
            }
            case 0: {
                final TreasureHunts$EventPresent eventPresent4 = this.activity.treasureHunts.eventPresent;
                eventPresent4.redTreatBags += (int)this.vaultCode.getRewardAmount();
                n2 = 2131166136;
                break;
            }
        }
        this.activity.LargePopup(n2, "Vault Cracked!", "You cracked the vault and got " + this.activity.FormatExp(this.vaultCode.getRewardAmount()) + "x " + this.vaultCode.getReward());
    }
    
    private boolean devTradeAvailable(final String s) {
        boolean b = false;
        int n = 2;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Golden Egg", "Golden Ticket", "Blue Treat Bag", "Red Treat Bag", "Yellow Treat Bag", "Challenge Coins", "Event Currency", "Killcoins", "Birthday Present", "Golden Present", "Special Currency" }));
        if (!this.activity.allItems.contains((Object)s) && !((List)list).contains((Object)s) && !s.contains((CharSequence)"Pet#") && !s.contains((CharSequence)"Kills#") && !s.contains((CharSequence)"Title#") && !s.contains((CharSequence)"Avatar#")) {
            return false;
        }
        if (!s.contains((CharSequence)"#")) {
            return true;
        }
        final String[] split = s.split("\\s*#\\s*");
        final String s2 = split[0];
        s2.hashCode();
        Label_0282: {
            switch (s2.hashCode()) {
                case 1972874617: {
                    if (!s2.equals((Object)"Avatar")) {
                        break;
                    }
                    break Label_0282;
                }
                case 72499381: {
                    if (!s2.equals((Object)"Kills")) {
                        break;
                    }
                    n = 1;
                    break Label_0282;
                }
                case 80127: {
                    if (!s2.equals((Object)"Pet")) {
                        break;
                    }
                    n = 0;
                    break Label_0282;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return true;
            }
            case 2: {
                return this.activity.avatarNames.contains((Object)split[1]);
            }
            case 1: {
                return this.activity.combatManager.enemyNames.contains((Object)split[1]);
            }
            case 0: {
                if (this.activity.skillingPets.contains((Object)split[1]) || this.activity.specialPets.contains((Object)split[1])) {
                    b = true;
                }
                return b;
            }
        }
    }
    
    private long getWishCost(final String s) {
        long n;
        if (s.equals((Object)"Beginner")) {
            n = 3L;
        }
        else {
            n = 15000L;
        }
        int i = 0;
        long n2 = n;
        while (i < this.getWishesMade(s)) {
            n2 += n;
            ++i;
        }
        if (s.equals((Object)"Beginner")) {
            return Math.min(n2, 500L);
        }
        return n2;
    }
    
    private int getWishesMade(final String s) {
        final boolean equals = s.equals((Object)"Beginner");
        int n = 0;
        final int n2 = 0;
        int n4;
        if (equals) {
            final Iterator iterator = this.myWishes.iterator();
            int n3 = n2;
            while (true) {
                n4 = n3;
                if (!iterator.hasNext()) {
                    break;
                }
                n3 += ((Wish)iterator.next()).getLevel();
            }
        }
        else {
            final Iterator iterator2 = this.myBigWishes.iterator();
            while (true) {
                n4 = n;
                if (!iterator2.hasNext()) {
                    break;
                }
                n += ((Wish)iterator2.next()).getLevel();
            }
        }
        return n4;
    }
    
    public void AddTradeHistory(final Map<String, Object> map) {
        this.firebaseDatabase.getReference("tradehistory").push().setValue((Object)(map.get((Object)"sender") + " sent " + map.get((Object)"amount") + "x " + map.get((Object)"item") + " to " + map.get((Object)"recipient") + " on the " + map.get((Object)"date")));
    }
    
    public void CheckEvents() {
        if (this.db != null) {
            if (this.firebaseUser != null) {
                this.Reauthenticate();
            }
            this.db.collection("offercodes").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda29(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda31(this));
            this.db.collection("vaultcodes").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda32(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda34(this));
            this.db.collection("freepro").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda35(this));
            this.db.collection("doublecaskets").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda36(this));
            this.db.collection("weeklygods").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda37(this));
            this.db.collection("weeklyskill").document("highlightedskill").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda38(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda39(this));
            this.db.collection("latestversion").get().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda40(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda30());
            this.activity.secretPathway.GetCurrentPath();
            this.CheckBan();
        }
    }
    
    public void CheckSkillingOutfits() {
        if (this.activity.trainingSkill.equals((Object)"Fishing") && this.weeklySkill.equals((Object)"Fishing") && this.activity.fishing.fishingLocations.contains((Object)this.activity.trainingMethod) && this.activity.combatManager.RandomFloat(0.0f, 2300.0f) <= (int)this.activity.fishing.fishingLocationsLevel.get(this.activity.fishing.fishingLocations.indexOf((Object)this.activity.trainingMethod)) * 1.0E-4f + 0.01f) {
            this.RewardOutfitPiece((String)this.activity.fishing.fishingOutfit.get(new Random().nextInt(this.activity.fishing.fishingOutfit.size())), "Fishing");
        }
        if (this.activity.trainingSkill.equals((Object)"Mining") && this.weeklySkill.equals((Object)"Mining") && this.activity.mining.miningRocks.contains((Object)this.activity.trainingMethod) && this.activity.combatManager.RandomFloat(0.0f, 2300.0f) <= (int)this.activity.mining.miningLocationsLevel.get(this.activity.mining.miningRocks.indexOf((Object)this.activity.trainingMethod)) * 1.0E-4f + 0.01f) {
            this.RewardOutfitPiece((String)this.activity.mining.miningOutfit.get(new Random().nextInt(this.activity.mining.miningOutfit.size())), "Mining");
        }
        if (this.activity.trainingSkill.equals((Object)"Thieving") && this.weeklySkill.equals((Object)"Thieving") && this.activity.thieving.thievingNpc.contains((Object)this.activity.trainingMethod) && this.activity.combatManager.RandomFloat(0.0f, 2300.0f) <= (int)this.activity.thieving.thievingUnlockLevel.get(this.activity.thieving.thievingNpc.indexOf((Object)this.activity.trainingMethod)) * 1.0E-4f + 0.01f) {
            this.RewardOutfitPiece((String)this.activity.thieving.thievingOutfit.get(new Random().nextInt(this.activity.thieving.thievingOutfit.size())), "Thieving");
        }
        if (this.activity.trainingSkill.equals((Object)"Forestry") && this.weeklySkill.equals((Object)"Forestry") && this.activity.forestry.forestTrees.contains((Object)this.activity.trainingMethod) && this.activity.combatManager.RandomFloat(0.0f, 2300.0f) <= 0.01f + 1.0E-4f * (int)this.activity.forestry.forestLevels.get(this.activity.forestry.forestTrees.indexOf((Object)this.activity.trainingMethod))) {
            this.RewardOutfitPiece((String)this.activity.forestry.lumberjackOutfit.get(new Random().nextInt(this.activity.forestry.lumberjackOutfit.size())), "Forestry");
        }
    }
    
    public void CheckSnowball() {
        if (this.firebaseDatabase == null) {
            return;
        }
        final FirebaseUser firebaseUser = this.firebaseUser;
        if (firebaseUser == null) {
            return;
        }
        if (firebaseUser.getDisplayName() == null) {
            return;
        }
        if (this.firebaseUser.getDisplayName().isEmpty()) {
            return;
        }
        if (this.activity.GetRandom(1, 50) > 1) {
            return;
        }
        this.db.collection("userinfo").document(this.firebaseUser.getDisplayName()).update("snowballs", (Object)FieldValue.increment(1L), new Object[0]).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda15(this));
    }
    
    public void CreateOfferCode(final String s, final String s2, final String s3, final boolean b) {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"reward", (Object)s2);
        ((Map)hashMap).put((Object)"amount", (Object)s3);
        ((Map)hashMap).put((Object)"onetimeuse", (Object)b);
        ((Map)hashMap).put((Object)"redeemed", (Object)false);
        this.db.collection("offercodes").document(s).set((Object)hashMap).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda53(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda54(this));
    }
    
    public void CreatePremiumCode(final String s) {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"reward", (Object)"Premium");
        ((Map)hashMap).put((Object)"amount", (Object)"1");
        ((Map)hashMap).put((Object)"onetimeuse", (Object)true);
        ((Map)hashMap).put((Object)"redeemed", (Object)false);
        this.db.collection("offercodes").document(s).set((Object)hashMap).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda57(this, s)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda58(this));
    }
    
    public void CreateUserDoc(final String s) {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"username", (Object)this.activity.currentUsername);
        ((Map)hashMap).put((Object)"id", (Object)this.firebaseUser.getUid());
        final Integer value = 0;
        ((Map)hashMap).put((Object)"bossCoins", (Object)value);
        ((Map)hashMap).put((Object)"referralPoints", (Object)value);
        ((Map)hashMap).put((Object)"friendCoins", (Object)value);
        ((Map)hashMap).put((Object)"friendGifts", (Object)value);
        ((Map)hashMap).put((Object)"eventTokens", (Object)value);
        if (this.activity.playerId != null && !this.activity.playerId.isEmpty()) {
            ((Map)hashMap).put((Object)"playid", (Object)this.activity.playerId);
        }
        this.db.collection("userinfo").document(s).set((Object)hashMap).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda107(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda108(this));
        if (this.banned) {
            this.activity.runOnUiThread((Runnable)new DatabaseManager$$ExternalSyntheticLambda109(this, s));
        }
    }
    
    public void CreateWishes() {
        if (this.myWishes.isEmpty()) {
            for (int i = 0; i < this.wishNames.size(); ++i) {
                this.myWishes.add((Object)new Wish((String)this.wishNames.get(i), 0));
            }
        }
        else if (this.myWishes.size() < this.wishNames.size()) {
            for (int j = this.myWishes.size(); j < this.wishNames.size(); ++j) {
                this.myWishes.add((Object)new Wish((String)this.wishNames.get(j), 0));
            }
        }
        final Iterator iterator = this.myWishes.iterator();
        while (true) {
            final boolean hasNext = iterator.hasNext();
            int n = 3;
            if (!hasNext) {
                break;
            }
            final Wish wish = (Wish)iterator.next();
            final String s = (String)this.wishRarities.get(this.wishNames.indexOf((Object)wish.getName()));
            s.hashCode();
            Label_0333: {
                switch (s.hashCode()) {
                    case 2024019467: {
                        if (!s.equals((Object)"Common")) {
                            break;
                        }
                        break Label_0333;
                    }
                    case 2539714: {
                        if (!s.equals((Object)"Rare")) {
                            break;
                        }
                        n = 2;
                        break Label_0333;
                    }
                    case 2166565: {
                        if (!s.equals((Object)"Epic")) {
                            break;
                        }
                        n = 1;
                        break Label_0333;
                    }
                    case -77594853: {
                        if (!s.equals((Object)"Legendary")) {
                            break;
                        }
                        n = 0;
                        break Label_0333;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    continue;
                }
                case 3: {
                    this.commonWishes.add((Object)wish);
                    continue;
                }
                case 2: {
                    this.rareWishes.add((Object)wish);
                    continue;
                }
                case 1: {
                    this.epicWishes.add((Object)wish);
                    continue;
                }
                case 0: {
                    this.legendaryWishes.add((Object)wish);
                    continue;
                }
            }
        }
        if (this.myBigWishes.isEmpty()) {
            for (int k = 0; k < this.bigWishNames.size(); ++k) {
                this.myBigWishes.add((Object)new Wish((String)this.bigWishNames.get(k), 0));
            }
        }
        else if (this.myBigWishes.size() < this.bigWishNames.size()) {
            for (int l = this.myBigWishes.size(); l < this.bigWishNames.size(); ++l) {
                this.myBigWishes.add((Object)new Wish((String)this.bigWishNames.get(l), 0));
            }
        }
        for (final Wish wish2 : this.myBigWishes) {
            final String s2 = (String)this.bigWishRarities.get(this.bigWishNames.indexOf((Object)wish2.getName()));
            s2.hashCode();
            int n2 = 0;
            Label_0762: {
                switch (s2.hashCode()) {
                    case 2024019467: {
                        if (!s2.equals((Object)"Common")) {
                            break;
                        }
                        n2 = 3;
                        break Label_0762;
                    }
                    case 2539714: {
                        if (!s2.equals((Object)"Rare")) {
                            break;
                        }
                        n2 = 2;
                        break Label_0762;
                    }
                    case 2166565: {
                        if (!s2.equals((Object)"Epic")) {
                            break;
                        }
                        n2 = 1;
                        break Label_0762;
                    }
                    case -77594853: {
                        if (!s2.equals((Object)"Legendary")) {
                            break;
                        }
                        n2 = 0;
                        break Label_0762;
                    }
                }
                n2 = -1;
            }
            switch (n2) {
                default: {
                    continue;
                }
                case 3: {
                    this.commonBigWishes.add((Object)wish2);
                    continue;
                }
                case 2: {
                    this.rareBigWishes.add((Object)wish2);
                    continue;
                }
                case 1: {
                    this.epicBigWishes.add((Object)wish2);
                    continue;
                }
                case 0: {
                    this.legendaryBigWishes.add((Object)wish2);
                    continue;
                }
            }
        }
    }
    
    public void DevBan(final String s) {
        this.ShowConnecting();
        new Thread((Runnable)new DatabaseManager$$ExternalSyntheticLambda89(this, s)).start();
    }
    
    public void DevSend(final String s, final String s2, final String s3) {
        if (s3.matches("^[^a-zA-Z]*$")) {
            this.ShowConnecting();
            new Thread((Runnable)new DatabaseManager$$ExternalSyntheticLambda6(this, s, s2, s3)).start();
        }
        else {
            this.activity.LargePopup(2131166497, "Letters Found", "Come on Banshen, stop sending letter amounts!");
        }
    }
    
    public Trade FindTrade(final String s) {
        for (final Trade trade : this.allTrades) {
            if (trade.getId().equals((Object)s)) {
                return trade;
            }
        }
        return null;
    }
    
    public String GetDate() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d", Locale.UK);
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMMM", Locale.UK);
        final Date date = new Date();
        return this.AddSuffix(simpleDateFormat.format(date)) + " " + simpleDateFormat2.format(date);
    }
    
    public int GetWishLevel(final String s, final String s2) {
        final boolean equals = s2.equals((Object)"Beginner");
        final int n = 0;
        int n2;
        if (equals) {
            final Iterator iterator = this.myWishes.iterator();
            Wish wish;
            do {
                n2 = n;
                if (!iterator.hasNext()) {
                    return n2;
                }
                wish = (Wish)iterator.next();
            } while (!wish.getName().equals((Object)s));
            n2 = wish.getLevel();
        }
        else {
            final Iterator iterator2 = this.myBigWishes.iterator();
            Wish wish2;
            do {
                n2 = n;
                if (!iterator2.hasNext()) {
                    return n2;
                }
                wish2 = (Wish)iterator2.next();
            } while (!wish2.getName().equals((Object)s));
            n2 = wish2.getLevel();
        }
        return n2;
    }
    
    public void GiveReferralPoints(final String s, final long n) {
        if (!s.isEmpty()) {
            if (this.db != null && this.connected) {
                final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
                singleThreadExecutor.execute((Runnable)new DatabaseManager$$ExternalSyntheticLambda82(this, s, n));
                singleThreadExecutor.shutdown();
            }
            else {
                this.LogIt("Error, DB is null");
            }
        }
    }
    
    public void HideConnecting() {
        this.activity.EnableScreen();
        this.activity.HideView((View)this.serverConnecting);
    }
    
    public void Initialize() {
        this.db = FirebaseFirestore.getInstance();
        final FirebaseAuth instance = FirebaseAuth.getInstance();
        this.firebaseAuth = instance;
        this.firebaseUser = instance.getCurrentUser();
        this.CheckEvents();
    }
    
    public void LogAccountInfo(final String s) {
        final FirebaseDatabase firebaseDatabase = this.firebaseDatabase;
        if (firebaseDatabase == null) {
            return;
        }
        if (s == null) {
            return;
        }
        final DatabaseReference child = firebaseDatabase.getReference("usersgold").child(s);
        final HashMap value = new HashMap();
        ((Map)value).put((Object)"gold", (Object)this.activity.totalGems);
        ((Map)value).put((Object)"soulGems", (Object)this.activity.combatManager.slayerInfo.getSoulGems());
        ((Map)value).put((Object)"darkThread", (Object)this.activity.combatManager.slayerInfo.getDarkThread());
        ((Map)value).put((Object)"killcoins", (Object)this.activity.combatManager.slayerInfo.getKillcoins());
        ((Map)value).put((Object)"challengeCoins", (Object)this.activity.dailies.challengeCoins);
        ((Map)value).put((Object)"casketsOpened", (Object)this.activity.accountStats.getCasketsOpened());
        ((Map)value).put((Object)"godItems", (Object)this.activity.accountStats.getGodItemsFound());
        ((Map)value).put((Object)"baseCamp", (Object)this.activity.baseTower.baseTowerLevel);
        ((Map)value).put((Object)"treasureScrolls", (Object)this.activity.accountStats.getScrollsCompleted());
        ((Map)value).put((Object)"monsterKills", (Object)this.activity.accountStats.getAllMonsterKills());
        ((Map)value).put((Object)"inventory", (Object)this.activity.inventoryItems);
        ((Map)value).put((Object)"inventoryAmounts", (Object)this.activity.inventoryAmounts);
        ((Map)value).put((Object)"equipment", (Object)this.activity.combatManager.equippedItems);
        ((Map)value).put((Object)"dailyBonus", (Object)this.activity.dailies.dailyBonus);
        ((Map)value).put((Object)"skills", (Object)this.activity.skillExp);
        ((Map)value).put((Object)"enchantments", (Object)this.activity.itemManager.blessings.getTickets());
        ((Map)value).put((Object)"stash", (Object)this.activity.baseTower.stashItems);
        ((Map)value).put((Object)"stashAmounts", (Object)this.activity.baseTower.stashAmounts);
        ((Map)value).put((Object)"eventCurrency", (Object)this.activity.holidayCurrency);
        ((Map)value).put((Object)"titles", (Object)this.activity.myTitles);
        ((Map)value).put((Object)"accountType", (Object)this.activity.accountType);
        ((Map)value).put((Object)"totalSafes", (Object)this.activity.accountStats.getSafesCracked());
        ((Map)value).put((Object)"empyreonSafes", (Object)this.activity.accountStats.getEmpyreonSafesCracked());
        ((Map)value).put((Object)"skipTickets", DatabaseManager$$ExternalSyntheticBackport0.m((Object)this.activity.secretPathway.myPath.getGoldenTickets(), (Object)0L));
        ((Map)value).put((Object)"energyUsed", (Object)this.activity.accountStats.getEnergyUsed());
        ((Map)value).put((Object)"specialCurrency", DatabaseManager$$ExternalSyntheticBackport0.m((Object)this.activity.treasureHunts.eventPresent.getSpecialCurrency(), (Object)0L));
        ((Map)value).put((Object)"specialCurrencyOpened", DatabaseManager$$ExternalSyntheticBackport0.m((Object)this.activity.treasureHunts.eventPresent.getSpecialCurrencyOpened(), (Object)0L));
        ((Map)value).put((Object)"activeAvatar", (Object)this.activity.activeAvatar);
        ((Map)value).put((Object)"userId", (Object)this.firebaseUser.getUid());
        final FirebaseUserMetadata metadata = this.firebaseUser.getMetadata();
        if (metadata != null) {
            ((Map)value).put((Object)"creationDate", (Object)this.activity.formatDateWithSuffix(metadata.getCreationTimestamp()));
        }
        ((Map)value).put((Object)"itemsCrafted", (Object)this.activity.accountStats.getItemsCrafted());
        ((Map)value).put((Object)"lastStore", (Object)ServerValue.TIMESTAMP);
        child.setValue((Object)value);
        this.LogFriendsData(s);
    }
    
    public void LogIt(final String s) {
        Log.e("Firestore", s);
    }
    
    public void LogSnowball(final String s) {
        final FirebaseUser firebaseUser = this.firebaseUser;
        if (firebaseUser == null) {
            return;
        }
        if (firebaseUser.getDisplayName() == null) {
            return;
        }
        if (this.firebaseDatabase == null) {
            return;
        }
        if (s == null) {
            return;
        }
        if (s.isEmpty()) {
            return;
        }
        final DatabaseReference push = this.firebaseDatabase.getReference("snowballs").push();
        final HashMap value = new HashMap();
        ((Map)value).put((Object)"sender", (Object)this.firebaseUser.getDisplayName());
        ((Map)value).put((Object)"recipient", (Object)s);
        ((Map)value).put((Object)"timestamp", (Object)ServerValue.TIMESTAMP);
        push.setValue((Object)value);
    }
    
    public void OpenCommunityVault() {
        if (this.communityVaultScreen == null) {
            this.communityVaultScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131296470)).inflate();
            final ScrollView communityVaultScreen = (ScrollView)this.activity.findViewById(2131296469);
            this.communityVaultScreen = communityVaultScreen;
            this.currentRequest = (RelativeLayout)communityVaultScreen.findViewById(2131296506);
            this.milestoneReward = (RelativeLayout)this.communityVaultScreen.findViewById(2131296849);
            this.donationAmount = (EditText)this.communityVaultScreen.findViewById(2131296563);
            this.vaultDonate = (TextView)this.communityVaultScreen.findViewById(2131297310);
            this.myDonations = (TextView)this.communityVaultScreen.findViewById(2131296892);
            this.donationNotice = (TextView)this.communityVaultScreen.findViewById(2131296564);
            this.refreshProgress = (TextView)this.communityVaultScreen.findViewById(2131297030);
        }
        this.activity.EnableLayout((ViewGroup)this.communityVaultScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.communityVaultScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.maxDonation = this.communityVault.getRequiredAmount() / 100L;
        final RelativeLayout currentRequest = this.currentRequest;
        final int n = 2;
        ((TextView)currentRequest.getChildAt(2)).setText((CharSequence)("Requested Amount: " + this.activity.FormatExp(this.communityVault.getRequiredAmount())));
        ((TextView)this.currentRequest.getChildAt(1)).setText((CharSequence)("Requested Item: " + this.communityVault.getRequiredItem()));
        final String reward = this.communityVault.getReward();
        reward.hashCode();
        int n2 = 0;
        Label_0546: {
            switch (reward.hashCode()) {
                case 1361763894: {
                    if (!reward.equals((Object)"Yellow Treat Bag")) {
                        break;
                    }
                    n2 = 6;
                    break Label_0546;
                }
                case 658894417: {
                    if (!reward.equals((Object)"Gold Coin")) {
                        break;
                    }
                    n2 = 5;
                    break Label_0546;
                }
                case 429263516: {
                    if (!reward.equals((Object)"Blue Treat Bag")) {
                        break;
                    }
                    n2 = 4;
                    break Label_0546;
                }
                case 224325123: {
                    if (!reward.equals((Object)"Golden Ticket")) {
                        break;
                    }
                    n2 = 3;
                    break Label_0546;
                }
                case 71018769: {
                    if (!reward.equals((Object)"Soul Gems")) {
                        break;
                    }
                    n2 = 2;
                    break Label_0546;
                }
                case -1326946875: {
                    if (!reward.equals((Object)"Challenge Coins")) {
                        break;
                    }
                    n2 = 1;
                    break Label_0546;
                }
                case -1793434157: {
                    if (!reward.equals((Object)"Red Treat Bag")) {
                        break;
                    }
                    n2 = 0;
                    break Label_0546;
                }
            }
            n2 = -1;
        }
        final int n3 = 2131165871;
        int intValue = 0;
        switch (n2) {
            default: {
                try {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)this.communityVault.getReward()));
                }
                catch (final IndexOutOfBoundsException ex) {
                    intValue = 2131166497;
                }
                break;
            }
            case 6: {
                intValue = 2131166355;
                break;
            }
            case 5: {
                intValue = 2131165871;
                break;
            }
            case 4: {
                intValue = 2131165623;
                break;
            }
            case 3: {
                intValue = 2131165478;
                break;
            }
            case 2: {
                intValue = 2131166237;
                break;
            }
            case 1: {
                intValue = 2131165354;
                break;
            }
            case 0: {
                intValue = 2131166136;
                break;
            }
        }
        ((ImageView)this.milestoneReward.getChildAt(0)).setImageDrawable(this.activity.GetImage(intValue));
        ((TextView)this.milestoneReward.getChildAt(1)).setText((CharSequence)(this.communityVault.getReward() + " x" + this.activity.FormatExp(this.communityVault.getRewardAmount())));
        this.donationAmount.setText((CharSequence)"");
        final String requiredItem = this.communityVault.getRequiredItem();
        requiredItem.hashCode();
        int n4 = 0;
        Label_0913: {
            switch (requiredItem.hashCode()) {
                case 658894417: {
                    if (!requiredItem.equals((Object)"Gold Coin")) {
                        break;
                    }
                    n4 = 3;
                    break Label_0913;
                }
                case 444298052: {
                    n4 = n;
                    if (!requiredItem.equals((Object)"Killcoins")) {
                        break;
                    }
                    break Label_0913;
                }
                case 71018769: {
                    if (!requiredItem.equals((Object)"Soul Gems")) {
                        break;
                    }
                    n4 = 1;
                    break Label_0913;
                }
                case -1144442577: {
                    if (!requiredItem.equals((Object)"Silver Coins")) {
                        break;
                    }
                    n4 = 0;
                    break Label_0913;
                }
            }
            n4 = -1;
        }
        int intValue2 = n3;
        while (true) {
            switch (n4) {
                default: {
                    intValue2 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)this.communityVault.getRequiredItem()));
                }
                case 3: {
                    ((ImageView)this.currentRequest.getChildAt(0)).setImageDrawable(this.activity.GetImage(intValue2));
                    this.vaultDonate.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda78(this));
                    this.refreshProgress.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda79(this));
                    this.UpdateCommunityVault();
                    return;
                }
                case 2: {
                    intValue2 = 2131165924;
                    continue;
                }
                case 1: {
                    intValue2 = 2131166237;
                    continue;
                }
                case 0: {
                    intValue2 = 2131166220;
                    continue;
                }
            }
            break;
        }
    }
    
    public void OpenTrades() {
        if (this.UnlockedTrade()) {
            if (this.firebaseUser == null) {
                this.activity.QuickPopup("You need an online account to trade with other players, you can create one via Game Settings.");
            }
            else {
                if (this.firebaseDatabase == null || this.tradeRef == null) {
                    this.SetupDb();
                }
                if (this.versionCode < this.latestVersion) {
                    this.activity.QuickPopup("You must be on the latest version of the game in order to trade!");
                    return;
                }
                if (!this.AllowedTrade()) {
                    this.activity.QuickPopup("You can access trade once your online account is atleast 3 days old");
                    return;
                }
                if (this.tradeScreen == null) {
                    this.tradeScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297267)).inflate();
                    final ScrollView tradeScreen = (ScrollView)this.activity.findViewById(2131297266);
                    this.tradeScreen = tradeScreen;
                    this.ts_username = (TextView)tradeScreen.findViewById(2131297296);
                    this.ts_sendrequest = (TextView)this.tradeScreen.findViewById(2131297292);
                    this.ts_playername = (EditText)this.tradeScreen.findViewById(2131297289);
                    this.ts_activeTrades = (LinearLayout)this.tradeScreen.findViewById(2131297285);
                    this.ts_itemSend = (TextView)this.tradeScreen.findViewById(2131297287);
                    this.ts_itemSendAmount = (EditText)this.tradeScreen.findViewById(2131297288);
                    this.ts_setMax = (TextView)this.tradeScreen.findViewById(2131297294);
                    this.ts_reloadtrades = (TextView)this.tradeScreen.findViewById(2131297290);
                    this.ts_sentItems = (LinearLayout)this.tradeScreen.findViewById(2131297293);
                    this.ts_tradeLimit = (TextView)this.tradeScreen.findViewById(2131297295);
                    this.ts_adminSend = (TextView)this.tradeScreen.findViewById(2131297286);
                    this.ts_sendFriend = (TextView)this.tradeScreen.findViewById(2131297291);
                    this.ts_activeGifts = (LinearLayout)this.tradeScreen.findViewById(2131297284);
                }
                this.ts_tradeLimit.setText((CharSequence)("You have " + (this.maxDailyTrades - this.tradesSent) + " trades remaining today"));
                this.tradeScreen.findViewById(2131296764).setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda144(this));
                this.activity.EnableLayout((ViewGroup)this.tradeScreen);
                this.ts_username.setText((CharSequence)("Trade Name: " + (String)DatabaseManager$$ExternalSyntheticBackport0.m((Object)this.firebaseUser.getDisplayName(), (Object)"Error")));
                this.UpdatePlayerTrades();
                this.UpdateSentTrades();
                this.ts_adminSend.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda145(this));
                this.ts_sendFriend.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda146(this));
                this.ts_itemSend.setText((CharSequence)"Select an item to send...");
                this.ts_itemSend.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda147(this));
                this.ts_setMax.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda148(this));
                final MainActivity activity = this.activity;
                activity.HideView(activity.currentView);
                this.activity.currentView = (View)this.tradeScreen;
                final MainActivity activity2 = this.activity;
                activity2.ShowView(activity2.currentView);
                this.ts_sendrequest.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda149(this));
                this.ts_reloadtrades.setOnClickListener((View$OnClickListener)new DatabaseManager$$ExternalSyntheticLambda1(this));
            }
        }
        else {
            this.activity.QuickPopup("You must have 500 Total Level and be Premium to use Player Trading.");
        }
    }
    
    public void OpenVault() {
        if (this.vaultScreen == null) {
            this.vaultScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297312)).inflate();
            this.vaultScreen = (ScrollView)this.activity.findViewById(2131297311);
        }
        this.activity.EnableLayout((ViewGroup)this.vaultScreen);
        this.currentReward = (LinearLayout)this.vaultScreen.findViewById(2131296507);
        this.chancesRemaining = (TextView)this.vaultScreen.findViewById(2131296434);
        this.increaseNumbers = (LinearLayout)this.vaultScreen.findViewById(2131296746);
        this.currentGuessNumbers = (LinearLayout)this.vaultScreen.findViewById(2131296504);
        this.lowerNumbers = (LinearLayout)this.vaultScreen.findViewById(2131296800);
        this.getMoreChances = (TextView)this.vaultScreen.findViewById(2131296687);
        this.openButton = (TextView)this.vaultScreen.findViewById(2131296930);
        this.codeResult = (TextView)this.vaultScreen.findViewById(2131296458);
        if (this.increaseNumbers.getChildCount() == 0) {
            this.GenerateViews();
        }
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.vaultScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        if (this.vaultChances > 200) {
            this.vaultChances = 200;
        }
        this.chancesRemaining.setText((CharSequence)("Chances Remaining: " + this.vaultChances));
        this.codeResult.setText((CharSequence)"Hit open to input your code to the vault");
        final LinearLayout currentReward = this.currentReward;
        int n = 0;
        ((TextView)currentReward.getChildAt(0)).setText((CharSequence)("Vault Date: " + this.vaultCode.getCreationDate()));
        ((TextView)this.currentReward.getChildAt(3)).setText((CharSequence)(this.vaultCode.getReward() + " x" + this.activity.FormatExp(this.vaultCode.getRewardAmount())));
        final String reward = this.vaultCode.getReward();
        reward.hashCode();
        Label_0710: {
            switch (reward.hashCode()) {
                case 1361763894: {
                    if (!reward.equals((Object)"Yellow Treat Bag")) {
                        break;
                    }
                    n = 10;
                    break Label_0710;
                }
                case 880990999: {
                    if (!reward.equals((Object)"Event Currency")) {
                        break;
                    }
                    n = 9;
                    break Label_0710;
                }
                case 712033232: {
                    if (!reward.equals((Object)"Golden Cracker")) {
                        break;
                    }
                    n = 8;
                    break Label_0710;
                }
                case 658894417: {
                    if (!reward.equals((Object)"Gold Coin")) {
                        break;
                    }
                    n = 7;
                    break Label_0710;
                }
                case 444298052: {
                    if (!reward.equals((Object)"Killcoins")) {
                        break;
                    }
                    n = 6;
                    break Label_0710;
                }
                case 429263516: {
                    if (!reward.equals((Object)"Blue Treat Bag")) {
                        break;
                    }
                    n = 5;
                    break Label_0710;
                }
                case 224325123: {
                    if (!reward.equals((Object)"Golden Ticket")) {
                        break;
                    }
                    n = 4;
                    break Label_0710;
                }
                case 65287138: {
                    if (!reward.equals((Object)"Coins")) {
                        break;
                    }
                    n = 3;
                    break Label_0710;
                }
                case -819624483: {
                    if (!reward.equals((Object)"Casket of Treasure")) {
                        break;
                    }
                    n = 2;
                    break Label_0710;
                }
                case -1326946875: {
                    if (!reward.equals((Object)"Challenge Coins")) {
                        break;
                    }
                    n = 1;
                    break Label_0710;
                }
                case -1793434157: {
                    if (!reward.equals((Object)"Red Treat Bag")) {
                        break;
                    }
                    break Label_0710;
                }
            }
            n = -1;
        }
        int n2 = 0;
        switch (n) {
            default: {
                try {
                    n2 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)this.vaultCode.getReward()));
                }
                catch (final IndexOutOfBoundsException ex) {
                    n2 = 2131166497;
                }
                break;
            }
            case 10: {
                n2 = 2131166355;
                break;
            }
            case 9: {
                n2 = (int)this.activity.eventIcons.get(this.activity.eventCurrecies.indexOf((Object)this.activity.currentHolidayCurrency));
                break;
            }
            case 8: {
                n2 = 2131165873;
                break;
            }
            case 7: {
                n2 = 2131165871;
                break;
            }
            case 6: {
                n2 = 2131165924;
                break;
            }
            case 5: {
                n2 = 2131165623;
                break;
            }
            case 4: {
                n2 = 2131165478;
                break;
            }
            case 3: {
                n2 = 2131166220;
                break;
            }
            case 2: {
                n2 = 2131165669;
                break;
            }
            case 1: {
                n2 = 2131165354;
                break;
            }
            case 0: {
                n2 = 2131166136;
                break;
            }
        }
        ((ImageView)this.currentReward.getChildAt(1)).setImageDrawable(this.activity.GetImage(n2));
        if (this.vaultCodesClaimed.contains((Object)this.vaultCode.getCode())) {
            this.openButton.setAlpha(0.4f);
            this.openButton.setText((CharSequence)"Cracked");
        }
        this.ResetNumbers();
        this.VaultListeners();
    }
    
    public void OpenWishes(final String s) {
        if (this.wishScreen == null) {
            this.wishScreen = (ConstraintLayout)((ViewStub)this.activity.findViewById(2131297340)).inflate();
            final ConstraintLayout wishScreen = (ConstraintLayout)this.activity.findViewById(2131297339);
            this.wishScreen = wishScreen;
            this.wishes_common = (LinearLayout)wishScreen.findViewById(2131297343);
            this.wishes_rare = (LinearLayout)this.wishScreen.findViewById(2131297347);
            this.wishes_epic = (LinearLayout)this.wishScreen.findViewById(2131297344);
            this.wishes_legendary = (LinearLayout)this.wishScreen.findViewById(2131297345);
            this.wishes_new = (LinearLayout)this.wishScreen.findViewById(2131297346);
            this.changeWell = (TextView)this.wishScreen.findViewById(2131296437);
        }
        this.UpdateWishes(s);
        if (s.equals((Object)"Beginner")) {
            this.changeWell.setText((CharSequence)"View Endgame Wishing Well");
        }
        else {
            this.changeWell.setText((CharSequence)"View Beginner Wishing Well");
        }
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.wishScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.activity.DisableScreen();
        this.activity.currentView.post((Runnable)new DatabaseManager$$ExternalSyntheticLambda83(this, s));
    }
    
    public void Reauthenticate() {
        this.firebaseUser.reload().addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda25(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda26(this));
    }
    
    public void SetupDb() {
        final FirebaseDatabase instance = FirebaseDatabase.getInstance();
        this.firebaseDatabase = instance;
        this.tradeRef = instance.getReference("trades");
        this.referrals = new Referrals(this.activity, this);
        ((ConnectivityManager)this.activity.getSystemService("connectivity")).registerDefaultNetworkCallback((ConnectivityManager$NetworkCallback)new ConnectivityManager$NetworkCallback(this) {
            final DatabaseManager this$0;
            
            public void onAvailable(final Network network) {
                this.this$0.connected = true;
            }
            
            public void onLost(final Network network) {
                if (this.this$0.connected) {
                    this.this$0.connected = false;
                    this.this$0.activity.runOnUiThread((Runnable)new DatabaseManager$2$$ExternalSyntheticLambda0(this));
                }
            }
            
            public void onUnavailable() {
                this.this$0.connected = false;
            }
        });
        final Query limitToFirst = this.tradeRef.orderByChild("recipient").equalTo(this.firebaseUser.getDisplayName()).limitToFirst(5);
        final Query limitToFirst2 = this.firebaseDatabase.getReference("bannedusers").orderByChild("username").equalTo(this.firebaseUser.getDisplayName()).limitToFirst(1);
        if (!this.activity.accountType.equals((Object)"Ironman")) {
            final int latestVersion = this.latestVersion;
            if (latestVersion < 0) {
                this.SetupListener(limitToFirst);
            }
            else if (this.versionCode >= latestVersion) {
                this.SetupListener(limitToFirst);
            }
        }
        limitToFirst2.addValueEventListener((ValueEventListener)new ValueEventListener(this) {
            final DatabaseManager this$0;
            
            public void onCancelled(final DatabaseError databaseError) {
                this.this$0.activity.LogIt("Event listener cancelled: ");
            }
            
            public void onDataChange(final DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    final DatabaseManager this$0 = this.this$0;
                    this$0.UserBanned(this$0.firebaseUser.getDisplayName());
                }
            }
        });
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute((Runnable)new DatabaseManager$$ExternalSyntheticLambda125(this));
        singleThreadExecutor.shutdown();
    }
    
    public void ShowConnecting() {
        this.activity.DisableScreen();
        if (this.serverConnecting == null) {
            this.serverConnecting = (TextView)this.activity.findViewById(2131297102);
        }
        this.activity.ShowView((View)this.serverConnecting);
    }
    
    public void SignIn() {
        if (!this.activity.userAuth.isEmpty() && this.firebaseUser == null) {
            this.CompleteSignIn();
        }
    }
    
    public void StoreIdleGain(final String s, final String s2, final String s3) {
        final FirebaseUser firebaseUser = this.firebaseUser;
        if (firebaseUser == null) {
            return;
        }
        if (firebaseUser.getDisplayName() == null) {
            return;
        }
        final FirebaseDatabase firebaseDatabase = this.firebaseDatabase;
        if (firebaseDatabase == null) {
            return;
        }
        final DatabaseReference push = firebaseDatabase.getReference("idlegains").push();
        final HashMap value = new HashMap();
        ((Map)value).put((Object)"username", (Object)this.firebaseUser.getDisplayName());
        ((Map)value).put((Object)"skill", (Object)s);
        ((Map)value).put((Object)"method", (Object)s2);
        ((Map)value).put((Object)"idleTime", (Object)s3);
        ((Map)value).put((Object)"timestamp", (Object)ServerValue.TIMESTAMP);
        push.setValue((Object)value);
    }
    
    public void StorePurchase(final Purchase purchase) {
        if (purchase == null) {
            return;
        }
        if (this.firebaseDatabase != null) {
            final FirebaseUser firebaseUser = this.firebaseUser;
            if (firebaseUser != null) {
                final String displayName = firebaseUser.getDisplayName();
                if (displayName == null) {
                    return;
                }
                final DatabaseReference push = this.firebaseDatabase.getReference("purchases").push();
                final HashMap value = new HashMap();
                ((Map)value).put((Object)"userId", (Object)displayName);
                ((Map)value).put((Object)"orderId", DatabaseManager$$ExternalSyntheticBackport0.m((Object)purchase.getOrderId(), (Object)"N/A"));
                ((Map)value).put((Object)"item", DatabaseManager$$ExternalSyntheticBackport0.m((Object)purchase.getProducts().get(0), (Object)"N/A"));
                push.setValue((Object)value);
            }
        }
    }
    
    public boolean UnlockedTrade() {
        return this.activity.GetTotalLevel() >= 500 && this.activity.members;
    }
    
    public void UpdateCode(final OfferCode offerCode) {
        this.db.collection("offercodes").document(offerCode.getCode()).update("redeemed", (Object)true, new Object[0]).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda27(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda28(this));
    }
    
    public void UpdateVault(final String s, final String s2, String createCode) {
        final String getDate = this.GetDate();
        createCode = this.CreateCode(createCode);
        this.db.collection("vaultcodes").document(this.vaultDocId).update("reward", (Object)s, new Object[] { "rewardAmount", s2, "creationDate", getDate, "code", createCode }).addOnSuccessListener((OnSuccessListener)new DatabaseManager$$ExternalSyntheticLambda65(this)).addOnFailureListener((OnFailureListener)new DatabaseManager$$ExternalSyntheticLambda66(this));
    }
    
    public boolean allWishesMaxed(final String s) {
        final boolean equals = s.equals((Object)"Beginner");
        boolean b = false;
        if (equals) {
            if (this.myWishes.isEmpty()) {
                return false;
            }
            for (int i = 0; i < this.myWishes.size(); ++i) {
                if (((Wish)this.myWishes.get(i)).getLevel() < (int)this.wishMaxLevels.get(this.wishNames.indexOf((Object)((Wish)this.myWishes.get(i)).getName()))) {
                    return b;
                }
            }
        }
        else {
            if (this.myBigWishes.isEmpty()) {
                return false;
            }
            for (int j = 0; j < this.myBigWishes.size(); ++j) {
                if (((Wish)this.myBigWishes.get(j)).getLevel() < (int)this.bigWishMaxLevels.get(this.bigWishNames.indexOf((Object)((Wish)this.myBigWishes.get(j)).getName()))) {
                    return b;
                }
            }
        }
        b = true;
        return b;
    }
    
    public OfferCode codeExists(final String s) {
        for (final OfferCode offerCode : this.offerCodes) {
            if (offerCode.getCode().equals((Object)s)) {
                return offerCode;
            }
        }
        return null;
    }
    
    public static class CommunityVault
    {
        boolean available;
        boolean completed;
        String id;
        long requiredAmount;
        String requiredItem;
        String reward;
        long rewardAmount;
        long totalDonations;
        
        public CommunityVault(final String id, final String reward, final String requiredItem, final boolean available, final boolean completed, final long requiredAmount, final long rewardAmount, final long totalDonations) {
            this.id = id;
            this.reward = reward;
            this.requiredItem = requiredItem;
            this.available = available;
            this.completed = completed;
            this.requiredAmount = requiredAmount;
            this.rewardAmount = rewardAmount;
            this.totalDonations = totalDonations;
        }
        
        public String getId() {
            return this.id;
        }
        
        public long getRequiredAmount() {
            return this.requiredAmount;
        }
        
        public String getRequiredItem() {
            return this.requiredItem;
        }
        
        public String getReward() {
            return this.reward;
        }
        
        public long getRewardAmount() {
            return this.rewardAmount;
        }
        
        public long getTotalDonations() {
            return this.totalDonations;
        }
        
        public boolean isAvailable() {
            return this.available;
        }
        
        public boolean isCompleted() {
            return this.completed;
        }
    }
    
    public static class Currencies
    {
        long bossCoins;
        long eventTokens;
        long friendCoins;
        long friendGifts;
        long referralPoints;
        long snowballs;
        
        public Currencies(final long bossCoins, final long referralPoints, final long friendCoins, final long friendGifts, final long snowballs, final long eventTokens) {
            this.bossCoins = bossCoins;
            this.referralPoints = referralPoints;
            this.friendCoins = friendCoins;
            this.friendGifts = friendGifts;
            this.snowballs = snowballs;
            this.eventTokens = eventTokens;
        }
        
        public long getBossCoins() {
            return this.bossCoins;
        }
        
        public long getEventTokens() {
            return this.eventTokens;
        }
        
        public long getFriendCoins() {
            return this.friendCoins;
        }
        
        public long getFriendGifts() {
            return this.friendGifts;
        }
        
        public long getReferralPoints() {
            return this.referralPoints;
        }
        
        public long getSnowballs() {
            return this.snowballs;
        }
    }
    
    public static class OfferCode
    {
        String code;
        boolean oneTimeUse;
        String reward;
        String rewardAmount;
        boolean used;
        
        public OfferCode(final String code, final String reward, final String rewardAmount, final boolean oneTimeUse, final boolean used) {
            this.reward = reward;
            this.code = code;
            this.rewardAmount = rewardAmount;
            this.oneTimeUse = oneTimeUse;
            this.used = used;
        }
        
        public String getCode() {
            return this.code;
        }
        
        public String getReward() {
            return this.reward;
        }
        
        public int getRewardAmount() {
            return Integer.parseInt(this.rewardAmount);
        }
        
        public boolean isOneTimeUse() {
            return this.oneTimeUse;
        }
        
        public boolean isUsed() {
            return this.used;
        }
    }
    
    public static class Trade
    {
        String date;
        String id;
        String item;
        String itemAmount;
        String recipient;
        String sender;
        
        public Trade(final String id, final String sender, final String recipient, final String item, final String itemAmount, final String date) {
            this.id = id;
            this.recipient = recipient;
            this.sender = sender;
            this.item = item;
            this.itemAmount = itemAmount;
            this.date = date;
        }
        
        public String getDate() {
            return this.date;
        }
        
        public String getId() {
            return this.id;
        }
        
        public String getItem() {
            return this.item;
        }
        
        public String getItemAmount() {
            return this.itemAmount;
        }
        
        public String getRecipient() {
            return this.recipient;
        }
        
        public String getSender() {
            return this.sender;
        }
    }
    
    public static class VaultCode
    {
        String code;
        String creationDate;
        String reward;
        long rewardAmount;
        
        public VaultCode(final String code, final String reward, final String creationDate, final long rewardAmount) {
            this.code = code;
            this.reward = reward;
            this.creationDate = creationDate;
            this.rewardAmount = rewardAmount;
        }
        
        public String getCode() {
            return this.code;
        }
        
        public String getCreationDate() {
            return this.creationDate;
        }
        
        public String getReward() {
            return this.reward;
        }
        
        public long getRewardAmount() {
            return this.rewardAmount;
        }
    }
    
    public static class Wish
    {
        int level;
        String name;
        
        public Wish(final String name, final int level) {
            this.name = name;
            this.level = level;
        }
        
        public int getLevel() {
            return this.level;
        }
        
        public String getName() {
            return this.name;
        }
    }
}
