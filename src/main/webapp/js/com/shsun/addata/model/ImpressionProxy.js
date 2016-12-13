var ImpressionProxy = Objs("com.shsun.addata.model.ImpressionProxy", AbstractHttpRequestlProxy, {

        initialize: function( name )
        {
            ImpressionProxy.$super.initialize.call( this, name );

            return this;
        },

        request : function( path )
        {
            this.doPost(path+"/ad/queryImpression.sdo", {});
        },

        exportExcel : function( path )
        {
            this.doPost(path+"/ad/exportexcel.sdo", {});
        },
        onHttpRequestSuccess : function( responseText ) {

        },
        onHttpRequestFailed : function( ) {

        }
    }
);