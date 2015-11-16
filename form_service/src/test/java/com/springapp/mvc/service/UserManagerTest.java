package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.repository.IUserRepository;

import com.springapp.mvc.service.impl.UserManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.springapp.mvc.util_test.UserUtilTest.getCustomUser;
import static com.springapp.mvc.util_test.UserUtilTest.getUserList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserManagerTest {


    @InjectMocks
//@Autowired
    private IUserManager manager = new UserManager();

    @Mock
    private IUserRepository repository;


    private User user;

    @Before
    public void init() {
        user = getCustomUser();
        initMocks(this);
    }


    @Test
    public void testAddUser() throws Exception {
        manager.addUser(getCustomUser());
    }

    @Test
    public void testRemoveUser() throws Exception {
        manager.removeUser(user);
    }

    @Test
    public void testFindUserByEmail() throws Exception {
        User user = getCustomUser();
        when(repository.findUserByEmail(user)).thenReturn(user);

        User currentUser = manager.findUserByEmail(user);
        assertNotNull(currentUser);
        verify(repository).findUserByEmail(user);

    }

    @Test
    public void testGetAllUser() throws Exception {
        when(repository.getAllUser()).thenReturn(getUserList());
        assertNotNull(manager.getAllUser());
    }

    @Test
    public void testEditUser() throws Exception {
        try {
            manager.editUser(getCustomUser());
        } catch (Exception e) {
            throw new RuntimeException("cant edit user");
        }
    }

    @Test
    public void testIsExistingUser() throws Exception {
        when(manager.isExistingUser(user)).thenReturn(true);
        assertEquals(true, manager.isExistingUser(user));
    }
}