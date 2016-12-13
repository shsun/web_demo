
var ChannelMediator = Objs("com.shsun.addata.view.ChannelMediator",AbstractMediator,
    {
        proxy: null,

        initialize: function( name, viewComponent )
        {
            ChannelMediator.$super.initialize.call( this, ChannelMediator.NAME, viewComponent );

            this.registerListeners();
            this.proxy = this.facade.retrieveProxy( ProxyNames.CHANNEL_PROXY );
        },

        registerListeners: function()
        {
            // TODO
        },


        /**
         * @override
         */
        listNotificationInterests: function()
        {
            return [
                NotificationNames.INIT_CATEGORY_VIEW
            ];
        },

        /**
         * @override
         */
        handleNotification: function( note )
        {
            alert( note.getName() );
            switch( note.getName() )
            {
                case NotificationNames.INIT_CATEGORY_VIEW:
                    break;
                default :
                    break;
            }
        },

        render : function() {

        }
    });