package piguy141.morematerials.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import piguy141.morematerials.Main;
import piguy141.morematerials.datagen.ModArmorMaterials;

import java.util.function.Function;

public class ModItems {
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> {
            creativeTab.accept(TIN_INGOT);
            creativeTab.accept(AMETHYST_GEM);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> {
            creativeTab.accept(TIN_SWORD);
            creativeTab.accept(TIN_AXE);
            creativeTab.accept(TIN_HELMET);
            creativeTab.accept(TIN_CHESTPLATE);
            creativeTab.accept(TIN_LEGGINGS);
            creativeTab.accept(TIN_BOOTS);

            creativeTab.accept(AMETHYST_SWORD);
            creativeTab.accept(AMETHYST_AXE);
            creativeTab.accept(AMETHYST_HELMET);
            creativeTab.accept(AMETHYST_CHESTPLATE);
            creativeTab.accept(AMETHYST_LEGGINGS);
            creativeTab.accept(AMETHYST_BOOTS);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register((creativeTab) -> {
            creativeTab.accept(TIN_PICKAXE);
            creativeTab.accept(TIN_SHOVEL);
            creativeTab.accept(TIN_HOE);
            creativeTab.accept(AMETHYST_PICKAXE);
            creativeTab.accept(AMETHYST_SHOVEL);
            creativeTab.accept(AMETHYST_HOE);
        });
    }

    public static ResourceKey<Item> keyOf(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> itemFactory) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Main.MOD_ID, name));
        Item item = itemFactory.apply(new Item.Properties().setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    // Tin Items
    public static final Item TIN_INGOT = registerItem("tin_ingot", Item::new);
    public static final Item TIN_SWORD = registerItem("tin_sword", properties -> new Item(properties.sword(ModToolMaterials.TIN, 4f, -2.4f)));
    public static final Item TIN_PICKAXE = registerItem("tin_pickaxe", properties -> new Item(properties.pickaxe(ModToolMaterials.TIN, 2f, -2.8f)));
    public static final Item TIN_AXE = registerItem("tin_axe", properties -> new Item(properties.axe(ModToolMaterials.TIN, 5f, -3.2f)));
    public static final Item TIN_SHOVEL = registerItem("tin_shovel", properties -> new Item(properties.shovel(ModToolMaterials.TIN, 2.5f, -3f)));
    public static final Item TIN_HOE = registerItem("tin_hoe", properties -> new Item(properties.hoe(ModToolMaterials.TIN, 1f, -3f)));
    public static final Item TIN_HELMET = registerItem("tin_helmet", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item TIN_CHESTPLATE = registerItem("tin_chestplate", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item TIN_LEGGINGS = registerItem("tin_leggings", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item TIN_BOOTS = registerItem("tin_boots", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.TIN_ARMOR_MATERIAL, ArmorType.BOOTS)));

    // Amethyst Items
    public static final Item AMETHYST_GEM = registerItem("amethyst_gem", Item::new);
    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword", properties -> new Item(properties.sword(ModToolMaterials.AMETHYST, 6f, -2.4f)));
    public static final Item AMETHYST_PICKAXE = registerItem("amethyst_pickaxe", properties -> new Item(properties.pickaxe(ModToolMaterials.AMETHYST, 4f, -2.8f)));
    public static final Item AMETHYST_AXE = registerItem("amethyst_axe", properties -> new Item(properties.axe(ModToolMaterials.AMETHYST, 7f, -3.2f)));
    public static final Item AMETHYST_SHOVEL = registerItem("amethyst_shovel", properties -> new Item(properties.shovel(ModToolMaterials.AMETHYST, 4.5f, -3f)));
    public static final Item AMETHYST_HOE = registerItem("amethyst_hoe", properties -> new Item(properties.hoe(ModToolMaterials.AMETHYST, 3f, -3f)));
    public static final Item AMETHYST_HELMET = registerItem("amethyst_helmet", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item AMETHYST_CHESTPLATE = registerItem("amethyst_chestplate", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item AMETHYST_LEGGINGS = registerItem("amethyst_leggings", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item AMETHYST_BOOTS = registerItem("amethyst_boots", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorType.BOOTS)));
}
