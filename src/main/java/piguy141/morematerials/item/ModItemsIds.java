package piguy141.morematerials.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import piguy141.morematerials.Main;

public class ModItemsIds {
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Main.MOD_ID, name));
    }

    public static final ResourceKey<Item> TIN_INGOT = create("tin-ingot");
}
