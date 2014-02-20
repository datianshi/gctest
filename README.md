gctest
======
Same Test without GC tuning the CMS survived
java -Xms256m -Xmx256m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -cp .:target/server-1.0-SNAPSHOT.jar:/Users/dings/.m2/repository/commons-lang/commons-lang/2.4/commons-lang-2.4.jar org.sample.shaozhen.Server 100

java -Xmx256m -XX:+UseParallelGC -cp .:target/server-1.0-SNAPSHOT.jar:/Users/dings/.m2/repository/commons-lang/commons-lang/2.4/commons-lang-2.4.jar org.sample.shaozhen.Server 100


Load

java -cp .:target/client-1.0-SNAPSHOT.jar org.sample.shaozhen.Client 30


