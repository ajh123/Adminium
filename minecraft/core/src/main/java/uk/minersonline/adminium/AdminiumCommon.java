package uk.minersonline.adminium;

import uk.minersonline.adminium.managers.PermissionManager;
import uk.minersonline.adminium.managers.PlayerManager;

public abstract class AdminiumCommon {
    private static AdminiumCommon instance;

    public static AdminiumCommon getInstance() {
        return instance;
    }

    protected AdminiumCommon() {
        instance = this;
    }

    private final PlayerManager playerManager = new PlayerManager();

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    private final PermissionManager permissionManager = new PermissionManager();

    public PermissionManager getPermissionManager() {
        return permissionManager;
    }
}
