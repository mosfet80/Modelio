To extract all dependencies jar, use the following maven command:

mvn -U clean dependency:copy-dependencies -DincludeGroupIds=org.modelio,com.modeliosoft,com.modelio

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
To deploy the MDA Kit pom, user  the following maven command:

mvn -gs=${TKPATH}/itools/tools/but/maven_conf/settings_integ.xml -DaltDeploymentRepository=modelio::default::http://minotaure:8081/nexus/content/repositories/dev clean deploy
