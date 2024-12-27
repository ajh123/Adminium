package uk.minersonline.adminium.permissions;

import java.util.ArrayList;
import java.util.List;

import uk.minersonline.adminium.utils.TriState;

public class PermissionGroup {
    private final String name;
    private final List<PermissionState> permissions = new ArrayList<>();

    public PermissionGroup(String name) {
        if (!name.matches("[a-zA-Z0-9_-]+")) {
            throw new IllegalArgumentException("Group name can only contain alphanumeric characters, underscores, and hyphens.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<PermissionState> getPermissions() {
        return permissions;
    }

    public void addPermission(PermissionState permission) {
        // Check if a permission state with the same node already exists
        permissions.removeIf(existingPermission -> existingPermission.getNode().equals(permission.getNode()));
        permissions.add(permission);
    }

    public void removePermission(PermissionState permission) {
        permissions.remove(permission);
    }

    public TriState hasPermission(PermissionNode node) {
        for (PermissionState permission : permissions) {
            if (permission.getNode().equals(node)) {
                return permission.getState();
            }
        }
        // Check for wildcard permissions
        PermissionNode currentNode = node;
        while (currentNode != null) {
            for (PermissionState permission : permissions) {
                if (permission.getNode().equals(currentNode)) {
                    return permission.getState();
                }
            }
            currentNode = getWildcardParent(currentNode);
        }
        return TriState.UNDEFINED;
    }

    private PermissionNode getWildcardParent(PermissionNode node) {
        List<PermissionNode> children = node.getChildren();
        for (PermissionNode child : children) {
            if (child.getName().equals("*")) {
                return child;
            }
        }
        return null;
    }
}
