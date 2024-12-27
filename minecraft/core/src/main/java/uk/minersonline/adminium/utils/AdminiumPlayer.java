package uk.minersonline.adminium.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import uk.minersonline.adminium.permissions.PermissionGroup;
import uk.minersonline.adminium.permissions.PermissionNode;

public class AdminiumPlayer {
    private String name;
    private final UUID uuid;
    private final List<PermissionGroup> groups = new ArrayList<>();

    public AdminiumPlayer(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<PermissionGroup> getGroups() {
        return groups;
    }

    public void addGroup(PermissionGroup group) {
        groups.add(group);
    }

    public void removeGroup(PermissionGroup group) {
        groups.remove(group);
    }

    public TriState hasPermission(PermissionNode node) {
        for (PermissionGroup group : groups) {
            TriState state = group.hasPermission(node);
            if (state != TriState.UNDEFINED) {
                return state;
            }
        }
        return TriState.UNDEFINED;
    }
}
