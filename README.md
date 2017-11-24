Application formatter to format Java source code that is specified in the input file.
Correctly puts newlines, braces, indentation in blocks.

mvn package
going to the package target, it is created .jar

java-jar formatter-1.0-SNAPSHOP.jar \input.java output.java
run jar arguments input.java output.java in the main method


Приложение formatter форматирует исходный код на Java, который задан во входном файле.
Правильно расставляет переводы строк, фигурные скобки, отступы в блоках.

mvn package
собирается пакет target, в нем создается .jar

java -jar formatter-1.0-SNAPSHOP.jar \input.java output.java
запускается jar, передаются аргументы input.java output.java в метод main
