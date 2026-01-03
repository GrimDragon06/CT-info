package uk.playdrop.cherrytree_idletextrpg;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FieldValue;
import android.content.Intent;
import android.view.ViewStub;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Referrals
{
    MainActivity activity;
    DatabaseManager databaseManager;
    TextView myReferralCode;
    TextView myReferralCoins;
    ScrollView referralScreen;
    LinearLayout referralShop;
    TextView shareButton;
    List<Integer> shopCosts;
    List<String> shopDescriptions;
    List<String> shopItems;
    
    public Referrals(final MainActivity activity, final DatabaseManager databaseManager) {
        final Integer value = 1;
        final Integer value2 = 2;
        this.shopItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Combat Boost", "Casket of Treasure", "Soul Gem", "Enhancement Ticket", "Gold Coin", "The 'Best Friend' Title", "The 'Real Cherry' Title" }));
        this.shopDescriptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Gives a permanent +5 bonus to all combat stats (Excluding Health, stackable)", "Gives 25 Treasure Caskets", "Grants 10 Soul Gems", "Grants an Enhancement Ticket", "Gives 10,000 Gold Coins", "Unlocks the cosmetic title 'the Best Friend'", "Unlocks the cosmetic title 'the Real Cherry'" }));
        this.shopCosts = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value, value2, value2, value, 25, 100 }));
        this.activity = activity;
        this.databaseManager = databaseManager;
    }
    
    private void GenerateShop() {
        for (int i = 0; i < this.shopItems.size(); ++i) {
            final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.activity, 2131492905, (ViewGroup)null);
            this.referralShop.addView((View)constraintLayout);
            final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)constraintLayout.getLayoutParams();
            layoutParams.topMargin = this.activity.GetResource(2131100202);
            constraintLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            int n = 1;
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)this.shopItems.get(i));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)this.shopDescriptions.get(i));
            final TextView textView = (TextView)constraintLayout.getChildAt(3);
            textView.setText((CharSequence)this.activity.FormatExp((int)this.shopCosts.get(i)));
            final String s = (String)this.shopItems.get(i);
            s.hashCode();
            Label_0293: {
                switch (s.hashCode()) {
                    case 1803406242: {
                        if (!s.equals((Object)"Soul Gem")) {
                            break;
                        }
                        n = 3;
                        break Label_0293;
                    }
                    case 1721869536: {
                        if (!s.equals((Object)"Enhancement Ticket")) {
                            break;
                        }
                        n = 2;
                        break Label_0293;
                    }
                    case -415919241: {
                        if (!s.equals((Object)"Combat Boost")) {
                            break;
                        }
                        break Label_0293;
                    }
                    case -819624483: {
                        if (!s.equals((Object)"Casket of Treasure")) {
                            break;
                        }
                        n = 0;
                        break Label_0293;
                    }
                }
                n = -1;
            }
            int intValue = 0;
            switch (n) {
                default: {
                    if (((String)this.shopItems.get(i)).contains((CharSequence)"Title")) {
                        intValue = 2131165520;
                        break;
                    }
                    intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.shopItems.get(i)));
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
                    intValue = 2131166468;
                    break;
                }
                case 0: {
                    intValue = 2131165669;
                    break;
                }
            }
            Picasso.get().load(intValue).into((ImageView)constraintLayout.getChildAt(0));
            textView.setOnClickListener((View$OnClickListener)new Referrals$$ExternalSyntheticLambda6(this, i));
        }
    }
    
    private void Purchase(final int n) {
        this.databaseManager.ShowConnecting();
        final int intValue = (int)this.shopCosts.get(n);
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute((Runnable)new Referrals$$ExternalSyntheticLambda5(this, intValue, n));
        singleThreadExecutor.shutdown();
    }
    
    private void RewardUser(final int n) {
        final DatabaseManager$Currencies currencies = this.databaseManager.currencies;
        currencies.referralPoints -= (int)this.shopCosts.get(n);
        this.UpdateShop();
        final String s = (String)this.shopItems.get(n);
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
            case 658894417: {
                if (!s.equals((Object)"Gold Coin")) {
                    break;
                }
                n2 = 4;
                break;
            }
            case 607943772: {
                if (!s.equals((Object)"The 'Real Cherry' Title")) {
                    break;
                }
                n2 = 3;
                break;
            }
            case -415919241: {
                if (!s.equals((Object)"Combat Boost")) {
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
            case -1274908291: {
                if (!s.equals((Object)"The 'Best Friend' Title")) {
                    break;
                }
                n2 = 0;
                break;
            }
        }
        switch (n2) {
            default: {
                this.activity.GiveItem((String)this.shopItems.get(n), 1L, true);
                break;
            }
            case 6: {
                final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                slayerInfo.soulGems += 10L;
                this.activity.QuickPopup("You received 10 Soul Gems");
                break;
            }
            case 5: {
                final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                ++blessings.tickets;
                this.activity.QuickPopup("You received an Enhancement Ticket");
                break;
            }
            case 4: {
                final MainActivity activity = this.activity;
                activity.totalGems += 10000L;
                this.activity.UpdateCash();
                this.activity.QuickPopup("You received 10,000 Gold Coins");
                break;
            }
            case 3: {
                this.activity.GiveTitle("the Real Cherry");
                break;
            }
            case 2: {
                final Dailies dailies = this.activity.dailies;
                dailies.dailyBonus += 5L;
                this.activity.QuickPopup("You received a +5 Combat Boost");
                break;
            }
            case 1: {
                final TreasureHunts.MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                myTreasureHunts.caskets += 25;
                this.activity.QuickPopup("You received 25 Treasure Caskets");
                break;
            }
            case 0: {
                this.activity.GiveTitle("the Best Friend");
                break;
            }
        }
    }
    
    private void UpdateShop() {
        this.myReferralCoins.setText((CharSequence)("You have " + this.activity.FormatExp(this.databaseManager.currencies.getReferralPoints()) + " Referral Coin(s)"));
    }
    
    public void OpenReferralShop() {
        if (this.referralScreen == null) {
            this.referralScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297029)).inflate();
            final ScrollView referralScreen = (ScrollView)this.activity.findViewById(2131297027);
            this.referralScreen = referralScreen;
            this.myReferralCode = (TextView)referralScreen.findViewById(2131296897);
            this.myReferralCoins = (TextView)this.referralScreen.findViewById(2131296898);
            this.referralShop = (LinearLayout)this.referralScreen.findViewById(2131297028);
            this.shareButton = (TextView)this.referralScreen.findViewById(2131297109);
        }
        this.activity.EnableLayout((ViewGroup)this.referralScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.referralScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.myReferralCode.setText((CharSequence)this.databaseManager.firebaseUser.getDisplayName());
        if (this.referralShop.getChildCount() == 0) {
            this.GenerateShop();
        }
        this.shareButton.setOnClickListener((View$OnClickListener)new Referrals$$ExternalSyntheticLambda2(this));
        this.UpdateShop();
    }
}
