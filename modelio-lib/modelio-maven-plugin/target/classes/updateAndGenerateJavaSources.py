#
# Update and Generate Java	Sources 1.0
#	This macro runs:
# - an SVN update on the project
# - a Java code generation on the project
#
#
# Author:	Modeliosoft
#
# Applicable on: project
#
# Version history:
# 1.0	 25th April 2012	 - creation
#
#

from com.modeliosoft.modelio.cms.api import IUpdateCommand
from com.modeliosoft.modelio.cms.api import IUpdateDetails
from com.modeliosoft.modelio.cms.api import TransactionStillOpenException
from com.modeliosoft.modelio.cms.api import ICmsServices

from java.util import ArrayList
from java.util import HashSet

from org.modelio.api.modelio import Modelio
from org.modelio.metamodel.mda import Project
from org.modelio.vbasic.progress import IModelioProgress

# Implementation of progress monitor that print tasks in the console
# Currently needed to avoid a NullPointerException.
class ConsoleProgress (IModelioProgress):

	def beginTask(self, name, totalWork):
		print name
	def done(self):
		return
	def internalWorked(self, work):
		return
	def isCanceled(self):
		return False
	def setCanceled(self, cancel):
		return
	def setTaskName(self, name):
		return
	def subTask(self, name):
		print name

	def worked(self, work):
		return

# Get the Subversion service
svnSvc = Modelio.getInstance().getService(ICmsServices)

if svnSvc is None :
	print "No Subversion API found in the project"
else:
	# get all roots under version control
	for root in modelingSession.getModel().getModelRoots():
		if root.getStatus().isCmsManaged():
			print "Updating model: ", root
			command = svnSvc.createUpdateCommand()
			command.getElements().add(root)
			results = command.execute(ConsoleProgress())

			for e in results.getCreatedElements():
				print "+", e
			for e in results.getDeletedElements():
				print "-", e
			for e in results.getUpdatedElements():
				print "*", e

	generationRoots = HashSet()
	for root in modelingSession.getModel().getModelRoots():
		if isinstance(root, Project):
			for p in root.getModel():
				print "Generating Java sources on ", p
				generationRoots.add(p)
	
	javaDesigner  = Modelio.getInstance().getModuleService().getPeerModule("JavaDesigner")
	javaArchitect = Modelio.getInstance().getModuleService().getPeerModule("JavaArchitect")
	
	if javaDesigner is None and javaArchitect is None:
		print "# "
		print "## Error : No Java Designer or Java Architect module found in the project"
		print "# "
		raise
	
	t = modelingSession.createTransaction("Generate sources")
	if not javaArchitect is None :
		print "Java source generation with " + javaArchitect.getName() + " " + javaArchitect.getVersion().toString()
		savedRetrieveMode = javaArchitect.getConfiguration().getParameterValue("RetrieveDefaultBehaviour")
		javaArchitect.getConfiguration().setParameterValue("RetrieveDefaultBehaviour", "Keep")
		javaArchitect.generateCode(generationRoots, None)
		# restore "default retrieve mode" parameter value
		javaArchitect.getConfiguration().setParameterValue("RetrieveDefaultBehaviour", savedRetrieveMode)
	else:
		print "Java source generation with " + javaDesigner.getName() + " " + javaDesigner.getVersion().toString()
		savedRetrieveMode = javaDesigner.getConfiguration().getParameterValue("RetrieveDefaultBehaviour")
		javaDesigner.getConfiguration().setParameterValue("RetrieveDefaultBehaviour", "Keep")
		javaDesigner.generate(generationRoots, False)
		# restore "default retrieve mode" parameter value
		javaDesigner.getConfiguration().setParameterValue("RetrieveDefaultBehaviour", savedRetrieveMode)
	t.commit()
	
	# save the model
	coreSession.save(None)
