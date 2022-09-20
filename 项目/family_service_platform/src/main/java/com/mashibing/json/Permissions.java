package com.mashibing.json;

import java.util.List;

/**
 * @Auther:yhj
 * @Date:2022/8/10 - 08 - 10 - 22:45
 * @Description: com.mashibing.json
 * @version: 1.0
 */
public class Permissions {
    private List<Permission> permissions;

    public Permissions() {
    }


    public Permissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissions=" + permissions +
                '}';
    }
}
