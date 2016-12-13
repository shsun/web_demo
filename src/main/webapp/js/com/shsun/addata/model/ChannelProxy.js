var ChannelProxy = Objs("com.shsun.addata.model.ChannelProxy", AbstractHttpRequestlProxy, {		
		initialize: function( name )
		{
			ChannelProxy.$super.initialize.call( this, name );
			return this;
		},

		request : function( path ) {
            this.doGet(path+"/as/queryChannel.sdo", {});
		},

        onHttpRequestSuccess : function( responseText ) {
            // you should parse the response-text and dispath the success-event with the parsedValueObject.
            // pseudo code as below:
            var tmpCategory = new CategoryVO(eval('(' + responseText + ')'));
            this.signal_success.dispatch(tmpCategory );

        },
        onHttpRequestFailed : function( ) {
            this.signal_failed.dispatch( )
        }
    }
);