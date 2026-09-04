package piguy141.morematerials;

import net.fabricmc.api.ModInitializer;
import piguy141.morematerials.block.ModBlocks;
import piguy141.morematerials.item.ModItems;

public class Main implements ModInitializer {
	public static final String MOD_ID = "more-materials";
	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModBlocks.initialize();
	}
}