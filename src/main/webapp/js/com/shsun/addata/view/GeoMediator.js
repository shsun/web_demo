
var GeoMediator = Objs("com.shsun.addata.view.GeoMediator",
    AbstractMediator,
    {
        dataProvider : null,

        initialize: function( name, viewComponent )
        {
            ChannelMediator.$super.initialize.call( this, ChannelMediator.NAME, viewComponent );

            this.registerListeners();
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
                NotificationNames.INIT_GEO_VIEW
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
                 case NotificationNames.INIT_GEO_VIEW:

                    break;
                 default :
                     break;
             }
        },

        render : function() {

        }

    });