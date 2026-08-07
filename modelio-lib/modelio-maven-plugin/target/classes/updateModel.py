#
#	This macro runs an SVN update on the project
#
#
# Author:	Modeliosoft
#
# Applicable on: project
#
# Version history:
# 1.1	 25th June 2013	   - Ported to Modelio 3
# 1.0	 25th April 2012	 - creation
#

from com.modeliosoft.modelio.cms.api import IUpdateCommand;
from com.modeliosoft.modelio.cms.api import IUpdateDetails;
from com.modeliosoft.modelio.cms.api import TransactionStillOpenException;
from com.modeliosoft.modelio.cms.api import ICmsServices

from java.util import ArrayList

from org.modelio.api.modelio import Modelio
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
