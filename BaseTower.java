package uk.playdrop.cherrytree_idletextrpg;

import android.widget.ProgressBar;
import java.util.Collections;
import java.util.function.Function;
import java.util.Comparator;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.View$OnClickListener;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.squareup.picasso.Picasso;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.ImageView;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import android.widget.ScrollView;

public class BaseTower
{
    MainActivity activity;
    ScrollView baseCamp;
    List<String> baseTowerBenefit;
    List<String> baseTowerItemsRequired;
    int baseTowerLevel;
    String baseTowerName;
    List<String> baseTowerRewards;
    List<String> baseTowerSkillsRequired;
    TextView bc_completed;
    TextView bc_currentLevel;
    LinearLayout bc_itemsRequired;
    TextView bc_levelreward;
    ConstraintLayout bc_nextLevel;
    TextView bc_seeMore;
    int hiddenBonuses;
    int maxStash;
    List<String> myTreestones;
    TextView organiseStash;
    int rowSize;
    int selectedItem;
    boolean sortMode;
    List<Long> stashAmounts;
    int stashItemSize;
    List<String> stashItems;
    TextView stashOpenInventory;
    LinearLayout stashScreen;
    List<RelativeLayout> stashViews;
    GridLayout stashWrap;
    List<Long> tempStashAmounts;
    List<String> tempStashItems;
    
    public BaseTower(final MainActivity activity) {
        this.baseTowerName = "";
        this.baseTowerLevel = 0;
        this.baseTowerBenefit = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Gives a permanent hidden +25 Bonus to all combat stats (Stackable)", "Gain 1 Extra item from exploring (Stacks with Discovery Cape)", "Doubles all potions made (Stacks with Premium Upgrades)", "Permanently halves the cost of changing your class", "Unlocks the Treestone of Space which gives access to the base tower stash, a secondary upgradable inventory with 25 starting spaces", "Gives a permanent hidden +25 Bonus to all combat stats (Stackable)", "Doubles all Fish caught (Works with Nets and stacks with Premium Upgrades)", "Doubles all crop harvests (Stacks with Premium Upgrades)", "Permanently doubles all experience gained in Discovery (Stacks with Premium Upgrades)", "Unlocks the Treestone of Time which doubles the duration of potions", "Gives a permanent hidden +25 Bonus to all combat stats (Stackable)", "Unlocks an Alter at your Base Tower which you can use to heal yourself at anytime", "Permanently doubles all experience gained in Farming (Stacks with Premium Upgrades)", "Permanently doubles all experience gained in Fishing (Stacks with Premium Upgrades and Potions)", "Unlocks the Treestone of Mind which gives a permanent ability to choose your own Slayer task", "Gives a permanent hidden +25 Bonus to all combat stats (Stackable)", "Permanently doubles all experience gained in Crafting (Stacks with Premium Upgrades)", "Doubles all crafting items made (Stacks with Premium Upgrades)", "Permanently doubles all experience gained in Health (Stacks with Premium Upgrades)", "Unlocks the Treestone of Soul which gives a permanent 10% chance to heal 100% of any damage taken", "Gives a permanent hidden +50 Bonus to all combat stats (Stackable)", "Permanently doubles all experience gained in Cooking (Stacks with Premium Upgrades)", "Permanently doubles all experience gained in Alchemy (Stacks with Premium Upgrades)", "Permanently doubles all experience gained in Attack (Stacks with Premium Upgrades)", "Unlocks the Treestone of Reality which gives a permanent 25% chance to double all monster drops", "Gives a permanent hidden +100 Bonus to all combat stats (Stackable)", "Permanently doubles all experience gained in Defence (Stacks with Premium Upgrades)", "Permanently doubles all experience gained in Strength (Stacks with Premium Upgrades)", "Permanently doubles all experience gained in Slayer (Stacks with Premium Upgrades)", "Unlocks the Treestone of Power which gives a permanent 150% damage bonus", "Permanently doubles all experience gained in Mining (Stacks with Premium Upgrades)", "Gives a permanent hidden +100 Bonus to all combat stats (Stackable)", "Increases the max upgradable inventory by 20 spaces", "Permanently doubles all experience gained in Thieving (Stacks with Premium Upgrades)", "Loot from Combat is automatically collected upon death, instead of lost", "Gives a permanent hidden +150 Bonus to all combat stats (Stackable)", "Doubles all Logs gained from Forestry", "Permanently doubles all experience gained in Forestry (Stacks with Premium Upgrades)", "Gives a permanent hidden +150 Bonus to all combat stats (Stackable)", "Increases the max upgradable inventory by 20 spaces", "Gives a permanent hidden +200 Bonus to all combat stats (Stackable)", "Permanently doubles all experience gained in Firemaking (Stacks with Premium Upgrades)", "Doubles all ores gained from Mining", "Doubles all coins gained from Thieving", "Grants a permanent 20% damage reduction", "Gives a permanent hidden +250 Bonus to all combat stats (Stackable)", "Increases the max upgradable inventory by 20 spaces", "Grants a permanent 10% chance to reflect damage back to the enemy when hit", "Doubles the duration of Potions (Stackable with previous upgrades)", "Gives a permanent +500 Bonus to all combat stats (Stackable)", "Increases Damage by 10% when using Archery", "Permanently grants a 10% chance to find double Ring Fragments while Crafting", "Gives a permanent +250 Bonus to all combat stats (Stackable)", "Increases the daily trade cap by 25", "Gives a permanent +250 Bonus to all combat stats (Stackable)", "Gives a permanent 20% increased chance to find Soul Gems", "Lowers the amount of Enhancement Tickets required for items by 20% (Rounds down)", "Grants a permanent 20% chance to double all cooked food (Stacks with the Chefs Hat)", "Gives a permanent +250 Bonus to all combat stats (Stackable)", "Permanently increases Attack speed by 20%", "Completing all your Daily Challenges also rewards 50 Treasure Caskets", "Increases the damage cap to 800k", "Grants a permanent 25% chance to save Potions when drinking them", "Reduces incoming damage by 15% when fighting in the Kingdom of the Gods", "Increases the chance of finding Secret Rares by 5% (Stacks with Wishes)", "Permanently lowers enemy spawn times by 20%", "Drinking Energy, Super Energy or Extreme Energy Potions provides double the usual energy", "Gives a permanent 20% chance to find double Soul Gems (Stacks with Ring of Souls)", "Permanently reduces the amount of monsters assigned by Slayer Masters by 20%", "Increases the damage cap to 1m", "Removes Stone from the Treasure Casket drop table, permanently increasing the rate of Gods Items", "Increases drop rate of Treasure Scrolls by 20%", "Gives an extra Challenge Coin for each Daily Challenge you complete", "Treasure Scrolls now convert to Caskets at a rate of 2:1 instead of 3:1", "Grants you the power of Sleepless storage, giving your Tower Stash unlimited spaces." }));
        this.baseTowerItemsRequired = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Coins,10000/Wood,200/Thread,500", "Coins,20000/Hide,500/Iron,250", "Coins,30000/Yarn,250/Barrel,200", "Coins,40000/Attack Potion,200/Waterskin,100", "Coins,50000/Gold Coin,15/Thread,1000", "Coins,60000/Strength Potion,250/Coin Purse,100", "Coins,70000/Perch,250/Raw Perch,250", "Coins,80000/Red Onion,100/Strawberry,100", "Coins,90000/Steel Bar,200/Wood,300", "Coins,100000/Gold Coin,30/Energy Potion,300", "Coins,200000/Super Defence Potion,200/Hammer,100", "Coins,300000/Crab,500/Raw Crab,500", "Coins,400000/Lemon,250/Red Onion,250", "Coins,500000/Clownfish,500/Raw Clownfish,500", "Coins,1000000/Gold Coin,45/Yarn,2000", "Coins,1500000/Super Defence Potion,500/Raft,200", "Coins,2000000/Diary,100/Notebook,100", "Coins,2500000/Anchor,100/Fish Hook,200", "Coins,3000000/Jellyfish,200/Super Forestry Potion,100", "Coins,5000000/Gold Coin,60/Mithril Bar,500", "Coins,6000000/Super Strength Potion,500/Super Defence Potion,500", "Coins,7000000/Pufferfish,500/Raw Pufferfish,500", "Coins,8000000/Extreme Energy Potion,300/Crate,250", "Coins,9000000/Workbench,250/Rope,1000", "Coins,10000000/Gold Coin,75/Dragon Leather,500", "Coins,15000000/Extreme Attack Potion,750/Extreme Defence Potion,750", "Coins,20000000/Extreme Defence Potion,750/Mithril Top,200", "Coins,25000000/Extreme Strength Potion,500/Mithril Axe,250", "Coins,30000000/Bestiary,500/Extreme Forestry Potion,250", "Coins,100000000/Gold Coin,100/Extreme Strength Potion,500", "Coins,120000000/Blue Shrimp,5000/Blue Crab,5000", "Coins,140000000/Coin Purse,1000", "Coins,160000000/Extreme Energy Potion,2000", "Coins,180000000/Lightning Potion,1000/Dragon Rider Greaves,1000", "Coins,200000000/Blueberry,10000/Cedar Log,2500", "Coins,220000000/Super Power Stone,5/Elder Log,5000", "Coins,240000000/Crystal Chest,2000/Crystal Key,2000", "Coins,260000000/Blue Thread,25000/Redwood Log,5000", "Coins,280000000/Golden Necklace,500/Fish Soup,2500", "Coins,300000000/Gold Coin,150/Ember Fern,5000", "Coins,350000000/Sunburst Flower,10000/Fish Steak,2500", "Coins,400000000/Rock Skin Potion,500/Bone Stew,3000", "Coins,450000000/Liquid Death Potion,500/Thieving Potion,2500", "Coins,500000000/Mahogany Log,5000/Cherry Blossom Log,5000", "Coins,550000000/Gold Coin,200/Coin Purse,10000", "Coins,600000000/Mushroom Soup,5000/Mahogany Log,7500", "Coins,650000000/Ultimate Power Potion,2500/Extreme Power Potion,4000", "Coins,700000000/Dragon Skull,1000/Dragon Tail,1000", "Coins,750000000/Coin Purse,10000/Crab Soup,10000", "Coins,1000000000/Invincibility Potion,2500/Golden Touch Potion,2500", "Coins,1100000000/Gold Coin,10000/Ring Fragments,500", "Coins,1200000000/Necromancer Top,50/Necromancer Greaves,50", "Coins,1300000000/Mystic Robe,25/Mystic Bottoms,25", "Coins,1400000000/Scythe of Demeter,10/Restoration Fragment 4,10", "Coins,1500000000/Gold Coin,25000/Ancient Elven Book,5", "Coins,1600000000/Challenger Boots,2/Challenger Gloves,2", "Coins,1700000000/Drakes Diary,15/Elven Grace Potion,15000", "Coins,1800000000/Ring Fragments,1000/Barbarian Top,50", "Coins,1900000000/Challenger Hat,2/Burnt Lobster,10000", "Coins,2000000000/Gold Coin,100000/Eternal Ring,5", "Coins,2000000000/Large Exp Scroll,250/Necklace of Health,10", "Coins,2000000000/Challenger Legs,2/Challenger Top,2", "Coins,2000000000/Ring Fragments,2000/Ring of Renewal,25", "Coins,2000000000/Primal Gloves,2/Primal Boots,2", "Coins,2000000000/Gold Coin,500000/Chefs Hat,5", "Coins,2000000000/Primal Legs,2/Primal Top,2", "Coins,2000000000/Ring of Life,20/Ring of Death,20", "Coins,2000000000/Ring Fragments,2500/Wooden Stick,5", "Coins,2000000000/Blessed Eternal Sacrifice,5/Goblin Cleaver,50", "Coins,2000000000/Gold Coin,1000000/Cognium Ring,2", "Coins,2000000000/Necklace of Amaran,1/Mystic Staff (E),1", "Coins,2000000000/Hatchet of the Gods,10/Rabbits Foot,25", "Coins,2000000000/Burnt Shrimp,25000/Burnt Snail,25000", "Coins,2000000000/Ring Fragments,5000/Ring of Souls (E),1", "Coins,2000000000/Gold Coin,5000000/Eternal Berserker Ring,10" }));
        this.baseTowerSkillsRequired = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Fishing,25/Alchemy,25/Discovery,25", "Farming,25/Crafting,25/Cooking,25", "Fishing,30/Alchemy,30/Discovery,30", "Farming,30/Crafting,30/Cooking,30", "Fishing,35/Alchemy,35/Discovery,35", "Farming,35/Crafting,35/Cooking,35", "Fishing,40/Alchemy,40/Discovery,40", "Farming,40/Crafting,40/Cooking,40", "Fishing,45/Alchemy,45/Discovery,45", "Farming,45/Crafting,45/Cooking,45", "Fishing,50/Alchemy,50/Discovery,50", "Farming,50/Crafting,50/Cooking,50", "Fishing,55/Alchemy,55/Discovery,55", "Farming,55/Crafting,55/Cooking,55", "Fishing,60/Alchemy,60/Discovery,60", "Farming,60/Crafting,60/Cooking,60", "Fishing,65/Alchemy,65/Discovery,65", "Farming,65/Crafting,65/Cooking,65", "Fishing,70/Alchemy,70/Discovery,70", "Farming,70/Crafting,70/Cooking,70", "Fishing,75/Alchemy,75/Discovery,75", "Farming,75/Crafting,75/Cooking,75", "Fishing,80/Alchemy,80/Discovery,80", "Farming,80/Crafting,80/Cooking,80", "Fishing,85/Alchemy,85/Discovery,85", "Farming,85/Crafting,85/Cooking,85", "Fishing,90/Alchemy,90/Discovery,90", "Farming,90/Crafting,90/Cooking,90", "Fishing,95/Alchemy,95/Discovery,95", "Farming,95/Crafting,95/Cooking,95", "Fishing,99/Alchemy,99/Discovery,99", "Farming,99/Crafting,99/Cooking,99", "Attack,99/Strength,99/Defence,99", "Alchemy,105/Cooking,105/Farming,105", "Forestry,105/Firemaking,105/Crafting,105", "Alchemy,108/Cooking,108/Farming,108", "Forestry,108/Firemaking,108/Crafting,108", "Alchemy,110/Cooking,110/Farming,110", "Forestry,110/Firemaking,110/Crafting,110", "Alchemy,112/Cooking,112/Farming,112", "Forestry,112/Firemaking,112/Crafting,112", "Alchemy,115/Cooking,115/Farming,115", "Forestry,115/Firemaking,115/Crafting,115", "Alchemy,118/Cooking,118/Farming,118", "Forestry,118/Firemaking,118/Crafting,118", "Alchemy,120/Cooking,120/Farming,120", "Forestry,120/Firemaking,120/Crafting,120", "Alchemy,125/Cooking,125/Farming,125", "Forestry,125/Firemaking,125/Crafting,125", "Alchemy,130/Cooking,130/Farming,130", "Forestry,130/Firemaking,130/Crafting,130", "Slayer,99", "Slayer,110", "Slayer,120", "Slayer,130", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null" }));
        this.baseTowerRewards = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Item,Small Exp Scroll,1", "Item,Small Exp Scroll,1", "Item,Small Exp Scroll,1", "Item,Small Exp Scroll,1", "Item,Small Exp Scroll,1", "Item,Small Exp Scroll,2", "Item,Small Exp Scroll,2", "Item,Small Exp Scroll,2", "Item,Small Exp Scroll,2", "Item,Small Exp Scroll,2", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,2", "Item,Medium Exp Scroll,2", "Item,Medium Exp Scroll,2", "Item,Medium Exp Scroll,2", "Item,Medium Exp Scroll,2", "Item,Large Exp Scroll,1", "Item,Large Exp Scroll,1", "Item,Large Exp Scroll,1", "Item,Large Exp Scroll,1", "Item,Large Exp Scroll,1", "Item,Large Exp Scroll,2", "Item,Large Exp Scroll,2", "Item,Large Exp Scroll,3", "Item,Large Exp Scroll,4", "Item,Large Exp Scroll,5", "Item,Large Exp Scroll,6", "Item,Large Exp Scroll,7", "Item,Large Exp Scroll,8", "Item,Large Exp Scroll,9", "Item,Large Exp Scroll,10", "Item,Queens Armour Fragment,10", "Item,Queens Armour Fragment,10", "Item,Queens Armour Fragment,10", "Item,Queens Armour Fragment,10", "Item,Queens Armour Fragment,10", "Item,Queens Weapon Fragment,5", "Item,Queens Weapon Fragment,10", "Item,Queens Weapon Fragment,15", "Item,Queens Weapon Fragment,20", "Item,Queens Weapon Fragment,25", "Item,Kings Weapon Fragment,2", "Item,Kings Weapon Fragment,5", "Item,Kings Weapon Fragment,10", "Item,Kings Weapon Fragment,25", "Item,Kings Weapon Fragment,50", "Item,Challenge Coins,20", "Item,Enhancement Ticket,5", "Item,Soul Gem,50", "Item,Casket of Treasure,100", "Item,Challenge Coins,20", "Item,Enhancement Ticket,5", "Item,Massive Exp Scroll,1", "Item,Casket of Treasure,100", "Item,Elven Weapon Fragment,100", "Item,Challenge Coins,20", "Item,Enhancement Ticket,5", "Item,Soul Gem,50", "Item,Elven Weapon Fragment,100", "Item,Massive Exp Scroll,1", "Item,Casket of Treasure,250", "Item,Elven Armour Fragment,500", "Item,Elven Weapon Fragment,100", "Item,Soul Gem,50", "Item,Massive Exp Scroll,5", "Item,Casket of Treasure,250", "Item,Elven Weapon Fragment,500", "Item,Soul Gem,100", "Item,Massive Exp Scroll,5", "Item,Casket of Treasure,1000", "Item,Casket of Treasure,5000" }));
        this.myTreestones = (List<String>)new ArrayList();
        this.stashItems = (List<String>)new ArrayList();
        this.stashAmounts = (List<Long>)new ArrayList();
        this.maxStash = 25;
        this.stashItemSize = 0;
        this.hiddenBonuses = 0;
        this.stashViews = (List<RelativeLayout>)new ArrayList();
        this.rowSize = 5;
        this.sortMode = false;
        this.selectedItem = -1;
        this.tempStashItems = (List<String>)new ArrayList();
        this.tempStashAmounts = (List<Long>)new ArrayList();
        this.activity = activity;
    }
    
    private void GenerateStash() {
        this.stashWrap.removeAllViews();
        this.stashWrap.setColumnCount(this.rowSize);
        this.stashViews.clear();
        int n = this.maxStash;
        if (this.baseTowerLevel >= 75) {
            n = this.stashItems.size();
        }
        for (int i = 0; i < n; ++i) {
            final RelativeLayout relativeLayout = new RelativeLayout((Context)this.activity);
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(this.activity.itemManager.inventItemSize, this.activity.itemManager.inventItemSize);
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
            if (this.stashItems.size() > i) {
                if ((long)this.stashAmounts.get(i) >= 2000000000L) {
                    this.stashAmounts.set(i, (Object)2000000000L);
                }
                final ImageView imageView = new ImageView((Context)this.activity);
                final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(this.activity.itemManager.inventImageSize, this.activity.itemManager.inventImageSize);
                layoutParams2.addRule(13);
                imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                imageView.setAdjustViewBounds(true);
                final int intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.stashItems.get(i)));
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
                textView.setText((CharSequence)this.activity.FormatCoins((long)this.stashAmounts.get(i)));
                relativeLayout.addView((View)textView);
            }
            this.stashWrap.addView((View)relativeLayout);
            this.stashViews.add((Object)relativeLayout);
            relativeLayout.setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda11(this, relativeLayout, i));
        }
    }
    
    private void HideRequirements() {
        for (int i = 0; i < this.bc_itemsRequired.getChildCount(); ++i) {
            this.activity.HideView(this.bc_itemsRequired.getChildAt(i));
        }
    }
    
    private void UpdateBaseCamp() {
        if (this.baseTowerLevel >= 75) {
            this.activity.HideView((View)this.bc_nextLevel);
            this.activity.ShowView((View)this.bc_completed);
        }
        else {
            this.activity.ShowView((View)this.bc_nextLevel);
            this.activity.HideView((View)this.bc_completed);
            this.bc_currentLevel.setText((CharSequence)String.valueOf(this.baseTowerLevel + 1));
            if (((String)this.baseTowerBenefit.get(this.baseTowerLevel)).equals((Object)"null")) {
                this.bc_levelreward.setText((CharSequence)"No benefit at this level, sorry! Keep on climbing!");
            }
            else {
                this.bc_levelreward.setText((CharSequence)this.baseTowerBenefit.get(this.baseTowerLevel));
            }
            this.bc_seeMore.setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda8(this));
            this.HideRequirements();
            this.UpdateRequirements();
        }
    }
    
    private void UpdateRequirements() {
        final String[] split = ((String)this.baseTowerItemsRequired.get(this.baseTowerLevel)).split("\\s*/\\s*");
        for (int i = 0; i < split.length; ++i) {
            this.activity.ShowView(this.bc_itemsRequired.getChildAt(i));
            final LinearLayout linearLayout = (LinearLayout)this.bc_itemsRequired.getChildAt(i);
            final String[] split2 = split[i].split("\\s*,\\s*");
            final ImageView imageView = (ImageView)linearLayout.getChildAt(0);
            final MainActivity activity = this.activity;
            imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)split2[0]))));
            ((TextView)linearLayout.getChildAt(1)).setText((CharSequence)split2[0]);
            ((TextView)linearLayout.getChildAt(2)).setText((CharSequence)("x" + this.activity.FormatExp(Long.parseLong(split2[1]))));
        }
    }
    
    public List<ItemManager$Item> CreateItemList() {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < this.stashItems.size(); ++i) {
            ((List)list).add((Object)new ItemManager$Item((String)this.stashItems.get(i), (long)this.stashAmounts.get(i), false, i));
        }
        return (List<ItemManager$Item>)list;
    }
    
    public void LoadTowerJob(final int n) {
        if (this.activity.quests.singleQuestScreen == null) {
            this.activity.quests.singleQuestScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297125)).inflate();
            this.activity.quests.singleQuestScreen = (ScrollView)this.activity.findViewById(2131297124);
            this.activity.quests.llItems = (LinearLayout)this.activity.quests.singleQuestScreen.findViewById(2131297016);
            this.activity.quests.llSkills = (LinearLayout)this.activity.quests.singleQuestScreen.findViewById(2131297018);
            this.activity.quests.llRewards = (LinearLayout)this.activity.quests.singleQuestScreen.findViewById(2131297017);
            this.activity.quests.qvComplete = (TextView)this.activity.quests.singleQuestScreen.findViewById(2131297015);
            this.activity.quests.qv_back = (TextView)this.activity.quests.singleQuestScreen.findViewById(2131297014);
            this.activity.quests.qvName = (TextView)this.activity.quests.singleQuestScreen.findViewById(2131297013);
            this.activity.quests.qvDesc = (TextView)this.activity.quests.singleQuestScreen.findViewById(2131297012);
            this.activity.quests.qvAvatar = (ImageView)this.activity.quests.singleQuestScreen.findViewById(2131297011);
        }
        final MainActivity activity = this.activity;
        activity.EnableLayout((ViewGroup)activity.quests.singleQuestScreen);
        this.activity.quests.llSkills.removeAllViews();
        this.activity.quests.llRewards.removeAllViews();
        this.activity.quests.llItems.removeAllViews();
        final MainActivity activity2 = this.activity;
        activity2.HideView(activity2.currentView);
        final MainActivity activity3 = this.activity;
        activity3.currentView = (View)activity3.quests.singleQuestScreen;
        final MainActivity activity4 = this.activity;
        activity4.ShowView(activity4.currentView);
        this.activity.quests.qv_back.setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda0(this));
        this.activity.quests.qvAvatar.setVisibility(8);
        this.activity.quests.qvName.setText((CharSequence)("Base Camp Level " + (n + 1)));
        this.activity.quests.qvDesc.setVisibility(0);
        if (((String)this.baseTowerBenefit.get(n)).equals((Object)"null")) {
            this.activity.quests.qvDesc.setText((CharSequence)"No perk unlocked at this level");
        }
        else {
            this.activity.quests.qvDesc.setText((CharSequence)this.baseTowerBenefit.get(n));
        }
        this.activity.quests.GenerateSkills((String)this.baseTowerSkillsRequired.get(n));
        this.activity.quests.GenerateItems((String)this.baseTowerItemsRequired.get(n));
        this.activity.quests.GenerateRewards((String)this.baseTowerRewards.get(n));
        if (this.activity.quests.HaveItems((String)this.baseTowerSkillsRequired.get(n), (String)this.baseTowerItemsRequired.get(n))) {
            this.activity.quests.qvComplete.setAlpha(1.0f);
        }
        else {
            this.activity.quests.qvComplete.setAlpha(0.2f);
        }
        this.activity.quests.qvComplete.setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda3(this, n));
    }
    
    public void OpenStash() {
        if (this.stashScreen == null) {
            final LinearLayout stashScreen = (LinearLayout)((ViewStub)this.activity.findViewById(2131297191)).inflate();
            this.stashScreen = stashScreen;
            this.stashWrap = (GridLayout)stashScreen.findViewById(2131297192);
            this.stashOpenInventory = (TextView)this.stashScreen.findViewById(2131297189);
            this.organiseStash = (TextView)this.stashScreen.findViewById(2131296958);
        }
        this.activity.EnableLayout((ViewGroup)this.stashScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.stashScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.GenerateStash();
        this.sortMode = false;
        this.organiseStash.setText((CharSequence)"Sort Mode Off");
        this.stashOpenInventory.setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda4(this));
        this.organiseStash.setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda5(this));
        this.stashScreen.findViewById(2131296360).setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda6(this));
    }
    
    public void OpenTower() {
        if (this.baseCamp == null) {
            this.baseCamp = (ScrollView)((ViewStub)this.activity.findViewById(2131296373)).inflate();
            final ScrollView baseCamp = (ScrollView)this.activity.findViewById(2131296372);
            this.baseCamp = baseCamp;
            this.bc_seeMore = (TextView)baseCamp.findViewById(2131296384);
            this.bc_levelreward = (TextView)this.baseCamp.findViewById(2131296381);
            this.bc_currentLevel = (TextView)this.baseCamp.findViewById(2131296378);
            this.bc_completed = (TextView)this.baseCamp.findViewById(2131296377);
            this.bc_itemsRequired = (LinearLayout)this.baseCamp.findViewById(2131296380);
            this.bc_nextLevel = (ConstraintLayout)this.baseCamp.findViewById(2131296382);
        }
        this.activity.EnableLayout((ViewGroup)this.baseCamp);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.baseCamp;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.baseCamp.findViewById(2131296383).setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda9(this));
        this.baseCamp.findViewById(2131296379).setOnClickListener((View$OnClickListener)new BaseTower$$ExternalSyntheticLambda10(this));
        this.UpdateBaseCamp();
    }
    
    public void RevertBackToLists(final List<ItemManager$Item> list) {
        this.tempStashItems.clear();
        this.tempStashAmounts.clear();
        this.tempStashItems.addAll((Collection)this.stashItems);
        this.tempStashAmounts.addAll((Collection)this.stashAmounts);
        this.stashItems.clear();
        this.stashAmounts.clear();
        for (int i = 0; i < list.size(); ++i) {
            final ItemManager$Item itemManager$Item = (ItemManager$Item)list.get(i);
            this.stashItems.add((Object)itemManager$Item.getName());
            this.stashAmounts.add((Object)itemManager$Item.getAmount());
        }
    }
    
    public List<ItemManager$Item> SortItems(final String s) {
        final List<ItemManager$Item> createItemList = this.CreateItemList();
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
    
    public void SortStash(final String s) {
        this.RevertBackToLists(this.SortItems(s));
    }
    
    public void UpdateStash() {
        for (int i = 0; i < this.stashViews.size(); ++i) {
            if (this.stashItems.size() > i) {
                if ((long)this.stashAmounts.get(i) >= 2000000000L) {
                    this.stashAmounts.set(i, (Object)2000000000L);
                }
                final String formatCoins = this.activity.FormatCoins((long)this.stashAmounts.get(i));
                if (((RelativeLayout)this.stashViews.get(i)).getChildCount() == 0) {
                    final ImageView imageView = new ImageView((Context)this.activity);
                    final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(this.activity.itemManager.inventImageSize, this.activity.itemManager.inventImageSize);
                    layoutParams.addRule(13);
                    imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                    imageView.setAdjustViewBounds(true);
                    final int intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.stashItems.get(i)));
                    imageView.setTag((Object)intValue);
                    Picasso.get().load(intValue).into(imageView);
                    ((RelativeLayout)this.stashViews.get(i)).addView((View)imageView);
                    final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886371));
                    final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-2, -2);
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(21);
                    layoutParams2.setMargins(0, 0, this.activity.GetResource(2131100091), this.activity.GetResource(2131100091));
                    textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                    final MainActivity activity = this.activity;
                    activity.SetTextSize(textView, activity.GetResource(2131100247));
                    textView.setTextColor(this.activity.GetColour(2131034924));
                    textView.setText((CharSequence)formatCoins);
                    ((RelativeLayout)this.stashViews.get(i)).addView((View)textView);
                }
                else {
                    final ImageView imageView2 = (ImageView)((RelativeLayout)this.stashViews.get(i)).getChildAt(0);
                    final TextView textView2 = (TextView)((RelativeLayout)this.stashViews.get(i)).getChildAt(1);
                    final int intValue2 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.stashItems.get(i)));
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
                ((RelativeLayout)this.stashViews.get(i)).removeAllViews();
            }
        }
    }
}
