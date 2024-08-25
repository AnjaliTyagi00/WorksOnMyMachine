package Test;

import com.hsbc.Dao.AdminDao;
import com.hsbc.Dao.AdminDaoImpl;
import com.hsbc.exceptions.*;
import com.hsbc.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdminDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(AdminDaoTest.class);

    @Mock
    private AdminDao adminDao;

    @InjectMocks
    private AdminDaoImpl adminDaoImpl;

    @BeforeEach
    void setUp() {
        logger.info("Initializing mocks");
        MockitoAnnotations.openMocks(this);
        logger.info("Mocks initialized");
    }

    @Test
    void testCreateUser() throws UserAlreadyExistsException {
        logger.info("Starting testCreateUser");
        User user = new User();
        when(adminDao.createUser(user)).thenReturn(true);

        boolean result = adminDao.createUser(user);
        logger.info("User creation result: {}", result);
        assertTrue(result);
        verify(adminDao).createUser(user);
        logger.info("testCreateUser passed");
    }

    @Test
    void testGetUserById() throws UserNotFoundException, UserAlreadyExistsException {
        logger.info("Starting testGetUserById");
        User user = new User();
        when(adminDao.createUser(user)).thenReturn(true);
        when(adminDao.getUserById(user.getUserId())).thenReturn(user);

        adminDao.createUser(user); // Ensure user is created before fetching
        User fetchedUser = adminDao.getUserById(user.getUserId());
        logger.info("Fetched user: {}", fetchedUser);
        assertEquals(user, fetchedUser);
        verify(adminDao).getUserById(user.getUserId());
        logger.info("testGetUserById passed");
    }

    @Test
    void testUpdateUser() throws UserNotFoundException, UserAlreadyExistsException {
        logger.info("Starting testUpdateUser");
        User user = new User();
        when(adminDao.createUser(user)).thenReturn(true);
        when(adminDao.updateUser(user)).thenReturn(true);
        when(adminDao.getUserById(user.getUserId())).thenReturn(user);

        adminDao.createUser(user);
        user.setName("Updated Name");
        boolean result = adminDao.updateUser(user);
        logger.info("User update result: {}", result);
        User updatedUser = adminDao.getUserById(user.getUserId());
        assertEquals("Updated Name", updatedUser.getName());
        verify(adminDao).updateUser(user);
        logger.info("testUpdateUser passed");
    }

    @Test
    void testDeleteUser() throws UserNotFoundException, UserAlreadyExistsException {
        logger.info("Starting testDeleteUser");
        User user = new User();
        when(adminDao.createUser(user)).thenReturn(true);
        when(adminDao.deleteUser(user.getUserId())).thenReturn(true);
        when(adminDao.getUserById(user.getUserId())).thenThrow(UserNotFoundException.class);

        adminDao.createUser(user);
        boolean result = adminDao.deleteUser(user.getUserId());
        logger.info("User deletion result: {}", result);
        assertTrue(result);
        assertThrows(UserNotFoundException.class, () -> adminDao.getUserById(user.getUserId()));
        verify(adminDao).deleteUser(user.getUserId());
        logger.info("testDeleteUser passed");
    }

    @Test
    void testGetAllUsers() throws UserAlreadyExistsException {
        logger.info("Starting testGetAllUsers");
        User user1 = new User();
        User user2 = new User();
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        when(adminDao.createUser(user1)).thenReturn(true);
        when(adminDao.createUser(user2)).thenReturn(true);
        when(adminDao.getAllUsers()).thenReturn(users);

        adminDao.createUser(user1);
        adminDao.createUser(user2);
        List<User> fetchedUsers = adminDao.getAllUsers();
        logger.info("Users fetched: {}", fetchedUsers);
        assertTrue(fetchedUsers.contains(user1));
        assertTrue(fetchedUsers.contains(user2));
        verify(adminDao).getAllUsers();
        logger.info("testGetAllUsers passed");
    }

    @Test
    void testCreateAmenity() {
        logger.info("Starting testCreateAmenity");
        Amenity amenity = new Amenity(123, "testing2", 1999);
        when(adminDao.createAmenity(amenity)).thenReturn(true);

        boolean result = adminDao.createAmenity(amenity);
        logger.info("Amenity creation result: {}", result);
        assertTrue(result);
        verify(adminDao).createAmenity(amenity);
        logger.info("testCreateAmenity passed");
    }

    @Test
    void testGetAmenityById() {
        logger.info("Starting testGetAmenityById");
        Amenity amenity = new Amenity(321, "testing3", 1776);
        when(adminDao.createAmenity(amenity)).thenReturn(true);
        when(adminDao.getAmenityById(amenity.getAmenityId())).thenReturn(amenity);

        adminDao.createAmenity(amenity); // Ensure amenity is created before fetching
        Amenity fetchedAmenity = adminDao.getAmenityById(amenity.getAmenityId());
        logger.info("Fetched amenity: {}", fetchedAmenity);
        assertEquals(amenity, fetchedAmenity);
        verify(adminDao).getAmenityById(amenity.getAmenityId());
        logger.info("testGetAmenityById passed");
    }

    @Test
    void testUpdateAmenity() {
        logger.info("Starting testUpdateAmenity");
        Amenity amenity = new Amenity(123, "testing1", 1234);
        when(adminDao.createAmenity(amenity)).thenReturn(true);
        when(adminDao.updateAmenity(amenity)).thenReturn(true);
        when(adminDao.getAmenityById(amenity.getAmenityId())).thenReturn(amenity);

        adminDao.createAmenity(amenity);
        amenity.setAmenityName("Updated Amenity");
        boolean result = adminDao.updateAmenity(amenity);
        logger.info("Amenity update result: {}", result);
        Amenity updatedAmenity = adminDao.getAmenityById(amenity.getAmenityId());
        assertEquals("Updated Amenity", updatedAmenity.getAmenityName());
        verify(adminDao).updateAmenity(amenity);
        logger.info("testUpdateAmenity passed");
    }

    @Test
    void testDeleteAmenity() {
        logger.info("Starting testDeleteAmenity");
        Amenity amenity = new Amenity(123, "testing5", 124);
        when(adminDao.createAmenity(amenity)).thenReturn(true);
        when(adminDao.deleteAmenity(amenity.getAmenityId())).thenReturn(true);
        when(adminDao.getAmenityById(amenity.getAmenityId())).thenThrow(RuntimeException.class);

        adminDao.createAmenity(amenity);
        boolean result = adminDao.deleteAmenity(amenity.getAmenityId());
        logger.info("Amenity deletion result: {}", result);
        assertTrue(result);
        assertThrows(RuntimeException.class, () -> adminDao.getAmenityById(amenity.getAmenityId()));
        verify(adminDao).deleteAmenity(amenity.getAmenityId());
        logger.info("testDeleteAmenity passed");
    }

    @Test
    void testGetAllAmenities() {
        logger.info("Starting testGetAllAmenities");
        Amenity amenity1 = new Amenity(223, "testing5", 221);
        Amenity amenity2 = new Amenity(123, "testing6", 412);
        List<Amenity> amenities = new ArrayList<>();
        amenities.add(amenity1);
        amenities.add(amenity2);

        when(adminDao.createAmenity(amenity1)).thenReturn(true);
        when(adminDao.createAmenity(amenity2)).thenReturn(true);
        when(adminDao.getAllAmenities()).thenReturn(amenities);

        adminDao.createAmenity(amenity1);
        adminDao.createAmenity(amenity2);
    }}
