package stack;

import java.util.*;

public class 二叉树的后序遍历_145 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        root.right.right=null;
        List<Integer> a = postorderTraversal(root);
    }

    /**
     * 二叉树后序遍历非递归
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        TreeNode node = root;
        TreeNode pre = null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(node != null || !st.isEmpty()){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                node = st.peek();
                if(node.right == null || node.right == pre){
                    st.pop();
                    result.add(node.val);
                    pre = node; //用来标记右节点
                    node = null; //为了让上面的if跳过
                }
                else{
                    node = node.right;
                }
            }
        }
        return result;
    }
}
