clear
javac -d ./bin ./src/graph/*.java
javadoc -sourcepath ./src -d ./doc graph
jar -cvfm Graph.jar Manifest.txt bin src doc