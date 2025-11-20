package ua.borukva.idmid.mixin;

import ua.borukva.idmid.util.IDMIDAccessor;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class PlayerEntityMixin {
    @ModifyVariable(at = @At(value = "RETURN", ordinal = 2), method = "dropItem")
    private ItemEntity idmid$dropItem(ItemEntity value, ItemStack stack, boolean dropAtSelf, boolean retainOwnership) {
        if(((IDMIDAccessor)((Object)stack)).idmid$isDeathDrop()){
            ((IDMIDAccessor)value).idmid$setItemAge(-32768);
        }
        return value;
    }
}
