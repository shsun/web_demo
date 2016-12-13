/**
 * This class represents a node in a tree of nodes. Instances of this class are used as the nodes in the TreeNode.
 *
 * @usage
 *
 * @example
 * var tree = new TreeNode(1, 'root', 1);
 * var child = new TreeNode(111, 'c11', 111, tree);
 *
 * @example
 * var tree = new TreeNode(1, 'root', 1);
 * tree.addChildNode( new TreeNode(111, 'c11', 111) );
 * tree.addChildNode( new TreeNode(222, 'c12', 222) );
 *
 */
var TreeNode = Objs("com.youdo.ds.TreeNode", {

    parentNodeId : null,
    parentNode : null,
    //
    nodeId : null,
    nodeName : "",
    nodeValue : null,
    //
    children : [],

    initialize : function( nodeId/*:Number*/, nodeName/*:String*/, nodeValue/*:Object*/, parentNode/*:TreeNode*/) {
        this.emptyChildren();
        //
        this.setNodeId(nodeId);
        this.setNodeName(nodeName);
        this.setNodeValue(nodeValue);
        this.setParentNode(parentNode);
    },

    isLeaf : function() {
        return this.getChildren().isEmpty();
    },

    isRoot : function() {
        return this.getParentNode() == null;
    },

    addChildNode : function( node ) {
        this.getChildren().push(node);
        node.setParentNode(this);
    },

    getElderNodes : function() {
        var list = [];
        var parentNode = this.getParentNode();
        if (parentNode != null) {
            list.push(parentNode);
            var tmpArray = parentNode.getElderNodes();
            for(var i=0; i<tmpArray.length; i++) {
                list.push(tmpArray[i]);
            }
        }
        return list;
    },

    getJuniorNodes : function() {
        var list = [];
        var children = this.getChildren();
        if (children != null) {
            var n = children.length;
            for (var i = 0; i < n; i++) {
                var node = children[i];
                list.push(node);
                var tmpArray = node.getJuniorNodes();
                for(var i=0; i<tmpArray.length; i++) {
                    list.push(tmpArray[i]);
                }
            }
        }
        return list;
    },

    /**
     * delete self.
     */
    deleteNode : function() {
        var parentNode = this.getParentNode();
        var id = this.getNodeId();
        if (parentNode != null) {
            parentNode.deleteChildNode(id);
        }
    },

    deleteAllChildNodes : function() {
        var list = this.getChildren();
        var n = list.length;
        for (var i = 0; i < n; i++) {
            this.deleteChildNode(list[i].getNodeId());
        }
    },

    deleteChildNode : function( childId ) {
        var list = this.getChildren();
        var n = list.length;
        for (var i = 0; i < n; i++) {
            if (list[i].getNodeId() == childId) {
                list.splice(i, 1);
                break;
            }
        }
    },

    findTreeNodeById : function( id ) {
        var node = null;
        if (this.getNodeId() == id) {
            node = this;
        } else if (!this.getChildren().isEmpty()) {
            var n = this.getChildren().length;
            for (var i =  0; i < n; i++) {
                var tmpNode = this.getChildren()[i].findTreeNodeById(id);
                if (tmpNode != null) {
                    node = tmpNode;
                    break;
                }
            }
        }
        return node;
    },

    emptyChildren : function() {
        this.setChildren([]);
    },

    setChildren : function( childList ) {
        this.children = childList;
    },
    getChildren : function() {
        return this.children;
    },
    getParentNodeId : function() {
        return this.parentNodeId;
    },
    setParentNodeId : function( parentNodeId ) {
        this.parentNodeId = parentNodeId;
    },

    getNodeId : function() {
        return this.nodeId;
    },
    setNodeId : function( nodeId ) {
        this.nodeId = nodeId;
    },
    getParentNode : function() {
        return this.parentNode;
    },
    setParentNode : function( parentNode ) {
        this.parentNode = parentNode;
    },
    getNodeName : function() {
        return this.nodeName;
    },
    setNodeName : function( nodeName ) {
        this.nodeName = nodeName;
    },
    getNodeValue : function() {
        return this.nodeValue;
    },
    setNodeValue :function( nodeValue ) {
        this.nodeValue = nodeValue;
    }

});