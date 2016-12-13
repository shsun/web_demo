
var InventoryProxy = Objs("com.shsun.addata.model.InventoryProxy", AbstractHttpRequestlProxy, {

        initialize: function( name )
        {
            InventoryProxy.$super.initialize.call( this, name );

            return this;
        },

        request : function( path )
        {
            this.doPost(path+"/inventory/queryInventory.sdo", {});
        },

        exportExcel : function( path )
        {
            this.doPost(path+"/inventory/exportexcel.sdo", {});
        },
        onHttpRequestSuccess : function( responseText ) {

        },
        onHttpRequestFailed : function( ) {

        }
    }
);