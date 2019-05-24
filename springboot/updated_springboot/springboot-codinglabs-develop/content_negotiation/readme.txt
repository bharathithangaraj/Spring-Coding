
Content Negotiation: It is a Concept where we can control output format (XML/JSON) of the API.
      
      
Spring starter project comes with the jar file(jackson-databind-2.9.7.jar)  which is responsible for converting the objects into JSON Format.

But for XML we have Configure the project explicitly by adding the jar(jackson-dataformat-xml-2.9.7.jar).


To restrict the output of the API we should use a attribute "produces" in the the "@RequestMapping" annotation.

Examples:
         1. @RequestMapping(value="/url", produces=mediaType.ALL)                       // Produces both Formats either JSON or XML
         2. @RequestMapping(value="/url", produces=mediaType.APPLICATION_JSON_VALUE)    // Produces only JSON as output
         3. @RequestMapping(value="/url", produces=mediaType.APPLICATION_XML_VALUE)     // Produces only XML as output
         
         
         
When a consumer sends a request, it can specify two HTTP Headers related to Content Negotiation

1.Accept       : Indicates the expected content type of the response.
2.Content-Type : Indicates the content type of the body of the request.


Example of Content Negotiation

There is a screenshot in the project which shows how you can specify these headers in a request using Postman.  