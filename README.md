### Unit Tests - Argument Captor
Simple example using the resource of Mockito Argument Captor

#### How can we use this resource?
We can use this Argument Captor when we need to know and validate the object that is used in some method. It is very useful when we know the scenario and the result, but the algorithm is complex. 

Initialization the captured object:
```
    ArgumentCaptor<Bill> billcaptured = ArgumentCaptor.forClass(Bill.class);
```
The moment that is captured the argument in our example:
```
    Mockito.verify(billEmailService).sendBillByEmail(billcaptured.capture());
```

#### What is necessary for to use this resource?
In this example, its used junit-4.10.jar and mockito-all-1.10.19. 
