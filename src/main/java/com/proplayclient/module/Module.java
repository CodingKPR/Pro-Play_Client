package com.proplayclient.module;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected String name;
    protected String category;
    protected boolean enabled;

    public Module(String name, String category) {
        this.name = name;
        this.category = category;
        this.enabled = false;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    protected void onEnable() {}
    protected void onDisable() {}
    public void onTick(MinecraftClient client) {}
}
