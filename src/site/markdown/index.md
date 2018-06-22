# java-aci-annotations-processor

Provides a processor factory for use with the Micro Focus IDOL [java-aci-api-ng](http://microfocus-idol.github.io/java-aci-api-ng), which 
creates processors which convert an ACI response to an instance of a Java class as configured by annotations on that class.
This abstracts away processing of ACI XML and encourages type safety in consuming code.

## Usage
java-aci-annotations-processor is available from the central Maven repository.

    <dependency>
        <groupId>com.hp.autonomy.aci.client</groupId>
        <artifactId>aci-annotations-processor</artifactId>
        <version>1.0.0</version>
    </dependency>

The IdolAnnotationsProcessorFactory creates instances of the ACI API's Processor class for given Java class representations
of ACI responses. The mapping from response XML to the Java Object is configured by annotations on the class. For example,
the following Document class can be used to read the response from the content component's Query action. 

    @IdolDocument("autn:hit")
    public class Document {
        private String reference;
    
        @IdolField("autn:reference")
        public void setReference(final String reference) {
            this.reference = reference;
        }
    }

The processor factory can be used to create a list processor for this class:

    IdolAnnotationsProcessorFactory processorFactory = new IdolAnnotationsProcessorFactoryImpl();
    Processor<List<Document>> processor = processorFactory.listProcessorForClass(Document.class);

Then an AciService from the ACI API can be used to execute the query action and convert the response to a List of our
Document type:

    AciParameters parameters = new AciParameters("Query");
    parameters.add("text", "*");
    List<Document> documents = aciService.executeAction(parameters, processor);

## Contributing
We welcome pull requests. These must be licensed under the MIT license. Please submit pull requests to the develop
branch - the master branch is for stable code only.

## Is it any good?
Yes.

## License
Copyright 2015 Hewlett-Packard Development Company, L.P.

Licensed under the MIT License (the "License"); you may not use this project except in compliance with the License.
