`Noroff Assignment #06`

# Movie Characters API

A dockerized PostgreSQL database solution using Spring Boot with Hibernate and
Maven. The database stores information about movies, characters and franchises.

Mapstruct is utilized for mapping conversions among entities and models to the
built in Spring converter.

---

## Structure

##### `/postman`
- ##### `/moviecorp`
  Postman files with handy requests for testing

##### `src/../datastore`

- ##### `/Controller`
  REST controllers tasked with receving requests, processing them utilizing services and
  returning appropriate responses
- ##### `/Entity`
  Database entities decorated with persistence annotations
- ##### `/Enum`
  Enums
- ##### `/Exception`
  Exception handlers
- ##### `/Mapper`
  Mapstruct mappers
- ##### `/Model`
  DTO models
- ##### `/Repository`
  Repositories extending JpaRepository
- ##### `/Service`
  Services for processing and persisting data.
- ##### `/config/CustomNaming.java`
  Configures Hibernate automatic snakeCase conversion for the JDBC Environment.
- ##### `/config/MapperSpringConfig.java`
  Mapstruct Spring config file
- ##### `/config/ProdDatabaseConfig.java`
  Prod profile configuration for Spring env variables.
