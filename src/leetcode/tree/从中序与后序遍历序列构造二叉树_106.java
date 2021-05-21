package leetcode.tree;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/17
 */
public class 从中序与后序遍历序列构造二叉树_106 {

//    例如，给出
//
//    中序遍历 inorder = [9,3,15,20,7]
//    后序遍历 postorder = [9,15,7,20,3]
//    返回如下的二叉树：
//
//            3
//            / \
//            9  20
//            /  \
//            15   7

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return makeTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode makeTree(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
        if (postL>postR) return null;
        TreeNode root = new TreeNode(postorder[postR]);
        //确定左子树的长度
        int inRoot = 0;
        for (int i=inL;i<=inR;i++) {
            if (inorder[i] == postorder[postR]) inRoot = i;
        }
        int leftLen = inRoot-inL;

        root.left = makeTree(inorder, inL, inRoot-1, postorder, postL, postL+leftLen-1);
        root.right = makeTree(inorder, inRoot+1, inR, postorder, postL+leftLen, postR-1);
        return root;
    }
}
