package com.mashibing.json;

/**
 * @Auther:yhj
 * @Date:2022/8/10 - 08 - 10 - 22:45
 * @Description: com.mashibing.json
 * @version: 1.0
 */
public class UserInfo {
    private String name;
    private String avatar = "/avatar2.jpg"; //登录以后，显示在页面上的用户信息图片，默认值
    private Permissions role;

    public UserInfo() { }

    public UserInfo(String name, Permissions role) { this.name = name; this.role = role; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public Permissions getRole() { return role; }

    public void setRole(Permissions role) { this.role = role; }

    @Override
    public String toString() { return "UserInfo{" + "name='" + name + '\'' + ", avatar='" + avatar + '\'' + ", role=" + role + '}'; }
}
