import gregtech.api.metatileentity.multiblock.CleanroomType
import gregtech.api.recipes.RecipeMaps
import gregtech.api.recipes.ingredients.GTRecipeItemInput
import gregtech.api.recipes.ingredients.GTRecipeOreInput
import net.minecraft.item.ItemStack

println('Hello World!')

def gt(ItemStack stack) {
    return GTRecipeItemInput.getOrCreate(stack);
}
def gtore(String od, int ct) {
    return GTRecipeOreInput.getOrCreate(od, ct);
}

crafting.remove("cookingforblockheads:sink")

RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
    .inputs(gt(item('minecraft:dirt')), gtore('ingotCopper', 3))
    //.input('stone')
    .outputs(item('minecraft:nether_star') * 2)
    .cleanroom(CleanroomType.CLEANROOM) // CLEANROOM and STERILE_CLEANROOM are valid
    .duration(200) // 10 seconds
    .EUt(512) // HV recipe
    .buildAndRegister()
