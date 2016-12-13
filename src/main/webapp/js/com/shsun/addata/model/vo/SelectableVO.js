var SelectableVO = Objs("com.shsun.addata.model.vo.SelectableVO", {

    id : null,
    selected : false,

    initialize: function( id, select  )
    {
        this.id = id;
        this.selected = select;
    },

    getId:function( )
    {
        return this.id;
    },

    setSelected:function( b )
    {
        this.selected = b;
    },
    getSelected:function( )
    {
        return this.selected;
    }
});