package piguy141.morematerials.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import piguy141.morematerials.block.ModBlocks;
import piguy141.morematerials.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.keyOf(ModBlocks.BLOCK_OF_TIN))
                .add(ModBlocks.keyOf(ModBlocks.TIN_ORE));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.keyOf(ModBlocks.BLOCK_OF_TIN))
                .add(ModBlocks.keyOf(ModBlocks.TIN_ORE));

        tag(ModTags.Blocks.INCORRECT_FOR_TIN_TOOL).addOptionalTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
    }
}
