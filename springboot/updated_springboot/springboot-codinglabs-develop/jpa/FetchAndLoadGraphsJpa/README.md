Entity Graphs- fetchgraph and loadgraph:
* In JPA, entity graphs are "fetch plans" for query or find operations. A "fetch plan" specifies properties/fields (of an entity) that should be fetched either lazily or eagerly. 
One of the ways to define an entity graph is to use @NamedEntityGraph annotation on the entity.

* @NamedEntityGraph(name = "my-graph-name", attributeNodes = @NamedAttributeNode("myProperty"))
 public class MyEntity{ ... }

* Where @NamedAttributeNode annotation specifies the target entity's properties which should be fetched either lazily or eagerly.

* How to use an Entity Graph: After defining an entity graph, we can use it with the find method or as a query hint to override FetchType semantics.

* The standard properties "javax.persistence.fetchgraph" (simply referred as Fetch Graph) and "javax.persistence.loadgraph" (simply referred as Load Graph) are used to specify such graphs to queries and find operations. 

* Fetch Graph: When the javax.persistence.fetchgraph property is used, the attributes that are specified by attributeNodes are treated as FetchType.EAGER and the rest of the attributes are treated as FetchType.LAZY (regardless of whatever the default FetchType is, or specified by the developer via one of the JPA mapping annotations).

* Load Graph: When the javax.persistence.loadgraph property is used, the attributes that are specified by attributeNodes are treated as FetchType.EAGER and the rest of the attributes are treated according to their specified or default FetchType (Original specified/default FetchType.LAZY or FetchType.EAGER are not changed). 

* For Example: The default FetchType of @oneToMany annotation is LAZY, but we are explicitly specifying that on 'phones' field for clarity. 
1. We are going to define an entity graph for User entity targeting only 'phones' property.
2. Using Entity Graph with "javax.persistence.fetchgraph".
3. According to the javax.persistence.fetchgraph specification, only 'phones' field should be loaded eagerly because that's the only one which is specified with attributeNodes.

* The source code can be found on GitLab "jpa/FetchAndLoadGraphsJpa".
