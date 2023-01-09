package com.crm.Crm.config;

import com.crm.Crm.entity.Authority;
import com.crm.Crm.entity.Role;
import com.crm.Crm.entity.User;
import com.crm.Crm.exception.AuthorityAlreadyExists;
import com.crm.Crm.exception.RoleAlreadyExistsException;
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

    private static boolean alreadySetup = false;

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
            try {
                createAdminUser();
                alreadySetup=true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean existAdmin(){
        return roleRepository.findByName("ADMIN")==null?false:true;
    }

public void createAdminUser() throws Exception {
        userService.saveRole(new Role( "ADMIN"));
        userService.saveAuthority(new Authority("ADMIN"));
        userService.saveUser(new User(null, "admin", "admin", "admin", new ArrayList<>()));
        userService.addAuthorityToRole("ADMIN","ADMIN");
        userService.addRoleToUser("admin", "ADMIN");
    }




}
