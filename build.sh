#!/bin/bash

if [[ ( -d "./src" ) && -e "/usr/bin/javac" ]]; then
	if [[ -d "./bin" ]]; then
		javac ./src/MatrixAnimation.java -d ./bin
		echo "Done!."
	else
		mkdir "./bin"
		echo "Making bin directory."
		javac ./src/MatrixAnimation.java -d ./bin
		echo "Done!."
	fi
else
	echo "No src folder."
fi
