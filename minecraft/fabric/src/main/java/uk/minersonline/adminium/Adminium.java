package uk.minersonline.adminium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.entity.player.PlayerEntity;
import uk.minersonline.adminium.managers.PermissionManager;
import uk.minersonline.adminium.utils.AdminiumPlayer;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.lucko.fabric.api.permissions.v0.OfflinePermissionCheckEvent;
import me.lucko.fabric.api.permissions.v0.PermissionCheckEvent;

public class Adminium extends AdminiumCommon implements ModInitializer {
	public static final String MOD_ID = "adminium";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		if (net.fabricmc.loader.api.FabricLoader.getInstance().getEnvironmentType() == net.fabricmc.api.EnvType.SERVER) {
			LOGGER.info("Adminium is running on the server side, initialising...");

			PermissionCheckEvent.EVENT.register((source, permission) -> {
				if (source instanceof PlayerEntity player) {
					AdminiumPlayer adminiumPlayer = this.getPlayerManager().getAndSet(player.getUuid(), player.getGameProfile().getName());
					var state = adminiumPlayer.hasPermission(PermissionManager.fromString(permission));
					switch (state) {
						case TRUE:
							return TriState.TRUE;
						case FALSE:
							return TriState.FALSE;
						case UNDEFINED:
							return TriState.DEFAULT;
					}
				}
				return TriState.DEFAULT;
			});

			OfflinePermissionCheckEvent.EVENT.register((uuid, permission) -> {
				return CompletableFuture.supplyAsync(() -> {
					var adminiumPlayer = this.getPlayerManager().getPlayer(uuid);
					if (adminiumPlayer == null) {
						return TriState.DEFAULT;
					}
					var state = adminiumPlayer.hasPermission(PermissionManager.fromString(permission));
					switch (state) {
						case TRUE:
							return TriState.TRUE;
						case FALSE:
							return TriState.FALSE;
						case UNDEFINED:
							return TriState.DEFAULT;
					}
					return TriState.DEFAULT;
				});
			});
		} else {
			LOGGER.warn("Adminium is running on client side, skipping initialisation.");
		}
	}
}