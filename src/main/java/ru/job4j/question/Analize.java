package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        int added = 0;
        int deleted = 0;
        int changed = 0;

        for (User userCurr : current) {
            if (!previous.contains(userCurr)) {
                boolean add = true;
                for (User userPrev : previous) {
                    if (userCurr.getId() == userPrev.getId()) {
                        changed += 1;
                        info.setChanged(changed);
                        add = false;
                        break;
                    }
                }
                if (add) {
                    added += 1;
                    info.setAdded(added);
                }
            }
        }
           for (User userPrev : previous) {
              if (current.stream()
                       .map(User::getId)
                       .noneMatch((s) -> s == userPrev.getId())) {
                  deleted += 1;
                 info.setDeleted(deleted);
              }

           }
        return info;
    }
}