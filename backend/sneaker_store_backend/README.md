# Sneaker Store Backend

Spring Boot service powering the EECS4413 sneaker store project.

## Prerequisites

- JDK 21+
- Gradle wrapper (included)

## Running with the default in-memory H2 database

The default `application.properties` now points to an H2 in-memory instance so you can spin up the API without installing MySQL:

```bash
cd backend/sneaker_store_backend
./gradlew bootRun
```

On startup the `SneakerStoreBackendApplication` seeds:

- 4 sneakers for the catalog endpoints
- 4 products so checkout/order flows can resolve SKUs
- 1 demo customer (`demo@sneakerstore.test` / `password`)

You can inspect the database at `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:sneaker_store`).

## Switching back to MySQL later

When you are ready to test against a local MySQL instance, enable the profile:

```bash
SPRING_PROFILES_ACTIVE=mysql ./gradlew bootRun
```

The profile pulls credentials from `src/main/resources/application-mysql.properties` (currently `root/EECS4413`).

## Exercising the API with Postman

After `bootRun` completes, hit the endpoints at `http://localhost:8080`.

- `GET /api/sneakers` – list seeded sneakers
- `GET /api/sneakers/filter?brand=Nike`
- `POST /api/auth/register` – create another customer
- `POST /api/auth/login` – log in as `demo@sneakerstore.test`
- `POST /api/checkout` – create orders using the seeded products/SKUs
- `GET /api/orders` – list orders (seeded checkout creates entries)

Feel free to import these endpoints into Postman; no extra headers or tokens are required yet.
