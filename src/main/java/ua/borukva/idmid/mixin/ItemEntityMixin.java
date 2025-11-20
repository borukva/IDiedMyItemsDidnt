package ua.borukva.idmid.mixin;

import ua.borukva.idmid.util.IDMIDAccessor;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin implements IDMIDAccessor {
    @Shadow
    private int itemAge;

    @Override
    public void idmid$setItemAge(int itemAge) {
        this.itemAge = itemAge;
    }
}
