package uk.playdrop.cherrytree_idletextrpg;

import com.squareup.picasso.Picasso;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.view.View$OnClickListener;
import java.util.function.Function;
import java.util.Comparator;
import android.widget.ProgressBar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crafting
{
    MainActivity activity;
    List<CraftingItem> craftables;
    List<String> craftingItemCategory;
    List<Long> craftingItemExp;
    List<Integer> craftingItemLevel;
    List<String> craftingItems;
    List<String> craftingMaterialAmounts;
    List<String> craftingMaterials;
    long lastCraftTime;
    List<String> noMultiples;
    
    public Crafting(final MainActivity activity) {
        final Integer value = 1;
        final Integer value2 = 3;
        final Integer value3 = 5;
        final Integer value4 = 25;
        final Integer value5 = 40;
        final Integer value6 = 45;
        final Integer value7 = 65;
        final Integer value8 = 78;
        final Integer value9 = 80;
        final Integer value10 = 120;
        final Integer value11 = 130;
        this.craftingItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Leather", "Leather Gloves", "Nails", "Rope", "Stone Block", "Wooden Stick", "Leather Boots", "Empty Vial", "Leather Helm", "Molten Glass", "Wooden Plank", "Leather Greaves", "Board", "Leather Top", "Potato Sack", "Yarn", "Satchel", "Blue Silk", "Barrel", "Iron", "Bestiary", "Iron Sword", "Iron Gloves", "Iron Boots", "Waterskin", "Iron Helm", "Iron Battleaxe", "Scissors", "Small Exp Scroll", "Iron Greaves", "Coin Purse", "Iron Top", "Crate", "Iron Shield", "Raft", "Fishing Net", "Diary", "Steel Gloves", "Steel Bar", "Hammer", "Steel Boots", "Notebook", "Steel Helm", "Gold Bar", "Steel Greaves", "Hourglass", "Master Sword", "Leather Bag", "Steel Top", "Steel Sword", "Master Gloves", "Master Boots", "Scarf", "Steel Knives", "Master Helm", "Master Legs", "Mithril Gloves", "Scroll", "Mithril Bar", "Master Top", "Mithril Boots", "Dragonhide Boots", "Mithril Helm", "Dragonhide Gloves", "Mithril Sword", "Dragonhide Helm", "Mithril Greaves", "Medium Exp Scroll", "Dragonhide Legs", "Mithril Axe", "Mithril Shield", "Dragonhide Top", "Large Fishing Net", "Mithril Top", "Workbench", "Ring of Power", "Super Power Stone", "Spiked Shield", "Wine", "Dragon Plate", "Dragon Rider Gloves", "Primal Sword", "Dragon Rider Boots", "Dragon Rider Helm", "Dragon Rider Greaves", "Dragon Rider Top", "Farmour Gloves", "Ring of Super Power", "Farmour Boots", "Farmour Helm", "Farmour Legs", "Large Exp Scroll", "Farmour Top", "Extreme Power Stone", "Dagger of Demeter", "Queens Gloves", "Primal Gloves", "Queens Boots", "Primal Boots", "Queens Helm", "Primal Helm", "Queens Greaves", "Primal Legs", "Queens Top", "Primal Top", "Drakes Ring", "Ring of Anuket", "Ring of Demeter", "Ring of Extreme Power", "Ring of Forestry", "Ring of Renewal", "Queens Sword", "Kings Gloves", "Kings Boots", "Berserker Ring", "Kings Helm", "Kings Greaves", "Blessed Eternal Sacrifice", "Kings Top", "Necklace of Restoration", "Kings Sword", "Massive Exp Scroll", "Elven Plate", "Elven Greaves", "Elven Helm", "Elven Gloves", "Elven Boots", "Elven Sword", "Eternal Ring", "Eternal Berserker Ring", "Dark Elven Helm", "Dark Elven Gloves", "Dark Elven Boots", "Dark Elven Greaves", "Dark Elven Plate", "Dark Elven Sword", "Ring of Secrets", "Soul Reaper Top", "Soul Reaper Gloves", "Soul Reaper Boots", "Soul Reaper Legs", "Soul Reaper Helm", "Necklace of the Gods", "Shadow Boots", "Darkstar Bar", "Shadow Gloves", "Shadow Hood", "Shadow Greaves", "Shadow Lantern", "Staff of the Shadows", "Shadow Cloak" }));
        this.craftingMaterials = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Hide", "Leather", "Iron", "Thread", "Stone", "Wood", "Leather", "Molten Glass", "Leather", "Sandstone", "Wood", "Leather", "Wood", "Leather", "Thread", "Wool", "Thread,Rope", "Blue Thread", "Wooden Plank,Steel Bar,Nails", "Iron Ore", "Blue Silk,Leather,Thread", "Iron", "Iron", "Iron", "Leather,Rope", "Iron", "Iron", "Steel Bar", "Mini Exp Scroll", "Iron", "Blue Silk,Blue Buttons,Rope", "Iron", "Wooden Plank,Nails", "Iron", "Wooden Plank,Steel Bar,Nails", "Rope", "Blue Silk,Leather,Thread", "Steel Bar", "Iron Ore", "Stone Block,Wood", "Steel Bar", "Blue Silk,Leather,Thread", "Steel Bar", "Gold Ore", "Steel Bar", "Molten Glass,Oak", "Apprentice Sword,Dark Thread", "Leather,Rope,Blue Buttons", "Steel Bar", "Steel Bar", "Apprentice Gloves,Soul Thread", "Apprentice Boots,Soul Thread", "Blue Silk,Thread", "Steel Bar", "Apprentice Helm,Soul Thread", "Apprentice Legs,Soul Thread", "Mithril Bar", "Blue Silk", "Mithril Ore", "Apprentice Top,Soul Thread", "Mithril Bar", "Dragon Plate,Dragon Leather", "Mithril Bar", "Dragon Plate,Dragon Leather", "Mithril Bar", "Dragon Plate,Dragon Leather", "Mithril Bar", "Small Exp Scroll", "Dragon Plate,Dragon Leather", "Mithril Bar", "Mithril Bar", "Dragon Plate,Dragon Leather", "Fishing Net", "Mithril Bar", "Wooden Plank,Nails,Steel Bar", "Ring Fragments,Power Stone", "Power Stone", "Steel Bar", "Empty Vial,Grapes", "Dragon Ore", "Dragon Plate, Dragon Leather", "Master Sword,Dark Thread", "Dragon Plate, Dragon Leather", "Dragon Plate, Dragon Leather", "Dragon Plate, Dragon Leather", "Dragon Plate, Dragon Leather", "Farmour Fragment,Leather Gloves,Thread", "Ring Fragments,Super Power Stone", "Farmour Fragment,Leather Boots,Thread", "Farmour Fragment,Leather Helm,Thread", "Farmour Fragment,Leather Greaves,Thread", "Medium Exp Scroll", "Farmour Fragment,Leather Top,Thread", "Super Power Stone", "Dagger Fragment,Chicken Knife", "Queens Armour Fragment,Dragon Plate,Dragon Leather", "Master Gloves,Soul Thread", "Queens Armour Fragment,Dragon Plate,Dragon Leather", "Master Boots,Soul Thread", "Queens Armour Fragment,Dragon Plate,Dragon Leather", "Master Helm,Soul Thread", "Queens Armour Fragment,Dragon Plate,Dragon Leather", "Master Legs,Soul Thread", "Queens Armour Fragment,Dragon Plate,Dragon Leather", "Master Top,Soul Thread", "Ring Fragments,Drakes Compass,Drakes Diary", "Ring Fragments,Rod of Anuket", "Ring Fragments,Scythe of Demeter", "Ring Fragments,Extreme Power Stone", "Ring Fragments,Rabbits Foot", "Ring Fragments,Cauldron", "Queens Weapon Fragment", "Kings Armour Fragment,Dragon Plate,Dragon Leather,Queens Gloves", "Kings Armour Fragment,Dragon Plate,Dragon Leather,Queens Boots", "Ring of Speed,Extreme Power Stone,Ring Fragments", "Kings Armour Fragment,Dragon Plate,Dragon Leather,Queens Helm", "Kings Armour Fragment,Dragon Plate,Dragon Leather,Queens Greaves", "Blessed Sacrifice,Necklace of Restoration,Cauldron", "Kings Armour Fragment,Dragon Plate,Dragon Leather,Queens Top", "Restoration Fragment 1, Restoration Fragment 2, Restoration Fragment 3, Restoration Fragment 4, Restoration Fragment 5", "Kings Weapon Fragment,Queens Sword", "Large Exp Scroll", "Elven Crystal,Elven Armour Fragment,Kings Top", "Elven Crystal,Elven Armour Fragment,Kings Greaves", "Elven Crystal,Elven Armour Fragment,Kings Helm", "Elven Crystal,Elven Armour Fragment,Kings Gloves", "Elven Crystal,Elven Armour Fragment,Kings Boots", "Elven Crystal,Elven Weapon Fragment,Kings Sword", "Ring of Speed,Ring of Life,Ring of Death,Ring Fragments", "Eternal Ring,Berserker Ring,Extreme Power Stone,Ring Fragments", "Elven Helm,Elven Crystal,Elven Armour Fragment,Dark Thread", "Elven Gloves,Elven Crystal,Elven Armour Fragment,Dark Thread", "Elven Boots,Elven Crystal,Elven Armour Fragment,Dark Thread", "Elven Greaves,Elven Crystal,Elven Armour Fragment,Dark Thread", "Elven Plate,Elven Crystal,Elven Armour Fragment,Dark Thread", "Elven Sword,Elven Crystal,Elven Weapon Fragment,Dark Thread", "Fragment of Secrets 1,Fragment of Secrets 2,Fragment of Secrets 3,Fragment of Secrets 4,Eternal Berserker Ring", "Soul Reaper Fragment,Dark Thread,Soul Thread", "Soul Reaper Fragment,Dark Thread,Soul Thread", "Soul Reaper Fragment,Dark Thread,Soul Thread", "Soul Reaper Fragment,Dark Thread,Soul Thread", "Soul Reaper Fragment,Dark Thread,Soul Thread", "Fragment of the Gods I,Fragment of the Gods II,Fragment of the Gods III,Fragment of the Gods IV,Blessed Eternal Sacrifice", "Shadow Armour Fragment,Darkstar Bar,Soul Thread,Soul Reaper Fragment", "Darkstar Ore", "Shadow Armour Fragment,Darkstar Bar,Soul Thread,Soul Reaper Fragment", "Shadow Armour Fragment,Darkstar Bar,Soul Thread,Soul Reaper Fragment", "Shadow Armour Fragment,Darkstar Bar,Soul Thread,Soul Reaper Fragment", "Shadow Lantern Base,Shadow Lantern Gem,Shadow Lantern Handle", "Shadow Staff Base,Shadow Staff Handle,Shadow Staff Tip,Shadow Weapon Fragment", "Shadow Armour Fragment,Darkstar Bar,Soul Thread,Soul Reaper Fragment" }));
        this.craftingMaterialAmounts = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "3", "2", "1", "10", "5", "500000", "3", "1", "4", "2", "2", "5", "5", "10", "10", "2", "5,1", "3", "10,2,20", "2", "5,1,3", "2", "1", "1", "3,2", "2", "3", "1", "3", "3", "1,5,1", "5", "10,25", "5", "10,5,40", "10", "5,3,40", "1", "5", "1,1", "1", "5,3,25", "2", "2", "3", "3,2", "1,20", "2,1,1", "5", "2", "1,1", "1,1", "5,10", "3", "1,1", "1,2", "1", "5", "3", "1,3", "1", "2,6", "2", "2,6", "3", "2,8", "3", "2", "3,10", "3", "10", "5,15", "6", "5", "25,100,10", "10,1", "15", "10", "1,50", "4", "2,3", "1,100", "3,5", "4,10", "5,15", "10,30", "50,100,5000", "10,1", "75,150,10000", "100,200,15000", "150,250,20000", "2", "250,500,25000", "15", "500,5", "50,1000,1000", "1,35", "75,1500,1500", "1,30", "100,2000,2000", "1,40", "150,2500,2500", "1,45", "250,5000,5000", "1,50", "10,1,1", "10,1", "10,1", "10,1", "10,1", "10,1", "350", "75,1000,1000,1", "100,1500,1500,1", "5,25,50", "150,2000,2000,1", "250,2500,2500,1", "10,15,25", "500,5000,5000,1", "1,1,1,1,1", "500,1", "100", "1000,1000,1", "800,800,1", "600,600,1", "400,400,1", "400,400,1", "1500,1000,1", "10,10,10,250", "3,3,50,250", "5,2000,500,150", "5,2000,500,150", "5,2000,500,150", "10,3500,1000,250", "15,5000,2000,500", "20,5000,2000,500", "1,1,1,1,10", "50,10000,100", "25,2500,30", "25,2500,30", "40,7500,75", "30,5000,50", "1,1,1,1,30", "200,200,1000,60", "5", "250,250,1250,75", "300,300,1500,100", "400,400,2000,150", "1,1,1", "1,1,1,1000", "500,500,2500,250" }));
        this.craftingItemLevel = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { value, value, value, value, value, value, 2, value2, value2, value2, value2, 4, value3, value3, value3, 8, 10, 12, 15, 15, 18, 18, 20, 22, 22, 24, value4, value4, value4, 26, 30, 30, 32, 32, 35, 37, value5, value5, value5, 41, 42, value6, value6, value6, 48, 50, 50, 52, 54, 56, 57, 59, 60, 61, 61, 63, value7, value7, value7, value7, 68, 71, 72, 72, 73, 74, 75, 75, 76, value8, value8, value8, value9, value9, value9, value9, 85, 86, 90, 90, 95, 95, 96, 97, 98, 99, 99, 100, 101, 103, 105, 105, 107, 109, 109, 111, 111, 113, 113, 115, 115, 117, 117, 119, 119, value10, value10, value10, value10, value10, value10, 121, 122, 124, 124, 125, 126, 126, 127, 128, 129, 129, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, value11, 132, 135, 135, 136, 137, 138, 139, 139, 139 }));
        this.craftingItemExp = (List<Long>)new ArrayList((Collection)Arrays.asList((Object[])new Long[] { 25L, 30L, 15L, 20L, 20L, 10000L, 45L, 25L, 60L, 35L, 25L, 75L, 25L, 100L, 50L, 60L, 80L, 100L, 200L, 75L, 120L, 100L, 60L, 90L, 100L, 100L, 120L, 100L, 75L, 120L, 200L, 250L, 200L, 275L, 300L, 270L, 350L, 150L, 120L, 400L, 225L, 600L, 300L, 160L, 375L, 700L, 1000L, 750L, 750L, 500L, 2000L, 2500L, 750L, 550L, 3000L, 4000L, 750L, 1000L, 250L, 5000L, 1000L, 400L, 1500L, 450L, 2500L, 600L, 2800L, 2000L, 750L, 4000L, 3000L, 1000L, 2000L, 3000L, 2000L, 5000L, 6000L, 6000L, 5000L, 650L, 2500L, 3000L, 4000L, 6000L, 7500L, 15000L, 15000L, 15000L, 18000L, 21000L, 23000L, 10000L, 25000L, 30000L, 27000L, 25000L, 220000L, 40000L, 240000L, 50000L, 260000L, 75000L, 280000L, 80000L, 300000L, 100000L, 100000L, 100000L, 100000L, 100000L, 100000L, 120000L, 150000L, 180000L, 50000L, 210000L, 240000L, 75000L, 260000L, 500000L, 300000L, 30000L, 1000000L, 800000L, 600000L, 400000L, 400000L, 2000000L, 3000000L, 3000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 1000000L, 3000000L, 5000000L, 5000000L, 5000000L, 5000000L, 5000000L, 1000000L, 1000000L, 25000L, 1500000L, 2000000L, 2500000L, 10000000L, 15000000L, 5000000L }));
        this.craftingItemCategory = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Materials", "Leather Equipment", "Materials", "Materials", "Bars", "Other", "Leather Equipment", "Skilling", "Leather Equipment", "Materials", "Materials", "Leather Equipment", "Materials", "Leather Equipment", "Other", "Materials", "Other", "Materials", "Other", "Bars", "Other", "Iron Equipment", "Iron Equipment", "Iron Equipment", "Other", "Iron Equipment", "Iron Equipment", "Other", "Exp Scrolls", "Iron Equipment", "Other", "Iron Equipment", "Other", "Iron Equipment", "Other", "Skilling", "Other", "Steel Equipment", "Bars", "Other", "Steel Equipment", "Other", "Steel Equipment", "Bars", "Steel Equipment", "Other", "Slayer Gear", "Other", "Steel Equipment", "Steel Equipment", "Slayer Gear", "Slayer Gear", "Other", "Steel Equipment", "Slayer Gear", "Slayer Gear", "Mithril Equipment", "Other", "Bars", "Slayer Gear", "Mithril Equipment", "Dragon Equipment", "Mithril Equipment", "Dragon Equipment", "Mithril Equipment", "Dragon Equipment", "Mithril Equipment", "Exp Scrolls", "Dragon Equipment", "Mithril Equipment", "Mithril Equipment", "Dragon Equipment", "Skilling", "Mithril Equipment", "Other", "Jewellery", "Blessing", "Steel Equipment", "Other", "Bars", "Dragon Equipment", "Slayer Gear", "Dragon Equipment", "Dragon Equipment", "Dragon Equipment", "Dragon Equipment", "Farmour Gear", "Jewellery", "Farmour Gear", "Farmour Gear", "Farmour Gear", "Exp Scrolls", "Farmour Gear", "Blessing", "Farmour Gear", "Queens Gear", "Slayer Gear", "Queens Gear", "Slayer Gear", "Queens Gear", "Slayer Gear", "Queens Gear", "Slayer Gear", "Queens Gear", "Slayer Gear", "Jewellery", "Jewellery", "Jewellery", "Jewellery", "Jewellery", "Jewellery", "Queens Gear", "Kings Gear", "Kings Gear", "Jewellery", "Kings Gear", "Kings Gear", "Jewellery", "Kings Gear", "Jewellery", "Kings Gear", "Exp Scrolls", "Elven Gear", "Elven Gear", "Elven Gear", "Elven Gear", "Elven Gear", "Elven Gear", "Jewellery", "Jewellery", "Elven Gear", "Elven Gear", "Elven Gear", "Elven Gear", "Elven Gear", "Elven Gear", "Jewellery", "Soul Reaper Gear", "Soul Reaper Gear", "Soul Reaper Gear", "Soul Reaper Gear", "Soul Reaper Gear", "Jewellery", "Shadow Gear", "Bars", "Shadow Gear", "Shadow Gear", "Shadow Gear", "Shadow Gear", "Shadow Gear", "Shadow Gear" }));
        this.craftables = (List<CraftingItem>)new ArrayList();
        this.noMultiples = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Elven Gear", "Jewellery", "Kings Gear", "Exp Scrolls", "Queens Gear", "Farmour Gear", "Slayer Gear", "Soul Reaper Gear", "Shadow Gear" }));
        this.lastCraftTime = 0L;
        this.activity = activity;
    }
    
    private boolean CheckUnlocks(final List<CraftingItem> list) {
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= list.size()) {
                break;
            }
            if (((CraftingItem)list.get(n)).GetLevel() == this.activity.GetSkillLevel("Crafting")) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    private void CraftingBar() {
        final MainActivity activity = this.activity;
        activity.ExpBar("Crafting", activity.craftingSkillProgress);
    }
    
    public boolean CheckItems(final String s, final String s2) {
        final ArrayList list = new ArrayList((Collection)Arrays.asList((Object[])s.split("\\s*,\\s*")));
        final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])s2.split("\\s*,\\s*")));
        final boolean b = false;
        for (int i = 0; i < ((List)list).size(); ++i) {
            if (((String)((List)list).get(i)).equals((Object)"Soul Thread")) {
                if (this.activity.combatManager.slayerInfo.getSoulThread() < Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.craftingMakeX)) {
                    return b;
                }
            }
            else if (((String)((List)list).get(i)).equals((Object)"Dark Thread")) {
                if (this.activity.combatManager.slayerInfo.getDarkThread() < Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.craftingMakeX)) {
                    return b;
                }
            }
            else {
                boolean b2 = b;
                if (!this.activity.inventoryItems.contains(((List)list).get(i))) {
                    return b2;
                }
                if ((long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list).get(i))) < Integer.parseInt((String)((List)list2).get(i)) * (long)(int)this.activity.makeXAmounts.get(this.activity.craftingMakeX)) {
                    b2 = b;
                    return b2;
                }
            }
        }
        return true;
    }
    
    public void CraftItem(final CraftingItem craftingItem, final List<CraftingItem> list) {
        if (this.activity.InventoryNotFull(craftingItem.GetItem())) {
            final int intValue = (int)this.activity.makeXAmounts.get(this.activity.craftingMakeX);
            final boolean equals = craftingItem.GetItem().equals((Object)"Darkstar Bar");
            int n = intValue;
            if (!equals) {
                n = intValue;
                if (!this.noMultiples.contains((Object)craftingItem.GetCategory())) {
                    int n2 = 0;
                    Label_0214: {
                        if (!this.activity.combatManager.equippedItems.contains((Object)"Crafting Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Mini Max Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Completion Cape") && !this.activity.combatManager.equippedItems.contains((Object)"Ultra Comp Cape")) {
                            n2 = intValue;
                            if (!this.activity.combatManager.equippedItems.contains((Object)"No Life Cape")) {
                                break Label_0214;
                            }
                        }
                        n2 = intValue * 2;
                    }
                    int n3 = n2;
                    if (this.activity.baseTower.baseTowerLevel >= 18) {
                        n3 = n2 * 2;
                    }
                    n = n3;
                    if (this.activity.combatManager.equippedItems.contains((Object)"Roger")) {
                        n = n3;
                        if (this.activity.GetRandom(1, 100) <= 10) {
                            n = n3 * 2;
                        }
                    }
                }
            }
            final MainActivity activity = this.activity;
            activity.itemsCrafted += n;
            int n4 = n;
            if (craftingItem.GetItem().equals((Object)"Nails")) {
                n4 = n * 10;
            }
            this.activity.GiveItem(craftingItem.GetItem(), (long)n4, true);
            this.activity.treasureHunts.CheckTreasureHunts("Crafting", craftingItem.GetItem());
            this.activity.dailies.UpdateDailies("Crafting", craftingItem.GetItem(), n4);
            this.activity.secretPathway.CheckPathway("Crafting", craftingItem.GetItem());
            final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])craftingItem.GetMats().split("\\s*,\\s*")));
            Object o = new ArrayList((Collection)Arrays.asList((Object[])craftingItem.GetMatAmounts().split("\\s*,\\s*")));
            int i = 0;
            int n5 = 0;
            while (i < (int)this.activity.makeXAmounts.get(this.activity.craftingMakeX)) {
                List list3;
                if (!craftingItem.GetItem().equals((Object)"Darkstar Bar") && !this.noMultiples.contains((Object)craftingItem.GetCategory())) {
                    list3 = (List)o;
                    if (this.activity.GetRandom(1, 100) > this.activity.resourceSave) {
                        int n6 = 0;
                        while (true) {
                            list3 = (List)o;
                            if (n6 >= ((List)list2).size()) {
                                break;
                            }
                            this.activity.RemoveItem((String)((List)list2).get(n6), Integer.parseInt((String)((List)o).get(n6)));
                            ++n6;
                        }
                    }
                }
                else {
                    int n7 = 0;
                    while (true) {
                        list3 = (List)o;
                        if (n7 >= ((List)list2).size()) {
                            break;
                        }
                        if (((String)((List)list2).get(n7)).equals((Object)"Soul Thread")) {
                            final CombatManager.SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                            slayerInfo.soulThread -= Integer.parseInt((String)((List)o).get(n7));
                        }
                        else if (((String)((List)list2).get(n7)).equals((Object)"Dark Thread")) {
                            final CombatManager.SlayerInfo slayerInfo2 = this.activity.combatManager.slayerInfo;
                            slayerInfo2.darkThread -= Integer.parseInt((String)((List)o).get(n7));
                        }
                        else {
                            this.activity.RemoveItem((String)((List)list2).get(n7), Integer.parseInt((String)((List)o).get(n7)));
                        }
                        ++n7;
                    }
                }
                if (this.activity.GetRandom(1, 350000) <= 2) {
                    int n8;
                    if (this.activity.baseTower.baseTowerLevel >= 52) {
                        if (this.activity.GetRandom(1, 100) <= 10) {
                            n8 = this.activity.GetRandom(2, 4);
                        }
                        else {
                            n8 = this.activity.GetRandom(1, 2);
                        }
                    }
                    else {
                        n8 = this.activity.GetRandom(1, 2);
                    }
                    n5 += n8;
                }
                this.activity.itemManager.CheckOnlineSecrets("Crafting", craftingItem.GetItem());
                if (craftingItem.GetItem().equals((Object)"Satchel")) {
                    if (this.activity.combatManager.equippedItems.contains((Object)"Leather Gloves") && this.activity.alchemy.activePotions.contains((Object)"Luck Potion")) {
                        this.activity.combatManager.CheckSecret("Drakes Compass", 2131165766, 60000);
                    }
                    else {
                        this.activity.combatManager.CheckSecret("Drakes Diary", 2131165766, 60000);
                    }
                }
                if (craftingItem.GetItem().equals((Object)"Dragon Rider Top")) {
                    this.activity.combatManager.CheckSecret("Mystic Robe", 2131166029, 75000);
                }
                if (craftingItem.GetItem().equals((Object)"Dark Elven Plate") && this.activity.combatManager.equippedItems.contains((Object)"Ring of Secrets")) {
                    this.activity.combatManager.CheckSecret("Fragment of the Gods IV", 2131165854, 25000);
                }
                ++i;
                o = list3;
            }
            if (n5 > 0) {
                this.activity.GiveItem("Ring Fragments", (long)n5, false);
                this.activity.LargePopup(2131166150, "Congratulations!", "You found " + n5 + " Ring Fragments.");
            }
            final int getSkillLevel = this.activity.GetSkillLevel("Crafting");
            long n10;
            final long n9 = n10 = craftingItem.GetExp() * (int)this.activity.makeXAmounts.get(this.activity.craftingMakeX);
            if (this.activity.baseTower.baseTowerLevel >= 17) {
                n10 = n9 + n9 / 4L;
            }
            this.activity.GiveExp("Crafting", n10, (ProgressBar)null);
            if (this.activity.GetSkillLevel("Crafting") > getSkillLevel) {
                if (this.CheckUnlocks(list)) {
                    this.GenerateWorkshop(this.activity.currentWorkshopCategory);
                }
                else {
                    this.UpdateMaterials(list);
                }
            }
            else {
                this.UpdateMaterials(list);
            }
            this.CraftingBar();
            this.activity.accountStats.addItemCrafted(n4);
        }
        else {
            this.activity.QuickPopup("Inventory full");
        }
    }
    
    public List<CraftingItem> CreateCraftablesList(final String s) {
        final ArrayList list = new ArrayList();
        for (int i = 0; i < this.craftables.size(); ++i) {
            if (((CraftingItem)this.craftables.get(i)).GetCategory().equals((Object)s)) {
                ((List)list).add((Object)this.craftables.get(i));
                if (this.activity.GetSkillLevel("Crafting") < ((CraftingItem)this.craftables.get(i)).GetLevel()) {
                    break;
                }
            }
        }
        return (List<CraftingItem>)list;
    }
    
    public void GenerateWorkshop(final String s) {
        this.activity.workshopList.removeAllViews();
        this.activity.craftingWraps.clear();
        final ArrayList list = new ArrayList((Collection)this.CreateCraftablesList(s));
        ((List)list).sort(Comparator.comparing((Function)new Crafting$$ExternalSyntheticLambda0()));
        this.CraftingBar();
        this.activity.workshopCategorySelect.setText((CharSequence)("Select Category: " + s));
        final TextView craftingMakeXButton = this.activity.craftingMakeXButton;
        final MainActivity activity = this.activity;
        craftingMakeXButton.setText((CharSequence)activity.getString(2131820664, new Object[] { activity.makeXAmounts.get(this.activity.craftingMakeX) }));
        this.activity.craftingMakeXButton.setOnClickListener((View$OnClickListener)new Crafting$$ExternalSyntheticLambda1(this, (List)list));
        if (this.activity.workshopList.getChildCount() == 0) {
            int i = 0;
            for (List list2 = (List)list; i < list2.size(); ++i) {
                final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this.activity, 2131492912, (ViewGroup)null);
                final ImageView imageView = (ImageView)relativeLayout.getChildAt(0);
                final TextView textView = (TextView)relativeLayout.getChildAt(1);
                final LinearLayout linearLayout = (LinearLayout)relativeLayout.getChildAt(2);
                final TextView textView2 = (TextView)relativeLayout.getChildAt(3);
                Picasso.get().load((int)this.activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)((CraftingItem)list2.get(i)).GetItem()))).into(imageView);
                if (((CraftingItem)list2.get(i)).GetItem().equals((Object)"Nails")) {
                    textView.setText((CharSequence)(((CraftingItem)list2.get(i)).GetItem() + " x10"));
                }
                else {
                    textView.setText((CharSequence)((CraftingItem)list2.get(i)).GetItem());
                }
                imageView.setOnClickListener((View$OnClickListener)new Crafting$$ExternalSyntheticLambda2(this, list2, i));
                if (this.activity.GetSkillLevel("Crafting") >= ((CraftingItem)list2.get(i)).GetLevel()) {
                    textView2.setText((CharSequence)"Craft");
                }
                else {
                    textView2.setText((CharSequence)("Level " + ((CraftingItem)list2.get(i)).GetLevel()));
                    relativeLayout.setAlpha(0.5f);
                }
                final ArrayList list3 = new ArrayList((Collection)Arrays.asList((Object[])((CraftingItem)list2.get(i)).GetMats().split("\\s*,\\s*")));
                final ArrayList list4 = new ArrayList((Collection)Arrays.asList((Object[])((CraftingItem)list2.get(i)).GetMatAmounts().split("\\s*,\\s*")));
                for (int j = 0; j < linearLayout.getChildCount(); ++j) {
                    if (((List)list3).size() > j) {
                        long n;
                        if (((String)((List)list3).get(j)).equals((Object)"Soul Thread")) {
                            n = this.activity.combatManager.slayerInfo.getSoulThread();
                        }
                        else if (((String)((List)list3).get(j)).equals((Object)"Dark Thread")) {
                            n = this.activity.combatManager.slayerInfo.getDarkThread();
                        }
                        else if (this.activity.inventoryItems.contains(((List)list3).get(j))) {
                            n = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list3).get(j)));
                        }
                        else {
                            n = 0L;
                        }
                        ((TextView)linearLayout.getChildAt(j)).setText((CharSequence)this.activity.getString(2131820615, new Object[] { n, this.activity.FormatExp(Integer.parseInt((String)((List)list4).get(j)) * (long)(int)this.activity.makeXAmounts.get(this.activity.craftingMakeX)), ((List)list3).get(j) }));
                        if (n >= Integer.parseInt((String)((List)list4).get(j)) * (long)(int)this.activity.makeXAmounts.get(this.activity.craftingMakeX)) {
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
                this.activity.workshopList.addView((View)relativeLayout);
                this.activity.craftingWraps.add((Object)relativeLayout);
                textView2.setOnClickListener((View$OnClickListener)new Crafting$$ExternalSyntheticLambda3(this, list2, i));
            }
        }
    }
    
    public void OpenWorkshop() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.workshopScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        this.activity.EnableScreen();
        this.CraftingBar();
        final TextView craftingMakeXButton = this.activity.craftingMakeXButton;
        final MainActivity activity4 = this.activity;
        craftingMakeXButton.setText((CharSequence)activity4.getString(2131820664, new Object[] { activity4.makeXAmounts.get(this.activity.craftingMakeX) }));
        this.GenerateWorkshop(this.activity.currentWorkshopCategory);
    }
    
    public void Setup() {
        for (int i = 0; i < this.craftingItems.size(); ++i) {
            this.craftables.add((Object)new CraftingItem((int)this.craftingItemLevel.get(i), (String)this.craftingItems.get(i), (String)this.craftingMaterials.get(i), (String)this.craftingMaterialAmounts.get(i), (long)this.craftingItemExp.get(i), (String)this.craftingItemCategory.get(i)));
        }
    }
    
    public void UpdateMaterials(final List<CraftingItem> list) {
        Object o = "\\s*,\\s*";
        int getColour = this.activity.GetColour(2131034925);
        int getColour2 = this.activity.GetColour(2131034904);
        for (int i = 0; i < this.activity.craftingWraps.size(); ++i) {
            Object string = o;
            int n = getColour;
            int n2 = getColour2;
            int n3 = i;
            Label_0815: {
                try {
                    string = o;
                    n = getColour;
                    n2 = getColour2;
                    n3 = i;
                    final ArrayList list2 = new ArrayList((Collection)Arrays.asList((Object[])((CraftingItem)list.get(i)).GetMats().split((String)o)));
                    string = o;
                    n = getColour;
                    n2 = getColour2;
                    n3 = i;
                    string = o;
                    n = getColour;
                    n2 = getColour2;
                    n3 = i;
                    final ArrayList list3 = new ArrayList((Collection)Arrays.asList((Object[])((CraftingItem)list.get(i)).GetMatAmounts().split((String)o)));
                    string = o;
                    n = getColour;
                    n2 = getColour2;
                    n3 = i;
                    final LinearLayout linearLayout = (LinearLayout)((RelativeLayout)this.activity.craftingWraps.get(i)).getChildAt(2);
                    int n4 = 0;
                    while (true) {
                        string = o;
                        n = getColour;
                        n2 = getColour2;
                        n3 = i;
                        if (n4 < ((List)list2).size()) {
                            string = o;
                            n = getColour;
                            n2 = getColour2;
                            n3 = i;
                            final TextView textView = (TextView)linearLayout.getChildAt(n4);
                            string = o;
                            n = getColour;
                            n2 = getColour2;
                            n3 = i;
                            long n5;
                            if (((String)((List)list2).get(n4)).equals((Object)"Soul Thread")) {
                                string = o;
                                n = getColour;
                                n2 = getColour2;
                                n3 = i;
                                n5 = this.activity.combatManager.slayerInfo.getSoulThread();
                            }
                            else {
                                string = o;
                                n = getColour;
                                n2 = getColour2;
                                n3 = i;
                                if (((String)((List)list2).get(n4)).equals((Object)"Dark Thread")) {
                                    string = o;
                                    n = getColour;
                                    n2 = getColour2;
                                    n3 = i;
                                    n5 = this.activity.combatManager.slayerInfo.getDarkThread();
                                }
                                else {
                                    string = o;
                                    n = getColour;
                                    n2 = getColour2;
                                    n3 = i;
                                    if (this.activity.inventoryItems.contains(((List)list2).get(n4))) {
                                        string = o;
                                        n = getColour;
                                        n2 = getColour2;
                                        n3 = i;
                                        n5 = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf(((List)list2).get(n4)));
                                    }
                                    else {
                                        n5 = 0L;
                                    }
                                }
                            }
                            string = o;
                            n = getColour;
                            n2 = getColour2;
                            n3 = i;
                            final MainActivity activity = this.activity;
                            string = o;
                            n = getColour;
                            n2 = getColour2;
                            n3 = i;
                            final MainActivity activity2 = this.activity;
                            string = o;
                            n = getColour;
                            n2 = getColour2;
                            n3 = i;
                            final long n6 = Integer.parseInt((String)((List)list3).get(n4));
                            try {
                                final List makeXAmounts = this.activity.makeXAmounts;
                                try {
                                    n = (int)makeXAmounts.get(this.activity.craftingMakeX);
                                    final long n7 = n;
                                    try {
                                        string = activity.getString(2131820615, new Object[] { n5, activity2.FormatExp(n6 * n7), ((List)list2).get(n4) });
                                        Label_0771: {
                                            if (!textView.getText().toString().equals(string)) {
                                                textView.setText((CharSequence)string);
                                                Label_0748: {
                                                    if (n5 < Integer.parseInt((String)((List)list3).get(n4)) * (long)(int)this.activity.makeXAmounts.get(this.activity.craftingMakeX)) {
                                                        break Label_0748;
                                                    }
                                                    n = textView.getCurrentTextColor();
                                                    if (n != getColour2) {
                                                        break Label_0771;
                                                    }
                                                    try {
                                                        textView.setTextColor(getColour);
                                                        break Label_0771;
                                                        while (true) {
                                                            textView.setTextColor(getColour2);
                                                            break Label_0771;
                                                            iftrue(Label_0771:)(textView.getCurrentTextColor() != getColour);
                                                            continue;
                                                        }
                                                    }
                                                    catch (final IndexOutOfBoundsException string) {
                                                        break Label_0815;
                                                    }
                                                }
                                            }
                                        }
                                        ++n4;
                                    }
                                    catch (final IndexOutOfBoundsException string) {}
                                }
                                catch (final IndexOutOfBoundsException string) {}
                            }
                            catch (final IndexOutOfBoundsException string) {
                                break Label_0815;
                            }
                            break;
                        }
                        break;
                    }
                    continue;
                }
                catch (final IndexOutOfBoundsException ex) {
                    o = string;
                    i = n3;
                    getColour2 = n2;
                    getColour = n;
                    string = ex;
                }
            }
            this.activity.LogIt("Index out of bounds crafting: " + string);
        }
    }
    
    public static class CraftingItem
    {
        String category;
        long exp;
        String item;
        int levelRequirement;
        String materialAmounts;
        String materials;
        
        public CraftingItem(final int levelRequirement, final String item, final String materials, final String materialAmounts, final long exp, final String category) {
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
