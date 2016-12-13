var RequestInventoryCommand = Objs("com.shsun.addata.controller.RequestInventoryCommand", SimpleCommand, {
    /**
     * @override
     */
    execute : function( note ) {
        var proxy = this.facade.retrieveProxy( ProxyNames.GEO_PROXY );
        proxy.signal_success.addOnce( this.handleSuccess );
        proxy.signals_failed.addOnce( this.handleFailed );
        proxy.request( );
    },

    handleSuccess : function( data ) {
        this.sendNotification(NotificationNames.INIT_DATAGRID_VIEW, data);
    },
    handleFailed : function( data ) {

    }
});