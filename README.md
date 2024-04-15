This file can be used as a template for initializing and running spring projects.

What's included: 
1. Gradle file created from start.spring.io
2. Other dependencies like Mongo.
3. Spring Tests
4. CRUD operation on data

Usage - 

1. To build the repository - 

From the repository root, 

1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.

## Need to be added:
Since this application uses cloud Atlas mongodb and have removed mongo-config.properties file, if you want to use mongodb cloud you can add the file in main/resources
FileName should be exact same as I have provided this filename to Application.java as property file, if you wish to change it change in Application.java too
#### mongo-config.properties
- mongodb.username=username
- mongodb.password=password

## PostMan Collection
- [PostManCollection.json](https://github.com/kunaljs-sudo/LeaderBoard/blob/main/psotmanCollection.json)
