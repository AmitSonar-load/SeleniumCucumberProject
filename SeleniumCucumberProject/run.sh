#!/bin/bash
javadoc -docletpath target/SeleniumCucumberProject-0.0.1-SNAPSHOT-jar-with-dependencies.jar -doclet SeleniumCucumberProject.SeleniumCucumberProject.Doclet "$@"
