package com.proplayclient.module.movement;

import com.proplayclient.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class Fly extends Module {
    public Fly() {
        super("Fly", "Movement");
    }

    @Override
    public void onEnable() {
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.getAbilities().allowFlying = true;
        }
    }

    @Override
    public void onDisable() {
        if (MinecraftClient.getInstance().player != null) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            player.getAbilities().allowFlying = false;
            player.getAbilities().flying = false;
        }
    }
}
