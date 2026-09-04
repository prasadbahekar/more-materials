package piguy141.morematerials;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;
import piguy141.morematerials.block.ModBlocks;
import piguy141.morematerials.item.ModItems;
import piguy141.morematerials.world.ModPlacedFeatures;

public class Main implements ModInitializer {
	public static final String MOD_ID = "more-materials";
	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModBlocks.initialize();

		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ModPlacedFeatures.TIN_ORE_PLACED);
	}
}