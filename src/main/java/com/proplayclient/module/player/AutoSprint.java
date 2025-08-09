package com.proplayclient.module.player;

import com.proplayclient.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class AutoSprint extends Module {
    public AutoSprint() {
        super("AutoSprint", "Player");
    }

    @Override
    public void onTick(MinecraftClient client) {
        if (client.player != null) {
            client.player.setSprinting(true);
        }
    }
}
