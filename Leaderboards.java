package uk.playdrop.cherrytree_idletextrpg;

import android.widget.RelativeLayout;
import java.util.Iterator;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import android.view.View$OnClickListener;
import android.view.ViewStub;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.Query$Direction;
import android.view.View;
import android.text.style.ForegroundColorSpan;
import android.text.SpannableString;
import android.widget.ImageView;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.List;

public class Leaderboards
{
    MainActivity activity;
    DatabaseManager databaseManager;
    List<String> leaderboardDescriptions;
    List<Integer> leaderboardIcons;
    List<String> leaderboardNames;
    ScrollView leaderboardScreen;
    LinearLayout leaderboardWrap;
    List<Leaderboard> leaderboards;
    TextView selectLeaderboard;
    
    public Leaderboards(final MainActivity activity) {
        int i = 0;
        this.leaderboardIcons = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165384, 2131165387, 2131165398, 2131165399, 2131165413, 2131165425, 2131165430, 2131165431 }));
        this.leaderboardNames = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Amaran", "Aurial", "Cognium", "Copina", "Feroxi", "Kynosian", "Noctyra", "Opulina" }));
        this.leaderboardDescriptions = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Amaran", "Aurial", "Cognium", "Copina", "Feroxi", "Kynosian", "Noctyra", "Opulina" }));
        this.leaderboards = (List<Leaderboard>)new ArrayList();
        this.activity = activity;
        this.databaseManager = activity.databaseManager;
        while (i < this.leaderboardNames.size()) {
            this.leaderboards.add((Object)new Leaderboard());
            ++i;
        }
    }
    
    private void AddLeaderboardEntry(final String text, final String s, final long n, final long n2) {
        final ConstraintLayout constraintLayout = (ConstraintLayout)this.activity.inflater.inflate(2131492965, (ViewGroup)this.leaderboardWrap, false);
        ((TextView)constraintLayout.findViewById(2131296983)).setText((CharSequence)String.valueOf(this.leaderboardWrap.getChildCount() + 1));
        try {
            final ImageView imageView = (ImageView)constraintLayout.findViewById(2131296361);
            final MainActivity activity = this.activity;
            imageView.setImageDrawable(activity.GetImage((int)activity.avatarIcons.get((int)n)));
        }
        catch (final IndexOutOfBoundsException ex) {
            final ImageView imageView2 = (ImageView)constraintLayout.findViewById(2131296361);
            final MainActivity activity2 = this.activity;
            imageView2.setImageDrawable(activity2.GetImage((int)activity2.avatarIcons.get(0)));
        }
        final String string = text + " " + s;
        if (!s.isEmpty()) {
            final SpannableString text2 = new SpannableString((CharSequence)string);
            final int index = string.indexOf(s);
            text2.setSpan((Object)new ForegroundColorSpan(this.activity.GetColour(2131034892)), index, s.length() + index, 33);
            ((TextView)constraintLayout.findViewById(2131296901)).setText((CharSequence)text2);
        }
        else {
            ((TextView)constraintLayout.findViewById(2131296901)).setText((CharSequence)text);
        }
        ((TextView)constraintLayout.findViewById(2131296769)).setText((CharSequence)(this.activity.FormatExp(n2) + " Kills"));
        this.leaderboardWrap.addView((View)constraintLayout);
    }
    
    private void GenerateLeaderboard(final Leaderboard leaderboard) {
        for (int i = 0; i < leaderboard.getPlayers().size(); ++i) {
            this.AddLeaderboardEntry((String)leaderboard.getPlayers().get(i), (String)leaderboard.getTitles().get(i), (long)leaderboard.getAvatars().get(i), (long)leaderboard.getKills().get(i));
        }
    }
    
    private void GrabLeaderboard(final String s) {
        final Leaderboard leaderboard = (Leaderboard)this.leaderboards.get(this.leaderboardNames.indexOf((Object)s));
        this.databaseManager.ShowConnecting();
        this.databaseManager.db.collection("userinfo").orderBy(s, Query$Direction.DESCENDING).limit(10L).get().addOnSuccessListener((OnSuccessListener)new Leaderboards$$ExternalSyntheticLambda1(this, s, leaderboard)).addOnFailureListener((OnFailureListener)new Leaderboards$$ExternalSyntheticLambda2(this));
    }
    
    public void OpenLeaderboards() {
        if (this.databaseManager.db != null) {
            final MainActivity activity = this.activity;
            activity.ShowView(activity.findViewById(2131296964));
            if (this.leaderboardScreen == null) {
                final ScrollView leaderboardScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131296780)).inflate();
                this.leaderboardScreen = leaderboardScreen;
                this.selectLeaderboard = (TextView)leaderboardScreen.findViewById(2131297087);
                this.leaderboardWrap = (LinearLayout)this.leaderboardScreen.findViewById(2131296777);
            }
            this.leaderboardWrap.removeAllViews();
            this.selectLeaderboard.setText((CharSequence)"Click to select a Leaderboard");
            final MainActivity activity2 = this.activity;
            activity2.HideView(activity2.currentView);
            (this.activity.currentView = (View)this.leaderboardScreen).setAlpha(0.0f);
            final MainActivity activity3 = this.activity;
            activity3.ShowView(activity3.currentView);
            this.activity.DisableScreen();
            this.selectLeaderboard.setOnClickListener((View$OnClickListener)new Leaderboards$$ExternalSyntheticLambda3(this));
            this.activity.currentView.post((Runnable)new Leaderboards$$ExternalSyntheticLambda4(this));
        }
        else {
            this.activity.QuickPopup("Not connected to the server.");
        }
    }
    
    public static class Leaderboard
    {
        List<Long> avatars;
        List<Long> kills;
        List<String> players;
        List<String> titles;
        
        public Leaderboard() {
            this.players = (List<String>)new ArrayList();
            this.avatars = (List<Long>)new ArrayList();
            this.kills = (List<Long>)new ArrayList();
            this.titles = (List<String>)new ArrayList();
        }
        
        public List<Long> getAvatars() {
            return this.avatars;
        }
        
        public List<Long> getKills() {
            return this.kills;
        }
        
        public List<String> getPlayers() {
            return this.players;
        }
        
        public List<String> getTitles() {
            return this.titles;
        }
    }
}
