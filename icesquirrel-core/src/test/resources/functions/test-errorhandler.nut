seterrorhandler(function(exception) {
	print("BANG! " + exception);
	::errorMessage <- exception;
});
unknownSlot = "anything";