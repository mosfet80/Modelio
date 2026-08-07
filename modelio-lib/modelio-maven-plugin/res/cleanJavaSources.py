#
# Clean Java sources
#	This macro cleans the Java sources
#
#
# Author:	Modeliosoft
#
# Applicable on: project
#
# Version history:
# 1.1  27th June 2013 - Update for Modelio3
# 1.0	 9th July	2012 - creation
#
#

from org.modelio.api.modelio import Modelio
from org.modelio.metamodel.mda import Project
import os
import stat

###############################################
# getJavaElements
#
# parameter:
#			root of the tree
#
# return:
#			the list of all children model elements (recursively) except ramcs
def getJavaElements(root):
	listEl = []
	for i in root.getOwnedElement():
		if i.getStatus().isRamc() == False:
			# recursivity
			for el in getJavaElements(i):
				listEl.append(el)

			# add files only for Java elements
			if i.isStereotyped("JavaDesigner", "JavaAnnotation") or\
				i.isStereotyped("JavaDesigner", "JavaClass") or\
				i.isStereotyped("JavaDesigner", "JavaDataType") or\
				i.isStereotyped("JavaDesigner", "JavaEnumeration") or\
				i.isStereotyped("JavaDesigner", "JavaInterface"):
				listEl.append(i)

	return listEl

###############################################
# deleteFile
#
# parameter:
#			full path  name (String)
#
def deleteFile(file2rm):
	if os.path.exists (file2rm) and os.path.isfile(file2rm):
		os.chmod(file2rm, stat.S_IWRITE | stat.S_IRUSR | stat.S_IXUSR)
		try:
			os.remove(file2rm)
			return 1
		except:
			'''print "	/!\\ source files have NOT been deleted: ", file2rm'''
	return 0

###############################################
# Begin
###############################################
javaMdac = None
for module in Modelio.getInstance().getModuleService().getAllPeerModules():
	if (module.getName() == "JavaDesigner"):
		javaMdac = module;
		break;

if javaMdac is None :
	print "No Java Designer module found in the project"
else:
	print "Java source cleaning with " + javaMdac.getName() + " " +	javaMdac.getVersion().toString()
	
	cpt = 0
	for root in modelingSession.getModel().getModelRoots():
		if isinstance(root, Project):
			for root in root.getModel():
				for i in getJavaElements(root):
					cpt += deleteFile(javaMdac.getFilename(i).toString())
	
	if cpt>1:
		print cpt, "files deleted"
	elif cpt==1:
		print cpt, "file deleted"
	else:
		print "no file deleted"
