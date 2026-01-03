package uk.playdrop.cherrytree_idletextrpg;

import android.widget.ProgressBar;
import android.widget.ImageView;
import android.view.ViewStub;
import com.google.android.gms.tasks.OnSuccessListener;
import android.view.ViewGroup$LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import android.view.View$OnClickListener;
import com.google.firebase.firestore.DocumentSnapshot;
import android.view.ViewGroup;
import android.view.View;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import java.util.List;
import android.widget.TextView;

public class SecretPathway
{
    MainActivity activity;
    TextView clueTv;
    TextView currentPathNumber;
    CurrentPathway currentPathway;
    DatabaseManager databaseManager;
    boolean grabbedPath;
    TextView monthTv;
    MyPath myPath;
    List<String> pathTesters;
    List<PathView> pathViews;
    LinearLayout pathwayLevels;
    ScrollView secretPath;
    ConstraintLayout skipButton;
    
    public SecretPathway(final MainActivity activity, final DatabaseManager databaseManager) {
        this.currentPathway = null;
        this.grabbedPath = false;
        this.pathViews = (List<PathView>)new ArrayList();
        this.pathTesters = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "banshen", "PlaydropUK", "FoxesGoAhhh", "Ace12444" }));
        this.activity = activity;
        this.databaseManager = databaseManager;
    }
    
    private void ClaimReward(final PathView pathView, final String s, int n) {
        String s2;
        long n2;
        if (s.equals((Object)"Free")) {
            s2 = (String)this.currentPathway.getFreeRewards().get(n);
            n2 = (long)this.currentPathway.getFreeRewardAmounts().get(n);
            if (this.myPath.getClaimedFree().get(n)) {
                this.activity.QuickPopup("You've already claimed this reward");
                return;
            }
        }
        else {
            s2 = (String)this.currentPathway.getPremiumRewards().get(n);
            n2 = (long)this.currentPathway.getPremiumRewardAmounts().get(n);
            if (this.myPath.getClaimedPremium().get(n)) {
                this.activity.QuickPopup("You've already claimed this reward");
                return;
            }
        }
        if (this.InventorySpace(s2)) {
            if (s.equals((Object)"Free")) {
                this.myPath.claimedFree.set(n, (Object)true);
                this.activity.HideView((View)pathView.getClaimFreeReward());
            }
            else {
                this.myPath.claimedPremium.set(n, (Object)true);
                this.activity.HideView((View)pathView.getClaimPremiumReward());
            }
            s2.hashCode();
            final int hashCode = s2.hashCode();
            n = -1;
            switch (hashCode) {
                case 1803406242: {
                    if (!s2.equals((Object)"Soul Gem")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 1721869536: {
                    if (!s2.equals((Object)"Enhancement Ticket")) {
                        break;
                    }
                    n = 4;
                    break;
                }
                case 1253687303: {
                    if (!s2.equals((Object)"Slayer Casket")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case 658894417: {
                    if (!s2.equals((Object)"Gold Coin")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case -458446738: {
                    if (!s2.equals((Object)"Challenge Coin")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -819624483: {
                    if (!s2.equals((Object)"Casket of Treasure")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    if (!s2.contains((CharSequence)"#")) {
                        this.activity.GiveItem(s2, n2, false);
                        break;
                    }
                    final String[] split = s2.split("\\s*#\\s*");
                    if (split[0].equals((Object)"Avatar")) {
                        this.activity.GiveAvatar(split[1]);
                        break;
                    }
                    if (split[0].equals((Object)"Title")) {
                        this.activity.GiveTitle(split[1]);
                        break;
                    }
                    break;
                }
                case 5: {
                    final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                    slayerInfo.soulGems += n2;
                    break;
                }
                case 4: {
                    final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                    blessings.tickets += (int)n2;
                    break;
                }
                case 3: {
                    final CombatManager$SlayerInfo slayerInfo2 = this.activity.combatManager.slayerInfo;
                    slayerInfo2.slayerCaskets += n2;
                    break;
                }
                case 2: {
                    final MainActivity activity = this.activity;
                    activity.totalGems += n2;
                    this.activity.UpdateCash();
                    break;
                }
                case 1: {
                    final Dailies dailies = this.activity.dailies;
                    dailies.challengeCoins += (int)n2;
                    break;
                }
                case 0: {
                    final TreasureHunts.MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                    myTreasureHunts.caskets += (int)n2;
                    break;
                }
            }
            String s3 = s2;
            if (s2.contains((CharSequence)"#")) {
                s3 = s2.split("\\s*#\\s*")[1];
            }
            this.activity.QuickPopup("You obtained " + this.activity.FormatExp(n2) + "x " + s3 + "!");
        }
        else {
            this.activity.QuickPopup("Not enough inventory space!");
        }
    }
    
    private String GeneratePathHint() {
        String s;
        try {
            final int getRandom = this.activity.GetRandom(1, this.currentPathway.getEquipment().size() - 2);
            if (((String)this.currentPathway.getEquipment().get(getRandom)).equals((Object)"None")) {
                s = "Level " + (getRandom + 1) + " does not require equipment";
            }
            else {
                s = "Level " + (getRandom + 1) + " requires " + (String)this.currentPathway.getEquipment().get(getRandom) + " equipped";
            }
        }
        catch (final IndexOutOfBoundsException ex) {
            s = "There was a problem generating your hint!";
        }
        return s;
    }
    
    private void GeneratePathway() {
        int n;
        for (int i = 0; i < this.currentPathway.getSkills().size(); i = n) {
            final ConstraintLayout constraintLayout = (ConstraintLayout)this.activity.inflater.inflate(2131493036, (ViewGroup)this.pathwayLevels, false);
            final PathView pathView = new PathView(constraintLayout);
            final TextView level = pathView.getLevel();
            n = i + 1;
            level.setText((CharSequence)String.valueOf(n));
            final String s = (String)this.currentPathway.getFreeRewards().get(i);
            s.hashCode();
            int n2 = 0;
            Label_0270: {
                switch (s.hashCode()) {
                    case 1803406242: {
                        if (!s.equals((Object)"Soul Gem")) {
                            break;
                        }
                        n2 = 5;
                        break Label_0270;
                    }
                    case 1721869536: {
                        if (!s.equals((Object)"Enhancement Ticket")) {
                            break;
                        }
                        n2 = 4;
                        break Label_0270;
                    }
                    case 1253687303: {
                        if (!s.equals((Object)"Slayer Casket")) {
                            break;
                        }
                        n2 = 3;
                        break Label_0270;
                    }
                    case 658894417: {
                        if (!s.equals((Object)"Gold Coin")) {
                            break;
                        }
                        n2 = 2;
                        break Label_0270;
                    }
                    case -458446738: {
                        if (!s.equals((Object)"Challenge Coin")) {
                            break;
                        }
                        n2 = 1;
                        break Label_0270;
                    }
                    case -819624483: {
                        if (!s.equals((Object)"Casket of Treasure")) {
                            break;
                        }
                        n2 = 0;
                        break Label_0270;
                    }
                }
                n2 = -1;
            }
            int n3 = 0;
            switch (n2) {
                default: {
                    if (!((String)this.currentPathway.getFreeRewards().get(i)).contains((CharSequence)"#")) {
                        try {
                            n3 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.currentPathway.getFreeRewards().get(i)));
                        }
                        catch (final IndexOutOfBoundsException ex) {
                            n3 = 2131166497;
                        }
                        break;
                    }
                    final String[] split = ((String)this.currentPathway.getFreeRewards().get(i)).split("\\s*#\\s*");
                    if (split[0].equals((Object)"Avatar")) {
                        n3 = (int)this.activity.avatarIcons.get(this.activity.avatarNames.indexOf((Object)split[1]));
                        break;
                    }
                    n3 = 2131165520;
                    break;
                }
                case 5: {
                    n3 = 2131166237;
                    break;
                }
                case 4: {
                    n3 = 2131165610;
                    break;
                }
                case 3: {
                    n3 = 2131166225;
                    break;
                }
                case 2: {
                    n3 = 2131165871;
                    break;
                }
                case 1: {
                    n3 = 2131165354;
                    break;
                }
                case 0: {
                    n3 = 2131165669;
                    break;
                }
            }
            final String s2 = (String)this.currentPathway.getPremiumRewards().get(i);
            s2.hashCode();
            int n4 = 0;
            Label_0706: {
                switch (s2.hashCode()) {
                    case 1803406242: {
                        if (!s2.equals((Object)"Soul Gem")) {
                            break;
                        }
                        n4 = 5;
                        break Label_0706;
                    }
                    case 1721869536: {
                        if (!s2.equals((Object)"Enhancement Ticket")) {
                            break;
                        }
                        n4 = 4;
                        break Label_0706;
                    }
                    case 1253687303: {
                        if (!s2.equals((Object)"Slayer Casket")) {
                            break;
                        }
                        n4 = 3;
                        break Label_0706;
                    }
                    case 658894417: {
                        if (!s2.equals((Object)"Gold Coin")) {
                            break;
                        }
                        n4 = 2;
                        break Label_0706;
                    }
                    case -458446738: {
                        if (!s2.equals((Object)"Challenge Coin")) {
                            break;
                        }
                        n4 = 1;
                        break Label_0706;
                    }
                    case -819624483: {
                        if (!s2.equals((Object)"Casket of Treasure")) {
                            break;
                        }
                        n4 = 0;
                        break Label_0706;
                    }
                }
                n4 = -1;
            }
            int n5 = 0;
            switch (n4) {
                default: {
                    if (!((String)this.currentPathway.getPremiumRewards().get(i)).contains((CharSequence)"#")) {
                        try {
                            n5 = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.currentPathway.getPremiumRewards().get(i)));
                        }
                        catch (final IndexOutOfBoundsException ex2) {
                            n5 = 2131166497;
                        }
                        break;
                    }
                    final String[] split2 = ((String)this.currentPathway.getPremiumRewards().get(i)).split("\\s*#\\s*");
                    if (split2[0].equals((Object)"Avatar")) {
                        n5 = (int)this.activity.avatarIcons.get(this.activity.avatarNames.indexOf((Object)split2[1]));
                        break;
                    }
                    n5 = 2131165520;
                    break;
                }
                case 5: {
                    n5 = 2131166237;
                    break;
                }
                case 4: {
                    n5 = 2131165610;
                    break;
                }
                case 3: {
                    n5 = 2131166225;
                    break;
                }
                case 2: {
                    n5 = 2131165871;
                    break;
                }
                case 1: {
                    n5 = 2131165354;
                    break;
                }
                case 0: {
                    n5 = 2131165669;
                    break;
                }
            }
            if (!((String)this.currentPathway.getFreeRewards().get(i)).contains((CharSequence)"Avatar")) {
                if (((String)this.currentPathway.getFreeRewards().get(i)).contains((CharSequence)"Title")) {
                    pathView.getFreeReward().setText((CharSequence)(((String)this.currentPathway.getFreeRewards().get(i)).split("\\s*#\\s*")[1] + " Title"));
                }
                else {
                    pathView.getFreeReward().setText((CharSequence)this.currentPathway.getFreeRewards().get(i));
                }
                pathView.getFreeRewardIcon().setPadding(this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202));
            }
            else {
                pathView.getFreeReward().setText((CharSequence)(((String)this.currentPathway.getFreeRewards().get(i)).split("\\s*#\\s*")[1] + " Avatar"));
            }
            if (!((String)this.currentPathway.getPremiumRewards().get(i)).contains((CharSequence)"Avatar")) {
                if (((String)this.currentPathway.getPremiumRewards().get(i)).contains((CharSequence)"Title")) {
                    pathView.getPremiumReward().setText((CharSequence)(((String)this.currentPathway.getPremiumRewards().get(i)).split("\\s*#\\s*")[1] + " Title"));
                }
                else {
                    pathView.getPremiumReward().setText((CharSequence)this.currentPathway.getPremiumRewards().get(i));
                }
                pathView.getPremiumRewardIcon().setPadding(this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202), this.activity.GetResource(2131100202));
            }
            else {
                pathView.getPremiumReward().setText((CharSequence)(((String)this.currentPathway.getPremiumRewards().get(i)).split("\\s*#\\s*")[1] + " Avatar"));
            }
            pathView.getFreeRewardIcon().setImageDrawable(this.activity.GetImage(n3));
            pathView.getPremiumRewardIcon().setImageDrawable(this.activity.GetImage(n5));
            pathView.getFreeRewardAmount().setText((CharSequence)this.activity.FormatExp((long)this.currentPathway.getFreeRewardAmounts().get(i)));
            pathView.getPremiumRewardAmount().setText((CharSequence)this.activity.FormatExp((long)this.currentPathway.getPremiumRewardAmounts().get(i)));
            this.SetProgress(pathView, i);
            this.pathwayLevels.addView((View)constraintLayout);
            if (this.activity.baseTower.baseTowerLevel < 50) {
                pathView.getPadlock().setVisibility(0);
                pathView.getPremiumReward().setAlpha(0.3f);
                pathView.getPremiumRewardIcon().setAlpha(0.3f);
                pathView.getPremiumRewardAmount().setAlpha(0.3f);
            }
            this.UpdateClaims(pathView, i);
            this.pathViews.add((Object)pathView);
        }
        this.UpdateSkipButton();
    }
    
    private boolean GotEquipment() {
        final String s = (String)this.currentPathway.getEquipment().get(this.myPath.getLevel());
        return s.equals((Object)"None") || this.activity.combatManager.equippedItems.contains((Object)s) || this.activity.alchemy.activePotions.contains((Object)s) || this.activity.equippedFood.equals((Object)s);
    }
    
    private boolean InventorySpace(final String s) {
        return s.equals((Object)"Casket of Treasure") || s.equals((Object)"Challenge Coin") || s.equals((Object)"Enhancement Ticket") || s.equals((Object)"Gold Coin") || s.equals((Object)"Soul Gem") || s.equals((Object)"Slayer Casket") || s.contains((CharSequence)"Avatar") || s.contains((CharSequence)"Title") || this.activity.InventoryNotFull(s);
    }
    
    private void SetPath(final DocumentSnapshot documentSnapshot) {
        final String string = documentSnapshot.getString("id");
        final String string2 = documentSnapshot.getString("month");
        final Boolean boolean1 = documentSnapshot.getBoolean("available");
        final int n = 0;
        final Boolean value = false;
        final boolean booleanValue = (boolean)DatabaseManager$$ExternalSyntheticBackport0.m((Object)boolean1, (Object)value);
        final String string3 = documentSnapshot.getString("skills");
        final String string4 = documentSnapshot.getString("methods");
        final String string5 = documentSnapshot.getString("equipment");
        final String string6 = documentSnapshot.getString("rewards");
        final String string7 = documentSnapshot.getString("premiumrewards");
        this.currentPathway = new CurrentPathway(string, string2, booleanValue);
        this.activity.runOnUiThread((Runnable)new SecretPathway$$ExternalSyntheticLambda0(this));
        this.activity.LogIt("Pathway available: " + this.currentPathway.isAvailable() + " tester: " + this.pathTesters.contains((Object)this.databaseManager.activeDisplayName) + " " + this.databaseManager.activeDisplayName);
        this.grabbedPath = true;
        if (!this.currentPathway.isAvailable() && !this.pathTesters.contains((Object)this.databaseManager.activeDisplayName)) {
            return;
        }
        if (string3 != null && string4 != null && string5 != null && string6 != null) {
            if (string7 != null) {
                this.currentPathway.skills = (List<String>)Arrays.asList((Object[])string3.split("\\s*/\\s*"));
                this.currentPathway.methods = (List<String>)Arrays.asList((Object[])string4.split("\\s*/\\s*"));
                this.currentPathway.equipment = (List<String>)Arrays.asList((Object[])string5.split("\\s*/\\s*"));
                final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])string6.split("\\s*/\\s*")));
                final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])string7.split("\\s*/\\s*")));
                for (int i = 0; i < ((List)list).size(); ++i) {
                    final String[] split = ((String)((List)list).get(i)).split("\\s*,\\s*");
                    this.currentPathway.freeRewards.add((Object)split[0]);
                    this.currentPathway.freeRewardAmounts.add((Object)Long.parseLong(split[1]));
                }
                for (int j = 0; j < ((List)list2).size(); ++j) {
                    final String[] split2 = ((String)((List)list2).get(j)).split("\\s*,\\s*");
                    this.currentPathway.premiumRewards.add((Object)split2[0]);
                    this.currentPathway.premiumRewardAmounts.add((Object)Long.parseLong(split2[1]));
                }
                if (!this.myPath.getId().equals((Object)this.currentPathway.getId())) {
                    this.myPath.id = this.currentPathway.getId();
                    this.myPath.level = 0;
                    if (!this.currentPathway.getEquipment().isEmpty()) {
                        this.myPath.hint = this.GeneratePathHint();
                    }
                    this.myPath.claimedFree.clear();
                    for (int k = 0; k < this.currentPathway.freeRewards.size(); ++k) {
                        this.myPath.claimedFree.add((Object)value);
                    }
                    this.myPath.claimedPremium.clear();
                    for (int l = n; l < this.currentPathway.premiumRewards.size(); ++l) {
                        this.myPath.claimedPremium.add((Object)value);
                    }
                }
                else if (this.myPath.getHint().isEmpty() && !this.currentPathway.getEquipment().isEmpty()) {
                    this.myPath.hint = this.GeneratePathHint();
                }
            }
        }
    }
    
    private void SetProgress(final PathView pathView, final int n) {
        if (this.myPath.getLevel() == n) {
            pathView.getProgressBar().setProgress(1);
        }
        if (this.myPath.getLevel() > n) {
            pathView.getProgressBar().setProgress(2);
        }
        if (this.myPath.getLevel() < n) {
            pathView.getProgressBar().setProgress(0);
        }
    }
    
    private void UpdateClaims(final PathView pathView, final int n) {
        if (this.myPath.getLevel() > n) {
            if (!(boolean)this.myPath.getClaimedFree().get(n)) {
                this.activity.ShowView((View)pathView.getClaimFreeReward());
                pathView.getClaimFreeReward().setOnClickListener((View$OnClickListener)new SecretPathway$$ExternalSyntheticLambda6(this, pathView, n));
            }
            else {
                this.activity.HideView((View)pathView.getClaimFreeReward());
            }
            if (this.activity.baseTower.baseTowerLevel >= 50) {
                if (!(boolean)this.myPath.getClaimedPremium().get(n)) {
                    this.activity.ShowView((View)pathView.getClaimPremiumReward());
                    pathView.getClaimPremiumReward().setOnClickListener((View$OnClickListener)new SecretPathway$$ExternalSyntheticLambda7(this, pathView, n));
                }
                else {
                    this.activity.HideView((View)pathView.getClaimPremiumReward());
                }
            }
        }
    }
    
    private void UpdatePathway() {
        if (this.myPath.getLevel() < this.currentPathway.getSkills().size()) {
            this.currentPathNumber.setText((CharSequence)("You are currently looking to find Path " + (this.myPath.getLevel() + 1)));
        }
        else {
            this.currentPathNumber.setText((CharSequence)"You have completed this months pathway, congratulations!");
        }
        ((TextView)this.secretPath.findViewById(2131297131)).setText((CharSequence)("You have " + this.myPath.getGoldenTickets() + " Golden Tickets."));
        for (int i = 0; i < this.pathwayLevels.getChildCount(); ++i) {
            final PathView pathView = (PathView)this.pathViews.get(i);
            this.SetProgress(pathView, i);
            this.UpdateClaims(pathView, i);
            if (this.activity.baseTower.baseTowerLevel < 50) {
                pathView.getPadlock().setVisibility(0);
                pathView.getPremiumReward().setAlpha(0.3f);
                pathView.getPremiumRewardIcon().setAlpha(0.3f);
                pathView.getPremiumRewardAmount().setAlpha(0.3f);
            }
            else {
                pathView.getPadlock().setVisibility(8);
                pathView.getPremiumReward().setAlpha(1.0f);
                pathView.getPremiumRewardIcon().setAlpha(1.0f);
                pathView.getPremiumRewardAmount().setAlpha(1.0f);
            }
        }
        this.UpdateSkipButton();
    }
    
    private void UpdateSkipButton() {
        if (this.myPath.getLevel() < this.currentPathway.getSkills().size() - 1) {
            this.skipButton.setVisibility(0);
            final ConstraintLayout$LayoutParams layoutParams = (ConstraintLayout$LayoutParams)this.skipButton.getLayoutParams();
            layoutParams.topMargin = this.activity.GetResource(2131101105) + this.activity.GetResource(2131101105) * this.myPath.getLevel() - this.activity.GetResource(2131099680);
            this.skipButton.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            this.skipButton.setOnClickListener((View$OnClickListener)new SecretPathway$$ExternalSyntheticLambda8(this));
        }
        else {
            this.skipButton.setVisibility(8);
        }
    }
    
    public void CheckPathway(final String s, final String s2) {
        final CurrentPathway currentPathway = this.currentPathway;
        if (currentPathway != null && currentPathway.isAvailable() && this.myPath.getLevel() < this.currentPathway.getSkills().size() && ((String)this.currentPathway.getSkills().get(this.myPath.getLevel())).equals((Object)s)) {
            final boolean equals = ((String)this.currentPathway.getMethods().get(this.myPath.getLevel())).equals((Object)s2);
            final int n = 500;
            if (equals) {
                if (this.GotEquipment()) {
                    int n2 = n;
                    if (!s.equals((Object)"Farming")) {
                        if (s.equals((Object)"Slayer")) {
                            n2 = n;
                        }
                        else {
                            n2 = 1250;
                        }
                    }
                    final int getWishLevel = this.activity.databaseManager.GetWishLevel("Path Hunter", "Endgame");
                    int n3 = n2;
                    if (getWishLevel > 0) {
                        n3 = n2 - n2 / 100 * getWishLevel;
                    }
                    if (this.activity.GetRandom(1, n3) <= 1) {
                        final MyPath myPath = this.myPath;
                        ++myPath.level;
                        this.activity.runOnUiThread((Runnable)new SecretPathway$$ExternalSyntheticLambda2(this));
                        final int getWishLevel2 = this.activity.databaseManager.GetWishLevel("Golden Ticket", "Endgame");
                        if (getWishLevel2 > 0 && this.activity.GetRandom(1, 100) <= getWishLevel2) {
                            final MyPath myPath2 = this.myPath;
                            ++myPath2.goldenTickets;
                            this.activity.runOnUiThread((Runnable)new SecretPathway$$ExternalSyntheticLambda3(this));
                        }
                    }
                }
                else if (this.activity.combatManager.equippedItems.contains((Object)"Ring of Secrets") && this.activity.GetRandom(1, 500) <= 1) {
                    this.activity.runOnUiThread((Runnable)new SecretPathway$$ExternalSyntheticLambda4(this));
                }
            }
            else if (this.activity.combatManager.equippedItems.contains((Object)"Ring of Secrets") && this.activity.GetRandom(1, 500) <= 1) {
                this.activity.runOnUiThread((Runnable)new SecretPathway$$ExternalSyntheticLambda5(this));
            }
        }
    }
    
    public void GetCurrentPath() {
        this.databaseManager.db.collection("secretpathway").document("pathway").get().addOnSuccessListener((OnSuccessListener)new OnSuccessListener<DocumentSnapshot>(this) {
            final SecretPathway this$0;
            
            public void onSuccess(final DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    this.this$0.SetPath(documentSnapshot);
                }
            }
        });
    }
    
    public void OpenPathway() {
        if (!this.grabbedPath) {
            this.activity.QuickPopup("Path hasn't been grabbed yet! Try again in a bit!");
            this.activity.LogIt("Not grabbed path yet");
            return;
        }
        final CurrentPathway currentPathway = this.currentPathway;
        if (currentPathway == null) {
            this.activity.QuickPopup("The Secret Pathway isn't currently available, please try again later!");
            this.activity.LogIt("Pathway null");
            return;
        }
        if (currentPathway.getSkills().isEmpty()) {
            this.activity.QuickPopup("The Secret Pathway isn't currently available, please try again later!");
            this.activity.LogIt("Pathway empty");
            return;
        }
        final MainActivity activity = this.activity;
        activity.ShowView(activity.findViewById(2131296964));
        if (this.secretPath == null) {
            final ScrollView secretPath = (ScrollView)((ViewStub)this.activity.findViewById(2131297085)).inflate();
            this.secretPath = secretPath;
            this.monthTv = (TextView)secretPath.findViewById(2131296859);
            this.clueTv = (TextView)this.secretPath.findViewById(2131296457);
            this.pathwayLevels = (LinearLayout)this.secretPath.findViewById(2131296975);
            this.skipButton = (ConstraintLayout)this.secretPath.findViewById(2131297129);
            this.currentPathNumber = (TextView)this.secretPath.findViewById(2131296505);
        }
        if (this.myPath.getLevel() < this.currentPathway.getSkills().size()) {
            this.currentPathNumber.setText((CharSequence)("You are currently looking to find Path " + (this.myPath.getLevel() + 1)));
        }
        else {
            this.currentPathNumber.setText((CharSequence)"You have completed this months pathway, congratulations!");
        }
        this.monthTv.setText((CharSequence)this.currentPathway.getMonth());
        ((TextView)this.secretPath.findViewById(2131297131)).setText((CharSequence)("You have " + this.myPath.getGoldenTickets() + " Golden Tickets."));
        this.clueTv.setText((CharSequence)("Level 1 this month is " + (String)this.currentPathway.getSkills().get(0) + " " + (String)this.currentPathway.getMethods().get(0) + "!\n" + this.myPath.getHint()));
        final MainActivity activity2 = this.activity;
        activity2.HideView(activity2.currentView);
        (this.activity.currentView = (View)this.secretPath).setAlpha(0.0f);
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.DisableScreen();
        this.activity.currentView.post((Runnable)new SecretPathway$$ExternalSyntheticLambda1(this));
    }
    
    public static class CurrentPathway
    {
        boolean available;
        List<String> equipment;
        List<Long> freeRewardAmounts;
        List<String> freeRewards;
        String id;
        List<String> methods;
        String month;
        List<Long> premiumRewardAmounts;
        List<String> premiumRewards;
        List<String> skills;
        
        public CurrentPathway(final String id, final String month, final boolean available) {
            this.id = id;
            this.available = available;
            this.month = month;
            this.skills = (List<String>)new ArrayList();
            this.methods = (List<String>)new ArrayList();
            this.equipment = (List<String>)new ArrayList();
            this.freeRewards = (List<String>)new ArrayList();
            this.premiumRewards = (List<String>)new ArrayList();
            this.freeRewardAmounts = (List<Long>)new ArrayList();
            this.premiumRewardAmounts = (List<Long>)new ArrayList();
        }
        
        public List<String> getEquipment() {
            return this.equipment;
        }
        
        public List<Long> getFreeRewardAmounts() {
            return this.freeRewardAmounts;
        }
        
        public List<String> getFreeRewards() {
            return this.freeRewards;
        }
        
        public String getId() {
            return this.id;
        }
        
        public List<String> getMethods() {
            return this.methods;
        }
        
        public String getMonth() {
            return this.month;
        }
        
        public List<Long> getPremiumRewardAmounts() {
            return this.premiumRewardAmounts;
        }
        
        public List<String> getPremiumRewards() {
            return this.premiumRewards;
        }
        
        public List<String> getSkills() {
            return this.skills;
        }
        
        public boolean isAvailable() {
            return this.available;
        }
    }
    
    public static class MyPath
    {
        List<Boolean> claimedFree;
        List<Boolean> claimedPremium;
        long goldenTickets;
        String hint;
        String id;
        int level;
        
        public MyPath() {
            this.id = "";
            this.level = 0;
            this.goldenTickets = 0L;
            this.claimedFree = (List<Boolean>)new ArrayList();
            this.claimedPremium = (List<Boolean>)new ArrayList();
            this.hint = "";
        }
        
        public List<Boolean> getClaimedFree() {
            return this.claimedFree;
        }
        
        public List<Boolean> getClaimedPremium() {
            return this.claimedPremium;
        }
        
        public long getGoldenTickets() {
            return this.goldenTickets;
        }
        
        public String getHint() {
            return this.hint;
        }
        
        public String getId() {
            return this.id;
        }
        
        public int getLevel() {
            return this.level;
        }
    }
    
    public static class PathView
    {
        TextView claimFreeReward;
        TextView claimPremiumReward;
        TextView freeReward;
        TextView freeRewardAmount;
        ImageView freeRewardIcon;
        TextView level;
        ImageView padlock;
        TextView premiumReward;
        TextView premiumRewardAmount;
        ImageView premiumRewardIcon;
        ProgressBar progressBar;
        ConstraintLayout view;
        
        public PathView(final ConstraintLayout view) {
            this.view = view;
            this.progressBar = (ProgressBar)view.findViewById(2131297314);
            this.freeReward = (TextView)view.findViewById(2131296665);
            this.premiumReward = (TextView)view.findViewById(2131296990);
            this.freeRewardIcon = (ImageView)view.findViewById(2131296664);
            this.premiumRewardIcon = (ImageView)view.findViewById(2131296989);
            this.freeRewardAmount = (TextView)view.findViewById(2131296663);
            this.premiumRewardAmount = (TextView)view.findViewById(2131296988);
            this.level = (TextView)view.findViewById(2131296972);
            this.padlock = (ImageView)view.findViewById(2131296963);
            this.claimFreeReward = (TextView)view.findViewById(2131296446);
            this.claimPremiumReward = (TextView)view.findViewById(2131296447);
        }
        
        public TextView getClaimFreeReward() {
            return this.claimFreeReward;
        }
        
        public TextView getClaimPremiumReward() {
            return this.claimPremiumReward;
        }
        
        public TextView getFreeReward() {
            return this.freeReward;
        }
        
        public TextView getFreeRewardAmount() {
            return this.freeRewardAmount;
        }
        
        public ImageView getFreeRewardIcon() {
            return this.freeRewardIcon;
        }
        
        public TextView getLevel() {
            return this.level;
        }
        
        public ImageView getPadlock() {
            return this.padlock;
        }
        
        public TextView getPremiumReward() {
            return this.premiumReward;
        }
        
        public TextView getPremiumRewardAmount() {
            return this.premiumRewardAmount;
        }
        
        public ImageView getPremiumRewardIcon() {
            return this.premiumRewardIcon;
        }
        
        public ProgressBar getProgressBar() {
            return this.progressBar;
        }
        
        public ConstraintLayout getView() {
            return this.view;
        }
    }
}
