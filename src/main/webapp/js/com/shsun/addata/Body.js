var Body = Objs("com.shsun.addata.Body", {
	
	owner: null,
	path: null,
	data : null,
	
    initialize: function( owner, path, data)
    {
        this.owner = owner;
        this.path = path;
        this.data = data;
    },
    
    getOwner : function( ) 
    {
    	return this.owner;
    },
    
    getPath : function( ) 
    {
    	return this.path;
    },

    setData : function( data )
    {
        this.data = data;
        return this;
    },

    getData : function( ) 
    {
    	return this.data;
    }
    
});