public class BinaryTree {
    private TNode root;
   
    
    public BinaryTree() {
        root =null;
    }
    
    public TNode addRoot(int s) {
		
		root= new TNode(s);
		return root;
	}
    
    public void insertLeft(TNode node, int value) { 
		
		
    	TNode left = new TNode(value);
		node.setLeft(left);
		left.setParent(node);
		
	}
    
    public void insertRight(TNode node, int value) { 
		
		
		
    	TNode right = new TNode(value);
		node.setRight(right);
		right.setParent(node);
		
    }
    
    public TNode getRoot() {
        return root;
    }

    public boolean isEmpty() {//Agac bosmu....
        return root.isEmpty();
    }
    
    	
    public void preorderTraverse(){
        if(!isEmpty())
            root.preorderTraverse();
    }

    public void postorderTraverse(char operator,int x){
        if(!isEmpty())
            root.postorderTraverse(operator,x);
    }

   

}
