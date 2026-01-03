package uk.playdrop.cherrytree_idletextrpg;

import com.google.firebase.Timestamp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentSnapshot;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails;
import com.android.billingclient.api.ProductDetails;
import android.view.ViewStub;
import java.util.Date;
import com.squareup.picasso.Picasso;
import java.util.HashMap;
import com.google.firebase.firestore.FieldValue;
import android.text.style.ForegroundColorSpan;
import android.text.SpannableString;
import android.os.Handler;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Context;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import java.util.List;
import com.google.firebase.firestore.DocumentReference;
import android.widget.EditText;
import android.widget.TextView;

public class Friends
{
    MainActivity activity;
    TextView addFriend;
    EditText addFriendInput;
    long coinsReceived;
    DocumentReference coinsRef;
    long coinsSent;
    List<String> coinsSentTo;
    DatabaseManager databaseManager;
    LinearLayout friendCoinsReceived;
    LinearLayout friendCoinsSent;
    ScrollView friendInfo;
    ScrollView friendScreen;
    ScrollView friendShop;
    List<Long> friendShopAmounts;
    List<Long> friendShopCosts;
    List<String> friendShopDescriptions;
    List<String> friendShopItems;
    LinearLayout friendShopWrapper;
    List<String> friendUsernames;
    LinearLayout friendsList;
    List<String> friendsMaxed;
    List<Long> giftAmounts;
    List<String> giftLoot;
    List<Float> giftOdds;
    LinearLayout giftPack1;
    LinearLayout giftPack2;
    boolean gotData;
    LayoutInflater inflater;
    long lastCheck;
    long lastCoinSent;
    int maxFriends;
    List<Friend> myFriends;
    TextView openShop;
    long receiveLimit;
    List<String> receivedFrom;
    long sendLimit;
    TextView sendSelfCoin;
    TextView sendSelfGift;
    
    public Friends(final MainActivity activity, final DatabaseManager databaseManager) {
        this.myFriends = (List<Friend>)new ArrayList();
        this.friendUsernames = (List<String>)new ArrayList();
        this.coinsSentTo = (List<String>)new ArrayList();
        this.friendsMaxed = (List<String>)new ArrayList();
        this.maxFriends = 40;
        this.sendLimit = 40L;
        this.receiveLimit = 40L;
        this.lastCheck = 0L;
        this.lastCoinSent = 0L;
        this.gotData = false;
        this.giftLoot = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Magnet of Copina", "Blessed Eternal Sacrifice", "Wings of Cognium", "Golden Ticket", "Enhancement Ticket", "Death Princess Rune", "Blessed Sacrifice", "Scythe of Aurial", "Cognium Ring", "Rod of Copina", "Eternal Ring", "Mystic Staff", "Massive Exp Scroll", "Gold Coin", "Challenge Coin", "Soul Reaper Potion", "Divine Protection Potion" }));
        final Long value = 1L;
        final Long value2 = 10L;
        final Long value3 = 50L;
        this.giftAmounts = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value, value, value, value, value2, value, value, value, value, value, value, value, 2L, 1000000L, value2, value3, value3 }));
        this.giftOdds = (List<Float>)new ArrayList((Collection)Arrays.asList((Object[])new Float[] { 0.1f, 0.22f, 0.37f, 0.55f, 0.75f, 1.0f, 1.3f, 1.65f, 2.05f, 2.5f, 3.0f, 3.7f, 5.2f, 8.2f, 13.2f, 20.2f, 29.2f }));
        this.friendShopItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "the Friendly", "the Best Friend", "the Popular One", "the Superstar", "Sword of Friendship", "Shield of Friendship", "Bow of Friendship", "Casket of Treasure", "Slayer Casket", "Gold Coin", "Friendship Gift", "Fragment of Secrets 3", "Fragment of Secrets 4", "Golden Ticket" }));
        this.friendShopDescriptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Unlocks the title, the Friendly", "Unlocks the title, the Best Friend", "Unlocks the title, the Popular One", "Unlocks the title, the Superstar", "Damage increases by 5% per mutual friend you have", "1% chance per mutual friend to heal 25% of your damage per hit", "Damage increases by 5% per mutual friend you have", "Grants 50 Treasure Caskets", "Grants 50 Slayer Caskets", "Grants 50k Gold Coins", "Grants a gift you can send to a friend. More information on Gifts below.", "Used to craft the Ring of Secrets", "Used to craft the Ring of Secrets", "Allows you to skip a level of the Secret Pathway" }));
        this.friendShopAmounts = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value, value, value, value, value, value, value, value3, value3, 50000L, value, value, value, value }));
        this.friendShopCosts = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { value3, 300L, 750L, 1500L, 1000L, 750L, 1250L, 20L, 20L, value2, value3, 1500L, 1200L, 350L }));
        this.receivedFrom = (List<String>)new ArrayList();
        this.activity = activity;
        this.databaseManager = databaseManager;
        this.inflater = LayoutInflater.from((Context)activity);
        this.GetFriends();
    }
    
    private void AddFriend(final String s) {
        if (!this.friendUsernames.contains((Object)s) && this.friendUsernames.size() < this.maxFriends) {
            this.friendUsernames.add((Object)s);
            this.myFriends.add((Object)new Friend(s));
            this.UpdateFriendsList();
            this.activity.runOnUiThread((Runnable)new Friends$$ExternalSyntheticLambda83(this));
            final List<Friend> myFriends = this.myFriends;
            this.GetFriendData((Friend)myFriends.get(myFriends.size() - 1), true);
        }
        else {
            this.activity.runOnUiThread((Runnable)new Friends$$ExternalSyntheticLambda84(this));
            if (this.friendUsernames.contains((Object)s)) {
                this.activity.runOnUiThread((Runnable)new Friends$$ExternalSyntheticLambda85(this, s));
            }
            else {
                this.activity.runOnUiThread((Runnable)new Friends$$ExternalSyntheticLambda86(this));
            }
        }
    }
    
    private void AddFriendList(final Friend friend) {
        final ConstraintLayout constraintLayout = (ConstraintLayout)this.inflater.inflate(2131492953, (ViewGroup)this.friendsList, false);
        final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)constraintLayout.getLayoutParams();
        if (this.friendsList.getChildCount() > 0) {
            layoutParams.topMargin = this.activity.GetResource(2131100202);
        }
        constraintLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.friendsList.addView((View)constraintLayout);
        final TextView textView = (TextView)constraintLayout.findViewById(2131296682);
        final ImageView imageView = (ImageView)constraintLayout.findViewById(2131296891);
        final TextView textView2 = (TextView)constraintLayout.findViewById(2131297093);
        final TextView textView3 = (TextView)constraintLayout.findViewById(2131296668);
        final TextView textView4 = (TextView)constraintLayout.findViewById(2131297021);
        textView3.setVisibility(8);
        textView4.setVisibility(8);
        textView.setText((CharSequence)friend.getUsername());
        if (friend.isMutualFriends()) {
            if (friend.getLastActivity() != null && this.databaseManager.serverDate != null) {
                textView3.setVisibility(0);
                final long getDaysBetween = this.GetDaysBetween(this.databaseManager.serverDate, friend.getLastActivity());
                if (getDaysBetween <= 0L) {
                    textView3.setText((CharSequence)"Last Active: Today");
                }
                else if (getDaysBetween == 1L) {
                    textView3.setText((CharSequence)"Last Active: Yesterday");
                }
                else {
                    textView3.setText((CharSequence)("Last Active: " + getDaysBetween + " Days ago"));
                }
            }
            imageView.setAlpha(1.0f);
            imageView.setContentDescription((CharSequence)"Mutual Friends");
            if (this.receivedFrom.contains((Object)friend.getUsername())) {
                textView4.setVisibility(0);
                textView4.setText((CharSequence)"Sent you a coin!");
            }
        }
        else {
            imageView.setAlpha(0.2f);
            imageView.setContentDescription((CharSequence)"Not Mutual Friends");
        }
        if (this.coinsSentTo.contains((Object)friend.getUsername())) {
            textView2.setAlpha(0.3f);
        }
        else {
            textView2.setAlpha(1.0f);
        }
        textView2.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda55(this, friend, textView2));
        constraintLayout.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda56(this, friend));
    }
    
    private void CheckUser(final String s, final Runnable runnable) {
        this.databaseManager.db.collection("userinfo").document(s).get().addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda7(this, runnable)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda8(this));
    }
    
    private void ContinueDeletingFriend(final Friend friend) {
        this.activity.DisableScreen();
        this.friendUsernames.remove((Object)friend.getUsername());
        this.myFriends.remove((Object)friend);
        this.activity.QuickPopup("You have removed " + friend.getUsername() + " from your Friends List");
        this.UpdateFriendsList();
        new Handler().postDelayed((Runnable)new Friends$$ExternalSyntheticLambda0(this), 600L);
    }
    
    private void ContinuePurchase(final int n) {
        if (this.databaseManager.currencies.getFriendCoins() >= (long)this.friendShopCosts.get(n)) {
            if (((List)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Sword of Friendship", "Shield of Friendship", "Bow of Friendship", "Fragment of Secrets 3", "Fragment of Secrets 4" }))).contains(this.friendShopItems.get(n)) && !this.activity.InventoryNotFull((String)this.friendShopItems.get(n))) {
                this.activity.QuickPopup("Your inventory is full!");
                return;
            }
            final String string = "Would you like to buy " + this.activity.FormatExp((long)this.friendShopAmounts.get(n)) + "x " + (String)this.friendShopItems.get(n) + " from the Friendshop for " + this.activity.FormatExp((long)this.friendShopCosts.get(n)) + " Friendship Coins?";
            final SpannableString spannableString = new SpannableString((CharSequence)string);
            final int index = string.indexOf((String)this.friendShopItems.get(n));
            spannableString.setSpan((Object)new ForegroundColorSpan(this.activity.GetColour(2131034892)), index, ((String)this.friendShopItems.get(n)).length() + index, 33);
            this.activity.ShowConfirmationPopup(2131165855, "Purchase Item", spannableString, "Yes", "No", (Runnable)new Friends$$ExternalSyntheticLambda66(this, n));
        }
        else {
            this.activity.QuickPopup("You don't have enough Friendship Coins!");
        }
    }
    
    private void ContinueSendingCoin(final Friend friend, final TextView textView) {
        this.databaseManager.db.collection("userinfo").document(friend.getUsername()).update("friendCoins", (Object)FieldValue.increment(1L), new Object[0]).addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda45(this, friend, textView)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda46(this));
    }
    
    private void CreateData(final String s) {
        final HashMap hashMap = new HashMap();
        final Integer value = 0;
        ((Map)hashMap).put((Object)"coinsSent", (Object)value);
        ((Map)hashMap).put((Object)"coinsReceived", (Object)value);
        ((Map)hashMap).put((Object)"sentTo", (Object)String.join((CharSequence)"/", (Iterable)this.coinsSentTo));
        this.databaseManager.db.collection("friendcoinssent").document(s).set((Object)hashMap).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda31(this));
    }
    
    private void DeleteFriend(final Friend friend) {
        final String username = friend.getUsername();
        final String string = "Are you sure you'd like to remove " + username + " from your Friends list?";
        final SpannableString spannableString = new SpannableString((CharSequence)string);
        final int index = string.indexOf(username);
        spannableString.setSpan((Object)new ForegroundColorSpan(this.activity.GetColour(2131034892)), index, username.length() + index, 33);
        this.activity.ShowConfirmationPopup(2131166497, "Remove Friend", spannableString, "Yes", "No", (Runnable)new Friends$$ExternalSyntheticLambda61(this, friend));
    }
    
    private void GenerateFriends() {
        this.friendsList.removeAllViews();
        for (int i = 0; i < this.myFriends.size(); ++i) {
            this.AddFriendList((Friend)this.myFriends.get(i));
        }
    }
    
    private void GenerateShop() {
        for (int i = 0; i < this.friendShopItems.size(); ++i) {
            final ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.activity, 2131492905, (ViewGroup)null);
            this.friendShopWrapper.addView((View)constraintLayout);
            final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)constraintLayout.getLayoutParams();
            layoutParams.topMargin = this.activity.GetResource(2131100202);
            layoutParams.leftMargin = this.activity.GetResource(2131100202);
            layoutParams.rightMargin = this.activity.GetResource(2131100202);
            constraintLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            int n = 1;
            ((TextView)constraintLayout.getChildAt(1)).setText((CharSequence)this.friendShopItems.get(i));
            ((TextView)constraintLayout.getChildAt(2)).setText((CharSequence)this.friendShopDescriptions.get(i));
            ((TextView)constraintLayout.getChildAt(3)).setText((CharSequence)this.activity.FormatExp((long)this.friendShopCosts.get(i)));
            final String s = (String)this.friendShopItems.get(i);
            s.hashCode();
            Label_0347: {
                switch (s.hashCode()) {
                    case 1368625968: {
                        if (!s.equals((Object)"the Popular One")) {
                            break;
                        }
                        n = 4;
                        break Label_0347;
                    }
                    case 349475627: {
                        if (!s.equals((Object)"the Best Friend")) {
                            break;
                        }
                        n = 3;
                        break Label_0347;
                    }
                    case 224325123: {
                        if (!s.equals((Object)"Golden Ticket")) {
                            break;
                        }
                        n = 2;
                        break Label_0347;
                    }
                    case -560190658: {
                        if (!s.equals((Object)"the Superstar")) {
                            break;
                        }
                        break Label_0347;
                    }
                    case -1846060134: {
                        if (!s.equals((Object)"the Friendly")) {
                            break;
                        }
                        n = 0;
                        break Label_0347;
                    }
                }
                n = -1;
            }
            int intValue = 0;
            switch (n) {
                default: {
                    try {
                        intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf(this.friendShopItems.get(i)));
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        intValue = 2131166497;
                    }
                    break;
                }
                case 2: {
                    intValue = 2131165478;
                    break;
                }
                case 0:
                case 1:
                case 3:
                case 4: {
                    intValue = 2131165520;
                    break;
                }
            }
            Picasso.get().load(intValue).into((ImageView)constraintLayout.getChildAt(0));
            constraintLayout.getChildAt(3).setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda23(this, i));
        }
    }
    
    private long GetDaysBetween(final Date date, final Date date2) {
        return (date.getTime() - date2.getTime()) / 86400000L;
    }
    
    private void GetFriendData(final Friend friend, final boolean b) {
        this.databaseManager.db.collection("friends").document(friend.getUsername()).get().addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda38(this, friend, b));
    }
    
    private String GetGiftOdds(final int n) {
        final List<Float> giftOdds = this.giftOdds;
        final float floatValue = (float)giftOdds.get(giftOdds.size() - 1);
        final StringBuilder sb = new StringBuilder("1 / ");
        if (n == 0) {
            return sb.append(Math.round(floatValue / (float)this.giftOdds.get(n))).toString();
        }
        return sb.append(Math.round(floatValue / ((float)this.giftOdds.get(n) - (float)this.giftOdds.get(n - 1)))).toString();
    }
    
    private boolean InvalidCharacters(final String s) {
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= 29) {
                break;
            }
            if (s.contains((CharSequence)(new String[] { "/", ",", ".", ";", ":", "?", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=", "[", "]", "{", "}", "|", "\\", "<", ">", "/", "`", "~" })[n])) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    private void OpenFriendshop() {
        final MainActivity activity = this.activity;
        activity.ShowView(activity.findViewById(2131296964));
        if (this.friendShop == null) {
            final ScrollView friendShop = (ScrollView)((ViewStub)this.activity.findViewById(2131296676)).inflate();
            this.friendShop = friendShop;
            this.friendShopWrapper = (LinearLayout)friendShop.findViewById(2131296683);
            this.giftPack1 = (LinearLayout)this.friendShop.findViewById(2131296692);
            this.giftPack2 = (LinearLayout)this.friendShop.findViewById(2131296693);
        }
        if (this.activity.billingInitialized && !this.activity.inAppProducts.isEmpty() && this.activity.skuNames.contains((Object)"friendship_gifts1") && this.activity.skuNames.contains((Object)"friendship_gifts2")) {
            final ProductDetails productDetails = (ProductDetails)this.activity.inAppProducts.get(this.activity.skuNames.indexOf((Object)"friendship_gifts1"));
            final ProductDetails productDetails2 = (ProductDetails)this.activity.inAppProducts.get(this.activity.skuNames.indexOf((Object)"friendship_gifts2"));
            ((TextView)this.giftPack1.getChildAt(3)).setText((CharSequence)DatabaseManager$$ExternalSyntheticBackport0.m((Object)((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)productDetails.getOneTimePurchaseOfferDetails())).getFormattedPrice(), (Object)"Error"));
            ((TextView)this.giftPack2.getChildAt(3)).setText((CharSequence)DatabaseManager$$ExternalSyntheticBackport0.m((Object)((ProductDetails$OneTimePurchaseOfferDetails)Objects.requireNonNull((Object)productDetails2.getOneTimePurchaseOfferDetails())).getFormattedPrice(), (Object)"Error"));
            this.giftPack1.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda2(this, productDetails));
            this.giftPack2.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda3(this, productDetails2));
        }
        final MainActivity activity2 = this.activity;
        activity2.HideView(activity2.currentView);
        (this.activity.currentView = (View)this.friendShop).setAlpha(0.0f);
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.DisableScreen();
        this.friendShop.findViewById(2131297317).setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda4(this));
        this.friendShop.findViewById(2131297036).setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda5(this));
        if (this.friendShopWrapper.getChildCount() == 0) {
            this.GenerateShop();
        }
        this.activity.currentView.post((Runnable)new Friends$$ExternalSyntheticLambda6(this));
    }
    
    private void OpenSelfGift() {
        this.databaseManager.ShowConnecting();
        final DatabaseManager.Currencies currencies = this.databaseManager.currencies;
        --currencies.friendGifts;
        this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("friendGifts", (Object)this.databaseManager.currencies.getFriendGifts(), new Object[0]).addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda69(this)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda70(this));
    }
    
    private void PurchaseItem(final int n) {
        this.databaseManager.ShowConnecting();
        final DatabaseManager.Currencies currencies = this.databaseManager.currencies;
        currencies.friendCoins -= (long)this.friendShopCosts.get(n);
        this.UpdateShopCoins();
        this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("friendCoins", (Object)this.databaseManager.currencies.getFriendCoins(), new Object[0]).addOnSuccessListener((OnSuccessListener)new OnSuccessListener<Void>(this, n) {
            final Friends this$0;
            final int val$index;
            
            public void onSuccess(final Void void1) {
                final String s = (String)this.this$0.friendShopItems.get(this.val$index);
                s.hashCode();
                final int hashCode = s.hashCode();
                int n = -1;
                switch (hashCode) {
                    case 1368625968: {
                        if (!s.equals((Object)"the Popular One")) {
                            break;
                        }
                        n = 8;
                        break;
                    }
                    case 1253687303: {
                        if (!s.equals((Object)"Slayer Casket")) {
                            break;
                        }
                        n = 7;
                        break;
                    }
                    case 658894417: {
                        if (!s.equals((Object)"Gold Coin")) {
                            break;
                        }
                        n = 6;
                        break;
                    }
                    case 349475627: {
                        if (!s.equals((Object)"the Best Friend")) {
                            break;
                        }
                        n = 5;
                        break;
                    }
                    case 224325123: {
                        if (!s.equals((Object)"Golden Ticket")) {
                            break;
                        }
                        n = 4;
                        break;
                    }
                    case -560190658: {
                        if (!s.equals((Object)"the Superstar")) {
                            break;
                        }
                        n = 3;
                        break;
                    }
                    case -819624483: {
                        if (!s.equals((Object)"Casket of Treasure")) {
                            break;
                        }
                        n = 2;
                        break;
                    }
                    case -1405765706: {
                        if (!s.equals((Object)"Friendship Gift")) {
                            break;
                        }
                        n = 1;
                        break;
                    }
                    case -1846060134: {
                        if (!s.equals((Object)"the Friendly")) {
                            break;
                        }
                        n = 0;
                        break;
                    }
                }
                switch (n) {
                    default: {
                        this.this$0.activity.runOnUiThread((Runnable)new Friends$5$$ExternalSyntheticLambda3(this, this.val$index));
                        break;
                    }
                    case 7: {
                        final CombatManager$SlayerInfo slayerInfo = this.this$0.activity.combatManager.slayerInfo;
                        slayerInfo.slayerCaskets += (long)this.this$0.friendShopAmounts.get(this.val$index);
                        break;
                    }
                    case 6: {
                        final MainActivity activity = this.this$0.activity;
                        activity.totalGems += (long)this.this$0.friendShopAmounts.get(this.val$index);
                        this.this$0.activity.runOnUiThread((Runnable)new Friends$5$$ExternalSyntheticLambda1(this));
                        break;
                    }
                    case 4: {
                        final SecretPathway$MyPath myPath = this.this$0.activity.secretPathway.myPath;
                        ++myPath.goldenTickets;
                        break;
                    }
                    case 2: {
                        final TreasureHunts$MyTreasureHunts myTreasureHunts = this.this$0.activity.treasureHunts.myTreasureHunts;
                        myTreasureHunts.caskets += (int)(long)this.this$0.friendShopAmounts.get(this.val$index);
                        break;
                    }
                    case 1: {
                        final DatabaseManager.Currencies currencies = this.this$0.databaseManager.currencies;
                        ++currencies.friendGifts;
                        this.this$0.activity.runOnUiThread((Runnable)new Friends$5$$ExternalSyntheticLambda2(this));
                        this.this$0.databaseManager.db.collection("userinfo").document(this.this$0.databaseManager.activeDisplayName).update("friendGifts", (Object)this.this$0.databaseManager.currencies.getFriendGifts(), new Object[0]);
                        break;
                    }
                    case 0:
                    case 3:
                    case 5:
                    case 8: {
                        this.this$0.activity.runOnUiThread((Runnable)new Friends$5$$ExternalSyntheticLambda0(this, this.val$index));
                        break;
                    }
                }
                this.this$0.activity.runOnUiThread((Runnable)new Friends$5$$ExternalSyntheticLambda4(this, this.val$index));
            }
        }).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda47(this, n));
    }
    
    private void SendCoin(final Friend friend, final TextView textView) {
        if (this.coinsSentTo.contains((Object)friend.getUsername())) {
            this.activity.QuickPopup("You have already sent this user a Friend Coin today.");
        }
        else if (!this.friendsMaxed.contains((Object)friend.getUsername())) {
            this.lastCoinSent = System.currentTimeMillis();
            this.databaseManager.ShowConnecting();
            this.databaseManager.db.collection("friendcoinssent").document(friend.getUsername()).get().addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda49(this, friend, textView)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda50(this));
        }
        else {
            this.activity.QuickPopup("This user has received the max amount of Friend Coins today");
        }
    }
    
    private void SendGift(final Friend friend) {
        if (this.databaseManager.currencies.getFriendGifts() > 0L) {
            final String username = friend.getUsername();
            final String string = "You currently have " + this.databaseManager.currencies.getFriendGifts() + " Friendship Gifts\nWould you like to send a Friendship Gift to " + username + "? Your friend will receive the gift in their trades, and it will open upon collection. Once the gift is sent you can not get it back, so are you sure you'd like to send it?";
            final SpannableString spannableString = new SpannableString((CharSequence)string);
            final int index = string.indexOf(username);
            spannableString.setSpan((Object)new ForegroundColorSpan(this.activity.GetColour(2131034892)), index, username.length() + index, 33);
            this.activity.ShowConfirmationPopup(2131165856, "Send Friendship Gift", spannableString, "Yes", "No", (Runnable)new Friends$$ExternalSyntheticLambda24(this, friend));
        }
        else {
            this.activity.QuickPopup("You do not have any Friendship Gifts to send. You can get more in the Friendshop!");
        }
    }
    
    private void SendSelfCoin() {
        this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("friendCoins", (Object)FieldValue.increment(1L), new Object[0]).addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda62(this)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda63(this));
    }
    
    private void SendSelfGift() {
        this.databaseManager.ShowConnecting();
        final DatabaseManager.Currencies currencies = this.databaseManager.currencies;
        --currencies.friendGifts;
        this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("friendGifts", (Object)this.databaseManager.currencies.getFriendGifts(), new Object[0]).addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda9(this)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda11(this));
    }
    
    private void ShowFriendInfo(final Friend friend) {
        final MainActivity activity = this.activity;
        activity.ShowView(activity.findViewById(2131296964));
        if (this.friendInfo == null) {
            this.friendInfo = (ScrollView)((ViewStub)this.activity.findViewById(2131296672)).inflate();
        }
        final TextView textView = (TextView)this.friendInfo.findViewById(2131297309);
        final TextView textView2 = (TextView)this.friendInfo.findViewById(2131297253);
        final ImageView imageView = (ImageView)this.friendInfo.findViewById(2131296361);
        final TextView textView3 = (TextView)this.friendInfo.findViewById(2131297093);
        final TextView textView4 = (TextView)this.friendInfo.findViewById(2131297096);
        final TextView textView5 = (TextView)this.friendInfo.findViewById(2131296531);
        final TextView textView6 = (TextView)this.friendInfo.findViewById(2131297247);
        final LinearLayout linearLayout = (LinearLayout)this.friendInfo.findViewById(2131296700);
        final TextView textView7 = (TextView)this.friendInfo.findViewById(2131296366);
        linearLayout.removeAllViews();
        textView7.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda12(this));
        textView.setText((CharSequence)friend.getUsername());
        if (friend.getTitle() != null && !friend.getTitle().isEmpty()) {
            textView2.setText((CharSequence)friend.getTitle());
        }
        else {
            textView2.setText((CharSequence)"No Title Found");
        }
        try {
            imageView.setImageResource((int)this.activity.avatarIcons.get((int)friend.getAvatar()));
        }
        catch (final IndexOutOfBoundsException ex) {
            imageView.setImageResource((int)this.activity.avatarIcons.get(0));
        }
        if (this.coinsSentTo.contains((Object)friend.getUsername())) {
            textView3.setAlpha(0.3f);
        }
        else {
            textView3.setAlpha(1.0f);
        }
        textView3.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda13(this, friend, textView3));
        if (this.activity.accountType.equals((Object)"Ironman")) {
            textView4.setAlpha(0.2f);
        }
        else {
            textView4.setAlpha(1.0f);
        }
        textView4.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda14(this, friend));
        textView5.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda15(this, friend));
        textView6.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda16(this, friend));
        if (friend.isMutualFriends()) {
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165384, "Amaran", this.activity.FormatExp(friend.getAmaranKills()) + " Kills"));
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165387, "Aurial", this.activity.FormatExp(friend.getAurialKills()) + " Kills"));
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165398, "Cognium", this.activity.FormatExp(friend.getCogniumKills()) + " Kills"));
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165399, "Copina", this.activity.FormatExp(friend.getCopinaKills()) + " Kills"));
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165413, "Feroxi", this.activity.FormatExp(friend.getFeroxiKills()) + " Kills"));
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165425, "Kynosian", this.activity.FormatExp(friend.getKynosianKills()) + " Kills"));
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165430, "Noctyra", this.activity.FormatExp(friend.getNoctyraKills()) + " Kills"));
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131165431, "Opulina", this.activity.FormatExp(friend.getOpulinaKills()) + " Kills"));
        }
        else {
            linearLayout.addView((View)this.activity.AddDescriptiveItemSelectItem(2131166497, "Not Mutual Friends", "You must be Mutual Friends with this user to see more of their profile information!"));
        }
        final MainActivity activity2 = this.activity;
        activity2.HideView(activity2.currentView);
        (this.activity.currentView = (View)this.friendInfo).setAlpha(0.0f);
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.DisableScreen();
        this.activity.currentView.post((Runnable)new Friends$$ExternalSyntheticLambda17(this));
    }
    
    private void ThrowSnowball(final Friend friend) {
        if (this.databaseManager.currencies.getSnowballs() > 0L) {
            final String username = friend.getUsername();
            final String string = "You currently have " + this.databaseManager.currencies.getSnowballs() + " Snowballs\nThrowing a Snowball at a friend gifts them with a Friendship Coin. Would you like throw a snowball at " + username + "?";
            final SpannableString spannableString = new SpannableString((CharSequence)string);
            final int index = string.indexOf(username);
            spannableString.setSpan((Object)new ForegroundColorSpan(this.activity.GetColour(2131034892)), index, username.length() + index, 33);
            this.activity.ShowConfirmationPopup(2131166233, "Throw Snowball", spannableString, "Yes", "No", (Runnable)new Friends$$ExternalSyntheticLambda44(this, friend));
        }
        else {
            this.activity.QuickPopup("You do not have any Snowballs to throw. You can get more while skilling throughout the Event!");
        }
    }
    
    private void UpdateCoins() {
        ((TextView)this.friendCoinsSent.getChildAt(2)).setText((CharSequence)(this.activity.FormatExp(this.coinsSent) + " / " + this.sendLimit));
        ((TextView)this.friendCoinsReceived.getChildAt(2)).setText((CharSequence)(this.activity.FormatExp(this.coinsReceived) + " / " + this.receiveLimit));
        ((TextView)this.friendScreen.findViewById(2131296900)).setText((CharSequence)("You have " + this.activity.FormatExp(this.databaseManager.currencies.getSnowballs()) + " Snowballs."));
    }
    
    private void UpdateFriendsList() {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"myFriends", (Object)String.join((CharSequence)"/", (Iterable)this.friendUsernames));
        this.databaseManager.db.collection("friends").document(this.databaseManager.activeDisplayName).update((Map)hashMap).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda72(this));
    }
    
    public void ContinueSendingGift(final Friend friend) {
        this.databaseManager.ShowConnecting();
        final DatabaseManager.Currencies currencies = this.databaseManager.currencies;
        --currencies.friendGifts;
        this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("friendGifts", (Object)this.databaseManager.currencies.getFriendGifts(), new Object[0]).addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda20(this, friend)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda22(this));
    }
    
    public void ContinueThrowingSnowball(final Friend friend) {
        this.databaseManager.ShowConnecting();
        final DatabaseManager.Currencies currencies = this.databaseManager.currencies;
        --currencies.snowballs;
        this.databaseManager.db.collection("userinfo").document(this.databaseManager.activeDisplayName).update("snowballs", (Object)this.databaseManager.currencies.getSnowballs(), new Object[0]).addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda41(this, friend)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda42(this));
    }
    
    public void GetDailyCoinInfo() {
        this.coinsRef.get().addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda87(this)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda88(this));
    }
    
    public void GetFriends() {
        if (!this.databaseManager.activeDisplayName.isEmpty()) {
            this.databaseManager.db.collection("friends").document(this.databaseManager.activeDisplayName).get().addOnSuccessListener((OnSuccessListener)new Friends$$ExternalSyntheticLambda21(this)).addOnFailureListener((OnFailureListener)new Friends$$ExternalSyntheticLambda32(this));
            this.coinsRef = this.databaseManager.db.collection("friendcoinssent").document(this.databaseManager.activeDisplayName);
            this.GetDailyCoinInfo();
        }
    }
    
    public int GetMutualFriends() {
        final Iterator iterator = this.myFriends.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            if (((Friend)iterator.next()).isMutualFriends()) {
                ++n;
            }
        }
        return n;
    }
    
    public float GetRandomFloat(final float n) {
        return this.activity.randomGenerator.nextFloat() * n;
    }
    
    public void OpenFriends() {
        if (this.databaseManager.activeDisplayName.isEmpty()) {
            this.activity.LargePopup(2131166497, "Not logged in", "You must be logged in to view your friends.");
        }
        else if (this.gotData) {
            final MainActivity activity = this.activity;
            activity.ShowView(activity.findViewById(2131296964));
            if (this.friendScreen == null) {
                final ScrollView friendScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131296677)).inflate();
                this.friendScreen = friendScreen;
                this.openShop = (TextView)friendScreen.findViewById(2131296937);
                this.addFriend = (TextView)this.friendScreen.findViewById(2131296329);
                this.friendsList = (LinearLayout)this.friendScreen.findViewById(2131296681);
                this.addFriendInput = (EditText)this.friendScreen.findViewById(2131296330);
                this.friendCoinsSent = (LinearLayout)this.friendScreen.findViewById(2131296670);
                this.friendCoinsReceived = (LinearLayout)this.friendScreen.findViewById(2131296669);
                this.sendSelfCoin = (TextView)this.friendScreen.findViewById(2131297099);
                this.sendSelfGift = (TextView)this.friendScreen.findViewById(2131297100);
            }
            this.sendSelfCoin.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda77(this));
            if (this.activity.accountType.equals((Object)"Ironman")) {
                this.sendSelfGift.setText((CharSequence)"Open a Friendship Gift");
            }
            else {
                this.sendSelfGift.setText((CharSequence)"Send yourself a Friendship Gift");
            }
            this.sendSelfGift.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda78(this));
            this.openShop.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda79(this));
            this.addFriend.setOnClickListener((View$OnClickListener)new Friends$$ExternalSyntheticLambda80(this));
            final MainActivity activity2 = this.activity;
            activity2.HideView(activity2.currentView);
            (this.activity.currentView = (View)this.friendScreen).setAlpha(0.0f);
            final MainActivity activity3 = this.activity;
            activity3.ShowView(activity3.currentView);
            this.activity.DisableScreen();
            this.activity.currentView.post((Runnable)new Friends$$ExternalSyntheticLambda81(this));
        }
        else {
            this.activity.LargePopup(2131166497, "Please Wait", "Please wait while we load your friends data.");
        }
    }
    
    public void OpenGift() {
        final List<Float> giftOdds = this.giftOdds;
        final int size = giftOdds.size();
        int n = 1;
        final float getRandomFloat = this.GetRandomFloat((float)giftOdds.get(size - 1));
        for (int i = 0; i < this.giftLoot.size(); ++i) {
            if (getRandomFloat < (float)this.giftOdds.get(i)) {
                final String s = (String)this.giftLoot.get(i);
                s.hashCode();
                Label_0209: {
                    switch (s.hashCode()) {
                        case 1721869536: {
                            if (!s.equals((Object)"Enhancement Ticket")) {
                                break;
                            }
                            n = 3;
                            break Label_0209;
                        }
                        case 658894417: {
                            if (!s.equals((Object)"Gold Coin")) {
                                break;
                            }
                            n = 2;
                            break Label_0209;
                        }
                        case 224325123: {
                            if (!s.equals((Object)"Golden Ticket")) {
                                break;
                            }
                            break Label_0209;
                        }
                        case -458446738: {
                            if (!s.equals((Object)"Challenge Coin")) {
                                break;
                            }
                            n = 0;
                            break Label_0209;
                        }
                    }
                    n = -1;
                }
                int intValue = 0;
                switch (n) {
                    default: {
                        try {
                            intValue = (int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)s));
                        }
                        catch (final IndexOutOfBoundsException ex) {
                            intValue = 2131166220;
                        }
                        this.activity.GiveItem(s, (long)this.giftAmounts.get(i), false);
                        break;
                    }
                    case 3: {
                        final ItemManager.Blessings blessings = this.activity.itemManager.blessings;
                        blessings.tickets += (long)this.giftAmounts.get(i);
                        intValue = 2131165610;
                        break;
                    }
                    case 2: {
                        final MainActivity activity = this.activity;
                        activity.totalGems += (long)this.giftAmounts.get(i);
                        this.activity.UpdateCash();
                        intValue = 2131165871;
                        break;
                    }
                    case 1: {
                        final SecretPathway$MyPath myPath = this.activity.secretPathway.myPath;
                        myPath.goldenTickets += (long)this.giftAmounts.get(i);
                        intValue = 2131165478;
                        break;
                    }
                    case 0: {
                        final Dailies dailies = this.activity.dailies;
                        dailies.challengeCoins += (int)(long)this.giftAmounts.get(i);
                        intValue = 2131165354;
                        break;
                    }
                }
                this.activity.LargePopup(intValue, "Gift Reward", "You opened the Gift and received " + this.activity.FormatExp((long)this.giftAmounts.get(i)) + "x " + s + "!");
                break;
            }
        }
    }
    
    public void UpdateShopCoins() {
        final ScrollView friendShop = this.friendShop;
        if (friendShop != null) {
            ((TextView)friendShop.findViewById(2131296502)).setText((CharSequence)("You currently have " + this.activity.FormatExp(this.databaseManager.currencies.getFriendCoins()) + " Friend Coins"));
            ((TextView)this.friendShop.findViewById(2131296691)).setText((CharSequence)("You currently have " + this.activity.FormatExp(this.databaseManager.currencies.getFriendGifts()) + " Friendship Gifts"));
        }
    }
    
    public static class Friend
    {
        long amaranKills;
        long aurialKills;
        long avatar;
        long cogniumKills;
        long copinaKills;
        long feroxiKills;
        long kynosianKills;
        Date lastActivity;
        boolean mutualFriends;
        long noctyraKills;
        long opulinaKills;
        String title;
        String username;
        
        public Friend(final String username) {
            this.username = username;
            this.mutualFriends = false;
        }
        
        public long getAmaranKills() {
            return this.amaranKills;
        }
        
        public long getAurialKills() {
            return this.aurialKills;
        }
        
        public long getAvatar() {
            return this.avatar;
        }
        
        public long getCogniumKills() {
            return this.cogniumKills;
        }
        
        public long getCopinaKills() {
            return this.copinaKills;
        }
        
        public long getFeroxiKills() {
            return this.feroxiKills;
        }
        
        public long getKynosianKills() {
            return this.kynosianKills;
        }
        
        public Date getLastActivity() {
            return this.lastActivity;
        }
        
        public long getNoctyraKills() {
            return this.noctyraKills;
        }
        
        public long getOpulinaKills() {
            return this.opulinaKills;
        }
        
        public String getTitle() {
            return this.title;
        }
        
        public String getUsername() {
            return this.username;
        }
        
        public boolean isMutualFriends() {
            return this.mutualFriends;
        }
    }
}
