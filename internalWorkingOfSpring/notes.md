# Internal Working of Spring

1. we avoid using direct objects for every class to avoid tight coupling.
    Ex:
    we won't do something like:
      - private RazorPayPaymentService paymentService = new RazorPayPaymentService();
2. To avoid this, we use "Beans". they let the prog. store beans of all classes, and use them when necessary.
   - "@Component" is used to make Spring framework know that we want to create the bean of a class.
   Ex: see RazorPayPaymentService.java
   - @Component is a kind of "Annotation" (discussed later).

3. we can also use "dependency" for the main class to avoid null pointer exceptions when the bean obj is undefined
"Dependency" means Obj1 must not run or be created without Obj2 as Obj1 is dependent on Obj2.
Thus, to implement this, we created a constructor of the main class in "InternalWorkingOfSpringApplication" with a parameter of "RazorPayPaymentService". This makes sure that the obj. of main class must not be created in the 1st place without the latter. This avoids any Null Exception activity.
// This is an example of "Constructor Dependency Injection".