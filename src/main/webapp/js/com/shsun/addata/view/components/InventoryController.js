var InventoryController = Objs("com.shsun.addata.view.components.InventoryController", AbstractController, {

        initialize: function()
        {
            InventoryController.$super.initialize.call( this );
            this.initializeChildren();
            this.bindListeners();
        },

        initializeChildren: function()
        {
            InventoryController.$super.initializeChildren.call( this );
            //this.rolePanel = jQuery(".role-panel");
            //this.addRoleButton = this.rolePanel.find(".add-role-button").button();
        },

        bindListeners: function()
        {
            InventoryController.$super.bindListeners.call( this );
            //this.addRoleButton.on( "click"+namespace, jQuery.proxy( this, "handleProvinceButtonClick") );
        }
    });