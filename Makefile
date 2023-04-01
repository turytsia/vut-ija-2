run:
	# rm ./ija/ija2022/homework2/**/*.class
	# rm ./ija/ija2022/homework2/*.class
	javac -cp .:ijatool.jar:junit-platform-console-standalone-1.6.0.jar -d build ija/ija2022/homework2/Homework2Test.java
	java -cp ./build:ijatool.jar:junit-platform-console-standalone-1.6.0.jar org.junit.runner.JUnitCore ija.ija2022.homework2.Homework2Test

clear:
	rm ./ija/ija2022/homework2/**/*.class
	rm ./ija/ija2022/homework2/*.class