Spel Expressions - @Value:

* The SpEL stands for Spring Expression Language. It is a powerful expression language which supports querying and manipulating an object graph at the bean creation time or run time. It is similar to other expression languages like JSP EL, OGNL, MVEL and JBoss EL etc with some additional features like method invocation and basic string templating functionality. 

* Syntax: #{ expression }

* Some uses of Spring SpEL:
1. It can be used to inject a bean or a bean property in another bean.
2. It can be used to invoke a bean method in another bean.
3. It can be used to execute any standard mathematical, logical or relational operations.
4. It can be used to perform conditional checking with ternary operator.
5. It can be used to get the elements of a Map or a List.

* Note: Spring expressions are available with both XML and annotation type bean configuration metadata. For using annotation type bean configuration metadata we use @Component and @Value.

* for operator based spel expressions refer "https://www.baeldung.com/spring-expression-language".

* The source code can be found on GitLab "jpa/SpelExpressions".
