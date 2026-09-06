package piguy141.morematerials.item;

import net.minecraft.world.item.ToolMaterial;
import piguy141.morematerials.tags.ModTags;

public class ModToolMaterials {
    public static final ToolMaterial TIN = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_TIN_TOOL,
            150,
            5f,
            1f,
            12,
            ModTags.Items.TIN_REPAIR
    );

    public static final ToolMaterial AMETHYST = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL,
            1650,
            8.5f,
            3f,
            20,
            ModTags.Items.AMETHYST_REPAIR
    );
}
