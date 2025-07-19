# Order API Integration Testing

## Full Context Test

- Uses @SpringBootTest with web environment and H2 in-memory database
- PaymentGatewayClient is mocked, all other beans are real.
- TestRestTemplate executes real HTTP requests to /orders.

## Sliced Test

- Uses @DataJdbcTest for repository-only testing (not shown in code above).
- Context startup is much faster with @DataJdbcTest compared to @SpringBootTest.

## Startup Time Reflection

- Full context with @SpringBootTest: [your measured time] ms
- Sliced context with @DataJdbcTest: [your measured time] ms

The difference demonstrates how slicing narrows context and speeds up test feedback.
