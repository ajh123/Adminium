package uk.minersonline.adminium.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import uk.minersonline.adminium.utils.AdminiumPlayer;

public class PlayerManager {
    private final Map<UUID, AdminiumPlayer> players = new HashMap<>();

    public Map<UUID, AdminiumPlayer> getPlayers() {
        return players;
    }

    public AdminiumPlayer getPlayer(UUID uuid) {
        return players.get(uuid);
    }

    public AdminiumPlayer getPlayer(String name) {
        for (AdminiumPlayer player : players.values()) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void addPlayer(AdminiumPlayer player) {
        players.put(player.getUuid(), player);
    }

    public void removePlayer(AdminiumPlayer player) {
        players.remove(player.getUuid());
    }

    public AdminiumPlayer getAndSet(UUID uuid, String name) {
        AdminiumPlayer player = getPlayer(uuid);
        if (player == null) {
            player = new AdminiumPlayer(name, uuid);
            addPlayer(player);
        } else {
            player.setName(name);
        }
        return player;
    }
}
