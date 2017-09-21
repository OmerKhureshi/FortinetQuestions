# Question 5: When the project is using Spring 4.3  and Hibernate 5.2, how to write the JUnit test without bounded with concrete DB closely. In other words, How to mock DB in JUnit test for service method.  If not possible give the reason else list cases for the different scenario.

There are several approaches that I am aware of,

1. Use an embedded/in-memory database like H2 or derby as the mock database. However this scenario now becomes an instance of integration testing rather than unit testing. Care should be taken that the type of in-memory DB is of the same type of DB as used in production. 



2. If JPA/ORM is used, these can mocked/stubbed along with any other dependencies. This is more in tune with unit testing.
		
	Example: Suppose we have an entity called Person and PersonDAO interface. We are required to test a PersonService class which is defined below,

```
class PersonService {
   public boolean authorizePerson(Person person) {
       if(personDAO.validatePerson(person)){
           authorize(person);
           return true;
       }

       return false;
   }
}
```


	Below  is the test for the PersonService class.

```
public class MockPersonServiceTest {

   private PersonDao personDao;
   private Person person;
   private PersonService personService;

   @Before
   public void setupMock() {
       person = mock(Person.class);
       personDao = mock(PersonDao.class);
       personService = new PersonService();
   }


   @Test
   public void testAuthorizeperson() {
       when(personDao.validatePerson(person)).thenReturn(true);
      
       // Check that PersonService:validatePerson method returns true for mocked person.
       assertEquals(true, personService.validatePerson(person));

       // Verify that PersonDao:validatePerson method was invoked at least once.
       verify(personDao, atLeastOnce()).validatePerson(product);

   }
}
```

