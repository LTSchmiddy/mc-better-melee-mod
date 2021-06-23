package net.lt_schmiddy.bettermelee;

import net.lt_schmiddy.bettermelee.config.ConfigHandler;
import net.fabricmc.api.ModInitializer;

public class ModEntry implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Loading Better Melee...");
		ConfigHandler.load();
	}
}
