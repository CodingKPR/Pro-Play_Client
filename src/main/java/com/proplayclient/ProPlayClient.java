package com.proplayclient;

import com.proplayclient.gui.ClientGUI;
import com.proplayclient.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ProPlayClient implements ClientModInitializer {
    public static final String MOD_ID = "proplayclient";
    private static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        ModuleManager.initialize();
        ClientGUI.initialize();

        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.proplayclient.opengui",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.proplayclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ModuleManager.onTick(client);
            if (openGuiKey.wasPressed()) {
                ClientGUI.toggle();
            }
        });
    }
}
