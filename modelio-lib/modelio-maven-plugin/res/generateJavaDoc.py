#
# Generate JavaDoc
#	This macro runs a JavaDoc generation on the project
#
#
# Author:	Modeliosoft
#
# Applicable on: project
#
# Version history:
# 1.1  27th June 2013 - Update for Modelio3
# 1.0	 25th April 2012	 - creation
#
#

# Get the Java module peer mdac
javaMdac = None
for module in Modelio.getInstance().getModuleService().getAllPeerModules():
	if (module.getName() == "JavaDesigner"):
		javaMdac = module
		break

if javaMdac is None :
	print "No Java Designer module found in the project"
else:
	print "JavaDoc generation with " + javaMdac.getName() + " " +	javaMdac.getVersion().toString()
	
	t = modelingSession.createTransaction("Generate JavaDoc")

	# save current value for "AutomaticallyOpenJavadoc" parameter
	savedAutoOpen = javaMdac.getConfiguration().getParameterValue("AutomaticallyOpenJavadoc")
	javaMdac.getConfiguration().setParameterValue("AutomaticallyOpenJavadoc", "false")
	  
	# generate the root package
	for root in modelingSession.getModel().getModelRoots():
		if isinstance(root, Project):
			for root in root.getModel():
				javaMdac.generateJavaDoc(root, False)
	
	# restore "AutomaticallyOpenJavadoc" parameter value
	javaMdac.getConfiguration().setParameterValue("AutomaticallyOpenJavadoc", savedAutoOpen)
	
	t.commit()
	
	# save the model
	coreSession.save(None)
