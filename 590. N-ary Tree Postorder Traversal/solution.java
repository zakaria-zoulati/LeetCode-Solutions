class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> rs = new ArrayList<>()  ;
        if( root == null ) return rs ; 
        Stack<Node> stack1 = new Stack<>() ; 
        Stack<Node> stack2 = new Stack<>() ; 
        stack1.add( root ) ; 
        while( !stack1.isEmpty() ){
            Node temp = stack1.pop() ; 
            stack2.add( temp ) ; 
            int a  = temp.children.size()  ;
            for(int i=0; i<a ; ++i){
                stack1.add( temp.children.get(i) ) ; 
            }
        }
        while( !stack2.isEmpty() ){
            rs.add( stack2.pop().val ) ; 
         }
         return rs ; 
    }
}