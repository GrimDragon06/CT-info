package uk.playdrop.cherrytree_idletextrpg;

import com.google.android.gms.games.PlayGamesSdk;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import com.google.android.gms.games.Player;
import java.io.IOException;
import android.graphics.BitmapFactory;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange$Builder;
import com.google.android.gms.games.SnapshotsClient$DataOrConflict;
import com.google.android.gms.games.snapshot.Snapshot;
import android.widget.GridLayout$LayoutParams;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.tasks.Task;
import java.util.HashSet;
import java.util.function.Function;
import java.util.Comparator;
import android.os.Looper;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.SystemClock;
import com.google.android.gms.tasks.OnSuccessListener;
import android.text.SpannableString;
import java.util.Map$Entry;
import com.google.android.gms.tasks.Continuation;
import com.android.billingclient.api.BillingFlowParams$ProductDetailsParams;
import com.android.billingclient.api.BillingFlowParams;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.gson.reflect.TypeToken;
import android.util.Log;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.google.common.collect.ImmutableList;
import com.android.billingclient.api.QueryProductDetailsParams$Product;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.PendingPurchasesParams;
import android.view.inputmethod.InputMethodManager;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.Purchase;
import java.util.concurrent.TimeUnit;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.text.NumberFormat;
import java.util.Iterator;
import android.widget.RelativeLayout$LayoutParams;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.content.DialogInterface;
import androidx.core.util.Consumer;
import java.util.concurrent.atomic.AtomicReference;
import androidx.core.text.HtmlCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import android.app.Activity;
import com.google.android.gms.games.PlayGames;
import com.google.firebase.auth.FirebaseUserMetadata;
import java.util.Locale;
import com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails;
import android.view.ViewStub;
import java.util.Collections;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup;
import android.content.Context;
import com.squareup.picasso.Picasso;
import java.util.Objects;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import android.view.View$OnClickListener;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import java.util.concurrent.Future;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import java.util.concurrent.Executors;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import java.util.concurrent.ScheduledExecutorService;
import android.content.SharedPreferences;
import java.util.Random;
import android.widget.EditText;
import android.view.LayoutInflater;
import com.android.billingclient.api.ProductDetails;
import com.google.android.gms.games.GamesSignInClient;
import android.os.Handler;
import com.google.firebase.analytics.FirebaseAnalytics;
import android.widget.ImageView;
import android.os.CountDownTimer;
import android.content.SharedPreferences$Editor;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.GridLayout;
import android.widget.ScrollView;
import com.android.billingclient.api.BillingClient;
import java.util.concurrent.ExecutorService;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout;
import java.util.List;
import com.google.gson.Gson;
import com.android.billingclient.api.PurchasesUpdatedListener;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PurchasesUpdatedListener
{
    static final boolean $assertionsDisabled = false;
    private static final Gson gson;
    List<String> accountNames;
    Statistic accountStats;
    String accountType;
    int activeAvatar;
    int activeCharacter;
    int activePopups;
    String activeTitle;
    Alchemy alchemy;
    LinearLayout alchemyList;
    int alchemyMakeX;
    TextView alchemyMakeXButton;
    RelativeLayout alchemySkillProgress;
    TextView alchemySpinner;
    List<String> allItems;
    List<Integer> allItemsAttackBonus;
    List<Integer> allItemsDefenceBonus;
    List<String> allItemsDescriptions;
    List<Integer> allItemsFarmingLevel;
    List<Integer> allItemsHealingAmount;
    List<Integer> allItemsHealthBonus;
    List<Integer> allItemsIcons;
    List<String> allItemsRarity;
    List<Integer> allItemsStrengthBonus;
    List<String> allItemsTypes;
    List<Long> allItemsValues;
    List<View> allViews;
    LinearLayout apothocaryScreen;
    List<Integer> areaIcons;
    List<String> areas;
    int attackBonus;
    ProgressBar attackSpeedBar;
    boolean attemptingBackup;
    boolean autoEat;
    List<Integer> avatarIcons;
    List<String> avatarNames;
    ExecutorService backgroundExecutor;
    int baseMaxStamina;
    BaseTower baseTower;
    TextView battleUpdates;
    BillingClient billingClient;
    boolean billingInitialized;
    LinearLayout bottomNav;
    int burnX;
    TextView changeAvatar;
    TextView changeTitle;
    List<String> chestLoot;
    LinearLayout chestLootScreen;
    List<Integer> chestMaxLoot;
    List<Integer> chestMinLoot;
    boolean claimedGift;
    RelativeLayout closeItemSelect;
    TextView closePro;
    TextView cloudSaves;
    TextView coins;
    LinearLayout combatButtons;
    long combatExp;
    CombatManager combatManager;
    ScrollView combatScreen;
    RelativeLayout combatSkillProgress;
    TextView combatSlayerProgress;
    LinearLayout combat_battleInfo;
    LinearLayout combat_combatStyles;
    LinearLayout combat_enemyInfo;
    LinearLayout combat_enemySpeed;
    RelativeLayout combat_myHealth;
    Cooking cooking;
    Crafting crafting;
    int craftingMakeX;
    TextView craftingMakeXButton;
    RelativeLayout craftingSkillProgress;
    List<RelativeLayout> craftingWraps;
    TextView createAccountButton;
    ScrollView createAccountScreen;
    long cropsFarmed;
    TextView currentArrows;
    String currentAttackStyle;
    String currentEvent;
    long currentEventCurrency;
    String currentFletchingCategory;
    int currentHealth;
    String currentHolidayCurrency;
    List<String> currentLoot;
    List<Long> currentLootAmounts;
    int currentStamina;
    String currentUsername;
    View currentView;
    String currentWorkshopCategory;
    Dailies dailies;
    DatabaseManager databaseManager;
    int defenceBonus;
    GridLayout devTools;
    DevTools developerTools;
    Discovery discovery;
    ScrollView discoveryScreen;
    LinearLayout discoveryWrap;
    ConstraintLayout donateInfo;
    TextView donateToSanta;
    int doubleFish;
    int doublePotions;
    List<Integer> dropMax;
    List<Integer> dropMin;
    List<String> dropRarity;
    List<String> drops;
    LinearLayout dungeonWrap;
    ScrollView dungeonsScreen;
    TextView eatFood;
    SharedPreferences$Editor ed;
    ProgressBar enemyAttackSpeedBar;
    CountDownTimer enemyAttackTimer;
    TextView enemyCombatLevelTv;
    int enemyCurrentHealth;
    TextView enemyDamageUpdates;
    ProgressBar enemyHealthBar;
    TextView enemyHealthTv;
    ImageView enemyImage;
    int enemyMaxHealth;
    TextView enemyNameTv;
    LinearLayout enemyWrap;
    int equipmentHeight;
    List<Integer> equipmentPlaceholders;
    LinearLayout equipmentPresets;
    ScrollView equipmentScreen;
    String equippedFood;
    ImageView ev_arrows;
    ImageView ev_blessing;
    ImageView ev_boots;
    ImageView ev_cape;
    ImageView ev_gloves;
    ImageView ev_greaves;
    ImageView ev_helm;
    ImageView ev_necklace;
    ImageView ev_pet;
    ImageView ev_ring;
    ImageView ev_shield;
    ImageView ev_top;
    ImageView ev_weapon;
    Event event;
    List<String> eventCurrecies;
    String eventCurrency;
    LinearLayout eventCurrencyWrap;
    boolean eventDoubleDrops;
    int eventIcon;
    List<Integer> eventIcons;
    ScrollView eventScreen;
    int expMultiplier;
    int exploreItems;
    int faded;
    Farming farming;
    List<RelativeLayout> farmingSpots;
    int farmingTimer;
    FirebaseAnalytics firebaseAnalytics;
    long fishBurnt;
    long fishCaught;
    long fishCooked;
    Fishing fishing;
    int fishingExpBoost;
    int fishingRodLevel;
    LinearLayout fishingScreen;
    RelativeLayout fishingSkillProgress;
    LinearLayout fishingWrap;
    Fletching fletching;
    int fletchingMakeX;
    List<Integer> foodItemHealing;
    List<String> foodItems;
    LinearLayout forestScreen;
    Forestry forestry;
    RelativeLayout forestrySkillProgress;
    LinearLayout forestryWrap;
    Friends friends;
    Funimator funimator;
    boolean gameLoaded;
    long gameStartTime;
    Handler gameTick;
    GamesSignInClient gamesSignInClient;
    TextView gems;
    LinearLayout genWrap;
    ScrollView generationScreen;
    List<String> goldPurchase;
    List<Long> goldPurchaseAmounts;
    List<String> goldPurchaseSkus;
    boolean gpSignedIn;
    int healthBonus;
    long healthExp;
    long holidayCurrency;
    boolean holidayEventAvailable;
    LinearLayout holidayShop;
    ScrollView homeScreen;
    LinearLayout home_skills;
    List<String> idleDrops;
    String idleMethod;
    String idleSkill;
    long idleSkillTime;
    List<ProductDetails> inAppProducts;
    boolean inCombat;
    LayoutInflater inflater;
    int instakillchance;
    List<Long> inventoryAmounts;
    List<Boolean> inventoryItemLocked;
    List<String> inventoryItems;
    LinearLayout inventoryScreen;
    int inventoryUpgradeAmount;
    GridLayout inventoryWrap;
    LinearLayout itemInfoWrap;
    ItemManager itemManager;
    RelativeLayout itemPopup;
    RelativeLayout itemSelect;
    TextView itemSelect_title;
    LinearLayout itemSelect_wrap;
    long itemsCrafted;
    TextView joinReddit;
    TextView killcoins;
    LinearLayout kitchenList;
    int kitchenMakeX;
    TextView kitchenMakeXButton;
    LinearLayout kitchenScreen;
    RelativeLayout kitchenSkillProgress;
    TextView kitchenSpinner;
    long lastBackupTime;
    long lastCloudRestore;
    long lastTickTime;
    Leaderboards leaderboards;
    float legendaryChance;
    float legendaryChanceBoost;
    List<Long> levelExp;
    TextView loggingIn;
    ConstraintLayout loginScreen;
    long logoutTime;
    LinearLayout lootList;
    String mCurrentSaveName;
    Handler mainHandler;
    RelativeLayout mainView;
    List<Integer> makeXAmounts;
    MarketManager market;
    TextView marketCategorySelect;
    int marketDiscount;
    LinearLayout marketList;
    LinearLayout marketScreen;
    List<String> market_itemCategory;
    List<String> market_itemDescription;
    List<Integer> market_itemIcon;
    List<Long> market_itemSellPrice;
    List<String> market_itemsAvailable;
    int maxHealth;
    int maxIdleIncrease;
    int maxInventory;
    long maxSkillExp;
    int maxStamina;
    boolean members;
    List<Boolean> membersArea;
    List<Boolean> membersSkill;
    RelativeLayout menu;
    LinearLayout menuWrap;
    Mining mining;
    long myAttackSpeed;
    CountDownTimer myAttackTimer;
    GridLayout myEquipment;
    TextView myHealth;
    ProgressBar myHealthBar;
    List<String> myPets;
    LinearLayout myPetsList;
    List<Integer> myProfileAvatars;
    List<String> myTitles;
    float mythicalChance;
    float mythicalChanceBoost;
    EditText newUsername;
    List<String> offerCodesRedeemed;
    TextView openReferralStore;
    float petChance;
    LinearLayout petInfo;
    ScrollView petScreen;
    int pickaxeLevel;
    long piggyBankGold;
    String playGamesUser;
    TextView playNowButton;
    String playerId;
    boolean potionRenewal;
    ImageView potionsButton;
    long potionsMade;
    TextView premiumBanner;
    List<String> premiumChestItems;
    List<String> premiumUpgrades;
    List<Long> premiumUpgradesCosts;
    List<String> premiumUpgradesDescriptions;
    List<Boolean> premiumUpgradesPurchased;
    TextView proPurchase;
    RelativeLayout proScreen;
    ImageView profileAvatar;
    TextView profilename;
    Quests quests;
    ScrollView questsScreen;
    LinearLayout quickFoodView;
    LinearLayout quickHealth;
    TextView quickHealthStat;
    LinearLayout quickPopups;
    Random randomGenerator;
    float rareChance;
    float rareChanceBoost;
    String referringFriend;
    int resourceSave;
    boolean saveAvailable;
    List<Long> scrollExps;
    TextView searchingEnemy;
    float secretChance;
    float secretChanceBoost;
    SecretPathway secretPathway;
    int seedBuy;
    List<Long> seedBuyBaseValues;
    List<TextView> seedBuyPrices;
    String selectedCrop;
    boolean setMenu;
    TextView settingsCreateAccount;
    TextView settingsError;
    TextView settingsInformation;
    ScrollView settingsScreen;
    TextView settingsTradeName;
    List<Long> skillExp;
    List<String> skillingPetAbilities;
    List<String> skillingPets;
    List<Integer> skillingPetsIcons;
    CountDownTimer skillingTimer;
    boolean skillingTimerRunning;
    List<String> skills;
    List<Integer> skillsIcons;
    List<String> skuNames;
    long slayerTasksCompleted;
    SharedPreferences sp;
    RelativeLayout spawns;
    List<String> specialPetAbilities;
    List<String> specialPets;
    List<Integer> specialPetsIcons;
    long stamCost;
    int staminaSaveChance;
    int strengthBonus;
    ImageView styleArchery;
    ImageView styleAttack;
    ImageView styleDefence;
    ImageView styleStrength;
    float superRareChance;
    float superRareChanceBoost;
    Thieving thieving;
    private final Object tickLock;
    private ScheduledExecutorService tickerExecutor;
    List<Integer> titleColours;
    List<String> titles;
    ConstraintLayout topBar;
    int topOffset;
    long totalChickenKills;
    long totalCoins;
    long totalDeaths;
    long totalGameTicks;
    long totalGems;
    long totalKillCoins;
    int totalKills;
    long totalTribalKills;
    String trainingMethod;
    String trainingSkill;
    TreasureHunts treasureHunts;
    ImageView tutorialHand;
    float uncommonChance;
    String userAuth;
    ActivityResultLauncher<Intent> viewSavedGames;
    TextView welcomeMessageTv;
    TextView welcomeNext;
    RelativeLayout welcomeScreen;
    int white;
    TextView workshopCategorySelect;
    LinearLayout workshopList;
    LinearLayout workshopScreen;
    
    static {
        gson = new Gson();
    }
    
    public MainActivity() {
        this.funimator = new Funimator();
        this.mainHandler = new Handler();
        this.currentUsername = "";
        this.accountNames = (List<String>)new ArrayList();
        this.totalCoins = 0L;
        this.totalGems = 0L;
        this.totalKillCoins = 0L;
        this.maxInventory = 20;
        this.inventoryUpgradeAmount = 5;
        this.currentHealth = 20;
        final Boolean value = false;
        this.maxHealth = 0;
        this.maxStamina = 50;
        this.currentStamina = 0;
        this.attackBonus = 0;
        this.strengthBonus = 0;
        this.defenceBonus = 0;
        this.healthBonus = 0;
        this.piggyBankGold = 0L;
        this.allViews = (List<View>)new ArrayList();
        final Boolean value2 = true;
        this.levelExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 0L, 90L, 189L, 300L, 423L, 560L, 711L, 880L, 1066L, 1274L, 1504L, 1759L, 2042L, 2357L, 2706L, 3093L, 3523L, 4000L, 4530L, 5118L, 5770L, 6495L, 7298L, 8190L, 9181L, 10279L, 11499L, 12853L, 14355L, 16023L, 17874L, 19928L, 22208L, 24738L, 27547L, 30664L, 34124L, 37964L, 42226L, 46956L, 52206L, 58033L, 64500L, 71678L, 79645L, 88487L, 98301L, 109193L, 121283L, 134700L, 149593L, 166121L, 184467L, 204828L, 227426L, 252508L, 280347L, 311244L, 345537L, 383598L, 425841L, 472727L, 524765L, 582522L, 646625L, 717773L, 796739L, 884383L, 981658L, 1089623L, 1209451L, 1342448L, 1490060L, 1653893L, 1835730L, 2037548L, 2261545L, 2510156L, 2786087L, 3092341L, 3432249L, 3809509L, 4228226L, 4692957L, 5208756L, 5781237L, 6416628L, 7121842L, 7904552L, 8773274L, 9737460L, 10807601L, 11995339L, 13313598L, 14776721L, 16400627L, 18202983L, 20203401L, 22423645L, 24887872L, 27622893L, 30658466L, 34027618L, 37767007L, 41917318L, 46523706L, 51636292L, 57310699L, 63608668L, 70598722L, 78356913L, 86967653L, 96524628L, 107131820L, 118904638L, 131971172L, 146473588L, 162569677L, 180434567L, 200262631L, 222269604L, 246694925L, 273804348L, 303892828L, 337287734L, 374352410L, 415490128L, 461148474L, 511824220L, 568068730L, 630493955L, 699779095L, 776677987L, 862027307L, 956755672L, 1061893748L, 1178585459L, 1308100434L, 1451847825L, 1611391632L }));
        this.skills = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Attack", "Strength", "Defence", "Health", "Slayer", "Fishing", "Discovery", "Alchemy", "Farming", "Crafting", "Cooking", "Thieving", "Mining", "Forestry", "Firemaking", "Archery", "Fletching" }));
        this.skillsIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131166468, 2131166480, 2131166471, 2131166477, 2131166479, 2131166475, 2131166472, 2131166467, 2131166473, 2131166470, 2131166469, 2131166481, 2131166478, 2131166476, 2131166474, 2131166482, 2131166483 }));
        this.membersSkill = (List<Boolean>)new ArrayList((Collection)Arrays.asList((Object[])new Boolean[] { value, value, value, value, value, value, value, value, value, value, value, value2, value2, value2, value2, value, value }));
        this.skillExp = (List<Long>)new ArrayList();
        this.areas = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "My Profile", "Gold Market", "Base Camp", "Inventory", "Equipment", "Market Trader", "Silver Market", "Farm", "Workshop", "Fletching Station", "Fishing", "The Mines", "Forest", "Kitchen", "Discovery", "Apothecary", "Battle Areas", "Slayer Masters", "Thieving Guild", "Quests", "Skilling Pets", "Completion Progress", "Wiki", "Game Settings" }));
        this.areaIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165740, 2131165871, 2131166019, 2131165951, 2131166044, 2131165704, 2131166220, 2131166473, 2131166470, 2131166483, 2131166475, 2131166478, 2131166476, 2131166469, 2131166472, 2131166467, 2131165565, 2131166479, 2131166481, 2131166049, 2131166055, 2131166048, 2131165507, 2131165701 }));
        this.membersArea = (List<Boolean>)new ArrayList((Collection)Arrays.asList((Object[])new Boolean[] { value, value, value, value, value, value, value, value, value, value, value, value2, value2, value, value, value, value, value, value2, value, value, value, value, value }));
        this.allItems = (List<String>)new ArrayList();
        this.allItemsRarity = (List<String>)new ArrayList();
        this.allItemsTypes = (List<String>)new ArrayList();
        this.allItemsDescriptions = (List<String>)new ArrayList();
        this.allItemsIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165527, 2131165528, 2131165529, 2131165530, 2131165533, 2131165534, 2131165534, 2131165544, 2131165545, 2131165547, 2131165549, 2131165552, 2131165553, 2131165554, 2131165555, 2131165556, 2131165557, 2131165558, 2131165560, 2131165565, 2131165570, 2131165611, 2131165613, 2131165615, 2131165616, 2131165620, 2131165621, 2131165622, 2131165612, 2131165612, 2131165618, 2131165624, 2131165625, 2131165627, 2131165637, 2131165638, 2131165641, 2131165642, 2131165649, 2131165650, 2131165651, 2131165652, 2131165654, 2131165655, 2131165656, 2131165658, 2131165659, 2131165660, 2131165661, 2131165662, 2131165663, 2131165667, 2131165668, 2131165670, 2131165683, 2131165683, 2131165691, 2131165697, 2131165701, 2131165704, 2131166220, 2131165705, 2131165706, 2131165707, 2131165709, 2131165713, 2131165715, 2131165716, 2131165720, 2131165721, 2131165737, 2131165738, 2131165740, 2131165746, 2131165752, 2131165754, 2131165756, 2131165757, 2131165758, 2131165759, 2131165760, 2131165761, 2131165762, 2131165763, 2131165765, 2131165769, 2131165772, 2131165774, 2131165774, 2131165793, 2131165794, 2131165796, 2131165806, 2131165807, 2131165808, 2131165812, 2131165816, 2131165819, 2131165827, 2131165832, 2131165834, 2131165837, 2131165838, 2131165869, 2131165870, 2131165871, 2131165885, 2131165887, 2131165877, 2131165880, 2131165888, 2131165888, 2131165891, 2131165894, 2131165895, 2131165897, 2131165899, 2131165901, 2131165902, 2131165905, 2131165910, 2131165913, 2131165914, 2131165915, 2131165916, 2131165917, 2131165920, 2131165921, 2131165922, 2131165923, 2131165948, 2131165949, 2131165950, 2131165951, 2131165952, 2131165953, 2131165954, 2131165955, 2131165956, 2131165957, 2131165957, 2131165960, 2131165964, 2131165978, 2131165986, 2131165987, 2131165988, 2131165990, 2131165996, 2131166000, 2131166004, 2131166005, 2131166006, 2131166007, 2131166008, 2131166009, 2131166012, 2131166013, 2131166014, 2131166015, 2131166017, 2131166018, 2131166019, 2131166020, 2131166021, 2131166022, 2131166023, 2131166031, 2131166032, 2131166040, 2131166041, 2131166042, 2131166043, 2131166044, 2131166045, 2131166046, 2131166047, 2131166049, 2131166050, 2131166055, 2131166056, 2131166060, 2131166060, 2131166063, 2131166064, 2131166072, 2131166079, 2131166078, 2131166088, 2131166111, 2131166113, 2131166114, 2131166115, 2131166116, 2131166117, 2131166118, 2131166119, 2131166120, 2131166121, 2131166122, 2131166123, 2131166124, 2131166125, 2131166126, 2131166127, 2131166128, 2131166129, 2131166130, 2131166131, 2131166132, 2131166133, 2131166133, 2131166141, 2131166167, 2131166168, 2131166171, 2131166172, 2131166178, 2131166183, 2131166184, 2131166185, 2131166187, 2131166188, 2131166192, 2131166193, 2131166214, 2131166215, 2131166219, 2131166222, 2131166224, 2131166226, 2131166227, 2131166228, 2131166229, 2131166230, 2131166231, 2131166232, 2131166249, 2131166250, 2131166253, 2131166255, 2131166256, 2131166257, 2131166258, 2131166259, 2131166260, 2131166261, 2131166262, 2131166263, 2131166264, 2131166266, 2131166269, 2131166270, 2131166271, 2131166271, 2131166272, 2131166273, 2131166280, 2131166281, 2131166282, 2131166284, 2131166286, 2131166287, 2131166290, 2131166291, 2131166300, 2131166309, 2131166311, 2131166311, 2131166312, 2131166314, 2131166317, 2131166318, 2131166319, 2131166320, 2131166321, 2131166322, 2131166323, 2131166336, 2131166337, 2131166341, 2131166343, 2131166344, 2131166346, 2131166347, 2131166349, 2131166350, 2131166352, 2131165918, 2131166221, 2131165886, 2131166010, 2131165753, 2131166180, 2131165693, 2131165665, 2131165531, 2131165867, 2131165868, 2131166186, 2131165841, 2131165842, 2131165843, 2131165645, 2131165646, 2131165647, 2131165626, 2131166016, 2131165857, 2131165714, 2131165686, 2131165636, 2131165653, 2131165648, 2131165643, 2131165640, 2131165681, 2131165548, 2131165639, 2131165671, 2131165813, 2131166330, 2131165959, 2131165906, 2131165884, 2131165958, 2131166310, 2131166077, 2131165722, 2131166308, 2131165814, 2131166080, 2131166288, 2131165999, 2131165792, 2131166276, 2131166165, 2131165766, 2131165767, 2131166190, 2131166024, 2131166027, 2131166025, 2131166028, 2131166029, 2131166026, 2131165635, 2131165961, 2131166081, 2131166289, 2131165815, 2131165997, 2131165998, 2131166306, 2131165935, 2131166106, 2131166102, 2131166099, 2131166104, 2131166103, 2131166107, 2131165931, 2131165928, 2131165933, 2131165932, 2131165936, 2131165925, 2131165937, 2131166096, 2131166108, 2131166101, 2131166105, 2131165930, 2131165934, 2131165803, 2131166054, 2131166067, 2131165977, 2131165569, 2131166252, 2131165831, 2131165543, 2131166340, 2131165799, 2131165776, 2131166140, 2131165675, 2131165684, 2131165973, 2131165690, 2131165972, 2131165865, 2131165893, 2131166110, 2131165865, 2131165972, 2131165690, 2131165973, 2131165684, 2131165675, 2131166140, 2131165776, 2131165799, 2131166340, 2131165543, 2131165831, 2131166252, 2131165569, 2131165977, 2131166067, 2131166054, 2131165803, 2131165770, 2131166164, 2131165755, 2131165566, 2131165644, 2131165822, 2131165723, 2131165818, 2131165820, 2131165724, 2131165823, 2131165821, 2131165824, 2131165825, 2131165826, 2131165768, 2131166151, 2131166152, 2131166153, 2131166154, 2131166155, 2131166156, 2131166157, 2131166158, 2131166163, 2131166161, 2131166150, 2131166034, 2131166035, 2131166038, 2131166036, 2131166030, 2131165979, 2131165708, 2131166292, 2131165719, 2131165676, 2131165677, 2131165678, 2131165680, 2131165679, 2131165970, 2131166142, 2131166143, 2131166144, 2131166145, 2131166146, 2131166037, 2131166333, 2131166334, 2131166335, 2131165628, 2131165629, 2131165532, 2131166251, 2131166011, 2131165919, 2131165783, 2131165785, 2131165546, 2131165562, 2131165563, 2131165567, 2131165568, 2131166162, 2131166173, 2131166177, 2131166247, 2131166277, 2131166278, 2131166313, 2131165789, 2131165786, 2131165787, 2131165784, 2131165780, 2131165790, 2131165777, 2131165791, 2131166348, 2131165798, 2131166066, 2131166307, 2131165682, 2131165844, 2131166315, 2131165669, 2131165739, 2131165712, 2131165909, 2131166076, 2131166149, 2131166268, 2131165711, 2131165912, 2131166003, 2131165745, 2131166075, 2131166148, 2131165908, 2131166098, 2131165927, 2131165779, 2131165800, 2131166051, 2131165974, 2131165828, 2131166137, 2131165672, 2131165687, 2131165862, 2131165802, 2131166053, 2131165976, 2131165830, 2131166139, 2131165674, 2131165689, 2131165864, 2131166267, 2131165710, 2131165911, 2131166002, 2131165744, 2131166074, 2131166147, 2131165907, 2131166097, 2131165926, 2131165778, 2131165801, 2131166052, 2131165975, 2131165829, 2131166138, 2131165673, 2131165688, 2131165863, 2131166100, 2131165929, 2131165781, 2131166297, 2131165633, 2131165892, 2131166065, 2131166166, 2131166059, 2131166058, 2131166217, 2131166109, 2131166189, 2131166216, 2131165942, 2131165718, 2131165630, 2131165866, 2131166073, 2131165896, 2131165889, 2131165938, 2131165943, 2131165944, 2131165947, 2131165945, 2131165946, 2131166295, 2131165551, 2131165574, 2131165617, 2131165703, 2131166069, 2131166134, 2131166338, 2131166353, 2131165564, 2131165797, 2131166332, 2131166048, 2131165904, 2131165702, 2131166345, 2131165736, 2131165573, 2131165540, 2131165536, 2131165535, 2131165538, 2131165537, 2131165985, 2131165981, 2131165980, 2131165983, 2131165982, 2131166087, 2131166083, 2131166082, 2131166085, 2131166084, 2131166245, 2131166240, 2131166238, 2131166242, 2131166241, 2131166246, 2131166237, 2131166160, 2131165750, 2131165747, 2131165748, 2131165749, 2131165751, 2131165599, 2131165579, 2131166033, 2131165858, 2131165861, 2131165860, 2131165859, 2131166089, 2131166093, 2131165657, 2131166254, 2131166094, 2131166223, 2131165742, 2131165743, 2131165600, 2131165591, 2131165593, 2131165609, 2131165597, 2131165577, 2131165608, 2131165590, 2131165717, 2131165610, 2131165539, 2131165984, 2131166086, 2131166244, 2131166191, 2131166057, 2131165735, 2131165795, 2131165619, 2131165666, 2131165692, 2131165873, 2131166235, 2131165594, 2131165584, 2131165585, 2131165586, 2131165587, 2131165588, 2131165589, 2131165601, 2131165595, 2131165582, 2131165598, 2131165728, 2131165726, 2131165725, 2131165727, 2131165729, 2131165730, 2131165962, 2131166265, 2131165598, 2131165598, 2131165598, 2131165598, 2131165598, 2131165577, 2131165577, 2131165577, 2131165577, 2131165600, 2131165600, 2131165600, 2131165600, 2131166243, 2131166159, 2131165847, 2131165848, 2131165849, 2131165850, 2131165634, 2131166070, 2131166135, 2131166339, 2131166354, 2131166299, 2131165782, 2131165788, 2131166342, 2131166239, 2131165576, 2131165580, 2131165596, 2131165583, 2131165581, 2131165602, 2131165607, 2131165604, 2131165603, 2131165606, 2131165605, 2131166169, 2131166170, 2131165559, 2131165541, 2131165578, 2131165845, 2131165971, 2131165833, 2131165835, 2131165836, 2131165839, 2131165840, 2131165965, 2131165966, 2131165969, 2131165967, 2131165968, 2131165991, 2131165992, 2131165995, 2131165993, 2131165994, 2131166301, 2131166302, 2131166305, 2131166303, 2131166304, 2131165631, 2131166296, 2131165771, 2131166095, 2131166089, 2131165514, 2131165773, 2131165775, 2131166225, 2131166298, 2131166218, 2131165632, 2131165856, 2131165855, 2131165561, 2131165874, 2131165876, 2131165882, 2131165989, 2131166061, 2131166071, 2131166274, 2131166275, 2131165571, 2131165550, 2131165664, 2131165878, 2131166062, 2131165633, 2131165699, 2131165698, 2131165700, 2131166176, 2131165734, 2131166198, 2131166195, 2131165731, 2131166174, 2131166175, 2131166212, 2131165732, 2131166196, 2131165733, 2131166197, 2131166201, 2131166203, 2131166202, 2131166200, 2131166208, 2131166204, 2131166205, 2131166206, 2131166207, 2131166209, 2131166210, 2131166211, 2131166213, 2131166194, 2131166199, 2131165764, 2131165592, 2131165592, 2131165592, 2131165601, 2131165601, 2131165741, 2131165872, 2131166092, 2131166090, 2131165963, 2131165851, 2131165852, 2131165853, 2131165854, 2131166039, 2131165881, 2131165575, 2131166248, 2131165883, 2131165875, 2131165900, 2131165817, 2131166179, 2131165696, 2131166068, 2131165890, 2131165614, 2131165695, 2131166236, 2131166234, 2131165939, 2131165940, 2131165941, 2131166181, 2131166293, 2131166294, 2131165898, 2131166001, 2131166182, 2131166351, 2131165694, 2131165542, 2131166279, 2131165805, 2131166325, 2131165804, 2131166283, 2131165809, 2131166328, 2131165846, 2131166285, 2131165811, 2131166324, 2131166326, 2131166331, 2131166327, 2131165685, 2131165810, 2131166329, 2131166112 }));
        this.allItemsValues = (List<Long>)new ArrayList();
        this.allItemsHealingAmount = (List<Integer>)new ArrayList();
        this.allItemsFarmingLevel = (List<Integer>)new ArrayList();
        this.allItemsAttackBonus = (List<Integer>)new ArrayList();
        this.allItemsStrengthBonus = (List<Integer>)new ArrayList();
        this.allItemsDefenceBonus = (List<Integer>)new ArrayList();
        this.allItemsHealthBonus = (List<Integer>)new ArrayList();
        this.inventoryItems = (List<String>)new ArrayList();
        this.inventoryAmounts = (List<Long>)new ArrayList();
        this.inventoryItemLocked = (List<Boolean>)new ArrayList();
        this.uncommonChance = 30.0f;
        this.rareChance = 6.0f;
        this.superRareChance = 1.2f;
        this.legendaryChance = 0.08f;
        this.mythicalChance = 0.02f;
        this.secretChance = 0.009f;
        this.rareChanceBoost = 0.0f;
        this.superRareChanceBoost = 0.0f;
        this.legendaryChanceBoost = 0.0f;
        this.mythicalChanceBoost = 0.0f;
        this.secretChanceBoost = 0.0f;
        this.inCombat = false;
        this.myAttackSpeed = 2000L;
        this.currentAttackStyle = "Attack";
        this.currentLoot = (List<String>)new ArrayList();
        this.currentLootAmounts = (List<Long>)new ArrayList();
        this.combatExp = 3L;
        this.healthExp = 2L;
        this.drops = (List<String>)new ArrayList();
        this.dropMin = (List<Integer>)new ArrayList();
        this.dropMax = (List<Integer>)new ArrayList();
        this.dropRarity = (List<String>)new ArrayList();
        this.foodItems = (List<String>)new ArrayList();
        this.foodItemHealing = (List<Integer>)new ArrayList();
        this.equippedFood = "";
        this.market_itemsAvailable = (List<String>)new ArrayList();
        this.market_itemCategory = (List<String>)new ArrayList();
        this.market_itemDescription = (List<String>)new ArrayList();
        this.market_itemIcon = (List<Integer>)new ArrayList();
        this.market_itemSellPrice = (List<Long>)new ArrayList();
        this.pickaxeLevel = 1;
        this.fishingRodLevel = 0;
        this.autoEat = false;
        this.maxSkillExp = 2000000000L;
        this.selectedCrop = "";
        this.exploreItems = 1;
        this.staminaSaveChance = 5;
        this.premiumUpgrades = (List<String>)new ArrayList();
        this.premiumUpgradesDescriptions = (List<String>)new ArrayList();
        this.premiumUpgradesCosts = (List<Long>)new ArrayList();
        this.premiumUpgradesPurchased = (List<Boolean>)new ArrayList();
        this.goldPurchase = (List<String>)new ArrayList();
        this.goldPurchaseAmounts = (List<Long>)new ArrayList();
        this.goldPurchaseSkus = (List<String>)new ArrayList();
        this.expMultiplier = 1;
        this.marketDiscount = 0;
        this.doubleFish = 0;
        this.doublePotions = 0;
        this.resourceSave = 0;
        this.farmingTimer = 0;
        this.totalKills = 0;
        this.craftingWraps = (List<RelativeLayout>)new ArrayList();
        this.fishingExpBoost = 1;
        this.instakillchance = 0;
        this.chestLoot = (List<String>)new ArrayList();
        this.chestMinLoot = (List<Integer>)new ArrayList();
        this.chestMaxLoot = (List<Integer>)new ArrayList();
        this.logoutTime = 0L;
        this.billingInitialized = false;
        this.inAppProducts = (List<ProductDetails>)new ArrayList();
        this.skuNames = (List<String>)new ArrayList();
        this.craftingMakeX = 0;
        this.fletchingMakeX = 0;
        this.kitchenMakeX = 0;
        this.alchemyMakeX = 0;
        this.burnX = 0;
        this.makeXAmounts = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 25000, 50000 }));
        this.seedBuy = 0;
        this.seedBuyPrices = (List<TextView>)new ArrayList();
        this.seedBuyBaseValues = (List<Long>)new ArrayList();
        this.baseMaxStamina = 50;
        this.stamCost = 3L;
        this.currentEvent = "Christmas";
        this.eventCurrency = "Presents";
        this.currentEventCurrency = 0L;
        this.farmingSpots = (List<RelativeLayout>)new ArrayList();
        this.slayerTasksCompleted = 0L;
        this.totalChickenKills = 0L;
        this.totalTribalKills = 0L;
        this.premiumChestItems = (List<String>)new ArrayList();
        this.currentWorkshopCategory = "Materials";
        this.currentFletchingCategory = "Arrow Shafts";
        this.myPets = (List<String>)new ArrayList();
        this.skillingPets = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Larry", "Leo", "Taylor", "Helen", "Carrie", "Jenny", "Oscar", "Casper", "Pinky", "Roger", "Benny", "Martin", "Rocko", "Lofty", "Sandy", "Timmy", "Archie" }));
        this.skillingPetsIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131166435, 2131166449, 2131166438, 2131166446, 2131166448, 2131166443, 2131166439, 2131166433, 2131166441, 2131166437, 2131166436, 2131166450, 2131166447, 2131166445, 2131166442, 2131166444, 2131166434 }));
        this.skillingPetAbilities = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Increases base attack speed by 0.1 seconds", "Increases Melee damage by 10%", "Reduces incoming damage by 10%", "All food heals 20% more health", "When finding Soul Gems you get 1 extra", "Grants 1 extra Fish per catch", "Grants 1 extra item per exploration", "Grants a 10% chance to double potions made", "Grants a 20% chance to double crop harvest", "Grants a 10% chance to double items made", "Grants a 10% chance to double food cooked", "Increases the chance of getting 2 rolls on the Safecracking loot table by 10%", "Grants 1 extra ore per mine", "Grants 1 extra log per chop", "Gives a chance to find Ring Fragments while burning logs", "Increases Archery damage by 10%", "Grants a 10% chance to double items fletched" }));
        this.specialPets = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Cassie the Casket", "Saul the Soul", "Tiki the Ticket", "Marshmallow the Bunny", "Adam the Troll", "Ace the Ghost", "Sprinkles" }));
        this.specialPetsIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165669, 2131166237, 2131165610, 2131166440, 2131166432, 2131165526, 2131166485 }));
        this.specialPetAbilities = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Increases chance to find Secret Rares by 5% (Stackable)", "When finding Soul Gems you get 3 extra", "Reduces the Enhancement Tickets required for Enhancements by 5% (Stackable)", "This super cute ball of fluff helps find things faster!", "Rewards between 100 and 1,500 Gold every minute while playing, and provides a 5% Insta Kill chance. But, there is a downside.", "Grants a 15% chance to reduce incoming damage to zero.", "Helps light the way while skilling by reducing all skill timers by 20% to a minimum of 0.9s!" }));
        this.petChance = 0.002f;
        this.saveAvailable = true;
        this.members = false;
        this.eventCurrecies = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Present", "Pumpkin", "Heart", "Present", "Bow", "Egg", "Skull", "Beach Ball", "Symbol", "Cake", "Pumpkin Coin", "Christmas Present", "Heart Coin", "Chocolate", "Ice Cream" }));
        this.eventIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165375, 2131165469, 2131165471, 2131165375, 2131165468, 2131165508, 2131165470, 2131165335, 2131166486, 2131165524, 2131166091, 2131165355, 2131165511, 2131165466, 2131165903 }));
        this.trainingSkill = "None";
        this.trainingMethod = "";
        this.holidayCurrency = 0L;
        this.holidayEventAvailable = true;
        this.currentHolidayCurrency = "Christmas Present";
        this.eventDoubleDrops = false;
        this.scrollExps = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 75L, 300L, 750L, 1600L }));
        this.claimedGift = false;
        this.potionRenewal = false;
        this.gpSignedIn = false;
        this.mCurrentSaveName = "CherryTree";
        this.gameLoaded = false;
        this.offerCodesRedeemed = (List<String>)new ArrayList();
        this.attemptingBackup = false;
        this.playGamesUser = "";
        this.titles = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "the Player", "the Legend", "the Chicken Slayer", "the Exp Hunter", "the Ancient", "the Safety Net", "the Guinea Pig", "the Maxed", "the Millionaire", "the Billionaire", "the Story Finder", "the New Leader", "the Unlucky", "the Achiever", "the Gold Miner", "the Camper", "the Easter Bunny", "the Enhanced", "the Camped Out", "the Whale" }));
        this.titleColours = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131034891, 2131034892, 2131034887, 2131034891, 2131034887, 2131034891, 2131034890, 2131034892, 2131034892, 2131034892, 2131034892, 2131034892, 2131034891, 2131034887, 2131034892, 2131034892, 2131034888, 2131034888, 2131034892, 2131034888 }));
        this.myTitles = (List<String>)new ArrayList();
        this.activeTitle = "";
        this.equipmentPlaceholders = (List<Integer>)new ArrayList();
        this.maxIdleIncrease = 0;
        this.idleDrops = (List<String>)new ArrayList();
        this.idleSkill = "";
        this.idleMethod = "";
        this.idleSkillTime = 0L;
        this.accountStats = null;
        this.setMenu = false;
        this.activeCharacter = 0;
        this.userAuth = "";
        this.lastCloudRestore = 0L;
        this.avatarIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165396, 2131165450, 2131165403, 2131165404, 2131165386, 2131165427, 2131165433, 2131165409, 2131165411, 2131165384, 2131165387, 2131165398, 2131165399, 2131165413, 2131165425, 2131165430, 2131165431, 2131165309, 2131165310, 2131165311, 2131165312, 2131165313, 2131165314, 2131165315, 2131165316, 2131165328, 2131165452, 2131165440, 2131165441, 2131165477, 2131165317, 2131165318, 2131165324 }));
        this.avatarNames = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Chicken", "Water Dragon", "King Dragon", "Dragon Queen", "Ancient Tribal Leader", "Living Armour King", "Orc King", "Elven King", "Elven Queen", "Amaran", "Aurial", "Cognium", "Copina", "Feroxi", "Kynosian", "Noctyra", "Opulina", "Amaran Chibi", "Aurial Chibi", "Cognium Chibi", "Copina Chibi", "Feroxi Chibi", "Kynosian Chibi", "Noctyra Chibi", "Opulina Chibi", "Adam the Troll", "Zombie", "Shadow Creature", "Shadow Dragon", "Ace the Ghost", "Ellie", "Eddie", "Santa" }));
        this.myProfileAvatars = (List<Integer>)new ArrayList();
        this.activeAvatar = 0;
        this.accountType = "";
        this.equipmentHeight = 0;
        this.gameTick = new Handler();
        this.totalGameTicks = 0L;
        this.referringFriend = "";
        this.randomGenerator = new Random();
        this.lastTickTime = 0L;
        this.backgroundExecutor = Executors.newSingleThreadExecutor();
        this.activePopups = 0;
        this.tickLock = new Object();
        this.viewSavedGames = (ActivityResultLauncher<Intent>)this.registerForActivityResult((ActivityResultContract)new ActivityResultContracts$StartActivityForResult(), (ActivityResultCallback)new MainActivity$$ExternalSyntheticLambda128(this));
    }
    
    private void AddIdleDrop(final String s, final int n, final List<String> list, final List<Integer> list2) {
        if (list.contains((Object)s)) {
            list2.set(list.indexOf((Object)s), (Object)((int)list2.get(list.indexOf((Object)s)) + n));
        }
        else {
            list.add((Object)s);
            list2.add((Object)n);
        }
    }
    
    private void AttemptBackup() {
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        final Future submit = singleThreadExecutor.submit((Runnable)new MainActivity$$ExternalSyntheticLambda36(this));
        try {
            submit.get();
            singleThreadExecutor.shutdown();
            this.lastBackupTime = System.currentTimeMillis();
        }
        catch (final Exception ex) {
            this.LogIt("Failed to backup");
            this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda37(this));
            singleThreadExecutor.shutdown();
        }
    }
    
    private void CheckConsumes() {
        this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), (PurchasesResponseListener)new MainActivity$$ExternalSyntheticLambda35(this));
    }
    
    private void CheckGoldenTouch() {
        if (this.alchemy.activePotions.contains((Object)"Golden Touch Potion")) {
            final float n = this.databaseManager.GetWishLevel("Golden Touch", "Beginner") * 0.25f;
            float n2 = 1.0f;
            if (n >= 0.0f) {
                n2 = 1.0f + n;
            }
            if (this.RandomFloat() <= n2) {
                final boolean contains = this.combatManager.equippedItems.contains((Object)"Opulinas Robe Top");
                int n4;
                final int n3 = n4 = 1;
                if (contains) {
                    n4 = n3;
                    if (this.combatManager.equippedItems.contains((Object)"Opulinas Robe Bottoms")) {
                        if (this.combatManager.equippedItems.contains((Object)"Crown of Opulina")) {
                            if (this.GetRandom(1, 1500) <= 1) {
                                final ItemManager$Blessings blessings = this.itemManager.blessings;
                                ++blessings.tickets;
                                this.LargePopup(2131165610, "Opulinas Gift", "While skilling Opulina gifts you an Enhancement Ticket.");
                            }
                            n4 = 30;
                        }
                        else {
                            n4 = 15;
                        }
                    }
                }
                this.totalGems += n4;
                this.UpdateCash();
                this.QuickPopup("Your Golden Touch Potion finds " + n4 + " Gold Coin");
            }
        }
    }
    
    private void CheckIdleSkill() {
        final TextView textView = (TextView)this.findViewById(2131296739);
        if (this.logoutTime > 0L) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > this.logoutTime && !this.idleSkill.isEmpty() && !this.idleMethod.equals((Object)"Sandalwood Tree") && !this.idleMethod.equals((Object)"Darkstar Ore") && !this.idleMethod.equals((Object)"Christmas Village") && !this.idleMethod.equals((Object)"Santas Helper")) {
                final long n = (currentTimeMillis - this.logoutTime) / 1000L / 60L;
                if (n >= 2L && !this.idleMethod.isEmpty() && !this.idleDrops.isEmpty() && this.idleSkillTime > 0L) {
                    textView.setVisibility(0);
                    textView.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda88(this, n, textView));
                }
            }
        }
    }
    
    private void CheckTitles() {
        if (this.totalGems >= 200000L) {
            this.GiveTitle("the Blue Whale");
        }
        final int n = 0;
        int n2 = 0;
        while (true) {
            final int size = this.titles.size();
            int n3 = 6;
            if (n2 >= size) {
                break;
            }
            if (!this.myTitles.contains(this.titles.get(n2))) {
                final String s = (String)this.titles.get(n2);
                s.hashCode();
                Label_0482: {
                    switch (s.hashCode()) {
                        case 2095560858: {
                            if (!s.equals((Object)"the Whale")) {
                                break;
                            }
                            n3 = 13;
                            break Label_0482;
                        }
                        case 2086138996: {
                            if (!s.equals((Object)"the Maxed")) {
                                break;
                            }
                            n3 = 12;
                            break Label_0482;
                        }
                        case 1871950640: {
                            if (!s.equals((Object)"the Achiever")) {
                                break;
                            }
                            n3 = 11;
                            break Label_0482;
                        }
                        case 1863627628: {
                            if (!s.equals((Object)"the Guinea Pig")) {
                                break;
                            }
                            n3 = 10;
                            break Label_0482;
                        }
                        case 1514617720: {
                            if (!s.equals((Object)"the Millionaire")) {
                                break;
                            }
                            n3 = 9;
                            break Label_0482;
                        }
                        case 1051152088: {
                            if (!s.equals((Object)"the New Leader")) {
                                break;
                            }
                            n3 = 8;
                            break Label_0482;
                        }
                        case 1017620824: {
                            if (!s.equals((Object)"the Chicken Slayer")) {
                                break;
                            }
                            n3 = 7;
                            break Label_0482;
                        }
                        case 341179792: {
                            if (!s.equals((Object)"the Player")) {
                                break;
                            }
                            break Label_0482;
                        }
                        case 303149341: {
                            if (!s.equals((Object)"the Camped Out")) {
                                break;
                            }
                            n3 = 5;
                            break Label_0482;
                        }
                        case 220358332: {
                            if (!s.equals((Object)"the Legend")) {
                                break;
                            }
                            n3 = 4;
                            break Label_0482;
                        }
                        case -40809059: {
                            if (!s.equals((Object)"the Camper")) {
                                break;
                            }
                            n3 = 3;
                            break Label_0482;
                        }
                        case -193753811: {
                            if (!s.equals((Object)"the Billionaire")) {
                                break;
                            }
                            n3 = 2;
                            break Label_0482;
                        }
                        case -1068750528: {
                            if (!s.equals((Object)"the Story Finder")) {
                                break;
                            }
                            n3 = 1;
                            break Label_0482;
                        }
                        case -1519864370: {
                            if (!s.equals((Object)"the Gold Miner")) {
                                break;
                            }
                            n3 = 0;
                            break Label_0482;
                        }
                    }
                    n3 = -1;
                }
                switch (n3) {
                    case 13: {
                        if (this.totalGems >= 50000L) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 12: {
                        if (this.All99s()) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 11: {
                        if (this.One99()) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 10: {
                        if (this.playGamesUser.equals((Object)"PlaydropUK") || this.playGamesUser.equals((Object)"AliHassanFB") || this.playGamesUser.equals((Object)"Ace12444") || this.playGamesUser.equals((Object)"TheSoloPlayer554")) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 9: {
                        if (this.totalCoins >= 1000000L) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 8: {
                        if (this.totalTribalKills >= 100000L) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 7: {
                        if (this.totalChickenKills >= 25000L) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 6: {
                        this.myTitles.add((Object)this.titles.get(n2));
                        break;
                    }
                    case 5: {
                        if (this.baseTower.baseTowerLevel >= 50) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 4: {
                        if (this.members) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 3: {
                        if (this.baseTower.baseTowerLevel >= 30) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 2: {
                        if (this.totalCoins >= 1000000000L) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 1: {
                        if (this.AllQuestsComplete()) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                    case 0: {
                        if (this.totalGems >= 5000L) {
                            this.myTitles.add((Object)this.titles.get(n2));
                            break;
                        }
                        break;
                    }
                }
            }
            ++n2;
        }
        if (this.market.CheckNoLife()) {
            for (int i = n; i < 7; ++i) {
                final String s2 = (new String[] { "has No Life", "requires Grass", "lives here", "clicks too much", "needs help", "is done", "the Hermit" })[i];
                if (!this.myTitles.contains((Object)s2)) {
                    this.myTitles.add((Object)s2);
                }
            }
        }
        if (this.accountType.equals((Object)"Ironman")) {
            if (!this.myTitles.contains((Object)"the Ironman")) {
                this.myTitles.add((Object)"the Ironman");
            }
            if (!this.myTitles.contains((Object)"the Ironwoman")) {
                this.myTitles.add((Object)"the Ironwoman");
            }
            if (!this.myTitles.contains((Object)"the Iron")) {
                this.myTitles.add((Object)"the Iron");
            }
        }
        if (this.databaseManager.allWishesMaxed("Endgame")) {
            if (!this.myTitles.contains((Object)"the Wishful")) {
                this.myTitles.add((Object)"the Wishful");
            }
        }
        else if (this.myTitles.contains((Object)"the Wishful")) {
            this.myTitles.remove((Object)"the Wishful");
            if (this.activeTitle.equals((Object)"the Wishful")) {
                this.activeTitle = "";
            }
        }
        if (this.myTitles.contains((Object)"")) {
            this.myTitles.remove((Object)"");
        }
    }
    
    private void CodeReward(final DatabaseManager$OfferCode databaseManager$OfferCode) {
        this.offerCodesRedeemed.add((Object)databaseManager$OfferCode.getCode());
        if (databaseManager$OfferCode.getReward().contains((CharSequence)"Title#")) {
            this.GiveTitle(databaseManager$OfferCode.getReward().replace((CharSequence)"Title#", (CharSequence)""));
        }
        else {
            final String reward = databaseManager$OfferCode.getReward();
            reward.hashCode();
            final int hashCode = reward.hashCode();
            int n = -1;
            switch (hashCode) {
                case 1346201143: {
                    if (!reward.equals((Object)"Premium")) {
                        break;
                    }
                    n = 6;
                    break;
                }
                case 880990999: {
                    if (!reward.equals((Object)"Event Currency")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 658894417: {
                    if (!reward.equals((Object)"Gold Coin")) {
                        break;
                    }
                    n = 4;
                    break;
                }
                case 444298052: {
                    if (!reward.equals((Object)"Killcoins")) {
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
                case -1976580156: {
                    if (!reward.equals((Object)"Silver Coin")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    this.GiveItem(databaseManager$OfferCode.getReward(), databaseManager$OfferCode.getRewardAmount(), false);
                    try {
                        this.LargePopup((int)this.allItemsIcons.get(this.allItems.indexOf((Object)databaseManager$OfferCode.getReward())), "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " " + databaseManager$OfferCode.getReward());
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        this.LargePopup(2131166488, "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " " + databaseManager$OfferCode.getReward());
                    }
                    break;
                }
                case 6: {
                    this.members = true;
                    this.premiumBanner.setVisibility(8);
                    this.GiveTitle("the Legend");
                    this.LargePopup(2131165474, "Success", "You unlocked CherryTree Premium.");
                    break;
                }
                case 5: {
                    this.LargePopup((int)this.eventIcons.get(this.eventCurrecies.indexOf((Object)this.currentHolidayCurrency)), "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " " + this.currentHolidayCurrency + "s.");
                    this.holidayCurrency += databaseManager$OfferCode.getRewardAmount();
                    this.UpdateBottomNav();
                    break;
                }
                case 4: {
                    this.totalGems += databaseManager$OfferCode.getRewardAmount();
                    this.LargePopup(2131165871, "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " Gold Coins");
                    this.UpdateCash();
                    break;
                }
                case 3: {
                    final CombatManager$SlayerInfo slayerInfo = this.combatManager.slayerInfo;
                    slayerInfo.killcoins += databaseManager$OfferCode.getRewardAmount();
                    this.LargePopup(2131165924, "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " Killcoins");
                    this.UpdateCash();
                    break;
                }
                case 2: {
                    this.LargePopup(2131165669, "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " Treasure Caskets.");
                    final TreasureHunts.MyTreasureHunts myTreasureHunts = this.treasureHunts.myTreasureHunts;
                    myTreasureHunts.caskets += databaseManager$OfferCode.getRewardAmount();
                    break;
                }
                case 1: {
                    this.LargePopup(2131165354, "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " Challenge Coins.");
                    final Dailies dailies = this.dailies;
                    dailies.challengeCoins += databaseManager$OfferCode.getRewardAmount();
                    break;
                }
                case 0: {
                    this.totalCoins += databaseManager$OfferCode.getRewardAmount();
                    this.LargePopup(2131166220, "Success", "You received " + databaseManager$OfferCode.getRewardAmount() + " Silver Coins");
                    this.UpdateCash();
                    break;
                }
            }
        }
    }
    
    private Map<String, Object> CreatePlayMap() {
        final HashMap hashMap = new HashMap();
        this.logoutTime = System.currentTimeMillis();
        final String join = TextUtils.join((CharSequence)"/", (Iterable)this.skillExp);
        final String join2 = TextUtils.join((CharSequence)"/", (Iterable)this.inventoryItems);
        final String join3 = TextUtils.join((CharSequence)"/", (Iterable)this.inventoryAmounts);
        final String join4 = TextUtils.join((CharSequence)"/", (Iterable)this.inventoryItemLocked);
        final String join5 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.seedBag);
        final String join6 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.seedBagAmounts);
        final String join7 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.farmCrop);
        final String join8 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.farmCropTimeRemaining);
        final String join9 = TextUtils.join((CharSequence)"/", (Iterable)this.combatManager.equippedItems);
        final String join10 = TextUtils.join((CharSequence)"/", (Iterable)this.premiumUpgradesPurchased);
        final String join11 = TextUtils.join((CharSequence)"/", (Iterable)this.quests.questsComplete);
        final String join12 = TextUtils.join((CharSequence)"/", (Iterable)this.baseTower.myTreestones);
        final String join13 = TextUtils.join((CharSequence)"/", (Iterable)this.baseTower.stashItems);
        final String join14 = TextUtils.join((CharSequence)"/", (Iterable)this.baseTower.stashAmounts);
        final String join15 = TextUtils.join((CharSequence)"/", (Iterable)this.myPets);
        final String join16 = TextUtils.join((CharSequence)"/", (Iterable)this.offerCodesRedeemed);
        final String join17 = TextUtils.join((CharSequence)"/", (Iterable)this.myTitles);
        final String join18 = TextUtils.join((CharSequence)"/", (Iterable)this.idleDrops);
        final String join19 = TextUtils.join((CharSequence)"/", (Iterable)this.myProfileAvatars);
        ((Map)hashMap).put((Object)"totalCoins", (Object)this.totalCoins);
        ((Map)hashMap).put((Object)"totalGems", (Object)this.totalGems);
        ((Map)hashMap).put((Object)"totalKillCoins", (Object)this.totalKillCoins);
        ((Map)hashMap).put((Object)"logoutTime", (Object)this.logoutTime);
        ((Map)hashMap).put((Object)"currentEventCurrency", (Object)this.currentEventCurrency);
        ((Map)hashMap).put((Object)"holidayCurrency", (Object)this.holidayCurrency);
        ((Map)hashMap).put((Object)"totalChickenKills", (Object)this.totalChickenKills);
        ((Map)hashMap).put((Object)"totalTribalKills", (Object)this.totalTribalKills);
        ((Map)hashMap).put((Object)"idleSkillTime", (Object)this.idleSkillTime);
        ((Map)hashMap).put((Object)"lastCloudRestore", (Object)this.lastCloudRestore);
        ((Map)hashMap).put((Object)"dailyBonus", (Object)this.dailies.dailyBonus);
        ((Map)hashMap).put((Object)"lastGodItem", (Object)this.treasureHunts.lastGodItem);
        ((Map)hashMap).put((Object)"dailySafesCracked", (Object)this.thieving.dailySafesCracked);
        ((Map)hashMap).put((Object)"skillExpStr", (Object)join);
        ((Map)hashMap).put((Object)"inventoryItemsStr", (Object)join2);
        ((Map)hashMap).put((Object)"inventoryAmountsStr", (Object)join3);
        ((Map)hashMap).put((Object)"inventoryItemLockedStr", (Object)join4);
        ((Map)hashMap).put((Object)"seedBagStr", (Object)join5);
        ((Map)hashMap).put((Object)"seedBagAmountsStr", (Object)join6);
        ((Map)hashMap).put((Object)"farmCropStr", (Object)join7);
        ((Map)hashMap).put((Object)"farmCropTimeRemainingStr", (Object)join8);
        ((Map)hashMap).put((Object)"equippedItemsStr", (Object)join9);
        ((Map)hashMap).put((Object)"premiumUpgradePurchasedStr", (Object)join10);
        ((Map)hashMap).put((Object)"questsCompleteStr", (Object)join11);
        ((Map)hashMap).put((Object)"myTreestonesStr", (Object)join12);
        ((Map)hashMap).put((Object)"stashItemsStr", (Object)join13);
        ((Map)hashMap).put((Object)"stashAmountsStr", (Object)join14);
        ((Map)hashMap).put((Object)"myPetsStr", (Object)join15);
        ((Map)hashMap).put((Object)"offerCodesRedeemedStr", (Object)join16);
        ((Map)hashMap).put((Object)"myTitlesStr", (Object)join17);
        ((Map)hashMap).put((Object)"idleDropsStr", (Object)join18);
        ((Map)hashMap).put((Object)"myProfileAvatarsStr", (Object)join19);
        ((Map)hashMap).put((Object)"currentAttackStyle", (Object)this.currentAttackStyle);
        ((Map)hashMap).put((Object)"equippedFood", (Object)this.equippedFood);
        ((Map)hashMap).put((Object)"slayerTask", (Object)this.combatManager.slayerTask);
        ((Map)hashMap).put((Object)"currentSlayerMaster", (Object)this.combatManager.currentSlayerMaster);
        ((Map)hashMap).put((Object)"baseTowerName", (Object)this.baseTower.baseTowerName);
        ((Map)hashMap).put((Object)"currentUsername", (Object)this.currentUsername);
        ((Map)hashMap).put((Object)"activeTitle", (Object)this.activeTitle);
        ((Map)hashMap).put((Object)"idleMethod", (Object)this.idleMethod);
        ((Map)hashMap).put((Object)"idleSkill", (Object)this.idleSkill);
        ((Map)hashMap).put((Object)"accountType", (Object)this.accountType);
        ((Map)hashMap).put((Object)"referringFriend", (Object)this.referringFriend);
        ((Map)hashMap).put((Object)"maxInventory", (Object)this.maxInventory);
        ((Map)hashMap).put((Object)"currentHealth", (Object)this.currentHealth);
        ((Map)hashMap).put((Object)"maxStamina", (Object)this.maxStamina);
        ((Map)hashMap).put((Object)"currentStamina", (Object)this.currentStamina);
        ((Map)hashMap).put((Object)"slayerAmount", (Object)this.combatManager.slayerAmount);
        ((Map)hashMap).put((Object)"fishingRodLevel", (Object)this.fishingRodLevel);
        ((Map)hashMap).put((Object)"planters", (Object)this.farming.planters);
        ((Map)hashMap).put((Object)"exploreItems", (Object)this.exploreItems);
        ((Map)hashMap).put((Object)"staminaSaveChance", (Object)this.staminaSaveChance);
        ((Map)hashMap).put((Object)"expMultiplier", (Object)this.expMultiplier);
        ((Map)hashMap).put((Object)"marketDiscount", (Object)this.marketDiscount);
        ((Map)hashMap).put((Object)"doubleFish", (Object)this.doubleFish);
        ((Map)hashMap).put((Object)"doublePotions", (Object)this.doublePotions);
        ((Map)hashMap).put((Object)"resourceSave", (Object)this.resourceSave);
        ((Map)hashMap).put((Object)"farmingTimer", (Object)this.farmingTimer);
        ((Map)hashMap).put((Object)"maxIdleIncrease", (Object)this.maxIdleIncrease);
        ((Map)hashMap).put((Object)"baseTowerLevel", (Object)this.baseTower.baseTowerLevel);
        ((Map)hashMap).put((Object)"hiddenBonuses", (Object)this.baseTower.hiddenBonuses);
        ((Map)hashMap).put((Object)"maxStash", (Object)this.baseTower.maxStash);
        ((Map)hashMap).put((Object)"discoveryFailChance", (Object)this.discovery.discoveryFailChance);
        ((Map)hashMap).put((Object)"skipTickets", (Object)this.dailies.skipTickets);
        ((Map)hashMap).put((Object)"challengeCoins", (Object)this.dailies.challengeCoins);
        ((Map)hashMap).put((Object)"lastLoginDay", (Object)this.dailies.lastLoginDay);
        ((Map)hashMap).put((Object)"doubleDays", (Object)this.dailies.doubleDays);
        ((Map)hashMap).put((Object)"vaultChances", (Object)this.databaseManager.vaultChances);
        ((Map)hashMap).put((Object)"activeCharacter", (Object)this.activeCharacter);
        ((Map)hashMap).put((Object)"activeAvatar", (Object)this.activeAvatar);
        ((Map)hashMap).put((Object)"cocktailsDrank", (Object)this.alchemy.cocktailsDrank);
        ((Map)hashMap).put((Object)"autoEat", (Object)this.autoEat);
        ((Map)hashMap).put((Object)"saveAvailable", (Object)this.saveAvailable);
        ((Map)hashMap).put((Object)"members", (Object)this.members);
        ((Map)hashMap).put((Object)"claimedGift", (Object)this.claimedGift);
        if (this.accountStats != null) {
            ((Map)hashMap).put((Object)"accountStats", (Object)new Gson().toJson((Object)this.accountStats));
        }
        if (!this.dailies.dailyChallenges.isEmpty()) {
            ((Map)hashMap).put((Object)"dailyChallenges", (Object)new Gson().toJson((Object)this.dailies.dailyChallenges));
        }
        ((Map)hashMap).put((Object)"vaultCodesClaimed", (Object)new Gson().toJson((Object)this.databaseManager.vaultCodesClaimed));
        if (!this.databaseManager.myWishes.isEmpty()) {
            ((Map)hashMap).put((Object)"myWishes", (Object)new Gson().toJson((Object)this.databaseManager.myWishes));
        }
        if (!this.databaseManager.myBigWishes.isEmpty()) {
            ((Map)hashMap).put((Object)"myBigWishes", (Object)new Gson().toJson((Object)this.databaseManager.myBigWishes));
        }
        if (this.treasureHunts.myTreasureHunts != null) {
            ((Map)hashMap).put((Object)"myTreasureHunts", (Object)new Gson().toJson((Object)this.treasureHunts.myTreasureHunts));
        }
        if (this.treasureHunts.eventPresent != null) {
            ((Map)hashMap).put((Object)"myEventPresents", (Object)new Gson().toJson((Object)this.treasureHunts.eventPresent));
        }
        if (this.combatManager.slayerInfo != null) {
            ((Map)hashMap).put((Object)"slayerInfo", (Object)new Gson().toJson((Object)this.combatManager.slayerInfo));
        }
        if (this.itemManager.skillingScrolls != null) {
            ((Map)hashMap).put((Object)"mySkillingScrolls", (Object)new Gson().toJson((Object)this.itemManager.skillingScrolls));
        }
        if (this.itemManager.blessings != null) {
            ((Map)hashMap).put((Object)"myBlessings", (Object)new Gson().toJson((Object)this.itemManager.blessings));
        }
        if (this.secretPathway.myPath != null) {
            ((Map)hashMap).put((Object)"mysecpath", (Object)new Gson().toJson((Object)this.secretPathway.myPath));
        }
        if (this.combatManager.equipmentPresets != null) {
            ((Map)hashMap).put((Object)"equipmentPresets", (Object)new Gson().toJson((Object)this.combatManager.equipmentPresets));
        }
        return (Map<String, Object>)hashMap;
    }
    
    private void EquipIt(final int n, final String s, final int n2) {
        this.CloseItemSelect();
        if (this.combatManager.equippedItems.get(n) != null && ((String)this.combatManager.equippedItems.get(n)).equals((Object)s)) {
            this.attackBonus -= (int)this.allItemsAttackBonus.get(n2);
            this.strengthBonus -= (int)this.allItemsStrengthBonus.get(n2);
            this.defenceBonus -= (int)this.allItemsDefenceBonus.get(n2);
            this.healthBonus -= (int)this.allItemsHealthBonus.get(n2);
            this.combatManager.equippedItems.set(n, (Object)null);
        }
        else {
            if (this.combatManager.equippedItems.get(n) != null) {
                final String s2 = (String)this.combatManager.equippedItems.get(n);
                this.attackBonus -= (int)this.allItemsAttackBonus.get(this.allItems.indexOf((Object)s2));
                this.strengthBonus -= (int)this.allItemsStrengthBonus.get(this.allItems.indexOf((Object)s2));
                this.defenceBonus -= (int)this.allItemsDefenceBonus.get(this.allItems.indexOf((Object)s2));
                this.healthBonus -= (int)this.allItemsHealthBonus.get(this.allItems.indexOf((Object)s2));
            }
            this.combatManager.equippedItems.set(n, (Object)s);
            this.attackBonus += (int)this.allItemsAttackBonus.get(n2);
            this.strengthBonus += (int)this.allItemsStrengthBonus.get(n2);
            this.defenceBonus += (int)this.allItemsDefenceBonus.get(n2);
            this.healthBonus += (int)this.allItemsHealthBonus.get(n2);
        }
        this.UpdateMaxHealth();
        this.UpdateEquipment();
    }
    
    private void EquipPreset(final List<String> list) {
        final ArrayList list2 = new ArrayList();
        for (int i = 0; i < list.size(); ++i) {
            final String s = (String)this.combatManager.equippedItems.get(i);
            final String s2 = (String)list.get(i);
            if (!Objects.equals((Object)s, (Object)s2)) {
                if (s != null) {
                    if (((String)this.combatManager.equippedItemsTypes.get(i)).equals((Object)"Pet")) {
                        this.combatManager.equippedItems.set(i, (Object)null);
                    }
                    else {
                        this.UnEquipItem(this.allItems.indexOf((Object)s), i);
                    }
                    Picasso.get().load((int)this.equipmentPlaceholders.get(i)).into((ImageView)this.combatManager.equippedItemsViews.get(i));
                }
                if (s2 != null) {
                    if (((String)this.combatManager.equippedItemsTypes.get(i)).equals((Object)"Pet")) {
                        this.combatManager.equippedItems.set(i, (Object)s2);
                        if (this.skillingPets.contains((Object)s2)) {
                            Picasso.get().load((int)this.skillingPetsIcons.get(this.skillingPets.indexOf((Object)s2))).into((ImageView)this.combatManager.equippedItemsViews.get(i));
                        }
                        else {
                            Picasso.get().load((int)this.specialPetsIcons.get(this.specialPets.indexOf((Object)s2))).into((ImageView)this.combatManager.equippedItemsViews.get(i));
                        }
                    }
                    else if (this.inventoryItems.contains((Object)s2)) {
                        this.EquipIt(i, s2, this.allItems.indexOf((Object)s2));
                        Picasso.get().load((int)this.allItemsIcons.get(this.allItems.indexOf((Object)s2))).into((ImageView)this.combatManager.equippedItemsViews.get(i));
                    }
                    else {
                        ((List)list2).add((Object)s2);
                    }
                }
            }
        }
        if (!((List)list2).isEmpty()) {
            this.QuickPopup("The following items are unavailable: " + String.join((CharSequence)", ", (Iterable)list2));
        }
        else {
            this.QuickPopup("Preset loaded");
        }
        this.UpdateMaxHealth();
        this.UpdateEquipmentStats();
    }
    
    private void GeneratePets() {
        for (int i = 0; i < this.skillingPets.size(); ++i) {
            final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this, 2131493038, (ViewGroup)null);
            this.petInfo = (LinearLayout)relativeLayout.findViewById(2131296978);
            final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
            if (i > 0) {
                linearLayout$LayoutParams.topMargin = this.GetResource(2131099658);
            }
            this.myPetsList.addView((View)relativeLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
            Picasso.get().load((int)this.skillingPetsIcons.get(i)).into((ImageView)relativeLayout.getChildAt(0));
            ((TextView)this.petInfo.getChildAt(0)).setText((CharSequence)((String)this.skillingPets.get(i) + " the " + (String)this.skills.get(i) + " Pet"));
            ((TextView)this.petInfo.getChildAt(1)).setText((CharSequence)this.skillingPetAbilities.get(i));
            if (!this.myPets.contains(this.skillingPets.get(i))) {
                relativeLayout.setAlpha(0.3f);
            }
        }
        for (int j = 0; j < this.specialPets.size(); ++j) {
            final RelativeLayout relativeLayout2 = (RelativeLayout)View.inflate((Context)this, 2131493038, (ViewGroup)null);
            this.petInfo = (LinearLayout)relativeLayout2.findViewById(2131296978);
            final LinearLayout$LayoutParams linearLayout$LayoutParams2 = new LinearLayout$LayoutParams(-1, -2);
            linearLayout$LayoutParams2.topMargin = this.GetResource(2131099658);
            this.myPetsList.addView((View)relativeLayout2, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
            Picasso.get().load((int)this.specialPetsIcons.get(j)).into((ImageView)relativeLayout2.getChildAt(0));
            ((TextView)this.petInfo.getChildAt(0)).setText((CharSequence)this.specialPets.get(j));
            ((TextView)this.petInfo.getChildAt(1)).setText((CharSequence)this.specialPetAbilities.get(j));
            if (!this.myPets.contains(this.specialPets.get(j))) {
                relativeLayout2.setAlpha(0.3f);
            }
        }
    }
    
    private void GenerateRequirements(LinearLayout linearLayout, final List<String> list) {
        linearLayout = (LinearLayout)linearLayout.getChildAt(1);
        final int visibility = linearLayout.getVisibility();
        int i = 0;
        if (visibility == 0) {
            linearLayout.setVisibility(8);
        }
        else {
            linearLayout.setVisibility(0);
        }
        if (linearLayout.getChildCount() == 0) {
            while (i < list.size()) {
                final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
                final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -2);
                if (i > 0) {
                    layoutParams.topMargin = this.GetResource(2131099980);
                }
                textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                textView.setText((CharSequence)("- " + (String)list.get(i)));
                this.SetTextSize(textView, this.GetResource(2131099658));
                textView.setTextColor(this.GetColour(2131034225));
                linearLayout.addView((View)textView);
                ++i;
            }
        }
    }
    
    private String GetExpToLevel(final String s) {
        final long longValue = (long)this.skillExp.get(this.skills.indexOf((Object)s));
        if (this.GetSkillLevel(s) >= this.GetSkillMaxLevel(s)) {
            return this.FormatExp(longValue);
        }
        return this.FormatExp(longValue) + " / " + this.FormatExp((long)this.levelExp.get(this.GetSkillLevel(s)));
    }
    
    private long GetMonsterKills() {
        long n = 0L;
        for (int i = 0; i < this.accountStats.getAllMonsterKills().size(); ++i) {
            n += (long)this.accountStats.getAllMonsterKills().get(i);
        }
        return n;
    }
    
    private String GetMostKilledMonster() {
        long n = 0L;
        int i = 0;
        int n2 = 0;
        while (i < this.accountStats.getAllMonsterKills().size()) {
            long longValue = n;
            if ((long)this.accountStats.getAllMonsterKills().get(i) > n) {
                longValue = (long)this.accountStats.getAllMonsterKills().get(i);
                n2 = i;
            }
            ++i;
            n = longValue;
        }
        return this.FormatExp(n) + " " + (String)this.combatManager.enemyNames.get(n2) + " kills";
    }
    
    private void HandleHoliday() {
        if (!this.holidayEventAvailable) {
            return;
        }
        final long currencyTimer = this.event.currencyTimer;
        final long crackerTimer = this.event.crackerTimer;
        long n = currencyTimer;
        long n2 = crackerTimer;
        if (this.combatManager.equippedItems.contains((Object)"Marshmallow the Bunny")) {
            n = currencyTimer - 15L;
            n2 = crackerTimer - 30L;
        }
        if (this.totalGameTicks % n == 0L) {
            this.event.EventCurrency();
        }
        if (this.totalGameTicks % n2 == 0L) {
            this.event.CheckCracker();
        }
        if (this.totalGameTicks % 20L == 0L && this.databaseManager.GetWishLevel("Event Mayhem", "Endgame") > 0) {
            final long n3 = this.databaseManager.GetWishLevel("Event Mayhem", "Endgame") * 5L;
            this.holidayCurrency += n3;
            this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda52(this, n3));
        }
        if (this.totalGameTicks % 300L == 0L) {
            this.databaseManager.CheckSnowball();
        }
        if (this.totalGameTicks % 30L == 0L) {
            this.event.CheckJumpers();
        }
        if (this.totalGameTicks % 45L == 0L) {
            this.event.CheckDisguise();
        }
    }
    
    private void IdlePopup(long min, final TextView textView) {
        this.LoadChestScreen();
        this.HideView(this.chestLootScreen.getChildAt(0));
        this.HideView(this.chestLootScreen.getChildAt(1));
        ((LinearLayout)this.chestLootScreen.getChildAt(2)).removeAllViews();
        this.chestLootScreen.getChildAt(3).setAlpha(0.0f);
        this.ShowView(this.findViewById(2131296964));
        textView.setVisibility(8);
        int n;
        if (this.members) {
            n = 360;
        }
        else {
            n = 120;
        }
        min = Math.min(min, (long)(n + this.databaseManager.GetWishLevel("Idle Please", "Beginner") * 15));
        final long n2 = this.maxIdleIncrease;
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute((Runnable)new MainActivity$$ExternalSyntheticLambda39(this, min + n2));
        singleThreadExecutor.shutdown();
    }
    
    private boolean One99() {
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= this.skills.size()) {
                break;
            }
            try {
                if (this.GetSkillLevel((String)this.skills.get(n)) >= 99) {
                    b2 = true;
                    break;
                }
            }
            catch (final IndexOutOfBoundsException ex) {
                this.LogIt("Index out here: " + (Object)ex);
            }
            ++n;
        }
        return b2;
    }
    
    private void OpenCompProgress() {
        this.LoadGenerations("Completion Cape Progress", "Here you can view the requirements for the 3 Completion Capes and your progress towards them. Simply tap the cape to view the requirements.");
        final LinearLayout linearLayout = (LinearLayout)View.inflate((Context)this, 2131492910, (ViewGroup)null);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, -2);
        linearLayout$LayoutParams.leftMargin = this.GetResource(2131100202);
        linearLayout$LayoutParams.rightMargin = this.GetResource(2131100202);
        linearLayout$LayoutParams.bottomMargin = this.GetResource(2131100202);
        this.genWrap.addView((View)linearLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        ((ImageView)((RelativeLayout)linearLayout.getChildAt(0)).getChildAt(0)).setImageDrawable(this.GetImage(2131165708));
        ((TextView)((RelativeLayout)linearLayout.getChildAt(0)).getChildAt(1)).setText((CharSequence)"Completion Cape");
        final LinearLayout linearLayout2 = (LinearLayout)View.inflate((Context)this, 2131492910, (ViewGroup)null);
        final LinearLayout$LayoutParams linearLayout$LayoutParams2 = new LinearLayout$LayoutParams(-1, -2);
        linearLayout$LayoutParams2.leftMargin = this.GetResource(2131100202);
        linearLayout$LayoutParams2.rightMargin = this.GetResource(2131100202);
        linearLayout$LayoutParams2.bottomMargin = this.GetResource(2131100202);
        this.genWrap.addView((View)linearLayout2, (ViewGroup$LayoutParams)linearLayout$LayoutParams2);
        ((ImageView)((RelativeLayout)linearLayout2.getChildAt(0)).getChildAt(0)).setImageDrawable(this.GetImage(2131166332));
        ((TextView)((RelativeLayout)linearLayout2.getChildAt(0)).getChildAt(1)).setText((CharSequence)"Ultra Comp Cape");
        final LinearLayout linearLayout3 = (LinearLayout)View.inflate((Context)this, 2131492910, (ViewGroup)null);
        final LinearLayout$LayoutParams linearLayout$LayoutParams3 = new LinearLayout$LayoutParams(-1, -2);
        linearLayout$LayoutParams3.leftMargin = this.GetResource(2131100202);
        linearLayout$LayoutParams3.rightMargin = this.GetResource(2131100202);
        linearLayout$LayoutParams3.bottomMargin = this.GetResource(2131100202);
        this.genWrap.addView((View)linearLayout3, (ViewGroup$LayoutParams)linearLayout$LayoutParams3);
        ((ImageView)((RelativeLayout)linearLayout3.getChildAt(0)).getChildAt(0)).setImageDrawable(this.GetImage(2131166048));
        ((TextView)((RelativeLayout)linearLayout3.getChildAt(0)).getChildAt(1)).setText((CharSequence)"No Life Cape");
        final ArrayList list = new ArrayList((Collection)Collections.singletonList((Object)"All Skills at Max Level, 99 and 130."));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Same as the Completion Cape plus the following...", "All Pets: " + this.myPets.size() + " / " + this.skillingPets.size(), "All Quests Complete: " + this.quests.questsComplete.size() + " / " + this.quests.questTitle.size(), "Base Camp Level: " + this.baseTower.baseTowerLevel + " / 50" }));
        final ArrayList list3 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Same as the Ultra Comp Cape plus the following...", "Items Crafted: " + this.FormatExp(this.accountStats.getItemsCrafted()) + " / 50,000,000", "Energy Used: " + this.FormatExp(this.accountStats.getEnergyUsed()) + " / 25,000,000", "Treasure Scrolls Completed: " + this.FormatExp(this.accountStats.getScrollsCompleted()) + " / 10,000", "Base Camp Level: " + this.baseTower.baseTowerLevel + " / 75", "Empyreon Safes Cracked: " + this.FormatExp(this.accountStats.getEmpyreonSafesCracked()) + " / 10,000", "100,000 Kills on every monster, as listed below..." }));
        for (int n = 0; n < this.combatManager.enemyNames.size() && !((String)this.combatManager.enemyArea.get(n)).equals((Object)"Shadow Realm"); ++n) {
            if (!((String)this.combatManager.enemyNames.get(n)).equals((Object)"Practice Dummy")) {
                if (!this.combatManager.allGods.contains(this.combatManager.enemyNames.get(n))) {
                    if (((String)this.combatManager.enemyArea.get(n)).equals((Object)"Shadow Realm")) {
                        ((List)list3).add((Object)((String)this.combatManager.enemyNames.get(n) + " Kills: " + this.FormatExp((long)this.accountStats.getAllMonsterKills().get(n)) + " / 5,000"));
                    }
                    else {
                        ((List)list3).add((Object)((String)this.combatManager.enemyNames.get(n) + " Kills: " + this.FormatExp((long)this.accountStats.getAllMonsterKills().get(n)) + " / 100,000"));
                    }
                }
                else {
                    ((List)list3).add((Object)((String)this.combatManager.enemyNames.get(n) + " Kills: " + this.FormatExp((long)this.accountStats.getAllMonsterKills().get(n)) + " / 10,000"));
                }
            }
        }
        linearLayout.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda152(this, linearLayout, (List)list));
        linearLayout2.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda153(this, linearLayout2, (List)list2));
        linearLayout3.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda155(this, linearLayout3, (List)list3));
    }
    
    private void OpenPets() {
        if (this.petScreen == null) {
            final ScrollView petScreen = (ScrollView)((ViewStub)this.findViewById(2131296980)).inflate();
            this.petScreen = petScreen;
            this.myPetsList = (LinearLayout)petScreen.findViewById(2131296896);
        }
        this.EnableLayout((ViewGroup)this.petScreen);
        this.HideView(this.currentView);
        this.ShowView(this.currentView = (View)this.petScreen);
        if (this.myPetsList.getChildCount() == 0) {
            this.GeneratePets();
        }
        else {
            this.UpdatePets();
        }
    }
    
    private void OpenPremium() {
        this.DisableScreen();
        final RelativeLayout proScreen = (RelativeLayout)this.inflater.inflate(2131492955, (ViewGroup)this.mainView, false);
        this.proScreen = proScreen;
        this.mainView.addView((View)proScreen);
        this.closePro = (TextView)this.proScreen.findViewById(2131296454);
        this.proPurchase = (TextView)this.proScreen.findViewById(2131296995);
        this.ShowView((View)this.proScreen);
        if (this.billingInitialized && !this.inAppProducts.isEmpty() && this.skuNames.contains((Object)"cherrytree_premium")) {
            final ProductDetails productDetails = (ProductDetails)this.inAppProducts.get(this.skuNames.indexOf((Object)"cherrytree_premium"));
            this.proPurchase.setText((CharSequence)((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)productDetails.getOneTimePurchaseOfferDetails())).getFormattedPrice());
            this.proPurchase.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda141(this, productDetails));
        }
        else {
            this.proPurchase.setText((CharSequence)"Error");
        }
        this.closePro.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda142(this));
        final TextView textView = (TextView)this.proScreen.getChildAt(3);
        if (this.billingInitialized) {
            textView.setVisibility(0);
            textView.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda144(this));
        }
        else {
            textView.setVisibility(8);
        }
    }
    
    private void OpenStats() {
        this.LoadGenerations(null, null);
        final StringBuilder sb = new StringBuilder();
        sb.append("CherryTree Statistics\n").append(this.getString(2131820765));
        final boolean b = this.AllFree99s() && !this.members;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Username", "Premium", "Maxed", "Free Maxed", "Ultimaxed", "Total Level", "Total Exp", "Base Camp Level", "Pets Discovered", "Silver Coins", "Slayer Coins", "Gold Coins", "Titles Unlocked", "Active Title" }));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { this.currentUsername, String.valueOf(this.members), String.valueOf(this.All99s()), String.valueOf(b), String.valueOf(this.Ultimaxed()), this.FormatExp(this.GetTotalLevel()), this.FormatExp(this.GetTotalExp()), String.valueOf(this.baseTower.baseTowerLevel), String.valueOf(this.myPets.size()), this.FormatExp(this.totalCoins), this.FormatExp(this.combatManager.slayerInfo.getKillcoins()), this.FormatExp(this.totalGems), String.valueOf(this.myTitles.size()), this.activeTitle }));
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -2);
        layoutParams.topMargin = -this.GetResource(2131099658);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        textView.setText((CharSequence)"Account Statistics");
        textView.setGravity(17);
        textView.setTextColor(this.GetColour(2131034925));
        this.SetTextSize(textView, this.GetResource(2131099724));
        textView.setPadding(this.GetResource(2131099658), this.GetResource(2131099658), this.GetResource(2131099658), this.GetResource(2131099658));
        textView.setBackground(this.GetImage(2131165346));
        this.genWrap.addView((View)textView);
        for (int i = 0; i < ((List)list).size(); ++i) {
            if (((String)((List)list2).get(i)).equals((Object)"false")) {
                ((List)list2).set(i, (Object)"No");
            }
            else if (((String)((List)list2).get(i)).equals((Object)"true")) {
                ((List)list2).set(i, (Object)"Yes");
            }
            if (((String)((List)list2).get(i)).isEmpty()) {
                ((List)list2).set(i, (Object)"N/A");
            }
            final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
            this.genWrap.addView((View)relativeLayout);
            ((TextView)relativeLayout.getChildAt(0)).setText((CharSequence)((List)list).get(i));
            ((TextView)relativeLayout.getChildAt(1)).setText((CharSequence)((List)list2).get(i));
            sb.append("\n");
            sb.append((String)((List)list).get(i)).append(": ").append((String)((List)list2).get(i));
        }
        final RelativeLayout relativeLayout2 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout2);
        ((TextView)relativeLayout2.getChildAt(0)).setText((CharSequence)"Total Monster Kills");
        ((TextView)relativeLayout2.getChildAt(1)).setText((CharSequence)this.FormatExp(this.GetMonsterKills()));
        sb.append("\nTotal Monster Kills: ");
        sb.append(this.FormatExp(this.GetMonsterKills()));
        final RelativeLayout relativeLayout3 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout3);
        ((TextView)relativeLayout3.getChildAt(0)).setText((CharSequence)"Most Killed Monster");
        ((TextView)relativeLayout3.getChildAt(1)).setText((CharSequence)this.GetMostKilledMonster());
        sb.append("\nMost Killed Monster: ");
        sb.append(this.GetMostKilledMonster());
        final RelativeLayout relativeLayout4 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout4);
        ((TextView)relativeLayout4.getChildAt(0)).setText((CharSequence)"Items Crafted");
        ((TextView)relativeLayout4.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getItemsCrafted()));
        sb.append("\nItems Crafted: ");
        sb.append(this.FormatExp(this.accountStats.getItemsCrafted()));
        final RelativeLayout relativeLayout5 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout5);
        ((TextView)relativeLayout5.getChildAt(0)).setText((CharSequence)"Energy Used");
        ((TextView)relativeLayout5.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getEnergyUsed()));
        sb.append("\nEnergy Used: ");
        sb.append(this.FormatExp(this.accountStats.getEnergyUsed()));
        final RelativeLayout relativeLayout6 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout6);
        ((TextView)relativeLayout6.getChildAt(0)).setText((CharSequence)"Secret Rares Found");
        ((TextView)relativeLayout6.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getSecretsFound()));
        sb.append("\nSecret Rares Found: ");
        sb.append(this.FormatExp(this.accountStats.getSecretsFound()));
        final RelativeLayout relativeLayout7 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout7);
        ((TextView)relativeLayout7.getChildAt(0)).setText((CharSequence)"Treasure Scrolls Completed");
        ((TextView)relativeLayout7.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getScrollsCompleted()));
        sb.append("\nTreasure Scrolls Completed: ");
        sb.append(this.FormatExp(this.accountStats.getScrollsCompleted()));
        final RelativeLayout relativeLayout8 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout8);
        ((TextView)relativeLayout8.getChildAt(0)).setText((CharSequence)"Treasure Caskets Opened");
        ((TextView)relativeLayout8.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getCasketsOpened()));
        sb.append("\nTreasure Caskets Opened: ");
        sb.append(this.FormatExp(this.accountStats.getCasketsOpened()));
        final RelativeLayout relativeLayout9 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout9);
        ((TextView)relativeLayout9.getChildAt(0)).setText((CharSequence)"God Items Found");
        ((TextView)relativeLayout9.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getGodItemsFound()));
        sb.append("\nGod Items Found: ");
        sb.append(this.FormatExp(this.accountStats.getGodItemsFound()));
        final RelativeLayout relativeLayout10 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout10);
        ((TextView)relativeLayout10.getChildAt(0)).setText((CharSequence)"Total Safes Cracked");
        ((TextView)relativeLayout10.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getSafesCracked()));
        sb.append("\nTotal Safes Cracked: ");
        sb.append(this.FormatExp(this.accountStats.getSafesCracked()));
        final RelativeLayout relativeLayout11 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout11);
        ((TextView)relativeLayout11.getChildAt(0)).setText((CharSequence)"Empyreon Safes Cracked");
        ((TextView)relativeLayout11.getChildAt(1)).setText((CharSequence)this.FormatExp(this.accountStats.getEmpyreonSafesCracked()));
        sb.append("\nEmpyreon Safes Cracked: ");
        sb.append(this.FormatExp(this.accountStats.getEmpyreonSafesCracked()));
        final RelativeLayout relativeLayout12 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout12);
        ((TextView)relativeLayout12.getChildAt(0)).setText((CharSequence)"Mercy");
        ((TextView)relativeLayout12.getChildAt(1)).setText((CharSequence)this.FormatExp(this.treasureHunts.casketMitigation - (this.accountStats.getCasketsOpened() - this.treasureHunts.lastGodItem)));
        final RelativeLayout relativeLayout13 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
        this.genWrap.addView((View)relativeLayout13);
        ((TextView)relativeLayout13.getChildAt(0)).setText((CharSequence)"Current Play Session");
        final long totalGameTicks = this.totalGameTicks;
        ((TextView)relativeLayout13.getChildAt(1)).setText((CharSequence)String.format(Locale.UK, "%02dh %02dm", new Object[] { totalGameTicks / 3600L, totalGameTicks % 3600L / 60L }));
        if (!this.databaseManager.activeDisplayName.isEmpty() && this.databaseManager.firebaseUser != null) {
            final FirebaseUserMetadata metadata = this.databaseManager.firebaseUser.getMetadata();
            if (metadata != null) {
                final String formatDateWithSuffix = this.formatDateWithSuffix(metadata.getCreationTimestamp());
                final RelativeLayout relativeLayout14 = (RelativeLayout)View.inflate((Context)this, 2131492892, (ViewGroup)null);
                this.genWrap.addView((View)relativeLayout14);
                ((TextView)relativeLayout14.getChildAt(0)).setText((CharSequence)"Account Creation");
                ((TextView)relativeLayout14.getChildAt(1)).setText((CharSequence)formatDateWithSuffix);
            }
        }
        final TextView addButton = this.AddButton("Share Statistics");
        this.genWrap.addView((View)addButton);
        addButton.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda89(this, sb));
    }
    
    private void PresetListeners() {
        this.equipmentPresets.removeAllViews();
        for (int i = 0; i < this.combatManager.equipmentPresets.size(); ++i) {
            final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this, 2131492938, (ViewGroup)null);
            final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, this.GetResource(2131099991));
            if (i > 0) {
                linearLayout$LayoutParams.topMargin = this.GetResource(2131100202);
            }
            this.equipmentPresets.addView((View)relativeLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
            if (this.combatManager.equipmentPresets.get(i) == null) {
                ((TextView)relativeLayout.getChildAt(0)).setText((CharSequence)"Empty Preset");
            }
            else {
                ((TextView)relativeLayout.getChildAt(0)).setText((CharSequence)("Preset " + (i + 1)));
            }
            relativeLayout.getChildAt(1).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda30(this, i));
            relativeLayout.getChildAt(2).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda31(this, i, relativeLayout));
        }
    }
    
    private void SetInventSizes(final int n) {
        final int getResource = this.GetResource(2131099769);
        final int getResource2 = this.GetResource(2131100202);
        final int rowSize = this.itemManager.rowSize;
        final ItemManager itemManager = this.itemManager;
        itemManager.inventItemSize = (n - (getResource + getResource2 * (rowSize - 1))) / itemManager.rowSize;
        final ItemManager itemManager2 = this.itemManager;
        itemManager2.inventImageSize = (int)(itemManager2.inventItemSize / 10.0f * 5.2f);
    }
    
    private void SetUser() {
        PlayGames.getPlayersClient((Activity)this).getCurrentPlayer().addOnCompleteListener((OnCompleteListener)new MainActivity$$ExternalSyntheticLambda149(this));
    }
    
    private void ShowIdleLoot(final List<String> list, final List<Integer> list2, long n, long min, long n2) {
        this.HideView(this.findViewById(2131296964));
        final LinearLayout linearLayout = (LinearLayout)this.chestLootScreen.getChildAt(2);
        this.totalCoins += min;
        min = Math.min(Math.max(n, 0L), 1000000L);
        this.ShowView(this.chestLootScreen.getChildAt(0));
        this.ShowView(this.chestLootScreen.getChildAt(1));
        ((ImageView)this.chestLootScreen.getChildAt(0)).setImageDrawable(this.GetImage((int)this.skillsIcons.get(this.skills.indexOf((Object)this.idleSkill))));
        n = n2 / 60L;
        String s;
        if (n > 0L) {
            n2 %= 60L;
            if (n2 > 0L) {
                s = String.format(Locale.UK, "%d Hours and %d Minutes", new Object[] { n, n2 });
            }
            else {
                s = String.format(Locale.UK, "%d Hours", new Object[] { n });
            }
        }
        else {
            s = String.format(Locale.UK, "%d Minutes", new Object[] { n2 % 60L });
        }
        this.databaseManager.StoreIdleGain(this.idleSkill, this.idleMethod, s);
        ((TextView)this.chestLootScreen.getChildAt(1)).setText((CharSequence)("Skill: " + this.idleSkill + " (" + this.idleMethod + ")\nTime: " + s + "\nExp Gain: " + this.FormatExp(min) + "\nYou received the following loot..."));
        for (int i = 0; i < list.size(); ++i) {
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = this.GetResource(2131099869);
            }
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            textView.setTextColor(this.GetColour(2131034225));
            this.SetTextSize(textView, this.GetResource(2131099669));
            textView.setText((CharSequence)(" " + this.FormatExp((int)list2.get(i)) + "x " + (String)list.get(i)));
            textView.setGravity(17);
            linearLayout.addView((View)textView);
            if (((String)list.get(i)).equals((Object)"Gold Coin")) {
                this.totalGems += (int)list2.get(i);
            }
            else if (((String)list.get(i)).equals((Object)"Coins")) {
                this.totalCoins += (int)list2.get(i);
            }
            else if (this.farming.farmingSeeds.contains(list.get(i))) {
                this.GiveSeed((String)list.get(i), (int)list2.get(i));
            }
            else {
                this.GiveItem((String)list.get(i), (int)list2.get(i), false);
            }
        }
        this.mainHandler.postDelayed((Runnable)new MainActivity$$ExternalSyntheticLambda67(this, min), 1500L);
    }
    
    private void Socials() {
        int i = 0;
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Join the incredible Discord Server!", "Check out the Community Podcast on Spotify!", "Join us on Reddit", "Get the latest news on Facebook", "Check out our Community YouTube channel", "Follow us on Instagram", "Follow us on TikTok" }));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "https://discord.gg/xPqYWyyF9v", "https://open.spotify.com/show/2tp7Kh3Uk1kIjsmha2yefW?si=2bbce260b3f94805", "https://www.reddit.com/r/CherryTreeRpg/", "https://www.facebook.com/groups/cherrytreerpg", "https://www.youtube.com/@CherryTreeCommunity", "https://www.instagram.com/cherrytreerpg", "https://www.tiktok.com/@cherrytree.rpg" }));
        this.LoadItemSelect("Join our Socials");
        this.itemSelect_wrap.removeAllViews();
        while (i < ((List)list).size()) {
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
            textView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
            textView.setText((CharSequence)((List)list).get(i));
            this.SetTextSize(textView, this.GetResource(2131099669));
            textView.setTextColor(this.GetColour(2131034924));
            textView.setBackground(this.GetImage(2131165348));
            textView.setGravity(16);
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setPadding(this.GetResource(2131099658), this.GetResource(2131099658), this.GetResource(2131099658), this.GetResource(2131099658));
            this.itemSelect_wrap.addView((View)textView);
            textView.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda110(this, (List)list2, i));
            ++i;
        }
    }
    
    private void TickLoop() {
        ++this.totalGameTicks;
        this.HandleHoliday();
        if (this.totalGameTicks % 60L == 0L) {
            final int getWishLevel = this.databaseManager.GetWishLevel("Ticket Rain", "Endgame");
            if (getWishLevel > 0 && this.GetRandom(1, 1000) <= getWishLevel) {
                final ItemManager$Blessings blessings = this.itemManager.blessings;
                ++blessings.tickets;
                this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda17(this));
            }
        }
        if (this.skillingTimerRunning) {
            this.secretPathway.CheckPathway(this.trainingSkill, this.trainingMethod);
            if (this.totalGameTicks % 10L == 0L && this.databaseManager.weeklySkill.equals((Object)this.trainingSkill)) {
                this.databaseManager.CheckSkillingOutfits();
            }
            if (this.totalGameTicks % 20L == 0L) {
                if (this.trainingSkill.equals((Object)"Mining")) {
                    if (this.combatManager.equippedItems.contains((Object)"Rusty Pickaxe")) {
                        if (this.GetRandom(1, 3000) <= 2) {
                            final TreasureHunts.MyTreasureHunts myTreasureHunts = this.treasureHunts.myTreasureHunts;
                            ++myTreasureHunts.caskets;
                            this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda19(this));
                        }
                        else {
                            final String s = (String)this.mining.rustyPickaxeLootTable.get(new Random().nextInt(this.mining.rustyPickaxeLootTable.size()));
                            if (s.equals((Object)"Gold Coin")) {
                                final int getRandom = this.GetRandom(2, 10);
                                this.totalGems += getRandom;
                                this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda20(this, getRandom));
                            }
                            else {
                                this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda21(this, s));
                            }
                        }
                    }
                    if (this.combatManager.equippedItems.contains((Object)"Golden Pickaxe")) {
                        this.GoldenTools("Golden Pickaxe");
                    }
                }
                if (this.trainingSkill.equals((Object)"Forestry")) {
                    if (this.combatManager.equippedItems.contains((Object)"Rusty Hatchet")) {
                        if (this.GetRandom(1, 3000) <= 2) {
                            final TreasureHunts.MyTreasureHunts myTreasureHunts2 = this.treasureHunts.myTreasureHunts;
                            ++myTreasureHunts2.caskets;
                            this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda23(this));
                        }
                        else {
                            final String s2 = (String)this.forestry.rustyHatchetLootTable.get(new Random().nextInt(this.forestry.rustyHatchetLootTable.size()));
                            if (s2.equals((Object)"Gold Coin")) {
                                final int getRandom2 = this.GetRandom(2, 10);
                                this.totalGems += getRandom2;
                                this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda24(this, getRandom2));
                            }
                            else {
                                this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda25(this, s2));
                            }
                        }
                    }
                    if (this.combatManager.equippedItems.contains((Object)"Golden Hatchet")) {
                        this.GoldenTools("Golden Hatchet");
                    }
                }
                if (this.trainingSkill.equals((Object)"Fishing") && this.combatManager.equippedItems.contains((Object)"Golden Fishing Rod")) {
                    this.GoldenTools("Golden Fishing Rod");
                }
                if (this.trainingSkill.equals((Object)"Thieving") && this.combatManager.equippedItems.contains((Object)"Golden Thieving Gloves")) {
                    this.GoldenTools("Golden Thieving Gloves");
                }
            }
            if (this.totalGameTicks % 30L == 0L && this.combatManager.equippedItems.contains((Object)"Metal Detector")) {
                this.discovery.MetalDetectorLoot();
            }
            if (this.totalGameTicks % 40L == 0L) {
                final int getWishLevel2 = this.databaseManager.GetWishLevel("Golden Rain", "Endgame");
                if (getWishLevel2 > 0 && this.GetRandom(1, 50) <= getWishLevel2) {
                    final int getRandom3 = this.GetRandom(1, 10000);
                    long n;
                    if (getRandom3 <= 1) {
                        n = 1000000L;
                    }
                    else if (getRandom3 <= 10) {
                        n = 100000L;
                    }
                    else if (getRandom3 <= 100) {
                        n = 10000L;
                    }
                    else if (getRandom3 <= 1500) {
                        n = 1000L;
                    }
                    else {
                        n = 100L;
                    }
                    this.totalGems += n;
                    this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda26(this, n));
                }
            }
            if (this.totalGameTicks % 60L == 0L && !this.myPets.contains((Object)"Tiki the Ticket") && this.GetRandom(1, 50000) <= 1) {
                this.myPets.add((Object)"Tiki the Ticket");
                this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda27(this));
            }
        }
        if (this.totalGameTicks % 300L == 0L) {
            this.Save(false);
        }
        final long totalGameTicks = this.totalGameTicks;
        if (totalGameTicks % 30L == 0L) {
            final int currentStamina = this.currentStamina;
            if (currentStamina < this.maxStamina) {
                this.currentStamina = currentStamina + 1;
            }
        }
        if (totalGameTicks % 20L == 0L && this.inCombat && this.combatManager.equippedItems.contains((Object)"Barbecue Skythe")) {
            this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda28(this, (String)this.cooking.cooking_cooked.get(this.GetRandom(this.cooking.cooking_cooked.size() - 5, this.cooking.cooking_cooked.size() - 1))));
        }
        if (this.totalGameTicks % 30L == 0L && this.inCombat && this.combatManager.equippedItems.contains((Object)"Golden Halo")) {
            this.GoldenTools("Golden Halo");
        }
        if (this.totalGameTicks % 60L == 0L && this.combatManager.equippedItems.contains((Object)"Adam the Troll")) {
            final long n2 = this.GetRandom(100, 1500);
            this.totalGems += n2;
            this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda18(this, n2));
        }
    }
    
    private void UnEquipItem(final int n, final int n2) {
        this.attackBonus -= (int)this.allItemsAttackBonus.get(n);
        this.strengthBonus -= (int)this.allItemsStrengthBonus.get(n);
        this.defenceBonus -= (int)this.allItemsDefenceBonus.get(n);
        this.healthBonus -= (int)this.allItemsHealthBonus.get(n);
        this.combatManager.equippedItems.set(n2, (Object)null);
    }
    
    private void UpdateEquipmentStats() {
        final LinearLayout linearLayout = (LinearLayout)this.equipmentScreen.findViewById(2131296596);
        final String formatExp = this.FormatExp(this.attackBonus);
        int i = 0;
        final String formatExp2 = this.FormatExp(this.strengthBonus);
        final String formatExp3 = this.FormatExp(this.defenceBonus);
        final String formatExp4 = this.FormatExp(this.healthBonus);
        while (i < 4) {
            final LinearLayout linearLayout2 = (LinearLayout)linearLayout.getChildAt(i);
            ((TextView)linearLayout2.getChildAt(1)).setText((CharSequence)(new String[] { formatExp, formatExp2, formatExp3, formatExp4 })[i]);
            if (i < 3) {
                ((TextView)linearLayout2.getChildAt(2)).setText((CharSequence)("(+" + this.FormatExp(this.baseTower.hiddenBonuses + this.dailies.dailyBonus) + ")"));
            }
            ++i;
        }
    }
    
    private void UpdateGearSelect(final String s) {
        this.LoadItemSelect("Equip a new " + s);
        final boolean equals = s.equals((Object)"Pet");
        int i = 0;
        final int n = 0;
        if (equals) {
            for (int j = n; j < this.myPets.size(); ++j) {
                try {
                    RelativeLayout relativeLayout;
                    if (this.skillingPets.contains(this.myPets.get(j))) {
                        relativeLayout = this.AddItemSelectItem((int)this.skillingPetsIcons.get(this.skillingPets.indexOf(this.myPets.get(j))), (String)this.myPets.get(j) + " the " + (String)this.skills.get(this.skillingPets.indexOf(this.myPets.get(j))) + " Pet");
                    }
                    else {
                        relativeLayout = this.AddItemSelectItem((int)this.specialPetsIcons.get(this.specialPets.indexOf(this.myPets.get(j))), (String)this.myPets.get(j));
                    }
                    this.itemSelect_wrap.addView((View)relativeLayout);
                    relativeLayout.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda131(this, s, j));
                }
                catch (final IndexOutOfBoundsException ex) {
                    this.LogIt("Pet not found");
                }
            }
        }
        else {
            while (i < this.inventoryItems.size()) {
                if (((String)this.allItemsTypes.get(this.allItems.indexOf(this.inventoryItems.get(i)))).contains((CharSequence)"Equipment") && ((String)this.allItemsTypes.get(this.allItems.indexOf(this.inventoryItems.get(i)))).split("\\s*-\\s*")[1].equals((Object)s)) {
                    RelativeLayout relativeLayout2;
                    if (s.equals((Object)"Arrows")) {
                        relativeLayout2 = this.AddItemSelectItem((int)this.allItemsIcons.get(this.allItems.indexOf(this.inventoryItems.get(i))), (String)this.inventoryItems.get(i) + " (" + this.FormatExp((long)this.inventoryAmounts.get(i)) + ")");
                    }
                    else {
                        relativeLayout2 = this.AddItemSelectItem((int)this.allItemsIcons.get(this.allItems.indexOf(this.inventoryItems.get(i))), (String)this.inventoryItems.get(i));
                    }
                    this.itemSelect_wrap.addView((View)relativeLayout2);
                    relativeLayout2.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda133(this, s, i));
                }
                ++i;
            }
        }
    }
    
    private void UpdatePets() {
        final ArrayList list = new ArrayList();
        ((List)list).addAll((Collection)this.skillingPets);
        ((List)list).addAll((Collection)this.specialPets);
        for (int i = 0; i < ((List)list).size(); ++i) {
            if (this.myPets.contains(((List)list).get(i))) {
                this.myPetsList.getChildAt(i).setAlpha(1.0f);
            }
            else {
                this.myPetsList.getChildAt(i).setAlpha(0.3f);
            }
        }
    }
    
    private void UpdateProfileInfo() {
        final String string = "Combat Level: " + this.FormatExp(this.MyCombatLevel());
        final String string2 = "Total Level: " + this.FormatExp(this.GetTotalLevel());
        final String string3 = "Total Experience: " + this.FormatExp(this.GetTotalExp());
        final String string4 = "Base Camp: " + this.FormatExp(this.baseTower.baseTowerLevel);
        if (!((TextView)this.findViewById(2131297000)).getText().toString().equals((Object)string)) {
            ((TextView)this.findViewById(2131297000)).setText((CharSequence)string);
        }
        if (!((TextView)this.findViewById(2131297002)).getText().toString().equals((Object)string2)) {
            ((TextView)this.findViewById(2131297002)).setText((CharSequence)string2);
        }
        if (!((TextView)this.findViewById(2131297001)).getText().toString().equals((Object)string3)) {
            ((TextView)this.findViewById(2131297001)).setText((CharSequence)string3);
        }
        if (!((TextView)this.findViewById(2131296999)).getText().toString().equals((Object)string4)) {
            ((TextView)this.findViewById(2131296999)).setText((CharSequence)string4);
        }
        if (this.accountType.equals((Object)"Ironman")) {
            this.ShowView(this.findViewById(2131296997));
        }
        else {
            this.HideView(this.findViewById(2131296997));
        }
    }
    
    private void UpdateTitle() {
        String text;
        if (this.activeTitle.isEmpty()) {
            text = this.currentUsername;
        }
        else if (this.activeTitle.contains((CharSequence)",")) {
            text = this.currentUsername + this.activeTitle;
        }
        else {
            text = this.currentUsername + " " + this.activeTitle;
        }
        if (!this.profilename.getText().toString().equals((Object)text)) {
            if (!this.activeTitle.isEmpty()) {
                this.profilename.setText((CharSequence)HtmlCompat.fromHtml(this.HTMLReplace(text, this.activeTitle, this.GetColour(2131034892)), 63));
            }
            else {
                this.profilename.setText((CharSequence)text);
            }
        }
    }
    
    private boolean UsernameAllowed(final String s) {
        if (!s.trim().equals((Object)"FoxesGoAhhh".trim())) {
            final boolean contains = s.toLowerCase().contains((CharSequence)"FoxesGoAhhh".toLowerCase());
            final boolean b = false;
            if (contains) {
                return b;
            }
            if (s.equalsIgnoreCase("FoxesGoAhhh")) {
                return b;
            }
            if (s.contains((CharSequence)" ")) {
                return b;
            }
            if (s.contains((CharSequence)".*\\s.*")) {
                return b;
            }
            if (s.matches("(?i).*foxes.*go.*ahhh.*")) {
                return b;
            }
        }
        return true;
    }
    
    private String getDayWithSuffix(final int n) {
        if (n >= 11 && n <= 13) {
            return n + "th";
        }
        final int n2 = n % 10;
        if (n2 == 1) {
            return n + "st";
        }
        if (n2 == 2) {
            return n + "nd";
        }
        if (n2 != 3) {
            return n + "th";
        }
        return n + "rd";
    }
    
    private TextView getPopupView() {
        return (TextView)this.getLayoutInflater().inflate(2131493041, (ViewGroup)this.quickPopups, false);
    }
    
    private void retryCreateItemsAsync(final Consumer<Boolean> consumer) {
        final ExecutorService singleThreadExecutor;
        singleThreadExecutor.execute((Runnable)new MainActivity$$ExternalSyntheticLambda72(this, new RawItems(this), consumer, singleThreadExecutor = Executors.newSingleThreadExecutor()));
    }
    
    private void showErrorDialog(final String message) {
        new AlertDialog$Builder((Context)this).setTitle((CharSequence)"Error").setMessage((CharSequence)message).setPositiveButton((CharSequence)"OK", (DialogInterface$OnClickListener)new MainActivity$$ExternalSyntheticLambda68()).setCancelable(false).show();
    }
    
    public void AddBorder(final ViewGroup viewGroup) {
        final RelativeLayout relativeLayout = new RelativeLayout((Context)this);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(-1, this.GetResource(2131099758)));
        relativeLayout.setBackgroundColor(this.GetColour(2131034148));
        viewGroup.addView((View)relativeLayout);
    }
    
    public TextView AddButton(final String text) {
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, this.GetResource(2131099880));
        layoutParams.topMargin = this.GetResource(2131100202);
        layoutParams.leftMargin = this.GetResource(2131100202);
        layoutParams.rightMargin = this.GetResource(2131100202);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        textView.setText((CharSequence)text);
        textView.setTextColor(this.GetColour(2131034924));
        this.SetTextSize(textView, this.GetResource(2131099669));
        textView.setBackground(this.GetImage(2131165336));
        textView.setGravity(17);
        return textView;
    }
    
    public RelativeLayout AddDescriptiveItemSelectItem(final int n, final String text, final String text2) {
        final RelativeLayout relativeLayout = new RelativeLayout((Context)this);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        relativeLayout.setPadding(this.GetResource(2131100236), this.GetResource(2131100236), this.GetResource(2131100236), this.GetResource(2131100236));
        relativeLayout.setBackground(this.GetImage(2131165348));
        final ImageView imageView = new ImageView((Context)this);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.GetResource(2131099791), this.GetResource(2131099791));
        layoutParams.addRule(15);
        imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setImageDrawable(this.GetImage(n));
        relativeLayout.addView((View)imageView);
        final LinearLayout linearLayout = new LinearLayout((Context)this);
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams2.setMargins(this.GetResource(2131099902), 0, 0, 0);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        linearLayout.setOrientation(1);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
        final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams3.setMargins(0, 0, 0, this.GetResource(2131099869));
        layoutParams3.addRule(15);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        textView.setTextColor(this.GetColour(2131034924));
        this.SetTextSize(textView, this.GetResource(2131099658));
        textView.setText((CharSequence)text);
        linearLayout.addView((View)textView);
        final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
        final RelativeLayout$LayoutParams layoutParams4 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams4.addRule(15);
        textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams4);
        textView2.setTextColor(this.GetColour(2131034225));
        this.SetTextSize(textView2, this.GetResource(2131100247));
        textView2.setLineSpacing(0.0f, 1.2f);
        textView2.setText((CharSequence)text2);
        linearLayout.addView((View)textView2);
        relativeLayout.addView((View)linearLayout);
        return relativeLayout;
    }
    
    public RelativeLayout AddItemSelectItem(final int n, final String text) {
        final RelativeLayout relativeLayout = new RelativeLayout((Context)this);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        relativeLayout.setPadding(this.GetResource(2131100236), this.GetResource(2131100236), this.GetResource(2131100236), this.GetResource(2131100236));
        relativeLayout.setBackground(this.GetImage(2131165348));
        final ImageView imageView = new ImageView((Context)this);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.GetResource(2131099791), this.GetResource(2131099791));
        layoutParams.addRule(15);
        imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setImageDrawable(this.GetImage(n));
        relativeLayout.addView((View)imageView);
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886424));
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams2.setMargins(this.GetResource(2131099902), 0, 0, 0);
        layoutParams2.addRule(15);
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setTextColor(this.GetColour(2131034924));
        this.SetTextSize(textView, this.GetResource(2131099658));
        textView.setText((CharSequence)text);
        relativeLayout.addView((View)textView);
        return relativeLayout;
    }
    
    public boolean All99s() {
        final Iterator iterator = this.skills.iterator();
        while (iterator.hasNext()) {
            if (this.GetSkillLevel((String)iterator.next()) < 99) {
                return false;
            }
        }
        return true;
    }
    
    public boolean AllFree99s() {
        for (final String s : this.skills) {
            if (!(boolean)this.membersSkill.get(this.skills.indexOf((Object)s)) && this.GetSkillLevel(s) < 99) {
                return false;
            }
        }
        return true;
    }
    
    public boolean AllQuestsComplete() {
        boolean b = false;
        for (int i = 0; i < this.quests.questTitle.size(); ++i) {
            if (!((String)this.quests.questTitle.get(i)).contains((CharSequence)"Santas Little Helpers")) {
                if (!this.quests.questsComplete.contains(this.quests.questTitle.get(i))) {
                    return b;
                }
            }
        }
        b = true;
        return b;
    }
    
    public int ArcheryDamage(int n, final long n2, final long n3, final long n4, int n5) {
        final float n6 = n4 + n / 2.0f - n5 / 600.0f;
        n5 = (n = (int)n2 + (int)n3 + (int)this.dailies.dailyBonus);
        if (this.databaseManager.GetWishLevel("Archery Damage", "Beginner") >= 1) {
            n = n5 + this.databaseManager.GetWishLevel("Archery Damage", "Beginner") * 2;
        }
        n += (int)this.combatManager.archeryArmourDamageBonus;
        final float n7 = (float)n;
        final float n8 = n7 / 1.2f + (n + 12) / (float)Math.max(640, n) * n7;
        n = (int)(3.2f + n8);
        n5 = (int)(n8 + 5.2f);
        n5 += n5 / 25;
        float n9 = n6;
        if (n6 < 0.05f) {
            n9 = 0.05f;
        }
        float n10 = n9;
        if (this.alchemy.activePotions.contains((Object)"Archery Potion")) {
            n10 = n9 + 1.0f;
        }
        float n11 = n10;
        if (this.alchemy.activePotions.contains((Object)"Super Archery Potion")) {
            n11 = n10 + 2.0f;
        }
        float n12 = n11;
        if (this.alchemy.activePotions.contains((Object)"Extreme Archery Potion")) {
            n12 = n11 + 3.0f;
        }
        float n13 = n12;
        if (this.alchemy.activePotions.contains((Object)"Ultimate Archery Potion")) {
            n13 = n12 + 5.0f;
        }
        if (!this.combatManager.equippedItems.contains((Object)"Bow of Kynosian (E5)") && !this.treasureHunts.BoostActive("I never miss") && !this.combatManager.equippedItems.contains((Object)"Bow of the Shadows")) {
            if (this.RandomFloat() <= n13) {
                n = this.GetRandom(n, n5);
            }
            else {
                n = 0;
            }
        }
        else {
            n = this.GetRandom(n, n5);
        }
        n5 = n;
        if (n > 0) {
            n5 = n;
            if (this.baseTower.myTreestones.contains((Object)"Treestone of Power")) {
                n5 = n + n / 2;
            }
            n = n5;
            if (this.combatManager.equippedItems.contains((Object)"Power Stone")) {
                n = n5 + n5 / 10;
            }
            n5 = n;
            if (this.combatManager.equippedItems.contains((Object)"Super Power Stone")) {
                n5 = n + n / 4;
            }
            n = n5;
            if (this.combatManager.equippedItems.contains((Object)"Extreme Power Stone")) {
                n = n5 + n5 / 2;
            }
            int n14 = n;
            if (this.combatManager.equippedItems.contains((Object)"Ring of Power")) {
                n14 = n + n / 10;
            }
            n5 = n14;
            if (this.combatManager.equippedItems.contains((Object)"Ring of Super Power")) {
                n5 = n14 + n14 / 4;
            }
            n = n5;
            if (this.combatManager.equippedItems.contains((Object)"Ring of Extreme Power")) {
                n = n5 + n5 / 2;
            }
            int n15 = n;
            if (this.combatManager.equippedItems.contains((Object)"Berserker Ring")) {
                n15 = n + n / 4;
            }
            Label_0654: {
                if (!this.combatManager.equippedItems.contains((Object)"Eternal Berserker Ring")) {
                    n5 = n15;
                    if (!this.combatManager.equippedItems.contains((Object)"Ring of Secrets")) {
                        break Label_0654;
                    }
                }
                n5 = n15 + n15 / 10 * 7;
            }
            n = n5;
            if (this.combatManager.equippedItems.contains((Object)"Death Princess Rune")) {
                if (this.GetRandom(1, 100) <= 20) {
                    n = n5 - n5 / 10 * 7;
                }
                else {
                    n = n5 * 2;
                }
            }
            n5 = n;
            if (this.combatManager.equippedItems.contains((Object)"Death Princess Rune (E)")) {
                if (this.GetRandom(1, 100) <= 15) {
                    n5 = n - n / 10 * 5;
                }
                else {
                    n5 = n * 2;
                }
            }
            n = n5;
            if (this.baseTower.baseTowerLevel >= 51) {
                n = n5 + n5 / 10;
            }
            n5 = n;
            if (this.databaseManager.GetWishLevel("Archery", "Endgame") > 0) {
                n5 = n + n / 100 * this.databaseManager.GetWishLevel("Archery", "Endgame");
            }
        }
        return n5;
    }
    
    public int CalculateDamage(int n, int n2, int n3, final String s) {
        if (s.equals((Object)"Enemy")) {
            final int hiddenBonuses = this.baseTower.hiddenBonuses;
            final int n4 = (int)this.dailies.dailyBonus;
            final int hiddenBonuses2 = this.baseTower.hiddenBonuses;
            final int n5 = (int)this.dailies.dailyBonus;
            n = n + hiddenBonuses + n4 + this.databaseManager.GetWishLevel("Attack", "Beginner") * 15;
            n2 = n2 + hiddenBonuses2 + n5 + this.databaseManager.GetWishLevel("Strength", "Beginner") * 15;
        }
        else {
            n3 = n3 + this.baseTower.hiddenBonuses + (int)this.dailies.dailyBonus + this.databaseManager.GetWishLevel("Defence", "Beginner") * 15;
        }
        final float n6 = 1.0f - n3 / 5 / (float)((n + 9) * 130) * 100.0f;
        final int n7 = n = n2 / 5 + (n2 + 17) / Math.max(640, n2) * n2;
        if (n2 >= 623) {
            n = (int)(n7 * 0.8f);
        }
        final float n8 = (float)n;
        final int n9 = (int)(3.2f + n8);
        n = (int)(n8 + 5.2f);
        n2 = n + n / 25;
        float n10 = n6;
        if (n6 < 0.1f) {
            n10 = 0.1f;
        }
        float n11 = n10;
        int n12 = n2;
        Label_0508: {
            if (s.equals((Object)"Enemy")) {
                n = n2;
                if (this.currentAttackStyle.equals((Object)"Strength")) {
                    n = n2 + n2 / 10;
                }
                float n13 = n10;
                if (this.currentAttackStyle.equals((Object)"Attack")) {
                    n13 = n10 + 0.1f;
                }
                float n14 = 0.0f;
                Label_0358: {
                    if (!this.alchemy.activePotions.contains((Object)"Attack Potion")) {
                        n14 = n13;
                        if (!this.alchemy.activePotions.contains((Object)"Power Potion")) {
                            break Label_0358;
                        }
                    }
                    n14 = n13 + 0.01f;
                }
                float n15 = 0.0f;
                Label_0406: {
                    if (!this.alchemy.activePotions.contains((Object)"Super Attack Potion")) {
                        n15 = n14;
                        if (!this.alchemy.activePotions.contains((Object)"Super Power Potion")) {
                            break Label_0406;
                        }
                    }
                    n15 = n14 + 0.02f;
                }
                float n16 = 0.0f;
                Label_0454: {
                    if (!this.alchemy.activePotions.contains((Object)"Extreme Attack Potion")) {
                        n16 = n15;
                        if (!this.alchemy.activePotions.contains((Object)"Extreme Power Potion")) {
                            break Label_0454;
                        }
                    }
                    n16 = n15 + 0.03f;
                }
                if (!this.alchemy.activePotions.contains((Object)"Ultimate Attack Potion")) {
                    n11 = n16;
                    n12 = n;
                    if (!this.alchemy.activePotions.contains((Object)"Ultimate Power Potion")) {
                        break Label_0508;
                    }
                }
                n11 = n16 + 0.05f;
                n12 = n;
            }
        }
        float n17 = n11;
        if (s.equals((Object)"Player")) {
            n17 = n11;
            if (this.currentAttackStyle.equals((Object)"Defence")) {
                n17 = n11 - 0.05f;
            }
        }
        final boolean equals = s.equals((Object)"Enemy");
        n2 = 0;
        if (equals) {
            if (!this.treasureHunts.BoostActive("I never miss") && !this.combatManager.equippedItems.contains((Object)"Staff of the Shadows") && !this.combatManager.equippedItems.contains((Object)"Scythe of Noctyra (E3)")) {
                if (this.GetRandom(0, 100) <= n17 * 100.0f) {
                    n2 = this.GetRandom(n9, n12);
                }
            }
            else {
                n2 = this.GetRandom(n9, n12);
            }
        }
        else if (this.GetRandom(0, 100) <= n17 * 100.0f) {
            n2 = this.GetRandom(n9, n12);
        }
        n = n2;
        if (s.equals((Object)"Player") && (n = n2) > 0) {
            final float n18 = (float)n3;
            n2 -= (int)(n18 / (2700.0f + n18) * n2);
            if ((n = n2) > 0) {
                n = n2;
                if (this.baseTower.baseTowerLevel >= 45) {
                    n = n2 - n2 / 5;
                }
            }
        }
        n3 = n;
        if (s.equals((Object)"Enemy") && (n3 = n) > 0) {
            n2 = n;
            if (this.combatManager.soulReaperEquipped) {
                n2 = n + n / 100 * this.combatManager.soulReaperDamageBuff;
            }
            n3 = n2;
            if (this.combatManager.dragonRiderBuff > 0) {
                n3 = n2 + n2 / 100 * this.combatManager.dragonRiderBuff;
            }
            n = n3;
            if (this.baseTower.myTreestones.contains((Object)"Treestone of Power")) {
                n = n3 + n3 / 2;
            }
            n2 = n;
            if (this.combatManager.equippedItems.contains((Object)"Power Stone")) {
                n2 = n + n / 10;
            }
            n = n2;
            if (this.combatManager.equippedItems.contains((Object)"Super Power Stone")) {
                n = n2 + n2 / 4;
            }
            n2 = n;
            if (this.combatManager.equippedItems.contains((Object)"Extreme Power Stone")) {
                n2 = n + n / 2;
            }
            n3 = n2;
            if (this.combatManager.equippedItems.contains((Object)"Ring of Power")) {
                n3 = n2 + n2 / 10;
            }
            n = n3;
            if (this.combatManager.equippedItems.contains((Object)"Ring of Super Power")) {
                n = n3 + n3 / 4;
            }
            n2 = n;
            if (this.combatManager.equippedItems.contains((Object)"Ring of Extreme Power")) {
                n2 = n + n / 2;
            }
            n = n2;
            if (this.combatManager.equippedItems.contains((Object)"Berserker Ring")) {
                n = n2 + n2 / 4;
            }
            Label_1082: {
                if (!this.combatManager.equippedItems.contains((Object)"Eternal Berserker Ring")) {
                    n2 = n;
                    if (!this.combatManager.equippedItems.contains((Object)"Ring of Secrets")) {
                        break Label_1082;
                    }
                }
                n2 = n + n / 10 * 7;
            }
            n = n2;
            if (this.combatManager.equippedItems.contains((Object)"Death Princess Rune")) {
                if (this.GetRandom(1, 100) <= 20) {
                    n = n2 - n2 / 10 * 7;
                }
                else {
                    n = n2 * 2;
                }
            }
            n2 = n;
            if (this.combatManager.equippedItems.contains((Object)"Death Princess Rune (E)")) {
                if (this.GetRandom(1, 100) <= 15) {
                    n2 = n - n / 10 * 5;
                }
                else {
                    n2 = n * 2;
                }
            }
            n3 = n2;
            if (this.databaseManager.GetWishLevel("Melee", "Endgame") > 0) {
                n3 = n2 + n2 / 100 * this.databaseManager.GetWishLevel("Melee", "Endgame");
            }
        }
        return n3;
    }
    
    public void CancelTimer() {
        if (this.skillingTimerRunning) {
            this.skillingTimerRunning = false;
            this.skillingTimer.cancel();
            this.trainingSkill = "None";
            this.trainingMethod = "";
        }
    }
    
    public void CheckAvatars() {
        final List<Integer> myProfileAvatars = this.myProfileAvatars;
        final int n = 0;
        final Integer value = 0;
        int i = n;
        if (!myProfileAvatars.contains((Object)value)) {
            this.myProfileAvatars.add((Object)value);
            i = n;
        }
        while (i < this.accountStats.getAllMonsterKills().size()) {
            if (this.avatarNames.contains(this.combatManager.enemyNames.get(i)) && (long)this.accountStats.getAllMonsterKills().get(i) >= 100000L) {
                this.GiveAvatar((String)this.combatManager.enemyNames.get(i));
            }
            ++i;
        }
    }
    
    public void CheckFreePro() {
        if (this.databaseManager.freePremiumAvailable && !this.members) {
            this.ShowView(this.findViewById(2131296732));
            this.findViewById(2131296732).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda59(this));
        }
        else {
            this.HideView(this.findViewById(2131296732));
        }
    }
    
    public void CloseItemSelect() {
        this.DisableLayout((ViewGroup)this.itemSelect);
        this.funimator.Start("SlideOutDown", 200L, new Funimator$AnimationData((View)this.itemSelect, 0, true, 1, 0));
        this.mainHandler.postDelayed((Runnable)new MainActivity$$ExternalSyntheticLambda38(this), 210L);
    }
    
    public void CloseMenu() {
        this.funimator.Start("SlideOutLeft", 200L, new Funimator$AnimationData((View)this.menu, 0, true, 1, 0));
        this.mainHandler.postDelayed((Runnable)new MainActivity$$ExternalSyntheticLambda12(this), 210L);
    }
    
    public void ContinueLoad() {
        this.DeclareUI();
        this.GenerateLists();
        this.ShowView((View)this.loggingIn);
        this.retryCreateItemsAsync((Consumer<Boolean>)new MainActivity$$ExternalSyntheticLambda42(this));
    }
    
    public void CreateAccount() {
        this.HideAllViews();
        final AtomicReference atomicReference = new AtomicReference((Object)"Standard");
        if (this.createAccountScreen == null) {
            final ScrollView createAccountScreen = (ScrollView)((ViewStub)this.findViewById(2131296496)).inflate();
            this.createAccountScreen = createAccountScreen;
            this.playNowButton = (TextView)createAccountScreen.findViewById(2131296982);
            this.newUsername = (EditText)this.createAccountScreen.findViewById(2131296914);
        }
        final LinearLayout linearLayout = (LinearLayout)this.createAccountScreen.findViewById(2131296858);
        final LinearLayout linearLayout2 = (LinearLayout)this.createAccountScreen.findViewById(2131296857);
        linearLayout.setAlpha(1.0f);
        linearLayout2.setAlpha(0.3f);
        linearLayout.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda53(atomicReference, linearLayout, linearLayout2));
        linearLayout2.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda55(atomicReference, linearLayout2, linearLayout));
        this.ShowView((View)this.createAccountScreen);
        this.EnableLayout((ViewGroup)this.createAccountScreen);
        this.playNowButton.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda56(this, (TextView)this.createAccountScreen.findViewById(2131296673), atomicReference));
    }
    
    public LinearLayout CreateNpc(final String text, final String text2) {
        final LinearLayout linearLayout = new LinearLayout((Context)this);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -2);
        layoutParams.setMargins(0, this.GetResource(2131100248), 0, 0);
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        linearLayout.setBackgroundColor(this.GetColour(2131034665));
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(this.GetResource(2131099658), this.GetResource(2131099713), this.GetResource(2131099658), this.GetResource(2131099713));
        final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886371));
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, 0, this.GetResource(2131099980));
        textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        textView.setText((CharSequence)text);
        textView.setGravity(17);
        textView.setTextColor(this.GetColour(2131034924));
        this.SetTextSize(textView, this.GetResource(2131099680));
        linearLayout.addView((View)textView);
        final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this, 2131886367));
        textView2.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
        textView2.setText((CharSequence)text2);
        textView2.setLineSpacing(0.0f, 1.2f);
        textView2.setTextColor(this.GetColour(2131034225));
        textView2.setGravity(17);
        this.SetTextSize(textView2, this.GetResource(2131099658));
        linearLayout.addView((View)textView2);
        return linearLayout;
    }
    
    public void DeclareUI() {
        this.homeScreen = (ScrollView)this.findViewById(2131296731);
        this.menu = (RelativeLayout)this.findViewById(2131296841);
        this.loggingIn = (TextView)this.findViewById(2131296793);
        this.topBar = (ConstraintLayout)this.findViewById(2131297261);
        this.generationScreen = (ScrollView)this.findViewById(2131296686);
        this.equipmentScreen = (ScrollView)this.findViewById(2131296598);
        this.loginScreen = (ConstraintLayout)this.findViewById(2131296795);
        this.combatScreen = (ScrollView)this.findViewById(2131296461);
        this.combat_enemyInfo = (LinearLayout)this.findViewById(2131296466);
        this.combat_combatStyles = (LinearLayout)this.findViewById(2131296465);
        this.lootList = (LinearLayout)this.findViewById(2131296799);
        this.combatButtons = (LinearLayout)this.findViewById(2131296460);
        this.combat_battleInfo = (LinearLayout)this.findViewById(2131296464);
        this.combat_myHealth = (RelativeLayout)this.findViewById(2131296468);
        this.eatFood = (TextView)this.findViewById(2131296582);
        this.currentArrows = (TextView)this.findViewById(2131296501);
        this.spawns = (RelativeLayout)this.findViewById(2131297162);
        this.quickPopups = (LinearLayout)this.findViewById(2131297010);
        this.itemPopup = (RelativeLayout)this.findViewById(2131296758);
        this.itemInfoWrap = (LinearLayout)this.findViewById(2131296757);
        this.createAccountButton = (TextView)this.findViewById(2131296494);
        this.combat_enemySpeed = (LinearLayout)this.findViewById(2131296467);
        this.itemSelect = (RelativeLayout)this.findViewById(2131296759);
        this.itemSelect_title = (TextView)this.findViewById(2131296760);
        this.itemSelect_wrap = (LinearLayout)this.findViewById(2131296761);
        this.closeItemSelect = (RelativeLayout)this.findViewById(2131296453);
        this.workshopScreen = (LinearLayout)this.findViewById(2131297353);
        this.apothocaryScreen = (LinearLayout)this.findViewById(2131296350);
        this.searchingEnemy = (TextView)this.findViewById(2131297083);
        this.bottomNav = (LinearLayout)this.findViewById(2131296404);
        this.quickFoodView = (LinearLayout)this.findViewById(2131297008);
        this.potionsButton = (ImageView)this.findViewById(2131296985);
        this.quickHealth = (LinearLayout)this.findViewById(2131297009);
        this.combatSkillProgress = (RelativeLayout)this.findViewById(2131296462);
        this.kitchenScreen = (LinearLayout)this.findViewById(2131296772);
        this.combatSlayerProgress = (TextView)this.findViewById(2131296463);
        this.craftingSkillProgress = (RelativeLayout)this.findViewById(2131296490);
        this.workshopList = (LinearLayout)this.findViewById(2131297352);
        this.alchemySkillProgress = (RelativeLayout)this.findViewById(2131296336);
        this.alchemyList = (LinearLayout)this.findViewById(2131296333);
        this.kitchenSkillProgress = (RelativeLayout)this.findViewById(2131296445);
        this.kitchenList = (LinearLayout)this.findViewById(2131296770);
        this.craftingMakeXButton = (TextView)this.findViewById(2131296489);
        this.kitchenMakeXButton = (TextView)this.findViewById(2131296771);
        this.eventCurrencyWrap = (LinearLayout)this.findViewById(2131296601);
        this.profileAvatar = (ImageView)this.findViewById(2131296998);
        this.profilename = (TextView)this.findViewById(2131297003);
        this.welcomeMessageTv = (TextView)this.findViewById(2131297334);
        this.welcomeNext = (TextView)this.findViewById(2131297335);
        this.changeAvatar = (TextView)this.findViewById(2131296435);
        this.cloudSaves = (TextView)this.findViewById(2131296456);
        this.workshopCategorySelect = (TextView)this.findViewById(2131297351);
        this.fishingScreen = (LinearLayout)this.findViewById(2131296636);
        this.fishingWrap = (LinearLayout)this.findViewById(2131296638);
        this.fishingSkillProgress = (RelativeLayout)this.findViewById(2131296637);
        this.inventoryScreen = (LinearLayout)this.findViewById(2131296751);
        this.inventoryWrap = (GridLayout)this.findViewById(2131296752);
        this.menuWrap = (LinearLayout)this.findViewById(2131296843);
        this.premiumBanner = (TextView)this.findViewById(2131296986);
        this.marketScreen = (LinearLayout)this.findViewById(2131296805);
        this.marketList = (LinearLayout)this.findViewById(2131296804);
        this.marketCategorySelect = (TextView)this.findViewById(2131296803);
        this.joinReddit = (TextView)this.findViewById(2131296766);
        this.discoveryScreen = (ScrollView)this.findViewById(2131296557);
        this.discoveryWrap = (LinearLayout)this.findViewById(2131296559);
        this.dungeonsScreen = (ScrollView)this.findViewById(2131296576);
        this.dungeonWrap = (LinearLayout)this.findViewById(2131296575);
        this.questsScreen = (ScrollView)this.findViewById(2131297007);
        this.kitchenSpinner = (TextView)this.findViewById(2131296773);
        this.alchemySpinner = (TextView)this.findViewById(2131296337);
        this.alchemyMakeXButton = (TextView)this.findViewById(2131296334);
        this.changeTitle = (TextView)this.findViewById(2131296436);
        this.tutorialHand = (ImageView)this.findViewById(2131297297);
        this.myEquipment = (GridLayout)this.findViewById(2131296893);
        this.coins = (TextView)this.findViewById(2131297215);
        this.killcoins = (TextView)this.findViewById(2131297217);
        this.gems = (TextView)this.findViewById(2131297216);
        this.quickHealthStat = (TextView)this.quickHealth.getChildAt(1);
        this.genWrap = (LinearLayout)((LinearLayout)this.generationScreen.getChildAt(0)).getChildAt(2);
        this.enemyImage = (ImageView)this.combat_enemyInfo.getChildAt(0);
        final LinearLayout enemyWrap = (LinearLayout)this.combat_enemyInfo.getChildAt(1);
        this.enemyWrap = enemyWrap;
        this.enemyNameTv = (TextView)enemyWrap.getChildAt(0);
        this.enemyCombatLevelTv = (TextView)this.enemyWrap.getChildAt(1);
        this.enemyHealthTv = (TextView)this.enemyWrap.getChildAt(2);
        this.enemyHealthBar = (ProgressBar)this.enemyWrap.getChildAt(3);
        this.styleAttack = (ImageView)this.combat_combatStyles.getChildAt(0);
        this.styleStrength = (ImageView)this.combat_combatStyles.getChildAt(1);
        this.styleDefence = (ImageView)this.combat_combatStyles.getChildAt(2);
        this.styleArchery = (ImageView)this.combat_combatStyles.getChildAt(3);
        this.attackSpeedBar = (ProgressBar)this.combat_battleInfo.getChildAt(1);
        this.battleUpdates = (TextView)this.combat_battleInfo.getChildAt(2);
        this.enemyAttackSpeedBar = (ProgressBar)this.combat_enemySpeed.getChildAt(1);
        this.enemyDamageUpdates = (TextView)this.combat_enemySpeed.getChildAt(2);
        this.myHealthBar = (ProgressBar)this.combat_myHealth.getChildAt(0);
        this.myHealth = (TextView)this.combat_myHealth.getChildAt(1);
        this.ev_helm = (ImageView)this.myEquipment.getChildAt(0);
        this.ev_top = (ImageView)this.myEquipment.getChildAt(1);
        this.ev_greaves = (ImageView)this.myEquipment.getChildAt(2);
        this.ev_gloves = (ImageView)this.myEquipment.getChildAt(3);
        this.ev_boots = (ImageView)this.myEquipment.getChildAt(4);
        this.ev_necklace = (ImageView)this.myEquipment.getChildAt(5);
        this.ev_cape = (ImageView)this.myEquipment.getChildAt(6);
        this.ev_weapon = (ImageView)this.myEquipment.getChildAt(7);
        this.ev_shield = (ImageView)this.myEquipment.getChildAt(8);
        this.ev_ring = (ImageView)this.myEquipment.getChildAt(9);
        this.ev_arrows = (ImageView)this.myEquipment.getChildAt(10);
        this.ev_blessing = (ImageView)this.myEquipment.getChildAt(11);
        this.ev_pet = (ImageView)this.myEquipment.getChildAt(12);
    }
    
    public void DisableLayout(final ViewGroup viewGroup) {
        viewGroup.setEnabled(false);
        for (int i = 0; i < viewGroup.getChildCount(); ++i) {
            final View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                this.DisableLayout((ViewGroup)child);
            }
            else {
                child.setEnabled(false);
            }
        }
    }
    
    public void DisableScreen() {
        this.DisableLayout((ViewGroup)this.topBar);
        this.DisableLayout((ViewGroup)this.bottomNav);
        try {
            this.DisableLayout((ViewGroup)this.currentView);
        }
        catch (final NullPointerException ex) {
            this.LogIt("Null Pointer: " + (Object)ex);
        }
    }
    
    public void EnableLayout(final ViewGroup viewGroup) {
        viewGroup.setEnabled(true);
        for (int i = 0; i < viewGroup.getChildCount(); ++i) {
            final View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                this.EnableLayout((ViewGroup)child);
            }
            else {
                child.setEnabled(true);
            }
        }
    }
    
    public void EnableScreen() {
        this.EnableLayout((ViewGroup)this.topBar);
        this.EnableLayout((ViewGroup)this.bottomNav);
        try {
            this.EnableLayout((ViewGroup)this.currentView);
        }
        catch (final NullPointerException ex) {
            this.LogIt("Null Pointer: " + (Object)ex);
        }
    }
    
    public void ExpBar(final String s, final RelativeLayout relativeLayout) {
        final ProgressBar progressBar = (ProgressBar)relativeLayout.getChildAt(3);
        final TextView textView = (TextView)relativeLayout.getChildAt(1);
        final TextView textView2 = (TextView)relativeLayout.getChildAt(2);
        ((ImageView)relativeLayout.getChildAt(0)).setImageDrawable(this.GetImage((int)this.skillsIcons.get(this.skills.indexOf((Object)s))));
        final long longValue = (long)this.skillExp.get(this.skills.indexOf((Object)s));
        final int getSkillLevel = this.GetSkillLevel(s);
        textView.setText((CharSequence)("Level " + getSkillLevel));
        if (getSkillLevel == this.GetSkillMaxLevel(s)) {
            progressBar.setMin(0);
            progressBar.setMax(100);
            progressBar.setProgress(100);
            textView2.setText((CharSequence)this.FormatExp(longValue));
        }
        else {
            progressBar.setMin(Math.toIntExact((long)this.levelExp.get(getSkillLevel - 1)));
            progressBar.setMax(Math.toIntExact((long)this.levelExp.get(getSkillLevel)));
            progressBar.setProgress((int)longValue);
            textView2.setText((CharSequence)(this.FormatExp(longValue) + " / " + this.FormatExp((long)this.levelExp.get(getSkillLevel))));
        }
    }
    
    public String FormatCoins(final long n) {
        if (n < 1000L) {
            return NumberFormat.getNumberInstance(Locale.getDefault()).format(n);
        }
        final double n2 = (double)n;
        final int n3 = (int)(Math.log(n2) / Math.log(1000.0));
        return String.format(Locale.UK, "%.2f%c", new Object[] { n2 / Math.pow(1000.0, (double)n3), "kMBTabcd".charAt(n3 - 1) });
    }
    
    public String FormatExp(final long n) {
        return NumberFormat.getNumberInstance().format(n);
    }
    
    public void GenerateLists() {
        Collections.addAll((Collection)this.allViews, (Object[])new View[] { (View)this.homeScreen, (View)this.menu, (View)this.generationScreen, (View)this.equipmentScreen, (View)this.loginScreen, (View)this.combatScreen, (View)this.itemPopup, (View)this.itemSelect, (View)this.workshopScreen, (View)this.apothocaryScreen, (View)this.kitchenScreen, (View)this.fishingScreen, (View)this.inventoryScreen, (View)this.marketScreen, (View)this.discoveryScreen, (View)this.questsScreen });
    }
    
    public int GetColour(final int n) {
        return ContextCompat.getColor((Context)this, n);
    }
    
    public int GetCombatLevel(final int n, final int n2, final int n3, final int n4) {
        return (n + n2 + n3 + n4) / 4;
    }
    
    public float GetFloat(final float n, final float n2) {
        return n + new Random().nextFloat() * (n2 - n);
    }
    
    public Drawable GetImage(final int n) {
        return ContextCompat.getDrawable((Context)this, n);
    }
    
    public int GetRandom(final int n, final int n2) {
        return this.randomGenerator.nextInt(n2 - n + 1) + n;
    }
    
    public int GetResource(final int n) {
        return this.getResources().getDimensionPixelSize(n);
    }
    
    public int GetSkillLevel(final String s) {
        final long longValue = (long)this.skillExp.get(this.skills.indexOf((Object)s));
        int i = 0;
        int n = 0;
        while (i < this.levelExp.size()) {
            if (longValue < (long)this.levelExp.get(i)) {
                return Math.min(i, this.GetSkillMaxLevel(s));
            }
            ++n;
            ++i;
        }
        i = n;
        return Math.min(i, this.GetSkillMaxLevel(s));
    }
    
    public int GetSkillMaxLevel(final String s) {
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Cooking", "Alchemy", "Farming", "Slayer", "Thieving", "Discovery" }));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Forestry", "Mining", "Fletching", "Crafting", "Firemaking", "Slayer", "Alchemy" }));
        int n;
        if (((List)list).contains((Object)s)) {
            n = 130;
        }
        else {
            n = 99;
        }
        if (((List)list2).contains((Object)s)) {
            n = 140;
        }
        return n;
    }
    
    public String GetTime(long n) {
        final long hours = TimeUnit.MILLISECONDS.toHours(n);
        final long n2 = TimeUnit.MILLISECONDS.toMinutes(n) % 60L;
        n = TimeUnit.MILLISECONDS.toSeconds(n) % 60L;
        String s;
        if (hours == 0L) {
            s = String.format(Locale.getDefault(), "%02d:%02d", new Object[] { n2, n });
        }
        else {
            s = String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[] { hours, n2, n });
        }
        return s;
    }
    
    public long GetTotalExp() {
        long n = 0L;
        for (int i = 0; i < this.skillExp.size(); ++i) {
            n += (long)this.skillExp.get(i);
        }
        return n;
    }
    
    public int GetTotalLevel() {
        int i = 0;
        int n = 0;
        while (i < this.skills.size()) {
            n += this.GetSkillLevel((String)this.skills.get(i));
            ++i;
        }
        return n;
    }
    
    public void GiveAvatar(final String s) {
        if (this.avatarNames.contains((Object)s)) {
            final int index = this.avatarNames.indexOf((Object)s);
            if (!this.myProfileAvatars.contains((Object)index)) {
                this.myProfileAvatars.add((Object)index);
                this.LargePopup((int)this.avatarIcons.get(index), "Congratulations", "You unlocked a new Profile Avatar!");
            }
        }
    }
    
    public void GiveExp(final String s, long n, final ProgressBar progressBar) {
        if (s.equals((Object)"Fishing")) {
            n *= this.fishingExpBoost;
        }
        long n2;
        n = (n2 = n * this.expMultiplier);
        if (s.equals((Object)"Slayer")) {
            int i = 0;
            int n3 = 0;
            while (i < this.combatManager.equippedItems.size()) {
                int n4 = n3;
                if (this.combatManager.equippedItems.get(i) != null) {
                    n4 = n3;
                    if (((String)this.combatManager.equippedItems.get(i)).contains((CharSequence)"Slayer Master")) {
                        n4 = n3 + 1;
                    }
                }
                ++i;
                n3 = n4;
            }
            n2 = n;
            if (n3 > 0) {
                n2 = n + n / 100L * (n3 * 10L);
            }
        }
        s.hashCode();
        final int hashCode = s.hashCode();
        int n5 = -1;
        switch (hashCode) {
            case 2093691137: {
                if (!s.equals((Object)"Firemaking")) {
                    break;
                }
                n5 = 10;
                break;
            }
            case 1971575400: {
                if (!s.equals((Object)"Attack")) {
                    break;
                }
                n5 = 9;
                break;
            }
            case 1855960161: {
                if (!s.equals((Object)"Strength")) {
                    break;
                }
                n5 = 8;
                break;
            }
            case 1281238620: {
                if (!s.equals((Object)"Thieving")) {
                    break;
                }
                n5 = 7;
                break;
            }
            case 744772833: {
                if (!s.equals((Object)"Alchemy")) {
                    break;
                }
                n5 = 6;
                break;
            }
            case 531872580: {
                if (!s.equals((Object)"Forestry")) {
                    break;
                }
                n5 = 5;
                break;
            }
            case -1085397968: {
                if (!s.equals((Object)"Defence")) {
                    break;
                }
                n5 = 4;
                break;
            }
            case -1678124166: {
                if (!s.equals((Object)"Cooking")) {
                    break;
                }
                n5 = 3;
                break;
            }
            case -1815998242: {
                if (!s.equals((Object)"Slayer")) {
                    break;
                }
                n5 = 2;
                break;
            }
            case -1990171536: {
                if (!s.equals((Object)"Mining")) {
                    break;
                }
                n5 = 1;
                break;
            }
            case -2137395588: {
                if (!s.equals((Object)"Health")) {
                    break;
                }
                n5 = 0;
                break;
            }
        }
        Label_0804: {
            Label_0736: {
                switch (n5) {
                    default: {
                        n = n2;
                        break Label_0804;
                    }
                    case 9: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 24) {
                            n = n2 / 10L;
                            break;
                        }
                        break Label_0804;
                    }
                    case 8: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 28) {
                            n = n2 / 10L;
                            break;
                        }
                        break Label_0804;
                    }
                    case 6: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 23) {
                            n = n2 / 10L;
                            break;
                        }
                        break Label_0804;
                    }
                    case 4: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 27) {
                            n = n2 / 10L;
                            break;
                        }
                        break Label_0804;
                    }
                    case 3: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 22) {
                            n = n2 / 10L;
                            break;
                        }
                        break Label_0804;
                    }
                    case 2: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 29) {
                            n = n2 / 10L;
                            break;
                        }
                        break Label_0804;
                    }
                    case 1: {
                        if (this.baseTower.baseTowerLevel >= 31) {
                            break Label_0736;
                        }
                    }
                    case 7: {
                        if (this.baseTower.baseTowerLevel >= 34) {
                            break Label_0736;
                        }
                    }
                    case 5: {
                        if (this.baseTower.baseTowerLevel >= 38) {
                            break Label_0736;
                        }
                    }
                    case 10: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 42) {
                            break Label_0736;
                        }
                        break Label_0804;
                    }
                    case 0: {
                        n = n2;
                        if (this.baseTower.baseTowerLevel >= 19) {
                            n = n2 / 10L;
                            break;
                        }
                        break Label_0804;
                    }
                }
                n += n2;
                break Label_0804;
            }
            n = n2 * 2L;
        }
        final String s2 = (String)this.skillingPets.get(this.skills.indexOf((Object)s));
        long n8;
        if (!this.myPets.contains((Object)s2)) {
            final float n6 = this.petChance / 10.0f;
            final float n7 = (float)(this.databaseManager.GetWishLevel("Pet Hunter", "Beginner") * 2);
            n8 = n;
            if (this.RandomFloat() <= this.petChance + n6 * n7) {
                this.myPets.add((Object)s2);
                this.LevelPopup((int)this.skillsIcons.get(this.skills.indexOf((Object)s)), "While skilling you found " + s2 + " the " + s + " pet.");
                n8 = n;
            }
        }
        else {
            n8 = n + n / 5L;
        }
        n = n8;
        if (this.members) {
            n = n8 + n8 / 5L;
        }
        long n9 = n;
        if (this.databaseManager.eventType.equals((Object)"Double Exp")) {
            n9 = n * 2L;
        }
        final long n10 = n9 + n9 / 100L * this.OutfitBoost();
        n = (long)(n10 / 200.0f * this.databaseManager.GetWishLevel("Global Exp", "Beginner"));
        if ((long)this.skillExp.get(this.skills.indexOf((Object)s)) < this.maxSkillExp) {
            final int getSkillLevel = this.GetSkillLevel(s);
            final int getTotalLevel = this.GetTotalLevel();
            this.skillExp.set(this.skills.indexOf((Object)s), (Object)((long)this.skillExp.get(this.skills.indexOf((Object)s)) + (n10 + n)));
            if ((long)this.skillExp.get(this.skills.indexOf((Object)s)) >= this.maxSkillExp) {
                this.skillExp.set(this.skills.indexOf((Object)s), (Object)this.maxSkillExp);
            }
            if (this.GetSkillLevel(s) > getSkillLevel) {
                this.LevelPopup((int)this.skillsIcons.get(this.skills.indexOf((Object)s)), this.getString(2131820647, new Object[] { s, this.GetSkillLevel(s) }));
                if (this.GetSkillLevel(s) == 99) {
                    this.GiveTitle("the Achiever");
                }
                ++this.piggyBankGold;
                if (s.equals((Object)"Health")) {
                    this.maxHealth = this.GetSkillLevel("Health") + this.healthBonus;
                    this.UpdateBottomNav();
                }
                if (getTotalLevel < 750 && this.GetTotalLevel() >= 750) {
                    this.databaseManager.GiveReferralPoints(this.referringFriend, 1L);
                }
                if (getTotalLevel < 1500 && this.GetTotalLevel() >= 1500) {
                    this.databaseManager.GiveReferralPoints(this.referringFriend, 2L);
                }
                if (s.equals((Object)"Crafting") && this.workshopScreen.isShown()) {
                    this.crafting.GenerateWorkshop(this.currentWorkshopCategory);
                }
            }
        }
        if (progressBar != null) {
            if (this.GetSkillLevel(s) == this.GetSkillMaxLevel(s)) {
                progressBar.setMax(100);
                progressBar.setProgress(100);
                progressBar.setMin(0);
            }
            else {
                progressBar.setMax(Math.toIntExact((long)this.levelExp.get(this.GetSkillLevel(s))));
                progressBar.setProgress(Math.toIntExact((long)this.skillExp.get(this.skills.indexOf((Object)s))));
                progressBar.setMin(Math.toIntExact((long)this.levelExp.get(this.GetSkillLevel(s) - 1)));
            }
        }
    }
    
    public void GiveItem(final String s, final long n, final boolean b) {
        s.hashCode();
        final int hashCode = s.hashCode();
        int n2 = -1;
        switch (hashCode) {
            case 1803406242: {
                if (!s.equals((Object)"Soul Gem")) {
                    break;
                }
                n2 = 14;
                break;
            }
            case 1721869536: {
                if (!s.equals((Object)"Enhancement Ticket")) {
                    break;
                }
                n2 = 13;
                break;
            }
            case 1361763894: {
                if (!s.equals((Object)"Yellow Treat Bag")) {
                    break;
                }
                n2 = 12;
                break;
            }
            case 1253687303: {
                if (!s.equals((Object)"Slayer Casket")) {
                    break;
                }
                n2 = 11;
                break;
            }
            case 658894417: {
                if (!s.equals((Object)"Gold Coin")) {
                    break;
                }
                n2 = 10;
                break;
            }
            case 464123864: {
                if (!s.equals((Object)"Special Currency")) {
                    break;
                }
                n2 = 9;
                break;
            }
            case 444298052: {
                if (!s.equals((Object)"Killcoins")) {
                    break;
                }
                n2 = 8;
                break;
            }
            case 429263516: {
                if (!s.equals((Object)"Blue Treat Bag")) {
                    break;
                }
                n2 = 7;
                break;
            }
            case 224325123: {
                if (!s.equals((Object)"Golden Ticket")) {
                    break;
                }
                n2 = 6;
                break;
            }
            case 65287138: {
                if (!s.equals((Object)"Coins")) {
                    break;
                }
                n2 = 5;
                break;
            }
            case -95351593: {
                if (!s.equals((Object)"Soul Thread")) {
                    break;
                }
                n2 = 4;
                break;
            }
            case -456161768: {
                if (!s.equals((Object)"Birthday Present")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case -819624483: {
                if (!s.equals((Object)"Casket of Treasure")) {
                    break;
                }
                n2 = 2;
                break;
            }
            case -1326946875: {
                if (!s.equals((Object)"Challenge Coins")) {
                    break;
                }
                n2 = 1;
                break;
            }
            case -1793434157: {
                if (!s.equals((Object)"Red Treat Bag")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        switch (n2) {
            default: {
                if (this.farming.farmingSeeds.contains((Object)s)) {
                    this.GiveSeed(s, n);
                    break;
                }
                this.GiveItemInventory(s, n, b);
                break;
            }
            case 14: {
                final CombatManager$SlayerInfo slayerInfo = this.combatManager.slayerInfo;
                slayerInfo.soulGems += (int)n;
                break;
            }
            case 13: {
                final ItemManager$Blessings blessings = this.itemManager.blessings;
                blessings.tickets += (int)n;
                break;
            }
            case 12: {
                final TreasureHunts.EventPresent eventPresent = this.treasureHunts.eventPresent;
                eventPresent.yellowTreatBags += (int)n;
                break;
            }
            case 11: {
                final CombatManager$SlayerInfo slayerInfo2 = this.combatManager.slayerInfo;
                slayerInfo2.slayerCaskets += (int)n;
                break;
            }
            case 10: {
                this.totalGems += n;
                this.UpdateCash();
                break;
            }
            case 9: {
                final TreasureHunts.EventPresent eventPresent2 = this.treasureHunts.eventPresent;
                eventPresent2.specialCurrency += (int)n;
                break;
            }
            case 8: {
                final CombatManager$SlayerInfo slayerInfo3 = this.combatManager.slayerInfo;
                slayerInfo3.killcoins += (int)n;
                this.UpdateCash();
                break;
            }
            case 7: {
                final TreasureHunts.EventPresent eventPresent3 = this.treasureHunts.eventPresent;
                eventPresent3.blueTreatBags += (int)n;
                break;
            }
            case 6: {
                final SecretPathway.MyPath myPath = this.secretPathway.myPath;
                myPath.goldenTickets += n;
                break;
            }
            case 5: {
                this.totalCoins += n;
                this.UpdateCash();
                break;
            }
            case 4: {
                final CombatManager$SlayerInfo slayerInfo4 = this.combatManager.slayerInfo;
                slayerInfo4.soulThread += (int)n;
                break;
            }
            case 3: {
                final TreasureHunts.EventPresent eventPresent4 = this.treasureHunts.eventPresent;
                eventPresent4.birthdayPresents += (int)n;
                break;
            }
            case 2: {
                final TreasureHunts.MyTreasureHunts myTreasureHunts = this.treasureHunts.myTreasureHunts;
                myTreasureHunts.caskets += (int)n;
                break;
            }
            case 1: {
                final Dailies dailies = this.dailies;
                dailies.challengeCoins += (int)n;
                break;
            }
            case 0: {
                final TreasureHunts.EventPresent eventPresent5 = this.treasureHunts.eventPresent;
                eventPresent5.redTreatBags += (int)n;
                break;
            }
        }
    }
    
    public void GiveItemInventory(final String s, final long n, final boolean b) {
        final String s2 = (String)this.allItemsRarity.get(this.allItems.indexOf((Object)s));
        final boolean contains = this.inventoryItems.contains((Object)s);
        final int n2 = 0;
        int n3;
        if (contains) {
            final int index = this.inventoryItems.indexOf((Object)s);
            final List<Long> inventoryAmounts = this.inventoryAmounts;
            inventoryAmounts.set(index, (Object)((long)inventoryAmounts.get(index) + n));
            n3 = n2;
            if (this.inventoryScreen.isShown()) {
                this.itemManager.UpdateItem(s);
                n3 = n2;
            }
        }
        else if (this.inventoryItems.size() < this.maxInventory) {
            this.inventoryItems.add((Object)s);
            this.inventoryAmounts.add((Object)n);
            this.inventoryItemLocked.add((Object)false);
            n3 = n2;
            if (this.inventoryScreen.isShown()) {
                this.itemManager.UpdateInventory();
                n3 = n2;
            }
        }
        else {
            n3 = 1;
        }
        if (s2.equals((Object)"Secret Rare")) {
            if (n3 != 0) {
                this.accountStats.addSecretFull((int)n);
            }
            else {
                this.accountStats.addSecret((int)n);
            }
        }
        if (b) {
            if (n3 == 0) {
                this.QuickPopup(this.getString(2131820643, new Object[] { n, s }) + " (" + this.FormatCoins((long)this.inventoryAmounts.get(this.inventoryItems.indexOf((Object)s))) + ")");
                if (this.equippedFood.equals((Object)s)) {
                    this.UpdateBottomNav();
                }
            }
            else {
                this.QuickPopup("Inventory Full");
            }
        }
    }
    
    public void GiveItemStash(final String s, final long n, final boolean b) {
        boolean b2 = false;
        Label_0182: {
            if (this.baseTower.stashItems.contains((Object)s)) {
                final int index = this.baseTower.stashItems.indexOf((Object)s);
                this.baseTower.stashAmounts.set(index, (Object)((long)this.baseTower.stashAmounts.get(index) + n));
            }
            else if (this.baseTower.baseTowerLevel >= 75) {
                this.baseTower.stashItems.add((Object)s);
                this.baseTower.stashAmounts.add((Object)n);
            }
            else {
                if (this.baseTower.stashItems.size() >= this.baseTower.maxStash) {
                    b2 = true;
                    break Label_0182;
                }
                this.baseTower.stashItems.add((Object)s);
                this.baseTower.stashAmounts.add((Object)n);
            }
            b2 = false;
        }
        if (b) {
            if (!b2) {
                this.QuickPopup(n + "x " + s + " sent to Stash");
                if (this.equippedFood.equals((Object)s)) {
                    this.UpdateBottomNav();
                }
            }
            else {
                this.QuickPopup("Stash Full");
            }
        }
    }
    
    public void GiveSeed(final String s, final long n) {
        if (this.farming.seedBag.contains((Object)s)) {
            final int index = this.farming.seedBag.indexOf((Object)s);
            this.farming.seedBagAmounts.set(index, (Object)((long)this.farming.seedBagAmounts.get(index) + n));
        }
        else {
            this.farming.seedBag.add((Object)s);
            this.farming.seedBagAmounts.add((Object)n);
        }
        this.QuickPopup(this.getString(2131820643, new Object[] { n, s }));
    }
    
    public void GiveTitle(final String s) {
        if (!this.myTitles.contains((Object)s)) {
            this.myTitles.add((Object)s);
            this.LargePopup(2131165520, "Congratulations", "You unlocked a new title: " + s);
        }
    }
    
    public void GoHome() {
        final View currentView = this.currentView;
        if (currentView != null) {
            this.HideView(currentView);
        }
        else {
            this.HideAllViews();
        }
        this.ShowView(this.currentView = (View)this.homeScreen);
        this.EnableLayout((ViewGroup)this.homeScreen);
        this.UpdateTitle();
        this.UpdateAvatar();
        this.UpdateProfileInfo();
        this.homeScreen.post((Runnable)new MainActivity$$ExternalSyntheticLambda57(this));
    }
    
    public void GoldenTools(final String s) {
        final int getRandom = this.GetRandom(1, 10000);
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
        else if (getRandom <= 1500) {
            n = 1000L;
        }
        else {
            n = 100L;
        }
        this.totalGems += n;
        this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda29(this, n, s));
    }
    
    public String HTMLReplace(final String s, final String s2, final int n) {
        return s.replace((CharSequence)s2, (CharSequence)("<font color='" + n + "'>" + s2 + "</font>"));
    }
    
    public void HandlePurchase(final Purchase purchase) {
        if (purchase.getPurchaseState() == 1) {
            int n;
            if (((String)purchase.getProducts().get(0)).equals((Object)"halloween_special")) {
                this.holidayCurrency += 2500L;
                this.UpdateBottomNav();
                n = 500;
            }
            else {
                n = 0;
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"gold_stack")) {
                this.LargePopup(2131165871, "Thank you!", "You received " + this.FormatExp(100) + " Gold Coins");
                n = 100;
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"gold_purse")) {
                this.LargePopup(2131165871, "Thank you!", "You received " + this.FormatExp(750) + " Gold Coins");
                n = 750;
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"gold_bag")) {
                n = Math.toIntExact((long)this.goldPurchaseAmounts.get(0));
                this.LargePopup(2131165871, "Thank you!", "You received " + this.FormatExp(n) + " Gold Coins");
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"gold_chest")) {
                n = Math.toIntExact((long)this.goldPurchaseAmounts.get(1));
                this.LargePopup(2131165871, "Thank you!", "You received " + this.FormatExp(n) + " Gold Coins");
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"xl_gold")) {
                n = Math.toIntExact((long)this.goldPurchaseAmounts.get(2));
                this.LargePopup(2131165871, "Thank you!", "You received " + this.FormatExp(n) + " Gold Coins");
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"massive_gold")) {
                n = Math.toIntExact((long)this.goldPurchaseAmounts.get(3));
                this.LargePopup(2131165871, "Thank you!", "You received " + this.FormatExp(n) + " Gold Coins");
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"kings_gold")) {
                n = Math.toIntExact((long)this.goldPurchaseAmounts.get(4));
                this.LargePopup(2131165871, "Thank you!", "You received " + this.FormatExp(n) + " Gold Coins");
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"cherrytree_premium")) {
                this.members = true;
                this.maxInventory += 10;
                this.HideView((View)this.proScreen);
                this.itemManager.generateInventory = true;
                this.HideView((View)this.premiumBanner);
                this.GiveTitle("the Legend");
                this.databaseManager.GiveReferralPoints(this.referringFriend, 4L);
                this.EnableScreen();
                n = 2000;
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"event_special")) {
                this.holidayCurrency += 5000L;
                this.UpdateBottomNav();
                n = 250;
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"exp_boost")) {
                this.GiveItem("Massive Exp Scroll", 1L, true);
                n = 0;
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"event_pack1")) {
                if (this.databaseManager.doubleCasketsAvailable) {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts = this.treasureHunts.myTreasureHunts;
                    myTreasureHunts.caskets += 200;
                    this.LargePopup(2131165669, "Thank you!", "You received 200 Treasure Caskets!");
                }
                else {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts2 = this.treasureHunts.myTreasureHunts;
                    myTreasureHunts2.caskets += 100;
                    this.LargePopup(2131165669, "Thank you!", "You received 100 Treasure Caskets!");
                }
                if (this.treasureHunts.treasureHuntScreen.isShown()) {
                    this.treasureHunts.UpdateScreen();
                }
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"event_pack2")) {
                if (this.databaseManager.doubleCasketsAvailable) {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts3 = this.treasureHunts.myTreasureHunts;
                    myTreasureHunts3.caskets += 700;
                    this.LargePopup(2131165669, "Thank you!", "You received 700 Treasure Caskets!");
                }
                else {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts4 = this.treasureHunts.myTreasureHunts;
                    myTreasureHunts4.caskets += 350;
                    this.LargePopup(2131165669, "Thank you!", "You received 350 Treasure Caskets!");
                }
                if (this.treasureHunts.treasureHuntScreen != null && this.treasureHunts.treasureHuntScreen.isShown()) {
                    this.treasureHunts.UpdateScreen();
                }
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"event_pack3")) {
                if (this.databaseManager.doubleCasketsAvailable) {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts5 = this.treasureHunts.myTreasureHunts;
                    myTreasureHunts5.caskets += 2000;
                    this.LargePopup(2131165669, "Thank you!", "You received 2,000 Treasure Caskets!");
                }
                else {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts6 = this.treasureHunts.myTreasureHunts;
                    myTreasureHunts6.caskets += 1000;
                    this.LargePopup(2131165669, "Thank you!", "You received 1,000 Treasure Caskets!");
                }
                if (this.treasureHunts.treasureHuntScreen.isShown()) {
                    this.treasureHunts.UpdateScreen();
                }
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"event_special2")) {
                final TreasureHunts.EventPresent eventPresent = this.treasureHunts.eventPresent;
                eventPresent.specialCurrency += 10;
                final ScrollView eventScreen = this.eventScreen;
                if (eventScreen != null && eventScreen.isShown()) {
                    this.event.UpdateSpecials();
                }
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"event_special3")) {
                final TreasureHunts.EventPresent eventPresent2 = this.treasureHunts.eventPresent;
                eventPresent2.specialCurrency += 60;
                final ScrollView eventScreen2 = this.eventScreen;
                if (eventScreen2 != null && eventScreen2.isShown()) {
                    this.event.UpdateSpecials();
                }
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"double_dailies")) {
                this.dailies.doubleDays = 7;
                this.dailies.OpenChallenges();
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"friendship_gifts1")) {
                final DatabaseManager$Currencies currencies = this.databaseManager.currencies;
                ++currencies.friendGifts;
                this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("friendGifts", (Object)this.databaseManager.currencies.getFriendGifts(), new Object[0]);
                if (this.friends.friendShop != null && this.friends.friendShop.isShown()) {
                    this.friends.UpdateShopCoins();
                }
            }
            if (((String)purchase.getProducts().get(0)).equals((Object)"friendship_gifts2")) {
                final DatabaseManager$Currencies currencies2 = this.databaseManager.currencies;
                currencies2.friendGifts += 10L;
                this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("friendGifts", (Object)this.databaseManager.currencies.getFriendGifts(), new Object[0]);
                if (this.friends.friendShop != null && this.friends.friendShop.isShown()) {
                    this.friends.UpdateShopCoins();
                }
            }
            this.totalGems += n;
            this.UpdateCash();
            this.Save(true);
            this.databaseManager.StorePurchase(purchase);
            this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), (ConsumeResponseListener)new MainActivity$$ExternalSyntheticLambda151(this));
        }
    }
    
    public void HeavyTasks(final boolean b) {
        this.forestry = new Forestry(this);
        this.alchemy.Setup();
        this.cooking.Setup();
        this.crafting.Setup();
        this.fletching.Setup();
        this.farming.Setup();
        this.discovery.GenerateMazes();
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute((Runnable)new MainActivity$$ExternalSyntheticLambda129(this));
        singleThreadExecutor.shutdown();
        if (this.members) {
            this.HideView((View)this.premiumBanner);
        }
        if (this.farming.seedBag.contains((Object)"Sandalwood Seed")) {
            final int index = this.farming.seedBag.indexOf((Object)"Sandalwood Seed");
            this.farming.seedBag.remove(index);
            this.farming.seedBagAmounts.remove(index);
        }
        this.farming.SortSeedBag();
        for (int i = 0; i < this.skillExp.size(); ++i) {
            if ((long)this.skillExp.get(i) < 0L) {
                this.skillExp.set(i, (Object)this.levelExp.get(98));
            }
        }
        this.GoHome();
        this.UpdateMaxHealth();
        this.UpdateEventCurrency();
        if (b) {
            this.maxHealth = 20;
            this.currentHealth = 20;
            this.UpdateBottomNav();
            this.ShowTutorial();
        }
        this.CheckTitles();
        this.CheckAvatars();
        this.homeScreen.post((Runnable)new MainActivity$$ExternalSyntheticLambda130(this, b));
    }
    
    public void HideAllViews() {
        for (final View view : this.allViews) {
            if (view.getVisibility() == 0) {
                this.HideView(view);
            }
        }
    }
    
    public void HideKeyboard(final View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager)this.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    
    public void HideView(final View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }
    
    public void IdleTime() {
        if (this.logoutTime > 0L) {
            final long currentTimeMillis = System.currentTimeMillis();
            final long logoutTime = this.logoutTime;
            if (currentTimeMillis > logoutTime) {
                final long n = currentTimeMillis - logoutTime;
                long n2;
                if ((n2 = n / 1000L) > 14400L) {
                    n2 = 14400L;
                }
                if (n2 >= 120L) {
                    final long n3 = n2 / 120L;
                    final int currentStamina = this.currentStamina;
                    final int maxStamina = this.maxStamina;
                    if (currentStamina < maxStamina && (this.currentStamina = currentStamina + (int)n3) > maxStamina) {
                        this.currentStamina = maxStamina;
                    }
                }
                for (int i = 0; i < this.farming.farmCropTimeRemaining.size(); ++i) {
                    if (this.farming.farmCropTimeRemaining.get(i) != null && (long)this.farming.farmCropTimeRemaining.get(i) > 0L) {
                        final long longValue = (long)this.farming.farmCropTimeRemaining.get(i);
                        long n4 = 30000L;
                        if (longValue >= 30000L) {
                            final long n5 = (long)this.farming.farmCropTimeRemaining.get(i) - n;
                            if (n5 >= 30000L) {
                                n4 = n5;
                            }
                            this.farming.farmCropTimeRemaining.set(i, (Object)n4);
                        }
                    }
                }
            }
        }
    }
    
    public void InitializeBilling() {
        (this.billingClient = BillingClient.newBuilder((Context)this).setListener((PurchasesUpdatedListener)this).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build()).startConnection((BillingClientStateListener)new BillingClientStateListener(this) {
            final MainActivity this$0;
            
            public void onBillingServiceDisconnected() {
                this.this$0.billingInitialized = false;
            }
            
            public void onBillingSetupFinished(final BillingResult billingResult) {
                if (billingResult.getResponseCode() == 0) {
                    this.this$0.billingClient.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList((List)ImmutableList.of((Object)QueryProductDetailsParams$Product.newBuilder().setProductId("gold_stack").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("gold_purse").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("gold_bag").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("gold_chest").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("halloween_special").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("cherrytree_premium").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("event_special").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("event_special2").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("event_special3").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("xl_gold").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("massive_gold").setProductType("inapp").build(), (Object)QueryProductDetailsParams$Product.newBuilder().setProductId("pro_pack").setProductType("inapp").build(), (Object[])new QueryProductDetailsParams$Product[] { QueryProductDetailsParams$Product.newBuilder().setProductId("exp_boost").setProductType("inapp").build(), QueryProductDetailsParams$Product.newBuilder().setProductId("kings_gold").setProductType("inapp").build(), QueryProductDetailsParams$Product.newBuilder().setProductId("event_pack1").setProductType("inapp").build(), QueryProductDetailsParams$Product.newBuilder().setProductId("event_pack2").setProductType("inapp").build(), QueryProductDetailsParams$Product.newBuilder().setProductId("event_pack3").setProductType("inapp").build(), QueryProductDetailsParams$Product.newBuilder().setProductId("double_dailies").setProductType("inapp").build(), QueryProductDetailsParams$Product.newBuilder().setProductId("friendship_gifts1").setProductType("inapp").build(), QueryProductDetailsParams$Product.newBuilder().setProductId("friendship_gifts2").setProductType("inapp").build() })).build(), (ProductDetailsResponseListener)new MainActivity$7$$ExternalSyntheticLambda0(this));
                    this.this$0.CheckConsumes();
                }
            }
        });
    }
    
    public boolean InventoryNotFull(final String s) {
        final boolean contains = this.inventoryItems.contains((Object)s);
        boolean b = false;
        if (!contains) {
            if (this.inventoryItems.size() >= this.maxInventory) {
                b = true;
            }
        }
        return b ^ true;
    }
    
    public void ItemChecks() {
        final int n = 0;
        int n2 = 0;
        int i;
        while (true) {
            i = n;
            if (n2 >= this.inventoryItems.size()) {
                break;
            }
            if (((String)this.inventoryItems.get(n2)).equals((Object)"Stamina Potion")) {
                this.inventoryItems.set(n2, (Object)"Energy Potion");
            }
            if (((String)this.inventoryItems.get(n2)).equals((Object)"Super Stamina Potion")) {
                this.inventoryItems.set(n2, (Object)"Super Energy Potion");
            }
            if (((String)this.inventoryItems.get(n2)).equals((Object)"Extreme Stamina Potion")) {
                this.inventoryItems.set(n2, (Object)"Extreme Energy Potion");
            }
            if (((String)this.inventoryItems.get(n2)).equals((Object)"Navigation Cape")) {
                this.inventoryItems.set(n2, (Object)"Discovery Cape");
            }
            ++n2;
        }
        while (i < this.baseTower.stashItems.size()) {
            if (((String)this.baseTower.stashItems.get(i)).equals((Object)"Stamina Potion")) {
                this.baseTower.stashItems.set(i, (Object)"Energy Potion");
            }
            if (((String)this.baseTower.stashItems.get(i)).equals((Object)"Super Stamina Potion")) {
                this.baseTower.stashItems.set(i, (Object)"Super Energy Potion");
            }
            if (((String)this.baseTower.stashItems.get(i)).equals((Object)"Extreme Stamina Potion")) {
                this.baseTower.stashItems.set(i, (Object)"Extreme Energy Potion");
            }
            if (((String)this.baseTower.stashItems.get(i)).equals((Object)"Navigation Cape")) {
                this.baseTower.stashItems.set(i, (Object)"Discovery Cape");
            }
            ++i;
        }
        if (this.combatManager.equippedItems.contains((Object)"Navigation Cape")) {
            this.combatManager.equippedItems.set(this.combatManager.equippedItems.indexOf((Object)"Navigation Cape"), (Object)"Discovery Cape");
        }
        Log.e("Skipped", "Item checks complete");
    }
    
    public void LargePopup(final int n, final String text, final String text2) {
        final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this, 2131492967, (ViewGroup)null);
        this.spawns.addView((View)relativeLayout);
        final RelativeLayout$LayoutParams layoutParams = (RelativeLayout$LayoutParams)relativeLayout.getLayoutParams();
        layoutParams.leftMargin = this.GetResource(2131099658);
        layoutParams.rightMargin = this.GetResource(2131099658);
        layoutParams.topMargin = this.GetResource(2131099991);
        relativeLayout.setAlpha(0.0f);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.ShowView(relativeLayout.getChildAt(0));
        ((ImageView)relativeLayout.getChildAt(0)).setImageDrawable(this.GetImage(n));
        ((TextView)((LinearLayout)relativeLayout.getChildAt(1)).getChildAt(0)).setText((CharSequence)text);
        ((TextView)((LinearLayout)relativeLayout.getChildAt(1)).getChildAt(1)).setText((CharSequence)text2);
        relativeLayout.post((Runnable)new MainActivity$$ExternalSyntheticLambda147(this, relativeLayout));
    }
    
    public void LevelPopup(final int n, final String text) {
        final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this, 2131492967, (ViewGroup)null);
        this.spawns.addView((View)relativeLayout);
        final RelativeLayout$LayoutParams layoutParams = (RelativeLayout$LayoutParams)relativeLayout.getLayoutParams();
        layoutParams.leftMargin = this.GetResource(2131099658);
        layoutParams.rightMargin = this.GetResource(2131099658);
        layoutParams.topMargin = this.GetResource(2131099991);
        relativeLayout.setAlpha(0.0f);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        if (n == 0) {
            this.HideView(relativeLayout.getChildAt(0));
        }
        else {
            this.ShowView(relativeLayout.getChildAt(0));
            ((ImageView)relativeLayout.getChildAt(0)).setImageDrawable(this.GetImage(n));
        }
        ((TextView)((LinearLayout)relativeLayout.getChildAt(1)).getChildAt(0)).setText((CharSequence)"Well Done");
        ((TextView)((LinearLayout)relativeLayout.getChildAt(1)).getChildAt(1)).setText((CharSequence)text);
        relativeLayout.post((Runnable)new MainActivity$$ExternalSyntheticLambda60(this, relativeLayout));
    }
    
    public void Listeners() {
        this.topBar.getChildAt(0).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda95(this));
        this.menu.getChildAt(1).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda107(this));
        this.styleAttack.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda118(this));
        this.styleStrength.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda119(this));
        this.styleDefence.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda120(this));
        this.styleArchery.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda122(this));
        this.itemPopup.getChildAt(1).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda123(this));
        this.closeItemSelect.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda124(this));
        this.quickFoodView.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda125(this));
        this.potionsButton.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda126(this));
        this.changeAvatar.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda96(this));
        this.workshopCategorySelect.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda97(this));
        this.kitchenSpinner.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda98(this));
        this.alchemySpinner.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda100(this));
        this.premiumBanner.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda101(this));
        this.joinReddit.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda102(this));
        this.eventCurrencyWrap.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda103(this));
        this.changeTitle.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda104(this));
        this.findViewById(2131296779).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda105(this));
        this.findViewById(2131297320).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda106(this));
        this.findViewById(2131296931).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda108(this));
        this.findViewById(2131296941).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda109(this));
        this.findViewById(2131296928).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda111(this));
        this.findViewById(2131296942).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda112(this));
        this.findViewById(2131296940).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda113(this));
        this.findViewById(2131296939).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda114(this));
        this.findViewById(2131296933).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda115(this));
        this.findViewById(2131296936).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda116(this));
        this.findViewById(2131296929).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda117(this));
    }
    
    public void Load() {
        final SharedPreferences sharedPreferences = this.getSharedPreferences("main", 0);
        this.sp = sharedPreferences;
        final String string = sharedPreferences.getString("skillExpStr", "");
        final String string2 = this.sp.getString("inventoryItemsStr", "");
        final String string3 = this.sp.getString("inventoryAmountsStr", "");
        final String string4 = this.sp.getString("inventoryItemLockedStr", "");
        final String string5 = this.sp.getString("seedBagStr", "");
        final String string6 = this.sp.getString("seedBagAmountsStr", "");
        final String string7 = this.sp.getString("farmCropStr", "");
        final String string8 = this.sp.getString("farmCropTimeRemainingStr", "");
        final String string9 = this.sp.getString("equippedItemsStr", "");
        final String string10 = this.sp.getString("premiumUpgradePurchasedStr", "");
        final String string11 = this.sp.getString("questsCompleteStr", "");
        final String string12 = this.sp.getString("myTreestonesStr", "");
        final String string13 = this.sp.getString("stashItemsStr", "");
        final String string14 = this.sp.getString("stashAmountsStr", "");
        final String string15 = this.sp.getString("myPetsStr", "");
        final String string16 = this.sp.getString("offerCodesRedeemedStr", "");
        final String string17 = this.sp.getString("myTitlesStr", "");
        final String string18 = this.sp.getString("idleDropsStr", "");
        final String string19 = this.sp.getString("myProfileAvatarsStr", "");
        this.currentAttackStyle = this.sp.getString("currentAttackStyle", this.currentAttackStyle);
        this.equippedFood = this.sp.getString("equippedFood", this.equippedFood);
        final CombatManager combatManager = this.combatManager;
        combatManager.slayerTask = this.sp.getString("slayerTask", combatManager.slayerTask);
        final CombatManager combatManager2 = this.combatManager;
        combatManager2.currentSlayerMaster = this.sp.getString("currentSlayerMaster", combatManager2.currentSlayerMaster);
        final BaseTower baseTower = this.baseTower;
        baseTower.baseTowerName = this.sp.getString("baseTowerName", baseTower.baseTowerName);
        this.currentUsername = this.sp.getString("currentUsername", this.currentUsername);
        this.activeTitle = this.sp.getString("activeTitle", this.activeTitle);
        this.idleSkill = this.sp.getString("idleSkill", this.idleSkill);
        this.idleMethod = this.sp.getString("idleMethod", this.idleMethod);
        this.accountType = this.sp.getString("accountType", this.accountType);
        this.referringFriend = this.sp.getString("referringFriend", this.referringFriend);
        this.totalCoins = this.sp.getLong("totalCoins", this.totalCoins);
        this.totalGems = this.sp.getLong("totalGems", this.totalGems);
        this.totalKillCoins = this.sp.getLong("totalKillCoins", this.totalKillCoins);
        this.logoutTime = this.sp.getLong("logoutTime", this.logoutTime);
        this.currentEventCurrency = this.sp.getLong("currentEventCurrency", this.currentEventCurrency);
        this.holidayCurrency = this.sp.getLong("holidayCurrency", this.holidayCurrency);
        this.totalChickenKills = this.sp.getLong("totalChickenKills", this.totalChickenKills);
        this.totalTribalKills = this.sp.getLong("totalTribalKills", this.totalTribalKills);
        this.idleSkillTime = this.sp.getLong("idleSkillTime", this.idleSkillTime);
        this.lastCloudRestore = this.sp.getLong("lastCloudRestore", this.lastCloudRestore);
        final Dailies dailies = this.dailies;
        dailies.dailyBonus = this.sp.getLong("dailyBonus", dailies.dailyBonus);
        final TreasureHunts treasureHunts = this.treasureHunts;
        treasureHunts.lastGodItem = this.sp.getLong("lastGodItem", treasureHunts.lastGodItem);
        final Thieving thieving = this.thieving;
        thieving.dailySafesCracked = this.sp.getLong("dailySafesCracked", thieving.dailySafesCracked);
        this.maxInventory = this.sp.getInt("maxInventory", this.maxInventory);
        this.currentHealth = this.sp.getInt("currentHealth", this.currentHealth);
        this.maxStamina = this.sp.getInt("maxStamina", this.maxStamina);
        this.currentStamina = this.sp.getInt("currentStamina", this.currentStamina);
        final CombatManager combatManager3 = this.combatManager;
        combatManager3.slayerAmount = this.sp.getInt("slayerAmount", combatManager3.slayerAmount);
        this.fishingRodLevel = this.sp.getInt("fishingRodLevel", this.fishingRodLevel);
        final Farming farming = this.farming;
        farming.planters = this.sp.getInt("planters", farming.planters);
        this.exploreItems = this.sp.getInt("exploreItems", this.exploreItems);
        this.staminaSaveChance = this.sp.getInt("staminaSaveChance", this.staminaSaveChance);
        this.expMultiplier = this.sp.getInt("expMultiplier", this.expMultiplier);
        this.marketDiscount = this.sp.getInt("marketDiscount", this.marketDiscount);
        this.doubleFish = this.sp.getInt("doubleFish", this.doubleFish);
        this.doublePotions = this.sp.getInt("doublePotions", this.doublePotions);
        this.resourceSave = this.sp.getInt("resourceSave", this.resourceSave);
        this.farmingTimer = this.sp.getInt("farmingTimer", this.farmingTimer);
        this.maxIdleIncrease = this.sp.getInt("maxIdleIncrease", this.maxIdleIncrease);
        final BaseTower baseTower2 = this.baseTower;
        baseTower2.baseTowerLevel = this.sp.getInt("baseTowerLevel", baseTower2.baseTowerLevel);
        final BaseTower baseTower3 = this.baseTower;
        baseTower3.hiddenBonuses = this.sp.getInt("hiddenBonuses", baseTower3.hiddenBonuses);
        final BaseTower baseTower4 = this.baseTower;
        baseTower4.maxStash = this.sp.getInt("maxStash", baseTower4.maxStash);
        final Discovery discovery = this.discovery;
        discovery.discoveryFailChance = this.sp.getInt("discoveryFailChance", discovery.discoveryFailChance);
        final Dailies dailies2 = this.dailies;
        dailies2.skipTickets = this.sp.getInt("skipTickets", dailies2.skipTickets);
        final Dailies dailies3 = this.dailies;
        dailies3.challengeCoins = this.sp.getInt("challengeCoins", dailies3.challengeCoins);
        final Dailies dailies4 = this.dailies;
        dailies4.lastLoginDay = this.sp.getInt("lastLoginDay", dailies4.lastLoginDay);
        final Dailies dailies5 = this.dailies;
        dailies5.doubleDays = this.sp.getInt("doubleDays", dailies5.doubleDays);
        final DatabaseManager databaseManager = this.databaseManager;
        databaseManager.vaultChances = this.sp.getInt("vaultChances", databaseManager.vaultChances);
        this.activeCharacter = this.sp.getInt("activeCharacter", this.activeCharacter);
        this.activeAvatar = this.sp.getInt("activeAvatar", this.activeAvatar);
        final Alchemy alchemy = this.alchemy;
        alchemy.cocktailsDrank = this.sp.getInt("cocktailsDrank", alchemy.cocktailsDrank);
        this.autoEat = this.sp.getBoolean("autoEat", this.autoEat);
        this.saveAvailable = this.sp.getBoolean("saveAvailable", this.saveAvailable);
        this.members = this.sp.getBoolean("members", this.members);
        this.claimedGift = this.sp.getBoolean("claimedGift", this.claimedGift);
        final boolean empty = string.isEmpty();
        final Long value = 0L;
        if (empty) {
            for (int i = 0; i < this.skills.size(); ++i) {
                if (i == 3) {
                    this.skillExp.add((Object)5118L);
                }
                else {
                    this.skillExp.add((Object)value);
                }
            }
        }
        else {
            final String[] split = string.split("\\s*/\\s*");
            for (int length = split.length, j = 0; j < length; ++j) {
                this.skillExp.add((Object)Long.valueOf(split[j]));
            }
        }
        if (string2.isEmpty()) {
            this.inventoryItems = (List<String>)new ArrayList();
        }
        else {
            this.inventoryItems.addAll((Collection)Arrays.asList((Object[])string2.split("\\s*/\\s*")));
        }
        if (string3.isEmpty()) {
            this.inventoryAmounts = (List<Long>)new ArrayList();
        }
        else {
            final String[] split2 = string3.split("\\s*/\\s*");
            for (int length2 = split2.length, k = 0; k < length2; ++k) {
                this.inventoryAmounts.add((Object)Long.valueOf(split2[k]));
            }
        }
        if (string4.isEmpty()) {
            this.inventoryItemLocked = (List<Boolean>)new ArrayList();
        }
        else {
            final String[] split3 = string4.split("\\s*/\\s*");
            for (int length3 = split3.length, l = 0; l < length3; ++l) {
                this.inventoryItemLocked.add((Object)Boolean.valueOf(split3[l]));
            }
        }
        if (string10.isEmpty()) {
            this.premiumUpgradesPurchased = (List<Boolean>)new ArrayList();
        }
        else {
            final String[] split4 = string10.split("\\s*/\\s*");
            for (int length4 = split4.length, n = 0; n < length4; ++n) {
                this.premiumUpgradesPurchased.add((Object)Boolean.valueOf(split4[n]));
            }
        }
        if (string5.isEmpty()) {
            this.farming.seedBag = (List)new ArrayList();
        }
        else {
            this.farming.seedBag.addAll((Collection)Arrays.asList((Object[])string5.split("\\s*/\\s*")));
        }
        if (string6.isEmpty()) {
            this.farming.seedBagAmounts = (List)new ArrayList();
        }
        else {
            final String[] split5 = string6.split("\\s*/\\s*");
            for (int length5 = split5.length, n2 = 0; n2 < length5; ++n2) {
                this.farming.seedBagAmounts.add((Object)Long.valueOf(split5[n2]));
            }
        }
        if (string7.isEmpty()) {
            this.farming.farmCrop = (List)new ArrayList();
            for (int n3 = 0; n3 < this.farming.planters; ++n3) {
                this.farming.farmCrop.add((Object)null);
            }
        }
        else {
            for (final String s : string7.split("\\s*/\\s*")) {
                if (s.equals((Object)"null")) {
                    this.farming.farmCrop.add((Object)null);
                }
                else {
                    this.farming.farmCrop.add((Object)s);
                }
            }
        }
        if (string8.isEmpty()) {
            this.farming.farmCropTimeRemaining = (List)new ArrayList();
            for (int n5 = 0; n5 < this.farming.planters; ++n5) {
                this.farming.farmCropTimeRemaining.add((Object)null);
            }
        }
        else {
            for (final String s2 : string8.split("\\s*/\\s*")) {
                if (s2.equals((Object)"null")) {
                    this.farming.farmCropTimeRemaining.add((Object)null);
                }
                else {
                    this.farming.farmCropTimeRemaining.add((Object)Long.valueOf(s2));
                }
            }
        }
        if (string11.isEmpty()) {
            this.quests.questsComplete = (List<String>)new ArrayList();
        }
        else {
            this.quests.questsComplete.addAll((Collection)Arrays.asList((Object[])string11.split("\\s*/\\s*")));
        }
        if (string13.isEmpty()) {
            this.baseTower.stashItems = (List)new ArrayList();
        }
        else {
            this.baseTower.stashItems.addAll((Collection)Arrays.asList((Object[])string13.split("\\s*/\\s*")));
        }
        if (string14.isEmpty()) {
            this.baseTower.stashAmounts = (List)new ArrayList();
        }
        else {
            final String[] split8 = string14.split("\\s*/\\s*");
            for (int length8 = split8.length, n7 = 0; n7 < length8; ++n7) {
                this.baseTower.stashAmounts.add((Object)Long.valueOf(split8[n7]));
            }
        }
        for (int n8 = 0; n8 < this.farming.planters; ++n8) {
            this.farming.farmCropTimer.add((Object)null);
            this.farming.farmCropProgress.add((Object)null);
        }
        if (string9.isEmpty()) {
            this.combatManager.equippedItems = (List)new ArrayList();
        }
        else {
            for (final String s3 : string9.split("\\s*/\\s*")) {
                if (s3.equals((Object)"null")) {
                    this.combatManager.equippedItems.add((Object)null);
                }
                else {
                    this.combatManager.equippedItems.add((Object)s3);
                }
            }
        }
        if (string15.isEmpty()) {
            this.myPets = (List<String>)new ArrayList();
        }
        else {
            Collections.addAll((Collection)this.myPets, (Object[])string15.split("\\s*/\\s*"));
        }
        if (string16.isEmpty()) {
            this.offerCodesRedeemed = (List<String>)new ArrayList();
        }
        else {
            Collections.addAll((Collection)this.offerCodesRedeemed, (Object[])string16.split("\\s*/\\s*"));
        }
        if (string17.isEmpty()) {
            this.myTitles = (List<String>)new ArrayList();
        }
        else {
            Collections.addAll((Collection)this.myTitles, (Object[])string17.split("\\s*/\\s*"));
        }
        if (string18.isEmpty()) {
            this.idleDrops = (List<String>)new ArrayList();
        }
        else {
            Collections.addAll((Collection)this.idleDrops, (Object[])string18.split("\\s*/\\s*"));
        }
        if (string19.isEmpty()) {
            this.myProfileAvatars = (List<Integer>)new ArrayList();
        }
        else {
            final String[] split10 = string19.split("\\s*/\\s*");
            for (int length10 = split10.length, n10 = 0; n10 < length10; ++n10) {
                this.myProfileAvatars.add((Object)Integer.valueOf(split10[n10]));
            }
        }
        final String string20 = this.sp.getString("accountStats", "");
        if (!string20.isEmpty()) {
            final Statistic accountStats = new Statistic(null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);
            this.accountStats = accountStats;
            this.accountStats = (Statistic)MainActivity.gson.fromJson(string20, (Class)accountStats.getClass());
        }
        else {
            this.accountStats = null;
        }
        final String string21 = this.sp.getString("dailyChallenges", "");
        if (!string21.isEmpty()) {
            this.dailies.dailyChallenges = (List)MainActivity.gson.fromJson(string21, new TypeToken<List<Dailies$DailyChallenge>>(this) {
                final MainActivity this$0;
            }.getType());
        }
        else {
            this.dailies.dailyChallenges = (List)new ArrayList();
        }
        final String string22 = this.sp.getString("vaultCodesClaimed", "");
        if (!string22.isEmpty()) {
            this.databaseManager.vaultCodesClaimed = (List)MainActivity.gson.fromJson(string22, new TypeToken<List<String>>(this) {
                final MainActivity this$0;
            }.getType());
        }
        else {
            this.databaseManager.vaultCodesClaimed = (List)new ArrayList();
        }
        final String string23 = this.sp.getString("myWishes", "");
        if (!string23.isEmpty()) {
            this.databaseManager.myWishes = (List)MainActivity.gson.fromJson(string23, new TypeToken<List<DatabaseManager$Wish>>(this) {
                final MainActivity this$0;
            }.getType());
        }
        else {
            this.databaseManager.myWishes = (List)new ArrayList();
        }
        final String string24 = this.sp.getString("myBigWishes", "");
        if (!string24.isEmpty()) {
            this.databaseManager.myBigWishes = (List)MainActivity.gson.fromJson(string24, new TypeToken<List<DatabaseManager$Wish>>(this) {
                final MainActivity this$0;
            }.getType());
        }
        else {
            this.databaseManager.myBigWishes = (List)new ArrayList();
        }
        final String string25 = this.sp.getString("myTreasureHunts", "");
        if (!string25.isEmpty()) {
            this.treasureHunts.New();
            final TreasureHunts treasureHunts2 = this.treasureHunts;
            treasureHunts2.myTreasureHunts = (TreasureHunts.MyTreasureHunts)MainActivity.gson.fromJson(string25, (Class)treasureHunts2.myTreasureHunts.getClass());
        }
        else {
            this.treasureHunts.New();
        }
        final String string26 = this.sp.getString("myEventPresents", "");
        if (!string26.isEmpty()) {
            this.treasureHunts.NewPresent();
            final TreasureHunts treasureHunts3 = this.treasureHunts;
            treasureHunts3.eventPresent = (TreasureHunts.EventPresent)MainActivity.gson.fromJson(string26, (Class)treasureHunts3.eventPresent.getClass());
        }
        else {
            this.treasureHunts.NewPresent();
        }
        final String string27 = this.sp.getString("slayerInfo", "");
        if (!string27.isEmpty()) {
            this.combatManager.slayerInfo = new CombatManager$SlayerInfo(0L, 0L, "", "", 0, 0L, 0, 0L, 0L);
            final CombatManager combatManager4 = this.combatManager;
            combatManager4.slayerInfo = (CombatManager$SlayerInfo)MainActivity.gson.fromJson(string27, (Class)combatManager4.slayerInfo.getClass());
        }
        else {
            this.combatManager.slayerInfo = new CombatManager$SlayerInfo(this.totalKillCoins, 0L, this.combatManager.slayerTask, this.combatManager.currentSlayerMaster, this.combatManager.slayerAmount, 0L, 0, 0L, 0L);
        }
        final String string28 = this.sp.getString("mySkillingScrolls", "");
        if (!string28.isEmpty()) {
            this.itemManager.CreateSkillingScrolls();
            final ItemManager itemManager = this.itemManager;
            itemManager.skillingScrolls = (ItemManager$SkillingScrolls)MainActivity.gson.fromJson(string28, (Class)itemManager.skillingScrolls.getClass());
        }
        else {
            this.itemManager.CreateSkillingScrolls();
        }
        final String string29 = this.sp.getString("myBlessings", "");
        if (!string29.isEmpty()) {
            this.itemManager.blessings = new ItemManager$Blessings(0L, 0L);
            final ItemManager itemManager2 = this.itemManager;
            itemManager2.blessings = (ItemManager$Blessings)MainActivity.gson.fromJson(string29, (Class)itemManager2.blessings.getClass());
        }
        else {
            this.itemManager.blessings = new ItemManager$Blessings(0L, 0L);
        }
        final String string30 = this.sp.getString("mysecpath", "");
        if (!string30.isEmpty()) {
            this.secretPathway.myPath = new SecretPathway.MyPath();
            final SecretPathway secretPathway = this.secretPathway;
            secretPathway.myPath = (SecretPathway.MyPath)MainActivity.gson.fromJson(string30, (Class)secretPathway.myPath.getClass());
        }
        else {
            this.secretPathway.myPath = new SecretPathway.MyPath();
        }
        final String string31 = this.sp.getString("equipmentPresets", (String)null);
        if (string31 != null) {
            final List list = (List)MainActivity.gson.fromJson(string31, new TypeToken<List<List<String>>>(this) {
                final MainActivity this$0;
            }.getType());
            if (list.size() > 2) {
                this.combatManager.equipmentPresets = (List)new ArrayList((Collection)list.subList(0, 2));
            }
            else {
                this.combatManager.equipmentPresets = (List)new ArrayList((Collection)list);
            }
        }
        else {
            this.combatManager.equipmentPresets = (List)new ArrayList((Collection)Arrays.asList((Object[])new List[] { null, null }));
        }
        this.IdleTime();
        for (int n11 = 0; n11 < this.farming.farmCrop.size(); ++n11) {
            if (this.farming.farmCropTimeRemaining.get(n11) != null && (long)this.farming.farmCropTimeRemaining.get(n11) > 0L) {
                final CountDownTimer countDownTimer = new CountDownTimer(this, (long)this.farming.farmCropTimeRemaining.get(n11), 1000L, n11) {
                    final MainActivity this$0;
                    final int val$finalI;
                    
                    public void onFinish() {
                        this.this$0.farming.farmCropTimeRemaining.set(this.val$finalI, (Object)0L);
                        if (this.this$0.farming.farmCropProgress.get(this.val$finalI) != null) {
                            ((TextView)this.this$0.farming.farmCropProgress.get(this.val$finalI)).setText((CharSequence)"Ready");
                        }
                    }
                    
                    public void onTick(final long n) {
                        try {
                            this.this$0.farming.farmCropTimeRemaining.set(this.val$finalI, (Object)n);
                            if (this.this$0.farming.farmCropProgress.get(this.val$finalI) != null) {
                                ((TextView)this.this$0.farming.farmCropProgress.get(this.val$finalI)).setText((CharSequence)this.this$0.GetTime(n));
                            }
                        }
                        catch (final IndexOutOfBoundsException ex) {
                            this.this$0.LogIt("Index out of bounds: " + (Object)ex);
                        }
                    }
                };
                countDownTimer.start();
                this.farming.farmCropTimer.set(n11, (Object)countDownTimer);
            }
        }
        if (string12.isEmpty()) {
            this.baseTower.myTreestones = (List)new ArrayList();
        }
        else {
            this.baseTower.myTreestones.addAll((Collection)Arrays.asList((Object[])string12.split("\\s*/\\s*")));
        }
        this.gameLoaded = true;
        final Statistic accountStats2 = this.accountStats;
        if (accountStats2 == null) {
            final ArrayList list2 = new ArrayList();
            for (int n12 = 0; n12 < this.combatManager.enemyNames.size(); ++n12) {
                ((List)list2).add((Object)value);
            }
            this.accountStats = new Statistic((List<Long>)list2, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);
        }
        else if (accountStats2.getAllMonsterKills().size() < this.combatManager.enemyNames.size()) {
            for (int size = this.combatManager.enemyNames.size(), size2 = this.accountStats.getAllMonsterKills().size(), n13 = 0; n13 < size - size2; ++n13) {
                this.accountStats.getAllMonsterKills().add((Object)value);
            }
        }
        this.gameStartTime = System.currentTimeMillis();
        this.itemManager.CheckSkillingScrolls();
        this.ContinueLoad();
    }
    
    public void LoadChestScreen() {
        final LinearLayout chestLootScreen = (LinearLayout)this.inflater.inflate(2131492907, (ViewGroup)this.mainView, false);
        this.chestLootScreen = chestLootScreen;
        this.mainView.addView((View)chestLootScreen);
        this.DisableLayout((ViewGroup)this.chestLootScreen);
    }
    
    public void LoadGenerations(final String text, final String text2) {
        this.HideView(this.currentView);
        this.ShowView(this.currentView = (View)this.generationScreen);
        this.genWrap.removeAllViews();
        if (text == null) {
            this.HideView(((LinearLayout)this.generationScreen.getChildAt(0)).getChildAt(0));
        }
        else {
            this.ShowView(((LinearLayout)this.generationScreen.getChildAt(0)).getChildAt(0));
            ((TextView)((LinearLayout)this.generationScreen.getChildAt(0)).getChildAt(0)).setText((CharSequence)text);
        }
        if (text2 == null) {
            this.HideView(((LinearLayout)this.generationScreen.getChildAt(0)).getChildAt(1));
        }
        else {
            this.ShowView(((LinearLayout)this.generationScreen.getChildAt(0)).getChildAt(1));
            ((TextView)((LinearLayout)this.generationScreen.getChildAt(0)).getChildAt(1)).setText((CharSequence)text2);
        }
    }
    
    public void LoadItemSelect(final String text) {
        this.DisableScreen();
        this.DisableLayout((ViewGroup)this.itemSelect);
        this.ShowView((View)this.itemSelect);
        this.itemSelect_wrap.removeAllViews();
        this.funimator.Start("SlideInUp", 200L, new Funimator$AnimationData((View)this.itemSelect, 0, false, 0, 1));
        this.mainHandler.postDelayed((Runnable)new MainActivity$$ExternalSyntheticLambda90(this), 210L);
        this.itemSelect_title.setText((CharSequence)text);
    }
    
    public void LogIt(final String s) {
        Log.e("Devlog", s);
    }
    
    public void Login(final boolean b) {
        final Long value = 0L;
        if (b) {
            for (int i = 0; i < this.skills.size(); ++i) {
                if (i == 3) {
                    this.skillExp.add((Object)5118L);
                }
                else {
                    this.skillExp.add((Object)value);
                }
            }
        }
        else {
            if (this.skillExp.size() > this.skills.size()) {
                for (int j = this.skillExp.size(); j > this.skills.size(); --j) {
                    this.skillExp.remove(j - 1);
                }
            }
            if (this.skillExp.size() < this.skills.size()) {
                for (int size = this.skills.size(), size2 = this.skillExp.size(), k = 0; k < size - size2; ++k) {
                    this.skillExp.add((Object)value);
                }
            }
        }
        this.backgroundExecutor.execute((Runnable)new MainActivity$$ExternalSyntheticLambda41(this));
        if (this.currentStamina < 0) {
            this.currentStamina = this.maxStamina;
        }
        if (this.accountType.isEmpty()) {
            this.accountType = "Standard";
        }
        if (this.farming.farmCrop.size() < this.farming.planters) {
            for (int l = this.farming.farmCrop.size(); l < this.farming.planters; ++l) {
                this.farming.farmCrop.add((Object)null);
            }
        }
        if (this.farming.farmCropTimer.size() < this.farming.planters) {
            for (int size3 = this.farming.farmCropTimer.size(); size3 < this.farming.planters; ++size3) {
                this.farming.farmCropTimer.add((Object)null);
            }
        }
        if (this.farming.farmCropProgress.size() < this.farming.planters) {
            for (int size4 = this.farming.farmCropProgress.size(); size4 < this.farming.planters; ++size4) {
                this.farming.farmCropProgress.add((Object)null);
            }
        }
        if (this.farming.farmCropTimeRemaining.size() < this.farming.planters) {
            for (int size5 = this.farming.farmCropTimeRemaining.size(); size5 < this.farming.planters; ++size5) {
                this.farming.farmCropTimeRemaining.add((Object)null);
            }
        }
        if (b) {
            this.UpdateBottomNav();
            this.currentStamina = this.maxStamina;
            this.GiveItem("Tomato", 25L, false);
            if (!this.referringFriend.isEmpty()) {
                this.totalGems = 5000L;
                this.GiveItem("Massive Exp Scroll", 1L, false);
            }
            this.Save(false);
        }
        this.ShowView((View)this.loggingIn);
        this.UpdateCash();
        this.HeavyTasks(b);
        if (this.baseTower.baseTowerLevel < 30 && this.baseTower.myTreestones.contains((Object)"Treestone of Power") && this.baseTower.baseTowerLevel >= 20) {
            this.baseTower.myTreestones.set(this.baseTower.myTreestones.indexOf((Object)"Treestone of Power"), (Object)"Treestone of Soul");
        }
    }
    
    public void LoginScreen() {
        this.HideView((View)this.loggingIn);
        this.HideAllViews();
        this.ShowView((View)this.loginScreen);
        final TextView textView = (TextView)this.loginScreen.findViewById(2131296794);
        final LinearLayout linearLayout = (LinearLayout)this.loginScreen.findViewById(2131296796);
        textView.setText((CharSequence)"Attempting to sign in to server...");
        final GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient((Activity)this);
        this.gamesSignInClient = gamesSignInClient;
        gamesSignInClient.isAuthenticated().addOnCompleteListener((OnCompleteListener)new MainActivity$$ExternalSyntheticLambda163(this, textView, linearLayout)).addOnFailureListener((OnFailureListener)new MainActivity$$ExternalSyntheticLambda164(this, textView, linearLayout));
    }
    
    public int MyCombatLevel() {
        return this.GetCombatLevel(this.GetSkillLevel("Attack"), this.GetSkillLevel("Strength"), this.GetSkillLevel("Defence"), this.GetSkillLevel("Health"));
    }
    
    public void OpenEquipment() {
        final View currentView = this.currentView;
        if (currentView != this.equipmentScreen) {
            this.HideView(currentView);
            this.ShowView(this.currentView = (View)this.equipmentScreen);
            if (this.equipmentHeight == 0) {
                this.equipmentScreen.post((Runnable)new MainActivity$$ExternalSyntheticLambda69(this));
            }
            if (this.equipmentPresets == null) {
                this.equipmentPresets = (LinearLayout)this.findViewById(2131296597);
            }
            this.PresetListeners();
            this.UpdateEquipment();
            for (int i = 0; i < this.combatManager.equippedItemsViews.size(); ++i) {
                ((ImageView)this.combatManager.equippedItemsViews.get(i)).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda70(this, i));
            }
            this.findViewById(2131296599).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda71(this));
        }
    }
    
    public void OpenMenu() {
        this.ShowView((View)this.menu);
        this.DisableScreen();
        this.DisableLayout((ViewGroup)this.menu);
        final ScrollView scrollView = (ScrollView)this.menu.findViewById(2131296842);
        if (this.databaseManager.firebaseUser == null) {
            ((LinearLayout)scrollView.getChildAt(0)).getChildAt(0).setVisibility(8);
        }
        else {
            ((LinearLayout)scrollView.getChildAt(0)).getChildAt(0).setVisibility(0);
            ((TextView)((LinearLayout)scrollView.getChildAt(0)).getChildAt(0)).setText((CharSequence)this.databaseManager.firebaseUser.getDisplayName());
        }
        scrollView.scrollTo(0, 0);
        this.funimator.Start("SlideInLeft", 200L, new Funimator$AnimationData((View)this.menu, 0, false, 0, 1));
        this.mainHandler.postDelayed((Runnable)new MainActivity$$ExternalSyntheticLambda7(this), 210L);
        for (int i = 0; i < this.menuWrap.getChildCount(); ++i) {
            final RelativeLayout relativeLayout = (RelativeLayout)this.menuWrap.getChildAt(i);
            if (!this.setMenu) {
                ((ImageView)relativeLayout.getChildAt(0)).setImageDrawable(this.GetImage((int)this.areaIcons.get(i)));
                ((TextView)relativeLayout.getChildAt(1)).setText((CharSequence)this.areas.get(i));
            }
            if ((boolean)this.membersArea.get(i) && !this.members) {
                relativeLayout.setAlpha(0.3f);
            }
            relativeLayout.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda8(this, i));
        }
        this.setMenu = true;
    }
    
    public void OpenSettings() {
        if (this.settingsScreen == null) {
            this.settingsScreen = (ScrollView)((ViewStub)this.findViewById(2131297107)).inflate();
            this.settingsScreen = (ScrollView)this.findViewById(2131297106);
            this.openReferralStore = (TextView)this.findViewById(2131296935);
            this.settingsTradeName = (TextView)this.findViewById(2131297108);
            this.settingsInformation = (TextView)this.findViewById(2131297105);
            this.settingsCreateAccount = (TextView)this.findViewById(2131297103);
            this.settingsError = (TextView)this.findViewById(2131297104);
        }
        this.HideView(this.currentView);
        this.ShowView(this.currentView = (View)this.settingsScreen);
        final LinearLayout linearLayout = (LinearLayout)this.settingsScreen.getChildAt(0);
        this.UpdateSettings();
        if (this.accountType.equals((Object)"Ironman")) {
            this.HideView(linearLayout.getChildAt(3));
        }
        else {
            this.ShowView(linearLayout.getChildAt(3));
            linearLayout.getChildAt(3).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda159(this));
        }
        linearLayout.getChildAt(5).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda160(this));
        linearLayout.getChildAt(8).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda161(this));
        if (this.gpSignedIn) {
            linearLayout.getChildAt(7).setAlpha(1.0f);
            linearLayout.getChildAt(7).setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda162(this));
        }
        else {
            linearLayout.getChildAt(7).setAlpha(0.3f);
        }
    }
    
    public void OpenWiki() {
        this.Save(true);
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://cherrytree.wiki/"));
        try {
            this.startActivity(intent);
        }
        catch (final ActivityNotFoundException ex) {
            this.LogIt("Activity not found: " + (Object)ex);
        }
    }
    
    public long OutfitBoost() {
        long n = 0L;
        long n2;
        for (int i = 0; i < this.combatManager.equippedItems.size(); ++i, n = n2) {
            n2 = n;
            if (this.combatManager.equippedItems.get(i) != null) {
                if (!((String)this.combatManager.equippedItems.get(i)).equals((Object)"Challenger Boots") && !((String)this.combatManager.equippedItems.get(i)).equals((Object)"Challenger Gloves") && !((String)this.combatManager.equippedItems.get(i)).equals((Object)"Challenger Hat") && !((String)this.combatManager.equippedItems.get(i)).equals((Object)"Challenger Legs")) {
                    n2 = n;
                    if (!((String)this.combatManager.equippedItems.get(i)).equals((Object)"Challenger Top")) {
                        continue;
                    }
                }
                n2 = n + 5L;
            }
        }
        return n;
    }
    
    public String PickDrop(final List<String> list) {
        final float randomFloat = this.RandomFloat();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        final ArrayList list5 = new ArrayList();
        final ArrayList list6 = new ArrayList();
        final ArrayList list7 = new ArrayList();
        final ArrayList list8 = new ArrayList();
        for (final String s : list) {
            final String s2 = (String)this.allItemsRarity.get(this.allItems.indexOf((Object)s));
            s2.hashCode();
            final int hashCode = s2.hashCode();
            int n = -1;
            switch (hashCode) {
                case 2024019467: {
                    if (!s2.equals((Object)"Common")) {
                        break;
                    }
                    n = 6;
                    break;
                }
                case 216109671: {
                    if (!s2.equals((Object)"Super Rare")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 191459333: {
                    if (!s2.equals((Object)"Mythical")) {
                        break;
                    }
                    n = 4;
                    break;
                }
                case 2539714: {
                    if (!s2.equals((Object)"Rare")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case -77594853: {
                    if (!s2.equals((Object)"Legendary")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case -403667484: {
                    if (!s2.equals((Object)"Uncommon")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -426919918: {
                    if (!s2.equals((Object)"Secret Rare")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    continue;
                }
                case 6: {
                    ((List)list2).add((Object)s);
                    continue;
                }
                case 5: {
                    ((List)list5).add((Object)s);
                    continue;
                }
                case 4: {
                    ((List)list8).add((Object)s);
                    continue;
                }
                case 3: {
                    ((List)list4).add((Object)s);
                    continue;
                }
                case 2: {
                    ((List)list6).add((Object)s);
                    continue;
                }
                case 1: {
                    ((List)list3).add((Object)s);
                    continue;
                }
                case 0: {
                    ((List)list7).add((Object)s);
                    continue;
                }
            }
        }
        String s3;
        if (randomFloat <= this.secretChance + this.secretChanceBoost && !((List)list7).isEmpty()) {
            s3 = (String)((List)list7).get(new Random().nextInt(((List)list7).size()));
        }
        else if (randomFloat <= this.mythicalChance + this.mythicalChanceBoost && !((List)list8).isEmpty()) {
            s3 = (String)((List)list8).get(new Random().nextInt(((List)list8).size()));
        }
        else if (randomFloat <= this.legendaryChance + this.legendaryChanceBoost && !((List)list6).isEmpty()) {
            s3 = (String)((List)list6).get(new Random().nextInt(((List)list6).size()));
        }
        else if ((randomFloat <= this.superRareChance + this.superRareChanceBoost && !((List)list5).isEmpty()) || (((List)list2).isEmpty() && ((List)list3).isEmpty() && ((List)list4).isEmpty())) {
            s3 = (String)((List)list5).get(new Random().nextInt(((List)list5).size()));
        }
        else if ((randomFloat <= this.rareChance + this.rareChanceBoost && !((List)list4).isEmpty()) || (((List)list2).isEmpty() && ((List)list3).isEmpty())) {
            s3 = (String)((List)list4).get(new Random().nextInt(((List)list4).size()));
        }
        else if ((randomFloat <= this.uncommonChance && !((List)list3).isEmpty()) || ((List)list2).isEmpty()) {
            s3 = (String)((List)list3).get(new Random().nextInt(((List)list3).size()));
        }
        else {
            s3 = (String)((List)list2).get(new Random().nextInt(((List)list2).size()));
        }
        return s3;
    }
    
    void PlayBackup(final boolean b) {
        if (this.gpSignedIn && !this.playGamesUser.isEmpty()) {
            this.attemptingBackup = true;
            PlayGames.getSnapshotsClient((Activity)this).open(this.mCurrentSaveName, true, 3).addOnCompleteListener((OnCompleteListener)new MainActivity$$ExternalSyntheticLambda134(this, new Gson().toJson((Object)this.CreatePlayMap()), this.currentUsername + "\nTotal Level: " + this.GetTotalLevel() + "\nTotal Exp: " + this.FormatExp(this.GetTotalExp()) + "\nTotal Gold: " + this.FormatExp(this.totalGems), b)).addOnFailureListener((OnFailureListener)new MainActivity$$ExternalSyntheticLambda135(this, b));
        }
    }
    
    public void PurchaseItem(final ProductDetails productDetails) {
        this.billingClient.launchBillingFlow((Activity)this, BillingFlowParams.newBuilder().setProductDetailsParamsList((List)ImmutableList.of((Object)BillingFlowParams$ProductDetailsParams.newBuilder().setProductDetails(productDetails).build())).build());
    }
    
    public void QuickPopup(final String text) {
        if (this.quickPopups.getChildCount() > 2) {
            return;
        }
        final TextView popupView = this.getPopupView();
        popupView.setText((CharSequence)text);
        try {
            this.quickPopups.addView((View)popupView);
            popupView.post((Runnable)new MainActivity$$ExternalSyntheticLambda5(this, popupView));
        }
        catch (final NullPointerException ex) {
            this.LogIt("NPE: " + (Object)ex);
        }
    }
    
    public float RandomFloat() {
        return new Random().nextFloat() * 100.0f + 0.0f;
    }
    
    public void RemoveItem(final String s, final int n) {
        final int index = this.inventoryItems.indexOf((Object)s);
        try {
            final List<Long> inventoryAmounts = this.inventoryAmounts;
            inventoryAmounts.set(index, (Object)((long)inventoryAmounts.get(index) - n));
            if ((long)this.inventoryAmounts.get(index) <= 0L) {
                this.inventoryItems.remove(index);
                this.inventoryAmounts.remove(index);
                this.inventoryItemLocked.remove(index);
            }
        }
        catch (final IndexOutOfBoundsException ex) {
            this.LogIt("Caught: " + (Object)ex);
        }
    }
    
    public void RemoveItemStash(final String s, final int n) {
        final int index = this.baseTower.stashItems.indexOf((Object)s);
        this.baseTower.stashAmounts.set(index, (Object)((long)this.baseTower.stashAmounts.get(index) - n));
        if ((long)this.baseTower.stashAmounts.get(index) <= 0L) {
            this.baseTower.stashItems.remove(index);
            this.baseTower.stashAmounts.remove(index);
        }
    }
    
    public void RemoveSeed(final String s, final TextView textView) {
        final int index = this.farming.seedBag.indexOf((Object)s);
        this.farming.seedBagAmounts.set(index, (Object)((long)this.farming.seedBagAmounts.get(index) - 1L));
        if ((long)this.farming.seedBagAmounts.get(index) <= 0L) {
            this.farming.seedBag.remove(index);
            this.farming.seedBagAmounts.remove(index);
        }
        if (this.selectedCrop.isEmpty()) {
            textView.setText((CharSequence)"Click here to select a seed to plant");
        }
        else if (this.farming.seedBag.contains((Object)this.selectedCrop)) {
            textView.setText((CharSequence)this.getString(2131820760, new Object[] { this.selectedCrop, this.farming.seedBagAmounts.get(this.farming.seedBag.indexOf((Object)this.selectedCrop)) }));
        }
        else {
            this.selectedCrop = "";
            textView.setText((CharSequence)"Click here to select a seed to plant");
        }
    }
    
    void RestoreCloudSave() {
        this.HideView((View)this.createAccountButton);
        this.HideView((View)this.cloudSaves);
        this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda47(this));
        PlayGames.getSnapshotsClient((Activity)this).open(this.mCurrentSaveName, true, 3).addOnFailureListener((OnFailureListener)new MainActivity$$ExternalSyntheticLambda48(this)).continueWith((Continuation)new MainActivity$$ExternalSyntheticLambda49(this)).addOnCompleteListener((OnCompleteListener)new MainActivity$$ExternalSyntheticLambda50(this));
    }
    
    void RestoreData(final Map<String, ?> map) {
        final SharedPreferences sharedPreferences = this.getSharedPreferences("main", 0);
        this.sp = sharedPreferences;
        this.ed = sharedPreferences.edit();
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "totalCoins", "totalGems", "totalKillCoins", "logoutTime", "currentEventCurrency", "holidayCurrency", "totalChickenKills", "totalTribalKills", "idleSkillTime", "dailyBonus", "lastCloudRestore", "lastGodItem", "dailySafesCracked" }));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])new String[] { "maxInventory", "currentHealth", "maxStamina", "currentStamina", "slayerAmount", "fishingRodLevel", "planters", "exploreItems", "staminaSaveChance", "expMultiplier", "marketDiscount", "doubleFish", "doublePotions", "resourceSave", "farmingTimer", "classChanges", "baseTowerLevel", "hiddenBonuses", "maxStash", "discoveryFailChance", "maxIdleIncrease", "skipTickets", "challengeCoins", "lastLoginDay", "activeCharacter", "vaultChances", "secretRaresSent", "tradesRemaining", "activeAvatar", "doubleDays", "cocktailsDrank" }));
        for (final Map$Entry map$Entry : map.entrySet()) {
            final String s = (String)map$Entry.getKey();
            final Object value = map$Entry.getValue();
            if (value instanceof Double) {
                if (((List)list).contains((Object)s)) {
                    if (s.equals((Object)"lastCloudRestore")) {
                        this.ed.putLong("lastCloudRestore", System.currentTimeMillis());
                    }
                    else {
                        this.ed.putLong(s, (long)(double)map$Entry.getValue());
                    }
                }
                else {
                    if (!((List)list2).contains((Object)s)) {
                        continue;
                    }
                    this.ed.putInt(s, (int)(double)map$Entry.getValue());
                }
            }
            else if (value instanceof Boolean) {
                this.ed.putBoolean(s, (boolean)value);
            }
            else {
                if (!(value instanceof String)) {
                    continue;
                }
                this.ed.putString(s, (String)map$Entry.getValue());
            }
        }
        if (!this.ed.commit()) {
            this.ed.apply();
        }
        this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda156(this));
        this.mainHandler.postDelayed((Runnable)new MainActivity$$ExternalSyntheticLambda157(this), 3000L);
    }
    
    public void Save(final boolean b) {
        final SharedPreferences sharedPreferences = this.getSharedPreferences("main", 0);
        this.sp = sharedPreferences;
        this.ed = sharedPreferences.edit();
        this.logoutTime = System.currentTimeMillis();
        final String join = TextUtils.join((CharSequence)"/", (Iterable)this.skillExp);
        final String join2 = TextUtils.join((CharSequence)"/", (Iterable)this.inventoryItems);
        final String join3 = TextUtils.join((CharSequence)"/", (Iterable)this.inventoryAmounts);
        final String join4 = TextUtils.join((CharSequence)"/", (Iterable)this.inventoryItemLocked);
        final String join5 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.seedBag);
        final String join6 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.seedBagAmounts);
        final String join7 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.farmCrop);
        final String join8 = TextUtils.join((CharSequence)"/", (Iterable)this.farming.farmCropTimeRemaining);
        final String join9 = TextUtils.join((CharSequence)"/", (Iterable)this.combatManager.equippedItems);
        final String join10 = TextUtils.join((CharSequence)"/", (Iterable)this.premiumUpgradesPurchased);
        final String join11 = TextUtils.join((CharSequence)"/", (Iterable)this.quests.questsComplete);
        final String join12 = TextUtils.join((CharSequence)"/", (Iterable)this.baseTower.myTreestones);
        final String join13 = TextUtils.join((CharSequence)"/", (Iterable)this.baseTower.stashItems);
        final String join14 = TextUtils.join((CharSequence)"/", (Iterable)this.baseTower.stashAmounts);
        final String join15 = TextUtils.join((CharSequence)"/", (Iterable)this.myPets);
        final String join16 = TextUtils.join((CharSequence)"/", (Iterable)this.offerCodesRedeemed);
        final String join17 = TextUtils.join((CharSequence)"/", (Iterable)this.myTitles);
        final String join18 = TextUtils.join((CharSequence)"/", (Iterable)this.idleDrops);
        final String join19 = TextUtils.join((CharSequence)"/", (Iterable)this.myProfileAvatars);
        this.ed.putLong("totalCoins", this.totalCoins);
        this.ed.putLong("totalGems", this.totalGems);
        this.ed.putLong("totalKillCoins", this.totalKillCoins);
        this.ed.putLong("logoutTime", this.logoutTime);
        this.ed.putLong("currentEventCurrency", this.currentEventCurrency);
        this.ed.putLong("holidayCurrency", this.holidayCurrency);
        this.ed.putLong("totalChickenKills", this.totalChickenKills);
        this.ed.putLong("totalTribalKills", this.totalTribalKills);
        this.ed.putLong("idleSkillTime", this.idleSkillTime);
        this.ed.putLong("dailyBonus", this.dailies.dailyBonus);
        this.ed.putLong("lastCloudRestore", this.lastCloudRestore);
        this.ed.putLong("lastGodItem", this.treasureHunts.lastGodItem);
        this.ed.putLong("dailySafesCracked", this.thieving.dailySafesCracked);
        this.ed.putString("skillExpStr", join);
        this.ed.putString("inventoryItemsStr", join2);
        this.ed.putString("inventoryAmountsStr", join3);
        this.ed.putString("inventoryItemLockedStr", join4);
        this.ed.putString("seedBagStr", join5);
        this.ed.putString("seedBagAmountsStr", join6);
        this.ed.putString("farmCropStr", join7);
        this.ed.putString("farmCropTimeRemainingStr", join8);
        this.ed.putString("equippedItemsStr", join9);
        this.ed.putString("premiumUpgradePurchasedStr", join10);
        this.ed.putString("questsCompleteStr", join11);
        this.ed.putString("myTreestonesStr", join12);
        this.ed.putString("stashItemsStr", join13);
        this.ed.putString("stashAmountsStr", join14);
        this.ed.putString("myPetsStr", join15);
        this.ed.putString("offerCodesRedeemedStr", join16);
        this.ed.putString("myTitlesStr", join17);
        this.ed.putString("idleDropsStr", join18);
        this.ed.putString("myProfileAvatarsStr", join19);
        this.ed.putString("currentAttackStyle", this.currentAttackStyle);
        this.ed.putString("equippedFood", this.equippedFood);
        this.ed.putString("slayerTask", this.combatManager.slayerTask);
        this.ed.putString("currentSlayerMaster", this.combatManager.currentSlayerMaster);
        this.ed.putString("baseTowerName", this.baseTower.baseTowerName);
        this.ed.putString("currentUsername", this.currentUsername);
        this.ed.putString("activeTitle", this.activeTitle);
        this.ed.putString("idleMethod", this.idleMethod);
        this.ed.putString("idleSkill", this.idleSkill);
        this.ed.putString("accountType", this.accountType);
        this.ed.putString("referringFriend", this.referringFriend);
        this.ed.putInt("maxInventory", this.maxInventory);
        this.ed.putInt("currentHealth", this.currentHealth);
        this.ed.putInt("maxStamina", this.maxStamina);
        this.ed.putInt("currentStamina", this.currentStamina);
        this.ed.putInt("slayerAmount", this.combatManager.slayerAmount);
        this.ed.putInt("fishingRodLevel", this.fishingRodLevel);
        this.ed.putInt("planters", this.farming.planters);
        this.ed.putInt("exploreItems", this.exploreItems);
        this.ed.putInt("staminaSaveChance", this.staminaSaveChance);
        this.ed.putInt("expMultiplier", this.expMultiplier);
        this.ed.putInt("marketDiscount", this.marketDiscount);
        this.ed.putInt("doubleFish", this.doubleFish);
        this.ed.putInt("doublePotions", this.doublePotions);
        this.ed.putInt("resourceSave", this.resourceSave);
        this.ed.putInt("farmingTimer", this.farmingTimer);
        this.ed.putInt("maxIdleIncrease", this.maxIdleIncrease);
        this.ed.putInt("baseTowerLevel", this.baseTower.baseTowerLevel);
        this.ed.putInt("hiddenBonuses", this.baseTower.hiddenBonuses);
        this.ed.putInt("maxStash", this.baseTower.maxStash);
        this.ed.putInt("discoveryFailChance", this.discovery.discoveryFailChance);
        this.ed.putInt("skipTickets", this.dailies.skipTickets);
        this.ed.putInt("challengeCoins", this.dailies.challengeCoins);
        this.ed.putInt("lastLoginDay", this.dailies.lastLoginDay);
        this.ed.putInt("doubleDays", this.dailies.doubleDays);
        this.ed.putInt("vaultChances", this.databaseManager.vaultChances);
        this.ed.putInt("activeCharacter", this.activeCharacter);
        this.ed.putInt("activeAvatar", this.activeAvatar);
        this.ed.putInt("cocktailsDrank", this.alchemy.cocktailsDrank);
        this.ed.putBoolean("autoEat", this.autoEat);
        this.ed.putBoolean("saveAvailable", this.saveAvailable);
        this.ed.putBoolean("members", this.members);
        this.ed.putBoolean("claimedGift", this.claimedGift);
        if (this.accountStats != null) {
            this.ed.putString("accountStats", new Gson().toJson((Object)this.accountStats));
        }
        if (!this.dailies.dailyChallenges.isEmpty()) {
            this.ed.putString("dailyChallenges", new Gson().toJson((Object)this.dailies.dailyChallenges));
        }
        this.ed.putString("vaultCodesClaimed", new Gson().toJson((Object)this.databaseManager.vaultCodesClaimed));
        this.ed.putString("equipmentPresets", new Gson().toJson((Object)this.combatManager.equipmentPresets));
        if (!this.databaseManager.myWishes.isEmpty()) {
            this.ed.putString("myWishes", new Gson().toJson((Object)this.databaseManager.myWishes));
        }
        if (!this.databaseManager.myBigWishes.isEmpty()) {
            this.ed.putString("myBigWishes", new Gson().toJson((Object)this.databaseManager.myBigWishes));
        }
        if (this.treasureHunts.myTreasureHunts != null) {
            this.ed.putString("myTreasureHunts", new Gson().toJson((Object)this.treasureHunts.myTreasureHunts));
        }
        if (this.treasureHunts.eventPresent != null) {
            this.ed.putString("myEventPresents", new Gson().toJson((Object)this.treasureHunts.eventPresent));
        }
        if (this.combatManager.slayerInfo != null) {
            this.ed.putString("slayerInfo", new Gson().toJson((Object)this.combatManager.slayerInfo));
        }
        if (this.itemManager.skillingScrolls != null) {
            this.ed.putString("mySkillingScrolls", new Gson().toJson((Object)this.itemManager.skillingScrolls));
        }
        if (this.itemManager.blessings != null) {
            this.ed.putString("myBlessings", new Gson().toJson((Object)this.itemManager.blessings));
        }
        if (this.secretPathway.myPath != null) {
            this.ed.putString("mysecpath", new Gson().toJson((Object)this.secretPathway.myPath));
        }
        if (b) {
            if (!this.ed.commit()) {
                this.ed.apply();
            }
        }
        else {
            this.ed.apply();
        }
    }
    
    public void SetHighlightedSkill() {
        final TextView textView = (TextView)this.findViewById(2131297331);
        if (this.databaseManager.weeklySkill.isEmpty()) {
            this.HideView((View)textView);
        }
        else {
            this.ShowView((View)textView);
            final String weeklySkill = this.databaseManager.weeklySkill;
            weeklySkill.hashCode();
            final int hashCode = weeklySkill.hashCode();
            int n = -1;
            switch (hashCode) {
                case 1281238620: {
                    if (!weeklySkill.equals((Object)"Thieving")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case 816216682: {
                    if (!weeklySkill.equals((Object)"Fishing")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case 531872580: {
                    if (!weeklySkill.equals((Object)"Forestry")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -1990171536: {
                    if (!weeklySkill.equals((Object)"Mining")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                case 3: {
                    textView.setText((CharSequence)"This weeks highlighted skill is Thieving, all week your daily safecracking limit is increased and you have 100% success rate while Pickpocketing!");
                    break;
                }
                case 2: {
                    textView.setText((CharSequence)"This weeks highlighted skill is Fishing, all week there's a 10% chance to double all your catches!");
                    break;
                }
                case 1: {
                    textView.setText((CharSequence)"This weeks highlighted skill is Forestry, all week there's a 10% chance to double all logs chopped!");
                    break;
                }
                case 0: {
                    textView.setText((CharSequence)"This weeks highlighted skill is Mining, all week there's a 10% chance to double all ores mined!");
                    break;
                }
            }
        }
    }
    
    public void SetTextSize(final TextView textView, final int n) {
        textView.setTextSize(0, (float)n);
    }
    
    public void ShowConfirmationPopup(final int n, final String text, final SpannableString text2, final String text3, final String text4, final Runnable runnable) {
        this.DisableScreen();
        final RelativeLayout relativeLayout = (RelativeLayout)this.inflater.inflate(2131492911, (ViewGroup)this.mainView, false);
        relativeLayout.setAlpha(0.0f);
        if (text4.isEmpty()) {
            this.HideView(relativeLayout.findViewById(2131296528));
        }
        else {
            this.ShowView(relativeLayout.findViewById(2131296528));
            ((TextView)relativeLayout.findViewById(2131296528)).setText((CharSequence)text4);
        }
        ((TextView)relativeLayout.findViewById(2131297253)).setText((CharSequence)text);
        ((TextView)relativeLayout.findViewById(2131296749)).setText((CharSequence)text2);
        ((TextView)relativeLayout.findViewById(2131296472)).setText((CharSequence)text3);
        ((ImageView)relativeLayout.findViewById(2131296743)).setImageDrawable(this.GetImage(n));
        this.mainView.addView((View)relativeLayout);
        relativeLayout.post((Runnable)new MainActivity$$ExternalSyntheticLambda32(this, relativeLayout, runnable, text4));
    }
    
    public void ShowMessage(final String[] array, final int n) {
        this.HideView((View)this.welcomeNext);
        this.DisableLayout((ViewGroup)this.welcomeScreen);
        this.welcomeMessageTv.setText((CharSequence)array[n]);
        if (n != 2) {
            if (n != 5) {
                if (n != 6) {
                    this.HideView((View)this.tutorialHand);
                }
                else {
                    this.tutorialHand.setX(this.quickHealth.getX() + this.GetResource(2131100102));
                    this.tutorialHand.setY((float)(this.welcomeScreen.getBottom() - this.GetResource(2131100215)));
                    this.ShowView((View)this.tutorialHand);
                }
            }
            else {
                this.tutorialHand.setX(this.quickFoodView.getX() + this.GetResource(2131099824));
                this.tutorialHand.setY((float)(this.welcomeScreen.getBottom() - this.GetResource(2131100215)));
                this.tutorialHand.setRotation(270.0f);
                this.ShowView((View)this.tutorialHand);
            }
        }
        else {
            this.ShowView((View)this.tutorialHand);
            this.tutorialHand.setX((float)this.GetResource(2131099880));
            this.tutorialHand.setY((float)this.GetResource(2131100215));
        }
        this.mainHandler.postDelayed((Runnable)new MainActivity$$ExternalSyntheticLambda64(this, new int[] { n }, array), 2000L);
    }
    
    void ShowSavedGames() {
        PlayGames.getSnapshotsClient((Activity)this).getSelectSnapshotIntent("See my Saves", true, true, 1).addOnSuccessListener((OnSuccessListener)new MainActivity$$ExternalSyntheticLambda15(this)).addOnFailureListener((OnFailureListener)new MainActivity$$ExternalSyntheticLambda16(this));
    }
    
    public void ShowTutorial() {
        this.DisableScreen();
        final RelativeLayout welcomeScreen = (RelativeLayout)this.inflater.inflate(2131493071, (ViewGroup)this.mainView, false);
        this.welcomeScreen = welcomeScreen;
        this.welcomeMessageTv = (TextView)welcomeScreen.findViewById(2131297334);
        this.welcomeNext = (TextView)this.welcomeScreen.findViewById(2131297335);
        this.tutorialHand = (ImageView)this.welcomeScreen.findViewById(2131297297);
        this.mainView.addView((View)this.welcomeScreen);
        this.welcomeScreen.post((Runnable)new MainActivity$$ExternalSyntheticLambda14(this, new String[] { "Hello there " + this.currentUsername + ", welcome to CherryTree!", "This game is huge and there are so many things to do, you will have to figure out most of it yourself, however we will cover the main things you need to know.", "First off, everything you will ever need can be found in the Main Menu, which is this icon here...", "Now, when you get into combat you're going to need food! I've given you 25 Tomatoes to get you started.", "They can be found in your Inventory, which you can find via the Menu we discussed earlier...", "Food can be used to heal you by equipping it from the Inventory, then clicking this button here...to heal yourself!", "You can see your current health here...", "There are lots of skills for you to train! From combat which requires defeating enemies, to Fishing, which is more relaxed.", "Some of the skills are idle, which means they work when the game is closed!", "The Main Menu is where you can navigate around the game and find all skill training areas.", "Well, that's about the basics, but if you have any questions we have a great community!", "Just head to Home Profile via the Main Menu, click Social Links, and join us! We're always happy to help!", "Good Luck on your Adventure " + this.currentUsername + "! You're going to need it, and we hope to see you in the Socials!" }, 0));
    }
    
    public void ShowView(final View view) {
        view.setVisibility(0);
    }
    
    public void StartSkilling(final String s, final long idleSkillTime, final List<String> idleDrops, final boolean b, final String s2, final long n, final RelativeLayout relativeLayout) {
        if (this.skillingTimerRunning) {
            this.skillingTimerRunning = false;
            this.skillingTimer.cancel();
        }
        if (this.findViewById(2131296739).getVisibility() == 0) {
            this.findViewById(2131296739).setVisibility(8);
        }
        this.idleSkill = s;
        this.idleDrops = idleDrops;
        this.idleMethod = s2;
        this.idleSkillTime = idleSkillTime;
        this.skillingTimerRunning = true;
        this.trainingSkill = s;
        this.trainingMethod = s2;
        (this.skillingTimer = new CountDownTimer(this, idleSkillTime, 1000L, n, s, s2, idleDrops, idleSkillTime, relativeLayout, b) {
            final MainActivity this$0;
            final long val$exp;
            final String val$method;
            final List val$possibleDrops;
            final RelativeLayout val$progressView;
            final boolean val$repeat;
            final String val$skill;
            final long val$time;
            
            public void onFinish() {
                long val$exp = this.val$exp;
                final String val$skill = this.val$skill;
                val$skill.hashCode();
                final int hashCode = val$skill.hashCode();
                final int n = 1;
                final int n2 = 1;
                int n3 = -1;
                switch (hashCode) {
                    case 1882760592: {
                        if (!val$skill.equals((Object)"Discovery")) {
                            break;
                        }
                        n3 = 4;
                        break;
                    }
                    case 1281238620: {
                        if (!val$skill.equals((Object)"Thieving")) {
                            break;
                        }
                        n3 = 3;
                        break;
                    }
                    case 816216682: {
                        if (!val$skill.equals((Object)"Fishing")) {
                            break;
                        }
                        n3 = 2;
                        break;
                    }
                    case 531872580: {
                        if (!val$skill.equals((Object)"Forestry")) {
                            break;
                        }
                        n3 = 1;
                        break;
                    }
                    case -1990171536: {
                        if (!val$skill.equals((Object)"Mining")) {
                            break;
                        }
                        n3 = 0;
                        break;
                    }
                }
                String s = null;
                int n7 = 0;
                int n8 = 0;
                Label_5673: {
                    int n6 = 0;
                    Label_5662: {
                        Label_5655: {
                            Label_4735: {
                                switch (n3) {
                                    case 4: {
                                        int n4;
                                        if (!this.this$0.combatManager.equippedItems.contains((Object)"Discovery Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Max Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Mini Max Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                                            n4 = 1;
                                        }
                                        else {
                                            n4 = 3;
                                        }
                                        int n5 = n4;
                                        if (this.this$0.baseTower.baseTowerLevel >= 2) {
                                            n5 = n4 + 1;
                                        }
                                        final MainActivity this$0 = this.this$0;
                                        --this$0.currentStamina;
                                        if (this.this$0.GetRandom(1, 100) > this.this$0.discovery.discoveryFailChance) {
                                            final String pickDrop = this.this$0.PickDrop((List<String>)this.val$possibleDrops);
                                            if (pickDrop.equals((Object)"Gold Coin")) {
                                                final MainActivity this$2 = this.this$0;
                                                ++this$2.totalGems;
                                                this.this$0.UpdateCash();
                                            }
                                            else {
                                                this.this$0.GiveItem(pickDrop, n5, true);
                                            }
                                            s = "";
                                            n6 = 1;
                                        }
                                        else {
                                            s = "Oops, didn't find anything.";
                                            n6 = 0;
                                        }
                                        if (this.this$0.discoveryScreen.isShown()) {
                                            this.this$0.discovery.UpdateEnergy();
                                        }
                                        if (this.this$0.currentStamina <= 0) {
                                            this.this$0.QuickPopup("You ran out of Energy.");
                                            n7 = n6;
                                            n8 = 1;
                                            break Label_5673;
                                        }
                                        break Label_5662;
                                    }
                                    case 3: {
                                        if (this.this$0.GetRandom(1, 100) > this.this$0.thieving.GetSuccessChance(this.this$0.thieving.thievingNpc.indexOf((Object)this.val$method)) && !this.this$0.alchemy.activePotions.contains((Object)"Thieving Potion")) {
                                            int n9 = (int)Math.max(this.this$0.maxHealth / 100.0f * (int)this.this$0.thieving.thievingDamage.get(this.this$0.thieving.thievingNpc.indexOf((Object)this.val$method)), 20.0f);
                                            if (this.this$0.combatManager.equippedItems.contains((Object)"Thieving Cape") || this.this$0.combatManager.equippedItems.contains((Object)"Max Cape") || this.this$0.combatManager.equippedItems.contains((Object)"Completion Cape") || this.this$0.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") || this.this$0.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                                                n9 = 0;
                                            }
                                            final MainActivity this$3 = this.this$0;
                                            this$3.currentHealth -= n9;
                                            if (this.this$0.currentHealth <= 0) {
                                                this.this$0.currentHealth = 0;
                                                this.this$0.QuickPopup("While Pickpocketing, you died!");
                                                this.this$0.GoHome();
                                                n8 = n2;
                                            }
                                            else {
                                                n8 = 0;
                                            }
                                            this.this$0.UpdateBottomNav();
                                            s = "Pickpocket Failed";
                                            break Label_4735;
                                        }
                                        long longValue;
                                        final long n10 = longValue = (long)this.this$0.thieving.thievingCoins.get(this.this$0.thieving.thievingNpc.indexOf((Object)this.val$method));
                                        if (this.this$0.baseTower.baseTowerLevel >= 44) {
                                            longValue = n10 * 2L;
                                        }
                                        long n11 = 0L;
                                        Label_0987: {
                                            if (!this.this$0.combatManager.equippedItems.contains((Object)"Thieving Gloves")) {
                                                n11 = longValue;
                                                if (!this.this$0.combatManager.equippedItems.contains((Object)"Thieving Gloves (E)")) {
                                                    break Label_0987;
                                                }
                                            }
                                            n11 = longValue * 5L;
                                        }
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Thieving Gloves (E)") && this.this$0.GetRandom(1, 100) <= 1) {
                                            final MainActivity this$4 = this.this$0;
                                            ++this$4.totalGems;
                                            this.this$0.QuickPopup("Your enhanced Thieving Gloves find a Gold Coin.");
                                        }
                                        final MainActivity this$5 = this.this$0;
                                        this$5.totalCoins += n11;
                                        this.this$0.UpdateCash();
                                        this.this$0.thieving.PickThievingLoot(this.val$method);
                                        this.this$0.CheckGoldenTouch();
                                        this.this$0.thieving.CheckSack(this.val$time);
                                        if (this.val$method.equals((Object)"Cook") && this.this$0.combatManager.equippedItems.contains((Object)"Cooking Cape")) {
                                            this.this$0.combatManager.CheckSecret("Chefs Hat", 2131165682, 250000);
                                        }
                                        this.this$0.dailies.UpdateDailies("Thieving", this.val$method, 1);
                                        this.this$0.treasureHunts.CheckTreasureHunts(this.val$skill, this.val$method);
                                        break;
                                    }
                                    case 2: {
                                        int n12;
                                        if (this.this$0.GetRandom(1, 100) <= this.this$0.doubleFish) {
                                            n12 = 2;
                                        }
                                        else {
                                            n12 = 1;
                                        }
                                        int n13 = n12;
                                        if (this.this$0.alchemy.activePotions.contains((Object)"Fishing Potion")) {
                                            n13 = n12;
                                            if (this.this$0.GetRandom(1, 100) <= 5) {
                                                n13 = n12 + 1;
                                            }
                                        }
                                        int n14 = n13;
                                        if (this.this$0.alchemy.activePotions.contains((Object)"Super Fishing Potion")) {
                                            n14 = n13;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n14 = n13 + 1;
                                            }
                                        }
                                        int n15 = n14;
                                        if (this.this$0.alchemy.activePotions.contains((Object)"Extreme Fishing Potion")) {
                                            n15 = n14;
                                            if (this.this$0.GetRandom(1, 100) <= 15) {
                                                n15 = n14 + 1;
                                            }
                                        }
                                        int n16 = n15;
                                        if (this.this$0.alchemy.activePotions.contains((Object)"Ultimate Fishing Potion")) {
                                            n16 = n15;
                                            if (this.this$0.GetRandom(1, 100) <= 20) {
                                                n16 = n15 + 1;
                                            }
                                        }
                                        int n17 = 0;
                                        Label_1559: {
                                            if (!this.this$0.combatManager.equippedItems.contains((Object)"Fishing Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Max Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Mini Max Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Ultra Comp Cape")) {
                                                n17 = n16;
                                                if (!this.this$0.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                                                    break Label_1559;
                                                }
                                            }
                                            n17 = n16 * 2;
                                        }
                                        int n18 = n17;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Jenny")) {
                                            n18 = n17 + 1;
                                        }
                                        int n19 = n18;
                                        if (this.this$0.baseTower.baseTowerLevel >= 7) {
                                            n19 = n18 * 2;
                                        }
                                        int n20 = n19;
                                        if (this.this$0.fishing.fishingNetActive) {
                                            n20 = n19 * 2;
                                        }
                                        int n21 = n20;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rod of Copina")) {
                                            n21 = n20 * 4;
                                        }
                                        int n22 = n21;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rod of Copina (E)")) {
                                            n22 = n21 * 5;
                                        }
                                        int n23 = n22;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rod of Copina (E2)")) {
                                            n23 = n22 * 6;
                                        }
                                        int n24 = n23;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rod of Copina (E3)")) {
                                            n24 = n23 * 7;
                                        }
                                        int n25 = n24;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rod of Copina (E4)")) {
                                            n25 = n24 * 8;
                                        }
                                        int n26 = n25;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rod of Copina (E5)")) {
                                            n26 = n25 * 9;
                                        }
                                        int n27 = n26;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rod of Copina (E6)")) {
                                            n27 = n26 * 10;
                                        }
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Old Fishing Rod") || this.this$0.combatManager.equippedItems.contains((Object)"Old Fishing Rod (E)")) {
                                            int n28;
                                            if (this.this$0.combatManager.equippedItems.contains((Object)"Old Fishing Rod (E)")) {
                                                n28 = 20;
                                            }
                                            else {
                                                n28 = 15;
                                            }
                                            if (this.this$0.GetRandom(1, 100) <= n28) {
                                                if (this.this$0.GetRandom(1, 5000) <= 2) {
                                                    final TreasureHunts.MyTreasureHunts myTreasureHunts = this.this$0.treasureHunts.myTreasureHunts;
                                                    ++myTreasureHunts.caskets;
                                                    this.this$0.LargePopup(2131165669, "Fishing Luck!", "While Fishing, you reel in a Treasure Casket!");
                                                }
                                                else {
                                                    final String s2 = (String)this.this$0.fishing.oldFishingRodLootTable.get(new Random().nextInt(this.this$0.fishing.oldFishingRodLootTable.size()));
                                                    if (s2.equals((Object)"Gold Coin")) {
                                                        final MainActivity this$6 = this.this$0;
                                                        this$6.totalGems += 2L;
                                                        this.this$0.UpdateCash();
                                                        this.this$0.QuickPopup("Your Old Rod manages to find 2 Gold Coins!");
                                                    }
                                                    else {
                                                        this.this$0.GiveItem(s2, 1L, false);
                                                        this.this$0.QuickPopup("Your Old Rod manages to find a " + s2 + "!");
                                                    }
                                                }
                                            }
                                        }
                                        int n29 = n27;
                                        if (this.this$0.treasureHunts.BoostActive("Commercial Fisher")) {
                                            n29 = n27 * 5;
                                        }
                                        int n30 = n29;
                                        if (this.this$0.treasureHunts.BoostActive("New Fisher")) {
                                            n30 = n29;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n30 = n29 * 2;
                                            }
                                        }
                                        int n31 = n30;
                                        if (this.this$0.fishing.outfitPieces > 0) {
                                            n31 = n30;
                                            if (this.this$0.GetRandom(1, 100) <= this.this$0.fishing.outfitPieces * 5) {
                                                n31 = n30 * 2;
                                            }
                                        }
                                        int n32 = n31;
                                        if (this.this$0.databaseManager.weeklySkill.equals((Object)"Fishing")) {
                                            n32 = n31;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n32 = n31 * 2;
                                            }
                                        }
                                        if (this.val$method.equals((Object)"Christmas Village")) {
                                            this.this$0.event.CheckHotChocolate(this.val$skill);
                                            n32 = 1;
                                        }
                                        final MainActivity this$7 = this.this$0;
                                        final long fishCaught = this$7.fishCaught;
                                        final long n33 = n32;
                                        this$7.fishCaught = fishCaught + n33;
                                        final String pickDrop2 = this.this$0.PickDrop((List<String>)this.val$possibleDrops);
                                        String s3 = null;
                                        boolean b = false;
                                        Label_2643: {
                                            Label_2636: {
                                                if (this.this$0.cooking.cooking_raw.contains((Object)pickDrop2)) {
                                                    if (this.this$0.combatManager.equippedItems.contains((Object)"Barbecue Skythe")) {
                                                        s3 = (String)this.this$0.cooking.cooking_cooked.get(this.this$0.cooking.cooking_raw.indexOf((Object)pickDrop2));
                                                        this.this$0.QuickPopup("Your Skythe cooks the " + pickDrop2 + " as you catch it!");
                                                        final MainActivity this$8 = this.this$0;
                                                        this$8.GiveExp("Cooking", (long)this$8.cooking.cooking_exp.get(this.this$0.cooking.cooking_cooked.indexOf((Object)s3)), null);
                                                    }
                                                    else {
                                                        if (!this.this$0.combatManager.equippedItems.contains((Object)"Flame Gloves") || this.this$0.GetRandom(1, 100) > 2) {
                                                            break Label_2636;
                                                        }
                                                        s3 = (String)this.this$0.cooking.cooking_burnt.get(this.this$0.cooking.cooking_raw.indexOf((Object)pickDrop2));
                                                        this.this$0.QuickPopup("Your Flame Gloves burn the fish as you catch it!");
                                                    }
                                                    b = false;
                                                    break Label_2643;
                                                }
                                            }
                                            b = true;
                                            s3 = pickDrop2;
                                        }
                                        this.this$0.GiveItem(s3, n33, b);
                                        long n34 = val$exp;
                                        if (this.this$0.baseTower.baseTowerLevel >= 14) {
                                            n34 = val$exp + val$exp / 4L;
                                        }
                                        this.this$0.CheckGoldenTouch();
                                        if (this.this$0.GetRandom(1, 100) <= 5 && this.this$0.databaseManager.GetWishLevel("Silver Fish", "Beginner") >= 1) {
                                            final long n35 = this.this$0.databaseManager.GetWishLevel("Silver Fish", "Beginner") * 100L;
                                            final MainActivity this$9 = this.this$0;
                                            this$9.totalCoins += n35;
                                            this.this$0.UpdateCash();
                                            this.this$0.QuickPopup("Your Silver Fish wish finds " + n35 + " Silver");
                                        }
                                        if (this.val$method.equals((Object)"Small Pond")) {
                                            this.this$0.combatManager.CheckSecret("Old Fishing Rod", 2131166057, 1500);
                                        }
                                        if (this.val$method.equals((Object)"Cave")) {
                                            this.this$0.combatManager.CheckSecret("Rod of Anuket", 2131166165, 5000);
                                        }
                                        if (this.val$method.equals((Object)"Livingstone Island")) {
                                            this.this$0.combatManager.CheckSecret("Mystic Boots", 2131166024, 15000);
                                        }
                                        if (this.val$method.equals((Object)"Beach Pier")) {
                                            this.this$0.combatManager.CheckSecret("Necklace of Health", 2131166036, 60000);
                                        }
                                        this.this$0.dailies.UpdateDailies("Fishing", this.val$method, n32);
                                        this.this$0.treasureHunts.CheckTreasureHunts(this.val$skill, this.val$method);
                                        this.this$0.itemManager.CheckOnlineSecrets(this.val$skill, this.val$method);
                                        s = "";
                                        val$exp = n34;
                                        n6 = n;
                                        break Label_5662;
                                    }
                                    case 1: {
                                        this.this$0.CheckGoldenTouch();
                                        if (this.this$0.GetRandom(1, 100) <= 5 && this.this$0.databaseManager.GetWishLevel("Silver Trees", "Beginner") >= 1) {
                                            final long n36 = this.this$0.databaseManager.GetWishLevel("Silver Trees", "Beginner") * 100L;
                                            final MainActivity this$10 = this.this$0;
                                            this$10.totalCoins += n36;
                                            this.this$0.UpdateCash();
                                            this.this$0.QuickPopup("Your Silver Trees wish finds " + n36 + " Silver");
                                        }
                                        float floatValue;
                                        final float n37 = floatValue = (float)this.this$0.forestry.forestNestChance.get(this.this$0.forestry.forestTrees.indexOf((Object)this.val$method));
                                        int n39 = 0;
                                        Label_3220: {
                                            if (this.this$0.alchemy.activePotions.contains((Object)"Forestry Potion")) {
                                                final float n38 = floatValue = n37 + 2.0f;
                                                if (this.this$0.GetRandom(1, 100) <= 5) {
                                                    n39 = 2;
                                                    floatValue = n38;
                                                    break Label_3220;
                                                }
                                            }
                                            n39 = 1;
                                        }
                                        float n40 = floatValue;
                                        int n41 = n39;
                                        if (this.this$0.alchemy.activePotions.contains((Object)"Super Forestry Potion")) {
                                            final float n42 = n40 = floatValue + 4.0f;
                                            n41 = n39;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n41 = n39 + 1;
                                                n40 = n42;
                                            }
                                        }
                                        float n43 = n40;
                                        int n44 = n41;
                                        if (this.this$0.alchemy.activePotions.contains((Object)"Extreme Forestry Potion")) {
                                            final float n45 = n43 = n40 + 6.0f;
                                            n44 = n41;
                                            if (this.this$0.GetRandom(1, 100) <= 15) {
                                                n44 = n41 + 1;
                                                n43 = n45;
                                            }
                                        }
                                        float n46 = n43;
                                        int n47 = n44;
                                        if (this.this$0.alchemy.activePotions.contains((Object)"Ultimate Forestry Potion")) {
                                            final float n48 = n46 = n43 + 10.0f;
                                            n47 = n44;
                                            if (this.this$0.GetRandom(1, 100) <= 20) {
                                                n47 = n44 + 1;
                                                n46 = n48;
                                            }
                                        }
                                        int n49 = 0;
                                        Label_3517: {
                                            if (!this.this$0.combatManager.equippedItems.contains((Object)"Forestry Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Max Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Ultra Comp Cape")) {
                                                n49 = n47;
                                                if (!this.this$0.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                                                    break Label_3517;
                                                }
                                            }
                                            n49 = n47 + 1;
                                        }
                                        int n50 = n49;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Lofty")) {
                                            n50 = n49 + 1;
                                        }
                                        float n51;
                                        float n52;
                                        float n53;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Hatchet of the Gods")) {
                                            n50 *= 2;
                                            n51 = n46 * 2.0f;
                                            n52 = 2.0f;
                                            n53 = 0.0f;
                                        }
                                        else {
                                            n52 = 1.0f;
                                            n53 = 10.0f;
                                            n51 = n46;
                                        }
                                        float n54 = n51;
                                        float n55 = n52;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Wreath Necklace")) {
                                            n54 = n51 * 2.0f;
                                            n55 = n52 * 2.0f;
                                        }
                                        float n56 = n54;
                                        float n57 = n55;
                                        int n58 = n50;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Hatchet of Copina")) {
                                            n58 = n50 * 4;
                                            n56 = n54 * 4.0f;
                                            n57 = n55 * 4.0f;
                                            n53 = 0.0f;
                                        }
                                        float n59 = n56;
                                        float n60 = n57;
                                        int n61 = n58;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Hatchet of Copina (E)")) {
                                            n61 = n58 * 5;
                                            n59 = n56 * 5.0f;
                                            n60 = n57 * 5.0f;
                                            n53 = 0.0f;
                                        }
                                        float n62 = 0.0f;
                                        Label_3789: {
                                            if (!this.this$0.combatManager.equippedItems.contains((Object)"Rabbits Foot")) {
                                                n62 = n59;
                                                if (!this.this$0.combatManager.equippedItems.contains((Object)"Ring of Forestry")) {
                                                    break Label_3789;
                                                }
                                            }
                                            n62 = n59 * 3.0f;
                                        }
                                        int n63 = n61;
                                        if (this.this$0.baseTower.baseTowerLevel >= 37) {
                                            n63 = n61 * 2;
                                        }
                                        int n64 = n63;
                                        if (this.this$0.treasureHunts.BoostActive("New Chopper")) {
                                            n64 = n63;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n64 = n63 * 2;
                                            }
                                        }
                                        int n65 = n64;
                                        if (this.this$0.forestry.outfitPieces > 0) {
                                            n65 = n64;
                                            if (this.this$0.GetRandom(1, 100) <= this.this$0.forestry.outfitPieces * 5) {
                                                n65 = n64 * 2;
                                            }
                                        }
                                        int n66 = n65;
                                        if (this.this$0.databaseManager.weeklySkill.equals((Object)"Forestry")) {
                                            n66 = n65;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n66 = n65 * 2;
                                            }
                                        }
                                        if (this.val$method.equals((Object)"Elder Tree")) {
                                            this.this$0.combatManager.CheckSecret("Restoration Fragment 4", 2131166145, 30000);
                                        }
                                        if (this.val$method.equals((Object)"Birch Tree")) {
                                            this.this$0.combatManager.CheckSecret("Rusty Hatchet", 2131166169, 75000);
                                        }
                                        if (this.val$method.equals((Object)"Sandalwood Tree") || this.val$method.equals((Object)"Christmas Village")) {
                                            n66 = 1;
                                        }
                                        if (this.val$method.equals((Object)"Christmas Village")) {
                                            this.this$0.event.CheckHotChocolate(this.val$skill);
                                        }
                                        String s4;
                                        if (this.val$possibleDrops.size() == 1) {
                                            s4 = (String)this.val$possibleDrops.get(0);
                                        }
                                        else {
                                            try {
                                                s4 = (String)this.val$possibleDrops.get(this.this$0.randomGenerator.nextInt(this.val$possibleDrops.size()));
                                            }
                                            catch (final IndexOutOfBoundsException ex) {
                                                s4 = (String)this.val$possibleDrops.get(0);
                                            }
                                        }
                                        Label_4622: {
                                            if (n53 > 0.0f) {
                                                if (this.this$0.GetFloat(0.0f, 100.0f) <= n53) {
                                                    s = "Your axe gets stuck in the tree, but you manage to wiggle it free.";
                                                    n6 = 0;
                                                    break Label_4622;
                                                }
                                                this.this$0.dailies.UpdateDailies("Forestry", this.val$method, 1);
                                                if (this.this$0.combatManager.equippedItems.contains((Object)"Flame Gloves")) {
                                                    final MainActivity this$11 = this.this$0;
                                                    this$11.GiveExp("Firemaking", (long)this$11.forestry.forestBurnExp.get(this.this$0.forestry.forestLogs.indexOf((Object)s4)) * 2L, null);
                                                    this.this$0.QuickPopup("Your flame gloves burn your logs");
                                                }
                                                else {
                                                    this.this$0.GiveItem(s4, n66, true);
                                                }
                                                if (this.this$0.GetFloat(0.0f, 100.0f) <= n62) {
                                                    this.this$0.GiveItem("Eagles Nest", 1L, true);
                                                }
                                                if (this.this$0.GetFloat(0.0f, 100.0f) <= n60 && !this.val$method.equals((Object)"Sandalwood Tree") && !this.val$method.equals((Object)"Christmas Village")) {
                                                    this.this$0.GiveSeed(this.val$method.replace((CharSequence)"Tree", (CharSequence)"Seed"), 1L);
                                                }
                                            }
                                            else {
                                                this.this$0.dailies.UpdateDailies("Forestry", this.val$method, 1);
                                                if (this.this$0.combatManager.equippedItems.contains((Object)"Flame Gloves")) {
                                                    final MainActivity this$12 = this.this$0;
                                                    this$12.GiveExp("Firemaking", (long)this$12.forestry.forestBurnExp.get(this.this$0.forestry.forestLogs.indexOf((Object)s4)) * 2L, null);
                                                    this.this$0.QuickPopup("Your flame gloves burn your logs");
                                                }
                                                else {
                                                    this.this$0.GiveItem(s4, n66, true);
                                                }
                                                if (this.this$0.GetFloat(0.0f, 100.0f) <= n62) {
                                                    this.this$0.GiveItem("Eagles Nest", 1L, true);
                                                }
                                                if (this.this$0.GetFloat(0.0f, 100.0f) <= n60 && !this.val$method.equals((Object)"Sandalwood Tree") && !this.val$method.equals((Object)"Christmas Village")) {
                                                    this.this$0.GiveSeed(this.val$method.replace((CharSequence)"Tree", (CharSequence)"Seed"), 1L);
                                                }
                                            }
                                            s = "";
                                            n6 = 1;
                                        }
                                        this.this$0.treasureHunts.CheckTreasureHunts(this.val$skill, this.val$method);
                                        this.this$0.itemManager.CheckOnlineSecrets(this.val$skill, this.val$method);
                                        break Label_5662;
                                    }
                                    case 0: {
                                        if (this.this$0.GetRandom(1, 100) > this.this$0.mining.GetSuccessChance(this.this$0.mining.miningRocks.indexOf((Object)this.val$method)) && !this.this$0.alchemy.activePotions.contains((Object)"Mining Potion")) {
                                            s = "You missed the rock";
                                            n8 = 0;
                                            break Label_4735;
                                        }
                                        int n67;
                                        if (!this.this$0.combatManager.equippedItems.contains((Object)"Mining Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Max Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"Ultra Comp Cape") && !this.this$0.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                                            n67 = 1;
                                        }
                                        else {
                                            n67 = 2;
                                        }
                                        int n68 = n67;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Rocko")) {
                                            n68 = n67 + 1;
                                        }
                                        int n69 = n68;
                                        if (this.this$0.baseTower.baseTowerLevel >= 43) {
                                            n69 = n68 * 2;
                                        }
                                        int n70 = n69;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Pickaxe of the Gods")) {
                                            n70 = n69 * 3;
                                        }
                                        int n71 = n70;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Pickaxe of Copina")) {
                                            n71 = n70 * 4;
                                        }
                                        int n72 = n71;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Pickaxe of Copina (E)")) {
                                            n72 = n71 * 5;
                                        }
                                        int n73 = n72;
                                        if (this.this$0.combatManager.equippedItems.contains((Object)"Illuminant Gem")) {
                                            final int n74 = n73 = n72 * 3;
                                            if (this.this$0.GetRandom(1, 100) <= 1) {
                                                final MainActivity this$13 = this.this$0;
                                                ++this$13.totalGems;
                                                this.this$0.QuickPopup("Your Illuminant Gem finds a Gold Coin while Mining.");
                                                this.this$0.UpdateCash();
                                                n73 = n74;
                                            }
                                        }
                                        int n75 = n73;
                                        if (this.this$0.treasureHunts.BoostActive("New Miner")) {
                                            n75 = n73;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n75 = n73 * 2;
                                            }
                                        }
                                        int n76 = n75;
                                        if (this.this$0.mining.outfitPieces > 0) {
                                            n76 = n75;
                                            if (this.this$0.GetRandom(1, 100) <= this.this$0.mining.outfitPieces * 5) {
                                                n76 = n75 * 2;
                                            }
                                        }
                                        int n77 = n76;
                                        if (this.this$0.databaseManager.weeklySkill.equals((Object)"Mining")) {
                                            n77 = n76;
                                            if (this.this$0.GetRandom(1, 100) <= 10) {
                                                n77 = n76 * 2;
                                            }
                                        }
                                        if (this.val$method.equals((Object)"Sapphire")) {
                                            this.this$0.combatManager.CheckSecret("Rusty Pickaxe", 2131166170, 75000);
                                        }
                                        if (this.val$method.equals((Object)"Darkstar Ore")) {
                                            if (this.this$0.combatManager.equippedItems.contains((Object)"Ring of Secrets")) {
                                                this.this$0.combatManager.CheckSecret("Fragment of the Gods III", 2131165853, 75000);
                                            }
                                            n77 = 1;
                                        }
                                        if (this.val$method.equals((Object)"Christmas Village")) {
                                            this.this$0.event.CheckHotChocolate(this.val$skill);
                                            n77 = 1;
                                        }
                                        String s5;
                                        if (this.val$possibleDrops.size() == 1) {
                                            s5 = (String)this.val$possibleDrops.get(0);
                                        }
                                        else {
                                            try {
                                                s5 = (String)this.val$possibleDrops.get(this.this$0.randomGenerator.nextInt(this.val$possibleDrops.size()));
                                            }
                                            catch (final IndexOutOfBoundsException ex2) {
                                                s5 = (String)this.val$possibleDrops.get(0);
                                            }
                                        }
                                        this.this$0.GiveItem(s5, n77, true);
                                        this.this$0.CheckGoldenTouch();
                                        this.this$0.treasureHunts.CheckTreasureHunts(this.val$skill, this.val$method);
                                        if (this.val$method.equals((Object)"Emerald") && this.this$0.combatManager.equippedItems.contains((Object)"Mining Cape")) {
                                            this.this$0.combatManager.CheckSecret("Pickaxe of the Gods", 2131166066, 250000);
                                        }
                                        if (this.this$0.GetRandom(1, 900000) <= (long)this.this$0.mining.miningLocationsBaseSpeed.get(this.this$0.mining.miningRocks.indexOf((Object)this.val$method)) / 2000L) {
                                            this.this$0.LargePopup(2131165904, "Congratulations!", "While Mining you find an Illuminant Gem!");
                                            this.this$0.GiveItem("Illuminant Gem", 1L, false);
                                        }
                                        this.this$0.dailies.UpdateDailies("Mining", this.val$method, n77);
                                        this.this$0.itemManager.CheckOnlineSecrets(this.val$skill, this.val$method);
                                        break;
                                    }
                                }
                                break Label_5655;
                            }
                            n7 = 0;
                            break Label_5673;
                        }
                        s = "";
                        n6 = 1;
                    }
                    final int n78 = 0;
                    n7 = n6;
                    n8 = n78;
                }
                if (n7 != 0) {
                    this.this$0.GiveExp(this.val$skill, val$exp, null);
                    final RelativeLayout val$progressView = this.val$progressView;
                    if (val$progressView != null && val$progressView.isShown()) {
                        this.this$0.ExpBar(this.val$skill, this.val$progressView);
                    }
                }
                else {
                    this.this$0.QuickPopup(s);
                }
                if (this.val$repeat && n8 == 0) {
                    this.this$0.skillingTimer.start();
                }
                else {
                    this.this$0.skillingTimerRunning = false;
                    this.this$0.trainingSkill = "";
                    this.this$0.trainingMethod = "";
                }
            }
            
            public void onTick(final long n) {
            }
        }).start();
    }
    
    public void StartTicker() {
        this.lastTickTime = SystemClock.elapsedRealtime();
        final ScheduledExecutorService tickerExecutor = this.tickerExecutor;
        if (tickerExecutor != null && !tickerExecutor.isShutdown()) {
            this.tickerExecutor.shutdownNow();
        }
        (this.tickerExecutor = Executors.newSingleThreadScheduledExecutor()).scheduleWithFixedDelay((Runnable)new MainActivity$$ExternalSyntheticLambda9(this), 0L, 1L, TimeUnit.SECONDS);
    }
    
    public boolean StashNotFull(final String s) {
        final int baseTowerLevel = this.baseTower.baseTowerLevel;
        boolean b = false;
        if (baseTowerLevel < 75) {
            if (!this.baseTower.stashItems.contains((Object)s)) {
                if (this.baseTower.stashItems.size() >= this.baseTower.maxStash) {
                    b = true;
                }
            }
        }
        return b ^ true;
    }
    
    public boolean Ultimaxed() {
        for (final String s : this.skills) {
            if (this.GetSkillLevel(s) < this.GetSkillMaxLevel(s)) {
                return false;
            }
        }
        return true;
    }
    
    public void Unimportant() {
        final Boolean value = false;
        for (int i = 0; i < this.allItems.size(); ++i) {
            if (((String)this.allItemsTypes.get(i)).equals((Object)"Food")) {
                this.foodItems.add((Object)this.allItems.get(i));
                this.foodItemHealing.add((Object)this.allItemsHealingAmount.get(i));
            }
        }
        if (this.combatManager.equippedItems.isEmpty()) {
            Collections.addAll((Collection)this.combatManager.equippedItems, (Object[])new String[] { null, null, null, null, null, null, null, null, null, null, null, null, null });
        }
        Collections.addAll((Collection)this.combatManager.equippedItemsTypes, (Object[])new String[] { "Helm", "Gloves", "Boots", "Greaves", "Top", "Weapon", "Cape", "Blessing", "Ring", "Necklace", "Shield", "Arrows", "Pet" });
        Collections.addAll((Collection)this.combatManager.equippedItemsViews, (Object[])new ImageView[] { this.ev_helm, this.ev_gloves, this.ev_boots, this.ev_greaves, this.ev_top, this.ev_weapon, this.ev_cape, this.ev_blessing, this.ev_ring, this.ev_necklace, this.ev_shield, this.ev_arrows, this.ev_pet });
        Collections.addAll((Collection)this.equipmentPlaceholders, (Object[])new Integer[] { 2131165458, 2131165457, 2131165455, 2131165459, 2131165464, 2131165465, 2131165456, 2131165454, 2131165462, 2131165460, 2131165463, 2131165453, 2131165461 });
        if (this.combatManager.equippedItems.size() < this.combatManager.equippedItemsTypes.size()) {
            for (int size = this.combatManager.equippedItemsTypes.size(), size2 = this.combatManager.equippedItems.size(), j = 0; j < size - size2; ++j) {
                this.combatManager.equippedItems.add((Object)null);
            }
        }
        for (int k = 0; k < this.combatManager.equippedItems.size(); ++k) {
            if (this.combatManager.equippedItems.get(k) != null && !((String)this.combatManager.equippedItemsTypes.get(k)).equals((Object)"Pet")) {
                this.attackBonus += (int)this.allItemsAttackBonus.get(this.allItems.indexOf(this.combatManager.equippedItems.get(k)));
                this.strengthBonus += (int)this.allItemsStrengthBonus.get(this.allItems.indexOf(this.combatManager.equippedItems.get(k)));
                this.defenceBonus += (int)this.allItemsDefenceBonus.get(this.allItems.indexOf(this.combatManager.equippedItems.get(k)));
                this.healthBonus += (int)this.allItemsHealthBonus.get(this.allItems.indexOf(this.combatManager.equippedItems.get(k)));
            }
        }
        Collections.addAll((Collection)this.market_itemsAvailable, (Object[])new String[] { "Inventory Size", "Stash Size", "Fishing Rod Upgrade", "Auto Eat", "Tomato Seed", "Apple Seed", "Strawberry Seed", "Red Onion Seed", "Orange Seed", "Lemon Seed", "Cherries Seed", "Blueberry Seed", "Eggplant Seed", "Grapes Seed", "Energy Saver", "Crop Rows", "Attack Cape", "Strength Cape", "Defence Cape", "Health Cape", "Slayer Cape", "Fishing Cape", "Discovery Cape", "Alchemy Cape", "Farming Cape", "Crafting Cape", "Cooking Cape", "Thieving Cape", "Mining Cape", "Max Cape", "Discovery Fail Chance", "Mini Max Cape", "Completion Cape", "Ultra Comp Cape", "No Life Cape", "Forestry Cape" });
        Collections.addAll((Collection)this.market_itemCategory, (Object[])new String[] { "Inventory", "Inventory", "Skill Upgrades", "Combat", "Seeds", "Seeds", "Seeds", "Seeds", "Seeds", "Seeds", "Seeds", "Seeds", "Seeds", "Seeds", "Skill Upgrades", "Skill Upgrades", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skill Upgrades", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes", "Skillcapes" });
        Collections.addAll((Collection)this.market_itemIcon, (Object[])new Integer[] { 2131165303, 2131166321, 2131166475, 2131166477, 2131166311, 2131165534, 2131166271, 2131166133, 2131166060, 2131165957, 2131165683, 2131165612, 2131165774, 2131165888, 2131166472, 2131166473, 2131165544, 2131166272, 2131165737, 2131165894, 2131166224, 2131165834, 2131166032, 2131165528, 2131165819, 2131165715, 2131165709, 2131166306, 2131165998, 2131165986, 2131166472, 2131165997, 2131165708, 2131166332, 2131166048, 2131165845 });
        Collections.addAll((Collection)this.market_itemDescription, (Object[])new String[] { "+" + this.inventoryUpgradeAmount + " Inventory Slots", "+" + this.inventoryUpgradeAmount + " Base Stash Slots", "Increases Fishing Speed", "Automatically eats food below 50% health.", "A Level 1 Farming Seed", "A Level 10 Farming Seed", "A Level 20 Farming Seed", "A Level 30 Farming Seed", "A Level 40 Farming Seed", "A Level 50 Farming Seed", "A Level 60 Farming Seed", "A Level 70 Farming Seed", "A Level 80 Farming Seed", "A Level 90 Farming Seed", "+1% chance to not use Energy", "Adds 5 more Crop Rows", "Provides a 200 Attack bonus", "Provides a 200 Strength bonus", "Provides a 200 Defence bonus", "Provides a 400 Health bonus", "Double killcoins from Slayer tasks", "Doubles all Fish caught", "Gives an extra 2 items per explore", "Create 2 Potions instead of 1", "Doubles all Crops harvests", "Create double items", "Stop burning all food", "Removes damage taken when caught pickpocketing", "Doubles all mined ores and gems", "Provides the benefits of all capes plus extra combat stats", "Lowers expedition failure chance by 1%", "Provides the benefits of all free to play capes with extra bonuses", "Provides the benefits of all skill capes plus epic stats. Requirements: All 99s and 130s.", "Check Cape Progress in the Menu for the Requirements", "Check Cape Progress in the Menu for the Requirements", "Grants an extra log while chopping trees" });
        Collections.addAll((Collection)this.market_itemSellPrice, (Object[])new Long[] { 0L, 0L, 0L, 250000L, 10L, 20L, 30L, 40L, 50L, 60L, 70L, 80L, 90L, 100L, 5000L, 5000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 13000000L, 0L, 7500000L, 250000000L, 500000000L, 1000000000L, 1000000L });
        Collections.addAll((Collection)this.premiumUpgrades, (Object[])new String[] { "Market Discount I", "Market Discount II", "Market Discount III", "Market Discount IV", "Market Discount V", "Double Exp", "Double Fish I", "Double Fish II", "Double Fish III", "Double Potions I", "Double Potions II", "Double Potions III", "Resource Saver I", "Resource Saver II", "Resource Saver III", "Farming Timer I", "Farming Timer II", "Farming Timer III", "null", "null", "null", "Craft X", "Double Farming", "Double Drops", "Cook X", "Brew X", "Fast Combat", "Burn X", "Cancel Crops", "Fletch X" });
        Collections.addAll((Collection)this.premiumUpgradesDescriptions, (Object[])new String[] { "Reduces item costs in market by 2% (Excluding Slayer and Gold). Stackable.", "Reduces item costs in market by 5% (Excluding Slayer and Gold). Stackable.", "Reduces item costs in market by 10% (Excluding Slayer and Gold). Stackable.", "Reduces item costs in market by 15% (Excluding Slayer and Gold). Stackable.", "Reduces item costs in market by 20% (Excluding Slayer and Gold). Stackable.", "Permanently Doubles all Exp gained", "Gives a 2% Chance to catch 2 Fish instead of 1. Stackable.", "Gives a 8% Chance to catch 2 Fish instead of 1. Stackable.", "Gives a 15% Chance to catch 2 Fish instead of 1. Stackable.", "Gives a 2% Chance to make 2 Potions instead of 1. Stackable.", "Gives a 8% Chance to make 2 Potions instead of 1. Stackable.", "Gives a 15% Chance to make 2 Potions instead of 1. Stackable.", "Gives a 5% Chance to save resources when crafting items or potions. Stackable.", "Gives a 10% Chance to save resources when crafting items or potions. Stackable.", "Gives a 15% Chance to save resources when crafting items or potions. Stackable.", "Reduces Farming Timers by 5%. Stackable.", "Reduces Farming Timers by 15%. Stackable.", "Reduces Farming Timers by 30%. Stackable.", "Increases Fishing Net length (Including Large) by 1 minute.", "Increases Fishing Net length (Including Large) by 3 minutes. Stackable.", "Increases Fishing Net length (Including Large) by 6 minutes. Stackable.", "Unlock the ability to Craft more items at a time in the Workshop", "Gives a 25% chance to get double the crops from Farming", "Gives a 25% chance to double any enemy drop", "Unlock the ability to cook more items at a time in the Kitchen", "Unlock the ability to brew more potions at a time", "Halves the time it takes enemies to respawn.", "Unlocks the ability to burn more logs at one time.", "Unlocks the ability to cancel all planted crops.", "Unlocks the ability to make more arrows at one time." });
        Collections.addAll((Collection)this.premiumUpgradesCosts, (Object[])new Long[] { 30L, 60L, 100L, 200L, 400L, 1000L, 40L, 75L, 150L, 50L, 100L, 200L, 75L, 150L, 225L, 60L, 100L, 200L, 60L, 100L, 250L, 250L, 250L, 500L, 250L, 250L, 500L, 250L, 300L, 750L });
        if (this.premiumUpgradesPurchased.isEmpty()) {
            Collections.addAll((Collection)this.premiumUpgradesPurchased, (Object[])new Boolean[] { value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value, value });
        }
        if (this.premiumUpgradesPurchased.size() < this.premiumUpgrades.size()) {
            for (int size3 = this.premiumUpgrades.size(), size4 = this.premiumUpgradesPurchased.size(), l = 0; l < size3 - size4; ++l) {
                this.premiumUpgradesPurchased.add((Object)value);
            }
        }
        for (int n = 0; n < this.premiumUpgrades.size(); ++n) {
            if (!((String)this.premiumUpgrades.get(n)).equals((Object)"null")) {
                this.market_itemsAvailable.add((Object)this.premiumUpgrades.get(n));
                this.market_itemCategory.add((Object)"Spend your Gold");
                this.market_itemDescription.add((Object)this.premiumUpgradesDescriptions.get(n));
                this.market_itemSellPrice.add((Object)this.premiumUpgradesCosts.get(n));
                this.market_itemIcon.add((Object)2131165871);
            }
        }
        Collections.addAll((Collection)this.goldPurchase, (Object[])new String[] { "Bag of Gold", "Chest of Gold", "XL Gold", "Massive Gold", "Kings Gold" });
        Collections.addAll((Collection)this.goldPurchaseAmounts, (Object[])new Long[] { 10000L, 30000L, 75000L, 250000L, 750000L });
        Collections.addAll((Collection)this.goldPurchaseSkus, (Object[])new String[] { "gold_bag", "gold_chest", "xl_gold", "massive_gold", "kings_gold" });
        Collections.addAll((Collection)this.premiumChestItems, (Object[])new String[] { "25000,Coins", "1000,Thread", "500,Wood", "250,Yarn", "250,Iron", "5,Small Exp Scroll", "2,Medium Exp Scroll", "1,Large Exp Scroll", "5,Crystal Chest", "5,Crystal Key", "5,Extreme Energy Potion", "10,Super Energy Potion", "10,Large Fishing Net", "10,Luck Potion", "5,Invincibility Potion" });
    }
    
    public void UpdateAvatar() {
        try {
            Picasso.get().load((int)this.avatarIcons.get((int)this.myProfileAvatars.get(this.activeAvatar))).into(this.profileAvatar);
        }
        catch (final IndexOutOfBoundsException ex) {
            this.profileAvatar.setImageDrawable((Drawable)null);
        }
    }
    
    public void UpdateBottomNav() {
        final String string = this.getString(2131820640, new Object[] { this.currentHealth, this.maxHealth });
        if (!this.quickHealthStat.getText().toString().equals((Object)string)) {
            this.quickHealthStat.setText((CharSequence)string);
        }
        final boolean empty = this.equippedFood.isEmpty();
        int i = 0;
        if (empty) {
            while (i < this.quickFoodView.getChildCount()) {
                this.HideView(this.quickFoodView.getChildAt(i));
                ++i;
            }
        }
        else {
            for (int j = 0; j < this.quickFoodView.getChildCount(); ++j) {
                this.ShowView(this.quickFoodView.getChildAt(j));
            }
            Picasso.get().load((int)this.allItemsIcons.get(this.allItems.indexOf((Object)this.equippedFood))).into((ImageView)this.quickFoodView.getChildAt(0));
            String formatExp;
            if (this.inventoryItems.contains((Object)this.equippedFood)) {
                formatExp = this.FormatExp((long)this.inventoryAmounts.get(this.inventoryItems.indexOf((Object)this.equippedFood)));
            }
            else {
                formatExp = "0";
            }
            if (!((TextView)this.quickFoodView.getChildAt(1)).getText().toString().equals((Object)formatExp)) {
                ((TextView)this.quickFoodView.getChildAt(1)).setText((CharSequence)formatExp);
            }
        }
        if (this.holidayEventAvailable) {
            ((TextView)this.eventCurrencyWrap.getChildAt(1)).setText((CharSequence)this.FormatCoins(this.holidayCurrency));
        }
    }
    
    public void UpdateCash() {
        final String formatCoins = this.FormatCoins(this.totalCoins);
        final String formatCoins2 = this.FormatCoins(this.totalGems);
        final String formatCoins3 = this.FormatCoins(this.combatManager.slayerInfo.getKillcoins());
        if (!this.coins.getText().toString().equals((Object)formatCoins)) {
            this.coins.setText((CharSequence)formatCoins);
        }
        if (!this.gems.getText().toString().equals((Object)formatCoins2)) {
            this.gems.setText((CharSequence)formatCoins2);
        }
        if (!this.killcoins.getText().toString().equals((Object)formatCoins3)) {
            this.killcoins.setText((CharSequence)formatCoins3);
        }
    }
    
    public void UpdateDev(final String s) {
        this.runOnUiThread((Runnable)new MainActivity$$ExternalSyntheticLambda51(this, s));
    }
    
    public void UpdateEquipment() {
        final TextView textView = (TextView)this.findViewById(2131296599);
        if (this.equippedFood.isEmpty()) {
            textView.setText((CharSequence)"Click here to equip some food");
        }
        else {
            try {
                textView.setText((CharSequence)("Food Equipped: " + this.equippedFood + " (" + this.FormatExp((long)this.inventoryAmounts.get(this.inventoryItems.indexOf((Object)this.equippedFood))) + ")"));
            }
            catch (final IndexOutOfBoundsException ex) {
                textView.setText((CharSequence)("Food Equipped: " + this.equippedFood + " (None left)"));
            }
        }
        for (int i = 0; i < this.combatManager.equippedItems.size(); ++i) {
            if (this.combatManager.equippedItems.get(i) != null) {
                if (((String)this.combatManager.equippedItemsTypes.get(i)).equals((Object)"Pet")) {
                    if (this.skillingPets.contains(this.combatManager.equippedItems.get(i))) {
                        Picasso.get().load((int)this.skillingPetsIcons.get(this.skillingPets.indexOf(this.combatManager.equippedItems.get(i)))).into((ImageView)this.combatManager.equippedItemsViews.get(i));
                    }
                    else {
                        Picasso.get().load((int)this.specialPetsIcons.get(this.specialPets.indexOf(this.combatManager.equippedItems.get(i)))).into((ImageView)this.combatManager.equippedItemsViews.get(i));
                    }
                }
                else {
                    Picasso.get().load((int)this.allItemsIcons.get(this.allItems.indexOf(this.combatManager.equippedItems.get(i)))).into((ImageView)this.combatManager.equippedItemsViews.get(i));
                }
            }
            else {
                Picasso.get().load((int)this.equipmentPlaceholders.get(i)).into((ImageView)this.combatManager.equippedItemsViews.get(i));
            }
        }
        final LinearLayout linearLayout = (LinearLayout)this.equipmentScreen.findViewById(2131296596);
        for (int j = 0; j < 4; ++j) {
            Picasso.get().load((new int[] { 2131166468, 2131166480, 2131166471, 2131166477 })[j]).into((ImageView)((LinearLayout)linearLayout.getChildAt(j)).getChildAt(0));
        }
        this.UpdateEquipmentStats();
    }
    
    public void UpdateEventCurrency() {
        if (this.holidayEventAvailable) {
            this.eventCurrencyWrap.setAlpha(1.0f);
            final String formatExp = this.FormatExp(this.holidayCurrency);
            if (!((TextView)this.eventCurrencyWrap.getChildAt(1)).getText().toString().equals((Object)formatExp)) {
                ((TextView)this.eventCurrencyWrap.getChildAt(1)).setText((CharSequence)formatExp);
            }
            ((ImageView)this.eventCurrencyWrap.getChildAt(0)).setImageDrawable(this.GetImage((int)this.eventIcons.get(this.eventCurrecies.indexOf((Object)this.currentHolidayCurrency))));
        }
        else {
            this.eventCurrencyWrap.setAlpha(0.0f);
        }
    }
    
    public void UpdateMaxHealth() {
        final int n = this.GetSkillLevel("Health") + this.healthBonus;
        this.maxHealth = n;
        if (this.currentHealth >= n) {
            this.currentHealth = n;
        }
        this.UpdateBottomNav();
        final String string = this.getString(2131820639, new Object[] { this.currentHealth, this.maxHealth });
        if (!this.myHealth.getText().toString().equals((Object)string)) {
            this.myHealth.setText((CharSequence)string);
        }
        this.myHealthBar.setMax(this.maxHealth);
    }
    
    public void UpdateSettings() {
        final LinearLayout linearLayout = (LinearLayout)((LinearLayout)this.settingsScreen.getChildAt(0)).getChildAt(2);
        if (this.databaseManager.UnlockedTrade() && this.gpSignedIn) {
            this.ShowView((View)linearLayout);
            if (this.referringFriend.isEmpty()) {
                this.settingsTradeName.setText((CharSequence)("Your trade name will be: " + this.playGamesUser));
            }
            else {
                this.settingsTradeName.setText((CharSequence)("Your trade name will be: " + this.playGamesUser + "\nYou were referred by: " + this.referringFriend));
            }
            this.HideView((View)this.settingsError);
            if (this.databaseManager.firebaseUser != null) {
                this.HideView((View)this.settingsInformation);
                this.settingsCreateAccount.setText((CharSequence)"Signed in");
                if (this.databaseManager.firebaseUser.getDisplayName() != null) {
                    if (this.referringFriend.isEmpty()) {
                        this.settingsTradeName.setText((CharSequence)("Your trade name is: " + this.databaseManager.firebaseUser.getDisplayName()));
                    }
                    else {
                        this.settingsTradeName.setText((CharSequence)("Your trade name is: " + this.databaseManager.firebaseUser.getDisplayName() + "\nYou were referred by: " + this.referringFriend));
                    }
                }
                this.ShowView((View)this.openReferralStore);
                this.openReferralStore.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda145(this));
            }
            else {
                this.ShowView((View)this.settingsInformation);
                this.HideView((View)this.openReferralStore);
                this.settingsCreateAccount.setText((CharSequence)"Create Grove Online Account");
                this.settingsCreateAccount.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda146(this));
            }
        }
        else {
            this.HideView((View)linearLayout);
        }
    }
    
    public String formatDateWithSuffix(final long n) {
        final Date date = new Date(n);
        return this.getDayWithSuffix(Integer.parseInt(new SimpleDateFormat("d", Locale.UK).format(date))) + " " + new SimpleDateFormat("MMMM yyyy", Locale.UK).format(date);
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
    }
    
    public void onBackPressed() {
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492893);
        this.mainView = (RelativeLayout)this.findViewById(2131296802);
        this.getWindow().setFlags(16777216, 16777216);
        this.firebaseAnalytics = FirebaseAnalytics.getInstance((Context)this);
        PlayGamesSdk.initialize((Context)this);
        this.combatManager = new CombatManager(this);
        this.dailies = new Dailies(this);
        this.treasureHunts = new TreasureHunts(this);
        this.itemManager = new ItemManager(this);
        this.alchemy = new Alchemy(this);
        this.discovery = new Discovery(this);
        this.crafting = new Crafting(this);
        this.fletching = new Fletching(this);
        this.cooking = new Cooking(this);
        this.fishing = new Fishing(this);
        this.thieving = new Thieving(this);
        this.farming = new Farming(this);
        this.quests = new Quests(this);
        this.baseTower = new BaseTower(this);
        this.mining = new Mining(this);
        this.market = new MarketManager(this);
        this.databaseManager = new DatabaseManager(this);
        this.event = new Event(this);
        this.secretPathway = new SecretPathway(this, this.databaseManager);
        this.event.lastCrackerTime = System.currentTimeMillis();
        this.event.currencyTime = System.currentTimeMillis();
        this.white = this.GetColour(2131034924);
        this.faded = this.GetColour(2131034225);
        this.inflater = LayoutInflater.from((Context)this);
        this.Load();
    }
    
    protected void onDestroy() {
        if (this.gameLoaded && this.loginScreen.getVisibility() == 8) {
            this.Save(true);
        }
        final ExecutorService backgroundExecutor = this.backgroundExecutor;
        if (backgroundExecutor != null) {
            backgroundExecutor.shutdownNow();
        }
        super.onDestroy();
    }
    
    protected void onPause() {
        if (this.gameLoaded && this.loginScreen.getVisibility() == 8) {
            this.Save(true);
        }
        super.onPause();
        if (this.inCombat) {
            this.myAttackTimer.cancel();
            this.enemyAttackTimer.cancel();
            this.attackSpeedBar.setProgress(0);
            this.combatManager.CollectLoot();
            this.inCombat = false;
            this.GoHome();
        }
    }
    
    public void onPurchasesUpdated(final BillingResult billingResult, final List<Purchase> list) {
        if (billingResult.getResponseCode() == 0 && list != null) {
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                this.HandlePurchase((Purchase)iterator.next());
            }
        }
    }
    
    protected void onResume() {
        super.onResume();
    }
    
    protected void onStart() {
        super.onStart();
    }
    
    protected void onStop() {
        super.onStop();
    }
    
    public static class Statistic
    {
        List<Long> allMonsterKills;
        long casketsOpened;
        long empyreonSafesCracked;
        long energyUsed;
        long godItemsFound;
        long itemsCrafted;
        long safesCracked;
        long scrollsCompleted;
        long secretsFound;
        long secretsFoundFull;
        
        public Statistic(final List<Long> allMonsterKills, final long secretsFound, final long secretsFoundFull, final long itemsCrafted, final long energyUsed, final long scrollsCompleted, final long casketsOpened, final long godItemsFound, final long empyreonSafesCracked, final long safesCracked) {
            this.allMonsterKills = allMonsterKills;
            this.secretsFound = secretsFound;
            this.secretsFoundFull = secretsFoundFull;
            this.itemsCrafted = itemsCrafted;
            this.energyUsed = energyUsed;
            this.scrollsCompleted = scrollsCompleted;
            this.casketsOpened = casketsOpened;
            this.godItemsFound = godItemsFound;
            this.empyreonSafesCracked = empyreonSafesCracked;
            this.safesCracked = safesCracked;
        }
        
        public void addCasketOpened(final int n) {
            this.casketsOpened += n;
        }
        
        public void addEnergyUsed(final int n) {
            this.energyUsed += n;
        }
        
        public void addGodItemFound(final int n) {
            this.godItemsFound += n;
        }
        
        public void addItemCrafted(final int n) {
            this.itemsCrafted += n;
        }
        
        public void addKill(final int n) {
            final List<Long> allMonsterKills = this.allMonsterKills;
            allMonsterKills.set(n, (Object)((long)allMonsterKills.get(n) + 1L));
        }
        
        public void addScrollCompleted(final int n) {
            this.scrollsCompleted += n;
        }
        
        public void addSecret(final int n) {
            this.secretsFound += n;
        }
        
        public void addSecretFull(final int n) {
            this.secretsFoundFull += n;
        }
        
        public List<Long> getAllMonsterKills() {
            return this.allMonsterKills;
        }
        
        public long getCasketsOpened() {
            return this.casketsOpened;
        }
        
        public long getEmpyreonSafesCracked() {
            return this.empyreonSafesCracked;
        }
        
        public long getEnergyUsed() {
            return this.energyUsed;
        }
        
        public long getGodItemsFound() {
            return this.godItemsFound;
        }
        
        public long getItemsCrafted() {
            return this.itemsCrafted;
        }
        
        public long getSafesCracked() {
            return this.safesCracked;
        }
        
        public long getScrollsCompleted() {
            return this.scrollsCompleted;
        }
        
        public long getSecretsFound() {
            return this.secretsFound;
        }
    }
}
