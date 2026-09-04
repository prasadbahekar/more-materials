package piguy141.morematerials.block;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import piguy141.morematerials.Main;

public class ModBlockItemIds {
    private static BlockItemId create(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Main.MOD_ID, name);
        return BlockItemId.create(id, id);
    }

    public static BlockItemId BLOCK_OF_TIN = create("block_of_tin");
}
