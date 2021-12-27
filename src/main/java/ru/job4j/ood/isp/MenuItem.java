package ru.job4j.ood.isp;

import java.util.List;

public class MenuItem {
    private boolean opened;
    private String name;
    private MenuAction menuAction;
    private List<MenuItem> children;

    public MenuItem(String name, MenuAction menuAction, List<MenuItem> children) {
        this.name = name;
        this.menuAction = menuAction;
        this.children = children;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuAction getActionMenu() {
        return menuAction;
    }

    public void setActionMenu(MenuAction menuAction) {
        this.menuAction = menuAction;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(MenuItem child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "MenuItem{"
                + "name='" + name + '\''
                + ", actionMenu=" + menuAction
                + ", children=" + children
                + '}';
    }
}
