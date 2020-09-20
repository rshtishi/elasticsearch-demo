# elasticsearch-demo

A practical guide for accessing the Elasticsearch datastore.

## Topics

Elasticsearch is a highly scalable open-source which can be used for datastore, text search, and analytics engine. The storage structure of Elasticsearch is like below:

- Index (the main data container, would be equivalent to the database in SQL)
- Mappings (define the organization of data in the index, would be the equivalent to a table in SQL)

In this demo, we will see how we can use spring-data-elasticsearch.

### Accessing Elasticsearch with spring-data-elasticsearch

We add the following dependency:

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-elasticsearch</artifactId>
		</dependency>
```

After that create the domain entity by adding the @Document annotation to the pojo as below:

```
@Document(indexName = "resource")
public class Person {
	@Id
	private String id;
	private String fullName;
	private int age;
  ...
}
```

And create the repository that extends the CrudRepository for generating the implementation of basics methods for accessing elasticsearch:

```
@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
	
	List<Person> findAll();

}
```
