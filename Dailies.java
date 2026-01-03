package uk.playdrop.cherrytree_idletextrpg;

import java.util.Objects;
import com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails;
import android.view.ContextThemeWrapper;
import com.android.billingclient.api.ProductDetails;
import java.util.Calendar;
import java.util.Random;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.widget.TextView;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup;
import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View$OnClickListener;
import android.view.View;
import java.util.Collections;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Dailies
{
    MainActivity activity;
    List<String> alchemyExceptions;
    List<String> allRewards;
    List<String> allRewardsDescriptions;
    int challengeAmount;
    int challengeCoins;
    List<String> craftingExceptions;
    long dailyBonus;
    List<DailyChallenge> dailyChallenges;
    List<String> dailySkills;
    int doubleDays;
    int lastLoginDay;
    List<String> possibleChallenges;
    List<String> premiumChallenges;
    List<Integer> rewardCost;
    int skipTickets;
    
    public Dailies(final MainActivity activity) {
        this.lastLoginDay = 0;
        final Integer value = 5;
        this.challengeAmount = 5;
        this.dailySkills = (List<String>)new ArrayList();
        final Integer value2 = 1;
        final Integer value3 = 3;
        this.possibleChallenges = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Combat", "Fishing", "Crafting", "Discovery", "Cooking", "Alchemy", "Slayer" }));
        this.premiumChallenges = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Thieving", "Mining", "Forestry", "Firemaking" }));
        this.dailyChallenges = (List<DailyChallenge>)new ArrayList();
        this.dailyBonus = 0L;
        this.skipTickets = 0;
        this.challengeCoins = 0;
        this.allRewards = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Combat Boost", "Enhancement Ticket", "Casket of Treasure", "Skip Ticket", "Challenger Boots", "Challenger Gloves", "Challenger Hat", "Challenger Legs", "Challenger Top", "Soul Gem", "Killcoins", "Elven Chest", "Elven Key", "Fragment of Secrets 4", "Challenger Title" }));
        this.allRewardsDescriptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Gives a permanent +10 bonus to all combat stats (Excluding Health, stackable)", "Can be used to enhance items, making them more powerful", "May contain some godly loot", "Used to skip Daily Challenges", "Awards 5% bonus exp in all skills per outfit piece worn", "Awards 5% bonus exp in all skills per outfit piece worn", "Awards 5% bonus exp in all skills per outfit piece worn", "Awards 5% bonus exp in all skills per outfit piece worn", "Awards 5% bonus exp in all skills per outfit piece worn", "Used to purchase high end rewards in the Slayer shop", "Gives 100 Killcoins, which can be spent in the Slayer Shop", "A high end chest that may contain some epic loot", "Used to open the Elven Chest", "A mythical fragment required to craft the Ring of Secrets", "Unlocks the cosmetic title: the Challenger (Can only be purchased once)" }));
        final Integer value4 = 20;
        this.rewardCost = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value4, value, value3, value4, value4, 25, 30, 45, 2, value3, value2, value2, 300, 250 }));
        this.craftingExceptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Queens Gloves", "Queens Boots", "Queens Helm", "Queens Greaves", "Queens Top", "Queens Sword", "Kings Gloves", "Kings Boots", "Kings Helm", "Kings Greaves", "Kings Top", "Kings Sword", "Super Power Stone", "Extreme Power Stone", "Farmour Gloves", "Farmour Boots", "Farmour Helm", "Farmour Legs", "Farmour Top", "Dagger of Demeter", "Drakes Ring", "Ring of Anuket", "Ring of Demeter", "Ring of Extreme Power", "Ring of Forestry", "Ring of Power", "Ring of Renewal", "Ring of Super Power", "Necklace of Restoration", "Mini Exp Scroll", "Small Exp Scroll", "Medium Exp Scroll", "Large Exp Scroll", "Massive Exp Scroll", "Elven Plate", "Elven Greaves", "Elven Helm", "Elven Gloves", "Elven Boots", "Elven Sword", "Wooden Stick", "Eternal Ring", "Berserker Ring", "Eternal Berserker Ring", "Master Top", "Master Gloves", "Master Boots", "Master Legs", "Master Helm", "Primal Top", "Primal Gloves", "Primal Boots", "Primal Legs", "Primal Helm", "Blessed Eternal Sacrifice", "Dark Elven Helm", "Dark Elven Gloves", "Dark Elven Boots", "Dark Elven Greaves", "Dark Elven Plate", "Dark Elven Sword", "Apprentice Sword", "Master Sword", "Primal Sword", "Ring of Secrets", "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Shadow Boots", "Darkstar Bar", "Shadow Gloves", "Shadow Hood", "Shadow Greaves", "Shadow Lantern", "Staff of the Shadows", "Shadow Cloak", "Necklace of the Gods" }));
        this.alchemyExceptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Divine Protection Potion", "Soul Reaper Potion", "Summer Cocktail" }));
        this.doubleDays = 0;
        this.activity = activity;
    }
    
    private boolean AllComplete() {
        final Iterator iterator = this.dailyChallenges.iterator();
        while (iterator.hasNext()) {
            if (!((DailyChallenge)iterator.next()).getCompleted()) {
                return false;
            }
        }
        return true;
    }
    
    private void CompleteChallenge() {
        int n;
        if (this.activity.members) {
            n = 2;
        }
        else {
            n = 1;
        }
        int n2 = n;
        if (this.activity.baseTower.baseTowerLevel >= 73) {
            n2 = n + 1;
        }
        int n3 = n2;
        if (this.doubleDays > 0) {
            n3 = n2 * 2;
        }
        this.challengeCoins += n3;
        final MainActivity activity = this.activity;
        activity.totalGems += 2L;
        this.activity.UpdateCash();
        if (this.AllComplete()) {
            if (this.activity.members) {
                final MainActivity activity2 = this.activity;
                activity2.totalGems += 100L;
            }
            else {
                final MainActivity activity3 = this.activity;
                activity3.totalGems += 25L;
            }
            if (this.activity.baseTower.baseTowerLevel >= 61) {
                final TreasureHunts$MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                myTreasureHunts.caskets += 50;
                this.activity.LargePopup(2131165669, "Congratulations!", "For completing all your dailies, you are rewarded 50 Treasure Caskets.");
            }
            this.activity.UpdateCash();
        }
    }
    
    private List<String> GetCombatEnemies(final int n, final int n2) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < this.activity.combatManager.enemyNames.size(); ++i) {
            final MainActivity activity = this.activity;
            final int getCombatLevel = activity.GetCombatLevel((int)activity.combatManager.enemyAttack.get(i), (int)this.activity.combatManager.enemyStrength.get(i), (int)this.activity.combatManager.enemyDefence.get(i), (int)this.activity.combatManager.enemyHealth.get(i));
            if (getCombatLevel >= n && getCombatLevel <= n2 && !((String)this.activity.combatManager.enemyArea.get(i)).equals((Object)"Training Grounds") && !((String)this.activity.combatManager.enemyArea.get(i)).equals((Object)"Immortal Realm") && (int)this.activity.combatManager.enemySlayerLevel.get(i) <= this.activity.GetSkillLevel("Slayer")) {
                ((List)list).add((Object)this.activity.combatManager.enemyNames.get(i));
            }
        }
        return (List<String>)list;
    }
    
    private DailyChallenge HaveDaily(final String s, final String s2) {
        for (final DailyChallenge dailyChallenge : this.dailyChallenges) {
            if (dailyChallenge.getSkill().equals((Object)s) && dailyChallenge.getChallenge().equals((Object)s2) && !dailyChallenge.getCompleted()) {
                return dailyChallenge;
            }
        }
        return null;
    }
    
    private void NewDailies() {
        this.dailySkills.clear();
        this.dailyChallenges.clear();
        final ArrayList list = new ArrayList((Collection)this.possibleChallenges);
        if (this.activity.members) {
            ((List)list).addAll((Collection)this.premiumChallenges);
        }
        Collections.shuffle((List)list);
        for (int i = 0; i < this.challengeAmount; ++i) {
            this.dailySkills.add((Object)((List)list).get(i));
        }
        this.SetDailies();
    }
    
    private void OpenShop() {
        this.activity.LoadGenerations("Challenge Store", "Here you can use your challenge points to redeem epic rewards!");
        final TextView addButton = this.activity.AddButton("Back to Challenges");
        this.activity.genWrap.addView((View)addButton);
        addButton.setOnClickListener((View$OnClickListener)new Dailies$$ExternalSyntheticLambda4(this));
        final TextView addButton2 = this.activity.AddButton("Points: " + this.activity.FormatExp((long)this.challengeCoins) + " | Combat Bonus: " + this.activity.FormatExp(this.dailyBonus));
        this.activity.genWrap.addView((View)addButton2);
        for (int i = 0; i < this.allRewards.size(); ++i) {
            final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.activity, 2131492905, (ViewGroup)null);
            this.activity.genWrap.addView((View)constraintLayout);
            final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)constraintLayout.getLayoutParams();
            layoutParams.topMargin = this.activity.GetResource(2131100202);
            layoutParams.leftMargin = this.activity.GetResource(2131100202);
            layoutParams.rightMargin = this.activity.GetResource(2131100202);
            constraintLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            int n = 1;
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)this.allRewards.get(i));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)this.allRewardsDescriptions.get(i));
            ((TextView)constraintLayout.getChildAt(3)).setText((CharSequence)this.activity.FormatExp((long)(int)this.rewardCost.get(i)));
            final String s = (String)this.allRewards.get(i);
            s.hashCode();
            Label_0552: {
                switch (s.hashCode()) {
                    case 1803406242: {
                        if (!s.equals((Object)"Soul Gem")) {
                            break;
                        }
                        n = 7;
                        break Label_0552;
                    }
                    case 1721869536: {
                        if (!s.equals((Object)"Enhancement Ticket")) {
                            break;
                        }
                        n = 6;
                        break Label_0552;
                    }
                    case 548227943: {
                        if (!s.equals((Object)"Challenger Title")) {
                            break;
                        }
                        n = 5;
                        break Label_0552;
                    }
                    case 444298052: {
                        if (!s.equals((Object)"Killcoins")) {
                            break;
                        }
                        n = 4;
                        break Label_0552;
                    }
                    case -415919241: {
                        if (!s.equals((Object)"Combat Boost")) {
                            break;
                        }
                        n = 3;
                        break Label_0552;
                    }
                    case -712891187: {
                        if (!s.equals((Object)"Skip Ticket")) {
                            break;
                        }
                        n = 2;
                        break Label_0552;
                    }
                    case -819624483: {
                        if (!s.equals((Object)"Casket of Treasure")) {
                            break;
                        }
                        break Label_0552;
                    }
                    case -1144442577: {
                        if (!s.equals((Object)"Silver Coins")) {
                            break;
                        }
                        n = 0;
                        break Label_0552;
                    }
                }
                n = -1;
            }
            int intValue = 0;
            switch (n) {
                default: {
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.allRewards.get(i)));
                    break;
                }
                case 7: {
                    intValue = 2131166237;
                    break;
                }
                case 6: {
                    intValue = 2131165610;
                    break;
                }
                case 5: {
                    intValue = 2131165520;
                    break;
                }
                case 4: {
                    intValue = 2131165924;
                    break;
                }
                case 3: {
                    intValue = 2131166468;
                    break;
                }
                case 2: {
                    intValue = 2131165353;
                    break;
                }
                case 1: {
                    intValue = 2131165669;
                    break;
                }
                case 0: {
                    intValue = 2131166220;
                    break;
                }
            }
            Picasso.get().load(intValue).into((ImageView)constraintLayout.getChildAt(0));
            constraintLayout.getChildAt(3).setOnClickListener((View$OnClickListener)new Dailies$$ExternalSyntheticLambda5(this, i, addButton2));
        }
    }
    
    private DailyChallenge PickChallenge(final String s) {
        final ArrayList list = new ArrayList();
        s.hashCode();
        final int hashCode = s.hashCode();
        int n = -1;
        switch (hashCode) {
            case 2093691137: {
                if (!s.equals((Object)"Firemaking")) {
                    break;
                }
                n = 10;
                break;
            }
            case 2024008468: {
                if (!s.equals((Object)"Combat")) {
                    break;
                }
                n = 9;
                break;
            }
            case 1882760592: {
                if (!s.equals((Object)"Discovery")) {
                    break;
                }
                n = 8;
                break;
            }
            case 1775166946: {
                if (!s.equals((Object)"Crafting")) {
                    break;
                }
                n = 7;
                break;
            }
            case 1281238620: {
                if (!s.equals((Object)"Thieving")) {
                    break;
                }
                n = 6;
                break;
            }
            case 816216682: {
                if (!s.equals((Object)"Fishing")) {
                    break;
                }
                n = 5;
                break;
            }
            case 744772833: {
                if (!s.equals((Object)"Alchemy")) {
                    break;
                }
                n = 4;
                break;
            }
            case 531872580: {
                if (!s.equals((Object)"Forestry")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1678124166: {
                if (!s.equals((Object)"Cooking")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1815998242: {
                if (!s.equals((Object)"Slayer")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1990171536: {
                if (!s.equals((Object)"Mining")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        String s2 = null;
        String s3 = null;
        int n2 = 0;
        switch (n) {
            default: {
                s2 = "";
                s3 = "";
                n2 = 0;
                break;
            }
            case 10: {
                for (int i = 0; i < this.activity.forestry.forestLogs.size(); ++i) {
                    if ((int)this.activity.forestry.forestLevels.get(i) <= this.activity.GetSkillLevel("Firemaking")) {
                        ((List)list).add((Object)this.activity.forestry.forestLogs.get(i));
                    }
                }
                ((List)list).remove((Object)"No Log");
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity = this.activity;
                n2 = activity.GetRandom(activity.GetSkillLevel("Firemaking") * 2, this.activity.GetSkillLevel("Firemaking") * 5);
                s3 = "Burn " + n2 + " " + s2 + "s";
                break;
            }
            case 9: {
                final int myCombatLevel = this.activity.MyCombatLevel();
                final int n3 = myCombatLevel - 10;
                final int max = Math.max(n3, 1);
                int max2;
                int n4;
                if (myCombatLevel >= 96) {
                    max2 = 150;
                    n4 = 200000;
                }
                else {
                    max2 = Math.max(0, n3);
                    n4 = myCombatLevel + 50;
                }
                final List<String> getCombatEnemies = this.GetCombatEnemies(max2, n4);
                Collections.shuffle((List)getCombatEnemies);
                s2 = (String)getCombatEnemies.get(new Random().nextInt(getCombatEnemies.size()));
                n2 = this.activity.GetRandom(max, myCombatLevel + 10);
                s3 = "Slay " + n2 + " " + s2;
                break;
            }
            case 8: {
                final MainActivity activity2 = this.activity;
                n2 = activity2.GetRandom(activity2.GetSkillLevel("Discovery") * 5, this.activity.GetSkillLevel("Discovery") * 10);
                s3 = "Use " + this.activity.FormatExp((long)n2) + " Energy in Discovery";
                s2 = "Energy";
                break;
            }
            case 7: {
                for (int j = 0; j < this.activity.crafting.craftingItems.size(); ++j) {
                    if ((int)this.activity.crafting.craftingItemLevel.get(j) <= this.activity.GetSkillLevel("Crafting") && !this.craftingExceptions.contains(this.activity.crafting.craftingItems.get(j))) {
                        ((List)list).add((Object)this.activity.crafting.craftingItems.get(j));
                    }
                }
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity3 = this.activity;
                n2 = activity3.GetRandom(activity3.GetSkillLevel("Crafting") * 2, this.activity.GetSkillLevel("Crafting") * 3);
                s3 = "Craft " + n2 + " " + s2;
                break;
            }
            case 6: {
                for (int k = 0; k < this.activity.thieving.thievingNpc.size(); ++k) {
                    if ((int)this.activity.thieving.thievingUnlockLevel.get(k) <= this.activity.GetSkillLevel("Thieving")) {
                        ((List)list).add((Object)this.activity.thieving.thievingNpc.get(k));
                    }
                }
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity4 = this.activity;
                n2 = activity4.GetRandom(activity4.GetSkillLevel("Thieving") * 2, this.activity.GetSkillLevel("Thieving") * 5);
                s3 = "Pickpocket " + n2 + " " + s2 + "s";
                break;
            }
            case 5: {
                for (int l = 0; l < this.activity.fishing.fishingLocations.size(); ++l) {
                    if ((int)this.activity.fishing.fishingLocationsLevel.get(l) <= this.activity.GetSkillLevel("Fishing")) {
                        ((List)list).add((Object)this.activity.fishing.fishingLocations.get(l));
                    }
                }
                if (((List)list).contains((Object)"The Grove") && !this.activity.members) {
                    ((List)list).remove((Object)"The Grove");
                }
                if (((List)list).contains((Object)"Mystery Island") && !this.activity.inventoryItems.contains((Object)"Ancient Rod") && !this.activity.baseTower.stashItems.contains((Object)"Ancient Rod")) {
                    ((List)list).remove((Object)"Mystery Island");
                }
                ((List)list).remove((Object)"Christmas Village");
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity5 = this.activity;
                n2 = activity5.GetRandom(activity5.GetSkillLevel("Fishing") * 4, this.activity.GetSkillLevel("Fishing") * 8);
                s3 = "Fish from the " + s2 + " " + n2 + " times";
                break;
            }
            case 4: {
                for (int n5 = 0; n5 < this.activity.alchemy.potionItems.size(); ++n5) {
                    if ((int)this.activity.alchemy.potionItemLevel.get(n5) <= this.activity.GetSkillLevel("Alchemy") && !this.alchemyExceptions.contains(this.activity.alchemy.potionItems.get(n5))) {
                        ((List)list).add((Object)this.activity.alchemy.potionItems.get(n5));
                    }
                }
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity6 = this.activity;
                n2 = activity6.GetRandom(activity6.GetSkillLevel("Alchemy") * 2, this.activity.GetSkillLevel("Alchemy") * 3);
                s3 = "Brew " + n2 + " " + s2 + "s";
                break;
            }
            case 3: {
                for (int n6 = 0; n6 < this.activity.forestry.forestTrees.size(); ++n6) {
                    if ((int)this.activity.forestry.forestLevels.get(n6) <= this.activity.GetSkillLevel("Forestry")) {
                        ((List)list).add((Object)this.activity.forestry.forestTrees.get(n6));
                    }
                }
                ((List)list).remove((Object)"Christmas Village");
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity7 = this.activity;
                n2 = activity7.GetRandom(activity7.GetSkillLevel("Forestry") * 2, this.activity.GetSkillLevel("Forestry") * 4);
                s3 = "Chop " + n2 + " " + s2 + "s";
                break;
            }
            case 2: {
                for (int n7 = 0; n7 < this.activity.cooking.cooking_cooked.size(); ++n7) {
                    if ((int)this.activity.cooking.cooking_level.get(n7) <= this.activity.GetSkillLevel("Cooking") && !((String)this.activity.cooking.cooking_cooked.get(n7)).equals((Object)"Pumpkin Pie")) {
                        ((List)list).add((Object)this.activity.cooking.cooking_cooked.get(n7));
                    }
                }
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity8 = this.activity;
                n2 = activity8.GetRandom(activity8.GetSkillLevel("Cooking") * 3, this.activity.GetSkillLevel("Cooking") * 5);
                s3 = "Cook " + n2 + " " + s2;
                break;
            }
            case 1: {
                if (this.activity.GetSkillLevel("Slayer") < 10) {
                    n2 = 1;
                }
                else {
                    final MainActivity activity9 = this.activity;
                    n2 = activity9.GetRandom(activity9.GetSkillLevel("Slayer") / 10, this.activity.GetSkillLevel("Slayer") / 5);
                }
                s3 = "Complete " + n2 + " Slayer Tasks";
                s2 = "Slayer";
                break;
            }
            case 0: {
                for (int n8 = 0; n8 < this.activity.mining.miningRocks.size(); ++n8) {
                    if ((int)this.activity.mining.miningLocationsLevel.get(n8) <= this.activity.GetSkillLevel("Mining")) {
                        ((List)list).add((Object)this.activity.mining.miningRocks.get(n8));
                    }
                }
                ((List)list).remove((Object)"Christmas Village");
                Collections.shuffle((List)list);
                s2 = (String)((List)list).get(new Random().nextInt(((List)list).size()));
                final MainActivity activity10 = this.activity;
                n2 = activity10.GetRandom(activity10.GetSkillLevel("Mining") * 2, this.activity.GetSkillLevel("Mining") * 5);
                s3 = "Mine " + n2 + " " + s2;
                break;
            }
        }
        return new DailyChallenge(s, s2, s3, 0, n2, false);
    }
    
    private void SetDailies() {
        for (int i = 0; i < this.dailySkills.size(); ++i) {
            this.dailyChallenges.add((Object)this.PickChallenge((String)this.dailySkills.get(i)));
        }
    }
    
    public void CheckDailies() {
        final int value = Calendar.getInstance().get(6);
        if (value != this.lastLoginDay) {
            if (this.activity.members) {
                final DatabaseManager databaseManager = this.activity.databaseManager;
                databaseManager.vaultChances += 10;
            }
            else {
                final DatabaseManager databaseManager2 = this.activity.databaseManager;
                databaseManager2.vaultChances += 5;
            }
            this.activity.alchemy.cocktailsDrank = 0;
            this.activity.thieving.dailySafesCracked = 0L;
            final int doubleDays = this.doubleDays;
            if (doubleDays > 0) {
                this.doubleDays = doubleDays - 1;
            }
        }
        if (value != this.lastLoginDay || this.dailyChallenges.isEmpty()) {
            this.lastLoginDay = value;
            this.NewDailies();
        }
    }
    
    public void OpenChallenges() {
        this.activity.LoadGenerations("Daily Challenges", "Here you can complete daily challenges. Completing each challenge awards a challenge point (2 if Premium), which can then be used in the challenge shop. You can skip challenges using skip tokens. Each Daily Challenge completed gives 2 Gold Coins. Complete them all to get a bonus reward of 25 Gold (Free players) or 100 Gold (Premium).");
        if (this.activity.billingInitialized && !this.activity.inAppProducts.isEmpty() && this.activity.skuNames.contains((Object)"double_dailies")) {
            final ProductDetails productDetails = (ProductDetails)this.activity.inAppProducts.get(this.activity.skuNames.indexOf((Object)"double_dailies"));
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-1, -2);
            layoutParams.topMargin = this.activity.GetResource(2131100202);
            layoutParams.leftMargin = this.activity.GetResource(2131100202);
            layoutParams.rightMargin = this.activity.GetResource(2131100202);
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            textView.setText((CharSequence)("Earn double Challenge Coins on dailies for 7 days\n" + ((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)productDetails.getOneTimePurchaseOfferDetails())).getFormattedPrice()));
            textView.setTextColor(this.activity.GetColour(2131034892));
            final MainActivity activity = this.activity;
            activity.SetTextSize(textView, activity.GetResource(2131099669));
            textView.setLineSpacing(0.0f, 1.3f);
            textView.setBackground(this.activity.GetImage(2131166456));
            textView.setPadding(this.activity.GetResource(2131099713), this.activity.GetResource(2131099658), this.activity.GetResource(2131099713), this.activity.GetResource(2131099658));
            textView.setGravity(17);
            this.activity.genWrap.addView((View)textView);
            textView.setOnClickListener((View$OnClickListener)new Dailies$$ExternalSyntheticLambda0(this, productDetails));
        }
        final TextView addButton = this.activity.AddButton("Challenge Shop");
        this.activity.genWrap.addView((View)addButton);
        final TextView addButton2 = this.activity.AddButton("Skip Tickets: " + this.skipTickets);
        this.activity.genWrap.addView((View)addButton2);
        this.activity.genWrap.addView((View)this.activity.AddButton("Double Days Remaining: " + this.doubleDays));
        addButton.setOnClickListener((View$OnClickListener)new Dailies$$ExternalSyntheticLambda1(this));
        for (int i = 0; i < this.dailyChallenges.size(); ++i) {
            final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.activity, 2131492906, (ViewGroup)null);
            this.activity.genWrap.addView((View)constraintLayout);
            final LinearLayout$LayoutParams layoutParams2 = (LinearLayout$LayoutParams)constraintLayout.getLayoutParams();
            layoutParams2.topMargin = this.activity.GetResource(2131100202);
            layoutParams2.leftMargin = this.activity.GetResource(2131100202);
            layoutParams2.rightMargin = this.activity.GetResource(2131100202);
            constraintLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            int n;
            if (((DailyChallenge)this.dailyChallenges.get(i)).getSkill().equals((Object)"Combat")) {
                n = (int)this.activity.skillsIcons.get(this.activity.skills.indexOf((Object)"Attack"));
            }
            else {
                n = (int)this.activity.skillsIcons.get(this.activity.skills.indexOf((Object)((DailyChallenge)this.dailyChallenges.get(i)).getSkill()));
            }
            final float n2 = ((DailyChallenge)this.dailyChallenges.get(i)).getCurrentProgress() / (float)((DailyChallenge)this.dailyChallenges.get(i)).getEndGoal();
            ((ImageView)constraintLayout.getChildAt(0)).setImageDrawable(this.activity.GetImage(n));
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)(((DailyChallenge)this.dailyChallenges.get(i)).getSkill() + " (" + (int)Math.min(n2 * 100.0f, 100.0f) + "%)"));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)((DailyChallenge)this.dailyChallenges.get(i)).getChallengeDescription());
            ((TextView)constraintLayout.getChildAt(3)).setText((CharSequence)(((DailyChallenge)this.dailyChallenges.get(i)).getCurrentProgress() + " / " + ((DailyChallenge)this.dailyChallenges.get(i)).getEndGoal()));
            constraintLayout.getChildAt(4).setOnClickListener((View$OnClickListener)new Dailies$$ExternalSyntheticLambda2(this, i, addButton2, constraintLayout));
            constraintLayout.setOnClickListener((View$OnClickListener)new Dailies$$ExternalSyntheticLambda3(this, i));
            if (((DailyChallenge)this.dailyChallenges.get(i)).getCompleted()) {
                constraintLayout.setAlpha(0.2f);
                constraintLayout.setEnabled(false);
            }
        }
    }
    
    public void UpdateDailies(final String s, final String s2, final int n) {
        final DailyChallenge haveDaily = this.HaveDaily(s, s2);
        if (haveDaily != null) {
            haveDaily.currentProgress += n;
            if (haveDaily.getCurrentProgress() >= haveDaily.getEndGoal()) {
                haveDaily.completed = true;
                this.activity.LargePopup(2131165354, "Daily Complete", "You have completed your " + haveDaily.getSkill() + " daily challenge.");
                this.CompleteChallenge();
            }
        }
    }
    
    public static class DailyChallenge
    {
        String challenge;
        String challengeDescription;
        Boolean completed;
        int currentProgress;
        int endGoal;
        String skill;
        
        public DailyChallenge(final String skill, final String challenge, final String challengeDescription, final int currentProgress, final int endGoal, final Boolean completed) {
            this.skill = skill;
            this.challenge = challenge;
            this.currentProgress = currentProgress;
            this.endGoal = endGoal;
            this.completed = completed;
            this.challengeDescription = challengeDescription;
        }
        
        public String getChallenge() {
            return this.challenge;
        }
        
        public String getChallengeDescription() {
            return this.challengeDescription;
        }
        
        public Boolean getCompleted() {
            return this.completed;
        }
        
        public int getCurrentProgress() {
            return this.currentProgress;
        }
        
        public int getEndGoal() {
            return this.endGoal;
        }
        
        public String getSkill() {
            return this.skill;
        }
    }
}
