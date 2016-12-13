var InitViewCommand = Objs("com.shsun.addata.controller.InitViewCommand",
    SimpleCommand, {
        execute: function( note ) {
            var prepDataVO/*:PrepDataVO*/ = note.getBody().getData();
            //
            var vo;

            vo = prepDataVO.getGeoVO();
            this.facade.sendNotification(NotificationNames.INIT_GEO_VIEW, vo );

            vo = prepDataVO.getCategoryVO();
            this.facade.sendNotification(NotificationNames.INIT_CATEGORY_VIEW, vo );
        }
    });
