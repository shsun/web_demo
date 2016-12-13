var PrepViewCommand = Objs("com.shsun.addata.controller.PrepViewCommand",
	SimpleCommand, {
	execute: function( note ) {
        var body/*:Body*/ = note.getBody();
	}
});