Releasing to central
--------------------

*Only really useful to Pavlov Media employees with permissions*

* Do a build first to ensure it will work
```bash
mvn clean package javadoc:jar source:jar
```

* Run again with a deploy
```bash
mvn clean package javadoc:jar source:jar deploy
```
 * Run a Maven Central sync from bintray
 * Profit!