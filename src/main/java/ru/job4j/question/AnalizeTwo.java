package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnalizeTwo {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> map = new HashMap<>();
        Info info = new Info(0, 0, 0);
        for (User userCurr : current) {
            map.put(userCurr.getId(), userCurr);
        }
        for (User userPrev : previous) {
            User user = map.remove(userPrev.getId());
            if (user != null) {
                if (!user.getName().equals(userPrev.getName())) {
                    info.setChanged(info.getChanged() + 1);
                }
            } else {
                info.setDeleted(info.getDeleted() + 1);
            }
        }
        info.setAdded(map.size());
        return info;
    }
}
