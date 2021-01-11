package net.glasslauncher.mods.machineutils.mixin.common;

import net.minecraft.entity.Living;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Living.class)
public interface LivingAccessor {

    @Accessor
    boolean isJumping();

    @Accessor
    void setJumping(boolean b);
}