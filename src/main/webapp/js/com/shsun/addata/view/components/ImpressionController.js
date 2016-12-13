var ImpressionController = Objs("com.shsun.addata.view.components.ImpressionController", AbstractController,
{
	initialize: function()
	{
		ImpressionController.$super.initialize.call( this );
        this.initializeChildren();
        this.bindListeners();
	},

    initializeChildren: function()
    {
        ImpressionController.$super.initializeChildren.call( this );
        //this.rolePanel = jQuery(".role-panel");
        //this.addRoleButton = this.rolePanel.find(".add-role-button").button();
    },

    bindListeners: function()
    {
        ImpressionController.$super.bindListeners.call( this );
        //this.addRoleButton.on( "click"+namespace, jQuery.proxy( this, "handleProvinceButtonClick") );
    }
});