package uk.playdrop.cherrytree_idletextrpg;

import java.util.Iterator;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.view.ContextThemeWrapper;
import java.util.Collections;
import java.util.HashSet;
import android.view.ViewStub;
import com.squareup.picasso.Picasso;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import java.util.function.Function;
import java.util.Comparator;
import android.widget.ProgressBar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class Fletching
{
    MainActivity activity;
    List<FletchingItem> fletchables;
    TextView fletchingCategorySelect;
    List<String> fletchingItemCategory;
    List<Long> fletchingItemExp;
    List<Integer> fletchingItemLevel;
    List<String> fletchingItems;
    LinearLayout fletchingList;
    TextView fletchingMakeXButton;
    List<String> fletchingMaterialAmounts;
    List<String> fletchingMaterials;
    LinearLayout fletchingScreen;
    RelativeLayout fletchingSkillProgress;
    List<RelativeLayout> fletchingWraps;
    long lastFletchTime;
    List<String> shadowItems;
    
    public Fletching(final MainActivity activity) {
        final Integer value = 1;
        final Integer value2 = 10;
        final Integer value3 = 25;
        final Integer value4 = 40;
        final Integer value5 = 55;
        this.fletchingItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Evergreen Arrow Shafts", "Oak Arrow Shafts", "Maple Arrow Shafts", "Fir Arrow Shafts", "Redwood Arrow Shafts", "Cedar Arrow Shafts", "Chestnut Arrow Shafts", "Ginkgo Arrow Shafts", "Evergreen Headless Arrows", "Oak Headless Arrows", "Maple Headless Arrows", "Fir Headless Arrows", "Redwood Headless Arrows", "Cedar Headless Arrows", "Chestnut Headless Arrows", "Ginkgo Headless Arrows", "Stone Arrows", "Copper Arrows", "Iron Arrows", "Mithril Arrows", "Dragon Arrows", "Platinum Arrows", "Rhodium Arrows", "Iridium Arrows", "Queens Arrows", "Kings Arrows", "Elven Arrows", "Stone Arrowheads", "Copper Arrowheads", "Iron Arrowheads", "Mithril Arrowheads", "Dragon Arrowheads", "Platinum Arrowheads", "Rhodium Arrowheads", "Iridium Arrowheads", "Queens Arrowheads", "Kings Arrowheads", "Elven Arrowheads", "Evergreen Bow", "Oak Bow", "Maple Bow", "Fir Bow", "Redwood Bow", "Cedar Bow", "Chestnut Bow", "Ginkgo Bow", "Queens Bow", "Kings Bow", "Elven Bow", "Bow of the Shadows", "Shadow Arrowheads", "Darkstar Arrowheads", "Sandalwood Arrow Shafts", "Headless Sandalwood Arrows", "Unstrung Shadow Bow", "Darkstar Arrows", "Shadow Arrows", "Shadow Bowstring" }));
        this.fletchingMaterials = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Evergreen Log", "Oak Log", "Maple Log", "Fir Log", "Redwood Log", "Cedar Log", "Chestnut Log", "Ginkgo Log", "Evergreen Arrow Shafts,Feathers", "Oak Arrow Shafts,Feathers", "Maple Arrow Shafts,Feathers", "Fir Arrow Shafts,Feathers", "Redwood Arrow Shafts,Feathers", "Cedar Arrow Shafts,Feathers", "Chestnut Arrow Shafts,Feathers", "Ginkgo Arrow Shafts,Feathers", "Evergreen Headless Arrows,Stone Arrowheads", "Oak Headless Arrows,Copper Arrowheads", "Maple Headless Arrows,Iron Arrowheads", "Fir Headless Arrows,Mithril Arrowheads", "Redwood Headless Arrows,Dragon Arrowheads", "Cedar Headless Arrows,Platinum Arrowheads", "Chestnut Headless Arrows,Rhodium Arrowheads", "Ginkgo Headless Arrows,Iridium Arrowheads", "Ginkgo Headless Arrows,Queens Arrowheads", "Ginkgo Headless Arrows,Kings Arrowheads", "Ginkgo Headless Arrows,Elven Arrowheads", "Stone", "Copper Ore", "Iron Ore", "Mithril Ore", "Dragon Ore", "Platinum Ore", "Rhodium Ore", "Iridium Ore", "Queens Weapon Fragment", "Kings Weapon Fragment", "Elven Weapon Fragment", "Evergreen Log,Thread", "Oak Log,Thread", "Maple Log,Thread", "Fir Log,Thread", "Redwood Log,Thread", "Cedar Log,Thread", "Chestnut Log,Thread", "Ginkgo Log,Thread", "Queens Weapon Fragment,Thread,Ginkgo Bow", "Kings Weapon Fragment,Thread,Queens Bow", "Elven Weapon Fragment,Elven Crystal,Thread,Kings Bow", "Unstrung Shadow Bow,Shadow Bowstring", "Shadow Weapon Fragment", "Darkstar Bar", "Sandalwood Log", "Sandalwood Arrow Shafts,Feathers", "Shadow Weapon Fragment,Sandalwood Log,Darkstar Bar", "Darkstar Arrowheads,Headless Sandalwood Arrows", "Shadow Arrowheads,Headless Sandalwood Arrows", "Dragon Tail Feather" }));
        this.fletchingMaterialAmounts = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "1", "1", "1", "1", "1", "1", "1", "1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1,1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "2,10", "2,10", "2,10", "2,10", "2,10", "2,10", "2,10", "2,10", "400,10,1", "750,10,1", "1500,1500,10,1", "1,1", "1", "1", "1", "1,5", "1000,5000,2500", "1,1", "1,1", "30" }));
        this.fletchingItemExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 3L, 5L, 10L, 30L, 60L, 100L, 150L, 250L, 3L, 5L, 10L, 30L, 60L, 100L, 150L, 250L, 5L, 10L, 20L, 40L, 75L, 125L, 200L, 350L, 600L, 2500L, 5000L, 3L, 5L, 10L, 30L, 60L, 100L, 150L, 250L, 75L, 2500L, 5000L, 3L, 5L, 10L, 30L, 60L, 100L, 150L, 250L, 10000L, 50000L, 100000L, 1000000L, 10000L, 6000L, 5000L, 5000L, 1000000L, 7500L, 15000L, 500000L }));
        this.fletchingItemLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value2, value3, value4, value5, 70, 80, 92, value, value2, value3, value4, value5, 70, 80, 92, value, value2, value3, value4, value5, 70, 80, 92, 101, 115, 129, value, value2, value3, value4, value5, 70, 80, 92, 101, 115, 129, value, value2, value3, value4, value5, 70, 80, 92, 101, 115, 129, 139, 139, 132, 132, 132, 137, 132, 138, 139 }));
        this.fletchingItemCategory = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Arrow Shafts", "Arrow Shafts", "Arrow Shafts", "Arrow Shafts", "Arrow Shafts", "Arrow Shafts", "Arrow Shafts", "Arrow Shafts", "Headless Arrows", "Headless Arrows", "Headless Arrows", "Headless Arrows", "Headless Arrows", "Headless Arrows", "Headless Arrows", "Headless Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrows", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Arrowheads", "Bows", "Bows", "Bows", "Bows", "Bows", "Bows", "Bows", "Bows", "Bows", "Bows", "Bows", "Bows", "Arrowheads", "Arrowheads", "Arrow Shafts", "Headless Arrows", "Bows", "Arrows", "Arrows", "Bows" }));
        this.fletchables = (List<FletchingItem>)new ArrayList();
        this.fletchingWraps = (List<RelativeLayout>)new ArrayList();
        this.shadowItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Bow of the Shadows", "Shadow Arrowheads", "Darkstar Arrowheads", "Sandalwood Arrow Shafts", "Headless Sandalwood Arrows", "Unstrung Shadow Bow", "Darkstar Arrows", "Shadow Arrows", "Shadow Bowstring" }));
        this.lastFletchTime = 0L;
        this.activity = activity;
    }
    
    private boolean CheckUnlocks(final List<FletchingItem> list) {
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= list.size()) {
                break;
            }
            if (((FletchingItem)list.get(n)).GetLevel() == this.activity.GetSkillLevel("Fletching")) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    private void FletchingBar() {
        this.activity.ExpBar("Fletching", this.fletchingSkillProgress);
    }
    
    public boolean CheckItems(final String s, final String s2) {
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])s.split("\\s*,\\s*")));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])s2.split("\\s*,\\s*")));
        final boolean b = false;
        int i = 0;
        while (i < ((List)list).size()) {
            boolean b2 = b;
            if (this.activity.inventoryItems.contains(((List)list).get(i))) {
                if ((long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list).get(i))) >= Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.fletchingMakeX)) {
                    ++i;
                    continue;
                }
                b2 = b;
            }
            return b2;
        }
        return true;
    }
    
    public List<FletchingItem> CreateFletchablesList(final String s) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < this.fletchables.size(); ++i) {
            if (((FletchingItem)this.fletchables.get(i)).GetCategory().equals((Object)s)) {
                ((List)list).add((Object)this.fletchables.get(i));
                if (this.activity.GetSkillLevel("Fletching") < ((FletchingItem)this.fletchables.get(i)).GetLevel()) {
                    break;
                }
            }
        }
        return (List<FletchingItem>)list;
    }
    
    public void FletchItem(final FletchingItem fletchingItem, final List<FletchingItem> list) {
        if (this.activity.InventoryNotFull(fletchingItem.GetItem())) {
            int intValue;
            final int n = intValue = (int)this.activity.makeXAmounts.get(this.activity.fletchingMakeX);
            if (!this.shadowItems.contains((Object)fletchingItem.GetItem())) {
                int n2 = n;
                if (this.activity.combatManager.equippedItems.contains((Object)"Archie")) {
                    n2 = n;
                    if (this.activity.GetRandom(1, 100) <= 10) {
                        n2 = n * 2;
                    }
                }
                int n3 = n2;
                if (this.activity.databaseManager.GetWishLevel("Fletcher", "Beginner") >= 1) {
                    n3 = n2;
                    if (this.activity.GetRandom(1, 100) <= this.activity.databaseManager.GetWishLevel("Fletcher", "Beginner")) {
                        n3 = n2 * 2;
                    }
                }
                int n4 = n3;
                if (this.activity.combatManager.equippedItems.contains((Object)"Knife of Copina")) {
                    n4 = n3 * 2;
                }
                intValue = n4;
                if (this.activity.combatManager.equippedItems.contains((Object)"Knife of Copina (E)")) {
                    intValue = n4 * 3;
                }
            }
            this.activity.GiveItem(fletchingItem.GetItem(), (long)intValue, true);
            final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])fletchingItem.GetMats().split("\\s*,\\s*")));
            final ArrayList list3 = new ArrayList((Collection)Arrays.asList((Object[])fletchingItem.GetMatAmounts().split("\\s*,\\s*")));
            for (int i = 0; i < (int)this.activity.makeXAmounts.get(this.activity.fletchingMakeX); ++i) {
                for (int j = 0; j < ((List)list2).size(); ++j) {
                    this.activity.RemoveItem((String)((List)list2).get(j), Integer.parseInt((String)((List)list3).get(j)));
                }
            }
            final int getSkillLevel = this.activity.GetSkillLevel("Fletching");
            this.activity.GiveExp("Fletching", fletchingItem.GetExp() * (int)this.activity.makeXAmounts.get(this.activity.fletchingMakeX), (ProgressBar)null);
            if (this.activity.GetSkillLevel("Fletching") > getSkillLevel) {
                if (this.CheckUnlocks(list)) {
                    this.GenerateFletching(this.activity.currentFletchingCategory);
                }
                else {
                    this.UpdateMaterials(list);
                }
            }
            else {
                this.UpdateMaterials(list);
            }
            this.FletchingBar();
        }
        else {
            this.activity.QuickPopup("Inventory full");
        }
    }
    
    public void GenerateFletching(final String s) {
        this.fletchingList.removeAllViews();
        this.fletchingWraps.clear();
        final ArrayList list = new ArrayList((Collection)this.CreateFletchablesList(s));
        ((List)list).sort(Comparator.comparing((Function)new Fletching$$ExternalSyntheticLambda1()));
        this.FletchingBar();
        this.fletchingCategorySelect.setText((CharSequence)("Select Category: " + s));
        final TextView fletchingMakeXButton = this.fletchingMakeXButton;
        final MainActivity activity = this.activity;
        fletchingMakeXButton.setText((CharSequence)activity.getString(2131820664, new Object[] { activity.makeXAmounts.get(this.activity.fletchingMakeX) }));
        this.fletchingMakeXButton.setOnClickListener((View$OnClickListener)new Fletching$$ExternalSyntheticLambda2(this, (List)list));
        if (this.fletchingList.getChildCount() == 0) {
            int i = 0;
            for (List list2 = (List)list; i < list2.size(); ++i) {
                final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this.activity, 2131492912, (ViewGroup)null);
                final ImageView imageView = (ImageView)relativeLayout.getChildAt(0);
                final TextView textView = (TextView)relativeLayout.getChildAt(1);
                final LinearLayout linearLayout = (LinearLayout)relativeLayout.getChildAt(2);
                final TextView textView2 = (TextView)relativeLayout.getChildAt(3);
                Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)((FletchingItem)list2.get(i)).GetItem()))).into(imageView);
                textView.setText((CharSequence)((FletchingItem)list2.get(i)).GetItem());
                imageView.setOnClickListener((View$OnClickListener)new Fletching$$ExternalSyntheticLambda3(this, list2, i));
                if (this.activity.GetSkillLevel("Fletching") >= ((FletchingItem)list2.get(i)).GetLevel()) {
                    textView2.setText((CharSequence)"Fletch");
                }
                else {
                    textView2.setText((CharSequence)("Level " + ((FletchingItem)list2.get(i)).GetLevel()));
                    relativeLayout.setAlpha(0.5f);
                }
                final ArrayList list3 = new ArrayList((Collection)Arrays.asList((Object[])((FletchingItem)list2.get(i)).GetMats().split("\\s*,\\s*")));
                final ArrayList list4 = new ArrayList((Collection)Arrays.asList((Object[])((FletchingItem)list2.get(i)).GetMatAmounts().split("\\s*,\\s*")));
                for (int j = 0; j < linearLayout.getChildCount(); ++j) {
                    if (((List)list3).size() > j) {
                        long longValue;
                        if (this.activity.inventoryItems.contains(((List)list3).get(j))) {
                            longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list3).get(j)));
                        }
                        else {
                            longValue = 0L;
                        }
                        ((TextView)linearLayout.getChildAt(j)).setText((CharSequence)this.activity.getString(2131820615, new Object[] { longValue, this.activity.FormatExp(Integer.parseInt((String)((List)list4).get(j)) * (long)(int)this.activity.makeXAmounts.get(this.activity.fletchingMakeX)), ((List)list3).get(j) }));
                        if (longValue >= Integer.parseInt((String)((List)list4).get(j)) * (long)(int)this.activity.makeXAmounts.get(this.activity.fletchingMakeX)) {
                            ((TextView)linearLayout.getChildAt(j)).setTextColor(this.activity.GetColour(2131034925));
                        }
                        else {
                            ((TextView)linearLayout.getChildAt(j)).setTextColor(this.activity.GetColour(2131034904));
                        }
                    }
                    else {
                        linearLayout.getChildAt(j).setVisibility(8);
                    }
                }
                this.fletchingList.addView((View)relativeLayout);
                this.fletchingWraps.add((Object)relativeLayout);
                textView2.setOnClickListener((View$OnClickListener)new Fletching$$ExternalSyntheticLambda4(this, list2, i));
            }
        }
    }
    
    public void OpenFletching() {
        if (this.fletchingScreen == null) {
            final LinearLayout fletchingScreen = (LinearLayout)((ViewStub)this.activity.findViewById(2131296650)).inflate();
            this.fletchingScreen = fletchingScreen;
            this.fletchingList = (LinearLayout)fletchingScreen.findViewById(2131296646);
            this.fletchingSkillProgress = (RelativeLayout)this.fletchingScreen.findViewById(2131296649);
            this.fletchingCategorySelect = (TextView)this.fletchingScreen.findViewById(2131296645);
            this.fletchingMakeXButton = (TextView)this.fletchingScreen.findViewById(2131296647);
        }
        this.activity.EnableLayout((ViewGroup)this.fletchingScreen);
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.fletchingScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.FletchingBar();
        this.fletchingCategorySelect.setOnClickListener((View$OnClickListener)new Fletching$$ExternalSyntheticLambda5(this));
        this.GenerateFletching(this.activity.currentFletchingCategory);
    }
    
    public void Setup() {
        for (int i = 0; i < this.fletchingItems.size(); ++i) {
            this.fletchables.add((Object)new FletchingItem((int)this.fletchingItemLevel.get(i), (String)this.fletchingItems.get(i), (String)this.fletchingMaterials.get(i), (String)this.fletchingMaterialAmounts.get(i), (long)this.fletchingItemExp.get(i), (String)this.fletchingItemCategory.get(i)));
        }
    }
    
    public void UpdateMaterials(final List<FletchingItem> list) {
        Object o = "\\s*,\\s*";
        int getColour = this.activity.GetColour(2131034925);
        int getColour2 = this.activity.GetColour(2131034904);
        for (int i = 0; i < this.fletchingWraps.size(); ++i) {
            Object string = o;
            int intValue = getColour;
            int currentTextColor = getColour2;
            int n = i;
            Label_0683: {
                try {
                    string = o;
                    intValue = getColour;
                    currentTextColor = getColour2;
                    n = i;
                    final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])((FletchingItem)list.get(i)).GetMats().split((String)o)));
                    string = o;
                    intValue = getColour;
                    currentTextColor = getColour2;
                    n = i;
                    string = o;
                    intValue = getColour;
                    currentTextColor = getColour2;
                    n = i;
                    final ArrayList list3 = new ArrayList((Collection)Arrays.asList((Object[])((FletchingItem)list.get(i)).GetMatAmounts().split((String)o)));
                    string = o;
                    intValue = getColour;
                    currentTextColor = getColour2;
                    n = i;
                    final LinearLayout linearLayout = (LinearLayout)((RelativeLayout)this.fletchingWraps.get(i)).getChildAt(2);
                    int n2 = 0;
                    while (true) {
                        string = o;
                        intValue = getColour;
                        currentTextColor = getColour2;
                        n = i;
                        if (n2 < ((List)list2).size()) {
                            string = o;
                            intValue = getColour;
                            currentTextColor = getColour2;
                            n = i;
                            final TextView textView = (TextView)linearLayout.getChildAt(n2);
                            string = o;
                            intValue = getColour;
                            currentTextColor = getColour2;
                            n = i;
                            long longValue;
                            if (this.activity.inventoryItems.contains(((List)list2).get(n2))) {
                                string = o;
                                intValue = getColour;
                                currentTextColor = getColour2;
                                n = i;
                                longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list2).get(n2)));
                            }
                            else {
                                longValue = 0L;
                            }
                            string = o;
                            intValue = getColour;
                            currentTextColor = getColour2;
                            n = i;
                            final MainActivity activity = this.activity;
                            string = o;
                            intValue = getColour;
                            currentTextColor = getColour2;
                            n = i;
                            final MainActivity activity2 = this.activity;
                            string = o;
                            intValue = getColour;
                            currentTextColor = getColour2;
                            n = i;
                            final long n3 = Integer.parseInt((String)((List)list3).get(n2));
                            try {
                                final List makeXAmounts = this.activity.makeXAmounts;
                                try {
                                    intValue = (int)makeXAmounts.get(this.activity.fletchingMakeX);
                                    final long n4 = intValue;
                                    try {
                                        string = activity.getString(2131820615, new Object[] { longValue, activity2.FormatExp(n3 * n4), ((List)list2).get(n2) });
                                        if (!textView.getText().toString().equals(string)) {
                                            textView.setText((CharSequence)string);
                                            if (longValue >= Integer.parseInt((String)((List)list3).get(n2)) * (long)(int)this.activity.makeXAmounts.get(this.activity.fletchingMakeX)) {
                                                if (textView.getCurrentTextColor() != getColour) {
                                                    textView.setTextColor(getColour);
                                                }
                                            }
                                            else {
                                                currentTextColor = textView.getCurrentTextColor();
                                                intValue = getColour2;
                                                if (currentTextColor != intValue) {
                                                    try {
                                                        textView.setTextColor(intValue);
                                                    }
                                                    catch (final IndexOutOfBoundsException string) {
                                                        getColour2 = intValue;
                                                        break Label_0683;
                                                    }
                                                }
                                            }
                                        }
                                        ++n2;
                                    }
                                    catch (final IndexOutOfBoundsException string) {}
                                }
                                catch (final IndexOutOfBoundsException string) {}
                            }
                            catch (final IndexOutOfBoundsException string) {
                                break Label_0683;
                            }
                            break;
                        }
                        break;
                    }
                    continue;
                }
                catch (final IndexOutOfBoundsException ex) {
                    o = string;
                    i = n;
                    getColour2 = currentTextColor;
                    getColour = intValue;
                    string = ex;
                }
            }
            this.activity.LogIt("Index out of bounds fletching: " + string);
        }
    }
    
    public static class FletchingItem
    {
        String category;
        long exp;
        String item;
        int levelRequirement;
        String materialAmounts;
        String materials;
        
        public FletchingItem(final int levelRequirement, final String item, final String materials, final String materialAmounts, final long exp, final String category) {
            this.levelRequirement = levelRequirement;
            this.exp = exp;
            this.materials = materials;
            this.materialAmounts = materialAmounts;
            this.item = item;
            this.category = category;
        }
        
        public String GetCategory() {
            return this.category;
        }
        
        public long GetExp() {
            return this.exp;
        }
        
        public String GetItem() {
            return this.item;
        }
        
        public long GetLevel() {
            return this.levelRequirement;
        }
        
        public String GetMatAmounts() {
            return this.materialAmounts;
        }
        
        public String GetMats() {
            return this.materials;
        }
    }
}
