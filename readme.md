# WebApps using Java Spark

http://sparkjava.com/
http://sparkjava.com/documentation

## Setup

* Create a maven project in IntelliJ called `HelloApp`.
* Add `Java Spark`, `Handlebars` & logging for `Java Spark` by adding the entries below to your `pom.xml` file

```xml
<dependencies>
        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-core</artifactId>
            <version>2.8.0</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.21</version>
        </dependency>
        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-template-handlebars</artifactId>
            <version>2.7.1</version>
        </dependency>
    </dependencies>
```

Create a new java class called `App` in a package called `hello`. Add a main method to the `App` class.

Add this code to the main method:


