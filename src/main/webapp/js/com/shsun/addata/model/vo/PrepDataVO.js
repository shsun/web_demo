var PrepDataVO = Objs("com.shsun.addata.model.vo.PrepDataVO", {

    categoryVO : null,
    geoVO : null,

    initialize: function( catetoryVO/*:CatetoryVO*/, geoVO/*:GeoVO*/) {
        this.setCategoryVO(catetoryVO);
        this.setGeoVO(geoVO);
    },

    setCategoryVO:function( vo ) {
        this.catetoryVO = vo;
        return this;
    },

    getCategoryVO:function( ) {
        return this.catetoryVO;
    },

    setGeoVO:function( vo ) {
        this.geoVO = vo;
        return this;
    },

    getGeoVO:function(){
        return this.geoVO;
    }
});
