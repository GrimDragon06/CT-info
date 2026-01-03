package uk.playdrop.cherrytree_idletextrpg;

import android.view.ViewStub;
import android.view.ContextThemeWrapper;
import android.view.View$OnClickListener;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import com.squareup.picasso.Picasso;
import android.view.ViewGroup;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ProgressBar;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.List;
import android.widget.LinearLayout;

public class Quests
{
    MainActivity activity;
    LinearLayout llItems;
    LinearLayout llRewards;
    LinearLayout llSkills;
    List<Integer> npcAvatars;
    List<String> npcNames;
    List<String> questGiver;
    LinearLayout questGrid;
    List<String> questItems;
    List<String> questRequirement;
    List<String> questReward;
    List<String> questSkills;
    List<String> questTitle;
    List<String> questsComplete;
    ImageView qvAvatar;
    TextView qvComplete;
    TextView qvDesc;
    TextView qvName;
    TextView qv_back;
    ScrollView singleQuestScreen;
    
    public Quests(final MainActivity activity) {
        this.questsComplete = (List<String>)new ArrayList();
        this.questTitle = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Farmer I", "Farmer II", "Farmer III", "Farmer IV", "Farmer V", "Crafter I", "Crafter II", "Crafter III", "Crafter IV", "Crafter V", "Alchemy I", "Alchemy II", "Alchemy III", "Alchemy IV", "Alchemy V", "Fishing I", "Fishing II", "Fishing III", "Fishing IV", "Fishing V", "Warrior I", "Warrior II", "Warrior III", "Warrior IV", "Warrior V", "Wealth I", "Wealth II", "Wealth III", "Wealth IV", "Wealth V", "Cooking I", "Cooking II", "Cooking III", "Cooking IV", "Cooking V", "I like Knitting I", "I like Knitting II", "I like Knitting III", "I like Knitting IV", "I like Knitting V", "I like Knitting VI", "I like Knitting VII", "I like Knitting VIII", "I like Knitting IX", "I like Knitting X", "I like Knitting XI", "I like Knitting XII", "I like Knitting XIII", "I like Knitting XIV", "I like Knitting XV", "I like Knitting XVI", "I like Knitting XVII", "I like Knitting XVIII", "I like Knitting XIX", "I like Knitting XX", "The Hoarder I", "The Hoarder II", "The Hoarder III", "The Hoarder IV", "The Hoarder V", "The Hoarder VI", "The Hoarder VII", "The Hoarder VIII", "The Hoarder IX", "The Hoarder X", "The Hoarder XI", "The Hoarder XII", "The Hoarder XIII", "The Hoarder XIV", "The Hoarder XV", "The Hoarder XVI", "The Hoarder XVII", "The Hoarder XVIII", "The Hoarder XIX", "The Hoarder XX", "Potions Forever I", "Potions Forever II", "Potions Forever III", "Potions Forever IV", "Potions Forever V", "Potions Forever VI", "Potions Forever VII", "Potions Forever VIII", "Potions Forever IX", "Potions Forever X", "Potions Forever XI", "Potions Forever XII", "Potions Forever XIII", "Potions Forever XIV", "Potions Forever XV", "Potions Forever XVI", "Potions Forever XVII", "Potions Forever XVIII", "Potions Forever XIX", "Death to All I", "Death to All II", "Death to All III", "Death to All IV", "Death to All V", "Death to All VI", "Chest Collector I", "Chest Collector II", "Chest Collector III", "Chest Collector IV", "Chest Collector V", "Cooking VI", "Cooking VII", "Cooking VIII", "Cooking IX", "Cooking X", "Wealth VI", "Wealth VII", "Wealth VIII", "Wealth IX", "Wealth X", "My Precious Gold I", "My Precious Gold II", "My Precious Gold III", "My Precious Gold IV", "My Precious Gold V", "My Precious Gold VI", "My Precious Gold VII", "My Precious Gold VIII", "Secret Keeper I", "Secret Keeper II", "Secret Keeper III", "Secret Keeper IV", "Secret Keeper V", "Secret Keeper VI", "Secret Keeper VII", "Secret Keeper VIII", "Secret Keeper IX", "Secret Keeper X", "Secret Keeper XI", "Sleepless Cogs I", "Sleepless Cogs II", "Sleepless Cogs III", "Sleepless Cogs IV", "Sleepless Cogs V", "Sleepless Cogs VI", "Sleepless Cogs VII", "Sleepless Cogs VIII", "Sleepless Cogs IX", "Sleepless Cogs X", "Beginners Luck I", "Beginners Luck II", "Beginners Luck III", "Beginners Luck IV", "Beginners Luck V", "Beginners Luck VI", "Beginners Luck VII", "Beginners Luck VIII", "Beginners Luck IX", "Beginners Luck X", "Santas Little Helpers I", "Santas Little Helpers II", "Santas Little Helpers III", "Santas Little Helpers IV", "Santas Little Helpers V", "Santas Little Helpers VI", "Santas Little Helpers VII", "Santas Little Helpers VIII", "Santas Little Helpers IX", "Santas Little Helpers X", "Santas Little Helpers XI", "Santas Little Helpers XII", "Santas Little Helpers XIII", "Santas Little Helpers XIV", "Santas Little Helpers XV", "Santas Little Helpers XVI", "Potions Forever XX", "Potions Forever XXI", "Potions Forever XXII", "Potions Forever XXIII", "Potions Forever XXIV", "Potions Forever XXV", "Potions Forever XXVI", "Potions Forever XXVII", "Potions Forever XXVIII", "Potions Forever XXIX", "Potions Forever XXX" }));
        this.questItems = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Tomato,25", "Apple,25", "Red Onion,25", "Cherries,50", "Grapes,100", "Rope,10", "Satchel,25", "Iron Top,25", "Scarf,50", "Mithril Top,100", "Akomeric,25", "Bloodroot,50", "Hyssop,50", "Sage Leaf,100", "Vissinel,150", "Raw Shrimp,20", "Raw Carp,50", "Raw Perch,75", "Raw Jellyfish,150", "Raw Shark,250", "Bones,25", "Bones,75/Hide,25", "Bacon,50/Red Chest,5", "Ram Skull,1/Honey,10", "Golden Necklace,1/Dragon Plate,10/Dragon Leather,10", "Coins,1000", "Coins,10000", "Coins,100000", "Coins,500000", "Coins,1000000", "Shrimp,20", "Carp,50", "Perch,100", "Jellyfish,200", "Shark,500", "Thread,2000", "Thread,2000", "Thread,2000", "Thread,2000", "Thread,2000/Yarn,1000", "Thread,2000/Yarn,1000", "Thread,2000/Yarn,1000", "Thread,2000/Yarn,1000", "Thread,2000/Yarn,1000", "Thread,2000/Yarn,1000", "Thread,2000/Yarn,1000", "Thread,5000/Yarn,2000", "Thread,5000/Yarn,2000", "Thread,5000/Yarn,2000", "Thread,5000/Yarn,2000", "Thread,5000/Yarn,2000", "Thread,5000/Yarn,2000", "Thread,5000/Yarn,2000", "Thread,5000/Yarn,2000", "Thread,10000/Yarn,5000", "Wooden Plank,250", "Potato Sack,250", "Wooden Plank,250", "Barrel,500", "Satchel,500", "Bestiary,500", "Waterskin,1000", "Scissors,1000", "Coin Purse,1000", "Crate,1500", "Raft,1500", "Diary,1500", "Hammer,2000", "Notebook,2000", "Hourglass,2000", "Leather Bag,2500", "Scarf,2500", "Scroll,2500", "Workbench,5000", "Wine,500", "Attack Potion,25", "Defence Potion,25", "Strength Potion,25", "Fishing Potion,50", "Forestry Potion,50", "Energy Potion,50", "Super Attack Potion,100", "Super Fishing Potion,100", "Super Defence Potion,100", "Super Energy Potion,200", "Super Strength Potion,200", "Super Forestry Potion,250", "Luck Potion,250", "Extreme Energy Potion,250", "Extreme Attack Potion,500", "Extreme Defence Potion,500", "Extreme Strength Potion,500", "Extreme Forestry Potion,1000", "Insta Kill Potion,50", "Bones,500", "Bones,1000", "Bones,2500", "Dragon Bones,1000", "Dragon Bones,2500", "Dragon Bones,5000", "Common Chest,50", "Red Chest,100", "Spiked Chest,150", "Nefrit Chest,200", "Crystal Chest,500", "Fish Wedge,250", "Fish Soup,250", "Bone Stew,300", "Mushroom Soup,400", "Crab Soup,500", "Coins,10000000", "Coins,100000000", "Coins,1000000000", "Coins,10000000000", "Coins,100000000000", "Gold Coin,100", "Gold Coin,250", "Gold Coin,500", "Gold Coin,1000", "Gold Coin,2500", "Gold Coin,3500", "Gold Coin,5000", "Gold Coin,10000", "Ancient Rod,1", "Chicken Knife,1", "Cauldron,1", "Rod of Anuket,1", "Drakes Diary,1", "Mystic Hat,1", "Extreme Power Stone,3", "Ring of Death,1", "Ring of Speed,1", "Scythe of Demeter,1", "Pickaxe of the Gods,1", "Cog,20", "Cog,50", "Cog,100", "Cog,500", "Cog,1000", "Cog,2500", "Cog,5000", "Cog,10000", "Cog,25000", "Cog,50000", "Raw Shrimp,30/Shrimp,30", "Leather,10/Birds Nest,10", "Attack Potion,10/Tomato,10", "Feathers,50/Common Chest,1", "Bones,50", "Raw Minnows,100/Minnows,100", "Iron Boots,50/Mushroom,50", "Fishing Potion,50/Strawberry,50", "Oak,50/Red Chest,10", "Bones,150/Milk,50", "Hot Chocolate,10", "Hot Chocolate,15", "Hot Chocolate,20", "Hot Chocolate,25", "Hot Chocolate,30", "Hot Chocolate,50", "Hot Chocolate,60", "Hot Chocolate,75", "Hot Chocolate,90", "Hot Chocolate,100", "Hot Chocolate,120", "Hot Chocolate,140", "Hot Chocolate,150", "Hot Chocolate,175", "Hot Chocolate,200", "Hot Chocolate,250", "Lightning Potion,100", "Extreme Archery Potion,100", "Ultimate Forestry Potion,100", "Ultimate Explorers Potion,100", "Extreme Luck Potion,100", "Ultimate Strength Potion,250", "Ultimate Power Potion,250", "Golden Touch Potion,250", "Invincibility Potion,500", "Ultimate Archery Potion,500", "Cherry Bomb Potion,500" }));
        this.questGiver = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Fred", "Fred", "Fred", "Fred", "Fred", "Birnet", "Birnet", "Birnet", "Birnet", "Birnet", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Marlie", "Marlie", "Marlie", "Marlie", "Marlie", "Andreas", "Andreas", "Andreas", "Andreas", "Andreas", "Trixie", "Trixie", "Trixie", "Trixie", "Trixie", "Carla", "Carla", "Carla", "Carla", "Carla", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Norah", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Andreas", "Andreas", "Andreas", "Andreas", "Andreas", "Andreas", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Carla", "Carla", "Carla", "Carla", "Carla", "Trixie", "Trixie", "Trixie", "Trixie", "Trixie", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Hoarder Harry", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Sleepy", "Sleepy", "Sleepy", "Sleepy", "Sleepy", "Sleepy", "Sleepy", "Sleepy", "Sleepy", "Sleepy", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Carla", "Eddie", "Ellie", "Eddie", "Ellie", "Eddie", "Ellie", "Eddie", "Ellie", "Eddie", "Ellie", "Eddie", "Ellie", "Eddie", "Ellie", "Eddie", "Ellie", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi", "Aggi" }));
        this.questRequirement = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "null", "Farmer I", "Farmer II", "Farmer III", "Farmer IV", "null", "Crafter I", "Crafter II", "Crafter III", "Crafter IV", "null", "Alchemy I", "Alchemy II", "Alchemy III", "Alchemy IV", "null", "Fishing I", "Fishing II", "Fishing III", "Fishing IV", "null", "Warrior I", "Warrior II", "Warrior III", "Warrior IV", "null", "Wealth I", "Wealth II", "Wealth III", "Wealth IV", "null", "Cooking I", "Cooking II", "Cooking III", "Cooking IV", "null", "I like Knitting I", "I like Knitting II", "I like Knitting III", "I like Knitting IV", "I like Knitting V", "I like Knitting VI", "I like Knitting VII", "I like Knitting VIII", "I like Knitting IX", "I like Knitting X", "I like Knitting XI", "I like Knitting XII", "I like Knitting XIII", "I like Knitting XIV", "I like Knitting XV", "I like Knitting XVI", "I like Knitting XVII", "I like Knitting XVIII", "I like Knitting XIX", "null", "The Hoarder I", "The Hoarder II", "The Hoarder III", "The Hoarder IV", "The Hoarder V", "The Hoarder VI", "The Hoarder VII", "The Hoarder VIII", "The Hoarder IX", "The Hoarder X", "The Hoarder XI", "The Hoarder XII", "The Hoarder XIII", "The Hoarder XIV", "The Hoarder XV", "The Hoarder XVI", "The Hoarder XVII", "The Hoarder XVIII", "The Hoarder XIX", "null", "Potions Forever I", "Potions Forever II", "Potions Forever III", "Potions Forever IV", "Potions Forever V", "Potions Forever VI", "Potions Forever VII", "Potions Forever VIII", "Potions Forever IX", "Potions Forever X", "Potions Forever XI", "Potions Forever XII", "Potions Forever XIII", "Potions Forever XIV", "Potions Forever XV", "Potions Forever XVI", "Potions Forever XVII", "Potions Forever XVIII", "null", "Death to All I", "Death to All II", "Death to All III", "Death to All IV", "Death to All V", "null", "Chest Collector I", "Chest Collector II", "Chest Collector III", "Chest Collector IV", "Cooking V", "Cooking VI", "Cooking VII", "Cooking VIII", "Cooking IX", "Wealth V", "Wealth VI", "Wealth VII", "Wealth VIII", "Wealth IX", "null", "My Precious Gold I", "My Precious Gold II", "My Precious Gold III", "My Precious Gold IV", "My Precious Gold V", "My Precious Gold VI", "My Precious Gold VII", "null", "Secret Keeper I", "Secret Keeper II", "Secret Keeper III", "Secret Keeper IV", "Secret Keeper V", "Secret Keeper VI", "Secret Keeper VII", "Secret Keeper VIII", "Secret Keeper IX", "Secret Keeper X", "null", "Sleepless Cogs I", "Sleepless Cogs II", "Sleepless Cogs III", "Sleepless Cogs IV", "Sleepless Cogs V", "Sleepless Cogs VI", "Sleepless Cogs VII", "Sleepless Cogs VIII", "Sleepless Cogs IX", "null", "Beginners Luck I", "Beginners Luck II", "Beginners Luck III", "Beginners Luck IV", "Beginners Luck V", "Beginners Luck VI", "Beginners Luck VII", "Beginners Luck VIII", "Beginners Luck IX", "null", "Santas Little Helpers I", "Santas Little Helpers II", "Santas Little Helpers III", "Santas Little Helpers IV", "Santas Little Helpers V", "Santas Little Helpers VI", "Santas Little Helpers VII", "Santas Little Helpers VIII", "Santas Little Helpers IX", "Santas Little Helpers X", "Santas Little Helpers XI", "Santas Little Helpers XII", "Santas Little Helpers XIII", "Santas Little Helpers XIV", "Santas Little Helpers XV", "Potions Forever XIX", "Potions Forever XX", "Potions Forever XXI", "Potions Forever XXII", "Potions Forever XXIII", "Potions Forever XXIV", "Potions Forever XXV", "Potions Forever XXVI", "Potions Forever XXVII", "Potions Forever XXVIII", "Potions Forever XXIX" }));
        this.questSkills = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "null", "Farming,10", "Farming,30", "Farming,60", "Farming,90", "null", "Crafting,10", "Crafting,30", "Crafting,60", "Crafting,90", "null", "Alchemy,10", "Alchemy,30", "Alchemy,60", "Alchemy,90", "null", "Fishing,10", "Fishing,30", "Fishing,60", "Fishing,90", "null", "Attack,10", "Strength,30", "Defence,60", "Attack,90/Strength,90/Defence,90", "null", "null", "null", "null", "null", "null", "Cooking,10", "Cooking,30", "Cooking,60", "Cooking,90", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "Alchemy,5", "Alchemy,10", "Alchemy,18", "Alchemy,25", "Alchemy,32", "Alchemy,38", "Alchemy,40", "Alchemy,45", "Alchemy,52", "Alchemy,57", "Alchemy,62", "Alchemy,65", "Alchemy,70", "Alchemy,76", "Alchemy,80", "Alchemy,85", "Alchemy,90", "Alchemy,99", "Attack,60/Strength,60/Defence,60", "Attack,70/Strength,70/Defence,70", "Attack,80/Strength,80/Defence,80", "Attack,90/Strength,90/Defence,90", "Attack,95/Strength,95/Defence,95", "Attack,99/Strength,99/Defence,99", "null", "null", "null", "null", "null", "Cooking,105", "Cooking,110", "Cooking,115", "Cooking,120", "Cooking,125", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "Fishing,99", "Strength,99", "Alchemy,130", "Crafting,130", "Discovery,99", "Slayer,99", "Defence,99", "Cooking,130", "Thieving,99", "Firemaking,130", "Mining,130", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "Fishing,10/Cooking,10", "Crafting,10/Discovery,10", "Alchemy,10/Farming,10", "Attack,10/Strength,10", "Defence,10/Slayer,10", "Fishing,30/Cooking,30", "Crafting,30/Discovery,30", "Alchemy,30/Farming,30", "Attack,30/Strength,30", "Defence,30/Slayer,30", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "Alchemy,102", "Alchemy,104", "Alchemy,106", "Alchemy,108", "Alchemy,110", "Alchemy,118", "Alchemy,125", "Alchemy,128", "Alchemy,130", "Alchemy,135", "Alchemy,140" }));
        this.questReward = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Exp,Farming,1000", "Exp,Farming,10000", "Exp,Farming,50000", "Exp,Farming,100000", "Exp,Farming,2000000", "Exp,Crafting,1000", "Exp,Crafting,10000", "Exp,Crafting,50000", "Exp,Crafting,100000", "Exp,Crafting,2000000", "Exp,Alchemy,1000", "Exp,Alchemy,10000", "Exp,Alchemy,50000", "Exp,Alchemy,100000", "Exp,Alchemy,2000000", "Exp,Fishing,1000", "Exp,Fishing,10000", "Exp,Fishing,50000", "Exp,Fishing,100000", "Exp,Fishing,2000000", "Exp,Attack,1000/Exp,Strength,1000/Exp,Defence,1000", "Exp,Attack,10000/Exp,Strength,10000/Exp,Defence,10000", "Exp,Attack,50000/Exp,Strength,50000/Exp,Defence,50000", "Exp,Attack,100000/Exp,Strength,100000/Exp,Defence,100000", "Exp,Attack,2000000/Exp,Strength,2000000/Exp,Defence,2000000", "Item,Small Exp Scroll,1/Item,Gold Coin,5", "Item,Small Exp Scroll,3/Item,Gold Coin,10", "Item,Medium Exp Scroll,1/Item,Gold Coin,15", "Item,Medium Exp Scroll,3/Item,Gold Coin,25", "Item,Large Exp Scroll,10/Item,Gold Coin,40", "Exp,Cooking,1000", "Exp,Cooking,10000", "Exp,Cooking,50000", "Exp,Cooking,100000", "Exp,Cooking,2000000", "Item,Medium Exp Scroll,1/Item,Gold Coin,5", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,2/Item,Gold Coin,10", "Item,Medium Exp Scroll,2", "Item,Medium Exp Scroll,2", "Item,Medium Exp Scroll,3/Item,Gold Coin,15", "Item,Medium Exp Scroll,3", "Item,Medium Exp Scroll,3", "Item,Medium Exp Scroll,3/Item,Gold Coin,20", "Item,Medium Exp Scroll,4", "Item,Medium Exp Scroll,4", "Item,Medium Exp Scroll,5/Item,Gold Coin,25", "Item,Medium Exp Scroll,5", "Item,Medium Exp Scroll,5", "Item,Large Exp Scroll,5/Item,Gold Coin,40", "Item,Large Exp Scroll,5", "Item,Large Exp Scroll,5", "Item,Large Exp Scroll,5", "Item,Large Exp Scroll,10/Item,Gold Coin,60", "Item,Medium Exp Scroll,1", "Item,Medium Exp Scroll,2", "Item,Medium Exp Scroll,3", "Item,Medium Exp Scroll,4", "Item,Medium Exp Scroll,5", "Item,Medium Exp Scroll,6", "Item,Medium Exp Scroll,7", "Item,Medium Exp Scroll,8", "Item,Medium Exp Scroll,9", "Item,Medium Exp Scroll,10", "Item,Medium Exp Scroll,11", "Item,Medium Exp Scroll,12", "Item,Medium Exp Scroll,13", "Item,Medium Exp Scroll,14", "Item,Medium Exp Scroll,15", "Item,Medium Exp Scroll,16", "Item,Medium Exp Scroll,17", "Item,Medium Exp Scroll,18", "Item,Medium Exp Scroll,19", "Item,Medium Exp Scroll,20", "Exp,Alchemy,500", "Exp,Alchemy,750", "Exp,Alchemy,1000", "Exp,Alchemy,1500", "Exp,Alchemy,2000", "Exp,Alchemy,2500", "Exp,Alchemy,3000", "Exp,Alchemy,5000", "Exp,Alchemy,10000", "Exp,Alchemy,15000", "Exp,Alchemy,20000", "Exp,Alchemy,25000", "Exp,Alchemy,50000", "Exp,Alchemy,75000", "Exp,Alchemy,100000", "Exp,Alchemy,250000", "Exp,Alchemy,500000", "Exp,Alchemy,1000000", "Exp,Alchemy,5000000", "Item,Gold Coin,5", "Item,Gold Coin,10", "Item,Gold Coin,15", "Item,Gold Coin,20", "Item,Gold Coin,25", "Item,Gold Coin,30", "Item,Gold Coin,5", "Item,Gold Coin,10", "Item,Gold Coin,20", "Item,Gold Coin,30", "Item,Gold Coin,50", "Exp,Cooking,3000000", "Exp,Cooking,5000000", "Exp,Cooking,7500000", "Exp,Cooking,10000000", "Exp,Cooking,15000000", "Item,Large Exp Scroll,12/Item,Gold Coin,50", "Item,Large Exp Scroll,14/Item,Gold Coin,50", "Item,Large Exp Scroll,16/Item,Gold Coin,50", "Item,Large Exp Scroll,18/Item,Gold Coin,50", "Item,Large Exp Scroll,20/Item,Gold Coin,50", "Item,Large Exp Scroll,5", "Item,Large Exp Scroll,10", "Item,Large Exp Scroll,15", "Item,Massive Exp Scroll,1", "Item,Massive Exp Scroll,1", "Item,Massive Exp Scroll,1", "Item,Massive Exp Scroll,1", "Item,Massive Exp Scroll,1", "Item,Gold Coin,25", "Item,Gold Coin,50", "Item,Gold Coin,75", "Item,Gold Coin,100", "Item,Gold Coin,125", "Item,Gold Coin,150", "Item,Gold Coin,175", "Item,Gold Coin,200", "Item,Gold Coin,225", "Item,Gold Coin,250", "Item,Gold Coin,250", "Item,Gold Coin,50", "Item,Wood,1", "Item,Cog,1", "Item,Wood,1", "Item,Cog,1", "Item,Wood,1", "Item,Cog,1", "Item,Wood,1", "Item,Cog,1", "Item,Wood,1", "Item,Casket of Treasure,5", "Item,Casket of Treasure,10", "Item,Casket of Treasure,15", "Item,Casket of Treasure,20", "Item,Casket of Treasure,25", "Item,Casket of Treasure,30", "Item,Casket of Treasure,35", "Item,Casket of Treasure,40", "Item,Casket of Treasure,45", "Item,Casket of Treasure,50", "Item,Special Currency,10", "Item,Christmas Stocking,50", "Item,Special Currency,10", "Item,Christmas Stocking,75", "Item,Special Currency,10", "Item,Christmas Stocking,100", "Item,Special Currency,15", "Item,Christmas Stocking,150", "Item,Special Currency,20", "Item,Christmas Stocking,200", "Item,Special Currency,25", "Item,Christmas Stocking,250", "Item,Special Currency,25/Item,Christmas Stocking,250", "Item,Special Currency,50", "Item,Santa Hat,1", "Avatar,Ellie,1/Avatar,Eddie,1", "Item,Gold Coin,10000", "Item,Gold Coin,20000", "Item,Gold Coin,30000", "Item,Gold Coin,40000", "Item,Gold Coin,50000", "Item,Gold Coin,60000", "Item,Gold Coin,70000", "Item,Gold Coin,80000", "Item,Gold Coin,90000", "Item,Gold Coin,100000", "Item,Gold Coin,150000" }));
        this.npcNames = (List<String>)new ArrayList((Collection)Arrays.asList((Object[])new String[] { "Fred", "Birnet", "Aggi", "Marlie", "Andreas", "Trixie", "Carla", "Skully", "Norah", "Hoarder Harry", "Jack", "Sleepy", "Ellie", "Eddie" }));
        this.npcAvatars = (List<Integer>)new ArrayList((Collection)Arrays.asList((Object[])new Integer[] { 2131165319, 2131165307, 2131165305, 2131165322, 2131165306, 2131165327, 2131165308, 2131165325, 2131165323, 2131165320, 2131165321, 2131165326, 2131165317, 2131165318 }));
        this.activity = activity;
    }
    
    private void CompleteQuest(final int n) {
        final String[] split = ((String)this.questItems.get(n)).split("\\s*/\\s*");
        final String[] split2 = ((String)this.questReward.get(n)).split("\\s*/\\s*");
        if (this.InventorySpace(split2)) {
            for (int length = split.length, i = 0; i < length; ++i) {
                final String[] split3 = split[i].split("\\s*,\\s*");
                if (split3[0].equals((Object)"Coins")) {
                    final MainActivity activity = this.activity;
                    activity.totalCoins -= Long.parseLong(split3[1]);
                    this.activity.UpdateCash();
                }
                else if (split3[0].equals((Object)"Gold Coin")) {
                    final MainActivity activity2 = this.activity;
                    activity2.totalGems -= Long.parseLong(split3[1]);
                    this.activity.UpdateCash();
                }
                else {
                    this.activity.RemoveItem(split3[0], Integer.parseInt(split3[1]));
                }
            }
            for (int length2 = split2.length, j = 0; j < length2; ++j) {
                final String[] split4 = split2[j].split("\\s*,\\s*");
                if (split4[0].equals((Object)"Exp")) {
                    this.activity.GiveExp(split4[1], Long.parseLong(split4[2]), null);
                }
                else if (split4[0].equals((Object)"Item")) {
                    final String s = split4[1];
                    s.hashCode();
                    final int hashCode = s.hashCode();
                    int n2 = -1;
                    switch (hashCode) {
                        case 1803406242: {
                            if (!s.equals((Object)"Soul Gem")) {
                                break;
                            }
                            n2 = 5;
                            break;
                        }
                        case 1721869536: {
                            if (!s.equals((Object)"Enhancement Ticket")) {
                                break;
                            }
                            n2 = 4;
                            break;
                        }
                        case 658894417: {
                            if (!s.equals((Object)"Gold Coin")) {
                                break;
                            }
                            n2 = 3;
                            break;
                        }
                        case 464123864: {
                            if (!s.equals((Object)"Special Currency")) {
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
                        case -1326946875: {
                            if (!s.equals((Object)"Challenge Coins")) {
                                break;
                            }
                            n2 = 0;
                            break;
                        }
                    }
                    switch (n2) {
                        default: {
                            this.activity.GiveItem(split4[1], Long.parseLong(split4[2]), true);
                            break;
                        }
                        case 5: {
                            final CombatManager$SlayerInfo slayerInfo = this.activity.combatManager.slayerInfo;
                            slayerInfo.soulGems += Long.parseLong(split4[2]);
                            break;
                        }
                        case 4: {
                            final ItemManager$Blessings blessings = this.activity.itemManager.blessings;
                            blessings.tickets += Long.parseLong(split4[2]);
                            break;
                        }
                        case 3: {
                            final MainActivity activity3 = this.activity;
                            activity3.totalGems += Long.parseLong(split4[2]);
                            this.activity.UpdateCash();
                            break;
                        }
                        case 2: {
                            final TreasureHunts.EventPresent eventPresent = this.activity.treasureHunts.eventPresent;
                            eventPresent.specialCurrency += Integer.parseInt(split4[2]);
                            break;
                        }
                        case 1: {
                            final TreasureHunts.MyTreasureHunts myTreasureHunts = this.activity.treasureHunts.myTreasureHunts;
                            myTreasureHunts.caskets += (int)Long.parseLong(split4[2]);
                            break;
                        }
                        case 0: {
                            final Dailies dailies = this.activity.dailies;
                            dailies.challengeCoins += (int)Long.parseLong(split4[2]);
                            break;
                        }
                    }
                }
                else if (split4[0].equals((Object)"Avatar")) {
                    this.activity.GiveAvatar(split4[1]);
                }
            }
            this.questsComplete.add((Object)this.questTitle.get(n));
            if (this.activity.AllQuestsComplete()) {
                this.activity.GiveTitle("the Story Finder");
            }
            this.activity.Save(true);
            this.OpenQuests();
        }
        else {
            this.activity.QuickPopup("You have no Inventory space for the rewards");
        }
    }
    
    public void AddQuest(final int n) {
        final RelativeLayout relativeLayout = (RelativeLayout)View.inflate((Context)this.activity, 2131493040, (ViewGroup)null);
        ((TextView)relativeLayout.getChildAt(1)).setText((CharSequence)this.questTitle.get(n));
        Picasso.get().load((int)this.npcAvatars.get(this.npcNames.indexOf(this.questGiver.get(n)))).into((ImageView)relativeLayout.getChildAt(0));
        if (this.HaveItems((String)this.questSkills.get(n), (String)this.questItems.get(n))) {
            relativeLayout.setAlpha(1.0f);
        }
        else {
            relativeLayout.setAlpha(0.3f);
        }
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, this.activity.GetResource(2131099991));
        linearLayout$LayoutParams.bottomMargin = this.activity.GetResource(2131100202);
        this.questGrid.addView((View)relativeLayout, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
        relativeLayout.setOnClickListener((View$OnClickListener)new Quests$$ExternalSyntheticLambda2(this, n));
    }
    
    public void GenerateItems(final String s) {
        for (final String s2 : s.split("\\s*/\\s*")) {
            final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
            linearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -2, 1.0f));
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            final String[] split2 = s2.split("\\s*,\\s*");
            final ImageView imageView = new ImageView((Context)this.activity);
            imageView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
            final MainActivity activity = this.activity;
            imageView.setImageDrawable(activity.GetImage((int)activity.allItemsIcons.get(this.activity.allItems.indexOf((Object)split2[0]))));
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236));
            linearLayout.addView((View)imageView);
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-2, -2);
            layoutParams.topMargin = this.activity.GetResource(2131099869);
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            textView.setText((CharSequence)split2[0]);
            textView.setTextColor(this.activity.white);
            textView.setGravity(17);
            final MainActivity activity2 = this.activity;
            activity2.SetTextSize(textView, activity2.GetResource(2131099658));
            linearLayout.addView((View)textView);
            final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886406));
            final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-2, -2);
            layoutParams2.topMargin = this.activity.GetResource(2131099869);
            textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            if (split2[0].equals((Object)"Coins")) {
                final StringBuilder sb = new StringBuilder();
                final MainActivity activity3 = this.activity;
                textView2.setText((CharSequence)sb.append(activity3.FormatCoins(activity3.totalCoins)).append(" / ").append(this.activity.FormatCoins(Long.parseLong(split2[1]))).toString());
            }
            else if (split2[0].equals((Object)"Gold Coin")) {
                final StringBuilder sb2 = new StringBuilder();
                final MainActivity activity4 = this.activity;
                textView2.setText((CharSequence)sb2.append(activity4.FormatCoins(activity4.totalGems)).append(" / ").append(this.activity.FormatCoins(Long.parseLong(split2[1]))).toString());
            }
            else {
                long longValue;
                if (this.activity.inventoryItems.contains((Object)split2[0])) {
                    longValue = (long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)split2[0]));
                }
                else {
                    longValue = 0L;
                }
                textView2.setText((CharSequence)(this.activity.FormatExp(longValue) + " / " + this.activity.FormatExp(Long.parseLong(split2[1]))));
            }
            textView2.setTextColor(this.activity.faded);
            textView2.setGravity(17);
            final MainActivity activity5 = this.activity;
            activity5.SetTextSize(textView2, activity5.GetResource(2131100247));
            linearLayout.addView((View)textView2);
            this.llItems.addView((View)linearLayout);
        }
    }
    
    public void GenerateRewards(final String s) {
        for (final String s2 : s.split("\\s*/\\s*")) {
            final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
            linearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -2, 1.0f));
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            final String[] split2 = s2.split("\\s*,\\s*");
            final ImageView imageView = new ImageView((Context)this.activity);
            imageView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
            if (s.contains((CharSequence)this.activity.eventCurrency)) {
                final MainActivity activity = this.activity;
                imageView.setImageDrawable(activity.GetImage(activity.eventIcon));
            }
            else if (split2[0].equals((Object)"Exp")) {
                final MainActivity activity2 = this.activity;
                imageView.setImageDrawable(activity2.GetImage((int)activity2.skillsIcons.get(this.activity.skills.indexOf((Object)split2[1]))));
            }
            else if (split2[0].equals((Object)"Item")) {
                final String s3 = split2[1];
                s3.hashCode();
                final int hashCode = s3.hashCode();
                int n = -1;
                switch (hashCode) {
                    case 1803406242: {
                        if (!s3.equals((Object)"Soul Gem")) {
                            break;
                        }
                        n = 4;
                        break;
                    }
                    case 1721869536: {
                        if (!s3.equals((Object)"Enhancement Ticket")) {
                            break;
                        }
                        n = 3;
                        break;
                    }
                    case 464123864: {
                        if (!s3.equals((Object)"Special Currency")) {
                            break;
                        }
                        n = 2;
                        break;
                    }
                    case -819624483: {
                        if (!s3.equals((Object)"Casket of Treasure")) {
                            break;
                        }
                        n = 1;
                        break;
                    }
                    case -1326946875: {
                        if (!s3.equals((Object)"Challenge Coins")) {
                            break;
                        }
                        n = 0;
                        break;
                    }
                }
                switch (n) {
                    default: {
                        final MainActivity activity3 = this.activity;
                        imageView.setImageDrawable(activity3.GetImage((int)activity3.allItemsIcons.get(this.activity.allItems.indexOf((Object)split2[1]))));
                        break;
                    }
                    case 4: {
                        imageView.setImageDrawable(this.activity.GetImage(2131166237));
                        break;
                    }
                    case 3: {
                        imageView.setImageDrawable(this.activity.GetImage(2131165610));
                        break;
                    }
                    case 2: {
                        final MainActivity activity4 = this.activity;
                        imageView.setImageDrawable(activity4.GetImage(activity4.event.specialCurrencyIcon));
                        break;
                    }
                    case 1: {
                        imageView.setImageDrawable(this.activity.GetImage(2131165669));
                        break;
                    }
                    case 0: {
                        imageView.setImageDrawable(this.activity.GetImage(2131165354));
                        break;
                    }
                }
            }
            else if (split2[0].equals((Object)"Avatar")) {
                final MainActivity activity5 = this.activity;
                imageView.setImageDrawable(activity5.GetImage((int)activity5.avatarIcons.get(this.activity.avatarNames.indexOf((Object)split2[1]))));
            }
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236));
            linearLayout.addView((View)imageView);
            final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-2, -2);
            layoutParams.topMargin = this.activity.GetResource(2131099869);
            textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            if (split2[1].equals((Object)this.activity.eventCurrency)) {
                textView.setText((CharSequence)(this.activity.FormatExp(Long.parseLong(split2[2])) + " " + split2[1] + "s"));
            }
            else if (split2[1].equals((Object)"Special Currency")) {
                textView.setText((CharSequence)(this.activity.FormatExp(Long.parseLong(split2[2])) + "x " + this.activity.event.specialCurrency + "s"));
            }
            else if (split2[0].equals((Object)"Exp")) {
                textView.setText((CharSequence)(this.activity.FormatExp(Long.parseLong(split2[2])) + " exp"));
            }
            else if (split2[0].equals((Object)"Item")) {
                textView.setText((CharSequence)(this.activity.FormatExp(Long.parseLong(split2[2])) + "x " + split2[1]));
            }
            else if (split2[0].equals((Object)"Avatar")) {
                textView.setText((CharSequence)(split2[1] + " Avatar"));
            }
            textView.setTextColor(this.activity.white);
            textView.setGravity(17);
            final MainActivity activity6 = this.activity;
            activity6.SetTextSize(textView, activity6.GetResource(2131099658));
            linearLayout.addView((View)textView);
            this.llRewards.addView((View)linearLayout);
        }
    }
    
    public void GenerateSkills(final String s) {
        if (!s.equals((Object)"null")) {
            for (final String s2 : s.split("\\s*/\\s*")) {
                final LinearLayout linearLayout = new LinearLayout((Context)this.activity);
                linearLayout.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(0, -2, 1.0f));
                linearLayout.setOrientation(1);
                linearLayout.setGravity(17);
                final String[] split2 = s2.split("\\s*,\\s*");
                final ImageView imageView = new ImageView((Context)this.activity);
                imageView.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-2, -2));
                final MainActivity activity = this.activity;
                imageView.setImageDrawable(activity.GetImage((int)activity.skillsIcons.get(this.activity.skills.indexOf((Object)split2[0]))));
                imageView.setAdjustViewBounds(true);
                imageView.setPadding(this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236), this.activity.GetResource(2131100236));
                linearLayout.addView((View)imageView);
                final TextView textView = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
                final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-2, -2);
                layoutParams.topMargin = this.activity.GetResource(2131099869);
                textView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                textView.setText((CharSequence)split2[0]);
                textView.setTextColor(this.activity.white);
                textView.setGravity(17);
                final MainActivity activity2 = this.activity;
                activity2.SetTextSize(textView, activity2.GetResource(2131099658));
                linearLayout.addView((View)textView);
                final TextView textView2 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886406));
                final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-2, -2);
                layoutParams2.topMargin = this.activity.GetResource(2131099869);
                textView2.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                textView2.setText((CharSequence)this.activity.getString(2131820646, new Object[] { split2[1] }));
                if (this.activity.GetSkillLevel(split2[0]) >= Long.parseLong(split2[1])) {
                    textView2.setTextColor(this.activity.faded);
                }
                else {
                    textView2.setTextColor(this.activity.GetColour(2131034904));
                }
                textView2.setGravity(17);
                final MainActivity activity3 = this.activity;
                activity3.SetTextSize(textView2, activity3.GetResource(2131100247));
                linearLayout.addView((View)textView2);
                this.llSkills.addView((View)linearLayout);
            }
        }
        else {
            final TextView textView3 = new TextView((Context)new ContextThemeWrapper((Context)this.activity, 2131886424));
            textView3.setLayoutParams((ViewGroup$LayoutParams)new LinearLayout$LayoutParams(-1, -2));
            textView3.setText((CharSequence)"No skills required");
            textView3.setTextColor(this.activity.faded);
            textView3.setGravity(17);
            final MainActivity activity4 = this.activity;
            activity4.SetTextSize(textView3, activity4.GetResource(2131099658));
            textView3.setPadding(this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658), this.activity.GetResource(2131099658));
            this.llSkills.addView((View)textView3);
        }
    }
    
    public boolean HaveItems(final String s, final String s2) {
        final boolean equals = s.equals((Object)"null");
        final boolean b = false;
        int n = 0;
        Label_0086: {
            if (!equals) {
                final String[] split = s.split("\\s*/\\s*");
                for (int length = split.length, i = 0; i < length; ++i) {
                    final String[] split2 = split[i].split("\\s*,\\s*");
                    if (this.activity.GetSkillLevel(split2[0]) < Long.parseLong(split2[1])) {
                        n = 0;
                        break Label_0086;
                    }
                }
            }
            n = 1;
        }
        if (n != 0) {
            final String[] split3 = s2.split("\\s*/\\s*");
            for (int length2 = split3.length, j = 0; j < length2; ++j) {
                final String[] split4 = split3[j].split("\\s*,\\s*");
                if (split4[0].equals((Object)"Coins")) {
                    if (this.activity.totalCoins < Long.parseLong(split4[1])) {
                        final int n2 = b ? 1 : 0;
                        return n2 != 0;
                    }
                }
                else if (split4[0].equals((Object)"Gold Coin")) {
                    if (this.activity.totalGems < Long.parseLong(split4[1])) {
                        final int n2 = b ? 1 : 0;
                        return n2 != 0;
                    }
                }
                else {
                    int n2 = b ? 1 : 0;
                    if (!this.activity.inventoryItems.contains((Object)split4[0])) {
                        return n2 != 0;
                    }
                    if ((long)this.activity.inventoryAmounts.get(this.activity.inventoryItems.indexOf((Object)split4[0])) < Long.parseLong(split4[1])) {
                        n2 = (b ? 1 : 0);
                        return n2 != 0;
                    }
                }
            }
        }
        int n2 = n;
        return n2 != 0;
    }
    
    public boolean InventorySpace(final String[] array) {
        final int length = array.length;
        boolean inventoryNotFull = true;
        for (int i = 0; i < length; ++i) {
            final String[] split = array[i].split("\\s*,\\s*");
            if (!split[0].equals((Object)"Exp")) {
                if (!split[0].equals((Object)"Item")) {
                    continue;
                }
                if (!split[1].equals((Object)"Gold Coin")) {
                    if (!split[1].equals((Object)this.activity.eventCurrency)) {
                        inventoryNotFull = this.activity.InventoryNotFull(split[1]);
                        continue;
                    }
                }
            }
            inventoryNotFull = true;
        }
        return inventoryNotFull;
    }
    
    public void OpenQuests() {
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        final MainActivity activity2 = this.activity;
        activity2.currentView = (View)activity2.questsScreen;
        final MainActivity activity3 = this.activity;
        activity3.ShowView(activity3.currentView);
        if (this.questGrid == null) {
            this.questGrid = (LinearLayout)this.activity.findViewById(2131297006);
        }
        this.questGrid.removeAllViews();
        for (int i = 0; i < this.questTitle.size(); ++i) {
            if ((this.questsComplete.contains(this.questRequirement.get(i)) || ((String)this.questRequirement.get(i)).equals((Object)"null")) && !this.questsComplete.contains(this.questTitle.get(i)) && !((String)this.questTitle.get(i)).contains((CharSequence)this.activity.currentEvent) && !((String)this.questTitle.get(i)).contains((CharSequence)"Halloween")) {
                this.AddQuest(i);
            }
        }
    }
    
    public void ViewQuest(final int n) {
        if (this.singleQuestScreen == null) {
            this.singleQuestScreen = (ScrollView)((ViewStub)this.activity.findViewById(2131297125)).inflate();
            final ScrollView singleQuestScreen = (ScrollView)this.activity.findViewById(2131297124);
            this.singleQuestScreen = singleQuestScreen;
            this.llItems = (LinearLayout)singleQuestScreen.findViewById(2131297016);
            this.llSkills = (LinearLayout)this.singleQuestScreen.findViewById(2131297018);
            this.llRewards = (LinearLayout)this.singleQuestScreen.findViewById(2131297017);
            this.qvComplete = (TextView)this.singleQuestScreen.findViewById(2131297015);
            this.qv_back = (TextView)this.singleQuestScreen.findViewById(2131297014);
            this.qvName = (TextView)this.singleQuestScreen.findViewById(2131297013);
            this.qvDesc = (TextView)this.singleQuestScreen.findViewById(2131297012);
            this.qvAvatar = (ImageView)this.singleQuestScreen.findViewById(2131297011);
        }
        this.activity.EnableLayout((ViewGroup)this.singleQuestScreen);
        this.llSkills.removeAllViews();
        this.llRewards.removeAllViews();
        this.llItems.removeAllViews();
        final MainActivity activity = this.activity;
        activity.HideView(activity.currentView);
        this.activity.currentView = (View)this.singleQuestScreen;
        final MainActivity activity2 = this.activity;
        activity2.ShowView(activity2.currentView);
        this.qv_back.setOnClickListener((View$OnClickListener)new Quests$$ExternalSyntheticLambda0(this));
        this.qvAvatar.setVisibility(0);
        this.qvAvatar.setImageDrawable(this.activity.GetImage((int)this.npcAvatars.get(this.npcNames.indexOf(this.questGiver.get(n)))));
        this.qvName.setText((CharSequence)this.questTitle.get(n));
        this.qvDesc.setText((CharSequence)"You will get the reward shown below");
        this.GenerateSkills((String)this.questSkills.get(n));
        this.GenerateItems((String)this.questItems.get(n));
        this.GenerateRewards((String)this.questReward.get(n));
        if (this.HaveItems((String)this.questSkills.get(n), (String)this.questItems.get(n))) {
            this.qvComplete.setAlpha(1.0f);
        }
        else {
            this.qvComplete.setAlpha(0.2f);
        }
        this.qvComplete.setOnClickListener((View$OnClickListener)new Quests$$ExternalSyntheticLambda1(this, n));
    }
}
