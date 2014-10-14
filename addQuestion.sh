#!/bin/sh

echo "Please enter the name of the new question: "

read question

echo "Generating templates for $question..."

cp templates/Template.java src/main/java/com/jiaz/leetj/${question}.java
cp templates/TemplateTest.java src/test/java/com/jiaz/leetj/${question}Test.java

pushd src/main/java/com/jiaz/leetj/
sed -i.bak "s/<QUESTION>/$question/g" ${question}.java
rm ${question}.java.bak
popd

pushd src/test/java/com/jiaz/leetj/
sed -i.bak "s/<QUESTION>/$question/g" ${question}Test.java
rm ${question}Test.java.bak
popd

