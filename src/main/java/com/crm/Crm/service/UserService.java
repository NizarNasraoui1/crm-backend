package com.crm.Crm.service;

import com.crm.Crm.entity.Authority;
import com.crm.Crm.entity.Role;
import com.crm.Crm.entity.User;


import java.util.List;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    Authority saveAuthority(Authority authority);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    Role addAuthorityToRole(String roleName, String authority);
    List<User>getUsers();
}
