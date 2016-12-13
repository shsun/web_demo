var ChannelVO = Objs("com.shsun.addata.model.vo.ChannelVO", {
    CHANNEL_AGENT_ID : null,
    CHANNEL_CODE : null,
    CHANNEL_NAME : null,
    CHANNEL_NUMBER : null,
    SITE_ID : null,
    IS_INUSE : null,
    children : {},

    /*
    initialize: function( obj )
    {
        this.CHANNEL_AGENT_ID = obj.CHANNEL_AGENT_ID;
        this.CHANNEL_CODE = obj.CHANNEL_CODE;
        this.CHANNEL_NAME = obj.CHANNEL_NAME;
        this.CHANNEL_NUMBER = obj.CHANNEL_NUMBER;
        this.SITE_ID = obj.SITE_ID;
        this.IS_INUSE = obj.IS_INUSE;
        for(var i=0;i<obj.children.length;i++) {
            var c = new SubChannelVO( this, obj.children[i] );
            this.children[''+c.getCHANNEL_AGENT_ID()] = c;
        }
    },*/

    initialize: function(jsonChannel)
    {
        this.children = {};
        this.CHANNEL_AGENT_ID = jsonChannel.CHANNEL_AGENT_ID;
        this.CHANNEL_CODE = jsonChannel.CHANNEL_CODE;
        this.CHANNEL_NAME = jsonChannel.CHANNEL_NAME;
        this.CHANNEL_NUMBER = jsonChannel.CHANNEL_NUMBER;
        this.SITE_ID = jsonChannel.SITE_ID;
        this.IS_INUSE = jsonChannel.IS_INUSE;
        for(var i = 0; i < jsonChannel.children.length; i++) {
            var tmpSubChannel =new SubChannelVO(jsonChannel.children[i], this);
            this.children[tmpSubChannel.SUB_CHANNEL_ID] = tmpSubChannel;
        }
    }

});
