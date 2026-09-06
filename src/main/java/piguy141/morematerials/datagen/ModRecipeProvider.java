package piguy141.morematerials.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
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
                // Tin
                List<ItemLike> tinSmeltables = List.of(ModBlocks.TIN_ORE);
                oreSmelting(tinSmeltables, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TIN_INGOT, 0.25f, 200, "tin");
                oreBlasting(tinSmeltables, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.TIN_INGOT, 0.25f, 200, "tin");
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_TIN);
                ShapelessRecipeBuilder.shapeless(registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.TIN_INGOT, 9)
                        .requires(ModBlocks.BLOCK_OF_TIN)
                        .unlockedBy(getHasName(ModBlocks.BLOCK_OF_TIN), has(ModBlocks.BLOCK_OF_TIN))
                        .save(output, "tin_ingots_from_block");

                addMaterialRecipes(new MaterialSet(
                        ModItems.TIN_INGOT,
                        ModItems.TIN_SWORD,
                        ModItems.TIN_PICKAXE,
                        ModItems.TIN_AXE,
                        ModItems.TIN_SHOVEL,
                        ModItems.TIN_HOE,
                        ModItems.TIN_HELMET,
                        ModItems.TIN_CHESTPLATE,
                        ModItems.TIN_LEGGINGS,
                        ModItems.TIN_BOOTS
                ));

                // Amethyst
                List<ItemLike> amethystSmeltables = List.of(ModBlocks.AMETHYST_ORE);
                oreSmelting(amethystSmeltables, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.AMETHYST_GEM, 0.25f, 200, "amethyst");
                oreBlasting(amethystSmeltables, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.AMETHYST_GEM, 0.25f, 200, "amethyst");
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.AMETHYST_GEM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_AMETHYST);
                ShapelessRecipeBuilder.shapeless(registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.AMETHYST_GEM, 9)
                        .requires(ModBlocks.BLOCK_OF_AMETHYST)
                        .unlockedBy(getHasName(ModBlocks.BLOCK_OF_AMETHYST), has(ModBlocks.BLOCK_OF_AMETHYST))
                        .save(output, "amethyst_gems_from_block");

                addMaterialRecipes(new MaterialSet(
                        ModItems.AMETHYST_GEM,
                        ModItems.AMETHYST_SWORD,
                        ModItems.AMETHYST_PICKAXE,
                        ModItems.AMETHYST_AXE,
                        ModItems.AMETHYST_SHOVEL,
                        ModItems.AMETHYST_HOE,
                        ModItems.AMETHYST_HELMET,
                        ModItems.AMETHYST_CHESTPLATE,
                        ModItems.AMETHYST_LEGGINGS,
                        ModItems.AMETHYST_BOOTS
                ));
            }

            private void addMaterialRecipes(MaterialSet material) {
                var items = registries.lookupOrThrow(Registries.ITEM);

                // Sword
                ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, material.sword())
                        .pattern("T")
                        .pattern("T")
                        .pattern("S")
                        .define('T', material.ingredient())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Pickaxe
                ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, material.pickaxe())
                        .pattern("TTT")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('T', material.ingredient())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Axe
                ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, material.axe())
                        .pattern("TT")
                        .pattern("ST")
                        .pattern("S ")
                        .define('T', material.ingredient())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Shovel
                ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, material.shovel())
                        .pattern("T")
                        .pattern("S")
                        .pattern("S")
                        .define('T', material.ingredient())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Hoe
                ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, material.hoe())
                        .pattern("TT")
                        .pattern("S ")
                        .pattern("S ")
                        .define('T', material.ingredient())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Helmet
                ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, material.helmet())
                        .pattern("TTT")
                        .pattern("T T")
                        .define('T', material.ingredient())
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Chestplate
                ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, material.chestplate())
                        .pattern("T T")
                        .pattern("TTT")
                        .pattern("TTT")
                        .define('T', material.ingredient())
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Leggings
                ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, material.leggings())
                        .pattern("TTT")
                        .pattern("T T")
                        .pattern("T T")
                        .define('T', material.ingredient())
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);

                // Boots
                ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, material.boots())
                        .pattern("T T")
                        .pattern("T T")
                        .define('T', material.ingredient())
                        .unlockedBy(getHasName(material.ingredient()), has(material.ingredient()))
                        .save(output);
            }
        };
    }

    private record MaterialSet(
            ItemLike ingredient,
            ItemLike sword,
            ItemLike pickaxe,
            ItemLike axe,
            ItemLike shovel,
            ItemLike hoe,
            ItemLike helmet,
            ItemLike chestplate,
            ItemLike leggings,
            ItemLike boots
    ) {}

    @Override
    public String getName() {
        return "MoreMaterials Recipes";
    }
}
