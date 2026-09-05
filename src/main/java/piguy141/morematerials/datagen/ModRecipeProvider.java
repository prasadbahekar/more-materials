package piguy141.morematerials.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;
import piguy141.morematerials.block.ModBlocks;
import piguy141.morematerials.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> TIN_SMELTABLES = List.of(ModBlocks.TIN_ORE);
                oreSmelting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TIN_INGOT, 0.25f, 200, "tin");
                oreBlasting(TIN_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TIN_INGOT, 0.25f, 200, "tin");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_TIN);
                ShapelessRecipeBuilder.shapeless(registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.TIN_INGOT, 9)
                        .requires(ModBlocks.BLOCK_OF_TIN)
                        .unlockedBy("has_block_of_tin", has(ModBlocks.BLOCK_OF_TIN))
                        .save(output, "tin_ingots_from_block");

                shaped(RecipeCategory.COMBAT, ModItems.TIN_SWORD)
                        .pattern("T")
                        .pattern("T")
                        .pattern("S")
                        .define('T', ModItems.TIN_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.TIN_INGOT), has(ModItems.TIN_INGOT))
                        .group("tin").save(output, "tin_sword");
            }
        };
    }

    @Override
    public String getName() {
        return "MoreMaterials Recipes";
    }
}
