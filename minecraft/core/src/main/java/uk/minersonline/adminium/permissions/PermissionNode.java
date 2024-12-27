package uk.minersonline.adminium.permissions;

import java.util.ArrayList;
import java.util.List;

public class PermissionNode {
    private final String name;
    private final List<PermissionNode> children = new ArrayList<>();

    public PermissionNode(String name) {
        if (!name.matches("[a-zA-Z0-9_-]+")) {
            throw new IllegalArgumentException("Node name can only contain alphanumeric characters, underscores, and hyphens.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<PermissionNode> getChildren() {
        return children;
    }

    public void addChild(PermissionNode child) {
        children.add(child);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PermissionNode that = (PermissionNode) obj;
        return name.equals(that.name) && children.equals(that.children);
    }
}
