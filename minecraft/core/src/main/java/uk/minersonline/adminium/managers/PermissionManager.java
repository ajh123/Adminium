package uk.minersonline.adminium.managers;

import java.util.ArrayList;
import java.util.List;

import uk.minersonline.adminium.permissions.PermissionGroup;
import uk.minersonline.adminium.permissions.PermissionNode;

public class PermissionManager {
    private final List<PermissionGroup> groups = new ArrayList<>();
    private final List<PermissionNode> nodes = new ArrayList<>();

    public List<PermissionGroup> getGroups() {
        return groups;
    }

    public List<PermissionNode> getNodes() {
        return nodes;
    }

    public void addGroup(PermissionGroup group) {
        groups.add(group);
    }

    public void removeGroup(PermissionGroup group) {
        groups.remove(group);
    }

    public void addNode(PermissionNode node) {
        nodes.add(node);
    }

    public void removeNode(PermissionNode node) {
        nodes.remove(node);
    }

    public PermissionGroup getGroup(String name) {
        for (PermissionGroup group : groups) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    public PermissionNode getNode(String name) {
        for (PermissionNode node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    public static PermissionNode fromString(String nodeString) {
        String[] parts = nodeString.split("\\.");
        PermissionNode root = new PermissionNode(parts[0]);
        PermissionNode current = root;
        for (int i = 1; i < parts.length; i++) {
            PermissionNode child = new PermissionNode(parts[i]);
            current.addChild(child);
            current = child;
        }
        return root;
    }

    public static String toString(PermissionNode node) {
        StringBuilder builder = new StringBuilder(node.getName());
        for (PermissionNode child : node.getChildren()) {
            builder.append(".").append(toString(child));
        }
        return builder.toString();
    }

    public static boolean isChildOf(PermissionNode parent, PermissionNode child) {
        if (parent.equals(child)) {
            return true;
        }
        for (PermissionNode node : parent.getChildren()) {
            if (isChildOf(node, child)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isParentOf(PermissionNode child, PermissionNode parent) {
        return isChildOf(parent, child);
    }

    
}
