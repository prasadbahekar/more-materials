package piguy141.morematerials.world;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import piguy141.morematerials.Main;

import java.util.List;

public class ModPlacedFeatures {
    public static void configure (BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> tinOreModifiers = List.of(
                CountPlacement.of(10),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(64))
        );

        context.register(TIN_ORE_PLACED, new PlacedFeature(configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_VEIN), tinOreModifiers));
    }

    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED =
        ResourceKey.create(
                Registries.PLACED_FEATURE,
                Identifier.fromNamespaceAndPath(Main.MOD_ID, "tin_ore_placed")
        );
}
