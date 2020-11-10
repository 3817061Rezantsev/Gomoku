# Gomoku
start rmiregistry -J-Djava.rmi.server.codebase=file:///Users/Сережа/git/Gomoku/common/target/common-0.0.1-SNAPSHOT.jar
java -cp "common/target/common-0.0.1-SNAPSHOT.jar;server/target/server-0.0.1-SNAPSHOT.jar" gomoku.server.Server
java -cp "common/target/common-0.0.1-SNAPSHOT.jar;client/target/client-0.0.1-SNAPSHOT.jar" gomoku.client.Client white
java -cp "common/target/common-0.0.1-SNAPSHOT.jar;client/target/client-0.0.1-SNAPSHOT.jar" gomoku.client.Client black