package com.crm.Crm.config;

import com.crm.Crm.entity.Role;
import com.crm.Crm.entity.User;
import com.crm.Crm.repository.RoleRepository;
import com.crm.Crm.repository.UserRepository;
import com.crm.Crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Component
public class InitUser implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }
        if(!existAdmin()){
            createAdminUser();
        }

    }

    public boolean existAdmin(){
        return roleRepository.findByName("ADMIN")==null?false:true;
    }

    public void createAdminUser(){
        userService.saveRole(new Role(null, "ADMIN"));;
        userService.saveUser(new User(null, "admin", "admin", "admin", new ArrayList<>()));
        userService.addRoleToUser("admin", "ADMIN");
    }




}
