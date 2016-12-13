
var ControllerMediator = Objs("com.shsun.addata.view.ControllerMediator",
    AbstractMediator,
    {
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
                /*NotificationNames.INIT_DATAGRID_VIEW*/
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
                case NotificationNames.INIT_DATAGRID_VIEW:


                    break;
                default :
                    break;
            }
        }
    });