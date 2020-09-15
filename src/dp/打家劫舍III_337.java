package dp;

public class 打家劫舍III_337 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public static int rob(TreeNode root) {
        postorder(root);
        return root.val;
    }

    public static void postorder(TreeNode root){
        if (root.left!=null){
            postorder(root.left);
        }
        if (root.right!=null){
            postorder(root.right);
        }
        int res1=0;
        int res2=root.val;
        if (root.left!=null){
            res1=res1+root.left.val;
            if (root.left.left!=null){
                res2=res2+root.left.left.val;
            }
            if (root.left.right!=null){
                res2=res2+root.left.right.val;
            }
        }
        if (root.right!=null){
            res1=res1+root.right.val;
            if (root.right.left!=null){
                res2=res2+root.right.left.val;
            }
            if (root.right.right!=null){
                res2=res2+root.right.right.val;
            }
        }
        root.val=Math.max(res1, res2);
    }
}
