#
# Generate Java	Sources 1.1
#	This macro runs a Java code generation on the project
#
#
# Author:	Modeliosoft
#
# Applicable on: project
#
# Version history:
# 1.1  18th Janurary 2013 - Update for Modelio3
# 1.0	 25th April 2012	  - creation
#

from org.modelio.api.modelio import Modelio
from org.modelio.metamodel.mda import Project

# Get the Java module peer mdac
javaMdac = None
for module in Modelio.getInstance().getModuleService().getAllPeerModules():
	if (module.getName() == "JavaDesigner"):
		javaMdac = module
		break

if javaMdac is None :
	print "No Java Designer module found in the project"
else:
	print "Java source generation with " + javaMdac.getName() + " " +	javaMdac.getVersion().toString()
	
	t = modelingSession.createTransaction("Generate sources")
	
	# save current value for "default retrieve mode" parameter
	savedRetrieveMode = javaMdac.getConfiguration().getParameterValue("RetrieveDefaultBehaviour")
	javaMdac.getConfiguration().setParameterValue("RetrieveDefaultBehaviour", "Keep")
	
	# generate the root package
	for root in modelingSession.getModel().getModelRoots():
		if isinstance(root, Project):
			for root in root.getModel():
				javaMdac.generate(root, False)
	
	# restore "default retrieve mode" parameter value
	javaMdac.getConfiguration().setParameterValue("RetrieveDefaultBehaviour", savedRetrieveMode)
	
	t.commit()
	
	# save the model
	coreSession.save(None)
