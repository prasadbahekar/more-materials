package piguy141.morematerials;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import piguy141.morematerials.datagen.ModBlockLootTableProvider;
import piguy141.morematerials.datagen.ModBlockTagsProvider;
import piguy141.morematerials.datagen.ModModelProvider;
import piguy141.morematerials.datagen.ModRecipeProvider;

public class MainDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
    }
}
