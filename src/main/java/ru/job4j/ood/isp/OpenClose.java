package ru.job4j.ood.isp;

public class OpenClose implements MenuAction {
    @Override
    public void action(MenuItem menuItem) {
        menuItem.setOpened(!menuItem.isOpened());
        if (!menuItem.isOpened()) {
            closeChildren(menuItem);
        }
    }

    private  void closeChildren(MenuItem menuItem) {
        for (MenuItem child : menuItem.getChildren()) {
            child.setOpened(false);
            closeChildren(child);
        }
    }
}
