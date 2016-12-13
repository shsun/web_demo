var CategoryVO = Objs("com.shsun.addata.model.vo.CategoryVO",
    {
        categories : {},
        aChannels: {},
        bChannels: {},
        /*
        initialize: function( arrayOfChannel )
        {
            for ( var i = 0; i < arrayOfChannel.length; i++) {
                var tmpChannelJSONObject = arrayOfChannel[i];
                var tmpChannel = this.categories[tmpChannelJSONObject.CHANNEL_AGENT_ID];
                if (tmpChannel == null) {
                    tmpChannel = new ChannelVO(tmpChannelJSONObject);
                }
                this.provinces[tmpSubChannelJSONObject.PROVINCE_ID] = tmpProvince;
            }
        },*/

        initialize: function(jsonCategory) {
            this.categories = {};
            if(jsonCategory.success ) {
                for (var i = 0; i < jsonCategory.a.length; i++) {
                    var tmpChannel = new ChannelVO(jsonCategory.a[i]);
                    this.categories[tmpChannel.CHANNEL_AGENT_ID] = tmpChannel;
                    this.aChannels[tmpChannel.CHANNEL_AGENT_ID] = tmpChannel;
                }
                for (var i = 0; i < jsonCategory.b.length; i++) {
                    var tmpChannel = new ChannelVO(jsonCategory.b[i]);
                    this.categories[tmpChannel.CHANNEL_AGENT_ID] = tmpChannel;
                    this.bChannels[tmpChannel.CHANNEL_AGENT_ID] = tmpChannel;
                }
            }
        },

        getAllSubChannelsByChannelID : function(id/* :String */)/* :Array */
        {
            return this.categories[id].children;
        },

        getChannelByID: function(id) {
            return this.categories[id];
        },

        getAllaChannels: function() {
            return this.aChannels;
        },

        getAllbChannels: function() {
            return this.bChannels;
        },

        getAllChannels: function(){
            return this.categories;
        }


    });
