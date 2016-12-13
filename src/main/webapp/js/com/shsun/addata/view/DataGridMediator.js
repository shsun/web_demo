
var DataGridMediator = Objs("com.shsun.addata.view.DataGridMediator",
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
                NotificationNames.INIT_DATAGRID_VIEW
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

                    //this.getViewComponent().

                    break;
                default :
                    break;
            }
        }
    });