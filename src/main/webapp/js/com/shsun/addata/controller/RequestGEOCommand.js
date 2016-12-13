var RequestGEOCommand = Objs("com.shsun.addata.controller.RequestGEOCommand", SimpleCommand, {
			/**
			 * @override
			 */
			execute : function( note ) {
				var proxy = this.facade.retrieveProxy( ProxyNames.GEO_PROXY );
                proxy.signal_success.addOnce( Delegate.create(this, this.handleSuccess, [note.getBody()]) );
                proxy.signal_failed.addOnce( Delegate.create(this, this.handleFailed) );
				proxy.request( note.getBody().getPath() );
			},
			
			handleSuccess : function( data, body ) {
                body.getData().setGeoVO( new GeoVO( data ) );
				this.facade.sendNotification(NotificationNames.INIT_VIEW, body );
			},
			handleFailed : function( data ) {
				
			}
		});