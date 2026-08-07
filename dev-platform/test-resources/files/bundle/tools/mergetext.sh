#!/bin/bash -x
#######################################################################
#    Merge text tool
#
# This script is called to merge notes during a Diff/merge.
# You can specify a merge tool by setting the MERGE_EDITOR environment 
# variable.
# Default tool is meld version 1.3.2
#
# Parameters available:
#  
#  $1 : current text
#  $2 : reference text
#  
#######################################################################

if [ -z "$MERGE_EDITOR" ] ; then
	meld -L "Modelio merge note" "$1" "$2"
else
	$MERGE_EDITOR "$1" "$2"
fi


