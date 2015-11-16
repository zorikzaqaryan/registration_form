package com.springapp.mvc.repository;


import com.springapp.mvc.repository.config.PersistenceConfigTest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {PersistenceConfigTest.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
})
//@TransactionConfiguration(transactionManager = "transactionManager")
//@Transactional

public class UserRepositoryTest {


    @Autowired
IUserRepository userRepository;

//
//    @InjectMocks
//    IUserRepository repository = new UserRepository();


//    @Before
//    public void init() {
//        initMocks(this);
//    }

    @Test
    public void testAddUser() throws Exception {
//        repository.addUser(getCustomUser());

    }

//    @Test
//    public void testRemoveUser() throws Exception {
//        List<User> userList= getUserList();
//        repository.removeUser(userList.get(3));
//        verify(repository).removeUser(userList.get(0));
//    }
//
//    @Test
//    public void testFindUserByEmail() throws Exception {
//        User user = getCustomUser();
//        User u = repository.findUserByEmail(user);
//        assertNotNull(u);
//    }
//
//    @Test
//    public void testGetAllUser() throws Exception {
//        List<User> users =repository.getAllUser();
//        assertNotNull(users);
//    }
//
//    @Test
//    public void testEditUser() throws Exception {
//        User user =getCustomUser();
//        repository.editUser(user);
//    }
//
//    @Test
//    public void testIsExistingUser() throws Exception {
//        repository.isExistingUser(getCustomUser());
//
//
//    }

}