package ua.borukva.idmid.mixin;

import ua.borukva.idmid.util.IDMIDAccessor;
import ua.borukva.idmid.util.IDMIDTags;
import net.minecraft.entity.EntityEquipment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EntityEquipment.class)
public abstract class EntityEquipmentMixin {
    @ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;"), method = "dropAll")
    private ItemStack idmid$dropAll(ItemStack stack) {
        if (!(stack.isIn(IDMIDTags.Items.FORCE_DESPAWN))) {
            ((IDMIDAccessor) ((Object) stack)).idmid$setAsDeathDrop(true);
        }
        return stack;
    }
}
