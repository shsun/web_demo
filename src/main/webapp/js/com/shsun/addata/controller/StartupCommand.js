var StartupCommand = Objs("com.shsun.addata.controller.StartupCommand", SimpleCommand, {
    execute: function( note ) 
    {
		this.sendNotification( NotificationNames.PREPARE_VIEW, note.getBody() );
        this.sendNotification( NotificationNames.REQUEST_CHANNEL,note.getBody() );
	}
});