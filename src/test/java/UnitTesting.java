/*
- Unit Testing (Sabse basic) - used to test a single class or method (without database, server, network)

JUnit → test likhne ke liye
Mockito → dependencies ko fake (mock) karne ke liye

Mockito kya karta hai - Fake object banata hai - Fake behavior (known as stub)

COMMON ASSERTIONS

Assertion	        Meaning
assertEquals(a,b)	value same
assertNotNull(x)	null nahi
assertTrue(cond)	true hona chahiye
assertThrows()	    exception aana chahiye


@Mock → dependency pe lagta hai
@InjectMocks → jis class ko test karna hai uspe lagta hai


BASIC STRUCTURE

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    Dependency1 dep1;

    @Mock
    Dependency2 dep2;

    @InjectMocks
    ClassUnderTest classUnderTest;


    @Test
    test function

}

Test function ka kaam code likhna nahi, balki 3 questions ka answer dena hota hai:
Given – initial situation kya hai?
When – main kaunsa method call kar raha hoon?
Then – result kya aana chahiye?

 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

//-----------------------------------MODEL
class Order {
    int id;
    String name;
    int amount;

    public Order(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}

//----------------------------------CUSTOM EXCEPTION
class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}

//----------------------------------REPOSITORY
interface OrderRepository {

    //method 1 - assuming only one object corresponding to one id
    Order findById(int id);

    //method 2
    Order save(Order order);
}

//-----------------------------------SERVICE
class OrderService {
    OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order findById(int id){
        //if (isPresent()) get() else throw

        Order list = repo.findById(id);
        if(list!=null) {
            return list;
        }
        else {
            throw new OrderNotFoundException("Order not found with ID - " + id);
        }
    }

    public Order save(Order order) {
        return repo.save(order);
    }
}

//----------------------------------UNIT TESTING

/*
Mockito ka Default Behaviour
Agar tum when() nahi likhti:

Method	    Default Return
Object	    null
Optional	Optional.empty()
int	        0

--- IMPORTANT
Jo method test kar rahi ho, uske andar jo dependency method call hoti hai, wahi when() me aayegi.
*/


@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    OrderRepository orderRepo;

    @InjectMocks
    OrderService service;

    @Test
    void shouldReturnOrderWhenOrderExists() {

        // Arrange
        Order order = new Order(1, "Laptop", 50000);

        //agar id 1 aaye to upar wala order return karna
        when(orderRepo.findById(1)).thenReturn(order);

        //ACT
        Order result = service.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        assertEquals(50000, result.getAmount());
    }

    /*
    ️assertThrows - Is code ko chalao, aur expect karo ki ye exception aaye”
    - expected exception aayi --> test pass
    - exception nahi aayi     -->test fail
    - koi aur exception aayi  --> test fail
     */

    @Test
    void shouldThrowExceptionWhenOrderNotFound(){
        //agar id 2 aaye to null return karna
        when(orderRepo.findById(2)).thenReturn(null);

        //ACT
        OrderNotFoundException exception = assertThrows(OrderNotFoundException.class, //Kaunsi exception chahiye
                ()-> {       //Kaunsa code exception throw karega
            service.findById(2);
                }
        );

        // Assert
        assertEquals("Order not found with ID - 2", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    void shouldCreateOrderSuccessfully() {

        Order order = new Order(1, "Phone", 30000);

        //Jab save bolo
        //to DB mat jao, bas same order wapas de do
        when(orderRepo.save(order))
                .thenReturn(order);

        Order savedOrder = service.save(order);

        assertNotNull(savedOrder);
        assertEquals("Phone", savedOrder.getName());
    }

}


public class UnitTesting {
}
