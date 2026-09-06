package piguy141.morematerials.datagen;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import piguy141.morematerials.Main;
import piguy141.morematerials.item.ModItems;
import piguy141.morematerials.tags.ModTags;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static final ResourceKey<EquipmentAsset> TIN_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(Main.MOD_ID, "tin"));
    public static final ResourceKey<EquipmentAsset> AMETHYST_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(Main.MOD_ID, "amethyst"));
    public static final ArmorMaterial TIN_ARMOR_MATERIAL = new ArmorMaterial(10, ArmorMaterials.makeDefense(2, 4, 5, 2, 9), 12, SoundEvents.ARMOR_EQUIP_IRON, 0f, 0f, ModTags.Items.TIN_REPAIR, TIN_KEY);
    public static final ArmorMaterial AMETHYST_ARMOR_MATERIAL = new ArmorMaterial(28, ArmorMaterials.makeDefense(3, 6, 7, 3, 11), 25, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.5f, 0f, ModTags.Items.AMETHYST_REPAIR, AMETHYST_KEY);
}
