package nz.co.demo.controller;

import org.junit.Before;

public class DemoControllerTest {

    private DemoController controller;

    @Before
    public void setUp() {
        controller = new DemoController("");
    }
//
//    @Test
//    public void shouldCreateUser() {
//
//        String firstName = "firstName";
//        String lastName = "lastName";
//
//        // Given
//        UserFactory userFactory = new UserFactory() {
//            @Override
//            public User create(String firstName, String lastName) {
//                User user = new User();
//                user.setFirstName(firstName);
//                user.setLastName(lastName);
//                return user;
//            }
//        };
//
//        // When
//        User actual = new DemoController(userFactory).createUser(firstName, lastName);
//
//        // Then
//        assertThat(actual.getFirstName(), is(firstName));
//        assertThat(actual.getLastName(), is(lastName));
//    }
//
//    @Test
//    public void shouldCreateUserWithMock() {
//
//        String firstName = "firstName";
//        String lastName = "lastName";
//        UserFactory userFactory = mock(UserFactory.class);
//        User expected = mock(User.class);
//
//        // Given
//        given(userFactory.create(firstName, lastName)).willReturn(expected);
//
//        // When
//        User actual = new DemoController(userFactory).createUser(firstName, lastName);
//
//        // Then
//        assertThat(actual, is(expected));
//    }

}