To extract all dependencies jar, use the following maven command:

 * Without merge
    mvn -U -gs=${MAVEN_HOME}/conf/settings_integ.xml  dependency:copy-dependencies  -DincludeGroupIds=org.modelio,com.modeliosoft.modelio,com.modelio,jdbm,net.sf.practicalxml
 
 * Merge all jars
    mvn -U  -gs=${MAVEN_HOME}/conf/settings_integ.xml shade:shade
 
 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
To deploy the ModelioLibrary pom, user  the following maven command:

  mvn -P module -U  -gs=${TKPATH}/itools/tools/but/maven_conf/settings_integ.xml -DaltDeploymentRepository=modelio::default::http://minotaure:8081/nexus/content/repositories/dev clean deploy

