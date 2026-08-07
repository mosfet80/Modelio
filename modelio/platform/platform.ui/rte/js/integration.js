/*******************************************************************************
 * Copyright (c) 2010 Tom Seidel, Remus Software All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 *
 * Contributors: Tom Seidel - initial API and implementation
 ******************************************************************************/

function EclipseIntegration() {
	this.eclipseRunning = (typeof _eclipse_running !== 'undefined');
	this.delegateInitCalled = false;
	this.pollingInterval = 250;
	this.format = new EclipseStyles();
}

EclipseIntegration.prototype.init = function(editor) {
	console.debug( "EclipseIntegration.init()" );

	this.eclipseRunning = (typeof _eclipse_running !== 'undefined');
	this.editor = editor;
	this.data = editor.getData();
	this.format.init(editor);
	var thisInstance = this;
	try {
		this.executeCommand("maximize");
	} catch (err) {
		// do nothing
	}

	editor.on('selectionChange', function(ev) {
		thisInstance.selectionChanged(ev)
	});


		editor.on('focus', function(ev) {
			thisInstance.focusGained(ev)
		});
		editor.on('blur', function(ev) {
			thisInstance.focusLost(ev)
		});

		// Use native DOM events to catch focus/blur
		document.body.addEventListener('blur', function(ev) {
		    thisInstance.focusLost(ev)
		}, true);

		document.body.addEventListener('focus', function(ev) {
			thisInstance.focusGained(ev)
		}, true);



	this.timerModifications();

	// Warn the Java side that initialization on the Browser side is done
	if (this.eclipseRunning) {
		console.debug( "EclipseIntegration.init():  Eclipse is running" );
		this.callDelegateInit();
	} else {
        console.warn( "EclipseIntegration.init():  Eclipse is NOT running" );
    }

}

/*
 * Warn the Java side that initialization on the Browser side is done
 */
EclipseIntegration.prototype.callDelegateInit = function() {

	if (this.delegateInitCalled) {
		console.debug( "  callDelegateInit() - already called" );
		return;
	}
	console.debug( "callDelegateInit() - fist time" );

	this.delegateInitCalled = true;

	setTimeout(function() {
		console.debug( "  callDelegateInit() - calling _delegate_init()" );
    	_delegate_init();
	}, 100);
}

EclipseIntegration.prototype.checkModifications = function() {
	if (this.data != this.editor.getData()) {
		if (this.eclipseRunning) {
			_delegate_modified();
		}
		this.data = this.editor.getData();
	}
}

EclipseIntegration.prototype.timerModifications = function() {
	var thisInstance = this;
	this.checkModifications();
	window.setTimeout(function() {
		thisInstance.timerModifications();
	}, this.pollingInterval);
}

EclipseIntegration.prototype.modified = function(event) {
	this.currentModifiedEvent = event;
	if (this.eclipseRunning) {
		_delegate_modified();
	}
}
EclipseIntegration.prototype.focusGained = function(event) {
	this.currentFocusEvent = event;
	console.info( "focusGained() - event: " + event );
	// Do not steal focus if a CKEditor dialog is open
	if (CKEDITOR.dialog.getCurrent()) {
		return;
	}

	editor.focus();
	// check this.currentSelection defined
	if (this.currentSelection) {
    	editor.getSelection().selectElement(this.currentSelection);
	}

	// editor.getSelection.unlock(true);
	if (this.eclipseRunning) {
		_delegate_focusGained();
	}
	this.checkModifications();
}

EclipseIntegration.prototype.focusLost = function(event) {
	// Do not process focus-lost while a CKEditor dialog is open:
	// blur events fire during native <select> interaction inside dialogs and
	// calling _delegate_focusLost() triggers async SWT actions that can
	// disrupt the dialog (combo stays open, selection lost before onOk).
	console.info( "focusLost() - event: " + event );

	if (CKEDITOR.dialog.getCurrent()) {
		return;
	}
	var thisInstance = this;
	    // Délai pour laisser le panel combo s'ouvrir
	    setTimeout(function() {
	        // Revérifier si un panel est ouvert
	        var panels = document.querySelectorAll('.cke_combopanel');
	        for (var i = 0; i < panels.length; i++) {
	            if (panels[i].style.display !== 'none') { return; }
	        }
	        // Revérifier si le focus est revenu dans l'éditeur
	        if (thisInstance.editor.focusManager.hasFocus) { return; }

	        thisInstance.currentSelection = thisInstance.editor.getSelection().getStartElement();
	        if (thisInstance.eclipseRunning) {
	            _delegate_focusLost();
	        }
	    }, 1000);
}



EclipseIntegration.prototype.selectionChanged = function(event) {
	this.currentSelectionEvent = event;
	if (this.eclipseRunning) {
		_delegate_selectionChanged();
	}
	this.checkModifications();
}

EclipseIntegration.prototype.executeCommand = function(commandName) {
	if (editor.mode == 'wysiwyg') {
		editor.execCommand(commandName);
	} else {
		alert('You must be on WYSIWYG mode!');
	}

}

EclipseIntegration.prototype.insertHtml = function(html) {
	if (editor.mode == 'wysiwyg') {
		editor.insertHtml(value);
	} else {
		alert('You must be on WYSIWYG mode!');
	}
}
