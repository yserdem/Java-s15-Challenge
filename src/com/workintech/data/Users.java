package com.workintech.data;

import com.workintech.person.Membership;
import com.workintech.person.User;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Users {
    private Map<Long, User> userMapById;
    private Map<Membership, List<User>> userMapByMembership;

    public void userMapGenerator() {
        userMapById = new HashMap<>();
        userMapByMembership = new HashMap<>();
    }
}
