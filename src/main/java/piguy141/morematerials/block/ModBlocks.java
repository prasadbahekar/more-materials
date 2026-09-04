package piguy141.morematerials.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import piguy141.morematerials.Main;

import java.util.function.Function;

public class ModBlocks {
    public static void initialize () {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((creativeTab) -> creativeTab.accept(BLOCK_OF_TIN));
    }

    public static ResourceKey<Block> keyOf(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
    }

    private static void registerItem(String name, Block block) {
        Identifier id = Identifier.fromNamespaceAndPath(Main.MOD_ID, name);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, id)));
        Registry.register(BuiltInRegistries.ITEM, id, blockItem);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory) {
        Identifier id = Identifier.fromNamespaceAndPath(Main.MOD_ID, name);
        Block block = blockFactory.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, id)));
        registerItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static Block BLOCK_OF_TIN = registerBlock("block_of_tin", properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
}
