/**
 * 
 */
 
 var TreeStore = Ext.create('Ext.data.TreeStore', {
    id:'TreeStore',
    proxy: {
        type: 'ajax',
        url : '/WebWms/privilege/list_menu.action',
        reader: {
            type: 'json'
        }
    },
    root: { expanded: false },//
    autoLoad: true
});