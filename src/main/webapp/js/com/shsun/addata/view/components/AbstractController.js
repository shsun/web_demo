var AbstractController = Objs("com.shsun.addata.view.components.AbstractController", UiComponent,
    {
        signal_province : new signals.Signal(),
        signal_city : new signals.Signal(),
        signal_channel : new signals.Signal(),
        signal_sub_channel : new signals.Signal(),

        signal_retrieve_data : new signals.Signal(),
        signal_export_excel : new signals.Signal(),

        initialize: function() {
            AbstractController.$super.initialize.call( this );
            this.initializeChildren();
            this.bindListeners();
        },

        initializeChildren: function() {
            //this.rolePanel = jQuery(".role-panel");
            //this.addRoleButton = this.rolePanel.find(".add-role-button").button();
        },

        bindListeners: function() {
            //this.addRoleButton.on( "click"+namespace, jQuery.proxy( this, "handleProvinceButtonClick") );
        },

        handleProvinceButtonClick : function() {
            this.signal_province.dispatch( {} );
        },
        handleCityButtonClick : function() {
            this.signal_city.dispatch( {} );
        },
        handleChannelButtonClick : function() {
            this.signal_channel.dispatch( {} );
        },
        handleSubChannelButtonClick : function() {
            this.signal_sub_channel.dispatch( {} );
        },
        handleRetrieveButtonClick : function() {
            this.signal_retrieve_data.dispatch( {} );
        },
        handleExportButtonClick : function() {
            this.signal_export_excel.dispatch( {} );
        }
    });