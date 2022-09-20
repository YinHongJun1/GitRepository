package com.mashibing.json;

/**
 * @Auther:yhj
 * @Date:2022/8/10 - 08 - 10 - 22:45
 * @Description: com.mashibing.json
 * @version: 1.0
 */
public class Permission {
    private String permissionId;

    public Permission() {
    }

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                '}';
    }
}
