var RequestChannelCommand = Objs(
		"com.shsun.addata.controller.RequestChannelCommand",
		SimpleCommand,
		{
			execute : function( note ) {
				var proxy = this.facade.retrieveProxy(ProxyNames.CHANNEL_PROXY);
				proxy.signal_success.addOnce( Delegate.create(this, this.handleSuccess, [note.getBody()]) );
				proxy.signal_failed.addOnce( Delegate.create(this, this.handleFailed) );
				proxy.request(note.getBody().getPath());
			},

            /**
             * @parameter data
             *
             * @parameter body
             *
             */
			handleSuccess : function(data, body/*:Body*/) {
                var prepDataVO/*:PrepDataVO*/ = new PrepDataVO( new CategoryVO( data ), null );
				this.facade.sendNotification( NotificationNames.REQUEST_GEO, body.setData(prepDataVO) );
			},
			
			handleFailed : function(data) {

			}
		});