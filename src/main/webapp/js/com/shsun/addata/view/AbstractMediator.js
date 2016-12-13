
var AbstractMediator = Objs("com.shsun.addata.view.AbstractMediator", Mediator,
    {
        dataProvider : null,

        initialize: function( name, viewComponent )
        {
            AbstractMediator.$super.initialize.call( this, AbstractMediator.NAME, viewComponent );
        },

        setDataProvider : function ( dataProvider )
        {
            this.dataProvider = dataProvider;
        },


        getDataProvider : function ( )
        {
            return this.dataProvider;
        },

        registerListeners: function()
        {
            // TODO
        },

        listNotificationInterests: function()
        {
            return [

            ];
        },

        /**
         * @override
         */
        handleNotification: function( note )
        {
            /*
             switch( note.getName() )
             {
             }
             */
        },

        render : function() {

        }
    });