#!/bin/bash
for argument in "$@"
do
case $argument in
	pdf2txt)
		../../jdk/bin/java -jar pdfbox-app-2.0.4.jar PDFtoTxt -landscape input.pdf output.txt
	;;
	becomeinitialcommit)
		rm -rf .git
		git init
		git add --all
		git commit -m "become initial commit"
		git remote add origin https://github.com/albraga/namus_pdf2txt.git
		git push -u --force origin master
	;;
	makemavenproject)
		D:/apache-maven-3.3.9/bin/mvn archetype:generate -DgroupId=io.github.albraga -DartifactId=project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
	;;
esac
done
