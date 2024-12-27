package uk.minersonline.adminium.permissions;

import uk.minersonline.adminium.utils.TriState;

public class PermissionState {
    private final TriState state;
    private final PermissionNode node;

    public PermissionState(TriState state, PermissionNode node) {
        this.state = state;
        this.node = node;
    }

    public TriState getState() {
        return state;
    }

    public PermissionNode getNode() {
        return node;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PermissionState that = (PermissionState) obj;
        return state == that.state && node.equals(that.node);
    }
}
