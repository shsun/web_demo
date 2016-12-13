function Delegate() {
}

Delegate.create = function(obj, func, args) {
	if (typeof args == "undefined") {
		args = [];
	}

	var f = function() {
		var myArgs = [];
		for ( var i = 0, len = arguments.length; i < len; i++) {
			myArgs.push(arguments[i]);
		}
		return (arguments.callee.func.apply(arguments.callee.target, myArgs.concat(arguments.callee.args) ) );
	};

	f.target = obj;
	f.func = func;
	f.args = args;

	return (f);
};


/*
Delegate.create = function( target, handler ) {
    var extraArgs = Array.prototype.slice.call(arguments, 2);
    var delegate = function() {
        var self = arguments.callee;
        var fullArgs = Array.prototype.concat.call(arguments, self.extraArgs, [self]);
        return self.handler.apply(self.target, fullArgs);
    };
    delegate.extraArgs = extraArgs;
    delegate.handler = handler;
    delegate.target = target;
    return delegate;
};
*/

Delegate.destroy = function(f) {
	if (f) {
		f.target = null;
		f.func = null;
		f.args = null;
	}
};