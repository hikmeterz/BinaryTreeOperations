import java.util.Scanner;

import javax.annotation.PostConstruct;

public class Main {
	
	
	public static void main(String[] args) {
		 
		Scanner k= new Scanner(System.in);
		String s = k.nextLine();//Ornek girdi...
		
		BinaryTree tree = new BinaryTree();//tree olusturuldu
		//Root'un her zaman giilecegi var sayildi.....
		
		String format=s.substring(0,s.indexOf(','));
		
		TNode iterator;
		if(s.indexOf('[')>0) {
			if(s.charAt(0)=='-')
				tree.addRoot((-1)*Integer.parseInt(s.substring(1,s.indexOf('['))));
			else
				tree.addRoot(Integer.parseInt(s.substring(0,s.indexOf('['))));
			iterator=tree.getRoot();
			format=format.substring(s.indexOf('['));
			int index=0;
			String deger="";
			boolean negatifMi=false;
			//System.out.println(format);
			while(index<format.length()) {
				negatifMi=false;
				if(format.charAt(index)=='[' && iterator.getDurumSoldami()==true) {
					
					if(format.charAt(index+1) != ']') {
						index++;
						
						if(format.charAt(index)=='-'){
							negatifMi=true;
							index++;
						}else if(format.charAt(index)=='+') {
							negatifMi=false;
							index++;
							
						}else
							negatifMi=false;
						
						for(int i=index;i<format.length();i++,index++) {
							if(format.charAt(i)=='[' || format.charAt(i)==']') {
								break;
							
							}
							deger+=format.charAt(i);
							
						}
						int value=0;
						if(negatifMi==true)
							value=(-1)*Integer.parseInt(deger);
						else
							value=Integer.parseInt(deger);
						
						deger="";
						tree.insertLeft(iterator, value);
						iterator=iterator.getLeft();
						
					}else{//Bos deger.......
						iterator.setDurumSoldami(false);
						index+=2;
					}
					
					
				}else if(format.charAt(index)=='[' && iterator.getDurumSoldami()==false) {
				
					if(s.charAt(index+1) != ']') {
						index++;
						if(format.charAt(index)=='-'){
							negatifMi=true;
							index++;
						}else if(format.charAt(index)=='+') {
							negatifMi=false;
							index++;
							
						}else
							negatifMi=false;
						
						
						for(int i=index;i<format.length();i++,index++) {
							if(format.charAt(i)=='[' || format.charAt(i)==']') {
								break;
							
							}
							deger+=format.charAt(i);
							
						}
						
						int value=0;
						
						//System.out.println(negatifMi);
						if(negatifMi==true)
							value=(-1)*Integer.parseInt(deger);
						else {
							
							value=Integer.parseInt(deger);
						}
						deger="";
						
						tree.insertRight(iterator, value);
						iterator=iterator.getRight();
						
					}else{//Bos deger.......
						
						if(iterator.getParent()!=null) {
							iterator=iterator.getParent();
						}else
							iterator=tree.getRoot();
							
						index+=2;
					
					}
				
			
				}else if(format.charAt(index)==']'){
					
					if(iterator.getParent()!=null) {
						iterator=iterator.getParent();
						iterator.setDurumSoldami(false);
					}else {
						iterator=tree.getRoot();
						iterator.setDurumSoldami(false);
					}	
					index++;
				}
					
				
			}//while
			
			//tree.preorderTraverse();
			//System.out.println("AAA");
			//System.exit(0);
			
			
			String islem=s.substring(s.indexOf(' ')+1);
			char operator=islem.charAt(0);
			int x=0;
			if(islem.charAt(1)=='+') {
				x=Integer.parseInt(islem.substring(2));
					
				tree.postorderTraverse(operator,x);
					
				
			}else if(islem.charAt(1)=='-') {
				x=(-1)*Integer.parseInt(islem.substring(2));
				tree.postorderTraverse(operator,x);
				
			}else{
				x=Integer.parseInt(islem.substring(1));
				tree.postorderTraverse(operator,x);
			}
		
		}else {
			
			tree.addRoot(Integer.parseInt(s.substring(0,s.indexOf(','))));
			String islem=s.substring(s.indexOf(' ')+1);
			
			char operator=islem.charAt(0);
			int x=0;
			if(islem.charAt(1)=='+') {
				x=Integer.parseInt(islem.substring(2));
				if(operator=='^') {
					
					System.out.println((int)Math.pow(tree.getRoot().getValue(),x));
					
				}else if(operator=='-') {
					
					System.out.println(tree.getRoot().getValue()-x);
					
				}else if(operator=='+') {
					
					System.out.println(tree.getRoot().getValue()+x);
					
				}else if(operator=='*') {
					
					System.out.println(tree.getRoot().getValue()*x);
					
				}
			}else if(islem.charAt(1)=='-') {
				x=(-1)*Integer.parseInt(islem.substring(2));
				if(operator=='^') {
					
					System.out.println((int)Math.pow(tree.getRoot().getValue(),x));
					
				}else if(operator=='-') {
					
					System.out.println((int)tree.getRoot().getValue()-x);
					
				}else if(operator=='+') {
					
					System.out.println((int)tree.getRoot().getValue()+x);
					
				}else if(operator=='*') {
					
					System.out.println((int)tree.getRoot().getValue()*x);
					
				}
			}else{
				x=Integer.parseInt(islem.substring(1));
				if(operator=='^') {
					
					System.out.println((int)Math.pow(tree.getRoot().getValue(),x));
					
				}else if(operator=='-') {
					
					System.out.println(tree.getRoot().getValue()-x);
					
				}else if(operator=='+') {
					
					System.out.println(tree.getRoot().getValue()+x);
					
				}else if(operator=='*') {
					
					System.out.println(tree.getRoot().getValue()*x);
					
				}
			
			}
			
		}
	}

}
