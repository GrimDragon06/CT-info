package uk.playdrop.cherrytree_idletextrpg;

import com.google.gson.JsonObject;
import java.util.Iterator;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RawItems
{
    MainActivity activity;
    
    public RawItems(final MainActivity activity) {
        this.activity = activity;
    }
    
    private String loadJSONFromAsset() {
        String s;
        try {
            final InputStream open = this.activity.getAssets().open("items.json");
            final byte[] array = new byte[open.available()];
            open.read(array);
            open.close();
            s = new String(array, StandardCharsets.UTF_8);
        }
        catch (final IOException ex) {
            s = null;
        }
        return s;
    }
    
    public void CreateItems() {
        final String loadJSONFromAsset = this.loadJSONFromAsset();
        if (loadJSONFromAsset != null) {
            final Iterator iterator = JsonParser.parseString(loadJSONFromAsset).getAsJsonArray().iterator();
            while (iterator.hasNext()) {
                final JsonObject asJsonObject = ((JsonElement)iterator.next()).getAsJsonObject();
                this.activity.allItems.add((Object)asJsonObject.get("name").getAsString());
                this.activity.allItemsRarity.add((Object)asJsonObject.get("rarity").getAsString());
                this.activity.allItemsValues.add((Object)asJsonObject.get("value").getAsLong());
                this.activity.allItemsTypes.add((Object)asJsonObject.get("type").getAsString());
                this.activity.allItemsHealingAmount.add((Object)asJsonObject.get("healing").getAsInt());
                this.activity.allItemsFarmingLevel.add((Object)asJsonObject.get("farming").getAsInt());
                this.activity.allItemsAttackBonus.add((Object)asJsonObject.get("attack").getAsInt());
                this.activity.allItemsStrengthBonus.add((Object)asJsonObject.get("strength").getAsInt());
                this.activity.allItemsDefenceBonus.add((Object)asJsonObject.get("defence").getAsInt());
                this.activity.allItemsHealthBonus.add((Object)asJsonObject.get("health").getAsInt());
                this.activity.allItemsDescriptions.add((Object)asJsonObject.get("description").getAsString());
            }
        }
    }
}
