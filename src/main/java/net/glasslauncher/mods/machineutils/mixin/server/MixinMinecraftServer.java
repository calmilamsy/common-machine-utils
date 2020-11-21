package net.glasslauncher.mods.machineutils.mixin.server;

import net.fabricmc.loader.api.FabricLoader;
import net.glasslauncher.mods.machineutils.event.ingame.TickManager;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
    private long clock;

    @Inject(method = "run", at = @At(value = "INVOKE", target = "Ljava/lang/System;currentTimeMillis()J"), remap = false)
    private void onTick(CallbackInfo ci) {
        MinecraftServer minecraft = ((MinecraftServer) FabricLoader.getInstance().getGameInstance());
        long newClock;
        newClock = minecraft.levels[0].getLevelTime();
        if (newClock != clock) {
            TickManager.onTickInGame(minecraft.serverPlayerConnectionManager.players);
        }
        clock = newClock;
    }
}
