var SubChannelVO = Objs("com.shsun.addata.model.vo.SubChannelVO", {
    CHANNEL_AGENT_ID : null,
    CHANNEL_CODE : null,
    CHANNEL_NAME : null,
    CHANNEL_NUMBER : null,
    SITE_ID : null,
    IS_INUSE : null,
    SUB_CHANNEL_ID : null,
    SUB_CHANNEL_NAME : null,
    parent : null,

    selected : false,

    /*
    initialize: function( parent, obj )
    {
        this.parent = parent;

        this.CHANNEL_AGENT_ID = obj.CHANNEL_AGENT_ID;
        this.CHANNEL_CODE = obj.CHANNEL_CODE;
        this.CHANNEL_NAME = obj.CHANNEL_NAME;
        this.CHANNEL_NUMBER = obj.CHANNEL_NUMBER;
        this.SITE_ID = obj.SITE_ID;
        this.IS_INUSE = obj.IS_INUSE;
        this.SUB_CHANNEL_ID = obj.SUB_CHANNEL_ID;
        this.SUB_CHANNEL_NAME = obj.SUB_CHANNEL_NAME;
    },*/

    initFromJson: function( jsonSubChannel, parent) {
        this.CHANNEL_AGENT_ID = jsonSubChannel.CHANNEL_AGENT_ID;
        this.CHANNEL_CODE = jsonSubChannel.CHANNEL_CODE;
        this.CHANNEL_NAME = jsonSubChannel.CHANNEL_NAME;
        this.CHANNEL_NUMBER = jsonSubChannel.CHANNEL_NUMBER;
        this.SITE_ID = jsonSubChannel.SITE_ID;
        this.IS_INUSE = jsonSubChannel.IS_INUSE;
        this.SUB_CHANNEL_ID = jsonSubChannel.SUB_CHANNEL_ID;
        this.SUB_CHANNEL_NAME = jsonSubChannel.SUB_CHANNEL_NAME;
        this.parent = parent;
    },

    setSelected:function( b )
    {
        this.selected = b;
    },
    getSelected:function( )
    {
        return this.selected;
    },

    getCHANNEL_AGENT_ID : function()
    {
        return this.CHANNEL_AGENT_ID;
    },

    getSUB_CHANNEL_ID : function()
    {
        return this.SUB_CHANNEL_ID;
    },

    getSUB_CHANNEL_NAME : function()
    {
        return this.SUB_CHANNEL_NAME;
    }
});