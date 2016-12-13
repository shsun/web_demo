/**
 * @classDescription
 * PureMVC <code>Proxy</code> class object used to control the user roles list
 * of the application. 
 * 
 * @requires org.puremvc.js.patterns.proxy.Proxy Proxy
 * 
 * @extends org.puremvc.js.patterns.proxy.Proxy Proxy
 * 
 * @constructor
 */
var AbstractHttpRequestlProxy = Objs("com.shsun.addata.model.AbstractHttpRequestlProxy", Proxy, {
		/**
		 * 
		 */
		signal_success : new signals.Signal(),
		/**
		 * 
		 */
		signal_failed : new signals.Signal(),
		
		/**
		 * 
		 */
		signal_timeout : new signals.Signal(),
		
		doPost : function( url, parameters) {
			var ajaxObject = this.createAjaxObject( );
			ajaxObject.open("POST", url, true);
			ajaxObject.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			ajaxObject.send(this.object2string( parameters ));
		},

		doGet : function( url, parameters ) {
			var ajaxObject = this.createAjaxObject( );
            var p = this.object2string( parameters );
            //url = url + (url.indexOf('?')>0)?"&":"?" + ((p==null)?"":p);
            url = url + ((p==null)?"":p);
            ajaxObject.open("GET", url, true);
			ajaxObject.send( null );
		},

        object2string : function( obj ) {
            var str = "";
            for(var pro in obj) {
                str += pro+"="+obj[pro];
            }
            return str.length>0 ? str : null;
        },

		/**
		 * 
		 */
		createAjaxObject : function( ) {
			var ajaxObject = null;
			try {
				// Firefox, Opera 8.0+, Safari
				ajaxObject = new XMLHttpRequest();
			} catch (e) {
				// IE
				try {
					ajaxObject = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					ajaxObject = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
			ajaxObject.onreadystatechange = Delegate.create(this, this.handleReadyStateChangeEvent);
			return ajaxObject;	
		},

        handleReadyStateChangeEvent : function( e ) {
            try{
                //console.debug("readyState:"+e.target.readyState+", status:"+ e.target.status );
            } catch (e){

            }
			if(e.target.readyState == 4 ) {
				if(e.target.status == 200) {
					// request success
					//this.signal_success.dispatch( e.target.responseText );
                    this["onHttpRequestSuccess"]( e.target.responseText );
				}
				if(e.target.status == 202) {
					// request pending
                    console.debug('HTTP 202');
				}
				if(e.target.status == 400) {
					// invalid request
					//this.signal_failed.dispatch( );
                    console.debug('HTTP 400');
                    this["onHttpRequestFailed"]( );
				}
				if(e.target.status == 404) {
					// can not find request resource
					//this.signal_failed.dispatch( );
                    console.debug('HTTP 404');
                    this["onHttpRequestFailed"]( );
				}
				if(e.target.status == 500) {
					// server error
					//this.signal_failed.dispatch( );
                    this["onHttpRequestFailed"]( );
				}
			}
        }
		// end class
	}
);