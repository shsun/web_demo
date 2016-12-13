var ApplicationFacade = Objs("com.shsun.addata.ApplicationFacade", Facade,
{
	startup: function( owner, path)
	{
        this.sendNotification( NotificationNames.STARTUP, new Body(owner, path, null) );
	},

    initializeView :function()
    {
        ApplicationFacade.$super.initializeView.call(this);

        this.registerMediator(new GeoMediator(MediatorNames.GEO_MEDIATOR,new GeoPopup()));
        this.registerMediator(new ChannelMediator(MediatorNames.CHANNEL_MEDIATOR,new ChannelPopup()));
        this.registerMediator(new ControllerMediator(MediatorNames.INVENTORY_CONTROLLER_MEDIATOR, new InventoryController()));
        this.registerMediator(new ControllerMediator(MediatorNames.IMPRESSION_CONTROLLER_MEDIATOR, new ImpressionController()));
        this.registerMediator(new GeoMediator(MediatorNames.DATAGRID_MEDIATOR,new DataGrid()));
    },

	initializeController: function()
	{
		ApplicationFacade.$super.initializeController.call( this );
		
		this.registerCommand( NotificationNames.STARTUP, StartupCommand );

        this.registerCommand(NotificationNames.PREPARE_VIEW,PrepViewCommand);

        this.registerCommand(NotificationNames.INIT_VIEW,InitViewCommand);

        this.registerCommand(NotificationNames.REQUEST_CHANNEL, RequestChannelCommand);
        this.registerCommand(NotificationNames.REQUEST_GEO, RequestGEOCommand);
        this.registerCommand(NotificationNames.REQUEST_INVENTORY,RequestInventoryCommand);
        this.registerCommand(NotificationNames.REQUEST_IMPRESSION,RequestImpressionCommand);
	},

    initializeModel : function()
    {
        ApplicationFacade.$super.initializeModel.call(this);

        this.registerProxy(new ChannelProxy(ProxyNames.CHANNEL_PROXY));
        this.registerProxy(new GeoProxy(ProxyNames.GEO_PROXY));
        this.registerProxy(new InventoryProxy(ProxyNames.INVENTORY_PROXY));
        this.registerProxy(new ImpressionProxy(ProxyNames.IMPRESSION_PROXY));
    }
});

ApplicationFacade.getInstance = function()
{
	if( !Facade.instance ) {
        Facade.instance = new ApplicationFacade();
    }
	return Facade.instance;
};