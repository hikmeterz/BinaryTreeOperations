public class TNode {
    private int value;
    private TNode parent;
    private TNode left;
    private TNode right;
    private boolean durumSoldaMi;


    public TNode(int value) {
        this.right = null;
        this.left = null;
        this.parent = null;
        this.value = value;
        this.durumSoldaMi=true;
    }

    public TNode(TNode parent, int value) {
        this.right = null;
        this.left = null;
        this.parent = parent;
        this.value = value;
    }
    public boolean getDurumSoldami(){
    	if(this.durumSoldaMi==true) {
    		
    		return true;
    		
    	}else
    		return false;
    	
    	
    }
    
    public void setDurumSoldami(boolean durum){
    	this.durumSoldaMi=durum;
    	
    }
    
    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEmpty() {
        if(this==null) return true;
        else return false;
    }

    public boolean isLeaf() {
        return this.left == null & this.right == null;
    }

    public boolean hasLeft() {
		return left != null;
	}
	public boolean hasRight() {
		return right != null;
	}	
	public boolean isRoot() {
		return parent == null;
	}
	public boolean isExternal() {//Yani leaf.
		return !(hasRight() || hasLeft());
	}
	public void preorderTraverse() {
	    
		System.out.print(this.value + " ");
		if(this.left!=null)
			this.left.preorderTraverse();
		if(this.right!=null)
			this.right.preorderTraverse();
	}
   
	public void postorderTraverse(char operator,int x) {
        
		if(operator=='^') {
			this.setValue((int)Math.pow(this.getValue(), x));
			System.out.print(this.getValue() + " ");
			if(this.left!=null)
	            this.left.postorderTraverse(operator,x);
	        if(this.right!=null)
	            this.right.postorderTraverse(operator,x);
		
		
	        this.setValue((int)Math.pow(this.getValue(), x));
			System.out.print(this.getValue() + " ");
			
		}else if(operator=='*') {
			if(this.left!=null)
	            this.left.postorderTraverse(operator,x);
	        if(this.right!=null)
	            this.right.postorderTraverse(operator,x);
		
	        this.setValue(this.getValue()* x);
			System.out.print(this.getValue() + " ");
			
		
		}else if(operator=='+') {
			if(this.left!=null)
	            this.left.postorderTraverse(operator,x);
	        if(this.right!=null)
	            this.right.postorderTraverse(operator,x);
		
		
	        this.setValue(this.getValue()+x);
			System.out.print(this.getValue() + " ");
			
		}else if(operator=='-') {
			if(this.left!=null)
	            this.left.postorderTraverse(operator,x);
	        if(this.right!=null)
	            this.right.postorderTraverse(operator,x);
		
	        this.setValue(this.getValue()-x);
			System.out.print(this.getValue() + " ");
			
		}
        
    }
    


}