
var GeoProxy = Objs("com.shsun.addata.model.GeoProxy", AbstractHttpRequestlProxy, {

        initialize: function( name )
        {
            GeoProxy.$super.initialize.call( this, name );
            return this;
        },

        request : function( path ) {
            //this.doGet(path+"/as/queryGEO.sdo", {});
            this.doGet(path+"/as/queryGEO2.sdo", {});
        },

        onHttpRequestSuccess : function( responseText ) {
            var tmpGeo = new GeoVO(eval('(' + responseText + ')'));
            this.signal_success.dispatch(tmpGeo );
        },
        onHttpRequestFailed : function( ) {

        }
    }
);