clear
#javac -d ./bin ./src/graph/*.java
#javadoc -sourcepath ./src -d ./doc graph
#jar -cvfm Graph.jar Manifest.txt bin src/graph doc

javac -d ./bin -cp ./bin ./src/graphImplementation/*.java
jar -cvfm GraphImpl.jar Manifest.txt bin src/graphImplementation