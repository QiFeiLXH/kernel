package com.bsoft.person.manager;

public interface JobPostManager {
    Boolean isLeader(String personId);

    Boolean isFirstManager(String personId);

    Boolean isSecondManager(String personId);

    Boolean isHr(String personId);

    Boolean isRankManager(String personId);
}
