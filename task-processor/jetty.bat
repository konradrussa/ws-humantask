title SERVER
set MAVEN_OPTS=-Xms512M -Xmx512M -XX:PermSize=192m -XX:MaxPermSize=384m -Djava.awt.headless=true -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled -XX:+UseConcMarkSweepGC -Xdebug -Xrunjdwp:transport=dt_socket,address=8001,server=y,suspend=n
call mvn -DskipTests -Djetty.port=8080 jetty:run
