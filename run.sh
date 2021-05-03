#! /bin/bash 
if [[ -f "./bin/MatrixAnimation.class" ]]; then
	java -cp bin/ MatrixAnimation $1 $2
else
	echo "Build it 1st."	
fi
